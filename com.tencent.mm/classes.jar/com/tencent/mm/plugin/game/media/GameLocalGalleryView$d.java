package com.tencent.mm.plugin.game.media;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.h.e;

final class GameLocalGalleryView$d
  extends RecyclerView.v
{
  View AnN;
  ImageView HLM;
  ImageView HLN;
  ImageView HPW;
  RelativeLayout HPX;
  TextView HPY;
  ImageView HQa;
  CheckBox checkBox;
  
  public GameLocalGalleryView$d(GameLocalGalleryView paramGameLocalGalleryView, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(41015);
    this.HPW = ((ImageView)paramView.findViewById(h.e.media_placeholder));
    this.HLM = ((ImageView)paramView.findViewById(h.e.media_thumb));
    this.HPX = ((RelativeLayout)paramView.findViewById(h.e.video_mask));
    this.HPY = ((TextView)paramView.findViewById(h.e.video_mask_tv));
    this.checkBox = ((CheckBox)paramView.findViewById(h.e.media_cbx));
    this.AnN = paramView.findViewById(h.e.media_cbx_clickarea);
    this.HLN = ((ImageView)paramView.findViewById(h.e.media_mask));
    this.AnN.setTag(h.e.media_cbx, this.checkBox);
    this.AnN.setTag(h.e.media_mask, this.HLN);
    this.HQa = ((ImageView)paramView.findViewById(h.e.edit_mark_iv));
    AppMethodBeat.o(41015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameLocalGalleryView.d
 * JD-Core Version:    0.7.0.1
 */