package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.b.c;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.plugin.backup.d.d;
import com.tencent.mm.sdk.platformtools.ab;

final class BackupMoveUI$1
  implements b.d
{
  BackupMoveUI$1(BackupMoveUI paramBackupMoveUI) {}
  
  public final void aSK() {}
  
  public final void rf(int paramInt)
  {
    AppMethodBeat.i(17408);
    Object localObject = b.aTr().aSL();
    ab.i("MicroMsg.BackupMoveUI", "onUpdateUIProgress state:%d, transferSession:%d, totalSession:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).jyO), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).jyP) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(17408);
      return;
      BackupMoveUI.a(this.jDk);
      AppMethodBeat.o(17408);
      return;
      this.jDk.finish();
      AppMethodBeat.o(17408);
      return;
      this.jDk.jCZ.setImageResource(2131230948);
      this.jDk.jCW.setText(2131297236);
      this.jDk.jCX.setText(2131297267);
      this.jDk.jCX.setVisibility(0);
      this.jDk.jCU.setVisibility(4);
      this.jDk.jCV.setVisibility(4);
      BackupMoveUI.b(this.jDk);
      AppMethodBeat.o(17408);
      return;
      this.jDk.jCZ.setImageResource(2131230948);
      this.jDk.jCW.setText(this.jDk.getString(2131297229, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).jyO), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).jyP) }));
      this.jDk.jCX.setText(2131297267);
      this.jDk.jCX.setTextColor(this.jDk.getResources().getColor(2131689741));
      this.jDk.jCX.setVisibility(0);
      this.jDk.jCU.setVisibility(4);
      this.jDk.jCV.setVisibility(4);
      BackupMoveUI.b(this.jDk);
      AppMethodBeat.o(17408);
      return;
      this.jDk.jCZ.setImageResource(2131230948);
      this.jDk.jCW.setText(2131297273);
      this.jDk.jCX.setText(2131297267);
      this.jDk.jCX.setTextColor(this.jDk.getResources().getColor(2131689741));
      this.jDk.jCX.setVisibility(0);
      this.jDk.jCU.setVisibility(4);
      this.jDk.jCV.setVisibility(4);
      BackupMoveUI.b(this.jDk);
      AppMethodBeat.o(17408);
      return;
      this.jDk.jCZ.setImageResource(2131230948);
      TextView localTextView = this.jDk.jCW;
      BackupMoveUI localBackupMoveUI = this.jDk;
      paramInt = ((com.tencent.mm.plugin.backup.b.e)localObject).jyO;
      int i = ((com.tencent.mm.plugin.backup.b.e)localObject).jyP;
      b.aTr().aTt();
      localTextView.setText(localBackupMoveUI.getString(2131297301, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), d.aTI() }));
      this.jDk.jCX.setText(2131297267);
      this.jDk.jCX.setTextColor(this.jDk.getResources().getColor(2131689741));
      this.jDk.jCX.setVisibility(0);
      this.jDk.jCU.setVisibility(4);
      this.jDk.jCV.setVisibility(4);
      BackupMoveUI.b(this.jDk);
      AppMethodBeat.o(17408);
      return;
      this.jDk.jCZ.setImageResource(2131230951);
      this.jDk.jCW.setText(2131297262);
      this.jDk.jCX.setText(this.jDk.getString(2131297263, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).jyO), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).jyP) }));
      this.jDk.jCX.setTextColor(this.jDk.getResources().getColor(2131689741));
      this.jDk.jCU.setText(2131297226);
      this.jDk.jCX.setVisibility(0);
      this.jDk.jCU.setVisibility(0);
      this.jDk.jCV.setVisibility(4);
      this.jDk.jCU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(17407);
          b.aTr().aTs().stop();
          b.aTr().aTt().cancel(true);
          b.aTr().aSL().jyN = -100;
          BackupMoveUI.c(BackupMoveUI.1.this.jDk);
          AppMethodBeat.o(17407);
        }
      });
      BackupMoveUI.b(this.jDk);
      AppMethodBeat.o(17408);
      return;
      localObject = b.aTr().aTt().bitmapData;
      this.jDk.jCZ.setImageBitmap(BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length));
      this.jDk.jCW.setText(2131297276);
      this.jDk.jCW.setTextColor(this.jDk.getContext().getResources().getColor(2131689763));
      this.jDk.jCX.setVisibility(4);
      this.jDk.jCU.setVisibility(4);
      this.jDk.jCV.setVisibility(4);
      BackupMoveUI.b(this.jDk);
      AppMethodBeat.o(17408);
      return;
      this.jDk.jCZ.setImageResource(2131230948);
      localTextView = this.jDk.jCW;
      localBackupMoveUI = this.jDk;
      paramInt = ((com.tencent.mm.plugin.backup.b.e)localObject).jyO;
      i = ((com.tencent.mm.plugin.backup.b.e)localObject).jyP;
      b.aTr().aTt();
      localTextView.setText(localBackupMoveUI.getString(2131297301, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), d.aTI() }));
      this.jDk.jCX.setText(2131297302);
      this.jDk.jCX.setTextColor(this.jDk.getResources().getColor(2131689741));
      this.jDk.jCX.setVisibility(0);
      this.jDk.jCU.setVisibility(4);
      this.jDk.jCV.setVisibility(4);
      BackupMoveUI.b(this.jDk);
      AppMethodBeat.o(17408);
      return;
      this.jDk.jCZ.setImageResource(2131230952);
      b.aTr().aTt().jCa.start();
      this.jDk.jCW.setText(this.jDk.getString(2131297268, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).jyO), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).jyP), "0M" }));
      this.jDk.jCX.setText(2131297252);
      this.jDk.jCX.setTextColor(this.jDk.getContext().getResources().getColor(2131690391));
      this.jDk.jCX.setVisibility(0);
      this.jDk.jCU.setVisibility(4);
      this.jDk.jCV.setVisibility(4);
      BackupMoveUI.d(this.jDk);
      b.aTr().aTt().jBU = c.jyz;
      AppMethodBeat.o(17408);
      return;
      this.jDk.jCZ.setImageResource(2131230952);
      this.jDk.jCW.setText(this.jDk.getString(2131297268, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).jyO), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).jyP), "0M" }));
      this.jDk.jCX.setText(2131297250);
      this.jDk.jCX.setTextColor(this.jDk.getContext().getResources().getColor(2131690391));
      this.jDk.jCX.setVisibility(0);
      this.jDk.jCU.setVisibility(4);
      this.jDk.jCV.setVisibility(4);
      BackupMoveUI.b(this.jDk);
      AppMethodBeat.o(17408);
      return;
      this.jDk.jCZ.setImageResource(2131230950);
      this.jDk.jCW.setText(2131297260);
      this.jDk.jCX.setVisibility(4);
      this.jDk.jCU.setVisibility(4);
      this.jDk.jCV.setVisibility(4);
      BackupMoveUI.b(this.jDk);
      AppMethodBeat.o(17408);
      return;
      this.jDk.jCZ.setImageResource(2131230950);
      this.jDk.jCW.setText(2131297246);
      this.jDk.jCX.setVisibility(4);
      this.jDk.jCU.setVisibility(4);
      this.jDk.jCV.setVisibility(4);
      BackupMoveUI.b(this.jDk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveUI.1
 * JD-Core Version:    0.7.0.1
 */