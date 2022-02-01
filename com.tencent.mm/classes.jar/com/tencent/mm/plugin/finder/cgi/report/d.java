package com.tencent.mm.plugin.finder.cgi.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.b.a.ec;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/report/FinderCgiReport;", "", "cigTrack", "Lcom/tencent/mm/plugin/finder/cgi/report/ICgiTrack;", "(Lcom/tencent/mm/plugin/finder/cgi/report/ICgiTrack;)V", "TAG", "", "TAG_DEBUG", "TAG_DETAIL", "actionTime", "", "cgiCostTime", "cgiLog", "", "cgiProcessTime", "fromCommentScene", "getFromCommentScene", "()I", "setFromCommentScene", "(I)V", "testTime", "Lcom/tencent/mm/compatible/util/CodeInfo$TestTime;", "cgiReport", "", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "endCgiNetWork", "endCgiProcess", "start", "plugin-finder_release"})
public final class d
{
  private final String TAG;
  private long dCz;
  private f.a hvh;
  public int tyh;
  private final String tyi;
  private final String tyj;
  private long tyk;
  private long tyl;
  private final int tym;
  private final e tyn;
  
  public d(e parame)
  {
    AppMethodBeat.i(242693);
    this.tyn = parame;
    this.TAG = ("Finder.FinderCgiReport" + hashCode());
    this.tyi = ("Finder.FinderCgiLogRP" + hashCode());
    this.tyj = ("Finder.FinderCgiDetail" + hashCode());
    this.hvh = new f.a();
    parame = c.vCb;
    this.tym = ((Number)c.dxc().value()).intValue();
    AppMethodBeat.o(242693);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.d paramd)
  {
    AppMethodBeat.i(242692);
    if (this.tym == 1)
    {
      localObject1 = a.tya;
      if (paramd == null) {
        break label610;
      }
      localObject1 = paramd.getUri();
      if ((!a.asQ((String)localObject1)) && (paramd != null))
      {
        localObject1 = paramd.aYK();
        if (localObject1 != null) {
          Log.i(this.tyj, "uri:" + paramd.getUri() + " response " + com.tencent.mm.ac.g.bN(localObject1));
        }
      }
    }
    int j;
    label102:
    Object localObject2;
    Object localObject3;
    if (paramInt2 != 0)
    {
      j = 1;
      localObject1 = this.tyn.cXS();
      int i = 0;
      if (localObject1 == b.tye) {
        i = 1;
      }
      localObject2 = a.tya;
      if (a.cZs()) {
        i = 0;
      }
      if (((j == 0) && (i == 0)) || (localObject1 == b.tyf)) {
        break label1010;
      }
      localObject3 = new ec();
      ((ec)localObject3).afx();
      if (localObject1 != b.tye) {
        break label622;
      }
      ((ec)localObject3).lz(3L);
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
      if (!n.J((String)localObject1, "/cgi-bin/micromsg-bin", false)) {
        break label634;
      }
      if (paramd != null)
      {
        localObject1 = paramd.getUri();
        if (localObject1 != null)
        {
          localObject2 = n.oD((String)localObject1, "/");
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label266;
          }
        }
      }
      localObject1 = "";
      label266:
      ((ec)localObject3).qF((String)localObject1);
      localObject1 = this.tyn.cXV();
      if (localObject1 != null)
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("actionExt", localObject1);
        localObject1 = ((JSONObject)localObject2).toString();
        p.g(localObject1, "JSONObject().also { json…             }.toString()");
        ((ec)localObject3).qG(n.j((String)localObject1, ",", ";", false));
      }
      ((ec)localObject3).lC(this.dCz);
      ((ec)localObject3).le(paramInt2);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("errType", paramInt1);
      localJSONObject.put("errCode", paramInt2);
      if (paramString != null)
      {
        localObject2 = n.j(paramString, ",", ";", false);
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localJSONObject.put("errMsg", localObject1);
      localJSONObject.put("cost", this.tyk);
      localJSONObject.put("actionTime", this.dCz);
      localJSONObject.put("cgiProcessTime", this.tyl - this.tyk);
      localJSONObject.put("cgiAllTime", this.tyl);
      localObject1 = this.tyn.cXW();
      if (localObject1 != null) {
        localJSONObject.put("resultExt", localObject1);
      }
      localObject1 = localJSONObject.toString();
      p.g(localObject1, "JSONObject().also { json…             }.toString()");
      ((ec)localObject3).qH(n.j((String)localObject1, ",", ";", false));
      ((ec)localObject3).lA(this.tyh);
      ((ec)localObject3).lB(this.tyk);
      localObject1 = com.tencent.mm.kernel.g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).azQ().get(ar.a.OjH, "");
      if (localObject1 != null) {
        break label663;
      }
      paramString = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(242692);
      throw paramString;
      label610:
      localObject1 = null;
      break;
      j = 0;
      break label102;
      label622:
      ((ec)localObject3).lz(2L);
    }
    label634:
    if (paramd != null) {}
    for (Object localObject1 = paramd.getUri();; localObject1 = null)
    {
      ((ec)localObject3).qF((String)localObject1);
      break;
    }
    label663:
    ((ec)localObject3).qI((String)localObject1);
    localObject1 = a.tya;
    label716:
    boolean bool2;
    if (paramd != null)
    {
      localObject1 = paramd.getUri();
      if (a.asP((String)localObject1)) {
        break label1010;
      }
      localObject1 = a.tya;
      if (paramd == null) {
        break label993;
      }
      localObject1 = paramd.getUri();
      bool2 = a.dv((String)localObject1, paramInt2);
      bool1 = bool2;
      if (!bool2)
      {
        if (this.tym == 1) {
          Log.d(this.tyi, "report value " + ((ec)localObject3).abW());
        }
        ((ec)localObject3).bfK();
      }
    }
    label812:
    label993:
    label1005:
    label1010:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localObject2 = this.TAG;
      localObject3 = new StringBuilder("onCgiBack ");
      if (paramd != null)
      {
        localObject1 = Integer.valueOf(paramd.getReqCmdId());
        localObject1 = ((StringBuilder)localObject3).append(localObject1).append(" errType ").append(paramInt1).append(' ').append(paramInt2).append(' ').append(paramString).append(" uri:");
        if (paramd == null) {
          break label1005;
        }
      }
      for (paramString = paramd.getUri();; paramString = null)
      {
        Log.i((String)localObject2, paramString + " costTime:(" + this.tyk + ',' + (this.tyl - this.tyk) + ',' + this.tyl + ") fromCommentScene:" + this.tyh + " report:" + this.tyn.cXS() + " limitBlock:" + bool1 + ' ' + this.tyn.cXS());
        AppMethodBeat.o(242692);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label716;
        localObject1 = null;
        break label812;
      }
    }
  }
  
  public final void cZt()
  {
    AppMethodBeat.i(242690);
    this.tyk = this.hvh.apr();
    AppMethodBeat.o(242690);
  }
  
  public final void cZu()
  {
    AppMethodBeat.i(242691);
    this.tyl = this.hvh.apr();
    AppMethodBeat.o(242691);
  }
  
  public final void g(com.tencent.mm.ak.d paramd)
  {
    AppMethodBeat.i(242689);
    this.hvh.reset();
    this.dCz = cl.aWA();
    if (this.tym == 1)
    {
      Object localObject = a.tya;
      if (paramd != null) {}
      for (localObject = paramd.getUri(); (!a.asQ((String)localObject)) && (paramd != null); localObject = null)
      {
        localObject = paramd.aYJ();
        if (localObject == null) {
          break;
        }
        Log.i(this.tyj, "uri:" + paramd.getUri() + " request buf: " + com.tencent.mm.ac.g.bN(localObject));
        AppMethodBeat.o(242689);
        return;
      }
    }
    AppMethodBeat.o(242689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.report.d
 * JD-Core Version:    0.7.0.1
 */