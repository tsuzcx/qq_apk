package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;

public class PaddingImageView
  extends FrameLayout
{
  ImageView lqK;
  ImageView plZ;
  private int pma;
  
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
    this.pma = a.au(getContext(), 2131165516);
    this.lqK = new ImageView(paramContext);
    this.lqK.setPadding(this.pma, this.pma, this.pma, this.pma);
    this.plZ = new ImageView(paramContext);
    AppMethodBeat.o(109411);
  }
  
  public ImageView getImageView()
  {
    return this.lqK;
  }
  
  public ImageView getImageViewFG()
  {
    return this.plZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.PaddingImageView
 * JD-Core Version:    0.7.0.1
 */