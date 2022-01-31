package com.tencent.mm.plugin.dbbackup;

import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.dbbackup.a.a.a;
import com.tencent.mm.plugin.dbbackup.a.a.b;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.wcdb.support.CancellationSignal;
import java.util.ArrayList;
import java.util.Arrays;

public class DBRecoveryUI
  extends MMActivity
  implements a.b
{
  private static final int[] iMJ = { 0, 5, 70, 80, 90, 100, 100 };
  private ProgressBar fsc;
  private int fzn;
  private com.tencent.mm.plugin.dbbackup.a.a iMB;
  private View iMC;
  private View iMD;
  private TextView iME;
  private View iMF;
  private int iMG;
  private boolean iMH;
  private DialogInterface.OnClickListener iMI = new DBRecoveryUI.1(this);
  
  private void aFr()
  {
    if (this.iMB != null)
    {
      y.e("MicroMsg.DBRecoveryUI", "Recovery task has already started.");
      return;
    }
    this.iMC.setVisibility(8);
    this.iMD.setVisibility(0);
    this.iMF.setEnabled(true);
    Object localObject1 = new StringBuilder().append(q.zf());
    com.tencent.mm.kernel.g.DN();
    localObject1 = com.tencent.mm.kernel.a.CK().getBytes();
    Object localObject2 = com.tencent.mm.kernel.g.DP().Du();
    String str1 = com.tencent.mm.kernel.g.DP().dKu.getPath();
    String str2 = str1 + "-recovery";
    this.iMG = 0;
    String str3 = com.tencent.mm.kernel.g.DP().dKt + "dbback/";
    a.a locala = new a.a();
    locala.iNL = this;
    locala.iNI = com.tencent.mm.a.g.p((byte[])localObject1);
    locala.iNJ = com.tencent.mm.a.g.o((byte[])localObject1).substring(0, 7).getBytes();
    locala.iNE = ((String)localObject2);
    locala.iND = str1;
    locala.iNC = str2;
    locala.iNF = (com.tencent.mm.kernel.g.DP().cachePath + "heavyDetailInfo");
    if (this.fzn == 0) {}
    for (boolean bool = true;; bool = false)
    {
      locala.iNK = bool;
      localObject1 = locala.zC((String)localObject2 + ".sm").zD((String)localObject2 + ".bak").zC(str3 + "corrupted/EnMicroMsg.db.sm").zD(str3 + "corrupted/EnMicroMsg.db.bak").zC(str3 + "EnMicroMsg.db.sm").zD(str3 + "EnMicroMsg.db.bak");
      localObject2 = new com.tencent.mm.plugin.dbbackup.a.a((byte)0);
      com.tencent.mm.plugin.dbbackup.a.a.a((com.tencent.mm.plugin.dbbackup.a.a)localObject2, ((a.a)localObject1).iNC);
      com.tencent.mm.plugin.dbbackup.a.a.b((com.tencent.mm.plugin.dbbackup.a.a)localObject2, ((a.a)localObject1).iND);
      com.tencent.mm.plugin.dbbackup.a.a.c((com.tencent.mm.plugin.dbbackup.a.a)localObject2, ((a.a)localObject1).iNE);
      com.tencent.mm.plugin.dbbackup.a.a.d((com.tencent.mm.plugin.dbbackup.a.a)localObject2, ((a.a)localObject1).iNF);
      com.tencent.mm.plugin.dbbackup.a.a.a((com.tencent.mm.plugin.dbbackup.a.a)localObject2, new ArrayList(((a.a)localObject1).iNG));
      com.tencent.mm.plugin.dbbackup.a.a.b((com.tencent.mm.plugin.dbbackup.a.a)localObject2, new ArrayList(((a.a)localObject1).iNH));
      com.tencent.mm.plugin.dbbackup.a.a.a((com.tencent.mm.plugin.dbbackup.a.a)localObject2, Arrays.copyOf(((a.a)localObject1).iNI, ((a.a)localObject1).iNI.length));
      com.tencent.mm.plugin.dbbackup.a.a.b((com.tencent.mm.plugin.dbbackup.a.a)localObject2, Arrays.copyOf(((a.a)localObject1).iNJ, ((a.a)localObject1).iNJ.length));
      com.tencent.mm.plugin.dbbackup.a.a.a((com.tencent.mm.plugin.dbbackup.a.a)localObject2, ((a.a)localObject1).iNK);
      com.tencent.mm.plugin.dbbackup.a.a.a((com.tencent.mm.plugin.dbbackup.a.a)localObject2, ((a.a)localObject1).iNL);
      this.iMB = ((com.tencent.mm.plugin.dbbackup.a.a)localObject2);
      this.iMB.execute(new Void[0]);
      this.iMH = true;
      return;
    }
  }
  
  private void aFs()
  {
    this.iMF.setEnabled(false);
    if (this.iMB != null)
    {
      this.iMB.mCancellationSignal.cancel();
      y.i("MicroMsg.DBRecoveryTask", "Recovery cancel triggered.");
      this.iMB = null;
      return;
    }
    y.e("MicroMsg.DBRecoveryUI", "Recovery task is not running.");
  }
  
  private static void aFv()
  {
    z localz = com.tencent.mm.kernel.g.DP().Dz();
    localz.o(89, Integer.valueOf(2));
    localz.mC(true);
  }
  
  public final void E(int paramInt1, int paramInt2, int paramInt3)
  {
    float f1 = 1.0F;
    if ((paramInt1 <= 0) || (paramInt1 > 6)) {
      return;
    }
    int i;
    int j;
    float f2;
    if (paramInt3 > 0)
    {
      i = iMJ[(paramInt1 - 1)];
      j = iMJ[paramInt1];
      f2 = paramInt2 / paramInt3;
      if (f2 <= 1.0F) {
        break label145;
      }
    }
    for (;;)
    {
      f2 = i;
      paramInt3 = (int)(f1 * (j - i) + f2);
      this.fsc.setProgress(paramInt3);
      for (;;)
      {
        this.iMG = paramInt1;
        String str = getResources().getStringArray(com.tencent.mm.R.c.data_recovery_progress)[(paramInt1 - 1)];
        this.iME.setText(String.format(str, new Object[] { Integer.valueOf(paramInt2) }));
        return;
        if (this.iMG != paramInt1) {
          this.fsc.setProgress(iMJ[(paramInt1 - 1)]);
        }
      }
      label145:
      f1 = f2;
    }
  }
  
  public final void aFt()
  {
    this.iMH = false;
    this.iMB = null;
    y.i("MicroMsg.DBRecoveryUI", "Recovery cancelled.");
    aFv();
    com.tencent.mm.ui.base.h.a(this, R.l.data_recovery_canceled, 0, false, this.iMI);
  }
  
  public final void aFu()
  {
    this.iMH = false;
    this.iMB = null;
    y.e("MicroMsg.DBRecoveryUI", "Recovery failed.");
    aFv();
    com.tencent.mm.ui.base.h.a(this, R.l.data_recovery_failed, 0, false, this.iMI);
  }
  
  protected final int getLayoutId()
  {
    return R.i.db_recover_ui;
  }
  
  public void onBackPressed()
  {
    if (this.iMH)
    {
      aFs();
      return;
    }
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.fzn = getIntent().getIntExtra("scene", 2);
    this.iMH = false;
    setMMTitle(R.l.data_recovery);
    this.iMC = findViewById(R.h.start_recover);
    this.iMD = findViewById(R.h.do_recover);
    this.fsc = ((ProgressBar)findViewById(R.h.progress_bar));
    this.iME = ((TextView)findViewById(R.h.progress_text));
    findViewById(R.h.start_btn).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if (com.tencent.mm.kernel.g.DP().Du() == null)
        {
          com.tencent.mm.ui.base.h.h(DBRecoveryUI.this, R.l.data_recovery_no_data, 0);
          return;
        }
        com.tencent.mm.ui.base.h.a(DBRecoveryUI.this, R.l.data_recover_warning, 0, R.l.data_recovery_sure, R.l.data_recovery_cancel, false, new DBRecoveryUI.2.1(this), null, R.e.backup_green);
      }
    });
    this.iMF = findViewById(R.h.cancel_btn);
    this.iMF.setOnClickListener(new DBRecoveryUI.3(this));
    setBackBtn(new DBRecoveryUI.4(this));
    if (this.fzn == 0) {
      aFr();
    }
    f.nEG.a(181L, this.fzn + 51, 1L, true);
    f.nEG.a(873L, 14L, 1L, false);
    if (this.fzn == 2) {
      f.nEG.a(873L, 15L, 1L, false);
    }
  }
  
  public final void onSuccess()
  {
    this.iMH = false;
    this.iMB = null;
    y.i("MicroMsg.DBRecoveryUI", "Recovery succeeded");
    ai.l(new DBRecoveryUI.6(this, com.tencent.mm.ui.base.h.a(this, R.l.data_recovery_success, 0, false, new DBRecoveryUI.5(this))), 5000L);
  }
  
  public final void v(long paramLong1, long paramLong2)
  {
    this.iMH = false;
    this.iMB = null;
    aFv();
    com.tencent.mm.ui.base.h.a(this, getString(R.l.data_recovery_space_not_enough, new Object[] { Long.valueOf(paramLong2 / 1024L / 1024L), Long.valueOf(paramLong1 / 1024L / 1024L) }), null, false, this.iMI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.DBRecoveryUI
 * JD-Core Version:    0.7.0.1
 */