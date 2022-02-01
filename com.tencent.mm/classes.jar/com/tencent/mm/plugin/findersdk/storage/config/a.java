package com.tencent.mm.plugin.findersdk.storage.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/storage/config/FinderNearbyConfig;", "", "()V", "FINDER_LIVE_ABOVE_LOOK", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "", "getFINDER_LIVE_ABOVE_LOOK", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "FINDER_LIVE_SUB_TAB_CACHE_TIME", "getFINDER_LIVE_SUB_TAB_CACHE_TIME", "FINDER_RECOM_CARD_REPLAEC_ANIM_SWITCH", "getFINDER_RECOM_CARD_REPLAEC_ANIM_SWITCH", "FINDER_SUPPORT_FIND_PAGE_LIVE", "getFINDER_SUPPORT_FIND_PAGE_LIVE", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Hds;
  private static final b<Integer> Hdt;
  private static final b<Integer> Hdu;
  private static final b<Integer> Hdv;
  private static final b<Integer> akis;
  
  static
  {
    AppMethodBeat.i(273776);
    Hds = new a();
    Hdt = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "是否打开发现页直播入口").d(c.a.zca).c("FINDER_SUPPORT_FIND_PAGE_LIVE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "打开" })).aDm("2021T2");
    Hdu = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "卡片插入是否感知(是否开启动画)").d(c.a.zcb).c("FINDER_RECOM_CARD_REPLAEC_ANIM_SWITCH", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "打开" })).aDm("2021T2");
    Hdv = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "直播独立入口在看一看上方").d(c.a.zcd).c("FINDER_LIVE_ABOVE_LOOK", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "打开" })).aDm("2021T2");
    akis = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(300000, "新广场二级tab缓存时间").d(c.a.Dhk).c("FINDER_LIVE_SUB_TAB_CACHE_TIME", p.listOf(new Integer[] { Integer.valueOf(300000), Integer.valueOf(30000) }), p.listOf(new String[] { "5分钟", "30秒" }));
    AppMethodBeat.o(273776);
  }
  
  public static b<Integer> fsc()
  {
    return Hdt;
  }
  
  public static b<Integer> fsd()
  {
    return Hdu;
  }
  
  public static b<Integer> fse()
  {
    return Hdv;
  }
  
  public static b<Integer> kLF()
  {
    return akis;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.storage.config.a
 * JD-Core Version:    0.7.0.1
 */