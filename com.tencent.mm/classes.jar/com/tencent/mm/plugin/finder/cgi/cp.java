package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.cd.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bkv;
import com.tencent.mm.protocal.protobuf.bkw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUploadHeadImg;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "filePath", "", "scene", "", "fileMD5", "totalLen", "(Ljava/lang/String;ILjava/lang/String;I)V", "ERRCODE_CANNOT_READ_FILE", "getERRCODE_CANNOT_READ_FILE", "()I", "ERRCODE_REACH_RETRY_LIMIT", "getERRCODE_REACH_RETRY_LIMIT", "IMG_SLICE_LEN", "MAX_DO_SCENE_LIMIT", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFilePath", "()Ljava/lang/String;", "imgUrl", "readBuf", "", "getScene", "startPos", "doNextUpload", "doScene", "getFileMD5", "getImgUrl", "getTotalLen", "getType", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "Companion", "plugin-finder_release"})
public final class cp
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private static final int xen = 1;
  private static final int xeo = 2;
  public static final a xep;
  private final String TAG;
  private int bPt;
  private i callback;
  private com.tencent.mm.network.g dispatcher;
  public String fileMD5;
  private final String filePath;
  public int lAW;
  private final int scene;
  private byte[] xeh;
  public String xei;
  private final int xej;
  private final int xek;
  private final int xel;
  private final int xem;
  
  static
  {
    AppMethodBeat.i(165287);
    xep = new a((byte)0);
    xen = 1;
    xeo = 2;
    AppMethodBeat.o(165287);
  }
  
  public cp(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(290581);
    this.filePath = paramString1;
    this.scene = paramInt1;
    this.fileMD5 = paramString2;
    this.lAW = paramInt2;
    this.TAG = "Finder.NetSceneFinderUploadHeadImg";
    this.xej = 51200;
    this.xek = 20;
    this.xel = -40000;
    this.xem = -40001;
    Log.i(this.TAG, "filePath " + this.filePath + " and size: " + Util.getSizeKB(u.bBQ(this.filePath)) + " total:" + u.bBQ(this.filePath));
    AppMethodBeat.o(290581);
  }
  
  private final int doY()
  {
    AppMethodBeat.i(165284);
    d.a locala = new d.a();
    locala.TW("/cgi-bin/micromsg-bin/finderuploadheadimg");
    locala.vD(getType());
    bkv localbkv = new bkv();
    localbkv.scene = this.scene;
    localbkv.bPt = this.bPt;
    localbkv.lAW = this.lAW;
    localbkv.SVL = this.fileMD5;
    this.xeh = u.aY(this.filePath, this.bPt, this.xej);
    if (this.xeh == null)
    {
      localObject1 = this.callback;
      if (localObject1 != null) {
        ((i)localObject1).onSceneEnd(3, this.xem, "", (q)this);
      }
      AppMethodBeat.o(165284);
      return -1;
    }
    Object localObject1 = this.xeh;
    Object localObject2 = this.xeh;
    int i;
    StringBuilder localStringBuilder;
    if (localObject2 != null)
    {
      i = localObject2.length;
      localbkv.Sth = com.tencent.mm.cd.b.S((byte[])localObject1, 0, i);
      localObject2 = this.TAG;
      localStringBuilder = new StringBuilder("next upload start:").append(this.bPt).append(", len:");
      localObject1 = this.xeh;
      if (localObject1 == null) {
        break label318;
      }
    }
    label318:
    for (localObject1 = Integer.valueOf(localObject1.length);; localObject1 = null)
    {
      Log.i((String)localObject2, localObject1);
      localObject1 = ao.xcj;
      localbkv.yjp = ao.dnO();
      locala.c((a)localbkv);
      locala.d((a)new bkw());
      i = dispatch(this.dispatcher, (s)locala.bgN(), (m)this);
      if (i == -1)
      {
        localObject1 = this.callback;
        if (localObject1 != null) {
          ((i)localObject1).onSceneEnd(3, this.xel, "", (q)this);
        }
      }
      AppMethodBeat.o(165284);
      return i;
      i = 0;
      break;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(290580);
    Log.i(this.TAG, "errType " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(290580);
        throw paramString;
      }
      params = ((d)params).bhY();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUploadHeadImgResponse");
        AppMethodBeat.o(290580);
        throw paramString;
      }
      params = (bkw)params;
      if (params.jIH)
      {
        this.xei = params.xei;
        Log.i(this.TAG, "upload completed " + this.xei);
        params = this.callback;
        if (params != null)
        {
          params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
          AppMethodBeat.o(290580);
          return;
        }
        AppMethodBeat.o(290580);
        return;
      }
      this.bPt = params.bPt;
      doY();
      AppMethodBeat.o(290580);
      return;
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(290580);
      return;
    }
    AppMethodBeat.o(290580);
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dnF()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.BvU;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(165283);
    if (Util.isNullOrNil(this.fileMD5))
    {
      this.fileMD5 = u.buc(this.filePath);
      this.lAW = ((int)u.bBQ(this.filePath));
      Log.i(this.TAG, "upload img file path:" + this.filePath + " totalLen:" + this.lAW + " md5:" + this.fileMD5);
    }
    this.callback = parami;
    this.dispatcher = paramg;
    int i = doY();
    AppMethodBeat.o(165283);
    return i;
  }
  
  public final int getType()
  {
    return 3759;
  }
  
  public final int securityLimitCount()
  {
    return this.xek;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(165282);
    p.k(params, "rr");
    if (Util.isNullOrNil(this.filePath))
    {
      params = q.b.lCy;
      AppMethodBeat.o(165282);
      return params;
    }
    params = q.b.lCx;
    AppMethodBeat.o(165282);
    return params;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUploadHeadImg$Companion;", "", "()V", "UPLOAD_FINDER_HEAD_IMG_SCENE_CREATE_CONTACT", "", "getUPLOAD_FINDER_HEAD_IMG_SCENE_CREATE_CONTACT", "()I", "UPLOAD_FINDER_HEAD_IMG_SCENE_UPDATE_CONTACT", "getUPLOAD_FINDER_HEAD_IMG_SCENE_UPDATE_CONTACT", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cp
 * JD-Core Version:    0.7.0.1
 */