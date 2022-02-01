package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLikedList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "lastPlayId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "targetUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLcom/tencent/mm/protobuf/ByteString;ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getTargetUsername", "()Ljava/lang/String;", "setTargetUsername", "(Ljava/lang/String;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getCount", "getLastDisplayId", "getLikedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getMaxId", "getRespLastBuffer", "kotlin.jvm.PlatformType", "getType", "isFetchFeedCgi", "", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class am
  extends ac
{
  public final String TAG;
  private com.tencent.mm.al.f callback;
  public int pullType;
  public List<? extends FinderItem> rJo;
  private String rJp;
  public com.tencent.mm.al.b rr;
  
  public am(long paramLong, com.tencent.mm.bx.b paramb, int paramInt, String paramString, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(201137);
    this.TAG = "Finder.NetSceneFinderGetLikedList";
    this.rJp = "";
    com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
    locala.oP(getType());
    this.pullType = paramInt;
    this.rJp = paramString;
    anw localanw = new anw();
    localanw.GmH = paramLong;
    localanw.lastBuffer = paramb;
    localanw.Gmz = u.aAu();
    localanw.rJp = paramString;
    paramb = v.rIR;
    localanw.Glv = v.a(paramaqy);
    locala.c((a)localanw);
    locala.oP(getType());
    locala.d((a)new anx());
    locala.Dl("/cgi-bin/micromsg-bin/findergetlikedlist");
    paramb = locala.aDC();
    d.g.b.p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ad.i(this.TAG, "NetSceneFinderGetLikedList init: " + paramLong + ' ' + localanw.Gmz);
    AppMethodBeat.o(201137);
  }
  
  public final boolean cxU()
  {
    return true;
  }
  
  public final com.tencent.mm.bx.b cyp()
  {
    AppMethodBeat.i(201135);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(201135);
      throw ((Throwable)localObject);
    }
    localObject = ((anx)localObject).lastBuffer;
    AppMethodBeat.o(201135);
    return localObject;
  }
  
  public final int cyq()
  {
    AppMethodBeat.i(201136);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(201136);
      throw ((Throwable)localObject);
    }
    int i = ((anx)localObject).continueFlag;
    AppMethodBeat.o(201136);
    return i;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
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
    ad.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.rr.aEF();
      if (paramq == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
        AppMethodBeat.o(165227);
        throw paramString;
      }
      d.g.b.p.g(((anx)paramq).GmI, "(rr.responseProtoBuf as …dListResponse).liked_list");
      paramq = this.rr.aEF();
      if (paramq == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
        AppMethodBeat.o(165227);
        throw paramString;
      }
      paramq = (anx)paramq;
      paramArrayOfByte = paramq.GmI;
      d.g.b.p.g(paramArrayOfByte, "resp.liked_list");
      if (paramArrayOfByte.size() > 0)
      {
        localObject1 = paramArrayOfByte.get(0);
        d.g.b.p.g(localObject1, "list[0]");
        localObject1 = (FinderObject)localObject1;
        ad.i(this.TAG, "onGYNetEnd list:" + paramArrayOfByte.size() + " firstItem:" + com.tencent.mm.ad.f.bF(localObject1));
      }
      Object localObject1 = this.TAG;
      Object localObject2 = new StringBuilder("onGYNetEnd list:").append(paramArrayOfByte.size()).append(", continueFlag:").append(paramq.continueFlag).append(", maxId:");
      paramq = (FinderObject)j.jf((List)paramArrayOfByte);
      label355:
      int i;
      if (paramq != null)
      {
        paramq = Long.valueOf(paramq.displayId);
        ad.i((String)localObject1, paramq + ' ');
        if ((this.pullType == 2) || (!bt.isNullOrNil(this.rJp))) {
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
          com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
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
      paramArrayOfByte = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
      this.rJo = com.tencent.mm.plugin.finder.storage.logic.b.a.a(paramq, 4, this.rIl, 4);
      if (paramInt1 != 0)
      {
        paramq = this.rJo;
        if (paramq != null)
        {
          paramArrayOfByte = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
          paramArrayOfByte = (Iterable)paramq;
          paramq = (Collection)new ArrayList(j.a(paramArrayOfByte, 10));
          paramArrayOfByte = paramArrayOfByte.iterator();
          while (paramArrayOfByte.hasNext())
          {
            localObject1 = (FinderItem)paramArrayOfByte.next();
            localObject2 = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
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
        d.g.b.p.gfZ();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(165227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.am
 * JD-Core Version:    0.7.0.1
 */