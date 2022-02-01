package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.protocal.protobuf.bi;
import com.tencent.mm.sdk.platformtools.Log;

final class d
  extends a
{
  private static void a(bi parambi)
  {
    AppMethodBeat.i(121981);
    try
    {
      b.r("hell_aty_action_mmkv_key", parambi.toByteArray());
      AppMethodBeat.o(121981);
      return;
    }
    catch (Exception parambi)
    {
      Log.printErrStackTrace("HABBYGE-MALI.ActivityDao_MMKV", parambi, "HellhoundDao writeBack", new Object[0]);
      AppMethodBeat.o(121981);
    }
  }
  
  private static bi dcR()
  {
    AppMethodBeat.i(121982);
    byte[] arrayOfByte = b.awZ("hell_aty_action_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121982);
      return null;
    }
    bi localbi = new bi();
    try
    {
      localbi.parseFrom(arrayOfByte);
      AppMethodBeat.o(121982);
      return localbi;
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
  
  final void KA(int paramInt)
  {
    AppMethodBeat.i(121975);
    bi localbi2 = dcR();
    bi localbi1 = localbi2;
    if (localbi2 == null) {
      localbi1 = new bi();
    }
    localbi1.RGs = paramInt;
    a(localbi1);
    AppMethodBeat.o(121975);
  }
  
  final void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(121978);
    bi localbi = dcR();
    if (localbi == null) {
      localbi = new bi();
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
      localbi.woF = paramString2;
      a(localbi);
      AppMethodBeat.o(121978);
      return;
    }
  }
  
  final void aa(Activity paramActivity)
  {
    AppMethodBeat.i(121977);
    Object localObject1 = dcR();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new bi();
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
    ((bi)localObject2).woF = ((String)localObject3);
    a((bi)localObject2);
    AppMethodBeat.o(121977);
  }
  
  final void axd(String paramString)
  {
    AppMethodBeat.i(121967);
    Object localObject2 = dcR();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bi();
    }
    ((bi)localObject1).RGk = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bi)localObject1).RGo = ((String)localObject2);
    a((bi)localObject1);
    AppMethodBeat.o(121967);
  }
  
  final void axe(String paramString)
  {
    AppMethodBeat.i(121969);
    Object localObject2 = dcR();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bi();
    }
    ((bi)localObject1).RGl = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bi)localObject1).RGp = ((String)localObject2);
    a((bi)localObject1);
    AppMethodBeat.o(121969);
  }
  
  final void axf(String paramString)
  {
    AppMethodBeat.i(121971);
    Object localObject2 = dcR();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bi();
    }
    ((bi)localObject1).RGm = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bi)localObject1).RGq = ((String)localObject2);
    a((bi)localObject1);
    AppMethodBeat.o(121971);
  }
  
  final void axg(String paramString)
  {
    AppMethodBeat.i(121973);
    Object localObject2 = dcR();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bi();
    }
    ((bi)localObject1).RGn = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bi)localObject1).RGr = ((String)localObject2);
    a((bi)localObject1);
    AppMethodBeat.o(121973);
  }
  
  final boolean axh(String paramString)
  {
    AppMethodBeat.i(121968);
    bi localbi = dcR();
    if (localbi == null)
    {
      AppMethodBeat.o(121968);
      return false;
    }
    boolean bool2 = localbi.RGk;
    String str = localbi.RGo;
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
      localbi.RGk = false;
      localbi.RGo = "";
      a(localbi);
    }
    AppMethodBeat.o(121968);
    return bool1;
  }
  
  final boolean axi(String paramString)
  {
    AppMethodBeat.i(121974);
    bi localbi = dcR();
    if (localbi == null)
    {
      AppMethodBeat.o(121974);
      return false;
    }
    boolean bool2 = localbi.RGn;
    String str = localbi.RGr;
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
      localbi.RGn = false;
      localbi.RGr = "";
      a(localbi);
    }
    Log.i("HABBYGE-MALI.ActivityDao_MMKV", "isFinishAction_pause, isFinishAction: %s", new Object[] { Boolean.valueOf(bool1) });
    AppMethodBeat.o(121974);
    return bool1;
  }
  
  final void axj(String paramString)
  {
    AppMethodBeat.i(121979);
    bi localbi2 = dcR();
    bi localbi1 = localbi2;
    if (localbi2 == null) {
      localbi1 = new bi();
    }
    localbi1.woF = paramString;
    a(localbi1);
    AppMethodBeat.o(121979);
  }
  
  final int dcL()
  {
    AppMethodBeat.i(121976);
    bi localbi = dcR();
    if (localbi == null)
    {
      AppMethodBeat.o(121976);
      return -1;
    }
    int i = localbi.RGs;
    AppMethodBeat.o(121976);
    return i;
  }
  
  final boolean dcM()
  {
    AppMethodBeat.i(121970);
    bi localbi = dcR();
    if (localbi == null)
    {
      AppMethodBeat.o(121970);
      return false;
    }
    boolean bool = localbi.RGl;
    if (bool)
    {
      localbi.RGl = false;
      localbi.RGp = "";
      a(localbi);
    }
    AppMethodBeat.o(121970);
    return bool;
  }
  
  final boolean dcN()
  {
    AppMethodBeat.i(121972);
    bi localbi = dcR();
    if (localbi == null)
    {
      AppMethodBeat.o(121972);
      return false;
    }
    boolean bool = localbi.RGm;
    if (bool)
    {
      localbi.RGm = false;
      localbi.RGq = "";
      a(localbi);
    }
    AppMethodBeat.o(121972);
    return bool;
  }
  
  final String dcO()
  {
    AppMethodBeat.i(121980);
    Object localObject = dcR();
    if (localObject == null)
    {
      AppMethodBeat.o(121980);
      return null;
    }
    if (((bi)localObject).woF.equals(""))
    {
      AppMethodBeat.o(121980);
      return null;
    }
    localObject = ((bi)localObject).woF;
    AppMethodBeat.o(121980);
    return localObject;
  }
  
  final void reset()
  {
    AppMethodBeat.i(121966);
    Log.i("HABBYGE-MALI.ActivityDao_MMKV", "ActivityDao_MMKV reset");
    b.r("hell_aty_action_mmkv_key", new byte[0]);
    AppMethodBeat.o(121966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */