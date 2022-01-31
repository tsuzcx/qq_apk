package com.tencent.mm.model;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class as
{
  public static void hO(int paramInt)
  {
    boolean bool2 = a.zQ();
    boolean bool3 = a.zR();
    boolean bool4 = a.zS();
    boolean bool5 = a.zT();
    boolean bool6 = a.zV();
    boolean bool7 = a.zW();
    int i2 = a.zX();
    int i3 = a.zZ();
    int i4 = a.zY();
    int i5 = a.Aa();
    g.DQ();
    boolean bool8 = ((Boolean)g.DP().Dz().get(73217, Boolean.valueOf(true))).booleanValue();
    g.DQ();
    boolean bool9 = ((Boolean)g.DP().Dz().get(73218, Boolean.valueOf(true))).booleanValue();
    boolean bool1;
    h localh;
    int i;
    label284:
    int j;
    label291:
    int k;
    label298:
    int m;
    label306:
    int n;
    label314:
    int i1;
    label322:
    String str1;
    String str2;
    if ((bool8) || (bool9))
    {
      bool1 = true;
      y.i("MicroMsg.KvNotificationStat", "doStatNotification, isNewMsgNotification: %s, isNewVoipMsgNotification: %s, isNotificationShowDetail: %s, isNotificationSound: %s, isNotificationShake: %s, isActiveSilentTime: %s, activeBegin: %s, activeEnd: %s, scene: %s, voipSound: %s, voipAudioSound: %s, voipHasSound: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6), Boolean.valueOf(bool7), hP(i2) + hP(i3), hP(i4) + hP(i5), Integer.valueOf(paramInt), Boolean.valueOf(bool8), Boolean.valueOf(bool9), Boolean.valueOf(bool1) });
      localh = h.nFQ;
      if (!bool2) {
        break label480;
      }
      i = 1;
      if (!bool3) {
        break label485;
      }
      j = 1;
      if (!bool4) {
        break label490;
      }
      k = 1;
      if (!bool5) {
        break label495;
      }
      m = 1;
      if (!bool6) {
        break label501;
      }
      n = 1;
      if (!bool7) {
        break label507;
      }
      i1 = 2;
      str1 = hP(i4) + hP(i5);
      str2 = hP(i2) + hP(i3);
      if (!bool1) {
        break label513;
      }
    }
    label513:
    for (i2 = 1;; i2 = 2)
    {
      localh.f(15308, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), str1, str2, Integer.valueOf(paramInt), Integer.valueOf(i2) });
      return;
      bool1 = false;
      break;
      label480:
      i = 2;
      break label284;
      label485:
      j = 2;
      break label291;
      label490:
      k = 2;
      break label298;
      label495:
      m = 2;
      break label306;
      label501:
      n = 2;
      break label314;
      label507:
      i1 = 1;
      break label322;
    }
  }
  
  private static String hP(int paramInt)
  {
    if (paramInt > 10) {
      return String.valueOf(paramInt);
    }
    return "0" + paramInt;
  }
  
  public static void j(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 2;
    boolean bool2 = a.zQ();
    boolean bool3 = a.zR();
    g.DQ();
    boolean bool4 = ((Boolean)g.DP().Dz().get(73217, Boolean.valueOf(true))).booleanValue();
    g.DQ();
    boolean bool5 = ((Boolean)g.DP().Dz().get(73218, Boolean.valueOf(true))).booleanValue();
    boolean bool1;
    h localh;
    int k;
    label159:
    int m;
    label167:
    int n;
    label175:
    int i;
    if ((bool4) || (bool5))
    {
      bool1 = true;
      y.i("MicroMsg.KvNotificationStat", "doStatSysNotificationAfterModify, switchNewMsg: %s, switchVoipInvite: %s, isNewMsgNotification: %s, isNewVoipMsgNotification: %s, voipSound: %s, voipAudioSound: %s, voipHasSound: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1) });
      localh = h.nFQ;
      if (!bool2) {
        break label276;
      }
      k = 1;
      if (!bool3) {
        break label282;
      }
      m = 1;
      if (!bool1) {
        break label288;
      }
      n = 1;
      if (!paramBoolean1) {
        break label299;
      }
      if (!bool2) {
        break label294;
      }
      i = 2;
      label186:
      if (!paramBoolean2) {
        break label309;
      }
      if (!bool3) {
        break label304;
      }
    }
    for (;;)
    {
      localh.f(14852, new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(0) });
      return;
      bool1 = false;
      break;
      label276:
      k = 0;
      break label159;
      label282:
      m = 0;
      break label167;
      label288:
      n = 0;
      break label175;
      label294:
      i = 1;
      break label186;
      label299:
      i = 0;
      break label186;
      label304:
      j = 1;
      continue;
      label309:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.model.as
 * JD-Core Version:    0.7.0.1
 */