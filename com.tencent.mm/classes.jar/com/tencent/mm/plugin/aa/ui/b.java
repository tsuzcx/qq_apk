package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.k;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.w;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends BaseAdapter
{
  private Context context;
  List<k> dataList;
  int mode;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(40715);
    this.dataList = new ArrayList();
    this.context = paramContext;
    this.mode = paramInt;
    AppMethodBeat.o(40715);
  }
  
  public final void aoX()
  {
    AppMethodBeat.i(40719);
    this.dataList.clear();
    AppMethodBeat.o(40719);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(40716);
    int i = this.dataList.size();
    AppMethodBeat.o(40716);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(40717);
    Object localObject = this.dataList.get(paramInt);
    AppMethodBeat.o(40717);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(40718);
    View localView = paramView;
    if (paramView == null)
    {
      localView = w.hM(this.context).inflate(2130968578, paramViewGroup, false);
      localView.setTag(new a(localView));
    }
    a locala = (a)localView.getTag();
    k localk = (k)getItem(paramInt);
    locala.ehv.setImageResource(2131230720);
    a.b.f(locala.ehv, localk.wjX, 2131230720);
    locala.titleTv.setText(j.b(this.context, localk.title, locala.titleTv.getTextSize()));
    paramViewGroup = ((com.tencent.mm.plugin.messenger.a.b)g.E(com.tencent.mm.plugin.messenger.a.b.class)).nE(localk.wjX);
    if (!bo.isNullOrNil(paramViewGroup))
    {
      paramView = paramViewGroup;
      if (!paramViewGroup.endsWith("@chatroom")) {}
    }
    else
    {
      paramView = this.context.getString(2131296344);
    }
    locala.gpo.setText(j.b(this.context, paramView, locala.gpo.getTextSize()));
    if (this.mode == 2)
    {
      locala.gpp.setText(localk.wkj);
      locala.gpq.setText(String.format("%s%s", new Object[] { Float.valueOf((float)localk.cNd / 100.0F), this.context.getString(2131296390) }));
      locala.gpr.setVisibility(0);
      if (this.mode != 2) {
        break label395;
      }
      switch (localk.state)
      {
      default: 
        locala.gpr.setVisibility(4);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(40718);
      return localView;
      locala.gpp.setText(localk.wkg);
      break;
      locala.gpr.setText(2131296364);
      locala.gpr.setTextColor(this.context.getResources().getColor(2131689632));
      continue;
      locala.gpr.setText(2131296362);
      locala.gpr.setTextColor(this.context.getResources().getColor(2131689632));
      continue;
      label395:
      switch (localk.state)
      {
      default: 
        locala.gpr.setVisibility(4);
        break;
      case 1: 
        locala.gpr.setText(2131296363);
        locala.gpr.setTextColor(this.context.getResources().getColor(2131689632));
        break;
      case 2: 
        locala.gpr.setText(2131296361);
        locala.gpr.setTextColor(this.context.getResources().getColor(2131689632));
        break;
      case 3: 
        locala.gpr.setText(2131296359);
        locala.gpr.setTextColor(this.context.getResources().getColor(2131690391));
        break;
      case 4: 
        locala.gpr.setText(2131296360);
        locala.gpr.setTextColor(this.context.getResources().getColor(2131690391));
      }
    }
  }
  
  final class a
  {
    public ImageView ehv;
    public TextView gpo;
    public TextView gpp;
    public TextView gpq;
    public TextView gpr;
    public TextView titleTv;
    
    public a(View paramView)
    {
      AppMethodBeat.i(40714);
      this.ehv = ((ImageView)paramView.findViewById(2131820901));
      this.gpo = ((TextView)paramView.findViewById(2131820903));
      this.titleTv = ((TextView)paramView.findViewById(2131820904));
      this.gpp = ((TextView)paramView.findViewById(2131820905));
      this.gpq = ((TextView)paramView.findViewById(2131820906));
      this.gpr = ((TextView)paramView.findViewById(2131820907));
      AppMethodBeat.o(40714);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.b
 * JD-Core Version:    0.7.0.1
 */