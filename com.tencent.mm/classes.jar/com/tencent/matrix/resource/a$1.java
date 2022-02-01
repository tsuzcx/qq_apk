package com.tencent.matrix.resource;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;

final class a$1
  implements View.OnAttachStateChangeListener
{
  public final void onViewAttachedToWindow(View paramView) {}
  
  /* Error */
  public final void onViewDetachedFromWindow(View paramView)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 22	android/view/View:getBackground	()Landroid/graphics/drawable/Drawable;
    //   4: aconst_null
    //   5: invokevirtual 28	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   8: aload_1
    //   9: aconst_null
    //   10: invokevirtual 32	android/view/View:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   13: aload_1
    //   14: invokevirtual 35	android/view/View:destroyDrawingCache	()V
    //   17: aload_1
    //   18: aload_0
    //   19: invokevirtual 39	android/view/View:removeOnAttachStateChangeListener	(Landroid/view/View$OnAttachStateChangeListener;)V
    //   22: return
    //   23: astore_2
    //   24: goto -7 -> 17
    //   27: astore_2
    //   28: goto -15 -> 13
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	1
    //   0	31	1	paramView	View
    //   23	1	2	localObject1	Object
    //   27	1	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   13	17	23	finally
    //   0	13	27	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.matrix.resource.a.1
 * JD-Core Version:    0.7.0.1
 */