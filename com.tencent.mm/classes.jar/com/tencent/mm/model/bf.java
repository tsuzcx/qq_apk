package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;

public final class bf
{
  public static void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 2;
    AppMethodBeat.i(150169);
    boolean bool2 = b.aQF();
    boolean bool3 = b.aQH();
    com.tencent.mm.kernel.h.baF();
    boolean bool4 = ((Boolean)com.tencent.mm.kernel.h.baE().ban().d(73217, Boolean.TRUE)).booleanValue();
    com.tencent.mm.kernel.h.baF();
    boolean bool5 = ((Boolean)com.tencent.mm.kernel.h.baE().ban().d(73218, Boolean.TRUE)).booleanValue();
    boolean bool1;
    com.tencent.mm.plugin.report.service.h localh;
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
      Log.i("MicroMsg.KvNotificationStat", "doStatSysNotificationAfterModify, switchNewMsg: %s, switchVoipInvite: %s, isNewMsgNotification: %s, isNewVoipMsgNotification: %s, voipSound: %s, voipAudioSound: %s, voipHasSound: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1) });
      localh = com.tencent.mm.plugin.report.service.h.OAn;
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
      localh.b(14852, new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(0) });
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
  
  public static void vg(int paramInt)
  {
    AppMethodBeat.i(150167);
    boolean bool2 = b.aQF();
    boolean bool3 = b.aQH();
    boolean bool4 = b.aQI();
    boolean bool5 = b.aQL();
    boolean bool6 = b.aQN();
    boolean bool7 = b.aQX();
    int i2 = b.aQY();
    int i3 = b.aRa();
    int i4 = b.aQZ();
    int i5 = b.aRb();
    com.tencent.mm.kernel.h.baF();
    boolean bool8 = ((Boolean)com.tencent.mm.kernel.h.baE().ban().d(73217, Boolean.TRUE)).booleanValue();
    com.tencent.mm.kernel.h.baF();
    boolean bool9 = ((Boolean)com.tencent.mm.kernel.h.baE().ban().d(73218, Boolean.TRUE)).booleanValue();
    boolean bool1;
    com.tencent.mm.plugin.report.service.h localh;
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
      Log.i("MicroMsg.KvNotificationStat", "doStatNotification, isNewMsgNotification: %s, isNewVoipMsgNotification: %s, isNotificationShowDetail: %s, isNotificationSound: %s, isNotificationShake: %s, isActiveSilentTime: %s, activeBegin: %s, activeEnd: %s, scene: %s, voipSound: %s, voipAudioSound: %s, voipHasSound: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6), Boolean.valueOf(bool7), vh(i2) + vh(i3), vh(i4) + vh(i5), Integer.valueOf(paramInt), Boolean.valueOf(bool8), Boolean.valueOf(bool9), Boolean.valueOf(bool1) });
      localh = com.tencent.mm.plugin.report.service.h.OAn;
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
      str1 = vh(i4) + vh(i5);
      str2 = vh(i2) + vh(i3);
      if (!bool1) {
        break label521;
      }
    }
    label515:
    label521:
    for (i2 = 1;; i2 = 2)
    {
      localh.b(15308, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), str1, str2, Integer.valueOf(paramInt), Integer.valueOf(i2) });
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
  
  private static String vh(int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bf
 * JD-Core Version:    0.7.0.1
 */