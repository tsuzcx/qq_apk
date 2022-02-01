package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.cgi.ax;
import com.tencent.mm.protocal.protobuf.avx;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/NetSceneFinderLiveGetLotteryRecord;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "liveId", "", "objectId", "objectNonceId", "lotteryId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(JJJLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getLastBuffer", "getLotteryInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "getType", "getWinnerList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryContact;", "kotlin.jvm.PlatformType", "isMessageSwitchOpen", "", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class aa
  extends ax
{
  public static final a ulx;
  private i callback;
  public int pullType;
  public d rr;
  
  static
  {
    AppMethodBeat.i(246357);
    ulx = new a((byte)0);
    AppMethodBeat.o(246357);
  }
  
  public aa(long paramLong1, long paramLong2, long paramLong3, String paramString, b paramb)
  {
    AppMethodBeat.i(246356);
    Object localObject = new d.a();
    ((d.a)localObject).sG(getType());
    avx localavx = new avx();
    am localam = am.tuw;
    localavx.LAI = am.cXY();
    localavx.finderUsername = z.aUg();
    localavx.liveId = paramLong1;
    localavx.hFK = paramLong2;
    localavx.lastBuffer = paramb;
    localavx.LGk = paramLong3;
    localavx.tWb = paramString;
    ((d.a)localObject).c((a)localavx);
    ((d.a)localObject).d((a)new avy());
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/finderlivegetlotteryrecord");
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((d)localObject);
    Log.i("NetSceneFinderLiveLotteryHistory", "NetSceneFinderLiveGetLotteryRecord init, finderUsername = " + localavx.finderUsername + ", liveId = " + paramLong1 + ", objectId = " + paramLong2 + ", objectNonceId = " + paramLong3 + ", lotteryId = " + paramString + ",  lastBuffer = " + paramb);
    AppMethodBeat.o(246356);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(246355);
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.hyc();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(246355);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(246354);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(246354);
    return i;
  }
  
  public final int getType()
  {
    return 5258;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/NetSceneFinderLiveGetLotteryRecord$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.aa
 * JD-Core Version:    0.7.0.1
 */