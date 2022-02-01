package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.alr;
import com.tencent.mm.protocal.protobuf.als;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUploadHeadImg;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "filePath", "", "scene", "", "(Ljava/lang/String;I)V", "ERRCODE_REACH_RETRY_LIMIT", "getERRCODE_REACH_RETRY_LIMIT", "()I", "IMG_SLICE_LEN", "MAX_DO_SCENE_LIMIT", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "fileMD5", "getFilePath", "()Ljava/lang/String;", "imgUrl", "readBuf", "", "getScene", "startPos", "totalLen", "doNextUpload", "doScene", "getImgUrl", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "Companion", "plugin-finder_release"})
public final class ad
  extends n
  implements com.tencent.mm.network.k
{
  private static final int qpF = 1;
  private static final int qpG = 2;
  public static final a qpH;
  private final String TAG;
  private int cWU;
  private g callback;
  private e dispatcher;
  private final String filePath;
  private int gTY;
  private byte[] qpA;
  public String qpB;
  private final int qpC;
  private final int qpD;
  private final int qpE;
  private String qpz;
  private final int scene;
  
  static
  {
    AppMethodBeat.i(165287);
    qpH = new a((byte)0);
    qpF = 1;
    qpG = 2;
    AppMethodBeat.o(165287);
  }
  
  public ad(String paramString, int paramInt)
  {
    AppMethodBeat.i(165286);
    this.filePath = paramString;
    this.scene = paramInt;
    this.TAG = "Finder.NetSceneFinderUploadHeadImg";
    this.qpC = 51200;
    this.qpD = 20;
    this.qpE = -40000;
    com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "filePath " + this.filePath + " and size: " + bt.mK(i.aMN(this.filePath)) + " total:" + i.aMN(this.filePath));
    AppMethodBeat.o(165286);
  }
  
  private final int ckY()
  {
    AppMethodBeat.i(165284);
    b.a locala = new b.a();
    locala.wg("/cgi-bin/micromsg-bin/finderuploadheadimg");
    locala.nB(getType());
    alr localalr = new alr();
    localalr.scene = this.scene;
    localalr.cWU = this.cWU;
    localalr.gTY = this.gTY;
    localalr.DmO = this.qpz;
    this.qpA = i.aR(this.filePath, this.cWU, this.qpC);
    Object localObject1 = this.qpA;
    Object localObject2 = this.qpA;
    int i;
    StringBuilder localStringBuilder;
    if (localObject2 != null)
    {
      i = localObject2.length;
      localalr.DcU = com.tencent.mm.bx.b.F((byte[])localObject1, 0, i);
      localObject2 = this.TAG;
      localStringBuilder = new StringBuilder("next upload start:").append(this.cWU).append(", len:");
      localObject1 = this.qpA;
      if (localObject1 == null) {
        break label279;
      }
    }
    label279:
    for (localObject1 = Integer.valueOf(localObject1.length);; localObject1 = null)
    {
      com.tencent.mm.sdk.platformtools.ad.i((String)localObject2, localObject1);
      localObject1 = am.KJy;
      localalr.Dkw = am.fRS();
      locala.c((a)localalr);
      locala.d((a)new als());
      i = dispatch(this.dispatcher, (q)locala.atI(), (com.tencent.mm.network.k)this);
      if (i == -1)
      {
        localObject1 = this.callback;
        if (localObject1 != null) {
          ((g)localObject1).onSceneEnd(3, this.qpE, "", (n)this);
        }
      }
      AppMethodBeat.o(165284);
      return i;
      i = 0;
      break;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(165283);
    if (bt.isNullOrNil(this.qpz))
    {
      this.qpz = i.aEN(this.filePath);
      this.gTY = ((int)i.aMN(this.filePath));
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "upload img file path:" + this.filePath + " totalLen:" + this.gTY + " md5:" + this.qpz);
    }
    this.callback = paramg;
    this.dispatcher = parame;
    int i = ckY();
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
    com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "errType " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(165285);
        throw paramString;
      }
      paramq = ((com.tencent.mm.al.b)paramq).auM();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUploadHeadImgResponse");
        AppMethodBeat.o(165285);
        throw paramString;
      }
      paramq = (als)paramq;
      if (paramq.completed)
      {
        this.qpB = paramq.qpB;
        com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "upload completed " + this.qpB);
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
      this.cWU = paramq.cWU;
      ckY();
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
    return this.qpD;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(165282);
    d.g.b.k.h(paramq, "rr");
    if (bt.isNullOrNil(this.filePath))
    {
      paramq = n.b.gVC;
      AppMethodBeat.o(165282);
      return paramq;
    }
    paramq = n.b.gVB;
    AppMethodBeat.o(165282);
    return paramq;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUploadHeadImg$Companion;", "", "()V", "UPLOAD_FINDER_HEAD_IMG_SCENE_CREATE_CONTACT", "", "getUPLOAD_FINDER_HEAD_IMG_SCENE_CREATE_CONTACT", "()I", "UPLOAD_FINDER_HEAD_IMG_SCENE_UPDATE_CONTACT", "getUPLOAD_FINDER_HEAD_IMG_SCENE_UPDATE_CONTACT", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ad
 * JD-Core Version:    0.7.0.1
 */