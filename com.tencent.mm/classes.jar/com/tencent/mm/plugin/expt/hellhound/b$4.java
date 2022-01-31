package com.tencent.mm.plugin.expt.hellhound;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.expt.hellhound.a.a.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.b;
import com.tencent.mm.plugin.expt.hellhound.a.c.d;
import com.tencent.mm.plugin.expt.hellhound.core.a;
import com.tencent.mm.plugin.expt.hellhound.core.e;
import com.tencent.mm.sdk.platformtools.ab;

final class b$4
  implements b.a
{
  public final void B(Activity paramActivity)
  {
    AppMethodBeat.i(152240);
    if (paramActivity == null)
    {
      AppMethodBeat.o(152240);
      return;
    }
    ab.d("HellhoundService", "habbyge-mali, sActivityListener, finishActivity-1: " + paramActivity.getClass().getName());
    b.brY();
    b.d(paramActivity, 1);
    AppMethodBeat.o(152240);
  }
  
  public final void C(Activity paramActivity)
  {
    AppMethodBeat.i(152242);
    if (paramActivity == null)
    {
      AppMethodBeat.o(152242);
      return;
    }
    ab.d("HellhoundService", "habbyge-mali, sActivityListener, moveActivityTaskToBack: " + paramActivity.getClass().getName());
    b.brY();
    b.d(paramActivity, 1);
    AppMethodBeat.o(152242);
  }
  
  public final void D(Activity paramActivity)
  {
    AppMethodBeat.i(152244);
    String str = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    ab.d("HellhoundService", "habbyge-mali, sActivityListener, onResume: ".concat(String.valueOf(str)));
    c.s(100, str, String.valueOf(i));
    b.brY();
    b.Mu(str);
    d.a(0, str, paramActivity);
    b.d(paramActivity, 0);
    AppMethodBeat.o(152244);
  }
  
  public final void E(Activity paramActivity)
  {
    AppMethodBeat.i(152245);
    if (paramActivity == null)
    {
      AppMethodBeat.o(152245);
      return;
    }
    String str = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    ab.d("HellhoundService", "habbyge-mali, sActivityListener, onPause: ".concat(String.valueOf(str)));
    c.s(101, str, String.valueOf(i));
    d.a(1, str, paramActivity);
    AppMethodBeat.o(152245);
  }
  
  public final void F(Activity paramActivity)
  {
    AppMethodBeat.i(152246);
    if (paramActivity == null)
    {
      AppMethodBeat.o(152246);
      return;
    }
    c.s(102, paramActivity.getClass().getCanonicalName(), String.valueOf(paramActivity.hashCode()));
    AppMethodBeat.o(152246);
  }
  
  public final void G(Activity paramActivity)
  {
    AppMethodBeat.i(152247);
    if (paramActivity == null)
    {
      AppMethodBeat.o(152247);
      return;
    }
    d.a(2, paramActivity.getClass().getCanonicalName(), paramActivity);
    AppMethodBeat.o(152247);
  }
  
  public final void H(Activity paramActivity)
  {
    AppMethodBeat.i(152248);
    ab.i("HellhoundService", "habbyge-mali, onResumed: " + paramActivity.getClass().getCanonicalName());
    a locala = a.brr();
    if (paramActivity != null) {
      locala.lZD.J(paramActivity);
    }
    AppMethodBeat.o(152248);
  }
  
  public final void I(Activity paramActivity)
  {
    AppMethodBeat.i(152249);
    ab.i("HellhoundService", "habbyge-mali, onPaused: " + paramActivity.getClass().getCanonicalName());
    a locala = a.brr();
    if (paramActivity != null) {
      locala.lZD.K(paramActivity);
    }
    AppMethodBeat.o(152249);
  }
  
  public final void Ma(String paramString)
  {
    AppMethodBeat.i(152239);
    ab.d("HellhoundService", "habbyge-mali, sActivityListener, startActivity: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(152239);
  }
  
  public final void b(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(152241);
    if (paramActivity == null)
    {
      AppMethodBeat.o(152241);
      return;
    }
    paramActivity = paramActivity.getClass().getCanonicalName();
    ab.d("HellhoundService", "habbyge-mali, sActivityListener, finishActivity-2: ".concat(String.valueOf(paramActivity)));
    c.s(103, paramActivity, paramString);
    AppMethodBeat.o(152241);
  }
  
  public final void c(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(152243);
    if (paramActivity == null)
    {
      AppMethodBeat.o(152243);
      return;
    }
    paramActivity = paramActivity.getClass().getCanonicalName();
    ab.d("HellhoundService", "habbyge-mali, sActivityListener, moveActivityTaskToBack: ".concat(String.valueOf(paramActivity)));
    c.s(103, paramActivity, paramString);
    AppMethodBeat.o(152243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b.4
 * JD-Core Version:    0.7.0.1
 */