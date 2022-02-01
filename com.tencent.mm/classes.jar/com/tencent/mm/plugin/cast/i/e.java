package com.tencent.mm.plugin.cast.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/utils/ScreenCastSetting;", "", "()V", "audioChannelCnt", "", "audioSampleRate", "audioUseLocalRecord", "", "iFrameInterval", "isAllowDebugSaveFile", "isAsyncCodec", "isDebugIgnoreScan", "isScreenPcCastForbidden", "isUseOpenGLRender", "videoBitrate", "plugin-cast_release"})
public final class e
{
  public static final e tKY;
  
  static
  {
    AppMethodBeat.i(189546);
    tKY = new e();
    AppMethodBeat.o(189546);
  }
  
  public static boolean cMd()
  {
    AppMethodBeat.i(189516);
    boolean bool;
    switch (af.juS.jrz)
    {
    case 0: 
    default: 
      bool = ((b)h.ae(b.class)).a(b.a.vWf, false);
      AppMethodBeat.o(189516);
      return bool;
    case -1: 
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        AppMethodBeat.o(189516);
        return false;
      }
      bool = ((b)h.ae(b.class)).a(b.a.vWf, false);
      AppMethodBeat.o(189516);
      return bool;
    case 2: 
      AppMethodBeat.o(189516);
      return false;
    }
    AppMethodBeat.o(189516);
    return true;
  }
  
  public static boolean cMe()
  {
    AppMethodBeat.i(189519);
    boolean bool;
    switch (af.juS.jrA)
    {
    case 0: 
    default: 
      bool = ((b)h.ae(b.class)).a(b.a.vWg, true);
      AppMethodBeat.o(189519);
      return bool;
    case -1: 
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        AppMethodBeat.o(189519);
        return true;
      }
      bool = ((b)h.ae(b.class)).a(b.a.vWg, true);
      AppMethodBeat.o(189519);
      return bool;
    case 2: 
      AppMethodBeat.o(189519);
      return false;
    }
    AppMethodBeat.o(189519);
    return true;
  }
  
  public static boolean cMf()
  {
    AppMethodBeat.i(189523);
    boolean bool;
    switch (af.juS.jrB)
    {
    case 0: 
    default: 
      bool = ((b)h.ae(b.class)).a(b.a.vWh, true);
      AppMethodBeat.o(189523);
      return bool;
    case -1: 
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        AppMethodBeat.o(189523);
        return true;
      }
      bool = ((b)h.ae(b.class)).a(b.a.vWh, true);
      AppMethodBeat.o(189523);
      return bool;
    case 2: 
      AppMethodBeat.o(189523);
      return false;
    }
    AppMethodBeat.o(189523);
    return true;
  }
  
  public static boolean cMg()
  {
    AppMethodBeat.i(189526);
    boolean bool;
    switch (af.juS.jrC)
    {
    case 0: 
    default: 
      bool = ((b)h.ae(b.class)).a(b.a.vWi, false);
      AppMethodBeat.o(189526);
      return bool;
    case -1: 
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        AppMethodBeat.o(189526);
        return false;
      }
      bool = ((b)h.ae(b.class)).a(b.a.vWi, false);
      AppMethodBeat.o(189526);
      return bool;
    case 2: 
      AppMethodBeat.o(189526);
      return false;
    }
    AppMethodBeat.o(189526);
    return true;
  }
  
  public static boolean cMh()
  {
    AppMethodBeat.i(189530);
    boolean bool = ((b)h.ae(b.class)).a(b.a.vWj, false);
    AppMethodBeat.o(189530);
    return bool;
  }
  
  public static boolean cMi()
  {
    AppMethodBeat.i(189534);
    boolean bool = ((b)h.ae(b.class)).a(b.a.vWo, false);
    AppMethodBeat.o(189534);
    return bool;
  }
  
  public static int cMj()
  {
    AppMethodBeat.i(189538);
    int i = ((b)h.ae(b.class)).a(b.a.vWk, 44100);
    AppMethodBeat.o(189538);
    return i;
  }
  
  public static int cMk()
  {
    AppMethodBeat.i(189539);
    int i = ((b)h.ae(b.class)).a(b.a.vWl, 4000);
    AppMethodBeat.o(189539);
    return i;
  }
  
  public static int cMl()
  {
    AppMethodBeat.i(189541);
    int i = ((b)h.ae(b.class)).a(b.a.vWm, 3);
    AppMethodBeat.o(189541);
    return i;
  }
  
  public static int cMm()
  {
    AppMethodBeat.i(189543);
    int i = ((b)h.ae(b.class)).a(b.a.vWn, 2);
    AppMethodBeat.o(189543);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.i.e
 * JD-Core Version:    0.7.0.1
 */