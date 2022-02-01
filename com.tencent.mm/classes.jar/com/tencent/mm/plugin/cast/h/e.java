package com.tencent.mm.plugin.cast.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/utils/ScreenCastSetting;", "", "()V", "audioChannelCnt", "", "audioSampleRate", "audioUseLocalRecord", "", "iFrameInterval", "isAllowDebugSaveFile", "isAsyncCodec", "isDebugIgnoreScan", "isScreenPcCastForbidden", "isUseOpenGLRender", "videoBitrate", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e wOn;
  
  static
  {
    AppMethodBeat.i(274268);
    wOn = new e();
    AppMethodBeat.o(274268);
  }
  
  public static boolean dpH()
  {
    AppMethodBeat.i(274202);
    boolean bool;
    switch (af.lYj.lUN)
    {
    case 0: 
    default: 
      bool = ((c)h.ax(c.class)).a(c.a.zoK, false);
      AppMethodBeat.o(274202);
      return bool;
    case -1: 
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        AppMethodBeat.o(274202);
        return false;
      }
      bool = ((c)h.ax(c.class)).a(c.a.zoK, false);
      AppMethodBeat.o(274202);
      return bool;
    case 2: 
      AppMethodBeat.o(274202);
      return false;
    }
    AppMethodBeat.o(274202);
    return true;
  }
  
  public static boolean dpI()
  {
    AppMethodBeat.i(274210);
    boolean bool;
    switch (af.lYj.lUO)
    {
    case 0: 
    default: 
      bool = ((c)h.ax(c.class)).a(c.a.zoL, true);
      AppMethodBeat.o(274210);
      return bool;
    case -1: 
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        AppMethodBeat.o(274210);
        return true;
      }
      bool = ((c)h.ax(c.class)).a(c.a.zoL, true);
      AppMethodBeat.o(274210);
      return bool;
    case 2: 
      AppMethodBeat.o(274210);
      return false;
    }
    AppMethodBeat.o(274210);
    return true;
  }
  
  public static boolean dpJ()
  {
    AppMethodBeat.i(274220);
    boolean bool;
    switch (af.lYj.lUP)
    {
    case 0: 
    default: 
      bool = ((c)h.ax(c.class)).a(c.a.zoM, true);
      AppMethodBeat.o(274220);
      return bool;
    case -1: 
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        AppMethodBeat.o(274220);
        return true;
      }
      bool = ((c)h.ax(c.class)).a(c.a.zoM, true);
      AppMethodBeat.o(274220);
      return bool;
    case 2: 
      AppMethodBeat.o(274220);
      return false;
    }
    AppMethodBeat.o(274220);
    return true;
  }
  
  public static boolean dpK()
  {
    AppMethodBeat.i(274227);
    boolean bool;
    switch (af.lYj.lUQ)
    {
    case 0: 
    default: 
      bool = ((c)h.ax(c.class)).a(c.a.zoN, false);
      AppMethodBeat.o(274227);
      return bool;
    case -1: 
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        AppMethodBeat.o(274227);
        return false;
      }
      bool = ((c)h.ax(c.class)).a(c.a.zoN, false);
      AppMethodBeat.o(274227);
      return bool;
    case 2: 
      AppMethodBeat.o(274227);
      return false;
    }
    AppMethodBeat.o(274227);
    return true;
  }
  
  public static boolean dpL()
  {
    AppMethodBeat.i(274233);
    boolean bool = ((c)h.ax(c.class)).a(c.a.zoO, false);
    AppMethodBeat.o(274233);
    return bool;
  }
  
  public static boolean dpM()
  {
    AppMethodBeat.i(274240);
    boolean bool = ((c)h.ax(c.class)).a(c.a.zoT, false);
    AppMethodBeat.o(274240);
    return bool;
  }
  
  public static int dpN()
  {
    AppMethodBeat.i(274246);
    int i = ((c)h.ax(c.class)).a(c.a.zoP, 44100);
    AppMethodBeat.o(274246);
    return i;
  }
  
  public static int dpO()
  {
    AppMethodBeat.i(274250);
    int i = ((c)h.ax(c.class)).a(c.a.zoQ, 4000);
    AppMethodBeat.o(274250);
    return i;
  }
  
  public static int dpP()
  {
    AppMethodBeat.i(274254);
    int i = ((c)h.ax(c.class)).a(c.a.zoR, 3);
    AppMethodBeat.o(274254);
    return i;
  }
  
  public static int dpQ()
  {
    AppMethodBeat.i(274264);
    int i = ((c)h.ax(c.class)).a(c.a.zoS, 2);
    AppMethodBeat.o(274264);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.h.e
 * JD-Core Version:    0.7.0.1
 */