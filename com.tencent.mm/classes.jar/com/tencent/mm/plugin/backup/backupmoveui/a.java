package com.tencent.mm.plugin.backup.backupmoveui;

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
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import java.util.HashSet;
import java.util.LinkedList;

public final class a
  extends BaseAdapter
{
  BackupMoveChooseUI mtM;
  HashSet<Integer> mtN;
  
  public a(BackupMoveChooseUI paramBackupMoveChooseUI)
  {
    AppMethodBeat.i(21377);
    this.mtM = paramBackupMoveChooseUI;
    this.mtN = new HashSet();
    AppMethodBeat.o(21377);
  }
  
  private static f.b vZ(int paramInt)
  {
    AppMethodBeat.i(21379);
    f.b localb = (f.b)b.bwC().bwG().bwy().get(paramInt);
    AppMethodBeat.o(21379);
    return localb;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(21378);
    LinkedList localLinkedList = b.bwC().bwG().bwy();
    if (localLinkedList != null)
    {
      int i = localLinkedList.size();
      AppMethodBeat.o(21378);
      return i;
    }
    AppMethodBeat.o(21378);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return -1L;
  }
  
  public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(21380);
    f.b localb;
    if (paramView == null)
    {
      paramView = this.mtM.getLayoutInflater().inflate(2131493137, paramViewGroup, false);
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
          AppMethodBeat.i(21376);
          if (a.a(a.this).contains(Integer.valueOf(paramInt))) {
            a.a(a.this).remove(Integer.valueOf(paramInt));
          }
          for (;;)
          {
            a.this.notifyDataSetChanged();
            a.b(a.this).b(a.a(a.this));
            AppMethodBeat.o(21376);
            return;
            a.a(a.this).add(Integer.valueOf(paramInt));
          }
        }
      });
      localb = vZ(paramInt);
      a.b.c(paramViewGroup.frr, localb.mqx);
      if (!w.pF(localb.mqx)) {
        break label211;
      }
      paramViewGroup.ica.setText(k.b(this.mtM, v.getDisplayName(localb.mqx, localb.mqx), paramViewGroup.ica.getTextSize()));
      label170:
      if (!this.mtN.contains(Integer.valueOf(paramInt))) {
        break label243;
      }
      paramViewGroup.icb.setChecked(true);
    }
    for (;;)
    {
      AppMethodBeat.o(21380);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label211:
      paramViewGroup.ica.setText(k.b(this.mtM, v.sh(localb.mqx), paramViewGroup.ica.getTextSize()));
      break label170;
      label243:
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
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.a
 * JD-Core Version:    0.7.0.1
 */