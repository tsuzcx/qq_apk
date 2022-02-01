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
import com.tencent.mm.model.bg;
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
  private static int beK = 0;
  private static long endTime;
  private static int oMY = 0;
  private static long startTime;
  private TextView oML;
  private TextView oMM;
  private TextView oMN;
  private ProgressBar oMO;
  private View oMP;
  private LinearLayout oMQ;
  private LinearLayout oMR;
  private LinearLayout oMS;
  private LinearLayout oMT;
  private TextView oMU;
  private TextView oMV;
  private TextView oMW;
  private Button oMX;
  private SimpleDateFormat oMZ;
  private a oOR;
  private ListView oOS;
  private b.a oOT;
  
  public BackupPcChooseUI()
  {
    AppMethodBeat.i(21638);
    this.oOR = new a(this);
    this.oMZ = new SimpleDateFormat("yyyy.MM.dd");
    this.oOT = new b.a()
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
          switch (BackupPcChooseUI.oMY)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(21637);
            return;
            BackupPcChooseUI.c(BackupPcChooseUI.this).setText(2131756317);
            AppMethodBeat.o(21637);
            return;
            BackupPcChooseUI.c(BackupPcChooseUI.this).setText(2131756389);
          }
        }
        BackupPcChooseUI.d(BackupPcChooseUI.this).setClickable(true);
        BackupPcChooseUI.d(BackupPcChooseUI.this).setTextColor(BackupPcChooseUI.this.getResources().getColor(2131100014));
        BackupPcChooseUI.b(BackupPcChooseUI.this).setVisibility(8);
        BackupPcChooseUI.a(BackupPcChooseUI.this).notifyDataSetChanged();
        AppMethodBeat.o(21637);
      }
    };
    AppMethodBeat.o(21638);
  }
  
  private void cfQ()
  {
    AppMethodBeat.i(21645);
    if ((this.oMR.getVisibility() == 8) && (this.oMS.getVisibility() == 8) && (this.oMT.getVisibility() == 8))
    {
      this.oMP.setVisibility(8);
      this.oMQ.setVisibility(8);
      AppMethodBeat.o(21645);
      return;
    }
    this.oMP.setVisibility(0);
    this.oMQ.setVisibility(0);
    AppMethodBeat.o(21645);
  }
  
  private void jC(boolean paramBoolean)
  {
    AppMethodBeat.i(21643);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.backup.backuppcmodel.b.cga();
      SharedPreferences localSharedPreferences = com.tencent.mm.plugin.backup.backuppcmodel.b.ceR();
      oMY = localSharedPreferences.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
      beK = localSharedPreferences.getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
      startTime = localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
      endTime = localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
    }
    if (com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().oOF) {}
    switch (oMY)
    {
    default: 
      if (com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().oOG) {
        switch (beK)
        {
        }
      }
      break;
    }
    for (;;)
    {
      cfQ();
      AppMethodBeat.o(21643);
      return;
      this.oMS.setVisibility(8);
      break;
      this.oMP.setVisibility(0);
      this.oMQ.setVisibility(0);
      this.oMS.setVisibility(0);
      this.oMV.setText(this.oMZ.format(new Date(startTime)) + "~" + this.oMZ.format(new Date(endTime - 86400000L)));
      break;
      this.oMT.setVisibility(8);
      continue;
      this.oMP.setVisibility(0);
      this.oMQ.setVisibility(0);
      this.oMT.setVisibility(0);
      this.oMW.setText(getContext().getResources().getString(2131756370));
    }
  }
  
  public final void a(HashSet<Integer> paramHashSet)
  {
    AppMethodBeat.i(21644);
    Object localObject = new HashSet();
    int i = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cfr().size();
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
      this.oMX.setEnabled(true);
      if ((com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().oLi) && (paramHashSet.size() == this.oOR.getCount()))
      {
        this.oML.setText(2131756226);
        this.oMP.setVisibility(0);
        this.oMQ.setVisibility(0);
        this.oMR.setVisibility(0);
        this.oMU.setText(getString(2131756228, new Object[] { Integer.valueOf(paramHashSet.size()) }));
      }
    }
    for (;;)
    {
      cfQ();
      AppMethodBeat.o(21644);
      return;
      this.oML.setText(2131756225);
      break;
      this.oMX.setEnabled(false);
      this.oML.setText(2131756225);
      this.oMR.setVisibility(8);
      this.oMU.setText("");
    }
  }
  
  public int getLayoutId()
  {
    return 2131493172;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21642);
    setMMTitle(2131756376);
    this.oOS = ((ListView)findViewById(2131297184));
    this.oOS.setAdapter(this.oOR);
    this.oOS.setEmptyView(findViewById(2131297186));
    this.oML = ((TextView)findViewById(2131297192));
    this.oMM = ((TextView)findViewById(2131297185));
    this.oMO = ((ProgressBar)findViewById(2131297191));
    this.oMN = ((TextView)findViewById(2131297187));
    this.oMP = findViewById(2131297190);
    this.oMQ = ((LinearLayout)findViewById(2131297188));
    this.oMR = ((LinearLayout)findViewById(2131297193));
    this.oMS = ((LinearLayout)findViewById(2131297196));
    this.oMT = ((LinearLayout)findViewById(2131297181));
    this.oMU = ((TextView)findViewById(2131297195));
    this.oMV = ((TextView)findViewById(2131297198));
    this.oMW = ((TextView)findViewById(2131297183));
    ((TextView)findViewById(2131297194)).setText(2131756318);
    ((TextView)findViewById(2131297197)).setText(2131756321);
    ((TextView)findViewById(2131297182)).setText(2131756316);
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
    this.oMX = ((Button)findViewById(2131297189));
    this.oMX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(21634);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = BackupPcChooseUI.a(BackupPcChooseUI.this);
        paramAnonymousView = new LinkedList();
        if (((a)localObject).oMG.size() <= 0) {}
        for (;;)
        {
          localObject = g.B(paramAnonymousView);
          bg.aVF();
          boolean bool = ((Boolean)com.tencent.mm.model.c.azQ().get(ar.a.NZI, Boolean.FALSE)).booleanValue();
          Log.i("MicroMsg.BackupPcChooseUI", "initView OnMenuItemClickListener startbackup choose records finish, selectedConversation size[%d], hasMove[%b], timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[] { Integer.valueOf(paramAnonymousView.size()), Boolean.valueOf(bool), Integer.valueOf(BackupPcChooseUI.oMY), Long.valueOf(BackupPcChooseUI.startTime), Long.valueOf(BackupPcChooseUI.cfR()), Integer.valueOf(BackupPcChooseUI.beK) });
          if (!bool) {
            break;
          }
          com.tencent.mm.ui.base.h.a(BackupPcChooseUI.this, 2131756350, 0, 2131756404, 0, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21633);
              com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().H(paramAnonymousView);
              com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().Bj(2);
              com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = 12;
              com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().G(this.oOW);
              com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().Bv(paramAnonymousView.size());
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(400L, 8L, 1L, false);
              com.tencent.mm.plugin.report.service.h.CyF.a(13735, new Object[] { Integer.valueOf(10), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq) });
              if ((BackupPcChooseUI.oMY == 1) && (BackupPcChooseUI.beK == 1))
              {
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(400L, 32L, 1L, false);
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(400L, 35L, 1L, false);
                com.tencent.mm.plugin.report.service.h.CyF.a(13735, new Object[] { Integer.valueOf(13), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq) });
              }
              for (;;)
              {
                BackupPcChooseUI.this.finish();
                AppMethodBeat.o(21633);
                return;
                if (BackupPcChooseUI.oMY == 1)
                {
                  com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(400L, 32L, 1L, false);
                  com.tencent.mm.plugin.report.service.h.CyF.a(13735, new Object[] { Integer.valueOf(11), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq) });
                }
                else if (BackupPcChooseUI.beK == 1)
                {
                  com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(400L, 35L, 1L, false);
                  com.tencent.mm.plugin.report.service.h.CyF.a(13735, new Object[] { Integer.valueOf(12), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq) });
                }
              }
            }
          }, null, 2131100014);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(21634);
          return;
          LinkedList localLinkedList = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cfr();
          if (localLinkedList != null)
          {
            int i = 0;
            while (i < ((a)localObject).getCount())
            {
              if (((a)localObject).oMG.contains(Integer.valueOf(i))) {
                paramAnonymousView.add(localLinkedList.get(i));
              }
              i += 1;
            }
          }
          Log.i("MicroMsg.BackupPcChooseAdapter", "finishSelected usernameSize:%d", new Object[] { Integer.valueOf(paramAnonymousView.size()) });
        }
        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().H(paramAnonymousView);
        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().Bj(2);
        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().ceM().oJc = 12;
        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().G((LinkedList)localObject);
        com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().Bv(paramAnonymousView.size());
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(400L, 8L, 1L, false);
        com.tencent.mm.plugin.report.service.h.CyF.a(13735, new Object[] { Integer.valueOf(10), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq) });
        if ((BackupPcChooseUI.oMY == 1) && (BackupPcChooseUI.beK == 1))
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(400L, 32L, 1L, false);
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(400L, 35L, 1L, false);
          com.tencent.mm.plugin.report.service.h.CyF.a(13735, new Object[] { Integer.valueOf(13), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq) });
        }
        for (;;)
        {
          BackupPcChooseUI.this.finish();
          break;
          if (BackupPcChooseUI.oMY == 1)
          {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(400L, 32L, 1L, false);
            com.tencent.mm.plugin.report.service.h.CyF.a(13735, new Object[] { Integer.valueOf(11), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq) });
          }
          else if (BackupPcChooseUI.beK == 1)
          {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(400L, 35L, 1L, false);
            com.tencent.mm.plugin.report.service.h.CyF.a(13735, new Object[] { Integer.valueOf(12), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgb().oOq) });
          }
        }
      }
    });
    this.oMX.setEnabled(false);
    if ((!com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().oOF) && (!com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().oOG)) {
      this.oMN.setVisibility(8);
    }
    for (;;)
    {
      this.oML.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21636);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().oLi)
          {
            paramAnonymousView = BackupPcChooseUI.a(BackupPcChooseUI.this);
            if (paramAnonymousView.oMG.size() != paramAnonymousView.getCount()) {
              break label114;
            }
            paramAnonymousView.oMG.clear();
          }
          for (a.oOP = false;; a.oOP = true)
          {
            paramAnonymousView.notifyDataSetChanged();
            paramAnonymousView.oOO.a(paramAnonymousView.oMG);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21636);
            return;
            label114:
            int i = 0;
            while (i < paramAnonymousView.getCount())
            {
              paramAnonymousView.oMG.add(Integer.valueOf(i));
              i += 1;
            }
          }
        }
      });
      if (com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().oLi) {
        break;
      }
      this.oML.setTextColor(getResources().getColor(2131100016));
      this.oML.setClickable(false);
      this.oMO.setVisibility(0);
      AppMethodBeat.o(21642);
      return;
      this.oMN.setVisibility(0);
      jC(true);
      this.oMN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21635);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new Intent(BackupPcChooseUI.this, BackupSelectExtUI.class);
          paramAnonymousView.putExtra("BACKUP_MODE", 1);
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MODE", BackupPcChooseUI.oMY);
          paramAnonymousView.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc().oOG);
          paramAnonymousView.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupPcChooseUI.beK);
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupPcChooseUI.startTime);
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupPcChooseUI.cfR());
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().oLe);
          BackupPcChooseUI.this.startActivityForResult(paramAnonymousView, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(21635);
        }
      });
    }
    if (com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cfr().size() == 0) {
      switch (oMY)
      {
      }
    }
    for (;;)
    {
      this.oMM.setVisibility(0);
      this.oMO.setVisibility(4);
      AppMethodBeat.o(21642);
      return;
      this.oMM.setText(2131756317);
      continue;
      this.oMM.setText(2131756389);
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
    paramInt1 = oMY;
    long l1 = startTime;
    long l2 = endTime;
    oMY = paramIntent.getIntExtra("BACKUP_SELECT_TIME_MODE", oMY);
    startTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0L);
    endTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0L);
    beK = paramIntent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", beK);
    Log.i("MicroMsg.BackupPcChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", new Object[] { Integer.valueOf(oMY), Integer.valueOf(paramInt1), Long.valueOf(startTime), Long.valueOf(l1), Long.valueOf(endTime), Long.valueOf(l2), Integer.valueOf(beK) });
    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cgc();
    e.f(oMY, startTime, endTime, beK);
    jC(false);
    if ((paramInt1 == oMY) && ((oMY == 0) || ((oMY == 1) && (startTime == l1) && (endTime == l2))))
    {
      AppMethodBeat.o(21646);
      return;
    }
    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().a(oMY, startTime, endTime, com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cfq());
    paramIntent = this.oOR;
    paramIntent.oMG.clear();
    paramIntent.oOO.a(paramIntent.oMG);
    if ((com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cfr() == null) || (com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cfr().size() == 0)) {
      switch (oMY)
      {
      default: 
        this.oMM.setVisibility(0);
      }
    }
    for (;;)
    {
      this.oOR.notifyDataSetChanged();
      AppMethodBeat.o(21646);
      return;
      this.oMM.setText(2131756317);
      break;
      this.oMM.setText(2131756389);
      break;
      this.oMM.setVisibility(4);
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
    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().oOc = this.oOT;
    AppMethodBeat.o(21640);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(21641);
    super.onStop();
    com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().oOc = null;
    AppMethodBeat.o(21641);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI
 * JD-Core Version:    0.7.0.1
 */