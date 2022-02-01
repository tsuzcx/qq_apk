package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.model.ak;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcm;
import com.tencent.mm.protocal.protobuf.bcn;
import com.tencent.mm.protocal.protobuf.bco;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSnsGetLiveObjectList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "responseList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "getResponseList", "()Ljava/util/ArrayList;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "isFetchFeedCgi", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ch
  extends ax
{
  private final String TAG;
  private i callback;
  private final b lastBuffer;
  public int pullType;
  public d rr;
  public final ArrayList<bo> twn;
  
  public ch(b paramb, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242511);
    this.lastBuffer = paramb;
    this.TAG = "Finder.NetSceneFinderSnsGetLiveObjectList";
    this.twn = new ArrayList();
    paramb = new d.a();
    paramb.sG(getType());
    Object localObject = new bco();
    ((bco)localObject).lastBuffer = this.lastBuffer;
    am localam = am.tuw;
    ((bco)localObject).LAI = am.a(parambbn);
    paramb.c((a)localObject);
    paramb.d((a)new bcp());
    paramb.MB("/cgi-bin/micromsg-bin/findersnsgetliveobjectlist");
    paramb = paramb.aXF();
    p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    parambbn = this.TAG;
    localObject = new StringBuilder("NetSceneFinderSnsGetLiveObjectList pullType:").append(this.pullType).append(" lastBuffer:");
    if (this.lastBuffer == null) {}
    for (paramb = "null";; paramb = MD5Util.getMD5String(this.lastBuffer.zy))
    {
      Log.i(parambbn, paramb);
      AppMethodBeat.o(242511);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242510);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    Object localObject1;
    Object localObject2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.rr.aYK();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSnsGetLiveObjectListResponse");
        AppMethodBeat.o(242510);
        throw paramString;
      }
      params = (bcp)params;
      localObject1 = params.LLG;
      localObject2 = params.LLI;
      Object localObject3 = params.LLH;
      Object localObject4;
      if (localObject3 != null)
      {
        localObject3 = ((bcn)localObject3).LLF;
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
                    l = ((awe)localObject6).liveId;
                    localObject6 = (List)this.twn;
                    paramInt1 = 0;
                    localObject6 = ((List)localObject6).iterator();
                    label268:
                    if (!((Iterator)localObject6).hasNext()) {
                      break label403;
                    }
                    Object localObject7 = (bo)((Iterator)localObject6).next();
                    if (!(localObject7 instanceof y)) {
                      break label390;
                    }
                    localObject7 = ((y)localObject7).uOo.liveInfo;
                    if ((localObject7 == null) || (((awe)localObject7).liveId != l)) {
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
                  localObject6 = this.twn;
                  p.g(localObject5, "it");
                  ((ArrayList)localObject6).add(new y((FinderObject)localObject5));
                }
              }
            }
            if (localObject2 != null)
            {
              localIterator = ((Iterable)localObject2).iterator();
              while (localIterator.hasNext())
              {
                localObject5 = (bcm)localIterator.next();
                l = ((bcm)localObject5).uOx;
                if ((localObject4 != null) && (l == ((Long)localObject4).longValue())) {
                  this.twn.add(new ak(((bcm)localObject5).uOx));
                }
              }
            }
          }
        }
      }
      if ((this.twn.isEmpty()) && (localObject1 != null))
      {
        if (!((Collection)localObject1).isEmpty()) {
          paramInt1 = 1;
        }
        while (paramInt1 == 1)
        {
          localObject2 = this.twn;
          localObject3 = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext())
            {
              localObject4 = (FinderObject)((Iterator)localObject3).next();
              p.g(localObject4, "it");
              ((Collection)localObject1).add(new y((FinderObject)localObject4));
              continue;
              paramInt1 = 0;
              break;
            }
          }
          ((ArrayList)localObject2).addAll((Collection)localObject1);
        }
      }
      localObject1 = com.tencent.mm.kernel.g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((e)localObject1).azQ();
      localObject2 = ar.a.OmP;
      if (!params.LLJ) {
        break label792;
      }
    }
    label792:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      ((ao)localObject1).set((ar.a)localObject2, Integer.valueOf(paramInt1));
      Log.i(this.TAG, "responseList size:" + this.twn.size() + ", resp.enableSetting:" + params.LLJ);
      params = this.callback;
      if (params == null) {
        break;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(242510);
      return;
    }
    AppMethodBeat.o(242510);
  }
  
  public final boolean cXQ()
  {
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(242509);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242509);
    return i;
  }
  
  public final int getType()
  {
    return 6847;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ch
 * JD-Core Version:    0.7.0.1
 */