package com.tencent.mm.plugin.backup.backuppcui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.backuppcmodel.e;
import com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI;
import com.tencent.mm.plugin.backup.c.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class BackupPcChooseUI
  extends MMWizardActivity
{
  private static int beN = 0;
  private static long endTime;
  private static int nBZ = 0;
  private static long startTime;
  private TextView nBM;
  private TextView nBN;
  private TextView nBO;
  private ProgressBar nBP;
  private View nBQ;
  private LinearLayout nBR;
  private LinearLayout nBS;
  private LinearLayout nBT;
  private LinearLayout nBU;
  private TextView nBV;
  private TextView nBW;
  private TextView nBX;
  private Button nBY;
  private SimpleDateFormat nCa;
  private a nDU;
  private ListView nDV;
  private b.a nDW;
  
  public BackupPcChooseUI()
  {
    AppMethodBeat.i(21638);
    this.nDU = new a(this);
    this.nCa = new SimpleDateFormat("yyyy.MM.dd");
    this.nDW = new b.a()
    {
      public final void C(LinkedList<f.b> paramAnonymousLinkedList)
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
          switch (BackupPcChooseUI.nBZ)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(21637);
            return;
            BackupPcChooseUI.c(BackupPcChooseUI.this).setText(2131756183);
            AppMethodBeat.o(21637);
            return;
            BackupPcChooseUI.c(BackupPcChooseUI.this).setText(2131756255);
          }
        }
        BackupPcChooseUI.d(BackupPcChooseUI.this).setClickable(true);
        BackupPcChooseUI.d(BackupPcChooseUI.this).setTextColor(BackupPcChooseUI.this.getResources().getColor(2131099990));
        BackupPcChooseUI.b(BackupPcChooseUI.this).setVisibility(8);
        BackupPcChooseUI.a(BackupPcChooseUI.this).notifyDataSetChanged();
        AppMethodBeat.o(21637);
      }
    };
    AppMethodBeat.o(21638);
  }
  
  private void bIY()
  {
    AppMethodBeat.i(21645);
    if ((this.nBS.getVisibility() == 8) && (this.nBT.getVisibility() == 8) && (this.nBU.getVisibility() == 8))
    {
      this.nBQ.setVisibility(8);
      this.nBR.setVisibility(8);
      AppMethodBeat.o(21645);
      return;
    }
    this.nBQ.setVisibility(0);
    this.nBR.setVisibility(0);
    AppMethodBeat.o(21645);
  }
  
  private void iB(boolean paramBoolean)
  {
    AppMethodBeat.i(21643);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.backup.backuppcmodel.b.bJh();
      SharedPreferences localSharedPreferences = com.tencent.mm.plugin.backup.backuppcmodel.b.bIa();
      nBZ = localSharedPreferences.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
      beN = localSharedPreferences.getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
      startTime = localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
      endTime = localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
    }
    if (com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJj().nDI) {}
    switch (nBZ)
    {
    default: 
      if (com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJj().nDJ) {
        switch (beN)
        {
        }
      }
      break;
    }
    for (;;)
    {
      bIY();
      AppMethodBeat.o(21643);
      return;
      this.nBT.setVisibility(8);
      break;
      this.nBQ.setVisibility(0);
      this.nBR.setVisibility(0);
      this.nBT.setVisibility(0);
      this.nBW.setText(this.nCa.format(new Date(startTime)) + "~" + this.nCa.format(new Date(endTime - 86400000L)));
      break;
      this.nBU.setVisibility(8);
      continue;
      this.nBQ.setVisibility(0);
      this.nBR.setVisibility(0);
      this.nBU.setVisibility(0);
      this.nBX.setText(getContext().getResources().getString(2131756236));
    }
  }
  
  public final void a(HashSet<Integer> paramHashSet)
  {
    AppMethodBeat.i(21644);
    Object localObject = new HashSet();
    int i = com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJl().bIA().size();
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
      this.nBY.setEnabled(true);
      if ((com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJl().nAk) && (paramHashSet.size() == this.nDU.getCount()))
      {
        this.nBM.setText(2131756092);
        this.nBQ.setVisibility(0);
        this.nBR.setVisibility(0);
        this.nBS.setVisibility(0);
        this.nBV.setText(getString(2131756094, new Object[] { Integer.valueOf(paramHashSet.size()) }));
      }
    }
    for (;;)
    {
      bIY();
      AppMethodBeat.o(21644);
      return;
      this.nBM.setText(2131756091);
      break;
      this.nBY.setEnabled(false);
      this.nBM.setText(2131756091);
      this.nBS.setVisibility(8);
      this.nBV.setText("");
    }
  }
  
  public int getLayoutId()
  {
    return 2131493129;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21642);
    setMMTitle(2131756242);
    this.nDV = ((ListView)findViewById(2131297038));
    this.nDV.setAdapter(this.nDU);
    this.nDV.setEmptyView(findViewById(2131297040));
    this.nBM = ((TextView)findViewById(2131297046));
    this.nBN = ((TextView)findViewById(2131297039));
    this.nBP = ((ProgressBar)findViewById(2131297045));
    this.nBO = ((TextView)findViewById(2131297041));
    this.nBQ = findViewById(2131297044);
    this.nBR = ((LinearLayout)findViewById(2131297042));
    this.nBS = ((LinearLayout)findViewById(2131297047));
    this.nBT = ((LinearLayout)findViewById(2131297050));
    this.nBU = ((LinearLayout)findViewById(2131297035));
    this.nBV = ((TextView)findViewById(2131297049));
    this.nBW = ((TextView)findViewById(2131297052));
    this.nBX = ((TextView)findViewById(2131297037));
    ((TextView)findViewById(2131297048)).setText(2131756184);
    ((TextView)findViewById(2131297051)).setText(2131756187);
    ((TextView)findViewById(2131297036)).setText(2131756182);
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
    this.nBY = ((Button)findViewById(2131297043));
    this.nBY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(21634);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        localObject = BackupPcChooseUI.a(BackupPcChooseUI.this);
        paramAnonymousView = new LinkedList();
        if (((a)localObject).nBH.size() <= 0) {}
        for (;;)
        {
          localObject = com.tencent.mm.plugin.backup.b.g.B(paramAnonymousView);
          bc.aCg();
          boolean bool = ((Boolean)com.tencent.mm.model.c.ajA().get(am.a.IRG, Boolean.FALSE)).booleanValue();
          ae.i("MicroMsg.BackupPcChooseUI", "initView OnMenuItemClickListener startbackup choose records finish, selectedConversation size[%d], hasMove[%b], timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[] { Integer.valueOf(paramAnonymousView.size()), Boolean.valueOf(bool), Integer.valueOf(BackupPcChooseUI.nBZ), Long.valueOf(BackupPcChooseUI.startTime), Long.valueOf(BackupPcChooseUI.It()), Integer.valueOf(BackupPcChooseUI.beN) });
          if (!bool) {
            break;
          }
          h.a(BackupPcChooseUI.this, 2131756216, 0, 2131756270, 0, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21633);
              com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJl().G(paramAnonymousView);
              com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi().xD(2);
              com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bHV().nye = 12;
              com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJj().H(this.nDZ);
              com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJj().tp(paramAnonymousView.size());
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 8L, 1L, false);
              com.tencent.mm.plugin.report.service.g.yxI.f(13735, new Object[] { Integer.valueOf(10), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi().nDt) });
              if ((BackupPcChooseUI.nBZ == 1) && (BackupPcChooseUI.beN == 1))
              {
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 32L, 1L, false);
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 35L, 1L, false);
                com.tencent.mm.plugin.report.service.g.yxI.f(13735, new Object[] { Integer.valueOf(13), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi().nDt) });
              }
              for (;;)
              {
                BackupPcChooseUI.this.finish();
                AppMethodBeat.o(21633);
                return;
                if (BackupPcChooseUI.nBZ == 1)
                {
                  com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 32L, 1L, false);
                  com.tencent.mm.plugin.report.service.g.yxI.f(13735, new Object[] { Integer.valueOf(11), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi().nDt) });
                }
                else if (BackupPcChooseUI.beN == 1)
                {
                  com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 35L, 1L, false);
                  com.tencent.mm.plugin.report.service.g.yxI.f(13735, new Object[] { Integer.valueOf(12), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi().nDt) });
                }
              }
            }
          }, null, 2131099990);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(21634);
          return;
          LinkedList localLinkedList = com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJl().bIA();
          if (localLinkedList != null)
          {
            int i = 0;
            while (i < ((a)localObject).getCount())
            {
              if (((a)localObject).nBH.contains(Integer.valueOf(i))) {
                paramAnonymousView.add(localLinkedList.get(i));
              }
              i += 1;
            }
          }
          ae.i("MicroMsg.BackupPcChooseAdapter", "finishSelected usernameSize:%d", new Object[] { Integer.valueOf(paramAnonymousView.size()) });
        }
        com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJl().G(paramAnonymousView);
        com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi().xD(2);
        com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bHV().nye = 12;
        com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJj().H((LinkedList)localObject);
        com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJj().tp(paramAnonymousView.size());
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 8L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yxI.f(13735, new Object[] { Integer.valueOf(10), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi().nDt) });
        if ((BackupPcChooseUI.nBZ == 1) && (BackupPcChooseUI.beN == 1))
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 32L, 1L, false);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 35L, 1L, false);
          com.tencent.mm.plugin.report.service.g.yxI.f(13735, new Object[] { Integer.valueOf(13), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi().nDt) });
        }
        for (;;)
        {
          BackupPcChooseUI.this.finish();
          break;
          if (BackupPcChooseUI.nBZ == 1)
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 32L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yxI.f(13735, new Object[] { Integer.valueOf(11), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi().nDt) });
          }
          else if (BackupPcChooseUI.beN == 1)
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 35L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yxI.f(13735, new Object[] { Integer.valueOf(12), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJi().nDt) });
          }
        }
      }
    });
    this.nBY.setEnabled(false);
    if ((!com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJj().nDI) && (!com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJj().nDJ)) {
      this.nBO.setVisibility(8);
    }
    for (;;)
    {
      this.nBM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21636);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJl().nAk)
          {
            paramAnonymousView = BackupPcChooseUI.a(BackupPcChooseUI.this);
            if (paramAnonymousView.nBH.size() != paramAnonymousView.getCount()) {
              break label114;
            }
            paramAnonymousView.nBH.clear();
          }
          for (a.nDS = false;; a.nDS = true)
          {
            paramAnonymousView.notifyDataSetChanged();
            paramAnonymousView.nDR.a(paramAnonymousView.nBH);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21636);
            return;
            label114:
            int i = 0;
            while (i < paramAnonymousView.getCount())
            {
              paramAnonymousView.nBH.add(Integer.valueOf(i));
              i += 1;
            }
          }
        }
      });
      if (com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJl().nAk) {
        break;
      }
      this.nBM.setTextColor(getResources().getColor(2131099992));
      this.nBM.setClickable(false);
      this.nBP.setVisibility(0);
      AppMethodBeat.o(21642);
      return;
      this.nBO.setVisibility(0);
      iB(true);
      this.nBO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21635);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new Intent(BackupPcChooseUI.this, BackupSelectExtUI.class);
          paramAnonymousView.putExtra("BACKUP_MODE", 1);
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MODE", BackupPcChooseUI.nBZ);
          paramAnonymousView.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJj().nDJ);
          paramAnonymousView.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupPcChooseUI.beN);
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupPcChooseUI.startTime);
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupPcChooseUI.It());
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJl().nAg);
          BackupPcChooseUI.this.startActivityForResult(paramAnonymousView, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(21635);
        }
      });
    }
    if (com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJl().bIA().size() == 0) {
      switch (nBZ)
      {
      }
    }
    for (;;)
    {
      this.nBN.setVisibility(0);
      this.nBP.setVisibility(4);
      AppMethodBeat.o(21642);
      return;
      this.nBN.setText(2131756183);
      continue;
      this.nBN.setText(2131756255);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(21646);
    if (paramInt2 != -1)
    {
      ae.e("MicroMsg.BackupPcChooseUI", "onActivityResult result error! resultCode[%d]", new Object[] { Integer.valueOf(paramInt2) });
      AppMethodBeat.o(21646);
      return;
    }
    paramInt1 = nBZ;
    long l1 = startTime;
    long l2 = endTime;
    nBZ = paramIntent.getIntExtra("BACKUP_SELECT_TIME_MODE", nBZ);
    startTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0L);
    endTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0L);
    beN = paramIntent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", beN);
    ae.i("MicroMsg.BackupPcChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", new Object[] { Integer.valueOf(nBZ), Integer.valueOf(paramInt1), Long.valueOf(startTime), Long.valueOf(l1), Long.valueOf(endTime), Long.valueOf(l2), Integer.valueOf(beN) });
    com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJj();
    e.f(nBZ, startTime, endTime, beN);
    iB(false);
    if ((paramInt1 == nBZ) && ((nBZ == 0) || ((nBZ == 1) && (startTime == l1) && (endTime == l2))))
    {
      AppMethodBeat.o(21646);
      return;
    }
    com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJl().a(nBZ, startTime, endTime, com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJl().bIz());
    paramIntent = this.nDU;
    paramIntent.nBH.clear();
    paramIntent.nDR.a(paramIntent.nBH);
    if ((com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJl().bIA() == null) || (com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJl().bIA().size() == 0)) {
      switch (nBZ)
      {
      default: 
        this.nBN.setVisibility(0);
      }
    }
    for (;;)
    {
      this.nDU.notifyDataSetChanged();
      AppMethodBeat.o(21646);
      return;
      this.nBN.setText(2131756183);
      break;
      this.nBN.setText(2131756255);
      break;
      this.nBN.setVisibility(4);
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
    com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJl().nDf = this.nDW;
    AppMethodBeat.o(21640);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(21641);
    super.onStop();
    com.tencent.mm.plugin.backup.backuppcmodel.b.bJh().bJl().nDf = null;
    AppMethodBeat.o(21641);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI
 * JD-Core Version:    0.7.0.1
 */