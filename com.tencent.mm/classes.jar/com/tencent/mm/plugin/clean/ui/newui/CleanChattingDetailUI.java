package com.tencent.mm.plugin.clean.ui.newui;

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
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.clean.c.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView;
import com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView;
import java.util.ArrayList;

public class CleanChattingDetailUI
  extends MMActivity
  implements com.tencent.mm.plugin.clean.c.h
{
  private ProgressDialog dnm;
  private Button fks;
  private GridHeadersGridView iCN;
  private View iCP;
  CheckBox iCQ;
  MMAutoAdjustTextView iCR;
  private b iDY;
  private com.tencent.mm.plugin.clean.c.b iDZ;
  private e iEa;
  private int index;
  
  public final void cA(int paramInt1, int paramInt2)
  {
    this.dnm.setMessage(getString(R.l.clean_progress_tip, new Object[] { paramInt1 * 100 / paramInt2 + "%" }));
  }
  
  public final void cZ(long paramLong)
  {
    this.dnm.dismiss();
    d.cX(d.aDU() + paramLong);
    d.cU(d.aDR() - paramLong);
    com.tencent.mm.ui.base.h.a(this, getString(R.l.clean_del_data_ok_tip, new Object[] { bk.cm(paramLong) }), "", new CleanChattingDetailUI.5(this));
  }
  
  protected final int getLayoutId()
  {
    return R.i.clean_chatting_detail_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    d.aDX();
    this.index = getIntent().getIntExtra("key_position", -1);
    if (this.index < 0)
    {
      finish();
      return;
    }
    if (d.aDQ() == null)
    {
      finish();
      return;
    }
    this.iCP = findViewById(R.h.all_select_click_area);
    this.iCQ = ((CheckBox)findViewById(R.h.all_select_cb));
    this.iCR = ((MMAutoAdjustTextView)findViewById(R.h.delete_info_tv));
    this.fks = ((Button)findViewById(R.h.del_btn));
    pn(0);
    this.iDZ = ((com.tencent.mm.plugin.clean.c.b)d.aDQ().get(this.index));
    if (s.fn(this.iDZ.username)) {
      setMMTitle(r.getDisplayName(this.iDZ.username, this.iDZ.username));
    }
    for (;;)
    {
      this.iCN = ((GridHeadersGridView)findViewById(R.h.clean_chatting_detail_gv));
      this.iCN.setNumColumns(3);
      this.iDY = new b(this, this.iDZ.iBu);
      this.iCN.setOnHeaderClickListener(this.iDY.iCC);
      this.iCN.setOnItemClickListener(this.iDY.idL);
      this.iCN.setOnScrollListener(this.iDY.iCE);
      this.iCN.setAdapter(this.iDY);
      setBackBtn(new CleanChattingDetailUI.1(this));
      this.iCP.setOnClickListener(new CleanChattingDetailUI.2(this));
      this.fks.setOnClickListener(new CleanChattingDetailUI.3(this));
      getString(R.l.app_tip);
      this.dnm = com.tencent.mm.ui.base.h.b(this, getString(R.l.clean_del_data), false, new CleanChattingDetailUI.4(this));
      this.dnm.dismiss();
      return;
      setMMTitle(r.gV(this.iDZ.username));
    }
  }
  
  protected void onDestroy()
  {
    if (this.dnm.isShowing()) {
      this.dnm.dismiss();
    }
    if (this.iEa != null) {
      this.iEa.aDZ();
    }
    d.aDY();
    d.aDW();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanChattingDetailUI
 * JD-Core Version:    0.7.0.1
 */