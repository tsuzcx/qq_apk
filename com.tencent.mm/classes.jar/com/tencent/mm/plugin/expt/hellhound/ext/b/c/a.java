package com.tencent.mm.plugin.expt.hellhound.ext.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.cn;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/HellFinderReport;", "", "()V", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a zIv;
  private static long zIw;
  private static long zIx;
  
  static
  {
    AppMethodBeat.i(300281);
    zIv = new a.a((byte)0);
    AppMethodBeat.o(300281);
  }
  
  public static final void a(b paramb)
  {
    AppMethodBeat.i(300256);
    a.a.a(paramb);
    AppMethodBeat.o(300256);
  }
  
  public static final void report21053OnClickOnSnsAd(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    AppMethodBeat.i(300262);
    ((cn)h.az(cn.class)).report21053OnClickOnSnsAd(paramLong1, paramLong2, paramString, paramLong3);
    AppMethodBeat.o(300262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.c.a
 * JD-Core Version:    0.7.0.1
 */