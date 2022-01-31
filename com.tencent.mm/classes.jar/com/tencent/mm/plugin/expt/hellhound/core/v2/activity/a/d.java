package com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.plugin.expt.hellhound.core.v2.a.f;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.sdk.platformtools.ab;

final class d
  extends a
{
  private static void a(bb parambb)
  {
    AppMethodBeat.i(73440);
    try
    {
      b.v("hell_aty_action_mmkv_key", parambb.toByteArray());
      AppMethodBeat.o(73440);
      return;
    }
    catch (Exception parambb)
    {
      ab.printErrStackTrace("ActivityDao_MMKV", parambb, "habbyge-mali, HellhoundDao writeBack", new Object[0]);
      AppMethodBeat.o(73440);
    }
  }
  
  private static bb brP()
  {
    AppMethodBeat.i(73441);
    byte[] arrayOfByte = b.getBytes("hell_aty_action_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(73441);
      return null;
    }
    bb localbb = new bb();
    try
    {
      localbb.parseFrom(arrayOfByte);
      AppMethodBeat.o(73441);
      return localbb;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("ActivityDao_MMKV", localException, "habbyge-mali, HellhoundDao _doRead parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  final void Mi(String paramString)
  {
    AppMethodBeat.i(73432);
    Object localObject2 = brP();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bb();
    }
    ((bb)localObject1).wne = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bb)localObject1).wni = ((String)localObject2);
    a((bb)localObject1);
    AppMethodBeat.o(73432);
  }
  
  final void Mj(String paramString)
  {
    AppMethodBeat.i(73436);
    Object localObject2 = brP();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bb();
    }
    ((bb)localObject1).wng = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bb)localObject1).wnk = ((String)localObject2);
    a((bb)localObject1);
    AppMethodBeat.o(73436);
  }
  
  final void Mk(String paramString)
  {
    AppMethodBeat.i(73430);
    Object localObject2 = brP();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bb();
    }
    ((bb)localObject1).wnd = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bb)localObject1).wnh = ((String)localObject2);
    a((bb)localObject1);
    AppMethodBeat.o(73430);
  }
  
  final boolean Ml(String paramString)
  {
    AppMethodBeat.i(73431);
    bb localbb = brP();
    if (localbb == null)
    {
      AppMethodBeat.o(73431);
      return false;
    }
    boolean bool2 = localbb.wnd;
    String str = localbb.wnh;
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
      localbb.wnd = false;
      localbb.wnh = "";
      a(localbb);
    }
    AppMethodBeat.o(73431);
    return bool1;
  }
  
  final void Mm(String paramString)
  {
    AppMethodBeat.i(73434);
    ab.i("ActivityDao_MMKV", "habbyge-mali, ActivityDao, setStartActivityAction_pause: ".concat(String.valueOf(paramString)));
    Object localObject2 = brP();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bb();
    }
    ((bb)localObject1).wnf = true;
    localObject2 = paramString;
    if (paramString == null) {
      localObject2 = "";
    }
    ((bb)localObject1).wnj = ((String)localObject2);
    a((bb)localObject1);
    AppMethodBeat.o(73434);
  }
  
  final boolean Mn(String paramString)
  {
    AppMethodBeat.i(73435);
    ab.i("ActivityDao_MMKV", "habbyge-mali, isStartActivityAction_pause: ".concat(String.valueOf(paramString)));
    paramString = brP();
    if (paramString == null)
    {
      AppMethodBeat.o(73435);
      return false;
    }
    boolean bool = paramString.wnf;
    if (bool)
    {
      paramString.wnf = false;
      paramString.wnj = "";
      a(paramString);
    }
    AppMethodBeat.o(73435);
    return bool;
  }
  
  final boolean Mo(String paramString)
  {
    AppMethodBeat.i(73437);
    bb localbb = brP();
    if (localbb == null)
    {
      AppMethodBeat.o(73437);
      return false;
    }
    boolean bool2 = localbb.wng;
    String str = localbb.wnk;
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
      localbb.wng = false;
      localbb.wnk = "";
      a(localbb);
    }
    AppMethodBeat.o(73437);
    return bool1;
  }
  
  final void Mp(String paramString)
  {
    AppMethodBeat.i(152282);
    bb localbb2 = brP();
    bb localbb1 = localbb2;
    if (localbb2 == null) {
      localbb1 = new bb();
    }
    localbb1.mba = paramString;
    ab.w("ActivityDao_MMKV", "habbyge-mali, setActivityJumpSrc: " + localbb1.mba);
    a(localbb1);
    AppMethodBeat.o(152282);
  }
  
  final void Q(Activity paramActivity)
  {
    AppMethodBeat.i(152281);
    bb localbb = brP();
    if (localbb == null) {
      localbb = new bb();
    }
    for (;;)
    {
      if ((paramActivity instanceof FragmentActivity))
      {
        localObject1 = f.b((FragmentActivity)paramActivity);
        if (localObject1 == null) {}
      }
      for (Object localObject1 = localObject1.getClass().getCanonicalName();; localObject1 = null)
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = paramActivity.getClass().getCanonicalName();
        }
        localbb.mba = ((String)localObject2);
        ab.w("ActivityDao_MMKV", "habbyge-mali, setActivityJumpSrc: " + localbb.mba);
        a(localbb);
        AppMethodBeat.o(152281);
        return;
      }
    }
  }
  
  final int brJ()
  {
    AppMethodBeat.i(73439);
    bb localbb = brP();
    if (localbb == null)
    {
      AppMethodBeat.o(73439);
      return -1;
    }
    int i = localbb.wnl;
    AppMethodBeat.o(73439);
    return i;
  }
  
  final boolean brL()
  {
    AppMethodBeat.i(73433);
    bb localbb = brP();
    if (localbb == null)
    {
      AppMethodBeat.o(73433);
      return false;
    }
    boolean bool = localbb.wne;
    if (bool)
    {
      localbb.wne = false;
      localbb.wni = "";
      a(localbb);
    }
    AppMethodBeat.o(73433);
    return bool;
  }
  
  final String brM()
  {
    AppMethodBeat.i(152283);
    Object localObject = brP();
    if (localObject == null)
    {
      AppMethodBeat.o(152283);
      return null;
    }
    localObject = ((bb)localObject).mba;
    AppMethodBeat.o(152283);
    return localObject;
  }
  
  final void reset()
  {
    AppMethodBeat.i(73429);
    ab.i("ActivityDao_MMKV", "habbyge-mali, ActivityDao_MMKV reset");
    b.v("hell_aty_action_mmkv_key", new byte[0]);
    AppMethodBeat.o(73429);
  }
  
  final void vm(int paramInt)
  {
    AppMethodBeat.i(73438);
    bb localbb2 = brP();
    bb localbb1 = localbb2;
    if (localbb2 == null) {
      localbb1 = new bb();
    }
    localbb1.wnl = paramInt;
    a(localbb1);
    AppMethodBeat.o(73438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.d
 * JD-Core Version:    0.7.0.1
 */