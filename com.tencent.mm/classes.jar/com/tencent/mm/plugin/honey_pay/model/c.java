package com.tencent.mm.plugin.honey_pay.model;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tg;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.bbz;
import com.tencent.mm.protocal.protobuf.bvv;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public final class c
{
  private static String nHq;
  
  static
  {
    AppMethodBeat.i(41769);
    nHq = com.tencent.mm.compatible.util.e.eQz + "wallet";
    AppMethodBeat.o(41769);
  }
  
  public static String E(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(41761);
    if (paramInt >= 0)
    {
      paramString1 = paramString1.replace("$" + paramString2 + "$", com.tencent.mm.wallet_core.ui.e.eZ(com.tencent.mm.wallet_core.ui.e.nE(paramString2), paramInt));
      AppMethodBeat.o(41761);
      return paramString1;
    }
    paramString1 = paramString1.replace("$" + paramString2 + "$", com.tencent.mm.wallet_core.ui.e.nE(paramString2));
    AppMethodBeat.o(41761);
    return paramString1;
  }
  
  public static void QL(String paramString)
  {
    AppMethodBeat.i(41767);
    Object localObject = new vf();
    ((vf)localObject).cLJ.scene = 8;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    ab.i("MicroMsg.HoneyPayUtil", "trigger offline event");
    localObject = new tg();
    ((tg)localObject).cJH.cJI = false;
    ((tg)localObject).cJH.scene = 1;
    ((tg)localObject).cJH.cJJ = true;
    ((tg)localObject).cJH.cJK = 65281;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    if (!bo.isNullOrNil(paramString)) {
      com.tencent.mm.plugin.offline.c.a.Wr(paramString);
    }
    AppMethodBeat.o(41767);
  }
  
  public static void W(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(41764);
    o(paramString1, paramString2, paramString3, null);
    AppMethodBeat.o(41764);
  }
  
  public static void X(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(41766);
    ab.i("MicroMsg.HoneyPayUtil", "insert sys msg: %s, %s", new Object[] { paramString1, Boolean.valueOf(bo.isNullOrNil(paramString2)) });
    if ((!bo.isNullOrNil(paramString2)) && (!bo.isNullOrNil(paramString1)))
    {
      paramString2 = E(E(paramString2, paramString1, -1), paramString3, -1);
      paramString3 = new bi();
      paramString3.hL(0);
      paramString3.kj(paramString1);
      paramString3.setStatus(3);
      paramString3.setContent(paramString2);
      paramString3.fQ(bf.x(paramString1, System.currentTimeMillis() / 1000L));
      paramString3.setType(10000);
      paramString3.hV(paramString3.field_flag | 0x8);
      long l = ((j)g.E(j.class)).bPQ().Z(paramString3);
      ab.i("MicroMsg.HoneyPayUtil", "insert msgId: %s", new Object[] { Long.valueOf(l) });
      if (l <= 0L) {
        ab.w("MicroMsg.HoneyPayUtil", "insert sys msg fail!");
      }
    }
    AppMethodBeat.o(41766);
  }
  
  public static int Z(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(41763);
    if (paramBoolean)
    {
      int i = -1;
      if (paramInt == 1) {
        i = 2131231413;
      }
      for (;;)
      {
        AppMethodBeat.o(41763);
        return i;
        if (paramInt == 2) {
          i = 2131231414;
        } else if (paramInt == 3) {
          i = 2131231412;
        }
      }
    }
    paramInt = xr(paramInt);
    AppMethodBeat.o(41763);
    return paramInt;
  }
  
  public static void a(Context paramContext, bbz parambbz, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(41760);
    com.tencent.mm.ui.base.h.a(paramContext, parambbz.cyA, "", parambbz.opD, parambbz.opC, false, paramOnClickListener, null);
    AppMethodBeat.o(41760);
  }
  
  public static void a(MMActivity paramMMActivity, Bundle paramBundle, aub paramaub, boolean paramBoolean)
  {
    AppMethodBeat.i(41757);
    RealnameGuideHelper localRealnameGuideHelper = new RealnameGuideHelper();
    localRealnameGuideHelper.a(paramaub.wkQ, paramaub.opB, paramaub.opC, paramaub.opD, paramaub.opE, 0);
    paramBundle.putString("realname_verify_process_jump_plugin", "honey_pay");
    localRealnameGuideHelper.a(paramMMActivity, paramBundle, null, new c.1(paramBoolean), false);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      AppMethodBeat.o(41757);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    AppMethodBeat.o(41757);
  }
  
  public static void a(MMActivity paramMMActivity, bvv parambvv, String paramString, int paramInt, ckm paramckm)
  {
    AppMethodBeat.i(41758);
    if ((parambvv != null) && (parambvv.xJr != null) && (!parambvv.xJr.isEmpty()))
    {
      paramString = new c.2(paramMMActivity, parambvv, paramString, paramckm, paramInt);
      if (!bo.isNullOrNil(parambvv.title))
      {
        paramMMActivity.addTextOptionMenu(0, parambvv.title, 2131690709, paramString);
        AppMethodBeat.o(41758);
        return;
      }
      paramMMActivity.addIconOptionMenu(0, 2131230727, paramString);
    }
    AppMethodBeat.o(41758);
  }
  
  public static void b(MMActivity paramMMActivity, bvv parambvv, String paramString, int paramInt, ckm paramckm)
  {
    AppMethodBeat.i(41759);
    a(paramMMActivity, parambvv, paramString, paramInt, paramckm);
    AppMethodBeat.o(41759);
  }
  
  public static int bHU()
  {
    return 2131231415;
  }
  
  public static String eN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(41762);
    paramString1 = E(paramString1, paramString2, -1);
    AppMethodBeat.o(41762);
    return paramString1;
  }
  
  public static String kn(long paramLong)
  {
    AppMethodBeat.i(41756);
    String str = com.tencent.mm.wallet_core.ui.e.a(String.valueOf(paramLong), "100", 2, RoundingMode.HALF_UP).toString();
    AppMethodBeat.o(41756);
    return str;
  }
  
  public static String ko(long paramLong)
  {
    AppMethodBeat.i(41768);
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1000L * paramLong));
    AppMethodBeat.o(41768);
    return str;
  }
  
  public static void o(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(41765);
    ab.i("MicroMsg.HoneyPayUtil", "update msg: %s, %s", new Object[] { paramString1, Boolean.valueOf(bo.isNullOrNil(paramString2)) });
    if ((!bo.isNullOrNil(paramString2)) && (!bo.isNullOrNil(paramString1)))
    {
      paramString2 = E(paramString2, paramString3, 6);
      if (bo.isNullOrNil(paramString4)) {
        break label224;
      }
      paramString2 = E(paramString2, paramString4, 6);
    }
    label224:
    for (;;)
    {
      paramString3 = new a();
      paramString3.field_payMsgId = paramString1;
      com.tencent.mm.plugin.honey_pay.a.bHS().bHT().get(paramString3, new String[0]);
      if (paramString3.field_msgId > 0L)
      {
        ab.i("MicroMsg.HoneyPayUtil", "find msg: %s", new Object[] { Long.valueOf(paramString3.field_msgId) });
        paramString1 = ((j)g.E(j.class)).bPQ().kB(paramString3.field_msgId);
        if (paramString1.field_msgId > 0L)
        {
          paramString1.setContent(paramString2);
          ((j)g.E(j.class)).bPQ().a(paramString1.field_msgId, paramString1);
          AppMethodBeat.o(41765);
          return;
        }
        ab.w("MicroMsg.HoneyPayUtil", "can't find msg: %s, may be deleted", new Object[] { Long.valueOf(paramString3.field_msgId) });
      }
      AppMethodBeat.o(41765);
      return;
    }
  }
  
  public static int xr(int paramInt)
  {
    int i = -1;
    if (paramInt == 1) {
      i = 2131231410;
    }
    do
    {
      return i;
      if (paramInt == 2) {
        return 2131231417;
      }
    } while (paramInt != 3);
    return 2131231408;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.model.c
 * JD-Core Version:    0.7.0.1
 */