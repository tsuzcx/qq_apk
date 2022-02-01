package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.aok;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.a.j;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLikedList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "lastPlayId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "targetUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLcom/tencent/mm/protobuf/ByteString;ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getTargetUsername", "()Ljava/lang/String;", "setTargetUsername", "(Ljava/lang/String;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getCount", "getLastDisplayId", "getLikedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getMaxId", "getRespLastBuffer", "getType", "isFetchFeedCgi", "", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class an
  extends ad
{
  public final String TAG;
  private com.tencent.mm.ak.f callback;
  public int pullType;
  public List<? extends FinderItem> rRC;
  private String rRD;
  public com.tencent.mm.ak.b rr;
  
  public an(long paramLong, com.tencent.mm.bw.b paramb, int paramInt, String paramString, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(201559);
    this.TAG = "Finder.NetSceneFinderGetLikedList";
    this.rRD = "";
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    locala.oS(getType());
    this.pullType = paramInt;
    this.rRD = paramString;
    aoj localaoj = new aoj();
    localaoj.GFO = paramLong;
    localaoj.lastBuffer = paramb;
    localaoj.GDP = com.tencent.mm.model.v.aAK();
    localaoj.rRD = paramString;
    paramb = v.rRb;
    localaoj.GDR = v.a(paramarn);
    locala.c((a)localaoj);
    locala.oS(getType());
    locala.d((a)new aok());
    locala.DN("/cgi-bin/micromsg-bin/findergetlikedlist");
    paramb = locala.aDS();
    d.g.b.p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ae.i(this.TAG, "NetSceneFinderGetLikedList init: " + paramLong + ' ' + localaoj.GDP);
    AppMethodBeat.o(201559);
  }
  
  public final com.tencent.mm.bw.b czQ()
  {
    AppMethodBeat.i(201557);
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(201557);
      throw ((Throwable)localObject);
    }
    localObject = ((aok)localObject).lastBuffer;
    AppMethodBeat.o(201557);
    return localObject;
  }
  
  public final int czR()
  {
    AppMethodBeat.i(201558);
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(201558);
      throw ((Throwable)localObject);
    }
    int i = ((aok)localObject).continueFlag;
    AppMethodBeat.o(201558);
    return i;
  }
  
  public final boolean czv()
  {
    return true;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(165226);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(165226);
    return i;
  }
  
  public final int getType()
  {
    return 3965;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165227);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ae.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.rr.aEV();
      if (paramq == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
        AppMethodBeat.o(165227);
        throw paramString;
      }
      d.g.b.p.g(((aok)paramq).GFP, "(rr.responseProtoBuf as …dListResponse).liked_list");
      paramq = this.rr.aEV();
      if (paramq == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
        AppMethodBeat.o(165227);
        throw paramString;
      }
      paramq = (aok)paramq;
      paramArrayOfByte = paramq.GFP;
      d.g.b.p.g(paramArrayOfByte, "resp.liked_list");
      if (paramArrayOfByte.size() > 0)
      {
        localObject1 = paramArrayOfByte.get(0);
        d.g.b.p.g(localObject1, "list[0]");
        localObject1 = (FinderObject)localObject1;
        ae.i(this.TAG, "onGYNetEnd list:" + paramArrayOfByte.size() + " firstItem:" + com.tencent.mm.ac.f.bF(localObject1));
      }
      Object localObject1 = this.TAG;
      Object localObject2 = new StringBuilder("onGYNetEnd list:").append(paramArrayOfByte.size()).append(", continueFlag:").append(paramq.continueFlag).append(", maxId:");
      paramq = (FinderObject)j.jo((List)paramArrayOfByte);
      label355:
      int i;
      if (paramq != null)
      {
        paramq = Long.valueOf(paramq.displayId);
        ae.i((String)localObject1, paramq + ' ');
        if ((this.pullType == 2) || (!bu.isNullOrNil(this.rRD))) {
          break label478;
        }
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label489;
        }
        paramq = (Collection)paramArrayOfByte;
        if ((paramq != null) && (!paramq.isEmpty())) {
          break label483;
        }
        i = 1;
        label384:
        if (i == 0) {
          break label489;
        }
      }
      label478:
      label483:
      label489:
      for (boolean bool = true;; bool = false)
      {
        paramArrayOfByte = (Iterable)paramArrayOfByte;
        paramq = (Collection)new ArrayList();
        paramArrayOfByte = paramArrayOfByte.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = paramArrayOfByte.next();
          localObject2 = (FinderObject)localObject1;
          com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sXz;
          if (com.tencent.mm.plugin.finder.utils.p.o((FinderObject)localObject2)) {
            paramq.add(localObject1);
          }
        }
        paramq = null;
        break;
        paramInt1 = 0;
        break label355;
        i = 0;
        break label384;
      }
      paramq = (List)paramq;
      paramArrayOfByte = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
      this.rRC = com.tencent.mm.plugin.finder.storage.logic.b.a.a(paramq, 4, this.rQw, 4);
      if (paramInt1 != 0)
      {
        paramq = this.rRC;
        if (paramq != null)
        {
          paramArrayOfByte = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
          paramArrayOfByte = (Iterable)paramq;
          paramq = (Collection)new ArrayList(j.a(paramArrayOfByte, 10));
          paramArrayOfByte = paramArrayOfByte.iterator();
          while (paramArrayOfByte.hasNext())
          {
            localObject1 = (FinderItem)paramArrayOfByte.next();
            localObject2 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
            paramq.add(com.tencent.mm.plugin.finder.storage.logic.b.a.j((FinderItem)localObject1));
          }
          com.tencent.mm.plugin.finder.storage.logic.b.a.b((List)paramq, 4, bool);
        }
      }
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.p.gkB();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(165227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.an
 * JD-Core Version:    0.7.0.1
 */