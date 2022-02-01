package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.ay.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderMvLogic;", "", "()V", "TAG", "", "playingPos", "", "getPlayingPos", "()I", "setPlayingPos", "(I)V", "createMusicWrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "musicSongInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "musicId", "musicType", "directPlayMusic", "", "musicShareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "isPlayingPosValid", "", "isTheSameIdPlaying", "playId", "playMusic", "musicCoverUrl", "playOrPauseMusic", "resetPlayingPos", "plugin-finder_release"})
public final class ac
{
  private static int vEQ;
  public static final ac vER;
  
  static
  {
    AppMethodBeat.i(251829);
    vER = new ac();
    vEQ = -1;
    AppMethodBeat.o(251829);
  }
  
  public static void KZ(int paramInt)
  {
    vEQ = paramInt;
  }
  
  private static f a(axy paramaxy, String paramString, int paramInt)
  {
    AppMethodBeat.i(258549);
    f localf = new f();
    localf.jeT = paramInt;
    localf.jeV = paramString;
    localf.jfi = paramaxy.LIf;
    localf.jeZ = paramaxy.albumName;
    localf.jeX = paramaxy.BPc;
    localf.jeY = paramaxy.lDR;
    localf.jfa = paramaxy.Djf;
    localf.jfm = paramaxy.Djf;
    localf.jfd = paramaxy.LIg;
    localf.jfb = paramaxy.musicDataUrl;
    localf.jfx = true;
    AppMethodBeat.o(258549);
    return localf;
  }
  
  public static void a(axy paramaxy, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(258547);
    p.h(paramaxy, "musicSongInfo");
    p.h(paramString1, "musicId");
    p.h(paramString2, "musicCoverUrl");
    if (!avv(paramString1))
    {
      Log.i("FinderMvLogic", "playMusic");
      paramaxy = a(paramaxy, paramString1, paramInt);
      ((com.tencent.mm.ay.a.a)g.af(com.tencent.mm.ay.a.a.class)).b(paramaxy, h.bv(paramString1, paramString2));
      com.tencent.mm.ay.a.c(paramaxy);
      AppMethodBeat.o(258547);
      return;
    }
    Log.i("FinderMvLogic", "same music");
    AppMethodBeat.o(258547);
  }
  
  public static void a(axy paramaxy, String paramString, css paramcss)
  {
    AppMethodBeat.i(258546);
    p.h(paramaxy, "musicSongInfo");
    p.h(paramString, "musicId");
    if (!avv(paramString))
    {
      Log.i("FinderMvLogic", "playMusic");
      paramaxy = a(paramaxy, paramString, 0);
      ((com.tencent.mm.ay.a.a)g.af(com.tencent.mm.ay.a.a.class)).b(paramaxy, h.a(paramString, paramcss));
      com.tencent.mm.ay.a.c(paramaxy);
      AppMethodBeat.o(258546);
      return;
    }
    Log.i("FinderMvLogic", "same music");
    AppMethodBeat.o(258546);
  }
  
  public static boolean avv(String paramString)
  {
    AppMethodBeat.i(251827);
    p.h(paramString, "playId");
    f localf = com.tencent.mm.ay.a.bef();
    if (localf != null) {}
    for (String str = localf.jeV; (str != null) && (localf.jeT == 0) && (com.tencent.mm.ay.a.bec()); str = null) {
      try
      {
        if (!Util.isEqual(localf.jeV, paramString)) {
          break;
        }
        AppMethodBeat.o(251827);
        return true;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(251827);
        return false;
      }
    }
    AppMethodBeat.o(251827);
    return false;
  }
  
  public static void b(axy paramaxy, String paramString, css paramcss)
  {
    AppMethodBeat.i(258548);
    paramaxy = a(paramaxy, paramString, 0);
    ((com.tencent.mm.ay.a.a)g.af(com.tencent.mm.ay.a.a.class)).b(paramaxy, h.a(paramString, paramcss));
    com.tencent.mm.ay.a.c(paramaxy);
    AppMethodBeat.o(258548);
  }
  
  public static void dxV()
  {
    vEQ = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ac
 * JD-Core Version:    0.7.0.1
 */