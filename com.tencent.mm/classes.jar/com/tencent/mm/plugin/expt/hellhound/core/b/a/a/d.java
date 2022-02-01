package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.g;
import com.tencent.mm.protocal.protobuf.bg;
import com.tencent.mm.sdk.platformtools.ac;

final class d
  extends a
{
  private static void a(bg parambg)
  {
    AppMethodBeat.i(121981);
    try
    {
      b.o("hell_aty_action_mmkv_key", parambg.toByteArray());
      AppMethodBeat.o(121981);
      return;
    }
    catch (Exception parambg)
    {
      ac.printErrStackTrace("ActivityDao_MMKV", parambg, "habbyge-mali, HellhoundDao writeBack", new Object[0]);
      AppMethodBeat.o(121981);
    }
  }
  
  private static bg cje()
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
        ac.printErrStackTrace("ActivityDao_MMKV", localException, "habbyge-mali, HellhoundDao _doRead parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  final void Ch(int paramInt)
  {
    AppMethodBeat.i(121975);
    bg localbg2 = cje();
    bg localbg1 = localbg2;
    if (localbg2 == null) {
      localbg1 = new bg();
    }
    localbg1.DNW = paramInt;
    a(localbg1);
    AppMethodBeat.o(121975);
  }
  
  final void aa(Activity paramActivity)
  {
    AppMethodBeat.i(121977);
    Object localObject1 = cje();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new bg();
    }
    Object localObject3 = null;
    localObject1 = localObject3;
    if ((paramActivity instanceof FragmentActivity))
    {
      Fragment localFragment = g.ab(paramActivity);
      localObject1 = localObject3;
      if (localFragment != null) {
        localObject1 = localFragment.getClass().getCanonicalName();
      }
    }
    localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = paramActivity.getClass().getCanonicalName();
    }
    ((bg)localObject2).qqh = ((String)localObject3);
    a((bg)localObject2);
    AppMethodBeat.o(121977);
  }
  
  final void aag(String paramString)
  {
    AppMethodBeat.i(121967);
    Object localObject2 = cje();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bg();
    }
    ((bg)localObject1).DNO = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bg)localObject1).DNS = ((String)localObject2);
    a((bg)localObject1);
    AppMethodBeat.o(121967);
  }
  
  final void aah(String paramString)
  {
    AppMethodBeat.i(121969);
    Object localObject2 = cje();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bg();
    }
    ((bg)localObject1).DNP = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bg)localObject1).DNT = ((String)localObject2);
    a((bg)localObject1);
    AppMethodBeat.o(121969);
  }
  
  final void aai(String paramString)
  {
    AppMethodBeat.i(121971);
    Object localObject2 = cje();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bg();
    }
    ((bg)localObject1).DNQ = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bg)localObject1).DNU = ((String)localObject2);
    a((bg)localObject1);
    AppMethodBeat.o(121971);
  }
  
  final void aaj(String paramString)
  {
    AppMethodBeat.i(121973);
    Object localObject2 = cje();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bg();
    }
    ((bg)localObject1).DNR = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bg)localObject1).DNV = ((String)localObject2);
    a((bg)localObject1);
    AppMethodBeat.o(121973);
  }
  
  final boolean aak(String paramString)
  {
    AppMethodBeat.i(121968);
    bg localbg = cje();
    if (localbg == null)
    {
      AppMethodBeat.o(121968);
      return false;
    }
    boolean bool2 = localbg.DNO;
    String str = localbg.DNS;
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
      localbg.DNO = false;
      localbg.DNS = "";
      a(localbg);
    }
    AppMethodBeat.o(121968);
    return bool1;
  }
  
  final boolean aal(String paramString)
  {
    AppMethodBeat.i(121974);
    bg localbg = cje();
    if (localbg == null)
    {
      AppMethodBeat.o(121974);
      return false;
    }
    boolean bool2 = localbg.DNR;
    String str = localbg.DNV;
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        bool1 = bool2;
        if (!str.equals(paramString))
        {
          ac.i("ActivityDao_MMKV", "HABBYGE-MALI, isFinishAction_pause, finishActivityName: %s, pActivityName: %s", new Object[] { str, paramString });
          bool1 = false;
        }
      }
      localbg.DNR = false;
      localbg.DNV = "";
      a(localbg);
    }
    ac.i("ActivityDao_MMKV", "HABBYGE-MALI, isFinishAction_pause, isFinishAction: %s", new Object[] { Boolean.valueOf(bool1) });
    AppMethodBeat.o(121974);
    return bool1;
  }
  
  final void aam(String paramString)
  {
    AppMethodBeat.i(121979);
    bg localbg2 = cje();
    bg localbg1 = localbg2;
    if (localbg2 == null) {
      localbg1 = new bg();
    }
    localbg1.qqh = paramString;
    a(localbg1);
    AppMethodBeat.o(121979);
  }
  
  final void b(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(121978);
    bg localbg = cje();
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
      localbg.qqh = paramString2;
      a(localbg);
      AppMethodBeat.o(121978);
      return;
    }
  }
  
  final int ciY()
  {
    AppMethodBeat.i(121976);
    bg localbg = cje();
    if (localbg == null)
    {
      AppMethodBeat.o(121976);
      return -1;
    }
    int i = localbg.DNW;
    AppMethodBeat.o(121976);
    return i;
  }
  
  final boolean ciZ()
  {
    AppMethodBeat.i(121970);
    bg localbg = cje();
    if (localbg == null)
    {
      AppMethodBeat.o(121970);
      return false;
    }
    boolean bool = localbg.DNP;
    if (bool)
    {
      localbg.DNP = false;
      localbg.DNT = "";
      a(localbg);
    }
    AppMethodBeat.o(121970);
    return bool;
  }
  
  final boolean cja()
  {
    AppMethodBeat.i(121972);
    bg localbg = cje();
    if (localbg == null)
    {
      AppMethodBeat.o(121972);
      return false;
    }
    boolean bool = localbg.DNQ;
    if (bool)
    {
      localbg.DNQ = false;
      localbg.DNU = "";
      a(localbg);
    }
    AppMethodBeat.o(121972);
    return bool;
  }
  
  final String cjb()
  {
    AppMethodBeat.i(121980);
    Object localObject = cje();
    if (localObject == null)
    {
      AppMethodBeat.o(121980);
      return null;
    }
    if (((bg)localObject).qqh.equals(""))
    {
      AppMethodBeat.o(121980);
      return null;
    }
    localObject = ((bg)localObject).qqh;
    AppMethodBeat.o(121980);
    return localObject;
  }
  
  final void reset()
  {
    AppMethodBeat.i(121966);
    ac.i("ActivityDao_MMKV", "habbyge-mali, ActivityDao_MMKV reset");
    b.o("hell_aty_action_mmkv_key", new byte[0]);
    AppMethodBeat.o(121966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */