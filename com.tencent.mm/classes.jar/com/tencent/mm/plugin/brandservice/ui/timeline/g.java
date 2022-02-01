package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.f;
import kotlin.g.a.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineResortHelper;", "", "()V", "TAG", "", "articleClickOpen", "", "getArticleClickOpen", "()Z", "enterBizTimeLineOpen", "getEnterBizTimeLineOpen", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "oftenReadClickOpen", "getOftenReadClickOpen", "getItem", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "list", "", "pos", "", "getResortContext", "Lcom/tencent/mm/protocal/protobuf/BizMsgReSortContext;", "sessionItemCache", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport$ReportHashMap;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport$ReportBrandExposeItem;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport;", "posInCard", "fromScene", "onClick", "", "info", "onEnter", "onOftenReadClick", "userName", "plugin-brandservice_release"})
public final class g
{
  private static final f lrB;
  public static final g sBS;
  
  static
  {
    AppMethodBeat.i(266170);
    sBS = new g();
    lrB = kotlin.g.ar((a)g.a.sBT);
    AppMethodBeat.o(266170);
  }
  
  public static MultiProcessMMKV bcJ()
  {
    AppMethodBeat.i(266169);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)lrB.getValue();
    AppMethodBeat.o(266169);
    return localMultiProcessMMKV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.g
 * JD-Core Version:    0.7.0.1
 */