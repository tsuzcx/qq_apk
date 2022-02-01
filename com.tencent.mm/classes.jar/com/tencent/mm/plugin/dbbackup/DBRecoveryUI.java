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
  private static final int[] qDw = { 0, 5, 60, 75, 95, 100, 100 };
  private ProgressBar krF;
  private View mQo;
  private int mScene;
  private com.tencent.mm.plugin.dbbackup.a.a qDp;
  private View qDq;
  private TextView qDr;
  private View qDs;
  private int qDt;
  private boolean qDu;
  private DialogInterface.OnClickListener qDv;
  
  public DBRecoveryUI()
  {
    AppMethodBeat.i(23063);
    this.qDv = new DialogInterface.OnClickListener()
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
        d.cAZ();
        AppMethodBeat.o(23052);
      }
    };
    AppMethodBeat.o(23063);
  }
  
  private void cAQ()
  {
    AppMethodBeat.i(23066);
    if (this.qDp != null)
    {
      Log.e("MicroMsg.DBRecoveryUI", "Recovery task has already started.");
      AppMethodBeat.o(23066);
      return;
    }
    this.qDq.setVisibility(8);
    this.mQo.setVisibility(0);
    this.qDs.setEnabled(true);
    Object localObject1 = new StringBuilder().append(q.dr(true));
    com.tencent.mm.kernel.g.aAf();
    Object localObject2 = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.kernel.a.getUin().getBytes()).substring(0, 7).getBytes();
    localObject1 = com.tencent.mm.kernel.g.aAh().azL();
    String str1 = com.tencent.mm.kernel.g.aAh().hqK.getPath();
    String str2 = str1 + "-recovery";
    this.qDt = 0;
    String str3 = com.tencent.mm.kernel.g.aAh().hqG + "dbback/";
    a.a locala = new a.a();
    locala.qED = this;
    localObject2 = locala.bl((byte[])localObject2).bm((byte[])localObject2);
    ((a.a)localObject2).qEB = new a.d()
    {
      private int qDA;
      private Collection<String> qDz;
      
      private void cAT()
      {
        AppMethodBeat.i(23058);
        if (this.qDz == null) {
          this.qDz = com.tencent.mm.plugin.dbbackup.a.b.cBj();
        }
        AppMethodBeat.o(23058);
      }
      
      public final Collection<byte[]> cAU()
      {
        AppMethodBeat.i(23059);
        cAT();
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.qDz.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localArrayList.add(com.tencent.mm.b.g.Q((str + this.qDA).getBytes()));
        }
        AppMethodBeat.o(23059);
        return localArrayList;
      }
      
      public final Collection<byte[]> cAV()
      {
        AppMethodBeat.i(23060);
        cAT();
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.qDz.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localArrayList.add(com.tencent.mm.b.g.getMessageDigest((str + this.qDA).getBytes()).substring(0, 7).getBytes());
        }
        AppMethodBeat.o(23060);
        return localArrayList;
      }
    };
    ((a.a)localObject2).qEt = ((String)localObject1);
    ((a.a)localObject2).qEs = str1;
    ((a.a)localObject2).qEr = str2;
    ((a.a)localObject2).qEu = (com.tencent.mm.kernel.g.aAh().cachePath + "heavyDetailInfo");
    if (this.mScene == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((a.a)localObject2).qEC = bool;
      this.qDp = ((a.a)localObject2).akU((String)localObject1 + ".sm").akV((String)localObject1 + ".bak").akU(str3 + "corrupted/EnMicroMsg.db.sm").akV(str3 + "corrupted/EnMicroMsg.db.bak").akU(str3 + "EnMicroMsg.db.sm").akV(str3 + "EnMicroMsg.db.bak").cBi();
      this.qDp.execute(new Void[0]);
      this.qDu = true;
      AppMethodBeat.o(23066);
      return;
    }
  }
  
  private void cAR()
  {
    AppMethodBeat.i(23067);
    this.qDs.setEnabled(false);
    if (this.qDp != null)
    {
      this.qDp.cancel();
      this.qDp = null;
      AppMethodBeat.o(23067);
      return;
    }
    Log.e("MicroMsg.DBRecoveryUI", "Recovery task is not running.");
    AppMethodBeat.o(23067);
  }
  
  private static void cAS()
  {
    AppMethodBeat.i(23073);
    ao localao = com.tencent.mm.kernel.g.aAh().azQ();
    localao.set(89, Integer.valueOf(2));
    localao.gBI();
    AppMethodBeat.o(23073);
  }
  
  public final void M(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(23069);
    this.qDu = false;
    this.qDp = null;
    cAS();
    com.tencent.mm.ui.base.h.a(this, getString(2131758249, new Object[] { Long.valueOf(paramLong2 / 1024L / 1024L), Long.valueOf(paramLong1 / 1024L / 1024L) }), null, false, this.qDv);
    AppMethodBeat.o(23069);
  }
  
  public final void X(int paramInt1, int paramInt2, int paramInt3)
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
      i = qDw[(paramInt1 - 1)];
      j = qDw[paramInt1];
      f2 = paramInt2 / paramInt3;
      if (f2 <= 1.0F) {
        break label163;
      }
    }
    for (;;)
    {
      f2 = i;
      paramInt3 = (int)(f1 * (j - i) + f2);
      this.krF.setProgress(paramInt3);
      for (;;)
      {
        this.qDt = paramInt1;
        String str = getResources().getStringArray(2130903045)[(paramInt1 - 1)];
        this.qDr.setText(String.format(str, new Object[] { Integer.valueOf(paramInt2) }));
        AppMethodBeat.o(23068);
        return;
        if (this.qDt != paramInt1) {
          this.krF.setProgress(qDw[(paramInt1 - 1)]);
        }
      }
      label163:
      f1 = f2;
    }
  }
  
  public int getLayoutId()
  {
    return 2131493815;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(23065);
    if (this.qDu)
    {
      cAR();
      AppMethodBeat.o(23065);
      return;
    }
    finish();
    AppMethodBeat.o(23065);
  }
  
  public final void onCanceled()
  {
    AppMethodBeat.i(23071);
    this.qDu = false;
    this.qDp = null;
    Log.i("MicroMsg.DBRecoveryUI", "Recovery cancelled.");
    cAS();
    com.tencent.mm.ui.base.h.a(this, 2131758243, 0, false, this.qDv);
    AppMethodBeat.o(23071);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23064);
    super.onCreate(paramBundle);
    this.mScene = getIntent().getIntExtra("scene", 2);
    this.qDu = false;
    setMMTitle(2131758240);
    this.qDq = findViewById(2131308372);
    this.mQo = findViewById(2131299719);
    this.krF = ((ProgressBar)findViewById(2131306284));
    this.qDr = ((TextView)findViewById(2131306299));
    findViewById(2131308361).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(23054);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/dbbackup/DBRecoveryUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (com.tencent.mm.kernel.g.aAh().azL() == null)
        {
          com.tencent.mm.ui.base.h.n(DBRecoveryUI.this, 2131758245, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/dbbackup/DBRecoveryUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(23054);
          return;
        }
        if (DBRecoveryUI.a(DBRecoveryUI.this) != 0) {
          com.tencent.mm.ui.base.h.a(DBRecoveryUI.this, 2131758238, 0, 2131758252, 2131758241, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(23053);
              com.tencent.mm.plugin.report.e.Cxv.idkeyStat(873L, 25L, 1L, false);
              DBRecoveryUI.d(DBRecoveryUI.this);
              AppMethodBeat.o(23053);
            }
          }, null, 2131100014);
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
    this.qDs = findViewById(2131297963);
    this.qDs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(23055);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/dbbackup/DBRecoveryUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
      cAQ();
    }
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(181L, this.mScene + 51, 1L, true);
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(873L, 14L, 1L, false);
    if (this.mScene == 2) {
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(873L, 15L, 1L, false);
    }
    AppMethodBeat.o(23064);
  }
  
  public final void onFailure()
  {
    AppMethodBeat.i(23072);
    this.qDu = false;
    this.qDp = null;
    Log.e("MicroMsg.DBRecoveryUI", "Recovery failed.");
    cAS();
    com.tencent.mm.ui.base.h.a(this, 2131758244, 0, false, this.qDv);
    AppMethodBeat.o(23072);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(23070);
    this.qDu = false;
    this.qDp = null;
    Log.i("MicroMsg.DBRecoveryUI", "Recovery succeeded");
    final com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.ui.base.h.a(this, 2131758251, 0, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(23061);
        DBRecoveryUI.this.finish();
        d.cAZ();
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
          d.cAZ();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.DBRecoveryUI
 * JD-Core Version:    0.7.0.1
 */