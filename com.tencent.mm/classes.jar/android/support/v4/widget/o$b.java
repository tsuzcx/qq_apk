package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

class o$b
  extends o.a
{
  public void a(TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    int i;
    Drawable localDrawable;
    if (paramTextView.getLayoutDirection() == 1)
    {
      i = 1;
      if (i == 0) {
        break label42;
      }
      localDrawable = paramDrawable3;
      label20:
      if (i == 0) {
        break label48;
      }
    }
    for (;;)
    {
      paramTextView.setCompoundDrawables(localDrawable, paramDrawable2, paramDrawable1, paramDrawable4);
      return;
      i = 0;
      break;
      label42:
      localDrawable = paramDrawable1;
      break label20;
      label48:
      paramDrawable1 = paramDrawable3;
    }
  }
  
  public Drawable[] c(TextView paramTextView)
  {
    int i = 1;
    if (paramTextView.getLayoutDirection() == 1) {}
    for (;;)
    {
      paramTextView = paramTextView.getCompoundDrawables();
      if (i != 0)
      {
        Object localObject1 = paramTextView[2];
        Object localObject2 = paramTextView[0];
        paramTextView[0] = localObject1;
        paramTextView[2] = localObject2;
      }
      return paramTextView;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.widget.o.b
 * JD-Core Version:    0.7.0.1
 */