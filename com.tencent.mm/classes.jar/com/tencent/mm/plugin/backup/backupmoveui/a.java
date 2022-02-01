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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import java.util.HashSet;
import java.util.LinkedList;

public final class a
  extends BaseAdapter
{
  BackupMoveChooseUI uZP;
  HashSet<Integer> uZQ;
  
  public a(BackupMoveChooseUI paramBackupMoveChooseUI)
  {
    AppMethodBeat.i(21377);
    this.uZP = paramBackupMoveChooseUI;
    this.uZQ = new HashSet();
    AppMethodBeat.o(21377);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(21378);
    LinkedList localLinkedList = com.tencent.mm.plugin.backup.d.b.cVs().cVw().cVo();
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
    View localView;
    if (paramView == null)
    {
      localView = this.uZP.getLayoutInflater().inflate(R.i.geB, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.lBC = ((ImageView)localView.findViewById(R.h.avatar_iv));
      paramViewGroup.pJJ = ((TextView)localView.findViewById(R.h.title_tv));
      paramViewGroup.pJL = ((CheckBox)localView.findViewById(R.h.select_cb));
      paramViewGroup.uZS = ((RelativeLayout)localView.findViewById(R.h.fVG));
      localView.setTag(paramViewGroup);
    }
    while (paramInt >= getCount())
    {
      Log.e("MicroMsg.BackupMoveChooseAdapter", "getView error, position:%d, count:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
      AppMethodBeat.o(21380);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
    paramView = (f.b)com.tencent.mm.plugin.backup.d.b.cVs().cVw().cVo().get(paramInt);
    paramViewGroup.uZS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21376);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
    a.b.g(paramViewGroup.lBC, paramView.uWu);
    if (au.bwE(paramView.uWu))
    {
      paramView = aa.aV(paramView.uWu, paramView.uWu);
      TextView localTextView = paramViewGroup.pJJ;
      BackupMoveChooseUI localBackupMoveChooseUI = this.uZP;
      Object localObject = paramView;
      if (paramView == null) {
        localObject = "群聊";
      }
      localTextView.setText(p.b(localBackupMoveChooseUI, (CharSequence)localObject, paramViewGroup.pJJ.getTextSize()));
      if (!this.uZQ.contains(Integer.valueOf(paramInt))) {
        break label311;
      }
      paramViewGroup.pJL.setChecked(true);
    }
    for (;;)
    {
      AppMethodBeat.o(21380);
      return localView;
      paramView = aa.getDisplayName(paramView.uWu);
      break;
      label311:
      paramViewGroup.pJL.setChecked(false);
    }
  }
  
  final class a
  {
    ImageView lBC;
    TextView pJJ;
    CheckBox pJL;
    RelativeLayout uZS;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.a
 * JD-Core Version:    0.7.0.1
 */