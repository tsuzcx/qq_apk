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
import com.tencent.mm.plugin.dbbackup.a.a.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DBRecoveryUI
  extends MMActivity
  implements a.b
{
  private static final int[] pnQ = { 0, 5, 60, 75, 95, 100, 100 };
  private ProgressBar jtq;
  private View lIA;
  private int mScene;
  private com.tencent.mm.plugin.dbbackup.a.a pnJ;
  private View pnK;
  private TextView pnL;
  private View pnM;
  private int pnN;
  private boolean pnO;
  private DialogInterface.OnClickListener pnP;
  
  public DBRecoveryUI()
  {
    AppMethodBeat.i(23063);
    this.pnP = new DialogInterface.OnClickListener()
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
        d.cde();
        AppMethodBeat.o(23052);
      }
    };
    AppMethodBeat.o(23063);
  }
  
  private void ccV()
  {
    AppMethodBeat.i(23066);
    if (this.pnJ != null)
    {
      ae.e("MicroMsg.DBRecoveryUI", "Recovery task has already started.");
      AppMethodBeat.o(23066);
      return;
    }
    this.pnK.setVisibility(8);
    this.lIA.setVisibility(0);
    this.pnM.setEnabled(true);
    Object localObject1 = new StringBuilder().append(q.cH(true));
    com.tencent.mm.kernel.g.ajP();
    Object localObject2 = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.kernel.a.getUin().getBytes()).substring(0, 7).getBytes();
    localObject1 = com.tencent.mm.kernel.g.ajR().ajv();
    String str1 = com.tencent.mm.kernel.g.ajR().gDX.getPath();
    String str2 = str1 + "-recovery";
    this.pnN = 0;
    String str3 = com.tencent.mm.kernel.g.ajR().gDT + "dbback/";
    a.a locala = new a.a();
    locala.poY = this;
    localObject2 = locala.aU((byte[])localObject2).aV((byte[])localObject2);
    ((a.a)localObject2).poW = new a.d()
    {
      private Collection<String> pnT;
      private int pnU;
      
      private void ccY()
      {
        AppMethodBeat.i(23058);
        if (this.pnT == null) {
          this.pnT = com.tencent.mm.plugin.dbbackup.a.b.cdo();
        }
        AppMethodBeat.o(23058);
      }
      
      public final Collection<byte[]> ccZ()
      {
        AppMethodBeat.i(23059);
        ccY();
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.pnT.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localArrayList.add(com.tencent.mm.b.g.C((str + this.pnU).getBytes()));
        }
        AppMethodBeat.o(23059);
        return localArrayList;
      }
      
      public final Collection<byte[]> cda()
      {
        AppMethodBeat.i(23060);
        ccY();
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.pnT.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localArrayList.add(com.tencent.mm.b.g.getMessageDigest((str + this.pnU).getBytes()).substring(0, 7).getBytes());
        }
        AppMethodBeat.o(23060);
        return localArrayList;
      }
    };
    ((a.a)localObject2).poO = ((String)localObject1);
    ((a.a)localObject2).poN = str1;
    ((a.a)localObject2).poM = str2;
    ((a.a)localObject2).poP = (com.tencent.mm.kernel.g.ajR().cachePath + "heavyDetailInfo");
    if (this.mScene == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((a.a)localObject2).poX = bool;
      this.pnJ = ((a.a)localObject2).aaN((String)localObject1 + ".sm").aaO((String)localObject1 + ".bak").aaN(str3 + "corrupted/EnMicroMsg.db.sm").aaO(str3 + "corrupted/EnMicroMsg.db.bak").aaN(str3 + "EnMicroMsg.db.sm").aaO(str3 + "EnMicroMsg.db.bak").cdn();
      this.pnJ.execute(new Void[0]);
      this.pnO = true;
      AppMethodBeat.o(23066);
      return;
    }
  }
  
  private void ccW()
  {
    AppMethodBeat.i(23067);
    this.pnM.setEnabled(false);
    if (this.pnJ != null)
    {
      this.pnJ.cancel();
      this.pnJ = null;
      AppMethodBeat.o(23067);
      return;
    }
    ae.e("MicroMsg.DBRecoveryUI", "Recovery task is not running.");
    AppMethodBeat.o(23067);
  }
  
  private static void ccX()
  {
    AppMethodBeat.i(23073);
    aj localaj = com.tencent.mm.kernel.g.ajR().ajA();
    localaj.set(89, Integer.valueOf(2));
    localaj.fuc();
    AppMethodBeat.o(23073);
  }
  
  public final void I(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(23069);
    this.pnO = false;
    this.pnJ = null;
    ccX();
    com.tencent.mm.ui.base.h.a(this, getString(2131758000, new Object[] { Long.valueOf(paramLong2 / 1024L / 1024L), Long.valueOf(paramLong1 / 1024L / 1024L) }), null, false, this.pnP);
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
      i = pnQ[(paramInt1 - 1)];
      j = pnQ[paramInt1];
      f2 = paramInt2 / paramInt3;
      if (f2 <= 1.0F) {
        break label163;
      }
    }
    for (;;)
    {
      f2 = i;
      paramInt3 = (int)(f1 * (j - i) + f2);
      this.jtq.setProgress(paramInt3);
      for (;;)
      {
        this.pnN = paramInt1;
        String str = getResources().getStringArray(2130903045)[(paramInt1 - 1)];
        this.pnL.setText(String.format(str, new Object[] { Integer.valueOf(paramInt2) }));
        AppMethodBeat.o(23068);
        return;
        if (this.pnN != paramInt1) {
          this.jtq.setProgress(pnQ[(paramInt1 - 1)]);
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
    if (this.pnO)
    {
      ccW();
      AppMethodBeat.o(23065);
      return;
    }
    finish();
    AppMethodBeat.o(23065);
  }
  
  public final void onCanceled()
  {
    AppMethodBeat.i(23071);
    this.pnO = false;
    this.pnJ = null;
    ae.i("MicroMsg.DBRecoveryUI", "Recovery cancelled.");
    ccX();
    com.tencent.mm.ui.base.h.a(this, 2131757994, 0, false, this.pnP);
    AppMethodBeat.o(23071);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23064);
    super.onCreate(paramBundle);
    this.mScene = getIntent().getIntExtra("scene", 2);
    this.pnO = false;
    setMMTitle(2131757991);
    this.pnK = findViewById(2131305182);
    this.lIA = findViewById(2131299174);
    this.jtq = ((ProgressBar)findViewById(2131303518));
    this.pnL = ((TextView)findViewById(2131303531));
    findViewById(2131305174).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(23054);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/dbbackup/DBRecoveryUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (com.tencent.mm.kernel.g.ajR().ajv() == null)
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
              com.tencent.mm.plugin.report.e.ywz.idkeyStat(873L, 25L, 1L, false);
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
    this.pnM = findViewById(2131297690);
    this.pnM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(23055);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/dbbackup/DBRecoveryUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        DBRecoveryUI.e(DBRecoveryUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/dbbackup/DBRecoveryUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
      ccV();
    }
    com.tencent.mm.plugin.report.e.ywz.idkeyStat(181L, this.mScene + 51, 1L, true);
    com.tencent.mm.plugin.report.e.ywz.idkeyStat(873L, 14L, 1L, false);
    if (this.mScene == 2) {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(873L, 15L, 1L, false);
    }
    AppMethodBeat.o(23064);
  }
  
  public final void onFailure()
  {
    AppMethodBeat.i(23072);
    this.pnO = false;
    this.pnJ = null;
    ae.e("MicroMsg.DBRecoveryUI", "Recovery failed.");
    ccX();
    com.tencent.mm.ui.base.h.a(this, 2131757995, 0, false, this.pnP);
    AppMethodBeat.o(23072);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(23070);
    this.pnO = false;
    this.pnJ = null;
    ae.i("MicroMsg.DBRecoveryUI", "Recovery succeeded");
    final com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.ui.base.h.a(this, 2131758002, 0, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(23061);
        DBRecoveryUI.this.finish();
        d.cde();
        AppMethodBeat.o(23061);
      }
    });
    if (locald != null) {
      ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23062);
          locald.dismiss();
          DBRecoveryUI.this.finish();
          d.cde();
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