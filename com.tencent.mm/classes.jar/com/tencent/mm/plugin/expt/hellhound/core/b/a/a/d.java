package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.sdk.platformtools.Log;

final class d
  extends a
{
  private static void a(bn parambn)
  {
    AppMethodBeat.i(121981);
    try
    {
      b.u("hell_aty_action_mmkv_key", parambn.toByteArray());
      AppMethodBeat.o(121981);
      return;
    }
    catch (Exception parambn)
    {
      Log.printErrStackTrace("HABBYGE-MALI.ActivityDao_MMKV", parambn, "HellhoundDao writeBack", new Object[0]);
      AppMethodBeat.o(121981);
    }
  }
  
  private static bn dJt()
  {
    AppMethodBeat.i(121982);
    byte[] arrayOfByte = b.ard("hell_aty_action_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121982);
      return null;
    }
    bn localbn = new bn();
    try
    {
      localbn.parseFrom(arrayOfByte);
      AppMethodBeat.o(121982);
      return localbn;
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
  
  final void LA(int paramInt)
  {
    AppMethodBeat.i(121975);
    bn localbn2 = dJt();
    bn localbn1 = localbn2;
    if (localbn2 == null) {
      localbn1 = new bn();
    }
    localbn1.YDg = paramInt;
    a(localbn1);
    AppMethodBeat.o(121975);
  }
  
  final void aj(Activity paramActivity)
  {
    AppMethodBeat.i(121977);
    Object localObject1 = dJt();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new bn();
    }
    Object localObject3 = null;
    localObject1 = localObject3;
    if ((paramActivity instanceof FragmentActivity))
    {
      Fragment localFragment = h.ak(paramActivity);
      localObject1 = localObject3;
      if (localFragment != null) {
        localObject1 = localFragment.getClass().getCanonicalName();
      }
    }
    localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = paramActivity.getClass().getCanonicalName();
    }
    ((bn)localObject2).zKK = ((String)localObject3);
    a((bn)localObject2);
    AppMethodBeat.o(121977);
  }
  
  final void arh(String paramString)
  {
    AppMethodBeat.i(121967);
    Object localObject2 = dJt();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bn();
    }
    ((bn)localObject1).YCY = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bn)localObject1).YDc = ((String)localObject2);
    a((bn)localObject1);
    AppMethodBeat.o(121967);
  }
  
  final void ari(String paramString)
  {
    AppMethodBeat.i(121969);
    Object localObject2 = dJt();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bn();
    }
    ((bn)localObject1).YCZ = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bn)localObject1).YDd = ((String)localObject2);
    a((bn)localObject1);
    AppMethodBeat.o(121969);
  }
  
  final void arj(String paramString)
  {
    AppMethodBeat.i(121971);
    Object localObject2 = dJt();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bn();
    }
    ((bn)localObject1).YDa = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bn)localObject1).YDe = ((String)localObject2);
    a((bn)localObject1);
    AppMethodBeat.o(121971);
  }
  
  final void ark(String paramString)
  {
    AppMethodBeat.i(121973);
    Object localObject2 = dJt();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bn();
    }
    ((bn)localObject1).YDb = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bn)localObject1).YDf = ((String)localObject2);
    a((bn)localObject1);
    AppMethodBeat.o(121973);
  }
  
  final boolean arl(String paramString)
  {
    AppMethodBeat.i(121968);
    bn localbn = dJt();
    if (localbn == null)
    {
      AppMethodBeat.o(121968);
      return false;
    }
    boolean bool2 = localbn.YCY;
    String str = localbn.YDc;
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
      localbn.YCY = false;
      localbn.YDc = "";
      a(localbn);
    }
    AppMethodBeat.o(121968);
    return bool1;
  }
  
  final boolean arm(String paramString)
  {
    AppMethodBeat.i(121974);
    bn localbn = dJt();
    if (localbn == null)
    {
      AppMethodBeat.o(121974);
      return false;
    }
    boolean bool2 = localbn.YDb;
    String str = localbn.YDf;
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
      localbn.YDb = false;
      localbn.YDf = "";
      a(localbn);
    }
    Log.i("HABBYGE-MALI.ActivityDao_MMKV", "isFinishAction_pause, isFinishAction: %s", new Object[] { Boolean.valueOf(bool1) });
    AppMethodBeat.o(121974);
    return bool1;
  }
  
  final void arn(String paramString)
  {
    AppMethodBeat.i(121979);
    bn localbn2 = dJt();
    bn localbn1 = localbn2;
    if (localbn2 == null) {
      localbn1 = new bn();
    }
    localbn1.zKK = paramString;
    a(localbn1);
    AppMethodBeat.o(121979);
  }
  
  final void d(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(121978);
    bn localbn = dJt();
    if (localbn == null) {
      localbn = new bn();
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
      localbn.zKK = paramString2;
      a(localbn);
      AppMethodBeat.o(121978);
      return;
    }
  }
  
  final int dJn()
  {
    AppMethodBeat.i(121976);
    bn localbn = dJt();
    if (localbn == null)
    {
      AppMethodBeat.o(121976);
      return -1;
    }
    int i = localbn.YDg;
    AppMethodBeat.o(121976);
    return i;
  }
  
  final boolean dJo()
  {
    AppMethodBeat.i(121970);
    bn localbn = dJt();
    if (localbn == null)
    {
      AppMethodBeat.o(121970);
      return false;
    }
    boolean bool = localbn.YCZ;
    if (bool)
    {
      localbn.YCZ = false;
      localbn.YDd = "";
      a(localbn);
    }
    AppMethodBeat.o(121970);
    return bool;
  }
  
  final boolean dJp()
  {
    AppMethodBeat.i(121972);
    bn localbn = dJt();
    if (localbn == null)
    {
      AppMethodBeat.o(121972);
      return false;
    }
    boolean bool = localbn.YDa;
    if (bool)
    {
      localbn.YDa = false;
      localbn.YDe = "";
      a(localbn);
    }
    AppMethodBeat.o(121972);
    return bool;
  }
  
  final String dJq()
  {
    AppMethodBeat.i(121980);
    Object localObject = dJt();
    if (localObject == null)
    {
      AppMethodBeat.o(121980);
      return null;
    }
    if (((bn)localObject).zKK.equals(""))
    {
      AppMethodBeat.o(121980);
      return null;
    }
    localObject = ((bn)localObject).zKK;
    AppMethodBeat.o(121980);
    return localObject;
  }
  
  final void reset()
  {
    AppMethodBeat.i(121966);
    Log.i("HABBYGE-MALI.ActivityDao_MMKV", "ActivityDao_MMKV reset");
    b.u("hell_aty_action_mmkv_key", new byte[0]);
    AppMethodBeat.o(121966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */