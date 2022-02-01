package com.tencent.mm.plugin.ball.service;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static List<BallInfo> ngB;
  public static int ngC;
  public static int ngD;
  private static e ngE;
  
  static
  {
    AppMethodBeat.i(106235);
    ngB = new Vector();
    ngC = com.tencent.mm.plugin.ball.f.e.nic;
    ngD = com.tencent.mm.plugin.ball.f.e.nid;
    AppMethodBeat.o(106235);
  }
  
  private e()
  {
    AppMethodBeat.i(106222);
    tX();
    if (g.ab(com.tencent.mm.plugin.handoff.a.a.class) != null) {
      ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).dV(ngB);
    }
    AppMethodBeat.o(106222);
  }
  
  public static int SQ(String paramString)
  {
    AppMethodBeat.i(176965);
    int i = aw.aKT(bGj()).decodeInt(paramString, 0);
    AppMethodBeat.o(176965);
    return i;
  }
  
  private static String SR(String paramString)
  {
    AppMethodBeat.i(106226);
    g.agP();
    if (!com.tencent.mm.kernel.a.afX())
    {
      AppMethodBeat.o(106226);
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    g.agP();
    paramString = com.tencent.mm.kernel.a.afE() + "#" + paramString;
    AppMethodBeat.o(106226);
    return paramString;
  }
  
  /* Error */
  private void a(BallInfo paramBallInfo, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 111
    //   4: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnull +85 -> 93
    //   11: aload_2
    //   12: ifnull +47 -> 59
    //   15: ldc 113
    //   17: ldc 115
    //   19: iconst_1
    //   20: anewarray 4	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: aload_1
    //   26: invokevirtual 120	com/tencent/mm/plugin/ball/model/BallInfo:bGd	()Ljava/lang/String;
    //   29: aastore
    //   30: invokestatic 125	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   33: invokestatic 70	com/tencent/mm/plugin/ball/service/e:bGj	()Ljava/lang/String;
    //   36: invokestatic 76	com/tencent/mm/sdk/platformtools/aw:aKT	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/aw;
    //   39: aload_1
    //   40: invokevirtual 120	com/tencent/mm/plugin/ball/model/BallInfo:bGd	()Ljava/lang/String;
    //   43: aload_2
    //   44: invokevirtual 128	org/json/JSONObject:toString	()Ljava/lang/String;
    //   47: invokevirtual 132	com/tencent/mm/sdk/platformtools/aw:encode	(Ljava/lang/String;Ljava/lang/String;)Z
    //   50: pop
    //   51: ldc 111
    //   53: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: ldc 113
    //   61: ldc 134
    //   63: iconst_1
    //   64: anewarray 4	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: aload_1
    //   70: invokevirtual 120	com/tencent/mm/plugin/ball/model/BallInfo:bGd	()Ljava/lang/String;
    //   73: aastore
    //   74: invokestatic 125	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: invokestatic 70	com/tencent/mm/plugin/ball/service/e:bGj	()Ljava/lang/String;
    //   80: invokestatic 76	com/tencent/mm/sdk/platformtools/aw:aKT	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/aw;
    //   83: aload_1
    //   84: invokevirtual 120	com/tencent/mm/plugin/ball/model/BallInfo:bGd	()Ljava/lang/String;
    //   87: ldc 136
    //   89: invokevirtual 132	com/tencent/mm/sdk/platformtools/aw:encode	(Ljava/lang/String;Ljava/lang/String;)Z
    //   92: pop
    //   93: ldc 111
    //   95: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static e bGN()
  {
    AppMethodBeat.i(106223);
    if (ngE == null) {}
    try
    {
      if (ngE == null) {
        ngE = new e();
      }
      e locale = ngE;
      AppMethodBeat.o(106223);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(106223);
    }
  }
  
  public static int bGO()
  {
    return ngC;
  }
  
  public static int bGP()
  {
    return ngD;
  }
  
  public static List<BallInfo> bGQ()
  {
    return ngB;
  }
  
  private void bGR()
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
          if (d.h(ngB))
          {
            int j = 0;
            i = 0;
            if (j < ngB.size())
            {
              BallInfo localBallInfo = (BallInfo)ngB.get(j);
              JSONObject localJSONObject = BallInfo.v(localBallInfo);
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
          aw localaw;
          localObject2 = finally;
        }
        catch (JSONException localJSONException)
        {
          ac.printErrStackTrace("MicroMsg.FloatBallStorage", localJSONException, "saveBallInfoList fail, exception:%s", new Object[] { localJSONException });
          localObject1 = ((JSONArray)localObject1).toString();
          aw.aKT(bGj()).encode("balls", (String)localObject1);
          localObject1 = d.bP(ngB);
          localaw = aw.aKT(bGj());
          if (d.h((Collection)localObject1))
          {
            i = ((List)localObject1).size();
            localaw.encode("ActiveCount", i);
            AppMethodBeat.o(106232);
            return;
          }
          i = 0;
        }
      }
    }
    finally {}
  }
  
  private static void bGS()
  {
    AppMethodBeat.i(106234);
    String[] arrayOfString = aw.aKT(bGj()).allKeys();
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
      if ((!bs.lr(str, "pos_x")) && (!bs.lr(str, "pos_y")) && (!bs.lr(str, "balls")) && (!bs.lr(str, "ActiveCount")) && (!bs.lr(str, "req_perm_cnt")))
      {
        Iterator localIterator = ngB.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!bs.lr(str, ((BallInfo)localIterator.next()).bGd()));
      }
    }
    for (int k = 1;; k = 0)
    {
      if (k == 0)
      {
        ac.i("MicroMsg.FloatBallStorage", "fixExistedKeyValues, key:%s", new Object[] { str });
        aw.aKT(bGj()).remove(str).commit();
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
  
  public static String bGj()
  {
    AppMethodBeat.i(106227);
    g.agP();
    if (!com.tencent.mm.kernel.a.afX())
    {
      AppMethodBeat.o(106227);
      return "float_ball_storage";
    }
    String str = SR("float_ball_storage");
    AppMethodBeat.o(106227);
    return str;
  }
  
  public static void cl(String paramString, int paramInt)
  {
    AppMethodBeat.i(176966);
    aw.aKT(bGj()).encode(paramString, paramInt);
    AppMethodBeat.o(176966);
  }
  
  private void tX()
  {
    int k = 0;
    Object localObject1;
    label29:
    label180:
    label231:
    try
    {
      AppMethodBeat.i(106233);
    }
    finally {}
    try
    {
      localObject1 = aw.aKT(bGj()).allKeys();
      if (localObject1 == null) {
        break label452;
      }
      i = localObject1.length;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label354:
      ngC = com.tencent.mm.plugin.ball.f.e.nic;
      ngD = com.tencent.mm.plugin.ball.f.e.nid;
      ngB = new Vector();
      ac.printErrStackTrace("MicroMsg.FloatBallStorage", localUnsatisfiedLinkError, "load fail, error:%s", new Object[] { localUnsatisfiedLinkError });
      AppMethodBeat.o(106233);
      break label180;
      i = 0;
      break label29;
      i += 1;
      break label231;
    }
    ac.i("MicroMsg.FloatBallStorage", "printExistedKeyValues, size:%s", new Object[] { Integer.valueOf(i) });
    int j = 0;
    for (;;)
    {
      if (j < i)
      {
        ac.i("MicroMsg.FloatBallStorage", "printExistedKeyValues, key:%s", new Object[] { localObject1[j] });
        j += 1;
      }
      else
      {
        ngC = aw.aKT(bGj()).decodeInt("pos_x", com.tencent.mm.plugin.ball.f.e.nic);
        ngD = aw.aKT(bGj()).decodeInt("pos_y", com.tencent.mm.plugin.ball.f.e.nid);
        localObject1 = aw.aKT(bGj()).decodeString("balls");
        if (bs.isNullOrNil((String)localObject1))
        {
          ngB = new Vector();
          ac.i("MicroMsg.FloatBallStorage", "load, ballPosition:[%s, %s], ballInfoList is empty", new Object[] { Integer.valueOf(ngC), Integer.valueOf(ngD) });
          AppMethodBeat.o(106233);
        }
      }
    }
    for (;;)
    {
      return;
      ac.i("MicroMsg.FloatBallStorage", "load, savedBalls:%s", new Object[] { localObject1 });
      try
      {
        ngB = new Vector();
        localObject1 = new JSONArray((String)localObject1);
        if (((JSONArray)localObject1).length() <= 0) {
          break label354;
        }
        i = k;
        if (i >= ((JSONArray)localObject1).length()) {
          break label354;
        }
        Object localObject3 = ((JSONArray)localObject1).optJSONObject(i);
        if (localObject3 == null) {
          break;
        }
        localObject3 = BallInfo.aa((JSONObject)localObject3);
        if (localObject3 == null) {
          break;
        }
        if ((((BallInfo)localObject3).nfB) && (((BallInfo)localObject3).type != 16))
        {
          l((BallInfo)localObject3);
        }
        else
        {
          ((BallInfo)localObject3).nfC = false;
          ((BallInfo)localObject3).state = 0;
          ngB.add(localObject3);
        }
      }
      catch (JSONException localJSONException)
      {
        ac.printErrStackTrace("MicroMsg.FloatBallStorage", localJSONException, "load fail, exception:%s", new Object[] { localJSONException });
        AppMethodBeat.o(106233);
      }
      continue;
      bGS();
      ac.i("MicroMsg.FloatBallStorage", "load, ballPosition:[%s, %s], ballInfoList:%s", new Object[] { Integer.valueOf(ngC), Integer.valueOf(ngD), ngB });
      AppMethodBeat.o(106233);
    }
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106228);
    ngB = paramList;
    bGR();
    AppMethodBeat.o(106228);
  }
  
  public final void clear()
  {
    try
    {
      AppMethodBeat.i(106229);
      aw.aKT(bGj()).clear();
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
        ac.i("MicroMsg.FloatBallStorage", ">>>>>> removeBallInfo, dataKey:%s <<<<<<", new Object[] { paramBallInfo.bGd() });
        aw.aKT(bGj()).remove(paramBallInfo.bGd()).commit();
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