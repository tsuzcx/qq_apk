package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.hy;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.awj;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dno;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneDeleteFinderObject;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "objectId", "", "objectNonceId", "isMegaVideo", "", "(Ljava/lang/String;JLjava/lang/String;Z)V", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "megaVideo", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/MegaVideo;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getDelId", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bt
  extends com.tencent.mm.plugin.findersdk.b.h
{
  private FinderObject ABJ;
  private dne ABK;
  private String TAG;
  private com.tencent.mm.am.h callback;
  public long hKN;
  private c rr;
  
  public bt(String paramString1, long paramLong, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(336422);
    this.TAG = "Finder.NetSceneDeleteFinderObject";
    c.a locala = new c.a();
    locala.uri = "/cgi-bin/micromsg-bin/finderdelfeed";
    locala.funcId = getType();
    awi localawi = new awi();
    localawi.id = paramLong;
    localawi.objectNonceId = paramString2;
    localawi.ZHf = paramString1;
    paramString1 = bi.ABn;
    localawi.CJv = bi.dVu();
    paramString1 = localawi.CJv;
    kotlin.g.b.s.checkNotNull(paramString1);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramString1.scene = i;
      locala.otE = ((a)localawi);
      locala.otF = ((a)new awj());
      paramString1 = locala.bEF();
      kotlin.g.b.s.s(paramString1, "builder.buildInstance()");
      this.rr = paramString1;
      this.hKN = paramLong;
      AppMethodBeat.o(336422);
      return;
    }
  }
  
  public bt(String paramString, FinderObject paramFinderObject)
  {
    this(paramString, l, str1);
    AppMethodBeat.i(336434);
    this.ABJ = paramFinderObject;
    AppMethodBeat.o(336434);
  }
  
  public bt(String paramString, dne paramdne) {}
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336458);
    Log.i(this.TAG, "errType " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    Object localObject;
    long l2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.ABJ;
      if (params == null) {
        break label467;
      }
      localObject = d.FND;
      d.a.qs(this.hKN);
      l2 = this.hKN;
      params = params.attachmentList;
      if (params != null) {
        break label310;
      }
      l1 = 0L;
      if (l1 != 0L)
      {
        params = d.FND;
        d.a.qt(l1);
      }
    }
    label310:
    label457:
    label467:
    for (long l1 = l2;; l1 = 0L)
    {
      params = this.ABK;
      l2 = l1;
      if (params != null)
      {
        localObject = d.FND;
        d.a.qt(params.id);
        params = params.aaUv;
        if (params != null) {
          break label457;
        }
      }
      for (l1 = 0L;; l1 = params.hKN)
      {
        l2 = l1;
        if (l1 != 0L)
        {
          params = d.FND;
          d.a.qs(l1);
          l2 = l1;
        }
        if (l2 != 0L)
        {
          params = new hy();
          params.hJo.id = l2;
          params.publish();
        }
        if ((this.ABJ == null) && (this.ABK == null))
        {
          params = d.FND;
          if (d.a.qs(this.hKN))
          {
            params = new hy();
            params.hJo.id = this.hKN;
            params.publish();
          }
        }
        params = this.callback;
        if (params != null) {
          params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
        }
        AppMethodBeat.o(336458);
        return;
        params = params.ZEi;
        if (params == null)
        {
          l1 = 0L;
          break;
        }
        localObject = ((Iterable)params).iterator();
        atq localatq;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          params = ((Iterator)localObject).next();
          localatq = (atq)params;
          av localav = av.GiL;
          kotlin.g.b.s.s(localatq, "it");
        } while (!av.a(localatq));
        for (;;)
        {
          params = (atq)params;
          if (params != null) {
            break label411;
          }
          l1 = 0L;
          break;
          params = null;
        }
        params = params.ZEf;
        if (params == null)
        {
          l1 = 0L;
          break;
        }
        params = params.ZXx;
        if (params == null)
        {
          l1 = 0L;
          break;
        }
        l1 = params.id;
        break;
      }
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(165205);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(165205);
    return i;
  }
  
  public final int getType()
  {
    return 3627;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bt
 * JD-Core Version:    0.7.0.1
 */