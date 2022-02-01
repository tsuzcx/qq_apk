package com.tencent.matrix.report;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.d;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

public class MatrixReportBroadcast
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      com.tencent.matrix.g.c.e("Matrix.ReportBroadcast", "MatrixReportBroadcast intent == null", new Object[0]);
    }
    for (;;)
    {
      return;
      Object localObject = x.getStringExtra(paramIntent, "tag");
      String str1 = x.getStringExtra(paramIntent, "key");
      int i = x.getIntExtra(paramIntent, "type", 0);
      String str2 = x.getStringExtra(paramIntent, "value");
      paramContext = x.getStringExtra(paramIntent, "filePath");
      paramIntent = new c();
      paramIntent.tag = ((String)localObject);
      paramIntent.key = str1;
      paramIntent.type = i;
      try
      {
        paramIntent.cue = new JSONObject(str2);
        label93:
        localObject = d.cql.cqm;
        if (localObject == null) {
          continue;
        }
        ((h)localObject).a(paramIntent, paramContext);
        return;
      }
      catch (JSONException localJSONException)
      {
        break label93;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.MatrixReportBroadcast
 * JD-Core Version:    0.7.0.1
 */