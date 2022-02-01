package com.tencent.mm.plugin.finder.uniComments.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.qe;
import com.tencent.mm.aw.c;
import com.tencent.mm.protocal.protobuf.boo;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/report/UniReportHelper;", "", "()V", "reportLike", "", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "action", "", "likeSource", "LikeActionType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Gbf;
  
  static
  {
    AppMethodBeat.i(341504);
    Gbf = new a();
    AppMethodBeat.o(341504);
  }
  
  public static void a(boo paramboo, long paramLong)
  {
    Object localObject2 = null;
    AppMethodBeat.i(341496);
    qe localqe = new qe();
    localqe.ipT = localqe.F("ContextId", String.valueOf(System.currentTimeMillis()), true);
    localqe.iXe = com.tencent.mm.aw.a.bLo().mPosition;
    localqe.iXf = localqe.iXe;
    Object localObject1;
    if (paramboo == null)
    {
      localObject1 = null;
      localqe.iWS = localqe.F("SongName", (String)localObject1, true);
      if (paramboo != null) {
        break label237;
      }
      localObject1 = null;
      label87:
      localqe.iWY = localqe.F("SongId", (String)localObject1, true);
      if (paramboo != null) {
        break label246;
      }
      localObject1 = null;
      label109:
      localqe.iWU = localqe.F("WebUrl", (String)localObject1, true);
      if (paramboo != null) {
        break label255;
      }
      localObject1 = null;
      label131:
      localqe.iWV = localqe.F("DataUrl", (String)localObject1, true);
      if (paramboo != null) {
        break label264;
      }
      localObject1 = localObject2;
      label154:
      localqe.iWT = localqe.F("Singer", (String)localObject1, true);
      if (paramboo != null) {
        break label294;
      }
    }
    label264:
    label294:
    for (long l = 0L;; l = paramboo.duration / 1000L)
    {
      localqe.iXd = l;
      localqe.ioV = paramLong;
      localqe.iYa = 1L;
      localqe.bMH();
      AppMethodBeat.o(341496);
      return;
      localObject1 = paramboo.songName;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = n.m((String)localObject1, ",", " ", false);
      break;
      label237:
      localObject1 = paramboo.mLQ;
      break label87;
      label246:
      localObject1 = paramboo.ZWR;
      break label109;
      label255:
      localObject1 = paramboo.musicDataUrl;
      break label131;
      String str = paramboo.rDl;
      localObject1 = localObject2;
      if (str == null) {
        break label154;
      }
      localObject1 = n.m(str, ",", " ", false);
      break label154;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.report.a
 * JD-Core Version:    0.7.0.1
 */