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
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.e;
import com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI;
import com.tencent.mm.plugin.backup.c.b.a;
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
public class BackupPcChooseUI
  extends MMWizardActivity
{
  private static int aUt = 0;
  private static long endTime;
  private static int mWh = 0;
  private static long startTime;
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
  private a mYc;
  private ListView mYd;
  private b.a mYe;
  
  public BackupPcChooseUI()
  {
    AppMethodBeat.i(21638);
    this.mYc = new a(this);
    this.mWi = new SimpleDateFormat("yyyy.MM.dd");
    this.mYe = new b.a()
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
          switch (BackupPcChooseUI.mWh)
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
  
  private void bDR()
  {
    AppMethodBeat.i(21645);
    if ((this.mWa.getVisibility() == 8) && (this.mWb.getVisibility() == 8) && (this.mWc.getVisibility() == 8))
    {
      this.mVY.setVisibility(8);
      this.mVZ.setVisibility(8);
      AppMethodBeat.o(21645);
      return;
    }
    this.mVY.setVisibility(0);
    this.mVZ.setVisibility(0);
    AppMethodBeat.o(21645);
  }
  
  private void iu(boolean paramBoolean)
  {
    AppMethodBeat.i(21643);
    if (paramBoolean)
    {
      b.bEa();
      SharedPreferences localSharedPreferences = b.bCU();
      mWh = localSharedPreferences.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
      aUt = localSharedPreferences.getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
      startTime = localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
      endTime = localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
    }
    if (b.bEa().bEc().mXQ) {}
    switch (mWh)
    {
    default: 
      if (b.bEa().bEc().mXR) {
        switch (aUt)
        {
        }
      }
      break;
    }
    for (;;)
    {
      bDR();
      AppMethodBeat.o(21643);
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
      this.mWf.setText(getContext().getResources().getString(2131756236));
    }
  }
  
  public final void a(HashSet<Integer> paramHashSet)
  {
    AppMethodBeat.i(21644);
    Object localObject = new HashSet();
    int i = b.bEa().bEe().bDu().size();
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
      this.mWg.setEnabled(true);
      if ((b.bEa().bEe().mUr) && (paramHashSet.size() == this.mYc.getCount()))
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
      AppMethodBeat.o(21644);
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
    AppMethodBeat.i(21642);
    setMMTitle(2131756242);
    this.mYd = ((ListView)findViewById(2131297038));
    this.mYd.setAdapter(this.mYc);
    this.mYd.setEmptyView(findViewById(2131297040));
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
    this.mWg = ((Button)findViewById(2131297043));
    this.mWg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(21634);
        Object localObject = BackupPcChooseUI.a(BackupPcChooseUI.this);
        paramAnonymousView = new LinkedList();
        if (((a)localObject).mVP.size() <= 0) {}
        for (;;)
        {
          localObject = g.B(paramAnonymousView);
          az.ayM();
          boolean bool = ((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GKQ, Boolean.FALSE)).booleanValue();
          ac.i("MicroMsg.BackupPcChooseUI", "initView OnMenuItemClickListener startbackup choose records finish, selectedConversation size[%d], hasMove[%b], timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[] { Integer.valueOf(paramAnonymousView.size()), Boolean.valueOf(bool), Integer.valueOf(BackupPcChooseUI.mWh), Long.valueOf(BackupPcChooseUI.startTime), Long.valueOf(BackupPcChooseUI.GQ()), Integer.valueOf(BackupPcChooseUI.aUt) });
          if (!bool) {
            break;
          }
          com.tencent.mm.ui.base.h.a(BackupPcChooseUI.this, 2131756216, 0, 2131756270, 0, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21633);
              b.bEa().bEe().G(paramAnonymousView);
              b.bEa().bEb().wT(2);
              b.bEa().bCP().mSk = 12;
              b.bEa().bEc().H(this.mYh);
              b.bEa().bEc().rc(paramAnonymousView.size());
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(400L, 8L, 1L, false);
              com.tencent.mm.plugin.report.service.h.wUl.f(13735, new Object[] { Integer.valueOf(10), Integer.valueOf(b.bEa().bEb().mXB) });
              if ((BackupPcChooseUI.mWh == 1) && (BackupPcChooseUI.aUt == 1))
              {
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(400L, 32L, 1L, false);
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(400L, 35L, 1L, false);
                com.tencent.mm.plugin.report.service.h.wUl.f(13735, new Object[] { Integer.valueOf(13), Integer.valueOf(b.bEa().bEb().mXB) });
              }
              for (;;)
              {
                BackupPcChooseUI.this.finish();
                AppMethodBeat.o(21633);
                return;
                if (BackupPcChooseUI.mWh == 1)
                {
                  com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(400L, 32L, 1L, false);
                  com.tencent.mm.plugin.report.service.h.wUl.f(13735, new Object[] { Integer.valueOf(11), Integer.valueOf(b.bEa().bEb().mXB) });
                }
                else if (BackupPcChooseUI.aUt == 1)
                {
                  com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(400L, 35L, 1L, false);
                  com.tencent.mm.plugin.report.service.h.wUl.f(13735, new Object[] { Integer.valueOf(12), Integer.valueOf(b.bEa().bEb().mXB) });
                }
              }
            }
          }, null, 2131099990);
          AppMethodBeat.o(21634);
          return;
          LinkedList localLinkedList = b.bEa().bEe().bDu();
          if (localLinkedList != null)
          {
            int i = 0;
            while (i < ((a)localObject).getCount())
            {
              if (((a)localObject).mVP.contains(Integer.valueOf(i))) {
                paramAnonymousView.add(localLinkedList.get(i));
              }
              i += 1;
            }
          }
          ac.i("MicroMsg.BackupPcChooseAdapter", "finishSelected usernameSize:%d", new Object[] { Integer.valueOf(paramAnonymousView.size()) });
        }
        b.bEa().bEe().G(paramAnonymousView);
        b.bEa().bEb().wT(2);
        b.bEa().bCP().mSk = 12;
        b.bEa().bEc().H((LinkedList)localObject);
        b.bEa().bEc().rc(paramAnonymousView.size());
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(400L, 8L, 1L, false);
        com.tencent.mm.plugin.report.service.h.wUl.f(13735, new Object[] { Integer.valueOf(10), Integer.valueOf(b.bEa().bEb().mXB) });
        if ((BackupPcChooseUI.mWh == 1) && (BackupPcChooseUI.aUt == 1))
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(400L, 32L, 1L, false);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(400L, 35L, 1L, false);
          com.tencent.mm.plugin.report.service.h.wUl.f(13735, new Object[] { Integer.valueOf(13), Integer.valueOf(b.bEa().bEb().mXB) });
        }
        for (;;)
        {
          BackupPcChooseUI.this.finish();
          AppMethodBeat.o(21634);
          return;
          if (BackupPcChooseUI.mWh == 1)
          {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(400L, 32L, 1L, false);
            com.tencent.mm.plugin.report.service.h.wUl.f(13735, new Object[] { Integer.valueOf(11), Integer.valueOf(b.bEa().bEb().mXB) });
          }
          else if (BackupPcChooseUI.aUt == 1)
          {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(400L, 35L, 1L, false);
            com.tencent.mm.plugin.report.service.h.wUl.f(13735, new Object[] { Integer.valueOf(12), Integer.valueOf(b.bEa().bEb().mXB) });
          }
        }
      }
    });
    this.mWg.setEnabled(false);
    if ((!b.bEa().bEc().mXQ) && (!b.bEa().bEc().mXR)) {
      this.mVW.setVisibility(8);
    }
    for (;;)
    {
      this.mVU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          int i = 0;
          AppMethodBeat.i(21636);
          if (b.bEa().bEe().mUr)
          {
            paramAnonymousView = BackupPcChooseUI.a(BackupPcChooseUI.this);
            if (paramAnonymousView.mVP.size() != paramAnonymousView.getCount()) {
              break label75;
            }
            paramAnonymousView.mVP.clear();
          }
          for (a.mYa = false;; a.mYa = true)
          {
            paramAnonymousView.notifyDataSetChanged();
            paramAnonymousView.mXZ.a(paramAnonymousView.mVP);
            AppMethodBeat.o(21636);
            return;
            label75:
            while (i < paramAnonymousView.getCount())
            {
              paramAnonymousView.mVP.add(Integer.valueOf(i));
              i += 1;
            }
          }
        }
      });
      if (b.bEa().bEe().mUr) {
        break;
      }
      this.mVU.setTextColor(getResources().getColor(2131099992));
      this.mVU.setClickable(false);
      this.mVX.setVisibility(0);
      AppMethodBeat.o(21642);
      return;
      this.mVW.setVisibility(0);
      iu(true);
      this.mVW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21635);
          paramAnonymousView = new Intent(BackupPcChooseUI.this, BackupSelectExtUI.class);
          paramAnonymousView.putExtra("BACKUP_MODE", 1);
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MODE", BackupPcChooseUI.mWh);
          paramAnonymousView.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", b.bEa().bEc().mXR);
          paramAnonymousView.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupPcChooseUI.aUt);
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupPcChooseUI.startTime);
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupPcChooseUI.GQ());
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", b.bEa().bEe().mUn);
          BackupPcChooseUI.this.startActivityForResult(paramAnonymousView, 0);
          AppMethodBeat.o(21635);
        }
      });
    }
    if (b.bEa().bEe().bDu().size() == 0) {
      switch (mWh)
      {
      }
    }
    for (;;)
    {
      this.mVV.setVisibility(0);
      this.mVX.setVisibility(4);
      AppMethodBeat.o(21642);
      return;
      this.mVV.setText(2131756183);
      continue;
      this.mVV.setText(2131756255);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(21646);
    if (paramInt2 != -1)
    {
      ac.e("MicroMsg.BackupPcChooseUI", "onActivityResult result error! resultCode[%d]", new Object[] { Integer.valueOf(paramInt2) });
      AppMethodBeat.o(21646);
      return;
    }
    paramInt1 = mWh;
    long l1 = startTime;
    long l2 = endTime;
    mWh = paramIntent.getIntExtra("BACKUP_SELECT_TIME_MODE", mWh);
    startTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0L);
    endTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0L);
    aUt = paramIntent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", aUt);
    ac.i("MicroMsg.BackupPcChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", new Object[] { Integer.valueOf(mWh), Integer.valueOf(paramInt1), Long.valueOf(startTime), Long.valueOf(l1), Long.valueOf(endTime), Long.valueOf(l2), Integer.valueOf(aUt) });
    b.bEa().bEc();
    e.f(mWh, startTime, endTime, aUt);
    iu(false);
    if ((paramInt1 == mWh) && ((mWh == 0) || ((mWh == 1) && (startTime == l1) && (endTime == l2))))
    {
      AppMethodBeat.o(21646);
      return;
    }
    b.bEa().bEe().a(mWh, startTime, endTime, b.bEa().bEe().bDt());
    paramIntent = this.mYc;
    paramIntent.mVP.clear();
    paramIntent.mXZ.a(paramIntent.mVP);
    if ((b.bEa().bEe().bDu() == null) || (b.bEa().bEe().bDu().size() == 0)) {
      switch (mWh)
      {
      default: 
        this.mVV.setVisibility(0);
      }
    }
    for (;;)
    {
      this.mYc.notifyDataSetChanged();
      AppMethodBeat.o(21646);
      return;
      this.mVV.setText(2131756183);
      break;
      this.mVV.setText(2131756255);
      break;
      this.mVV.setVisibility(4);
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
    b.bEa().bEe().mXn = this.mYe;
    AppMethodBeat.o(21640);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(21641);
    super.onStop();
    b.bEa().bEe().mXn = null;
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