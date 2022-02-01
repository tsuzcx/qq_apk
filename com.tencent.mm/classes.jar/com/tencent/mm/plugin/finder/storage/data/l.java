package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.bxv;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/FinderTopicFollowListPage;", "Lcom/tencent/mm/platformtools/BaseProtoPage;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "fileName", "", "(Ljava/lang/String;)V", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends d<bxv>
{
  public static final a FNn;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(339340);
    FNn = new a((byte)0);
    TAG = "Finder.FinderTopicFollowListPage";
    AppMethodBeat.o(339340);
  }
  
  public l(String paramString)
  {
    AppMethodBeat.i(339331);
    av localav = av.GiL;
    super.RY(s.X(av.Ub(6), paramString));
    AppMethodBeat.o(339331);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/FinderTopicFollowListPage$Companion;", "", "()V", "TAG", "", "clearAll", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.l
 * JD-Core Version:    0.7.0.1
 */