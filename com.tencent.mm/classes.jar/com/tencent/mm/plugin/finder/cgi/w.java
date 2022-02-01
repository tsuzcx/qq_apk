package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aki;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOriginalUserFeeds;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "refObjectId", "", "refObjectNonceId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "TAG", "getTAG", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "()I", "getRefObjectId", "()J", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUsername", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/FinderOriginalUserFeedsResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class w
  extends n
  implements com.tencent.mm.network.k
{
  private final String TAG;
  private g callback;
  private final com.tencent.mm.bx.b lastBuffer;
  public final int pullType;
  public List<? extends FinderItem> qpi;
  public final long refObjectId;
  private com.tencent.mm.al.b rr;
  private final String username;
  
  public w(String paramString1, long paramLong, String paramString2, com.tencent.mm.bx.b paramb, int paramInt)
  {
    AppMethodBeat.i(165253);
    this.username = paramString1;
    this.refObjectId = paramLong;
    this.lastBuffer = paramb;
    this.pullType = paramInt;
    this.TAG = "Finder.NetSceneFinderOriginalUserFeeds";
    paramString1 = new com.tencent.mm.al.b.a();
    paramString1.nB(getType());
    paramb = new aki();
    paramb.username = this.username;
    paramb.refObjectId = this.refObjectId;
    paramb.refObjectNonceId = paramString2;
    paramb.finderUsername = u.aqO();
    paramb.lastBuffer = this.lastBuffer;
    paramString2 = am.KJy;
    paramb.Dkw = am.fRS();
    paramString1.c((a)paramb);
    paramString1.nB(getType());
    paramString1.d((a)new akj());
    paramString1.wg("/cgi-bin/micromsg-bin/finderoriginaluserfeeds");
    paramString1 = paramString1.atI();
    d.g.b.k.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    ad.i(this.TAG, "NetSceneFinderOriginalUserFeeds " + this.refObjectId);
    AppMethodBeat.o(165253);
  }
  
  public final akj ckU()
  {
    AppMethodBeat.i(165252);
    Object localObject = this.rr;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.al.b)localObject).auM(); localObject == null; localObject = null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOriginalUserFeedsResponse");
      AppMethodBeat.o(165252);
      throw ((Throwable)localObject);
    }
    localObject = (akj)localObject;
    AppMethodBeat.o(165252);
    return localObject;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(165250);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(165250);
    return i;
  }
  
  public final int getType()
  {
    return 3581;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    boolean bool2 = true;
    AppMethodBeat.i(165251);
    ad.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.rr.auM();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOriginalUserFeedsResponse");
        AppMethodBeat.o(165251);
        throw paramString;
      }
      paramq = ((akj)paramq).object;
      if (paramq == null) {
        d.g.b.k.fvU();
      }
      ad.i(this.TAG, "onGYNetEnd list:" + paramq.size());
      boolean bool1;
      if (this.pullType != 2)
      {
        bool1 = true;
        if (!bool1) {
          break label276;
        }
        paramArrayOfByte = (Collection)paramq;
        if ((paramArrayOfByte != null) && (!paramArrayOfByte.isEmpty())) {
          break label271;
        }
        paramInt1 = 1;
        label176:
        if (paramInt1 == 0) {
          break label276;
        }
      }
      for (;;)
      {
        paramArrayOfByte = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
        paramArrayOfByte = (Iterable)paramq;
        paramq = (Collection)new ArrayList();
        paramArrayOfByte = paramArrayOfByte.iterator();
        while (paramArrayOfByte.hasNext())
        {
          Object localObject = paramArrayOfByte.next();
          FinderObject localFinderObject = (FinderObject)localObject;
          i locali = i.qTa;
          if (i.f(localFinderObject)) {
            paramq.add(localObject);
          }
        }
        bool1 = false;
        break;
        label271:
        paramInt1 = 0;
        break label176;
        label276:
        bool2 = false;
      }
      this.qpi = com.tencent.mm.plugin.finder.storage.logic.b.a.a((List)paramq, 2, bool1, this.username, bool2, null, 96);
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.fvU();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(165251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.w
 * JD-Core Version:    0.7.0.1
 */