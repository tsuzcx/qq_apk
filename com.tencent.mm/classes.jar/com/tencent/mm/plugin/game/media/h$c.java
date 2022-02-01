package com.tencent.mm.plugin.game.media;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.h.e;

final class h$c
  extends RecyclerView.v
{
  public TextView IyT;
  public TextView IyU;
  public GameVideoTagContainer IyV;
  public TextView IyW;
  public ImageView IyX;
  public ImageView tUG;
  
  public h$c(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(40989);
    this.IyT = ((TextView)paramView.findViewById(h.e.HXZ));
    this.tUG = ((ImageView)paramView.findViewById(h.e.video_icon));
    this.IyU = ((TextView)paramView.findViewById(h.e.HTQ));
    this.IyV = ((GameVideoTagContainer)paramView.findViewById(h.e.HYk));
    this.IyW = ((TextView)paramView.findViewById(h.e.video_title));
    this.IyX = ((ImageView)paramView.findViewById(h.e.HWH));
    AppMethodBeat.o(40989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.h.c
 * JD-Core Version:    0.7.0.1
 */