package com.tencent.mm.plugin.ball.service;

import android.content.SharedPreferences.Editor;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.e;
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

public class d
  implements com.tencent.mm.plugin.ball.c.d
{
  private static List<BallInfo> rZv;
  public static int rZw;
  public static int rZx;
  public static boolean rZy;
  private static d rZz;
  
  static
  {
    AppMethodBeat.i(106235);
    rZv = new Vector();
    rZw = 0;
    rZx = e.saX;
    rZy = false;
    AppMethodBeat.o(106235);
  }
  
  private d()
  {
    AppMethodBeat.i(106222);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      Log.w("MicroMsg.FloatBallStorage", "initFloatBallStorage account not ready");
      AppMethodBeat.o(106222);
      return;
    }
    tA();
    if (com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class) != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).fz(rZv);
    }
    AppMethodBeat.o(106222);
  }
  
  /* Error */
  private void a(BallInfo paramBallInfo, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 81
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnull +85 -> 93
    //   11: aload_2
    //   12: ifnull +47 -> 59
    //   15: ldc 57
    //   17: ldc 83
    //   19: iconst_1
    //   20: anewarray 4	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: aload_1
    //   26: invokevirtual 89	com/tencent/mm/plugin/ball/model/BallInfo:cvr	()Ljava/lang/String;
    //   29: aastore
    //   30: invokestatic 92	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   33: invokestatic 95	com/tencent/mm/plugin/ball/service/d:cvw	()Ljava/lang/String;
    //   36: invokestatic 101	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   39: aload_1
    //   40: invokevirtual 89	com/tencent/mm/plugin/ball/model/BallInfo:cvr	()Ljava/lang/String;
    //   43: aload_2
    //   44: invokevirtual 106	org/json/JSONObject:toString	()Ljava/lang/String;
    //   47: invokevirtual 110	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:encode	(Ljava/lang/String;Ljava/lang/String;)Z
    //   50: pop
    //   51: ldc 81
    //   53: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: ldc 57
    //   61: ldc 112
    //   63: iconst_1
    //   64: anewarray 4	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: aload_1
    //   70: invokevirtual 89	com/tencent/mm/plugin/ball/model/BallInfo:cvr	()Ljava/lang/String;
    //   73: aastore
    //   74: invokestatic 92	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: invokestatic 95	com/tencent/mm/plugin/ball/service/d:cvw	()Ljava/lang/String;
    //   80: invokestatic 101	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   83: aload_1
    //   84: invokevirtual 89	com/tencent/mm/plugin/ball/model/BallInfo:cvr	()Ljava/lang/String;
    //   87: ldc 114
    //   89: invokevirtual 110	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:encode	(Ljava/lang/String;Ljava/lang/String;)Z
    //   92: pop
    //   93: ldc 81
    //   95: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: goto -42 -> 56
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	d
    //   0	106	1	paramBallInfo	BallInfo
    //   0	106	2	paramJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   2	7	101	finally
    //   15	56	101	finally
    //   59	93	101	finally
    //   93	98	101	finally
  }
  
  private static String aco(String paramString)
  {
    AppMethodBeat.i(106226);
    com.tencent.mm.kernel.h.aHE();
    if (!com.tencent.mm.kernel.b.aGL())
    {
      AppMethodBeat.o(106226);
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    paramString = com.tencent.mm.kernel.b.aGq() + "#" + paramString;
    AppMethodBeat.o(106226);
    return paramString;
  }
  
  public static int aoA(String paramString)
  {
    AppMethodBeat.i(176965);
    int i = MultiProcessMMKV.getMMKV(cvw()).decodeInt(paramString, 0);
    AppMethodBeat.o(176965);
    return i;
  }
  
  public static void cU(String paramString, int paramInt)
  {
    AppMethodBeat.i(176966);
    MultiProcessMMKV.getMMKV(cvw()).encode(paramString, paramInt);
    AppMethodBeat.o(176966);
  }
  
  public static String cvw()
  {
    AppMethodBeat.i(106227);
    com.tencent.mm.kernel.h.aHE();
    if (!com.tencent.mm.kernel.b.aGL())
    {
      AppMethodBeat.o(106227);
      return "float_ball_storage";
    }
    String str = aco("float_ball_storage");
    AppMethodBeat.o(106227);
    return str;
  }
  
  public static d cwb()
  {
    AppMethodBeat.i(106223);
    if (rZz == null) {}
    try
    {
      if (rZz == null) {
        rZz = new d();
      }
      d locald = rZz;
      AppMethodBeat.o(106223);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(106223);
    }
  }
  
  public static int cwc()
  {
    return rZw;
  }
  
  public static int cwd()
  {
    return rZx;
  }
  
  public static boolean cwe()
  {
    return rZy;
  }
  
  public static List<BallInfo> cwf()
  {
    return rZv;
  }
  
  private void cwg()
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
          if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(rZv))
          {
            int j = 0;
            i = 0;
            if (j < rZv.size())
            {
              BallInfo localBallInfo = (BallInfo)rZv.get(j);
              JSONObject localJSONObject = BallInfo.x(localBallInfo);
              if (localJSONObject == null) {
                break label202;
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
          MultiProcessMMKV.getMMKV(cvw()).encode("balls", (String)localObject1);
          Log.i("MicroMsg.FloatBallStorage", "saveBallInfoList, savedBalls:%s", new Object[] { localObject1 });
          localObject1 = com.tencent.mm.plugin.ball.f.d.cc(rZv);
          localMultiProcessMMKV = MultiProcessMMKV.getMMKV(cvw());
          if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty((Collection)localObject1))
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
  
  private static void cwh()
  {
    AppMethodBeat.i(106234);
    String[] arrayOfString = MultiProcessMMKV.getMMKV(cvw()).allKeys();
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
        Iterator localIterator = rZv.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!Util.isEqual(str, ((BallInfo)localIterator.next()).cvr()));
      }
    }
    for (int k = 1;; k = 0)
    {
      if (k == 0)
      {
        Log.i("MicroMsg.FloatBallStorage", "fixExistedKeyValues, key:%s", new Object[] { str });
        MultiProcessMMKV.getMMKV(cvw()).remove(str).commit();
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
  
  private void tA()
  {
    bool = true;
    int k = 0;
    Object localObject1;
    label33:
    Object localObject4;
    label242:
    try
    {
      AppMethodBeat.i(106233);
    }
    finally {}
    try
    {
      localObject1 = MultiProcessMMKV.getMMKV(cvw()).allKeys();
      if (localObject1 == null) {
        break label621;
      }
      i = localObject1.length;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        rZw = 0;
        rZx = e.saX;
        rZy = false;
        rZv = new Vector();
        Log.printErrStackTrace("MicroMsg.FloatBallStorage", localUnsatisfiedLinkError, "load fail, error:%s", new Object[] { localUnsatisfiedLinkError });
        AppMethodBeat.o(106233);
        break;
        com.tencent.e.h.ZvG.bg(new d.1(this, (BallInfo)localObject3, bool));
      }
      break label626;
      i = 0;
      break label33;
      i += 1;
      break label320;
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
        rZw = MultiProcessMMKV.getMMKV(cvw()).decodeInt("pos_x", 0);
        rZx = MultiProcessMMKV.getMMKV(cvw()).decodeInt("pos_y", e.saX);
        if (MultiProcessMMKV.getMMKV(cvw()).contains("dock_left"))
        {
          bool = MultiProcessMMKV.getMMKV(cvw()).decodeBool("dock_left", false);
          rZy = bool;
          localObject4 = MultiProcessMMKV.getMMKV(cvw()).decodeString("balls");
          if (!Util.isNullOrNil((String)localObject4)) {
            break label242;
          }
          rZv = new Vector();
          Log.i("MicroMsg.FloatBallStorage", "load, ballPosition:[%s, %s], ballInfoList is empty", new Object[] { Integer.valueOf(rZw), Integer.valueOf(rZx) });
          AppMethodBeat.o(106233);
        }
      }
    }
    for (;;)
    {
      return;
      if (rZw < com.tencent.mm.ci.a.kr(MMApplicationContext.getContext()) / 2) {
        break;
      }
      bool = false;
      break;
      bool = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM();
      Log.i("MicroMsg.FloatBallStorage", "load, savedBalls:%s, isTeenMode: %s", new Object[] { localObject4, Boolean.valueOf(bool) });
      localObject3 = null;
      localObject1 = null;
      try
      {
        rZv = new Vector();
        localObject4 = new JSONArray((String)localObject4);
        if (((JSONArray)localObject4).length() > 0)
        {
          i = k;
          label320:
          localObject3 = localObject1;
          if (i < ((JSONArray)localObject4).length())
          {
            localObject3 = ((JSONArray)localObject4).optJSONObject(i);
            if (localObject3 == null) {
              break label618;
            }
            localObject3 = BallInfo.az((JSONObject)localObject3);
            if (localObject3 == null) {
              break label618;
            }
            if ((((BallInfo)localObject3).rYr) && ((((BallInfo)localObject3).type != 16) || (bool))) {
              l((BallInfo)localObject3);
            }
            while (((BallInfo)localObject3).type == 20)
            {
              localObject1 = localObject3;
              break;
              ((BallInfo)localObject3).qmt = false;
              ((BallInfo)localObject3).state = 0;
              rZv.add(localObject3);
            }
          }
        }
      }
      catch (JSONException localJSONException)
      {
        Log.printErrStackTrace("MicroMsg.FloatBallStorage", localJSONException, "load fail, exception:%s", new Object[] { localJSONException });
        AppMethodBeat.o(106233);
      }
      bool = rZv.isEmpty();
      if ((localObject3 != null) && (((BallInfo)localObject3).type == 20)) {
        break label594;
      }
      cwh();
      Log.i("MicroMsg.FloatBallStorage", "load, ballPosition:[%s, %s], ballInfoList:%s", new Object[] { Integer.valueOf(rZw), Integer.valueOf(rZx), rZv });
      AppMethodBeat.o(106233);
    }
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106228);
    rZv = paramList;
    cwg();
    AppMethodBeat.o(106228);
  }
  
  public final void clear()
  {
    try
    {
      AppMethodBeat.i(106229);
      MultiProcessMMKV.getMMKV(cvw()).clear();
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
        Log.i("MicroMsg.FloatBallStorage", ">>>>>> removeBallInfo, dataKey:%s <<<<<<", new Object[] { paramBallInfo.cvr() });
        MultiProcessMMKV.getMMKV(cvw()).remove(paramBallInfo.cvr()).commit();
      }
      AppMethodBeat.o(106231);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.d
 * JD-Core Version:    0.7.0.1
 */