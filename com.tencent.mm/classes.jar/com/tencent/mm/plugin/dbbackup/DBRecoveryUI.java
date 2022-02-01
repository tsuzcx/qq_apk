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
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.dbbackup.a.a.a;
import com.tencent.mm.plugin.dbbackup.a.a.b;
import com.tencent.mm.plugin.dbbackup.a.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DBRecoveryUI
  extends MMActivity
  implements a.b
{
  private static final int[] ucx = { 0, 5, 60, 75, 95, 100, 100 };
  private int mScene;
  private ProgressBar njo;
  private View pRh;
  private com.tencent.mm.plugin.dbbackup.a.a ucq;
  private View ucr;
  private TextView ucs;
  private View uct;
  private int ucu;
  private boolean ucv;
  private DialogInterface.OnClickListener ucw;
  
  public DBRecoveryUI()
  {
    AppMethodBeat.i(23063);
    this.ucw = new DialogInterface.OnClickListener()
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
        d.cPD();
        AppMethodBeat.o(23052);
      }
    };
    AppMethodBeat.o(23063);
  }
  
  private void cPu()
  {
    AppMethodBeat.i(23066);
    if (this.ucq != null)
    {
      Log.e("MicroMsg.DBRecoveryUI", "Recovery task has already started.");
      AppMethodBeat.o(23066);
      return;
    }
    this.ucr.setVisibility(8);
    this.pRh.setVisibility(0);
    this.uct.setEnabled(true);
    Object localObject1 = new StringBuilder().append(q.dR(true));
    com.tencent.mm.kernel.h.aHE();
    Object localObject2 = g.getMessageDigest(com.tencent.mm.kernel.b.getUin().getBytes()).substring(0, 7).getBytes();
    localObject1 = com.tencent.mm.kernel.h.aHG().aHk();
    String str1 = com.tencent.mm.kernel.h.aHG().kcF.getPath();
    String str2 = str1 + "-recovery";
    this.ucu = 0;
    String str3 = com.tencent.mm.kernel.h.aHG().kcB + "dbback/";
    a.a locala = new a.a();
    locala.udE = this;
    localObject2 = locala.by((byte[])localObject2).bz((byte[])localObject2);
    ((a.a)localObject2).udC = new a.d()
    {
      private Collection<String> ucA;
      private int ucB;
      
      private void cPx()
      {
        AppMethodBeat.i(23058);
        if (this.ucA == null) {
          this.ucA = com.tencent.mm.plugin.dbbackup.a.b.cPN();
        }
        AppMethodBeat.o(23058);
      }
      
      public final Collection<byte[]> cPy()
      {
        AppMethodBeat.i(23059);
        cPx();
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.ucA.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localArrayList.add(g.V((str + this.ucB).getBytes()));
        }
        AppMethodBeat.o(23059);
        return localArrayList;
      }
      
      public final Collection<byte[]> cPz()
      {
        AppMethodBeat.i(23060);
        cPx();
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.ucA.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localArrayList.add(g.getMessageDigest((str + this.ucB).getBytes()).substring(0, 7).getBytes());
        }
        AppMethodBeat.o(23060);
        return localArrayList;
      }
    };
    ((a.a)localObject2).udu = ((String)localObject1);
    ((a.a)localObject2).udt = str1;
    ((a.a)localObject2).uds = str2;
    ((a.a)localObject2).udv = (com.tencent.mm.kernel.h.aHG().cachePath + "heavyDetailInfo");
    if (this.mScene == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((a.a)localObject2).udD = bool;
      this.ucq = ((a.a)localObject2).asN((String)localObject1 + ".sm").asO((String)localObject1 + ".bak").asN(str3 + "corrupted/EnMicroMsg.db.sm").asO(str3 + "corrupted/EnMicroMsg.db.bak").asN(str3 + "EnMicroMsg.db.sm").asO(str3 + "EnMicroMsg.db.bak").cPM();
      this.ucq.execute(new Void[0]);
      this.ucv = true;
      AppMethodBeat.o(23066);
      return;
    }
  }
  
  private void cPv()
  {
    AppMethodBeat.i(23067);
    this.uct.setEnabled(false);
    if (this.ucq != null)
    {
      this.ucq.cancel();
      this.ucq = null;
      AppMethodBeat.o(23067);
      return;
    }
    Log.e("MicroMsg.DBRecoveryUI", "Recovery task is not running.");
    AppMethodBeat.o(23067);
  }
  
  private static void cPw()
  {
    AppMethodBeat.i(23073);
    ao localao = com.tencent.mm.kernel.h.aHG().aHp();
    localao.i(89, Integer.valueOf(2));
    localao.hxT();
    AppMethodBeat.o(23073);
  }
  
  public final void O(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(23069);
    this.ucv = false;
    this.ucq = null;
    cPw();
    com.tencent.mm.ui.base.h.a(this, getString(R.l.eAP, new Object[] { Long.valueOf(paramLong2 / 1024L / 1024L), Long.valueOf(paramLong1 / 1024L / 1024L) }), null, false, this.ucw);
    AppMethodBeat.o(23069);
  }
  
  public final void Y(int paramInt1, int paramInt2, int paramInt3)
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
      i = ucx[(paramInt1 - 1)];
      j = ucx[paramInt1];
      f2 = paramInt2 / paramInt3;
      if (f2 <= 1.0F) {
        break label163;
      }
    }
    for (;;)
    {
      f2 = i;
      paramInt3 = (int)(f1 * (j - i) + f2);
      this.njo.setProgress(paramInt3);
      for (;;)
      {
        this.ucu = paramInt1;
        String str = getResources().getStringArray(com.tencent.mm.R.c.djN)[(paramInt1 - 1)];
        this.ucs.setText(String.format(str, new Object[] { Integer.valueOf(paramInt2) }));
        AppMethodBeat.o(23068);
        return;
        if (this.ucu != paramInt1) {
          this.njo.setProgress(ucx[(paramInt1 - 1)]);
        }
      }
      label163:
      f1 = f2;
    }
  }
  
  public int getLayoutId()
  {
    return R.i.efQ;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(23065);
    if (this.ucv)
    {
      cPv();
      AppMethodBeat.o(23065);
      return;
    }
    finish();
    AppMethodBeat.o(23065);
  }
  
  public final void onCanceled()
  {
    AppMethodBeat.i(23071);
    this.ucv = false;
    this.ucq = null;
    Log.i("MicroMsg.DBRecoveryUI", "Recovery cancelled.");
    cPw();
    com.tencent.mm.ui.base.h.a(this, R.l.eAM, 0, false, this.ucw);
    AppMethodBeat.o(23071);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23064);
    super.onCreate(paramBundle);
    this.mScene = getIntent().getIntExtra("scene", 2);
    this.ucv = false;
    setMMTitle(R.l.data_recovery);
    this.ucr = findViewById(R.h.start_recover);
    this.pRh = findViewById(R.h.dEU);
    this.njo = ((ProgressBar)findViewById(R.h.progress_bar));
    this.ucs = ((TextView)findViewById(R.h.dRD));
    findViewById(R.h.start_btn).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(23054);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/dbbackup/DBRecoveryUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (com.tencent.mm.kernel.h.aHG().aHk() == null)
        {
          com.tencent.mm.ui.base.h.p(DBRecoveryUI.this, R.l.eAO, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/dbbackup/DBRecoveryUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(23054);
          return;
        }
        if (DBRecoveryUI.a(DBRecoveryUI.this) != 0) {
          com.tencent.mm.ui.base.h.a(DBRecoveryUI.this, R.l.eAK, 0, R.l.eAR, R.l.eAL, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(23053);
              com.tencent.mm.plugin.report.f.Iyx.idkeyStat(873L, 25L, 1L, false);
              DBRecoveryUI.d(DBRecoveryUI.this);
              AppMethodBeat.o(23053);
            }
          }, null, R.e.dke);
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
    this.uct = findViewById(R.h.cancel_btn);
    this.uct.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(23055);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/dbbackup/DBRecoveryUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
      cPu();
    }
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(181L, this.mScene + 51, 1L, true);
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(873L, 14L, 1L, false);
    if (this.mScene == 2) {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(873L, 15L, 1L, false);
    }
    AppMethodBeat.o(23064);
  }
  
  public final void onFailure()
  {
    AppMethodBeat.i(23072);
    this.ucv = false;
    this.ucq = null;
    Log.e("MicroMsg.DBRecoveryUI", "Recovery failed.");
    cPw();
    com.tencent.mm.ui.base.h.a(this, R.l.eAN, 0, false, this.ucw);
    AppMethodBeat.o(23072);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(23070);
    this.ucv = false;
    this.ucq = null;
    Log.i("MicroMsg.DBRecoveryUI", "Recovery succeeded");
    final com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.ui.base.h.a(this, R.l.eAQ, 0, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(23061);
        DBRecoveryUI.this.finish();
        d.cPD();
        AppMethodBeat.o(23061);
      }
    });
    if (locald != null) {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23062);
          locald.dismiss();
          DBRecoveryUI.this.finish();
          d.cPD();
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