package com.tencent.mobileqq.activity.widget.qqmusic.network.response;

import com.tencent.mobileqq.activity.widget.qqmusic.network.request.BaseCgiRequest;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MusicUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

public class ResponseBodyProcessor
{
  static String a = "liwei";
  
  public static ResponseProcessResult a(HttpResponse paramHttpResponse, BaseCgiRequest paramBaseCgiRequest)
  {
    if (paramBaseCgiRequest == null)
    {
      MLog.d(a, "request ==null");
      paramHttpResponse = new ResponseProcessResult();
      paramHttpResponse.d = -1;
      return paramHttpResponse;
    }
    return a(paramHttpResponse, paramBaseCgiRequest.a());
  }
  
  public static ResponseProcessResult a(HttpResponse paramHttpResponse, boolean paramBoolean)
  {
    int i = 0;
    if ((paramHttpResponse == null) || (paramHttpResponse.getEntity() == null))
    {
      MLog.d(a, "rsp == null || rsp.getEntity() == null");
      paramHttpResponse = new ResponseProcessResult();
      paramHttpResponse.d = -1;
      return paramHttpResponse;
    }
    MLog.b(a, "rsp.getStatusLine():" + paramHttpResponse.getStatusLine());
    HttpEntity localHttpEntity = paramHttpResponse.getEntity();
    long l = localHttpEntity.getContentLength();
    MLog.b(a, "entity.getContentLength():" + l);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramHttpResponse = null;
    for (;;)
    {
      try
      {
        localObject = new byte[65536];
        paramHttpResponse = (HttpResponse)localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Object localObject;
        continue;
      }
      try
      {
        localObject = localHttpEntity.getContent();
        if (localObject == null)
        {
          MLog.d(a, "is == null");
          paramHttpResponse = new ResponseProcessResult();
          paramHttpResponse.d = -1;
          return paramHttpResponse;
        }
      }
      catch (IOException paramHttpResponse)
      {
        paramHttpResponse = new ResponseProcessResult();
        paramHttpResponse.d = -1;
        return paramHttpResponse;
      }
    }
    do
    {
      int j;
      do
      {
        int k = ((InputStream)localObject).read(paramHttpResponse);
        if (k <= 0) {
          break;
        }
        j = i + k;
        localByteArrayOutputStream.write(paramHttpResponse, 0, k);
        i = j;
      } while (j < l);
      i = j;
    } while (l == -1L);
    MLog.b(a, "readLength >= length && length != -1");
    localByteArrayOutputStream.flush();
    paramHttpResponse = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    ((InputStream)localObject).close();
    return a(paramHttpResponse, paramBoolean);
  }
  
  public static ResponseProcessResult a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    ResponseProcessResult localResponseProcessResult = new ResponseProcessResult();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 5))
    {
      localResponseProcessResult.a = paramArrayOfByte;
      localResponseProcessResult.d = 0;
      return localResponseProcessResult;
    }
    Object localObject;
    if (paramArrayOfByte[0] == 64)
    {
      StringBuilder localStringBuilder;
      try
      {
        paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte, 5, paramArrayOfByte.length - 5);
        localObject = new GZIPInputStream(paramArrayOfByte, 320);
        localStringBuilder = new StringBuilder();
        byte[] arrayOfByte = new byte[320];
        for (;;)
        {
          i = ((GZIPInputStream)localObject).read(arrayOfByte);
          if (i == -1) {
            break;
          }
          localStringBuilder.append(new String(arrayOfByte, 0, i));
        }
        ((GZIPInputStream)localObject).close();
      }
      catch (IOException paramArrayOfByte)
      {
        MLog.d(a, paramArrayOfByte.getMessage());
        localResponseProcessResult.d = -1;
        return localResponseProcessResult;
      }
      paramArrayOfByte.close();
      localResponseProcessResult.a = localStringBuilder.toString().getBytes();
      localResponseProcessResult.d = 0;
      return localResponseProcessResult;
    }
    int k = 1;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < 5)
      {
        if (paramArrayOfByte[i] != 0) {
          j = 0;
        }
      }
      else
      {
        if (j == 0) {
          break label245;
        }
        localObject = paramArrayOfByte;
        if (paramBoolean) {
          localObject = MusicUtil.b(paramArrayOfByte);
        }
        if (localObject != null) {
          break;
        }
        localResponseProcessResult.d = -2;
        return localResponseProcessResult;
      }
      i += 1;
    }
    localResponseProcessResult.d = 0;
    localResponseProcessResult.a = ((byte[])localObject);
    return localResponseProcessResult;
    label245:
    MLog.b(a, "没有压缩");
    localResponseProcessResult.d = 0;
    localResponseProcessResult.a = paramArrayOfByte;
    return localResponseProcessResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.response.ResponseBodyProcessor
 * JD-Core Version:    0.7.0.1
 */