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
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.backuppcmodel.e;
import com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI;
import com.tencent.mm.plugin.backup.c.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  private static int nwE = 0;
  private static long startTime;
  private TextView nwA;
  private TextView nwB;
  private TextView nwC;
  private Button nwD;
  private SimpleDateFormat nwF;
  private TextView nwr;
  private TextView nws;
  private TextView nwt;
  private ProgressBar nwu;
  private View nwv;
  private LinearLayout nww;
  private LinearLayout nwx;
  private LinearLayout nwy;
  private LinearLayout nwz;
  private ListView nyA;
  private b.a nyB;
  private a nyz;
  
  public BackupPcChooseUI()
  {
    AppMethodBeat.i(21638);
    this.nyz = new a(this);
    this.nwF = new SimpleDateFormat("yyyy.MM.dd");
    this.nyB = new b.a()
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
          switch (BackupPcChooseUI.nwE)
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
  
  private void bIa()
  {
    AppMethodBeat.i(21645);
    if ((this.nwx.getVisibility() == 8) && (this.nwy.getVisibility() == 8) && (this.nwz.getVisibility() == 8))
    {
      this.nwv.setVisibility(8);
      this.nww.setVisibility(8);
      AppMethodBeat.o(21645);
      return;
    }
    this.nwv.setVisibility(0);
    this.nww.setVisibility(0);
    AppMethodBeat.o(21645);
  }
  
  private void iD(boolean paramBoolean)
  {
    AppMethodBeat.i(21643);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.backup.backuppcmodel.b.bIj();
      SharedPreferences localSharedPreferences = com.tencent.mm.plugin.backup.backuppcmodel.b.bHc();
      nwE = localSharedPreferences.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
      beN = localSharedPreferences.getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
      startTime = localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
      endTime = localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
    }
    if (com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIl().nyn) {}
    switch (nwE)
    {
    default: 
      if (com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIl().nyo) {
        switch (beN)
        {
        }
      }
      break;
    }
    for (;;)
    {
      bIa();
      AppMethodBeat.o(21643);
      return;
      this.nwy.setVisibility(8);
      break;
      this.nwv.setVisibility(0);
      this.nww.setVisibility(0);
      this.nwy.setVisibility(0);
      this.nwB.setText(this.nwF.format(new Date(startTime)) + "~" + this.nwF.format(new Date(endTime - 86400000L)));
      break;
      this.nwz.setVisibility(8);
      continue;
      this.nwv.setVisibility(0);
      this.nww.setVisibility(0);
      this.nwz.setVisibility(0);
      this.nwC.setText(getContext().getResources().getString(2131756236));
    }
  }
  
  public final void a(HashSet<Integer> paramHashSet)
  {
    AppMethodBeat.i(21644);
    Object localObject = new HashSet();
    int i = com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().bHC().size();
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
      this.nwD.setEnabled(true);
      if ((com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().nuP) && (paramHashSet.size() == this.nyz.getCount()))
      {
        this.nwr.setText(2131756092);
        this.nwv.setVisibility(0);
        this.nww.setVisibility(0);
        this.nwx.setVisibility(0);
        this.nwA.setText(getString(2131756094, new Object[] { Integer.valueOf(paramHashSet.size()) }));
      }
    }
    for (;;)
    {
      bIa();
      AppMethodBeat.o(21644);
      return;
      this.nwr.setText(2131756091);
      break;
      this.nwD.setEnabled(false);
      this.nwr.setText(2131756091);
      this.nwx.setVisibility(8);
      this.nwA.setText("");
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
    this.nyA = ((ListView)findViewById(2131297038));
    this.nyA.setAdapter(this.nyz);
    this.nyA.setEmptyView(findViewById(2131297040));
    this.nwr = ((TextView)findViewById(2131297046));
    this.nws = ((TextView)findViewById(2131297039));
    this.nwu = ((ProgressBar)findViewById(2131297045));
    this.nwt = ((TextView)findViewById(2131297041));
    this.nwv = findViewById(2131297044);
    this.nww = ((LinearLayout)findViewById(2131297042));
    this.nwx = ((LinearLayout)findViewById(2131297047));
    this.nwy = ((LinearLayout)findViewById(2131297050));
    this.nwz = ((LinearLayout)findViewById(2131297035));
    this.nwA = ((TextView)findViewById(2131297049));
    this.nwB = ((TextView)findViewById(2131297052));
    this.nwC = ((TextView)findViewById(2131297037));
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
    this.nwD = ((Button)findViewById(2131297043));
    this.nwD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(21634);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        localObject = BackupPcChooseUI.a(BackupPcChooseUI.this);
        paramAnonymousView = new LinkedList();
        if (((a)localObject).nwm.size() <= 0) {}
        for (;;)
        {
          localObject = com.tencent.mm.plugin.backup.b.g.B(paramAnonymousView);
          ba.aBQ();
          boolean bool = ((Boolean)com.tencent.mm.model.c.ajl().get(al.a.Ixi, Boolean.FALSE)).booleanValue();
          ad.i("MicroMsg.BackupPcChooseUI", "initView OnMenuItemClickListener startbackup choose records finish, selectedConversation size[%d], hasMove[%b], timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[] { Integer.valueOf(paramAnonymousView.size()), Boolean.valueOf(bool), Integer.valueOf(BackupPcChooseUI.nwE), Long.valueOf(BackupPcChooseUI.startTime), Long.valueOf(BackupPcChooseUI.Il()), Integer.valueOf(BackupPcChooseUI.beN) });
          if (!bool) {
            break;
          }
          h.a(BackupPcChooseUI.this, 2131756216, 0, 2131756270, 0, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21633);
              com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().G(paramAnonymousView);
              com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().xz(2);
              com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ = 12;
              com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIl().H(this.nyE);
              com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIl().tb(paramAnonymousView.size());
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 8L, 1L, false);
              com.tencent.mm.plugin.report.service.g.yhR.f(13735, new Object[] { Integer.valueOf(10), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxY) });
              if ((BackupPcChooseUI.nwE == 1) && (BackupPcChooseUI.beN == 1))
              {
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 32L, 1L, false);
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 35L, 1L, false);
                com.tencent.mm.plugin.report.service.g.yhR.f(13735, new Object[] { Integer.valueOf(13), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxY) });
              }
              for (;;)
              {
                BackupPcChooseUI.this.finish();
                AppMethodBeat.o(21633);
                return;
                if (BackupPcChooseUI.nwE == 1)
                {
                  com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 32L, 1L, false);
                  com.tencent.mm.plugin.report.service.g.yhR.f(13735, new Object[] { Integer.valueOf(11), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxY) });
                }
                else if (BackupPcChooseUI.beN == 1)
                {
                  com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 35L, 1L, false);
                  com.tencent.mm.plugin.report.service.g.yhR.f(13735, new Object[] { Integer.valueOf(12), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxY) });
                }
              }
            }
          }, null, 2131099990);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(21634);
          return;
          LinkedList localLinkedList = com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().bHC();
          if (localLinkedList != null)
          {
            int i = 0;
            while (i < ((a)localObject).getCount())
            {
              if (((a)localObject).nwm.contains(Integer.valueOf(i))) {
                paramAnonymousView.add(localLinkedList.get(i));
              }
              i += 1;
            }
          }
          ad.i("MicroMsg.BackupPcChooseAdapter", "finishSelected usernameSize:%d", new Object[] { Integer.valueOf(paramAnonymousView.size()) });
        }
        com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().G(paramAnonymousView);
        com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().xz(2);
        com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bGX().nsJ = 12;
        com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIl().H((LinkedList)localObject);
        com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIl().tb(paramAnonymousView.size());
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 8L, 1L, false);
        com.tencent.mm.plugin.report.service.g.yhR.f(13735, new Object[] { Integer.valueOf(10), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxY) });
        if ((BackupPcChooseUI.nwE == 1) && (BackupPcChooseUI.beN == 1))
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 32L, 1L, false);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 35L, 1L, false);
          com.tencent.mm.plugin.report.service.g.yhR.f(13735, new Object[] { Integer.valueOf(13), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxY) });
        }
        for (;;)
        {
          BackupPcChooseUI.this.finish();
          break;
          if (BackupPcChooseUI.nwE == 1)
          {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 32L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yhR.f(13735, new Object[] { Integer.valueOf(11), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxY) });
          }
          else if (BackupPcChooseUI.beN == 1)
          {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 35L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yhR.f(13735, new Object[] { Integer.valueOf(12), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIk().nxY) });
          }
        }
      }
    });
    this.nwD.setEnabled(false);
    if ((!com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIl().nyn) && (!com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIl().nyo)) {
      this.nwt.setVisibility(8);
    }
    for (;;)
    {
      this.nwr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21636);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().nuP)
          {
            paramAnonymousView = BackupPcChooseUI.a(BackupPcChooseUI.this);
            if (paramAnonymousView.nwm.size() != paramAnonymousView.getCount()) {
              break label114;
            }
            paramAnonymousView.nwm.clear();
          }
          for (a.nyx = false;; a.nyx = true)
          {
            paramAnonymousView.notifyDataSetChanged();
            paramAnonymousView.nyw.a(paramAnonymousView.nwm);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21636);
            return;
            label114:
            int i = 0;
            while (i < paramAnonymousView.getCount())
            {
              paramAnonymousView.nwm.add(Integer.valueOf(i));
              i += 1;
            }
          }
        }
      });
      if (com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().nuP) {
        break;
      }
      this.nwr.setTextColor(getResources().getColor(2131099992));
      this.nwr.setClickable(false);
      this.nwu.setVisibility(0);
      AppMethodBeat.o(21642);
      return;
      this.nwt.setVisibility(0);
      iD(true);
      this.nwt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21635);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = new Intent(BackupPcChooseUI.this, BackupSelectExtUI.class);
          paramAnonymousView.putExtra("BACKUP_MODE", 1);
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MODE", BackupPcChooseUI.nwE);
          paramAnonymousView.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIl().nyo);
          paramAnonymousView.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupPcChooseUI.beN);
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupPcChooseUI.startTime);
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupPcChooseUI.Il());
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().nuL);
          BackupPcChooseUI.this.startActivityForResult(paramAnonymousView, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(21635);
        }
      });
    }
    if (com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().bHC().size() == 0) {
      switch (nwE)
      {
      }
    }
    for (;;)
    {
      this.nws.setVisibility(0);
      this.nwu.setVisibility(4);
      AppMethodBeat.o(21642);
      return;
      this.nws.setText(2131756183);
      continue;
      this.nws.setText(2131756255);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(21646);
    if (paramInt2 != -1)
    {
      ad.e("MicroMsg.BackupPcChooseUI", "onActivityResult result error! resultCode[%d]", new Object[] { Integer.valueOf(paramInt2) });
      AppMethodBeat.o(21646);
      return;
    }
    paramInt1 = nwE;
    long l1 = startTime;
    long l2 = endTime;
    nwE = paramIntent.getIntExtra("BACKUP_SELECT_TIME_MODE", nwE);
    startTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0L);
    endTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0L);
    beN = paramIntent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", beN);
    ad.i("MicroMsg.BackupPcChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", new Object[] { Integer.valueOf(nwE), Integer.valueOf(paramInt1), Long.valueOf(startTime), Long.valueOf(l1), Long.valueOf(endTime), Long.valueOf(l2), Integer.valueOf(beN) });
    com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIl();
    e.f(nwE, startTime, endTime, beN);
    iD(false);
    if ((paramInt1 == nwE) && ((nwE == 0) || ((nwE == 1) && (startTime == l1) && (endTime == l2))))
    {
      AppMethodBeat.o(21646);
      return;
    }
    com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().a(nwE, startTime, endTime, com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().bHB());
    paramIntent = this.nyz;
    paramIntent.nwm.clear();
    paramIntent.nyw.a(paramIntent.nwm);
    if ((com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().bHC() == null) || (com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().bHC().size() == 0)) {
      switch (nwE)
      {
      default: 
        this.nws.setVisibility(0);
      }
    }
    for (;;)
    {
      this.nyz.notifyDataSetChanged();
      AppMethodBeat.o(21646);
      return;
      this.nws.setText(2131756183);
      break;
      this.nws.setText(2131756255);
      break;
      this.nws.setVisibility(4);
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
    com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().nxK = this.nyB;
    AppMethodBeat.o(21640);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(21641);
    super.onStop();
    com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().nxK = null;
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