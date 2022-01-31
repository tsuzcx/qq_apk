package com.tencent.mm.plugin.dbbackup;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.dbbackup.a.a.a;
import com.tencent.mm.plugin.dbbackup.a.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;

public class DBRecoveryUI
  extends MMActivity
  implements a.b
{
  private static final int[] kTH = { 0, 5, 70, 80, 90, 100, 100 };
  private ProgressBar gJE;
  private View kTA;
  private View kTB;
  private TextView kTC;
  private View kTD;
  private int kTE;
  private boolean kTF;
  private DialogInterface.OnClickListener kTG;
  private com.tencent.mm.plugin.dbbackup.a.a kTz;
  private int mScene;
  
  public DBRecoveryUI()
  {
    AppMethodBeat.i(18954);
    this.kTG = new DBRecoveryUI.1(this);
    AppMethodBeat.o(18954);
  }
  
  private void biJ()
  {
    AppMethodBeat.i(18957);
    if (this.kTz != null)
    {
      ab.e("MicroMsg.DBRecoveryUI", "Recovery task has already started.");
      AppMethodBeat.o(18957);
      return;
    }
    this.kTA.setVisibility(8);
    this.kTB.setVisibility(0);
    this.kTD.setEnabled(true);
    Object localObject1 = new StringBuilder().append(q.bP(true));
    com.tencent.mm.kernel.g.RJ();
    Object localObject2 = com.tencent.mm.a.g.w(com.tencent.mm.kernel.a.getUin().getBytes()).substring(0, 7).getBytes();
    localObject1 = com.tencent.mm.kernel.g.RL().Ro();
    String str1 = com.tencent.mm.kernel.g.RL().eHS.getPath();
    String str2 = str1 + "-recovery";
    this.kTE = 0;
    String str3 = com.tencent.mm.kernel.g.RL().eHR + "dbback/";
    a.a locala = new a.a();
    locala.kUO = this;
    localObject2 = locala.aD((byte[])localObject2).aE((byte[])localObject2);
    ((a.a)localObject2).kUM = new DBRecoveryUI.5(this);
    ((a.a)localObject2).kUE = ((String)localObject1);
    ((a.a)localObject2).kUD = str1;
    ((a.a)localObject2).kUC = str2;
    ((a.a)localObject2).kUF = (com.tencent.mm.kernel.g.RL().cachePath + "heavyDetailInfo");
    if (this.mScene == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((a.a)localObject2).kUN = bool;
      this.kTz = ((a.a)localObject2).Jw((String)localObject1 + ".sm").Jx((String)localObject1 + ".bak").Jw(str3 + "corrupted/EnMicroMsg.db.sm").Jx(str3 + "corrupted/EnMicroMsg.db.bak").Jw(str3 + "EnMicroMsg.db.sm").Jx(str3 + "EnMicroMsg.db.bak").bja();
      this.kTz.execute(new Void[0]);
      this.kTF = true;
      AppMethodBeat.o(18957);
      return;
    }
  }
  
  private void biK()
  {
    AppMethodBeat.i(18958);
    this.kTD.setEnabled(false);
    if (this.kTz != null)
    {
      this.kTz.cancel();
      this.kTz = null;
      AppMethodBeat.o(18958);
      return;
    }
    ab.e("MicroMsg.DBRecoveryUI", "Recovery task is not running.");
    AppMethodBeat.o(18958);
  }
  
  private static void biL()
  {
    AppMethodBeat.i(18964);
    z localz = com.tencent.mm.kernel.g.RL().Ru();
    localz.set(89, Integer.valueOf(2));
    localz.dww();
    AppMethodBeat.o(18964);
  }
  
  public final void H(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(18960);
    this.kTF = false;
    this.kTz = null;
    biL();
    com.tencent.mm.ui.base.h.a(this, getString(2131298917, new Object[] { Long.valueOf(paramLong2 / 1024L / 1024L), Long.valueOf(paramLong1 / 1024L / 1024L) }), null, false, this.kTG);
    AppMethodBeat.o(18960);
  }
  
  public final void Q(int paramInt1, int paramInt2, int paramInt3)
  {
    float f1 = 1.0F;
    AppMethodBeat.i(18959);
    if ((paramInt1 <= 0) || (paramInt1 > 6))
    {
      AppMethodBeat.o(18959);
      return;
    }
    int i;
    int j;
    float f2;
    if (paramInt3 > 0)
    {
      i = kTH[(paramInt1 - 1)];
      j = kTH[paramInt1];
      f2 = paramInt2 / paramInt3;
      if (f2 <= 1.0F) {
        break label163;
      }
    }
    for (;;)
    {
      f2 = i;
      paramInt3 = (int)(f1 * (j - i) + f2);
      this.gJE.setProgress(paramInt3);
      for (;;)
      {
        this.kTE = paramInt1;
        String str = getResources().getStringArray(2131755013)[(paramInt1 - 1)];
        this.kTC.setText(String.format(str, new Object[] { Integer.valueOf(paramInt2) }));
        AppMethodBeat.o(18959);
        return;
        if (this.kTE != paramInt1) {
          this.gJE.setProgress(kTH[(paramInt1 - 1)]);
        }
      }
      label163:
      f1 = f2;
    }
  }
  
  public int getLayoutId()
  {
    return 2130969296;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(18956);
    if (this.kTF)
    {
      biK();
      AppMethodBeat.o(18956);
      return;
    }
    finish();
    AppMethodBeat.o(18956);
  }
  
  public final void onCanceled()
  {
    AppMethodBeat.i(18962);
    this.kTF = false;
    this.kTz = null;
    ab.i("MicroMsg.DBRecoveryUI", "Recovery cancelled.");
    biL();
    com.tencent.mm.ui.base.h.a(this, 2131298911, 0, false, this.kTG);
    AppMethodBeat.o(18962);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(18955);
    super.onCreate(paramBundle);
    this.mScene = getIntent().getIntExtra("scene", 2);
    this.kTF = false;
    setMMTitle(2131298908);
    this.kTA = findViewById(2131823303);
    this.kTB = findViewById(2131823305);
    this.gJE = ((ProgressBar)findViewById(2131821119));
    this.kTC = ((TextView)findViewById(2131823306));
    findViewById(2131823304).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(18945);
        if (com.tencent.mm.kernel.g.RL().Ro() == null)
        {
          com.tencent.mm.ui.base.h.h(DBRecoveryUI.this, 2131298913, 0);
          AppMethodBeat.o(18945);
          return;
        }
        com.tencent.mm.ui.base.h.a(DBRecoveryUI.this, 2131298906, 0, 2131298920, 2131298909, false, new DBRecoveryUI.2.1(this), null, 2131689739);
        AppMethodBeat.o(18945);
      }
    });
    this.kTD = findViewById(2131822887);
    this.kTD.setOnClickListener(new DBRecoveryUI.3(this));
    setBackBtn(new DBRecoveryUI.4(this));
    if (this.mScene == 0) {
      biJ();
    }
    com.tencent.mm.plugin.report.e.qrI.idkeyStat(181L, this.mScene + 51, 1L, true);
    com.tencent.mm.plugin.report.e.qrI.idkeyStat(873L, 14L, 1L, false);
    if (this.mScene == 2) {
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(873L, 15L, 1L, false);
    }
    AppMethodBeat.o(18955);
  }
  
  public final void onFailure()
  {
    AppMethodBeat.i(18963);
    this.kTF = false;
    this.kTz = null;
    ab.e("MicroMsg.DBRecoveryUI", "Recovery failed.");
    biL();
    com.tencent.mm.ui.base.h.a(this, 2131298912, 0, false, this.kTG);
    AppMethodBeat.o(18963);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(18961);
    this.kTF = false;
    this.kTz = null;
    ab.i("MicroMsg.DBRecoveryUI", "Recovery succeeded");
    al.p(new DBRecoveryUI.7(this, com.tencent.mm.ui.base.h.a(this, 2131298919, 0, false, new DBRecoveryUI.6(this))), 5000L);
    AppMethodBeat.o(18961);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.DBRecoveryUI
 * JD-Core Version:    0.7.0.1
 */