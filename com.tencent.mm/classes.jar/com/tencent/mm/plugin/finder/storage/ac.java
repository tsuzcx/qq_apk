package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.kn;
import com.tencent.mm.aw.f;
import com.tencent.mm.plugin.findersdk.a.cp;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderMvLogic;", "", "()V", "TAG", "", "playingPos", "", "getPlayingPos", "()I", "setPlayingPos", "(I)V", "createMusicWrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "musicSongInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "musicId", "musicType", "directPlayMusic", "", "musicShareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "isTheSameIdPlaying", "", "playId", "playMusic", "musicCoverUrl", "playMusicWithNoFloatBall", "coverUrl", "playOrPauseMusic", "resetPlayingPos", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
{
  public static final ac FLX;
  private static int FLY;
  
  static
  {
    AppMethodBeat.i(339646);
    FLX = new ac();
    FLY = -1;
    AppMethodBeat.o(339646);
  }
  
  public static void Tr(int paramInt)
  {
    FLY = paramInt;
  }
  
  private static f a(boo paramboo, String paramString, int paramInt)
  {
    AppMethodBeat.i(339636);
    f localf = new f();
    localf.oOt = paramInt;
    localf.oOv = paramString;
    localf.oOI = paramboo.ZWQ;
    localf.oOz = paramboo.albumName;
    localf.oOx = paramboo.songName;
    localf.oOy = paramboo.rDl;
    localf.oOA = paramboo.ZWS;
    localf.oOM = paramboo.ZWS;
    localf.oOD = paramboo.ZWR;
    localf.oOB = paramboo.musicDataUrl;
    localf.oPa = true;
    paramString = com.tencent.mm.plugin.comm.a.xeG;
    localf.oOX = com.tencent.mm.plugin.comm.a.dsR();
    if (!Util.isNullOrNil(paramboo.oOZ)) {
      localf.oOZ = paramboo.oOZ;
    }
    AppMethodBeat.o(339636);
    return localf;
  }
  
  public static void a(boo paramboo, dtj paramdtj, String paramString1, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(339590);
    s.u(paramboo, "musicSongInfo");
    s.u(paramString1, "musicId");
    f localf = a(paramboo, paramString1, 14);
    localf.oOY = false;
    if (paramdtj != null)
    {
      if (!Util.isNullOrNil(paramdtj.oOZ)) {
        i = 1;
      }
      if (i == 0) {
        break label104;
      }
    }
    label104:
    for (paramboo = paramdtj;; paramboo = null)
    {
      if (paramboo != null) {
        localf.oOZ = paramboo.oOZ;
      }
      ((com.tencent.mm.aw.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.aw.a.a.class)).b(localf, com.tencent.mm.aw.h.a(paramString1, paramdtj, paramString2));
      com.tencent.mm.aw.a.c(localf);
      AppMethodBeat.o(339590);
      return;
    }
  }
  
  public static void a(boo paramboo, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(339576);
    s.u(paramboo, "musicSongInfo");
    s.u(paramString1, "musicId");
    s.u(paramString2, "musicCoverUrl");
    if (!aAE(paramString1))
    {
      Log.i("FinderMvLogic", "playMusic");
      paramboo = a(paramboo, paramString1, paramInt);
      ((com.tencent.mm.aw.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.aw.a.a.class)).b(paramboo, com.tencent.mm.aw.h.a(paramString1, null, paramString2));
      com.tencent.mm.aw.a.c(paramboo);
      AppMethodBeat.o(339576);
      return;
    }
    Log.i("FinderMvLogic", "same music");
    AppMethodBeat.o(339576);
  }
  
  public static void a(boo paramboo, String paramString, dtj paramdtj)
  {
    AppMethodBeat.i(339560);
    s.u(paramboo, "musicSongInfo");
    s.u(paramString, "musicId");
    if (!aAE(paramString))
    {
      Log.i("FinderMvLogic", "playMusic");
      paramboo = a(paramboo, paramString, 13);
      ((com.tencent.mm.aw.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.aw.a.a.class)).b(paramboo, com.tencent.mm.aw.h.a(paramString, paramdtj));
      int i;
      if (paramdtj != null)
      {
        if (Util.isNullOrNil(paramdtj.oOZ)) {
          break label100;
        }
        i = 1;
        if (i == 0) {
          break label105;
        }
      }
      for (;;)
      {
        if (paramdtj != null) {
          paramboo.oOZ = paramdtj.oOZ;
        }
        com.tencent.mm.aw.a.c(paramboo);
        AppMethodBeat.o(339560);
        return;
        label100:
        i = 0;
        break;
        label105:
        paramdtj = null;
      }
    }
    Log.i("FinderMvLogic", "same music");
    AppMethodBeat.o(339560);
  }
  
  public static boolean aAE(String paramString)
  {
    AppMethodBeat.i(339622);
    s.u(paramString, "playId");
    f localf = com.tencent.mm.aw.a.bLn();
    if (localf == null) {}
    for (String str = null; (str != null) && (localf.oOt == 0) && (com.tencent.mm.aw.a.bLk()); str = localf.oOv) {
      try
      {
        if (!Util.isEqual(localf.oOv, paramString)) {
          break;
        }
        AppMethodBeat.o(339622);
        return true;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(339622);
        return false;
      }
    }
    AppMethodBeat.o(339622);
    return false;
  }
  
  public static void b(boo paramboo, String paramString, dtj paramdtj)
  {
    AppMethodBeat.i(339608);
    paramboo = a(paramboo, paramString, 0);
    ((com.tencent.mm.aw.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.aw.a.a.class)).b(paramboo, com.tencent.mm.aw.h.a(paramString, paramdtj));
    int i;
    if (!Util.isNullOrNil(paramdtj.oOZ))
    {
      i = 1;
      if (i == 0) {
        break label98;
      }
    }
    for (;;)
    {
      if (paramdtj != null) {
        paramboo.oOZ = paramdtj.oOZ;
      }
      com.tencent.mm.aw.a.c(paramboo);
      paramboo = new kn();
      paramboo.ioV = 1L;
      paramboo.iqr = 8L;
      cp.a(paramboo);
      AppMethodBeat.o(339608);
      return;
      i = 0;
      break;
      label98:
      paramdtj = null;
    }
  }
  
  public static void eZz()
  {
    FLY = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ac
 * JD-Core Version:    0.7.0.1
 */