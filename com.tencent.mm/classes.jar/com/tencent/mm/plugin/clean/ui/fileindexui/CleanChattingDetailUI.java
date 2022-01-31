package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView;
import com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView;

public class CleanChattingDetailUI
  extends MMActivity
  implements com.tencent.mm.plugin.clean.c.h
{
  private ProgressDialog dnm;
  private Button fks;
  private long iBn;
  private GridHeadersGridView iCN;
  private b iCO;
  private View iCP;
  CheckBox iCQ;
  MMAutoAdjustTextView iCR;
  private com.tencent.mm.plugin.clean.b.b iCS;
  private int pos;
  private String username;
  
  public final void cA(final int paramInt1, final int paramInt2)
  {
    ai.d(new Runnable()
    {
      public final void run()
      {
        CleanChattingDetailUI.c(CleanChattingDetailUI.this).setMessage(CleanChattingDetailUI.this.getString(R.l.clean_progress_tip, new Object[] { paramInt1 * 100 / paramInt2 + "%" }));
      }
    });
  }
  
  public final void cZ(long paramLong)
  {
    y.i("MicroMsg.CleanChattingDetailUI", "%s onDeleteEnd [%d] ", new Object[] { hashCode(), Long.valueOf(paramLong) });
    j.aEb().iBl -= paramLong;
    j.aEb().iBk -= paramLong;
    this.iBn += paramLong;
    ai.d(new CleanChattingDetailUI.6(this, paramLong));
  }
  
  protected final int getLayoutId()
  {
    return R.i.clean_chatting_detail_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.username = getIntent().getStringExtra("key_username");
    this.pos = getIntent().getIntExtra("key_pos", 0);
    if (bk.bl(this.username))
    {
      y.w("MicroMsg.CleanChattingDetailUI", "username is null");
      finish();
      return;
    }
    this.iCP = ((View)findViewById(R.h.all_select_click_area));
    this.iCQ = ((CheckBox)findViewById(R.h.all_select_cb));
    this.iCR = ((MMAutoAdjustTextView)findViewById(R.h.delete_info_tv));
    this.fks = ((Button)findViewById(R.h.del_btn));
    pn(0);
    if (s.fn(this.username)) {
      setMMTitle(r.getDisplayName(this.username, this.username));
    }
    for (;;)
    {
      this.iCN = ((GridHeadersGridView)findViewById(R.h.clean_chatting_detail_gv));
      this.iCN.setNumColumns(3);
      this.iCO = new b(this, this.username);
      this.iCN.setOnHeaderClickListener(this.iCO.iCC);
      this.iCN.setOnItemClickListener(this.iCO.idL);
      this.iCN.setOnScrollListener(this.iCO.iCE);
      this.iCN.setAdapter(this.iCO);
      setBackBtn(new CleanChattingDetailUI.1(this));
      this.iCP.setOnClickListener(new CleanChattingDetailUI.2(this));
      this.fks.setOnClickListener(new CleanChattingDetailUI.3(this));
      getString(R.l.app_tip);
      this.dnm = com.tencent.mm.ui.base.h.b(this, getString(R.l.clean_del_data), false, new CleanChattingDetailUI.4(this));
      this.dnm.dismiss();
      if (this.iCO != null) {
        e.post(new b.b(this.iCO, (byte)0), "load_clean_detail");
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(714L, 30L, 1L, false);
      return;
      setMMTitle(r.gV(this.username));
    }
  }
  
  protected void onDestroy()
  {
    if ((this.dnm != null) && (this.dnm.isShowing())) {
      this.dnm.dismiss();
    }
    if (this.iCO != null) {
      this.iCO.isStop = true;
    }
    super.onDestroy();
  }
  
  public final void pn(int paramInt)
  {
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.fks.setEnabled(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI
 * JD-Core Version:    0.7.0.1
 */