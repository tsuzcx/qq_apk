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
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import java.util.HashSet;
import java.util.LinkedList;

public final class a
  extends BaseAdapter
{
  static boolean nyx = false;
  HashSet<Integer> nwm;
  BackupPcChooseUI nyw;
  
  public a(BackupPcChooseUI paramBackupPcChooseUI)
  {
    AppMethodBeat.i(21627);
    this.nyw = paramBackupPcChooseUI;
    this.nwm = new HashSet();
    nyx = false;
    AppMethodBeat.o(21627);
  }
  
  private static String getItem(int paramInt)
  {
    AppMethodBeat.i(21629);
    Object localObject = com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().bHC();
    if (((LinkedList)localObject).get(paramInt) == null)
    {
      AppMethodBeat.o(21629);
      return null;
    }
    localObject = ((f.b)((LinkedList)localObject).get(paramInt)).nsX;
    AppMethodBeat.o(21629);
    return localObject;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(21628);
    LinkedList localLinkedList = com.tencent.mm.plugin.backup.backuppcmodel.b.bIj().bIn().bHC();
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
      paramView = this.nyw.getLayoutInflater().inflate(2131493132, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.fOf = ((ImageView)paramView.findViewById(2131297008));
      paramViewGroup.iVq = ((TextView)paramView.findViewById(2131305948));
      paramViewGroup.iVs = ((CheckBox)paramView.findViewById(2131304502));
      paramViewGroup.nwo = ((RelativeLayout)paramView.findViewById(2131304503));
      paramView.setTag(paramViewGroup);
      paramViewGroup.nwo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21626);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (a.a(a.this).contains(Integer.valueOf(paramInt))) {
            a.a(a.this).remove(Integer.valueOf(paramInt));
          }
          for (;;)
          {
            a.this.notifyDataSetChanged();
            a.b(a.this).a(a.a(a.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21626);
            return;
            a.a(a.this).add(Integer.valueOf(paramInt));
          }
        }
      });
      str = getItem(paramInt);
      a.b.c(paramViewGroup.fOf, str);
      if (!w.vF(str)) {
        break label199;
      }
      paramViewGroup.iVq.setText(k.b(this.nyw, v.getDisplayName(str, str), paramViewGroup.iVq.getTextSize()));
      label158:
      if (!this.nwm.contains(Integer.valueOf(paramInt))) {
        break label228;
      }
      paramViewGroup.iVs.setChecked(true);
    }
    for (;;)
    {
      AppMethodBeat.o(21630);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label199:
      paramViewGroup.iVq.setText(k.b(this.nyw, v.zf(str), paramViewGroup.iVq.getTextSize()));
      break label158;
      label228:
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
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.a
 * JD-Core Version:    0.7.0.1
 */