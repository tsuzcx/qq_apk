package com.tencent.mm.plugin.clean.ui.newui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.clean.c.b;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.clean.c.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class CleanChattingUI
  extends MMActivity
  implements com.tencent.mm.plugin.clean.c.h
{
  private ProgressDialog eeN;
  private Button gBJ;
  private TextView jCx;
  private View kHW;
  private CheckBox kHX;
  private ListView kIe;
  private TextView kIf;
  private e kJh;
  private a kJk;
  
  public final void a(HashSet<Integer> paramHashSet)
  {
    AppMethodBeat.i(18881);
    Object localObject = new HashSet();
    Iterator localIterator = paramHashSet.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      int j = ((Integer)localIterator.next()).intValue();
      if (j < d.bgQ().size())
      {
        long l = i;
        i = (int)(((b)d.bgQ().get(j)).jyU + l);
      }
      else
      {
        ((HashSet)localObject).add(Integer.valueOf(j));
      }
    }
    localObject = ((HashSet)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramHashSet.remove((Integer)((Iterator)localObject).next());
    }
    if ((paramHashSet.size() != 0) || (i > 0))
    {
      this.kIf.setText(getString(2131298949, new Object[] { bo.hk(i) }));
      this.gBJ.setEnabled(true);
      if (paramHashSet.size() == this.kJk.getCount())
      {
        this.kHX.setChecked(true);
        AppMethodBeat.o(18881);
        return;
      }
      this.kHX.setChecked(false);
      AppMethodBeat.o(18881);
      return;
    }
    this.kIf.setText("");
    this.gBJ.setEnabled(false);
    this.kHX.setChecked(false);
    AppMethodBeat.o(18881);
  }
  
  public final void dY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(18883);
    this.eeN.setMessage(getString(2131298394, new Object[] { paramInt1 * 100 / paramInt2 + "%" }));
    AppMethodBeat.o(18883);
  }
  
  public int getLayoutId()
  {
    return 2130969162;
  }
  
  public final void iv(long paramLong)
  {
    AppMethodBeat.i(18884);
    this.eeN.dismiss();
    d.it(d.bgU() + paramLong);
    d.iq(d.bgR() - paramLong);
    com.tencent.mm.ui.base.h.a(this, getString(2131298375, new Object[] { bo.hk(paramLong) }), "", new CleanChattingUI.6(this));
    AppMethodBeat.o(18884);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(18885);
    this.kJk.notifyDataSetChanged();
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(18885);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(18880);
    super.onCreate(paramBundle);
    d.bgX();
    ab.i("MicroMsg.CleanChattingUI", "Create!!");
    setMMTitle(2131298402);
    this.kIe = ((ListView)findViewById(2131822842));
    this.kJk = new a(this);
    this.kIe.setAdapter(this.kJk);
    this.kIe.setEmptyView(findViewById(2131821642));
    this.kHW = findViewById(2131821650);
    this.kIf = ((TextView)findViewById(2131822841));
    this.kHX = ((CheckBox)findViewById(2131821648));
    this.jCx = ((TextView)findViewById(2131821649));
    if (!aa.dsC())
    {
      this.kIf.setTextSize(1, 14.0F);
      this.jCx.setTextSize(1, 14.0F);
    }
    this.gBJ = ((Button)findViewById(2131822840));
    this.gBJ.setEnabled(false);
    setBackBtn(new CleanChattingUI.1(this));
    this.kIe.setOnItemClickListener(new CleanChattingUI.2(this));
    this.gBJ.setOnClickListener(new CleanChattingUI.3(this));
    this.kHW.setOnClickListener(new CleanChattingUI.4(this));
    getString(2131297087);
    this.eeN = com.tencent.mm.ui.base.h.b(this, getString(2131298374), false, new CleanChattingUI.5(this));
    this.eeN.dismiss();
    AppMethodBeat.o(18880);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(18882);
    if (this.eeN.isShowing()) {
      this.eeN.dismiss();
    }
    if (this.kJh != null) {
      this.kJh.bgZ();
    }
    d.bgY();
    d.bgW();
    super.onDestroy();
    AppMethodBeat.o(18882);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanChattingUI
 * JD-Core Version:    0.7.0.1
 */