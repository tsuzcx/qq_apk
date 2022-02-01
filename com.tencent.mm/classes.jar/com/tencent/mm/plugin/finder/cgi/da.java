package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOriginal;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "apply", "", "getWording", "(Ljava/lang/String;ZZ)V", "getApply", "()Z", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getGetWording", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUsername", "()Ljava/lang/String;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class da
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final a ACT;
  private static final String TAG;
  private final boolean ACU;
  private final boolean ACV;
  private com.tencent.mm.am.h callback;
  private c rr;
  private final String username;
  
  static
  {
    AppMethodBeat.i(336600);
    ACT = new a((byte)0);
    TAG = "Finder.NetSceneFinderOriginal";
    AppMethodBeat.o(336600);
  }
  
  private da(String paramString)
  {
    AppMethodBeat.i(336580);
    this.username = paramString;
    this.ACU = true;
    this.ACV = false;
    paramString = new c.a();
    paramString.funcId = getType();
    Object localObject = new ato();
    ((ato)localObject).finderUsername = this.username;
    bi localbi = bi.ABn;
    ((ato)localObject).ZEc = bi.dVu();
    if (this.ACV) {
      i = 3;
    }
    for (;;)
    {
      ((ato)localObject).hYl = i;
      paramString.otE = ((a)localObject);
      localObject = new atp();
      ((atp)localObject).setBaseResponse(new kd());
      paramString.otF = ((a)localObject);
      paramString.uri = "/cgi-bin/micromsg-bin/finderapplyoriginal";
      paramString = paramString.bEF();
      kotlin.g.b.s.s(paramString, "builder.buildInstance()");
      this.rr = paramString;
      Log.i(TAG, kotlin.g.b.s.X("NetSceneFinderOriginal init ", Boolean.valueOf(this.ACU)));
      AppMethodBeat.o(336580);
      return;
      if (!this.ACU) {
        i = 2;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    Object localObject = null;
    AppMethodBeat.i(336626);
    Log.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    aq localaq;
    at.a locala;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = c.c.b(this.rr.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderApplyOriginalResponse");
        AppMethodBeat.o(336626);
        throw paramString;
      }
      params = (atp)params;
      if (!this.ACV)
      {
        FinderContact localFinderContact = params.ZEd;
        if ((localFinderContact != null) && (Util.isEqual(localFinderContact.username, z.bAW())))
        {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.adag, Integer.valueOf(localFinderContact.originalFlag));
          com.tencent.mm.kernel.h.baE().ban().set(at.a.adal, Integer.valueOf(localFinderContact.originalEntranceFlag));
          if (localFinderContact.originalInfo != null)
          {
            localaq = com.tencent.mm.kernel.h.baE().ban();
            locala = at.a.adah;
            params = localFinderContact.originalInfo;
            if (params != null) {
              break label406;
            }
            params = null;
            localaq.set(locala, params);
            localaq = com.tencent.mm.kernel.h.baE().ban();
            locala = at.a.adai;
            params = localFinderContact.originalInfo;
            if (params != null) {
              break label419;
            }
            params = null;
            label246:
            localaq.set(locala, params);
            localaq = com.tencent.mm.kernel.h.baE().ban();
            locala = at.a.adaj;
            params = localFinderContact.originalInfo;
            if (params != null) {
              break label432;
            }
            params = null;
            label283:
            localaq.set(locala, params);
            localaq = com.tencent.mm.kernel.h.baE().ban();
            locala = at.a.adak;
            params = localFinderContact.originalInfo;
            if (params != null) {
              break label445;
            }
            params = null;
            label320:
            localaq.set(locala, params);
            localaq = com.tencent.mm.kernel.h.baE().ban();
            locala = at.a.adan;
            params = localFinderContact.originalInfo;
            if (params != null) {
              break label458;
            }
          }
        }
      }
    }
    label406:
    label419:
    label432:
    label445:
    label458:
    for (params = localObject;; params = Integer.valueOf(params.aaaa))
    {
      localaq.set(locala, params);
      if (this.callback != null)
      {
        params = this.callback;
        kotlin.g.b.s.checkNotNull(params);
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(336626);
      return;
      params = Integer.valueOf(params.ZZW);
      break;
      params = Integer.valueOf(params.ZZX);
      break label246;
      params = Integer.valueOf(params.ZZY);
      break label283;
      params = Integer.valueOf(params.ZZZ);
      break label320;
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336614);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(336614);
    return i;
  }
  
  public final int getType()
  {
    return 3785;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOriginal$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.da
 * JD-Core Version:    0.7.0.1
 */