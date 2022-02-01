package com.tencent.gamecenter.http.utils;

import android.os.Handler;
import android.os.Message;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class AsyncHttpConnection
  implements Runnable
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 200;
  public static final int e = 201;
  private static final int f = 0;
  private static final int g = 1;
  private static final int h = 2;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private String jdField_a_of_type_JavaLangString;
  private HttpClient jdField_a_of_type_OrgApacheHttpClientHttpClient;
  private String b;
  private int i;
  
  public AsyncHttpConnection(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  private void a(HttpEntity paramHttpEntity, int paramInt)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramHttpEntity.getContent()));
    Object localObject = new StringBuilder("");
    for (;;)
    {
      String str = localBufferedReader.readLine();
      if (str == null) {
        break;
      }
      ((StringBuilder)localObject).append(str);
    }
    localObject = ((StringBuilder)localObject).toString();
    long l;
    if (paramHttpEntity.getContentLength() > 0L)
    {
      l = paramHttpEntity.getContentLength();
      paramHttpEntity = new String[3];
      paramHttpEntity[0] = ("" + paramInt);
      paramHttpEntity[1] = localObject;
      paramHttpEntity[2] = ("" + l);
      if (QLog.isColorLevel()) {
        QLog.d("GameCenter", 2, "statusCode = " + paramHttpEntity[0] + ",result = " + paramHttpEntity[1] + "contentLength = " + l);
      }
      if ((paramInt == 200) || (paramInt == 201)) {
        break label245;
      }
      paramHttpEntity = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, paramHttpEntity);
      label212:
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        break label258;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramHttpEntity);
    }
    for (;;)
    {
      localBufferedReader.close();
      return;
      l = ((String)localObject).getBytes().length;
      break;
      label245:
      paramHttpEntity = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 2, paramHttpEntity);
      break label212;
      label258:
      if (QLog.isColorLevel()) {
        QLog.d("GameCenter", 2, "AsyncHttpConnection_processEntity() handler was null.");
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.i = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    AsyncHttpConnectionManager.a().a(this);
  }
  
  public void a(String paramString)
  {
    a(0, paramString, null);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(1, paramString1, paramString2);
  }
  
  public void b(String paramString1, String paramString2)
  {
    a(2, paramString1, paramString2);
  }
  
  public void run()
  {
    int k = 0;
    Object localObject;
    int j;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 0));
      this.jdField_a_of_type_OrgApacheHttpClientHttpClient = new DefaultHttpClient();
      HttpConnectionParams.setConnectionTimeout(this.jdField_a_of_type_OrgApacheHttpClientHttpClient.getParams(), 20000);
      localObject = null;
      j = k;
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("GameCenter", this.jdField_a_of_type_JavaLangString);
        j = k;
        if (QLog.isColorLevel())
        {
          j = k;
          QLog.d("GameCenter", 2, "Http url= " + Util.b(this.jdField_a_of_type_JavaLangString, new String[0]));
        }
        j = k;
        switch (this.i)
        {
        case 0: 
          j = k;
          if (this.i <= 2)
          {
            j = k;
            k = ((HttpResponse)localObject).getStatusLine().getStatusCode();
            j = k;
            a(((HttpResponse)localObject).getEntity(), k);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("GameCenter", 2, "AsyncHttpConnection_run() statusCode = " + j + "," + localException.toString());
        localException.printStackTrace();
        if (this.jdField_a_of_type_AndroidOsHandler == null) {
          continue;
        }
        Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, localException);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("GameCenter", 2, "AsyncHttpConnection_run() handler post DID_ERROR because it was null.");
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GameCenter", 2, "AsyncHttpConnection_run() Could not call handler to post DID_START message because it was null.");
      break;
      j = k;
      localObject = new HttpGet(this.jdField_a_of_type_JavaLangString);
      j = k;
      localObject = this.jdField_a_of_type_OrgApacheHttpClientHttpClient.execute((HttpUriRequest)localObject);
      continue;
      j = k;
      localObject = new HttpPost(this.jdField_a_of_type_JavaLangString);
      j = k;
      ((HttpPost)localObject).setHeader("Content-Type", "application/x-www-form-urlencoded");
      j = k;
      ((HttpPost)localObject).setEntity(new StringEntity(this.b, "utf-8"));
      j = k;
      ((HttpPost)localObject).getParams().setBooleanParameter("http.protocol.expect-continue", false);
      j = k;
      localObject = this.jdField_a_of_type_OrgApacheHttpClientHttpClient.execute((HttpUriRequest)localObject);
      continue;
      j = k;
      localObject = new HttpPost(this.jdField_a_of_type_JavaLangString);
      j = k;
      ((HttpPost)localObject).setHeader("Content-Type", "multipart/form-data");
      j = k;
      ((HttpPost)localObject).setEntity(new StringEntity(this.b, "utf-8"));
      j = k;
      ((HttpPost)localObject).getParams().setBooleanParameter("http.protocol.expect-continue", false);
      j = k;
      localObject = this.jdField_a_of_type_OrgApacheHttpClientHttpClient.execute((HttpUriRequest)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.gamecenter.http.utils.AsyncHttpConnection
 * JD-Core Version:    0.7.0.1
 */