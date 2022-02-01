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
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashSet;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private List<c> dataList;
  HashSet<Integer> mVP;
  CleanChattingUI ork;
  
  public a(CleanChattingUI paramCleanChattingUI, List<c> paramList)
  {
    AppMethodBeat.i(22850);
    this.ork = paramCleanChattingUI;
    this.mVP = new HashSet();
    this.dataList = paramList;
    AppMethodBeat.o(22850);
  }
  
  public final c Al(int paramInt)
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
  
  public final void bVj()
  {
    AppMethodBeat.i(22854);
    this.mVP.clear();
    this.ork.a(this.mVP);
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
      paramView = this.ork.getLayoutInflater().inflate(2131493544, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.fuY = ((ImageView)paramView.findViewById(2131297008));
      paramViewGroup.iCg = ((TextView)paramView.findViewById(2131305948));
      paramViewGroup.ijE = ((TextView)paramView.findViewById(2131299008));
      paramViewGroup.iCi = ((CheckBox)paramView.findViewById(2131304502));
      paramViewGroup.mVR = ((RelativeLayout)paramView.findViewById(2131304503));
      paramView.setTag(paramViewGroup);
      paramViewGroup.mVR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(22849);
          if (a.a(a.this).contains(Integer.valueOf(paramInt))) {
            a.a(a.this).remove(Integer.valueOf(paramInt));
          }
          for (;;)
          {
            a.this.notifyDataSetChanged();
            a.b(a.this).a(a.a(a.this));
            AppMethodBeat.o(22849);
            return;
            a.a(a.this).add(Integer.valueOf(paramInt));
          }
        }
      });
      c localc2 = Al(paramInt);
      localc1 = localc2;
      if (localc2 == null)
      {
        ac.e("MicroMsg.CleanChattingAdapter", "get item is null. [%d]", new Object[] { Integer.valueOf(paramInt) });
        localc1 = new c();
        localc1.size = 0L;
        localc1.username = "";
      }
      a.b.c(paramViewGroup.fuY, localc1.username);
      paramViewGroup.iCg.setText(bs.qz(localc1.size));
      if (!w.sQ(localc1.username)) {
        break label289;
      }
      paramViewGroup.ijE.setText(k.b(this.ork, v.getDisplayName(localc1.username, localc1.username), paramViewGroup.ijE.getTextSize()));
      label248:
      if (!this.mVP.contains(Integer.valueOf(paramInt))) {
        break label321;
      }
      paramViewGroup.iCi.setChecked(true);
    }
    for (;;)
    {
      AppMethodBeat.o(22853);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label289:
      paramViewGroup.ijE.setText(k.b(this.ork, v.wk(localc1.username), paramViewGroup.ijE.getTextSize()));
      break label248;
      label321:
      paramViewGroup.iCi.setChecked(false);
    }
  }
  
  final class a
  {
    ImageView fuY;
    TextView iCg;
    CheckBox iCi;
    TextView ijE;
    RelativeLayout mVR;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.a
 * JD-Core Version:    0.7.0.1
 */