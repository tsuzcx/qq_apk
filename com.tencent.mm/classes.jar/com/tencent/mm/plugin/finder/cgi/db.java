package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.brz;
import com.tencent.mm.protocal.protobuf.bsa;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOriginalUserFeeds;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "refObjectId", "", "refObjectNonceId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "TAG", "getTAG", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "()I", "getRefObjectId", "()J", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUsername", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/FinderOriginalUserFeedsResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class db
  extends com.tencent.mm.am.p
  implements m
{
  public List<? extends FinderItem> ACl;
  private final String TAG;
  private h callback;
  private final b lastBuffer;
  public final int pullType;
  public final long refObjectId;
  private c rr;
  private final String username;
  
  public db(String paramString1, long paramLong, String paramString2, b paramb, int paramInt)
  {
    AppMethodBeat.i(165253);
    this.username = paramString1;
    this.refObjectId = paramLong;
    this.lastBuffer = paramb;
    this.pullType = paramInt;
    this.TAG = "Finder.NetSceneFinderOriginalUserFeeds";
    paramString1 = new c.a();
    paramString1.funcId = getType();
    paramb = new brz();
    paramb.username = this.username;
    paramb.refObjectId = this.refObjectId;
    paramb.refObjectNonceId = paramString2;
    paramb.finderUsername = z.bAW();
    paramb.lastBuffer = this.lastBuffer;
    paramString2 = bi.ABn;
    paramb.CJv = bi.dVu();
    paramString1.otE = ((a)paramb);
    paramString1.funcId = getType();
    paramString1.otF = ((a)new bsa());
    paramString1.uri = "/cgi-bin/micromsg-bin/finderoriginaluserfeeds";
    paramString1 = paramString1.bEF();
    kotlin.g.b.s.s(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    Log.i(this.TAG, kotlin.g.b.s.X("NetSceneFinderOriginalUserFeeds ", Long.valueOf(this.refObjectId)));
    AppMethodBeat.o(165253);
  }
  
  public final bsa dWq()
  {
    AppMethodBeat.i(165252);
    Object localObject = this.rr;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = c.c.b(((c)localObject).otC))
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOriginalUserFeedsResponse");
      AppMethodBeat.o(165252);
      throw ((Throwable)localObject);
    }
    localObject = (bsa)localObject;
    AppMethodBeat.o(165252);
    return localObject;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(165250);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(165250);
    return i;
  }
  
  public final int getType()
  {
    return 3581;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165251);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = c.c.b(this.rr.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderOriginalUserFeedsResponse");
        AppMethodBeat.o(165251);
        throw paramString;
      }
      params = ((bsa)params).object;
      kotlin.g.b.s.checkNotNull(params);
      Log.i(this.TAG, kotlin.g.b.s.X("onGYNetEnd list:", Integer.valueOf(params.size())));
      if (this.pullType != 2) {}
      Object localObject1;
      Object localObject2;
      for (boolean bool = true;; bool = false)
      {
        paramArrayOfByte = d.FND;
        paramArrayOfByte = (Iterable)params;
        params = (Collection)new ArrayList();
        paramArrayOfByte = paramArrayOfByte.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = paramArrayOfByte.next();
          localObject2 = (FinderObject)localObject1;
          av localav = av.GiL;
          if (av.y((FinderObject)localObject2)) {
            params.add(localObject1);
          }
        }
      }
      this.ACl = d.a.K((List)params, 2);
      if (bool)
      {
        params = this.ACl;
        if (params != null)
        {
          paramArrayOfByte = d.FND;
          paramArrayOfByte = (Iterable)params;
          params = (Collection)new ArrayList(kotlin.a.p.a(paramArrayOfByte, 10));
          paramArrayOfByte = paramArrayOfByte.iterator();
          while (paramArrayOfByte.hasNext())
          {
            localObject1 = (FinderItem)paramArrayOfByte.next();
            localObject2 = d.FND;
            params.add(d.a.a((FinderItem)localObject1));
          }
          d.a.a((List)params, 2, this.username, bool);
        }
      }
    }
    if (this.callback != null)
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
    }
    AppMethodBeat.o(165251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.db
 * JD-Core Version:    0.7.0.1
 */