package com.tencent.mm.plugin.findersdk.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.g;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.f.b.a.ez;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/cgi/report/FinderCgiReport;", "", "cigTrack", "Lcom/tencent/mm/plugin/findersdk/cgi/report/ICgiTrack;", "(Lcom/tencent/mm/plugin/findersdk/cgi/report/ICgiTrack;)V", "TAG", "", "TAG_DEBUG", "TAG_DETAIL", "actionTime", "", "cgiCostTime", "cgiLog", "", "cgiProcessTime", "fromCommentScene", "getFromCommentScene", "()I", "setFromCommentScene", "(I)V", "testTime", "Lcom/tencent/mm/compatible/util/CodeInfo$TestTime;", "cgiReport", "", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "endCgiNetWork", "endCgiProcess", "longLog", "tag", "log", "start", "finder-sdk_release"})
public final class d
{
  private final String BvY;
  private final String BvZ;
  private long Bwa;
  private long Bwb;
  private final int Bwc;
  private final e Bwd;
  private final String TAG;
  public int fGo;
  private long fvg;
  private f.a khd;
  
  public d(e parame)
  {
    AppMethodBeat.i(209915);
    this.Bwd = parame;
    this.TAG = "Finder.FinderCgiReport";
    this.BvY = ("Finder.FinderCgiLogRP" + hashCode());
    this.BvZ = ("Finder.FinderCgiDetail" + hashCode());
    this.khd = new f.a();
    parame = com.tencent.mm.plugin.findersdk.d.a.b.Bwn;
    this.Bwc = ((Number)com.tencent.mm.plugin.findersdk.d.a.b.ent().aSr()).intValue();
    AppMethodBeat.o(209915);
  }
  
