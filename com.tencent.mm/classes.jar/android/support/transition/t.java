package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

final class t
{
  private static final boolean CR;
  private static final boolean CS;
  private static final boolean CT;
  
  static
  {
    boolean bool2 = true;
    if (Build.VERSION.SDK_INT >= 19)
    {
      bool1 = true;
      CR = bool1;
      if (Build.VERSION.SDK_INT < 18) {
        break label50;
      }
      bool1 = true;
      label26:
      CS = bool1;
      if (Build.VERSION.SDK_INT < 28) {
        break label55;
      }
    }
    label50:
    label55:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      CT = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label26;
    }
  }
  
  static Animator a(Animator paramAnimator1, Animator paramAnimator2)
  {
    if (paramAnimator1 == null) {
      return paramAnimator2;
    }
    if (paramAnimator2 == null) {
      return paramAnimator1;
    }
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { paramAnimator1, paramAnimator2 });
    return localAnimatorSet;
  }
  
  static View a(ViewGroup paramViewGroup, View paramView1, View paramView2)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setTranslate(-paramView2.getScrollX(), -paramView2.getScrollY());
    ag.a(paramView1, localMatrix);
    ag.b(paramViewGroup, localMatrix);
    RectF localRectF = new RectF(0.0F, 0.0F, paramView1.getWidth(), paramView1.getHeight());
    localMatrix.mapRect(localRectF);
    int k = Math.round(localRectF.left);
    int m = Math.round(localRectF.top);
    int n = Math.round(localRectF.right);
    int i1 = Math.round(localRectF.bottom);
    ImageView localImageView = new ImageView(paramView1.getContext());
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    int i;
    boolean bool;
    if (CR) {
      if (!paramView1.isAttachedToWindow())
      {
        i = 1;
        if (paramViewGroup != null) {
          break label232;
        }
        bool = false;
      }
    }
    Object localObject;
    for (;;)
    {
      j = 0;
      if ((!CS) || (i == 0)) {
        break label496;
      }
      if (bool) {
        break label250;
      }
      localObject = null;
      if (localObject != null) {
        localImageView.setImageBitmap((Bitmap)localObject);
      }
      localImageView.measure(View.MeasureSpec.makeMeasureSpec(n - k, 1073741824), View.MeasureSpec.makeMeasureSpec(i1 - m, 1073741824));
      localImageView.layout(k, m, n, i1);
      return localImageView;
      i = 0;
      break;
      label232:
      bool = paramViewGroup.isAttachedToWindow();
      continue;
      i = 0;
      bool = false;
    }
    label250:
    ViewGroup localViewGroup = (ViewGroup)paramView1.getParent();
    int j = localViewGroup.indexOfChild(paramView1);
    paramViewGroup.getOverlay().add(paramView1);
    for (;;)
    {
      localObject = null;
      int i3 = Math.round(localRectF.width());
      int i2 = Math.round(localRectF.height());
      paramView2 = (View)localObject;
      if (i3 > 0)
      {
        paramView2 = (View)localObject;
        if (i2 > 0)
        {
          float f = Math.min(1.0F, 1048576.0F / (i3 * i2));
          i3 = Math.round(i3 * f);
          i2 = Math.round(i2 * f);
          localMatrix.postTranslate(-localRectF.left, -localRectF.top);
          localMatrix.postScale(f, f);
          if (!CT) {
            break label459;
          }
          paramView2 = new Picture();
          localObject = paramView2.beginRecording(i3, i2);
          ((Canvas)localObject).concat(localMatrix);
          paramView1.draw((Canvas)localObject);
          paramView2.endRecording();
          paramView2 = Bitmap.createBitmap(paramView2);
        }
      }
      for (;;)
      {
        localObject = paramView2;
        if (!CS) {
          break;
        }
        localObject = paramView2;
        if (i == 0) {
          break;
        }
        paramViewGroup.getOverlay().remove(paramView1);
        localViewGroup.addView(paramView1, j);
        localObject = paramView2;
        break;
        label459:
        paramView2 = Bitmap.createBitmap(i3, i2, Bitmap.Config.ARGB_8888);
        localObject = new Canvas(paramView2);
        ((Canvas)localObject).concat(localMatrix);
        paramView1.draw((Canvas)localObject);
      }
      label496:
      localViewGroup = null;
    }
  }
  
  static final class a
    implements TypeEvaluator<Matrix>
  {
    final Matrix Av = new Matrix();
    final float[] CU = new float[9];
    final float[] CV = new float[9];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.t
 * JD-Core Version:    0.7.0.1
 */