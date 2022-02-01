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
import com.tencent.mm.by.c;
import com.tencent.mm.model.cs;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.AvailabilityAlertSupplier;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

public final class ak
{
  static volatile boolean feW;
  
  private static void bP(final Context paramContext)
  {
    AppMethodBeat.i(265299);
    final WeChatBrands.Business.AvailabilityAlertSupplier local4 = new WeChatBrands.Business.AvailabilityAlertSupplier()
    {
      d feX;
      
      public final void showDialog(Context paramAnonymousContext)
      {
        AppMethodBeat.i(275124);
        if ((this.feX != null) && (this.feX.isShowing()))
        {
          Context localContext = this.feX.getContext();
          if ((localContext != null) && ((localContext == paramAnonymousContext) || (((localContext instanceof ContextWrapper)) && (((ContextWrapper)localContext).getBaseContext() == paramAnonymousContext))))
          {
            AppMethodBeat.o(275124);
            return;
          }
        }
        this.feX = new d.a(paramAnonymousContext).bBc(getTilte()).bBd(getBody()).bBj(getPositiveBtnText()).c(getOnPositiveClickListener()).bBk(getNegativeBtnText()).HG(true).HH(false).d(getOnNegativeClickListener()).f(new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(290449);
            ak.4.this.getOnDismissListener().onClick(paramAnonymous2DialogInterface, -2);
            ak.4.this.feX = null;
            AppMethodBeat.o(290449);
          }
        }).a(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(196043);
            ak.4.this.getOnDismissListener().onClick(paramAnonymous2DialogInterface, -2);
            ak.4.this.feX = null;
            AppMethodBeat.o(196043);
          }
        }).icu();
        this.feX.show();
        AppMethodBeat.o(275124);
      }
    };
    Object localObject2 = cs.bfL();
    String str1 = cs.bfM();
    String str2 = cs.bfN();
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
          AppMethodBeat.i(287917);
          if (this.feZ.getCallback() != null) {
            this.feZ.getCallback().accept(Integer.valueOf(1));
          }
          AppMethodBeat.o(287917);
        }
      }).setOnDismissListener(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(288020);
          if (this.feZ.getCallback() != null) {
            this.feZ.getCallback().accept(Integer.valueOf(-1));
          }
          AppMethodBeat.o(288020);
        }
      });
      if (!TextUtils.isEmpty(str2)) {
        local4.setNegativeBtnText(paramContext.getString(R.l.brands_alert_negative)).setOnNegativeClickListener(new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(255512);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("rawUrl", this.ffa);
            c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
            if (local4.getCallback() != null) {
              local4.getCallback().accept(Integer.valueOf(0));
            }
            AppMethodBeat.o(255512);
          }
        });
      }
      WeChatBrands.updateBizRestrictAlertSupplier(local4);
      AppMethodBeat.o(265299);
      return;
    }
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(265298);
    if (!feW) {
      try
      {
        if (!feW)
        {
          cs.bfO();
          com.tencent.mm.ui.e.a.c(new ak.1());
          com.tencent.mm.ui.e.a.d(new androidx.a.a.c.a() {});
          bP(paramContext);
          cs.F(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(278570);
              ak.bQ(this.val$context);
              AppMethodBeat.o(278570);
            }
          });
          feW = true;
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(265298);
      }
    }
    AppMethodBeat.o(265298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.ak
 * JD-Core Version:    0.7.0.1
 */