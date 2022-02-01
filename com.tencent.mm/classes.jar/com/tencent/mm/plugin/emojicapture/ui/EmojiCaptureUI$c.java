package com.tencent.mm.plugin.emojicapture.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.c;
import com.tencent.mm.ui.base.h;
import d.a.e;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "", "kotlin.jvm.PlatformType", "grantResults", "", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V"})
final class EmojiCaptureUI$c
  implements c
{
  EmojiCaptureUI$c(EmojiCaptureUI paramEmojiCaptureUI) {}
  
  public final void b(int paramInt, int[] paramArrayOfInt)
  {
    int j = 1;
    AppMethodBeat.i(195134);
    p.g(paramArrayOfInt, "grantResults");
    int k = paramArrayOfInt.length;
    paramInt = 0;
    int i;
    if (paramInt < k) {
      if (paramArrayOfInt[paramInt] != 0)
      {
        i = 1;
        label34:
        if (i == 0) {
          break label113;
        }
        paramInt = j;
        label41:
        if (paramInt != 0)
        {
          paramInt = 2131761860;
          paramArrayOfInt = e.m(paramArrayOfInt, 0);
          if (paramArrayOfInt != null) {
            break label125;
          }
        }
      }
    }
    for (;;)
    {
      h.a((Context)this.pUy.getContext(), paramInt, 2131761885, 2131760598, 2131755691, false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(451);
          p.h(paramAnonymousDialogInterface, "dialog");
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = this.pUz.pUy.getContext();
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$checkPermission$1$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$checkPermission$1$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(451);
        }
      }, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(452);
          p.h(paramAnonymousDialogInterface, "dialog");
          paramAnonymousDialogInterface.dismiss();
          this.pUz.pUy.finish();
          AppMethodBeat.o(452);
        }
      });
      AppMethodBeat.o(195134);
      return;
      i = 0;
      break label34;
      label113:
      paramInt += 1;
      break;
      paramInt = 0;
      break label41;
      label125:
      if (paramArrayOfInt.intValue() == 0) {
        paramInt = 2131761871;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.c
 * JD-Core Version:    0.7.0.1
 */