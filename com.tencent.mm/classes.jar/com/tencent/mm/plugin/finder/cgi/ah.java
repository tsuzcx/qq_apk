package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aiu;
import com.tencent.mm.protocal.protobuf.akz;
import com.tencent.mm.protocal.protobuf.ala;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.l;
import d.v;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetMentionedFeed;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "username", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUsername", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRespLastBuffer", "kotlin.jvm.PlatformType", "getTotalCount", "", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ah
  extends w
{
  private final String TAG;
  private com.tencent.mm.ak.g callback;
  public int pullType;
  public com.tencent.mm.ak.b rr;
  private final String username;
  
  public ah(String paramString, com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(201195);
    this.username = paramString;
    this.TAG = "Finder.NetSceneFinderGetMentionedFeed";
    paramString = new b.a();
    paramString.op(getType());
    akz localakz = new akz();
    localakz.EEI = this.username;
    localakz.EEJ = paramb;
    localakz.EEO = new aiu();
    paramb = localakz.EEO;
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(locale, "MMKernel.storage()");
    paramb.EDy = locale.agA().getInt(ah.a.GVw, 0);
    paramString.c((a)localakz);
    paramString.op(getType());
    paramString.d((a)new ala());
    paramString.Am("/cgi-bin/micromsg-bin/findergetmentionedlist");
    paramString = paramString.aAz();
    d.g.b.k.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    ac.i(this.TAG, "NetSceneFinderGetMentionedFeed init: " + this.username);
    AppMethodBeat.o(201195);
  }
  
  public final List<FinderObject> csC()
  {
    AppMethodBeat.i(201194);
    Object localObject = this.rr.aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
      AppMethodBeat.o(201194);
      throw ((Throwable)localObject);
    }
    localObject = ((ala)localObject).object;
    d.g.b.k.g(localObject, "(rr.responseProtoBuf as …nedListResponse).`object`");
    localObject = (List)localObject;
    AppMethodBeat.o(201194);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(201192);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(201192);
    return i;
  }
  
  public final int getType()
  {
    return 3810;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201193);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ac.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.TAG;
      paramArrayOfByte = new StringBuilder("friendUsername ").append(this.username).append(' ');
      p localp = p.qXG;
      ac.i(paramq, p.dw(csC()));
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.fOy();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(201193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ah
 * JD-Core Version:    0.7.0.1
 */