package com.tencent.mm.plugin.backup.backuppcui;

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
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import java.util.HashSet;
import java.util.LinkedList;

public final class a
  extends BaseAdapter
{
  static boolean jEF = false;
  HashSet<Integer> jCr;
  BackupPcChooseUI jEE;
  
  public a(BackupPcChooseUI paramBackupPcChooseUI)
  {
    AppMethodBeat.i(17568);
    this.jEE = paramBackupPcChooseUI;
    this.jCr = new HashSet();
    jEF = false;
    AppMethodBeat.o(17568);
  }
  
  private static String getItem(int paramInt)
  {
    AppMethodBeat.i(17570);
    Object localObject = b.aTX().aUb().aTn();
    if (((LinkedList)localObject).get(paramInt) == null)
    {
      AppMethodBeat.o(17570);
      return null;
    }
    localObject = ((f.b)((LinkedList)localObject).get(paramInt)).jza;
    AppMethodBeat.o(17570);
    return localObject;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(17569);
    LinkedList localLinkedList = b.aTX().aUb().aTn();
    if (localLinkedList != null)
    {
      int i = localLinkedList.size();
      AppMethodBeat.o(17569);
      return i;
    }
    AppMethodBeat.o(17569);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return -1L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(17571);
    String str;
    if (paramView == null)
    {
      paramView = this.jEE.getLayoutInflater().inflate(2130968803, paramViewGroup, false);
      paramViewGroup = new a.a(this);
      paramViewGroup.egq = ((ImageView)paramView.findViewById(2131821210));
      paramViewGroup.gpL = ((TextView)paramView.findViewById(2131821212));
      paramViewGroup.gpN = ((CheckBox)paramView.findViewById(2131821631));
      paramViewGroup.jCu = ((RelativeLayout)paramView.findViewById(2131821630));
      paramView.setTag(paramViewGroup);
      paramViewGroup.jCu.setOnClickListener(new a.1(this, paramInt));
      str = getItem(paramInt);
      a.b.c(paramViewGroup.egq, str);
      if (!t.lA(str)) {
        break label199;
      }
      paramViewGroup.gpL.setText(j.b(this.jEE, s.getDisplayName(str, str), paramViewGroup.gpL.getTextSize()));
      label158:
      if (!this.jCr.contains(Integer.valueOf(paramInt))) {
        break label228;
      }
      paramViewGroup.gpN.setChecked(true);
    }
    for (;;)
    {
      AppMethodBeat.o(17571);
      return paramView;
      paramViewGroup = (a.a)paramView.getTag();
      break;
      label199:
      paramViewGroup.gpL.setText(j.b(this.jEE, s.nE(str), paramViewGroup.gpL.getTextSize()));
      break label158;
      label228:
      paramViewGroup.gpN.setChecked(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.a
 * JD-Core Version:    0.7.0.1
 */