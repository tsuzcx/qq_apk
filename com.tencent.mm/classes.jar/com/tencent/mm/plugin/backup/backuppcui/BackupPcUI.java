package com.tencent.mm.plugin.backup.backuppcui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.backup.b.b.c;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.d;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class BackupPcUI
  extends MMWizardActivity
{
  private static boolean ifG = false;
  private TextView mup;
  private TextView muq;
  private TextView mur;
  private TextView mus;
  private TextView mut;
  private ImageView muu;
  public b.c mwi;
  
  public BackupPcUI()
  {
    AppMethodBeat.i(21676);
    this.mwi = new b.c()
    {
      private void bxs()
      {
        AppMethodBeat.i(21674);
        BackupPcUI.h(BackupPcUI.this).setText(2131756095);
        BackupPcUI.h(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymous2View)
          {
            AppMethodBeat.i(21659);
            BackupPcUI.n(BackupPcUI.this);
            AppMethodBeat.o(21659);
          }
        });
        AppMethodBeat.o(21674);
      }
      
      private void bxt()
      {
        AppMethodBeat.i(21675);
        BackupPcUI.h(BackupPcUI.this).setText(2131756097);
        BackupPcUI.h(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymous2View)
          {
            AppMethodBeat.i(21660);
            BackupPcUI.o(BackupPcUI.this);
            AppMethodBeat.o(21660);
          }
        });
        AppMethodBeat.o(21675);
      }
      
      private void we(int paramAnonymousInt)
      {
        AppMethodBeat.i(21673);
        if ((2 == paramAnonymousInt) || (4 == paramAnonymousInt))
        {
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231108);
          AppMethodBeat.o(21673);
          return;
        }
        BackupPcUI.b(BackupPcUI.this).setImageResource(2131231105);
        AppMethodBeat.o(21673);
      }
      
      public final void bvR()
      {
        AppMethodBeat.i(21671);
        int i = b.bxe().bxf().mvu;
        ad.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onBackupPcStart, commandMode[%d]", new Object[] { Integer.valueOf(i) });
        switch (i)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(21671);
          return;
          b.bxe().bvT().mqj = 11;
          vS(11);
          AppMethodBeat.o(21671);
          return;
          b.bxe().bvT().mqj = 21;
          vS(21);
          AppMethodBeat.o(21671);
          return;
          b.bxe().bvT().mqj = 12;
          vS(12);
          AppMethodBeat.o(21671);
          return;
          b.bxe().bvT().mqj = 22;
          vS(22);
        }
      }
      
      public final void bvS() {}
      
      public final void vS(int paramAnonymousInt)
      {
        AppMethodBeat.i(21672);
        int i = b.bxe().bxf().mvu;
        ad.i("MicroMsg.BackupPcUI", "onUpdateUIProgress backupPcState:%d, commandMode:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
        Object localObject = b.bxe().bvT();
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.a(BackupPcUI.this);
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231107);
          BackupPcUI.c(BackupPcUI.this).setText(2131756189);
          BackupPcUI.d(BackupPcUI.this).setVisibility(4);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          bxs();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231107);
          BackupPcUI.c(BackupPcUI.this).setText(2131756244);
          BackupPcUI.d(BackupPcUI.this).setText(2131756243);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099992));
          BackupPcUI.e(BackupPcUI.this).setText(2131756241);
          BackupPcUI.f(BackupPcUI.this).setText(2131756242);
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(0);
          BackupPcUI.f(BackupPcUI.this).setVisibility(0);
          bxs();
          BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21650);
              az.arV();
              boolean bool = ((Boolean)com.tencent.mm.model.c.afk().get(ae.a.Fnb, Boolean.FALSE)).booleanValue();
              ad.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onUpdateUIProgress startbackup all, hasMove:%s", new Object[] { Boolean.valueOf(bool) });
              if (bool)
              {
                com.tencent.mm.ui.base.h.a(BackupPcUI.this, 2131756216, 0, 2131756270, 0, false, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(21649);
                    b.bxe().bxf().wc(2);
                    b.bxe().bvT().mqj = 12;
                    BackupPcUI.3.this.vS(12);
                    b.bxe().bxi().bxd();
                    b.bxe().bxi().hV(true);
                    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(400L, 7L, 1L, false);
                    com.tencent.mm.plugin.report.service.h.vKh.f(13735, new Object[] { Integer.valueOf(9), Integer.valueOf(b.bxe().bxf().mvA) });
                    AppMethodBeat.o(21649);
                  }
                }, null, 2131099990);
                AppMethodBeat.o(21650);
                return;
              }
              b.bxe().bxf().wc(2);
              b.bxe().bvT().mqj = 12;
              BackupPcUI.3.this.vS(12);
              b.bxe().bxi().cancel();
              b.bxe().bxi().bxd();
              b.bxe().bxi().hV(true);
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(400L, 7L, 1L, false);
              com.tencent.mm.plugin.report.service.h.vKh.f(13735, new Object[] { Integer.valueOf(9), Integer.valueOf(b.bxe().bxf().mvA) });
              AppMethodBeat.o(21650);
            }
          });
          BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21661);
              paramAnonymous2View = new Intent(BackupPcUI.this, BackupPcChooseUI.class);
              MMWizardActivity.V(BackupPcUI.this, paramAnonymous2View);
              b.bxe().bxi().cancel();
              b.bxe().bxi().bxd();
              b.bxe().bxi().hV(false);
              AppMethodBeat.o(21661);
            }
          });
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231107);
          BackupPcUI.c(BackupPcUI.this).setText(2131756220);
          BackupPcUI.d(BackupPcUI.this).setText(2131756221);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099992));
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          bxt();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231107);
          TextView localTextView = BackupPcUI.c(BackupPcUI.this);
          BackupPcUI localBackupPcUI = BackupPcUI.this;
          paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).mqk;
          i = ((com.tencent.mm.plugin.backup.b.e)localObject).mql;
          b.bxe().bxf();
          localTextView.setText(localBackupPcUI.getString(2131756249, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bxk() }));
          BackupPcUI.d(BackupPcUI.this).setText(2131756221);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099992));
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          bxt();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231106);
          BackupPcUI.c(BackupPcUI.this).setText(2131756180);
          BackupPcUI.d(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756181, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mqk), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mql) }));
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099992));
          BackupPcUI.e(BackupPcUI.this).setText(2131756096);
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(0);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21662);
              b.bxe().bwD().stop();
              b.bxe().bxg().cancel(true);
              b.bxe().bvT().mqj = -100;
              BackupPcUI.g(BackupPcUI.this);
              AppMethodBeat.o(21662);
            }
          });
          bxs();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231110);
          BackupPcUI.c(BackupPcUI.this).setText(2131756230);
          BackupPcUI.e(BackupPcUI.this).setText(2131756229);
          BackupPcUI.d(BackupPcUI.this).setVisibility(4);
          BackupPcUI.e(BackupPcUI.this).setVisibility(0);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21663);
              com.tencent.mm.plugin.report.service.h.vKh.f(13735, new Object[] { Integer.valueOf(23), Integer.valueOf(b.bxe().bxf().mvA) });
              b.bxe().bxf().wc(4);
              b.bxe().bvT().mqj = 22;
              BackupPcUI.3.this.vS(22);
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(400L, 16L, 1L, false);
              AppMethodBeat.o(21663);
            }
          });
          bxs();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231110);
          BackupPcUI.c(BackupPcUI.this).setText(2131756220);
          BackupPcUI.d(BackupPcUI.this).setText(2131756221);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099992));
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          bxt();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231110);
          localTextView = BackupPcUI.c(BackupPcUI.this);
          localBackupPcUI = BackupPcUI.this;
          paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).mqk;
          i = ((com.tencent.mm.plugin.backup.b.e)localObject).mql;
          b.bxe().bxf();
          localTextView.setText(localBackupPcUI.getString(2131756232, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bxk() }));
          BackupPcUI.d(BackupPcUI.this).setText(2131756221);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099992));
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          bxt();
          AppMethodBeat.o(21672);
          return;
          if (bt.iM(BackupPcUI.this))
          {
            b.bxe().bvT().mqj = 24;
            paramAnonymousInt = 24;
            break;
            if (BackupPcUI.bxr())
            {
              BackupPcUI.b(BackupPcUI.this).setImageResource(2131231110);
              BackupPcUI.c(BackupPcUI.this).setText(2131756233);
              BackupPcUI.d(BackupPcUI.this).setText(2131756235);
              BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099992));
              BackupPcUI.e(BackupPcUI.this).setText(2131756228);
              BackupPcUI.f(BackupPcUI.this).setText(2131756231);
              BackupPcUI.h(BackupPcUI.this).setText(2131756253);
              BackupPcUI.d(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setVisibility(0);
              BackupPcUI.f(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21664);
                  ad.i("MicroMsg.BackupPcUI", "onUpdateUIProgress user click start merge.");
                  b.bxe().bxh();
                  if (!d.bwH())
                  {
                    b.bxe().bxh();
                    if (!d.bwH())
                    {
                      b.bxe().bvT().mqj = -22;
                      BackupPcUI.3.this.vS(-22);
                      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(400L, 64L, 1L, false);
                      AppMethodBeat.o(21664);
                      return;
                    }
                  }
                  com.tencent.mm.plugin.report.service.h.vKh.f(13735, new Object[] { Integer.valueOf(27), Integer.valueOf(b.bxe().bxf().mvA) });
                  b.bxe().bxh().bxo();
                  AppMethodBeat.o(21664);
                }
              });
              BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21666);
                  com.tencent.mm.ui.base.h.a(BackupPcUI.this, 2131756195, 2131756194, 2131756246, 2131756090, false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(21665);
                      ad.i("MicroMsg.BackupPcUI", "user click close. stop recover merge.");
                      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(400L, 26L, 1L, false);
                      b.bxe().bwD().stop();
                      b.bxe().bxh().b(true, true, -100);
                      AppMethodBeat.o(21665);
                    }
                  }, null, 2131099991);
                  AppMethodBeat.o(21666);
                }
              });
              BackupPcUI.h(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21667);
                  b.bxe().bvT().mqj = 25;
                  BackupPcUI.i(BackupPcUI.this);
                  AppMethodBeat.o(21667);
                }
              });
              AppMethodBeat.o(21672);
              return;
            }
            if (bt.iM(BackupPcUI.this))
            {
              b.bxe().bxh();
              if (!d.bwH())
              {
                b.bxe().bvT().mqj = -22;
                vS(-22);
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(400L, 64L, 1L, false);
                AppMethodBeat.o(21672);
                return;
              }
              b.bxe().bxh().bxo();
              AppMethodBeat.o(21672);
              return;
              BackupPcUI.b(BackupPcUI.this).setImageResource(2131231110);
              BackupPcUI.c(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756227, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mqm) }));
              BackupPcUI.d(BackupPcUI.this).setText(2131756226);
              BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099992));
              BackupPcUI.h(BackupPcUI.this).setText(2131756231);
              BackupPcUI.d(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              bxs();
              AppMethodBeat.o(21672);
              return;
              BackupPcUI.b(BackupPcUI.this).setImageResource(2131689735);
              BackupPcUI.c(BackupPcUI.this).setText(2131756252);
              BackupPcUI.d(BackupPcUI.this).setText(2131756153);
              BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099992));
              BackupPcUI.d(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              bxs();
              AppMethodBeat.o(21672);
              return;
              BackupPcUI.b(BackupPcUI.this).setImageResource(2131231109);
              BackupPcUI.c(BackupPcUI.this).setText(2131756224);
              BackupPcUI.d(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756225, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mqk), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mql) }));
              BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099992));
              BackupPcUI.e(BackupPcUI.this).setText(2131756096);
              BackupPcUI.d(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setVisibility(0);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21668);
                  b.bxe().bwD().stop();
                  b.bxe().bvT().mqj = -100;
                  BackupPcUI.j(BackupPcUI.this);
                  AppMethodBeat.o(21668);
                }
              });
              bxs();
              AppMethodBeat.o(21672);
              return;
              switch (i)
              {
              }
              for (;;)
              {
                BackupPcUI.d(BackupPcUI.this).setText(2131756251);
                BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099991));
                BackupPcUI.d(BackupPcUI.this).setVisibility(0);
                BackupPcUI.e(BackupPcUI.this).setVisibility(4);
                BackupPcUI.f(BackupPcUI.this).setVisibility(4);
                bxt();
                AppMethodBeat.o(21672);
                return;
                BackupPcUI.b(BackupPcUI.this).setImageResource(2131231107);
                localTextView = BackupPcUI.c(BackupPcUI.this);
                localBackupPcUI = BackupPcUI.this;
                paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).mqk;
                i = ((com.tencent.mm.plugin.backup.b.e)localObject).mql;
                b.bxe().bxf();
                localTextView.setText(localBackupPcUI.getString(2131756249, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bxk() }));
                continue;
                BackupPcUI.b(BackupPcUI.this).setImageResource(2131231110);
                localTextView = BackupPcUI.c(BackupPcUI.this);
                localBackupPcUI = BackupPcUI.this;
                paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).mqk;
                i = ((com.tencent.mm.plugin.backup.b.e)localObject).mql;
                b.bxe().bxf();
                localTextView.setText(localBackupPcUI.getString(2131756232, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bxk() }));
              }
              switch (i)
              {
              }
              for (;;)
              {
                BackupPcUI.d(BackupPcUI.this).setText(2131756250);
                BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099991));
                BackupPcUI.d(BackupPcUI.this).setVisibility(0);
                BackupPcUI.e(BackupPcUI.this).setVisibility(4);
                BackupPcUI.f(BackupPcUI.this).setVisibility(0);
                bxt();
                AppMethodBeat.o(21672);
                return;
                BackupPcUI.b(BackupPcUI.this).setImageResource(2131231107);
                localTextView = BackupPcUI.c(BackupPcUI.this);
                localBackupPcUI = BackupPcUI.this;
                paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).mqk;
                i = ((com.tencent.mm.plugin.backup.b.e)localObject).mql;
                b.bxe().bxf();
                localTextView.setText(localBackupPcUI.getString(2131756249, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bxk() }));
                BackupPcUI.f(BackupPcUI.this).setText(2131756245);
                BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(21670);
                    com.tencent.mm.ui.base.h.a(BackupPcUI.this, 2131756193, 2131756192, 2131756245, 2131756090, false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                      {
                        AppMethodBeat.i(21669);
                        ad.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
                        b.bxe().bwD().stop();
                        b.bxe().bxg().cancel(true);
                        b.bxe().bvT().mqj = -100;
                        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(400L, 52L, 1L, false);
                        b.bxe().bxg().wd(4);
                        BackupPcUI.k(BackupPcUI.this);
                        AppMethodBeat.o(21669);
                      }
                    }, null, 2131099991);
                    AppMethodBeat.o(21670);
                  }
                });
                continue;
                BackupPcUI.b(BackupPcUI.this).setImageResource(2131231110);
                localTextView = BackupPcUI.c(BackupPcUI.this);
                localBackupPcUI = BackupPcUI.this;
                paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).mqk;
                i = ((com.tencent.mm.plugin.backup.b.e)localObject).mql;
                b.bxe().bxf();
                localTextView.setText(localBackupPcUI.getString(2131756232, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bxk() }));
                BackupPcUI.f(BackupPcUI.this).setText(2131756247);
                BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(21652);
                    com.tencent.mm.ui.base.h.a(BackupPcUI.this, 2131756195, 2131756194, 2131756246, 2131756090, false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                      {
                        AppMethodBeat.i(21651);
                        ad.i("MicroMsg.BackupPcUI", "user click close. stop recover.");
                        b.bxe().bwD().stop();
                        b.bxe().bxh().b(true, true, -100);
                        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(400L, 52L, 1L, false);
                        b.bxe().bxh().wd(4);
                        AppMethodBeat.o(21651);
                      }
                    }, null, 2131099991);
                    AppMethodBeat.o(21652);
                  }
                });
              }
              if ((1 == i) || (3 == i))
              {
                BackupPcUI.b(BackupPcUI.this).setImageResource(2131231105);
                BackupPcUI.c(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756249, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mqk), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mql), "0M" }));
                BackupPcUI.d(BackupPcUI.this).setText(2131756204);
                BackupPcUI.f(BackupPcUI.this).setText(2131756245);
                BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(21654);
                    com.tencent.mm.ui.base.h.a(BackupPcUI.this, 2131756193, 2131756192, 2131756245, 2131756090, false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                      {
                        AppMethodBeat.i(21653);
                        ad.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
                        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(400L, 10L, 1L, false);
                        b.bxe().bxg().wd(4);
                        b.bxe().bwD().stop();
                        b.bxe().bxg().cancel(true);
                        b.bxe().bvT().mqj = -100;
                        BackupPcUI.l(BackupPcUI.this);
                        AppMethodBeat.o(21653);
                      }
                    }, null, 2131099991);
                    AppMethodBeat.o(21654);
                  }
                });
              }
              for (;;)
              {
                BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099991));
                BackupPcUI.d(BackupPcUI.this).setVisibility(0);
                BackupPcUI.e(BackupPcUI.this).setVisibility(4);
                BackupPcUI.f(BackupPcUI.this).setVisibility(0);
                bxt();
                AppMethodBeat.o(21672);
                return;
                if ((2 == i) || (4 == i))
                {
                  BackupPcUI.b(BackupPcUI.this).setImageResource(2131231108);
                  BackupPcUI.c(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756232, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mqk), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mql), "0M" }));
                  BackupPcUI.d(BackupPcUI.this).setText(2131756212);
                  BackupPcUI.f(BackupPcUI.this).setText(2131756247);
                  BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymous2View)
                    {
                      AppMethodBeat.i(21656);
                      com.tencent.mm.ui.base.h.a(BackupPcUI.this, 2131756195, 2131756194, 2131756246, 2131756090, false, new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                        {
                          AppMethodBeat.i(21655);
                          ad.i("MicroMsg.BackupPcUI", "user click close. stop recover.");
                          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(400L, 18L, 1L, false);
                          b.bxe().bxh().wd(4);
                          b.bxe().bwD().stop();
                          b.bxe().bxh().b(true, true, -100);
                          AppMethodBeat.o(21655);
                        }
                      }, null, 2131099991);
                      AppMethodBeat.o(21656);
                    }
                  });
                }
              }
              we(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756209);
              localObject = com.tencent.mm.plugin.backup.b.g.dZ(BackupPcUI.this);
              if ((localObject == null) || (((String)localObject).equals(""))) {
                BackupPcUI.d(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756210, new Object[] { b.bxe().bxf().mvv, "移动网络" }));
              }
              for (;;)
              {
                BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099991));
                BackupPcUI.f(BackupPcUI.this).setText(2131756214);
                BackupPcUI.d(BackupPcUI.this).setVisibility(0);
                BackupPcUI.e(BackupPcUI.this).setVisibility(4);
                BackupPcUI.f(BackupPcUI.this).setVisibility(0);
                BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(21657);
                    BackupPcUI.m(BackupPcUI.this);
                    AppMethodBeat.o(21657);
                  }
                });
                bxs();
                AppMethodBeat.o(21672);
                return;
                BackupPcUI.d(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756210, new Object[] { b.bxe().bxf().mvv, localObject }));
              }
              we(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756198);
              BackupPcUI.f(BackupPcUI.this).setText(2131756214);
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(0);
              BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(21658);
                  BackupPcUI.m(BackupPcUI.this);
                  AppMethodBeat.o(21658);
                }
              });
              bxs();
              AppMethodBeat.o(21672);
              return;
              we(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756199);
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              bxs();
              AppMethodBeat.o(21672);
              return;
              we(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756211);
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              bxs();
              AppMethodBeat.o(21672);
              return;
              we(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756208);
              b.bxe().bwD().stop();
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              bxs();
              AppMethodBeat.o(21672);
              return;
              we(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756203);
              b.bxe().bwD().stop();
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              bxs();
              AppMethodBeat.o(21672);
              return;
              we(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756200);
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              bxs();
            }
          }
        }
      }
    };
    AppMethodBeat.o(21676);
  }
  
  private void bwX()
  {
    AppMethodBeat.i(21684);
    int i = b.bxe().bvT().mqj;
    int j = b.bxe().bxf().mvu;
    ad.i("MicroMsg.BackupPcUI", "closeImpl, backupPcState:%d, commandMode:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    switch (i)
    {
    default: 
    case 15: 
    case -22: 
    case -21: 
    case -13: 
    case -5: 
    case -3: 
    case -2: 
    case -1: 
    case 1: 
    case 11: 
    case 21: 
    case 27: 
    case 24: 
      for (;;)
      {
        Xo(1);
        AppMethodBeat.o(21684);
        return;
        ad.i("MicroMsg.BackupPcUI", "closeImpl backup finish, user click close.");
        bxq();
        AppMethodBeat.o(21684);
        return;
        if ((1 == j) || (3 == j))
        {
          b.bxe().bxg().cancel(false);
          b.bxe().bvT().mqj = -100;
        }
        else
        {
          if ((2 == j) || (4 == j))
          {
            b.bxe().bxh().b(false, false, -100);
            AppMethodBeat.o(21684);
            return;
          }
          b.bxe().bvT().mqj = -100;
          continue;
          ad.i("MicroMsg.BackupPcUI", "closeImpl recover finish, user click close.");
          bxq();
          AppMethodBeat.o(21684);
          return;
          b.bxe().bvT().mqj = 25;
        }
      }
    }
    com.tencent.mm.ui.base.h.a(this, 2131756195, 2131756194, 2131756246, 2131756090, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(21648);
        ad.i("MicroMsg.BackupPcUI", "closeImpl merging user click close. stop recover merge.");
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(400L, 26L, 1L, false);
        b.bxe().bwD().stop();
        b.bxe().bxh().b(true, true, -100);
        AppMethodBeat.o(21648);
      }
    }, null, 2131099991);
    AppMethodBeat.o(21684);
  }
  
  private void bxq()
  {
    AppMethodBeat.i(21685);
    ad.i("MicroMsg.BackupPcUI", "exitBackupPc.");
    if ((1 == b.bxe().bxf().mvu) || (3 == b.bxe().bxf().mvu))
    {
      b.bxe().bxi().cancel();
      b.bxe().bxi().bxd();
      b.bxe().bxg().cancel(true);
      b.bxe().bwD().stop();
      b.bxe().bvT().mqj = -100;
      Xo(1);
      AppMethodBeat.o(21685);
      return;
    }
    if ((2 == b.bxe().bxf().mvu) || (4 == b.bxe().bxf().mvu))
    {
      b.bxe().bxh().b(true, true, -100);
      b.bxe().bwD().stop();
    }
    AppMethodBeat.o(21685);
  }
  
  public int getLayoutId()
  {
    return 2131493131;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21681);
    this.mut = ((TextView)findViewById(2131297053));
    this.muu = ((ImageView)findViewById(2131297054));
    this.mur = ((TextView)findViewById(2131297063));
    this.mus = ((TextView)findViewById(2131297062));
    this.mup = ((TextView)findViewById(2131297034));
    this.muq = ((TextView)findViewById(2131297033));
    AppMethodBeat.o(21681);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21677);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false))
    {
      AppMethodBeat.o(21677);
      return;
    }
    ad.i("MicroMsg.BackupPcUI", "onCreate.");
    getSupportActionBar().hide();
    com.tencent.mm.plugin.backup.a.hYt.Lo();
    initView();
    if (b.bxe().bxf().mvB)
    {
      b.bxe().bxf().mvB = false;
      final int i = com.tencent.mm.plugin.backup.b.g.bwj();
      if (i < 50)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(400L, 4L, 1L, false);
        com.tencent.mm.plugin.report.service.h.vKh.f(13736, new Object[] { Integer.valueOf(4), b.bxe().bxf().mvv, com.tencent.mm.plugin.backup.b.g.dZ(this), Integer.valueOf(0), Integer.valueOf(b.bxe().bxf().mvA) });
        com.tencent.mm.ui.base.h.a(this, 2131756202, 2131756201, 2131756270, 0, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(21647);
            ad.i("MicroMsg.BackupPcUI", "low battery, user click sure. battery:%d", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(21647);
          }
        }, null, 2131099990);
      }
    }
    if (((k)com.tencent.mm.kernel.g.ab(k.class)).aqo().cON()) {
      bi.ash();
    }
    AppMethodBeat.o(21677);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21682);
    ad.i("MicroMsg.BackupPcUI", "onDestroy. stack:%s", new Object[] { bt.eGN() });
    super.onDestroy();
    AppMethodBeat.o(21682);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21683);
    if (paramInt == 4)
    {
      bwX();
      AppMethodBeat.o(21683);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(21683);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(21679);
    super.onPause();
    ad.i("MicroMsg.BackupPcUI", "onPause.");
    Object localObject1 = b.bxe().bxg();
    b.c localc = this.mwi;
    synchronized (((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).mvG)
    {
      ((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).mvG.remove(localc);
      localObject1 = b.bxe().bxh();
      localc = this.mwi;
    }
    synchronized (((d)localObject1).mvG)
    {
      ((d)localObject1).mvG.remove(localc);
      AppMethodBeat.o(21679);
      return;
      localObject2 = finally;
      AppMethodBeat.o(21679);
      throw localObject2;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(21680);
    super.onResume();
    ad.i("MicroMsg.BackupPcUI", "onResume.");
    Object localObject1 = b.bxe().bxg();
    b.c localc = this.mwi;
    synchronized (((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).mvG)
    {
      ((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).mvG.add(localc);
      localObject1 = b.bxe().bxh();
      localc = this.mwi;
    }
    synchronized (((d)localObject1).mvG)
    {
      ((d)localObject1).mvG.add(localc);
      int i = b.bxe().bvT().mqj;
      this.mwi.vS(i);
      AppMethodBeat.o(21680);
      return;
      localObject2 = finally;
      AppMethodBeat.o(21680);
      throw localObject2;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(21678);
    super.onStart();
    ad.i("MicroMsg.BackupPcUI", "onStart.");
    ifG = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
    AppMethodBeat.o(21678);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcUI
 * JD-Core Version:    0.7.0.1
 */