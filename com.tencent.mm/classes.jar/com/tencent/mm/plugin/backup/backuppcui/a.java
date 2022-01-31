package com.tencent.mm.plugin.backup.backuppcui;

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
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import java.util.HashSet;
import java.util.LinkedList;

public final class a
  extends BaseAdapter
{
  static boolean hLc = false;
  HashSet<Integer> hIR;
  BackupPcChooseUI hLb;
  
  public a(BackupPcChooseUI paramBackupPcChooseUI)
  {
    this.hLb = paramBackupPcChooseUI;
    this.hIR = new HashSet();
    hLc = false;
  }
  
  private static String ke(int paramInt)
  {
    LinkedList localLinkedList = b.auw().auA().atP();
    if (localLinkedList.get(paramInt) == null) {
      return null;
    }
    return ((f.b)localLinkedList.get(paramInt)).hFD;
  }
  
  public final int getCount()
  {
    LinkedList localLinkedList = b.auw().auA().atP();
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
    String str;
    if (paramView == null)
    {
      paramView = this.hLb.getLayoutInflater().inflate(R.i.backup_pc_choose_item, paramViewGroup, false);
      paramViewGroup = new a.a(this);
      paramViewGroup.doU = ((ImageView)paramView.findViewById(R.h.avatar_iv));
      paramViewGroup.eXO = ((TextView)paramView.findViewById(R.h.title_tv));
      paramViewGroup.eXQ = ((CheckBox)paramView.findViewById(R.h.select_cb));
      paramViewGroup.hIU = ((RelativeLayout)paramView.findViewById(R.h.select_cb_click_layout));
      paramView.setTag(paramViewGroup);
      paramViewGroup.hIU.setOnClickListener(new a.1(this, paramInt));
      str = ke(paramInt);
      a.b.a(paramViewGroup.doU, str);
      if (!s.fn(str)) {
        break label192;
      }
      paramViewGroup.eXO.setText(j.a(this.hLb, r.getDisplayName(str, str), paramViewGroup.eXO.getTextSize()));
    }
    for (;;)
    {
      if (!this.hIR.contains(Integer.valueOf(paramInt))) {
        break label221;
      }
      paramViewGroup.eXQ.setChecked(true);
      return paramView;
      paramViewGroup = (a.a)paramView.getTag();
      break;
      label192:
      paramViewGroup.eXO.setText(j.a(this.hLb, r.gV(str), paramViewGroup.eXO.getTextSize()));
    }
    label221:
    paramViewGroup.eXQ.setChecked(false);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.a
 * JD-Core Version:    0.7.0.1
 */