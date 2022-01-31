package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.plugin.backup.d.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.progress.RoundProgressBtn;

final class BackupMoveRecoverUI$1
  implements b.d
{
  BackupMoveRecoverUI$1(BackupMoveRecoverUI paramBackupMoveRecoverUI) {}
  
  public final void aSK() {}
  
  public final void rf(int paramInt)
  {
    AppMethodBeat.i(17385);
    Object localObject = b.aTr().aSL();
    ab.i("MicroMsg.BackupMoveRecoverUI", "onUpdateUIProgress state[%d], isActivityOnTop[%b], transferSession[%d], totalSession[%d], mergePercent[%d]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(BackupMoveRecoverUI.access$000()), Integer.valueOf(((e)localObject).jyO), Integer.valueOf(((e)localObject).jyP), Integer.valueOf(((e)localObject).jyQ) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(17385);
      return;
      BackupMoveRecoverUI.a(this.jDc);
      AppMethodBeat.o(17385);
      return;
      this.jDc.finish();
      AppMethodBeat.o(17385);
      return;
      this.jDc.jCZ.setImageResource(2131230948);
      this.jDc.jCW.setText(2131297236);
      this.jDc.jCX.setText(2131297267);
      this.jDc.jCX.setVisibility(0);
      this.jDc.jCU.setVisibility(4);
      this.jDc.jCV.setVisibility(4);
      BackupMoveRecoverUI.b(this.jDc).setVisibility(8);
      BackupMoveRecoverUI.c(this.jDc);
      AppMethodBeat.o(17385);
      return;
      this.jDc.jCZ.setImageResource(2131230948);
      this.jDc.jCW.setText(2131297282);
      this.jDc.jCX.setText(2131297267);
      this.jDc.jCX.setTextColor(this.jDc.getResources().getColor(2131689741));
      this.jDc.jCX.setVisibility(0);
      this.jDc.jCU.setVisibility(4);
      this.jDc.jCV.setVisibility(4);
      BackupMoveRecoverUI.b(this.jDc).setVisibility(8);
      BackupMoveRecoverUI.d(this.jDc);
      AppMethodBeat.o(17385);
      return;
      this.jDc.jCZ.setImageResource(2131230948);
      this.jDc.jCW.setText(2131297264);
      this.jDc.jCU.setText(2131297266);
      this.jDc.jCV.setText(2131297265);
      this.jDc.jCX.setVisibility(4);
      this.jDc.jCU.setVisibility(0);
      this.jDc.jCV.setVisibility(0);
      BackupMoveRecoverUI.b(this.jDc).setVisibility(8);
      this.jDc.jCU.setOnClickListener(new BackupMoveRecoverUI.1.1(this));
      this.jDc.jCV.setOnClickListener(new BackupMoveRecoverUI.1.12(this));
      BackupMoveRecoverUI.c(this.jDc);
      AppMethodBeat.o(17385);
      return;
      this.jDc.jCZ.setImageResource(2131230948);
      TextView localTextView = this.jDc.jCW;
      BackupMoveRecoverUI localBackupMoveRecoverUI = this.jDc;
      paramInt = ((e)localObject).jyO;
      int i = ((e)localObject).jyP;
      b.aTr().aTu();
      localTextView.setText(localBackupMoveRecoverUI.getString(2131297287, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), c.aTA() }));
      this.jDc.jCX.setText(2131297267);
      this.jDc.jCX.setTextColor(this.jDc.getResources().getColor(2131689741));
      this.jDc.jCX.setVisibility(0);
      this.jDc.jCU.setVisibility(8);
      this.jDc.jCV.setVisibility(4);
      BackupMoveRecoverUI.b(this.jDc).setVisibility(0);
      BackupMoveRecoverUI.b(this.jDc).setProgress(((e)localObject).aSU());
      BackupMoveRecoverUI.b(this.jDc).setOnClickListener(new BackupMoveRecoverUI.1.15(this));
      BackupMoveRecoverUI.d(this.jDc);
      AppMethodBeat.o(17385);
      return;
      this.jDc.jCZ.setImageResource(2131230948);
      this.jDc.jCW.setText(2131297270);
      this.jDc.jCX.setText(2131297272);
      this.jDc.jCX.setTextColor(this.jDc.getResources().getColor(2131689741));
      this.jDc.jCX.setVisibility(0);
      this.jDc.jCU.setVisibility(0);
      BackupMoveRecoverUI.b(this.jDc).setVisibility(8);
      this.jDc.jCU.setText(2131297271);
      this.jDc.jCU.setOnClickListener(new BackupMoveRecoverUI.1.16(this));
      this.jDc.jCV.setVisibility(0);
      this.jDc.jCV.setText(2131297286);
      this.jDc.jCV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(17379);
          ab.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop move button.");
          ab.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop move.");
          b.aTr().aSL().jyN = 29;
          BackupMoveRecoverUI.1.this.rf(29);
          AppMethodBeat.o(17379);
        }
      });
      BackupMoveRecoverUI.d(this.jDc);
      AppMethodBeat.o(17385);
      return;
      this.jDc.jCZ.setImageResource(2131230948);
      this.jDc.jCW.setText(2131297297);
      this.jDc.jCX.setText(2131297299);
      this.jDc.jCX.setTextColor(this.jDc.getResources().getColor(2131689741));
      this.jDc.jCX.setVisibility(0);
      this.jDc.jCU.setVisibility(0);
      BackupMoveRecoverUI.b(this.jDc).setVisibility(8);
      this.jDc.jCU.setText(2131297296);
      this.jDc.jCU.setOnClickListener(new BackupMoveRecoverUI.1.18(this));
      this.jDc.jCV.setVisibility(0);
      this.jDc.jCV.setText(2131297237);
      this.jDc.jCV.setOnClickListener(new BackupMoveRecoverUI.1.19(this, paramInt));
      this.jDc.jCY.setText(2131297377);
      this.jDc.jCY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(17383);
          b.aTr().aSL().jyN = 25;
          BackupMoveRecoverUI.e(BackupMoveRecoverUI.1.this.jDc);
          AppMethodBeat.o(17383);
        }
      });
      AppMethodBeat.o(17385);
      return;
      if (BackupMoveRecoverUI.access$000())
      {
        b.aTr().aSL().jyN = 24;
        paramInt = 24;
        break;
        ab.i("MicroMsg.BackupMoveRecoverUI", "backupmove BACKUP_STATE_RECOVER_TRANSFER_FINISH isFromBanner[%b]", new Object[] { Boolean.valueOf(BackupMoveRecoverUI.aTR()) });
        if (BackupMoveRecoverUI.aTR())
        {
          this.jDc.jCZ.setImageResource(2131230948);
          this.jDc.jCW.setText(2131297288);
          this.jDc.jCX.setText(2131297290);
          this.jDc.jCX.setTextColor(this.jDc.getResources().getColor(2131689741));
          this.jDc.jCU.setText(2131297284);
          this.jDc.jCV.setText(2131297285);
          this.jDc.jCY.setText(2131297377);
          this.jDc.jCX.setVisibility(0);
          this.jDc.jCU.setVisibility(0);
          this.jDc.jCV.setVisibility(0);
          BackupMoveRecoverUI.b(this.jDc).setVisibility(8);
          this.jDc.jCU.setOnClickListener(new BackupMoveRecoverUI.1.21(this));
          this.jDc.jCV.setOnClickListener(new BackupMoveRecoverUI.1.2(this, paramInt));
          this.jDc.jCY.setOnClickListener(new BackupMoveRecoverUI.1.3(this));
          AppMethodBeat.o(17385);
          return;
        }
        if (BackupMoveRecoverUI.access$000())
        {
          b.aTr().aTu();
          if (!c.aTw())
          {
            ab.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
            b.aTr().aSL().jyN = -22;
            rf(-22);
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(485L, 6L, 1L, false);
            AppMethodBeat.o(17385);
            return;
          }
          b.aTr().aTu().aTd();
          AppMethodBeat.o(17385);
          return;
          this.jDc.jCZ.setImageResource(2131230954);
          this.jDc.jCW.setText(this.jDc.getString(2131297279, new Object[] { Integer.valueOf(((e)localObject).jyQ) }));
          this.jDc.jCX.setText(2131297280);
          this.jDc.jCX.setTextColor(this.jDc.getResources().getColor(2131689741));
          this.jDc.jCX.setVisibility(0);
          this.jDc.jCU.setVisibility(4);
          this.jDc.jCV.setVisibility(4);
          BackupMoveRecoverUI.b(this.jDc).setVisibility(8);
          BackupMoveRecoverUI.c(this.jDc);
          AppMethodBeat.o(17385);
          return;
          this.jDc.jCZ.setImageResource(2131230954);
          this.jDc.jCW.setText(2131297376);
          this.jDc.jCX.setText(2131297280);
          this.jDc.jCX.setTextColor(this.jDc.getResources().getColor(2131689741));
          this.jDc.jCX.setVisibility(0);
          this.jDc.jCU.setVisibility(4);
          this.jDc.jCV.setVisibility(4);
          BackupMoveRecoverUI.b(this.jDc).setVisibility(8);
          BackupMoveRecoverUI.c(this.jDc);
          AppMethodBeat.o(17385);
          return;
          this.jDc.jCZ.setImageResource(2131230956);
          this.jDc.jCW.setText(2131297277);
          this.jDc.jCX.setText(this.jDc.getString(2131297278, new Object[] { Integer.valueOf(((e)localObject).jyO), Integer.valueOf(((e)localObject).jyP) }));
          this.jDc.jCX.setTextColor(this.jDc.getResources().getColor(2131689741));
          this.jDc.jCU.setText(2131297226);
          this.jDc.jCX.setVisibility(0);
          this.jDc.jCU.setVisibility(0);
          this.jDc.jCV.setVisibility(4);
          BackupMoveRecoverUI.b(this.jDc).setVisibility(8);
          this.jDc.jCU.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(17363);
              b.aTr().aTs().stop();
              b.aTr().aSL().jyN = -100;
              BackupMoveRecoverUI.g(BackupMoveRecoverUI.1.this.jDc);
              AppMethodBeat.o(17363);
            }
          });
          BackupMoveRecoverUI.c(this.jDc);
          AppMethodBeat.o(17385);
          return;
          this.jDc.jCZ.setImageResource(2131230948);
          localTextView = this.jDc.jCW;
          localBackupMoveRecoverUI = this.jDc;
          paramInt = ((e)localObject).jyO;
          i = ((e)localObject).jyP;
          b.aTr().aTu();
          localTextView.setText(localBackupMoveRecoverUI.getString(2131297287, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), c.aTA() }));
          this.jDc.jCX.setText(2131297302);
          this.jDc.jCX.setTextColor(this.jDc.getResources().getColor(2131689741));
          this.jDc.jCX.setVisibility(0);
          this.jDc.jCU.setVisibility(8);
          this.jDc.jCV.setVisibility(0);
          BackupMoveRecoverUI.b(this.jDc).setVisibility(0);
          BackupMoveRecoverUI.b(this.jDc).setProgress(((e)localObject).aSU());
          BackupMoveRecoverUI.b(this.jDc).setOnClickListener(new BackupMoveRecoverUI.1.5(this));
          this.jDc.jCV.setText(2131297303);
          this.jDc.jCV.setOnClickListener(new BackupMoveRecoverUI.1.6(this));
          BackupMoveRecoverUI.d(this.jDc);
          AppMethodBeat.o(17385);
          return;
          this.jDc.jCZ.setImageResource(2131230950);
          this.jDc.jCW.setText(this.jDc.getString(2131297268, new Object[] { Integer.valueOf(((e)localObject).jyO), Integer.valueOf(((e)localObject).jyP), "0M" }));
          this.jDc.jCX.setText(2131297252);
          this.jDc.jCU.setText(2131297283);
          this.jDc.jCV.setText(2131297286);
          this.jDc.jCU.setOnClickListener(new BackupMoveRecoverUI.1.7(this));
          this.jDc.jCV.setOnClickListener(new BackupMoveRecoverUI.1.8(this, paramInt));
          this.jDc.jCX.setTextColor(this.jDc.getResources().getColor(2131689740));
          this.jDc.jCX.setVisibility(0);
          this.jDc.jCU.setVisibility(0);
          this.jDc.jCV.setVisibility(0);
          BackupMoveRecoverUI.b(this.jDc).setVisibility(8);
          BackupMoveRecoverUI.d(this.jDc);
          AppMethodBeat.o(17385);
          return;
          this.jDc.jCZ.setImageResource(2131230950);
          this.jDc.jCW.setText(2131297255);
          localObject = g.dx(this.jDc);
          if ((localObject == null) || (((String)localObject).equals(""))) {
            this.jDc.jCX.setText(this.jDc.getString(2131297256, new Object[] { "移动网络", b.aTr().aTu().jBz }));
          }
          for (;;)
          {
            this.jDc.jCX.setTextColor(this.jDc.getResources().getColor(2131689740));
            this.jDc.jCX.setVisibility(0);
            this.jDc.jCU.setVisibility(4);
            this.jDc.jCV.setVisibility(4);
            BackupMoveRecoverUI.b(this.jDc).setVisibility(8);
            BackupMoveRecoverUI.c(this.jDc);
            AppMethodBeat.o(17385);
            return;
            this.jDc.jCX.setText(this.jDc.getString(2131297256, new Object[] { localObject, b.aTr().aTu().jBz }));
          }
          this.jDc.jCZ.setImageResource(2131230950);
          this.jDc.jCW.setText(2131297243);
          this.jDc.jCX.setText(2131297244);
          this.jDc.jCU.setText(2131297281);
          this.jDc.jCV.setText(2131297286);
          this.jDc.jCX.setTextColor(this.jDc.getResources().getColor(2131689740));
          this.jDc.jCX.setVisibility(0);
          this.jDc.jCU.setVisibility(0);
          this.jDc.jCV.setVisibility(0);
          BackupMoveRecoverUI.b(this.jDc).setVisibility(8);
          this.jDc.jCU.setOnClickListener(new BackupMoveRecoverUI.1.9(this));
          this.jDc.jCV.setOnClickListener(new BackupMoveRecoverUI.1.10(this, paramInt));
          BackupMoveRecoverUI.c(this.jDc);
          AppMethodBeat.o(17385);
          return;
          this.jDc.jCZ.setImageResource(2131230950);
          this.jDc.jCW.setText(2131297245);
          this.jDc.jCU.setText(2131297283);
          this.jDc.jCV.setText(2131297286);
          this.jDc.jCX.setVisibility(4);
          this.jDc.jCU.setVisibility(0);
          this.jDc.jCV.setVisibility(0);
          BackupMoveRecoverUI.b(this.jDc).setVisibility(8);
          this.jDc.jCU.setOnClickListener(new BackupMoveRecoverUI.1.11(this));
          this.jDc.jCV.setOnClickListener(new BackupMoveRecoverUI.1.13(this, paramInt));
          BackupMoveRecoverUI.c(this.jDc);
          AppMethodBeat.o(17385);
          return;
          this.jDc.jCZ.setImageResource(2131230950);
          this.jDc.jCW.setText(2131297337);
          this.jDc.jCX.setVisibility(4);
          this.jDc.jCU.setVisibility(4);
          this.jDc.jCV.setVisibility(4);
          BackupMoveRecoverUI.b(this.jDc).setVisibility(8);
          BackupMoveRecoverUI.c(this.jDc);
          AppMethodBeat.o(17385);
          return;
          this.jDc.jCZ.setImageResource(2131230948);
          this.jDc.jCW.setText(2131297236);
          this.jDc.jCX.setText(2131297267);
          this.jDc.jCX.setVisibility(0);
          this.jDc.jCU.setVisibility(4);
          this.jDc.jCV.setVisibility(4);
          BackupMoveRecoverUI.b(this.jDc).setVisibility(8);
          BackupMoveRecoverUI.c(this.jDc);
          com.tencent.mm.ui.base.h.a(this.jDc, 2131297251, 0, 2131297394, 0, false, new BackupMoveRecoverUI.1.14(this), null, 2131689739);
          AppMethodBeat.o(17385);
          return;
          this.jDc.jCZ.setImageResource(2131230950);
          this.jDc.jCW.setText(2131297253);
          this.jDc.jCX.setText(this.jDc.getString(2131297254, new Object[] { bo.hk(b.aTr().aTu().jBH) }));
          this.jDc.jCX.setVisibility(0);
          this.jDc.jCU.setVisibility(4);
          this.jDc.jCV.setVisibility(4);
          BackupMoveRecoverUI.b(this.jDc).setVisibility(8);
          BackupMoveRecoverUI.c(this.jDc);
          AppMethodBeat.o(17385);
          return;
          this.jDc.jCZ.setImageResource(2131230950);
          this.jDc.jCW.setText(2131297329);
          b.aTr().aTs().stop();
          this.jDc.jCX.setVisibility(4);
          this.jDc.jCU.setVisibility(4);
          this.jDc.jCV.setVisibility(4);
          BackupMoveRecoverUI.b(this.jDc).setVisibility(8);
          BackupMoveRecoverUI.c(this.jDc);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.1
 * JD-Core Version:    0.7.0.1
 */