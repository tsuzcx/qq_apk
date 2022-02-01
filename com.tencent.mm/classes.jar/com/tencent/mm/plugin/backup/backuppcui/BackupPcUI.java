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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class BackupPcUI
  extends MMWizardActivity
{
  private static boolean iFP = false;
  private TextView gzg;
  private TextView mWr;
  private TextView mWs;
  private TextView mWt;
  private TextView mWu;
  private ImageView mWv;
  public b.c mYj;
  
  public BackupPcUI()
  {
    AppMethodBeat.i(21676);
    this.mYj = new b.c()
    {
      private void bEo()
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
      
      private void bEp()
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
      
      private void wV(int paramAnonymousInt)
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
      
      public final void bCN()
      {
        AppMethodBeat.i(21671);
        int i = b.bEa().bEb().mXv;
        ac.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onBackupPcStart, commandMode[%d]", new Object[] { Integer.valueOf(i) });
        switch (i)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(21671);
          return;
          b.bEa().bCP().mSk = 11;
          wJ(11);
          AppMethodBeat.o(21671);
          return;
          b.bEa().bCP().mSk = 21;
          wJ(21);
          AppMethodBeat.o(21671);
          return;
          b.bEa().bCP().mSk = 12;
          wJ(12);
          AppMethodBeat.o(21671);
          return;
          b.bEa().bCP().mSk = 22;
          wJ(22);
        }
      }
      
      public final void bCO() {}
      
      public final void wJ(int paramAnonymousInt)
      {
        AppMethodBeat.i(21672);
        int i = b.bEa().bEb().mXv;
        ac.i("MicroMsg.BackupPcUI", "onUpdateUIProgress backupPcState:%d, commandMode:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
        Object localObject = b.bEa().bCP();
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
          bEo();
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
          bEo();
          BackupPcUI.e(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21650);
              az.ayM();
              boolean bool = ((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GKQ, Boolean.FALSE)).booleanValue();
              ac.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onUpdateUIProgress startbackup all, hasMove:%s", new Object[] { Boolean.valueOf(bool) });
              if (bool)
              {
                com.tencent.mm.ui.base.h.a(BackupPcUI.this, 2131756216, 0, 2131756270, 0, false, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(21649);
                    b.bEa().bEb().wT(2);
                    b.bEa().bCP().mSk = 12;
                    BackupPcUI.3.this.wJ(12);
                    b.bEa().bEe().bDZ();
                    b.bEa().bEe().iv(true);
                    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(400L, 7L, 1L, false);
                    com.tencent.mm.plugin.report.service.h.wUl.f(13735, new Object[] { Integer.valueOf(9), Integer.valueOf(b.bEa().bEb().mXB) });
                    AppMethodBeat.o(21649);
                  }
                }, null, 2131099990);
                AppMethodBeat.o(21650);
                return;
              }
              b.bEa().bEb().wT(2);
              b.bEa().bCP().mSk = 12;
              BackupPcUI.3.this.wJ(12);
              b.bEa().bEe().cancel();
              b.bEa().bEe().bDZ();
              b.bEa().bEe().iv(true);
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(400L, 7L, 1L, false);
              com.tencent.mm.plugin.report.service.h.wUl.f(13735, new Object[] { Integer.valueOf(9), Integer.valueOf(b.bEa().bEb().mXB) });
              AppMethodBeat.o(21650);
            }
          });
          BackupPcUI.f(BackupPcUI.this).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(21661);
              paramAnonymous2View = new Intent(BackupPcUI.this, BackupPcChooseUI.class);
              MMWizardActivity.aj(BackupPcUI.this, paramAnonymous2View);
              b.bEa().bEe().cancel();
              b.bEa().bEe().bDZ();
              b.bEa().bEe().iv(false);
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
          bEp();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231107);
          TextView localTextView = BackupPcUI.c(BackupPcUI.this);
          BackupPcUI localBackupPcUI = BackupPcUI.this;
          paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).mSl;
          i = ((com.tencent.mm.plugin.backup.b.e)localObject).mSm;
          b.bEa().bEb();
          localTextView.setText(localBackupPcUI.getString(2131756249, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bEg() }));
          BackupPcUI.d(BackupPcUI.this).setText(2131756221);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099992));
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          bEp();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231106);
          BackupPcUI.c(BackupPcUI.this).setText(2131756180);
          BackupPcUI.d(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756181, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mSl), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mSm) }));
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
              b.bEa().bDz().stop();
              b.bEa().bEc().cancel(true);
              b.bEa().bCP().mSk = -100;
              BackupPcUI.g(BackupPcUI.this);
              AppMethodBeat.o(21662);
            }
          });
          bEo();
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
              com.tencent.mm.plugin.report.service.h.wUl.f(13735, new Object[] { Integer.valueOf(23), Integer.valueOf(b.bEa().bEb().mXB) });
              b.bEa().bEb().wT(4);
              b.bEa().bCP().mSk = 22;
              BackupPcUI.3.this.wJ(22);
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(400L, 16L, 1L, false);
              AppMethodBeat.o(21663);
            }
          });
          bEo();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231110);
          BackupPcUI.c(BackupPcUI.this).setText(2131756220);
          BackupPcUI.d(BackupPcUI.this).setText(2131756221);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099992));
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          bEp();
          AppMethodBeat.o(21672);
          return;
          BackupPcUI.b(BackupPcUI.this).setImageResource(2131231110);
          localTextView = BackupPcUI.c(BackupPcUI.this);
          localBackupPcUI = BackupPcUI.this;
          paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).mSl;
          i = ((com.tencent.mm.plugin.backup.b.e)localObject).mSm;
          b.bEa().bEb();
          localTextView.setText(localBackupPcUI.getString(2131756232, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bEg() }));
          BackupPcUI.d(BackupPcUI.this).setText(2131756221);
          BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099992));
          BackupPcUI.d(BackupPcUI.this).setVisibility(0);
          BackupPcUI.e(BackupPcUI.this).setVisibility(4);
          BackupPcUI.f(BackupPcUI.this).setVisibility(4);
          bEp();
          AppMethodBeat.o(21672);
          return;
          if (bs.iX(BackupPcUI.this))
          {
            b.bEa().bCP().mSk = 24;
            paramAnonymousInt = 24;
            break;
            if (BackupPcUI.bEn())
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
                  ac.i("MicroMsg.BackupPcUI", "onUpdateUIProgress user click start merge.");
                  b.bEa().bEd();
                  if (!d.bDD())
                  {
                    b.bEa().bEd();
                    if (!d.bDD())
                    {
                      b.bEa().bCP().mSk = -22;
                      BackupPcUI.3.this.wJ(-22);
                      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(400L, 64L, 1L, false);
                      AppMethodBeat.o(21664);
                      return;
                    }
                  }
                  com.tencent.mm.plugin.report.service.h.wUl.f(13735, new Object[] { Integer.valueOf(27), Integer.valueOf(b.bEa().bEb().mXB) });
                  b.bEa().bEd().bEk();
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
                      ac.i("MicroMsg.BackupPcUI", "user click close. stop recover merge.");
                      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(400L, 26L, 1L, false);
                      b.bEa().bDz().stop();
                      b.bEa().bEd().b(true, true, -100);
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
                  b.bEa().bCP().mSk = 25;
                  BackupPcUI.i(BackupPcUI.this);
                  AppMethodBeat.o(21667);
                }
              });
              AppMethodBeat.o(21672);
              return;
            }
            if (bs.iX(BackupPcUI.this))
            {
              b.bEa().bEd();
              if (!d.bDD())
              {
                b.bEa().bCP().mSk = -22;
                wJ(-22);
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(400L, 64L, 1L, false);
                AppMethodBeat.o(21672);
                return;
              }
              b.bEa().bEd().bEk();
              AppMethodBeat.o(21672);
              return;
              BackupPcUI.b(BackupPcUI.this).setImageResource(2131231110);
              BackupPcUI.c(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756227, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mSn) }));
              BackupPcUI.d(BackupPcUI.this).setText(2131756226);
              BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099992));
              BackupPcUI.h(BackupPcUI.this).setText(2131756231);
              BackupPcUI.d(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              bEo();
              AppMethodBeat.o(21672);
              return;
              BackupPcUI.b(BackupPcUI.this).setImageResource(2131689735);
              BackupPcUI.c(BackupPcUI.this).setText(2131756252);
              BackupPcUI.d(BackupPcUI.this).setText(2131756153);
              BackupPcUI.d(BackupPcUI.this).setTextColor(BackupPcUI.this.getResources().getColor(2131099992));
              BackupPcUI.d(BackupPcUI.this).setVisibility(0);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              bEo();
              AppMethodBeat.o(21672);
              return;
              BackupPcUI.b(BackupPcUI.this).setImageResource(2131231109);
              BackupPcUI.c(BackupPcUI.this).setText(2131756224);
              BackupPcUI.d(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756225, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mSl), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mSm) }));
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
                  b.bEa().bDz().stop();
                  b.bEa().bCP().mSk = -100;
                  BackupPcUI.j(BackupPcUI.this);
                  AppMethodBeat.o(21668);
                }
              });
              bEo();
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
                bEp();
                AppMethodBeat.o(21672);
                return;
                BackupPcUI.b(BackupPcUI.this).setImageResource(2131231107);
                localTextView = BackupPcUI.c(BackupPcUI.this);
                localBackupPcUI = BackupPcUI.this;
                paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).mSl;
                i = ((com.tencent.mm.plugin.backup.b.e)localObject).mSm;
                b.bEa().bEb();
                localTextView.setText(localBackupPcUI.getString(2131756249, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bEg() }));
                continue;
                BackupPcUI.b(BackupPcUI.this).setImageResource(2131231110);
                localTextView = BackupPcUI.c(BackupPcUI.this);
                localBackupPcUI = BackupPcUI.this;
                paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).mSl;
                i = ((com.tencent.mm.plugin.backup.b.e)localObject).mSm;
                b.bEa().bEb();
                localTextView.setText(localBackupPcUI.getString(2131756232, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bEg() }));
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
                bEp();
                AppMethodBeat.o(21672);
                return;
                BackupPcUI.b(BackupPcUI.this).setImageResource(2131231107);
                localTextView = BackupPcUI.c(BackupPcUI.this);
                localBackupPcUI = BackupPcUI.this;
                paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).mSl;
                i = ((com.tencent.mm.plugin.backup.b.e)localObject).mSm;
                b.bEa().bEb();
                localTextView.setText(localBackupPcUI.getString(2131756249, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bEg() }));
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
                        ac.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
                        b.bEa().bDz().stop();
                        b.bEa().bEc().cancel(true);
                        b.bEa().bCP().mSk = -100;
                        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(400L, 52L, 1L, false);
                        b.bEa().bEc().wU(4);
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
                paramAnonymousInt = ((com.tencent.mm.plugin.backup.b.e)localObject).mSl;
                i = ((com.tencent.mm.plugin.backup.b.e)localObject).mSm;
                b.bEa().bEb();
                localTextView.setText(localBackupPcUI.getString(2131756232, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), com.tencent.mm.plugin.backup.backuppcmodel.c.bEg() }));
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
                        ac.i("MicroMsg.BackupPcUI", "user click close. stop recover.");
                        b.bEa().bDz().stop();
                        b.bEa().bEd().b(true, true, -100);
                        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(400L, 52L, 1L, false);
                        b.bEa().bEd().wU(4);
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
                BackupPcUI.c(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756249, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mSl), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mSm), "0M" }));
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
                        ac.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
                        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(400L, 10L, 1L, false);
                        b.bEa().bEc().wU(4);
                        b.bEa().bDz().stop();
                        b.bEa().bEc().cancel(true);
                        b.bEa().bCP().mSk = -100;
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
                bEp();
                AppMethodBeat.o(21672);
                return;
                if ((2 == i) || (4 == i))
                {
                  BackupPcUI.b(BackupPcUI.this).setImageResource(2131231108);
                  BackupPcUI.c(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756232, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mSl), Integer.valueOf(((com.tencent.mm.plugin.backup.b.e)localObject).mSm), "0M" }));
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
                          ac.i("MicroMsg.BackupPcUI", "user click close. stop recover.");
                          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(400L, 18L, 1L, false);
                          b.bEa().bEd().wU(4);
                          b.bEa().bDz().stop();
                          b.bEa().bEd().b(true, true, -100);
                          AppMethodBeat.o(21655);
                        }
                      }, null, 2131099991);
                      AppMethodBeat.o(21656);
                    }
                  });
                }
              }
              wV(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756209);
              localObject = com.tencent.mm.plugin.backup.b.g.eh(BackupPcUI.this);
              if ((localObject == null) || (((String)localObject).equals(""))) {
                BackupPcUI.d(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756210, new Object[] { b.bEa().bEb().mXw, "移动网络" }));
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
                bEo();
                AppMethodBeat.o(21672);
                return;
                BackupPcUI.d(BackupPcUI.this).setText(BackupPcUI.this.getString(2131756210, new Object[] { b.bEa().bEb().mXw, localObject }));
              }
              wV(i);
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
              bEo();
              AppMethodBeat.o(21672);
              return;
              wV(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756199);
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              bEo();
              AppMethodBeat.o(21672);
              return;
              wV(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756211);
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              bEo();
              AppMethodBeat.o(21672);
              return;
              wV(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756208);
              b.bEa().bDz().stop();
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              bEo();
              AppMethodBeat.o(21672);
              return;
              wV(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756203);
              b.bEa().bDz().stop();
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              bEo();
              AppMethodBeat.o(21672);
              return;
              wV(i);
              BackupPcUI.c(BackupPcUI.this).setText(2131756200);
              BackupPcUI.d(BackupPcUI.this).setVisibility(4);
              BackupPcUI.e(BackupPcUI.this).setVisibility(4);
              BackupPcUI.f(BackupPcUI.this).setVisibility(4);
              bEo();
            }
          }
        }
      }
    };
    AppMethodBeat.o(21676);
  }
  
  private void bDT()
  {
    AppMethodBeat.i(21684);
    int i = b.bEa().bCP().mSk;
    int j = b.bEa().bEb().mXv;
    ac.i("MicroMsg.BackupPcUI", "closeImpl, backupPcState:%d, commandMode:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
        ZA(1);
        AppMethodBeat.o(21684);
        return;
        ac.i("MicroMsg.BackupPcUI", "closeImpl backup finish, user click close.");
        bEm();
        AppMethodBeat.o(21684);
        return;
        if ((1 == j) || (3 == j))
        {
          b.bEa().bEc().cancel(false);
          b.bEa().bCP().mSk = -100;
        }
        else
        {
          if ((2 == j) || (4 == j))
          {
            b.bEa().bEd().b(false, false, -100);
            AppMethodBeat.o(21684);
            return;
          }
          b.bEa().bCP().mSk = -100;
          continue;
          ac.i("MicroMsg.BackupPcUI", "closeImpl recover finish, user click close.");
          bEm();
          AppMethodBeat.o(21684);
          return;
          b.bEa().bCP().mSk = 25;
        }
      }
    }
    com.tencent.mm.ui.base.h.a(this, 2131756195, 2131756194, 2131756246, 2131756090, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(21648);
        ac.i("MicroMsg.BackupPcUI", "closeImpl merging user click close. stop recover merge.");
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(400L, 26L, 1L, false);
        b.bEa().bDz().stop();
        b.bEa().bEd().b(true, true, -100);
        AppMethodBeat.o(21648);
      }
    }, null, 2131099991);
    AppMethodBeat.o(21684);
  }
  
  private void bEm()
  {
    AppMethodBeat.i(21685);
    ac.i("MicroMsg.BackupPcUI", "exitBackupPc.");
    if ((1 == b.bEa().bEb().mXv) || (3 == b.bEa().bEb().mXv))
    {
      b.bEa().bEe().cancel();
      b.bEa().bEe().bDZ();
      b.bEa().bEc().cancel(true);
      b.bEa().bDz().stop();
      b.bEa().bCP().mSk = -100;
      ZA(1);
      AppMethodBeat.o(21685);
      return;
    }
    if ((2 == b.bEa().bEb().mXv) || (4 == b.bEa().bEb().mXv))
    {
      b.bEa().bEd().b(true, true, -100);
      b.bEa().bDz().stop();
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
    this.gzg = ((TextView)findViewById(2131297053));
    this.mWv = ((ImageView)findViewById(2131297054));
    this.mWt = ((TextView)findViewById(2131297063));
    this.mWu = ((TextView)findViewById(2131297062));
    this.mWr = ((TextView)findViewById(2131297034));
    this.mWs = ((TextView)findViewById(2131297033));
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
    ac.i("MicroMsg.BackupPcUI", "onCreate.");
    getSupportActionBar().hide();
    com.tencent.mm.plugin.backup.a.iyx.Lm();
    initView();
    if (b.bEa().bEb().mXC)
    {
      b.bEa().bEb().mXC = false;
      final int i = com.tencent.mm.plugin.backup.b.g.bDf();
      if (i < 50)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(400L, 4L, 1L, false);
        com.tencent.mm.plugin.report.service.h.wUl.f(13736, new Object[] { Integer.valueOf(4), b.bEa().bEb().mXw, com.tencent.mm.plugin.backup.b.g.eh(this), Integer.valueOf(0), Integer.valueOf(b.bEa().bEb().mXB) });
        com.tencent.mm.ui.base.h.a(this, 2131756202, 2131756201, 2131756270, 0, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(21647);
            ac.i("MicroMsg.BackupPcUI", "low battery, user click sure. battery:%d", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(21647);
          }
        }, null, 2131099990);
      }
    }
    if (((k)com.tencent.mm.kernel.g.ab(k.class)).axd().dcw()) {
      bi.ayY();
    }
    AppMethodBeat.o(21677);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21682);
    ac.i("MicroMsg.BackupPcUI", "onDestroy. stack:%s", new Object[] { bs.eWi() });
    super.onDestroy();
    AppMethodBeat.o(21682);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21683);
    if (paramInt == 4)
    {
      bDT();
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
    ac.i("MicroMsg.BackupPcUI", "onPause.");
    Object localObject1 = b.bEa().bEc();
    b.c localc = this.mYj;
    synchronized (((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).mXH)
    {
      ((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).mXH.remove(localc);
      localObject1 = b.bEa().bEd();
      localc = this.mYj;
    }
    synchronized (((d)localObject1).mXH)
    {
      ((d)localObject1).mXH.remove(localc);
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
    ac.i("MicroMsg.BackupPcUI", "onResume.");
    Object localObject1 = b.bEa().bEc();
    b.c localc = this.mYj;
    synchronized (((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).mXH)
    {
      ((com.tencent.mm.plugin.backup.backuppcmodel.e)localObject1).mXH.add(localc);
      localObject1 = b.bEa().bEd();
      localc = this.mYj;
    }
    synchronized (((d)localObject1).mXH)
    {
      ((d)localObject1).mXH.add(localc);
      int i = b.bEa().bCP().mSk;
      this.mYj.wJ(i);
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
    ac.i("MicroMsg.BackupPcUI", "onStart.");
    iFP = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
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