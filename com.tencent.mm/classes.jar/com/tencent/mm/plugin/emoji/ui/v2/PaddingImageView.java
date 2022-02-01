package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public class PaddingImageView
  extends FrameLayout
{
  ImageView cIN;
  ImageView rnd;
  private int rne;
  
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
    this.rne = a.aG(getContext(), 2131165534);
    this.cIN = new ImageView(paramContext);
    this.cIN.setPadding(this.rne, this.rne, this.rne, this.rne);
    this.rnd = new ImageView(paramContext);
    AppMethodBeat.o(109411);
  }
  
  public ImageView getImageView()
  {
    return this.cIN;
  }
  
  public ImageView getImageViewFG()
  {
    return this.rnd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.PaddingImageView
 * JD-Core Version:    0.7.0.1
 */