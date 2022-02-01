package com.tencent.mm.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cr;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.AvailabilityAlertSupplier;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

public final class ai
{
  static volatile boolean dmI;
  
  private static void bP(final Context paramContext)
  {
    AppMethodBeat.i(231409);
    final WeChatBrands.Business.AvailabilityAlertSupplier local4 = new WeChatBrands.Business.AvailabilityAlertSupplier()
    {
      d dmJ;
      
      public final void showDialog(Context paramAnonymousContext)
      {
        AppMethodBeat.i(231404);
        if ((this.dmJ != null) && (this.dmJ.isShowing()))
        {
          Context localContext = this.dmJ.getContext();
          if ((localContext != null) && ((localContext == paramAnonymousContext) || (((localContext instanceof ContextWrapper)) && (((ContextWrapper)localContext).getBaseContext() == paramAnonymousContext))))
          {
            AppMethodBeat.o(231404);
            return;
          }
        }
        this.dmJ = new d.a(paramAnonymousContext).bon(getTilte()).boo(getBody()).bou(getPositiveBtnText()).c(getOnPositiveClickListener()).bov(getNegativeBtnText()).Dk(true).Dl(false).d(getOnNegativeClickListener()).f(new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(231403);
            ai.4.this.getOnDismissListener().onClick(paramAnonymous2DialogInterface, -2);
            ai.4.this.dmJ = null;
            AppMethodBeat.o(231403);
          }
        }).a(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(231402);
            ai.4.this.getOnDismissListener().onClick(paramAnonymous2DialogInterface, -2);
            ai.4.this.dmJ = null;
            AppMethodBeat.o(231402);
          }
        }).hbn();
        this.dmJ.show();
        AppMethodBeat.o(231404);
      }
    };
    Object localObject2 = cr.aWF();
    String str1 = cr.aWG();
    String str2 = cr.aWH();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramContext.getString(2131756897);
    }
    localObject2 = local4.setTilte((String)localObject1);
    if (str1 == null) {}
    for (localObject1 = paramContext.getString(2131756894);; localObject1 = str1)
    {
      ((WeChatBrands.Business.AvailabilityAlertSupplier)localObject2).setBody((String)localObject1).setPositiveBtnText(paramContext.getString(2131756896)).setOnPositiveClickListener(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(231406);
          if (this.dmL.getCallback() != null) {
            this.dmL.getCallback().accept(Integer.valueOf(1));
          }
          AppMethodBeat.o(231406);
        }
      }).setOnDismissListener(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(231405);
          if (this.dmL.getCallback() != null) {
            this.dmL.getCallback().accept(Integer.valueOf(-1));
          }
          AppMethodBeat.o(231405);
        }
      });
      if (!TextUtils.isEmpty(str2)) {
        local4.setNegativeBtnText(paramContext.getString(2131756895)).setOnNegativeClickListener(new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(231407);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("rawUrl", this.dmM);
            com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
            if (local4.getCallback() != null) {
              local4.getCallback().accept(Integer.valueOf(0));
            }
            AppMethodBeat.o(231407);
          }
        });
      }
      WeChatBrands.updateBizRestrictAlertSupplier(local4);
      AppMethodBeat.o(231409);
      return;
    }
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(231408);
    if (!dmI) {
      try
      {
        if (!dmI)
        {
          cr.aWI();
          com.tencent.mm.ui.e.a.b(new android.arch.a.c.a() {});
          com.tencent.mm.ui.e.a.c(new android.arch.a.c.a() {});
          bP(paramContext);
          cr.F(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(231401);
              ai.bQ(this.val$context);
              AppMethodBeat.o(231401);
            }
          });
          dmI = true;
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(231408);
      }
    }
    AppMethodBeat.o(231408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.ai
 * JD-Core Version:    0.7.0.1
 */