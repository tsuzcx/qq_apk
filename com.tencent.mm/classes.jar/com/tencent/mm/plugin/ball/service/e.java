package com.tencent.mm.plugin.ball.service;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  implements com.tencent.mm.plugin.ball.c.d
{
  private static List<BallInfo> oXv;
  public static int oXw;
  public static int oXx;
  public static boolean oXy;
  private static e oXz;
  
  static
  {
    AppMethodBeat.i(106235);
    oXv = new Vector();
    oXw = 0;
    oXx = com.tencent.mm.plugin.ball.f.e.oYW;
    oXy = false;
    AppMethodBeat.o(106235);
  }
  
  private e()
  {
    AppMethodBeat.i(106222);
    vC();
    if (g.af(com.tencent.mm.plugin.handoff.a.a.class) != null) {
      ((com.tencent.mm.plugin.handoff.a.a)g.af(com.tencent.mm.plugin.handoff.a.a.class)).ff(oXv);
    }
    AppMethodBeat.o(106222);
  }
  
  private static String UE(String paramString)
  {
    AppMethodBeat.i(106226);
    g.aAf();
    if (!com.tencent.mm.kernel.a.azo())
    {
      AppMethodBeat.o(106226);
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    g.aAf();
    paramString = com.tencent.mm.kernel.a.ayV() + "#" + paramString;
    AppMethodBeat.o(106226);
    return paramString;
  }
  
  /* Error */
  private void a(BallInfo paramBallInfo, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 96
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnull +85 -> 93
    //   11: aload_2
    //   12: ifnull +47 -> 59
    //   15: ldc 98
    //   17: ldc 100
    //   19: iconst_1
    //   20: anewarray 4	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: aload_1
    //   26: invokevirtual 105	com/tencent/mm/plugin/ball/model/BallInfo:cif	()Ljava/lang/String;
    //   29: aastore
    //   30: invokestatic 110	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   33: invokestatic 113	com/tencent/mm/plugin/ball/service/e:cik	()Ljava/lang/String;
    //   36: invokestatic 119	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   39: aload_1
    //   40: invokevirtual 105	com/tencent/mm/plugin/ball/model/BallInfo:cif	()Ljava/lang/String;
    //   43: aload_2
    //   44: invokevirtual 122	org/json/JSONObject:toString	()Ljava/lang/String;
    //   47: invokevirtual 126	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:encode	(Ljava/lang/String;Ljava/lang/String;)Z
    //   50: pop
    //   51: ldc 96
    //   53: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: ldc 98
    //   61: ldc 128
    //   63: iconst_1
    //   64: anewarray 4	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: aload_1
    //   70: invokevirtual 105	com/tencent/mm/plugin/ball/model/BallInfo:cif	()Ljava/lang/String;
    //   73: aastore
    //   74: invokestatic 110	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: invokestatic 113	com/tencent/mm/plugin/ball/service/e:cik	()Ljava/lang/String;
    //   80: invokestatic 119	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   83: aload_1
    //   84: invokevirtual 105	com/tencent/mm/plugin/ball/model/BallInfo:cif	()Ljava/lang/String;
    //   87: ldc 130
    //   89: invokevirtual 126	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:encode	(Ljava/lang/String;Ljava/lang/String;)Z
    //   92: pop
    //   93: ldc 96
    //   95: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: goto -42 -> 56
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	e
    //   0	106	1	paramBallInfo	BallInfo
    //   0	106	2	paramJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   2	7	101	finally
    //   15	56	101	finally
    //   59	93	101	finally
    //   93	98	101	finally
  }
  
  public static int agV(String paramString)
  {
    AppMethodBeat.i(176965);
    int i = MultiProcessMMKV.getMMKV(cik()).decodeInt(paramString, 0);
    AppMethodBeat.o(176965);
    return i;
  }
  
  public static e ciJ()
  {
    AppMethodBeat.i(106223);
    if (oXz == null) {}
    try
    {
      if (oXz == null) {
        oXz = new e();
      }
      e locale = oXz;
      AppMethodBeat.o(106223);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(106223);
    }
  }
  
  public static int ciK()
  {
    return oXw;
  }
  
  public static int ciL()
  {
    return oXx;
  }
  
  public static boolean ciM()
  {
    return oXy;
  }
  
  public static List<BallInfo> ciN()
  {
    return oXv;
  }
  
  private void ciO()
  {
    try
    {
      AppMethodBeat.i(106232);
      Object localObject1 = new JSONArray();
      for (;;)
      {
        try
        {
          int i;
          if (com.tencent.mm.plugin.ball.f.d.h(oXv))
          {
            int j = 0;
            i = 0;
            if (j < oXv.size())
            {
              BallInfo localBallInfo = (BallInfo)oXv.get(j);
              JSONObject localJSONObject = BallInfo.x(localBallInfo);
              if (localJSONObject == null) {
                break label187;
              }
              ((JSONArray)localObject1).put(i, localJSONObject);
              a(localBallInfo, localJSONObject);
              i += 1;
              j += 1;
              continue;
            }
          }
          MultiProcessMMKV localMultiProcessMMKV;
          localObject2 = finally;
        }
        catch (JSONException localJSONException)
        {
          Log.printErrStackTrace("MicroMsg.FloatBallStorage", localJSONException, "saveBallInfoList fail, exception:%s", new Object[] { localJSONException });
          localObject1 = ((JSONArray)localObject1).toString();
          MultiProcessMMKV.getMMKV(cik()).encode("balls", (String)localObject1);
          localObject1 = com.tencent.mm.plugin.ball.f.d.cg(oXv);
          localMultiProcessMMKV = MultiProcessMMKV.getMMKV(cik());
          if (com.tencent.mm.plugin.ball.f.d.h((Collection)localObject1))
          {
            i = ((List)localObject1).size();
            localMultiProcessMMKV.encode("ActiveCount", i);
            AppMethodBeat.o(106232);
            return;
          }
          i = 0;
        }
      }
    }
    finally {}
  }
  
  private static void ciP()
  {
    AppMethodBeat.i(106234);
    String[] arrayOfString = MultiProcessMMKV.getMMKV(cik()).allKeys();
    int i;
    int j;
    label24:
    String str;
    if (arrayOfString != null)
    {
      i = arrayOfString.length;
      j = 0;
      if (j >= i) {
        break label176;
      }
      str = arrayOfString[j];
      if ((!Util.isEqual(str, "pos_x")) && (!Util.isEqual(str, "pos_y")) && (!Util.isEqual(str, "balls")) && (!Util.isEqual(str, "ActiveCount")) && (!Util.isEqual(str, "req_perm_cnt")))
      {
        Iterator localIterator = oXv.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!Util.isEqual(str, ((BallInfo)localIterator.next()).cif()));
      }
    }
    for (int k = 1;; k = 0)
    {
      if (k == 0)
      {
        Log.i("MicroMsg.FloatBallStorage", "fixExistedKeyValues, key:%s", new Object[] { str });
        MultiProcessMMKV.getMMKV(cik()).remove(str).commit();
      }
      j += 1;
      break label24;
      i = 0;
      break;
      label176:
      AppMethodBeat.o(106234);
      return;
    }
  }
  
  public static String cik()
  {
    AppMethodBeat.i(106227);
    g.aAf();
    if (!com.tencent.mm.kernel.a.azo())
    {
      AppMethodBeat.o(106227);
      return "float_ball_storage";
    }
    String str = UE("float_ball_storage");
    AppMethodBeat.o(106227);
    return str;
  }
  
  public static void cz(String paramString, int paramInt)
  {
    AppMethodBeat.i(176966);
    MultiProcessMMKV.getMMKV(cik()).encode(paramString, paramInt);
    AppMethodBeat.o(176966);
  }
  
  private void vC()
  {
    boolean bool = true;
    int k = 0;
    Object localObject1;
    label32:
    label216:
    label239:
    try
    {
      AppMethodBeat.i(106233);
    }
    finally {}
    try
    {
      localObject1 = MultiProcessMMKV.getMMKV(cik()).allKeys();
      if (localObject1 == null) {
        break label510;
      }
      i = localObject1.length;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label287:
      oXw = 0;
      label410:
      oXx = com.tencent.mm.plugin.ball.f.e.oYW;
      oXy = false;
      oXv = new Vector();
      Log.printErrStackTrace("MicroMsg.FloatBallStorage", localUnsatisfiedLinkError, "load fail, error:%s", new Object[] { localUnsatisfiedLinkError });
      AppMethodBeat.o(106233);
      break label216;
      i = 0;
      break label32;
      i += 1;
      break label287;
    }
    Log.i("MicroMsg.FloatBallStorage", "printExistedKeyValues, size:%s", new Object[] { Integer.valueOf(i) });
    int j = 0;
    for (;;)
    {
      if (j < i)
      {
        Log.i("MicroMsg.FloatBallStorage", "printExistedKeyValues, key:%s", new Object[] { localObject1[j] });
        j += 1;
      }
      else
      {
        oXw = MultiProcessMMKV.getMMKV(cik()).decodeInt("pos_x", 0);
        oXx = MultiProcessMMKV.getMMKV(cik()).decodeInt("pos_y", com.tencent.mm.plugin.ball.f.e.oYW);
        if (MultiProcessMMKV.getMMKV(cik()).contains("dock_left"))
        {
          bool = MultiProcessMMKV.getMMKV(cik()).decodeBool("dock_left", false);
          oXy = bool;
          localObject1 = MultiProcessMMKV.getMMKV(cik()).decodeString("balls");
          if (!Util.isNullOrNil((String)localObject1)) {
            break label239;
          }
          oXv = new Vector();
          Log.i("MicroMsg.FloatBallStorage", "load, ballPosition:[%s, %s], ballInfoList is empty", new Object[] { Integer.valueOf(oXw), Integer.valueOf(oXx) });
          AppMethodBeat.o(106233);
        }
      }
    }
    for (;;)
    {
      return;
      if (oXw < com.tencent.mm.cb.a.jn(MMApplicationContext.getContext()) / 2) {
        break;
      }
      bool = false;
      break;
      Log.i("MicroMsg.FloatBallStorage", "load, savedBalls:%s", new Object[] { localObject1 });
      try
      {
        oXv = new Vector();
        localObject1 = new JSONArray((String)localObject1);
        if (((JSONArray)localObject1).length() <= 0) {
          break label410;
        }
        i = k;
        if (i >= ((JSONArray)localObject1).length()) {
          break label410;
        }
        Object localObject3 = ((JSONArray)localObject1).optJSONObject(i);
        if (localObject3 == null) {
          break label515;
        }
        localObject3 = BallInfo.av((JSONObject)localObject3);
        if (localObject3 == null) {
          break label515;
        }
        if ((((BallInfo)localObject3).oWr) && (((BallInfo)localObject3).type != 16))
        {
          l((BallInfo)localObject3);
        }
        else
        {
          ((BallInfo)localObject3).nno = false;
          ((BallInfo)localObject3).state = 0;
          oXv.add(localObject3);
        }
      }
      catch (JSONException localJSONException)
      {
        Log.printErrStackTrace("MicroMsg.FloatBallStorage", localJSONException, "load fail, exception:%s", new Object[] { localJSONException });
        AppMethodBeat.o(106233);
      }
      continue;
      ciP();
      Log.i("MicroMsg.FloatBallStorage", "load, ballPosition:[%s, %s], ballInfoList:%s", new Object[] { Integer.valueOf(oXw), Integer.valueOf(oXx), oXv });
      AppMethodBeat.o(106233);
    }
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106228);
    oXv = paramList;
    ciO();
    AppMethodBeat.o(106228);
  }
  
  public final void clear()
  {
    try
    {
      AppMethodBeat.i(106229);
      MultiProcessMMKV.getMMKV(cik()).clear();
      AppMethodBeat.o(106229);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void l(BallInfo paramBallInfo)
  {
    try
    {
      AppMethodBeat.i(106231);
      if (paramBallInfo != null)
      {
        Log.i("MicroMsg.FloatBallStorage", ">>>>>> removeBallInfo, dataKey:%s <<<<<<", new Object[] { paramBallInfo.cif() });
        MultiProcessMMKV.getMMKV(cik()).remove(paramBallInfo.cif()).commit();
      }
      AppMethodBeat.o(106231);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.e
 * JD-Core Version:    0.7.0.1
 */