package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.aqk;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/data/FinderActivityPage;", "Lcom/tencent/mm/platformtools/BaseProtoPage;", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "filename", "", "(Ljava/lang/String;)V", "Companion", "plugin-finder_release"})
public final class c
  extends d<aqk>
{
  private static final String TAG = "Finder.FinderActivityPage";
  public static final a vFR;
  
  static
  {
    AppMethodBeat.i(251952);
    vFR = new a((byte)0);
    TAG = "Finder.FinderActivityPage";
    AppMethodBeat.o(251952);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(251951);
    StringBuilder localStringBuilder = new StringBuilder();
    y localy = y.vXH;
    super.Sg(y.LA(7) + paramString);
    AppMethodBeat.o(251951);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/data/FinderActivityPage$Companion;", "", "()V", "TAG", "", "clearAll", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.c
 * JD-Core Version:    0.7.0.1
 */