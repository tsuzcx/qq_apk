package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class AAImagPreviewUI$a
  extends BaseAdapter
{
  private AAImagPreviewUI$a(AAImagPreviewUI paramAAImagPreviewUI) {}
  
  public final int getCount()
  {
    return 1;
  }
  
  public final Object getItem(int paramInt)
  {
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(63485);
    paramView = View.inflate(this.ibz.getContext(), 2131492882, null);
    paramViewGroup = (MultiTouchImageView)paramView.findViewById(2131300914);
    paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
    AAImagPreviewUI.a(this.ibz, paramViewGroup);
    AppMethodBeat.o(63485);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAImagPreviewUI.a
 * JD-Core Version:    0.7.0.1
 */