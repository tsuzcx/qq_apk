package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ats;
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.protocal.protobuf.bdk;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTagContact;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "getTagScene", "", "(I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getGetTagScene", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getTagContacts", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderTagContact;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class br
  extends ax
  implements m
{
  private static final String TAG = "Finder.NetSceneFinderGetTagContact";
  public static final a tvA;
  private static final int tvz = 1;
  private i callback;
  private d rr;
  private final int tvy;
  
  static
  {
    AppMethodBeat.i(242456);
    tvA = new a((byte)0);
    TAG = "Finder.NetSceneFinderGetTagContact";
    tvz = 1;
    AppMethodBeat.o(242456);
  }
  
  public br(int paramInt)
  {
    AppMethodBeat.i(242455);
    this.tvy = paramInt;
    Object localObject = new d.a();
    ((d.a)localObject).sG(getType());
    ats localats = new ats();
    localats.scene = this.tvy;
    am localam = am.tuw;
    localats.LAI = am.cXY();
    ((d.a)localObject).c((a)localats);
    ((d.a)localObject).d((a)new att());
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/findergettagcontact");
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((d)localObject);
    Log.i(TAG, "NetSceneFinderGetTagContact");
    AppMethodBeat.o(242455);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242453);
    Log.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.hyc();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(242453);
  }
  
  public final LinkedList<bdk> cYF()
  {
    AppMethodBeat.i(242454);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetTagContactResp");
      AppMethodBeat.o(242454);
      throw ((Throwable)localObject);
    }
    localObject = ((att)localObject).LDz;
    AppMethodBeat.o(242454);
    return localObject;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242452);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242452);
    return i;
  }
  
  public final int getType()
  {
    return 3528;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetTagContact$Companion;", "", "()V", "GetTagContactScene_Not_Interesting", "", "getGetTagContactScene_Not_Interesting", "()I", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.br
 * JD-Core Version:    0.7.0.1
 */