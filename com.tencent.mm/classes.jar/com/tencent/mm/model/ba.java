package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.n.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;

public final class ba
{
  public static void m(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 2;
    AppMethodBeat.i(150169);
    boolean bool2 = a.abO();
    boolean bool3 = a.abQ();
    com.tencent.mm.kernel.g.ajS();
    boolean bool4 = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(73217, Boolean.TRUE)).booleanValue();
    com.tencent.mm.kernel.g.ajS();
    boolean bool5 = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(73218, Boolean.TRUE)).booleanValue();
    boolean bool1;
    com.tencent.mm.plugin.report.service.g localg;
    int k;
    label162:
    int m;
    label170:
    int n;
    label178:
    int i;
    if ((bool4) || (bool5))
    {
      bool1 = true;
      ae.i("MicroMsg.KvNotificationStat", "doStatSysNotificationAfterModify, switchNewMsg: %s, switchVoipInvite: %s, isNewMsgNotification: %s, isNewVoipMsgNotification: %s, voipSound: %s, voipAudioSound: %s, voipHasSound: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1) });
      localg = com.tencent.mm.plugin.report.service.g.yxI;
      if (!bool2) {
        break label284;
      }
      k = 1;
      if (!bool3) {
        break label290;
      }
      m = 1;
      if (!bool1) {
        break label296;
      }
      n = 1;
      if (!paramBoolean1) {
        break label307;
      }
      if (!bool2) {
        break label302;
      }
      i = 2;
      label189:
      if (!paramBoolean2) {
        break label317;
      }
      if (!bool3) {
        break label312;
      }
    }
    for (;;)
    {
      localg.f(14852, new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(150169);
      return;
      bool1 = false;
      break;
      label284:
      k = 0;
      break label162;
      label290:
      m = 0;
      break label170;
      label296:
      n = 0;
      break label178;
      label302:
      i = 1;
      break label189;
      label307:
      i = 0;
      break label189;
      label312:
      j = 1;
      continue;
      label317:
      j = 0;
    }
  }
  
  public static void ox(int paramInt)
  {
    AppMethodBeat.i(150167);
    boolean bool2 = a.abO();
    boolean bool3 = a.abQ();
    boolean bool4 = a.abR();
    boolean bool5 = a.abS();
    boolean bool6 = a.abW();
    boolean bool7 = a.acf();
    int i2 = a.acg();
    int i3 = a.aci();
    int i4 = a.ach();
    int i5 = a.acj();
    com.tencent.mm.kernel.g.ajS();
    boolean bool8 = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(73217, Boolean.TRUE)).booleanValue();
    com.tencent.mm.kernel.g.ajS();
    boolean bool9 = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(73218, Boolean.TRUE)).booleanValue();
    boolean bool1;
    com.tencent.mm.plugin.report.service.g localg;
    int i;
    label287:
    int j;
    label294:
    int k;
    label301:
    int m;
    label309:
    int n;
    label317:
    int i1;
    label325:
    String str1;
    String str2;
    if ((bool8) || (bool9))
    {
      bool1 = true;
      ae.i("MicroMsg.KvNotificationStat", "doStatNotification, isNewMsgNotification: %s, isNewVoipMsgNotification: %s, isNotificationShowDetail: %s, isNotificationSound: %s, isNotificationShake: %s, isActiveSilentTime: %s, activeBegin: %s, activeEnd: %s, scene: %s, voipSound: %s, voipAudioSound: %s, voipHasSound: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6), Boolean.valueOf(bool7), oy(i2) + oy(i3), oy(i4) + oy(i5), Integer.valueOf(paramInt), Boolean.valueOf(bool8), Boolean.valueOf(bool9), Boolean.valueOf(bool1) });
      localg = com.tencent.mm.plugin.report.service.g.yxI;
      if (!bool2) {
        break label488;
      }
      i = 1;
      if (!bool3) {
        break label493;
      }
      j = 1;
      if (!bool4) {
        break label498;
      }
      k = 1;
      if (!bool5) {
        break label503;
      }
      m = 1;
      if (!bool6) {
        break label509;
      }
      n = 1;
      if (!bool7) {
        break label515;
      }
      i1 = 2;
      str1 = oy(i4) + oy(i5);
      str2 = oy(i2) + oy(i3);
      if (!bool1) {
        break label521;
      }
    }
    label515:
    label521:
    for (i2 = 1;; i2 = 2)
    {
      localg.f(15308, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), str1, str2, Integer.valueOf(paramInt), Integer.valueOf(i2) });
      AppMethodBeat.o(150167);
      return;
      bool1 = false;
      break;
      label488:
      i = 2;
      break label287;
      label493:
      j = 2;
      break label294;
      label498:
      k = 2;
      break label301;
      label503:
      m = 2;
      break label309;
      label509:
      n = 2;
      break label317;
      i1 = 1;
      break label325;
    }
  }
  
  private static String oy(int paramInt)
  {
    AppMethodBeat.i(150168);
    if (paramInt > 10)
    {
      AppMethodBeat.o(150168);
      return String.valueOf(paramInt);
    }
    String str = "0".concat(String.valueOf(paramInt));
    AppMethodBeat.o(150168);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.ba
 * JD-Core Version:    0.7.0.1
 */