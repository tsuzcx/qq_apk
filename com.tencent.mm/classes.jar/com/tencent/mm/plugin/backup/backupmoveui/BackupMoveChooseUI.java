package com.tencent.mm.plugin.backup.backupmoveui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI;
import com.tencent.mm.plugin.backup.c.b.b;
import com.tencent.mm.plugin.backup.d.a.2;
import com.tencent.mm.plugin.backup.d.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
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
  private static int aOl = 0;
  private static long endTime;
  private static int rOU = 0;
  private static long startTime;
  private a rOF;
  private ListView rOG;
  private TextView rOH;
  private TextView rOI;
  private TextView rOJ;
  private ProgressBar rOK;
  private View rOL;
  private LinearLayout rOM;
  private LinearLayout rON;
  private LinearLayout rOO;
  private LinearLayout rOP;
  private TextView rOQ;
  private TextView rOR;
  private TextView rOS;
  private Button rOT;
  private SimpleDateFormat rOV;
  private b.b rOW;
  
  public BackupMoveChooseUI()
  {
    AppMethodBeat.i(21387);
    this.rOF = new a(this);
    this.rOV = new SimpleDateFormat("yyyy.MM.dd");
    this.rOW = new b.b()
    {
      public final void D(LinkedList<f.b> paramAnonymousLinkedList)
      {
        AppMethodBeat.i(21386);
        if (paramAnonymousLinkedList == null)
        {
          AppMethodBeat.o(21386);
          return;
        }
        if (paramAnonymousLinkedList.size() == 0)
        {
          BackupMoveChooseUI.b(BackupMoveChooseUI.this).setVisibility(8);
          BackupMoveChooseUI.c(BackupMoveChooseUI.this).setVisibility(0);
          switch (BackupMoveChooseUI.rOU)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(21386);
            return;
            BackupMoveChooseUI.c(BackupMoveChooseUI.this).setText(R.l.ept);
            AppMethodBeat.o(21386);
            return;
            BackupMoveChooseUI.c(BackupMoveChooseUI.this).setText(R.l.erS);
          }
        }
        BackupMoveChooseUI.d(BackupMoveChooseUI.this).setClickable(true);
        BackupMoveChooseUI.d(BackupMoveChooseUI.this).setTextColor(BackupMoveChooseUI.this.getResources().getColor(R.e.dke));
        BackupMoveChooseUI.b(BackupMoveChooseUI.this).setVisibility(8);
        BackupMoveChooseUI.a(BackupMoveChooseUI.this).notifyDataSetChanged();
        AppMethodBeat.o(21386);
      }
      
      public final void E(LinkedList<f.b> paramAnonymousLinkedList) {}
      
      public final void a(LinkedList<f.b> paramAnonymousLinkedList, f.b paramAnonymousb, int paramAnonymousInt) {}
    };
    AppMethodBeat.o(21387);
  }
  
  private void ctd()
  {
    AppMethodBeat.i(21394);
    if ((this.rON.getVisibility() == 8) && (this.rOO.getVisibility() == 8) && (this.rOP.getVisibility() == 8))
    {
      this.rOL.setVisibility(8);
      this.rOM.setVisibility(8);
      AppMethodBeat.o(21394);
      return;
    }
    this.rOL.setVisibility(0);
    this.rOM.setVisibility(0);
    AppMethodBeat.o(21394);
  }
  
  private void kN(boolean paramBoolean)
  {
    AppMethodBeat.i(21392);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.backup.d.b.csI();
      SharedPreferences localSharedPreferences = com.tencent.mm.plugin.backup.d.b.cse();
      rOU = localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
      aOl = localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
      startTime = localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
      endTime = localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
    }
    switch (rOU)
    {
    default: 
      switch (aOl)
      {
      }
      break;
    }
    for (;;)
    {
      ctd();
      AppMethodBeat.o(21392);
      return;
      this.rOO.setVisibility(8);
      break;
      this.rOL.setVisibility(0);
      this.rOM.setVisibility(0);
      this.rOO.setVisibility(0);
      this.rOR.setText(this.rOV.format(new Date(startTime)) + "~" + this.rOV.format(new Date(endTime - 86400000L)));
      break;
      this.rOP.setVisibility(8);
      continue;
      this.rOL.setVisibility(0);
      this.rOM.setVisibility(0);
      this.rOP.setVisibility(0);
      this.rOS.setText(getContext().getResources().getString(R.l.eqA));
    }
  }
  
  public final void a(HashSet<Integer> paramHashSet)
  {
    AppMethodBeat.i(21393);
    Object localObject = com.tencent.mm.plugin.backup.d.b.csI().csM().csE();
    if (localObject == null)
    {
      Log.e("MicroMsg.BackupMoveChooseUI", "onClickCheckBox convInfo is null.");
      AppMethodBeat.o(21393);
      return;
    }
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramHashSet.iterator();
    long l = 0L;
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if (i < ((LinkedList)localObject).size()) {
        l = ((f.b)((LinkedList)localObject).get(i)).rLj + l;
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
      this.rOT.setEnabled(true);
      if (paramHashSet.size() == this.rOF.getCount())
      {
        this.rOH.setText(R.l.epn);
        this.rOL.setVisibility(0);
        this.rOM.setVisibility(0);
        this.rON.setVisibility(0);
        this.rOQ.setText(getString(R.l.dsy, new Object[] { Integer.valueOf(paramHashSet.size()) }));
      }
    }
    for (;;)
    {
      ctd();
      AppMethodBeat.o(21393);
      return;
      this.rOH.setText(R.l.epm);
      break;
      this.rOT.setEnabled(false);
      this.rOH.setText(R.l.epm);
      this.rON.setVisibility(8);
      this.rOQ.setText("");
    }
  }
  
  public int getLayoutId()
  {
    return R.i.ebO;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21391);
    setMMTitle(R.l.erV);
    this.rOG = ((ListView)findViewById(R.h.dso));
    this.rOG.setAdapter(this.rOF);
    this.rOG.setEmptyView(findViewById(R.h.dsq));
    this.rOH = ((TextView)findViewById(R.h.dsx));
    this.rOI = ((TextView)findViewById(R.h.dsp));
    this.rOK = ((ProgressBar)findViewById(R.h.dsw));
    this.rOJ = ((TextView)findViewById(R.h.dsr));
    this.rOL = findViewById(R.h.dsv);
    this.rOM = ((LinearLayout)findViewById(R.h.dss));
    this.rON = ((LinearLayout)findViewById(R.h.dsy));
    this.rOO = ((LinearLayout)findViewById(R.h.dsB));
    this.rOP = ((LinearLayout)findViewById(R.h.dsl));
    this.rOQ = ((TextView)findViewById(R.h.dsA));
    this.rOR = ((TextView)findViewById(R.h.dsD));
    this.rOS = ((TextView)findViewById(R.h.dsn));
    ((TextView)findViewById(R.h.dsz)).setText(R.l.epu);
    ((TextView)findViewById(R.h.dsC)).setText(R.l.epv);
    ((TextView)findViewById(R.h.dsm)).setText(R.l.eps);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(21382);
        BackupMoveChooseUI.this.finish();
        AppMethodBeat.o(21382);
        return false;
      }
    });
    this.rOT = ((Button)findViewById(R.h.dsu));
    this.rOT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21383);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        localObject1 = new PLong();
        Object localObject2 = new PInt();
        a locala = BackupMoveChooseUI.a(BackupMoveChooseUI.this);
        paramAnonymousView = new LinkedList();
        label117:
        int j;
        if (locala.rOC.size() <= 0)
        {
          localObject1 = g.C(paramAnonymousView);
          localObject2 = com.tencent.mm.plugin.backup.d.b.csI().csM();
          if (paramAnonymousView.size() != 0) {
            break label573;
          }
          ((com.tencent.mm.plugin.backup.d.a)localObject2).rMX = new LinkedList();
          com.tencent.mm.plugin.backup.d.b.csI().csK().H((LinkedList)localObject1);
          localObject1 = com.tencent.mm.plugin.backup.d.b.csI().csM();
          if (((com.tencent.mm.plugin.backup.d.a)localObject1).rMS != null) {
            ((com.tencent.mm.plugin.backup.d.a)localObject1).rMS.cancel();
          }
          ThreadPool.post(new a.2((com.tencent.mm.plugin.backup.d.a)localObject1), "BackupMoveChooseServer.calculateChooseConvSize");
          i = 0;
          if ((BackupMoveChooseUI.rOU != 1) || (BackupMoveChooseUI.Yx() != 1)) {
            break label626;
          }
          h.IzE.idkeyStat(485L, 26L, 1L, false);
          h.IzE.idkeyStat(485L, 27L, 1L, false);
          h.IzE.a(11788, new Object[] { Integer.valueOf(7) });
          h.IzE.a(11788, new Object[] { Integer.valueOf(14), Long.valueOf(System.currentTimeMillis()), Long.valueOf(BackupMoveChooseUI.startTime), Long.valueOf(BackupMoveChooseUI.endTime) });
          i = 0;
          label281:
          localObject1 = h.IzE;
          j = paramAnonymousView.size();
          if (i == 0) {
            break label842;
          }
        }
        label573:
        label842:
        for (int i = 1;; i = 0)
        {
          ((h)localObject1).a(11788, new Object[] { Integer.valueOf(13), Integer.valueOf(j), Integer.valueOf(i) });
          h.IzE.a(11788, new Object[] { Integer.valueOf(8) });
          paramAnonymousView = new Intent(BackupMoveChooseUI.this, BackupMoveQRCodeUI.class);
          MMWizardActivity.aH(BackupMoveChooseUI.this, paramAnonymousView);
          h.IzE.idkeyStat(485L, 23L, 1L, false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(21383);
          return;
          ((PLong)localObject1).value = 0L;
          ((PInt)localObject2).value = 0;
          LinkedList localLinkedList = com.tencent.mm.plugin.backup.d.b.csI().csM().csE();
          if (localLinkedList != null)
          {
            i = 0;
            while (i < locala.getCount())
            {
              if (locala.rOC.contains(Integer.valueOf(i)))
              {
                paramAnonymousView.add(localLinkedList.get(i));
                ((PLong)localObject1).value += ((f.b)localLinkedList.get(i)).rLj;
                ((PInt)localObject2).value = ((int)(((PInt)localObject2).value + ((f.b)localLinkedList.get(i)).rLk));
              }
              i += 1;
            }
          }
          Log.i("MicroMsg.BackupMoveChooseAdapter", "finishSelected usernameSize:%d, convSize:%d, convMsgCount:%d", new Object[] { Integer.valueOf(paramAnonymousView.size()), Long.valueOf(((PLong)localObject1).value), Integer.valueOf(((PInt)localObject2).value) });
          break;
          ((com.tencent.mm.plugin.backup.d.a)localObject2).rMX = new LinkedList(paramAnonymousView.subList(paramAnonymousView.size() * 3 / 4, paramAnonymousView.size()));
          ((com.tencent.mm.plugin.backup.d.a)localObject2).rMX.addAll(paramAnonymousView.subList(0, paramAnonymousView.size() * 3 / 4));
          break label117;
          label626:
          if (BackupMoveChooseUI.rOU == 1)
          {
            h.IzE.idkeyStat(485L, 26L, 1L, false);
            h.IzE.a(11788, new Object[] { Integer.valueOf(5) });
            h.IzE.a(11788, new Object[] { Integer.valueOf(14), Long.valueOf(System.currentTimeMillis()), Long.valueOf(BackupMoveChooseUI.startTime), Long.valueOf(BackupMoveChooseUI.endTime) });
            i = 0;
            break label281;
          }
          if (BackupMoveChooseUI.Yx() == 1)
          {
            h.IzE.idkeyStat(485L, 27L, 1L, false);
            h.IzE.a(11788, new Object[] { Integer.valueOf(6) });
            i = 0;
            break label281;
          }
          localObject1 = BackupMoveChooseUI.a(BackupMoveChooseUI.this);
          if (((a)localObject1).rOC.size() == ((a)localObject1).getCount()) {}
          for (j = 1;; j = 0)
          {
            if (j != 0)
            {
              i = 1;
              h.IzE.idkeyStat(485L, 22L, 1L, false);
              h.IzE.a(11788, new Object[] { Integer.valueOf(4) });
            }
            break;
          }
        }
      }
    });
    this.rOT.setEnabled(false);
    kN(true);
    this.rOJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21384);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new Intent(BackupMoveChooseUI.this, BackupSelectExtUI.class);
        paramAnonymousView.putExtra("BACKUP_MODE", 2);
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MODE", BackupMoveChooseUI.rOU);
        paramAnonymousView.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", true);
        paramAnonymousView.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupMoveChooseUI.Yx());
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupMoveChooseUI.startTime);
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupMoveChooseUI.endTime);
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", com.tencent.mm.plugin.backup.d.b.csI().csM().rMU);
        BackupMoveChooseUI.this.startActivityForResult(paramAnonymousView, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(21384);
      }
    });
    this.rOH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21385);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (com.tencent.mm.plugin.backup.d.b.csI().csM().rMY)
        {
          paramAnonymousView = BackupMoveChooseUI.a(BackupMoveChooseUI.this);
          if (paramAnonymousView.rOC.size() != paramAnonymousView.getCount()) {
            break label110;
          }
          paramAnonymousView.rOC.clear();
        }
        for (;;)
        {
          paramAnonymousView.notifyDataSetChanged();
          paramAnonymousView.rOB.a(paramAnonymousView.rOC);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(21385);
          return;
          label110:
          int i = 0;
          while (i < paramAnonymousView.getCount())
          {
            paramAnonymousView.rOC.add(Integer.valueOf(i));
            i += 1;
          }
        }
      }
    });
    if (com.tencent.mm.plugin.backup.d.b.csI().csM().rMY)
    {
      if ((com.tencent.mm.plugin.backup.d.b.csI().csM().csE() == null) || (com.tencent.mm.plugin.backup.d.b.csI().csM().csE().size() == 0)) {
        switch (rOU)
        {
        }
      }
      for (;;)
      {
        this.rOI.setVisibility(0);
        this.rOK.setVisibility(4);
        AppMethodBeat.o(21391);
        return;
        this.rOI.setText(R.l.ept);
        continue;
        this.rOI.setText(R.l.erS);
      }
    }
    if (!com.tencent.mm.plugin.backup.d.b.csI().csM().rMY)
    {
      this.rOH.setTextColor(getResources().getColor(R.e.dkg));
      this.rOH.setClickable(false);
      this.rOK.setVisibility(0);
      AppMethodBeat.o(21391);
      return;
    }
    this.rOK.setVisibility(4);
    AppMethodBeat.o(21391);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(21395);
    if (paramInt2 != -1)
    {
      Log.e("MicroMsg.BackupMoveChooseUI", "onActivityResult result error! resultCode:%d", new Object[] { Integer.valueOf(paramInt2) });
      AppMethodBeat.o(21395);
      return;
    }
    paramInt1 = rOU;
    long l1 = startTime;
    long l2 = endTime;
    rOU = paramIntent.getIntExtra("BACKUP_SELECT_TIME_MODE", rOU);
    startTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0L);
    endTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0L);
    aOl = paramIntent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", aOl);
    Log.i("MicroMsg.BackupMoveChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", new Object[] { Integer.valueOf(rOU), Integer.valueOf(paramInt1), Long.valueOf(startTime), Long.valueOf(l1), Long.valueOf(endTime), Long.valueOf(l2), Integer.valueOf(aOl) });
    com.tencent.mm.plugin.backup.d.b.csI().csK();
    d.e(rOU, startTime, endTime, aOl);
    kN(false);
    if ((paramInt1 == rOU) && ((rOU == 0) || ((rOU == 1) && (startTime == l1) && (endTime == l2))))
    {
      AppMethodBeat.o(21395);
      return;
    }
    com.tencent.mm.plugin.backup.d.b.csI().csM().a(rOU, startTime, endTime, com.tencent.mm.plugin.backup.d.b.csI().csM().csD());
    paramIntent = this.rOF;
    paramIntent.rOC.clear();
    paramIntent.rOB.a(paramIntent.rOC);
    if ((com.tencent.mm.plugin.backup.d.b.csI().csM().csE() == null) || (com.tencent.mm.plugin.backup.d.b.csI().csM().csE().size() == 0)) {
      switch (rOU)
      {
      default: 
        this.rOI.setVisibility(0);
      }
    }
    for (;;)
    {
      this.rOF.notifyDataSetChanged();
      AppMethodBeat.o(21395);
      return;
      this.rOI.setText(R.l.ept);
      break;
      this.rOI.setText(R.l.erS);
      break;
      this.rOI.setVisibility(4);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21388);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(21388);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(21389);
    super.onStart();
    com.tencent.mm.plugin.backup.d.b.csI().csM().rMT = this.rOW;
    AppMethodBeat.o(21389);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(21390);
    super.onStop();
    com.tencent.mm.plugin.backup.d.b.csI().csM().rMT = null;
    AppMethodBeat.o(21390);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI
 * JD-Core Version:    0.7.0.1
 */