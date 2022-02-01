package com.tencent.mm.plugin.findersdk.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/cgi/report/FinderActionReport;", "", "()V", "costTime", "", "fromCommentScene", "", "getFromCommentScene", "()I", "setFromCommentScene", "(I)V", "testTime", "Lcom/tencent/mm/compatible/util/CodeInfo$TestTime;", "end", "", "reportIfWxChange", "reportLiveSwitchStream", "switchUrl", "", "switchRet", "reportWxChange", "lastVersion", "lastVersion2", "lastTag", "start", "Companion", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.a Hdh;
  public static final String TAG;
  public long costTime;
  public int hLK;
  public f.a mHw;
  
  static
  {
    AppMethodBeat.i(273854);
    Hdh = new c.a((byte)0);
    TAG = s.X("Finder.FinderActionReport", Integer.valueOf(Hdh.hashCode()));
    AppMethodBeat.o(273854);
  }
  
  public c()
  {
    AppMethodBeat.i(273850);
    this.mHw = new f.a();
    AppMethodBeat.o(273850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.b.a.c
 * JD-Core Version:    0.7.0.1
 */