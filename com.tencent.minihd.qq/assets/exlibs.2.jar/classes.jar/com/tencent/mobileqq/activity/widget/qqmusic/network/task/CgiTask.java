package com.tencent.mobileqq.activity.widget.qqmusic.network.task;

import com.tencent.mobileqq.activity.widget.qqmusic.network.http.ClientHttpExecutor;
import com.tencent.mobileqq.activity.widget.qqmusic.network.listener.OnResultListener;
import com.tencent.mobileqq.activity.widget.qqmusic.network.request.BaseCgiRequest;
import com.tencent.mobileqq.activity.widget.qqmusic.network.request.CommonRequest;
import com.tencent.mobileqq.activity.widget.qqmusic.network.response.CommonResponse;
import com.tencent.mobileqq.activity.widget.qqmusic.network.response.ResponseBodyProcessor;
import com.tencent.mobileqq.activity.widget.qqmusic.network.response.ResponseProcessResult;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.ApnManager;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

public class CgiTask
  extends CommonTask
{
  private static final String a = "liwei";
  
  public CgiTask(OnResultListener paramOnResultListener)
  {
    super(paramOnResultListener);
  }
  
  protected CommonResponse a(CommonRequest... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    do
    {
      return null;
      paramVarArgs = paramVarArgs[0];
    } while ((paramVarArgs == null) || (!(paramVarArgs instanceof BaseCgiRequest)));
    BaseCgiRequest localBaseCgiRequest = (BaseCgiRequest)paramVarArgs;
    if (!ApnManager.a())
    {
      MLog.d("liwei", "Network is not Available");
      paramVarArgs = new CommonResponse();
      paramVarArgs.a(1);
      paramVarArgs.b(1100008);
      return paramVarArgs;
    }
    paramVarArgs = ClientHttpExecutor.a().a(localBaseCgiRequest);
    MLog.d("liwei", "httpResponse is: " + paramVarArgs);
    if ((paramVarArgs == null) || (paramVarArgs.getStatusLine() == null))
    {
      paramVarArgs = new CommonResponse();
      paramVarArgs.a(1);
      paramVarArgs.b(0);
      return paramVarArgs;
    }
    int i = paramVarArgs.getStatusLine().getStatusCode();
    MLog.d("liwei", "statusCode is: " + i);
    Object localObject;
    if ((i >= 200) && (i < 300))
    {
      localObject = ResponseBodyProcessor.a(paramVarArgs, localBaseCgiRequest);
      MLog.d("liwei", "result is: " + localObject);
      if (localObject == null)
      {
        paramVarArgs = new CommonResponse();
        paramVarArgs.a(1);
        paramVarArgs.b(1100010);
        return paramVarArgs;
      }
    }
    else
    {
      paramVarArgs = new CommonResponse();
      paramVarArgs.a(1);
      if ((i >= 400) && (i < 500))
      {
        paramVarArgs.b(1100000);
        return paramVarArgs;
      }
      if (i >= 500)
      {
        paramVarArgs.b(1100003);
        return paramVarArgs;
      }
      paramVarArgs.b(1100001);
      return paramVarArgs;
    }
    if (((ResponseProcessResult)localObject).d == 0)
    {
      paramVarArgs = ((ResponseProcessResult)localObject).a;
      MLog.d("liwei", "content is: " + new String(paramVarArgs));
      if ((paramVarArgs == null) || (paramVarArgs.length == 0))
      {
        paramVarArgs = new CommonResponse();
        paramVarArgs.a(1);
        paramVarArgs.b(1100014);
        return paramVarArgs;
      }
      localObject = localBaseCgiRequest.a((ResponseProcessResult)localObject);
      MLog.a("liwei", "reponse is:" + localObject);
      paramVarArgs = (CommonRequest[])localObject;
      if (localObject == null)
      {
        paramVarArgs = new CommonResponse();
        paramVarArgs.a(0);
      }
    }
    for (;;)
    {
      MLog.a("liwei", "Cgi response : " + paramVarArgs.a() + "  " + paramVarArgs.b() + "  " + localBaseCgiRequest.a());
      return paramVarArgs;
      paramVarArgs = new CommonResponse();
      paramVarArgs.a(1);
      paramVarArgs.b(ResponseProcessResult.a(((ResponseProcessResult)localObject).d));
    }
  }
  
  protected void a(CommonResponse paramCommonResponse)
  {
    super.a(paramCommonResponse);
    if (this.a != null)
    {
      if (paramCommonResponse == null) {
        this.a.a(1000006, "CommonResponse is null");
      }
    }
    else {
      return;
    }
    if (paramCommonResponse.a() == 0) {
      try
      {
        this.a.a(paramCommonResponse);
        return;
      }
      catch (Exception paramCommonResponse)
      {
        return;
      }
    }
    try
    {
      this.a.a(paramCommonResponse.b(), "error");
      return;
    }
    catch (Exception paramCommonResponse) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.task.CgiTask
 * JD-Core Version:    0.7.0.1
 */