package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ata;
import com.tencent.mm.protocal.protobuf.atb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUploadHeadImg;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "filePath", "", "scene", "", "(Ljava/lang/String;I)V", "ERRCODE_CANNOT_READ_FILE", "getERRCODE_CANNOT_READ_FILE", "()I", "ERRCODE_REACH_RETRY_LIMIT", "getERRCODE_REACH_RETRY_LIMIT", "IMG_SLICE_LEN", "MAX_DO_SCENE_LIMIT", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "fileMD5", "getFilePath", "()Ljava/lang/String;", "imgUrl", "readBuf", "", "getScene", "startPos", "totalLen", "doNextUpload", "doScene", "getImgUrl", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "Companion", "plugin-finder_release"})
public final class be
  extends n
  implements k
{
  private static final int rSq = 1;
  private static final int rSr = 2;
  public static final a rSs;
  private final String TAG;
  private f callback;
  private int dgI;
  private e dispatcher;
  private final String filePath;
  private int hPI;
  private String rSj;
  private byte[] rSk;
  public String rSl;
  private final int rSm;
  private final int rSn;
  private final int rSo;
  private final int rSp;
  private final int scene;
  
  static
  {
    AppMethodBeat.i(165287);
    rSs = new a((byte)0);
    rSq = 1;
    rSr = 2;
    AppMethodBeat.o(165287);
  }
  
  public be(String paramString, int paramInt)
  {
    AppMethodBeat.i(165286);
    this.filePath = paramString;
    this.scene = paramInt;
    this.TAG = "Finder.NetSceneFinderUploadHeadImg";
    this.rSm = 51200;
    this.rSn = 20;
    this.rSo = -40000;
    this.rSp = -40001;
    ae.i(this.TAG, "filePath " + this.filePath + " and size: " + bu.sL(o.aZR(this.filePath)) + " total:" + o.aZR(this.filePath));
    AppMethodBeat.o(165286);
  }
  
  private final int cAo()
  {
    AppMethodBeat.i(165284);
    b.a locala = new b.a();
    locala.DN("/cgi-bin/micromsg-bin/finderuploadheadimg");
    locala.oS(getType());
    ata localata = new ata();
    localata.scene = this.scene;
    localata.dgI = this.dgI;
    localata.hPI = this.hPI;
    localata.GJV = this.rSj;
    this.rSk = o.bb(this.filePath, this.dgI, this.rSm);
    if (this.rSk == null)
    {
      localObject1 = this.callback;
      if (localObject1 != null) {
        ((f)localObject1).onSceneEnd(3, this.rSp, "", (n)this);
      }
      AppMethodBeat.o(165284);
      return -1;
    }
    Object localObject1 = this.rSk;
    Object localObject2 = this.rSk;
    int i;
    StringBuilder localStringBuilder;
    if (localObject2 != null)
    {
      i = localObject2.length;
      localata.Gwe = com.tencent.mm.bw.b.G((byte[])localObject1, 0, i);
      localObject2 = this.TAG;
      localStringBuilder = new StringBuilder("next upload start:").append(this.dgI).append(", len:");
      localObject1 = this.rSk;
      if (localObject1 == null) {
        break label318;
      }
    }
    label318:
    for (localObject1 = Integer.valueOf(localObject1.length);; localObject1 = null)
    {
      ae.i((String)localObject2, localObject1);
      localObject1 = v.rRb;
      localata.GDR = v.czz();
      locala.c((a)localata);
      locala.d((a)new atb());
      i = dispatch(this.dispatcher, (q)locala.aDS(), (k)this);
      if (i == -1)
      {
        localObject1 = this.callback;
        if (localObject1 != null) {
          ((f)localObject1).onSceneEnd(3, this.rSo, "", (n)this);
        }
      }
      AppMethodBeat.o(165284);
      return i;
      i = 0;
      break;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(165283);
    if (bu.isNullOrNil(this.rSj))
    {
      this.rSj = o.aRh(this.filePath);
      this.hPI = ((int)o.aZR(this.filePath));
      ae.i(this.TAG, "upload img file path:" + this.filePath + " totalLen:" + this.hPI + " md5:" + this.rSj);
    }
    this.callback = paramf;
    this.dispatcher = parame;
    int i = cAo();
    AppMethodBeat.o(165283);
    return i;
  }
  
  public final int getType()
  {
    return 3759;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165285);
    ae.i(this.TAG, "errType " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (paramq == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(165285);
        throw paramString;
      }
      paramq = ((com.tencent.mm.ak.b)paramq).aEV();
      if (paramq == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUploadHeadImgResponse");
        AppMethodBeat.o(165285);
        throw paramString;
      }
      paramq = (atb)paramq;
      if (paramq.completed)
      {
        this.rSl = paramq.rSl;
        ae.i(this.TAG, "upload completed " + this.rSl);
        paramq = this.callback;
        if (paramq != null)
        {
          paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
          AppMethodBeat.o(165285);
          return;
        }
        AppMethodBeat.o(165285);
        return;
      }
      this.dgI = paramq.dgI;
      cAo();
      AppMethodBeat.o(165285);
      return;
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(165285);
      return;
    }
    AppMethodBeat.o(165285);
  }
  
  public final int securityLimitCount()
  {
    return this.rSn;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(165282);
    p.h(paramq, "rr");
    if (bu.isNullOrNil(this.filePath))
    {
      paramq = n.b.hRj;
      AppMethodBeat.o(165282);
      return paramq;
    }
    paramq = n.b.hRi;
    AppMethodBeat.o(165282);
    return paramq;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUploadHeadImg$Companion;", "", "()V", "UPLOAD_FINDER_HEAD_IMG_SCENE_CREATE_CONTACT", "", "getUPLOAD_FINDER_HEAD_IMG_SCENE_CREATE_CONTACT", "()I", "UPLOAD_FINDER_HEAD_IMG_SCENE_UPDATE_CONTACT", "getUPLOAD_FINDER_HEAD_IMG_SCENE_UPDATE_CONTACT", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.be
 * JD-Core Version:    0.7.0.1
 */