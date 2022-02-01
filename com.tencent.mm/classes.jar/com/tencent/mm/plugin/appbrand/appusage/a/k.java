package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.csl;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/MockData;", "", "()V", "fakeRecommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "getFakeRecommendCard", "()Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "setFakeRecommendCard", "(Lcom/tencent/mm/protocal/protobuf/RecommendCard;)V", "copyMockData", "", "mockData", "mock", "Ljava/util/LinkedList;", "pageNum", "", "plugin-appbrand-integration_release"})
public final class k
{
  csl jUL;
  
  public k()
  {
    AppMethodBeat.i(50332);
    this.jUL = new csl();
    AppMethodBeat.o(50332);
  }
  
  final void a(csl paramcsl)
  {
    paramcsl.Hgn = this.jUL.Hgn;
    paramcsl.mwf = this.jUL.mwf;
    paramcsl.mwh = this.jUL.mwh;
    paramcsl.HDC = this.jUL.HDC;
    paramcsl.prd = "####客户端mock数据####商品";
    paramcsl.mwi = this.jUL.mwi;
    paramcsl.HDE = this.jUL.HDE;
    paramcsl.HDD = this.jUL.HDD;
    paramcsl.HDA = this.jUL.HDA;
    paramcsl.score = this.jUL.score;
    paramcsl.mwj = this.jUL.mwj;
    paramcsl.HDF = this.jUL.HDF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.k
 * JD-Core Version:    0.7.0.1
 */