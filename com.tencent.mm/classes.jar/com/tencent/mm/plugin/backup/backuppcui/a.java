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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import java.util.HashSet;
import java.util.LinkedList;

public final class a
  extends BaseAdapter
{
  static boolean rQM = false;
  HashSet<Integer> rOC;
  BackupPcChooseUI rQL;
  
  public a(BackupPcChooseUI paramBackupPcChooseUI)
  {
    AppMethodBeat.i(21627);
    this.rQL = paramBackupPcChooseUI;
    this.rOC = new HashSet();
    rQM = false;
    AppMethodBeat.o(21627);
  }
  
  private static String getItem(int paramInt)
  {
    AppMethodBeat.i(21629);
    Object localObject = com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().csE();
    if (((LinkedList)localObject).get(paramInt) == null)
    {
      AppMethodBeat.o(21629);
      return null;
    }
    localObject = ((f.b)((LinkedList)localObject).get(paramInt)).rLg;
    AppMethodBeat.o(21629);
    return localObject;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(21628);
    LinkedList localLinkedList = com.tencent.mm.plugin.backup.backuppcmodel.b.ctm().ctq().csE();
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
      paramView = this.rQL.getLayoutInflater().inflate(R.i.ebR, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.iZG = ((ImageView)paramView.findViewById(R.h.avatar_iv));
      paramViewGroup.mNb = ((TextView)paramView.findViewById(R.h.title_tv));
      paramViewGroup.mNd = ((CheckBox)paramView.findViewById(R.h.select_cb));
      paramViewGroup.rOE = ((RelativeLayout)paramView.findViewById(R.h.dTz));
      paramView.setTag(paramViewGroup);
      paramViewGroup.rOE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21626);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
      a.b.c(paramViewGroup.iZG, str);
      if (!ab.Lj(str)) {
        break label204;
      }
      paramViewGroup.mNb.setText(l.b(this.rQL, aa.aL(str, str), paramViewGroup.mNb.getTextSize()));
      label163:
      if (!this.rOC.contains(Integer.valueOf(paramInt))) {
        break label233;
      }
      paramViewGroup.mNd.setChecked(true);
    }
    for (;;)
    {
      AppMethodBeat.o(21630);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label204:
      paramViewGroup.mNb.setText(l.b(this.rQL, aa.PJ(str), paramViewGroup.mNb.getTextSize()));
      break label163;
      label233:
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
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.a
 * JD-Core Version:    0.7.0.1
 */