package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f.a.b;
import a.f.b.j;
import a.f.b.k;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"toDate", "", "", "invoke"})
final class f$j
  extends k
  implements b<Long, String>
{
  public static final j kbx;
  
  static
  {
    AppMethodBeat.i(14820);
    kbx = new j();
    AppMethodBeat.o(14820);
  }
  
  f$j()
  {
    super(1);
  }
  
  public static String hZ(long paramLong)
  {
    AppMethodBeat.i(14819);
    String str = new SimpleDateFormat("MM/dd HH:mm:ss").format(new Date(paramLong));
    j.p(str, "SimpleDateFormat(\"MM/dd …m:ss\").format(Date(this))");
    AppMethodBeat.o(14819);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.f.j
 * JD-Core Version:    0.7.0.1
 */