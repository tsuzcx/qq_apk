package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.kn;
import com.tencent.mm.aw.f;
import com.tencent.mm.plugin.findersdk.a.cp;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderQQMusicLogic;", "", "()V", "TAG", "", "createQQMusicWrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "musicId", "musicType", "", "directPlayMusic", "", "musicSongInfo", "musicShareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "isTheSameIdPlaying", "", "playId", "playMusic", "musicCoverUrl", "playMusicWithNoFloatBall", "coverUrl", "playOrPauseMusic", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj
{
  public static final aj FMk;
  
  static
  {
    AppMethodBeat.i(339456);
    FMk = new aj();
    AppMethodBeat.o(339456);
  }
  
  public static f a(bqj parambqj, String paramString, int paramInt)
  {
    AppMethodBeat.i(339450);
    f localf = new f();
    localf.oOt = 0;
    localf.oOv = paramString;
    localf.oOI = parambqj.ZYq;
    localf.oOz = parambqj.albumName;
    localf.oOx = parambqj.name;
    localf.oOy = parambqj.artist;
    localf.oOA = parambqj.ZYr;
    localf.oOM = parambqj.ZYo;
    localf.oOD = parambqj.rDm;
    localf.oOB = parambqj.ZYp;
    localf.oPa = true;
    localf.oOZ = parambqj.HsD;
    parambqj = com.tencent.mm.plugin.comm.a.xeG;
    localf.oOX = com.tencent.mm.plugin.comm.a.dsR();
    AppMethodBeat.o(339450);
    return localf;
  }
  
  public static boolean a(bqj parambqj, String paramString, dtj paramdtj)
  {
    AppMethodBeat.i(339425);
    s.u(parambqj, "musicSongInfo");
    s.u(paramString, "musicId");
    f localf = com.tencent.mm.aw.a.bLn();
    String str;
    if (localf == null) {
      str = null;
    }
    while ((str != null) && (Util.isEqual(localf.oOv, paramString))) {
      if (com.tencent.mm.aw.a.bLk())
      {
        parambqj = new kn();
        parambqj.ioV = 2L;
        parambqj.iqr = 8L;
        cp.a(parambqj);
        com.tencent.mm.aw.a.bLi();
        AppMethodBeat.o(339425);
        return true;
        str = localf.oOv;
      }
      else
      {
        b(parambqj, paramString, paramdtj);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(339425);
      return false;
      Log.i("FinderMvLogic", "playMusic");
      b(parambqj, paramString, paramdtj);
    }
  }
  
  public static boolean aAE(String paramString)
  {
    AppMethodBeat.i(339439);
    s.u(paramString, "playId");
    f localf = com.tencent.mm.aw.a.bLn();
    if (localf == null) {}
    for (String str = null; (str != null) && (localf.oOt == 0) && (com.tencent.mm.aw.a.bLk()); str = localf.oOv) {
      try
      {
        if (!Util.isEqual(localf.oOv, paramString)) {
          break;
        }
        AppMethodBeat.o(339439);
        return true;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(339439);
        return false;
      }
    }
    AppMethodBeat.o(339439);
    return false;
  }
  
  private static void b(bqj parambqj, String paramString, dtj paramdtj)
  {
    AppMethodBeat.i(339431);
    parambqj = a(parambqj, paramString, 0);
    ((com.tencent.mm.aw.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.aw.a.a.class)).b(parambqj, com.tencent.mm.aw.h.a(paramString, paramdtj));
    int i;
    if (paramdtj != null)
    {
      if (Util.isNullOrNil(paramdtj.oOZ)) {
        break label73;
      }
      i = 1;
      if (i == 0) {
        break label78;
      }
    }
    for (;;)
    {
      if (paramdtj != null) {
        parambqj.oOZ = paramdtj.oOZ;
      }
      com.tencent.mm.aw.a.c(parambqj);
      AppMethodBeat.o(339431);
      return;
      label73:
      i = 0;
      break;
      label78:
      paramdtj = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.aj
 * JD-Core Version:    0.7.0.1
 */