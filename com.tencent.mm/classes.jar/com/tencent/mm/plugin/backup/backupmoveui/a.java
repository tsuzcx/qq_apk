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
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashSet;
import java.util.LinkedList;

public final class a
  extends BaseAdapter
{
  BackupMoveChooseUI nwl;
  HashSet<Integer> nwm;
  
  public a(BackupMoveChooseUI paramBackupMoveChooseUI)
  {
    AppMethodBeat.i(21377);
    this.nwl = paramBackupMoveChooseUI;
    this.nwm = new HashSet();
    AppMethodBeat.o(21377);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(21378);
    LinkedList localLinkedList = com.tencent.mm.plugin.backup.d.b.bHG().bHK().bHC();
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
    if (paramView == null)
    {
      paramView = this.nwl.getLayoutInflater().inflate(2131493137, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.fOf = ((ImageView)paramView.findViewById(2131297008));
      paramViewGroup.iVq = ((TextView)paramView.findViewById(2131305948));
      paramViewGroup.iVs = ((CheckBox)paramView.findViewById(2131304502));
      paramViewGroup.nwo = ((RelativeLayout)paramView.findViewById(2131304503));
      paramView.setTag(paramViewGroup);
    }
    while (paramInt >= getCount())
    {
      ad.e("MicroMsg.BackupMoveChooseAdapter", "getView error, position:%d, count:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
      AppMethodBeat.o(21380);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    f.b localb = (f.b)com.tencent.mm.plugin.backup.d.b.bHG().bHK().bHC().get(paramInt);
    paramViewGroup.nwo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21376);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (a.a(a.this).contains(Integer.valueOf(paramInt))) {
          a.a(a.this).remove(Integer.valueOf(paramInt));
        }
        for (;;)
        {
          a.this.notifyDataSetChanged();
          a.b(a.this).a(a.a(a.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(21376);
          return;
          a.a(a.this).add(Integer.valueOf(paramInt));
        }
      }
    });
    a.b.c(paramViewGroup.fOf, localb.nsX);
    if (w.vF(localb.nsX))
    {
      paramViewGroup.iVq.setText(k.b(this.nwl, v.getDisplayName(localb.nsX, localb.nsX), paramViewGroup.iVq.getTextSize()));
      if (!this.nwm.contains(Integer.valueOf(paramInt))) {
        break label299;
      }
      paramViewGroup.iVs.setChecked(true);
    }
    for (;;)
    {
      AppMethodBeat.o(21380);
      return paramView;
      paramViewGroup.iVq.setText(k.b(this.nwl, v.zf(localb.nsX), paramViewGroup.iVq.getTextSize()));
      break;
      label299:
      paramViewGroup.iVs.setChecked(false);
    }
  }
  
  final class a
  {
    ImageView fOf;
    TextView iVq;
    CheckBox iVs;
    RelativeLayout nwo;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.a
 * JD-Core Version:    0.7.0.1
 */