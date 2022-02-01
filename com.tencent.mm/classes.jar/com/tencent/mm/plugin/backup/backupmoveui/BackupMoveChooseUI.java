package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
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
  private static int cIh = 0;
  private static long endTime;
  private static long startTime;
  private static int vai = 0;
  private a uZT;
  private ListView uZU;
  private TextView uZV;
  private TextView uZW;
  private TextView uZX;
  private ProgressBar uZY;
  private View uZZ;
  private LinearLayout vaa;
  private LinearLayout vab;
  private LinearLayout vac;
  private LinearLayout vad;
  private TextView vae;
  private TextView vaf;
  private TextView vag;
  private Button vah;
  private SimpleDateFormat vaj;
  private b.b vak;
  
  public BackupMoveChooseUI()
  {
    AppMethodBeat.i(21387);
    this.uZT = new a(this);
    this.vaj = new SimpleDateFormat("yyyy.MM.dd");
    this.vak = new b.b()
    {
      public final void G(LinkedList<f.b> paramAnonymousLinkedList)
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
          switch (BackupMoveChooseUI.vai)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(21386);
            return;
            BackupMoveChooseUI.c(BackupMoveChooseUI.this).setText(R.l.gsu);
            AppMethodBeat.o(21386);
            return;
            BackupMoveChooseUI.c(BackupMoveChooseUI.this).setText(R.l.guT);
          }
        }
        BackupMoveChooseUI.d(BackupMoveChooseUI.this).setClickable(true);
        BackupMoveChooseUI.d(BackupMoveChooseUI.this).setTextColor(BackupMoveChooseUI.this.getResources().getColor(R.e.fkf));
        BackupMoveChooseUI.b(BackupMoveChooseUI.this).setVisibility(8);
        BackupMoveChooseUI.a(BackupMoveChooseUI.this).notifyDataSetChanged();
        AppMethodBeat.o(21386);
      }
      
      public final void H(LinkedList<f.b> paramAnonymousLinkedList) {}
      
      public final void a(LinkedList<f.b> paramAnonymousLinkedList, f.b paramAnonymousb, int paramAnonymousInt) {}
    };
    AppMethodBeat.o(21387);
  }
  
  private void cVN()
  {
    AppMethodBeat.i(21394);
    if ((this.vab.getVisibility() == 8) && (this.vac.getVisibility() == 8) && (this.vad.getVisibility() == 8))
    {
      this.uZZ.setVisibility(8);
      this.vaa.setVisibility(8);
      AppMethodBeat.o(21394);
      return;
    }
    this.uZZ.setVisibility(0);
    this.vaa.setVisibility(0);
    AppMethodBeat.o(21394);
  }
  
  private void ma(boolean paramBoolean)
  {
    AppMethodBeat.i(21392);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.backup.d.b.cVs();
      SharedPreferences localSharedPreferences = com.tencent.mm.plugin.backup.d.b.cUO();
      vai = localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
      cIh = localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
      startTime = localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
      endTime = localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
    }
    switch (vai)
    {
    default: 
      switch (cIh)
      {
      }
      break;
    }
    for (;;)
    {
      cVN();
      AppMethodBeat.o(21392);
      return;
      this.vac.setVisibility(8);
      break;
      this.uZZ.setVisibility(0);
      this.vaa.setVisibility(0);
      this.vac.setVisibility(0);
      this.vaf.setText(this.vaj.format(new Date(startTime)) + "~" + this.vaj.format(new Date(endTime - 86400000L)));
      break;
      this.vad.setVisibility(8);
      continue;
      this.uZZ.setVisibility(0);
      this.vaa.setVisibility(0);
      this.vad.setVisibility(0);
      this.vag.setText(getContext().getResources().getString(R.l.gtB));
    }
  }
  
  public final void a(HashSet<Integer> paramHashSet)
  {
    AppMethodBeat.i(21393);
    Object localObject = com.tencent.mm.plugin.backup.d.b.cVs().cVw().cVo();
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
        l = ((f.b)((LinkedList)localObject).get(i)).uWx + l;
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
      this.vah.setEnabled(true);
      if (paramHashSet.size() == this.uZT.getCount())
      {
        this.uZV.setText(R.l.gso);
        this.uZZ.setVisibility(0);
        this.vaa.setVisibility(0);
        this.vab.setVisibility(0);
        this.vae.setText(getString(R.l.fsP, new Object[] { Integer.valueOf(paramHashSet.size()) }));
      }
    }
    for (;;)
    {
      cVN();
      AppMethodBeat.o(21393);
      return;
      this.uZV.setText(R.l.gsn);
      break;
      this.vah.setEnabled(false);
      this.uZV.setText(R.l.gsn);
      this.vab.setVisibility(8);
      this.vae.setText("");
    }
  }
  
  public int getLayoutId()
  {
    return R.i.gew;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21391);
    setMMTitle(R.l.guW);
    this.uZU = ((ListView)findViewById(R.h.fsG));
    this.uZU.setAdapter(this.uZT);
    this.uZU.setEmptyView(findViewById(R.h.fsI));
    this.uZV = ((TextView)findViewById(R.h.fsO));
    this.uZW = ((TextView)findViewById(R.h.fsH));
    this.uZY = ((ProgressBar)findViewById(R.h.fsN));
    this.uZX = ((TextView)findViewById(R.h.fsJ));
    this.uZZ = findViewById(R.h.fsM);
    this.vaa = ((LinearLayout)findViewById(R.h.fsK));
    this.vab = ((LinearLayout)findViewById(R.h.fsP));
    this.vac = ((LinearLayout)findViewById(R.h.fsS));
    this.vad = ((LinearLayout)findViewById(R.h.fsD));
    this.vae = ((TextView)findViewById(R.h.fsR));
    this.vaf = ((TextView)findViewById(R.h.fsU));
    this.vag = ((TextView)findViewById(R.h.fsF));
    ((TextView)findViewById(R.h.fsQ)).setText(R.l.gsv);
    ((TextView)findViewById(R.h.fsT)).setText(R.l.gsw);
    ((TextView)findViewById(R.h.fsE)).setText(R.l.gst);
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
    this.vah = ((Button)findViewById(R.h.fsL));
    this.vah.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21383);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        localObject1 = new PLong();
        Object localObject2 = new PInt();
        a locala = BackupMoveChooseUI.a(BackupMoveChooseUI.this);
        paramAnonymousView = new LinkedList();
        label117:
        int j;
        if (locala.uZQ.size() <= 0)
        {
          localObject1 = g.F(paramAnonymousView);
          localObject2 = com.tencent.mm.plugin.backup.d.b.cVs().cVw();
          if (paramAnonymousView.size() != 0) {
            break label576;
          }
          ((com.tencent.mm.plugin.backup.d.a)localObject2).uYl = new LinkedList();
          com.tencent.mm.plugin.backup.d.b.cVs().cVu().K((LinkedList)localObject1);
          localObject1 = com.tencent.mm.plugin.backup.d.b.cVs().cVw();
          if (((com.tencent.mm.plugin.backup.d.a)localObject1).uYg != null) {
            ((com.tencent.mm.plugin.backup.d.a)localObject1).uYg.cancel();
          }
          ThreadPool.post(new a.2((com.tencent.mm.plugin.backup.d.a)localObject1), "BackupMoveChooseServer.calculateChooseConvSize");
          i = 0;
          if ((BackupMoveChooseUI.vai != 1) || (BackupMoveChooseUI.cIh != 1)) {
            break label629;
          }
          h.OAn.idkeyStat(485L, 26L, 1L, false);
          h.OAn.idkeyStat(485L, 27L, 1L, false);
          h.OAn.b(11788, new Object[] { Integer.valueOf(7) });
          h.OAn.b(11788, new Object[] { Integer.valueOf(14), Long.valueOf(System.currentTimeMillis()), Long.valueOf(BackupMoveChooseUI.startTime), Long.valueOf(BackupMoveChooseUI.endTime) });
          i = 0;
          label281:
          localObject1 = h.OAn;
          j = paramAnonymousView.size();
          if (i == 0) {
            break label845;
          }
        }
        label576:
        label845:
        for (int i = 1;; i = 0)
        {
          ((h)localObject1).b(11788, new Object[] { Integer.valueOf(13), Integer.valueOf(j), Integer.valueOf(i) });
          h.OAn.b(11788, new Object[] { Integer.valueOf(8) });
          paramAnonymousView = new Intent(BackupMoveChooseUI.this, BackupMoveQRCodeUI.class);
          MMWizardActivity.aQ(BackupMoveChooseUI.this, paramAnonymousView);
          h.OAn.idkeyStat(485L, 23L, 1L, false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(21383);
          return;
          ((PLong)localObject1).value = 0L;
          ((PInt)localObject2).value = 0;
          LinkedList localLinkedList = com.tencent.mm.plugin.backup.d.b.cVs().cVw().cVo();
          if (localLinkedList != null)
          {
            i = 0;
            while (i < locala.getCount())
            {
              if (locala.uZQ.contains(Integer.valueOf(i)))
              {
                paramAnonymousView.add((f.b)localLinkedList.get(i));
                ((PLong)localObject1).value += ((f.b)localLinkedList.get(i)).uWx;
                ((PInt)localObject2).value = ((int)(((PInt)localObject2).value + ((f.b)localLinkedList.get(i)).uWy));
              }
              i += 1;
            }
          }
          Log.i("MicroMsg.BackupMoveChooseAdapter", "finishSelected usernameSize:%d, convSize:%d, convMsgCount:%d", new Object[] { Integer.valueOf(paramAnonymousView.size()), Long.valueOf(((PLong)localObject1).value), Integer.valueOf(((PInt)localObject2).value) });
          break;
          ((com.tencent.mm.plugin.backup.d.a)localObject2).uYl = new LinkedList(paramAnonymousView.subList(paramAnonymousView.size() * 3 / 4, paramAnonymousView.size()));
          ((com.tencent.mm.plugin.backup.d.a)localObject2).uYl.addAll(paramAnonymousView.subList(0, paramAnonymousView.size() * 3 / 4));
          break label117;
          label629:
          if (BackupMoveChooseUI.vai == 1)
          {
            h.OAn.idkeyStat(485L, 26L, 1L, false);
            h.OAn.b(11788, new Object[] { Integer.valueOf(5) });
            h.OAn.b(11788, new Object[] { Integer.valueOf(14), Long.valueOf(System.currentTimeMillis()), Long.valueOf(BackupMoveChooseUI.startTime), Long.valueOf(BackupMoveChooseUI.endTime) });
            i = 0;
            break label281;
          }
          if (BackupMoveChooseUI.cIh == 1)
          {
            h.OAn.idkeyStat(485L, 27L, 1L, false);
            h.OAn.b(11788, new Object[] { Integer.valueOf(6) });
            i = 0;
            break label281;
          }
          localObject1 = BackupMoveChooseUI.a(BackupMoveChooseUI.this);
          if (((a)localObject1).uZQ.size() == ((a)localObject1).getCount()) {}
          for (j = 1;; j = 0)
          {
            if (j != 0)
            {
              i = 1;
              h.OAn.idkeyStat(485L, 22L, 1L, false);
              h.OAn.b(11788, new Object[] { Integer.valueOf(4) });
            }
            break;
          }
        }
      }
    });
    this.vah.setEnabled(false);
    ma(true);
    this.uZX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21384);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new Intent(BackupMoveChooseUI.this, BackupSelectExtUI.class);
        paramAnonymousView.putExtra("BACKUP_MODE", 2);
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MODE", BackupMoveChooseUI.vai);
        paramAnonymousView.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", true);
        paramAnonymousView.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupMoveChooseUI.cIh);
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupMoveChooseUI.startTime);
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupMoveChooseUI.endTime);
        paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", com.tencent.mm.plugin.backup.d.b.cVs().cVw().uYi);
        BackupMoveChooseUI.this.startActivityForResult(paramAnonymousView, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(21384);
      }
    });
    this.uZV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21385);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (com.tencent.mm.plugin.backup.d.b.cVs().cVw().uYm)
        {
          paramAnonymousView = BackupMoveChooseUI.a(BackupMoveChooseUI.this);
          if (paramAnonymousView.uZQ.size() != paramAnonymousView.getCount()) {
            break label110;
          }
          paramAnonymousView.uZQ.clear();
        }
        for (;;)
        {
          paramAnonymousView.notifyDataSetChanged();
          paramAnonymousView.uZP.a(paramAnonymousView.uZQ);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(21385);
          return;
          label110:
          int i = 0;
          while (i < paramAnonymousView.getCount())
          {
            paramAnonymousView.uZQ.add(Integer.valueOf(i));
            i += 1;
          }
        }
      }
    });
    if (com.tencent.mm.plugin.backup.d.b.cVs().cVw().uYm)
    {
      if ((com.tencent.mm.plugin.backup.d.b.cVs().cVw().cVo() == null) || (com.tencent.mm.plugin.backup.d.b.cVs().cVw().cVo().size() == 0)) {
        switch (vai)
        {
        }
      }
      for (;;)
      {
        this.uZW.setVisibility(0);
        this.uZY.setVisibility(4);
        AppMethodBeat.o(21391);
        return;
        this.uZW.setText(R.l.gsu);
        continue;
        this.uZW.setText(R.l.guT);
      }
    }
    if (!com.tencent.mm.plugin.backup.d.b.cVs().cVw().uYm)
    {
      this.uZV.setTextColor(getResources().getColor(R.e.fkh));
      this.uZV.setClickable(false);
      this.uZY.setVisibility(0);
      AppMethodBeat.o(21391);
      return;
    }
    this.uZY.setVisibility(4);
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
    paramInt1 = vai;
    long l1 = startTime;
    long l2 = endTime;
    vai = paramIntent.getIntExtra("BACKUP_SELECT_TIME_MODE", vai);
    startTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0L);
    endTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0L);
    cIh = paramIntent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", cIh);
    Log.i("MicroMsg.BackupMoveChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", new Object[] { Integer.valueOf(vai), Integer.valueOf(paramInt1), Long.valueOf(startTime), Long.valueOf(l1), Long.valueOf(endTime), Long.valueOf(l2), Integer.valueOf(cIh) });
    com.tencent.mm.plugin.backup.d.b.cVs().cVu();
    d.e(vai, startTime, endTime, cIh);
    ma(false);
    if ((paramInt1 == vai) && ((vai == 0) || ((vai == 1) && (startTime == l1) && (endTime == l2))))
    {
      AppMethodBeat.o(21395);
      return;
    }
    com.tencent.mm.plugin.backup.d.b.cVs().cVw().a(vai, startTime, endTime, com.tencent.mm.plugin.backup.d.b.cVs().cVw().cVn());
    paramIntent = this.uZT;
    paramIntent.uZQ.clear();
    paramIntent.uZP.a(paramIntent.uZQ);
    if ((com.tencent.mm.plugin.backup.d.b.cVs().cVw().cVo() == null) || (com.tencent.mm.plugin.backup.d.b.cVs().cVw().cVo().size() == 0)) {
      switch (vai)
      {
      default: 
        this.uZW.setVisibility(0);
      }
    }
    for (;;)
    {
      this.uZT.notifyDataSetChanged();
      AppMethodBeat.o(21395);
      return;
      this.uZW.setText(R.l.gsu);
      break;
      this.uZW.setText(R.l.guT);
      break;
      this.uZW.setVisibility(4);
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
    com.tencent.mm.plugin.backup.d.b.cVs().cVw().uYh = this.vak;
    AppMethodBeat.o(21389);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(21390);
    super.onStop();
    com.tencent.mm.plugin.backup.d.b.cVs().cVw().uYh = null;
    AppMethodBeat.o(21390);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI
 * JD-Core Version:    0.7.0.1
 */