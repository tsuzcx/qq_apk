package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.f.a.hn;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.protocal.protobuf.blj;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneDeleteFinderObject;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "objectId", "", "objectNonceId", "isMegaVideo", "", "(Ljava/lang/String;JLjava/lang/String;Z)V", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "megaVideo", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/MegaVideo;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getDelId", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ay
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private String TAG;
  private i callback;
  private d rr;
  public long xbk;
  private FinderObject xcx;
  private cvy xcy;
  
  public ay(String paramString1, long paramLong, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(285543);
    this.TAG = "Finder.NetSceneDeleteFinderObject";
    d.a locala = new d.a();
    locala.TW("/cgi-bin/micromsg-bin/finderdelfeed");
    locala.vD(getType());
    arx localarx = new arx();
    localarx.id = paramLong;
    localarx.objectNonceId = paramString2;
    localarx.SFp = paramString1;
    paramString1 = ao.xcj;
    localarx.yjp = ao.dnO();
    paramString1 = localarx.yjp;
    if (paramString1 == null) {
      p.iCn();
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramString1.scene = i;
      locala.c((a)localarx);
      locala.d((a)new ary());
      paramString1 = locala.bgN();
      p.j(paramString1, "builder.buildInstance()");
      this.rr = paramString1;
      this.xbk = paramLong;
      AppMethodBeat.o(285543);
      return;
    }
  }
  
  public ay(String paramString, FinderObject paramFinderObject)
  {
    this(paramString, l, str1);
    AppMethodBeat.i(285544);
    this.xcx = paramFinderObject;
    AppMethodBeat.o(285544);
  }
  
  public ay(String paramString, cvy paramcvy) {}
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(285542);
    Log.i(this.TAG, "errType " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    long l1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.xcx;
      if (params == null) {
        break label378;
      }
      c.a locala = c.AnK;
      c.a.MT(this.xbk);
      long l2 = this.xbk;
      params = params.attachmentList;
      if (params == null) {
        break label372;
      }
      params = params.SDm;
      if (params == null) {
        break label372;
      }
      params = (apw)j.lp((List)params);
      if (params == null) {
        break label372;
      }
      params = params.SDl;
      if (params == null) {
        break label372;
      }
      params = params.SPm;
      if (params == null) {
        break label372;
      }
      l1 = params.id;
      if (l1 != 0L)
      {
        params = c.AnK;
        c.a.MU(l1);
      }
      l1 = l2;
      label179:
      params = this.xcy;
      if (params == null) {
        break label390;
      }
      locala = c.AnK;
      c.a.MU(params.id);
      params = params.TEO;
      if (params == null) {
        break label384;
      }
      l1 = params.xbk;
      label222:
      if (l1 != 0L)
      {
        params = c.AnK;
        c.a.MT(l1);
      }
    }
    label384:
    label390:
    for (;;)
    {
      if (l1 != 0L)
      {
        params = new hn();
        params.fEy.id = l1;
        EventCenter.instance.publish((IEvent)params);
      }
      if ((this.xcx == null) && (this.xcy == null))
      {
        params = c.AnK;
        if (c.a.MT(this.xbk))
        {
          params = new hn();
          params.fEy.id = this.xbk;
          EventCenter.instance.publish((IEvent)params);
        }
      }
      params = this.callback;
      if (params == null) {
        break label393;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(285542);
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
    AppMethodBeat.o(285542);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ay
 * JD-Core Version:    0.7.0.1
 */