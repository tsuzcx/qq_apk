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
  private static int beK = 0;
  private static long endTime;
  private static int oMY = 0;
  private static long startTime;
  private a oMJ;
  private ListView oMK;
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
  private b.b oNa;
  
  public BackupMoveChooseUI()
  {
    AppMethodBeat.i(21387);
    this.oMJ = new a(this);
    this.oMZ = new SimpleDateFormat("yyyy.MM.dd");
    this.oNa = new b.b()
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
          switch (BackupMoveChooseUI.oMY)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(21386);
            return;
            BackupMoveChooseUI.c(BackupMoveChooseUI.this).setText(2131756235);
            AppMethodBeat.o(21386);
            return;
            BackupMoveChooseUI.c(BackupMoveChooseUI.this).setText(2131756389);
          }
        }
        BackupMoveChooseUI.d(BackupMoveChooseUI.this).setClickable(true);
        BackupMoveChooseUI.d(BackupMoveChooseUI.this).setTextColor(BackupMoveChooseUI.this.getResources().getColor(2131100014));
        BackupMoveChooseUI.b(BackupMoveChooseUI.this).setVisibility(8);
        BackupMoveChooseUI.a(BackupMoveChooseUI.this).notifyDataSetChanged();
        AppMethodBeat.o(21386);
      }
      
      public final void D(LinkedList<f.b> paramAnonymousLinkedList) {}
      
      public final void a(LinkedList<f.b> paramAnonymousLinkedList, f.b paramAnonymousb, int paramAnonymousInt) {}
    };
    AppMethodBeat.o(21387);
  }
  
  private void cfQ()
  {
    AppMethodBeat.i(21394);
    if ((this.oMR.getVisibility() == 8) && (this.oMS.getVisibility() == 8) && (this.oMT.getVisibility() == 8))
    {
      this.oMP.setVisibility(8);
      this.oMQ.setVisibility(8);
      AppMethodBeat.o(21394);
      return;
    }
    this.oMP.setVisibility(0);
    this.oMQ.setVisibility(0);
    AppMethodBeat.o(21394);
  }
  
  private void jC(boolean paramBoolean)
  {
    AppMethodBeat.i(21392);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.backup.d.b.cfv();
      SharedPreferences localSharedPreferences = com.tencent.mm.plugin.backup.d.b.ceR();
      oMY = localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
      beK = localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
      startTime = localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
      endTime = localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
    }
    switch (oMY)
    {
    default: 
      switch (beK)
      {
      }
      break;
    }
    for (;;)
    {
      cfQ();
      AppMethodBeat.o(21392);
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
      this.oMW.setText(getContext().getResources().getString(2131756298));
    }
  }
  
  public final void a(HashSet<Integer> paramHashSet)
  {
    AppMethodBeat.i(21393);
    Object localObject = com.tencent.mm.plugin.backup.d.b.cfv().cfz().cfr();
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
        l = ((f.b)((LinkedList)localObject).get(i)).oJt + l;
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
      this.oMX.setEnabled(true);
      if (paramHashSet.size() == this.oMJ.getCount())
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
      AppMethodBeat.o(21393);
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
    AppMethodBeat.i(21391);
    setMMTitle(2131756400);
    this.oMK = ((ListView)findViewById(2131297184));
    this.oMK.setAdapter(this.oMJ);
    this.oMK.setEmptyView(findViewById(2131297186));
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
    ((TextView)findViewById(2131297194)).setText(2131756236);
    ((TextView)findViewById(2131297197)).setText(2131756238);
    ((TextView)findViewById(2131297182)).setText(2131756234);
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
    this.oMX = ((Button)findViewById(2131297189));
    this.oMX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21383);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        localObject1 = new PLong();
        Object localObject2 = new PInt();
        a locala = BackupMoveChooseUI.a(BackupMoveChooseUI.this);
        paramAnonymousView = new LinkedList();
        label117:
        int j;
        if (locala.oMG.size() <= 0)
        {
          localObject1 = g.B(paramAnonymousView);
          localObject2 = com.tencent.mm.plugin.backup.d.b.cfv().cfz();
          if (paramAnonymousView.size() != 0) {
            break label573;
          }
          ((com.tencent.mm.plugin.backup.d.a)localObject2).oLh = new LinkedList();
          com.tencent.mm.plugin.backup.d.b.cfv().cfx().G((LinkedList)localObject1);
          localObject1 = com.tencent.mm.plugin.backup.d.b.cfv().cfz();
          if (((com.tencent.mm.plugin.backup.d.a)localObject1).oLc != null) {
            ((com.tencent.mm.plugin.backup.d.a)localObject1).oLc.cancel();
          }
          ThreadPool.post(new a.2((com.tencent.mm.plugin.backup.d.a)localObject1), "BackupMoveChooseServer.calculateChooseConvSize");
          i = 0;
          if ((BackupMoveChooseUI.oMY != 1) || (BackupMoveChooseUI.Tp() != 1)) {
            break label626;
          }
          h.CyF.idkeyStat(485L, 26L, 1L, false);
          h.CyF.idkeyStat(485L, 27L, 1L, false);
          h.CyF.a(11788, new Object[] { Integer.valueOf(7) });
          h.CyF.a(11788, new Object[] { Integer.valueOf(14), Long.valueOf(System.currentTimeMillis()), Long.valueOf(BackupMoveChooseUI.cfR()), Long.valueOf(BackupMoveChooseUI.endTime) });
          i = 0;
          label281:
          localObject1 = h.CyF;
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
          h.CyF.a(11788, new Object[] { Integer.valueOf(8) });
          paramAnonymousView = new Intent(BackupMoveChooseUI.this, BackupMoveQRCodeUI.class);
          MMWizardActivity.ay(BackupMoveChooseUI.this, paramAnonymousView);
          h.CyF.idkeyStat(485L, 23L, 1L, false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(21383);
          return;
          ((PLong)localObject1).value = 0L;
          ((PInt)localObject2).value = 0;
          LinkedList localLinkedList = com.tencent.mm.plugin.backup.d.b.cfv().cfz().cfr();
          if (localLinkedList != null)
          {
            i = 0;
            while (i < locala.getCount())
            {
              if (locala.oMG.contains(Integer.valueOf(i)))
              {
                paramAnonymousView.add(localLinkedList.get(i));
                ((PLong)localObject1).value += ((f.b)localLinkedList.get(i)).oJt;
                ((PInt)localObject2).value = ((int)(((PInt)localObject2).value + ((f.b)localLinkedList.get(i)).oJu));
              }
              i += 1;
            }
          }
          Log.i("MicroMsg.BackupMoveChooseAdapter", "finishSelected usernameSize:%d, convSize:%d, convMsgCount:%d", new Object[] { Integer.valueOf(paramAnonymousView.size()), Long.valueOf(((PLong)localObject1).value), Integer.valueOf(((PInt)localObject2).value) });
          break;
          ((com.tencent.mm.plugin.backup.d.a)localObject2).oLh = new LinkedList(paramAnonymousView.subList(paramAnonymousView.size() * 3 / 4, paramAnonymousView.size()));
          ((com.tencent.mm.plugin.backup.d.a)localObject2).oLh.addAll(paramAnonymousView.subList(0, paramAnonymousView.size() * 3 / 4));
          break label117;
          label626:
          if (BackupMoveChooseUI.oMY == 1)
          {
            h.CyF.idkeyStat(485L, 26L, 1L, false);
            h.CyF.a(11788, new Object[] { Integer.valueOf(5) });
            h.CyF.a(11788, new Object[] { Integer.valueOf(14), Long.valueOf(System.currentTimeMillis()), Long.valueOf(BackupMoveChooseUI.cfR()), Long.valueOf(BackupMoveChooseUI.endTime) });
            i = 0;
            break label281;
          }
          if (BackupMoveChooseUI.Tp() == 1)
          {
            h.CyF.idkeyStat(485L, 27L, 1L, false);
            h.CyF.a(11788, new Object[] { Integer.valueOf(6) });
            i = 0;
            break label281;
          }
          localObject1 = BackupMoveChooseUI.a(BackupMoveChooseUI.this);
          if (((a)localObject1).oMG.size() == ((a)localObject1).getCount()) {}
          for (j = 1;; j = 0)
          {
            if (j != 0)
            {
              i = 1;
              h.CyF.idkeyStat(485L, 22L, 1L, false);
              h.CyF.a(11788, new Object[] { Integer.valueOf(4) });
            }
            break;
          }
        }
      }
    });
    this.oMX.setEnabled(false);
    jC(true);
    this.oMN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21384);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new Intent(BackupMoveChooseUI.this, BackupSelectExtUI.class);
        paramAnonymousView.putExtra("BACKUP_MODE", 2);
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MODE", BackupMoveChooseUI.oMY);
        paramAnonymousView.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", true);
        paramAnonymousView.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupMoveChooseUI.Tp());
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupMoveChooseUI.cfR());
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupMoveChooseUI.endTime);
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", com.tencent.mm.plugin.backup.d.b.cfv().cfz().oLe);
        BackupMoveChooseUI.this.startActivityForResult(paramAnonymousView, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(21384);
      }
    });
    this.oML.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21385);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (com.tencent.mm.plugin.backup.d.b.cfv().cfz().oLi)
        {
          paramAnonymousView = BackupMoveChooseUI.a(BackupMoveChooseUI.this);
          if (paramAnonymousView.oMG.size() != paramAnonymousView.getCount()) {
            break label110;
          }
          paramAnonymousView.oMG.clear();
        }
        for (;;)
        {
          paramAnonymousView.notifyDataSetChanged();
          paramAnonymousView.oMF.a(paramAnonymousView.oMG);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(21385);
          return;
          label110:
          int i = 0;
          while (i < paramAnonymousView.getCount())
          {
            paramAnonymousView.oMG.add(Integer.valueOf(i));
            i += 1;
          }
        }
      }
    });
    if (com.tencent.mm.plugin.backup.d.b.cfv().cfz().oLi)
    {
      if ((com.tencent.mm.plugin.backup.d.b.cfv().cfz().cfr() == null) || (com.tencent.mm.plugin.backup.d.b.cfv().cfz().cfr().size() == 0)) {
        switch (oMY)
        {
        }
      }
      for (;;)
      {
        this.oMM.setVisibility(0);
        this.oMO.setVisibility(4);
        AppMethodBeat.o(21391);
        return;
        this.oMM.setText(2131756235);
        continue;
        this.oMM.setText(2131756389);
      }
    }
    if (!com.tencent.mm.plugin.backup.d.b.cfv().cfz().oLi)
    {
      this.oML.setTextColor(getResources().getColor(2131100016));
      this.oML.setClickable(false);
      this.oMO.setVisibility(0);
      AppMethodBeat.o(21391);
      return;
    }
    this.oMO.setVisibility(4);
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
    paramInt1 = oMY;
    long l1 = startTime;
    long l2 = endTime;
    oMY = paramIntent.getIntExtra("BACKUP_SELECT_TIME_MODE", oMY);
    startTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0L);
    endTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0L);
    beK = paramIntent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", beK);
    Log.i("MicroMsg.BackupMoveChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", new Object[] { Integer.valueOf(oMY), Integer.valueOf(paramInt1), Long.valueOf(startTime), Long.valueOf(l1), Long.valueOf(endTime), Long.valueOf(l2), Integer.valueOf(beK) });
    com.tencent.mm.plugin.backup.d.b.cfv().cfx();
    d.e(oMY, startTime, endTime, beK);
    jC(false);
    if ((paramInt1 == oMY) && ((oMY == 0) || ((oMY == 1) && (startTime == l1) && (endTime == l2))))
    {
      AppMethodBeat.o(21395);
      return;
    }
    com.tencent.mm.plugin.backup.d.b.cfv().cfz().a(oMY, startTime, endTime, com.tencent.mm.plugin.backup.d.b.cfv().cfz().cfq());
    paramIntent = this.oMJ;
    paramIntent.oMG.clear();
    paramIntent.oMF.a(paramIntent.oMG);
    if ((com.tencent.mm.plugin.backup.d.b.cfv().cfz().cfr() == null) || (com.tencent.mm.plugin.backup.d.b.cfv().cfz().cfr().size() == 0)) {
      switch (oMY)
      {
      default: 
        this.oMM.setVisibility(0);
      }
    }
    for (;;)
    {
      this.oMJ.notifyDataSetChanged();
      AppMethodBeat.o(21395);
      return;
      this.oMM.setText(2131756235);
      break;
      this.oMM.setText(2131756389);
      break;
      this.oMM.setVisibility(4);
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
    com.tencent.mm.plugin.backup.d.b.cfv().cfz().oLd = this.oNa;
    AppMethodBeat.o(21389);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(21390);
    super.onStop();
    com.tencent.mm.plugin.backup.d.b.cfv().cfz().oLd = null;
    AppMethodBeat.o(21390);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI
 * JD-Core Version:    0.7.0.1
 */