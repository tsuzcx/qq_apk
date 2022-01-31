package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.emoji.f.c;

public class PaddingImageView
  extends FrameLayout
{
  ImageView jjn;
  ImageView jjo;
  private int jjp;
  
  public PaddingImageView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public PaddingImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public PaddingImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.jjp = a.aa(getContext(), f.c.NormalPadding);
    this.jjn = new ImageView(paramContext);
    this.jjn.setPadding(this.jjp, this.jjp, this.jjp, this.jjp);
    this.jjo = new ImageView(paramContext);
  }
  
  public ImageView getImageView()
  {
    return this.jjn;
  }
  
  public ImageView getImageViewFG()
  {
    return this.jjo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.PaddingImageView
 * JD-Core Version:    0.7.0.1
 */