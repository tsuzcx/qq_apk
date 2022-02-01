package com.tencent.mm.plugin.dbbackup;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.dbbackup.a.a.a;
import com.tencent.mm.plugin.dbbackup.a.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;

public class DBRecoveryUI
  extends MMActivity
  implements a.b
{
  private static final int[] oDK = { 0, 5, 60, 75, 95, 100, 100 };
  private ProgressBar iXo;
  private View lhd;
  private int mScene;
  private com.tencent.mm.plugin.dbbackup.a.a oDD;
  private View oDE;
  private TextView oDF;
  private View oDG;
  private int oDH;
  private boolean oDI;
  private DialogInterface.OnClickListener oDJ;
  
  public DBRecoveryUI()
  {
    AppMethodBeat.i(23063);
    this.oDJ = new DialogInterface.OnClickListener()
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
        d.bXm();
        AppMethodBeat.o(23052);
      }
    };
    AppMethodBeat.o(23063);
  }
  
  private void bXd()
  {
    AppMethodBeat.i(23066);
    if (this.oDD != null)
    {
      ac.e("MicroMsg.DBRecoveryUI", "Recovery task has already started.");
      AppMethodBeat.o(23066);
      return;
    }
    this.oDE.setVisibility(8);
    this.lhd.setVisibility(0);
    this.oDG.setEnabled(true);
    Object localObject1 = new StringBuilder().append(q.cF(true));
    com.tencent.mm.kernel.g.agP();
    Object localObject2 = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.kernel.a.getUin().getBytes()).substring(0, 7).getBytes();
    localObject1 = com.tencent.mm.kernel.g.agR().agu();
    String str1 = com.tencent.mm.kernel.g.agR().ghG.getPath();
    String str2 = str1 + "-recovery";
    this.oDH = 0;
    String str3 = com.tencent.mm.kernel.g.agR().ghC + "dbback/";
    a.a locala = new a.a();
    locala.oER = this;
    localObject2 = locala.aS((byte[])localObject2).aT((byte[])localObject2);
    ((a.a)localObject2).oEP = new DBRecoveryUI.5(this);
    ((a.a)localObject2).oEH = ((String)localObject1);
    ((a.a)localObject2).oEG = str1;
    ((a.a)localObject2).oEF = str2;
    ((a.a)localObject2).oEI = (com.tencent.mm.kernel.g.agR().cachePath + "heavyDetailInfo");
    if (this.mScene == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((a.a)localObject2).oEQ = bool;
      this.oDD = ((a.a)localObject2).Wp((String)localObject1 + ".sm").Wq((String)localObject1 + ".bak").Wp(str3 + "corrupted/EnMicroMsg.db.sm").Wq(str3 + "corrupted/EnMicroMsg.db.bak").Wp(str3 + "EnMicroMsg.db.sm").Wq(str3 + "EnMicroMsg.db.bak").bXv();
      this.oDD.execute(new Void[0]);
      this.oDI = true;
      AppMethodBeat.o(23066);
      return;
    }
  }
  
  private void bXe()
  {
    AppMethodBeat.i(23067);
    this.oDG.setEnabled(false);
    if (this.oDD != null)
    {
      this.oDD.cancel();
      this.oDD = null;
      AppMethodBeat.o(23067);
      return;
    }
    ac.e("MicroMsg.DBRecoveryUI", "Recovery task is not running.");
    AppMethodBeat.o(23067);
  }
  
  private static void bXf()
  {
    AppMethodBeat.i(23073);
    ae localae = com.tencent.mm.kernel.g.agR().agA();
    localae.set(89, Integer.valueOf(2));
    localae.faa();
    AppMethodBeat.o(23073);
  }
  
  public final void J(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(23069);
    this.oDI = false;
    this.oDD = null;
    bXf();
    com.tencent.mm.ui.base.h.a(this, getString(2131758000, new Object[] { Long.valueOf(paramLong2 / 1024L / 1024L), Long.valueOf(paramLong1 / 1024L / 1024L) }), null, false, this.oDJ);
    AppMethodBeat.o(23069);
  }
  
  public final void U(int paramInt1, int paramInt2, int paramInt3)
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
      i = oDK[(paramInt1 - 1)];
      j = oDK[paramInt1];
      f2 = paramInt2 / paramInt3;
      if (f2 <= 1.0F) {
        break label163;
      }
    }
    for (;;)
    {
      f2 = i;
      paramInt3 = (int)(f1 * (j - i) + f2);
      this.iXo.setProgress(paramInt3);
      for (;;)
      {
        this.oDH = paramInt1;
        String str = getResources().getStringArray(2130903045)[(paramInt1 - 1)];
        this.oDF.setText(String.format(str, new Object[] { Integer.valueOf(paramInt2) }));
        AppMethodBeat.o(23068);
        return;
        if (this.oDH != paramInt1) {
          this.iXo.setProgress(oDK[(paramInt1 - 1)]);
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
    if (this.oDI)
    {
      bXe();
      AppMethodBeat.o(23065);
      return;
    }
    finish();
    AppMethodBeat.o(23065);
  }
  
  public final void onCanceled()
  {
    AppMethodBeat.i(23071);
    this.oDI = false;
    this.oDD = null;
    ac.i("MicroMsg.DBRecoveryUI", "Recovery cancelled.");
    bXf();
    com.tencent.mm.ui.base.h.a(this, 2131757994, 0, false, this.oDJ);
    AppMethodBeat.o(23071);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23064);
    super.onCreate(paramBundle);
    this.mScene = getIntent().getIntExtra("scene", 2);
    this.oDI = false;
    setMMTitle(2131757991);
    this.oDE = findViewById(2131305182);
    this.lhd = findViewById(2131299174);
    this.iXo = ((ProgressBar)findViewById(2131303518));
    this.oDF = ((TextView)findViewById(2131303531));
    findViewById(2131305174).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(23054);
        if (com.tencent.mm.kernel.g.agR().agu() == null)
        {
          com.tencent.mm.ui.base.h.l(DBRecoveryUI.this, 2131757996, 0);
          AppMethodBeat.o(23054);
          return;
        }
        if (DBRecoveryUI.a(DBRecoveryUI.this) != 0)
        {
          com.tencent.mm.ui.base.h.a(DBRecoveryUI.this, 2131757989, 0, 2131758003, 2131757992, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(23053);
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(873L, 25L, 1L, false);
              DBRecoveryUI.d(DBRecoveryUI.this);
              AppMethodBeat.o(23053);
            }
          }, null, 2131099990);
          AppMethodBeat.o(23054);
          return;
        }
        DBRecoveryUI.d(DBRecoveryUI.this);
        AppMethodBeat.o(23054);
      }
    });
    this.oDG = findViewById(2131297690);
    this.oDG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(23055);
        DBRecoveryUI.e(DBRecoveryUI.this);
        AppMethodBeat.o(23055);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(23056);
        if (DBRecoveryUI.f(DBRecoveryUI.this)) {
          DBRecoveryUI.e(DBRecoveryUI.this);
        }
        for (;;)
        {
          AppMethodBeat.o(23056);
          return true;
          DBRecoveryUI.this.finish();
        }
      }
    });
    if (this.mScene == 0) {
      bXd();
    }
    com.tencent.mm.plugin.report.e.wTc.idkeyStat(181L, this.mScene + 51, 1L, true);
    com.tencent.mm.plugin.report.e.wTc.idkeyStat(873L, 14L, 1L, false);
    if (this.mScene == 2) {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(873L, 15L, 1L, false);
    }
    AppMethodBeat.o(23064);
  }
  
  public final void onFailure()
  {
    AppMethodBeat.i(23072);
    this.oDI = false;
    this.oDD = null;
    ac.e("MicroMsg.DBRecoveryUI", "Recovery failed.");
    bXf();
    com.tencent.mm.ui.base.h.a(this, 2131757995, 0, false, this.oDJ);
    AppMethodBeat.o(23072);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(23070);
    this.oDI = false;
    this.oDD = null;
    ac.i("MicroMsg.DBRecoveryUI", "Recovery succeeded");
    final com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.ui.base.h.a(this, 2131758002, 0, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(23061);
        DBRecoveryUI.this.finish();
        d.bXm();
        AppMethodBeat.o(23061);
      }
    });
    if (locald != null) {
      ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23062);
          locald.dismiss();
          DBRecoveryUI.this.finish();
          d.bXm();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.DBRecoveryUI
 * JD-Core Version:    0.7.0.1
 */