  private static void hz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(209913);
    int j;
    String str;
    label40:
    int i;
    if (paramString2.length() < 4000)
    {
      Log.i(paramString1, paramString2);
      AppMethodBeat.o(209913);
      return;
      str = paramString2.substring(j);
      p.j(str, "(this as java.lang.String).substring(startIndex)");
      Log.i(paramString1, "=>id:" + i + ' ' + str);
      i += 1;
      j += 4000;
    }
    for (;;)
    {
      if (j < paramString2.length())
      {
        if (paramString2.length() <= j + 4000)
        {
          if (paramString2 != null) {
            break;
          }
          paramString1 = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(209913);
          throw paramString1;
        }
        if (paramString2 == null)
        {
          paramString1 = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(209913);
          throw paramString1;
        }
        str = paramString2.substring(j, j + 4000);
        p.j(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        break label40;
      }
      AppMethodBeat.o(209913);
      return;
      i = 0;
      j = 0;
    }
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd)
  {
    AppMethodBeat.i(209914);
    if (this.Bwc == 1)
    {
      localObject1 = a.BvR;
      if (paramd == null) {
        break label647;
      }
      localObject1 = paramd.getUri();
      if ((!a.aGO((String)localObject1)) && (paramd != null))
      {
        localObject1 = paramd.bhY();
        if (localObject1 != null)
        {
          Log.i(this.BvZ, "##########response uri: ===> " + paramd.getUri());
          hz(this.BvZ, "uri:" + paramd.getUri() + " response " + g.bN(localObject1));
        }
      }
    }
    int j;
    label129:
    Object localObject2;
    Object localObject3;
    if (paramInt2 != 0)
    {
      j = 1;
      localObject1 = this.Bwd.dnF();
      int i = 0;
      if (localObject1 == b.BvU) {
        i = 1;
      }
      localObject2 = a.BvR;
      if (a.eno()) {
        i = 0;
      }
      if (((j == 0) && (i == 0)) || (localObject1 == b.BvV)) {
        break label1047;
      }
      localObject3 = new ez();
      ((ez)localObject3).akv();
      if (localObject1 != b.BvU) {
        break label659;
      }
      ((ez)localObject3).mL(3L);
    }
    for (;;)
    {
      if (paramd != null)
      {
        localObject2 = paramd.getUri();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      if (!n.M((String)localObject1, "/cgi-bin/micromsg-bin", false)) {
        break label671;
      }
      if (paramd != null)
      {
        localObject1 = paramd.getUri();
        if (localObject1 != null)
        {
          localObject2 = n.pz((String)localObject1, "/");
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label294;
          }
        }
      }
      localObject1 = "";
      label294:
      ((ez)localObject3).tI((String)localObject1);
      localObject1 = this.Bwd.dnI();
      if (localObject1 != null)
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("actionExt", localObject1);
        localObject1 = ((JSONObject)localObject2).toString();
        p.j(localObject1, "JSONObject().also { json…             }.toString()");
        ((ez)localObject3).tJ(n.l((String)localObject1, ",", ";", false));
      }
      ((ez)localObject3).mO(this.fvg);
      ((ez)localObject3).ms(paramInt2);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("errType", paramInt1);
      localJSONObject.put("errCode", paramInt2);
      if (paramString != null)
      {
        localObject2 = n.l(paramString, ",", ";", false);
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localJSONObject.put("errMsg", localObject1);
      localJSONObject.put("cost", this.Bwa);
      localJSONObject.put("actionTime", this.fvg);
      localJSONObject.put("cgiProcessTime", this.Bwb - this.Bwa);
      localJSONObject.put("cgiAllTime", this.Bwb);
      localObject1 = this.Bwd.dnJ();
      if (localObject1 != null) {
        localJSONObject.put("resultExt", localObject1);
      }
      localObject1 = localJSONObject.toString();
      p.j(localObject1, "JSONObject().also { json…             }.toString()");
      ((ez)localObject3).tK(n.l((String)localObject1, ",", ";", false));
      ((ez)localObject3).mM(this.fGo);
      ((ez)localObject3).mN(this.Bwa);
      localObject1 = h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      localObject1 = ((f)localObject1).aHp().get(ar.a.VxY, "");
      if (localObject1 != null) {
        break label700;
      }
      paramString = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(209914);
      throw paramString;
      label647:
      localObject1 = null;
      break;
      j = 0;
      break label129;
      label659:
      ((ez)localObject3).mL(2L);
    }
    label671:
    if (paramd != null) {}
    for (Object localObject1 = paramd.getUri();; localObject1 = null)
    {
      ((ez)localObject3).tI((String)localObject1);
      break;
    }
    label700:
    ((ez)localObject3).tL((String)localObject1);
    localObject1 = a.BvR;
    label753:
    boolean bool2;
    if (paramd != null)
    {
      localObject1 = paramd.getUri();
      if (a.aGN((String)localObject1)) {
        break label1047;
      }
      localObject1 = a.BvR;
      if (paramd == null) {
        break label1030;
      }
      localObject1 = paramd.getUri();
      bool2 = a.ep((String)localObject1, paramInt2);
      bool1 = bool2;
      if (!bool2)
      {
        if (this.Bwc == 1) {
          Log.d(this.BvY, "report value " + ((ez)localObject3).agI());
        }
        ((ez)localObject3).bpa();
      }
    }
    label1030:
    label1042:
    label1047:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localObject2 = this.TAG;
      localObject3 = new StringBuilder("onCgiBack ");
      if (paramd != null)
      {
        localObject1 = Integer.valueOf(paramd.getReqCmdId());
        label849:
        localObject1 = ((StringBuilder)localObject3).append(localObject1).append(" errType ").append(paramInt1).append(' ').append(paramInt2).append(' ').append(paramString).append(" uri:");
        if (paramd == null) {
          break label1042;
        }
      }
      for (paramString = paramd.getUri();; paramString = null)
      {
        Log.i((String)localObject2, paramString + " costTime:(" + this.Bwa + ',' + (this.Bwb - this.Bwa) + ',' + this.Bwb + ") fromCommentScene:" + this.fGo + " report:" + this.Bwd.dnF() + " limitBlock:" + bool1 + ' ' + this.Bwd.dnF());
        AppMethodBeat.o(209914);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label753;
        localObject1 = null;
        break label849;
      }
    }
  }
  
  public final void enp()
  {
    AppMethodBeat.i(209911);
    this.Bwa = this.khd.avE();
    AppMethodBeat.o(209911);
  }
  
  public final void enq()
  {
    AppMethodBeat.i(209912);
    this.Bwb = this.khd.avE();
    AppMethodBeat.o(209912);
  }
  
  public final void h(com.tencent.mm.an.d paramd)
  {
    AppMethodBeat.i(209909);
    this.khd.reset();
    this.fvg = cm.bfE();
    if (this.Bwc == 1)
    {
      Object localObject = a.BvR;
      if (paramd != null) {}
      for (localObject = paramd.getUri(); (!a.aGO((String)localObject)) && (paramd != null); localObject = null)
      {
        localObject = paramd.bhX();
        if (localObject == null) {
          break;
        }
        Log.i(this.BvZ, "##########request uri: ===> " + paramd.getUri());
        if (BuildInfo.DEBUG) {
          Log.i(this.BvZ, "uri:" + paramd.getUri() + " request stack: " + Util.getStack() + ' ');
        }
        hz(this.BvZ, "uri:" + paramd.getUri() + " request buf: " + g.bN(localObject));
        AppMethodBeat.o(209909);
        return;
      }
    }
    AppMethodBeat.o(209909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.b.a.d
 * JD-Core Version:    0.7.0.1
 */