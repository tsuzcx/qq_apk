package com.tencent.mm.plugin.eggspring;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/eggspring/SpringEggRpt;", "", "()V", "RECEIVER", "", "SENDER", "TAG", "", "TYPE_GROUP", "TYPE_SINGLE", "appId", "chatRoomId", "chattingType", "Ljava/lang/Integer;", "extendString", "keyWord", "reportEffectType", "senderType", "sessionId", "", "getSessionId", "()Ljava/lang/Long;", "setSessionId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "userName", "eggRpt", "", "action", "keyWords", "initEggRptMsg", "isSend", "", "isGroup", "name", "effectType", "luckyBagRptAction", "materialId", "luckyBagRptLoadingTimeMs", "timeMs", "luckyBagRptVideoInfo", "videoDuration", "playCount", "playDuration", "setAppId", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  private static final String TAG;
  private static String appId;
  public static String oQy;
  private static String userName;
  public static final f xEl;
  private static Integer xEm;
  private static String xEn;
  private static Long xEo;
  private static Integer xEp;
  private static String xEq;
  private static int xEr;
  
  static
  {
    AppMethodBeat.i(162208);
    xEl = new f();
    TAG = "MicroMsg.SpringEggRpt";
    xEq = "";
    xEr = 1;
    AppMethodBeat.o(162208);
  }
  
  public static void V(int paramInt, long paramLong)
  {
    AppMethodBeat.i(266538);
    h.OAn.b(18916, new Object[] { xEo, "", Integer.valueOf(paramInt), "", "", "", "", "", appId, Long.valueOf(paramLong) });
    AppMethodBeat.o(266538);
  }
  
  public static void a(long paramLong1, int paramInt, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(266546);
    h.OAn.b(18916, new Object[] { xEo, "", Integer.valueOf(16), "", Long.valueOf(paramLong1), Integer.valueOf(paramInt), Long.valueOf(paramLong2), "", appId, Long.valueOf(paramLong3) });
    AppMethodBeat.o(266546);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(266525);
    s.u(paramString1, "name");
    s.u(paramString2, "keyWord");
    Integer localInteger;
    if (paramBoolean1)
    {
      localInteger = Integer.valueOf(1);
      xEm = localInteger;
      if (!paramBoolean2) {
        break label94;
      }
      xEn = paramString1;
      userName = "";
      xEp = Integer.valueOf(2);
      label52:
      oQy = paramString2;
      xEo = Long.valueOf(cn.bDu());
      if (paramInt != 1) {
        break label113;
      }
    }
    label94:
    label113:
    for (paramInt = 2;; paramInt = 1)
    {
      xEr = paramInt;
      AppMethodBeat.o(266525);
      return;
      localInteger = Integer.valueOf(2);
      break;
      userName = paramString1;
      xEn = "";
      xEp = Integer.valueOf(1);
      break label52;
    }
  }
  
  public static void an(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(266541);
    h.OAn.b(18916, new Object[] { xEo, "", Integer.valueOf(15), Long.valueOf(paramLong1), "", "", "", "", appId, Long.valueOf(paramLong2) });
    AppMethodBeat.o(266541);
  }
  
  public static void bb(int paramInt, String paramString)
  {
    AppMethodBeat.i(162206);
    Log.i(TAG, "eggRpt: " + paramString + ", " + paramInt + ", " + xEr);
    h.OAn.b(18914, new Object[] { paramString, xEm, userName, xEn, xEo, xEp, Integer.valueOf(paramInt), xEq, Integer.valueOf(xEr) });
    AppMethodBeat.o(162206);
  }
  
  public static Long dxH()
  {
    return xEo;
  }
  
  public static void setAppId(String paramString)
  {
    appId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.f
 * JD-Core Version:    0.7.0.1
 */