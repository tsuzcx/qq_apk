package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.bdw;
import com.tencent.mm.protocal.protobuf.bdx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUploadHeadImg;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "filePath", "", "scene", "", "fileMD5", "totalLen", "(Ljava/lang/String;ILjava/lang/String;I)V", "ERRCODE_CANNOT_READ_FILE", "getERRCODE_CANNOT_READ_FILE", "()I", "ERRCODE_REACH_RETRY_LIMIT", "getERRCODE_REACH_RETRY_LIMIT", "IMG_SLICE_LEN", "MAX_DO_SCENE_LIMIT", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFilePath", "()Ljava/lang/String;", "imgUrl", "readBuf", "", "getScene", "startPos", "doNextUpload", "doScene", "getFileMD5", "getImgUrl", "getTotalLen", "getType", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "Companion", "plugin-finder_release"})
public final class cl
  extends ax
  implements m
{
  public static final a twA;
  private static final int twy = 1;
  private static final int twz = 2;
  private final String TAG;
  private int bNu;
  private i callback;
  private g dispatcher;
  public String fileMD5;
  private final String filePath;
  public int iKP;
  private final int scene;
  private byte[] tws;
  public String twt;
  private final int twu;
  private final int twv;
  private final int tww;
  private final int twx;
  
  static
  {
    AppMethodBeat.i(165287);
    twA = new a((byte)0);
    twy = 1;
    twz = 2;
    AppMethodBeat.o(165287);
  }
  
  public cl(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(242520);
    this.filePath = paramString1;
    this.scene = paramInt1;
    this.fileMD5 = paramString2;
    this.iKP = paramInt2;
    this.TAG = "Finder.NetSceneFinderUploadHeadImg";
    this.twu = 51200;
    this.twv = 20;
    this.tww = -40000;
    this.twx = -40001;
    Log.i(this.TAG, "filePath " + this.filePath + " and size: " + Util.getSizeKB(com.tencent.mm.vfs.s.boW(this.filePath)) + " total:" + com.tencent.mm.vfs.s.boW(this.filePath));
    AppMethodBeat.o(242520);
  }
  
  private final int cZg()
  {
    AppMethodBeat.i(165284);
    d.a locala = new d.a();
    locala.MB("/cgi-bin/micromsg-bin/finderuploadheadimg");
    locala.sG(getType());
    bdw localbdw = new bdw();
    localbdw.scene = this.scene;
    localbdw.bNu = this.bNu;
    localbdw.iKP = this.iKP;
    localbdw.LNB = this.fileMD5;
    this.tws = com.tencent.mm.vfs.s.aW(this.filePath, this.bNu, this.twu);
    if (this.tws == null)
    {
      localObject1 = this.callback;
      if (localObject1 != null) {
        ((i)localObject1).onSceneEnd(3, this.twx, "", (q)this);
      }
      AppMethodBeat.o(165284);
      return -1;
    }
    Object localObject1 = this.tws;
    Object localObject2 = this.tws;
    int i;
    StringBuilder localStringBuilder;
    if (localObject2 != null)
    {
      i = localObject2.length;
      localbdw.LrK = com.tencent.mm.bw.b.Q((byte[])localObject1, 0, i);
      localObject2 = this.TAG;
      localStringBuilder = new StringBuilder("next upload start:").append(this.bNu).append(", len:");
      localObject1 = this.tws;
      if (localObject1 == null) {
        break label318;
      }
    }
    label318:
    for (localObject1 = Integer.valueOf(localObject1.length);; localObject1 = null)
    {
      Log.i((String)localObject2, localObject1);
      localObject1 = am.tuw;
      localbdw.uli = am.cXY();
      locala.c((a)localbdw);
      locala.d((a)new bdx());
      i = dispatch(this.dispatcher, (com.tencent.mm.network.s)locala.aXF(), (m)this);
      if (i == -1)
      {
        localObject1 = this.callback;
        if (localObject1 != null) {
          ((i)localObject1).onSceneEnd(3, this.tww, "", (q)this);
        }
      }
      AppMethodBeat.o(165284);
      return i;
      i = 0;
      break;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(242519);
    Log.i(this.TAG, "errType " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(242519);
        throw paramString;
      }
      params = ((d)params).aYK();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUploadHeadImgResponse");
        AppMethodBeat.o(242519);
        throw paramString;
      }
      params = (bdx)params;
      if (params.completed)
      {
        this.twt = params.twt;
        Log.i(this.TAG, "upload completed " + this.twt);
        params = this.callback;
        if (params != null)
        {
          params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
          AppMethodBeat.o(242519);
          return;
        }
        AppMethodBeat.o(242519);
        return;
      }
      this.bNu = params.bNu;
      cZg();
      AppMethodBeat.o(242519);
      return;
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(242519);
      return;
    }
    AppMethodBeat.o(242519);
  }
  
  public final com.tencent.mm.plugin.finder.cgi.report.b cXS()
  {
    return com.tencent.mm.plugin.finder.cgi.report.b.tye;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(165283);
    if (Util.isNullOrNil(this.fileMD5))
    {
      this.fileMD5 = com.tencent.mm.vfs.s.bhK(this.filePath);
      this.iKP = ((int)com.tencent.mm.vfs.s.boW(this.filePath));
      Log.i(this.TAG, "upload img file path:" + this.filePath + " totalLen:" + this.iKP + " md5:" + this.fileMD5);
    }
    this.callback = parami;
    this.dispatcher = paramg;
    int i = cZg();
    AppMethodBeat.o(165283);
    return i;
  }
  
  public final int getType()
  {
    return 3759;
  }
  
  public final int securityLimitCount()
  {
    return this.twv;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(165282);
    p.h(params, "rr");
    if (Util.isNullOrNil(this.filePath))
    {
      params = q.b.iMr;
      AppMethodBeat.o(165282);
      return params;
    }
    params = q.b.iMq;
    AppMethodBeat.o(165282);
    return params;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUploadHeadImg$Companion;", "", "()V", "UPLOAD_FINDER_HEAD_IMG_SCENE_CREATE_CONTACT", "", "getUPLOAD_FINDER_HEAD_IMG_SCENE_CREATE_CONTACT", "()I", "UPLOAD_FINDER_HEAD_IMG_SCENE_UPDATE_CONTACT", "getUPLOAD_FINDER_HEAD_IMG_SCENE_UPDATE_CONTACT", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cl
 * JD-Core Version:    0.7.0.1
 */