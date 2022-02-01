package com.tencent.mm.plugin.audio.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/audio/util/XSettingWithAudioUtil;", "", "()V", "getForbidRefreshTime", "", "getForbidRequestTimes", "getForbidStrategy", "isAvailableToResponse", "", "plugin-audio_release"})
public final class f
{
  public static final f oIs;
  
  static
  {
    AppMethodBeat.i(224039);
    oIs = new f();
    AppMethodBeat.o(224039);
  }
  
  public static final boolean cew()
  {
    AppMethodBeat.i(224035);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(224035);
      return true;
    }
    boolean bool;
    switch (ae.gKu.gDT)
    {
    case 0: 
    default: 
      bool = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sjL, false);
      AppMethodBeat.o(224035);
      return bool;
    case -1: 
      bool = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sjL, false);
      AppMethodBeat.o(224035);
      return bool;
    case 2: 
      AppMethodBeat.o(224035);
      return false;
    }
    AppMethodBeat.o(224035);
    return true;
  }
  
  public static final int cex()
  {
    AppMethodBeat.i(224036);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(224036);
      return 1;
    }
    switch (ae.gKu.gDU)
    {
    default: 
      i = ae.gKu.gDU;
      AppMethodBeat.o(224036);
      return i;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sjM, 1);
    AppMethodBeat.o(224036);
    return i;
  }
  
  public static final int cey()
  {
    AppMethodBeat.i(224037);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(224037);
      return 50;
    }
    switch (ae.gKu.gDV)
    {
    default: 
      i = ae.gKu.gDV;
      AppMethodBeat.o(224037);
      return i;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sjN, 50);
    AppMethodBeat.o(224037);
    return i;
  }
  
  public static final int cez()
  {
    AppMethodBeat.i(224038);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(224038);
      return 2;
    }
    switch (ae.gKu.gDW)
    {
    default: 
      i = ae.gKu.gDW;
      AppMethodBeat.o(224038);
      return i;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sjO, 2);
    AppMethodBeat.o(224038);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.d.f
 * JD-Core Version:    0.7.0.1
 */