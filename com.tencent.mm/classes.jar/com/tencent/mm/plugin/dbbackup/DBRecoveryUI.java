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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;

public class DBRecoveryUI
  extends MMActivity
  implements a.b
{
  private static final int[] oal = { 0, 5, 70, 80, 90, 100, 100 };
  private ProgressBar ixl;
  private View kFK;
  private int mScene;
  private com.tencent.mm.plugin.dbbackup.a.a oae;
  private View oaf;
  private TextView oag;
  private View oah;
  private int oai;
  private boolean oaj;
  private DialogInterface.OnClickListener oak;
  
  public DBRecoveryUI()
  {
    AppMethodBeat.i(23063);
    this.oak = new DialogInterface.OnClickListener()
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
        d.bPW();
        AppMethodBeat.o(23052);
      }
    };
    AppMethodBeat.o(23063);
  }
  
  private void bPN()
  {
    AppMethodBeat.i(23066);
    if (this.oae != null)
    {
      ad.e("MicroMsg.DBRecoveryUI", "Recovery task has already started.");
      AppMethodBeat.o(23066);
      return;
    }
    this.oaf.setVisibility(8);
    this.kFK.setVisibility(0);
    this.oah.setEnabled(true);
    Object localObject1 = new StringBuilder().append(q.cG(true));
    com.tencent.mm.kernel.g.afz();
    Object localObject2 = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.kernel.a.getUin().getBytes()).substring(0, 7).getBytes();
    localObject1 = com.tencent.mm.kernel.g.afB().afe();
    String str1 = com.tencent.mm.kernel.g.afB().gda.getPath();
    String str2 = str1 + "-recovery";
    this.oai = 0;
    String str3 = com.tencent.mm.kernel.g.afB().gcW + "dbback/";
    a.a locala = new a.a();
    locala.obt = this;
    localObject2 = locala.aT((byte[])localObject2).aU((byte[])localObject2);
    ((a.a)localObject2).obr = new DBRecoveryUI.5(this);
    ((a.a)localObject2).obi = ((String)localObject1);
    ((a.a)localObject2).obh = str1;
    ((a.a)localObject2).obg = str2;
    ((a.a)localObject2).obk = (com.tencent.mm.kernel.g.afB().cachePath + "heavyDetailInfo");
    if (this.mScene == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((a.a)localObject2).obs = bool;
      this.oae = ((a.a)localObject2).Sd((String)localObject1 + ".sm").Se((String)localObject1 + ".bak").Sd(str3 + "corrupted/EnMicroMsg.db.sm").Se(str3 + "corrupted/EnMicroMsg.db.bak").Sd(str3 + "EnMicroMsg.db.sm").Se(str3 + "EnMicroMsg.db.bak").bQe();
      this.oae.execute(new Void[0]);
      this.oaj = true;
      AppMethodBeat.o(23066);
      return;
    }
  }
  
  private void bPO()
  {
    AppMethodBeat.i(23067);
    this.oah.setEnabled(false);
    if (this.oae != null)
    {
      this.oae.cancel();
      this.oae = null;
      AppMethodBeat.o(23067);
      return;
    }
    ad.e("MicroMsg.DBRecoveryUI", "Recovery task is not running.");
    AppMethodBeat.o(23067);
  }
  
  private static void bPP()
  {
    AppMethodBeat.i(23073);
    ab localab = com.tencent.mm.kernel.g.afB().afk();
    localab.set(89, Integer.valueOf(2));
    localab.eKy();
    AppMethodBeat.o(23073);
  }
  
  public final void N(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(23069);
    this.oaj = false;
    this.oae = null;
    bPP();
    com.tencent.mm.ui.base.h.a(this, getString(2131758000, new Object[] { Long.valueOf(paramLong2 / 1024L / 1024L), Long.valueOf(paramLong1 / 1024L / 1024L) }), null, false, this.oak);
    AppMethodBeat.o(23069);
  }
  
  public final void T(int paramInt1, int paramInt2, int paramInt3)
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
      i = oal[(paramInt1 - 1)];
      j = oal[paramInt1];
      f2 = paramInt2 / paramInt3;
      if (f2 <= 1.0F) {
        break label163;
      }
    }
    for (;;)
    {
      f2 = i;
      paramInt3 = (int)(f1 * (j - i) + f2);
      this.ixl.setProgress(paramInt3);
      for (;;)
      {
        this.oai = paramInt1;
        String str = getResources().getStringArray(2130903045)[(paramInt1 - 1)];
        this.oag.setText(String.format(str, new Object[] { Integer.valueOf(paramInt2) }));
        AppMethodBeat.o(23068);
        return;
        if (this.oai != paramInt1) {
          this.ixl.setProgress(oal[(paramInt1 - 1)]);
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
    if (this.oaj)
    {
      bPO();
      AppMethodBeat.o(23065);
      return;
    }
    finish();
    AppMethodBeat.o(23065);
  }
  
  public final void onCanceled()
  {
    AppMethodBeat.i(23071);
    this.oaj = false;
    this.oae = null;
    ad.i("MicroMsg.DBRecoveryUI", "Recovery cancelled.");
    bPP();
    com.tencent.mm.ui.base.h.a(this, 2131757994, 0, false, this.oak);
    AppMethodBeat.o(23071);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23064);
    super.onCreate(paramBundle);
    this.mScene = getIntent().getIntExtra("scene", 2);
    this.oaj = false;
    setMMTitle(2131757991);
    this.oaf = findViewById(2131305182);
    this.kFK = findViewById(2131299174);
    this.ixl = ((ProgressBar)findViewById(2131303518));
    this.oag = ((TextView)findViewById(2131303531));
    findViewById(2131305174).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(23054);
        if (com.tencent.mm.kernel.g.afB().afe() == null)
        {
          com.tencent.mm.ui.base.h.j(DBRecoveryUI.this, 2131757996, 0);
          AppMethodBeat.o(23054);
          return;
        }
        com.tencent.mm.ui.base.h.a(DBRecoveryUI.this, 2131757989, 0, 2131758003, 2131757992, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(23053);
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(873L, 25L, 1L, false);
            DBRecoveryUI.d(DBRecoveryUI.this);
            AppMethodBeat.o(23053);
          }
        }, null, 2131099990);
        AppMethodBeat.o(23054);
      }
    });
    this.oah = findViewById(2131297690);
    this.oah.setOnClickListener(new View.OnClickListener()
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
      bPN();
    }
    com.tencent.mm.plugin.report.e.vIY.idkeyStat(181L, this.mScene + 51, 1L, true);
    com.tencent.mm.plugin.report.e.vIY.idkeyStat(873L, 14L, 1L, false);
    if (this.mScene == 2) {
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(873L, 15L, 1L, false);
    }
    AppMethodBeat.o(23064);
  }
  
  public final void onFailure()
  {
    AppMethodBeat.i(23072);
    this.oaj = false;
    this.oae = null;
    ad.e("MicroMsg.DBRecoveryUI", "Recovery failed.");
    bPP();
    com.tencent.mm.ui.base.h.a(this, 2131757995, 0, false, this.oak);
    AppMethodBeat.o(23072);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(23070);
    this.oaj = false;
    this.oae = null;
    ad.i("MicroMsg.DBRecoveryUI", "Recovery succeeded");
    final com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.ui.base.h.a(this, 2131758002, 0, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(23061);
        DBRecoveryUI.this.finish();
        d.bPW();
        AppMethodBeat.o(23061);
      }
    });
    if (locald != null) {
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23062);
          locald.dismiss();
          DBRecoveryUI.this.finish();
          d.bPW();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.DBRecoveryUI
 * JD-Core Version:    0.7.0.1
 */