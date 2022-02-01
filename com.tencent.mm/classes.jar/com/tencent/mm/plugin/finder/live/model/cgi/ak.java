package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.bcv;
import com.tencent.mm.protocal.protobuf.bcw;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSuspiciousVerify;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSuspiciousVerifyResponse;", "liveId", "", "objectId", "scene", "", "verificationId", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSuspiciousVerify$CallBack;", "(JJILjava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSuspiciousVerify$CallBack;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSuspiciousVerify$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSuspiciousVerifyRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "Companion", "plugin-finder_release"})
public final class ak
  extends n<bcw>
{
  public static final b ykh;
  private final bcv ykf;
  private final a ykg;
  
  static
  {
    AppMethodBeat.i(291171);
    ykh = new b((byte)0);
    AppMethodBeat.o(291171);
  }
  
  public ak(long paramLong1, long paramLong2, int paramInt, String paramString, a parama)
  {
    AppMethodBeat.i(291170);
    this.ykg = parama;
    this.ykf = new bcv();
    this.ykf.klE = paramLong1;
    this.ykf.object_id = paramLong2;
    this.ykf.scene = paramInt;
    this.ykf.SMe = paramString;
    parama = this.ykf;
    Object localObject = ao.xcj;
    parama.RLM = ao.dnO();
    this.ykf.RLN = z.bdh();
    parama = new d.a();
    parama.c((a)this.ykf);
    localObject = new bcw();
    ((bcw)localObject).setBaseResponse(new jh());
    ((bcw)localObject).getBaseResponse().Tef = new eaf();
    parama.d((a)localObject);
    parama.TW("/cgi-bin/micromsg-bin/finderlivesuspiciousverify");
    parama.vD(5281);
    c(parama.bgN());
    Log.i("Finder.CgiFinderLiveSuspiciousVerify", "init: liveId:" + paramLong1 + ", objectId:" + paramLong2 + ", scene:" + paramInt + ", verification_id:" + paramString);
    AppMethodBeat.o(291170);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSuspiciousVerify$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSuspiciousVerifyResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, bcw parambcw);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSuspiciousVerify$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.ak
 * JD-Core Version:    0.7.0.1
 */