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
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.LinkedList;

public final class a
  extends BaseAdapter
{
  BackupMoveChooseUI oMF;
  HashSet<Integer> oMG;
  
  public a(BackupMoveChooseUI paramBackupMoveChooseUI)
  {
    AppMethodBeat.i(21377);
    this.oMF = paramBackupMoveChooseUI;
    this.oMG = new HashSet();
    AppMethodBeat.o(21377);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(21378);
    LinkedList localLinkedList = com.tencent.mm.plugin.backup.d.b.cfv().cfz().cfr();
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
      paramView = this.oMF.getLayoutInflater().inflate(2131493180, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.gvv = ((ImageView)paramView.findViewById(2131297134));
      paramViewGroup.jVO = ((TextView)paramView.findViewById(2131309249));
      paramViewGroup.jVQ = ((CheckBox)paramView.findViewById(2131307508));
      paramViewGroup.oMI = ((RelativeLayout)paramView.findViewById(2131307509));
      paramView.setTag(paramViewGroup);
    }
    while (paramInt >= getCount())
    {
      Log.e("MicroMsg.BackupMoveChooseAdapter", "getView error, position:%d, count:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
      AppMethodBeat.o(21380);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    f.b localb = (f.b)com.tencent.mm.plugin.backup.d.b.cfv().cfz().cfr().get(paramInt);
    paramViewGroup.oMI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21376);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
    a.b.c(paramViewGroup.gvv, localb.oJq);
    if (ab.Eq(localb.oJq))
    {
      paramViewGroup.jVO.setText(l.b(this.oMF, aa.getDisplayName(localb.oJq, localb.oJq), paramViewGroup.jVO.getTextSize()));
      if (!this.oMG.contains(Integer.valueOf(paramInt))) {
        break label299;
      }
      paramViewGroup.jVQ.setChecked(true);
    }
    for (;;)
    {
      AppMethodBeat.o(21380);
      return paramView;
      paramViewGroup.jVO.setText(l.b(this.oMF, aa.getDisplayName(localb.oJq), paramViewGroup.jVO.getTextSize()));
      break;
      label299:
      paramViewGroup.jVQ.setChecked(false);
    }
  }
  
  final class a
  {
    ImageView gvv;
    TextView jVO;
    CheckBox jVQ;
    RelativeLayout oMI;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.a
 * JD-Core Version:    0.7.0.1
 */