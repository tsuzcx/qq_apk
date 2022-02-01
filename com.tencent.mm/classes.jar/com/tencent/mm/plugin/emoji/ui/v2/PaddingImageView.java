package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.emoji.h.c;

public class PaddingImageView
  extends FrameLayout
{
  ImageView ewg;
  ImageView xZa;
  private int xZb;
  
  public PaddingImageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(109408);
    init(paramContext);
    AppMethodBeat.o(109408);
  }
  
  public PaddingImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109409);
    init(paramContext);
    AppMethodBeat.o(109409);
  }
  
  public PaddingImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109410);
    init(paramContext);
    AppMethodBeat.o(109410);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(109411);
    this.xZb = a.br(getContext(), h.c.NormalPadding);
    this.ewg = new ImageView(paramContext);
    this.ewg.setPadding(this.xZb, this.xZb, this.xZb, this.xZb);
    this.xZa = new ImageView(paramContext);
    AppMethodBeat.o(109411);
  }
  
  public ImageView getImageView()
  {
    return this.ewg;
  }
  
  public ImageView getImageViewFG()
  {
    return this.xZa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.PaddingImageView
 * JD-Core Version:    0.7.0.1
 */