package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.bds;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/data/FinderTopicFollowListPage;", "Lcom/tencent/mm/platformtools/BaseProtoPage;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "fileName", "", "(Ljava/lang/String;)V", "Companion", "plugin-finder_release"})
public final class m
  extends d<bds>
{
  private static final String TAG = "Finder.FinderTopicFollowListPage";
  public static final a vGz;
  
  static
  {
    AppMethodBeat.i(252024);
    vGz = new a((byte)0);
    TAG = "Finder.FinderTopicFollowListPage";
    AppMethodBeat.o(252024);
  }
  
  public m(String paramString)
  {
    AppMethodBeat.i(252023);
    StringBuilder localStringBuilder = new StringBuilder();
    y localy = y.vXH;
    super.Sg(y.LA(6) + paramString);
    AppMethodBeat.o(252023);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/data/FinderTopicFollowListPage$Companion;", "", "()V", "TAG", "", "clearAll", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.m
 * JD-Core Version:    0.7.0.1
 */