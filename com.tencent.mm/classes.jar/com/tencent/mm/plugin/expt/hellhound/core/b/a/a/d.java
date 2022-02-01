package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.protocal.protobuf.bk;
import com.tencent.mm.sdk.platformtools.Log;

final class d
  extends a
{
  private static void a(bk parambk)
  {
    AppMethodBeat.i(121981);
    try
    {
      b.o("hell_aty_action_mmkv_key", parambk.toByteArray());
      AppMethodBeat.o(121981);
      return;
    }
    catch (Exception parambk)
    {
      Log.printErrStackTrace("HABBYGE-MALI.ActivityDao_MMKV", parambk, "HellhoundDao writeBack", new Object[0]);
      AppMethodBeat.o(121981);
    }
  }
  
  private static bk cNZ()
  {
    AppMethodBeat.i(121982);
    byte[] arrayOfByte = b.getBytes("hell_aty_action_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121982);
      return null;
    }
    bk localbk = new bk();
    try
    {
      localbk.parseFrom(arrayOfByte);
      AppMethodBeat.o(121982);
      return localbk;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("HABBYGE-MALI.ActivityDao_MMKV", localException, "HellhoundDao _doRead parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  final void GQ(int paramInt)
  {
    AppMethodBeat.i(121975);
    bk localbk2 = cNZ();
    bk localbk1 = localbk2;
    if (localbk2 == null) {
      localbk1 = new bk();
    }
    localbk1.KFb = paramInt;
    a(localbk1);
    AppMethodBeat.o(121975);
  }
  
  final void Z(Activity paramActivity)
  {
    AppMethodBeat.i(121977);
    Object localObject1 = cNZ();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new bk();
    }
    Object localObject3 = null;
    localObject1 = localObject3;
    if ((paramActivity instanceof FragmentActivity))
    {
      Fragment localFragment = h.aa(paramActivity);
      localObject1 = localObject3;
      if (localFragment != null) {
        localObject1 = localFragment.getClass().getCanonicalName();
      }
    }
    localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = paramActivity.getClass().getCanonicalName();
    }
    ((bk)localObject2).sII = ((String)localObject3);
    a((bk)localObject2);
    AppMethodBeat.o(121977);
  }
  
  final void apd(String paramString)
  {
    AppMethodBeat.i(121967);
    Object localObject2 = cNZ();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bk();
    }
    ((bk)localObject1).KES = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bk)localObject1).KEW = ((String)localObject2);
    a((bk)localObject1);
    AppMethodBeat.o(121967);
  }
  
  final void ape(String paramString)
  {
    AppMethodBeat.i(121969);
    Object localObject2 = cNZ();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bk();
    }
    ((bk)localObject1).KET = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bk)localObject1).KEX = ((String)localObject2);
    a((bk)localObject1);
    AppMethodBeat.o(121969);
  }
  
  final void apf(String paramString)
  {
    AppMethodBeat.i(121971);
    Object localObject2 = cNZ();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bk();
    }
    ((bk)localObject1).KEU = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bk)localObject1).KEZ = ((String)localObject2);
    a((bk)localObject1);
    AppMethodBeat.o(121971);
  }
  
  final void apg(String paramString)
  {
    AppMethodBeat.i(121973);
    Object localObject2 = cNZ();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bk();
    }
    ((bk)localObject1).KEV = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bk)localObject1).KFa = ((String)localObject2);
    a((bk)localObject1);
    AppMethodBeat.o(121973);
  }
  
  final boolean aph(String paramString)
  {
    AppMethodBeat.i(121968);
    bk localbk = cNZ();
    if (localbk == null)
    {
      AppMethodBeat.o(121968);
      return false;
    }
    boolean bool2 = localbk.KES;
    String str = localbk.KEW;
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
      localbk.KES = false;
      localbk.KEW = "";
      a(localbk);
    }
    AppMethodBeat.o(121968);
    return bool1;
  }
  
  final boolean api(String paramString)
  {
    AppMethodBeat.i(121974);
    bk localbk = cNZ();
    if (localbk == null)
    {
      AppMethodBeat.o(121974);
      return false;
    }
    boolean bool2 = localbk.KEV;
    String str = localbk.KFa;
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        bool1 = bool2;
        if (!str.equals(paramString))
        {
          Log.i("HABBYGE-MALI.ActivityDao_MMKV", "isFinishAction_pause, finishActivityName: %s, pActivityName: %s", new Object[] { str, paramString });
          bool1 = false;
        }
      }
      localbk.KEV = false;
      localbk.KFa = "";
      a(localbk);
    }
    Log.i("HABBYGE-MALI.ActivityDao_MMKV", "isFinishAction_pause, isFinishAction: %s", new Object[] { Boolean.valueOf(bool1) });
    AppMethodBeat.o(121974);
    return bool1;
  }
  
  final void apj(String paramString)
  {
    AppMethodBeat.i(121979);
    bk localbk2 = cNZ();
    bk localbk1 = localbk2;
    if (localbk2 == null) {
      localbk1 = new bk();
    }
    localbk1.sII = paramString;
    a(localbk1);
    AppMethodBeat.o(121979);
  }
  
  final void b(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(121978);
    bk localbk = cNZ();
    if (localbk == null) {
      localbk = new bk();
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
      localbk.sII = paramString2;
      a(localbk);
      AppMethodBeat.o(121978);
      return;
    }
  }
  
  final int cNT()
  {
    AppMethodBeat.i(121976);
    bk localbk = cNZ();
    if (localbk == null)
    {
      AppMethodBeat.o(121976);
      return -1;
    }
    int i = localbk.KFb;
    AppMethodBeat.o(121976);
    return i;
  }
  
  final boolean cNU()
  {
    AppMethodBeat.i(121970);
    bk localbk = cNZ();
    if (localbk == null)
    {
      AppMethodBeat.o(121970);
      return false;
    }
    boolean bool = localbk.KET;
    if (bool)
    {
      localbk.KET = false;
      localbk.KEX = "";
      a(localbk);
    }
    AppMethodBeat.o(121970);
    return bool;
  }
  
  final boolean cNV()
  {
    AppMethodBeat.i(121972);
    bk localbk = cNZ();
    if (localbk == null)
    {
      AppMethodBeat.o(121972);
      return false;
    }
    boolean bool = localbk.KEU;
    if (bool)
    {
      localbk.KEU = false;
      localbk.KEZ = "";
      a(localbk);
    }
    AppMethodBeat.o(121972);
    return bool;
  }
  
  final String cNW()
  {
    AppMethodBeat.i(121980);
    Object localObject = cNZ();
    if (localObject == null)
    {
      AppMethodBeat.o(121980);
      return null;
    }
    if (((bk)localObject).sII.equals(""))
    {
      AppMethodBeat.o(121980);
      return null;
    }
    localObject = ((bk)localObject).sII;
    AppMethodBeat.o(121980);
    return localObject;
  }
  
  final void reset()
  {
    AppMethodBeat.i(121966);
    Log.i("HABBYGE-MALI.ActivityDao_MMKV", "ActivityDao_MMKV reset");
    b.o("hell_aty_action_mmkv_key", new byte[0]);
    AppMethodBeat.o(121966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */