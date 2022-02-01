package com.tencent.mm.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.br.c;
import com.tencent.mm.model.ct;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.AvailabilityAlertSupplier;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;

public final class ao
{
  static volatile boolean hjd;
  
  private static void cC(final Context paramContext)
  {
    AppMethodBeat.i(239220);
    final WeChatBrands.Business.AvailabilityAlertSupplier local4 = new WeChatBrands.Business.AvailabilityAlertSupplier()
    {
      e hje;
      
      public final void showDialog(Context paramAnonymousContext)
      {
        AppMethodBeat.i(239221);
        if ((this.hje != null) && (this.hje.isShowing()))
        {
          Context localContext = this.hje.getContext();
          if ((localContext != null) && ((localContext == paramAnonymousContext) || (((localContext instanceof ContextWrapper)) && (((ContextWrapper)localContext).getBaseContext() == paramAnonymousContext))))
          {
            AppMethodBeat.o(239221);
            return;
          }
        }
        this.hje = new e.a(paramAnonymousContext).bDv(getTilte()).bDw(getBody()).bDC(getPositiveBtnText()).c(getOnPositiveClickListener()).bDD(getNegativeBtnText()).NC(true).ND(false).d(getOnNegativeClickListener()).e(new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(239075);
            ao.4.this.getOnDismissListener().onClick(paramAnonymous2DialogInterface, -2);
            ao.4.this.hje = null;
            AppMethodBeat.o(239075);
          }
        }).c(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(239067);
            ao.4.this.getOnDismissListener().onClick(paramAnonymous2DialogInterface, -2);
            ao.4.this.hje = null;
            AppMethodBeat.o(239067);
          }
        }).jHH();
        this.hje.show();
        AppMethodBeat.o(239221);
      }
    };
    Object localObject2 = ct.bDC();
    String str1 = ct.bDD();
    String str2 = ct.bDE();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramContext.getString(R.l.brands_alert_title);
    }
    localObject2 = local4.setTilte((String)localObject1);
    if (str1 == null) {}
    for (localObject1 = paramContext.getString(R.l.brands_alert_body);; localObject1 = str1)
    {
      ((WeChatBrands.Business.AvailabilityAlertSupplier)localObject2).setBody((String)localObject1).setPositiveBtnText(paramContext.getString(R.l.brands_alert_positive)).setOnPositiveClickListener(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(239230);
          if (ao.this.getCallback() != null) {
            ao.this.getCallback().accept(Integer.valueOf(1));
          }
          AppMethodBeat.o(239230);
        }
      }).setOnDismissListener(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(239217);
          if (ao.this.getCallback() != null) {
            ao.this.getCallback().accept(Integer.valueOf(-1));
          }
          AppMethodBeat.o(239217);
        }
      });
      if (!TextUtils.isEmpty(str2)) {
        local4.setNegativeBtnText(paramContext.getString(R.l.brands_alert_negative)).setOnNegativeClickListener(new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(239224);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("rawUrl", ao.this);
            c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
            if (local4.getCallback() != null) {
              local4.getCallback().accept(Integer.valueOf(0));
            }
            AppMethodBeat.o(239224);
          }
        });
      }
      WeChatBrands.updateBizRestrictAlertSupplier(local4);
      AppMethodBeat.o(239220);
      return;
    }
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(239215);
    if (!hjd) {
      try
      {
        if (!hjd)
        {
          ct.bDF();
          com.tencent.mm.ui.d.a.c(new ao.1());
          com.tencent.mm.ui.d.a.d(new ao.2());
          cC(paramContext);
          ct.K(new ao.3(paramContext));
          hjd = true;
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(239215);
      }
    }
    AppMethodBeat.o(239215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.app.ao
 * JD-Core Version:    0.7.0.1
 */