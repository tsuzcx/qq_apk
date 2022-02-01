package com.tencent.mm.plugin.honey_pay.model;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.utils.k;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.protocal.protobuf.cim;
import com.tencent.mm.protocal.protobuf.cux;
import com.tencent.mm.protocal.protobuf.cxg;
import com.tencent.mm.protocal.protobuf.dzl;
import com.tencent.mm.protocal.protobuf.esi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.wallet_core.ui.g;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  public static String Od(long paramLong)
  {
    AppMethodBeat.i(64651);
    String str = g.b(String.valueOf(paramLong), "100", 2, RoundingMode.HALF_UP).toString();
    AppMethodBeat.o(64651);
    return str;
  }
  
  public static String Oe(long paramLong)
  {
    AppMethodBeat.i(64659);
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1000L * paramLong));
    AppMethodBeat.o(64659);
    return str;
  }
  
  public static int UU(int paramInt)
  {
    AppMethodBeat.i(182450);
    int i = -1;
    if (!ar.isDarkMode()) {
      if (paramInt == 1) {
        i = a.h.honey_pay_father_card_icon;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(182450);
      return i;
      if (paramInt == 2)
      {
        i = a.h.honey_pay_mother_card_icon;
      }
      else if (paramInt == 3)
      {
        i = a.h.honey_pay_child_card_icon;
        continue;
        if (paramInt == 1) {
          i = a.h.honey_pay_father_card_icon_dm;
        } else if (paramInt == 2) {
          i = a.h.honey_pay_mother_card_icon_dm;
        } else if (paramInt == 3) {
          i = a.h.honey_pay_child_card_icon_dm;
        }
      }
    }
  }
  
  public static void a(Context paramContext, cux paramcux, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(64655);
    com.tencent.mm.ui.base.h.a(paramContext, paramcux.wording, "", paramcux.oDK, paramcux.oDJ, false, paramOnClickListener, null);
    AppMethodBeat.o(64655);
  }
  
  public static void a(MMActivity paramMMActivity, Bundle paramBundle, cim paramcim, boolean paramBoolean)
  {
    AppMethodBeat.i(64652);
    RealnameGuideHelper localRealnameGuideHelper = new RealnameGuideHelper();
    localRealnameGuideHelper.a(paramcim.REc, paramcim.EBN, paramcim.oDJ, paramcim.oDK, paramcim.EBO, 0);
    paramBundle.putString("realname_verify_process_jump_plugin", "honey_pay");
    localRealnameGuideHelper.a(paramMMActivity, paramBundle, null, new c.1(paramBoolean), false);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      AppMethodBeat.o(64652);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    AppMethodBeat.o(64652);
  }
  
  public static void a(MMActivity paramMMActivity, final dzl paramdzl, int paramInt1, final String paramString, final int paramInt2, final esi paramesi)
  {
    AppMethodBeat.i(215165);
    if ((paramdzl != null) && (paramdzl.UeW != null) && (!paramdzl.UeW.isEmpty()))
    {
      paramString = new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(64650);
          paramAnonymousMenuItem = new e(this.val$activity, 1, false);
          paramAnonymousMenuItem.ODT = new q.f()
          {
            public final void onCreateMMMenu(o paramAnonymous2o)
            {
              AppMethodBeat.i(64648);
              Iterator localIterator = c.2.this.DJP.UeW.iterator();
              int i = 0;
              cxg localcxg;
              if (localIterator.hasNext())
              {
                localcxg = (cxg)localIterator.next();
                if (Util.isNullOrNil(localcxg.szv)) {
                  break label110;
                }
                if (!Util.isNullOrNil(localcxg.lmL))
                {
                  paramAnonymous2o.a(i, k.cW(localcxg.lmL, true), localcxg.szv);
                  label83:
                  i += 1;
                }
              }
              label110:
              for (;;)
              {
                break;
                paramAnonymous2o.d(i, localcxg.szv);
                break label83;
                AppMethodBeat.o(64648);
                return;
              }
            }
          };
          paramAnonymousMenuItem.ODU = new q.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(64649);
              paramAnonymous2MenuItem = (cxg)c.2.this.DJP.UeW.get(paramAnonymous2Int);
              if (!Util.isNullOrNil(paramAnonymous2MenuItem.url))
              {
                if ((paramAnonymous2MenuItem.url.equals("weixin://wcpay/honeypay/unbind")) && (!Util.isNullOrNil(c.2.this.DJQ)) && (c.2.this.DJR != null))
                {
                  Log.i("MicroMsg.HoneyPayUtil", "go to unbind");
                  paramAnonymous2MenuItem = new Intent(c.2.this.val$activity, HoneyPayCheckPwdUI.class);
                  paramAnonymous2MenuItem.putExtra("key_scene", 3);
                  paramAnonymous2MenuItem.putExtra("key_card_no", c.2.this.DJQ);
                  try
                  {
                    paramAnonymous2MenuItem.putExtra("key_toke_mess", c.2.this.DJR.toByteArray());
                    c.2.this.val$activity.startActivityForResult(paramAnonymous2MenuItem, c.2.this.DJS);
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
                g.p(c.2.this.val$activity, paramAnonymous2MenuItem.url, false);
              }
              AppMethodBeat.o(64649);
            }
          };
          paramAnonymousMenuItem.eik();
          AppMethodBeat.o(64650);
          return false;
        }
      };
      if (!Util.isNullOrNil(paramdzl.title))
      {
        paramMMActivity.addTextOptionMenu(0, paramdzl.title, a.c.white, paramString);
        AppMethodBeat.o(215165);
        return;
      }
      paramMMActivity.addIconOptionMenu(0, paramInt1, paramString);
    }
    AppMethodBeat.o(215165);
  }
  
  public static void a(MMActivity paramMMActivity, dzl paramdzl, String paramString, int paramInt, esi paramesi)
  {
    AppMethodBeat.i(64654);
    a(paramMMActivity, paramdzl, a.h.actionbar_dark_icon_more, paramString, paramInt, paramesi);
    AppMethodBeat.o(64654);
  }
  
  public static int aH(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(64657);
    if (paramBoolean)
    {
      int i = -1;
      if (!ar.isDarkMode()) {
        if (paramInt == 1) {
          i = a.h.honey_pay_disable_father_card_icon;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(64657);
        return i;
        if (paramInt == 2)
        {
          i = a.h.honey_pay_disable_mother_card_icon;
        }
        else if (paramInt == 3)
        {
          i = a.h.honey_pay_disable_child_card_icon;
          continue;
          if (paramInt == 1) {
            i = a.h.honey_pay_disable_father_card_icon_dm;
          } else if (paramInt == 2) {
            i = a.h.honey_pay_disable_mother_card_icon_dm;
          } else if (paramInt == 3) {
            i = a.h.honey_pay_disable_child_card_icon_dm;
          }
        }
      }
    }
    paramInt = UU(paramInt);
    AppMethodBeat.o(64657);
    return paramInt;
  }
  
  public static String aa(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(64656);
    if (paramInt >= 0)
    {
      paramString1 = paramString1.replace("$" + paramString2 + "$", g.ic(g.PJ(paramString2), paramInt));
      AppMethodBeat.o(64656);
      return paramString1;
    }
    paramString1 = paramString1.replace("$" + paramString2 + "$", g.PJ(paramString2));
    AppMethodBeat.o(64656);
    return paramString1;
  }
  
  public static int eHL()
  {
    AppMethodBeat.i(182451);
    if (!ar.isDarkMode())
    {
      i = a.h.honey_pay_input_logo;
      AppMethodBeat.o(182451);
      return i;
    }
    int i = a.h.honey_pay_input_logo_dm;
    AppMethodBeat.o(182451);
    return i;
  }
  
  public static void x(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(64658);
    Log.i("MicroMsg.HoneyPayUtil", "update msg: %s, %s", new Object[] { paramString1, Boolean.valueOf(Util.isNullOrNil(paramString2)) });
    if ((!Util.isNullOrNil(paramString2)) && (!Util.isNullOrNil(paramString1)))
    {
      paramString2 = aa(paramString2, paramString3, 6);
      if (Util.isNullOrNil(paramString4)) {
        break label229;
      }
      paramString2 = aa(paramString2, paramString4, 6);
    }
    label229:
    for (;;)
    {
      paramString3 = new a();
      paramString3.field_payMsgId = paramString1;
      com.tencent.mm.plugin.honey_pay.a.eHJ().eHK().get(paramString3, new String[0]);
      if (paramString3.field_msgId > 0L)
      {
        Log.i("MicroMsg.HoneyPayUtil", "find msg: %s", new Object[] { Long.valueOf(paramString3.field_msgId) });
        paramString1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramString3.field_msgId);
        if (paramString1.field_msgId > 0L)
        {
          paramString1.setContent(paramString2);
          ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(paramString1.field_msgId, paramString1);
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