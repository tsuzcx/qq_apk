package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.aou;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUploadHeadImg;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "filePath", "", "scene", "", "(Ljava/lang/String;I)V", "ERRCODE_REACH_RETRY_LIMIT", "getERRCODE_REACH_RETRY_LIMIT", "()I", "IMG_SLICE_LEN", "MAX_DO_SCENE_LIMIT", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "fileMD5", "getFilePath", "()Ljava/lang/String;", "imgUrl", "readBuf", "", "getScene", "startPos", "totalLen", "doNextUpload", "doScene", "getImgUrl", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "Companion", "plugin-finder_release"})
public final class av
  extends n
  implements com.tencent.mm.network.k
{
  private static final int qYL = 1;
  private static final int qYM = 2;
  public static final a qYN;
  private final String TAG;
  private int cUq;
  private g callback;
  private e dispatcher;
  private final String filePath;
  private int hux;
  private String qYF;
  private byte[] qYG;
  public String qYH;
  private final int qYI;
  private final int qYJ;
  private final int qYK;
  private final int scene;
  
  static
  {
    AppMethodBeat.i(165287);
    qYN = new a((byte)0);
    qYL = 1;
    qYM = 2;
    AppMethodBeat.o(165287);
  }
  
  public av(String paramString, int paramInt)
  {
    AppMethodBeat.i(165286);
    this.filePath = paramString;
    this.scene = paramInt;
    this.TAG = "Finder.NetSceneFinderUploadHeadImg";
    this.qYI = 51200;
    this.qYJ = 20;
    this.qYK = -40000;
    ac.i(this.TAG, "filePath " + this.filePath + " and size: " + bs.qz(i.aSp(this.filePath)) + " total:" + i.aSp(this.filePath));
    AppMethodBeat.o(165286);
  }
  
  private final int csR()
  {
    AppMethodBeat.i(165284);
    b.a locala = new b.a();
    locala.Am("/cgi-bin/micromsg-bin/finderuploadheadimg");
    locala.op(getType());
    aou localaou = new aou();
    localaou.scene = this.scene;
    localaou.cUq = this.cUq;
    localaou.hux = this.hux;
    localaou.EHL = this.qYF;
    this.qYG = i.aU(this.filePath, this.cUq, this.qYI);
    Object localObject1 = this.qYG;
    Object localObject2 = this.qYG;
    int i;
    StringBuilder localStringBuilder;
    if (localObject2 != null)
    {
      i = localObject2.length;
      localaou.Ewb = com.tencent.mm.bw.b.E((byte[])localObject1, 0, i);
      localObject2 = this.TAG;
      localStringBuilder = new StringBuilder("next upload start:").append(this.cUq).append(", len:");
      localObject1 = this.qYG;
      if (localObject1 == null) {
        break label279;
      }
    }
    label279:
    for (localObject1 = Integer.valueOf(localObject1.length);; localObject1 = null)
    {
      ac.i((String)localObject2, localObject1);
      localObject1 = q.qXH;
      localaou.EDL = q.csi();
      locala.c((a)localaou);
      locala.d((a)new aov());
      i = dispatch(this.dispatcher, (com.tencent.mm.network.q)locala.aAz(), (com.tencent.mm.network.k)this);
      if (i == -1)
      {
        localObject1 = this.callback;
        if (localObject1 != null) {
          ((g)localObject1).onSceneEnd(3, this.qYK, "", (n)this);
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
    if (bs.isNullOrNil(this.qYF))
    {
      this.qYF = i.aKe(this.filePath);
      this.hux = ((int)i.aSp(this.filePath));
      ac.i(this.TAG, "upload img file path:" + this.filePath + " totalLen:" + this.hux + " md5:" + this.qYF);
    }
    this.callback = paramg;
    this.dispatcher = parame;
    int i = csR();
    AppMethodBeat.o(165283);
    return i;
  }
  
  public final int getType()
  {
    return 3759;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165285);
    ac.i(this.TAG, "errType " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(165285);
        throw paramString;
      }
      paramq = ((com.tencent.mm.ak.b)paramq).aBD();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUploadHeadImgResponse");
        AppMethodBeat.o(165285);
        throw paramString;
      }
      paramq = (aov)paramq;
      if (paramq.completed)
      {
        this.qYH = paramq.qYH;
        ac.i(this.TAG, "upload completed " + this.qYH);
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
      this.cUq = paramq.cUq;
      csR();
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
    return this.qYJ;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    AppMethodBeat.i(165282);
    d.g.b.k.h(paramq, "rr");
    if (bs.isNullOrNil(this.filePath))
    {
      paramq = n.b.hwb;
      AppMethodBeat.o(165282);
      return paramq;
    }
    paramq = n.b.hwa;
    AppMethodBeat.o(165282);
    return paramq;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUploadHeadImg$Companion;", "", "()V", "UPLOAD_FINDER_HEAD_IMG_SCENE_CREATE_CONTACT", "", "getUPLOAD_FINDER_HEAD_IMG_SCENE_CREATE_CONTACT", "()I", "UPLOAD_FINDER_HEAD_IMG_SCENE_UPDATE_CONTACT", "getUPLOAD_FINDER_HEAD_IMG_SCENE_UPDATE_CONTACT", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.av
 * JD-Core Version:    0.7.0.1
 */