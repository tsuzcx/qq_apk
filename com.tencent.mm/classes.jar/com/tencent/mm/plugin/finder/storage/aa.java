package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.f;
import com.tencent.mm.f.b.a.ig;
import com.tencent.mm.plugin.findersdk.a.al;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderMvLogic;", "", "()V", "TAG", "", "playingPos", "", "getPlayingPos", "()I", "setPlayingPos", "(I)V", "createMusicWrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "musicSongInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "musicId", "musicType", "directPlayMusic", "", "musicShareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "isPlayingPosValid", "", "isTheSameIdPlaying", "playId", "playMusic", "musicCoverUrl", "playMusicWithNoFloatBall", "coverUrl", "playOrPauseMusic", "resetPlayingPos", "plugin-finder_release"})
public final class aa
{
  private static int Amf;
  public static final aa Amg;
  
  static
  {
    AppMethodBeat.i(250118);
    Amg = new aa();
    Amf = -1;
    AppMethodBeat.o(250118);
  }
  
  public static void Qj(int paramInt)
  {
    Amf = paramInt;
  }
  
  private static f a(bds parambds, String paramString, int paramInt)
  {
    AppMethodBeat.i(250115);
    f localf = new f();
    localf.lVr = paramInt;
    localf.lVt = paramString;
    localf.lVG = parambds.SOJ;
    localf.lVx = parambds.albumName;
    localf.lVv = parambds.HLH;
    localf.lVw = parambds.ozs;
    localf.lVy = parambds.SOM;
    localf.lVK = parambds.SOM;
    localf.lVB = parambds.SOK;
    localf.lVz = parambds.musicDataUrl;
    localf.lVX = true;
    parambds = com.tencent.mm.plugin.comm.a.ubo;
    localf.lVV = com.tencent.mm.plugin.comm.a.cPl();
    AppMethodBeat.o(250115);
    return localf;
  }
  
  public static void a(bds parambds, dbr paramdbr, String paramString1, String paramString2)
  {
    AppMethodBeat.i(250107);
    p.k(parambds, "musicSongInfo");
    p.k(paramString1, "musicId");
    parambds = a(parambds, paramString1, 14);
    parambds.lVW = false;
    ((com.tencent.mm.bb.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.bb.a.a.class)).b(parambds, com.tencent.mm.bb.h.a(paramString1, paramdbr, paramString2));
    com.tencent.mm.bb.a.c(parambds);
    AppMethodBeat.o(250107);
  }
  
  public static void a(bds parambds, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(250106);
    p.k(parambds, "musicSongInfo");
    p.k(paramString1, "musicId");
    p.k(paramString2, "musicCoverUrl");
    if (!aEL(paramString1))
    {
      Log.i("FinderMvLogic", "playMusic");
      parambds = a(parambds, paramString1, paramInt);
      ((com.tencent.mm.bb.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.bb.a.a.class)).b(parambds, com.tencent.mm.bb.h.a(paramString1, null, paramString2));
      com.tencent.mm.bb.a.c(parambds);
      AppMethodBeat.o(250106);
      return;
    }
    Log.i("FinderMvLogic", "same music");
    AppMethodBeat.o(250106);
  }
  
  public static void a(bds parambds, String paramString, dbr paramdbr)
  {
    AppMethodBeat.i(250104);
    p.k(parambds, "musicSongInfo");
    p.k(paramString, "musicId");
    if (!aEL(paramString))
    {
      Log.i("FinderMvLogic", "playMusic");
      parambds = a(parambds, paramString, 13);
      ((com.tencent.mm.bb.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.bb.a.a.class)).b(parambds, com.tencent.mm.bb.h.a(paramString, paramdbr));
      com.tencent.mm.bb.a.c(parambds);
      AppMethodBeat.o(250104);
      return;
    }
    Log.i("FinderMvLogic", "same music");
    AppMethodBeat.o(250104);
  }
  
  public static boolean aEL(String paramString)
  {
    AppMethodBeat.i(250111);
    p.k(paramString, "playId");
    f localf = com.tencent.mm.bb.a.bnA();
    if (localf != null) {}
    for (String str = localf.lVt; (str != null) && (localf.lVr == 0) && (com.tencent.mm.bb.a.bnx()); str = null) {
      try
      {
        if (!Util.isEqual(localf.lVt, paramString)) {
          break;
        }
        AppMethodBeat.o(250111);
        return true;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(250111);
        return false;
      }
    }
    AppMethodBeat.o(250111);
    return false;
  }
  
  public static void b(bds parambds, String paramString, dbr paramdbr)
  {
    AppMethodBeat.i(250110);
    parambds = a(parambds, paramString, 0);
    ((com.tencent.mm.bb.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.bb.a.a.class)).b(parambds, com.tencent.mm.bb.h.a(paramString, paramdbr));
    com.tencent.mm.bb.a.c(parambds);
    parambds = new ig();
    parambds.sJ(1L);
    parambds.sK(8L);
    al.a(parambds);
    AppMethodBeat.o(250110);
  }
  
  public static void dYQ()
  {
    Amf = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.aa
 * JD-Core Version:    0.7.0.1
 */