package com.tencent.mm.plugin.game.chatroom.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.view.FixAspectRatioImageView;

public class FixAspectRatioAndTopCropImageView
  extends FixAspectRatioImageView
{
  public FixAspectRatioAndTopCropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(210967);
    setScaleType(ImageView.ScaleType.MATRIX);
    AppMethodBeat.o(210967);
  }
  
  public FixAspectRatioAndTopCropImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(210970);
    setScaleType(ImageView.ScaleType.MATRIX);
    AppMethodBeat.o(210970);
  }
  
  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(210973);
    boolean bool;
    if (getDrawable() == null)
    {
      bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(210973);
      return bool;
    }
    Matrix localMatrix = getImageMatrix();
    int i = getWidth() - getPaddingLeft() - getPaddingRight();
    int j = getHeight() - getPaddingTop() - getPaddingBottom();
    int k = getDrawable().getIntrinsicWidth();
    int m = getDrawable().getIntrinsicHeight();
    if (k * j > m * i) {}
    for (float f = j / m;; f = i / k)
    {
      localMatrix.setScale(f, f);
      setImageMatrix(localMatrix);
      bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(210973);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.FixAspectRatioAndTopCropImageView
 * JD-Core Version:    0.7.0.1
 */