package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.y;
import com.tencent.mm.f.a.y.a;
import com.tencent.mm.f.a.y.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public static boolean Tm(String paramString)
  {
    AppMethodBeat.i(257200);
    Log.i("MicroMsg.AudioPlayerHelper", "stopAudio, audioId:%s", new Object[] { paramString });
    y localy = new y();
    localy.fvx.action = 3;
    localy.fvx.fmF = paramString;
    com.tencent.mm.plugin.music.b.b.a(localy);
    boolean bool = localy.fvy.result;
    AppMethodBeat.o(257200);
    return bool;
  }
  
  public static boolean Tn(String paramString)
  {
    AppMethodBeat.i(257201);
    Log.i("MicroMsg.AudioPlayerHelper", "destroyAudio, audioId:%s", new Object[] { paramString });
    y localy = new y();
    localy.fvx.action = 5;
    localy.fvx.fmF = paramString;
    com.tencent.mm.plugin.music.b.b.a(localy);
    boolean bool = localy.fvy.result;
    AppMethodBeat.o(257201);
    return bool;
  }
  
  public static boolean To(String paramString)
  {
    AppMethodBeat.i(136979);
    y localy = new y();
    localy.fvx.action = 7;
    localy.fvx.fmF = paramString;
    com.tencent.mm.plugin.music.b.b.a(localy);
    boolean bool = localy.fvy.result;
    AppMethodBeat.o(136979);
    return bool;
  }
  
  public static b Tp(String paramString)
  {
    AppMethodBeat.i(136980);
    y localy = new y();
    localy.fvx.action = 16;
    localy.fvx.fmF = paramString;
    com.tencent.mm.plugin.music.b.b.a(localy);
    paramString = localy.fvx.fvz;
    AppMethodBeat.o(136980);
    return paramString;
  }
  
  public static String be(String paramString1, String paramString2)
  {
    AppMethodBeat.i(257198);
    Log.i("MicroMsg.AudioPlayerHelper", "createAudioPlayer, appId:%s, audioId:%s", new Object[] { paramString1, paramString2 });
    y localy = new y();
    localy.fvx.action = 10;
    localy.fvx.appId = paramString1;
    localy.fvx.fmF = paramString2;
    com.tencent.mm.plugin.music.b.b.a(localy);
    paramString1 = localy.fvx.fmF;
    AppMethodBeat.o(257198);
    return paramString1;
  }
  
  public static boolean l(b paramb)
  {
    AppMethodBeat.i(257199);
    Log.d("MicroMsg.AudioPlayerHelper", "startAudio, audioId:%s", new Object[] { paramb.fmF });
    y localy = new y();
    localy.fvx.action = 0;
    localy.fvx.fmF = paramb.fmF;
    localy.fvx.fvz = paramb;
    com.tencent.mm.plugin.music.b.b.a(localy);
    boolean bool = localy.fvy.result;
    AppMethodBeat.o(257199);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.al.c
 * JD-Core Version:    0.7.0.1
 */