package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chm;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/MockData;", "", "()V", "fakeRecommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "getFakeRecommendCard", "()Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "setFakeRecommendCard", "(Lcom/tencent/mm/protocal/protobuf/RecommendCard;)V", "copyMockData", "", "mockData", "mock", "Ljava/util/LinkedList;", "pageNum", "", "plugin-appbrand-integration_release"})
public final class k
{
  chm iXh;
  
  public k()
  {
    AppMethodBeat.i(50332);
    this.iXh = new chm();
    AppMethodBeat.o(50332);
  }
  
  final void a(chm paramchm)
  {
    paramchm.DHP = this.iXh.DHP;
    paramchm.lpv = this.iXh.lpv;
    paramchm.lpx = this.iXh.lpx;
    paramchm.EcW = this.iXh.EcW;
    paramchm.odv = "####客户端mock数据####商品";
    paramchm.lpy = this.iXh.lpy;
    paramchm.EcY = this.iXh.EcY;
    paramchm.EcX = this.iXh.EcX;
    paramchm.EcU = this.iXh.EcU;
    paramchm.score = this.iXh.score;
    paramchm.lpz = this.iXh.lpz;
    paramchm.EcZ = this.iXh.EcZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.k
 * JD-Core Version:    0.7.0.1
 */