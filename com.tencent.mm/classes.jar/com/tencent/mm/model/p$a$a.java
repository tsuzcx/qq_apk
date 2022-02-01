package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.z.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.core.i.a;
import com.tencent.mm.protocal.protobuf.cra;
import com.tencent.mm.protocal.protobuf.enh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.d.d;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"<anonymous>", "", "errType", "errCode", "<anonymous parameter 2>", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;"}, k=3, mv={1, 5, 1}, xi=48)
final class p$a$a
  implements z.a
{
  p$a$a(ah.a parama, d<? super cra> paramd, p.f paramf) {}
  
  public final int callback(int paramInt1, int paramInt2, String paramString, c paramc, com.tencent.mm.am.p paramp)
  {
    int i = 1;
    Object localObject = null;
    AppMethodBeat.i(241900);
    s.u(paramc, "rr");
    s.u(paramp, "$noName_4");
    Log.i("Micromsg.BizTLRecFeedsDataUtil", "getRecommendFeeds callback " + paramInt1 + ", " + paramInt2);
    if (this.ojj.aiwY)
    {
      paramString = o.ojb;
      o.ir(6L);
      AppMethodBeat.o(241900);
      return 0;
    }
    this.ojj.aiwY = true;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      try
      {
        paramString = o.ojb;
        o.ir(3L);
        paramString = this.ojk;
        paramc = Result.Companion;
        paramString.resumeWith(Result.constructor-impl(null));
        AppMethodBeat.o(241900);
        return 0;
      }
      catch (Exception paramString)
      {
        paramc = o.ojb;
        o.ir(7L);
        Log.e("Micromsg.BizTLRecFeedsDataUtil", s.X("callback ex ", paramString.getMessage()));
      }
      AppMethodBeat.o(241900);
      return 0;
    }
    paramString = o.ojb;
    o.ir(2L);
    if (!(c.c.b(paramc.otC) instanceof cra))
    {
      paramString = this.ojk;
      paramc = Result.Companion;
      paramString.resumeWith(Result.constructor-impl(null));
      AppMethodBeat.o(241900);
      return 0;
    }
    paramString = c.c.b(paramc.otC);
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetRecommendFeedsResp");
      AppMethodBeat.o(241900);
      throw paramString;
    }
    paramc = (cra)paramString;
    paramString = i.Wya;
    if (i.a.anH())
    {
      paramString = MultiProcessMMKV.getSingleMMKV("brandService");
      if ((paramString == null) || (paramString.decodeInt("BizTimeLineRecFeedStatus", 1) != 0)) {
        break label684;
      }
    }
    label657:
    label666:
    label675:
    label684:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      if (paramInt1 != 0)
      {
        paramString = paramc.aaxG;
        if (paramString != null) {
          paramString.clear();
        }
      }
      paramp = new StringBuilder("getRecommendFeeds card size=");
      paramString = paramc.aaxG;
      if (paramString == null)
      {
        paramString = null;
        label329:
        paramp = paramp.append(paramString).append(' ');
        paramString = paramc.aaxH;
        if (paramString != null) {
          break label595;
        }
        paramString = (String)localObject;
        label355:
        Log.i("Micromsg.BizTLRecFeedsDataUtil", paramString);
        if ((paramc.aaxD != null) && (paramc.aaxD.Op.length > 0))
        {
          paramString = p.ojc;
          p.a.atj().encode("GetRecommendFeedsBuffer", paramc.aaxD.toByteArray());
        }
        if (p.f.oju.scene == this.ojl.scene)
        {
          paramString = p.ojc;
          p.a.atj().encode("RecommendFeedsWording", paramc.aaxI);
          paramString = p.ojc;
          paramString = p.a.atj();
          paramp = paramc.aaxH;
          if (paramp != null) {
            break label657;
          }
          paramInt1 = 1800;
          label469:
          paramString.encode("ProtectionTime", paramInt1);
          paramString = p.ojc;
          paramString = p.a.atj();
          paramp = paramc.aaxH;
          if (paramp != null) {
            break label666;
          }
          paramInt1 = 10;
          label501:
          paramString.encode("BizmsgContextCnt", paramInt1);
        }
        paramString = p.ojc;
        paramString = p.a.atj();
        paramp = s.X("NextReqTime-", Integer.valueOf(this.ojl.scene));
        localObject = paramc.aaxH;
        if (localObject != null) {
          break label675;
        }
      }
      for (paramInt1 = 600;; paramInt1 = ((enh)localObject).abrN)
      {
        paramString.encode(paramp, paramInt1);
        paramString = this.ojk;
        paramp = Result.Companion;
        paramString.resumeWith(Result.constructor-impl(paramc));
        break;
        paramString = Integer.valueOf(paramString.size());
        break label329;
        label595:
        localObject = p.ojc;
        s.u(paramString, "<this>");
        paramString = "NextReqTime=" + paramString.abrN + " ProtectionTime=" + paramString.abrO + " BizmsgContextCnt=" + paramString.abrR;
        break label355;
        paramInt1 = paramp.abrO;
        break label469;
        paramInt1 = paramp.abrR;
        break label501;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.p.a.a
 * JD-Core Version:    0.7.0.1
 */