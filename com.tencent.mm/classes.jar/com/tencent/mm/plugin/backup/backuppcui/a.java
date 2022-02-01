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
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.storage.au;
import java.util.HashSet;
import java.util.LinkedList;

public final class a
  extends BaseAdapter
{
  static boolean vcb = false;
  HashSet<Integer> uZQ;
  BackupPcChooseUI vca;
  
  public a(BackupPcChooseUI paramBackupPcChooseUI)
  {
    AppMethodBeat.i(21627);
    this.vca = paramBackupPcChooseUI;
    this.uZQ = new HashSet();
    vcb = false;
    AppMethodBeat.o(21627);
  }
  
  private static String getItem(int paramInt)
  {
    AppMethodBeat.i(21629);
    Object localObject = com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().cVo();
    if (((LinkedList)localObject).get(paramInt) == null)
    {
      AppMethodBeat.o(21629);
      return null;
    }
    localObject = ((f.b)((LinkedList)localObject).get(paramInt)).uWu;
    AppMethodBeat.o(21629);
    return localObject;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(21628);
    LinkedList localLinkedList = com.tencent.mm.plugin.backup.backuppcmodel.b.cVW().cWa().cVo();
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
      paramView = this.vca.getLayoutInflater().inflate(R.i.gez, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.lBC = ((ImageView)paramView.findViewById(R.h.avatar_iv));
      paramViewGroup.pJJ = ((TextView)paramView.findViewById(R.h.title_tv));
      paramViewGroup.pJL = ((CheckBox)paramView.findViewById(R.h.select_cb));
      paramViewGroup.uZS = ((RelativeLayout)paramView.findViewById(R.h.fVG));
      paramView.setTag(paramViewGroup);
      paramViewGroup.uZS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21626);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
      a.b.g(paramViewGroup.lBC, str);
      if (!au.bwE(str)) {
        break label204;
      }
      paramViewGroup.pJJ.setText(p.b(this.vca, aa.aV(str, str), paramViewGroup.pJJ.getTextSize()));
      label163:
      if (!this.uZQ.contains(Integer.valueOf(paramInt))) {
        break label233;
      }
      paramViewGroup.pJL.setChecked(true);
    }
    for (;;)
    {
      AppMethodBeat.o(21630);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label204:
      paramViewGroup.pJJ.setText(p.b(this.vca, aa.getDisplayName(str), paramViewGroup.pJJ.getTextSize()));
      break label163;
      label233:
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
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.a
 * JD-Core Version:    0.7.0.1
 */