package com.tencent.mm.plugin.aa.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.aa.model.f;
import com.tencent.mm.plugin.aa.model.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.app.a;

public final class d
  extends a
{
  m mLk;
  f mLl;
  
  public d()
  {
    AppMethodBeat.i(63443);
    this.mLk = new m();
    this.mLl = new f();
    AppMethodBeat.o(63443);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(63444);
    super.onCreate();
    Log.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onCreate");
    Object localObject = this.mLk.bwv();
    h.aHH();
    h.aHF().kcd.a(1624, (i)localObject);
    h.aHH();
    h.aHF().kcd.a(1655, (i)localObject);
    h.aHH();
    h.aHF().kcd.a(2831, (i)localObject);
    localObject = this.mLl.bwr();
    Log.i("MicroMsg.AAOperationData", "init");
    h.aHH();
    h.aHF().kcd.a(1698, (i)localObject);
    AppMethodBeat.o(63444);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(63445);
    super.onDestroy();
    Log.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onDestroy");
    Object localObject = this.mLk.bwv();
    h.aHH();
    h.aHF().kcd.b(1624, (i)localObject);
    h.aHH();
    h.aHF().kcd.b(1655, (i)localObject);
    h.aHH();
    h.aHF().kcd.b(2831, (i)localObject);
    localObject = this.mLl.bwr();
    Log.i("MicroMsg.AAOperationData", "uninit");
    h.aHH();
    h.aHF().kcd.b(1698, (i)localObject);
    AppMethodBeat.o(63445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.b.d
 * JD-Core Version:    0.7.0.1
 */