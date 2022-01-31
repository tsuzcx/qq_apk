package com.tencent.matrix.mrs.core;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.b.a.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.sqlitelint.SQLiteLintPlugin;
import java.util.ArrayList;
import org.json.JSONObject;

public class MatrixIdKeyReporter
{
  private static final int MATRIX_TRACE_ID_KEY = 1033;
  private static final String TAG = "MatrixIdKeyReporter";
  private int MATRIX_TAG_REPORT_LOG_ID = 17108;
  
  private int getKeyOffset(String paramString)
  {
    int i = -1;
    if (paramString.endsWith("SnsTimeLineUI")) {
      i = 0;
    }
    do
    {
      return i;
      if ((paramString.endsWith("ChattingUIFragment")) || (paramString.endsWith("ChattingUI"))) {
        return 20;
      }
    } while (!paramString.endsWith("MainUI"));
    return 40;
  }
  
  public void report(String paramString, JSONObject paramJSONObject)
  {
    String str1;
    Object localObject1;
    int i;
    for (;;)
    {
      Object localObject2;
      try
      {
        ab.i("MatrixIdKeyReporter", "[report] tag:%s", new Object[] { paramString });
        if (!com.tencent.matrix.b.isInstalled())
        {
          ab.i("MatrixIdKeyReporter", "matrix not installed");
          return;
        }
        str1 = "";
        localObject2 = null;
        localObject1 = localObject2;
        if (paramString != null)
        {
          localObject1 = localObject2;
          if (paramString.startsWith("Trace")) {
            localObject1 = com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class);
          }
        }
        if (localObject1 == null) {
          break label1135;
        }
        if (!(localObject1 instanceof com.tencent.matrix.trace.b)) {
          break label966;
        }
        localObject2 = paramJSONObject.getString("tag");
        if (!((String)localObject2).equalsIgnoreCase("Trace_EvilMethod")) {
          break label457;
        }
        str1 = paramJSONObject.getString("detail");
        ab.i("MatrixIdKeyReporter", "[report] _detail:%s", new Object[] { str1 });
        if (str1.equalsIgnoreCase(a.a.bRc.toString()))
        {
          localObject1 = paramJSONObject.getString("stackKey");
          localObject2 = paramJSONObject.getString("threadStack");
          String str2 = paramJSONObject.getString("scene");
          h.qsU.e(this.MATRIX_TAG_REPORT_LOG_ID, new Object[] { paramString, Integer.valueOf(d.whH), str1, localObject1, str2, localObject2 });
          e.qrI.idkeyStat(1033L, 0L, 1L, true);
          i = 1;
          localObject1 = str1;
          if ((i != 0) || (paramString.equalsIgnoreCase("io")) || (paramString.equalsIgnoreCase("sqlitelint")) || (paramString.equalsIgnoreCase("battery"))) {
            break label1145;
          }
          h.qsU.e(this.MATRIX_TAG_REPORT_LOG_ID, new Object[] { paramString, Integer.valueOf(d.whH), localObject1 });
          return;
        }
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MatrixIdKeyReporter", paramString, "data:%s", new Object[] { paramJSONObject.toString() });
        return;
      }
      if (str1.equalsIgnoreCase(a.a.bRb.toString()))
      {
        localObject1 = paramJSONObject.getString("stackKey");
        localObject2 = paramJSONObject.getString("scene");
        e.qrI.idkeyStat(1033L, 21L, 1L, true);
        h.qsU.e(this.MATRIX_TAG_REPORT_LOG_ID, new Object[] { paramString, Integer.valueOf(d.whH), str1, localObject1, localObject2, "null" });
        i = 1;
        localObject1 = str1;
      }
      else
      {
        localObject1 = str1;
        if (!str1.equalsIgnoreCase(a.a.bRd.toString())) {
          break label1146;
        }
        e.qrI.idkeyStat(1033L, 11L, 1L, true);
        i = 0;
        localObject1 = str1;
        continue;
        label457:
        localObject1 = str1;
        if (!((String)localObject2).equalsIgnoreCase("Trace_FPS")) {
          break label1146;
        }
        localObject1 = paramJSONObject.getString("scene");
        i = getKeyOffset((String)localObject1);
        if (i < 0) {
          break label1145;
        }
        double d = paramJSONObject.getDouble("fps");
        localObject2 = paramJSONObject.getJSONObject("dropLevel");
        int j = ((JSONObject)localObject2).getInt("DROPPED_BEST");
        int k = ((JSONObject)localObject2).getInt("DROPPED_NORMAL");
        int m = ((JSONObject)localObject2).getInt("DROPPED_MIDDLE");
        int n = ((JSONObject)localObject2).getInt("DROPPED_HIGH");
        int i1 = ((JSONObject)localObject2).getInt("DROPPED_FROZEN");
        ab.i("MatrixIdKeyReporter", "[getKeyOffset] scene:%s fps:%s offset:%s", new Object[] { localObject1, Double.valueOf(d), Integer.valueOf(i) });
        localObject1 = new ArrayList();
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(1033);
        ((IDKey)localObject2).SetKey(i + 47);
        ((IDKey)localObject2).SetValue(1L);
        ((ArrayList)localObject1).add(localObject2);
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(1033);
        ((IDKey)localObject2).SetKey(i + 48);
        ((IDKey)localObject2).SetValue(d);
        if (((IDKey)localObject2).GetValue() > 0L) {
          ((ArrayList)localObject1).add(localObject2);
        }
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(1033);
        ((IDKey)localObject2).SetKey(i + 49);
        ((IDKey)localObject2).SetValue(j);
        if (((IDKey)localObject2).GetValue() > 0L) {
          ((ArrayList)localObject1).add(localObject2);
        }
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(1033);
        ((IDKey)localObject2).SetKey(i + 50);
        ((IDKey)localObject2).SetValue(k);
        if (((IDKey)localObject2).GetValue() > 0L) {
          ((ArrayList)localObject1).add(localObject2);
        }
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(1033);
        ((IDKey)localObject2).SetKey(i + 51);
        ((IDKey)localObject2).SetValue(m);
        if (((IDKey)localObject2).GetValue() > 0L) {
          ((ArrayList)localObject1).add(localObject2);
        }
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(1033);
        ((IDKey)localObject2).SetKey(i + 52);
        ((IDKey)localObject2).SetValue(n);
        if (((IDKey)localObject2).GetValue() > 0L) {
          ((ArrayList)localObject1).add(localObject2);
        }
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(1033);
        ((IDKey)localObject2).SetKey(i + 53);
        ((IDKey)localObject2).SetValue(i1);
        if (((IDKey)localObject2).GetValue() > 0L) {
          ((ArrayList)localObject1).add(localObject2);
        }
        e.qrI.b((ArrayList)localObject1, false);
        localObject1 = str1;
        break label1146;
        label966:
        if (!(localObject1 instanceof com.tencent.matrix.iocanary.a)) {
          break;
        }
        e.qrI.idkeyStat(1033L, 30L, 1L, false);
        i = 0;
        localObject1 = str1;
      }
    }
    if ((localObject1 instanceof SQLiteLintPlugin))
    {
      e.qrI.idkeyStat(1033L, 31L, 1L, false);
      if (!"true".equalsIgnoreCase(paramJSONObject.getString("isInMainThread"))) {
        break label1152;
      }
      i = bo.apV(paramJSONObject.getString("sqlTimeCost"));
      if (i < 80) {
        break label1152;
      }
      if (i >= 500) {
        break label1162;
      }
      i = 110;
    }
    for (;;)
    {
      e.qrI.idkeyStat(1033L, i, 1L, false);
      break label1152;
      if ((localObject1 instanceof com.tencent.matrix.a.a))
      {
        e.qrI.idkeyStat(1033L, 32L, 1L, false);
        i = 0;
        localObject1 = str1;
        break;
      }
      if ((localObject1 instanceof com.tencent.matrix.resource.b)) {
        e.qrI.idkeyStat(1033L, 33L, 1L, false);
      }
      label1135:
      i = 0;
      localObject1 = str1;
      break;
      label1145:
      return;
      label1146:
      i = 0;
      break;
      label1152:
      i = 0;
      localObject1 = str1;
      break;
      label1162:
      if (i < 1000) {
        i = 111;
      } else if (i < 3000) {
        i = 112;
      } else if (i < 5000) {
        i = 113;
      } else {
        i = 114;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.mrs.core.MatrixIdKeyReporter
 * JD-Core Version:    0.7.0.1
 */