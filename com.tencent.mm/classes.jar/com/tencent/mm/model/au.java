package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;

public final class au
{
  public static void k(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 2;
    AppMethodBeat.i(77812);
    boolean bool2 = a.Mx();
    boolean bool3 = a.Mz();
    g.RM();
    boolean bool4 = ((Boolean)g.RL().Ru().get(73217, Boolean.TRUE)).booleanValue();
    g.RM();
    boolean bool5 = ((Boolean)g.RL().Ru().get(73218, Boolean.TRUE)).booleanValue();
    boolean bool1;
    h localh;
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
      ab.i("MicroMsg.KvNotificationStat", "doStatSysNotificationAfterModify, switchNewMsg: %s, switchVoipInvite: %s, isNewMsgNotification: %s, isNewVoipMsgNotification: %s, voipSound: %s, voipAudioSound: %s, voipHasSound: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1) });
      localh = h.qsU;
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
      localh.e(14852, new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(77812);
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
  
  public static void kA(int paramInt)
  {
    AppMethodBeat.i(77810);
    boolean bool2 = a.Mx();
    boolean bool3 = a.Mz();
    boolean bool4 = a.MA();
    boolean bool5 = a.MB();
    boolean bool6 = a.MD();
    boolean bool7 = a.MM();
    int i2 = a.MN();
    int i3 = a.MP();
    int i4 = a.MO();
    int i5 = a.MQ();
    g.RM();
    boolean bool8 = ((Boolean)g.RL().Ru().get(73217, Boolean.TRUE)).booleanValue();
    g.RM();
    boolean bool9 = ((Boolean)g.RL().Ru().get(73218, Boolean.TRUE)).booleanValue();
    boolean bool1;
    h localh;
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
      ab.i("MicroMsg.KvNotificationStat", "doStatNotification, isNewMsgNotification: %s, isNewVoipMsgNotification: %s, isNotificationShowDetail: %s, isNotificationSound: %s, isNotificationShake: %s, isActiveSilentTime: %s, activeBegin: %s, activeEnd: %s, scene: %s, voipSound: %s, voipAudioSound: %s, voipHasSound: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6), Boolean.valueOf(bool7), kB(i2) + kB(i3), kB(i4) + kB(i5), Integer.valueOf(paramInt), Boolean.valueOf(bool8), Boolean.valueOf(bool9), Boolean.valueOf(bool1) });
      localh = h.qsU;
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
      str1 = kB(i4) + kB(i5);
      str2 = kB(i2) + kB(i3);
      if (!bool1) {
        break label521;
      }
    }
    label515:
    label521:
    for (i2 = 1;; i2 = 2)
    {
      localh.e(15308, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), str1, str2, Integer.valueOf(paramInt), Integer.valueOf(i2) });
      AppMethodBeat.o(77810);
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
  
  private static String kB(int paramInt)
  {
    AppMethodBeat.i(77811);
    if (paramInt > 10)
    {
      AppMethodBeat.o(77811);
      return String.valueOf(paramInt);
    }
    String str = "0".concat(String.valueOf(paramInt));
    AppMethodBeat.o(77811);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.au
 * JD-Core Version:    0.7.0.1
 */