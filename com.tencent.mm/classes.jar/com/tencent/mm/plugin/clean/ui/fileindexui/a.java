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
  HashSet<Integer> rOC;
  CleanChattingUI tOQ;
  
  public a(CleanChattingUI paramCleanChattingUI, List<c> paramList)
  {
    AppMethodBeat.i(22850);
    this.tOQ = paramCleanChattingUI;
    this.rOC = new HashSet();
    this.dataList = paramList;
    AppMethodBeat.o(22850);
  }
  
  public final c Iv(int paramInt)
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
  
  public final void cNn()
  {
    AppMethodBeat.i(22854);
    this.rOC.clear();
    this.tOQ.a(this.rOC);
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
      paramView = this.tOQ.getLayoutInflater().inflate(R.i.eeN, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.iZG = ((ImageView)paramView.findViewById(R.h.avatar_iv));
      paramViewGroup.mNb = ((TextView)paramView.findViewById(R.h.title_tv));
      paramViewGroup.mrM = ((TextView)paramView.findViewById(R.h.desc_tv));
      paramViewGroup.mNd = ((CheckBox)paramView.findViewById(R.h.select_cb));
      paramViewGroup.rOE = ((RelativeLayout)paramView.findViewById(R.h.dTz));
      paramView.setTag(paramViewGroup);
      paramViewGroup.rOE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(22849);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
      c localc2 = Iv(paramInt);
      localc1 = localc2;
      if (localc2 == null)
      {
        Log.e("MicroMsg.CleanChattingAdapter", "get item is null. [%d]", new Object[] { Integer.valueOf(paramInt) });
        localc1 = new c();
        localc1.size = 0L;
        localc1.username = "";
      }
      a.b.c(paramViewGroup.iZG, localc1.username);
      paramViewGroup.mNb.setText(Util.getSizeKB(localc1.size));
      if (!ab.Lj(localc1.username)) {
        break label295;
      }
      paramViewGroup.mrM.setText(l.b(this.tOQ, aa.aL(localc1.username, localc1.username), paramViewGroup.mrM.getTextSize()));
      label254:
      if (!this.rOC.contains(Integer.valueOf(paramInt))) {
        break label327;
      }
      paramViewGroup.mNd.setChecked(true);
    }
    for (;;)
    {
      AppMethodBeat.o(22853);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label295:
      paramViewGroup.mrM.setText(l.b(this.tOQ, aa.PJ(localc1.username), paramViewGroup.mrM.getTextSize()));
      break label254;
      label327:
      paramViewGroup.mNd.setChecked(false);
    }
  }
  
  final class a
  {
    ImageView iZG;
    TextView mNb;
    CheckBox mNd;
    TextView mrM;
    RelativeLayout rOE;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.a
 * JD-Core Version:    0.7.0.1
 */