package com.tencent.mm.plugin.mmsight.segment;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RecyclerThumbSeekBar$e
  extends RecyclerView.v
{
  ImageView cuM;
  
  RecyclerThumbSeekBar$e(RecyclerThumbSeekBar paramRecyclerThumbSeekBar, View paramView, int paramInt)
  {
    super(paramView);
    AppMethodBeat.i(54995);
    if (paramInt == 0) {
      this.cuM = ((ImageView)((LinearLayout)paramView).getChildAt(0));
    }
    AppMethodBeat.o(54995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.e
 * JD-Core Version:    0.7.0.1
 */