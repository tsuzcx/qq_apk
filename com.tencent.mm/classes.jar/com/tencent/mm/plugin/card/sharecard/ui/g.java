package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import java.util.List;

public final class g
  extends BaseAdapter
{
  c iqd;
  List<b> iqo;
  Context mContext;
  
  public final int getCount()
  {
    return this.iqo.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = oK(paramInt);
    return this.iqd.a(paramInt, paramView, paramViewGroup);
  }
  
  public final b oK(int paramInt)
  {
    return (b)this.iqo.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.g
 * JD-Core Version:    0.7.0.1
 */