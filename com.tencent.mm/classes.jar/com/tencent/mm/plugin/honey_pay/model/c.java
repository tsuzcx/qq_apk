package com.tencent.mm.plugin.honey_pay.model;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.h.a.rp;
import com.tencent.mm.h.a.tk;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.protocal.c.aoj;
import com.tencent.mm.protocal.c.avo;
import com.tencent.mm.protocal.c.bmi;
import com.tencent.mm.protocal.c.bya;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public final class c
{
  private static String ljU = com.tencent.mm.compatible.util.e.bkH + "wallet";
  
  public static void Fo(String paramString)
  {
    Object localObject = new tk();
    ((tk)localObject).ccZ.scene = 8;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    y.i("MicroMsg.HoneyPayUtil", "trigger offline event");
    localObject = new rp();
    ((rp)localObject).cbe.cbf = false;
    ((rp)localObject).cbe.scene = 1;
    ((rp)localObject).cbe.cbg = true;
    ((rp)localObject).cbe.cbh = 65281;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    if (!bk.bl(paramString)) {
      com.tencent.mm.plugin.offline.c.a.Kp(paramString);
    }
  }
  
  public static void P(String paramString1, String paramString2, String paramString3)
  {
    m(paramString1, paramString2, paramString3, null);
  }
  
  public static void Q(String paramString1, String paramString2, String paramString3)
  {
    y.i("MicroMsg.HoneyPayUtil", "insert sys msg: %s, %s", new Object[] { paramString1, Boolean.valueOf(bk.bl(paramString2)) });
    if ((!bk.bl(paramString2)) && (!bk.bl(paramString1)))
    {
      paramString2 = x(x(paramString2, paramString1, -1), paramString3, -1);
      paramString3 = new bi();
      paramString3.fA(0);
      paramString3.ec(paramString1);
      paramString3.setStatus(3);
      paramString3.setContent(paramString2);
      paramString3.bg(bd.o(paramString1, System.currentTimeMillis() / 1000L));
      paramString3.setType(10000);
      paramString3.fJ(paramString3.field_flag | 0x8);
      long l = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().T(paramString3);
      y.i("MicroMsg.HoneyPayUtil", "insert msgId: %s", new Object[] { Long.valueOf(l) });
      if (l <= 0L) {
        y.w("MicroMsg.HoneyPayUtil", "insert sys msg fail!");
      }
    }
  }
  
  public static int R(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i = -1;
      if (paramInt == 1) {
        i = a.h.honey_pay_grey_father_card_icon;
      }
      do
      {
        return i;
        if (paramInt == 2) {
          return a.h.honey_pay_grey_mother_card_icon;
        }
      } while (paramInt != 3);
      return a.h.honey_pay_grey_child_card_icon;
    }
    return sr(paramInt);
  }
  
  public static void a(Context paramContext, avo paramavo, DialogInterface.OnClickListener paramOnClickListener)
  {
    com.tencent.mm.ui.base.h.a(paramContext, paramavo.bQZ, "", paramavo.lRF, paramavo.lRE, false, paramOnClickListener, null);
  }
  
  public static void a(MMActivity paramMMActivity, Bundle paramBundle, aoj paramaoj, boolean paramBoolean)
  {
    RealnameGuideHelper localRealnameGuideHelper = new RealnameGuideHelper();
    localRealnameGuideHelper.a(paramaoj.ssk, paramaoj.lRD, paramaoj.lRE, paramaoj.lRF, paramaoj.lRG, 0);
    paramBundle.putString("realname_verify_process_jump_plugin", "honey_pay");
    localRealnameGuideHelper.a(paramMMActivity, paramBundle, null, new c.1(paramBoolean), false);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.f(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
  }
  
  public static void a(MMActivity paramMMActivity, bmi parambmi, int paramInt1, String paramString, int paramInt2, bya parambya)
  {
    if ((parambmi != null) && (parambmi.tFJ != null) && (!parambmi.tFJ.isEmpty()))
    {
      paramString = new c.2(paramMMActivity, parambmi, paramString, parambya, paramInt2);
      if (!bk.bl(parambmi.title)) {
        paramMMActivity.a(0, parambmi.title, a.c.white, paramString);
      }
    }
    else
    {
      return;
    }
    paramMMActivity.addIconOptionMenu(0, paramInt1, paramString);
  }
  
  public static void a(MMActivity paramMMActivity, bmi parambmi, String paramString, int paramInt, bya parambya)
  {
    a(paramMMActivity, parambmi, a.h.actionbar_dark_icon_more, paramString, paramInt, parambya);
  }
  
  public static int baT()
  {
    return a.h.honey_pay_input_logo;
  }
  
  public static String dx(String paramString1, String paramString2)
  {
    return x(paramString1, paramString2, -1);
  }
  
  public static String eR(long paramLong)
  {
    return com.tencent.mm.wallet_core.ui.e.b(String.valueOf(paramLong), "100", RoundingMode.HALF_UP).toString();
  }
  
  public static String eS(long paramLong)
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1000L * paramLong));
  }
  
  public static void m(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    y.i("MicroMsg.HoneyPayUtil", "update msg: %s, %s", new Object[] { paramString1, Boolean.valueOf(bk.bl(paramString2)) });
    if ((!bk.bl(paramString2)) && (!bk.bl(paramString1)))
    {
      paramString2 = x(paramString2, paramString3, 6);
      if (bk.bl(paramString4)) {
        break label206;
      }
      paramString2 = x(paramString2, paramString4, 6);
    }
    label206:
    for (;;)
    {
      paramString3 = new a();
      paramString3.field_payMsgId = paramString1;
      com.tencent.mm.plugin.honey_pay.a.baR().baS().b(paramString3, new String[0]);
      if (paramString3.field_msgId > 0L)
      {
        y.i("MicroMsg.HoneyPayUtil", "find msg: %s", new Object[] { Long.valueOf(paramString3.field_msgId) });
        paramString1 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(paramString3.field_msgId);
        if (paramString1.field_msgId > 0L)
        {
          paramString1.setContent(paramString2);
          ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(paramString1.field_msgId, paramString1);
        }
      }
      else
      {
        return;
      }
      y.w("MicroMsg.HoneyPayUtil", "can't find msg: %s, may be deleted", new Object[] { Long.valueOf(paramString3.field_msgId) });
      return;
    }
  }
  
  public static int sr(int paramInt)
  {
    int i = -1;
    if (paramInt == 1) {
      i = a.h.honey_pay_father_card_icon;
    }
    do
    {
      return i;
      if (paramInt == 2) {
        return a.h.honey_pay_mother_card_icon;
      }
    } while (paramInt != 3);
    return a.h.honey_pay_child_card_icon;
  }
  
  public static String x(String paramString1, String paramString2, int paramInt)
  {
    if (paramInt >= 0) {
      return paramString1.replace("$" + paramString2 + "$", com.tencent.mm.wallet_core.ui.e.dP(com.tencent.mm.wallet_core.ui.e.gV(paramString2), paramInt));
    }
    return paramString1.replace("$" + paramString2 + "$", com.tencent.mm.wallet_core.ui.e.gV(paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.model.c
 * JD-Core Version:    0.7.0.1
 */