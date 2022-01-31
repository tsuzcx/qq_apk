package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import java.util.HashSet;
import java.util.LinkedList;

public final class a
  extends BaseAdapter
{
  BackupMoveChooseUI hIQ;
  HashSet<Integer> hIR;
  boolean hIS = false;
  
  public a(BackupMoveChooseUI paramBackupMoveChooseUI)
  {
    this.hIQ = paramBackupMoveChooseUI;
    this.hIR = new HashSet();
    this.hIS = false;
  }
  
  private static f.b nz(int paramInt)
  {
    return (f.b)b.atS().atW().atP().get(paramInt);
  }
  
  public final int getCount()
  {
    LinkedList localLinkedList = b.atS().atW().atP();
    if (localLinkedList != null) {
      return localLinkedList.size();
    }
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return -1L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    f.b localb;
    if (paramView == null)
    {
      paramView = this.hIQ.getLayoutInflater().inflate(R.i.bak_move_choose_item, paramViewGroup, false);
      paramViewGroup = new a.a(this);
      paramViewGroup.doU = ((ImageView)paramView.findViewById(R.h.avatar_iv));
      paramViewGroup.eXO = ((TextView)paramView.findViewById(R.h.title_tv));
      paramViewGroup.eXQ = ((CheckBox)paramView.findViewById(R.h.select_cb));
      paramViewGroup.hIU = ((RelativeLayout)paramView.findViewById(R.h.select_cb_click_layout));
      paramView.setTag(paramViewGroup);
      paramViewGroup.hIU.setOnClickListener(new a.1(this, paramInt));
      localb = nz(paramInt);
      a.b.a(paramViewGroup.doU, localb.hFD);
      if (!s.fn(localb.hFD)) {
        break label204;
      }
      paramViewGroup.eXO.setText(j.a(this.hIQ, r.getDisplayName(localb.hFD, localb.hFD), paramViewGroup.eXO.getTextSize()));
    }
    for (;;)
    {
      if (!this.hIR.contains(Integer.valueOf(paramInt))) {
        break label236;
      }
      paramViewGroup.eXQ.setChecked(true);
      return paramView;
      paramViewGroup = (a.a)paramView.getTag();
      break;
      label204:
      paramViewGroup.eXO.setText(j.a(this.hIQ, r.gV(localb.hFD), paramViewGroup.eXO.getTextSize()));
    }
    label236:
    paramViewGroup.eXQ.setChecked(false);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.a
 * JD-Core Version:    0.7.0.1
 */