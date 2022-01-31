package com.tencent.matrix.resource;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.g.c;
import org.json.JSONObject;

public class CanaryResultService
  extends MatrixJobIntentService
{
  public static void d(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, CanaryResultService.class);
    localIntent.setAction("com.tencent.matrix.resource.result.action.REPORT_HPROF_RESULT");
    localIntent.putExtra("RESULT_PATH", paramString1);
    localIntent.putExtra("RESULT_ACTIVITY", paramString2);
    a(paramContext, CanaryResultService.class, -84148994, localIntent);
  }
  
  protected final void l(Intent paramIntent)
  {
    Object localObject;
    String str;
    if ((paramIntent != null) && ("com.tencent.matrix.resource.result.action.REPORT_HPROF_RESULT".equals(paramIntent.getAction())))
    {
      localObject = paramIntent.getStringExtra("RESULT_PATH");
      str = paramIntent.getStringExtra("RESULT_ACTIVITY");
      if ((localObject == null) || (((String)localObject).isEmpty()) || (str == null) || (str.isEmpty())) {}
    }
    else
    {
      try
      {
        paramIntent = new JSONObject();
        paramIntent.put("resultZipPath", localObject);
        paramIntent.put("activity", str);
        localObject = com.tencent.matrix.b.yD().z(b.class);
        if (localObject != null) {
          ((com.tencent.matrix.d.b)localObject).onDetectIssue(new com.tencent.matrix.e.b(paramIntent));
        }
        return;
      }
      catch (Throwable paramIntent)
      {
        c.printErrStackTrace("Matrix.CanaryResultService", paramIntent, "unexpected exception, skip reporting.", new Object[0]);
        return;
      }
    }
    c.e("Matrix.CanaryResultService", "resultPath or activityName is null or empty, skip reporting.", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.resource.CanaryResultService
 * JD-Core Version:    0.7.0.1
 */