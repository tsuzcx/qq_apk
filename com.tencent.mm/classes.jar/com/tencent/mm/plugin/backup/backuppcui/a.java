package com.tencent.mm.plugin.backup.backuppcui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import java.util.HashSet;
import java.util.LinkedList;

public final class a
  extends BaseAdapter
{
  static boolean mvZ = false;
  HashSet<Integer> mtN;
  BackupPcChooseUI mvY;
  
  public a(BackupPcChooseUI paramBackupPcChooseUI)
  {
    AppMethodBeat.i(21627);
    this.mvY = paramBackupPcChooseUI;
    this.mtN = new HashSet();
    mvZ = false;
    AppMethodBeat.o(21627);
  }
  
  private static String getItem(int paramInt)
  {
    AppMethodBeat.i(21629);
    Object localObject = b.bxe().bxi().bwy();
    if (((LinkedList)localObject).get(paramInt) == null)
    {
      AppMethodBeat.o(21629);
      return null;
    }
    localObject = ((f.b)((LinkedList)localObject).get(paramInt)).mqx;
    AppMethodBeat.o(21629);
    return localObject;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(21628);
    LinkedList localLinkedList = b.bxe().bxi().bwy();
    if (localLinkedList != null)
    {
      int i = localLinkedList.size();
      AppMethodBeat.o(21628);
      return i;
    }
    AppMethodBeat.o(21628);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return -1L;
  }
  
  public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(21630);
    String str;
    if (paramView == null)
    {
      paramView = this.mvY.getLayoutInflater().inflate(2131493132, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.frr = ((ImageView)paramView.findViewById(2131297008));
      paramViewGroup.ica = ((TextView)paramView.findViewById(2131305948));
      paramViewGroup.icb = ((CheckBox)paramView.findViewById(2131304502));
      paramViewGroup.mtP = ((RelativeLayout)paramView.findViewById(2131304503));
      paramView.setTag(paramViewGroup);
      paramViewGroup.mtP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21626);
          if (a.a(a.this).contains(Integer.valueOf(paramInt))) {
            a.a(a.this).remove(Integer.valueOf(paramInt));
          }
          for (;;)
          {
            a.this.notifyDataSetChanged();
            a.b(a.this).b(a.a(a.this));
            AppMethodBeat.o(21626);
            return;
            a.a(a.this).add(Integer.valueOf(paramInt));
          }
        }
      });
      str = getItem(paramInt);
      a.b.c(paramViewGroup.frr, str);
      if (!w.pF(str)) {
        break label199;
      }
      paramViewGroup.ica.setText(k.b(this.mvY, v.getDisplayName(str, str), paramViewGroup.ica.getTextSize()));
      label158:
      if (!this.mtN.contains(Integer.valueOf(paramInt))) {
        break label228;
      }
      paramViewGroup.icb.setChecked(true);
    }
    for (;;)
    {
      AppMethodBeat.o(21630);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label199:
      paramViewGroup.ica.setText(k.b(this.mvY, v.sh(str), paramViewGroup.ica.getTextSize()));
      break label158;
      label228:
      paramViewGroup.icb.setChecked(false);
    }
  }
  
  final class a
  {
    ImageView frr;
    TextView ica;
    CheckBox icb;
    RelativeLayout mtP;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.a
 * JD-Core Version:    0.7.0.1
 */