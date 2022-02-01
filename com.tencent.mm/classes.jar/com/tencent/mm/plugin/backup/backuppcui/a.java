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
  static boolean oOP = false;
  HashSet<Integer> oMG;
  BackupPcChooseUI oOO;
  
  public a(BackupPcChooseUI paramBackupPcChooseUI)
  {
    AppMethodBeat.i(21627);
    this.oOO = paramBackupPcChooseUI;
    this.oMG = new HashSet();
    oOP = false;
    AppMethodBeat.o(21627);
  }
  
  private static String getItem(int paramInt)
  {
    AppMethodBeat.i(21629);
    Object localObject = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cfr();
    if (((LinkedList)localObject).get(paramInt) == null)
    {
      AppMethodBeat.o(21629);
      return null;
    }
    localObject = ((f.b)((LinkedList)localObject).get(paramInt)).oJq;
    AppMethodBeat.o(21629);
    return localObject;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(21628);
    LinkedList localLinkedList = com.tencent.mm.plugin.backup.backuppcmodel.b.cga().cge().cfr();
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
      paramView = this.oOO.getLayoutInflater().inflate(2131493175, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.gvv = ((ImageView)paramView.findViewById(2131297134));
      paramViewGroup.jVO = ((TextView)paramView.findViewById(2131309249));
      paramViewGroup.jVQ = ((CheckBox)paramView.findViewById(2131307508));
      paramViewGroup.oMI = ((RelativeLayout)paramView.findViewById(2131307509));
      paramView.setTag(paramViewGroup);
      paramViewGroup.oMI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21626);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/backuppcui/BackupPcChooseAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
      a.b.c(paramViewGroup.gvv, str);
      if (!ab.Eq(str)) {
        break label199;
      }
      paramViewGroup.jVO.setText(l.b(this.oOO, aa.getDisplayName(str, str), paramViewGroup.jVO.getTextSize()));
      label158:
      if (!this.oMG.contains(Integer.valueOf(paramInt))) {
        break label228;
      }
      paramViewGroup.jVQ.setChecked(true);
    }
    for (;;)
    {
      AppMethodBeat.o(21630);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label199:
      paramViewGroup.jVO.setText(l.b(this.oOO, aa.getDisplayName(str), paramViewGroup.jVO.getTextSize()));
      break label158;
      label228:
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
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcui.a
 * JD-Core Version:    0.7.0.1
 */