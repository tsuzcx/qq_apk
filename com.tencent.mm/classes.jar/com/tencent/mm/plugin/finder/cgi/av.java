package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.g.a.hg;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.aqh;
import com.tencent.mm.protocal.protobuf.aqi;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cns;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneDeleteFinderObject;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "objectId", "", "objectNonceId", "isMegaVideo", "", "(Ljava/lang/String;JLjava/lang/String;Z)V", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "megaVideo", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/MegaVideo;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getDelId", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class av
  extends ax
  implements m
{
  private String TAG;
  private i callback;
  public long hFK;
  private d rr;
  private FinderObject tuO;
  private cng tuP;
  
  public av(String paramString1, long paramLong, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(242351);
    this.TAG = "Finder.NetSceneDeleteFinderObject";
    d.a locala = new d.a();
    locala.MB("/cgi-bin/micromsg-bin/finderdelfeed");
    locala.sG(getType());
    aqh localaqh = new aqh();
    localaqh.id = paramLong;
    localaqh.objectNonceId = paramString2;
    localaqh.LCo = paramString1;
    paramString1 = am.tuw;
    localaqh.uli = am.cXY();
    paramString1 = localaqh.uli;
    if (paramString1 == null) {
      p.hyc();
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramString1.scene = i;
      locala.c((a)localaqh);
      locala.d((a)new aqi());
      paramString1 = locala.aXF();
      p.g(paramString1, "builder.buildInstance()");
      this.rr = paramString1;
      this.hFK = paramLong;
      AppMethodBeat.o(242351);
      return;
    }
  }
  
  public av(String paramString, FinderObject paramFinderObject)
  {
    this(paramString, l, str1);
    AppMethodBeat.i(242352);
    this.tuO = paramFinderObject;
    AppMethodBeat.o(242352);
  }
  
  public av(String paramString, cng paramcng) {}
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242350);
    Log.i(this.TAG, "errType " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    long l1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.tuO;
      if (params == null) {
        break label378;
      }
      c.a locala = c.vGN;
      c.a.FT(this.hFK);
      long l2 = this.hFK;
      params = params.attachmentList;
      if (params == null) {
        break label372;
      }
      params = params.LAM;
      if (params == null) {
        break label372;
      }
      params = (aop)j.kt((List)params);
      if (params == null) {
        break label372;
      }
      params = params.LAL;
      if (params == null) {
        break label372;
      }
      params = params.LIA;
      if (params == null) {
        break label372;
      }
      l1 = params.id;
      if (l1 != 0L)
      {
        params = c.vGN;
        c.a.FU(l1);
      }
      l1 = l2;
      label179:
      params = this.tuP;
      if (params == null) {
        break label390;
      }
      locala = c.vGN;
      c.a.FU(params.id);
      params = params.MtI;
      if (params == null) {
        break label384;
      }
      l1 = params.hFK;
      label222:
      if (l1 != 0L)
      {
        params = c.vGN;
        c.a.FT(l1);
      }
    }
    label384:
    label390:
    for (;;)
    {
      if (l1 != 0L)
      {
        params = new hg();
        params.dLJ.id = l1;
        EventCenter.instance.publish((IEvent)params);
      }
      if ((this.tuO == null) && (this.tuP == null))
      {
        params = c.vGN;
        if (c.a.FT(this.hFK))
        {
          params = new hg();
          params.dLJ.id = this.hFK;
          EventCenter.instance.publish((IEvent)params);
        }
      }
      params = this.callback;
      if (params == null) {
        break label393;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(242350);
      return;
      label372:
      l1 = 0L;
      break;
      label378:
      l1 = 0L;
      break label179;
      l1 = 0L;
      break label222;
    }
    label393:
    AppMethodBeat.o(242350);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(165205);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(165205);
    return i;
  }
  
  public final int getType()
  {
    return 3627;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.av
 * JD-Core Version:    0.7.0.1
 */