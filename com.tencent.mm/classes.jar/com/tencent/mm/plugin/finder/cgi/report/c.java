package com.tencent.mm.plugin.finder.cgi.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/report/FinderActionReport;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "costTime", "", "fromCommentScene", "", "getFromCommentScene", "()I", "setFromCommentScene", "(I)V", "testTime", "Lcom/tencent/mm/compatible/util/CodeInfo$TestTime;", "end", "", "reportIfWxChange", "reportWxChange", "lastVersion", "lastVersion2", "lastTag", "start", "plugin-finder_release"})
public final class c
{
  public final String TAG;
  public long costTime;
  public f.a hvh;
  public int tyh;
  
  public c()
  {
    AppMethodBeat.i(242688);
    this.TAG = ("Finder.FinderActionReport" + hashCode());
    this.hvh = new f.a();
    AppMethodBeat.o(242688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.report.c
 * JD-Core Version:    0.7.0.1
 */