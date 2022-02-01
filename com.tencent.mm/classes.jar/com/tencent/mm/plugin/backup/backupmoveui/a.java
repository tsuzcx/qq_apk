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
  BackupMoveChooseUI rOB;
  HashSet<Integer> rOC;
  
  public a(BackupMoveChooseUI paramBackupMoveChooseUI)
  {
    AppMethodBeat.i(21377);
    this.rOB = paramBackupMoveChooseUI;
    this.rOC = new HashSet();
    AppMethodBeat.o(21377);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(21378);
    LinkedList localLinkedList = com.tencent.mm.plugin.backup.d.b.csI().csM().csE();
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
      localView = this.rOB.getLayoutInflater().inflate(R.i.ebT, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.iZG = ((ImageView)localView.findViewById(R.h.avatar_iv));
      paramViewGroup.mNb = ((TextView)localView.findViewById(R.h.title_tv));
      paramViewGroup.mNd = ((CheckBox)localView.findViewById(R.h.select_cb));
      paramViewGroup.rOE = ((RelativeLayout)localView.findViewById(R.h.dTz));
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
    paramView = (f.b)com.tencent.mm.plugin.backup.d.b.csI().csM().csE().get(paramInt);
    paramViewGroup.rOE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21376);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveChooseAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
    a.b.c(paramViewGroup.iZG, paramView.rLg);
    if (ab.Lj(paramView.rLg))
    {
      paramView = aa.aL(paramView.rLg, paramView.rLg);
      TextView localTextView = paramViewGroup.mNb;
      BackupMoveChooseUI localBackupMoveChooseUI = this.rOB;
      Object localObject = paramView;
      if (paramView == null) {
        localObject = "群聊";
      }
      localTextView.setText(l.b(localBackupMoveChooseUI, (CharSequence)localObject, paramViewGroup.mNb.getTextSize()));
      if (!this.rOC.contains(Integer.valueOf(paramInt))) {
        break label311;
      }
      paramViewGroup.mNd.setChecked(true);
    }
    for (;;)
    {
      AppMethodBeat.o(21380);
      return localView;
      paramView = aa.PJ(paramView.rLg);
      break;
      label311:
      paramViewGroup.mNd.setChecked(false);
    }
  }
  
  final class a
  {
    ImageView iZG;
    TextView mNb;
    CheckBox mNd;
    RelativeLayout rOE;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.a
 * JD-Core Version:    0.7.0.1
 */