package com.tencent.mm.plugin.findersdk.b.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.mmdata.rpt.gn;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/cgi/report/FinderCgiReport;", "", "cigTrack", "Lcom/tencent/mm/plugin/findersdk/cgi/report/ICgiTrack;", "(Lcom/tencent/mm/plugin/findersdk/cgi/report/ICgiTrack;)V", "TAG", "", "TAG_DEBUG", "TAG_DETAIL", "actionTime", "", "cgiCostTime", "cgiLog", "", "cgiProcessTime", "fromCommentScene", "getFromCommentScene", "()I", "setFromCommentScene", "(I)V", "testTime", "Lcom/tencent/mm/compatible/util/CodeInfo$TestTime;", "cgiReport", "", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "endCgiNetWork", "endCgiProcess", "longLog", "tag", "log", "start", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private final e Hdi;
  private final String Hdj;
  private final String Hdk;
  private long Hdl;
  private long Hdm;
  private final int Hdn;
  private final String TAG;
  public int hLK;
  private long hzA;
  private f.a mHw;
  
  public d(e parame)
  {
    AppMethodBeat.i(273861);
    this.Hdi = parame;
    this.TAG = "Finder.FinderCgiReport";
    this.Hdj = s.X("Finder.FinderCgiLogRP", Integer.valueOf(hashCode()));
    this.Hdk = s.X("Finder.FinderCgiDetail", Integer.valueOf(hashCode()));
    this.mHw = new f.a();
    parame = com.tencent.mm.plugin.findersdk.storage.config.b.Hdw;
    this.Hdn = ((Number)com.tencent.mm.plugin.findersdk.storage.config.b.fsf().bmg()).intValue();
    AppMethodBeat.o(273861);
  }
  
  private static void ix(String paramString1, String paramString2)
  {
    AppMethodBeat.i(273872);
    int j;
    String str;
    label40:
    int i;
    if (paramString2.length() < 4000)
    {
      Log.i(paramString1, paramString2);
      AppMethodBeat.o(273872);
      return;
      str = paramString2.substring(j);
      s.s(str, "(this as java.lang.String).substring(startIndex)");
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
          paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(273872);
          throw paramString1;
        }
        if (paramString2 == null)
        {
          paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(273872);
          throw paramString1;
        }
        str = paramString2.substring(j, j + 4000);
        s.s(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        break label40;
      }
      AppMethodBeat.o(273872);
      return;
      i = 0;
      j = 0;
    }
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, c paramc)
  {
    AppMethodBeat.i(273921);
    if (this.Hdn == 1)
    {
      localObject1 = a.HcR;
      if (paramc != null) {
        break label564;
      }
      localObject1 = null;
      if ((!a.aDf((String)localObject1)) && (paramc != null))
      {
        localObject1 = c.c.b(paramc.otC);
        if (localObject1 != null)
        {
          Log.i(this.Hdk, s.X("##########response uri: ===> ", paramc.getUri()));
          ix(this.Hdk, "uri:" + paramc.getUri() + " response " + com.tencent.mm.ae.f.dg(localObject1));
        }
      }
    }
    int j;
    label118:
    Object localObject2;
    Object localObject3;
    label207:
    label217:
    label239:
    Object localObject4;
    if (paramInt2 != 0)
    {
      j = 1;
      localObject1 = this.Hdi.dVi();
      int i = 0;
      if (localObject1 == b.Hde) {
        i = 1;
      }
      localObject2 = a.HcR;
      if (a.frY()) {
        i = 0;
      }
      if (((j == 0) && (i == 0)) || (localObject1 == b.Hdf)) {
        break label1073;
      }
      localObject3 = new gn();
      ((gn)localObject3).iLq = 8;
      if (localObject1 != b.Hde) {
        break label580;
      }
      ((gn)localObject3).isX = 3L;
      if (paramc != null) {
        break label591;
      }
      localObject1 = "";
      if (!n.U((String)localObject1, "/cgi-bin/micromsg-bin", false)) {
        break label662;
      }
      if (paramc != null) {
        break label615;
      }
      localObject1 = "";
      ((gn)localObject3).rk((String)localObject1);
      localObject2 = this.Hdi.dVk();
      if (localObject2 != null)
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("actionExt", localObject2);
        localObject2 = ah.aiuX;
        localObject1 = ((JSONObject)localObject1).toString();
        s.s(localObject1, "JSONObject().also { json…             }.toString()");
        ((gn)localObject3).rl(n.bV((String)localObject1, ",", ";"));
      }
      ((gn)localObject3).iLw = this.hzA;
      ((gn)localObject3).iLt = paramInt2;
      localObject4 = new JSONObject();
      ((JSONObject)localObject4).put("errType", paramInt1);
      ((JSONObject)localObject4).put("errCode", paramInt2);
      if (paramString != null) {
        break label691;
      }
      localObject1 = "";
    }
    for (;;)
    {
      ((JSONObject)localObject4).put("errMsg", localObject1);
      ((JSONObject)localObject4).put("cost", this.Hdl);
      ((JSONObject)localObject4).put("actionTime", this.hzA);
      ((JSONObject)localObject4).put("cgiProcessTime", this.Hdm - this.Hdl);
      ((JSONObject)localObject4).put("cgiAllTime", this.Hdm);
      localObject1 = this.Hdi.dVl();
      if (localObject1 != null) {
        ((JSONObject)localObject4).put("resultExt", localObject1);
      }
      localObject1 = ah.aiuX;
      localObject1 = ((JSONObject)localObject4).toString();
      s.s(localObject1, "JSONObject().also { json…             }.toString()");
      ((gn)localObject3).rm(n.bV((String)localObject1, ",", ";"));
      ((gn)localObject3).ijn = this.hLK;
      ((gn)localObject3).iLv = this.Hdl;
      localObject1 = h.baE().ban().get(at.a.acZS, "");
      if (localObject1 != null) {
        break label720;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(273921);
      throw paramString;
      label564:
      localObject1 = paramc.getUri();
      break;
      j = 0;
      break label118;
      label580:
      ((gn)localObject3).isX = 2L;
      break label207;
      label591:
      localObject2 = paramc.getUri();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label217;
      }
      localObject1 = "";
      break label217;
      label615:
      localObject1 = paramc.getUri();
      if (localObject1 == null)
      {
        localObject1 = "";
        break label239;
      }
      localObject2 = n.rw((String)localObject1, "/");
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label239;
      }
      localObject1 = "";
      break label239;
      label662:
      if (paramc == null) {}
      for (localObject1 = null;; localObject1 = paramc.getUri())
      {
        ((gn)localObject3).rk((String)localObject1);
        break;
      }
      label691:
      localObject2 = n.bV(paramString, ",", ";");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
    label720:
    ((gn)localObject3).rn((String)localObject1);
    Object localObject1 = a.HcR;
    label765:
    boolean bool2;
    if (paramc == null)
    {
      localObject1 = null;
      if (a.aDe((String)localObject1)) {
        break label1073;
      }
      localObject1 = a.HcR;
      if (paramc != null) {
        break label1038;
      }
      localObject1 = null;
      bool2 = a.fe((String)localObject1, paramInt2);
      bool1 = bool2;
      if (!bool2)
      {
        if (this.Hdn == 1) {
          Log.d(this.Hdj, s.X("report value ", ((gn)localObject3).aIF()));
        }
        ((gn)localObject3).bMH();
      }
    }
    label1038:
    label1064:
    label1073:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localObject2 = this.TAG;
      localObject3 = new StringBuilder();
      localObject4 = ((StringBuilder)localObject3).append("onCgiBack ");
      if (paramc == null)
      {
        localObject1 = null;
        label851:
        localObject1 = ((StringBuilder)localObject4).append(localObject1).append(" errType ").append(paramInt1).append(' ').append(paramInt2).append(' ').append(paramString).append(" uri:");
        if (paramc != null) {
          break label1064;
        }
      }
      for (paramString = null;; paramString = paramc.getUri())
      {
        ((StringBuilder)localObject1).append(paramString).append(" costTime:(").append(this.Hdl).append(',').append(this.Hdm - this.Hdl).append(',').append(this.Hdm).append(") fromCommentScene:").append(this.hLK).append(" report:").append(this.Hdi.dVi()).append(" limitBlock:").append(bool1).append(' ');
        ((StringBuilder)localObject3).append(this.Hdi.dVi());
        Log.i((String)localObject2, ((StringBuilder)localObject3).toString());
        AppMethodBeat.o(273921);
        return;
        localObject1 = paramc.getUri();
        break;
        localObject1 = paramc.getUri();
        break label765;
        localObject1 = Integer.valueOf(c.b.a(paramc.otB));
        break label851;
      }
    }
  }
  
  public final void frZ()
  {
    AppMethodBeat.i(273885);
    this.Hdl = this.mHw.aPY();
    AppMethodBeat.o(273885);
  }
  
  public final void fsa()
  {
    AppMethodBeat.i(273890);
    this.Hdm = this.mHw.aPY();
    AppMethodBeat.o(273890);
  }
  
  public final void h(c paramc)
  {
    AppMethodBeat.i(273879);
    this.mHw.lYS = SystemClock.elapsedRealtime();
    this.hzA = cn.bDw();
    if (this.Hdn == 1)
    {
      localObject = a.HcR;
      if (paramc != null) {
        break label176;
      }
    }
    label176:
    for (Object localObject = null;; localObject = paramc.getUri())
    {
      if ((!a.aDf((String)localObject)) && (paramc != null))
      {
        localObject = c.b.b(paramc.otB);
        if (localObject != null)
        {
          Log.i(this.Hdk, s.X("##########request uri: ===> ", paramc.getUri()));
          if (BuildInfo.DEBUG) {
            Log.i(this.Hdk, "uri:" + paramc.getUri() + " request stack: " + Util.getStack() + ' ');
          }
          ix(this.Hdk, "uri:" + paramc.getUri() + " request buf: " + com.tencent.mm.ae.f.dg(localObject));
        }
      }
      AppMethodBeat.o(273879);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.b.a.d
 * JD-Core Version:    0.7.0.1
 */