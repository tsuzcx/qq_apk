package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.backuppcmodel.e;
import com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI;
import com.tencent.mm.plugin.backup.c.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.k;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class BackupPcChooseUI
  extends MMWizardActivity
{
  private static int cIh = 0;
  private static long endTime;
  private static long startTime;
  private static int vai = 0;
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
  private a vcd;
  private ListView vce;
  private b.a vcf;
  
  public BackupPcChooseUI()
  {
    AppMethodBeat.i(21638);
    this.vcd = new a(this);
    this.vaj = new SimpleDateFormat("yyyy.MM.dd");
    this.vcf = new b.a()
    {
      public final void G(LinkedList<f.b> paramAnonymousLinkedList)
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
          switch (BackupPcChooseUI.vai)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(21637);
            return;
            BackupPcChooseUI.c(BackupPcChooseUI.this).setText(R.l.gtO);
            AppMethodBeat.o(21637);
            return;
            BackupPcChooseUI.c(BackupPcChooseUI.this).setText(R.l.guT);
          }
        }
        BackupPcChooseUI.d(BackupPcChooseUI.this).setClickable(true);
        BackupPcChooseUI.d(BackupPcChooseUI.this).setTextColor(BackupPcChooseUI.this.getResources().getColor(R.e.fkf));
        BackupPcChooseUI.b(BackupPcChooseUI.this).setVisibility(8);
        BackupPcChooseUI.a(BackupPcChooseUI.this).notifyDataSetChanged();
        AppMethodBeat.o(21637);
      }
    };
    AppMethodBeat.o(21638);
  }
  
  private void cVN()
  {
    AppMethodBeat.i(21645);
    if ((this.vab.getVisibility() == 8) && (this.vac.getVisibility() == 8) && (this.vad.getVisibility() == 8))
    {
      this.uZZ.setVisibility(8);
      this.vaa.setVisibility(8);
      AppMethodBeat.o(21645);
      return;
    }
    this.uZZ.setVisibility(0);
    this.vaa.setVisibility(0);
    AppMethodBeat.o(21645);
  }
  
  private void ma(boolean paramBoolean)
  {
    AppMethodBeat.i(21643);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.backup.backuppcmodel.b.cVW();
      SharedPreferences localSharedPreferences = com.tencent.mm.plugin.backup.backuppcmodel.b.cUO();
      vai = localSharedPreferences.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
      cIh = localSharedPreferences.getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
      startTime = localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
      endTime = localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
    }
    if (com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVY().vbR) {}
    switch (vai)
    {
    default: 
      if (com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVY().vbS) {
        switch (cIh)
        {
        }
      }
      break;
    }
    for (;;)
    {
      cVN();
      AppMethodBeat.o(21643);
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
      this.vag.setText(getContext().getResources().getString(R.l.guE));
    }
  }
  
  public final void a(HashSet<Integer> paramHashSet)
  {
    AppMethodBeat.i(21644);
    Object localObject = new HashSet();
    int i = com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().cVo().size();
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
      this.vah.setEnabled(true);
      if ((com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().uYm) && (paramHashSet.size() == this.vcd.getCount()))
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
      AppMethodBeat.o(21644);
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
    AppMethodBeat.i(21642);
    setMMTitle(R.l.guI);
    this.vce = ((ListView)findViewById(R.h.fsG));
    this.vce.setAdapter(this.vcd);
    this.vce.setEmptyView(findViewById(R.h.fsI));
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
    ((TextView)findViewById(R.h.fsQ)).setText(R.l.gtP);
    ((TextView)findViewById(R.h.fsT)).setText(R.l.gtQ);
    ((TextView)findViewById(R.h.fsE)).setText(R.l.gtN);
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
    this.vah = ((Button)findViewById(R.h.fsL));
    this.vah.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(21634);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        localObject = BackupPcChooseUI.a(BackupPcChooseUI.this);
        paramAnonymousView = new LinkedList();
        if (((a)localObject).uZQ.size() <= 0) {}
        for (;;)
        {
          localObject = g.F(paramAnonymousView);
          bh.bCz();
          boolean bool = ((Boolean)com.tencent.mm.model.c.ban().get(at.a.acPd, Boolean.FALSE)).booleanValue();
          Log.i("MicroMsg.BackupPcChooseUI", "initView OnMenuItemClickListener startbackup choose records finish, selectedConversation size[%d], hasMove[%b], timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[] { Integer.valueOf(paramAnonymousView.size()), Boolean.valueOf(bool), Integer.valueOf(BackupPcChooseUI.vai), Long.valueOf(BackupPcChooseUI.startTime), Long.valueOf(BackupPcChooseUI.endTime), Integer.valueOf(BackupPcChooseUI.cIh) });
          if (!bool) {
            break;
          }
          k.a(BackupPcChooseUI.this, R.l.gun, 0, R.l.guZ, 0, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(21633);
              com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().L(paramAnonymousView);
              com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().Fl(2);
              com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg = 12;
              com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVY().K(this.vci);
              com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVY().jZ(paramAnonymousView.size());
              h.OAn.idkeyStat(400L, 8L, 1L, false);
              h.OAn.b(13735, new Object[] { Integer.valueOf(10), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbC) });
              if ((BackupPcChooseUI.vai == 1) && (BackupPcChooseUI.cIh == 1))
              {
                h.OAn.idkeyStat(400L, 32L, 1L, false);
                h.OAn.idkeyStat(400L, 35L, 1L, false);
                h.OAn.b(13735, new Object[] { Integer.valueOf(13), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbC) });
              }
              for (;;)
              {
                BackupPcChooseUI.this.finish();
                AppMethodBeat.o(21633);
                return;
                if (BackupPcChooseUI.vai == 1)
                {
                  h.OAn.idkeyStat(400L, 32L, 1L, false);
                  h.OAn.b(13735, new Object[] { Integer.valueOf(11), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbC) });
                }
                else if (BackupPcChooseUI.cIh == 1)
                {
                  h.OAn.idkeyStat(400L, 35L, 1L, false);
                  h.OAn.b(13735, new Object[] { Integer.valueOf(12), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbC) });
                }
              }
            }
          }, null, R.e.fkf);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(21634);
          return;
          LinkedList localLinkedList = com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().cVo();
          if (localLinkedList != null)
          {
            int i = 0;
            while (i < ((a)localObject).getCount())
            {
              if (((a)localObject).uZQ.contains(Integer.valueOf(i))) {
                paramAnonymousView.add((f.b)localLinkedList.get(i));
              }
              i += 1;
            }
          }
          Log.i("MicroMsg.BackupPcChooseAdapter", "finishSelected usernameSize:%d", new Object[] { Integer.valueOf(paramAnonymousView.size()) });
        }
        com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().L(paramAnonymousView);
        com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().Fl(2);
        com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cUJ().uWg = 12;
        com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVY().K((LinkedList)localObject);
        com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVY().jZ(paramAnonymousView.size());
        h.OAn.idkeyStat(400L, 8L, 1L, false);
        h.OAn.b(13735, new Object[] { Integer.valueOf(10), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbC) });
        if ((BackupPcChooseUI.vai == 1) && (BackupPcChooseUI.cIh == 1))
        {
          h.OAn.idkeyStat(400L, 32L, 1L, false);
          h.OAn.idkeyStat(400L, 35L, 1L, false);
          h.OAn.b(13735, new Object[] { Integer.valueOf(13), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbC) });
        }
        for (;;)
        {
          BackupPcChooseUI.this.finish();
          break;
          if (BackupPcChooseUI.vai == 1)
          {
            h.OAn.idkeyStat(400L, 32L, 1L, false);
            h.OAn.b(13735, new Object[] { Integer.valueOf(11), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbC) });
          }
          else if (BackupPcChooseUI.cIh == 1)
          {
            h.OAn.idkeyStat(400L, 35L, 1L, false);
            h.OAn.b(13735, new Object[] { Integer.valueOf(12), Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVX().vbC) });
          }
        }
      }
    });
    this.vah.setEnabled(false);
    if ((!com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVY().vbR) && (!com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVY().vbS)) {
      this.uZX.setVisibility(8);
    }
    for (;;)
    {
      this.uZV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21636);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().uYm)
          {
            paramAnonymousView = BackupPcChooseUI.a(BackupPcChooseUI.this);
            if (paramAnonymousView.uZQ.size() != paramAnonymousView.getCount()) {
              break label114;
            }
            paramAnonymousView.uZQ.clear();
          }
          for (a.vcb = false;; a.vcb = true)
          {
            paramAnonymousView.notifyDataSetChanged();
            paramAnonymousView.vca.a(paramAnonymousView.uZQ);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21636);
            return;
            label114:
            int i = 0;
            while (i < paramAnonymousView.getCount())
            {
              paramAnonymousView.uZQ.add(Integer.valueOf(i));
              i += 1;
            }
          }
        }
      });
      if (com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().uYm) {
        break;
      }
      this.uZV.setTextColor(getResources().getColor(R.e.fkh));
      this.uZV.setClickable(false);
      this.uZY.setVisibility(0);
      AppMethodBeat.o(21642);
      return;
      this.uZX.setVisibility(0);
      ma(true);
      this.uZX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21635);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new Intent(BackupPcChooseUI.this, BackupSelectExtUI.class);
          paramAnonymousView.putExtra("BACKUP_MODE", 1);
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MODE", BackupPcChooseUI.vai);
          paramAnonymousView.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVY().vbS);
          paramAnonymousView.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupPcChooseUI.cIh);
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupPcChooseUI.startTime);
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupPcChooseUI.endTime);
          paramAnonymousView.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().uYi);
          BackupPcChooseUI.this.startActivityForResult(paramAnonymousView, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(21635);
        }
      });
    }
    if (com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().cVo().size() == 0) {
      switch (vai)
      {
      }
    }
    for (;;)
    {
      this.uZW.setVisibility(0);
      this.uZY.setVisibility(4);
      AppMethodBeat.o(21642);
      return;
      this.uZW.setText(R.l.gtO);
      continue;
      this.uZW.setText(R.l.guT);
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
    paramInt1 = vai;
    long l1 = startTime;
    long l2 = endTime;
    vai = paramIntent.getIntExtra("BACKUP_SELECT_TIME_MODE", vai);
    startTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0L);
    endTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0L);
    cIh = paramIntent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", cIh);
    Log.i("MicroMsg.BackupPcChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", new Object[] { Integer.valueOf(vai), Integer.valueOf(paramInt1), Long.valueOf(startTime), Long.valueOf(l1), Long.valueOf(endTime), Long.valueOf(l2), Integer.valueOf(cIh) });
    com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cVY();
    e.f(vai, startTime, endTime, cIh);
    ma(false);
    if ((paramInt1 == vai) && ((vai == 0) || ((vai == 1) && (startTime == l1) && (endTime == l2))))
    {
      AppMethodBeat.o(21646);
      return;
    }
    com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().a(vai, startTime, endTime, com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().cVn());
    paramIntent = this.vcd;
    paramIntent.uZQ.clear();
    paramIntent.vca.a(paramIntent.uZQ);
    if ((com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().cVo() == null) || (com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().cVo().size() == 0)) {
      switch (vai)
      {
      default: 
        this.uZW.setVisibility(0);
      }
    }
    for (;;)
    {
      this.vcd.notifyDataSetChanged();
      AppMethodBeat.o(21646);
      return;
      this.uZW.setText(R.l.gtO);
      break;
      this.uZW.setText(R.l.guT);
      break;
      this.uZW.setVisibility(4);
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
    com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().vbo = this.vcf;
    AppMethodBeat.o(21640);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(21641);
    super.onStop();
    com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().vbo = null;
    AppMethodBeat.o(21641);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI
 * JD-Core Version:    0.7.0.1
 */