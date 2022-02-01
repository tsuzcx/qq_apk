package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.f;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ajd;
import com.tencent.mm.protocal.protobuf.aje;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLikedList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "lastPlayId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "targetUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLcom/tencent/mm/protobuf/ByteString;ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getTargetUsername", "()Ljava/lang/String;", "setTargetUsername", "(Ljava/lang/String;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getLastDisplayId", "getLikedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getMaxId", "getRespLastBuffer", "kotlin.jvm.PlatformType", "getType", "isFetchFeedCgi", "", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class r
  extends ap
{
  private final String TAG;
  private g callback;
  public int pullType;
  public List<? extends FinderItem> qpi;
  private String qwI;
  private com.tencent.mm.al.b rr;
  
  public r(long paramLong, com.tencent.mm.bx.b paramb, int paramInt, String paramString, dzp paramdzp)
  {
    super(paramdzp);
    AppMethodBeat.i(197311);
    this.TAG = "Finder.NetSceneFinderGetLikedList";
    this.qwI = "";
    com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
    locala.nB(getType());
    this.pullType = paramInt;
    this.qwI = paramString;
    ajd localajd = new ajd();
    localajd.Dlu = paramLong;
    localajd.lastBuffer = paramb;
    localajd.Dls = u.aqO();
    localajd.qwI = paramString;
    paramb = am.KJy;
    localajd.Dkw = am.a(paramdzp);
    locala.c((a)localajd);
    locala.nB(getType());
    locala.d((a)new aje());
    locala.wg("/cgi-bin/micromsg-bin/findergetlikedlist");
    paramb = locala.atI();
    d.g.b.k.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ad.i(this.TAG, "NetSceneFinderGetLikedList init: " + paramLong + ' ' + localajd.Dls);
    AppMethodBeat.o(197311);
  }
  
  public final com.tencent.mm.bx.b ckN()
  {
    AppMethodBeat.i(197309);
    Object localObject = this.rr.auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(197309);
      throw ((Throwable)localObject);
    }
    localObject = ((aje)localObject).lastBuffer;
    AppMethodBeat.o(197309);
    return localObject;
  }
  
  public final int ckO()
  {
    AppMethodBeat.i(197310);
    Object localObject = this.rr.auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(197310);
      throw ((Throwable)localObject);
    }
    int i = ((aje)localObject).continueFlag;
    AppMethodBeat.o(197310);
    return i;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(165226);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(165226);
    return i;
  }
  
  public final boolean fRR()
  {
    return true;
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
      paramq = this.rr.auM();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
        AppMethodBeat.o(165227);
        throw paramString;
      }
      d.g.b.k.g(((aje)paramq).Dlv, "(rr.responseProtoBuf as …dListResponse).liked_list");
      paramq = this.rr.auM();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
        AppMethodBeat.o(165227);
        throw paramString;
      }
      paramq = (aje)paramq;
      paramArrayOfByte = paramq.Dlv;
      d.g.b.k.g(paramArrayOfByte, "resp.liked_list");
      if (paramArrayOfByte.size() > 0)
      {
        localObject1 = paramArrayOfByte.get(0);
        d.g.b.k.g(localObject1, "list[0]");
        localObject1 = (FinderObject)localObject1;
        ad.i(this.TAG, "onGYNetEnd list:" + paramArrayOfByte.size() + " firstItem:" + f.bG(localObject1));
      }
      Object localObject1 = this.TAG;
      Object localObject2 = new StringBuilder("onGYNetEnd list:").append(paramArrayOfByte.size()).append(", continueFlag:").append(paramq.continueFlag).append(", maxId:");
      paramq = (FinderObject)j.iB((List)paramArrayOfByte);
      boolean bool1;
      if (paramq != null)
      {
        paramq = Long.valueOf(paramq.displayId);
        ad.i((String)localObject1, paramq + ' ');
        if ((this.pullType == 2) || (!bt.isNullOrNil(this.qwI))) {
          break label478;
        }
        bool1 = true;
        label356:
        if (!bool1) {
          break label489;
        }
        paramq = (Collection)paramArrayOfByte;
        if ((paramq != null) && (!paramq.isEmpty())) {
          break label484;
        }
        paramInt1 = 1;
        label385:
        if (paramInt1 == 0) {
          break label489;
        }
      }
      label478:
      label484:
      label489:
      for (boolean bool2 = true;; bool2 = false)
      {
        paramArrayOfByte = (Iterable)paramArrayOfByte;
        paramq = (Collection)new ArrayList();
        paramArrayOfByte = paramArrayOfByte.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = paramArrayOfByte.next();
          localObject2 = (FinderObject)localObject1;
          i locali = i.qTa;
          if (i.f((FinderObject)localObject2)) {
            paramq.add(localObject1);
          }
        }
        paramq = null;
        break;
        bool1 = false;
        break label356;
        paramInt1 = 0;
        break label385;
      }
      paramq = (List)paramq;
      paramArrayOfByte = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
      this.qpi = com.tencent.mm.plugin.finder.storage.logic.b.a.a(paramq, 4, bool1, null, bool2, this.contextObj, 40);
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.fvU();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(165227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.r
 * JD-Core Version:    0.7.0.1
 */