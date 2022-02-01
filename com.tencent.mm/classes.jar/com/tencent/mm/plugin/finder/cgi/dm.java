package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.model.ao;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.z;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bvr;
import com.tencent.mm.protocal.protobuf.bvs;
import com.tencent.mm.protocal.protobuf.bvt;
import com.tencent.mm.protocal.protobuf.bvu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSnsGetLiveObjectList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "responseList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "getResponseList", "()Ljava/util/ArrayList;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "isFetchFeedCgi", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class dm
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public final ArrayList<cc> ADl;
  private final String TAG;
  private com.tencent.mm.am.h callback;
  private final b lastBuffer;
  public int pullType;
  public c rr;
  
  public dm(b paramb, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336890);
    this.lastBuffer = paramb;
    this.TAG = "Finder.NetSceneFinderSnsGetLiveObjectList";
    this.ADl = new ArrayList();
    paramb = new c.a();
    paramb.funcId = getType();
    Object localObject = new bvt();
    ((bvt)localObject).lastBuffer = this.lastBuffer;
    bi localbi = bi.ABn;
    ((bvt)localObject).ZEc = bi.a(parambui);
    paramb.otE = ((a)localObject);
    paramb.otF = ((a)new bvu());
    paramb.uri = "/cgi-bin/micromsg-bin/findersnsgetliveobjectlist";
    paramb = paramb.bEF();
    kotlin.g.b.s.s(paramb, "builder.buildInstance()");
    this.rr = paramb;
    parambui = this.TAG;
    localObject = new StringBuilder("NetSceneFinderSnsGetLiveObjectList pullType:").append(this.pullType).append(" lastBuffer:");
    if (this.lastBuffer == null) {}
    for (paramb = "null";; paramb = MD5Util.getMD5String(this.lastBuffer.Op))
    {
      Log.i(parambui, paramb);
      AppMethodBeat.o(336890);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336924);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    Object localObject1;
    Object localObject2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = c.c.b(this.rr.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSnsGetLiveObjectListResponse");
        AppMethodBeat.o(336924);
        throw paramString;
      }
      params = (bvu)params;
      localObject1 = params.aadD;
      localObject2 = params.aadF;
      Object localObject3 = params.aadE;
      Object localObject4;
      if (localObject3 != null)
      {
        localObject3 = ((bvs)localObject3).aadC;
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
                  label247:
                  int i;
                  if (localObject6 == null)
                  {
                    l = 0L;
                    localObject6 = (List)this.ADl;
                    paramInt1 = 0;
                    localObject6 = ((List)localObject6).iterator();
                    label267:
                    if (!((Iterator)localObject6).hasNext()) {
                      break label420;
                    }
                    Object localObject7 = (cc)((Iterator)localObject6).next();
                    if (!(localObject7 instanceof z)) {
                      break label407;
                    }
                    localObject7 = ((z)localObject7).ECN.liveInfo;
                    if ((localObject7 == null) || (((bip)localObject7).liveId != l)) {
                      break label401;
                    }
                    i = 1;
                    label329:
                    if (i == 0) {
                      break label407;
                    }
                    i = 1;
                    label337:
                    if (i == 0) {
                      break label413;
                    }
                  }
                  for (;;)
                  {
                    if (paramInt1 < 0) {
                      break label425;
                    }
                    Log.i(this.TAG, "exist: " + localObject4 + ", " + l + ", filter");
                    break;
                    l = ((bip)localObject6).liveId;
                    break label247;
                    label401:
                    i = 0;
                    break label329;
                    label407:
                    i = 0;
                    break label337;
                    label413:
                    paramInt1 += 1;
                    break label267;
                    label420:
                    paramInt1 = -1;
                  }
                  label425:
                  localObject6 = this.ADl;
                  kotlin.g.b.s.s(localObject5, "it");
                  ((ArrayList)localObject6).add(new z((FinderObject)localObject5));
                }
              }
            }
            if (localObject2 != null)
            {
              localIterator = ((Iterable)localObject2).iterator();
              while (localIterator.hasNext())
              {
                localObject5 = (bvr)localIterator.next();
                l = ((bvr)localObject5).ECY;
                if ((localObject4 != null) && (l == ((Long)localObject4).longValue())) {
                  this.ADl.add(new ao(((bvr)localObject5).ECY));
                }
              }
            }
          }
        }
      }
      if (this.ADl.isEmpty())
      {
        if (localObject1 != null) {
          if (!((Collection)localObject1).isEmpty())
          {
            paramInt1 = 1;
            if (paramInt1 != 1) {
              break label687;
            }
            paramInt1 = 1;
          }
        }
        label687:
        for (;;)
        {
          label579:
          if (paramInt1 != 0)
          {
            localObject2 = this.ADl;
            kotlin.g.b.s.s(localObject1, "liveObjects");
            localObject3 = (Iterable)localObject1;
            localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
            localObject3 = ((Iterable)localObject3).iterator();
            for (;;)
            {
              if (((Iterator)localObject3).hasNext())
              {
                localObject4 = (FinderObject)((Iterator)localObject3).next();
                kotlin.g.b.s.s(localObject4, "it");
                ((Collection)localObject1).add(new z((FinderObject)localObject4));
                continue;
                paramInt1 = 0;
                break;
                paramInt1 = 0;
                break label579;
              }
            }
            ((ArrayList)localObject2).addAll((Collection)localObject1);
          }
        }
      }
      localObject1 = com.tencent.mm.kernel.h.baE().ban();
      localObject2 = at.a.adel;
      if (!params.aadG) {
        break label816;
      }
    }
    label816:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      ((aq)localObject1).set((at.a)localObject2, Integer.valueOf(paramInt1));
      Log.i(this.TAG, "responseList size:" + this.ADl.size() + ", resp.enableSetting:" + params.aadG);
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
      }
      AppMethodBeat.o(336924);
      return;
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336903);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(336903);
    return i;
  }
  
  public final int getType()
  {
    return 6847;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.dm
 * JD-Core Version:    0.7.0.1
 */