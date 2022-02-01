package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.byh;
import com.tencent.mm.protocal.protobuf.byi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUploadHeadImg;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "filePath", "", "scene", "", "fileMD5", "totalLen", "(Ljava/lang/String;ILjava/lang/String;I)V", "ERRCODE_CANNOT_READ_FILE", "getERRCODE_CANNOT_READ_FILE", "()I", "ERRCODE_REACH_RETRY_LIMIT", "getERRCODE_REACH_RETRY_LIMIT", "IMG_SLICE_LEN", "MAX_DO_SCENE_LIMIT", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFilePath", "()Ljava/lang/String;", "imgUrl", "readBuf", "", "getScene", "startPos", "doNextUpload", "doScene", "getFileMD5", "getImgUrl", "getTotalLen", "getType", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class dr
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final a ADr;
  private static final int ADy;
  private static final int ADz;
  private byte[] ADs;
  public String ADt;
  private final int ADu;
  private final int ADv;
  private final int ADw;
  private final int ADx;
  private final String TAG;
  private com.tencent.mm.am.h callback;
  private int dIY;
  private g dispatcher;
  public String fileMD5;
  private final String filePath;
  public int osy;
  private final int scene;
  
  static
  {
    AppMethodBeat.i(165287);
    ADr = new a((byte)0);
    ADy = 1;
    ADz = 2;
    AppMethodBeat.o(165287);
  }
  
  public dr(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(336785);
    this.filePath = paramString1;
    this.scene = paramInt1;
    this.fileMD5 = paramString2;
    this.osy = paramInt2;
    this.TAG = "Finder.NetSceneFinderUploadHeadImg";
    this.ADu = 51200;
    this.ADv = 20;
    this.ADw = -40000;
    this.ADx = -40001;
    Log.i(this.TAG, "filePath " + this.filePath + " and size: " + Util.getSizeKB(y.bEl(this.filePath)) + " total:" + y.bEl(this.filePath));
    AppMethodBeat.o(336785);
  }
  
  private final int dWy()
  {
    AppMethodBeat.i(165284);
    c.a locala = new c.a();
    locala.uri = "/cgi-bin/micromsg-bin/finderuploadheadimg";
    locala.funcId = getType();
    byh localbyh = new byh();
    localbyh.scene = this.scene;
    localbyh.dIY = this.dIY;
    localbyh.osy = this.osy;
    localbyh.aahb = this.fileMD5;
    this.ADs = y.bi(this.filePath, this.dIY, this.ADu);
    if (this.ADs == null)
    {
      localObject1 = this.callback;
      if (localObject1 != null) {
        ((com.tencent.mm.am.h)localObject1).onSceneEnd(3, this.ADx, "", (p)this);
      }
      AppMethodBeat.o(165284);
      return -1;
    }
    Object localObject1 = this.ADs;
    Object localObject2 = this.ADs;
    int i;
    StringBuilder localStringBuilder;
    if (localObject2 == null)
    {
      i = 0;
      localbyh.Zsu = com.tencent.mm.bx.b.P((byte[])localObject1, 0, i);
      localObject2 = this.TAG;
      localStringBuilder = new StringBuilder("next upload start:").append(this.dIY).append(", len:");
      localObject1 = this.ADs;
      if (localObject1 != null) {
        break label314;
      }
    }
    label314:
    for (localObject1 = null;; localObject1 = Integer.valueOf(localObject1.length))
    {
      Log.i((String)localObject2, localObject1);
      localObject1 = bi.ABn;
      localbyh.CJv = bi.dVu();
      locala.otE = ((a)localbyh);
      locala.otF = ((a)new byi());
      i = dispatch(this.dispatcher, (com.tencent.mm.network.s)locala.bEF(), (m)this);
      if (i == -1)
      {
        localObject1 = this.callback;
        if (localObject1 != null) {
          ((com.tencent.mm.am.h)localObject1).onSceneEnd(3, this.ADw, "", (p)this);
        }
      }
      AppMethodBeat.o(165284);
      return i;
      i = localObject2.length;
      break;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336835);
    Log.i(this.TAG, "errType " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(336835);
        throw paramString;
      }
      params = c.c.b(((c)params).otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUploadHeadImgResponse");
        AppMethodBeat.o(336835);
        throw paramString;
      }
      params = (byi)params;
      if (params.TGl)
      {
        this.ADt = params.ADt;
        Log.i(this.TAG, kotlin.g.b.s.X("upload completed ", this.ADt));
        params = this.callback;
        if (params != null)
        {
          params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
          AppMethodBeat.o(336835);
        }
      }
      else
      {
        this.dIY = params.dIY;
        dWy();
        AppMethodBeat.o(336835);
      }
    }
    else
    {
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
    }
    AppMethodBeat.o(336835);
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dVi()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.Hde;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(165283);
    if (Util.isNullOrNil(this.fileMD5))
    {
      this.fileMD5 = y.bub(this.filePath);
      this.osy = ((int)y.bEl(this.filePath));
      Log.i(this.TAG, "upload img file path:" + this.filePath + " totalLen:" + this.osy + " md5:" + this.fileMD5);
    }
    this.callback = paramh;
    this.dispatcher = paramg;
    int i = dWy();
    AppMethodBeat.o(165283);
    return i;
  }
  
  public final int getType()
  {
    return 3759;
  }
  
  public final int securityLimitCount()
  {
    return this.ADv;
  }
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(165282);
    kotlin.g.b.s.u(params, "rr");
    if (Util.isNullOrNil(this.filePath))
    {
      params = p.b.oui;
      AppMethodBeat.o(165282);
      return params;
    }
    params = p.b.ouh;
    AppMethodBeat.o(165282);
    return params;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUploadHeadImg$Companion;", "", "()V", "UPLOAD_FINDER_HEAD_IMG_SCENE_CREATE_CONTACT", "", "getUPLOAD_FINDER_HEAD_IMG_SCENE_CREATE_CONTACT", "()I", "UPLOAD_FINDER_HEAD_IMG_SCENE_UPDATE_CONTACT", "getUPLOAD_FINDER_HEAD_IMG_SCENE_UPDATE_CONTACT", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.dr
 * JD-Core Version:    0.7.0.1
 */