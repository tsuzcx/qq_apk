package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;

public class PaddingImageView
  extends FrameLayout
{
  ImageView kPl;
  private int oIA;
  ImageView oIz;
  
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
    this.oIA = a.ao(getContext(), 2131165516);
    this.kPl = new ImageView(paramContext);
    this.kPl.setPadding(this.oIA, this.oIA, this.oIA, this.oIA);
    this.oIz = new ImageView(paramContext);
    AppMethodBeat.o(109411);
  }
  
  public ImageView getImageView()
  {
    return this.kPl;
  }
  
  public ImageView getImageViewFG()
  {
    return this.oIz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.PaddingImageView
 * JD-Core Version:    0.7.0.1
 */