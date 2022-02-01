package com.tencent.mm.plugin.backup.backupmoveui;

import android.app.Activity;
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
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI;
import com.tencent.mm.plugin.backup.c.b.b;
import com.tencent.mm.plugin.backup.d.a.2;
import com.tencent.mm.plugin.backup.d.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  private static int beN = 0;
  private static long endTime;
  private static int nwE = 0;
  private static long startTime;
  private TextView nwA;
  private TextView nwB;
  private TextView nwC;
  private Button nwD;
  private SimpleDateFormat nwF;
  private b.b nwG;
  private a nwp;
  private ListView nwq;
  private TextView nwr;
  private TextView nws;
  private TextView nwt;
  private ProgressBar nwu;
  private View nwv;
  private LinearLayout nww;
  private LinearLayout nwx;
  private LinearLayout nwy;
  private LinearLayout nwz;
  
  public BackupMoveChooseUI()
  {
    AppMethodBeat.i(21387);
    this.nwp = new a(this);
    this.nwF = new SimpleDateFormat("yyyy.MM.dd");
    this.nwG = new b.b()
    {
      public final void C(LinkedList<f.b> paramAnonymousLinkedList)
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
          switch (BackupMoveChooseUI.nwE)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(21386);
            return;
            BackupMoveChooseUI.c(BackupMoveChooseUI.this).setText(2131756101);
            AppMethodBeat.o(21386);
            return;
            BackupMoveChooseUI.c(BackupMoveChooseUI.this).setText(2131756255);
          }
        }
        BackupMoveChooseUI.d(BackupMoveChooseUI.this).setClickable(true);
        BackupMoveChooseUI.d(BackupMoveChooseUI.this).setTextColor(BackupMoveChooseUI.this.getResources().getColor(2131099990));
        BackupMoveChooseUI.b(BackupMoveChooseUI.this).setVisibility(8);
        BackupMoveChooseUI.a(BackupMoveChooseUI.this).notifyDataSetChanged();
        AppMethodBeat.o(21386);
      }
      
      public final void D(LinkedList<f.b> paramAnonymousLinkedList) {}
      
      public final void a(LinkedList<f.b> paramAnonymousLinkedList, f.b paramAnonymousb, int paramAnonymousInt) {}
    };
    AppMethodBeat.o(21387);
  }
  
  private void bIa()
  {
    AppMethodBeat.i(21394);
    if ((this.nwx.getVisibility() == 8) && (this.nwy.getVisibility() == 8) && (this.nwz.getVisibility() == 8))
    {
      this.nwv.setVisibility(8);
      this.nww.setVisibility(8);
      AppMethodBeat.o(21394);
      return;
    }
    this.nwv.setVisibility(0);
    this.nww.setVisibility(0);
    AppMethodBeat.o(21394);
  }
  
  private void iD(boolean paramBoolean)
  {
    AppMethodBeat.i(21392);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.backup.d.b.bHG();
      SharedPreferences localSharedPreferences = com.tencent.mm.plugin.backup.d.b.bHc();
      nwE = localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
      beN = localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
      startTime = localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
      endTime = localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
    }
    switch (nwE)
    {
    default: 
      switch (beN)
      {
      }
      break;
    }
    for (;;)
    {
      bIa();
      AppMethodBeat.o(21392);
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
      this.nwC.setText(getContext().getResources().getString(2131756164));
    }
  }
  
  public final void a(HashSet<Integer> paramHashSet)
  {
    AppMethodBeat.i(21393);
    Object localObject = com.tencent.mm.plugin.backup.d.b.bHG().bHK().bHC();
    if (localObject == null)
    {
      ad.e("MicroMsg.BackupMoveChooseUI", "onClickCheckBox convInfo is null.");
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
        l = ((f.b)((LinkedList)localObject).get(i)).nta + l;
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
      this.nwD.setEnabled(true);
      if (paramHashSet.size() == this.nwp.getCount())
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
      AppMethodBeat.o(21393);
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
    AppMethodBeat.i(21391);
    setMMTitle(2131756266);
    this.nwq = ((ListView)findViewById(2131297038));
    this.nwq.setAdapter(this.nwp);
    this.nwq.setEmptyView(findViewById(2131297040));
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
    ((TextView)findViewById(2131297048)).setText(2131756102);
    ((TextView)findViewById(2131297051)).setText(2131756104);
    ((TextView)findViewById(2131297036)).setText(2131756100);
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
    this.nwD = ((Button)findViewById(2131297043));
    this.nwD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21383);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        localObject1 = new PLong();
        Object localObject2 = new PInt();
        a locala = BackupMoveChooseUI.a(BackupMoveChooseUI.this);
        paramAnonymousView = new LinkedList();
        label117:
        int j;
        if (locala.nwm.size() <= 0)
        {
          localObject1 = com.tencent.mm.plugin.backup.b.g.B(paramAnonymousView);
          localObject2 = com.tencent.mm.plugin.backup.d.b.bHG().bHK();
          if (paramAnonymousView.size() != 0) {
            break label735;
          }
          ((com.tencent.mm.plugin.backup.d.a)localObject2).nuO = new LinkedList();
          localObject2 = com.tencent.mm.plugin.backup.d.b.bHG().bHI();
          ((d)localObject2).nvI = ((LinkedList)localObject1);
          com.tencent.mm.plugin.backup.d.b.bHG();
          if (com.tencent.mm.plugin.backup.d.b.bHc().getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0) != 1) {
            break label788;
          }
          d.nvP = true;
          label155:
          com.tencent.mm.plugin.backup.d.b.bHG();
          ((d)localObject2).nvL = com.tencent.mm.plugin.backup.d.b.bHc().getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
          com.tencent.mm.plugin.backup.d.b.bHG();
          ((d)localObject2).nvM = com.tencent.mm.plugin.backup.d.b.bHc().getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
          com.tencent.mm.plugin.backup.d.b.bHG();
          if (com.tencent.mm.plugin.backup.d.b.bHc().getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0) != 1) {
            break label795;
          }
          d.nur = true;
          label218:
          ad.i("MicroMsg.BackupMoveServer", "setBakupChooseData users size[%d], selectStartTime[%d], selectEndTime[%d], isQuickBackup[%b]", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), Long.valueOf(((d)localObject2).nvL), Long.valueOf(((d)localObject2).nvM), Boolean.valueOf(d.nur) });
          ba.aBQ();
          c.ajl().set(al.a.Ixf, Boolean.TRUE);
          localObject1 = com.tencent.mm.plugin.backup.d.b.bHG().bHK();
          if (((com.tencent.mm.plugin.backup.d.a)localObject1).nuJ != null) {
            ((com.tencent.mm.plugin.backup.d.a)localObject1).nuJ.cancel();
          }
          com.tencent.mm.sdk.g.b.c(new a.2((com.tencent.mm.plugin.backup.d.a)localObject1), "BackupMoveChooseServer.calculateChooseConvSize");
          i = 0;
          if ((BackupMoveChooseUI.nwE != 1) || (BackupMoveChooseUI.beN != 1)) {
            break label802;
          }
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 26L, 1L, false);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 27L, 1L, false);
          com.tencent.mm.plugin.report.service.g.yhR.f(11788, new Object[] { Integer.valueOf(7) });
          com.tencent.mm.plugin.report.service.g.yhR.f(11788, new Object[] { Integer.valueOf(14), Long.valueOf(System.currentTimeMillis()), Long.valueOf(BackupMoveChooseUI.Il()), Long.valueOf(BackupMoveChooseUI.endTime) });
          i = 0;
          label440:
          localObject1 = com.tencent.mm.plugin.report.service.g.yhR;
          j = paramAnonymousView.size();
          if (i == 0) {
            break label1018;
          }
        }
        label735:
        label1018:
        for (int i = 1;; i = 0)
        {
          ((com.tencent.mm.plugin.report.service.g)localObject1).f(11788, new Object[] { Integer.valueOf(13), Integer.valueOf(j), Integer.valueOf(i) });
          com.tencent.mm.plugin.report.service.g.yhR.f(11788, new Object[] { Integer.valueOf(8) });
          paramAnonymousView = new Intent(BackupMoveChooseUI.this, BackupMoveQRCodeUI.class);
          MMWizardActivity.al(BackupMoveChooseUI.this, paramAnonymousView);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 23L, 1L, false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(21383);
          return;
          ((PLong)localObject1).value = 0L;
          ((PInt)localObject2).value = 0;
          LinkedList localLinkedList = com.tencent.mm.plugin.backup.d.b.bHG().bHK().bHC();
          if (localLinkedList != null)
          {
            i = 0;
            while (i < locala.getCount())
            {
              if (locala.nwm.contains(Integer.valueOf(i)))
              {
                paramAnonymousView.add(localLinkedList.get(i));
                ((PLong)localObject1).value += ((f.b)localLinkedList.get(i)).nta;
                ((PInt)localObject2).value = ((int)(((PInt)localObject2).value + ((f.b)localLinkedList.get(i)).ntb));
              }
              i += 1;
            }
          }
          ad.i("MicroMsg.BackupMoveChooseAdapter", "finishSelected usernameSize:%d, convSize:%d, convMsgCount:%d", new Object[] { Integer.valueOf(paramAnonymousView.size()), Long.valueOf(((PLong)localObject1).value), Integer.valueOf(((PInt)localObject2).value) });
          break;
          ((com.tencent.mm.plugin.backup.d.a)localObject2).nuO = new LinkedList(paramAnonymousView.subList(paramAnonymousView.size() * 3 / 4, paramAnonymousView.size()));
          ((com.tencent.mm.plugin.backup.d.a)localObject2).nuO.addAll(paramAnonymousView.subList(0, paramAnonymousView.size() * 3 / 4));
          break label117;
          d.nvP = false;
          break label155;
          d.nur = false;
          break label218;
          if (BackupMoveChooseUI.nwE == 1)
          {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 26L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yhR.f(11788, new Object[] { Integer.valueOf(5) });
            com.tencent.mm.plugin.report.service.g.yhR.f(11788, new Object[] { Integer.valueOf(14), Long.valueOf(System.currentTimeMillis()), Long.valueOf(BackupMoveChooseUI.Il()), Long.valueOf(BackupMoveChooseUI.endTime) });
            i = 0;
            break label440;
          }
          if (BackupMoveChooseUI.beN == 1)
          {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 27L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yhR.f(11788, new Object[] { Integer.valueOf(6) });
            i = 0;
            break label440;
          }
          localObject1 = BackupMoveChooseUI.a(BackupMoveChooseUI.this);
          if (((a)localObject1).nwm.size() == ((a)localObject1).getCount()) {}
          for (j = 1;; j = 0)
          {
            if (j != 0)
            {
              i = 1;
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(485L, 22L, 1L, false);
              com.tencent.mm.plugin.report.service.g.yhR.f(11788, new Object[] { Integer.valueOf(4) });
            }
            break;
          }
        }
      }
    });
    this.nwD.setEnabled(false);
    iD(true);
    this.nwt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21384);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new Intent(BackupMoveChooseUI.this, BackupSelectExtUI.class);
        paramAnonymousView.putExtra("BACKUP_MODE", 2);
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MODE", BackupMoveChooseUI.nwE);
        paramAnonymousView.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", true);
        paramAnonymousView.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupMoveChooseUI.beN);
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupMoveChooseUI.Il());
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupMoveChooseUI.endTime);
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", com.tencent.mm.plugin.backup.d.b.bHG().bHK().nuL);
        BackupMoveChooseUI.this.startActivityForResult(paramAnonymousView, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(21384);
      }
    });
    this.nwr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21385);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (com.tencent.mm.plugin.backup.d.b.bHG().bHK().nuP)
        {
          paramAnonymousView = BackupMoveChooseUI.a(BackupMoveChooseUI.this);
          if (paramAnonymousView.nwm.size() != paramAnonymousView.getCount()) {
            break label110;
          }
          paramAnonymousView.nwm.clear();
        }
        for (;;)
        {
          paramAnonymousView.notifyDataSetChanged();
          paramAnonymousView.nwl.a(paramAnonymousView.nwm);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(21385);
          return;
          label110:
          int i = 0;
          while (i < paramAnonymousView.getCount())
          {
            paramAnonymousView.nwm.add(Integer.valueOf(i));
            i += 1;
          }
        }
      }
    });
    if (com.tencent.mm.plugin.backup.d.b.bHG().bHK().nuP)
    {
      if ((com.tencent.mm.plugin.backup.d.b.bHG().bHK().bHC() == null) || (com.tencent.mm.plugin.backup.d.b.bHG().bHK().bHC().size() == 0)) {
        switch (nwE)
        {
        }
      }
      for (;;)
      {
        this.nws.setVisibility(0);
        this.nwu.setVisibility(4);
        AppMethodBeat.o(21391);
        return;
        this.nws.setText(2131756101);
        continue;
        this.nws.setText(2131756255);
      }
    }
    if (!com.tencent.mm.plugin.backup.d.b.bHG().bHK().nuP)
    {
      this.nwr.setTextColor(getResources().getColor(2131099992));
      this.nwr.setClickable(false);
      this.nwu.setVisibility(0);
      AppMethodBeat.o(21391);
      return;
    }
    this.nwu.setVisibility(4);
    AppMethodBeat.o(21391);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(21395);
    if (paramInt2 != -1)
    {
      ad.e("MicroMsg.BackupMoveChooseUI", "onActivityResult result error! resultCode:%d", new Object[] { Integer.valueOf(paramInt2) });
      AppMethodBeat.o(21395);
      return;
    }
    paramInt1 = nwE;
    long l1 = startTime;
    long l2 = endTime;
    nwE = paramIntent.getIntExtra("BACKUP_SELECT_TIME_MODE", nwE);
    startTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0L);
    endTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0L);
    beN = paramIntent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", beN);
    ad.i("MicroMsg.BackupMoveChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", new Object[] { Integer.valueOf(nwE), Integer.valueOf(paramInt1), Long.valueOf(startTime), Long.valueOf(l1), Long.valueOf(endTime), Long.valueOf(l2), Integer.valueOf(beN) });
    com.tencent.mm.plugin.backup.d.b.bHG().bHI();
    d.e(nwE, startTime, endTime, beN);
    iD(false);
    if ((paramInt1 == nwE) && ((nwE == 0) || ((nwE == 1) && (startTime == l1) && (endTime == l2))))
    {
      AppMethodBeat.o(21395);
      return;
    }
    com.tencent.mm.plugin.backup.d.b.bHG().bHK().a(nwE, startTime, endTime, com.tencent.mm.plugin.backup.d.b.bHG().bHK().bHB());
    paramIntent = this.nwp;
    paramIntent.nwm.clear();
    paramIntent.nwl.a(paramIntent.nwm);
    if ((com.tencent.mm.plugin.backup.d.b.bHG().bHK().bHC() == null) || (com.tencent.mm.plugin.backup.d.b.bHG().bHK().bHC().size() == 0)) {
      switch (nwE)
      {
      default: 
        this.nws.setVisibility(0);
      }
    }
    for (;;)
    {
      this.nwp.notifyDataSetChanged();
      AppMethodBeat.o(21395);
      return;
      this.nws.setText(2131756101);
      break;
      this.nws.setText(2131756255);
      break;
      this.nws.setVisibility(4);
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
    com.tencent.mm.plugin.backup.d.b.bHG().bHK().nuK = this.nwG;
    AppMethodBeat.o(21389);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(21390);
    super.onStop();
    com.tencent.mm.plugin.backup.d.b.bHG().bHK().nuK = null;
    AppMethodBeat.o(21390);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI
 * JD-Core Version:    0.7.0.1
 */