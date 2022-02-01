package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bbj;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneGetLiveNoticeQrCode;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "anchorUserName", "", "noticeId", "(Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getQRCodeBitmap", "Landroid/graphics/Bitmap;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeQRCodeResponse;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class cv
  extends com.tencent.mm.plugin.findersdk.b.g
{
  public static final a xeu;
  private i callback;
  private d rr;
  
  static
  {
    AppMethodBeat.i(290026);
    xeu = new a((byte)0);
    AppMethodBeat.o(290026);
  }
  
  public cv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(290025);
    Object localObject1 = new d.a();
    ((d.a)localObject1).TW("/cgi-bin/micromsg-bin/finderlivenoticeqrcode");
    ((d.a)localObject1).vD(getType());
    bbi localbbi = new bbi();
    localbbi.SLv = paramString1;
    localbbi.SNe = paramString2;
    Object localObject2 = ao.xcj;
    localbbi.RLM = ao.dnO();
    localObject2 = new bbj();
    ((d.a)localObject1).c((a)localbbi);
    ((d.a)localObject1).d((a)localObject2);
    localObject1 = ((d.a)localObject1).bgN();
    p.j(localObject1, "builder.buildInstance()");
    this.rr = ((d)localObject1);
    Log.i("Finder.NetSceneGetLiveNoticeQrCode", "NetSceneGetLiveNoticeQrCode init userName:" + paramString1 + ", noticeId:" + paramString2 + ' ');
    AppMethodBeat.o(290025);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(290023);
    Log.i("Finder.NetSceneGetLiveNoticeQrCode", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(290023);
      return;
    }
    AppMethodBeat.o(290023);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(290021);
    this.callback = parami;
    parami = this.rr;
    if (parami == null) {
      p.bGy("rr");
    }
    int i = dispatch(paramg, (s)parami, (m)this);
    AppMethodBeat.o(290021);
    return i;
  }
  
  public final bbj dph()
  {
    AppMethodBeat.i(290024);
    Object localObject = this.rr;
    if (localObject == null) {
      p.bGy("rr");
    }
    localObject = ((d)localObject).bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveNoticeQRCodeResponse");
      AppMethodBeat.o(290024);
      throw ((Throwable)localObject);
    }
    localObject = (bbj)localObject;
    AppMethodBeat.o(290024);
    return localObject;
  }
  
  public final int getType()
  {
    return 4214;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneGetLiveNoticeQrCode$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cv
 * JD-Core Version:    0.7.0.1
 */