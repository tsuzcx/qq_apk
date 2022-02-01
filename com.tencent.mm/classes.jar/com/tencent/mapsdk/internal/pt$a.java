package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorLevel;
import java.util.List;

final class pt$a
  extends BaseAdapter
{
  private Context b;
  private List<IndoorLevel> c;
  
  public pt$a(Context paramContext, List<IndoorLevel> paramList)
  {
    this.b = paramList;
    Object localObject;
    this.c = localObject;
  }
  
  public final void a(List<IndoorLevel> paramList)
  {
    AppMethodBeat.i(225746);
    this.c = paramList;
    notifyDataSetChanged();
    AppMethodBeat.o(225746);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(225709);
    if (this.c == null)
    {
      AppMethodBeat.o(225709);
      return 0;
    }
    int i = this.c.size();
    AppMethodBeat.o(225709);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(225714);
    if (this.c == null)
    {
      AppMethodBeat.o(225714);
      return null;
    }
    Object localObject = this.c.get(paramInt);
    AppMethodBeat.o(225714);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(225736);
    if ((this.c == null) || (this.c.size() == 0))
    {
      AppMethodBeat.o(225736);
      return null;
    }
    Object localObject1;
    Object localObject2;
    if (paramView != null)
    {
      localObject1 = (a)paramView.getTag();
      paramViewGroup = ((a)localObject1).a;
      localObject2 = ((a)localObject1).b;
      localObject1 = paramView;
      paramView = (View)localObject2;
      paramViewGroup.setText(((IndoorLevel)this.c.get(paramInt)).getName());
      if (paramInt == pt.g(this.a)) {
        break label397;
      }
      if (!pt.h(this.a)) {
        break label390;
      }
      paramInt = pt.h();
      label108:
      paramViewGroup.setTextColor(paramInt);
      paramView.setVisibility(4);
    }
    for (;;)
    {
      AppMethodBeat.o(225736);
      return localObject1;
      localObject1 = new FrameLayout(this.b);
      paramView = new View(this.b);
      paramViewGroup = new FrameLayout.LayoutParams((int)(pt.e(this.a) * 26.5D), (int)(pt.e(this.a) * 26.5D));
      if (pt.f(this.a) == null)
      {
        pt.a(this.a, new pq());
        pt.f(this.a).setBounds(0, 0, paramViewGroup.width, paramViewGroup.height);
      }
      if (Build.VERSION.SDK_INT < 16) {
        paramView.setBackgroundDrawable(pt.f(this.a));
      }
      for (;;)
      {
        paramViewGroup.gravity = 17;
        ((FrameLayout)localObject1).addView(paramView, paramViewGroup);
        paramViewGroup = new TextView(this.b);
        paramViewGroup.setIncludeFontPadding(false);
        paramViewGroup.setSingleLine();
        paramViewGroup.setGravity(17);
        paramViewGroup.setTextSize(2, 13.0F);
        int i = (int)(10.0D * pt.e(this.a));
        paramViewGroup.setPadding(0, i, 0, i);
        localObject2 = new FrameLayout.LayoutParams(-2, (int)(37.5F * pt.e(this.a)));
        ((FrameLayout.LayoutParams)localObject2).gravity = 17;
        ((FrameLayout)localObject1).addView(paramViewGroup, (ViewGroup.LayoutParams)localObject2);
        ((FrameLayout)localObject1).setTag(new a(paramViewGroup, paramView));
        break;
        paramView.setBackground(pt.f(this.a));
      }
      label390:
      paramInt = pt.i();
      break label108;
      label397:
      pt.h(this.a);
      paramViewGroup.setTextColor(-1);
      paramView.setVisibility(0);
    }
  }
  
  public final class a
  {
    public TextView a;
    public View b;
    
    public a(TextView paramTextView, View paramView)
    {
      this.a = paramTextView;
      this.b = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.pt.a
 * JD-Core Version:    0.7.0.1
 */