package com.tencent.mm.kernel.b;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.a;
import com.tencent.mm.co.a.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vending.b.b;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;

public final class h
  extends g
{
  public com.tencent.mm.booter.d fjW;
  public ApplicationLike gfO;
  public a<ApplicationLifeCycle> gfP;
  public com.tencent.mm.compatible.loader.d mProfileCompat;
  
  public h(String paramString, Application paramApplication, ApplicationLike paramApplicationLike)
  {
    super(paramString, paramApplication);
    AppMethodBeat.i(132220);
    this.gfP = new a();
    aj.setProcessName(paramString);
    this.gfO = paramApplicationLike;
    AppMethodBeat.o(132220);
  }
  
  public final b a(ApplicationLifeCycle paramApplicationLifeCycle)
  {
    AppMethodBeat.i(132226);
    paramApplicationLifeCycle = this.gfP.bv(paramApplicationLifeCycle);
    AppMethodBeat.o(132226);
    return paramApplicationLifeCycle;
  }
  
  public final String getPackageName()
  {
    AppMethodBeat.i(202261);
    String str = aj.getPackageName();
    AppMethodBeat.o(202261);
    return str;
  }
  
  public final void onConfigurationChanged(final Configuration paramConfiguration)
  {
    AppMethodBeat.i(132225);
    this.gfP.a(new a.a() {});
    AppMethodBeat.o(132225);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(132221);
    this.gfP.a(new a.a() {});
    AppMethodBeat.o(132221);
  }
  
  public final void onLowMemory()
  {
    AppMethodBeat.i(132222);
    this.gfP.a(new a.a() {});
    AppMethodBeat.o(132222);
  }
  
  public final void onTerminate()
  {
    AppMethodBeat.i(132224);
    this.gfP.a(new a.a() {});
    AppMethodBeat.o(132224);
  }
  
  public final void onTrimMemory(final int paramInt)
  {
    AppMethodBeat.i(132223);
    this.gfP.a(new a.a() {});
    AppMethodBeat.o(132223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.b.h
 * JD-Core Version:    0.7.0.1
 */