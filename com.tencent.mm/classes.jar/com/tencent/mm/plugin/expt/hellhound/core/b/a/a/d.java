package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.g;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.sdk.platformtools.ad;

final class d
  extends a
{
  private static void a(be parambe)
  {
    AppMethodBeat.i(121981);
    try
    {
      b.o("hell_aty_action_mmkv_key", parambe.toByteArray());
      AppMethodBeat.o(121981);
      return;
    }
    catch (Exception parambe)
    {
      ad.printErrStackTrace("ActivityDao_MMKV", parambe, "habbyge-mali, HellhoundDao writeBack", new Object[0]);
      AppMethodBeat.o(121981);
    }
  }
  
  private static be cbT()
  {
    AppMethodBeat.i(121982);
    byte[] arrayOfByte = b.getBytes("hell_aty_action_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121982);
      return null;
    }
    be localbe = new be();
    try
    {
      localbe.parseFrom(arrayOfByte);
      AppMethodBeat.o(121982);
      return localbe;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("ActivityDao_MMKV", localException, "habbyge-mali, HellhoundDao _doRead parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  final void Bp(int paramInt)
  {
    AppMethodBeat.i(121975);
    be localbe2 = cbT();
    be localbe1 = localbe2;
    if (localbe2 == null) {
      localbe1 = new be();
    }
    localbe1.CvB = paramInt;
    a(localbe1);
    AppMethodBeat.o(121975);
  }
  
  final void VR(String paramString)
  {
    AppMethodBeat.i(121967);
    Object localObject2 = cbT();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new be();
    }
    ((be)localObject1).Cvt = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((be)localObject1).Cvx = ((String)localObject2);
    a((be)localObject1);
    AppMethodBeat.o(121967);
  }
  
  final void VS(String paramString)
  {
    AppMethodBeat.i(121969);
    Object localObject2 = cbT();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new be();
    }
    ((be)localObject1).Cvu = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((be)localObject1).Cvy = ((String)localObject2);
    a((be)localObject1);
    AppMethodBeat.o(121969);
  }
  
  final void VT(String paramString)
  {
    AppMethodBeat.i(121971);
    Object localObject2 = cbT();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new be();
    }
    ((be)localObject1).Cvv = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((be)localObject1).Cvz = ((String)localObject2);
    a((be)localObject1);
    AppMethodBeat.o(121971);
  }
  
  final void VU(String paramString)
  {
    AppMethodBeat.i(121973);
    Object localObject2 = cbT();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new be();
    }
    ((be)localObject1).Cvw = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((be)localObject1).CvA = ((String)localObject2);
    a((be)localObject1);
    AppMethodBeat.o(121973);
  }
  
  final boolean VV(String paramString)
  {
    AppMethodBeat.i(121968);
    be localbe = cbT();
    if (localbe == null)
    {
      AppMethodBeat.o(121968);
      return false;
    }
    boolean bool2 = localbe.Cvt;
    String str = localbe.Cvx;
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        bool1 = bool2;
        if (!str.equals(paramString)) {
          bool1 = false;
        }
      }
      localbe.Cvt = false;
      localbe.Cvx = "";
      a(localbe);
    }
    AppMethodBeat.o(121968);
    return bool1;
  }
  
  final boolean VW(String paramString)
  {
    AppMethodBeat.i(121974);
    be localbe = cbT();
    if (localbe == null)
    {
      AppMethodBeat.o(121974);
      return false;
    }
    boolean bool2 = localbe.Cvw;
    String str = localbe.CvA;
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        bool1 = bool2;
        if (!str.equals(paramString))
        {
          ad.i("ActivityDao_MMKV", "HABBYGE-MALI, isFinishAction_pause, finishActivityName: %s, pActivityName: %s", new Object[] { str, paramString });
          bool1 = false;
        }
      }
      localbe.Cvw = false;
      localbe.CvA = "";
      a(localbe);
    }
    ad.i("ActivityDao_MMKV", "HABBYGE-MALI, isFinishAction_pause, isFinishAction: %s", new Object[] { Boolean.valueOf(bool1) });
    AppMethodBeat.o(121974);
    return bool1;
  }
  
  final void VX(String paramString)
  {
    AppMethodBeat.i(121979);
    be localbe2 = cbT();
    be localbe1 = localbe2;
    if (localbe2 == null) {
      localbe1 = new be();
    }
    localbe1.pHA = paramString;
    a(localbe1);
    AppMethodBeat.o(121979);
  }
  
  final void Z(Activity paramActivity)
  {
    AppMethodBeat.i(121977);
    Object localObject1 = cbT();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new be();
    }
    Object localObject3 = null;
    localObject1 = localObject3;
    if ((paramActivity instanceof FragmentActivity))
    {
      Fragment localFragment = g.aa(paramActivity);
      localObject1 = localObject3;
      if (localFragment != null) {
        localObject1 = localFragment.getClass().getCanonicalName();
      }
    }
    localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = paramActivity.getClass().getCanonicalName();
    }
    ((be)localObject2).pHA = ((String)localObject3);
    a((be)localObject2);
    AppMethodBeat.o(121977);
  }
  
  final void b(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(121978);
    be localbe = cbT();
    if (localbe == null) {
      localbe = new be();
    }
    for (;;)
    {
      String str = null;
      if (paramBoolean) {
        str = paramString2;
      }
      paramString2 = str;
      if (str == null) {
        paramString2 = paramString1.getClass().getCanonicalName();
      }
      localbe.pHA = paramString2;
      a(localbe);
      AppMethodBeat.o(121978);
      return;
    }
  }
  
  final int cbN()
  {
    AppMethodBeat.i(121976);
    be localbe = cbT();
    if (localbe == null)
    {
      AppMethodBeat.o(121976);
      return -1;
    }
    int i = localbe.CvB;
    AppMethodBeat.o(121976);
    return i;
  }
  
  final boolean cbO()
  {
    AppMethodBeat.i(121970);
    be localbe = cbT();
    if (localbe == null)
    {
      AppMethodBeat.o(121970);
      return false;
    }
    boolean bool = localbe.Cvu;
    if (bool)
    {
      localbe.Cvu = false;
      localbe.Cvy = "";
      a(localbe);
    }
    AppMethodBeat.o(121970);
    return bool;
  }
  
  final boolean cbP()
  {
    AppMethodBeat.i(121972);
    be localbe = cbT();
    if (localbe == null)
    {
      AppMethodBeat.o(121972);
      return false;
    }
    boolean bool = localbe.Cvv;
    if (bool)
    {
      localbe.Cvv = false;
      localbe.Cvz = "";
      a(localbe);
    }
    AppMethodBeat.o(121972);
    return bool;
  }
  
  final String cbQ()
  {
    AppMethodBeat.i(121980);
    Object localObject = cbT();
    if (localObject == null)
    {
      AppMethodBeat.o(121980);
      return null;
    }
    if (((be)localObject).pHA.equals(""))
    {
      AppMethodBeat.o(121980);
      return null;
    }
    localObject = ((be)localObject).pHA;
    AppMethodBeat.o(121980);
    return localObject;
  }
  
  final void reset()
  {
    AppMethodBeat.i(121966);
    ad.i("ActivityDao_MMKV", "habbyge-mali, ActivityDao_MMKV reset");
    b.o("hell_aty_action_mmkv_key", new byte[0]);
    AppMethodBeat.o(121966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */