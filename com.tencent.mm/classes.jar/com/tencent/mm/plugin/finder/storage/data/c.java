package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.asg;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/data/FinderActivityPage;", "Lcom/tencent/mm/platformtools/BaseProtoPage;", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "filename", "", "(Ljava/lang/String;)V", "Companion", "plugin-finder_release"})
public final class c
  extends d<asg>
{
  public static final a AmQ;
  private static final String TAG = "Finder.FinderActivityPage";
  
  static
  {
    AppMethodBeat.i(276275);
    AmQ = new a((byte)0);
    TAG = "Finder.FinderActivityPage";
    AppMethodBeat.o(276275);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(276274);
    StringBuilder localStringBuilder = new StringBuilder();
    aj localaj = aj.AGc;
    super.ZI(aj.QO(7) + paramString);
    AppMethodBeat.o(276274);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/data/FinderActivityPage$Companion;", "", "()V", "TAG", "", "clearAll", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.c
 * JD-Core Version:    0.7.0.1
 */