package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeDialogActionReport;", "", "scope", "", "(Ljava/lang/String;)V", "hadTriggerUserUserAgreementAlert", "", "userUserAgreementVisible", "markHadTriggerUserUserAgreementAlert", "", "markUserUserAgreementVisible", "report", "userUserAgreementChecked", "action", "", "Action", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final a rEQ;
  boolean rER;
  boolean rES;
  private final String scope;
  
  static
  {
    AppMethodBeat.i(326874);
    rEQ = new a((byte)0);
    AppMethodBeat.o(326874);
  }
  
  public g(String paramString)
  {
    AppMethodBeat.i(326871);
    this.scope = paramString;
    AppMethodBeat.o(326871);
  }
  
  public final void n(boolean paramBoolean, int paramInt)
  {
    int k = 1;
    AppMethodBeat.i(326876);
    h localh = h.OAn;
    String str = this.scope;
    int i;
    int j;
    if (this.rER)
    {
      i = 1;
      if (!paramBoolean) {
        break label166;
      }
      j = 1;
      label35:
      if (!this.rES) {
        break label172;
      }
    }
    for (;;)
    {
      localh.b(24877, new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt) });
      Log.i("MicroMsg.AuthorizeReport", "scope=" + this.scope + ", userUserAgreementVisible=" + this.rER + ", userUserAgreementChecked=" + paramBoolean + ",  hadTriggerUserUserAgreementAlert=" + this.rES + ", action=" + paramInt);
      AppMethodBeat.o(326876);
      return;
      i = 0;
      break;
      label166:
      j = 0;
      break label35;
      label172:
      k = 0;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeDialogActionReport$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.g
 * JD-Core Version:    0.7.0.1
 */