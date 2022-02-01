package com.tencent.matrix.resource;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.d.b;
import com.tencent.matrix.report.g;
import org.json.JSONObject;

public class CanaryResultService
  extends MatrixJobIntentService
{
  public static void e(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, CanaryResultService.class);
    localIntent.setAction("com.tencent.matrix.resource.result.action.REPORT_HPROF_RESULT");
    localIntent.putExtra("RESULT_PATH", paramString1);
    localIntent.putExtra("RESULT_ACTIVITY", paramString2);
    a(paramContext, CanaryResultService.class, -84148994, localIntent);
  }
  
  protected final void o(Intent paramIntent)
  {
    Object localObject;
    String str;
    JSONObject localJSONObject;
    if ((paramIntent != null) && ("com.tencent.matrix.resource.result.action.REPORT_HPROF_RESULT".equals(paramIntent.getAction())))
    {
      localObject = paramIntent.getStringExtra("RESULT_PATH");
      str = paramIntent.getStringExtra("RESULT_ACTIVITY");
      if ((localObject != null) && (!((String)localObject).isEmpty()) && (str != null) && (!str.isEmpty()))
      {
        paramIntent = new g(0);
        localJSONObject = new JSONObject();
      }
    }
    else
    {
      try
      {
        localJSONObject.put("resultZipPath", localObject);
        localJSONObject.put("activity", str);
        paramIntent.eYz = localJSONObject;
        localObject = com.tencent.matrix.c.avW().ai(c.class);
        if (localObject != null) {
          ((b)localObject).onDetectIssue(paramIntent);
        }
        return;
      }
      finally
      {
        for (;;)
        {
          com.tencent.matrix.e.c.printErrStackTrace("Matrix.CanaryResultService", localThrowable, "unexpected exception, skip reporting.", new Object[0]);
        }
      }
    }
    com.tencent.matrix.e.c.e("Matrix.CanaryResultService", "resultPath or activityName is null or empty, skip reporting.", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.resource.CanaryResultService
 * JD-Core Version:    0.7.0.1
 */