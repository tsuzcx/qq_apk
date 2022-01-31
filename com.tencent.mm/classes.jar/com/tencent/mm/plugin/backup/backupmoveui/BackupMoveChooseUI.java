package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.c.b.b;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.plugin.backup.d.d;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.s;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class BackupMoveChooseUI
  extends MMWizardActivity
  implements b.b
{
  private static int avS = 0;
  private static long endTime;
  private static int hJk = 0;
  private static long startTime;
  private a hIV = new a(this);
  private ListView hIW;
  private TextView hIX;
  private TextView hIY;
  private TextView hIZ;
  private ProgressBar hJa;
  private View hJb;
  private LinearLayout hJc;
  private LinearLayout hJd;
  private LinearLayout hJe;
  private LinearLayout hJf;
  private TextView hJg;
  private TextView hJh;
  private TextView hJi;
  private Button hJj;
  private SimpleDateFormat hJl = new SimpleDateFormat("yyyy.MM.dd");
  
  private void aum()
  {
    if ((this.hJd.getVisibility() == 8) && (this.hJe.getVisibility() == 8) && (this.hJf.getVisibility() == 8))
    {
      this.hJb.setVisibility(8);
      this.hJc.setVisibility(8);
      return;
    }
    this.hJb.setVisibility(0);
    this.hJc.setVisibility(0);
  }
  
  private void ed(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b.atS();
      SharedPreferences localSharedPreferences = b.ats();
      hJk = localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
      avS = localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
      startTime = localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
      endTime = localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
    }
    switch (hJk)
    {
    default: 
      switch (avS)
      {
      }
      break;
    }
    for (;;)
    {
      aum();
      return;
      this.hJe.setVisibility(8);
      break;
      this.hJb.setVisibility(0);
      this.hJc.setVisibility(0);
      this.hJe.setVisibility(0);
      this.hJh.setText(this.hJl.format(new Date(startTime)) + "~" + this.hJl.format(new Date(endTime - 86400000L)));
      break;
      this.hJf.setVisibility(8);
      continue;
      this.hJb.setVisibility(0);
      this.hJc.setVisibility(0);
      this.hJf.setVisibility(0);
      this.hJi.setText(this.mController.uMN.getResources().getString(R.l.backup_move_select_ext_content_text_only));
    }
  }
  
  public final void A(LinkedList<f.b> paramLinkedList)
  {
    if (paramLinkedList == null) {
      return;
    }
    if (paramLinkedList.size() == 0)
    {
      this.hJa.setVisibility(8);
      this.hIY.setVisibility(0);
      switch (hJk)
      {
      default: 
        return;
      case 0: 
        this.hIY.setText(R.l.backup_move_choose_empty_records);
        return;
      }
      this.hIY.setText(R.l.backup_select_empty_records_in_select_time);
      return;
    }
    this.hIX.setClickable(true);
    this.hIX.setTextColor(getResources().getColor(R.e.backup_green));
    this.hJa.setVisibility(8);
    this.hIV.notifyDataSetChanged();
  }
  
  public final void B(LinkedList<f.b> paramLinkedList) {}
  
  public final void a(HashSet<Integer> paramHashSet)
  {
    Object localObject = b.atS().atW().atP();
    if (localObject == null)
    {
      y.e("MicroMsg.BackupMoveChooseUI", "onClickCheckBox convInfo is null.");
      return;
    }
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramHashSet.iterator();
    long l = 0L;
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if (i < ((LinkedList)localObject).size()) {
        l = ((f.b)((LinkedList)localObject).get(i)).hFG + l;
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
      this.hJj.setEnabled(true);
      if (paramHashSet.size() == this.hIV.getCount())
      {
        this.hIX.setText(R.l.backup_choose_cancel_select_all);
        this.hJb.setVisibility(0);
        this.hJc.setVisibility(0);
        this.hJd.setVisibility(0);
        this.hJg.setText(getString(R.l.backup_choose_session_info, new Object[] { Integer.valueOf(paramHashSet.size()) }));
      }
    }
    for (;;)
    {
      aum();
      return;
      this.hIX.setText(R.l.backup_choose_all);
      break;
      this.hJj.setEnabled(false);
      this.hIX.setText(R.l.backup_choose_all);
      this.hJd.setVisibility(8);
      this.hJg.setText("");
    }
  }
  
  public final void a(LinkedList<f.b> paramLinkedList, f.b paramb, int paramInt) {}
  
  protected final int getLayoutId()
  {
    return R.i.backup_choose;
  }
  
  public final void initView()
  {
    setMMTitle(R.l.backup_start_choose_move_records);
    this.hIW = ((ListView)findViewById(R.h.backup_choose_conversation_lv));
    this.hIW.setAdapter(this.hIV);
    this.hIW.setEmptyView(findViewById(R.h.backup_choose_empty_view));
    this.hIX = ((TextView)findViewById(R.h.backup_choose_select_all_tv));
    this.hIY = ((TextView)findViewById(R.h.backup_choose_empty_tv));
    this.hJa = ((ProgressBar)findViewById(R.h.backup_choose_loading_pb));
    this.hIZ = ((TextView)findViewById(R.h.backup_choose_ext));
    this.hJb = findViewById(R.h.backup_choose_line);
    this.hJc = ((LinearLayout)findViewById(R.h.backup_choose_ext_info));
    this.hJd = ((LinearLayout)findViewById(R.h.backup_choose_session_info));
    this.hJe = ((LinearLayout)findViewById(R.h.backup_choose_time));
    this.hJf = ((LinearLayout)findViewById(R.h.backup_choose_content));
    this.hJg = ((TextView)findViewById(R.h.backup_choose_session_info_tv));
    this.hJh = ((TextView)findViewById(R.h.backup_choose_time_tv));
    this.hJi = ((TextView)findViewById(R.h.backup_choose_content_tv));
    ((TextView)findViewById(R.h.backup_choose_session_info_title)).setText(R.l.backup_move_choose_number);
    ((TextView)findViewById(R.h.backup_choose_time_title)).setText(R.l.backup_move_choose_time);
    ((TextView)findViewById(R.h.backup_choose_content_title)).setText(R.l.backup_move_choose_content);
    setBackBtn(new BackupMoveChooseUI.1(this));
    this.hJj = ((Button)findViewById(R.h.backup_choose_finish));
    this.hJj.setOnClickListener(new BackupMoveChooseUI.2(this));
    this.hJj.setEnabled(false);
    ed(true);
    this.hIZ.setOnClickListener(new BackupMoveChooseUI.3(this));
    this.hIX.setOnClickListener(new BackupMoveChooseUI.4(this));
    if (b.atS().atW().hHx)
    {
      if ((b.atS().atW().atP() == null) || (b.atS().atW().atP().size() == 0)) {
        switch (hJk)
        {
        }
      }
      for (;;)
      {
        this.hIY.setVisibility(0);
        this.hJa.setVisibility(4);
        return;
        this.hIY.setText(R.l.backup_move_choose_empty_records);
        continue;
        this.hIY.setText(R.l.backup_select_empty_records_in_select_time);
      }
    }
    if (!b.atS().atW().hHx)
    {
      this.hIX.setTextColor(getResources().getColor(R.e.backup_status_content));
      this.hIX.setClickable(false);
      this.hJa.setVisibility(0);
      return;
    }
    this.hJa.setVisibility(4);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {
      y.e("MicroMsg.BackupMoveChooseUI", "onActivityResult result error! resultCode:%d", new Object[] { Integer.valueOf(paramInt2) });
    }
    long l1;
    long l2;
    do
    {
      return;
      paramInt1 = hJk;
      l1 = startTime;
      l2 = endTime;
      hJk = paramIntent.getIntExtra("BACKUP_SELECT_TIME_MODE", hJk);
      startTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0L);
      endTime = paramIntent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0L);
      avS = paramIntent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", avS);
      y.i("MicroMsg.BackupMoveChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", new Object[] { Integer.valueOf(hJk), Integer.valueOf(paramInt1), Long.valueOf(startTime), Long.valueOf(l1), Long.valueOf(endTime), Long.valueOf(l2), Integer.valueOf(avS) });
      b.atS().atU();
      d.d(hJk, startTime, endTime, avS);
      ed(false);
    } while ((paramInt1 == hJk) && ((hJk == 0) || ((hJk == 1) && (startTime == l1) && (endTime == l2))));
    b.atS().atW().a(hJk, startTime, endTime, b.atS().atW().atO());
    paramIntent = this.hIV;
    paramIntent.hIR.clear();
    paramIntent.hIQ.a(paramIntent.hIR);
    if ((b.atS().atW().atP() == null) || (b.atS().atW().atP().size() == 0)) {
      switch (hJk)
      {
      default: 
        this.hIY.setVisibility(0);
      }
    }
    for (;;)
    {
      this.hIV.notifyDataSetChanged();
      return;
      this.hIY.setText(R.l.backup_move_choose_empty_records);
      break;
      this.hIY.setText(R.l.backup_select_empty_records_in_select_time);
      break;
      this.hIY.setVisibility(4);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public void onStart()
  {
    super.onStart();
    b.atS().atW().hHs = this;
  }
  
  public void onStop()
  {
    super.onStop();
    b.atS().atW().hHs = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI
 * JD-Core Version:    0.7.0.1
 */