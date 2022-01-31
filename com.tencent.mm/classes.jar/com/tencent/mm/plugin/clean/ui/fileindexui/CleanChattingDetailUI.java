package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView;
import com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView;

public class CleanChattingDetailUI
  extends MMActivity
  implements com.tencent.mm.plugin.clean.c.h
{
  private ProgressDialog eeN;
  private Button gBJ;
  private long kGu;
  private GridHeadersGridView kHU;
  private b kHV;
  private View kHW;
  CheckBox kHX;
  MMAutoAdjustTextView kHY;
  private com.tencent.mm.plugin.clean.b.b kHZ;
  private int pos;
  private String username;
  
  public final void dY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(18775);
    al.d(new CleanChattingDetailUI.5(this, paramInt1, paramInt2));
    AppMethodBeat.o(18775);
  }
  
  public int getLayoutId()
  {
    return 2130969160;
  }
  
  public final void iv(long paramLong)
  {
    AppMethodBeat.i(18776);
    ab.i("MicroMsg.CleanChattingDetailUI", "%s onDeleteEnd [%d] ", new Object[] { hashCode(), Long.valueOf(paramLong) });
    j.bhb().kGs -= paramLong;
    j.bhb().kGr -= paramLong;
    this.kGu += paramLong;
    al.d(new CleanChattingDetailUI.6(this, paramLong));
    AppMethodBeat.o(18776);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(18772);
    super.onCreate(paramBundle);
    this.username = getIntent().getStringExtra("key_username");
    this.pos = getIntent().getIntExtra("key_pos", 0);
    if (bo.isNullOrNil(this.username))
    {
      ab.w("MicroMsg.CleanChattingDetailUI", "username is null");
      finish();
      AppMethodBeat.o(18772);
      return;
    }
    this.kHW = ((View)$(2131821650));
    this.kHX = ((CheckBox)$(2131821648));
    this.kHY = ((MMAutoAdjustTextView)$(2131822841));
    this.gBJ = ((Button)$(2131822840));
    tD(0);
    if (t.lA(this.username)) {
      setMMTitle(s.getDisplayName(this.username, this.username));
    }
    for (;;)
    {
      this.kHU = ((GridHeadersGridView)findViewById(2131822839));
      this.kHU.setNumColumns(3);
      this.kHV = new b(this, this.username);
      this.kHU.setOnHeaderClickListener(this.kHV.kHJ);
      this.kHU.setOnItemClickListener(this.kHV.jUz);
      this.kHU.setOnScrollListener(this.kHV.kHL);
      this.kHU.setAdapter(this.kHV);
      setBackBtn(new CleanChattingDetailUI.1(this));
      this.kHW.setOnClickListener(new CleanChattingDetailUI.2(this));
      this.gBJ.setOnClickListener(new CleanChattingDetailUI.3(this));
      getString(2131297087);
      this.eeN = com.tencent.mm.ui.base.h.b(this, getString(2131298374), false, new CleanChattingDetailUI.4(this));
      this.eeN.dismiss();
      if (this.kHV != null) {
        d.post(new b.b(this.kHV, (byte)0), "load_clean_detail");
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(714L, 30L, 1L, false);
      AppMethodBeat.o(18772);
      return;
      setMMTitle(s.nE(this.username));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(18774);
    if ((this.eeN != null) && (this.eeN.isShowing())) {
      this.eeN.dismiss();
    }
    if (this.kHV != null) {
      this.kHV.isStop = true;
    }
    super.onDestroy();
    AppMethodBeat.o(18774);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void tD(int paramInt)
  {
    AppMethodBeat.i(18773);
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.gBJ.setEnabled(bool);
      AppMethodBeat.o(18773);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI
 * JD-Core Version:    0.7.0.1
 */