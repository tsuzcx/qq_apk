package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import java.util.HashSet;
import java.util.LinkedList;

public final class a
  extends BaseAdapter
{
  BackupMoveChooseUI jCq;
  HashSet<Integer> jCr;
  boolean jCs;
  
  public a(BackupMoveChooseUI paramBackupMoveChooseUI)
  {
    AppMethodBeat.i(17319);
    this.jCs = false;
    this.jCq = paramBackupMoveChooseUI;
    this.jCr = new HashSet();
    this.jCs = false;
    AppMethodBeat.o(17319);
  }
  
  private static f.b rn(int paramInt)
  {
    AppMethodBeat.i(17321);
    f.b localb = (f.b)b.aTr().aTv().aTn().get(paramInt);
    AppMethodBeat.o(17321);
    return localb;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(17320);
    LinkedList localLinkedList = b.aTr().aTv().aTn();
    if (localLinkedList != null)
    {
      int i = localLinkedList.size();
      AppMethodBeat.o(17320);
      return i;
    }
    AppMethodBeat.o(17320);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return -1L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(17322);
    f.b localb;
    if (paramView == null)
    {
      paramView = this.jCq.getLayoutInflater().inflate(2130968808, paramViewGroup, false);
      paramViewGroup = new a.a(this);
      paramViewGroup.egq = ((ImageView)paramView.findViewById(2131821210));
      paramViewGroup.gpL = ((TextView)paramView.findViewById(2131821212));
      paramViewGroup.gpN = ((CheckBox)paramView.findViewById(2131821631));
      paramViewGroup.jCu = ((RelativeLayout)paramView.findViewById(2131821630));
      paramView.setTag(paramViewGroup);
      paramViewGroup.jCu.setOnClickListener(new a.1(this, paramInt));
      localb = rn(paramInt);
      a.b.c(paramViewGroup.egq, localb.jza);
      if (!t.lA(localb.jza)) {
        break label211;
      }
      paramViewGroup.gpL.setText(j.b(this.jCq, s.getDisplayName(localb.jza, localb.jza), paramViewGroup.gpL.getTextSize()));
      label170:
      if (!this.jCr.contains(Integer.valueOf(paramInt))) {
        break label243;
      }
      paramViewGroup.gpN.setChecked(true);
    }
    for (;;)
    {
      AppMethodBeat.o(17322);
      return paramView;
      paramViewGroup = (a.a)paramView.getTag();
      break;
      label211:
      paramViewGroup.gpL.setText(j.b(this.jCq, s.nE(localb.jza), paramViewGroup.gpL.getTextSize()));
      break label170;
      label243:
      paramViewGroup.gpN.setChecked(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.a
 * JD-Core Version:    0.7.0.1
 */