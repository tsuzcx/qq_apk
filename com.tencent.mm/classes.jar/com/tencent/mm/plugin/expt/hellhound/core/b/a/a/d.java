package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.protocal.protobuf.bg;
import com.tencent.mm.sdk.platformtools.ad;

final class d
  extends a
{
  private static void a(bg parambg)
  {
    AppMethodBeat.i(121981);
    try
    {
      b.p("hell_aty_action_mmkv_key", parambg.toByteArray());
      AppMethodBeat.o(121981);
      return;
    }
    catch (Exception parambg)
    {
      ad.printErrStackTrace("HABBYGE-MALI.ActivityDao_MMKV", parambg, "HellhoundDao writeBack", new Object[0]);
      AppMethodBeat.o(121981);
    }
  }
  
  private static bg coe()
  {
    AppMethodBeat.i(121982);
    byte[] arrayOfByte = b.getBytes("hell_aty_action_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121982);
      return null;
    }
    bg localbg = new bg();
    try
    {
      localbg.parseFrom(arrayOfByte);
      AppMethodBeat.o(121982);
      return localbg;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("HABBYGE-MALI.ActivityDao_MMKV", localException, "HellhoundDao _doRead parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  final void CS(int paramInt)
  {
    AppMethodBeat.i(121975);
    bg localbg2 = coe();
    bg localbg1 = localbg2;
    if (localbg2 == null) {
      localbg1 = new bg();
    }
    localbg1.Ftc = paramInt;
    a(localbg1);
    AppMethodBeat.o(121975);
  }
  
  final void aa(Activity paramActivity)
  {
    AppMethodBeat.i(121977);
    Object localObject1 = coe();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new bg();
    }
    Object localObject3 = null;
    localObject1 = localObject3;
    if ((paramActivity instanceof FragmentActivity))
    {
      Fragment localFragment = h.ab(paramActivity);
      localObject1 = localObject3;
      if (localFragment != null) {
        localObject1 = localFragment.getClass().getCanonicalName();
      }
    }
    localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = paramActivity.getClass().getCanonicalName();
    }
    ((bg)localObject2).qZg = ((String)localObject3);
    a((bg)localObject2);
    AppMethodBeat.o(121977);
  }
  
  final void adT(String paramString)
  {
    AppMethodBeat.i(121967);
    Object localObject2 = coe();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bg();
    }
    ((bg)localObject1).FsU = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bg)localObject1).FsY = ((String)localObject2);
    a((bg)localObject1);
    AppMethodBeat.o(121967);
  }
  
  final void adU(String paramString)
  {
    AppMethodBeat.i(121969);
    Object localObject2 = coe();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bg();
    }
    ((bg)localObject1).FsV = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bg)localObject1).FsZ = ((String)localObject2);
    a((bg)localObject1);
    AppMethodBeat.o(121969);
  }
  
  final void adV(String paramString)
  {
    AppMethodBeat.i(121971);
    Object localObject2 = coe();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bg();
    }
    ((bg)localObject1).FsW = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bg)localObject1).Fta = ((String)localObject2);
    a((bg)localObject1);
    AppMethodBeat.o(121971);
  }
  
  final void adW(String paramString)
  {
    AppMethodBeat.i(121973);
    Object localObject2 = coe();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bg();
    }
    ((bg)localObject1).FsX = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bg)localObject1).Ftb = ((String)localObject2);
    a((bg)localObject1);
    AppMethodBeat.o(121973);
  }
  
  final boolean adX(String paramString)
  {
    AppMethodBeat.i(121968);
    bg localbg = coe();
    if (localbg == null)
    {
      AppMethodBeat.o(121968);
      return false;
    }
    boolean bool2 = localbg.FsU;
    String str = localbg.FsY;
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
      localbg.FsU = false;
      localbg.FsY = "";
      a(localbg);
    }
    AppMethodBeat.o(121968);
    return bool1;
  }
  
  final boolean adY(String paramString)
  {
    AppMethodBeat.i(121974);
    bg localbg = coe();
    if (localbg == null)
    {
      AppMethodBeat.o(121974);
      return false;
    }
    boolean bool2 = localbg.FsX;
    String str = localbg.Ftb;
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        bool1 = bool2;
        if (!str.equals(paramString))
        {
          ad.i("HABBYGE-MALI.ActivityDao_MMKV", "isFinishAction_pause, finishActivityName: %s, pActivityName: %s", new Object[] { str, paramString });
          bool1 = false;
        }
      }
      localbg.FsX = false;
      localbg.Ftb = "";
      a(localbg);
    }
    ad.i("HABBYGE-MALI.ActivityDao_MMKV", "isFinishAction_pause, isFinishAction: %s", new Object[] { Boolean.valueOf(bool1) });
    AppMethodBeat.o(121974);
    return bool1;
  }
  
  final void adZ(String paramString)
  {
    AppMethodBeat.i(121979);
    bg localbg2 = coe();
    bg localbg1 = localbg2;
    if (localbg2 == null) {
      localbg1 = new bg();
    }
    localbg1.qZg = paramString;
    a(localbg1);
    AppMethodBeat.o(121979);
  }
  
  final void b(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(121978);
    bg localbg = coe();
    if (localbg == null) {
      localbg = new bg();
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
      localbg.qZg = paramString2;
      a(localbg);
      AppMethodBeat.o(121978);
      return;
    }
  }
  
  final int cnY()
  {
    AppMethodBeat.i(121976);
    bg localbg = coe();
    if (localbg == null)
    {
      AppMethodBeat.o(121976);
      return -1;
    }
    int i = localbg.Ftc;
    AppMethodBeat.o(121976);
    return i;
  }
  
  final boolean cnZ()
  {
    AppMethodBeat.i(121970);
    bg localbg = coe();
    if (localbg == null)
    {
      AppMethodBeat.o(121970);
      return false;
    }
    boolean bool = localbg.FsV;
    if (bool)
    {
      localbg.FsV = false;
      localbg.FsZ = "";
      a(localbg);
    }
    AppMethodBeat.o(121970);
    return bool;
  }
  
  final boolean coa()
  {
    AppMethodBeat.i(121972);
    bg localbg = coe();
    if (localbg == null)
    {
      AppMethodBeat.o(121972);
      return false;
    }
    boolean bool = localbg.FsW;
    if (bool)
    {
      localbg.FsW = false;
      localbg.Fta = "";
      a(localbg);
    }
    AppMethodBeat.o(121972);
    return bool;
  }
  
  final String cob()
  {
    AppMethodBeat.i(121980);
    Object localObject = coe();
    if (localObject == null)
    {
      AppMethodBeat.o(121980);
      return null;
    }
    if (((bg)localObject).qZg.equals(""))
    {
      AppMethodBeat.o(121980);
      return null;
    }
    localObject = ((bg)localObject).qZg;
    AppMethodBeat.o(121980);
    return localObject;
  }
  
  final void reset()
  {
    AppMethodBeat.i(121966);
    ad.i("HABBYGE-MALI.ActivityDao_MMKV", "ActivityDao_MMKV reset");
    b.p("hell_aty_action_mmkv_key", new byte[0]);
    AppMethodBeat.o(121966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */