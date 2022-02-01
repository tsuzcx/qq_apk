package com.tencent.mm.plugin.kidswatch.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport;", "", "()V", "LoginReportID", "", "RegReportID", "loginReport", "", "accountType", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$AccountType;", "loginUrl", "", "type", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$LoginType;", "result", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$LoginResult;", "childCount", "errCode", "regReport", "kidsUIN", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$RegResult;", "AccountType", "LoginResult", "LoginType", "RegResult", "Scene", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b JSY;
  
  static
  {
    AppMethodBeat.i(262277);
    JSY = new b();
    AppMethodBeat.o(262277);
  }
  
  public static void a(b.a parama, String paramString, c paramc, b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262258);
    s.u(parama, "accountType");
    s.u(paramString, "loginUrl");
    s.u(paramc, "type");
    s.u(paramb, "result");
    h.OAn.a(21127, true, true, false, new Object[] { Integer.valueOf(paramb.value), Integer.valueOf(paramc.value), paramString, Integer.valueOf(paramInt1), Integer.valueOf(parama.value), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(262258);
  }
  
  public static void a(String paramString, d paramd, int paramInt)
  {
    AppMethodBeat.i(262267);
    s.u(paramString, "kidsUIN");
    s.u(paramd, "result");
    h.OAn.a(21256, true, true, false, new Object[] { paramString, Integer.valueOf(paramd.value), Integer.valueOf(paramInt) });
    AppMethodBeat.o(262267);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$LoginResult;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "LOGIN_RESULT_SUCCESS", "LOGIN_RESULT_TURN_TO_REG", "LOGIN_RESULT_CANCEL", "LOGIN_RESULT_FAIL", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(262304);
      JTc = new b("LOGIN_RESULT_SUCCESS", 0, 1);
      JTd = new b("LOGIN_RESULT_TURN_TO_REG", 1, 2);
      JTe = new b("LOGIN_RESULT_CANCEL", 2, 3);
      JTf = new b("LOGIN_RESULT_FAIL", 3, 4);
      JTg = new b[] { JTc, JTd, JTe, JTf };
      AppMethodBeat.o(262304);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$LoginType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "LOGIN_TYPE_DEFAULT", "LOGIN_TYPE_BOTH", "LOGIN_TYPE_WATCH_ONLY", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum c
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(262318);
      JTh = new c("LOGIN_TYPE_DEFAULT", 0, 0);
      JTi = new c("LOGIN_TYPE_BOTH", 1, 1);
      JTj = new c("LOGIN_TYPE_WATCH_ONLY", 2, 2);
      JTk = new c[] { JTh, JTi, JTj };
      AppMethodBeat.o(262318);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$RegResult;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "REG_RESULT_SUCCESS", "REG_RESULT_FAIL", "REG_RESULT_CANCEL", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum d
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(262288);
      JTl = new d("REG_RESULT_SUCCESS", 0, 1);
      JTm = new d("REG_RESULT_FAIL", 1, 2);
      JTn = new d("REG_RESULT_CANCEL", 2, 3);
      JTo = new d[] { JTl, JTm, JTn };
      AppMethodBeat.o(262288);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.model.b
 * JD-Core Version:    0.7.0.1
 */