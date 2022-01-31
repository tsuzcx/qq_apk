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
  ImageView ioq;
  ImageView lsg;
  private int lsh;
  
  public PaddingImageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(53836);
    init(paramContext);
    AppMethodBeat.o(53836);
  }
  
  public PaddingImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(53837);
    init(paramContext);
    AppMethodBeat.o(53837);
  }
  
  public PaddingImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(53838);
    init(paramContext);
    AppMethodBeat.o(53838);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(53839);
    this.lsh = a.ao(getContext(), 2131427808);
    this.ioq = new ImageView(paramContext);
    this.ioq.setPadding(this.lsh, this.lsh, this.lsh, this.lsh);
    this.lsg = new ImageView(paramContext);
    AppMethodBeat.o(53839);
  }
  
  public ImageView getImageView()
  {
    return this.ioq;
  }
  
  public ImageView getImageViewFG()
  {
    return this.lsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.PaddingImageView
 * JD-Core Version:    0.7.0.1
 */