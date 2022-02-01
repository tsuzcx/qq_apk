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
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI;
import com.tencent.mm.plugin.backup.c.b.b;
import com.tencent.mm.plugin.backup.d.a.2;
import com.tencent.mm.plugin.backup.d.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  private static int aUt = 0;
  private static long endTime;
  private static int mWh = 0;
  private static long startTime;
  private a mVS;
  private ListView mVT;
  private TextView mVU;
  private TextView mVV;
  private TextView mVW;
  private ProgressBar mVX;
  private View mVY;
  private LinearLayout mVZ;
  private LinearLayout mWa;
  private LinearLayout mWb;
  private LinearLayout mWc;
  private TextView mWd;
  private TextView mWe;
  private TextView mWf;
  private Button mWg;
  private SimpleDateFormat mWi;
  private b.b mWj;
  
  public BackupMoveChooseUI()
  {
    AppMethodBeat.i(21387);
    this.mVS = new a(this);
    this.mWi = new SimpleDateFormat("yyyy.MM.dd");
    this.mWj = new b.b()
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
          switch (BackupMoveChooseUI.mWh)
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
  
  private void bDR()
  {
    AppMethodBeat.i(21394);
    if ((this.mWa.getVisibility() == 8) && (this.mWb.getVisibility() == 8) && (this.mWc.getVisibility() == 8))
    {
      this.mVY.setVisibility(8);
      this.mVZ.setVisibility(8);
      AppMethodBeat.o(21394);
      return;
    }
    this.mVY.setVisibility(0);
    this.mVZ.setVisibility(0);
    AppMethodBeat.o(21394);
  }
  
  private void iu(boolean paramBoolean)
  {
    AppMethodBeat.i(21392);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.backup.d.b.bDy();
      SharedPreferences localSharedPreferences = com.tencent.mm.plugin.backup.d.b.bCU();
      mWh = localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
      aUt = localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
      startTime = localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
      endTime = localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
    }
    switch (mWh)
    {
    default: 
      switch (aUt)
      {
      }
      break;
    }
    for (;;)
    {
      bDR();
      AppMethodBeat.o(21392);
      return;
      this.mWb.setVisibility(8);
      break;
      this.mVY.setVisibility(0);
      this.mVZ.setVisibility(0);
      this.mWb.setVisibility(0);
      this.mWe.setText(this.mWi.format(new Date(startTime)) + "~" + this.mWi.format(new Date(endTime - 86400000L)));
      break;
      this.mWc.setVisibility(8);
      continue;
      this.mVY.setVisibility(0);
      this.mVZ.setVisibility(0);
      this.mWc.setVisibility(0);
      this.mWf.setText(getContext().getResources().getString(2131756164));
    }
  }
  
  public final void a(HashSet<Integer> paramHashSet)
  {
    AppMethodBeat.i(21393);
    Object localObject = com.tencent.mm.plugin.backup.d.b.bDy().bDC().bDu();
    if (localObject == null)
    {
      ac.e("MicroMsg.BackupMoveChooseUI", "onClickCheckBox convInfo is null.");
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
        l = ((f.b)((LinkedList)localObject).get(i)).mSC + l;
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
      this.mWg.setEnabled(true);
      if (paramHashSet.size() == this.mVS.getCount())
      {
        this.mVU.setText(2131756092);
        this.mVY.setVisibility(0);
        this.mVZ.setVisibility(0);
        this.mWa.setVisibility(0);
        this.mWd.setText(getString(2131756094, new Object[] { Integer.valueOf(paramHashSet.size()) }));
      }
    }
    for (;;)
    {
      bDR();
      AppMethodBeat.o(21393);
      return;
      this.mVU.setText(2131756091);
      break;
      this.mWg.setEnabled(false);
      this.mVU.setText(2131756091);
      this.mWa.setVisibility(8);
      this.mWd.setText("");
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
    this.mVT = ((ListView)findViewById(2131297038));
    this.mVT.setAdapter(this.mVS);
    this.mVT.setEmptyView(findViewById(2131297040));
    this.mVU = ((TextView)findViewById(2131297046));
    this.mVV = ((TextView)findViewById(2131297039));
    this.mVX = ((ProgressBar)findViewById(2131297045));
    this.mVW = ((TextView)findViewById(2131297041));
    this.mVY = findViewById(2131297044);
    this.mVZ = ((LinearLayout)findViewById(2131297042));
    this.mWa = ((LinearLayout)findViewById(2131297047));
    this.mWb = ((LinearLayout)findViewById(2131297050));
    this.mWc = ((LinearLayout)findViewById(2131297035));
    this.mWd = ((TextView)findViewById(2131297049));
    this.mWe = ((TextView)findViewById(2131297052));
    this.mWf = ((TextView)findViewById(2131297037));
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
    this.mWg = ((Button)findViewById(2131297043));
    this.mWg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21383);
        Object localObject1 = new PLong();
        Object localObject2 = new PInt();
        a locala = BackupMoveChooseUI.a(BackupMoveChooseUI.this);
        paramAnonymousView = new LinkedList();
        label85:
        label123:
        int j;
        if (locala.mVP.size() <= 0)
        {
          localObject1 = g.B(paramAnonymousView);
          localObject2 = com.tencent.mm.plugin.backup.d.b.bDy().bDC();
          if (paramAnonymousView.size() != 0) {
            break label690;
          }
          ((com.tencent.mm.plugin.backup.d.a)localObject2).mUq = new LinkedList();
          localObject2 = com.tencent.mm.plugin.backup.d.b.bDy().bDA();
          ((d)localObject2).mVl = ((LinkedList)localObject1);
          com.tencent.mm.plugin.backup.d.b.bDy();
          if (com.tencent.mm.plugin.backup.d.b.bCU().getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0) != 1) {
            break label743;
          }
          d.mVs = true;
          com.tencent.mm.plugin.backup.d.b.bDy();
          ((d)localObject2).mVo = com.tencent.mm.plugin.backup.d.b.bCU().getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
          com.tencent.mm.plugin.backup.d.b.bDy();
          ((d)localObject2).mVp = com.tencent.mm.plugin.backup.d.b.bCU().getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
          com.tencent.mm.plugin.backup.d.b.bDy();
          if (com.tencent.mm.plugin.backup.d.b.bCU().getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0) != 1) {
            break label750;
          }
          d.mTT = true;
          label186:
          ac.i("MicroMsg.BackupMoveServer", "setBakupChooseData users size[%d], selectStartTime[%d], selectEndTime[%d], isQuickBackup[%b]", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), Long.valueOf(((d)localObject2).mVo), Long.valueOf(((d)localObject2).mVp), Boolean.valueOf(d.mTT) });
          az.ayM();
          c.agA().set(ah.a.GKN, Boolean.TRUE);
          localObject1 = com.tencent.mm.plugin.backup.d.b.bDy().bDC();
          if (((com.tencent.mm.plugin.backup.d.a)localObject1).mUl != null) {
            ((com.tencent.mm.plugin.backup.d.a)localObject1).mUl.cancel();
          }
          com.tencent.mm.sdk.g.b.c(new a.2((com.tencent.mm.plugin.backup.d.a)localObject1), "BackupMoveChooseServer.calculateChooseConvSize");
          i = 0;
          if ((BackupMoveChooseUI.mWh != 1) || (BackupMoveChooseUI.aUt != 1)) {
            break label757;
          }
          h.wUl.idkeyStat(485L, 26L, 1L, false);
          h.wUl.idkeyStat(485L, 27L, 1L, false);
          h.wUl.f(11788, new Object[] { Integer.valueOf(7) });
          h.wUl.f(11788, new Object[] { Integer.valueOf(14), Long.valueOf(System.currentTimeMillis()), Long.valueOf(BackupMoveChooseUI.GQ()), Long.valueOf(BackupMoveChooseUI.endTime) });
          i = 0;
          label408:
          localObject1 = h.wUl;
          j = paramAnonymousView.size();
          if (i == 0) {
            break label973;
          }
        }
        label690:
        label973:
        for (int i = 1;; i = 0)
        {
          ((h)localObject1).f(11788, new Object[] { Integer.valueOf(13), Integer.valueOf(j), Integer.valueOf(i) });
          h.wUl.f(11788, new Object[] { Integer.valueOf(8) });
          paramAnonymousView = new Intent(BackupMoveChooseUI.this, BackupMoveQRCodeUI.class);
          MMWizardActivity.aj(BackupMoveChooseUI.this, paramAnonymousView);
          h.wUl.idkeyStat(485L, 23L, 1L, false);
          AppMethodBeat.o(21383);
          return;
          ((PLong)localObject1).value = 0L;
          ((PInt)localObject2).value = 0;
          LinkedList localLinkedList = com.tencent.mm.plugin.backup.d.b.bDy().bDC().bDu();
          if (localLinkedList != null)
          {
            i = 0;
            while (i < locala.getCount())
            {
              if (locala.mVP.contains(Integer.valueOf(i)))
              {
                paramAnonymousView.add(localLinkedList.get(i));
                ((PLong)localObject1).value += ((f.b)localLinkedList.get(i)).mSC;
                ((PInt)localObject2).value = ((int)(((PInt)localObject2).value + ((f.b)localLinkedList.get(i)).mSD));
              }
              i += 1;
            }
          }
          ac.i("MicroMsg.BackupMoveChooseAdapter", "finishSelected usernameSize:%d, convSize:%d, convMsgCount:%d", new Object[] { Integer.valueOf(paramAnonymousView.size()), Long.valueOf(((PLong)localObject1).value), Integer.valueOf(((PInt)localObject2).value) });
          break;
          ((com.tencent.mm.plugin.backup.d.a)localObject2).mUq = new LinkedList(paramAnonymousView.subList(paramAnonymousView.size() * 3 / 4, paramAnonymousView.size()));
          ((com.tencent.mm.plugin.backup.d.a)localObject2).mUq.addAll(paramAnonymousView.subList(0, paramAnonymousView.size() * 3 / 4));
          break label85;
          label743:
          d.mVs = false;
          break label123;
          label750:
          d.mTT = false;
          break label186;
          label757:
          if (BackupMoveChooseUI.mWh == 1)
          {
            h.wUl.idkeyStat(485L, 26L, 1L, false);
            h.wUl.f(11788, new Object[] { Integer.valueOf(5) });
            h.wUl.f(11788, new Object[] { Integer.valueOf(14), Long.valueOf(System.currentTimeMillis()), Long.valueOf(BackupMoveChooseUI.GQ()), Long.valueOf(BackupMoveChooseUI.endTime) });
            i = 0;
            break label408;
          }
          if (BackupMoveChooseUI.aUt == 1)
          {
            h.wUl.idkeyStat(485L, 27L, 1L, false);
            h.wUl.f(11788, new Object[] { Integer.valueOf(6) });
            i = 0;
            break label408;
          }
          localObject1 = BackupMoveChooseUI.a(BackupMoveChooseUI.this);
          if (((a)localObject1).mVP.size() == ((a)localObject1).getCount()) {}
          for (j = 1;; j = 0)
          {
            if (j != 0)
            {
              i = 1;
              h.wUl.idkeyStat(485L, 22L, 1L, false);
              h.wUl.f(11788, new Object[] { Integer.valueOf(4) });
            }
            break;
          }
        }
      }
    });
    this.mWg.setEnabled(false);
    iu(true);
    this.mVW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21384);
        paramAnonymousView = new Intent(BackupMoveChooseUI.this, BackupSelectExtUI.class);
        paramAnonymousView.putExtra("BACKUP_MODE", 2);
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MODE", BackupMoveChooseUI.mWh);
        paramAnonymousView.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", true);
        paramAnonymousView.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupMoveChooseUI.aUt);
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupMoveChooseUI.GQ());
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupMoveChooseUI.endTime);
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", com.tencent.mm.plugin.backup.d.b.bDy().bDC().mUn);
        BackupMoveChooseUI.this.startActivityForResult(paramAnonymousView, 0);
        AppMethodBeat.o(21384);
      }
    });
    this.mVU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21385);
        if (com.tencent.mm.plugin.backup.d.b.bDy().bDC().mUr)
        {
          paramAnonymousView = BackupMoveChooseUI.a(BackupMoveChooseUI.this);
          if (paramAnonymousView.mVP.size() != paramAnonymousView.getCount()) {
            break label69;
          }
          paramAnonymousView.mVP.clear();
        }
        for (;;)
        {
          paramAnonymousView.notifyDataSetChanged();
          paramAnonymousView.mVO.a(paramAnonymousView.mVP);
          AppMethodBeat.o(21385);
          return;
          label69:
          int i = 0;
          while (i < paramAnonymousView.getCount())
          {
            paramAnonymousView.mVP.add(Integer.valueOf(i));
            i += 1;
          }
        }
      }
    });
    if (com.tencent.mm.plugin.backup.d.b.bDy().bDC().mUr)
    {
      if ((com.tencent.mm.plugin.backup.d.b.bDy().bDC().bDu() == null) || (com.tencent.mm.plugin.backup.d.b.bDy().bDC().bDu().size() == 0)) {
        switch (mWh)
        {
        }
      }
      for (;;)
      {
        this.mVV.setVisibility(0);
        this.mVX.setVisibility(4);
        AppMethodBeat.o(21391);
        return;
        this.mVV.setText(2131756101);
        continue;
        this.mVV.setText(2131756255);
      }
    }
    if (!com.tencent.mm.plugin.backup.d.b.bDy().bDC().mUr)
    {
      this.mVU.setTextColor(getResources().getColor(2131099992));
      this.mVU.setClickable(false);
      this.mVX.setVisibility(0);
      AppMethodBeat.o(21391);
      return;
    }
    this.mVX.setVisibility(4);
    AppMethodBeat.o(21391);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(21395);
    if (paramInt2 != -1)
    {
      ac.e("MicroMsg.BackupMoveChooseUI", "onActivityResult result error! resultCode:%d", new Object[] { Integer.valueOf(paramInt2) });
      AppMethodBeat.o(21395);
      return;
    }
    paramInt1 = mWh;
    long l1 = startTime;
    long l2 = endTime;
    mWh = paramIntent.getIntExtra("BACKUP_SELECT_TIME_MODE", mWh);
    startTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0L);
    endTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0L);
    aUt = paramIntent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", aUt);
    ac.i("MicroMsg.BackupMoveChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", new Object[] { Integer.valueOf(mWh), Integer.valueOf(paramInt1), Long.valueOf(startTime), Long.valueOf(l1), Long.valueOf(endTime), Long.valueOf(l2), Integer.valueOf(aUt) });
    com.tencent.mm.plugin.backup.d.b.bDy().bDA();
    d.e(mWh, startTime, endTime, aUt);
    iu(false);
    if ((paramInt1 == mWh) && ((mWh == 0) || ((mWh == 1) && (startTime == l1) && (endTime == l2))))
    {
      AppMethodBeat.o(21395);
      return;
    }
    com.tencent.mm.plugin.backup.d.b.bDy().bDC().a(mWh, startTime, endTime, com.tencent.mm.plugin.backup.d.b.bDy().bDC().bDt());
    paramIntent = this.mVS;
    paramIntent.mVP.clear();
    paramIntent.mVO.a(paramIntent.mVP);
    if ((com.tencent.mm.plugin.backup.d.b.bDy().bDC().bDu() == null) || (com.tencent.mm.plugin.backup.d.b.bDy().bDC().bDu().size() == 0)) {
      switch (mWh)
      {
      default: 
        this.mVV.setVisibility(0);
      }
    }
    for (;;)
    {
      this.mVS.notifyDataSetChanged();
      AppMethodBeat.o(21395);
      return;
      this.mVV.setText(2131756101);
      break;
      this.mVV.setText(2131756255);
      break;
      this.mVV.setVisibility(4);
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
    com.tencent.mm.plugin.backup.d.b.bDy().bDC().mUm = this.mWj;
    AppMethodBeat.o(21389);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(21390);
    super.onStop();
    com.tencent.mm.plugin.backup.d.b.bDy().bDC().mUm = null;
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