package com.tencent.mm.plugin.finder.live.olympic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.e;
import com.tencent.mm.plugin.findersdk.storage.config.base.c;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/FinderOlympicDebugConfig;", "", "()V", "FINDER_OLYMPICS_LOCATION_VALID_TIME", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "", "getFINDER_OLYMPICS_LOCATION_VALID_TIME", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "FINDER_OLYMPIC_BUTTON_STATE", "getFINDER_OLYMPIC_BUTTON_STATE", "FINDER_OLYMPIC_CLEAN_BUBBLE_CACHE", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderSimpleClickConfig;", "getFINDER_OLYMPIC_CLEAN_BUBBLE_CACHE", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderSimpleClickConfig;", "FINDER_OLYMPIC_CLEAN_LOCATION", "getFINDER_OLYMPIC_CLEAN_LOCATION", "checkDebugState", "", "baseData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOlympicsSlice$OlympicBaseData;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  public static final n COU;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> COV;
  private static final c COW;
  private static final c COX;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> COY;
  
  static
  {
    AppMethodBeat.i(360487);
    COU = new n();
    COV = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "初始化设置冬奥火炬按钮状态").c("FINDER_OLYMPIC_BUTTON_STATE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4) }), p.listOf(new String[] { "默认", "参与护跑-为开幕", "点燃火炬-未领证书", "点燃火炬-已领证书", "我的证书" }));
    COW = new c("清除火炬气泡显示", (kotlin.g.a.b)n.a.COZ);
    COX = new c("清除首次定位提示", (kotlin.g.a.b)n.b.CPa);
    COY = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "证书定位缓存有效期").c("OLYMPICS_ROOM_REMAINDAY_MOCK", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(5), Integer.valueOf(10), Integer.valueOf(60000) }), p.listOf(new String[] { "默认10分钟", "5s", "10s", "1分钟" }));
    AppMethodBeat.o(360487);
  }
  
  public static void a(n.e parame)
  {
    AppMethodBeat.i(360474);
    s.u(parame, "baseData");
    com.tencent.d.a.b.a.a.a.a locala = com.tencent.d.a.b.a.a.a.a.ahqb;
    com.tencent.d.a.b.a.a.a.a.cl((kotlin.g.a.a)new c(parame));
    AppMethodBeat.o(360474);
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> enJ()
  {
    return COV;
  }
  
  public static c enK()
  {
    return COW;
  }
  
  public static c enL()
  {
    return COX;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> enM()
  {
    return COY;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(n.e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.n
 * JD-Core Version:    0.7.0.1
 */