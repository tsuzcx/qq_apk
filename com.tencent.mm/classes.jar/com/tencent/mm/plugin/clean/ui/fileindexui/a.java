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
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashSet;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private List<c> dataList;
  HashSet<Integer> nBH;
  CleanChattingUI pbj;
  
  public a(CleanChattingUI paramCleanChattingUI, List<c> paramList)
  {
    AppMethodBeat.i(22850);
    this.pbj = paramCleanChattingUI;
    this.nBH = new HashSet();
    this.dataList = paramList;
    AppMethodBeat.o(22850);
  }
  
  public final c Bg(int paramInt)
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
  
  public final void cbd()
  {
    AppMethodBeat.i(22854);
    this.nBH.clear();
    this.pbj.a(this.nBH);
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
      paramView = this.pbj.getLayoutInflater().inflate(2131493544, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.fQl = ((ImageView)paramView.findViewById(2131297008));
      paramViewGroup.iYj = ((TextView)paramView.findViewById(2131305948));
      paramViewGroup.iFO = ((TextView)paramView.findViewById(2131299008));
      paramViewGroup.iYl = ((CheckBox)paramView.findViewById(2131304502));
      paramViewGroup.nBJ = ((RelativeLayout)paramView.findViewById(2131304503));
      paramView.setTag(paramViewGroup);
      paramViewGroup.nBJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(22849);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
      c localc2 = Bg(paramInt);
      localc1 = localc2;
      if (localc2 == null)
      {
        ae.e("MicroMsg.CleanChattingAdapter", "get item is null. [%d]", new Object[] { Integer.valueOf(paramInt) });
        localc1 = new c();
        localc1.size = 0L;
        localc1.username = "";
      }
      a.b.c(paramViewGroup.fQl, localc1.username);
      paramViewGroup.iYj.setText(bu.sL(localc1.size));
      if (!x.wb(localc1.username)) {
        break label289;
      }
      paramViewGroup.iFO.setText(k.b(this.pbj, w.getDisplayName(localc1.username, localc1.username), paramViewGroup.iFO.getTextSize()));
      label248:
      if (!this.nBH.contains(Integer.valueOf(paramInt))) {
        break label321;
      }
      paramViewGroup.iYl.setChecked(true);
    }
    for (;;)
    {
      AppMethodBeat.o(22853);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label289:
      paramViewGroup.iFO.setText(k.b(this.pbj, w.zP(localc1.username), paramViewGroup.iFO.getTextSize()));
      break label248;
      label321:
      paramViewGroup.iYl.setChecked(false);
    }
  }
  
  final class a
  {
    ImageView fQl;
    TextView iFO;
    TextView iYj;
    CheckBox iYl;
    RelativeLayout nBJ;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.a
 * JD-Core Version:    0.7.0.1
 */