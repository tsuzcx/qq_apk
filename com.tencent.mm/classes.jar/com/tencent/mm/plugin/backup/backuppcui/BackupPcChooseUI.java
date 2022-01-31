package com.tencent.mm.plugin.backup.backuppcui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.e;
import com.tencent.mm.plugin.backup.c.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMWizardActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class BackupPcChooseUI
  extends MMWizardActivity
{
  private static int ayi = 0;
  private static long endTime;
  private static int jCK = 0;
  private static long startTime;
  private ProgressBar jCA;
  private View jCB;
  private LinearLayout jCC;
  private LinearLayout jCD;
  private LinearLayout jCE;
  private LinearLayout jCF;
  private TextView jCG;
  private TextView jCH;
  private TextView jCI;
  private Button jCJ;
  private SimpleDateFormat jCL;
  private TextView jCx;
  private TextView jCy;
  private TextView jCz;
  private a jEH;
  private ListView jEI;
  private b.a jEJ;
  
  public BackupPcChooseUI()
  {
    AppMethodBeat.i(17579);
    this.jEH = new a(this);
    this.jCL = new SimpleDateFormat("yyyy.MM.dd");
    this.jEJ = new BackupPcChooseUI.5(this);
    AppMethodBeat.o(17579);
  }
  
  private void aTM()
  {
    AppMethodBeat.i(17586);
    if ((this.jCD.getVisibility() == 8) && (this.jCE.getVisibility() == 8) && (this.jCF.getVisibility() == 8))
    {
      this.jCB.setVisibility(8);
      this.jCC.setVisibility(8);
      AppMethodBeat.o(17586);
      return;
    }
    this.jCB.setVisibility(0);
    this.jCC.setVisibility(0);
    AppMethodBeat.o(17586);
  }
  
  private void fA(boolean paramBoolean)
  {
    AppMethodBeat.i(17584);
    if (paramBoolean)
    {
      b.aTX();
      SharedPreferences localSharedPreferences = b.aSQ();
      jCK = localSharedPreferences.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
      ayi = localSharedPreferences.getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
      startTime = localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
      endTime = localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
    }
    if (b.aTX().aTZ().jEv) {}
    switch (jCK)
    {
    default: 
      if (b.aTX().aTZ().jEw) {
        switch (ayi)
        {
        }
      }
      break;
    }
    for (;;)
    {
      aTM();
      AppMethodBeat.o(17584);
      return;
      this.jCE.setVisibility(8);
      break;
      this.jCB.setVisibility(0);
      this.jCC.setVisibility(0);
      this.jCE.setVisibility(0);
      this.jCH.setText(this.jCL.format(new Date(startTime)) + "~" + this.jCL.format(new Date(endTime - 86400000L)));
      break;
      this.jCF.setVisibility(8);
      continue;
      this.jCB.setVisibility(0);
      this.jCC.setVisibility(0);
      this.jCF.setVisibility(0);
      this.jCI.setText(getContext().getResources().getString(2131297361));
    }
  }
  
  public final void a(HashSet<Integer> paramHashSet)
  {
    AppMethodBeat.i(17585);
    Object localObject = new HashSet();
    int i = b.aTX().aUb().aTn().size();
    Iterator localIterator = paramHashSet.iterator();
    while (localIterator.hasNext())
    {
      int j = ((Integer)localIterator.next()).intValue();
      if (j >= i) {
        ((HashSet)localObject).add(Integer.valueOf(j));
      }
    }
    localObject = ((HashSet)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramHashSet.remove(Integer.valueOf(((Integer)((Iterator)localObject).next()).intValue()));
    }
    if (paramHashSet.size() != 0)
    {
      this.jCJ.setEnabled(true);
      if ((b.aTX().aUb().jAT) && (paramHashSet.size() == this.jEH.getCount()))
      {
        this.jCx.setText(2131297222);
        this.jCB.setVisibility(0);
        this.jCC.setVisibility(0);
        this.jCD.setVisibility(0);
        this.jCG.setText(getString(2131297224, new Object[] { Integer.valueOf(paramHashSet.size()) }));
      }
    }
    for (;;)
    {
      aTM();
      AppMethodBeat.o(17585);
      return;
      this.jCx.setText(2131297221);
      break;
      this.jCJ.setEnabled(false);
      this.jCx.setText(2131297221);
      this.jCD.setVisibility(8);
      this.jCG.setText("");
    }
  }
  
  public int getLayoutId()
  {
    return 2130968800;
  }
  
  public void initView()
  {
    AppMethodBeat.i(17583);
    setMMTitle(2131297367);
    this.jEI = ((ListView)findViewById(2131821601));
    this.jEI.setAdapter(this.jEH);
    this.jEI.setEmptyView(findViewById(2131821602));
    this.jCx = ((TextView)findViewById(2131821616));
    this.jCy = ((TextView)findViewById(2131821604));
    this.jCA = ((ProgressBar)findViewById(2131821603));
    this.jCz = ((TextView)findViewById(2131821617));
    this.jCB = findViewById(2131821605);
    this.jCC = ((LinearLayout)findViewById(2131821606));
    this.jCD = ((LinearLayout)findViewById(2131821607));
    this.jCE = ((LinearLayout)findViewById(2131821610));
    this.jCF = ((LinearLayout)findViewById(2131821613));
    this.jCG = ((TextView)findViewById(2131821609));
    this.jCH = ((TextView)findViewById(2131821612));
    this.jCI = ((TextView)findViewById(2131821615));
    ((TextView)findViewById(2131821608)).setText(2131297310);
    ((TextView)findViewById(2131821611)).setText(2131297313);
    ((TextView)findViewById(2131821614)).setText(2131297308);
    setBackBtn(new BackupPcChooseUI.1(this));
    this.jCJ = ((Button)findViewById(2131821618));
    this.jCJ.setOnClickListener(new BackupPcChooseUI.2(this));
    this.jCJ.setEnabled(false);
    if ((!b.aTX().aTZ().jEv) && (!b.aTX().aTZ().jEw)) {
      this.jCz.setVisibility(8);
    }
    for (;;)
    {
      this.jCx.setOnClickListener(new BackupPcChooseUI.4(this));
      if (b.aTX().aUb().jAT) {
        break;
      }
      this.jCx.setTextColor(getResources().getColor(2131689741));
      this.jCx.setClickable(false);
      this.jCA.setVisibility(0);
      AppMethodBeat.o(17583);
      return;
      this.jCz.setVisibility(0);
      fA(true);
      this.jCz.setOnClickListener(new BackupPcChooseUI.3(this));
    }
    if (b.aTX().aUb().aTn().size() == 0) {
      switch (jCK)
      {
      }
    }
    for (;;)
    {
      this.jCy.setVisibility(0);
      this.jCA.setVisibility(4);
      AppMethodBeat.o(17583);
      return;
      this.jCy.setText(2131297309);
      continue;
      this.jCy.setText(2131297379);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(17587);
    if (paramInt2 != -1)
    {
      ab.e("MicroMsg.BackupPcChooseUI", "onActivityResult result error! resultCode[%d]", new Object[] { Integer.valueOf(paramInt2) });
      AppMethodBeat.o(17587);
      return;
    }
    paramInt1 = jCK;
    long l1 = startTime;
    long l2 = endTime;
    jCK = paramIntent.getIntExtra("BACKUP_SELECT_TIME_MODE", jCK);
    startTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0L);
    endTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0L);
    ayi = paramIntent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", ayi);
    ab.i("MicroMsg.BackupPcChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", new Object[] { Integer.valueOf(jCK), Integer.valueOf(paramInt1), Long.valueOf(startTime), Long.valueOf(l1), Long.valueOf(endTime), Long.valueOf(l2), Integer.valueOf(ayi) });
    b.aTX().aTZ();
    e.f(jCK, startTime, endTime, ayi);
    fA(false);
    if ((paramInt1 == jCK) && ((jCK == 0) || ((jCK == 1) && (startTime == l1) && (endTime == l2))))
    {
      AppMethodBeat.o(17587);
      return;
    }
    b.aTX().aUb().a(jCK, startTime, endTime, b.aTX().aUb().aTm());
    paramIntent = this.jEH;
    paramIntent.jCr.clear();
    paramIntent.jEE.a(paramIntent.jCr);
    if ((b.aTX().aUb().aTn() == null) || (b.aTX().aUb().aTn().size() == 0)) {
      switch (jCK)
      {
      default: 
        this.jCy.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jEH.notifyDataSetChanged();
      AppMethodBeat.o(17587);
      return;
      this.jCy.setText(2131297309);
      break;
      this.jCy.setText(2131297379);
      break;
      this.jCy.setVisibility(4);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(17580);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false))
    {
      AppMethodBeat.o(17580);
      return;
    }
    initView();
    AppMethodBeat.o(17580);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(17581);
    super.onStart();
    b.aTX().aUb().jDS = this.jEJ;
    AppMethodBeat.o(17581);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(17582);
    super.onStop();
    b.aTX().aUb().jDS = null;
    AppMethodBeat.o(17582);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI
 * JD-Core Version:    0.7.0.1
 */