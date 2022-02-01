package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bjh;
import com.tencent.mm.protocal.protobuf.bji;
import com.tencent.mm.protocal.protobuf.bjj;
import com.tencent.mm.protocal.protobuf.bjk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSnsGetLiveObjectList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "responseList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "getResponseList", "()Ljava/util/ArrayList;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "isFetchFeedCgi", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class cl
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private final String TAG;
  private i callback;
  private final b lastBuffer;
  public int pullType;
  public d rr;
  public final ArrayList<bu> xec;
  
  public cl(b paramb, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(266889);
    this.lastBuffer = paramb;
    this.TAG = "Finder.NetSceneFinderSnsGetLiveObjectList";
    this.xec = new ArrayList();
    paramb = new d.a();
    paramb.vD(getType());
    Object localObject = new bjj();
    ((bjj)localObject).lastBuffer = this.lastBuffer;
    ao localao = ao.xcj;
    ((bjj)localObject).SDi = ao.a(parambid);
    paramb.c((a)localObject);
    paramb.d((a)new bjk());
    paramb.TW("/cgi-bin/micromsg-bin/findersnsgetliveobjectlist");
    paramb = paramb.bgN();
    p.j(paramb, "builder.buildInstance()");
    this.rr = paramb;
    parambid = this.TAG;
    localObject = new StringBuilder("NetSceneFinderSnsGetLiveObjectList pullType:").append(this.pullType).append(" lastBuffer:");
    if (this.lastBuffer == null) {}
    for (paramb = "null";; paramb = MD5Util.getMD5String(this.lastBuffer.UH))
    {
      Log.i(parambid, paramb);
      AppMethodBeat.o(266889);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(266888);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    Object localObject1;
    Object localObject2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.rr.bhY();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSnsGetLiveObjectListResponse");
        AppMethodBeat.o(266888);
        throw paramString;
      }
      params = (bjk)params;
      localObject1 = params.STz;
      localObject2 = params.STB;
      Object localObject3 = params.STA;
      Object localObject4;
      if (localObject3 != null)
      {
        localObject3 = ((bji)localObject3).STy;
        if (localObject3 != null)
        {
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Long)((Iterator)localObject3).next();
            Iterator localIterator;
            Object localObject5;
            long l;
            if (localObject1 != null)
            {
              localIterator = ((Iterable)localObject1).iterator();
              while (localIterator.hasNext())
              {
                localObject5 = (FinderObject)localIterator.next();
                l = ((FinderObject)localObject5).id;
                if ((localObject4 != null) && (l == ((Long)localObject4).longValue()))
                {
                  Object localObject6 = ((FinderObject)localObject5).liveInfo;
                  label248:
                  int i;
                  if (localObject6 != null)
                  {
                    l = ((bac)localObject6).liveId;
                    localObject6 = (List)this.xec;
                    paramInt1 = 0;
                    localObject6 = ((List)localObject6).iterator();
                    label268:
                    if (!((Iterator)localObject6).hasNext()) {
                      break label403;
                    }
                    Object localObject7 = (bu)((Iterator)localObject6).next();
                    if (!(localObject7 instanceof y)) {
                      break label390;
                    }
                    localObject7 = ((y)localObject7).zAF.liveInfo;
                    if ((localObject7 == null) || (((bac)localObject7).liveId != l)) {
                      break label390;
                    }
                    i = 1;
                    label330:
                    if (i == 0) {
                      break label396;
                    }
                  }
                  for (;;)
                  {
                    if (paramInt1 < 0) {
                      break label408;
                    }
                    Log.i(this.TAG, "exist: " + localObject4 + ", " + l + ", filter");
                    break;
                    l = 0L;
                    break label248;
                    label390:
                    i = 0;
                    break label330;
                    label396:
                    paramInt1 += 1;
                    break label268;
                    label403:
                    paramInt1 = -1;
                  }
                  label408:
                  localObject6 = this.xec;
                  p.j(localObject5, "it");
                  ((ArrayList)localObject6).add(new y((FinderObject)localObject5));
                }
              }
            }
            if (localObject2 != null)
            {
              localIterator = ((Iterable)localObject2).iterator();
              while (localIterator.hasNext())
              {
                localObject5 = (bjh)localIterator.next();
                l = ((bjh)localObject5).zAO;
                if ((localObject4 != null) && (l == ((Long)localObject4).longValue())) {
                  this.xec.add(new am(((bjh)localObject5).zAO));
                }
              }
            }
          }
        }
      }
      if ((this.xec.isEmpty()) && (localObject1 != null))
      {
        if (!((Collection)localObject1).isEmpty()) {
          paramInt1 = 1;
        }
        while (paramInt1 == 1)
        {
          localObject2 = this.xec;
          localObject3 = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext())
            {
              localObject4 = (FinderObject)((Iterator)localObject3).next();
              p.j(localObject4, "it");
              ((Collection)localObject1).add(new y((FinderObject)localObject4));
              continue;
              paramInt1 = 0;
              break;
            }
          }
          ((ArrayList)localObject2).addAll((Collection)localObject1);
        }
      }
      localObject1 = h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      localObject1 = ((f)localObject1).aHp();
      localObject2 = ar.a.VBP;
      if (!params.STC) {
        break label792;
      }
    }
    label792:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      ((com.tencent.mm.storage.ao)localObject1).set((ar.a)localObject2, Integer.valueOf(paramInt1));
      Log.i(this.TAG, "responseList size:" + this.xec.size() + ", resp.enableSetting:" + params.STC);
      params = this.callback;
      if (params == null) {
        break;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(266888);
      return;
    }
    AppMethodBeat.o(266888);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(266887);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(266887);
    return i;
  }
  
  public final int getType()
  {
    return 6847;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cl
 * JD-Core Version:    0.7.0.1
 */