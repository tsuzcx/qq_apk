package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.protocal.protobuf.bg;
import com.tencent.mm.sdk.platformtools.ae;

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
      ae.printErrStackTrace("HABBYGE-MALI.ActivityDao_MMKV", parambg, "HellhoundDao writeBack", new Object[0]);
      AppMethodBeat.o(121981);
    }
  }
  
  private static bg cpG()
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
        ae.printErrStackTrace("HABBYGE-MALI.ActivityDao_MMKV", localException, "HellhoundDao _doRead parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  final void Df(int paramInt)
  {
    AppMethodBeat.i(121975);
    bg localbg2 = cpG();
    bg localbg1 = localbg2;
    if (localbg2 == null) {
      localbg1 = new bg();
    }
    localbg1.FLA = paramInt;
    a(localbg1);
    AppMethodBeat.o(121975);
  }
  
  final void ab(Activity paramActivity)
  {
    AppMethodBeat.i(121977);
    Object localObject1 = cpG();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new bg();
    }
    Object localObject3 = null;
    localObject1 = localObject3;
    if ((paramActivity instanceof FragmentActivity))
    {
      Fragment localFragment = h.ac(paramActivity);
      localObject1 = localObject3;
      if (localFragment != null) {
        localObject1 = localFragment.getClass().getCanonicalName();
      }
    }
    localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = paramActivity.getClass().getCanonicalName();
    }
    ((bg)localObject2).rhm = ((String)localObject3);
    a((bg)localObject2);
    AppMethodBeat.o(121977);
  }
  
  final void aeN(String paramString)
  {
    AppMethodBeat.i(121967);
    Object localObject2 = cpG();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bg();
    }
    ((bg)localObject1).FLs = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bg)localObject1).FLw = ((String)localObject2);
    a((bg)localObject1);
    AppMethodBeat.o(121967);
  }
  
  final void aeO(String paramString)
  {
    AppMethodBeat.i(121969);
    Object localObject2 = cpG();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bg();
    }
    ((bg)localObject1).FLt = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bg)localObject1).FLx = ((String)localObject2);
    a((bg)localObject1);
    AppMethodBeat.o(121969);
  }
  
  final void aeP(String paramString)
  {
    AppMethodBeat.i(121971);
    Object localObject2 = cpG();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bg();
    }
    ((bg)localObject1).FLu = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bg)localObject1).FLy = ((String)localObject2);
    a((bg)localObject1);
    AppMethodBeat.o(121971);
  }
  
  final void aeQ(String paramString)
  {
    AppMethodBeat.i(121973);
    Object localObject2 = cpG();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bg();
    }
    ((bg)localObject1).FLv = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bg)localObject1).FLz = ((String)localObject2);
    a((bg)localObject1);
    AppMethodBeat.o(121973);
  }
  
  final boolean aeR(String paramString)
  {
    AppMethodBeat.i(121968);
    bg localbg = cpG();
    if (localbg == null)
    {
      AppMethodBeat.o(121968);
      return false;
    }
    boolean bool2 = localbg.FLs;
    String str = localbg.FLw;
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
      localbg.FLs = false;
      localbg.FLw = "";
      a(localbg);
    }
    AppMethodBeat.o(121968);
    return bool1;
  }
  
  final boolean aeS(String paramString)
  {
    AppMethodBeat.i(121974);
    bg localbg = cpG();
    if (localbg == null)
    {
      AppMethodBeat.o(121974);
      return false;
    }
    boolean bool2 = localbg.FLv;
    String str = localbg.FLz;
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        bool1 = bool2;
        if (!str.equals(paramString))
        {
          ae.i("HABBYGE-MALI.ActivityDao_MMKV", "isFinishAction_pause, finishActivityName: %s, pActivityName: %s", new Object[] { str, paramString });
          bool1 = false;
        }
      }
      localbg.FLv = false;
      localbg.FLz = "";
      a(localbg);
    }
    ae.i("HABBYGE-MALI.ActivityDao_MMKV", "isFinishAction_pause, isFinishAction: %s", new Object[] { Boolean.valueOf(bool1) });
    AppMethodBeat.o(121974);
    return bool1;
  }
  
  final void aeT(String paramString)
  {
    AppMethodBeat.i(121979);
    bg localbg2 = cpG();
    bg localbg1 = localbg2;
    if (localbg2 == null) {
      localbg1 = new bg();
    }
    localbg1.rhm = paramString;
    a(localbg1);
    AppMethodBeat.o(121979);
  }
  
  final void b(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(121978);
    bg localbg = cpG();
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
      localbg.rhm = paramString2;
      a(localbg);
      AppMethodBeat.o(121978);
      return;
    }
  }
  
  final int cpA()
  {
    AppMethodBeat.i(121976);
    bg localbg = cpG();
    if (localbg == null)
    {
      AppMethodBeat.o(121976);
      return -1;
    }
    int i = localbg.FLA;
    AppMethodBeat.o(121976);
    return i;
  }
  
  final boolean cpB()
  {
    AppMethodBeat.i(121970);
    bg localbg = cpG();
    if (localbg == null)
    {
      AppMethodBeat.o(121970);
      return false;
    }
    boolean bool = localbg.FLt;
    if (bool)
    {
      localbg.FLt = false;
      localbg.FLx = "";
      a(localbg);
    }
    AppMethodBeat.o(121970);
    return bool;
  }
  
  final boolean cpC()
  {
    AppMethodBeat.i(121972);
    bg localbg = cpG();
    if (localbg == null)
    {
      AppMethodBeat.o(121972);
      return false;
    }
    boolean bool = localbg.FLu;
    if (bool)
    {
      localbg.FLu = false;
      localbg.FLy = "";
      a(localbg);
    }
    AppMethodBeat.o(121972);
    return bool;
  }
  
  final String cpD()
  {
    AppMethodBeat.i(121980);
    Object localObject = cpG();
    if (localObject == null)
    {
      AppMethodBeat.o(121980);
      return null;
    }
    if (((bg)localObject).rhm.equals(""))
    {
      AppMethodBeat.o(121980);
      return null;
    }
    localObject = ((bg)localObject).rhm;
    AppMethodBeat.o(121980);
    return localObject;
  }
  
  final void reset()
  {
    AppMethodBeat.i(121966);
    ae.i("HABBYGE-MALI.ActivityDao_MMKV", "ActivityDao_MMKV reset");
    b.p("hell_aty_action_mmkv_key", new byte[0]);
    AppMethodBeat.o(121966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */