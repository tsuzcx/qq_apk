package com.tencent.mm.plugin.honey_pay.model;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.protocal.protobuf.biu;
import com.tencent.mm.protocal.protobuf.bta;
import com.tencent.mm.protocal.protobuf.cqw;
import com.tencent.mm.protocal.protobuf.dhy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.wallet_core.ui.e;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public final class c
{
  public static int GP(int paramInt)
  {
    AppMethodBeat.i(182450);
    int i = -1;
    if (!aj.DT()) {
      if (paramInt == 1) {
        i = 2131690308;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(182450);
      return i;
      if (paramInt == 2)
      {
        i = 2131690315;
      }
      else if (paramInt == 3)
      {
        i = 2131690299;
        continue;
        if (paramInt == 1) {
          i = 2131690309;
        } else if (paramInt == 2) {
          i = 2131690316;
        } else if (paramInt == 3) {
          i = 2131690300;
        }
      }
    }
  }
  
  public static String R(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(64656);
    if (paramInt >= 0)
    {
      paramString1 = paramString1.replace("$" + paramString2 + "$", e.gr(e.wk(paramString2), paramInt));
      AppMethodBeat.o(64656);
      return paramString1;
    }
    paramString1 = paramString1.replace("$" + paramString2 + "$", e.wk(paramString2));
    AppMethodBeat.o(64656);
    return paramString1;
  }
  
  public static void a(Context paramContext, bta parambta, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(64655);
    com.tencent.mm.ui.base.h.a(paramContext, parambta.dlQ, "", parambta.unX, parambta.unW, false, paramOnClickListener, null);
    AppMethodBeat.o(64655);
  }
  
  public static void a(MMActivity paramMMActivity, Bundle paramBundle, biu parambiu, boolean paramBoolean)
  {
    AppMethodBeat.i(64652);
    RealnameGuideHelper localRealnameGuideHelper = new RealnameGuideHelper();
    localRealnameGuideHelper.b(parambiu.DLr, parambiu.unV, parambiu.unW, parambiu.unX, parambiu.unY, 0);
    paramBundle.putString("realname_verify_process_jump_plugin", "honey_pay");
    localRealnameGuideHelper.a(paramMMActivity, paramBundle, null, new c.1(paramBoolean), false);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      AppMethodBeat.o(64652);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    AppMethodBeat.o(64652);
  }
  
  public static void a(MMActivity paramMMActivity, cqw paramcqw, String paramString, int paramInt, dhy paramdhy)
  {
    AppMethodBeat.i(64653);
    if ((paramcqw != null) && (paramcqw.FDQ != null) && (!paramcqw.FDQ.isEmpty()))
    {
      paramString = new c.2(paramMMActivity, paramcqw, paramString, paramdhy, paramInt);
      if (!bs.isNullOrNil(paramcqw.title))
      {
        paramMMActivity.addTextOptionMenu(0, paramcqw.title, 2131101179, paramString);
        AppMethodBeat.o(64653);
        return;
      }
      paramMMActivity.addIconOptionMenu(0, 2131689480, paramString);
    }
    AppMethodBeat.o(64653);
  }
  
  public static int ak(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(64657);
    if (paramBoolean)
    {
      int i = -1;
      if (!aj.DT()) {
        if (paramInt == 1) {
          i = 2131690304;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(64657);
        return i;
        if (paramInt == 2)
        {
          i = 2131690306;
        }
        else if (paramInt == 3)
        {
          i = 2131690302;
          continue;
          if (paramInt == 1) {
            i = 2131690305;
          } else if (paramInt == 2) {
            i = 2131690307;
          } else if (paramInt == 3) {
            i = 2131690303;
          }
        }
      }
    }
    paramInt = GP(paramInt);
    AppMethodBeat.o(64657);
    return paramInt;
  }
  
  public static void b(MMActivity paramMMActivity, cqw paramcqw, String paramString, int paramInt, dhy paramdhy)
  {
    AppMethodBeat.i(64654);
    a(paramMMActivity, paramcqw, paramString, paramInt, paramdhy);
    AppMethodBeat.o(64654);
  }
  
  public static int cSV()
  {
    AppMethodBeat.i(182451);
    if (!aj.DT())
    {
      AppMethodBeat.o(182451);
      return 2131690311;
    }
    AppMethodBeat.o(182451);
    return 2131690312;
  }
  
  public static void p(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(64658);
    ac.i("MicroMsg.HoneyPayUtil", "update msg: %s, %s", new Object[] { paramString1, Boolean.valueOf(bs.isNullOrNil(paramString2)) });
    if ((!bs.isNullOrNil(paramString2)) && (!bs.isNullOrNil(paramString1)))
    {
      paramString2 = R(paramString2, paramString3, 6);
      if (bs.isNullOrNil(paramString4)) {
        break label221;
      }
      paramString2 = R(paramString2, paramString4, 6);
    }
    label221:
    for (;;)
    {
      paramString3 = new a();
      paramString3.field_payMsgId = paramString1;
      com.tencent.mm.plugin.honey_pay.a.cST().cSU().get(paramString3, new String[0]);
      if (paramString3.field_msgId > 0L)
      {
        ac.i("MicroMsg.HoneyPayUtil", "find msg: %s", new Object[] { Long.valueOf(paramString3.field_msgId) });
        paramString1 = ((k)g.ab(k.class)).dcr().vP(paramString3.field_msgId);
        if (paramString1.field_msgId > 0L)
        {
          paramString1.setContent(paramString2);
          ((k)g.ab(k.class)).dcr().a(paramString1.field_msgId, paramString1);
          AppMethodBeat.o(64658);
          return;
        }
        ac.w("MicroMsg.HoneyPayUtil", "can't find msg: %s, may be deleted", new Object[] { Long.valueOf(paramString3.field_msgId) });
      }
      AppMethodBeat.o(64658);
      return;
    }
  }
  
  public static String vA(long paramLong)
  {
    AppMethodBeat.i(64651);
    String str = e.a(String.valueOf(paramLong), "100", 2, RoundingMode.HALF_UP).toString();
    AppMethodBeat.o(64651);
    return str;
  }
  
  public static String vB(long paramLong)
  {
    AppMethodBeat.i(64659);
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1000L * paramLong));
    AppMethodBeat.o(64659);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.model.c
 * JD-Core Version:    0.7.0.1
 */