package com.tencent.mm.plugin.honey_pay.model;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.protocal.protobuf.cal;
import com.tencent.mm.protocal.protobuf.cma;
import com.tencent.mm.protocal.protobuf.cos;
import com.tencent.mm.protocal.protobuf.dpp;
import com.tencent.mm.protocal.protobuf.eig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.wallet_core.ui.f;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  public static String GO(long paramLong)
  {
    AppMethodBeat.i(64651);
    String str = f.b(String.valueOf(paramLong), "100", 2, RoundingMode.HALF_UP).toString();
    AppMethodBeat.o(64651);
    return str;
  }
  
  public static String GP(long paramLong)
  {
    AppMethodBeat.i(64659);
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1000L * paramLong));
    AppMethodBeat.o(64659);
    return str;
  }
  
  public static int OM(int paramInt)
  {
    AppMethodBeat.i(182450);
    int i = -1;
    if (!ao.isDarkMode()) {
      if (paramInt == 1) {
        i = 2131690405;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(182450);
      return i;
      if (paramInt == 2)
      {
        i = 2131690412;
      }
      else if (paramInt == 3)
      {
        i = 2131690396;
        continue;
        if (paramInt == 1) {
          i = 2131690406;
        } else if (paramInt == 2) {
          i = 2131690413;
        } else if (paramInt == 3) {
          i = 2131690397;
        }
      }
    }
  }
  
  public static String W(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(64656);
    if (paramInt >= 0)
    {
      paramString1 = paramString1.replace("$" + paramString2 + "$", f.hs(f.getDisplayName(paramString2), paramInt));
      AppMethodBeat.o(64656);
      return paramString1;
    }
    paramString1 = paramString1.replace("$" + paramString2 + "$", f.getDisplayName(paramString2));
    AppMethodBeat.o(64656);
    return paramString1;
  }
  
  public static void a(Context paramContext, cma paramcma, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(64655);
    com.tencent.mm.ui.base.h.a(paramContext, paramcma.dQx, "", paramcma.lHB, paramcma.lHA, false, paramOnClickListener, null);
    AppMethodBeat.o(64655);
  }
  
  public static void a(MMActivity paramMMActivity, Bundle paramBundle, cal paramcal, boolean paramBoolean)
  {
    AppMethodBeat.i(64652);
    RealnameGuideHelper localRealnameGuideHelper = new RealnameGuideHelper();
    localRealnameGuideHelper.b(paramcal.KCl, paramcal.yXJ, paramcal.lHA, paramcal.lHB, paramcal.yXK, 0);
    paramBundle.putString("realname_verify_process_jump_plugin", "honey_pay");
    localRealnameGuideHelper.a(paramMMActivity, paramBundle, null, new c.1(paramBoolean), false);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      AppMethodBeat.o(64652);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    AppMethodBeat.o(64652);
  }
  
  public static void a(MMActivity paramMMActivity, final dpp paramdpp, final String paramString, final int paramInt, final eig parameig)
  {
    AppMethodBeat.i(64653);
    if ((paramdpp != null) && (paramdpp.MSO != null) && (!paramdpp.MSO.isEmpty()))
    {
      paramString = new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(64650);
          paramAnonymousMenuItem = new e(this.val$activity, 1, false);
          paramAnonymousMenuItem.HLX = new o.f()
          {
            public final void onCreateMMMenu(m paramAnonymous2m)
            {
              AppMethodBeat.i(64648);
              Iterator localIterator = c.2.this.yjN.MSO.iterator();
              int i = 0;
              cos localcos;
              if (localIterator.hasNext())
              {
                localcos = (cos)localIterator.next();
                if (Util.isNullOrNil(localcos.pqv)) {
                  break label110;
                }
                if (!Util.isNullOrNil(localcos.ixw))
                {
                  paramAnonymous2m.a(i, com.tencent.mm.plugin.wallet_core.utils.g.cI(localcos.ixw, true), localcos.pqv);
                  label83:
                  i += 1;
                }
              }
              label110:
              for (;;)
              {
                break;
                paramAnonymous2m.d(i, localcos.pqv);
                break label83;
                AppMethodBeat.o(64648);
                return;
              }
            }
          };
          paramAnonymousMenuItem.HLY = new o.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(64649);
              paramAnonymous2MenuItem = (cos)c.2.this.yjN.MSO.get(paramAnonymous2Int);
              if (!Util.isNullOrNil(paramAnonymous2MenuItem.url))
              {
                if ((paramAnonymous2MenuItem.url.equals("weixin://wcpay/honeypay/unbind")) && (!Util.isNullOrNil(c.2.this.yjO)) && (c.2.this.yjP != null))
                {
                  Log.i("MicroMsg.HoneyPayUtil", "go to unbind");
                  paramAnonymous2MenuItem = new Intent(c.2.this.val$activity, HoneyPayCheckPwdUI.class);
                  paramAnonymous2MenuItem.putExtra("key_scene", 3);
                  paramAnonymous2MenuItem.putExtra("key_card_no", c.2.this.yjO);
                  try
                  {
                    paramAnonymous2MenuItem.putExtra("key_toke_mess", c.2.this.yjP.toByteArray());
                    c.2.this.val$activity.startActivityForResult(paramAnonymous2MenuItem, c.2.this.yjQ);
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
                f.p(c.2.this.val$activity, paramAnonymous2MenuItem.url, false);
              }
              AppMethodBeat.o(64649);
            }
          };
          paramAnonymousMenuItem.dGm();
          AppMethodBeat.o(64650);
          return false;
        }
      };
      if (!Util.isNullOrNil(paramdpp.title))
      {
        paramMMActivity.addTextOptionMenu(0, paramdpp.title, 2131101424, paramString);
        AppMethodBeat.o(64653);
        return;
      }
      paramMMActivity.addIconOptionMenu(0, 2131689482, paramString);
    }
    AppMethodBeat.o(64653);
  }
  
  public static int aB(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(64657);
    if (paramBoolean)
    {
      int i = -1;
      if (!ao.isDarkMode()) {
        if (paramInt == 1) {
          i = 2131690401;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(64657);
        return i;
        if (paramInt == 2)
        {
          i = 2131690403;
        }
        else if (paramInt == 3)
        {
          i = 2131690399;
          continue;
          if (paramInt == 1) {
            i = 2131690402;
          } else if (paramInt == 2) {
            i = 2131690404;
          } else if (paramInt == 3) {
            i = 2131690400;
          }
        }
      }
    }
    paramInt = OM(paramInt);
    AppMethodBeat.o(64657);
    return paramInt;
  }
  
  public static void b(MMActivity paramMMActivity, dpp paramdpp, String paramString, int paramInt, eig parameig)
  {
    AppMethodBeat.i(64654);
    a(paramMMActivity, paramdpp, paramString, paramInt, parameig);
    AppMethodBeat.o(64654);
  }
  
  public static int dYO()
  {
    AppMethodBeat.i(182451);
    if (!ao.isDarkMode())
    {
      AppMethodBeat.o(182451);
      return 2131690408;
    }
    AppMethodBeat.o(182451);
    return 2131690409;
  }
  
  public static void s(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(64658);
    Log.i("MicroMsg.HoneyPayUtil", "update msg: %s, %s", new Object[] { paramString1, Boolean.valueOf(Util.isNullOrNil(paramString2)) });
    if ((!Util.isNullOrNil(paramString2)) && (!Util.isNullOrNil(paramString1)))
    {
      paramString2 = W(paramString2, paramString3, 6);
      if (Util.isNullOrNil(paramString4)) {
        break label222;
      }
      paramString2 = W(paramString2, paramString4, 6);
    }
    label222:
    for (;;)
    {
      paramString3 = new a();
      paramString3.field_payMsgId = paramString1;
      com.tencent.mm.plugin.honey_pay.a.dYM().dYN().get(paramString3, new String[0]);
      if (paramString3.field_msgId > 0L)
      {
        Log.i("MicroMsg.HoneyPayUtil", "find msg: %s", new Object[] { Long.valueOf(paramString3.field_msgId) });
        paramString1 = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(paramString3.field_msgId);
        if (paramString1.field_msgId > 0L)
        {
          paramString1.setContent(paramString2);
          ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(paramString1.field_msgId, paramString1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.model.c
 * JD-Core Version:    0.7.0.1
 */