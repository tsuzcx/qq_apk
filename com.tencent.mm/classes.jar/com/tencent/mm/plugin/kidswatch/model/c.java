package com.tencent.mm.plugin.kidswatch.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport;", "", "()V", "LoginReportID", "", "RegReportID", "loginReport", "", "accountType", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$AccountType;", "loginUrl", "", "type", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$LoginType;", "result", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$LoginResult;", "childCount", "errCode", "regReport", "kidsUIN", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$RegResult;", "AccountType", "LoginResult", "LoginType", "RegResult", "Scene", "plugin-kidswatch_release"})
public final class c
{
  public static final c EbU;
  
  static
  {
    AppMethodBeat.i(251595);
    EbU = new c();
    AppMethodBeat.o(251595);
  }
  
  public static void a(a parama, String paramString, c paramc, b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251591);
    p.k(parama, "accountType");
    p.k(paramString, "loginUrl");
    p.k(paramc, "type");
    p.k(paramb, "result");
    h.IzE.a(21127, true, true, false, new Object[] { Integer.valueOf(paramb.value), Integer.valueOf(paramc.value), paramString, Integer.valueOf(paramInt1), Integer.valueOf(parama.value), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(251591);
  }
  
  public static void a(String paramString, d paramd, int paramInt)
  {
    AppMethodBeat.i(251592);
    p.k(paramString, "kidsUIN");
    p.k(paramd, "result");
    h.IzE.a(21256, true, true, false, new Object[] { paramString, Integer.valueOf(paramd.value), Integer.valueOf(paramInt) });
    AppMethodBeat.o(251592);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$AccountType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "ACCOUNT_TYPE_NORMAL", "ACCOUNT_TYPE_KIDS", "plugin-kidswatch_release"})
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(251837);
      a locala1 = new a("ACCOUNT_TYPE_NORMAL", 0, 0);
      EbV = locala1;
      a locala2 = new a("ACCOUNT_TYPE_KIDS", 1, 1);
      EbW = locala2;
      EbX = new a[] { locala1, locala2 };
      AppMethodBeat.o(251837);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$LoginResult;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "LOGIN_RESULT_SUCCESS", "LOGIN_RESULT_TURN_TO_REG", "LOGIN_RESULT_CANCEL", "LOGIN_RESULT_FAIL", "plugin-kidswatch_release"})
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(252251);
      b localb1 = new b("LOGIN_RESULT_SUCCESS", 0, 1);
      EbY = localb1;
      b localb2 = new b("LOGIN_RESULT_TURN_TO_REG", 1, 2);
      EbZ = localb2;
      b localb3 = new b("LOGIN_RESULT_CANCEL", 2, 3);
      Eca = localb3;
      b localb4 = new b("LOGIN_RESULT_FAIL", 3, 4);
      Ecb = localb4;
      Ecc = new b[] { localb1, localb2, localb3, localb4 };
      AppMethodBeat.o(252251);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$LoginType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "LOGIN_TYPE_DEFAULT", "LOGIN_TYPE_BOTH", "LOGIN_TYPE_WATCH_ONLY", "plugin-kidswatch_release"})
  public static enum c
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(252144);
      c localc1 = new c("LOGIN_TYPE_DEFAULT", 0, 0);
      Ecd = localc1;
      c localc2 = new c("LOGIN_TYPE_BOTH", 1, 1);
      Ece = localc2;
      c localc3 = new c("LOGIN_TYPE_WATCH_ONLY", 2, 2);
      Ecf = localc3;
      Ecg = new c[] { localc1, localc2, localc3 };
      AppMethodBeat.o(252144);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$RegResult;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "REG_RESULT_SUCCESS", "REG_RESULT_FAIL", "REG_RESULT_CANCEL", "plugin-kidswatch_release"})
  public static enum d
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(251913);
      d locald1 = new d("REG_RESULT_SUCCESS", 0, 1);
      Ech = locald1;
      d locald2 = new d("REG_RESULT_FAIL", 1, 2);
      Eci = locald2;
      d locald3 = new d("REG_RESULT_CANCEL", 2, 3);
      Ecj = locald3;
      Eck = new d[] { locald1, locald2, locald3 };
      AppMethodBeat.o(251913);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.model.c
 * JD-Core Version:    0.7.0.1
 */