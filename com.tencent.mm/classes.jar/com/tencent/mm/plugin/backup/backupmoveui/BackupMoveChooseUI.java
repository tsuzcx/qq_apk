package com.tencent.mm.plugin.backup.backupmoveui;

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
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.c.b.b;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.plugin.backup.d.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMWizardActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class BackupMoveChooseUI
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
  private b.b jCM;
  private a jCv;
  private ListView jCw;
  private TextView jCx;
  private TextView jCy;
  private TextView jCz;
  
  public BackupMoveChooseUI()
  {
    AppMethodBeat.i(17329);
    this.jCv = new a(this);
    this.jCL = new SimpleDateFormat("yyyy.MM.dd");
    this.jCM = new BackupMoveChooseUI.5(this);
    AppMethodBeat.o(17329);
  }
  
  private void aTM()
  {
    AppMethodBeat.i(17336);
    if ((this.jCD.getVisibility() == 8) && (this.jCE.getVisibility() == 8) && (this.jCF.getVisibility() == 8))
    {
      this.jCB.setVisibility(8);
      this.jCC.setVisibility(8);
      AppMethodBeat.o(17336);
      return;
    }
    this.jCB.setVisibility(0);
    this.jCC.setVisibility(0);
    AppMethodBeat.o(17336);
  }
  
  private void fA(boolean paramBoolean)
  {
    AppMethodBeat.i(17334);
    if (paramBoolean)
    {
      b.aTr();
      SharedPreferences localSharedPreferences = b.aSQ();
      jCK = localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
      ayi = localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
      startTime = localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
      endTime = localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
    }
    switch (jCK)
    {
    default: 
      switch (ayi)
      {
      }
      break;
    }
    for (;;)
    {
      aTM();
      AppMethodBeat.o(17334);
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
      this.jCI.setText(getContext().getResources().getString(2131297291));
    }
  }
  
  public final void a(HashSet<Integer> paramHashSet)
  {
    AppMethodBeat.i(17335);
    Object localObject = b.aTr().aTv().aTn();
    if (localObject == null)
    {
      ab.e("MicroMsg.BackupMoveChooseUI", "onClickCheckBox convInfo is null.");
      AppMethodBeat.o(17335);
      return;
    }
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramHashSet.iterator();
    long l = 0L;
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if (i < ((LinkedList)localObject).size()) {
        l = ((f.b)((LinkedList)localObject).get(i)).jzd + l;
      } else {
        localHashSet.add(Integer.valueOf(i));
      }
    }
    localObject = localHashSet.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramHashSet.remove((Integer)((Iterator)localObject).next());
    }
    if ((paramHashSet.size() != 0) || (l > 0L))
    {
      this.jCJ.setEnabled(true);
      if (paramHashSet.size() == this.jCv.getCount())
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
      AppMethodBeat.o(17335);
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
    AppMethodBeat.i(17333);
    setMMTitle(2131297390);
    this.jCw = ((ListView)findViewById(2131821601));
    this.jCw.setAdapter(this.jCv);
    this.jCw.setEmptyView(findViewById(2131821602));
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
    ((TextView)findViewById(2131821608)).setText(2131297232);
    ((TextView)findViewById(2131821611)).setText(2131297234);
    ((TextView)findViewById(2131821614)).setText(2131297230);
    setBackBtn(new BackupMoveChooseUI.1(this));
    this.jCJ = ((Button)findViewById(2131821618));
    this.jCJ.setOnClickListener(new BackupMoveChooseUI.2(this));
    this.jCJ.setEnabled(false);
    fA(true);
    this.jCz.setOnClickListener(new BackupMoveChooseUI.3(this));
    this.jCx.setOnClickListener(new BackupMoveChooseUI.4(this));
    if (b.aTr().aTv().jAT)
    {
      if ((b.aTr().aTv().aTn() == null) || (b.aTr().aTv().aTn().size() == 0)) {
        switch (jCK)
        {
        }
      }
      for (;;)
      {
        this.jCy.setVisibility(0);
        this.jCA.setVisibility(4);
        AppMethodBeat.o(17333);
        return;
        this.jCy.setText(2131297231);
        continue;
        this.jCy.setText(2131297379);
      }
    }
    if (!b.aTr().aTv().jAT)
    {
      this.jCx.setTextColor(getResources().getColor(2131689741));
      this.jCx.setClickable(false);
      this.jCA.setVisibility(0);
      AppMethodBeat.o(17333);
      return;
    }
    this.jCA.setVisibility(4);
    AppMethodBeat.o(17333);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(17337);
    if (paramInt2 != -1)
    {
      ab.e("MicroMsg.BackupMoveChooseUI", "onActivityResult result error! resultCode:%d", new Object[] { Integer.valueOf(paramInt2) });
      AppMethodBeat.o(17337);
      return;
    }
    paramInt1 = jCK;
    long l1 = startTime;
    long l2 = endTime;
    jCK = paramIntent.getIntExtra("BACKUP_SELECT_TIME_MODE", jCK);
    startTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0L);
    endTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0L);
    ayi = paramIntent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", ayi);
    ab.i("MicroMsg.BackupMoveChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", new Object[] { Integer.valueOf(jCK), Integer.valueOf(paramInt1), Long.valueOf(startTime), Long.valueOf(l1), Long.valueOf(endTime), Long.valueOf(l2), Integer.valueOf(ayi) });
    b.aTr().aTt();
    d.e(jCK, startTime, endTime, ayi);
    fA(false);
    if ((paramInt1 == jCK) && ((jCK == 0) || ((jCK == 1) && (startTime == l1) && (endTime == l2))))
    {
      AppMethodBeat.o(17337);
      return;
    }
    b.aTr().aTv().a(jCK, startTime, endTime, b.aTr().aTv().aTm());
    paramIntent = this.jCv;
    paramIntent.jCr.clear();
    paramIntent.jCq.a(paramIntent.jCr);
    if ((b.aTr().aTv().aTn() == null) || (b.aTr().aTv().aTn().size() == 0)) {
      switch (jCK)
      {
      default: 
        this.jCy.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jCv.notifyDataSetChanged();
      AppMethodBeat.o(17337);
      return;
      this.jCy.setText(2131297231);
      break;
      this.jCy.setText(2131297379);
      break;
      this.jCy.setVisibility(4);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(17330);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(17330);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(17331);
    super.onStart();
    b.aTr().aTv().jAO = this.jCM;
    AppMethodBeat.o(17331);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(17332);
    super.onStop();
    b.aTr().aTv().jAO = null;
    AppMethodBeat.o(17332);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI
 * JD-Core Version:    0.7.0.1
 */