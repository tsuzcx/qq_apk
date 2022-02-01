package com.tencent.mm.plugin.audio.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/audio/util/XSettingWithAudioUtil;", "", "()V", "getForbidRefreshTime", "", "getForbidRequestTimes", "getForbidStrategy", "isAvailableToResponse", "", "plugin-audio_release"})
public final class f
{
  public static final f rKi;
  
  static
  {
    AppMethodBeat.i(257801);
    rKi = new f();
    AppMethodBeat.o(257801);
  }
  
  public static final boolean crJ()
  {
    AppMethodBeat.i(257790);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(257790);
      return true;
    }
    boolean bool;
    switch (af.juI.jod)
    {
    case 0: 
    default: 
      bool = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vUm, false);
      AppMethodBeat.o(257790);
      return bool;
    case -1: 
      bool = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vUm, false);
      AppMethodBeat.o(257790);
      return bool;
    case 2: 
      AppMethodBeat.o(257790);
      return false;
    }
    AppMethodBeat.o(257790);
    return true;
  }
  
  public static final int crK()
  {
    AppMethodBeat.i(257792);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(257792);
      return 1;
    }
    switch (af.juI.joe)
    {
    default: 
      i = af.juI.joe;
      AppMethodBeat.o(257792);
      return i;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vUn, 1);
    AppMethodBeat.o(257792);
    return i;
  }
  
  public static final int crL()
  {
    AppMethodBeat.i(257795);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(257795);
      return 50;
    }
    switch (af.juI.jof)
    {
    default: 
      i = af.juI.jof;
      AppMethodBeat.o(257795);
      return i;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vUo, 50);
    AppMethodBeat.o(257795);
    return i;
  }
  
  public static final int crM()
  {
    AppMethodBeat.i(257797);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(257797);
      return 2;
    }
    switch (af.juI.jog)
    {
    default: 
      i = af.juI.jog;
      AppMethodBeat.o(257797);
      return i;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vUp, 2);
    AppMethodBeat.o(257797);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.d.f
 * JD-Core Version:    0.7.0.1
 */