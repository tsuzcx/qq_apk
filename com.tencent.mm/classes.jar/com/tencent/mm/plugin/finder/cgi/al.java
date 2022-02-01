package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.al.b.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.protocal.protobuf.dyz;
import com.tencent.mm.protocal.protobuf.dza;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.ab;
import d.g.b.k;
import d.v;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetHotRelatedList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "feedId", "", "nonceId", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getFeedId", "()J", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class al
  extends com.tencent.mm.al.a<dza>
{
  public static final a KJw;
  private static final boolean cxf;
  private final String KJv;
  final long feedId;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(197270);
    KJw = new a((byte)0);
    if ((h.IS_FLAVOR_PURPLE) || (h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.a.b.eEQ())) {
      bool = true;
    }
    cxf = bool;
    AppMethodBeat.o(197270);
  }
  
  public al(long paramLong, String paramString, dzp paramdzp)
  {
    AppMethodBeat.i(197269);
    this.feedId = paramLong;
    this.KJv = paramString;
    paramString = g.afB();
    k.g(paramString, "MMKernel.storage()");
    paramString = paramString.afk();
    Object localObject = i.qTa;
    paramString = paramString.get(i.ahH(4), "");
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(197269);
      throw paramString;
    }
    paramString = com.tencent.mm.bx.b.cd(bt.aGd((String)paramString));
    localObject = new b.a();
    ((b.a)localObject).nB(3688);
    dyz localdyz = new dyz();
    localdyz.objectId = this.feedId;
    localdyz.objectNonceId = this.KJv;
    am localam = am.KJy;
    localdyz.DlF = am.a(paramdzp);
    localdyz.scene = 4;
    localdyz.IoU = 4;
    localdyz.KKa = paramString;
    ((b.a)localObject).c((com.tencent.mm.bx.a)localdyz);
    ((b.a)localObject).d((com.tencent.mm.bx.a)new dza());
    ((b.a)localObject).wg("/cgi-bin/micromsg-bin/findergetrelatedlist");
    c(((b.a)localObject).atI());
    ad.i("CgiGetHotRelatedList", "feedId=" + c.ly(this.feedId) + " objectNonceId=" + this.KJv + " streamLastBuffer=" + paramString);
    AppMethodBeat.o(197269);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetHotRelatedList$Companion;", "", "()V", "TAG", "", "isDebug", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(al paramal)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.al
 * JD-Core Version:    0.7.0.1
 */