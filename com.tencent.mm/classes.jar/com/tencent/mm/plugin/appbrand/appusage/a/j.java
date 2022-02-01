package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.enb;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/MockData;", "", "()V", "fakeRecommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "getFakeRecommendCard", "()Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "setFakeRecommendCard", "(Lcom/tencent/mm/protocal/protobuf/RecommendCard;)V", "copyMockData", "", "mockData", "mock", "Ljava/util/LinkedList;", "pageNum", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  enb qRD;
  
  public j()
  {
    AppMethodBeat.i(50332);
    this.qRD = new enb();
    AppMethodBeat.o(50332);
  }
  
  final void a(enb paramenb)
  {
    paramenb.met = this.qRD.met;
    paramenb.tNS = this.qRD.tNS;
    paramenb.tNU = this.qRD.tNU;
    paramenb.abrr = this.qRD.abrr;
    paramenb.recommend_reason = "####客户端mock数据####商品";
    paramenb.tNV = this.qRD.tNV;
    paramenb.abru = this.qRD.abru;
    paramenb.abrs = this.qRD.abrs;
    paramenb.abrp = this.qRD.abrp;
    paramenb.abrt = this.qRD.abrt;
    paramenb.tNW = this.qRD.tNW;
    paramenb.abrv = this.qRD.abrv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.j
 * JD-Core Version:    0.7.0.1
 */