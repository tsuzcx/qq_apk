package com.tencent.mm.plugin.backup.backuppcui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.b.b.c;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class BackupPcUI$3
  implements b.c
{
  BackupPcUI$3(BackupPcUI paramBackupPcUI) {}
  
  private void aUj()
  {
    AppMethodBeat.i(17615);
    BackupPcUI.h(this.jEP).setText(2131297225);
    BackupPcUI.h(this.jEP).setOnClickListener(new BackupPcUI.3.7(this));
    AppMethodBeat.o(17615);
  }
  
  private void aUk()
  {
    AppMethodBeat.i(17616);
    BackupPcUI.h(this.jEP).setText(2131297227);
    BackupPcUI.h(this.jEP).setOnClickListener(new BackupPcUI.3.8(this));
    AppMethodBeat.o(17616);
  }
  
  private void rs(int paramInt)
  {
    AppMethodBeat.i(17614);
    if ((2 == paramInt) || (4 == paramInt))
    {
      BackupPcUI.b(this.jEP).setImageResource(2131230960);
      AppMethodBeat.o(17614);
      return;
    }
    BackupPcUI.b(this.jEP).setImageResource(2131230957);
    AppMethodBeat.o(17614);
  }
  
  public final void aSJ()
  {
    AppMethodBeat.i(17612);
    int i = b.aTX().aTY().jEa;
    ab.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onBackupPcStart, commandMode[%d]", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(17612);
      return;
      b.aTX().aSL().jyN = 11;
      rf(11);
      AppMethodBeat.o(17612);
      return;
      b.aTX().aSL().jyN = 21;
      rf(21);
      AppMethodBeat.o(17612);
      return;
      b.aTX().aSL().jyN = 12;
      rf(12);
      AppMethodBeat.o(17612);
      return;
      b.aTX().aSL().jyN = 22;
      rf(22);
    }
  }
  
  public final void aSK() {}
  
  public final void rf(int paramInt)
  {
    AppMethodBeat.i(17613);
    int i = b.aTX().aTY().jEa;
    ab.i("MicroMsg.BackupPcUI", "onUpdateUIProgress backupPcState:%d, commandMode:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    Object localObject = b.aTX().aSL();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(17613);
      return;
      BackupPcUI.a(this.jEP);
      AppMethodBeat.o(17613);
      return;
      BackupPcUI.b(this.jEP).setImageResource(2131230959);
      BackupPcUI.c(this.jEP).setText(2131297315);
      BackupPcUI.d(this.jEP).setVisibility(4);
      BackupPcUI.e(this.jEP).setVisibility(4);
      BackupPcUI.f(this.jEP).setVisibility(4);
      aUj();
      AppMethodBeat.o(17613);
      return;
      BackupPcUI.b(this.jEP).setImageResource(2131230959);
      BackupPcUI.c(this.jEP).setText(2131297369);
      BackupPcUI.d(this.jEP).setText(2131297368);
      BackupPcUI.d(this.jEP).setTextColor(this.jEP.getResources().getColor(2131689741));
      BackupPcUI.e(this.jEP).setText(2131297366);
      BackupPcUI.f(this.jEP).setText(2131297367);
      BackupPcUI.d(this.jEP).setVisibility(0);
      BackupPcUI.e(this.jEP).setVisibility(0);
      BackupPcUI.f(this.jEP).setVisibility(0);
      aUj();
      BackupPcUI.e(this.jEP).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(17591);
          aw.aaz();
          boolean bool = ((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yEv, Boolean.FALSE)).booleanValue();
          ab.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onUpdateUIProgress startbackup all, hasMove:%s", new Object[] { Boolean.valueOf(bool) });
          if (bool)
          {
            com.tencent.mm.ui.base.h.a(BackupPcUI.3.this.jEP, 2131297342, 0, 2131297394, 0, false, new BackupPcUI.3.1.1(this), null, 2131689739);
            AppMethodBeat.o(17591);
            return;
          }
          b.aTX().aTY().rq(2);
          b.aTX().aSL().jyN = 12;
          BackupPcUI.3.this.rf(12);
          b.aTX().aUb().cancel();
          b.aTX().aUb().aTW();
          b.aTX().aUb().fB(true);
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(400L, 7L, 1L, false);
          com.tencent.mm.plugin.report.service.h.qsU.e(13735, new Object[] { Integer.valueOf(9), Integer.valueOf(b.aTX().aTY().jEg) });
          AppMethodBeat.o(17591);
        }
      });
      BackupPcUI.f(this.jEP).setOnClickListener(new BackupPcUI.3.9(this));
      AppMethodBeat.o(17613);
      return;
      BackupPcUI.b(this.jEP).setImageResource(2131230959);
      BackupPcUI.c(this.jEP).setText(2131297345);
      BackupPcUI.d(this.jEP).setText(2131297346);
      BackupPcUI.d(this.jEP).setTextColor(this.jEP.getResources().getColor(2131689741));
      BackupPcUI.d(this.jEP).setVisibility(0);
      BackupPcUI.e(this.jEP).setVisibility(4);
      BackupPcUI.f(this.jEP).setVisibility(4);
      aUk();
      AppMethodBeat.o(17613);
      return;
      BackupPcUI.b(this.jEP).setImageResource(2131230959);
      TextView localTextView = BackupPcUI.c(this.jEP);
      BackupPcUI localBackupPcUI = this.jEP;
      paramInt = ((e)localObject).jyO;
      i = ((e)localObject).jyP;
      b.aTX().aTY();
      localTextView.setText(localBackupPcUI.getString(2131297373, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.aUd() }));
      BackupPcUI.d(this.jEP).setText(2131297346);
      BackupPcUI.d(this.jEP).setTextColor(this.jEP.getResources().getColor(2131689741));
      BackupPcUI.d(this.jEP).setVisibility(0);
      BackupPcUI.e(this.jEP).setVisibility(4);
      BackupPcUI.f(this.jEP).setVisibility(4);
      aUk();
      AppMethodBeat.o(17613);
      return;
      BackupPcUI.b(this.jEP).setImageResource(2131230958);
      BackupPcUI.c(this.jEP).setText(2131297306);
      BackupPcUI.d(this.jEP).setText(this.jEP.getString(2131297307, new Object[] { Integer.valueOf(((e)localObject).jyO), Integer.valueOf(((e)localObject).jyP) }));
      BackupPcUI.d(this.jEP).setTextColor(this.jEP.getResources().getColor(2131689741));
      BackupPcUI.e(this.jEP).setText(2131297226);
      BackupPcUI.d(this.jEP).setVisibility(0);
      BackupPcUI.e(this.jEP).setVisibility(0);
      BackupPcUI.f(this.jEP).setVisibility(4);
      BackupPcUI.e(this.jEP).setOnClickListener(new BackupPcUI.3.10(this));
      aUj();
      AppMethodBeat.o(17613);
      return;
      BackupPcUI.b(this.jEP).setImageResource(2131230962);
      BackupPcUI.c(this.jEP).setText(2131297355);
      BackupPcUI.e(this.jEP).setText(2131297354);
      BackupPcUI.d(this.jEP).setVisibility(4);
      BackupPcUI.e(this.jEP).setVisibility(0);
      BackupPcUI.f(this.jEP).setVisibility(4);
      BackupPcUI.e(this.jEP).setOnClickListener(new BackupPcUI.3.11(this));
      aUj();
      AppMethodBeat.o(17613);
      return;
      BackupPcUI.b(this.jEP).setImageResource(2131230962);
      BackupPcUI.c(this.jEP).setText(2131297345);
      BackupPcUI.d(this.jEP).setText(2131297346);
      BackupPcUI.d(this.jEP).setTextColor(this.jEP.getResources().getColor(2131689741));
      BackupPcUI.d(this.jEP).setVisibility(0);
      BackupPcUI.e(this.jEP).setVisibility(4);
      BackupPcUI.f(this.jEP).setVisibility(4);
      aUk();
      AppMethodBeat.o(17613);
      return;
      BackupPcUI.b(this.jEP).setImageResource(2131230962);
      localTextView = BackupPcUI.c(this.jEP);
      localBackupPcUI = this.jEP;
      paramInt = ((e)localObject).jyO;
      i = ((e)localObject).jyP;
      b.aTX().aTY();
      localTextView.setText(localBackupPcUI.getString(2131297357, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.aUd() }));
      BackupPcUI.d(this.jEP).setText(2131297346);
      BackupPcUI.d(this.jEP).setTextColor(this.jEP.getResources().getColor(2131689741));
      BackupPcUI.d(this.jEP).setVisibility(0);
      BackupPcUI.e(this.jEP).setVisibility(4);
      BackupPcUI.f(this.jEP).setVisibility(4);
      aUk();
      AppMethodBeat.o(17613);
      return;
      if (bo.cB(this.jEP))
      {
        b.aTX().aSL().jyN = 24;
        paramInt = 24;
        break;
        if (BackupPcUI.access$700())
        {
          BackupPcUI.b(this.jEP).setImageResource(2131230962);
          BackupPcUI.c(this.jEP).setText(2131297358);
          BackupPcUI.d(this.jEP).setText(2131297360);
          BackupPcUI.d(this.jEP).setTextColor(this.jEP.getResources().getColor(2131689741));
          BackupPcUI.e(this.jEP).setText(2131297353);
          BackupPcUI.f(this.jEP).setText(2131297356);
          BackupPcUI.h(this.jEP).setText(2131297377);
          BackupPcUI.d(this.jEP).setVisibility(0);
          BackupPcUI.e(this.jEP).setVisibility(0);
          BackupPcUI.f(this.jEP).setVisibility(0);
          BackupPcUI.e(this.jEP).setOnClickListener(new BackupPcUI.3.12(this));
          BackupPcUI.f(this.jEP).setOnClickListener(new BackupPcUI.3.13(this));
          BackupPcUI.h(this.jEP).setOnClickListener(new BackupPcUI.3.14(this));
          AppMethodBeat.o(17613);
          return;
        }
        if (bo.cB(this.jEP))
        {
          b.aTX().aUa();
          if (!d.aTw())
          {
            b.aTX().aSL().jyN = -22;
            rf(-22);
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(400L, 64L, 1L, false);
            AppMethodBeat.o(17613);
            return;
          }
          b.aTX().aUa().aTd();
          AppMethodBeat.o(17613);
          return;
          BackupPcUI.b(this.jEP).setImageResource(2131230962);
          BackupPcUI.c(this.jEP).setText(this.jEP.getString(2131297352, new Object[] { Integer.valueOf(((e)localObject).jyQ) }));
          BackupPcUI.d(this.jEP).setText(2131297351);
          BackupPcUI.d(this.jEP).setTextColor(this.jEP.getResources().getColor(2131689741));
          BackupPcUI.h(this.jEP).setText(2131297356);
          BackupPcUI.d(this.jEP).setVisibility(0);
          BackupPcUI.e(this.jEP).setVisibility(4);
          BackupPcUI.f(this.jEP).setVisibility(4);
          aUj();
          AppMethodBeat.o(17613);
          return;
          BackupPcUI.b(this.jEP).setImageResource(2131230954);
          BackupPcUI.c(this.jEP).setText(2131297376);
          BackupPcUI.d(this.jEP).setText(2131297280);
          BackupPcUI.d(this.jEP).setTextColor(this.jEP.getResources().getColor(2131689741));
          BackupPcUI.d(this.jEP).setVisibility(0);
          BackupPcUI.e(this.jEP).setVisibility(4);
          BackupPcUI.f(this.jEP).setVisibility(4);
          aUj();
          AppMethodBeat.o(17613);
          return;
          BackupPcUI.b(this.jEP).setImageResource(2131230961);
          BackupPcUI.c(this.jEP).setText(2131297349);
          BackupPcUI.d(this.jEP).setText(this.jEP.getString(2131297350, new Object[] { Integer.valueOf(((e)localObject).jyO), Integer.valueOf(((e)localObject).jyP) }));
          BackupPcUI.d(this.jEP).setTextColor(this.jEP.getResources().getColor(2131689741));
          BackupPcUI.e(this.jEP).setText(2131297226);
          BackupPcUI.d(this.jEP).setVisibility(0);
          BackupPcUI.e(this.jEP).setVisibility(0);
          BackupPcUI.f(this.jEP).setVisibility(4);
          BackupPcUI.e(this.jEP).setOnClickListener(new BackupPcUI.3.15(this));
          aUj();
          AppMethodBeat.o(17613);
          return;
          switch (i)
          {
          }
          for (;;)
          {
            BackupPcUI.d(this.jEP).setText(2131297375);
            BackupPcUI.d(this.jEP).setTextColor(this.jEP.getResources().getColor(2131689740));
            BackupPcUI.d(this.jEP).setVisibility(0);
            BackupPcUI.e(this.jEP).setVisibility(4);
            BackupPcUI.f(this.jEP).setVisibility(4);
            aUk();
            AppMethodBeat.o(17613);
            return;
            BackupPcUI.b(this.jEP).setImageResource(2131230959);
            localTextView = BackupPcUI.c(this.jEP);
            localBackupPcUI = this.jEP;
            paramInt = ((e)localObject).jyO;
            i = ((e)localObject).jyP;
            b.aTX().aTY();
            localTextView.setText(localBackupPcUI.getString(2131297373, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.aUd() }));
            continue;
            BackupPcUI.b(this.jEP).setImageResource(2131230962);
            localTextView = BackupPcUI.c(this.jEP);
            localBackupPcUI = this.jEP;
            paramInt = ((e)localObject).jyO;
            i = ((e)localObject).jyP;
            b.aTX().aTY();
            localTextView.setText(localBackupPcUI.getString(2131297357, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.aUd() }));
          }
          switch (i)
          {
          }
          for (;;)
          {
            BackupPcUI.d(this.jEP).setText(2131297374);
            BackupPcUI.d(this.jEP).setTextColor(this.jEP.getResources().getColor(2131689740));
            BackupPcUI.d(this.jEP).setVisibility(0);
            BackupPcUI.e(this.jEP).setVisibility(4);
            BackupPcUI.f(this.jEP).setVisibility(0);
            aUk();
            AppMethodBeat.o(17613);
            return;
            BackupPcUI.b(this.jEP).setImageResource(2131230959);
            localTextView = BackupPcUI.c(this.jEP);
            localBackupPcUI = this.jEP;
            paramInt = ((e)localObject).jyO;
            i = ((e)localObject).jyP;
            b.aTX().aTY();
            localTextView.setText(localBackupPcUI.getString(2131297373, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.aUd() }));
            BackupPcUI.f(this.jEP).setText(2131297370);
            BackupPcUI.f(this.jEP).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(17611);
                com.tencent.mm.ui.base.h.a(BackupPcUI.3.this.jEP, 2131297319, 2131297318, 2131297370, 2131297220, false, new BackupPcUI.3.16.1(this), null, 2131689740);
                AppMethodBeat.o(17611);
              }
            });
            continue;
            BackupPcUI.b(this.jEP).setImageResource(2131230962);
            localTextView = BackupPcUI.c(this.jEP);
            localBackupPcUI = this.jEP;
            paramInt = ((e)localObject).jyO;
            i = ((e)localObject).jyP;
            b.aTX().aTY();
            localTextView.setText(localBackupPcUI.getString(2131297357, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.aUd() }));
            BackupPcUI.f(this.jEP).setText(2131297372);
            BackupPcUI.f(this.jEP).setOnClickListener(new BackupPcUI.3.2(this));
          }
          if ((1 == i) || (3 == i))
          {
            BackupPcUI.b(this.jEP).setImageResource(2131230957);
            BackupPcUI.c(this.jEP).setText(this.jEP.getString(2131297373, new Object[] { Integer.valueOf(((e)localObject).jyO), Integer.valueOf(((e)localObject).jyP), "0M" }));
            BackupPcUI.d(this.jEP).setText(2131297330);
            BackupPcUI.f(this.jEP).setText(2131297370);
            BackupPcUI.f(this.jEP).setOnClickListener(new BackupPcUI.3.3(this));
          }
          for (;;)
          {
            BackupPcUI.d(this.jEP).setTextColor(this.jEP.getResources().getColor(2131689740));
            BackupPcUI.d(this.jEP).setVisibility(0);
            BackupPcUI.e(this.jEP).setVisibility(4);
            BackupPcUI.f(this.jEP).setVisibility(0);
            aUk();
            AppMethodBeat.o(17613);
            return;
            if ((2 == i) || (4 == i))
            {
              BackupPcUI.b(this.jEP).setImageResource(2131230960);
              BackupPcUI.c(this.jEP).setText(this.jEP.getString(2131297357, new Object[] { Integer.valueOf(((e)localObject).jyO), Integer.valueOf(((e)localObject).jyP), "0M" }));
              BackupPcUI.d(this.jEP).setText(2131297338);
              BackupPcUI.f(this.jEP).setText(2131297372);
              BackupPcUI.f(this.jEP).setOnClickListener(new BackupPcUI.3.4(this));
            }
          }
          rs(i);
          BackupPcUI.c(this.jEP).setText(2131297335);
          localObject = g.dx(this.jEP);
          if ((localObject == null) || (((String)localObject).equals(""))) {
            BackupPcUI.d(this.jEP).setText(this.jEP.getString(2131297336, new Object[] { b.aTX().aTY().jEb, "移动网络" }));
          }
          for (;;)
          {
            BackupPcUI.d(this.jEP).setTextColor(this.jEP.getResources().getColor(2131689740));
            BackupPcUI.f(this.jEP).setText(2131297340);
            BackupPcUI.d(this.jEP).setVisibility(0);
            BackupPcUI.e(this.jEP).setVisibility(4);
            BackupPcUI.f(this.jEP).setVisibility(0);
            BackupPcUI.f(this.jEP).setOnClickListener(new BackupPcUI.3.5(this));
            aUj();
            AppMethodBeat.o(17613);
            return;
            BackupPcUI.d(this.jEP).setText(this.jEP.getString(2131297336, new Object[] { b.aTX().aTY().jEb, localObject }));
          }
          rs(i);
          BackupPcUI.c(this.jEP).setText(2131297324);
          BackupPcUI.f(this.jEP).setText(2131297340);
          BackupPcUI.d(this.jEP).setVisibility(4);
          BackupPcUI.e(this.jEP).setVisibility(4);
          BackupPcUI.f(this.jEP).setVisibility(0);
          BackupPcUI.f(this.jEP).setOnClickListener(new BackupPcUI.3.6(this));
          aUj();
          AppMethodBeat.o(17613);
          return;
          rs(i);
          BackupPcUI.c(this.jEP).setText(2131297325);
          BackupPcUI.d(this.jEP).setVisibility(4);
          BackupPcUI.e(this.jEP).setVisibility(4);
          BackupPcUI.f(this.jEP).setVisibility(4);
          aUj();
          AppMethodBeat.o(17613);
          return;
          rs(i);
          BackupPcUI.c(this.jEP).setText(2131297337);
          BackupPcUI.d(this.jEP).setVisibility(4);
          BackupPcUI.e(this.jEP).setVisibility(4);
          BackupPcUI.f(this.jEP).setVisibility(4);
          aUj();
          AppMethodBeat.o(17613);
          return;
          rs(i);
          BackupPcUI.c(this.jEP).setText(2131297334);
          b.aTX().aTs().stop();
          BackupPcUI.d(this.jEP).setVisibility(4);
          BackupPcUI.e(this.jEP).setVisibility(4);
          BackupPcUI.f(this.jEP).setVisibility(4);
          aUj();
          AppMethodBeat.o(17613);
          return;
          rs(i);
          BackupPcUI.c(this.jEP).setText(2131297329);
          b.aTX().aTs().stop();
          BackupPcUI.d(this.jEP).setVisibility(4);
          BackupPcUI.e(this.jEP).setVisibility(4);
          BackupPcUI.f(this.jEP).setVisibility(4);
          aUj();
          AppMethodBeat.o(17613);
          return;
          rs(i);
          BackupPcUI.c(this.jEP).setText(2131297326);
          BackupPcUI.d(this.jEP).setVisibility(4);
          BackupPcUI.e(this.jEP).setVisibility(4);
          BackupPcUI.f(this.jEP).setVisibility(4);
          aUj();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3
 * JD-Core Version:    0.7.0.1
 */