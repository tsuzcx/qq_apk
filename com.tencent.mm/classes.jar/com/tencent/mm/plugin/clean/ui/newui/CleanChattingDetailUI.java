package com.tencent.mm.plugin.clean.ui.newui;

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
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.clean.c.e;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView;
import com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView;
import java.util.ArrayList;

public class CleanChattingDetailUI
  extends MMActivity
  implements com.tencent.mm.plugin.clean.c.h
{
  private ProgressDialog eeN;
  private Button gBJ;
  private int index;
  private GridHeadersGridView kHU;
  private View kHW;
  CheckBox kHX;
  MMAutoAdjustTextView kHY;
  private b kJf;
  private com.tencent.mm.plugin.clean.c.b kJg;
  private e kJh;
  
  public final void dY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(18871);
    this.eeN.setMessage(getString(2131298394, new Object[] { paramInt1 * 100 / paramInt2 + "%" }));
    AppMethodBeat.o(18871);
  }
  
  public int getLayoutId()
  {
    return 2130969160;
  }
  
  public final void iv(long paramLong)
  {
    AppMethodBeat.i(18872);
    this.eeN.dismiss();
    d.it(d.bgU() + paramLong);
    d.iq(d.bgR() - paramLong);
    com.tencent.mm.ui.base.h.a(this, getString(2131298375, new Object[] { bo.hk(paramLong) }), "", new CleanChattingDetailUI.5(this));
    AppMethodBeat.o(18872);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(18868);
    super.onCreate(paramBundle);
    d.bgX();
    this.index = getIntent().getIntExtra("key_position", -1);
    if (this.index < 0)
    {
      finish();
      AppMethodBeat.o(18868);
      return;
    }
    if (d.bgQ() == null)
    {
      finish();
      AppMethodBeat.o(18868);
      return;
    }
    this.kHW = findViewById(2131821650);
    this.kHX = ((CheckBox)findViewById(2131821648));
    this.kHY = ((MMAutoAdjustTextView)findViewById(2131822841));
    this.gBJ = ((Button)findViewById(2131822840));
    tD(0);
    this.kJg = ((com.tencent.mm.plugin.clean.c.b)d.bgQ().get(this.index));
    if (t.lA(this.kJg.username)) {
      setMMTitle(s.getDisplayName(this.kJg.username, this.kJg.username));
    }
    for (;;)
    {
      this.kHU = ((GridHeadersGridView)findViewById(2131822839));
      this.kHU.setNumColumns(3);
      this.kJf = new b(this, this.kJg.kGB);
      this.kHU.setOnHeaderClickListener(this.kJf.kHJ);
      this.kHU.setOnItemClickListener(this.kJf.jUz);
      this.kHU.setOnScrollListener(this.kJf.kHL);
      this.kHU.setAdapter(this.kJf);
      setBackBtn(new CleanChattingDetailUI.1(this));
      this.kHW.setOnClickListener(new CleanChattingDetailUI.2(this));
      this.gBJ.setOnClickListener(new CleanChattingDetailUI.3(this));
      getString(2131297087);
      this.eeN = com.tencent.mm.ui.base.h.b(this, getString(2131298374), false, new CleanChattingDetailUI.4(this));
      this.eeN.dismiss();
      AppMethodBeat.o(18868);
      return;
      setMMTitle(s.nE(this.kJg.username));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(18870);
    if (this.eeN.isShowing()) {
      this.eeN.dismiss();
    }
    if (this.kJh != null) {
      this.kJh.bgZ();
    }
    d.bgY();
    d.bgW();
    super.onDestroy();
    AppMethodBeat.o(18870);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void tD(int paramInt)
  {
    AppMethodBeat.i(18869);
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.gBJ.setEnabled(bool);
      AppMethodBeat.o(18869);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanChattingDetailUI
 * JD-Core Version:    0.7.0.1
 */