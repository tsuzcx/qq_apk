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
  ImageView cum;
  private int pPA;
  ImageView pPz;
  
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
    this.pPA = a.ax(getContext(), 2131165516);
    this.cum = new ImageView(paramContext);
    this.cum.setPadding(this.pPA, this.pPA, this.pPA, this.pPA);
    this.pPz = new ImageView(paramContext);
    AppMethodBeat.o(109411);
  }
  
  public ImageView getImageView()
  {
    return this.cum;
  }
  
  public ImageView getImageViewFG()
  {
    return this.pPz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.PaddingImageView
 * JD-Core Version:    0.7.0.1
 */