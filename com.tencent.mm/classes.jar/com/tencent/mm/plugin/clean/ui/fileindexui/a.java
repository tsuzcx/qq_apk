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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import java.util.HashSet;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private List<c> dataList;
  HashSet<Integer> uZQ;
  CleanChattingUI wSg;
  
  public a(CleanChattingUI paramCleanChattingUI, List<c> paramList)
  {
    AppMethodBeat.i(22850);
    this.wSg = paramCleanChattingUI;
    this.uZQ = new HashSet();
    this.dataList = paramList;
    AppMethodBeat.o(22850);
  }
  
  public final c IY(int paramInt)
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
  
  public final void dqT()
  {
    AppMethodBeat.i(22854);
    this.uZQ.clear();
    this.wSg.a(this.uZQ);
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
      paramView = this.wSg.getLayoutInflater().inflate(R.i.ghF, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.lBC = ((ImageView)paramView.findViewById(R.h.avatar_iv));
      paramViewGroup.pJJ = ((TextView)paramView.findViewById(R.h.title_tv));
      paramViewGroup.plr = ((TextView)paramView.findViewById(R.h.desc_tv));
      paramViewGroup.pJL = ((CheckBox)paramView.findViewById(R.h.select_cb));
      paramViewGroup.uZS = ((RelativeLayout)paramView.findViewById(R.h.fVG));
      paramView.setTag(paramViewGroup);
      paramViewGroup.uZS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(22849);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
      c localc2 = IY(paramInt);
      localc1 = localc2;
      if (localc2 == null)
      {
        Log.e("MicroMsg.CleanChattingAdapter", "get item is null. [%d]", new Object[] { Integer.valueOf(paramInt) });
        localc1 = new c();
        localc1.size = 0L;
        localc1.username = "";
      }
      a.b.g(paramViewGroup.lBC, localc1.username);
      paramViewGroup.pJJ.setText(Util.getSizeKB(localc1.size));
      if (!au.bwE(localc1.username)) {
        break label295;
      }
      paramViewGroup.plr.setText(p.b(this.wSg, aa.aV(localc1.username, localc1.username), paramViewGroup.plr.getTextSize()));
      label254:
      if (!this.uZQ.contains(Integer.valueOf(paramInt))) {
        break label327;
      }
      paramViewGroup.pJL.setChecked(true);
    }
    for (;;)
    {
      AppMethodBeat.o(22853);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label295:
      paramViewGroup.plr.setText(p.b(this.wSg, aa.getDisplayName(localc1.username), paramViewGroup.plr.getTextSize()));
      break label254;
      label327:
      paramViewGroup.pJL.setChecked(false);
    }
  }
  
  final class a
  {
    ImageView lBC;
    TextView pJJ;
    CheckBox pJL;
    TextView plr;
    RelativeLayout uZS;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.a
 * JD-Core Version:    0.7.0.1
 */