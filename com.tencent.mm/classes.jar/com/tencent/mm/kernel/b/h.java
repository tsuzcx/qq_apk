package com.tencent.mm.kernel.b;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.d;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.cw.a;
import com.tencent.mm.cw.a.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.b.b;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;

public class h
  extends g
{
  public d iQW;
  public ApplicationLike kfv;
  public a<ApplicationLifeCycle> kfw;
  public c mProfileCompat;
  
  public h(String paramString, Application paramApplication, ApplicationLike paramApplicationLike)
  {
    super(paramString, paramApplication);
    AppMethodBeat.i(132220);
    this.kfw = new a();
    this.kfv = paramApplicationLike;
    AppMethodBeat.o(132220);
  }
  
  public final b a(ApplicationLifeCycle paramApplicationLifeCycle)
  {
    AppMethodBeat.i(132226);
    paramApplicationLifeCycle = this.kfw.add(paramApplicationLifeCycle);
    AppMethodBeat.o(132226);
    return paramApplicationLifeCycle;
  }
  
  public final String getPackageName()
  {
    AppMethodBeat.i(292940);
    String str = MMApplicationContext.getPackageName();
    AppMethodBeat.o(292940);
    return str;
  }
  
  public final void onConfigurationChanged(final Configuration paramConfiguration)
  {
    AppMethodBeat.i(132225);
    this.kfw.a(new a.a() {});
    AppMethodBeat.o(132225);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(132221);
    this.kfw.a(new a.a() {});
    AppMethodBeat.o(132221);
  }
  
  public final void onLowMemory()
  {
    AppMethodBeat.i(132222);
    this.kfw.a(new a.a() {});
    AppMethodBeat.o(132222);
  }
  
  public final void onTerminate()
  {
    AppMethodBeat.i(132224);
    this.kfw.a(new a.a() {});
    AppMethodBeat.o(132224);
  }
  
  public final void onTrimMemory(final int paramInt)
  {
    AppMethodBeat.i(132223);
    this.kfw.a(new a.a() {});
    AppMethodBeat.o(132223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kernel.b.h
 * JD-Core Version:    0.7.0.1
 */