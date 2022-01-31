package com.tencent.mm.kernel.b;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.d;
import com.tencent.mm.cm.a;
import com.tencent.mm.cm.a.a;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vending.b.b;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;

public final class h
  extends g
{
  public d dZN;
  public ApplicationLike eKG;
  public a<ApplicationLifeCycle> eKH;
  public e mProfileCompat;
  
  public h(String paramString, Application paramApplication, ApplicationLike paramApplicationLike)
  {
    super(paramString, paramApplication);
    AppMethodBeat.i(58081);
    this.eKH = new a();
    ah.setProcessName(paramString);
    this.eKG = paramApplicationLike;
    AppMethodBeat.o(58081);
  }
  
  public final b a(ApplicationLifeCycle paramApplicationLifeCycle)
  {
    AppMethodBeat.i(146114);
    paramApplicationLifeCycle = this.eKH.at(paramApplicationLifeCycle);
    AppMethodBeat.o(146114);
    return paramApplicationLifeCycle;
  }
  
  public final String getPackageName()
  {
    AppMethodBeat.i(156838);
    String str = ah.getPackageName();
    AppMethodBeat.o(156838);
    return str;
  }
  
  public final void onConfigurationChanged(final Configuration paramConfiguration)
  {
    AppMethodBeat.i(146113);
    this.eKH.a(new a.a() {});
    AppMethodBeat.o(146113);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(58082);
    this.eKH.a(new a.a() {});
    AppMethodBeat.o(58082);
  }
  
  public final void onLowMemory()
  {
    AppMethodBeat.i(146110);
    this.eKH.a(new a.a() {});
    AppMethodBeat.o(146110);
  }
  
  public final void onTerminate()
  {
    AppMethodBeat.i(146112);
    this.eKH.a(new a.a() {});
    AppMethodBeat.o(146112);
  }
  
  public final void onTrimMemory(final int paramInt)
  {
    AppMethodBeat.i(146111);
    this.eKH.a(new a.a() {});
    AppMethodBeat.o(146111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.b.h
 * JD-Core Version:    0.7.0.1
 */