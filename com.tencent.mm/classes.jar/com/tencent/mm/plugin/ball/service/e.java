package com.tencent.mm.plugin.ball.service;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  implements com.tencent.mm.plugin.ball.c.e
{
  public static int nMA;
  public static int nMB;
  public static boolean nMC;
  private static e nMD;
  private static List<BallInfo> nMz;
  
  static
  {
    AppMethodBeat.i(106235);
    nMz = new Vector();
    nMA = com.tencent.mm.plugin.ball.f.e.nOb;
    nMB = com.tencent.mm.plugin.ball.f.e.nOc;
    nMC = false;
    AppMethodBeat.o(106235);
  }
  
  private e()
  {
    AppMethodBeat.i(106222);
    vw();
    if (g.ab(com.tencent.mm.plugin.handoff.a.a.class) != null) {
      ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).em(nMz);
    }
    AppMethodBeat.o(106222);
  }
  
  private static String Lv(String paramString)
  {
    AppMethodBeat.i(106226);
    g.ajP();
    if (!com.tencent.mm.kernel.a.aiY())
    {
      AppMethodBeat.o(106226);
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    g.ajP();
    paramString = com.tencent.mm.kernel.a.aiF() + "#" + paramString;
    AppMethodBeat.o(106226);
    return paramString;
  }
  
  public static int Xa(String paramString)
  {
    AppMethodBeat.i(176965);
    int i = ay.aRW(bLr()).decodeInt(paramString, 0);
    AppMethodBeat.o(176965);
    return i;
  }
  
  /* Error */
  private void a(BallInfo paramBallInfo, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 115
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnull +85 -> 93
    //   11: aload_2
    //   12: ifnull +47 -> 59
    //   15: ldc 117
    //   17: ldc 119
    //   19: iconst_1
    //   20: anewarray 4	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: aload_1
    //   26: invokevirtual 124	com/tencent/mm/plugin/ball/model/BallInfo:bLl	()Ljava/lang/String;
    //   29: aastore
    //   30: invokestatic 129	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   33: invokestatic 102	com/tencent/mm/plugin/ball/service/e:bLr	()Ljava/lang/String;
    //   36: invokestatic 108	com/tencent/mm/sdk/platformtools/ay:aRW	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/ay;
    //   39: aload_1
    //   40: invokevirtual 124	com/tencent/mm/plugin/ball/model/BallInfo:bLl	()Ljava/lang/String;
    //   43: aload_2
    //   44: invokevirtual 132	org/json/JSONObject:toString	()Ljava/lang/String;
    //   47: invokevirtual 136	com/tencent/mm/sdk/platformtools/ay:encode	(Ljava/lang/String;Ljava/lang/String;)Z
    //   50: pop
    //   51: ldc 115
    //   53: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: ldc 117
    //   61: ldc 138
    //   63: iconst_1
    //   64: anewarray 4	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: aload_1
    //   70: invokevirtual 124	com/tencent/mm/plugin/ball/model/BallInfo:bLl	()Ljava/lang/String;
    //   73: aastore
    //   74: invokestatic 129	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: invokestatic 102	com/tencent/mm/plugin/ball/service/e:bLr	()Ljava/lang/String;
    //   80: invokestatic 108	com/tencent/mm/sdk/platformtools/ay:aRW	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/ay;
    //   83: aload_1
    //   84: invokevirtual 124	com/tencent/mm/plugin/ball/model/BallInfo:bLl	()Ljava/lang/String;
    //   87: ldc 140
    //   89: invokevirtual 136	com/tencent/mm/sdk/platformtools/ay:encode	(Ljava/lang/String;Ljava/lang/String;)Z
    //   92: pop
    //   93: ldc 115
    //   95: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static e bLU()
  {
    AppMethodBeat.i(106223);
    if (nMD == null) {}
    try
    {
      if (nMD == null) {
        nMD = new e();
      }
      e locale = nMD;
      AppMethodBeat.o(106223);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(106223);
    }
  }
  
  public static int bLV()
  {
    return nMA;
  }
  
  public static int bLW()
  {
    return nMB;
  }
  
  public static List<BallInfo> bLX()
  {
    return nMz;
  }
  
  private void bLY()
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
          if (d.h(nMz))
          {
            int j = 0;
            i = 0;
            if (j < nMz.size())
            {
              BallInfo localBallInfo = (BallInfo)nMz.get(j);
              JSONObject localJSONObject = BallInfo.y(localBallInfo);
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
          ay localay;
          localObject2 = finally;
        }
        catch (JSONException localJSONException)
        {
          ae.printErrStackTrace("MicroMsg.FloatBallStorage", localJSONException, "saveBallInfoList fail, exception:%s", new Object[] { localJSONException });
          localObject1 = ((JSONArray)localObject1).toString();
          ay.aRW(bLr()).encode("balls", (String)localObject1);
          localObject1 = d.bS(nMz);
          localay = ay.aRW(bLr());
          if (d.h((Collection)localObject1))
          {
            i = ((List)localObject1).size();
            localay.encode("ActiveCount", i);
            AppMethodBeat.o(106232);
            return;
          }
          i = 0;
        }
      }
    }
    finally {}
  }
  
  private static void bLZ()
  {
    AppMethodBeat.i(106234);
    String[] arrayOfString = ay.aRW(bLr()).allKeys();
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
      if ((!bu.lX(str, "pos_x")) && (!bu.lX(str, "pos_y")) && (!bu.lX(str, "balls")) && (!bu.lX(str, "ActiveCount")) && (!bu.lX(str, "req_perm_cnt")))
      {
        Iterator localIterator = nMz.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!bu.lX(str, ((BallInfo)localIterator.next()).bLl()));
      }
    }
    for (int k = 1;; k = 0)
    {
      if (k == 0)
      {
        ae.i("MicroMsg.FloatBallStorage", "fixExistedKeyValues, key:%s", new Object[] { str });
        ay.aRW(bLr()).remove(str).commit();
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
  
  public static String bLr()
  {
    AppMethodBeat.i(106227);
    g.ajP();
    if (!com.tencent.mm.kernel.a.aiY())
    {
      AppMethodBeat.o(106227);
      return "float_ball_storage";
    }
    String str = Lv("float_ball_storage");
    AppMethodBeat.o(106227);
    return str;
  }
  
  public static void cs(String paramString, int paramInt)
  {
    AppMethodBeat.i(176966);
    ay.aRW(bLr()).encode(paramString, paramInt);
    AppMethodBeat.o(176966);
  }
  
  private void vw()
  {
    boolean bool = true;
    int k = 0;
    Object localObject1;
    label32:
    label219:
    label242:
    try
    {
      AppMethodBeat.i(106233);
    }
    finally {}
    try
    {
      localObject1 = ay.aRW(bLr()).allKeys();
      if (localObject1 == null) {
        break label515;
      }
      i = localObject1.length;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label290:
      nMA = com.tencent.mm.plugin.ball.f.e.nOb;
      label413:
      nMB = com.tencent.mm.plugin.ball.f.e.nOc;
      nMC = false;
      nMz = new Vector();
      ae.printErrStackTrace("MicroMsg.FloatBallStorage", localUnsatisfiedLinkError, "load fail, error:%s", new Object[] { localUnsatisfiedLinkError });
      AppMethodBeat.o(106233);
      break label219;
      i = 0;
      break label32;
      i += 1;
      break label290;
    }
    ae.i("MicroMsg.FloatBallStorage", "printExistedKeyValues, size:%s", new Object[] { Integer.valueOf(i) });
    int j = 0;
    for (;;)
    {
      if (j < i)
      {
        ae.i("MicroMsg.FloatBallStorage", "printExistedKeyValues, key:%s", new Object[] { localObject1[j] });
        j += 1;
      }
      else
      {
        nMA = ay.aRW(bLr()).decodeInt("pos_x", com.tencent.mm.plugin.ball.f.e.nOb);
        nMB = ay.aRW(bLr()).decodeInt("pos_y", com.tencent.mm.plugin.ball.f.e.nOc);
        if (ay.aRW(bLr()).contains("dock_left"))
        {
          bool = ay.aRW(bLr()).decodeBool("dock_left", false);
          nMC = bool;
          localObject1 = ay.aRW(bLr()).decodeString("balls");
          if (!bu.isNullOrNil((String)localObject1)) {
            break label242;
          }
          nMz = new Vector();
          ae.i("MicroMsg.FloatBallStorage", "load, ballPosition:[%s, %s], ballInfoList is empty", new Object[] { Integer.valueOf(nMA), Integer.valueOf(nMB) });
          AppMethodBeat.o(106233);
        }
      }
    }
    for (;;)
    {
      return;
      if (nMA < com.tencent.mm.cb.a.iu(ak.getContext()) / 2) {
        break;
      }
      bool = false;
      break;
      ae.i("MicroMsg.FloatBallStorage", "load, savedBalls:%s", new Object[] { localObject1 });
      try
      {
        nMz = new Vector();
        localObject1 = new JSONArray((String)localObject1);
        if (((JSONArray)localObject1).length() <= 0) {
          break label413;
        }
        i = k;
        if (i >= ((JSONArray)localObject1).length()) {
          break label413;
        }
        Object localObject3 = ((JSONArray)localObject1).optJSONObject(i);
        if (localObject3 == null) {
          break label520;
        }
        localObject3 = BallInfo.ad((JSONObject)localObject3);
        if (localObject3 == null) {
          break label520;
        }
        if ((((BallInfo)localObject3).nLu) && (((BallInfo)localObject3).type != 16))
        {
          m((BallInfo)localObject3);
        }
        else
        {
          ((BallInfo)localObject3).nLv = false;
          ((BallInfo)localObject3).state = 0;
          nMz.add(localObject3);
        }
      }
      catch (JSONException localJSONException)
      {
        ae.printErrStackTrace("MicroMsg.FloatBallStorage", localJSONException, "load fail, exception:%s", new Object[] { localJSONException });
        AppMethodBeat.o(106233);
      }
      continue;
      bLZ();
      ae.i("MicroMsg.FloatBallStorage", "load, ballPosition:[%s, %s], ballInfoList:%s", new Object[] { Integer.valueOf(nMA), Integer.valueOf(nMB), nMz });
      AppMethodBeat.o(106233);
    }
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106228);
    nMz = paramList;
    bLY();
    AppMethodBeat.o(106228);
  }
  
  public final void clear()
  {
    try
    {
      AppMethodBeat.i(106229);
      ay.aRW(bLr()).clear();
      AppMethodBeat.o(106229);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void m(BallInfo paramBallInfo)
  {
    try
    {
      AppMethodBeat.i(106231);
      if (paramBallInfo != null)
      {
        ae.i("MicroMsg.FloatBallStorage", ">>>>>> removeBallInfo, dataKey:%s <<<<<<", new Object[] { paramBallInfo.bLl() });
        ay.aRW(bLr()).remove(paramBallInfo.bLl()).commit();
      }
      AppMethodBeat.o(106231);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.e
 * JD-Core Version:    0.7.0.1
 */