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
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.protocal.protobuf.cnw;
import com.tencent.mm.protocal.protobuf.cnx;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoGetBullet;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "videoObjectId", "", "videoNonceId", "", "videoTimeStamps", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;JLcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getVideoObjectId", "()J", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getBulletList", "", "Lcom/tencent/mm/protocal/protobuf/MegaVideoBulletCommentInfo;", "getMaxTime", "getMinTime", "getRespLastBuffer", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ct
  extends cr
  implements m
{
  public static final a twI;
  private i callback;
  private final b lastBuffer;
  public int pullType;
  private d rr;
  public final long twG;
  
  static
  {
    AppMethodBeat.i(242556);
    twI = new a((byte)0);
    AppMethodBeat.o(242556);
  }
  
  public ct(long paramLong1, String paramString, long paramLong2, b paramb, bbn parambbn)
  {
    AppMethodBeat.i(242555);
    this.twG = paramLong1;
    this.lastBuffer = paramb;
    paramb = new cnw();
    ap localap = ap.tuF;
    paramb.Mul = ap.b(parambbn);
    paramb.twG = this.twG;
    paramb.lastBuffer = this.lastBuffer;
    paramb.LOd = paramString;
    paramb.MtO = paramLong2;
    paramb.username = z.aUg();
    paramString = new d.a();
    paramString.MB("/cgi-bin/micromsg-bin/megavideogetbulletcomment");
    paramString.sG(getType());
    paramString.c((a)paramb);
    paramString.d((a)new cnx());
    paramString = paramString.aXF();
    p.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    paramb = new StringBuilder("NetSceneGetMegaVideoBullet videoObjectId ").append(this.twG).append(" lastBuffer ").append(this.lastBuffer).append(" md5:");
    paramString = this.lastBuffer;
    if (paramString != null) {}
    for (paramString = paramString.zy;; paramString = null)
    {
      Log.i("Finder.NetSceneGetMegaVideoBullet", com.tencent.mm.b.g.getMessageDigest(paramString));
      AppMethodBeat.o(242555);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    Object localObject1 = null;
    AppMethodBeat.i(242550);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Object localObject2 = new StringBuilder("count:").append(cZo().size()).append(" ,lastbuf ");
      params = cYz();
      if (params != null) {}
      for (params = params.zy;; params = null)
      {
        localObject2 = new StringBuffer(com.tencent.mm.b.g.getMessageDigest(params) + " min:" + cZp() + " max: ==>" + cZq());
        params = (Iterable)cZo();
        paramInt1 = 0;
        params = params.iterator();
        while (params.hasNext())
        {
          localObject3 = params.next();
          if (paramInt1 < 0) {
            j.hxH();
          }
          localObject3 = (cni)localObject3;
          ((StringBuffer)localObject2).append("# " + paramInt1 + ':' + ((cni)localObject3).content + ',' + ((cni)localObject3).iXu + ", ");
          paramInt1 += 1;
        }
      }
      Object localObject3 = new StringBuilder("getBulletList videoObjectId ").append(this.twG).append(' ');
      b localb = this.lastBuffer;
      params = localObject1;
      if (localb != null) {
        params = localb.zy;
      }
      Log.i("Finder.NetSceneGetMegaVideoBullet", com.tencent.mm.b.g.getMessageDigest(params) + ' ' + (StringBuffer)localObject2);
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(242550);
      return;
    }
    AppMethodBeat.o(242550);
  }
  
  public final b cYz()
  {
    AppMethodBeat.i(242552);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MegaVideoGetBulletCommentResponse");
      AppMethodBeat.o(242552);
      throw ((Throwable)localObject);
    }
    localObject = ((cnx)localObject).lastBuffer;
    AppMethodBeat.o(242552);
    return localObject;
  }
  
  public final List<cni> cZo()
  {
    AppMethodBeat.i(242551);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MegaVideoGetBulletCommentResponse");
      AppMethodBeat.o(242551);
      throw ((Throwable)localObject);
    }
    localObject = ((cnx)localObject).commentList;
    p.g(localObject, "(rr.responseProtoBuf as …mentResponse).commentList");
    localObject = (List)localObject;
    AppMethodBeat.o(242551);
    return localObject;
  }
  
  public final long cZp()
  {
    AppMethodBeat.i(242553);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MegaVideoGetBulletCommentResponse");
      AppMethodBeat.o(242553);
      throw ((Throwable)localObject);
    }
    long l = ((cnx)localObject).Mum;
    AppMethodBeat.o(242553);
    return l;
  }
  
  public final long cZq()
  {
    AppMethodBeat.i(242554);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MegaVideoGetBulletCommentResponse");
      AppMethodBeat.o(242554);
      throw ((Throwable)localObject);
    }
    long l = ((cnx)localObject).Mun;
    AppMethodBeat.o(242554);
    return l;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(242549);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242549);
    return i;
  }
  
  public final int getType()
  {
    return 6865;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoGetBullet$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ct
 * JD-Core Version:    0.7.0.1
 */