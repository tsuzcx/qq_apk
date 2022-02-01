package com.tencent.mm.plugin.clean.ui.fileindexui;

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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private List<c> dataList;
  HashSet<Integer> oMG;
  CleanChattingUI qqi;
  
  public a(CleanChattingUI paramCleanChattingUI, List<c> paramList)
  {
    AppMethodBeat.i(22850);
    this.qqi = paramCleanChattingUI;
    this.oMG = new HashSet();
    this.dataList = paramList;
    AppMethodBeat.o(22850);
  }
  
  public final c EO(int paramInt)
  {
    AppMethodBeat.i(22852);
    if ((paramInt < 0) || (paramInt >= this.dataList.size()))
    {
      AppMethodBeat.o(22852);
      return null;
    }
    c localc = (c)this.dataList.get(paramInt);
    AppMethodBeat.o(22852);
    return localc;
  }
  
  public final void cyS()
  {
    AppMethodBeat.i(22854);
    this.oMG.clear();
    this.qqi.a(this.oMG);
    AppMethodBeat.o(22854);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(22851);
    int i = this.dataList.size();
    AppMethodBeat.o(22851);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return -1L;
  }
  
  public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22853);
    c localc1;
    if (paramView == null)
    {
      paramView = this.qqi.getLayoutInflater().inflate(2131493656, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.gvv = ((ImageView)paramView.findViewById(2131297134));
      paramViewGroup.jVO = ((TextView)paramView.findViewById(2131309249));
      paramViewGroup.jBR = ((TextView)paramView.findViewById(2131299510));
      paramViewGroup.jVQ = ((CheckBox)paramView.findViewById(2131307508));
      paramViewGroup.oMI = ((RelativeLayout)paramView.findViewById(2131307509));
      paramView.setTag(paramViewGroup);
      paramViewGroup.oMI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(22849);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (a.a(a.this).contains(Integer.valueOf(paramInt))) {
            a.a(a.this).remove(Integer.valueOf(paramInt));
          }
          for (;;)
          {
            a.this.notifyDataSetChanged();
            a.b(a.this).a(a.a(a.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(22849);
            return;
            a.a(a.this).add(Integer.valueOf(paramInt));
          }
        }
      });
      c localc2 = EO(paramInt);
      localc1 = localc2;
      if (localc2 == null)
      {
        Log.e("MicroMsg.CleanChattingAdapter", "get item is null. [%d]", new Object[] { Integer.valueOf(paramInt) });
        localc1 = new c();
        localc1.size = 0L;
        localc1.username = "";
      }
      a.b.c(paramViewGroup.gvv, localc1.username);
      paramViewGroup.jVO.setText(Util.getSizeKB(localc1.size));
      if (!ab.Eq(localc1.username)) {
        break label289;
      }
      paramViewGroup.jBR.setText(l.b(this.qqi, aa.getDisplayName(localc1.username, localc1.username), paramViewGroup.jBR.getTextSize()));
      label248:
      if (!this.oMG.contains(Integer.valueOf(paramInt))) {
        break label321;
      }
      paramViewGroup.jVQ.setChecked(true);
    }
    for (;;)
    {
      AppMethodBeat.o(22853);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label289:
      paramViewGroup.jBR.setText(l.b(this.qqi, aa.getDisplayName(localc1.username), paramViewGroup.jBR.getTextSize()));
      break label248;
      label321:
      paramViewGroup.jVQ.setChecked(false);
    }
  }
  
  final class a
  {
    ImageView gvv;
    TextView jBR;
    TextView jVO;
    CheckBox jVQ;
    RelativeLayout oMI;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.a
 * JD-Core Version:    0.7.0.1
 */