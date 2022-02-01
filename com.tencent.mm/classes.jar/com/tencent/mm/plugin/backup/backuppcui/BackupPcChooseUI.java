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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
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
  private static int aTB = 0;
  private static long endTime;
  private static int muf = 0;
  private static long startTime;
  private TextView mtS;
  private TextView mtT;
  private TextView mtU;
  private ProgressBar mtV;
  private View mtW;
  private LinearLayout mtX;
  private LinearLayout mtY;
  private LinearLayout mtZ;
  private LinearLayout mua;
  private TextView mub;
  private TextView muc;
  private TextView mud;
  private Button mue;
  private SimpleDateFormat mug;
  private a mwb;
  private ListView mwc;
  private b.a mwd;
  
  public BackupPcChooseUI()
  {
    AppMethodBeat.i(21638);
    this.mwb = new a(this);
    this.mug = new SimpleDateFormat("yyyy.MM.dd");
    this.mwd = new b.a()
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
          switch (BackupPcChooseUI.muf)
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
  
  private void bwV()
  {
    AppMethodBeat.i(21645);
    if ((this.mtY.getVisibility() == 8) && (this.mtZ.getVisibility() == 8) && (this.mua.getVisibility() == 8))
    {
      this.mtW.setVisibility(8);
      this.mtX.setVisibility(8);
      AppMethodBeat.o(21645);
      return;
    }
    this.mtW.setVisibility(0);
    this.mtX.setVisibility(0);
    AppMethodBeat.o(21645);
  }
  
  private void hU(boolean paramBoolean)
  {
    AppMethodBeat.i(21643);
    if (paramBoolean)
    {
      b.bxe();
      SharedPreferences localSharedPreferences = b.bvY();
      muf = localSharedPreferences.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
      aTB = localSharedPreferences.getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
      startTime = localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
      endTime = localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
    }
    if (b.bxe().bxg().mvP) {}
    switch (muf)
    {
    default: 
      if (b.bxe().bxg().mvQ) {
        switch (aTB)
        {
        }
      }
      break;
    }
    for (;;)
    {
      bwV();
      AppMethodBeat.o(21643);
      return;
      this.mtZ.setVisibility(8);
      break;
      this.mtW.setVisibility(0);
      this.mtX.setVisibility(0);
      this.mtZ.setVisibility(0);
      this.muc.setText(this.mug.format(new Date(startTime)) + "~" + this.mug.format(new Date(endTime - 86400000L)));
      break;
      this.mua.setVisibility(8);
      continue;
      this.mtW.setVisibility(0);
      this.mtX.setVisibility(0);
      this.mua.setVisibility(0);
      this.mud.setText(getContext().getResources().getString(2131756236));
    }
  }
  
  public final void b(HashSet<Integer> paramHashSet)
  {
    AppMethodBeat.i(21644);
    Object localObject = new HashSet();
    int i = b.bxe().bxi().bwy().size();
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
      this.mue.setEnabled(true);
      if ((b.bxe().bxi().msq) && (paramHashSet.size() == this.mwb.getCount()))
      {
        this.mtS.setText(2131756092);
        this.mtW.setVisibility(0);
        this.mtX.setVisibility(0);
        this.mtY.setVisibility(0);
        this.mub.setText(getString(2131756094, new Object[] { Integer.valueOf(paramHashSet.size()) }));
      }
    }
    for (;;)
    {
      bwV();
      AppMethodBeat.o(21644);
      return;
      this.mtS.setText(2131756091);
      break;
      this.mue.setEnabled(false);
      this.mtS.setText(2131756091);
      this.mtY.setVisibility(8);
      this.mub.setText("");
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
    this.mwc = ((ListView)findViewById(2131297038));
    this.mwc.setAdapter(this.mwb);
    this.mwc.setEmptyView(findViewById(2131297040));
    this.mtS = ((TextView)findViewById(2131297046));
    this.mtT = ((TextView)findViewById(2131297039));
    this.mtV = ((ProgressBar)findViewById(2131297045));
    this.mtU = ((TextView)findViewById(2131297041));
    this.mtW = findViewById(2131297044);
    this.mtX = ((LinearLayout)findViewById(2131297042));
    this.mtY = ((LinearLayout)findViewById(2131297047));
    this.mtZ = ((LinearLayout)findViewById(2131297050));
    this.mua = ((LinearLayout)findViewById(2131297035));
    this.mub = ((TextView)findViewById(2131297049));
    this.muc = ((TextView)findViewById(2131297052));
    this.mud = ((TextView)findViewById(2131297037));
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
    this.mue = ((Button)findViewById(2131297043));
    this.mue.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(21634);
        Object localObject = BackupPcChooseUI.a(BackupPcChooseUI.this);
        paramAnonymousView = new LinkedList();
        if (((a)localObject).mtN.size() <= 0) {}
        for (;;)
        {
          localObject = g.B(paramAnonymousView);
          az.arV();
          boolean bool = ((Boolean)com.tencent.mm.model.c.afk().get(ae.a.Fnb, Boolean.FALSE)).booleanValue();
          ad.i("MicroMsg.BackupPcChooseUI", "initView OnMenuItemClickListener startbackup choose records finish, selectedConversation size[%d], hasMove[%b], timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[] { Integer.valueOf(paramAnonymousView.size()), Boolean.valueOf(bool), Integer.valueOf(BackupPcChooseUI.muf), Long.valueOf(BackupPcChooseUI.startTime), Long.valueOf(BackupPcChooseUI.Hf()), Integer.valueOf(BackupPcChooseUI.aTB) });
          if (!bool) {
            break;
          }
          com.tencent.mm.ui.base.h.a(BackupPcChooseUI.this, 2131756216, 0, 2131756270, 0, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21633);
              b.bxe().bxi().G(paramAnonymousView);
              b.bxe().bxf().wc(2);
              b.bxe().bvT().mqj = 12;
              b.bxe().bxg().H(this.mwg);
              b.bxe().bxg().nq(paramAnonymousView.size());
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(400L, 8L, 1L, false);
              com.tencent.mm.plugin.report.service.h.vKh.f(13735, new Object[] { Integer.valueOf(10), Integer.valueOf(b.bxe().bxf().mvA) });
              if ((BackupPcChooseUI.muf == 1) && (BackupPcChooseUI.aTB == 1))
              {
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(400L, 32L, 1L, false);
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(400L, 35L, 1L, false);
                com.tencent.mm.plugin.report.service.h.vKh.f(13735, new Object[] { Integer.valueOf(13), Integer.valueOf(b.bxe().bxf().mvA) });
              }
              for (;;)
              {
                BackupPcChooseUI.this.finish();
                AppMethodBeat.o(21633);
                return;
                if (BackupPcChooseUI.muf == 1)
                {
                  com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(400L, 32L, 1L, false);
                  com.tencent.mm.plugin.report.service.h.vKh.f(13735, new Object[] { Integer.valueOf(11), Integer.valueOf(b.bxe().bxf().mvA) });
                }
                else if (BackupPcChooseUI.aTB == 1)
                {
                  com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(400L, 35L, 1L, false);
                  com.tencent.mm.plugin.report.service.h.vKh.f(13735, new Object[] { Integer.valueOf(12), Integer.valueOf(b.bxe().bxf().mvA) });
                }
              }
            }
          }, null, 2131099990);
          AppMethodBeat.o(21634);
          return;
          LinkedList localLinkedList = b.bxe().bxi().bwy();
          if (localLinkedList != null)
          {
            int i = 0;
            while (i < ((a)localObject).getCount())
            {
              if (((a)localObject).mtN.contains(Integer.valueOf(i))) {
                paramAnonymousView.add(localLinkedList.get(i));
              }
              i += 1;
            }
          }
          ad.i("MicroMsg.BackupPcChooseAdapter", "finishSelected usernameSize:%d", new Object[] { Integer.valueOf(paramAnonymousView.size()) });
        }
        b.bxe().bxi().G(paramAnonymousView);
        b.bxe().bxf().wc(2);
        b.bxe().bvT().mqj = 12;
        b.bxe().bxg().H((LinkedList)localObject);
        b.bxe().bxg().nq(paramAnonymousView.size());
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(400L, 8L, 1L, false);
        com.tencent.mm.plugin.report.service.h.vKh.f(13735, new Object[] { Integer.valueOf(10), Integer.valueOf(b.bxe().bxf().mvA) });
        if ((BackupPcChooseUI.muf == 1) && (BackupPcChooseUI.aTB == 1))
        {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(400L, 32L, 1L, false);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(400L, 35L, 1L, false);
          com.tencent.mm.plugin.report.service.h.vKh.f(13735, new Object[] { Integer.valueOf(13), Integer.valueOf(b.bxe().bxf().mvA) });
        }
        for (;;)
        {
          BackupPcChooseUI.this.finish();
          AppMethodBeat.o(21634);
          return;
          if (BackupPcChooseUI.muf == 1)
          {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(400L, 32L, 1L, false);
            com.tencent.mm.plugin.report.service.h.vKh.f(13735, new Object[] { Integer.valueOf(11), Integer.valueOf(b.bxe().bxf().mvA) });
          }
          else if (BackupPcChooseUI.aTB == 1)
          {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(400L, 35L, 1L, false);
            com.tencent.mm.plugin.report.service.h.vKh.f(13735, new Object[] { Integer.valueOf(12), Integer.valueOf(b.bxe().bxf().mvA) });
          }
        }
      }
    });
    this.mue.setEnabled(false);
    if ((!b.bxe().bxg().mvP) && (!b.bxe().bxg().mvQ)) {
      this.mtU.setVisibility(8);
    }
    for (;;)
    {
      this.mtS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          int i = 0;
          AppMethodBeat.i(21636);
          if (b.bxe().bxi().msq)
          {
            paramAnonymousView = BackupPcChooseUI.a(BackupPcChooseUI.this);
            if (paramAnonymousView.mtN.size() != paramAnonymousView.getCount()) {
              break label75;
            }
            paramAnonymousView.mtN.clear();
          }
          for (a.mvZ = false;; a.mvZ = true)
          {
            paramAnonymousView.notifyDataSetChanged();
            paramAnonymousView.mvY.b(paramAnonymousView.mtN);
            AppMethodBeat.o(21636);
            return;
            label75:
            while (i < paramAnonymousView.getCount())
            {
              paramAnonymousView.mtN.add(Integer.valueOf(i));
              i += 1;
            }
          }
        }
      });
      if (b.bxe().bxi().msq) {
        break;
      }
      this.mtS.setTextColor(getResources().getColor(2131099992));
      this.mtS.setClickable(false);
      this.mtV.setVisibility(0);
      AppMethodBeat.o(21642);
      return;
      this.mtU.setVisibility(0);
      hU(true);
      this.mtU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21635);
          paramAnonymousView = new Intent(BackupPcChooseUI.this, BackupSelectExtUI.class);
          paramAnonymousView.putExtra("BACKUP_MODE", 1);
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MODE", BackupPcChooseUI.muf);
          paramAnonymousView.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", b.bxe().bxg().mvQ);
          paramAnonymousView.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupPcChooseUI.aTB);
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupPcChooseUI.startTime);
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupPcChooseUI.Hf());
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", b.bxe().bxi().msm);
          BackupPcChooseUI.this.startActivityForResult(paramAnonymousView, 0);
          AppMethodBeat.o(21635);
        }
      });
    }
    if (b.bxe().bxi().bwy().size() == 0) {
      switch (muf)
      {
      }
    }
    for (;;)
    {
      this.mtT.setVisibility(0);
      this.mtV.setVisibility(4);
      AppMethodBeat.o(21642);
      return;
      this.mtT.setText(2131756183);
      continue;
      this.mtT.setText(2131756255);
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
    paramInt1 = muf;
    long l1 = startTime;
    long l2 = endTime;
    muf = paramIntent.getIntExtra("BACKUP_SELECT_TIME_MODE", muf);
    startTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0L);
    endTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0L);
    aTB = paramIntent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", aTB);
    ad.i("MicroMsg.BackupPcChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", new Object[] { Integer.valueOf(muf), Integer.valueOf(paramInt1), Long.valueOf(startTime), Long.valueOf(l1), Long.valueOf(endTime), Long.valueOf(l2), Integer.valueOf(aTB) });
    b.bxe().bxg();
    e.f(muf, startTime, endTime, aTB);
    hU(false);
    if ((paramInt1 == muf) && ((muf == 0) || ((muf == 1) && (startTime == l1) && (endTime == l2))))
    {
      AppMethodBeat.o(21646);
      return;
    }
    b.bxe().bxi().a(muf, startTime, endTime, b.bxe().bxi().bwx());
    paramIntent = this.mwb;
    paramIntent.mtN.clear();
    paramIntent.mvY.b(paramIntent.mtN);
    if ((b.bxe().bxi().bwy() == null) || (b.bxe().bxi().bwy().size() == 0)) {
      switch (muf)
      {
      default: 
        this.mtT.setVisibility(0);
      }
    }
    for (;;)
    {
      this.mwb.notifyDataSetChanged();
      AppMethodBeat.o(21646);
      return;
      this.mtT.setText(2131756183);
      break;
      this.mtT.setText(2131756255);
      break;
      this.mtT.setVisibility(4);
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
    b.bxe().bxi().mvm = this.mwd;
    AppMethodBeat.o(21640);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(21641);
    super.onStop();
    b.bxe().bxi().mvm = null;
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