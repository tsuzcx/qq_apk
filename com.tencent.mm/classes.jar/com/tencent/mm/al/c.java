package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ab;
import com.tencent.mm.autogen.a.ab.a;
import com.tencent.mm.autogen.a.ab.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public static boolean Lo(String paramString)
  {
    AppMethodBeat.i(234483);
    Log.i("MicroMsg.AudioPlayerHelper", "stopAudio, audioId:%s", new Object[] { paramString });
    ab localab = new ab();
    localab.hzS.action = 3;
    localab.hzS.hqQ = paramString;
    com.tencent.mm.plugin.music.b.b.a(localab);
    boolean bool = localab.hzT.result;
    AppMethodBeat.o(234483);
    return bool;
  }
  
  public static boolean Lp(String paramString)
  {
    AppMethodBeat.i(234488);
    Log.i("MicroMsg.AudioPlayerHelper", "destroyAudio, audioId:%s", new Object[] { paramString });
    ab localab = new ab();
    localab.hzS.action = 5;
    localab.hzS.hqQ = paramString;
    com.tencent.mm.plugin.music.b.b.a(localab);
    boolean bool = localab.hzT.result;
    AppMethodBeat.o(234488);
    return bool;
  }
  
  public static boolean Lq(String paramString)
  {
    AppMethodBeat.i(136979);
    ab localab = new ab();
    localab.hzS.action = 7;
    localab.hzS.hqQ = paramString;
    com.tencent.mm.plugin.music.b.b.a(localab);
    boolean bool = localab.hzT.result;
    AppMethodBeat.o(136979);
    return bool;
  }
  
  public static b Lr(String paramString)
  {
    AppMethodBeat.i(136980);
    ab localab = new ab();
    localab.hzS.action = 16;
    localab.hzS.hqQ = paramString;
    com.tencent.mm.plugin.music.b.b.a(localab);
    paramString = localab.hzS.hzU;
    AppMethodBeat.o(136980);
    return paramString;
  }
  
  public static String bo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(234477);
    Log.i("MicroMsg.AudioPlayerHelper", "createAudioPlayer, appId:%s, audioId:%s", new Object[] { paramString1, paramString2 });
    ab localab = new ab();
    localab.hzS.action = 10;
    localab.hzS.appId = paramString1;
    localab.hzS.hqQ = paramString2;
    com.tencent.mm.plugin.music.b.b.a(localab);
    paramString1 = localab.hzS.hqQ;
    AppMethodBeat.o(234477);
    return paramString1;
  }
  
  public static boolean l(b paramb)
  {
    AppMethodBeat.i(234479);
    Log.d("MicroMsg.AudioPlayerHelper", "startAudio, audioId:%s", new Object[] { paramb.hqQ });
    ab localab = new ab();
    localab.hzS.action = 0;
    localab.hzS.hqQ = paramb.hqQ;
    localab.hzS.hzU = paramb;
    com.tencent.mm.plugin.music.b.b.a(localab);
    boolean bool = localab.hzT.result;
    AppMethodBeat.o(234479);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.al.c
 * JD-Core Version:    0.7.0.1
 */