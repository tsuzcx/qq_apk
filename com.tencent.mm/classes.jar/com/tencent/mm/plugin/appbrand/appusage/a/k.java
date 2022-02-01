package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dko;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/MockData;", "", "()V", "fakeRecommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "getFakeRecommendCard", "()Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "setFakeRecommendCard", "(Lcom/tencent/mm/protocal/protobuf/RecommendCard;)V", "copyMockData", "", "mockData", "mock", "Ljava/util/LinkedList;", "pageNum", "", "plugin-appbrand-integration_release"})
public final class k
{
  dko kXH;
  
  public k()
  {
    AppMethodBeat.i(50332);
    this.kXH = new dko();
    AppMethodBeat.o(50332);
  }
  
  final void a(dko paramdko)
  {
    paramdko.gTT = this.kXH.gTT;
    paramdko.nHd = this.kXH.nHd;
    paramdko.nHf = this.kXH.nHf;
    paramdko.MOw = this.kXH.MOw;
    paramdko.qGI = "####客户端mock数据####商品";
    paramdko.nHg = this.kXH.nHg;
    paramdko.MOy = this.kXH.MOy;
    paramdko.MOx = this.kXH.MOx;
    paramdko.MOu = this.kXH.MOu;
    paramdko.score = this.kXH.score;
    paramdko.nHh = this.kXH.nHh;
    paramdko.MOz = this.kXH.MOz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.k
 * JD-Core Version:    0.7.0.1
 */