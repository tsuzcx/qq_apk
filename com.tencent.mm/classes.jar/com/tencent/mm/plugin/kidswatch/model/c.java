package com.tencent.mm.plugin.kidswatch.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport;", "", "()V", "LoginReportID", "", "RegReportID", "loginReport", "", "accountType", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$AccountType;", "loginUrl", "", "type", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$LoginType;", "result", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$LoginResult;", "childCount", "errCode", "regReport", "kidsUIN", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$RegResult;", "AccountType", "LoginResult", "LoginType", "RegResult", "Scene", "plugin-kidswatch_release"})
public final class c
{
  public static final c yAF;
  
  static
  {
    AppMethodBeat.i(256196);
    yAF = new c();
    AppMethodBeat.o(256196);
  }
  
  public static void a(c.a parama, String paramString, c paramc, b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(256194);
    p.h(parama, "accountType");
    p.h(paramString, "loginUrl");
    p.h(paramc, "type");
    p.h(paramb, "result");
    h.CyF.a(21127, true, true, false, new Object[] { Integer.valueOf(paramb.value), Integer.valueOf(paramc.value), paramString, Integer.valueOf(paramInt1), Integer.valueOf(parama.value), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(256194);
  }
  
  public static void a(String paramString, d paramd, int paramInt)
  {
    AppMethodBeat.i(256195);
    p.h(paramString, "kidsUIN");
    p.h(paramd, "result");
    h.CyF.a(21256, true, true, false, new Object[] { paramString, Integer.valueOf(paramd.value), Integer.valueOf(paramInt) });
    AppMethodBeat.o(256195);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$LoginResult;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "LOGIN_RESULT_SUCCESS", "LOGIN_RESULT_TURN_TO_REG", "LOGIN_RESULT_CANCEL", "LOGIN_RESULT_FAIL", "plugin-kidswatch_release"})
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(256185);
      b localb1 = new b("LOGIN_RESULT_SUCCESS", 0, 1);
      yAJ = localb1;
      b localb2 = new b("LOGIN_RESULT_TURN_TO_REG", 1, 2);
      yAK = localb2;
      b localb3 = new b("LOGIN_RESULT_CANCEL", 2, 3);
      yAL = localb3;
      b localb4 = new b("LOGIN_RESULT_FAIL", 3, 4);
      yAM = localb4;
      yAN = new b[] { localb1, localb2, localb3, localb4 };
      AppMethodBeat.o(256185);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$LoginType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "LOGIN_TYPE_DEFAULT", "LOGIN_TYPE_BOTH", "LOGIN_TYPE_WATCH_ONLY", "plugin-kidswatch_release"})
  public static enum c
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(256188);
      c localc1 = new c("LOGIN_TYPE_DEFAULT", 0, 0);
      yAO = localc1;
      c localc2 = new c("LOGIN_TYPE_BOTH", 1, 1);
      yAP = localc2;
      c localc3 = new c("LOGIN_TYPE_WATCH_ONLY", 2, 2);
      yAQ = localc3;
      yAR = new c[] { localc1, localc2, localc3 };
      AppMethodBeat.o(256188);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$RegResult;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "REG_RESULT_SUCCESS", "REG_RESULT_FAIL", "REG_RESULT_CANCEL", "plugin-kidswatch_release"})
  public static enum d
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(256191);
      d locald1 = new d("REG_RESULT_SUCCESS", 0, 1);
      yAS = locald1;
      d locald2 = new d("REG_RESULT_FAIL", 1, 2);
      yAT = locald2;
      d locald3 = new d("REG_RESULT_CANCEL", 2, 3);
      yAU = locald3;
      yAV = new d[] { locald1, locald2, locald3 };
      AppMethodBeat.o(256191);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.model.c
 * JD-Core Version:    0.7.0.1
 */