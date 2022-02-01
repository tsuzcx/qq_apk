package com.tencent.mm.plugin.findersdk.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import kotlin.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/storage/config/FinderNearbyConfig;", "", "()V", "FINDER_LIVE_ABOVE_LOOK", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "", "getFINDER_LIVE_ABOVE_LOOK", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "FINDER_SUPPORT_FIND_PAGE_LIVE", "getFINDER_SUPPORT_FIND_PAGE_LIVE", "finder-sdk_release"})
public final class a
{
  private static final b<Integer> Bwi;
  public static final a Bwj;
  private static final b<Integer> Lea;
  
  static
  {
    AppMethodBeat.i(208909);
    Bwj = new a();
    Bwi = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "是否打开发现页直播入口").d(b.a.vLA).b("FINDER_SUPPORT_FIND_PAGE_LIVE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" })).aGU("2021T2");
    Lea = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "直播独立入口在看一看上方").d(b.a.KHS).b("FINDER_LIVE_ABOVE_LOOK", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" })).aGU("2021T2");
    AppMethodBeat.o(208909);
  }
  
  public static b<Integer> ens()
  {
    return Bwi;
  }
  
  public static b<Integer> etL()
  {
    return Lea;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.d.a.a
 * JD-Core Version:    0.7.0.1
 */