package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CleanChattingUI
  extends MMActivity
  implements com.tencent.mm.plugin.clean.c.h
{
  private List<c> dataList = new ArrayList();
  private ProgressDialog dnm;
  private Button fks;
  private TextView hIX;
  private View iCP;
  private CheckBox iCQ;
  private a iCW;
  private ListView iCX;
  private TextView iCY;
  private TextView iCZ;
  private boolean iDa = false;
  
  public final void a(HashSet<Integer> paramHashSet)
  {
    if (this.iCW == null)
    {
      y.w("MicroMsg.CleanChattingUI", "on click check box but adapter is null");
      return;
    }
    Object localObject = new HashSet();
    Iterator localIterator = paramHashSet.iterator();
    long l = 0L;
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      c localc = this.iCW.pk(i);
      if (localc != null) {
        l = localc.size + l;
      } else {
        ((HashSet)localObject).add(Integer.valueOf(i));
      }
    }
    localObject = ((HashSet)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramHashSet.remove((Integer)((Iterator)localObject).next());
    }
    if ((paramHashSet.size() != 0) || (l > 0L))
    {
      this.iCY.setText(getString(R.l.delete_info, new Object[] { bk.cm(l) }));
      this.fks.setEnabled(true);
      if (paramHashSet.size() == this.iCW.getCount())
      {
        this.iCQ.setChecked(true);
        return;
      }
      this.iCQ.setChecked(false);
      return;
    }
    this.iCY.setText("");
    this.fks.setEnabled(false);
    this.iCQ.setChecked(false);
  }
  
  public final void cA(int paramInt1, int paramInt2)
  {
    ai.d(new CleanChattingUI.7(this, paramInt1, paramInt2));
  }
  
  public final void cZ(long paramLong)
  {
    y.i("MicroMsg.CleanChattingUI", "%s onDeleteEnd [%d] ", new Object[] { hashCode(), Long.valueOf(paramLong) });
    j.aEb().iBl -= paramLong;
    j.aEb().iBk -= paramLong;
    ai.d(new CleanChattingUI.8(this, paramLong));
  }
  
  protected final int getLayoutId()
  {
    return R.i.clean_chatting_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    long l;
    c localc;
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("key_pos", -1);
      l = paramIntent.getLongExtra("key_delete_size", 0L);
      if ((i > 0) && (i < this.dataList.size()))
      {
        localc = (c)this.dataList.get(i);
        if (localc != null)
        {
          if (localc.size != l) {
            break label102;
          }
          this.dataList.remove(i);
        }
      }
    }
    for (;;)
    {
      this.iCW.notifyDataSetChanged();
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      label102:
      localc.size -= l;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.CleanChattingUI", "Create!!");
    setMMTitle(R.l.clean_msg_ui_title);
    this.iCX = ((ListView)findViewById(R.h.clean_chatting_lv));
    this.iCW = new a(this, this.dataList);
    this.iCX.setAdapter(this.iCW);
    this.iCX.setEmptyView(findViewById(R.h.empty_view));
    this.iCZ = ((TextView)findViewById(R.h.empty_tip));
    this.iCP = findViewById(R.h.all_select_click_area);
    this.iCY = ((TextView)findViewById(R.h.delete_info_tv));
    this.iCQ = ((CheckBox)findViewById(R.h.all_select_cb));
    this.hIX = ((TextView)findViewById(R.h.all_select));
    if (!x.cqF())
    {
      this.iCY.setTextSize(1, 14.0F);
      this.hIX.setTextSize(1, 14.0F);
    }
    this.fks = ((Button)findViewById(R.h.del_btn));
    this.fks.setEnabled(false);
    setBackBtn(new CleanChattingUI.1(this));
    this.iCX.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = CleanChattingUI.a(CleanChattingUI.this).pk(paramAnonymousInt);
        if (paramAnonymousAdapterView != null)
        {
          paramAnonymousView = new Intent(CleanChattingUI.this, CleanChattingDetailUI.class);
          paramAnonymousView.putExtra("key_username", paramAnonymousAdapterView.username);
          paramAnonymousView.putExtra("key_pos", paramAnonymousInt);
          CleanChattingUI.this.startActivityForResult(paramAnonymousView, 0);
          com.tencent.mm.plugin.report.service.h.nFQ.a(714L, 21L, 1L, false);
        }
      }
    });
    this.fks.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        com.tencent.mm.ui.base.h.a(CleanChattingUI.this, CleanChattingUI.this.getString(R.l.confirm_delete_chatting), "", CleanChattingUI.this.getString(R.l.delete), CleanChattingUI.this.getString(R.l.cancel), new CleanChattingUI.3.1(this), new CleanChattingUI.3.2(this));
      }
    });
    this.iCP.setOnClickListener(new CleanChattingUI.4(this));
    getString(R.l.app_tip);
    this.dnm = com.tencent.mm.ui.base.h.b(this, getString(R.l.clean_del_data), false, new CleanChattingUI.5(this));
    this.dnm.dismiss();
    com.tencent.mm.plugin.report.service.h.nFQ.a(714L, 20L, 1L, false);
  }
  
  protected void onDestroy()
  {
    if (this.dnm.isShowing()) {
      this.dnm.dismiss();
    }
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    if ((this.iCW != null) && (this.dataList.isEmpty())) {
      g.DS().O(new CleanChattingUI.6(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI
 * JD-Core Version:    0.7.0.1
 */