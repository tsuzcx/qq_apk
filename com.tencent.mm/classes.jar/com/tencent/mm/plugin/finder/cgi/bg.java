package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.aqr;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFansList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "liveId", "", "scene", "", "(Lcom/tencent/mm/protobuf/ByteString;JI)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFansList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bg
  extends ax
  implements m
{
  private final String TAG;
  private i callback;
  private d rr;
  
  public bg(b paramb, long paramLong, int paramInt)
  {
    AppMethodBeat.i(242393);
    this.TAG = "Finder.NetSceneFinderGetFansList";
    d.a locala = new d.a();
    locala.sG(getType());
    arx localarx = new arx();
    localarx.finderUsername = z.aUg();
    localarx.tVM = paramb;
    paramb = am.tuw;
    localarx.uli = am.cXY();
    localarx.LDo = paramLong;
    localarx.scene = paramInt;
    locala.c((a)localarx);
    locala.d((a)new ary());
    locala.MB("/cgi-bin/micromsg-bin/findergetfanslist");
    paramb = locala.aXF();
    p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i(this.TAG, "NetSceneFinderGetFansList,liveId:" + paramLong + ",scene:" + paramInt);
    AppMethodBeat.o(242393);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242389);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      e.Cxv.idkeyStat(1279L, 9L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null)
      {
        params = this.callback;
        if (params == null) {
          p.hyc();
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      }
      AppMethodBeat.o(242389);
      return;
      e.Cxv.idkeyStat(1279L, 10L, 1L, false);
    }
  }
  
  public final b cYm()
  {
    AppMethodBeat.i(242391);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListResponse");
      AppMethodBeat.o(242391);
      throw ((Throwable)localObject);
    }
    localObject = ((ary)localObject).tVM;
    AppMethodBeat.o(242391);
    return localObject;
  }
  
  public final b cYn()
  {
    AppMethodBeat.i(242390);
    Object localObject = this.rr.aYJ();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListRequest");
      AppMethodBeat.o(242390);
      throw ((Throwable)localObject);
    }
    localObject = ((arx)localObject).tVM;
    AppMethodBeat.o(242390);
    return localObject;
  }
  
  public final LinkedList<aqr> cYo()
  {
    AppMethodBeat.i(165219);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListResponse");
      AppMethodBeat.o(165219);
      throw ((Throwable)localObject);
    }
    localObject = ((ary)localObject).LDp;
    AppMethodBeat.o(165219);
    return localObject;
  }
  
  public final boolean cYp()
  {
    AppMethodBeat.i(242392);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListResponse");
      AppMethodBeat.o(242392);
      throw ((Throwable)localObject);
    }
    if (((ary)localObject).continueFlag != 0)
    {
      AppMethodBeat.o(242392);
      return true;
    }
    AppMethodBeat.o(242392);
    return false;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(165217);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(165217);
    return i;
  }
  
  public final int getType()
  {
    return 3531;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bg
 * JD-Core Version:    0.7.0.1
 */