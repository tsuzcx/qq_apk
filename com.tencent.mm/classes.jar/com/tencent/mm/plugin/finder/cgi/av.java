package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqf;
import com.tencent.mm.protocal.protobuf.aqg;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOriginalUserFeeds;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "refObjectId", "", "refObjectNonceId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "TAG", "getTAG", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "()I", "getRefObjectId", "()J", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUsername", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/FinderOriginalUserFeedsResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class av
  extends n
  implements k
{
  private final String TAG;
  private f callback;
  private final com.tencent.mm.bx.b lastBuffer;
  public final int pullType;
  public List<? extends FinderItem> rJo;
  public final long refObjectId;
  private com.tencent.mm.al.b rr;
  private final String username;
  
  public av(String paramString1, long paramLong, String paramString2, com.tencent.mm.bx.b paramb, int paramInt)
  {
    AppMethodBeat.i(165253);
    this.username = paramString1;
    this.refObjectId = paramLong;
    this.lastBuffer = paramb;
    this.pullType = paramInt;
    this.TAG = "Finder.NetSceneFinderOriginalUserFeeds";
    paramString1 = new com.tencent.mm.al.b.a();
    paramString1.oP(getType());
    paramb = new aqf();
    paramb.username = this.username;
    paramb.refObjectId = this.refObjectId;
    paramb.refObjectNonceId = paramString2;
    paramb.rTn = u.aAu();
    paramb.lastBuffer = this.lastBuffer;
    paramString2 = v.rIR;
    paramb.Glv = v.cxY();
    paramString1.c((a)paramb);
    paramString1.oP(getType());
    paramString1.d((a)new aqg());
    paramString1.Dl("/cgi-bin/micromsg-bin/finderoriginaluserfeeds");
    paramString1 = paramString1.aDC();
    d.g.b.p.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    ad.i(this.TAG, "NetSceneFinderOriginalUserFeeds " + this.refObjectId);
    AppMethodBeat.o(165253);
  }
  
  public final aqg cyH()
  {
    AppMethodBeat.i(165252);
    Object localObject = this.rr;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.al.b)localObject).aEF(); localObject == null; localObject = null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOriginalUserFeedsResponse");
      AppMethodBeat.o(165252);
      throw ((Throwable)localObject);
    }
    localObject = (aqg)localObject;
    AppMethodBeat.o(165252);
    return localObject;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(165250);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(165250);
    return i;
  }
  
  public final int getType()
  {
    return 3581;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    AppMethodBeat.i(165251);
    ad.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.rr.aEF();
      if (paramq == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOriginalUserFeedsResponse");
        AppMethodBeat.o(165251);
        throw paramString;
      }
      paramq = ((aqg)paramq).object;
      if (paramq == null) {
        d.g.b.p.gfZ();
      }
      ad.i(this.TAG, "onGYNetEnd list:" + paramq.size());
      boolean bool1;
      if (this.pullType != 2)
      {
        paramInt1 = 1;
        bool1 = bool2;
        if (paramInt1 != 0)
        {
          paramArrayOfByte = (Collection)paramq;
          if ((paramArrayOfByte != null) && (!paramArrayOfByte.isEmpty())) {
            break label281;
          }
        }
      }
      Object localObject1;
      Object localObject2;
      label281:
      for (int i = 1;; i = 0)
      {
        bool1 = bool2;
        if (i != 0) {
          bool1 = true;
        }
        paramArrayOfByte = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
        paramArrayOfByte = (Iterable)paramq;
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
        paramInt1 = 0;
        break;
      }
      this.rJo = com.tencent.mm.plugin.finder.storage.logic.b.a.a((List)paramq, 2, null, 12);
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
          com.tencent.mm.plugin.finder.storage.logic.b.a.a((List)paramq, 2, this.username, bool1);
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
    AppMethodBeat.o(165251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.av
 * JD-Core Version:    0.7.0.1
 */