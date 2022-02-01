package com.tencent.mm.plugin.findersdk.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/cgi/report/FinderActionReport;", "", "()V", "costTime", "", "fromCommentScene", "", "getFromCommentScene", "()I", "setFromCommentScene", "(I)V", "testTime", "Lcom/tencent/mm/compatible/util/CodeInfo$TestTime;", "end", "", "reportIfWxChange", "reportWxChange", "lastVersion", "", "lastVersion2", "lastTag", "start", "Companion", "finder-sdk_release"})
public final class c
{
  public static final a BvX;
  public static final String TAG;
  public long costTime;
  public int fGo;
  public f.a khd;
  
  static
  {
    AppMethodBeat.i(209842);
    BvX = new a((byte)0);
    TAG = "Finder.FinderActionReport" + BvX.hashCode();
    AppMethodBeat.o(209842);
  }
  
  public c()
  {
    AppMethodBeat.i(209841);
    this.khd = new f.a();
    AppMethodBeat.o(209841);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/cgi/report/FinderActionReport$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "finder-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.b.a.c
 * JD-Core Version:    0.7.0.1
 */