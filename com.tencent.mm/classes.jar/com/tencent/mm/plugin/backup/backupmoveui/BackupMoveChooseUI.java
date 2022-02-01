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
public class BackupMoveChooseUI
  extends MMWizardActivity
{
  private static int aTB = 0;
  private static long endTime;
  private static int muf = 0;
  private static long startTime;
  private a mtQ;
  private ListView mtR;
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
  private b.b muh;
  
  public BackupMoveChooseUI()
  {
    AppMethodBeat.i(21387);
    this.mtQ = new a(this);
    this.mug = new SimpleDateFormat("yyyy.MM.dd");
    this.muh = new b.b()
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
          switch (BackupMoveChooseUI.muf)
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
  
  private void bwV()
  {
    AppMethodBeat.i(21394);
    if ((this.mtY.getVisibility() == 8) && (this.mtZ.getVisibility() == 8) && (this.mua.getVisibility() == 8))
    {
      this.mtW.setVisibility(8);
      this.mtX.setVisibility(8);
      AppMethodBeat.o(21394);
      return;
    }
    this.mtW.setVisibility(0);
    this.mtX.setVisibility(0);
    AppMethodBeat.o(21394);
  }
  
  private void hU(boolean paramBoolean)
  {
    AppMethodBeat.i(21392);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.backup.d.b.bwC();
      SharedPreferences localSharedPreferences = com.tencent.mm.plugin.backup.d.b.bvY();
      muf = localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
      aTB = localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
      startTime = localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
      endTime = localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
    }
    switch (muf)
    {
    default: 
      switch (aTB)
      {
      }
      break;
    }
    for (;;)
    {
      bwV();
      AppMethodBeat.o(21392);
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
      this.mud.setText(getContext().getResources().getString(2131756164));
    }
  }
  
  public final void b(HashSet<Integer> paramHashSet)
  {
    AppMethodBeat.i(21393);
    Object localObject = com.tencent.mm.plugin.backup.d.b.bwC().bwG().bwy();
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
        l = ((f.b)((LinkedList)localObject).get(i)).mqA + l;
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
      this.mue.setEnabled(true);
      if (paramHashSet.size() == this.mtQ.getCount())
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
      AppMethodBeat.o(21393);
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
    AppMethodBeat.i(21391);
    setMMTitle(2131756266);
    this.mtR = ((ListView)findViewById(2131297038));
    this.mtR.setAdapter(this.mtQ);
    this.mtR.setEmptyView(findViewById(2131297040));
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
    this.mue = ((Button)findViewById(2131297043));
    this.mue.setOnClickListener(new View.OnClickListener()
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
        if (locala.mtN.size() <= 0)
        {
          localObject1 = g.B(paramAnonymousView);
          localObject2 = com.tencent.mm.plugin.backup.d.b.bwC().bwG();
          if (paramAnonymousView.size() != 0) {
            break label690;
          }
          ((com.tencent.mm.plugin.backup.d.a)localObject2).msp = new LinkedList();
          localObject2 = com.tencent.mm.plugin.backup.d.b.bwC().bwE();
          ((d)localObject2).mtj = ((LinkedList)localObject1);
          com.tencent.mm.plugin.backup.d.b.bwC();
          if (com.tencent.mm.plugin.backup.d.b.bvY().getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0) != 1) {
            break label743;
          }
          d.mtq = true;
          com.tencent.mm.plugin.backup.d.b.bwC();
          ((d)localObject2).mtm = com.tencent.mm.plugin.backup.d.b.bvY().getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
          com.tencent.mm.plugin.backup.d.b.bwC();
          ((d)localObject2).mtn = com.tencent.mm.plugin.backup.d.b.bvY().getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
          com.tencent.mm.plugin.backup.d.b.bwC();
          if (com.tencent.mm.plugin.backup.d.b.bvY().getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0) != 1) {
            break label750;
          }
          d.mrR = true;
          label186:
          ad.i("MicroMsg.BackupMoveServer", "setBakupChooseData users size[%d], selectStartTime[%d], selectEndTime[%d], isQuickBackup[%b]", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), Long.valueOf(((d)localObject2).mtm), Long.valueOf(((d)localObject2).mtn), Boolean.valueOf(d.mrR) });
          az.arV();
          c.afk().set(ae.a.FmY, Boolean.TRUE);
          localObject1 = com.tencent.mm.plugin.backup.d.b.bwC().bwG();
          if (((com.tencent.mm.plugin.backup.d.a)localObject1).msk != null) {
            ((com.tencent.mm.plugin.backup.d.a)localObject1).msk.cancel();
          }
          com.tencent.mm.sdk.g.b.c(new a.2((com.tencent.mm.plugin.backup.d.a)localObject1), "BackupMoveChooseServer.calculateChooseConvSize");
          i = 0;
          if ((BackupMoveChooseUI.muf != 1) || (BackupMoveChooseUI.aTB != 1)) {
            break label757;
          }
          h.vKh.idkeyStat(485L, 26L, 1L, false);
          h.vKh.idkeyStat(485L, 27L, 1L, false);
          h.vKh.f(11788, new Object[] { Integer.valueOf(7) });
          h.vKh.f(11788, new Object[] { Integer.valueOf(14), Long.valueOf(System.currentTimeMillis()), Long.valueOf(BackupMoveChooseUI.Hf()), Long.valueOf(BackupMoveChooseUI.endTime) });
          i = 0;
          label408:
          localObject1 = h.vKh;
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
          h.vKh.f(11788, new Object[] { Integer.valueOf(8) });
          paramAnonymousView = new Intent(BackupMoveChooseUI.this, BackupMoveQRCodeUI.class);
          MMWizardActivity.V(BackupMoveChooseUI.this, paramAnonymousView);
          h.vKh.idkeyStat(485L, 23L, 1L, false);
          AppMethodBeat.o(21383);
          return;
          ((PLong)localObject1).value = 0L;
          ((PInt)localObject2).value = 0;
          LinkedList localLinkedList = com.tencent.mm.plugin.backup.d.b.bwC().bwG().bwy();
          if (localLinkedList != null)
          {
            i = 0;
            while (i < locala.getCount())
            {
              if (locala.mtN.contains(Integer.valueOf(i)))
              {
                paramAnonymousView.add(localLinkedList.get(i));
                ((PLong)localObject1).value += ((f.b)localLinkedList.get(i)).mqA;
                ((PInt)localObject2).value = ((int)(((PInt)localObject2).value + ((f.b)localLinkedList.get(i)).mqB));
              }
              i += 1;
            }
          }
          ad.i("MicroMsg.BackupMoveChooseAdapter", "finishSelected usernameSize:%d, convSize:%d, convMsgCount:%d", new Object[] { Integer.valueOf(paramAnonymousView.size()), Long.valueOf(((PLong)localObject1).value), Integer.valueOf(((PInt)localObject2).value) });
          break;
          ((com.tencent.mm.plugin.backup.d.a)localObject2).msp = new LinkedList(paramAnonymousView.subList(paramAnonymousView.size() * 3 / 4, paramAnonymousView.size()));
          ((com.tencent.mm.plugin.backup.d.a)localObject2).msp.addAll(paramAnonymousView.subList(0, paramAnonymousView.size() * 3 / 4));
          break label85;
          label743:
          d.mtq = false;
          break label123;
          label750:
          d.mrR = false;
          break label186;
          label757:
          if (BackupMoveChooseUI.muf == 1)
          {
            h.vKh.idkeyStat(485L, 26L, 1L, false);
            h.vKh.f(11788, new Object[] { Integer.valueOf(5) });
            h.vKh.f(11788, new Object[] { Integer.valueOf(14), Long.valueOf(System.currentTimeMillis()), Long.valueOf(BackupMoveChooseUI.Hf()), Long.valueOf(BackupMoveChooseUI.endTime) });
            i = 0;
            break label408;
          }
          if (BackupMoveChooseUI.aTB == 1)
          {
            h.vKh.idkeyStat(485L, 27L, 1L, false);
            h.vKh.f(11788, new Object[] { Integer.valueOf(6) });
            i = 0;
            break label408;
          }
          localObject1 = BackupMoveChooseUI.a(BackupMoveChooseUI.this);
          if (((a)localObject1).mtN.size() == ((a)localObject1).getCount()) {}
          for (j = 1;; j = 0)
          {
            if (j != 0)
            {
              i = 1;
              h.vKh.idkeyStat(485L, 22L, 1L, false);
              h.vKh.f(11788, new Object[] { Integer.valueOf(4) });
            }
            break;
          }
        }
      }
    });
    this.mue.setEnabled(false);
    hU(true);
    this.mtU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21384);
        paramAnonymousView = new Intent(BackupMoveChooseUI.this, BackupSelectExtUI.class);
        paramAnonymousView.putExtra("BACKUP_MODE", 2);
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MODE", BackupMoveChooseUI.muf);
        paramAnonymousView.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", true);
        paramAnonymousView.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupMoveChooseUI.aTB);
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupMoveChooseUI.Hf());
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupMoveChooseUI.endTime);
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", com.tencent.mm.plugin.backup.d.b.bwC().bwG().msm);
        BackupMoveChooseUI.this.startActivityForResult(paramAnonymousView, 0);
        AppMethodBeat.o(21384);
      }
    });
    this.mtS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21385);
        if (com.tencent.mm.plugin.backup.d.b.bwC().bwG().msq)
        {
          paramAnonymousView = BackupMoveChooseUI.a(BackupMoveChooseUI.this);
          if (paramAnonymousView.mtN.size() != paramAnonymousView.getCount()) {
            break label69;
          }
          paramAnonymousView.mtN.clear();
        }
        for (;;)
        {
          paramAnonymousView.notifyDataSetChanged();
          paramAnonymousView.mtM.b(paramAnonymousView.mtN);
          AppMethodBeat.o(21385);
          return;
          label69:
          int i = 0;
          while (i < paramAnonymousView.getCount())
          {
            paramAnonymousView.mtN.add(Integer.valueOf(i));
            i += 1;
          }
        }
      }
    });
    if (com.tencent.mm.plugin.backup.d.b.bwC().bwG().msq)
    {
      if ((com.tencent.mm.plugin.backup.d.b.bwC().bwG().bwy() == null) || (com.tencent.mm.plugin.backup.d.b.bwC().bwG().bwy().size() == 0)) {
        switch (muf)
        {
        }
      }
      for (;;)
      {
        this.mtT.setVisibility(0);
        this.mtV.setVisibility(4);
        AppMethodBeat.o(21391);
        return;
        this.mtT.setText(2131756101);
        continue;
        this.mtT.setText(2131756255);
      }
    }
    if (!com.tencent.mm.plugin.backup.d.b.bwC().bwG().msq)
    {
      this.mtS.setTextColor(getResources().getColor(2131099992));
      this.mtS.setClickable(false);
      this.mtV.setVisibility(0);
      AppMethodBeat.o(21391);
      return;
    }
    this.mtV.setVisibility(4);
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
    paramInt1 = muf;
    long l1 = startTime;
    long l2 = endTime;
    muf = paramIntent.getIntExtra("BACKUP_SELECT_TIME_MODE", muf);
    startTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0L);
    endTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0L);
    aTB = paramIntent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", aTB);
    ad.i("MicroMsg.BackupMoveChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", new Object[] { Integer.valueOf(muf), Integer.valueOf(paramInt1), Long.valueOf(startTime), Long.valueOf(l1), Long.valueOf(endTime), Long.valueOf(l2), Integer.valueOf(aTB) });
    com.tencent.mm.plugin.backup.d.b.bwC().bwE();
    d.e(muf, startTime, endTime, aTB);
    hU(false);
    if ((paramInt1 == muf) && ((muf == 0) || ((muf == 1) && (startTime == l1) && (endTime == l2))))
    {
      AppMethodBeat.o(21395);
      return;
    }
    com.tencent.mm.plugin.backup.d.b.bwC().bwG().a(muf, startTime, endTime, com.tencent.mm.plugin.backup.d.b.bwC().bwG().bwx());
    paramIntent = this.mtQ;
    paramIntent.mtN.clear();
    paramIntent.mtM.b(paramIntent.mtN);
    if ((com.tencent.mm.plugin.backup.d.b.bwC().bwG().bwy() == null) || (com.tencent.mm.plugin.backup.d.b.bwC().bwG().bwy().size() == 0)) {
      switch (muf)
      {
      default: 
        this.mtT.setVisibility(0);
      }
    }
    for (;;)
    {
      this.mtQ.notifyDataSetChanged();
      AppMethodBeat.o(21395);
      return;
      this.mtT.setText(2131756101);
      break;
      this.mtT.setText(2131756255);
      break;
      this.mtT.setVisibility(4);
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
    com.tencent.mm.plugin.backup.d.b.bwC().bwG().msl = this.muh;
    AppMethodBeat.o(21389);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(21390);
    super.onStop();
    com.tencent.mm.plugin.backup.d.b.bwC().bwG().msl = null;
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