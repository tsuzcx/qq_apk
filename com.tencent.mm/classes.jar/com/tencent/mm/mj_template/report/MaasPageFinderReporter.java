package com.tencent.mm.mj_template.report;

import android.content.Intent;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ff;
import com.tencent.mm.autogen.mmdata.rpt.gk;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/report/MaasPageFinderReporter;", "Landroidx/lifecycle/LifecycleObserver;", "sessionId", "", "currentCommentScene", "", "eid", "intent", "Landroid/content/Intent;", "(Ljava/lang/String;ILjava/lang/String;Landroid/content/Intent;)V", "clickTabContextId", "getClickTabContextId", "()Ljava/lang/String;", "clickTabContextId$delegate", "Lkotlin/Lazy;", "getCurrentCommentScene", "()I", "getEid", "enterTime", "", "finderContextId", "getFinderContextId", "finderContextId$delegate", "fromCommonScene", "getFromCommonScene", "fromCommonScene$delegate", "jumpId", "getJumpId", "jumpId$delegate", "pageUdfObj", "Lorg/json/JSONObject;", "getSessionId", "addKV", "", "key", "value", "onPause", "onResume", "report21874", "resume", "", "scene", "udfContent", "report21875", "templateId", "click", "reportClick", "reportExpose", "reportRecordClick", "Companion", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MaasPageFinderReporter
  implements p
{
  public static final int Ue;
  public static final MaasPageFinderReporter.a odE;
  private long enterTime;
  public final int odF;
  private final String odG;
  private final j odH;
  private final j odI;
  private final j odJ;
  private final j odK;
  private JSONObject odL;
  public final String sessionId;
  
  static
  {
    AppMethodBeat.i(239557);
    odE = new MaasPageFinderReporter.a((byte)0);
    Ue = 8;
    AppMethodBeat.o(239557);
  }
  
  public MaasPageFinderReporter(String paramString1, int paramInt, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(239535);
    this.sessionId = paramString1;
    this.odF = paramInt;
    this.odG = paramString2;
    this.odH = k.cm((a)new c(paramIntent));
    this.odI = k.cm((a)new e(paramIntent));
    this.odJ = k.cm((a)new b(paramIntent));
    this.odK = k.cm((a)new d(paramIntent));
    this.odL = new JSONObject();
    AppMethodBeat.o(239535);
  }
  
  private final void H(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(239553);
    Log.i("MaasPageFinderReporter", "report 21875 tid: " + paramString + " click: " + paramBoolean + " session: " + this.sessionId + " contextId: " + bys() + " jumpId: " + byt() + " clickTabContext: " + byu() + " currentCommentScene: " + this.odF);
    gk localgk = new gk();
    localgk.qU(this.sessionId);
    localgk.qV(bys());
    localgk.qW(String.valueOf(this.odF));
    localgk.rb(String.valueOf(byv()));
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localgk.iGK = i;
      localgk.qX(String.valueOf(cn.bDw()));
      localgk.qY(this.odG);
      paramString = new JSONObject().put("templateId", paramString).toString();
      s.s(paramString, "JSONObject().put(\"templa…\", templateId).toString()");
      localgk.qZ(n.bV(paramString, ",", ";"));
      localgk.ra(byu());
      localgk.rc(n.bV(byt(), ",", ";"));
      localgk.bMH();
      AppMethodBeat.o(239553);
      return;
    }
  }
  
  private final void gP(boolean paramBoolean)
  {
    long l2 = 0L;
    AppMethodBeat.i(239545);
    Log.i("MaasPageFinderReporter", "report 21874 session: " + this.sessionId + " contextId: " + bys() + " jumpId: " + byt() + " clickTabContext: " + byu() + " currentCommentScene: " + this.odF);
    if (this.odL.length() == 0) {
      a(this, "0");
    }
    ff localff = new ff();
    localff.pF(this.sessionId);
    localff.pG(bys());
    localff.pL(byu());
    localff.pJ(com.tencent.mm.model.z.bAW());
    localff.pH(String.valueOf(this.odF));
    localff.pM(String.valueOf(byv()));
    int i;
    if (paramBoolean)
    {
      i = 0;
      localff.iGK = i;
      localff.pI(String.valueOf(cn.bDw()));
      if (paramBoolean) {
        break label299;
      }
      l1 = cn.bDw() - this.enterTime;
      label210:
      localff.iGM = l1;
      String str = this.odL.toString();
      s.s(str, "pageUdfObj.toString()");
      localff.pK(n.bV(str, ",", ";"));
      localff.pN(n.bV(byt(), ",", ";"));
      localff.bMH();
      if (paramBoolean) {
        break label304;
      }
    }
    label299:
    label304:
    for (long l1 = l2;; l1 = cn.bDw())
    {
      this.enterTime = l1;
      AppMethodBeat.o(239545);
      return;
      i = 1;
      break;
      l1 = 0L;
      break label210;
    }
  }
  
  public final void HN(String paramString)
  {
    AppMethodBeat.i(239602);
    s.u(paramString, "templateId");
    H(paramString, true);
    AppMethodBeat.o(239602);
  }
  
  public final void HO(String paramString)
  {
    AppMethodBeat.i(239609);
    s.u(paramString, "templateId");
    H(paramString, false);
    AppMethodBeat.o(239609);
  }
  
  public final String bys()
  {
    AppMethodBeat.i(239563);
    String str = (String)this.odH.getValue();
    AppMethodBeat.o(239563);
    return str;
  }
  
  public final String byt()
  {
    AppMethodBeat.i(239570);
    String str = (String)this.odI.getValue();
    AppMethodBeat.o(239570);
    return str;
  }
  
  public final String byu()
  {
    AppMethodBeat.i(239577);
    String str = (String)this.odJ.getValue();
    AppMethodBeat.o(239577);
    return str;
  }
  
  public final int byv()
  {
    AppMethodBeat.i(239586);
    int i = ((Number)this.odK.getValue()).intValue();
    AppMethodBeat.o(239586);
    return i;
  }
  
  @androidx.lifecycle.z(Ho=j.a.ON_PAUSE)
  public final void onPause()
  {
    AppMethodBeat.i(239597);
    Log.i("MaasPageFinderReporter", "onPause");
    gP(false);
    AppMethodBeat.o(239597);
  }
  
  @androidx.lifecycle.z(Ho=j.a.ON_RESUME)
  public final void onResume()
  {
    AppMethodBeat.i(239593);
    Log.i("MaasPageFinderReporter", "onResume");
    gP(true);
    AppMethodBeat.o(239593);
  }
  
  public final void x(boolean paramBoolean, String paramString)
  {
    long l2 = 0L;
    AppMethodBeat.i(239617);
    s.u(paramString, "udfContent");
    Log.i("MaasPageFinderReporter", "report 21874 session: " + this.sessionId + " contextId: " + bys() + " jumpId: " + byt() + " clickTabContext: " + byu() + " currentCommentScene: " + this.odF);
    if (this.odL.length() == 0) {
      a(this, "0");
    }
    ff localff = new ff();
    localff.pF(this.sessionId);
    localff.pG(bys());
    localff.pL(byu());
    localff.pJ(com.tencent.mm.model.z.bAW());
    localff.pH("99");
    localff.pM(String.valueOf(byv()));
    int i;
    if (paramBoolean)
    {
      i = 0;
      localff.iGK = i;
      localff.pI(String.valueOf(cn.bDw()));
      if (paramBoolean) {
        break label279;
      }
      l1 = cn.bDw() - this.enterTime;
      label214:
      localff.iGM = l1;
      localff.pK(paramString);
      localff.pN(n.bV(byt(), ",", ";"));
      localff.bMH();
      if (paramBoolean) {
        break label285;
      }
    }
    label279:
    label285:
    for (long l1 = l2;; l1 = cn.bDw())
    {
      this.enterTime = l1;
      AppMethodBeat.o(239617);
      return;
      i = 1;
      break;
      l1 = 0L;
      break label214;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<String>
  {
    b(Intent paramIntent)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<String>
  {
    c(Intent paramIntent)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<Integer>
  {
    d(Intent paramIntent)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<String>
  {
    e(Intent paramIntent)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.report.MaasPageFinderReporter
 * JD-Core Version:    0.7.0.1
 */