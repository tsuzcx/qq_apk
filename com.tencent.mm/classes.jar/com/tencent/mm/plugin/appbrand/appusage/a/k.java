package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cmp;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/MockData;", "", "()V", "fakeRecommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "getFakeRecommendCard", "()Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "setFakeRecommendCard", "(Lcom/tencent/mm/protocal/protobuf/RecommendCard;)V", "copyMockData", "", "mockData", "mock", "Ljava/util/LinkedList;", "pageNum", "", "plugin-appbrand-integration_release"})
public final class k
{
  cmp jxx;
  
  public k()
  {
    AppMethodBeat.i(50332);
    this.jxx = new cmp();
    AppMethodBeat.o(50332);
  }
  
  final void a(cmp paramcmp)
  {
    paramcmp.Fdk = this.jxx.Fdk;
    paramcmp.lRr = this.jxx.lRr;
    paramcmp.lRt = this.jxx.lRt;
    paramcmp.FzR = this.jxx.FzR;
    paramcmp.oGU = "####客户端mock数据####商品";
    paramcmp.lRu = this.jxx.lRu;
    paramcmp.FzT = this.jxx.FzT;
    paramcmp.FzS = this.jxx.FzS;
    paramcmp.FzP = this.jxx.FzP;
    paramcmp.score = this.jxx.score;
    paramcmp.lRv = this.jxx.lRv;
    paramcmp.FzU = this.jxx.FzU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.k
 * JD-Core Version:    0.7.0.1
 */