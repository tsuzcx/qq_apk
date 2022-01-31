package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.plugin.backup.d.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

final class BackupMoveQRCodeUI$1
  implements b.d
{
  BackupMoveQRCodeUI$1(BackupMoveQRCodeUI paramBackupMoveQRCodeUI) {}
  
  public final void aSK() {}
  
  public final void rf(int paramInt)
  {
    AppMethodBeat.i(17345);
    ab.i("MicroMsg.BackupMoveQRCodeUI", "onUpdateUIProgress backupState:%d", new Object[] { Integer.valueOf(paramInt) });
    if (BackupMoveQRCodeUI.a(this.jCS))
    {
      AppMethodBeat.o(17345);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(17345);
      return;
      ab.i("MicroMsg.BackupMoveQRCodeUI", "auth success. go to BackupMoveUI.");
      b.aTr().aSL().jyN = 12;
      Object localObject = new Intent(this.jCS, BackupMoveUI.class);
      MMWizardActivity.J(this.jCS, (Intent)localObject);
      AppMethodBeat.o(17345);
      return;
      localObject = b.aTr().aTt().bitmapData;
      BackupMoveQRCodeUI.b(this.jCS).setImageBitmap(BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length));
      BackupMoveQRCodeUI.c(this.jCS).setText(2131297276);
      BackupMoveQRCodeUI.c(this.jCS).setTextColor(this.jCS.getContext().getResources().getColor(2131689763));
      BackupMoveQRCodeUI.d(this.jCS).setVisibility(4);
      AppMethodBeat.o(17345);
      return;
      BackupMoveQRCodeUI.c(this.jCS).setText(2131297250);
      BackupMoveQRCodeUI.c(this.jCS).setTextColor(this.jCS.getContext().getResources().getColor(2131690391));
      BackupMoveQRCodeUI.b(this.jCS).setImageResource(2131230953);
      BackupMoveQRCodeUI.d(this.jCS).setVisibility(4);
      AppMethodBeat.o(17345);
      return;
      BackupMoveQRCodeUI.a(this.jCS, true);
      h.a(this.jCS, 2131297259, 0, 2131297219, 2131297220, false, new BackupMoveQRCodeUI.1.1(this), new BackupMoveQRCodeUI.1.2(this), 2131689739);
      AppMethodBeat.o(17345);
      return;
      BackupMoveQRCodeUI.a(this.jCS, true);
      h.a(this.jCS, 2131297258, 0, 2131297218, 2131297220, false, new BackupMoveQRCodeUI.1.3(this), new BackupMoveQRCodeUI.1.4(this), 2131689739);
      AppMethodBeat.o(17345);
      return;
      h.a(this.jCS, 2131297261, 0, 2131297394, 0, false, new BackupMoveQRCodeUI.1.5(this), null, 2131689739);
      AppMethodBeat.o(17345);
      return;
      BackupMoveQRCodeUI.a(this.jCS, true);
      h.a(this.jCS, 2131297257, 0, 2131297219, 2131297220, false, new BackupMoveQRCodeUI.1.6(this), new BackupMoveQRCodeUI.1.7(this), 2131689739);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveQRCodeUI.1
 * JD-Core Version:    0.7.0.1
 */