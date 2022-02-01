package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.bkr;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/data/FinderTopicFollowListPage;", "Lcom/tencent/mm/platformtools/BaseProtoPage;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "fileName", "", "(Ljava/lang/String;)V", "Companion", "plugin-finder_release"})
public final class l
  extends d<bkr>
{
  public static final a Anx;
  private static final String TAG = "Finder.FinderTopicFollowListPage";
  
  static
  {
    AppMethodBeat.i(271087);
    Anx = new a((byte)0);
    TAG = "Finder.FinderTopicFollowListPage";
    AppMethodBeat.o(271087);
  }
  
  public l(String paramString)
  {
    AppMethodBeat.i(271086);
    StringBuilder localStringBuilder = new StringBuilder();
    aj localaj = aj.AGc;
    super.ZI(aj.QO(6) + paramString);
    AppMethodBeat.o(271086);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/data/FinderTopicFollowListPage$Companion;", "", "()V", "TAG", "", "clearAll", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.l
 * JD-Core Version:    0.7.0.1
 */