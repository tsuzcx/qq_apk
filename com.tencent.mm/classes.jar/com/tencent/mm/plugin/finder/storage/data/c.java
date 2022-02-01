package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.awt;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/FinderActivityPage;", "Lcom/tencent/mm/platformtools/BaseProtoPage;", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "filename", "", "(Ljava/lang/String;)V", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends d<awt>
{
  public static final a FMK;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(339355);
    FMK = new a((byte)0);
    TAG = "Finder.FinderActivityPage";
    AppMethodBeat.o(339355);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(339350);
    av localav = av.GiL;
    super.RY(s.X(av.Ub(7), paramString));
    AppMethodBeat.o(339350);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/FinderActivityPage$Companion;", "", "()V", "TAG", "", "clearAll", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.c
 * JD-Core Version:    0.7.0.1
 */