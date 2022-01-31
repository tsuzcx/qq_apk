package com.tencent.mm.plugin.clean.ui.newui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.clean.c.b;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.clean.c.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class CleanChattingUI
  extends MMActivity
  implements com.tencent.mm.plugin.clean.c.h
{
  private ProgressDialog dnm;
  private Button fks;
  private TextView hIX;
  private View iCP;
  private CheckBox iCQ;
  private ListView iCX;
  private TextView iCY;
  private e iEa;
  private a iEd;
  
  public final void a(HashSet<Integer> paramHashSet)
  {
    Object localObject = new HashSet();
    Iterator localIterator = paramHashSet.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      int j = ((Integer)localIterator.next()).intValue();
      if (j < d.aDQ().size())
      {
        long l = i;
        i = (int)(((b)d.aDQ().get(j)).hFz + l);
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
      this.iCY.setText(getString(R.l.delete_info, new Object[] { bk.cm(i) }));
      this.fks.setEnabled(true);
      if (paramHashSet.size() == this.iEd.getCount())
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
    this.dnm.setMessage(getString(R.l.clean_progress_tip, new Object[] { paramInt1 * 100 / paramInt2 + "%" }));
  }
  
  public final void cZ(long paramLong)
  {
    this.dnm.dismiss();
    d.cX(d.aDU() + paramLong);
    d.cU(d.aDR() - paramLong);
    com.tencent.mm.ui.base.h.a(this, getString(R.l.clean_del_data_ok_tip, new Object[] { bk.cm(paramLong) }), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if ((d.aDQ() != null) && (d.aDQ().size() == 0)) {
          CleanChattingUI.this.finish();
        }
      }
    });
  }
  
  protected final int getLayoutId()
  {
    return R.i.clean_chatting_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.iEd.notifyDataSetChanged();
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    d.aDX();
    y.i("MicroMsg.CleanChattingUI", "Create!!");
    setMMTitle(R.l.clean_ui_title);
    this.iCX = ((ListView)findViewById(R.h.clean_chatting_lv));
    this.iEd = new a(this);
    this.iCX.setAdapter(this.iEd);
    this.iCX.setEmptyView(findViewById(R.h.empty_view));
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
    this.iCX.setOnItemClickListener(new CleanChattingUI.2(this));
    this.fks.setOnClickListener(new CleanChattingUI.3(this));
    this.iCP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = CleanChattingUI.b(CleanChattingUI.this);
        if (paramAnonymousView.hIR.size() == paramAnonymousView.getCount()) {
          paramAnonymousView.hIR.clear();
        }
        for (;;)
        {
          paramAnonymousView.notifyDataSetChanged();
          paramAnonymousView.iDU.a(paramAnonymousView.hIR);
          return;
          int i = 0;
          while (i < paramAnonymousView.getCount())
          {
            paramAnonymousView.hIR.add(Integer.valueOf(i));
            i += 1;
          }
        }
      }
    });
    getString(R.l.app_tip);
    this.dnm = com.tencent.mm.ui.base.h.b(this, getString(R.l.clean_del_data), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    this.dnm.dismiss();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanChattingUI
 * JD-Core Version:    0.7.0.1
 */