package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ajb;
import com.tencent.mm.protocal.protobuf.ajc;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import d.g.a.s;
import d.g.b.k;
import d.l;
import d.v;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetHistory;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "pullType", "", "tabType", "callback", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "scene", "", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "useGlobalLastBuffer", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(IILkotlin/jvm/functions/Function5;Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protobuf/ByteString;ZLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiBack", "Companion", "plugin-finder_release"})
public final class c
  extends an<ajc>
{
  public static final a qop;
  private final int IoU;
  private final boolean KJo;
  private final b lastBuffer;
  private final int pullType;
  private final s<Integer, Integer, String, ajc, n, y> qon;
  private final g.c qoo;
  
  static
  {
    AppMethodBeat.i(165165);
    qop = new a((byte)0);
    AppMethodBeat.o(165165);
  }
  
  public c(int paramInt1, int paramInt2, s<? super Integer, ? super Integer, ? super String, ? super ajc, ? super n, y> params, b paramb, boolean paramBoolean, dzp paramdzp)
  {
    super(paramdzp);
    AppMethodBeat.i(197251);
    this.pullType = paramInt1;
    this.IoU = paramInt2;
    this.qon = params;
    this.qoo = null;
    this.lastBuffer = paramb;
    this.KJo = paramBoolean;
    params = new b.a();
    paramb = new ajb();
    paramb.Dls = u.aqO();
    paramb.IoU = this.IoU;
    Object localObject;
    if (this.KJo)
    {
      localObject = g.afB();
      k.g(localObject, "MMKernel.storage()");
      localObject = ((e)localObject).afk();
      i locali = i.qTa;
      localObject = ((ab)localObject).get(i.ahH(this.IoU), "");
      if (localObject == null)
      {
        params = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(197251);
        throw params;
      }
    }
    for (paramb.Dlt = b.cd(bt.aGd((String)localObject));; paramb.Dlt = this.lastBuffer)
    {
      ad.i("Finder.CgiFinderGetHistory", "[request] tabType=" + this.IoU + " pullType=" + this.pullType + " useGlobalLastBuffer=" + this.KJo);
      localObject = am.KJy;
      paramb.Dkw = am.a(paramdzp);
      params.c((a)paramb);
      paramb = new ajc();
      paramb.setBaseResponse(new BaseResponse());
      paramb.getBaseResponse().ErrMsg = new cmf();
      params.d((a)paramb);
      params.wg("/cgi-bin/micromsg-bin/findergethistory");
      params.nB(3814);
      c(params.atI());
      AppMethodBeat.o(197251);
      return;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetHistory$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.c
 * JD-Core Version:    0.7.0.1
 */