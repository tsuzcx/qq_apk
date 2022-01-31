package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

final class aw
  extends al
{
  private final WeakReference<Context> alY;
  
  public aw(Context paramContext, Resources paramResources)
  {
    super(paramResources);
    this.alY = new WeakReference(paramContext);
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    Drawable localDrawable = super.getDrawable(paramInt);
    Context localContext = (Context)this.alY.get();
    if ((localDrawable != null) && (localContext != null))
    {
      h.gi();
      h.a(localContext, paramInt, localDrawable);
    }
    return localDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.aw
 * JD-Core Version:    0.7.0.1
 */