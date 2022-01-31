package com.tencent.mm.plugin.appbrand.appusage.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bsi;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/MockData;", "", "()V", "fakeRecommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "getFakeRecommendCard", "()Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "setFakeRecommendCard", "(Lcom/tencent/mm/protocal/protobuf/RecommendCard;)V", "copyMockData", "", "mockData", "mock", "Ljava/util/LinkedList;", "pageNum", "", "plugin-appbrand-integration_release"})
public final class k
{
  bsi hdR;
  
  public k()
  {
    AppMethodBeat.i(134595);
    this.hdR = new bsi();
    AppMethodBeat.o(134595);
  }
  
  final void a(bsi parambsi)
  {
    parambsi.xFL = this.hdR.xFL;
    parambsi.iFH = this.hdR.iFH;
    parambsi.iFJ = this.hdR.iFJ;
    parambsi.xFN = this.hdR.xFN;
    parambsi.kWF = "####客户端mock数据####商品";
    parambsi.iFK = this.hdR.iFK;
    parambsi.xFP = this.hdR.xFP;
    parambsi.xFO = this.hdR.xFO;
    parambsi.xFK = this.hdR.xFK;
    parambsi.score = this.hdR.score;
    parambsi.iFL = this.hdR.iFL;
    parambsi.xFQ = this.hdR.xFQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.k
 * JD-Core Version:    0.7.0.1
 */