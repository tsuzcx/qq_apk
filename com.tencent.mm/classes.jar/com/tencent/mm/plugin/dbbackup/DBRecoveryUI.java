package com.tencent.mm.plugin.dbbackup;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
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
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DBRecoveryUI
  extends MMActivity
  implements a.b
{
  private static final int[] xiB = { 0, 5, 60, 75, 95, 100, 100 };
  private int mScene;
  private ProgressBar qgC;
  private View sVQ;
  private DialogInterface.OnClickListener xiA;
  private com.tencent.mm.plugin.dbbackup.a.a xiu;
  private View xiv;
  private TextView xiw;
  private View xix;
  private int xiy;
  private boolean xiz;
  
  public DBRecoveryUI()
  {
    AppMethodBeat.i(23063);
    this.xiA = new DialogInterface.OnClickListener()
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
        d.dtZ();
        AppMethodBeat.o(23052);
      }
    };
    AppMethodBeat.o(23063);
  }
  
  private void dtP()
  {
    AppMethodBeat.i(23066);
    if (this.xiu != null)
    {
      Log.e("MicroMsg.DBRecoveryUI", "Recovery task has already started.");
      AppMethodBeat.o(23066);
      return;
    }
    this.xiv.setVisibility(8);
    this.sVQ.setVisibility(0);
    this.xix.setEnabled(true);
    Object localObject1 = new StringBuilder().append(q.eD(true));
    com.tencent.mm.kernel.h.baC();
    Object localObject2 = g.getMessageDigest(com.tencent.mm.kernel.b.getUin().getBytes()).substring(0, 7).getBytes();
    localObject1 = com.tencent.mm.kernel.h.baE().bai();
    String str1 = com.tencent.mm.kernel.h.baE().mCN.getPath();
    String str2 = str1 + "-recovery";
    this.xiy = 0;
    String str3 = com.tencent.mm.kernel.h.baE().mCJ + "dbback/";
    a.a locala = new a.a();
    locala.xjH = this;
    localObject2 = locala.by((byte[])localObject2).bz((byte[])localObject2);
    ((a.a)localObject2).xjF = new a.d()
    {
      private Collection<String> xiE;
      private int xiF;
      
      private void dtT()
      {
        AppMethodBeat.i(23058);
        if (this.xiE == null) {
          this.xiE = com.tencent.mm.plugin.dbbackup.a.b.duk();
        }
        AppMethodBeat.o(23058);
      }
      
      public final Collection<byte[]> dtU()
      {
        AppMethodBeat.i(23059);
        dtT();
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.xiE.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localArrayList.add(g.U((str + this.xiF).getBytes()));
        }
        AppMethodBeat.o(23059);
        return localArrayList;
      }
      
      public final Collection<byte[]> dtV()
      {
        AppMethodBeat.i(23060);
        dtT();
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.xiE.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localArrayList.add(g.getMessageDigest((str + this.xiF).getBytes()).substring(0, 7).getBytes());
        }
        AppMethodBeat.o(23060);
        return localArrayList;
      }
    };
    ((a.a)localObject2).xjx = ((String)localObject1);
    ((a.a)localObject2).xjw = str1;
    ((a.a)localObject2).xjv = str2;
    ((a.a)localObject2).xjy = (com.tencent.mm.kernel.h.baE().cachePath + "heavyDetailInfo");
    if (this.mScene == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((a.a)localObject2).xjG = bool;
      this.xiu = ((a.a)localObject2).amC((String)localObject1 + ".sm").amD((String)localObject1 + ".bak").amC(str3 + "corrupted/EnMicroMsg.db.sm").amD(str3 + "corrupted/EnMicroMsg.db.bak").amC(str3 + "EnMicroMsg.db.sm").amD(str3 + "EnMicroMsg.db.bak").duj();
      this.xiu.execute(new Void[0]);
      this.xiz = true;
      AppMethodBeat.o(23066);
      return;
    }
  }
  
  private void dtQ()
  {
    AppMethodBeat.i(23067);
    this.xix.setEnabled(false);
    if (this.xiu != null)
    {
      this.xiu.cancel();
      this.xiu = null;
      AppMethodBeat.o(23067);
      return;
    }
    Log.e("MicroMsg.DBRecoveryUI", "Recovery task is not running.");
    AppMethodBeat.o(23067);
  }
  
  private static void dtS()
  {
    AppMethodBeat.i(23073);
    aq localaq = com.tencent.mm.kernel.h.baE().ban();
    localaq.B(89, Integer.valueOf(2));
    localaq.iZy();
    AppMethodBeat.o(23073);
  }
  
  public final void al(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(23069);
    this.xiz = false;
    this.xiu = null;
    dtS();
    k.a(this, getString(R.l.gDP, new Object[] { Long.valueOf(paramLong2 / 1024L / 1024L), Long.valueOf(paramLong1 / 1024L / 1024L) }), null, false, this.xiA);
    AppMethodBeat.o(23069);
  }
  
  public final void ap(int paramInt1, int paramInt2, int paramInt3)
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
      i = xiB[(paramInt1 - 1)];
      j = xiB[paramInt1];
      f2 = paramInt2 / paramInt3;
      if (f2 <= 1.0F) {
        break label163;
      }
    }
    for (;;)
    {
      f2 = i;
      paramInt3 = (int)(f1 * (j - i) + f2);
      this.qgC.setProgress(paramInt3);
      for (;;)
      {
        this.xiy = paramInt1;
        String str = getResources().getStringArray(com.tencent.mm.R.c.fjO)[(paramInt1 - 1)];
        this.xiw.setText(String.format(str, new Object[] { Integer.valueOf(paramInt2) }));
        AppMethodBeat.o(23068);
        return;
        if (this.xiy != paramInt1) {
          this.qgC.setProgress(xiB[(paramInt1 - 1)]);
        }
      }
      label163:
      f1 = f2;
    }
  }
  
  public final void dtR()
  {
    AppMethodBeat.i(23072);
    this.xiz = false;
    this.xiu = null;
    Log.e("MicroMsg.DBRecoveryUI", "Recovery failed.");
    dtS();
    k.a(this, R.l.gDN, 0, false, this.xiA);
    AppMethodBeat.o(23072);
  }
  
  public int getLayoutId()
  {
    return R.i.giP;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(23065);
    if (this.xiz)
    {
      dtQ();
      AppMethodBeat.o(23065);
      return;
    }
    finish();
    AppMethodBeat.o(23065);
  }
  
  public final void onCanceled()
  {
    AppMethodBeat.i(23071);
    this.xiz = false;
    this.xiu = null;
    Log.i("MicroMsg.DBRecoveryUI", "Recovery cancelled.");
    dtS();
    k.a(this, R.l.gDM, 0, false, this.xiA);
    AppMethodBeat.o(23071);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23064);
    super.onCreate(paramBundle);
    this.mScene = getIntent().getIntExtra("scene", 2);
    this.xiz = false;
    setMMTitle(R.l.data_recovery);
    this.xiv = findViewById(R.h.start_recover);
    this.sVQ = findViewById(R.h.fFY);
    this.qgC = ((ProgressBar)findViewById(R.h.progress_bar));
    this.xiw = ((TextView)findViewById(R.h.fTF));
    findViewById(R.h.start_btn).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(23054);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/dbbackup/DBRecoveryUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (com.tencent.mm.kernel.h.baE().bai() == null)
        {
          k.s(DBRecoveryUI.this, R.l.gDO, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/dbbackup/DBRecoveryUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(23054);
          return;
        }
        if (DBRecoveryUI.a(DBRecoveryUI.this) != 0) {
          k.a(DBRecoveryUI.this, R.l.gDK, 0, R.l.gDR, R.l.gDL, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(23053);
              com.tencent.mm.plugin.report.f.Ozc.idkeyStat(873L, 25L, 1L, false);
              DBRecoveryUI.d(DBRecoveryUI.this);
              AppMethodBeat.o(23053);
            }
          }, null, R.e.fkf);
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
    this.xix = findViewById(R.h.cancel_btn);
    this.xix.setOnClickListener(new DBRecoveryUI.3(this));
    setBackBtn(new DBRecoveryUI.4(this));
    if (this.mScene == 0) {
      dtP();
    }
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(181L, this.mScene + 51, 1L, true);
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(873L, 14L, 1L, false);
    if (this.mScene == 2) {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(873L, 15L, 1L, false);
    }
    AppMethodBeat.o(23064);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(23070);
    this.xiz = false;
    this.xiu = null;
    Log.i("MicroMsg.DBRecoveryUI", "Recovery succeeded");
    final e locale = k.a(this, R.l.gDQ, 0, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(23061);
        DBRecoveryUI.this.finish();
        d.dtZ();
        AppMethodBeat.o(23061);
      }
    });
    if (locale != null) {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23062);
          locale.dismiss();
          DBRecoveryUI.this.finish();
          d.dtZ();
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