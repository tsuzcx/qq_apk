package com.tencent.mm.plugin.clean.ui.fileindexui;

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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CleanChattingUI
  extends MMActivity
  implements com.tencent.mm.plugin.clean.c.h
{
  private List<c> dataList;
  private ProgressDialog eeN;
  private Button gBJ;
  private TextView jCx;
  private View kHW;
  private CheckBox kHX;
  private a kId;
  private ListView kIe;
  private TextView kIf;
  private TextView kIg;
  private boolean kIh;
  
  public CleanChattingUI()
  {
    AppMethodBeat.i(18788);
    this.kIh = false;
    this.dataList = new ArrayList();
    AppMethodBeat.o(18788);
  }
  
  public final void a(HashSet<Integer> paramHashSet)
  {
    AppMethodBeat.i(18790);
    if (this.kId == null)
    {
      ab.w("MicroMsg.CleanChattingUI", "on click check box but adapter is null");
      AppMethodBeat.o(18790);
      return;
    }
    Object localObject = new HashSet();
    Iterator localIterator = paramHashSet.iterator();
    long l = 0L;
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      c localc = this.kId.tA(i);
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
      this.kIf.setText(getString(2131298949, new Object[] { bo.hk(l) }));
      this.gBJ.setEnabled(true);
      if (paramHashSet.size() == this.kId.getCount())
      {
        this.kHX.setChecked(true);
        AppMethodBeat.o(18790);
        return;
      }
      this.kHX.setChecked(false);
      AppMethodBeat.o(18790);
      return;
    }
    this.kIf.setText("");
    this.gBJ.setEnabled(false);
    this.kHX.setChecked(false);
    AppMethodBeat.o(18790);
  }
  
  public final void dY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(18793);
    al.d(new CleanChattingUI.7(this, paramInt1, paramInt2));
    AppMethodBeat.o(18793);
  }
  
  public int getLayoutId()
  {
    return 2130969162;
  }
  
  public final void iv(long paramLong)
  {
    AppMethodBeat.i(18794);
    ab.i("MicroMsg.CleanChattingUI", "%s onDeleteEnd [%d] ", new Object[] { hashCode(), Long.valueOf(paramLong) });
    j.bhb().kGs -= paramLong;
    j.bhb().kGr -= paramLong;
    al.d(new CleanChattingUI.8(this, paramLong));
    AppMethodBeat.o(18794);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(18795);
    long l;
    c localc;
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("key_pos", -1);
      l = paramIntent.getLongExtra("key_delete_size", 0L);
      if ((i >= 0) && (i < this.dataList.size()))
      {
        localc = (c)this.dataList.get(i);
        if (localc != null)
        {
          if (localc.size != l) {
            break label121;
          }
          this.dataList.remove(i);
          this.kId.bhf();
        }
      }
    }
    for (;;)
    {
      this.kId.notifyDataSetChanged();
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(18795);
      return;
      label121:
      localc.size -= l;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(18789);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.CleanChattingUI", "Create!!");
    setMMTitle(2131298387);
    this.kIe = ((ListView)findViewById(2131822842));
    this.kId = new a(this, this.dataList);
    this.kIe.setAdapter(this.kId);
    this.kIe.setEmptyView(findViewById(2131821642));
    this.kIg = ((TextView)$(2131821537));
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
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(714L, 20L, 1L, false);
    AppMethodBeat.o(18789);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(18791);
    if (this.eeN.isShowing()) {
      this.eeN.dismiss();
    }
    super.onDestroy();
    AppMethodBeat.o(18791);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(18792);
    super.onResume();
    if ((this.kId != null) && (this.dataList.isEmpty())) {
      g.RO().ac(new CleanChattingUI.6(this));
    }
    AppMethodBeat.o(18792);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI
 * JD-Core Version:    0.7.0.1
 */