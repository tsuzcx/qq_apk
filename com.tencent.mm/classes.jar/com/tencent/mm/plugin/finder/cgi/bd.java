package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.asl;
import com.tencent.mm.protocal.protobuf.asm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUploadHeadImg;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "filePath", "", "scene", "", "(Ljava/lang/String;I)V", "ERRCODE_CANNOT_READ_FILE", "getERRCODE_CANNOT_READ_FILE", "()I", "ERRCODE_REACH_RETRY_LIMIT", "getERRCODE_REACH_RETRY_LIMIT", "IMG_SLICE_LEN", "MAX_DO_SCENE_LIMIT", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "fileMD5", "getFilePath", "()Ljava/lang/String;", "imgUrl", "readBuf", "", "getScene", "startPos", "totalLen", "doNextUpload", "doScene", "getImgUrl", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "Companion", "plugin-finder_release"})
public final class bd
  extends n
  implements k
{
  private static final int rKc = 1;
  private static final int rKd = 2;
  public static final a rKe;
  private final String TAG;
  private f callback;
  private int dfG;
  private e dispatcher;
  private final String filePath;
  private int hMP;
  private String rJV;
  private byte[] rJW;
  public String rJX;
  private final int rJY;
  private final int rJZ;
  private final int rKa;
  private final int rKb;
  private final int scene;
  
  static
  {
    AppMethodBeat.i(165287);
    rKe = new a((byte)0);
    rKc = 1;
    rKd = 2;
    AppMethodBeat.o(165287);
  }
  
  public bd(String paramString, int paramInt)
  {
    AppMethodBeat.i(165286);
    this.filePath = paramString;
    this.scene = paramInt;
    this.TAG = "Finder.NetSceneFinderUploadHeadImg";
    this.rJY = 51200;
    this.rJZ = 20;
    this.rKa = -40000;
    this.rKb = -40001;
    ad.i(this.TAG, "filePath " + this.filePath + " and size: " + bt.sy(i.aYo(this.filePath)) + " total:" + i.aYo(this.filePath));
    AppMethodBeat.o(165286);
  }
  
  private final int cyN()
  {
    AppMethodBeat.i(165284);
    b.a locala = new b.a();
    locala.Dl("/cgi-bin/micromsg-bin/finderuploadheadimg");
    locala.oP(getType());
    asl localasl = new asl();
    localasl.scene = this.scene;
    localasl.dfG = this.dfG;
    localasl.hMP = this.hMP;
    localasl.GqA = this.rJV;
    this.rJW = i.aY(this.filePath, this.dfG, this.rJY);
    if (this.rJW == null)
    {
      localObject1 = this.callback;
      if (localObject1 != null) {
        ((f)localObject1).onSceneEnd(3, this.rKb, "", (n)this);
      }
      AppMethodBeat.o(165284);
      return -1;
    }
    Object localObject1 = this.rJW;
    Object localObject2 = this.rJW;
    int i;
    StringBuilder localStringBuilder;
    if (localObject2 != null)
    {
      i = localObject2.length;
      localasl.Gdx = com.tencent.mm.bx.b.F((byte[])localObject1, 0, i);
      localObject2 = this.TAG;
      localStringBuilder = new StringBuilder("next upload start:").append(this.dfG).append(", len:");
      localObject1 = this.rJW;
      if (localObject1 == null) {
        break label318;
      }
    }
    label318:
    for (localObject1 = Integer.valueOf(localObject1.length);; localObject1 = null)
    {
      ad.i((String)localObject2, localObject1);
      localObject1 = v.rIR;
      localasl.Glv = v.cxY();
      locala.c((a)localasl);
      locala.d((a)new asm());
      i = dispatch(this.dispatcher, (q)locala.aDC(), (k)this);
      if (i == -1)
      {
        localObject1 = this.callback;
        if (localObject1 != null) {
          ((f)localObject1).onSceneEnd(3, this.rKa, "", (n)this);
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
    if (bt.isNullOrNil(this.rJV))
    {
      this.rJV = i.aPK(this.filePath);
      this.hMP = ((int)i.aYo(this.filePath));
      ad.i(this.TAG, "upload img file path:" + this.filePath + " totalLen:" + this.hMP + " md5:" + this.rJV);
    }
    this.callback = paramf;
    this.dispatcher = parame;
    int i = cyN();
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
    ad.i(this.TAG, "errType " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (paramq == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(165285);
        throw paramString;
      }
      paramq = ((com.tencent.mm.al.b)paramq).aEF();
      if (paramq == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUploadHeadImgResponse");
        AppMethodBeat.o(165285);
        throw paramString;
      }
      paramq = (asm)paramq;
      if (paramq.completed)
      {
        this.rJX = paramq.rJX;
        ad.i(this.TAG, "upload completed " + this.rJX);
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
      this.dfG = paramq.dfG;
      cyN();
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
    return this.rJZ;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(165282);
    p.h(paramq, "rr");
    if (bt.isNullOrNil(this.filePath))
    {
      paramq = n.b.hOq;
      AppMethodBeat.o(165282);
      return paramq;
    }
    paramq = n.b.hOp;
    AppMethodBeat.o(165282);
    return paramq;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUploadHeadImg$Companion;", "", "()V", "UPLOAD_FINDER_HEAD_IMG_SCENE_CREATE_CONTACT", "", "getUPLOAD_FINDER_HEAD_IMG_SCENE_CREATE_CONTACT", "()I", "UPLOAD_FINDER_HEAD_IMG_SCENE_UPDATE_CONTACT", "getUPLOAD_FINDER_HEAD_IMG_SCENE_UPDATE_CONTACT", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bd
 * JD-Core Version:    0.7.0.1
 */