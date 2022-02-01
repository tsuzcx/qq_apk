package com.tencent.mm.plugin.ball.service;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.ball.f.e;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
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
  private static List<BallInfo> vkL;
  public static int vkM;
  public static int vkN;
  public static int vkO;
  public static boolean vkP;
  private static d vkQ;
  
  static
  {
    AppMethodBeat.i(106235);
    vkL = new Vector();
    vkM = 0;
    vkN = e.vmp;
    vkO = 0;
    vkP = false;
    AppMethodBeat.o(106235);
  }
  
  private d()
  {
    AppMethodBeat.i(106222);
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.w("MicroMsg.FloatBallStorage", "initFloatBallStorage account not ready");
      AppMethodBeat.o(106222);
      return;
    }
    Td();
    if (com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class) != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).iw(vkL);
    }
    AppMethodBeat.o(106222);
  }
  
  private void Td()
  {
    bool = true;
    int k = 0;
    Object localObject1;
    label32:
    try
    {
      AppMethodBeat.i(106233);
    }
    finally {}
    try
    {
      localObject1 = MultiProcessMMKV.getMMKV(cYh()).allKeys();
      if (localObject1 == null) {
        break label643;
      }
      i = localObject1.length;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        vkM = 0;
        vkN = e.vmp;
        vkP = false;
        vkL = new Vector();
        vkO = 0;
        Log.printErrStackTrace("MicroMsg.FloatBallStorage", localUnsatisfiedLinkError, "load fail, error:%s", new Object[] { localUnsatisfiedLinkError });
        AppMethodBeat.o(106233);
        break;
        com.tencent.threadpool.h.ahAA.bo(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(288437);
            this.viZ.vjI.opType = 15;
            a.b(this.viZ, bool);
            AppMethodBeat.o(288437);
          }
        });
      }
      break label648;
      i = 0;
      break label32;
      i += 1;
      break label344;
    }
    Log.i("MicroMsg.FloatBallStorage", "printExistedKeyValues, size:%s", new Object[] { Integer.valueOf(i) });
    int j = 0;
    while (j < i)
    {
      Log.i("MicroMsg.FloatBallStorage", "printExistedKeyValues, key:%s", new Object[] { localObject1[j] });
      j += 1;
    }
    vkM = MultiProcessMMKV.getMMKV(cYh()).decodeInt("pos_x", 0);
    vkN = MultiProcessMMKV.getMMKV(cYh()).decodeInt("pos_y", e.vmp);
    Object localObject4;
    if (MultiProcessMMKV.getMMKV(cYh()).contains("dock_left"))
    {
      bool = MultiProcessMMKV.getMMKV(cYh()).decodeBool("dock_left", false);
      vkP = bool;
      vkO = MultiProcessMMKV.getMMKV(cYh()).decodeInt("collapse_state", 0);
      localObject4 = MultiProcessMMKV.getMMKV(cYh()).decodeString("balls");
      if (!Util.isNullOrNil((String)localObject4)) {
        break label250;
      }
      vkL = new Vector();
      Log.i("MicroMsg.FloatBallStorage", "load, ballPosition:[%s, %s], ballInfoList is empty", new Object[] { Integer.valueOf(vkM), Integer.valueOf(vkN) });
      AppMethodBeat.o(106233);
    }
    for (;;)
    {
      return;
      if (vkM < com.tencent.mm.cd.a.ms(MMApplicationContext.getContext()) / 2) {
        break;
      }
      bool = false;
      break;
      label250:
      bool = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
      Log.i("MicroMsg.FloatBallStorage", "load, savedBalls:%s, isTeenMode: %s, collapseState: %d, sBallDockLeft: %s", new Object[] { localObject4, Boolean.valueOf(bool), Integer.valueOf(vkO), Boolean.valueOf(vkP) });
      localObject3 = null;
      localObject1 = null;
      try
      {
        vkL = new Vector();
        localObject4 = new JSONArray((String)localObject4);
        if (((JSONArray)localObject4).length() > 0)
        {
          i = k;
          label344:
          localObject3 = localObject1;
          if (i < ((JSONArray)localObject4).length())
          {
            localObject3 = ((JSONArray)localObject4).optJSONObject(i);
            if (localObject3 == null) {
              break label640;
            }
            localObject3 = BallInfo.aJ((JSONObject)localObject3);
            if (localObject3 == null) {
              break label640;
            }
            if ((((BallInfo)localObject3).vjH) && ((((BallInfo)localObject3).type != 16) || (bool))) {
              l((BallInfo)localObject3);
            }
            while (((BallInfo)localObject3).type == 20)
            {
              localObject1 = localObject3;
              break;
              ((BallInfo)localObject3).trn = false;
              ((BallInfo)localObject3).state = 0;
              vkL.add(localObject3);
            }
          }
        }
      }
      catch (JSONException localJSONException)
      {
        Log.printErrStackTrace("MicroMsg.FloatBallStorage", localJSONException, "load fail, exception:%s", new Object[] { localJSONException });
        AppMethodBeat.o(106233);
      }
      bool = vkL.isEmpty();
      if ((localObject3 != null) && (((BallInfo)localObject3).type == 20)) {
        break label616;
      }
      cYR();
      Log.i("MicroMsg.FloatBallStorage", "load, ballPosition:[%s, %s], ballInfoList:%s", new Object[] { Integer.valueOf(vkM), Integer.valueOf(vkN), vkL });
      AppMethodBeat.o(106233);
    }
  }
  
  private static String UO(String paramString)
  {
    AppMethodBeat.i(106226);
    com.tencent.mm.kernel.h.baC();
    if (!b.aZM())
    {
      AppMethodBeat.o(106226);
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    paramString = b.aZs() + "#" + paramString;
    AppMethodBeat.o(106226);
    return paramString;
  }
  
  /* Error */
  private void a(BallInfo paramBallInfo, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 273
    //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnull +89 -> 98
    //   12: aload_2
    //   13: ifnull +49 -> 62
    //   16: ldc 62
    //   18: ldc_w 275
    //   21: iconst_1
    //   22: anewarray 4	java/lang/Object
    //   25: dup
    //   26: iconst_0
    //   27: aload_1
    //   28: invokevirtual 278	com/tencent/mm/plugin/ball/model/BallInfo:cYc	()Ljava/lang/String;
    //   31: aastore
    //   32: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   35: invokestatic 92	com/tencent/mm/plugin/ball/service/d:cYh	()Ljava/lang/String;
    //   38: invokestatic 98	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   41: aload_1
    //   42: invokevirtual 278	com/tencent/mm/plugin/ball/model/BallInfo:cYc	()Ljava/lang/String;
    //   45: aload_2
    //   46: invokevirtual 281	org/json/JSONObject:toString	()Ljava/lang/String;
    //   49: invokevirtual 285	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:encode	(Ljava/lang/String;Ljava/lang/String;)Z
    //   52: pop
    //   53: ldc_w 273
    //   56: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: ldc 62
    //   64: ldc_w 287
    //   67: iconst_1
    //   68: anewarray 4	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: aload_1
    //   74: invokevirtual 278	com/tencent/mm/plugin/ball/model/BallInfo:cYc	()Ljava/lang/String;
    //   77: aastore
    //   78: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: invokestatic 92	com/tencent/mm/plugin/ball/service/d:cYh	()Ljava/lang/String;
    //   84: invokestatic 98	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   87: aload_1
    //   88: invokevirtual 278	com/tencent/mm/plugin/ball/model/BallInfo:cYc	()Ljava/lang/String;
    //   91: ldc_w 289
    //   94: invokevirtual 285	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:encode	(Ljava/lang/String;Ljava/lang/String;)Z
    //   97: pop
    //   98: ldc_w 273
    //   101: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: goto -45 -> 59
    //   107: astore_1
    //   108: aload_0
    //   109: monitorexit
    //   110: aload_1
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	d
    //   0	112	1	paramBallInfo	BallInfo
    //   0	112	2	paramJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   2	8	107	finally
    //   16	59	107	finally
    //   62	98	107	finally
    //   98	104	107	finally
  }
  
  public static int ahW(String paramString)
  {
    AppMethodBeat.i(176965);
    int i = MultiProcessMMKV.getMMKV(cYh()).decodeInt(paramString, 0);
    AppMethodBeat.o(176965);
    return i;
  }
  
  public static d cYL()
  {
    AppMethodBeat.i(106223);
    if (vkQ == null) {}
    try
    {
      if (vkQ == null) {
        vkQ = new d();
      }
      d locald = vkQ;
      AppMethodBeat.o(106223);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(106223);
    }
  }
  
  public static int cYM()
  {
    return vkM;
  }
  
  public static int cYN()
  {
    return vkN;
  }
  
  public static boolean cYO()
  {
    return vkP;
  }
  
  public static List<BallInfo> cYP()
  {
    return vkL;
  }
  
  private void cYQ()
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
          if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(vkL))
          {
            int j = 0;
            i = 0;
            if (j < vkL.size())
            {
              BallInfo localBallInfo = (BallInfo)vkL.get(j);
              JSONObject localJSONObject = BallInfo.x(localBallInfo);
              if (localJSONObject == null) {
                break label207;
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
          MultiProcessMMKV.getMMKV(cYh()).encode("balls", (String)localObject1);
          Log.i("MicroMsg.FloatBallStorage", "saveBallInfoList, savedBalls:%s", new Object[] { localObject1 });
          localObject1 = com.tencent.mm.plugin.ball.f.d.dU(vkL);
          localMultiProcessMMKV = MultiProcessMMKV.getMMKV(cYh());
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
  
  private static void cYR()
  {
    AppMethodBeat.i(106234);
    String[] arrayOfString = MultiProcessMMKV.getMMKV(cYh()).allKeys();
    int i;
    int j;
    label25:
    String str;
    if (arrayOfString != null)
    {
      i = arrayOfString.length;
      j = 0;
      if (j >= i) {
        break label180;
      }
      str = arrayOfString[j];
      if ((!Util.isEqual(str, "pos_x")) && (!Util.isEqual(str, "pos_y")) && (!Util.isEqual(str, "balls")) && (!Util.isEqual(str, "ActiveCount")) && (!Util.isEqual(str, "req_perm_cnt")))
      {
        Iterator localIterator = vkL.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!Util.isEqual(str, ((BallInfo)localIterator.next()).cYc()));
      }
    }
    for (int k = 1;; k = 0)
    {
      if (k == 0)
      {
        Log.i("MicroMsg.FloatBallStorage", "fixExistedKeyValues, key:%s", new Object[] { str });
        MultiProcessMMKV.getMMKV(cYh()).remove(str).commit();
      }
      j += 1;
      break label25;
      i = 0;
      break;
      label180:
      AppMethodBeat.o(106234);
      return;
    }
  }
  
  public static String cYh()
  {
    AppMethodBeat.i(106227);
    com.tencent.mm.kernel.h.baC();
    if (!b.aZM())
    {
      AppMethodBeat.o(106227);
      return "float_ball_storage";
    }
    String str = UO("float_ball_storage");
    AppMethodBeat.o(106227);
    return str;
  }
  
  public static void dw(String paramString, int paramInt)
  {
    AppMethodBeat.i(176966);
    MultiProcessMMKV.getMMKV(cYh()).encode(paramString, paramInt);
    AppMethodBeat.o(176966);
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106228);
    vkL = paramList;
    cYQ();
    AppMethodBeat.o(106228);
  }
  
  public final void clear()
  {
    try
    {
      AppMethodBeat.i(106229);
      MultiProcessMMKV.getMMKV(cYh()).clear();
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
        Log.i("MicroMsg.FloatBallStorage", ">>>>>> removeBallInfo, dataKey:%s <<<<<<", new Object[] { paramBallInfo.cYc() });
        MultiProcessMMKV.getMMKV(cYh()).remove(paramBallInfo.cYc()).commit();
      }
      AppMethodBeat.o(106231);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.d
 * JD-Core Version:    0.7.0.1
 */