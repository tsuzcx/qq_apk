package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.crr;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/MockData;", "", "()V", "fakeRecommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "getFakeRecommendCard", "()Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "setFakeRecommendCard", "(Lcom/tencent/mm/protocal/protobuf/RecommendCard;)V", "copyMockData", "", "mockData", "mock", "Ljava/util/LinkedList;", "pageNum", "", "plugin-appbrand-integration_release"})
public final class k
{
  crr jRt;
  
  public k()
  {
    AppMethodBeat.i(50332);
    this.jRt = new crr();
    AppMethodBeat.o(50332);
  }
  
  final void a(crr paramcrr)
  {
    paramcrr.GMM = this.jRt.GMM;
    paramcrr.mrh = this.jRt.mrh;
    paramcrr.mrj = this.jRt.mrj;
    paramcrr.Hkc = this.jRt.Hkc;
    paramcrr.pky = "####客户端mock数据####商品";
    paramcrr.mrk = this.jRt.mrk;
    paramcrr.Hke = this.jRt.Hke;
    paramcrr.Hkd = this.jRt.Hkd;
    paramcrr.Hka = this.jRt.Hka;
    paramcrr.score = this.jRt.score;
    paramcrr.mrl = this.jRt.mrl;
    paramcrr.Hkf = this.jRt.Hkf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.k
 * JD-Core Version:    0.7.0.1
 */