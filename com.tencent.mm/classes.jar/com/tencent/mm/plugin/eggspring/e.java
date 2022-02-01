package com.tencent.mm.plugin.eggspring;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.report.service.h;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/eggspring/SpringEggRpt;", "", "()V", "RECEIVER", "", "SENDER", "TYPE_GROUP", "TYPE_SINGLE", "appId", "", "chatRoomId", "chattingType", "Ljava/lang/Integer;", "keyWord", "senderType", "sessionId", "", "getSessionId", "()Ljava/lang/Long;", "setSessionId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "userName", "eggRpt", "", "action", "keyWords", "initEggRptMsg", "isSend", "", "isGroup", "name", "luckyBagRptAction", "materialId", "luckyBagRptLoadingTimeMs", "timeMs", "luckyBagRptVideoInfo", "videoDuration", "playCount", "playDuration", "setAppId", "plugin-eggspring_release"})
public final class e
{
  private static String appId;
  public static String lXu;
  private static String userName;
  private static Integer uxB;
  private static String uxC;
  private static Long uxD;
  private static Integer uxE;
  public static final e uxF;
  
  static
  {
    AppMethodBeat.i(162208);
    uxF = new e();
    AppMethodBeat.o(162208);
  }
  
  public static void Q(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(249609);
    h.IzE.a(18916, new Object[] { uxD, "", Integer.valueOf(15), Long.valueOf(paramLong1), "", "", "", "", appId, Long.valueOf(paramLong2) });
    AppMethodBeat.o(249609);
  }
  
  public static void R(int paramInt, long paramLong)
  {
    AppMethodBeat.i(249607);
    h.IzE.a(18916, new Object[] { uxD, "", Integer.valueOf(paramInt), "", "", "", "", "", appId, Long.valueOf(paramLong) });
    AppMethodBeat.o(249607);
  }
  
  public static void a(long paramLong1, int paramInt, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(249610);
    h.IzE.a(18916, new Object[] { uxD, "", Integer.valueOf(16), "", Long.valueOf(paramLong1), Integer.valueOf(paramInt), Long.valueOf(paramLong2), "", appId, Long.valueOf(paramLong3) });
    AppMethodBeat.o(249610);
  }
  
  public static void aO(int paramInt, String paramString)
  {
    AppMethodBeat.i(162206);
    h.IzE.a(18914, new Object[] { paramString, uxB, userName, uxC, uxD, uxE, Integer.valueOf(paramInt) });
    AppMethodBeat.o(162206);
  }
  
  public static void b(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(249601);
    p.k(paramString1, "name");
    p.k(paramString2, "keyWord");
    Integer localInteger;
    if (paramBoolean1)
    {
      localInteger = Integer.valueOf(1);
      uxB = localInteger;
      if (!paramBoolean2) {
        break label80;
      }
      uxC = paramString1;
      userName = "";
    }
    for (uxE = Integer.valueOf(2);; uxE = Integer.valueOf(1))
    {
      lXu = paramString2;
      uxD = Long.valueOf(cm.bfC());
      AppMethodBeat.o(249601);
      return;
      localInteger = Integer.valueOf(2);
      break;
      label80:
      userName = paramString1;
      uxC = "";
    }
  }
  
  public static Long cTn()
  {
    return uxD;
  }
  
  public static void setAppId(String paramString)
  {
    appId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.e
 * JD-Core Version:    0.7.0.1
 */