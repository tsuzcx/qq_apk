package com.tencent.component.network.module.report;

import android.text.TextUtils;
import com.tencent.component.network.Global;
import com.tencent.component.network.utils.a.e;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BusinessReport$ReportRunnable
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  String jdField_a_of_type_JavaLangString;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  int c;
  
  public BusinessReport$ReportRunnable(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      com.tencent.component.network.module.base.b.d("BusinessReport", "listToSend is empty.");
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("count", ((ArrayList)localObject).size());
      JSONArray localJSONArray = new JSONArray();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localJSONArray.put(((ReportObj)((Iterator)localObject).next()).a());
        continue;
        this.jdField_a_of_type_JavaLangString = ReportObj.a(this.jdField_b_of_type_Int, this.c);
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONObject = null;
      com.tencent.component.network.module.base.b.d("BusinessReport", "JSONException when uploadReport.", localJSONException);
    }
    for (;;)
    {
      if (com.tencent.component.network.module.base.b.b()) {
        com.tencent.component.network.module.base.b.b("BusinessReport", "url : " + this.jdField_a_of_type_JavaLangString);
      }
      if (localJSONObject != null) {
        this.jdField_b_of_type_JavaLangString = localJSONObject.toString();
      }
      if (com.tencent.component.network.module.base.b.b()) {
        com.tencent.component.network.module.base.b.b("BusinessReport", "json : " + this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Boolean = true;
      return;
      localJSONObject.put("data", localJSONException);
    }
  }
  
  public void run()
  {
    a();
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      if (com.tencent.component.network.module.base.b.b()) {
        com.tencent.component.network.module.base.b.b("BusinessReport", "start report thread.");
      }
      try
      {
        HttpResponse localHttpResponse = e.a(Global.a(), this.jdField_a_of_type_JavaLangString, new StringEntity(this.jdField_b_of_type_JavaLangString));
        if (localHttpResponse.getStatusLine().getStatusCode() == 200)
        {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_b_of_type_Boolean = true;
          if (com.tencent.component.network.module.base.b.b()) {
            com.tencent.component.network.module.base.b.b("BusinessReport", "report success.");
          }
        }
        while ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Int <= 3))
        {
          BusinessReport.a().a(this, 120000L);
          return;
          this.jdField_a_of_type_Int += 1;
          com.tencent.component.network.module.base.b.d("BusinessReport", "HttpStatus error when report : " + localHttpResponse.getStatusLine().getStatusCode());
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          this.jdField_a_of_type_Int += 1;
          com.tencent.component.network.module.base.b.c("BusinessReport", "exception when report", localUnsupportedEncodingException);
        }
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        for (;;)
        {
          this.jdField_a_of_type_Int += 1;
          com.tencent.component.network.module.base.b.c("BusinessReport", "exception when report", localClientProtocolException);
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          this.jdField_a_of_type_Int += 1;
          com.tencent.component.network.module.base.b.c("BusinessReport", "exception when report", localIOException);
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          this.jdField_a_of_type_Int += 1;
          com.tencent.component.network.module.base.b.c("BusinessReport", "exception when report", localIllegalArgumentException);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.jdField_a_of_type_Int += 1;
          com.tencent.component.network.module.base.b.c("BusinessReport", "exception when report", localException);
        }
      }
      catch (Error localError)
      {
        for (;;)
        {
          this.jdField_a_of_type_Int += 1;
          com.tencent.component.network.module.base.b.c("BusinessReport", "error when report", localError);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.report.BusinessReport.ReportRunnable
 * JD-Core Version:    0.7.0.1
 */