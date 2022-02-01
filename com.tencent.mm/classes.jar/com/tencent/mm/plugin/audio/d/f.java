package com.tencent.mm.plugin.audio.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/audio/util/XSettingWithAudioUtil;", "", "()V", "getForbidRefreshTime", "", "getForbidRequestTimes", "getForbidStrategy", "isAvailableToResponse", "", "plugin-audio_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f uVw;
  
  static
  {
    AppMethodBeat.i(263738);
    uVw = new f();
    AppMethodBeat.o(263738);
  }
  
  public static final boolean cUt()
  {
    AppMethodBeat.i(263714);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(263714);
      return true;
    }
    boolean bool;
    switch (af.lXZ.lRl)
    {
    case 0: 
    default: 
      bool = ((c)h.ax(c.class)).a(c.a.zmP, false);
      AppMethodBeat.o(263714);
      return bool;
    case -1: 
      bool = ((c)h.ax(c.class)).a(c.a.zmP, false);
      AppMethodBeat.o(263714);
      return bool;
    case 2: 
      AppMethodBeat.o(263714);
      return false;
    }
    AppMethodBeat.o(263714);
    return true;
  }
  
  public static final int cUu()
  {
    AppMethodBeat.i(263719);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(263719);
      return 1;
    }
    if (af.lXZ.lRm == -1)
    {
      i = ((c)h.ax(c.class)).a(c.a.zmQ, 1);
      AppMethodBeat.o(263719);
      return i;
    }
    int i = af.lXZ.lRm;
    AppMethodBeat.o(263719);
    return i;
  }
  
  public static final int cUv()
  {
    AppMethodBeat.i(263726);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(263726);
      return 50;
    }
    if (af.lXZ.lRn == -1)
    {
      i = ((c)h.ax(c.class)).a(c.a.zmR, 50);
      AppMethodBeat.o(263726);
      return i;
    }
    int i = af.lXZ.lRn;
    AppMethodBeat.o(263726);
    return i;
  }
  
  public static final int cUw()
  {
    AppMethodBeat.i(263733);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(263733);
      return 2;
    }
    if (af.lXZ.lRo == -1)
    {
      i = ((c)h.ax(c.class)).a(c.a.zmS, 2);
      AppMethodBeat.o(263733);
      return i;
    }
    int i = af.lXZ.lRo;
    AppMethodBeat.o(263733);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.d.f
 * JD-Core Version:    0.7.0.1
 */