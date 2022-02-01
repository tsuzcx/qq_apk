package com.tencent.mm.plugin.backup.backuppcui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.backuppcmodel.e;
import com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI;
import com.tencent.mm.plugin.backup.c.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
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
  private static int aOl = 0;
  private static long endTime;
  private static int rOU = 0;
  private static long startTime;
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
  private a rQO;
  private ListView rQP;
  private b.a rQQ;
  
  public BackupPcChooseUI()
  {
    AppMethodBeat.i(21638);
    this.rQO = new a(this);
    this.rOV = new SimpleDateFormat("yyyy.MM.dd");
    this.rQQ = new b.a()
    {
      public final void D(LinkedList<f.b> paramAnonymousLinkedList)
      {
        AppMethodBeat.i(21637);
        if (paramAnonymousLinkedList == null)
        {
          AppMethodBeat.o(21637);
          return;
        }
        if (paramAnonymousLinkedList.size() == 0)
        {
          BackupPcChooseUI.b(BackupPcChooseUI.this).setVisibility(8);
          BackupPcChooseUI.c(BackupPcChooseUI.this).setVisibility(0);
          switch (BackupPcChooseUI.rOU)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(21637);
            return;
            BackupPcChooseUI.c(BackupPcChooseUI.this).setText(R.l.eqN);
            AppMethodBeat.o(21637);
            return;
            BackupPcChooseUI.c(BackupPcChooseUI.this).setText(R.l.erS);
          }
        }
        BackupPcChooseUI.d(BackupPcChooseUI.this).setClickable(true);
        BackupPcChooseUI.d(BackupPcChooseUI.this).setTextColor(BackupPcChooseUI.this.getResources().getColor(R.e.dke));
        BackupPcChooseUI.b(BackupPcChooseUI.this).setVisibility(8);
        BackupPcChooseUI.a(BackupPcChooseUI.this).notifyDataSetChanged();
        AppMethodBeat.o(21637);
      }
    };
    AppMethodBeat.o(21638);
  }
  
  private void ctd()
  {
    AppMethodBeat.i(21645);
    if ((this.rON.getVisibility() == 8) && (this.rOO.getVisibility() == 8) && (this.rOP.getVisibility() == 8))
    {
      this.rOL.setVisibility(8);
      this.rOM.setVisibility(8);
      AppMethodBeat.o(21645);
      return;
    }
    this.rOL.setVisibility(0);
    this.rOM.setVisibility(0);
    AppMethodBeat.o(21645);
  }
  
  private void kN(boolean paramBoolean)
  {
    AppMethodBeat.i(21643);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.backup.backuppcmodel.b.ctm();
      SharedPreferences localSharedPreferences = com.tencent.mm.plugin.backup.backuppcmodel.b.cse();
      rOU = localSharedPreferences.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
      aOl = localSharedPreferences.getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
      startTime = localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
      endTime = localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
    }
    if (com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().cto().rQC) {}
    switch (rOU)
    {
    default: 
      if (com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().cto().rQD) {
        switch (aOl)
        {
        }
      }
      break;
    }
    for (;;)
    {
      ctd();
      AppMethodBeat.o(21643);
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
      this.rOS.setText(getContext().getResources().getString(R.l.erD));
    }
  }
  
  public final void a(HashSet<Integer> paramHashSet)
  {
    AppMethodBeat.i(21644);
    Object localObject = new HashSet();
    int i = com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().csE().size();
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
      this.rOT.setEnabled(true);
      if ((com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().rMY) && (paramHashSet.size() == this.rQO.getCount()))
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
      AppMethodBeat.o(21644);
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
    AppMethodBeat.i(21642);
    setMMTitle(R.l.erH);
    this.rQP = ((ListView)findViewById(R.h.dso));
    this.rQP.setAdapter(this.rQO);
    this.rQP.setEmptyView(findViewById(R.h.dsq));
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
    ((TextView)findViewById(R.h.dsz)).setText(R.l.eqO);
    ((TextView)findViewById(R.h.dsC)).setText(R.l.eqP);
    ((TextView)findViewById(R.h.dsm)).setText(R.l.eqM);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(21632);
        BackupPcChooseUI.this.finish();
        AppMethodBeat.o(21632);
        return false;
      }
    });
    this.rOT = ((Button)findViewById(R.h.dsu));
    this.rOT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(21634);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = BackupPcChooseUI.a(BackupPcChooseUI.this);
        paramAnonymousView = new LinkedList();
        if (((a)localObject).rOC.size() <= 0) {}
        for (;;)
        {
          localObject = g.C(paramAnonymousView);
          bh.beI();
          boolean bool = ((Boolean)com.tencent.mm.model.c.aHp().get(ar.a.VnI, Boolean.FALSE)).booleanValue();
          Log.i("MicroMsg.BackupPcChooseUI", "initView OnMenuItemClickListener startbackup choose records finish, selectedConversation size[%d], hasMove[%b], timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[] { Integer.valueOf(paramAnonymousView.size()), Boolean.valueOf(bool), Integer.valueOf(BackupPcChooseUI.rOU), Long.valueOf(BackupPcChooseUI.startTime), Long.valueOf(BackupPcChooseUI.endTime), Integer.valueOf(BackupPcChooseUI.aOl) });
          if (!bool) {
            break;
          }
          com.tencent.mm.ui.base.h.a(BackupPcChooseUI.this, R.l.erm, 0, R.l.erY, 0, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21633);
              com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().I(paramAnonymousView);
              com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().EK(2);
              com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS = 12;
              com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().cto().H(this.rQT);
              com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().cto().HI(paramAnonymousView.size());
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 8L, 1L, false);
              com.tencent.mm.plugin.report.service.h.IzE.a(13735, new Object[] { Integer.valueOf(10), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQn) });
              if ((BackupPcChooseUI.rOU == 1) && (BackupPcChooseUI.aOl == 1))
              {
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 32L, 1L, false);
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 35L, 1L, false);
                com.tencent.mm.plugin.report.service.h.IzE.a(13735, new Object[] { Integer.valueOf(13), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQn) });
              }
              for (;;)
              {
                BackupPcChooseUI.this.finish();
                AppMethodBeat.o(21633);
                return;
                if (BackupPcChooseUI.rOU == 1)
                {
                  com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 32L, 1L, false);
                  com.tencent.mm.plugin.report.service.h.IzE.a(13735, new Object[] { Integer.valueOf(11), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQn) });
                }
                else if (BackupPcChooseUI.aOl == 1)
                {
                  com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 35L, 1L, false);
                  com.tencent.mm.plugin.report.service.h.IzE.a(13735, new Object[] { Integer.valueOf(12), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQn) });
                }
              }
            }
          }, null, R.e.dke);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(21634);
          return;
          LinkedList localLinkedList = com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().csE();
          if (localLinkedList != null)
          {
            int i = 0;
            while (i < ((a)localObject).getCount())
            {
              if (((a)localObject).rOC.contains(Integer.valueOf(i))) {
                paramAnonymousView.add(localLinkedList.get(i));
              }
              i += 1;
            }
          }
          Log.i("MicroMsg.BackupPcChooseAdapter", "finishSelected usernameSize:%d", new Object[] { Integer.valueOf(paramAnonymousView.size()) });
        }
        com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().I(paramAnonymousView);
        com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().EK(2);
        com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().crZ().rKS = 12;
        com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().cto().H((LinkedList)localObject);
        com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().cto().HI(paramAnonymousView.size());
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 8L, 1L, false);
        com.tencent.mm.plugin.report.service.h.IzE.a(13735, new Object[] { Integer.valueOf(10), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQn) });
        if ((BackupPcChooseUI.rOU == 1) && (BackupPcChooseUI.aOl == 1))
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 32L, 1L, false);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 35L, 1L, false);
          com.tencent.mm.plugin.report.service.h.IzE.a(13735, new Object[] { Integer.valueOf(13), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQn) });
        }
        for (;;)
        {
          BackupPcChooseUI.this.finish();
          break;
          if (BackupPcChooseUI.rOU == 1)
          {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 32L, 1L, false);
            com.tencent.mm.plugin.report.service.h.IzE.a(13735, new Object[] { Integer.valueOf(11), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQn) });
          }
          else if (BackupPcChooseUI.aOl == 1)
          {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 35L, 1L, false);
            com.tencent.mm.plugin.report.service.h.IzE.a(13735, new Object[] { Integer.valueOf(12), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctn().rQn) });
          }
        }
      }
    });
    this.rOT.setEnabled(false);
    if ((!com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().cto().rQC) && (!com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().cto().rQD)) {
      this.rOJ.setVisibility(8);
    }
    for (;;)
    {
      this.rOH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21636);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().rMY)
          {
            paramAnonymousView = BackupPcChooseUI.a(BackupPcChooseUI.this);
            if (paramAnonymousView.rOC.size() != paramAnonymousView.getCount()) {
              break label114;
            }
            paramAnonymousView.rOC.clear();
          }
          for (a.rQM = false;; a.rQM = true)
          {
            paramAnonymousView.notifyDataSetChanged();
            paramAnonymousView.rQL.a(paramAnonymousView.rOC);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21636);
            return;
            label114:
            int i = 0;
            while (i < paramAnonymousView.getCount())
            {
              paramAnonymousView.rOC.add(Integer.valueOf(i));
              i += 1;
            }
          }
        }
      });
      if (com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().rMY) {
        break;
      }
      this.rOH.setTextColor(getResources().getColor(R.e.dkg));
      this.rOH.setClickable(false);
      this.rOK.setVisibility(0);
      AppMethodBeat.o(21642);
      return;
      this.rOJ.setVisibility(0);
      kN(true);
      this.rOJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21635);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new Intent(BackupPcChooseUI.this, BackupSelectExtUI.class);
          paramAnonymousView.putExtra("BACKUP_MODE", 1);
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MODE", BackupPcChooseUI.rOU);
          paramAnonymousView.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().cto().rQD);
          paramAnonymousView.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupPcChooseUI.aOl);
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupPcChooseUI.startTime);
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupPcChooseUI.endTime);
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().rMU);
          BackupPcChooseUI.this.startActivityForResult(paramAnonymousView, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(21635);
        }
      });
    }
    if (com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().csE().size() == 0) {
      switch (rOU)
      {
      }
    }
    for (;;)
    {
      this.rOI.setVisibility(0);
      this.rOK.setVisibility(4);
      AppMethodBeat.o(21642);
      return;
      this.rOI.setText(R.l.eqN);
      continue;
      this.rOI.setText(R.l.erS);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(21646);
    if (paramInt2 != -1)
    {
      Log.e("MicroMsg.BackupPcChooseUI", "onActivityResult result error! resultCode[%d]", new Object[] { Integer.valueOf(paramInt2) });
      AppMethodBeat.o(21646);
      return;
    }
    paramInt1 = rOU;
    long l1 = startTime;
    long l2 = endTime;
    rOU = paramIntent.getIntExtra("BACKUP_SELECT_TIME_MODE", rOU);
    startTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0L);
    endTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0L);
    aOl = paramIntent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", aOl);
    Log.i("MicroMsg.BackupPcChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", new Object[] { Integer.valueOf(rOU), Integer.valueOf(paramInt1), Long.valueOf(startTime), Long.valueOf(l1), Long.valueOf(endTime), Long.valueOf(l2), Integer.valueOf(aOl) });
    com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().cto();
    e.f(rOU, startTime, endTime, aOl);
    kN(false);
    if ((paramInt1 == rOU) && ((rOU == 0) || ((rOU == 1) && (startTime == l1) && (endTime == l2))))
    {
      AppMethodBeat.o(21646);
      return;
    }
    com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().a(rOU, startTime, endTime, com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().csD());
    paramIntent = this.rQO;
    paramIntent.rOC.clear();
    paramIntent.rQL.a(paramIntent.rOC);
    if ((com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().csE() == null) || (com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().csE().size() == 0)) {
      switch (rOU)
      {
      default: 
        this.rOI.setVisibility(0);
      }
    }
    for (;;)
    {
      this.rQO.notifyDataSetChanged();
      AppMethodBeat.o(21646);
      return;
      this.rOI.setText(R.l.eqN);
      break;
      this.rOI.setText(R.l.erS);
      break;
      this.rOI.setVisibility(4);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21639);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false))
    {
      AppMethodBeat.o(21639);
      return;
    }
    initView();
    AppMethodBeat.o(21639);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(21640);
    super.onStart();
    com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().rPZ = this.rQQ;
    AppMethodBeat.o(21640);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(21641);
    super.onStop();
    com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().rPZ = null;
    AppMethodBeat.o(21641);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI
 * JD-Core Version:    0.7.0.1
 */