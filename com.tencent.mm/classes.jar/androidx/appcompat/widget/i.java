package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.graphics.drawable.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

class i
{
  private static final int[] na = { 16843067, 16843068 };
  private final ProgressBar rS;
  Bitmap rT;
  
  i(ProgressBar paramProgressBar)
  {
    this.rS = paramProgressBar;
  }
  
  private Drawable a(Drawable paramDrawable, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(200042);
    if ((paramDrawable instanceof f))
    {
      localObject1 = ((f)paramDrawable).DN();
      if (localObject1 != null)
      {
        localObject1 = a((Drawable)localObject1, paramBoolean);
        ((f)paramDrawable).v((Drawable)localObject1);
      }
    }
    do
    {
      AppMethodBeat.o(200042);
      return paramDrawable;
      if ((paramDrawable instanceof LayerDrawable))
      {
        paramDrawable = (LayerDrawable)paramDrawable;
        int k = paramDrawable.getNumberOfLayers();
        localObject1 = new Drawable[k];
        int i = 0;
        if (i < k)
        {
          int m = paramDrawable.getId(i);
          localObject2 = paramDrawable.getDrawable(i);
          if ((m == 16908301) || (m == 16908303)) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            localObject1[i] = a((Drawable)localObject2, paramBoolean);
            i += 1;
            break;
          }
        }
        localObject1 = new LayerDrawable((Drawable[])localObject1);
        i = j;
        while (i < k)
        {
          ((LayerDrawable)localObject1).setId(i, paramDrawable.getId(i));
          i += 1;
        }
        AppMethodBeat.o(200042);
        return localObject1;
      }
    } while (!(paramDrawable instanceof BitmapDrawable));
    paramDrawable = (BitmapDrawable)paramDrawable;
    Object localObject2 = paramDrawable.getBitmap();
    if (this.rT == null) {
      this.rT = ((Bitmap)localObject2);
    }
    Object localObject1 = new ShapeDrawable(new RoundRectShape(new float[] { 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F }, null, null));
    localObject2 = new BitmapShader((Bitmap)localObject2, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
    ((ShapeDrawable)localObject1).getPaint().setShader((Shader)localObject2);
    ((ShapeDrawable)localObject1).getPaint().setColorFilter(paramDrawable.getPaint().getColorFilter());
    if (paramBoolean)
    {
      paramDrawable = new ClipDrawable((Drawable)localObject1, 3, 1);
      AppMethodBeat.o(200042);
      return paramDrawable;
    }
    AppMethodBeat.o(200042);
    return localObject1;
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(200062);
    ac localac = ac.a(this.rS.getContext(), paramAttributeSet, na, paramInt, 0);
    Object localObject = localac.ax(0);
    if (localObject != null)
    {
      ProgressBar localProgressBar = this.rS;
      paramAttributeSet = (AttributeSet)localObject;
      if ((localObject instanceof AnimationDrawable))
      {
        localObject = (AnimationDrawable)localObject;
        int i = ((AnimationDrawable)localObject).getNumberOfFrames();
        paramAttributeSet = new AnimationDrawable();
        paramAttributeSet.setOneShot(((AnimationDrawable)localObject).isOneShot());
        paramInt = 0;
        while (paramInt < i)
        {
          Drawable localDrawable = a(((AnimationDrawable)localObject).getFrame(paramInt), true);
          localDrawable.setLevel(10000);
          paramAttributeSet.addFrame(localDrawable, ((AnimationDrawable)localObject).getDuration(paramInt));
          paramInt += 1;
        }
        paramAttributeSet.setLevel(10000);
      }
      localProgressBar.setIndeterminateDrawable(paramAttributeSet);
    }
    paramAttributeSet = localac.ax(1);
    if (paramAttributeSet != null) {
      this.rS.setProgressDrawable(a(paramAttributeSet, false));
    }
    localac.xv.recycle();
    AppMethodBeat.o(200062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.i
 * JD-Core Version:    0.7.0.1
 */