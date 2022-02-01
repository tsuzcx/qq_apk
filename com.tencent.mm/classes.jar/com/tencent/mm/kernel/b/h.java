package com.tencent.mm.kernel.b;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.d;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.cp.a;
import com.tencent.mm.cp.a.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.b.b;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;

public class h
  extends g
{
  public d lsS;
  public c mFS;
  public ApplicationLike mFT;
  public a<ApplicationLifeCycle> mFU;
  
  public h(String paramString, Application paramApplication, ApplicationLike paramApplicationLike)
  {
    super(paramString, paramApplication);
    AppMethodBeat.i(132220);
    this.mFU = new a();
    this.mFT = paramApplicationLike;
    AppMethodBeat.o(132220);
  }
  
  public final b a(ApplicationLifeCycle paramApplicationLifeCycle)
  {
    AppMethodBeat.i(132226);
    paramApplicationLifeCycle = this.mFU.add(paramApplicationLifeCycle);
    AppMethodBeat.o(132226);
    return paramApplicationLifeCycle;
  }
  
  public final String getPackageName()
  {
    AppMethodBeat.i(369557);
    String str = MMApplicationContext.getPackageName();
    AppMethodBeat.o(369557);
    return str;
  }
  
  public final void onConfigurationChanged(final Configuration paramConfiguration)
  {
    AppMethodBeat.i(132225);
    this.mFU.a(new a.a() {});
    AppMethodBeat.o(132225);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(132221);
    this.mFU.a(new a.a() {});
    AppMethodBeat.o(132221);
  }
  
  public final void onLowMemory()
  {
    AppMethodBeat.i(132222);
    this.mFU.a(new a.a() {});
    AppMethodBeat.o(132222);
  }
  
  public final void onTerminate()
  {
    AppMethodBeat.i(132224);
    this.mFU.a(new a.a() {});
    AppMethodBeat.o(132224);
  }
  
  public final void onTrimMemory(final int paramInt)
  {
    AppMethodBeat.i(132223);
    this.mFU.a(new a.a() {});
    AppMethodBeat.o(132223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.kernel.b.h
 * JD-Core Version:    0.7.0.1
 */