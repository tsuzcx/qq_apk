package com.tencent.matrix.report;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.d;
import com.tencent.mm.sdk.platformtools.IntentUtil;
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
      Object localObject = IntentUtil.getStringExtra(paramIntent, "tag");
      String str1 = IntentUtil.getStringExtra(paramIntent, "key");
      int i = IntentUtil.getIntExtra(paramIntent, "type", 0);
      String str2 = IntentUtil.getStringExtra(paramIntent, "value");
      paramContext = IntentUtil.getStringExtra(paramIntent, "filePath");
      paramIntent = new c();
      paramIntent.tag = ((String)localObject);
      paramIntent.key = str1;
      paramIntent.type = i;
      try
      {
        paramIntent.cWe = new JSONObject(str2);
        label93:
        localObject = d.cPI.cPJ;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.report.MatrixReportBroadcast
 * JD-Core Version:    0.7.0.1
 */