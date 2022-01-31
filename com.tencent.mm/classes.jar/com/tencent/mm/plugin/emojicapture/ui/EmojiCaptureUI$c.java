package com.tencent.mm.plugin.emojicapture.ui;

import a.a.e;
import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.c;
import com.tencent.mm.ui.base.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "", "kotlin.jvm.PlatformType", "grantResults", "", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V"})
final class EmojiCaptureUI$c
  implements c
{
  EmojiCaptureUI$c(EmojiCaptureUI paramEmojiCaptureUI) {}
  
  public final void t(int[] paramArrayOfInt)
  {
    int k = 1;
    AppMethodBeat.i(2866);
    j.p(paramArrayOfInt, "grantResults");
    int m = paramArrayOfInt.length;
    int i = 0;
    int j;
    if (i < m) {
      if (paramArrayOfInt[i] != 0)
      {
        j = 1;
        label35:
        if (j == 0) {
          break label115;
        }
        i = k;
        label42:
        if (i != 0)
        {
          i = 2131302067;
          paramArrayOfInt = e.j(paramArrayOfInt, 0);
          if (paramArrayOfInt != null) {
            break label127;
          }
        }
      }
    }
    for (;;)
    {
      h.a((Context)this.lxg.getContext(), i, 2131302083, 2131300996, 2131296888, false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(2864);
          j.q(paramAnonymousDialogInterface, "dialog");
          paramAnonymousDialogInterface.dismiss();
          this.lxh.lxg.getContext().startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
          AppMethodBeat.o(2864);
        }
      }, (DialogInterface.OnClickListener)new EmojiCaptureUI.c.2(this));
      AppMethodBeat.o(2866);
      return;
      j = 0;
      break label35;
      label115:
      i += 1;
      break;
      i = 0;
      break label42;
      label127:
      if (paramArrayOfInt.intValue() == 0) {
        i = 2131302075;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.c
 * JD-Core Version:    0.7.0.1
 */