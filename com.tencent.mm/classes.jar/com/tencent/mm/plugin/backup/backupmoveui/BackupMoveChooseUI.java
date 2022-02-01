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
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI;
import com.tencent.mm.plugin.backup.c.b.b;
import com.tencent.mm.plugin.backup.d.a.2;
import com.tencent.mm.plugin.backup.d.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
  private static int nBZ = 0;
  private static long startTime;
  private a nBK;
  private ListView nBL;
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
  private b.b nCb;
  
  public BackupMoveChooseUI()
  {
    AppMethodBeat.i(21387);
    this.nBK = new a(this);
    this.nCa = new SimpleDateFormat("yyyy.MM.dd");
    this.nCb = new b.b()
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
          switch (BackupMoveChooseUI.nBZ)
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
  
  private void bIY()
  {
    AppMethodBeat.i(21394);
    if ((this.nBS.getVisibility() == 8) && (this.nBT.getVisibility() == 8) && (this.nBU.getVisibility() == 8))
    {
      this.nBQ.setVisibility(8);
      this.nBR.setVisibility(8);
      AppMethodBeat.o(21394);
      return;
    }
    this.nBQ.setVisibility(0);
    this.nBR.setVisibility(0);
    AppMethodBeat.o(21394);
  }
  
  private void iB(boolean paramBoolean)
  {
    AppMethodBeat.i(21392);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.backup.d.b.bIE();
      SharedPreferences localSharedPreferences = com.tencent.mm.plugin.backup.d.b.bIa();
      nBZ = localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
      beN = localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
      startTime = localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
      endTime = localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
    }
    switch (nBZ)
    {
    default: 
      switch (beN)
      {
      }
      break;
    }
    for (;;)
    {
      bIY();
      AppMethodBeat.o(21392);
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
      this.nBX.setText(getContext().getResources().getString(2131756164));
    }
  }
  
  public final void a(HashSet<Integer> paramHashSet)
  {
    AppMethodBeat.i(21393);
    Object localObject = com.tencent.mm.plugin.backup.d.b.bIE().bII().bIA();
    if (localObject == null)
    {
      ae.e("MicroMsg.BackupMoveChooseUI", "onClickCheckBox convInfo is null.");
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
        l = ((f.b)((LinkedList)localObject).get(i)).nyv + l;
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
      this.nBY.setEnabled(true);
      if (paramHashSet.size() == this.nBK.getCount())
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
      AppMethodBeat.o(21393);
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
    AppMethodBeat.i(21391);
    setMMTitle(2131756266);
    this.nBL = ((ListView)findViewById(2131297038));
    this.nBL.setAdapter(this.nBK);
    this.nBL.setEmptyView(findViewById(2131297040));
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
    this.nBY = ((Button)findViewById(2131297043));
    this.nBY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21383);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        localObject1 = new PLong();
        Object localObject2 = new PInt();
        a locala = BackupMoveChooseUI.a(BackupMoveChooseUI.this);
        paramAnonymousView = new LinkedList();
        label117:
        int j;
        if (locala.nBH.size() <= 0)
        {
          localObject1 = com.tencent.mm.plugin.backup.b.g.B(paramAnonymousView);
          localObject2 = com.tencent.mm.plugin.backup.d.b.bIE().bII();
          if (paramAnonymousView.size() != 0) {
            break label735;
          }
          ((com.tencent.mm.plugin.backup.d.a)localObject2).nAj = new LinkedList();
          localObject2 = com.tencent.mm.plugin.backup.d.b.bIE().bIG();
          ((d)localObject2).nBd = ((LinkedList)localObject1);
          com.tencent.mm.plugin.backup.d.b.bIE();
          if (com.tencent.mm.plugin.backup.d.b.bIa().getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0) != 1) {
            break label788;
          }
          d.nBk = true;
          label155:
          com.tencent.mm.plugin.backup.d.b.bIE();
          ((d)localObject2).nBg = com.tencent.mm.plugin.backup.d.b.bIa().getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
          com.tencent.mm.plugin.backup.d.b.bIE();
          ((d)localObject2).nBh = com.tencent.mm.plugin.backup.d.b.bIa().getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
          com.tencent.mm.plugin.backup.d.b.bIE();
          if (com.tencent.mm.plugin.backup.d.b.bIa().getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0) != 1) {
            break label795;
          }
          d.nzM = true;
          label218:
          ae.i("MicroMsg.BackupMoveServer", "setBakupChooseData users size[%d], selectStartTime[%d], selectEndTime[%d], isQuickBackup[%b]", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), Long.valueOf(((d)localObject2).nBg), Long.valueOf(((d)localObject2).nBh), Boolean.valueOf(d.nzM) });
          bc.aCg();
          c.ajA().set(am.a.IRD, Boolean.TRUE);
          localObject1 = com.tencent.mm.plugin.backup.d.b.bIE().bII();
          if (((com.tencent.mm.plugin.backup.d.a)localObject1).nAe != null) {
            ((com.tencent.mm.plugin.backup.d.a)localObject1).nAe.cancel();
          }
          com.tencent.mm.sdk.g.b.c(new a.2((com.tencent.mm.plugin.backup.d.a)localObject1), "BackupMoveChooseServer.calculateChooseConvSize");
          i = 0;
          if ((BackupMoveChooseUI.nBZ != 1) || (BackupMoveChooseUI.beN != 1)) {
            break label802;
          }
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 26L, 1L, false);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 27L, 1L, false);
          com.tencent.mm.plugin.report.service.g.yxI.f(11788, new Object[] { Integer.valueOf(7) });
          com.tencent.mm.plugin.report.service.g.yxI.f(11788, new Object[] { Integer.valueOf(14), Long.valueOf(System.currentTimeMillis()), Long.valueOf(BackupMoveChooseUI.It()), Long.valueOf(BackupMoveChooseUI.endTime) });
          i = 0;
          label440:
          localObject1 = com.tencent.mm.plugin.report.service.g.yxI;
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
          com.tencent.mm.plugin.report.service.g.yxI.f(11788, new Object[] { Integer.valueOf(8) });
          paramAnonymousView = new Intent(BackupMoveChooseUI.this, BackupMoveQRCodeUI.class);
          MMWizardActivity.al(BackupMoveChooseUI.this, paramAnonymousView);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 23L, 1L, false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(21383);
          return;
          ((PLong)localObject1).value = 0L;
          ((PInt)localObject2).value = 0;
          LinkedList localLinkedList = com.tencent.mm.plugin.backup.d.b.bIE().bII().bIA();
          if (localLinkedList != null)
          {
            i = 0;
            while (i < locala.getCount())
            {
              if (locala.nBH.contains(Integer.valueOf(i)))
              {
                paramAnonymousView.add(localLinkedList.get(i));
                ((PLong)localObject1).value += ((f.b)localLinkedList.get(i)).nyv;
                ((PInt)localObject2).value = ((int)(((PInt)localObject2).value + ((f.b)localLinkedList.get(i)).nyw));
              }
              i += 1;
            }
          }
          ae.i("MicroMsg.BackupMoveChooseAdapter", "finishSelected usernameSize:%d, convSize:%d, convMsgCount:%d", new Object[] { Integer.valueOf(paramAnonymousView.size()), Long.valueOf(((PLong)localObject1).value), Integer.valueOf(((PInt)localObject2).value) });
          break;
          ((com.tencent.mm.plugin.backup.d.a)localObject2).nAj = new LinkedList(paramAnonymousView.subList(paramAnonymousView.size() * 3 / 4, paramAnonymousView.size()));
          ((com.tencent.mm.plugin.backup.d.a)localObject2).nAj.addAll(paramAnonymousView.subList(0, paramAnonymousView.size() * 3 / 4));
          break label117;
          d.nBk = false;
          break label155;
          d.nzM = false;
          break label218;
          if (BackupMoveChooseUI.nBZ == 1)
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 26L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yxI.f(11788, new Object[] { Integer.valueOf(5) });
            com.tencent.mm.plugin.report.service.g.yxI.f(11788, new Object[] { Integer.valueOf(14), Long.valueOf(System.currentTimeMillis()), Long.valueOf(BackupMoveChooseUI.It()), Long.valueOf(BackupMoveChooseUI.endTime) });
            i = 0;
            break label440;
          }
          if (BackupMoveChooseUI.beN == 1)
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 27L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yxI.f(11788, new Object[] { Integer.valueOf(6) });
            i = 0;
            break label440;
          }
          localObject1 = BackupMoveChooseUI.a(BackupMoveChooseUI.this);
          if (((a)localObject1).nBH.size() == ((a)localObject1).getCount()) {}
          for (j = 1;; j = 0)
          {
            if (j != 0)
            {
              i = 1;
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 22L, 1L, false);
              com.tencent.mm.plugin.report.service.g.yxI.f(11788, new Object[] { Integer.valueOf(4) });
            }
            break;
          }
        }
      }
    });
    this.nBY.setEnabled(false);
    iB(true);
    this.nBO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21384);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new Intent(BackupMoveChooseUI.this, BackupSelectExtUI.class);
        paramAnonymousView.putExtra("BACKUP_MODE", 2);
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MODE", BackupMoveChooseUI.nBZ);
        paramAnonymousView.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", true);
        paramAnonymousView.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupMoveChooseUI.beN);
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupMoveChooseUI.It());
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupMoveChooseUI.endTime);
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", com.tencent.mm.plugin.backup.d.b.bIE().bII().nAg);
        BackupMoveChooseUI.this.startActivityForResult(paramAnonymousView, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(21384);
      }
    });
    this.nBM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21385);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (com.tencent.mm.plugin.backup.d.b.bIE().bII().nAk)
        {
          paramAnonymousView = BackupMoveChooseUI.a(BackupMoveChooseUI.this);
          if (paramAnonymousView.nBH.size() != paramAnonymousView.getCount()) {
            break label110;
          }
          paramAnonymousView.nBH.clear();
        }
        for (;;)
        {
          paramAnonymousView.notifyDataSetChanged();
          paramAnonymousView.nBG.a(paramAnonymousView.nBH);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(21385);
          return;
          label110:
          int i = 0;
          while (i < paramAnonymousView.getCount())
          {
            paramAnonymousView.nBH.add(Integer.valueOf(i));
            i += 1;
          }
        }
      }
    });
    if (com.tencent.mm.plugin.backup.d.b.bIE().bII().nAk)
    {
      if ((com.tencent.mm.plugin.backup.d.b.bIE().bII().bIA() == null) || (com.tencent.mm.plugin.backup.d.b.bIE().bII().bIA().size() == 0)) {
        switch (nBZ)
        {
        }
      }
      for (;;)
      {
        this.nBN.setVisibility(0);
        this.nBP.setVisibility(4);
        AppMethodBeat.o(21391);
        return;
        this.nBN.setText(2131756101);
        continue;
        this.nBN.setText(2131756255);
      }
    }
    if (!com.tencent.mm.plugin.backup.d.b.bIE().bII().nAk)
    {
      this.nBM.setTextColor(getResources().getColor(2131099992));
      this.nBM.setClickable(false);
      this.nBP.setVisibility(0);
      AppMethodBeat.o(21391);
      return;
    }
    this.nBP.setVisibility(4);
    AppMethodBeat.o(21391);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(21395);
    if (paramInt2 != -1)
    {
      ae.e("MicroMsg.BackupMoveChooseUI", "onActivityResult result error! resultCode:%d", new Object[] { Integer.valueOf(paramInt2) });
      AppMethodBeat.o(21395);
      return;
    }
    paramInt1 = nBZ;
    long l1 = startTime;
    long l2 = endTime;
    nBZ = paramIntent.getIntExtra("BACKUP_SELECT_TIME_MODE", nBZ);
    startTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0L);
    endTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0L);
    beN = paramIntent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", beN);
    ae.i("MicroMsg.BackupMoveChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", new Object[] { Integer.valueOf(nBZ), Integer.valueOf(paramInt1), Long.valueOf(startTime), Long.valueOf(l1), Long.valueOf(endTime), Long.valueOf(l2), Integer.valueOf(beN) });
    com.tencent.mm.plugin.backup.d.b.bIE().bIG();
    d.e(nBZ, startTime, endTime, beN);
    iB(false);
    if ((paramInt1 == nBZ) && ((nBZ == 0) || ((nBZ == 1) && (startTime == l1) && (endTime == l2))))
    {
      AppMethodBeat.o(21395);
      return;
    }
    com.tencent.mm.plugin.backup.d.b.bIE().bII().a(nBZ, startTime, endTime, com.tencent.mm.plugin.backup.d.b.bIE().bII().bIz());
    paramIntent = this.nBK;
    paramIntent.nBH.clear();
    paramIntent.nBG.a(paramIntent.nBH);
    if ((com.tencent.mm.plugin.backup.d.b.bIE().bII().bIA() == null) || (com.tencent.mm.plugin.backup.d.b.bIE().bII().bIA().size() == 0)) {
      switch (nBZ)
      {
      default: 
        this.nBN.setVisibility(0);
      }
    }
    for (;;)
    {
      this.nBK.notifyDataSetChanged();
      AppMethodBeat.o(21395);
      return;
      this.nBN.setText(2131756101);
      break;
      this.nBN.setText(2131756255);
      break;
      this.nBN.setVisibility(4);
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
    com.tencent.mm.plugin.backup.d.b.bIE().bII().nAf = this.nCb;
    AppMethodBeat.o(21389);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(21390);
    super.onStop();
    com.tencent.mm.plugin.backup.d.b.bIE().bII().nAf = null;
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