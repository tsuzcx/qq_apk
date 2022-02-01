package com.tencent.mm.plugin.honey_pay.model;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.protocal.protobuf.bnu;
import com.tencent.mm.protocal.protobuf.byi;
import com.tencent.mm.protocal.protobuf.bzr;
import com.tencent.mm.protocal.protobuf.cwv;
import com.tencent.mm.protocal.protobuf.dok;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
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
  public static int IJ(int paramInt)
  {
    AppMethodBeat.i(182450);
    int i = -1;
    if (!al.isDarkMode()) {
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
  
  public static String U(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(64656);
    if (paramInt >= 0)
    {
      paramString1 = paramString1.replace("$" + paramString2 + "$", f.gX(f.zP(paramString2), paramInt));
      AppMethodBeat.o(64656);
      return paramString1;
    }
    paramString1 = paramString1.replace("$" + paramString2 + "$", f.zP(paramString2));
    AppMethodBeat.o(64656);
    return paramString1;
  }
  
  public static void a(Context paramContext, byi parambyi, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(64655);
    h.a(paramContext, parambyi.dyI, "", parambyi.kDa, parambyi.kCZ, false, paramOnClickListener, null);
    AppMethodBeat.o(64655);
  }
  
  public static void a(MMActivity paramMMActivity, Bundle paramBundle, bnu parambnu, boolean paramBoolean)
  {
    AppMethodBeat.i(64652);
    RealnameGuideHelper localRealnameGuideHelper = new RealnameGuideHelper();
    localRealnameGuideHelper.b(parambnu.FIU, parambnu.vCG, parambnu.kCZ, parambnu.kDa, parambnu.vCH, 0);
    paramBundle.putString("realname_verify_process_jump_plugin", "honey_pay");
    localRealnameGuideHelper.a(paramMMActivity, paramBundle, null, new c.1(paramBoolean), false);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      AppMethodBeat.o(64652);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    AppMethodBeat.o(64652);
  }
  
  public static void a(MMActivity paramMMActivity, final cwv paramcwv, final String paramString, final int paramInt, final dok paramdok)
  {
    AppMethodBeat.i(64653);
    if ((paramcwv != null) && (paramcwv.HHD != null) && (!paramcwv.HHD.isEmpty()))
    {
      paramString = new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(64650);
          paramAnonymousMenuItem = new e(this.val$activity, 1, false);
          paramAnonymousMenuItem.LfS = new n.d()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(64648);
              Iterator localIterator = c.2.this.uRj.HHD.iterator();
              int i = 0;
              bzr localbzr;
              if (localIterator.hasNext())
              {
                localbzr = (bzr)localIterator.next();
                if (bu.isNullOrNil(localbzr.ofy)) {
                  break label110;
                }
                if (!bu.isNullOrNil(localbzr.hDr))
                {
                  paramAnonymous2l.a(i, com.tencent.mm.plugin.wallet_core.utils.g.cp(localbzr.hDr, true), localbzr.ofy);
                  label83:
                  i += 1;
                }
              }
              label110:
              for (;;)
              {
                break;
                paramAnonymous2l.d(i, localbzr.ofy);
                break label83;
                AppMethodBeat.o(64648);
                return;
              }
            }
          };
          paramAnonymousMenuItem.LfT = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(64649);
              paramAnonymous2MenuItem = (bzr)c.2.this.uRj.HHD.get(paramAnonymous2Int);
              if (!bu.isNullOrNil(paramAnonymous2MenuItem.url))
              {
                if ((paramAnonymous2MenuItem.url.equals("weixin://wcpay/honeypay/unbind")) && (!bu.isNullOrNil(c.2.this.uRk)) && (c.2.this.uRl != null))
                {
                  ae.i("MicroMsg.HoneyPayUtil", "go to unbind");
                  paramAnonymous2MenuItem = new Intent(c.2.this.val$activity, HoneyPayCheckPwdUI.class);
                  paramAnonymous2MenuItem.putExtra("key_scene", 3);
                  paramAnonymous2MenuItem.putExtra("key_card_no", c.2.this.uRk);
                  try
                  {
                    paramAnonymous2MenuItem.putExtra("key_toke_mess", c.2.this.uRl.toByteArray());
                    c.2.this.val$activity.startActivityForResult(paramAnonymous2MenuItem, c.2.this.uRm);
                    AppMethodBeat.o(64649);
                    return;
                  }
                  catch (IOException localIOException)
                  {
                    for (;;)
                    {
                      ae.printErrStackTrace("MicroMsg.HoneyPayUtil", localIOException, "", new Object[0]);
                    }
                  }
                }
                f.p(c.2.this.val$activity, paramAnonymous2MenuItem.url, false);
              }
              AppMethodBeat.o(64649);
            }
          };
          paramAnonymousMenuItem.cPF();
          AppMethodBeat.o(64650);
          return false;
        }
      };
      if (!bu.isNullOrNil(paramcwv.title))
      {
        paramMMActivity.addTextOptionMenu(0, paramcwv.title, 2131101179, paramString);
        AppMethodBeat.o(64653);
        return;
      }
      paramMMActivity.addIconOptionMenu(0, 2131689480, paramString);
    }
    AppMethodBeat.o(64653);
  }
  
  public static int ar(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(64657);
    if (paramBoolean)
    {
      int i = -1;
      if (!al.isDarkMode()) {
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
    paramInt = IJ(paramInt);
    AppMethodBeat.o(64657);
    return paramInt;
  }
  
  public static void b(MMActivity paramMMActivity, cwv paramcwv, String paramString, int paramInt, dok paramdok)
  {
    AppMethodBeat.i(64654);
    a(paramMMActivity, paramcwv, paramString, paramInt, paramdok);
    AppMethodBeat.o(64654);
  }
  
  public static int deU()
  {
    AppMethodBeat.i(182451);
    if (!al.isDarkMode())
    {
      AppMethodBeat.o(182451);
      return 2131690311;
    }
    AppMethodBeat.o(182451);
    return 2131690312;
  }
  
  public static void o(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(64658);
    ae.i("MicroMsg.HoneyPayUtil", "update msg: %s, %s", new Object[] { paramString1, Boolean.valueOf(bu.isNullOrNil(paramString2)) });
    if ((!bu.isNullOrNil(paramString2)) && (!bu.isNullOrNil(paramString1)))
    {
      paramString2 = U(paramString2, paramString3, 6);
      if (bu.isNullOrNil(paramString4)) {
        break label222;
      }
      paramString2 = U(paramString2, paramString4, 6);
    }
    label222:
    for (;;)
    {
      paramString3 = new a();
      paramString3.field_payMsgId = paramString1;
      com.tencent.mm.plugin.honey_pay.a.deS().deT().get(paramString3, new String[0]);
      if (paramString3.field_msgId > 0L)
      {
        ae.i("MicroMsg.HoneyPayUtil", "find msg: %s", new Object[] { Long.valueOf(paramString3.field_msgId) });
        paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(paramString3.field_msgId);
        if (paramString1.field_msgId > 0L)
        {
          paramString1.setContent(paramString2);
          ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(paramString1.field_msgId, paramString1);
          AppMethodBeat.o(64658);
          return;
        }
        ae.w("MicroMsg.HoneyPayUtil", "can't find msg: %s, may be deleted", new Object[] { Long.valueOf(paramString3.field_msgId) });
      }
      AppMethodBeat.o(64658);
      return;
    }
  }
  
  public static String ye(long paramLong)
  {
    AppMethodBeat.i(64651);
    String str = f.b(String.valueOf(paramLong), "100", 2, RoundingMode.HALF_UP).toString();
    AppMethodBeat.o(64651);
    return str;
  }
  
  public static String yf(long paramLong)
  {
    AppMethodBeat.i(64659);
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1000L * paramLong));
    AppMethodBeat.o(64659);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.model.c
 * JD-Core Version:    0.7.0.1
 */