package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLikedList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "lastPlayId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "targetUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "saveCache", "", "(JLcom/tencent/mm/protobuf/ByteString;ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;IZ)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSaveCache", "()Z", "setSaveCache", "(Z)V", "getTargetUsername", "()Ljava/lang/String;", "setTargetUsername", "(Ljava/lang/String;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getCount", "getLastDisplayId", "getLikedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getMaxId", "getMegaVideoCount", "getRespLastBuffer", "getType", "isFetchFeedCgi", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bp
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private final String TAG;
  private i callback;
  private int fEH;
  public int pullType;
  private d rr;
  public List<? extends FinderItem> xcV;
  private String xcW;
  private boolean xcX;
  
  private bp(long paramLong, b paramb, int paramInt1, String paramString, bid parambid, int paramInt2, boolean paramBoolean)
  {
    super(parambid);
    AppMethodBeat.i(279076);
    this.TAG = "Finder.NetSceneFinderGetLikedList";
    this.xcW = "";
    this.xcX = true;
    d.a locala = new d.a();
    locala.vD(getType());
    this.pullType = paramInt1;
    this.xcW = paramString;
    this.xcX = paramBoolean;
    auo localauo = new auo();
    localauo.SGM = paramLong;
    localauo.lastBuffer = paramb;
    localauo.RLN = z.bdh();
    if ((p.h(paramString, z.bcZ()) ^ true)) {
      localauo.xcW = paramString;
    }
    localauo.fEH = paramInt2;
    paramb = ao.xcj;
    localauo.SCW = ao.dnP();
    this.fEH = paramInt2;
    paramb = ao.xcj;
    localauo.yjp = ao.a(parambid);
    locala.c((com.tencent.mm.cd.a)localauo);
    locala.vD(getType());
    locala.d((com.tencent.mm.cd.a)new aup());
    locala.TW("/cgi-bin/micromsg-bin/findergetlikedlist");
    paramb = locala.bgN();
    p.j(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i(this.TAG, "NetSceneFinderGetLikedList init: " + paramLong + ' ' + localauo.RLN + "， targetUsername：" + paramString);
    AppMethodBeat.o(279076);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    boolean bool2 = false;
    AppMethodBeat.i(279070);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.rr.bhY();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
        AppMethodBeat.o(279070);
        throw paramString;
      }
      p.j(((aup)params).SGN, "(rr.responseProtoBuf as …dListResponse).liked_list");
      params = this.rr.bhY();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
        AppMethodBeat.o(279070);
        throw paramString;
      }
      params = (aup)params;
      Object localObject1 = com.tencent.mm.plugin.finder.preload.a.zKe;
      localObject1 = params.SDf;
      Object localObject2 = params.SGN;
      p.j(localObject2, "resp.liked_list");
      com.tencent.mm.plugin.finder.preload.a.a((bhh)localObject1, (List)localObject2, 3965);
      localObject1 = params.SGN;
      p.j(localObject1, "resp.liked_list");
      if (((LinkedList)localObject1).size() > 0)
      {
        localObject2 = ((LinkedList)localObject1).get(0);
        p.j(localObject2, "list[0]");
        localObject2 = (FinderObject)localObject2;
        Log.i(this.TAG, "onGYNetEnd list:" + ((LinkedList)localObject1).size() + " firstItem:" + com.tencent.mm.ae.g.bN(localObject2));
      }
      localObject2 = this.TAG;
      Object localObject3 = new StringBuilder("onGYNetEnd list:").append(((LinkedList)localObject1).size()).append(", continueFlag:").append(params.continueFlag).append(", maxId:");
      params = (FinderObject)j.lr((List)localObject1);
      if (params != null) {}
      boolean bool1;
      for (params = Long.valueOf(params.displayId);; params = null)
      {
        Log.i((String)localObject2, params + ' ');
        bool1 = bool2;
        if (this.pullType != 2)
        {
          bool1 = bool2;
          if (Util.isNullOrNil(this.xcW)) {
            bool1 = true;
          }
        }
        localObject1 = (Iterable)localObject1;
        params = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          localObject3 = (FinderObject)localObject2;
          aj localaj = aj.AGc;
          if (aj.w((FinderObject)localObject3)) {
            params.add(localObject2);
          }
        }
      }
      params = (List)params;
      localObject1 = c.AnK;
      this.xcV = c.a.a(params, 4, this.xbu);
      if ((bool1) && (this.fEH != 1) && (this.xcX))
      {
        params = this.xcV;
        if (params != null)
        {
          localObject1 = c.AnK;
          localObject1 = (Iterable)params;
          params = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (FinderItem)((Iterator)localObject1).next();
            localObject3 = c.AnK;
            params.add(c.a.a((FinderItem)localObject2));
          }
          c.a.b((List)params, 4, bool1);
        }
      }
    }
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.iCn();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(279070);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(165226);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(165226);
    return i;
  }
  
  public final int dom()
  {
    AppMethodBeat.i(279072);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(279072);
      throw ((Throwable)localObject);
    }
    int i = ((aup)localObject).zwD;
    AppMethodBeat.o(279072);
    return i;
  }
  
  public final b don()
  {
    AppMethodBeat.i(279073);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(279073);
      throw ((Throwable)localObject);
    }
    localObject = ((aup)localObject).lastBuffer;
    AppMethodBeat.o(279073);
    return localObject;
  }
  
  public final int doo()
  {
    AppMethodBeat.i(279075);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(279075);
      throw ((Throwable)localObject);
    }
    int i = ((aup)localObject).continueFlag;
    AppMethodBeat.o(279075);
    return i;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(279071);
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("total count = ");
    com.tencent.mm.cd.a locala = this.rr.bhY();
    if (locala == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(279071);
      throw ((Throwable)localObject);
    }
    Log.i((String)localObject, ((aup)locala).jlf);
    localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(279071);
      throw ((Throwable)localObject);
    }
    int i = ((aup)localObject).jlf;
    AppMethodBeat.o(279071);
    return i;
  }
  
  public final int getType()
  {
    return 3965;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bp
 * JD-Core Version:    0.7.0.1
 */