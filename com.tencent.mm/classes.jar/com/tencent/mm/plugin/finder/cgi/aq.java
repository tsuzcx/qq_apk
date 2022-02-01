package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.protocal.protobuf.aol;
import com.tencent.mm.protocal.protobuf.aom;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneAdFeedList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "req_username", "", "feedId", "", "encryptedFeedId", "maxId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;JLcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "continueFlag", "", "getContinueFlag", "()Z", "setContinueFlag", "(Z)V", "getEncryptedFeedId", "()Ljava/lang/String;", "getFeedId", "()J", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "()I", "setPullType", "(I)V", "getReq_username", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getAdFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getPrivateLock", "getResponseBuffer", "getType", "getWording", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class aq
  extends ax
  implements m
{
  public static final a tuJ;
  private i callback;
  private final long feedId;
  public int pullType;
  public d rr;
  public boolean tuG;
  private final String tuH;
  private final String tuI;
  
  static
  {
    AppMethodBeat.i(242334);
    tuJ = new a((byte)0);
    AppMethodBeat.o(242334);
  }
  
  public aq(String paramString1, long paramLong1, String paramString2, long paramLong2, b paramb, int paramInt, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242333);
    this.tuH = paramString1;
    this.feedId = paramLong1;
    this.tuI = paramString2;
    this.tuG = true;
    paramString1 = c.tsp;
    paramString1 = c.a.asG(this.tuH);
    if (paramString1 != null)
    {
      paramString1 = paramString1.field_firstPageMD5;
      if (paramString1 != null) {}
    }
    else
    {
      paramString1 = "";
    }
    for (;;)
    {
      paramString2 = new d.a();
      paramString2.MB("/cgi-bin/micromsg-bin/finderaduserpage");
      paramString2.sG(getType());
      aol localaol = new aol();
      localaol.username = this.tuH;
      localaol.DIf = paramLong2;
      localaol.firstPageMD5 = paramString1;
      Object localObject = am.tuw;
      localaol.LAv = am.cXZ();
      localaol.LAt = z.aUg();
      localObject = am.tuw;
      localaol.uli = am.a(parambbn);
      localObject = localaol.uli;
      if (localObject != null) {
        if (parambbn == null) {
          break label361;
        }
      }
      label361:
      for (int i = parambbn.tyh;; i = 0)
      {
        ((aov)localObject).scene = i;
        if (n.I(localaol.username, localaol.LAt, false)) {
          localaol.LAu = 1;
        }
        localaol.LAw = this.feedId;
        localaol.tNK = this.tuI;
        localaol.lastBuffer = paramb;
        paramb = new aom();
        paramString2.c((a)localaol);
        paramString2.d((a)paramb);
        paramString2 = paramString2.aXF();
        p.g(paramString2, "builder.buildInstance()");
        this.rr = paramString2;
        this.pullType = paramInt;
        Log.i("Finder.NetSceneAdFeedListval", "NetSceneFinderUserPage init maxId " + paramLong2 + " username " + this.tuH + " pullType " + paramInt + " fpMD5 " + paramString1);
        AppMethodBeat.o(242333);
        return;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242332);
    Log.i("Finder.NetSceneAdFeedListval", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.rr.aYK();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAdUserPageResponse");
        AppMethodBeat.o(242332);
        throw paramString;
      }
      if (((aom)params).continueFlag != 1) {
        break label156;
      }
    }
    label156:
    for (boolean bool = true;; bool = false)
    {
      this.tuG = bool;
      if (this.callback != null)
      {
        params = this.callback;
        if (params == null) {
          p.hyc();
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      }
      AppMethodBeat.o(242332);
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(242331);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242331);
    return i;
  }
  
  public final int getType()
  {
    return 6692;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneAdFeedList$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aq
 * JD-Core Version:    0.7.0.1
 */