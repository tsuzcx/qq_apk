package com.tencent.mm.plugin.dbbackup;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.dbbackup.a.a.a;
import com.tencent.mm.plugin.dbbackup.a.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMActivity;

public class DBRecoveryUI
  extends MMActivity
  implements a.b
{
  private static final int[] phk = { 0, 5, 60, 75, 95, 100, 100 };
  private ProgressBar jqx;
  private View lEb;
  private int mScene;
  private com.tencent.mm.plugin.dbbackup.a.a phd;
  private View phe;
  private TextView phf;
  private View phg;
  private int phh;
  private boolean phi;
  private DialogInterface.OnClickListener phj;
  
  public DBRecoveryUI()
  {
    AppMethodBeat.i(23063);
    this.phj = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(23052);
        if (DBRecoveryUI.a(DBRecoveryUI.this) != 0)
        {
          DBRecoveryUI.b(DBRecoveryUI.this).setVisibility(0);
          DBRecoveryUI.c(DBRecoveryUI.this).setVisibility(8);
          AppMethodBeat.o(23052);
          return;
        }
        d.cbP();
        AppMethodBeat.o(23052);
      }
    };
    AppMethodBeat.o(23063);
  }
  
  private void cbG()
  {
    AppMethodBeat.i(23066);
    if (this.phd != null)
    {
      ad.e("MicroMsg.DBRecoveryUI", "Recovery task has already started.");
      AppMethodBeat.o(23066);
      return;
    }
    this.phe.setVisibility(8);
    this.lEb.setVisibility(0);
    this.phg.setEnabled(true);
    Object localObject1 = new StringBuilder().append(q.cH(true));
    com.tencent.mm.kernel.g.ajA();
    Object localObject2 = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.kernel.a.getUin().getBytes()).substring(0, 7).getBytes();
    localObject1 = com.tencent.mm.kernel.g.ajC().ajg();
    String str1 = com.tencent.mm.kernel.g.ajC().gBq.getPath();
    String str2 = str1 + "-recovery";
    this.phh = 0;
    String str3 = com.tencent.mm.kernel.g.ajC().gBm + "dbback/";
    a.a locala = new a.a();
    locala.pit = this;
    localObject2 = locala.aV((byte[])localObject2).aW((byte[])localObject2);
    ((a.a)localObject2).pir = new DBRecoveryUI.5(this);
    ((a.a)localObject2).pii = ((String)localObject1);
    ((a.a)localObject2).pih = str1;
    ((a.a)localObject2).pig = str2;
    ((a.a)localObject2).pij = (com.tencent.mm.kernel.g.ajC().cachePath + "heavyDetailInfo");
    if (this.mScene == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((a.a)localObject2).pis = bool;
      this.phd = ((a.a)localObject2).ZW((String)localObject1 + ".sm").ZX((String)localObject1 + ".bak").ZW(str3 + "corrupted/EnMicroMsg.db.sm").ZX(str3 + "corrupted/EnMicroMsg.db.bak").ZW(str3 + "EnMicroMsg.db.sm").ZX(str3 + "EnMicroMsg.db.bak").cbY();
      this.phd.execute(new Void[0]);
      this.phi = true;
      AppMethodBeat.o(23066);
      return;
    }
  }
  
  private void cbH()
  {
    AppMethodBeat.i(23067);
    this.phg.setEnabled(false);
    if (this.phd != null)
    {
      this.phd.cancel();
      this.phd = null;
      AppMethodBeat.o(23067);
      return;
    }
    ad.e("MicroMsg.DBRecoveryUI", "Recovery task is not running.");
    AppMethodBeat.o(23067);
  }
  
  private static void cbI()
  {
    AppMethodBeat.i(23073);
    ai localai = com.tencent.mm.kernel.g.ajC().ajl();
    localai.set(89, Integer.valueOf(2));
    localai.fqc();
    AppMethodBeat.o(23073);
  }
  
  public final void J(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(23069);
    this.phi = false;
    this.phd = null;
    cbI();
    com.tencent.mm.ui.base.h.a(this, getString(2131758000, new Object[] { Long.valueOf(paramLong2 / 1024L / 1024L), Long.valueOf(paramLong1 / 1024L / 1024L) }), null, false, this.phj);
    AppMethodBeat.o(23069);
  }
  
  public final void W(int paramInt1, int paramInt2, int paramInt3)
  {
    float f1 = 1.0F;
    AppMethodBeat.i(23068);
    if ((paramInt1 <= 0) || (paramInt1 > 6))
    {
      AppMethodBeat.o(23068);
      return;
    }
    int i;
    int j;
    float f2;
    if (paramInt3 > 0)
    {
      i = phk[(paramInt1 - 1)];
      j = phk[paramInt1];
      f2 = paramInt2 / paramInt3;
      if (f2 <= 1.0F) {
        break label163;
      }
    }
    for (;;)
    {
      f2 = i;
      paramInt3 = (int)(f1 * (j - i) + f2);
      this.jqx.setProgress(paramInt3);
      for (;;)
      {
        this.phh = paramInt1;
        String str = getResources().getStringArray(2130903045)[(paramInt1 - 1)];
        this.phf.setText(String.format(str, new Object[] { Integer.valueOf(paramInt2) }));
        AppMethodBeat.o(23068);
        return;
        if (this.phh != paramInt1) {
          this.jqx.setProgress(phk[(paramInt1 - 1)]);
        }
      }
      label163:
      f1 = f2;
    }
  }
  
  public int getLayoutId()
  {
    return 2131493684;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(23065);
    if (this.phi)
    {
      cbH();
      AppMethodBeat.o(23065);
      return;
    }
    finish();
    AppMethodBeat.o(23065);
  }
  
  public final void onCanceled()
  {
    AppMethodBeat.i(23071);
    this.phi = false;
    this.phd = null;
    ad.i("MicroMsg.DBRecoveryUI", "Recovery cancelled.");
    cbI();
    com.tencent.mm.ui.base.h.a(this, 2131757994, 0, false, this.phj);
    AppMethodBeat.o(23071);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23064);
    super.onCreate(paramBundle);
    this.mScene = getIntent().getIntExtra("scene", 2);
    this.phi = false;
    setMMTitle(2131757991);
    this.phe = findViewById(2131305182);
    this.lEb = findViewById(2131299174);
    this.jqx = ((ProgressBar)findViewById(2131303518));
    this.phf = ((TextView)findViewById(2131303531));
    findViewById(2131305174).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(23054);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/dbbackup/DBRecoveryUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (com.tencent.mm.kernel.g.ajC().ajg() == null)
        {
          com.tencent.mm.ui.base.h.l(DBRecoveryUI.this, 2131757996, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/dbbackup/DBRecoveryUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(23054);
          return;
        }
        if (DBRecoveryUI.a(DBRecoveryUI.this) != 0) {
          com.tencent.mm.ui.base.h.a(DBRecoveryUI.this, 2131757989, 0, 2131758003, 2131757992, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(23053);
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(873L, 25L, 1L, false);
              DBRecoveryUI.d(DBRecoveryUI.this);
              AppMethodBeat.o(23053);
            }
          }, null, 2131099990);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/dbbackup/DBRecoveryUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(23054);
          return;
          DBRecoveryUI.d(DBRecoveryUI.this);
        }
      }
    });
    this.phg = findViewById(2131297690);
    this.phg.setOnClickListener(new DBRecoveryUI.3(this));
    setBackBtn(new DBRecoveryUI.4(this));
    if (this.mScene == 0) {
      cbG();
    }
    com.tencent.mm.plugin.report.e.ygI.idkeyStat(181L, this.mScene + 51, 1L, true);
    com.tencent.mm.plugin.report.e.ygI.idkeyStat(873L, 14L, 1L, false);
    if (this.mScene == 2) {
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(873L, 15L, 1L, false);
    }
    AppMethodBeat.o(23064);
  }
  
  public final void onFailure()
  {
    AppMethodBeat.i(23072);
    this.phi = false;
    this.phd = null;
    ad.e("MicroMsg.DBRecoveryUI", "Recovery failed.");
    cbI();
    com.tencent.mm.ui.base.h.a(this, 2131757995, 0, false, this.phj);
    AppMethodBeat.o(23072);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(23070);
    this.phi = false;
    this.phd = null;
    ad.i("MicroMsg.DBRecoveryUI", "Recovery succeeded");
    final com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.ui.base.h.a(this, 2131758002, 0, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(23061);
        DBRecoveryUI.this.finish();
        d.cbP();
        AppMethodBeat.o(23061);
      }
    });
    if (locald != null) {
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23062);
          locald.dismiss();
          DBRecoveryUI.this.finish();
          d.cbP();
          AppMethodBeat.o(23062);
        }
      }, 5000L);
    }
    AppMethodBeat.o(23070);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.DBRecoveryUI
 * JD-Core Version:    0.7.0.1
 */