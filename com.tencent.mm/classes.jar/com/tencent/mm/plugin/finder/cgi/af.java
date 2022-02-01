package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.f;
import com.tencent.mm.ak.g;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.akv;
import com.tencent.mm.protocal.protobuf.akw;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.a.j;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLikedList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "lastPlayId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "targetUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLcom/tencent/mm/protobuf/ByteString;ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getTargetUsername", "()Ljava/lang/String;", "setTargetUsername", "(Ljava/lang/String;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getLastDisplayId", "getLikedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getMaxId", "getRespLastBuffer", "kotlin.jvm.PlatformType", "getType", "isFetchFeedCgi", "", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class af
  extends w
{
  private final String TAG;
  private g callback;
  public int pullType;
  public List<? extends FinderItem> qYc;
  private String qYd;
  private com.tencent.mm.ak.b rr;
  
  public af(long paramLong, com.tencent.mm.bw.b paramb, int paramInt, String paramString, anm paramanm)
  {
    super(paramanm);
    AppMethodBeat.i(201189);
    this.TAG = "Finder.NetSceneFinderGetLikedList";
    this.qYd = "";
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    locala.op(getType());
    this.pullType = paramInt;
    this.qYd = paramString;
    akv localakv = new akv();
    localakv.EEK = paramLong;
    localakv.lastBuffer = paramb;
    localakv.EEI = u.axE();
    localakv.qYd = paramString;
    paramb = q.qXH;
    localakv.EDL = q.a(paramanm);
    locala.c((a)localakv);
    locala.op(getType());
    locala.d((a)new akw());
    locala.Am("/cgi-bin/micromsg-bin/findergetlikedlist");
    paramb = locala.aAz();
    d.g.b.k.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    ac.i(this.TAG, "NetSceneFinderGetLikedList init: " + paramLong + ' ' + localakv.EEI);
    AppMethodBeat.o(201189);
  }
  
  public final boolean csf()
  {
    return true;
  }
  
  public final com.tencent.mm.bw.b csy()
  {
    AppMethodBeat.i(201187);
    Object localObject = this.rr.aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(201187);
      throw ((Throwable)localObject);
    }
    localObject = ((akw)localObject).lastBuffer;
    AppMethodBeat.o(201187);
    return localObject;
  }
  
  public final int csz()
  {
    AppMethodBeat.i(201188);
    Object localObject = this.rr.aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(201188);
      throw ((Throwable)localObject);
    }
    int i = ((akw)localObject).continueFlag;
    AppMethodBeat.o(201188);
    return i;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(165226);
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(165226);
    return i;
  }
  
  public final int getType()
  {
    return 3965;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165227);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ac.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.rr.aBD();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
        AppMethodBeat.o(165227);
        throw paramString;
      }
      d.g.b.k.g(((akw)paramq).EEL, "(rr.responseProtoBuf as …dListResponse).liked_list");
      paramq = this.rr.aBD();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
        AppMethodBeat.o(165227);
        throw paramString;
      }
      paramq = (akw)paramq;
      paramArrayOfByte = paramq.EEL;
      d.g.b.k.g(paramArrayOfByte, "resp.liked_list");
      if (paramArrayOfByte.size() > 0)
      {
        localObject1 = paramArrayOfByte.get(0);
        d.g.b.k.g(localObject1, "list[0]");
        localObject1 = (FinderObject)localObject1;
        ac.i(this.TAG, "onGYNetEnd list:" + paramArrayOfByte.size() + " firstItem:" + f.bD(localObject1));
      }
      Object localObject1 = this.TAG;
      Object localObject2 = new StringBuilder("onGYNetEnd list:").append(paramArrayOfByte.size()).append(", continueFlag:").append(paramq.continueFlag).append(", maxId:");
      paramq = (FinderObject)j.iR((List)paramArrayOfByte);
      boolean bool1;
      if (paramq != null)
      {
        paramq = Long.valueOf(paramq.displayId);
        ac.i((String)localObject1, paramq + ' ');
        if ((this.pullType == 2) || (!bs.isNullOrNil(this.qYd))) {
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
          com.tencent.mm.plugin.finder.utils.n localn = com.tencent.mm.plugin.finder.utils.n.rPN;
          if (com.tencent.mm.plugin.finder.utils.n.n((FinderObject)localObject2)) {
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
      paramArrayOfByte = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
      this.qYc = com.tencent.mm.plugin.finder.storage.logic.b.a.a(paramq, 4, bool1, null, bool2, this.contextObj, 40);
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.fOy();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
    }
    AppMethodBeat.o(165227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.af
 * JD-Core Version:    0.7.0.1
 */