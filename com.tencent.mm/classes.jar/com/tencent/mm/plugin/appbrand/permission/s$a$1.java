package com.tencent.mm.plugin.appbrand.permission;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.AvailabilityAlertSupplier;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class s$a$1
  implements Runnable
{
  s$a$1(s.a parama, WeChatBrands.Business.AvailabilityAlertSupplier paramAvailabilityAlertSupplier) {}
  
  public final void run()
  {
    AppMethodBeat.i(256976);
    Object localObject1 = this.qzX.oxb.getContext();
    Object localObject2;
    if ((localObject1 != null) && (this.qzX.oxb.getDialogContainer() != null))
    {
      localObject1 = new b((Context)localObject1);
      localObject2 = this.qzY;
      p.j(localObject2, "supplier");
      ((b)localObject1).setTitle((CharSequence)((WeChatBrands.Business.AvailabilityAlertSupplier)localObject2).getTilte());
      localObject2 = this.qzY;
      p.j(localObject2, "supplier");
      ((b)localObject1).setMessage((CharSequence)((WeChatBrands.Business.AvailabilityAlertSupplier)localObject2).getBody());
      localObject2 = this.qzY;
      p.j(localObject2, "supplier");
      localObject2 = (CharSequence)((WeChatBrands.Business.AvailabilityAlertSupplier)localObject2).getNegativeBtnText();
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label265;
      }
    }
    label265:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject2 = this.qzY;
        p.j(localObject2, "supplier");
        localObject2 = (CharSequence)((WeChatBrands.Business.AvailabilityAlertSupplier)localObject2).getNegativeBtnText();
        localAvailabilityAlertSupplier = this.qzY;
        p.j(localAvailabilityAlertSupplier, "supplier");
        ((b)localObject1).b((CharSequence)localObject2, true, localAvailabilityAlertSupplier.getOnNegativeClickListener());
      }
      localObject2 = this.qzY;
      p.j(localObject2, "supplier");
      localObject2 = (CharSequence)((WeChatBrands.Business.AvailabilityAlertSupplier)localObject2).getPositiveBtnText();
      WeChatBrands.Business.AvailabilityAlertSupplier localAvailabilityAlertSupplier = this.qzY;
      p.j(localAvailabilityAlertSupplier, "supplier");
      ((b)localObject1).a((CharSequence)localObject2, true, localAvailabilityAlertSupplier.getOnPositiveClickListener());
      ((b)localObject1).setOnDismissListener((DialogInterface.OnDismissListener)new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(267288);
          WeChatBrands.Business.AvailabilityAlertSupplier localAvailabilityAlertSupplier = this.qzZ.qzY;
          p.j(localAvailabilityAlertSupplier, "supplier");
          if (localAvailabilityAlertSupplier.getOnDismissListener() != null)
          {
            localAvailabilityAlertSupplier = this.qzZ.qzY;
            p.j(localAvailabilityAlertSupplier, "supplier");
            localAvailabilityAlertSupplier.getOnDismissListener().onClick(paramAnonymousDialogInterface, -2);
          }
          AppMethodBeat.o(267288);
        }
      });
      localObject2 = this.qzX.oxb.getDialogContainer();
      if (localObject2 == null) {
        p.iCn();
      }
      ((com.tencent.mm.plugin.appbrand.widget.dialog.l)localObject2).a((com.tencent.mm.plugin.appbrand.widget.dialog.j)localObject1);
      AppMethodBeat.o(256976);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.s.a.1
 * JD-Core Version:    0.7.0.1
 */