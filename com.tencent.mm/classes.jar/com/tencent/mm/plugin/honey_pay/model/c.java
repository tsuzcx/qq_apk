package com.tencent.mm.plugin.honey_pay.model;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.protocal.protobuf.bfc;
import com.tencent.mm.protocal.protobuf.bok;
import com.tencent.mm.protocal.protobuf.bpr;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.protocal.protobuf.dcl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  public static int ET(int paramInt)
  {
    AppMethodBeat.i(182450);
    int i = -1;
    if (!ai.Eq()) {
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
  
  public static String Q(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(64656);
    if (paramInt >= 0)
    {
      paramString1 = paramString1.replace("$" + paramString2 + "$", com.tencent.mm.wallet_core.ui.e.gn(com.tencent.mm.wallet_core.ui.e.sh(paramString2), paramInt));
      AppMethodBeat.o(64656);
      return paramString1;
    }
    paramString1 = paramString1.replace("$" + paramString2 + "$", com.tencent.mm.wallet_core.ui.e.sh(paramString2));
    AppMethodBeat.o(64656);
    return paramString1;
  }
  
  public static void a(Context paramContext, bok parambok, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(64655);
    com.tencent.mm.ui.base.h.a(paramContext, parambok.doh, "", parambok.tfI, parambok.tfH, false, paramOnClickListener, null);
    AppMethodBeat.o(64655);
  }
  
  public static void a(MMActivity paramMMActivity, Bundle paramBundle, bfc parambfc, boolean paramBoolean)
  {
    AppMethodBeat.i(64652);
    RealnameGuideHelper localRealnameGuideHelper = new RealnameGuideHelper();
    localRealnameGuideHelper.b(parambfc.Cta, parambfc.tfG, parambfc.tfH, parambfc.tfI, parambfc.tfJ, 0);
    paramBundle.putString("realname_verify_process_jump_plugin", "honey_pay");
    localRealnameGuideHelper.a(paramMMActivity, paramBundle, null, new c.1(paramBoolean), false);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      AppMethodBeat.o(64652);
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    AppMethodBeat.o(64652);
  }
  
  public static void a(MMActivity paramMMActivity, final clp paramclp, final String paramString, final int paramInt, final dcl paramdcl)
  {
    AppMethodBeat.i(64653);
    if ((paramclp != null) && (paramclp.EgR != null) && (!paramclp.EgR.isEmpty()))
    {
      paramString = new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(64650);
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(this.val$activity, 1, false);
          paramAnonymousMenuItem.HrX = new n.c()
          {
            public final void onCreateMMMenu(l paramAnonymous2l)
            {
              AppMethodBeat.i(64648);
              Iterator localIterator = c.2.this.suY.EgR.iterator();
              int i = 0;
              bpr localbpr;
              if (localIterator.hasNext())
              {
                localbpr = (bpr)localIterator.next();
                if (bt.isNullOrNil(localbpr.mVR)) {
                  break label110;
                }
                if (!bt.isNullOrNil(localbpr.gHT))
                {
                  paramAnonymous2l.a(i, com.tencent.mm.plugin.wallet_core.utils.g.bW(localbpr.gHT, true), localbpr.mVR);
                  label83:
                  i += 1;
                }
              }
              label110:
              for (;;)
              {
                break;
                paramAnonymous2l.c(i, localbpr.mVR);
                break label83;
                AppMethodBeat.o(64648);
                return;
              }
            }
          };
          paramAnonymousMenuItem.HrY = new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(64649);
              paramAnonymous2MenuItem = (bpr)c.2.this.suY.EgR.get(paramAnonymous2Int);
              if (!bt.isNullOrNil(paramAnonymous2MenuItem.url))
              {
                if ((paramAnonymous2MenuItem.url.equals("weixin://wcpay/honeypay/unbind")) && (!bt.isNullOrNil(c.2.this.suZ)) && (c.2.this.sva != null))
                {
                  ad.i("MicroMsg.HoneyPayUtil", "go to unbind");
                  paramAnonymous2MenuItem = new Intent(c.2.this.val$activity, HoneyPayCheckPwdUI.class);
                  paramAnonymous2MenuItem.putExtra("key_scene", 3);
                  paramAnonymous2MenuItem.putExtra("key_card_no", c.2.this.suZ);
                  try
                  {
                    paramAnonymous2MenuItem.putExtra("key_toke_mess", c.2.this.sva.toByteArray());
                    c.2.this.val$activity.startActivityForResult(paramAnonymous2MenuItem, c.2.this.svb);
                    AppMethodBeat.o(64649);
                    return;
                  }
                  catch (IOException localIOException)
                  {
                    for (;;)
                    {
                      ad.printErrStackTrace("MicroMsg.HoneyPayUtil", localIOException, "", new Object[0]);
                    }
                  }
                }
                com.tencent.mm.wallet_core.ui.e.p(c.2.this.val$activity, paramAnonymous2MenuItem.url, false);
              }
              AppMethodBeat.o(64649);
            }
          };
          paramAnonymousMenuItem.csG();
          AppMethodBeat.o(64650);
          return false;
        }
      };
      if (!bt.isNullOrNil(paramclp.title))
      {
        paramMMActivity.addTextOptionMenu(0, paramclp.title, 2131101179, paramString);
        AppMethodBeat.o(64653);
        return;
      }
      paramMMActivity.addIconOptionMenu(0, 2131689480, paramString);
    }
    AppMethodBeat.o(64653);
  }
  
  public static int ah(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(64657);
    if (paramBoolean)
    {
      int i = -1;
      if (!ai.Eq()) {
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
    paramInt = ET(paramInt);
    AppMethodBeat.o(64657);
    return paramInt;
  }
  
  public static void b(MMActivity paramMMActivity, clp paramclp, String paramString, int paramInt, dcl paramdcl)
  {
    AppMethodBeat.i(64654);
    a(paramMMActivity, paramclp, paramString, paramInt, paramdcl);
    AppMethodBeat.o(64654);
  }
  
  public static int cFL()
  {
    AppMethodBeat.i(182451);
    if (!ai.Eq())
    {
      AppMethodBeat.o(182451);
      return 2131690311;
    }
    AppMethodBeat.o(182451);
    return 2131690312;
  }
  
  public static void n(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(64658);
    ad.i("MicroMsg.HoneyPayUtil", "update msg: %s, %s", new Object[] { paramString1, Boolean.valueOf(bt.isNullOrNil(paramString2)) });
    if ((!bt.isNullOrNil(paramString2)) && (!bt.isNullOrNil(paramString1)))
    {
      paramString2 = Q(paramString2, paramString3, 6);
      if (bt.isNullOrNil(paramString4)) {
        break label222;
      }
      paramString2 = Q(paramString2, paramString4, 6);
    }
    label222:
    for (;;)
    {
      paramString3 = new a();
      paramString3.field_payMsgId = paramString1;
      com.tencent.mm.plugin.honey_pay.a.cFJ().cFK().get(paramString3, new String[0]);
      if (paramString3.field_msgId > 0L)
      {
        ad.i("MicroMsg.HoneyPayUtil", "find msg: %s", new Object[] { Long.valueOf(paramString3.field_msgId) });
        paramString1 = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rm(paramString3.field_msgId);
        if (paramString1.field_msgId > 0L)
        {
          paramString1.setContent(paramString2);
          ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().a(paramString1.field_msgId, paramString1);
          AppMethodBeat.o(64658);
          return;
        }
        ad.w("MicroMsg.HoneyPayUtil", "can't find msg: %s, may be deleted", new Object[] { Long.valueOf(paramString3.field_msgId) });
      }
      AppMethodBeat.o(64658);
      return;
    }
  }
  
  public static String qX(long paramLong)
  {
    AppMethodBeat.i(64651);
    String str = com.tencent.mm.wallet_core.ui.e.a(String.valueOf(paramLong), "100", 2, RoundingMode.HALF_UP).toString();
    AppMethodBeat.o(64651);
    return str;
  }
  
  public static String qY(long paramLong)
  {
    AppMethodBeat.i(64659);
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1000L * paramLong));
    AppMethodBeat.o(64659);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.model.c
 * JD-Core Version:    0.7.0.1
 */