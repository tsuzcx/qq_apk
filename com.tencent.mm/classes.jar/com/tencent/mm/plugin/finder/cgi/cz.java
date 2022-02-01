package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.findersdk.b.a.b;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.brv;
import com.tencent.mm.protocal.protobuf.brw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOplog;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "cmdList", "", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "isMegaVideo", "", "(Ljava/lang/String;Ljava/util/List;Z)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "isIgnoreSpam", "()Z", "setIgnoreSpam", "(Z)V", "requestExt", "Lorg/json/JSONObject;", "resultExt", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "actionExt", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCmdItemList", "getCmdRetList", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "getType", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cz
  extends com.tencent.mm.plugin.findersdk.b.h
{
  private final JSONObject AAn;
  private final JSONObject ABH;
  public boolean ACS;
  private final String TAG;
  private com.tencent.mm.am.h callback;
  private c rr;
  
  public cz(String arg1, List<? extends auw> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(336610);
    this.TAG = "Finder.NetSceneFinderOplog";
    this.AAn = new JSONObject();
    this.ABH = new JSONObject();
    Object localObject = new c.a();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/finderoplog";
    brv localbrv = new brv();
    localbrv.username = ???;
    localbrv.zMR.addAll((Collection)paramList);
    ??? = bi.ABn;
    localbrv.CJv = bi.dVu();
    ??? = localbrv.CJv;
    kotlin.g.b.s.checkNotNull(???);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ???.scene = i;
      ((c.a)localObject).otE = ((com.tencent.mm.bx.a)localbrv);
      ((c.a)localObject).otF = ((com.tencent.mm.bx.a)new brw());
      ??? = ((c.a)localObject).bEF();
      kotlin.g.b.s.s(???, "builder.buildInstance()");
      this.rr = ???;
      synchronized ((Iterable)paramList)
      {
        paramList = ???.iterator();
        i = j;
        while (paramList.hasNext())
        {
          localObject = (auw)paramList.next();
          this.ABH.put(kotlin.g.b.s.X("req", Integer.valueOf(i)), ((auw)localObject).cmdId);
          i += 1;
        }
        paramList = ah.aiuX;
        this.ABH.put("isMegaVideo", paramBoolean);
        Log.i(this.TAG, "NetSceneFinderOplog init ");
        AppMethodBeat.o(336610);
        return;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336671);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    Log.i(this.TAG, kotlin.g.b.s.X("retList ", Integer.valueOf(dWp().size())));
    this.AAn.put("retsize", dWp().size());
    params = dWp().iterator();
    paramInt1 = 0;
    Object localObject;
    while (params.hasNext())
    {
      localObject = (aux)params.next();
      this.AAn.put(kotlin.g.b.s.X("resp", Integer.valueOf(paramInt1)), ((aux)localObject).retCode);
      this.AAn.put(kotlin.g.b.s.X("respm", Integer.valueOf(paramInt1)), ((aux)localObject).wZb);
      paramInt1 += 1;
    }
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    paramString = dWp().iterator();
    while (paramString.hasNext())
    {
      params = (aux)paramString.next();
      Log.i(this.TAG, "retCode " + params.retCode + " retMsg " + params.wZb);
      if (!this.ACS)
      {
        localObject = com.tencent.mm.plugin.findersdk.d.a.Hdr;
        paramInt1 = params.retCode;
        params = params.wZb;
        if (!Util.isNullOrNil(params)) {
          switch (paramInt1)
          {
          default: 
            com.tencent.mm.plugin.findersdk.d.a.A(4, paramInt1, params);
            break;
          case -4006: 
            if (params != null) {
              com.tencent.mm.plugin.findersdk.d.a.aDg(params);
            }
            f.Ozc.idkeyStat(1264L, 0L, 1L, false);
            break;
          case -4007: 
            if (params != null) {
              com.tencent.mm.plugin.findersdk.d.a.aDg(params);
            }
            f.Ozc.idkeyStat(1264L, 1L, 1L, false);
            break;
          case -4017: 
            if (params != null) {
              com.tencent.mm.plugin.findersdk.d.a.aDg(params);
            }
            f.Ozc.idkeyStat(1264L, 2L, 1L, false);
            break;
          case -4005: 
            if (params != null) {
              com.tencent.mm.plugin.findersdk.d.a.aDg(params);
            }
            f.Ozc.idkeyStat(1264L, 5L, 1L, false);
            break;
          case -4019: 
            if (params != null) {
              com.tencent.mm.plugin.findersdk.d.a.aDg(params);
            }
            f.Ozc.idkeyStat(1264L, 6L, 1L, false);
          }
        }
      }
    }
    AppMethodBeat.o(336671);
  }
  
  public final b dVi()
  {
    return b.Hde;
  }
  
  public final JSONObject dVk()
  {
    return this.ABH;
  }
  
  public final JSONObject dVl()
  {
    return this.AAn;
  }
  
  public final List<auw> dWo()
  {
    AppMethodBeat.i(165246);
    Object localObject = this.rr;
    kotlin.g.b.s.checkNotNull(localObject);
    localObject = c.b.b(((c)localObject).otB);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOplogRequest");
      AppMethodBeat.o(165246);
      throw ((Throwable)localObject);
    }
    localObject = ((brv)localObject).zMR;
    kotlin.g.b.s.s(localObject, "rr!!.requestProtoBuf as …nderOplogRequest).cmdList");
    localObject = (List)localObject;
    AppMethodBeat.o(165246);
    return localObject;
  }
  
  public final List<aux> dWp()
  {
    AppMethodBeat.i(165247);
    Object localObject = this.rr;
    kotlin.g.b.s.checkNotNull(localObject);
    localObject = c.c.b(((c)localObject).otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOplogResponse");
      AppMethodBeat.o(165247);
      throw ((Throwable)localObject);
    }
    localObject = ((brw)localObject).wuE;
    kotlin.g.b.s.s(localObject, "rr!!.responseProtoBuf as…derOplogResponse).retList");
    localObject = (List)localObject;
    AppMethodBeat.o(165247);
    return localObject;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(165244);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(165244);
    return i;
  }
  
  public final int getType()
  {
    return 3870;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cz
 * JD-Core Version:    0.7.0.1
 */