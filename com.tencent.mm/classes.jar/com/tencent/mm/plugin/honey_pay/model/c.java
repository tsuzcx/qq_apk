package com.tencent.mm.plugin.honey_pay.model;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.protocal.protobuf.cyp;
import com.tencent.mm.protocal.protobuf.dmd;
import com.tencent.mm.protocal.protobuf.dol;
import com.tencent.mm.protocal.protobuf.esq;
import com.tencent.mm.protocal.protobuf.fnr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  public static int YP(int paramInt)
  {
    AppMethodBeat.i(182450);
    int i = -1;
    if (paramInt == 1) {
      i = a.h.honey_pay_father_card_icon;
    }
    for (;;)
    {
      AppMethodBeat.o(182450);
      return i;
      if (paramInt == 2) {
        i = a.h.honey_pay_mother_card_icon;
      } else if (paramInt == 3) {
        i = a.h.honey_pay_child_card_icon;
      } else if (paramInt == 4) {
        i = a.h.honey_pay_relatives_card_icon;
      }
    }
  }
  
  public static void a(Context paramContext, dmd paramdmd, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(64655);
    k.a(paramContext, paramdmd.wording, "", paramdmd.right_button_wording, paramdmd.rGU, false, paramOnClickListener, null);
    AppMethodBeat.o(64655);
  }
  
  public static void a(MMActivity paramMMActivity, Bundle paramBundle, cyp paramcyp, boolean paramBoolean)
  {
    AppMethodBeat.i(64652);
    RealnameGuideHelper localRealnameGuideHelper = new RealnameGuideHelper();
    localRealnameGuideHelper.a(paramcyp.YAF, paramcyp.KuO, paramcyp.rGU, paramcyp.right_button_wording, paramcyp.KuP, 0);
    paramBundle.putString("realname_verify_process_jump_plugin", "honey_pay");
    localRealnameGuideHelper.a(paramMMActivity, paramBundle, null, new c.1(paramBoolean), false);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      AppMethodBeat.o(64652);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    AppMethodBeat.o(64652);
  }
  
  public static void a(MMActivity paramMMActivity, final esq paramesq, final String paramString, final int paramInt, final fnr paramfnr)
  {
    AppMethodBeat.i(64654);
    int i = a.h.icons_outlined_more;
    if ((paramesq != null) && (paramesq.abwj != null) && (!paramesq.abwj.isEmpty()))
    {
      paramString = new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(64650);
          paramAnonymousMenuItem = new f(c.this, 1, false);
          paramAnonymousMenuItem.Vtg = new u.g()
          {
            public final void onCreateMMMenu(s paramAnonymous2s)
            {
              AppMethodBeat.i(64648);
              Iterator localIterator = c.2.this.JAL.abwj.iterator();
              int i = 0;
              dol localdol;
              if (localIterator.hasNext())
              {
                localdol = (dol)localIterator.next();
                if (Util.isNullOrNil(localdol.vFa)) {
                  break label110;
                }
                if (!Util.isNullOrNil(localdol.nRQ))
                {
                  paramAnonymous2s.a(i, com.tencent.mm.plugin.wallet_core.utils.n.dE(localdol.nRQ, true), localdol.vFa);
                  label83:
                  i += 1;
                }
              }
              label110:
              for (;;)
              {
                break;
                paramAnonymous2s.c(i, localdol.vFa);
                break label83;
                AppMethodBeat.o(64648);
                return;
              }
            }
          };
          paramAnonymousMenuItem.GAC = new u.i()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(64649);
              paramAnonymous2MenuItem = (dol)c.2.this.JAL.abwj.get(paramAnonymous2Int);
              if (!Util.isNullOrNil(paramAnonymous2MenuItem.url))
              {
                if ((paramAnonymous2MenuItem.url.equals("weixin://wcpay/honeypay/unbind")) && (!Util.isNullOrNil(c.2.this.JAM)) && (c.2.this.JAN != null))
                {
                  Log.i("MicroMsg.HoneyPayUtil", "go to unbind");
                  paramAnonymous2MenuItem = new Intent(c.this, HoneyPayCheckPwdUI.class);
                  paramAnonymous2MenuItem.putExtra("key_scene", 3);
                  paramAnonymous2MenuItem.putExtra("key_card_no", c.2.this.JAM);
                  try
                  {
                    paramAnonymous2MenuItem.putExtra("key_toke_mess", c.2.this.JAN.toByteArray());
                    c.this.startActivityForResult(paramAnonymous2MenuItem, c.2.this.JAO);
                    AppMethodBeat.o(64649);
                    return;
                  }
                  catch (IOException localIOException)
                  {
                    for (;;)
                    {
                      Log.printErrStackTrace("MicroMsg.HoneyPayUtil", localIOException, "", new Object[0]);
                    }
                  }
                }
                com.tencent.mm.wallet_core.ui.i.p(c.this, paramAnonymous2MenuItem.url, false);
              }
              AppMethodBeat.o(64649);
            }
          };
          paramAnonymousMenuItem.dDn();
          AppMethodBeat.o(64650);
          return false;
        }
      };
      if (!Util.isNullOrNil(paramesq.title))
      {
        paramMMActivity.addTextOptionMenu(0, paramesq.title, a.c.white, paramString);
        AppMethodBeat.o(64654);
        return;
      }
      paramMMActivity.addIconOptionMenu(0, i, paramString);
    }
    AppMethodBeat.o(64654);
  }
  
  public static void aA(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(267324);
    Log.i("MicroMsg.HoneyPayUtil", "insert sys msg: %s, %s", new Object[] { paramString1, Boolean.valueOf(Util.isNullOrNil(paramString2)) });
    if ((!Util.isNullOrNil(paramString2)) && (!Util.isNullOrNil(paramString1)))
    {
      paramString2 = ah(ah(paramString2, paramString1, -1), paramString3, -1);
      paramString3 = new cc();
      paramString3.pI(0);
      paramString3.BS(paramString1);
      paramString3.setStatus(6);
      paramString3.setContent(paramString2);
      paramString3.setCreateTime(br.D(paramString1, System.currentTimeMillis() / 1000L));
      paramString3.setType(10000);
      paramString3.setFlag(paramString3.field_flag | 0x8);
      long l = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().ba(paramString3);
      Log.i("MicroMsg.HoneyPayUtil", "insert msgId: %s", new Object[] { Long.valueOf(l) });
      if (l <= 0L) {
        Log.w("MicroMsg.HoneyPayUtil", "insert sys msg fail!");
      }
    }
    AppMethodBeat.o(267324);
  }
  
  public static String ah(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(64656);
    if (paramInt >= 0)
    {
      paramString1 = paramString1.replace("$" + paramString2 + "$", com.tencent.mm.wallet_core.ui.i.jo(com.tencent.mm.wallet_core.ui.i.getDisplayName(paramString2), paramInt));
      AppMethodBeat.o(64656);
      return paramString1;
    }
    paramString1 = paramString1.replace("$" + paramString2 + "$", com.tencent.mm.wallet_core.ui.i.getDisplayName(paramString2));
    AppMethodBeat.o(64656);
    return paramString1;
  }
  
  public static int fPw()
  {
    AppMethodBeat.i(182451);
    if (!aw.isDarkMode())
    {
      i = a.h.honey_pay_input_logo;
      AppMethodBeat.o(182451);
      return i;
    }
    int i = a.h.honey_pay_input_logo_dm;
    AppMethodBeat.o(182451);
    return i;
  }
  
  public static String rY(long paramLong)
  {
    AppMethodBeat.i(64651);
    String str = com.tencent.mm.wallet_core.ui.i.b(String.valueOf(paramLong), "100", 2, RoundingMode.HALF_UP).toString();
    AppMethodBeat.o(64651);
    return str;
  }
  
  public static String rZ(long paramLong)
  {
    AppMethodBeat.i(64659);
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1000L * paramLong));
    AppMethodBeat.o(64659);
    return str;
  }
  
  public static void z(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(64658);
    Log.i("MicroMsg.HoneyPayUtil", "update msg: %s, %s", new Object[] { paramString1, Boolean.valueOf(Util.isNullOrNil(paramString2)) });
    if ((!Util.isNullOrNil(paramString2)) && (!Util.isNullOrNil(paramString1)))
    {
      paramString2 = ah(paramString2, paramString3, 6);
      if (Util.isNullOrNil(paramString4)) {
        break label224;
      }
      paramString2 = ah(paramString2, paramString4, 6);
    }
    label224:
    for (;;)
    {
      paramString3 = new a();
      paramString3.field_payMsgId = paramString1;
      com.tencent.mm.plugin.honey_pay.a.fPu().fPv().get(paramString3, new String[0]);
      if (paramString3.field_msgId > 0L)
      {
        Log.i("MicroMsg.HoneyPayUtil", "find msg: %s", new Object[] { Long.valueOf(paramString3.field_msgId) });
        paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(paramString3.field_msgId);
        if (paramString1.field_msgId > 0L)
        {
          paramString1.setContent(paramString2);
          ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(paramString1.field_msgId, paramString1);
          AppMethodBeat.o(64658);
          return;
        }
        Log.w("MicroMsg.HoneyPayUtil", "can't find msg: %s, may be deleted", new Object[] { Long.valueOf(paramString3.field_msgId) });
      }
      AppMethodBeat.o(64658);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.model.c
 * JD-Core Version:    0.7.0.1
 */