package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

final class ay
  extends am
{
  private final WeakReference<Context> avO;
  
  public ay(Context paramContext, Resources paramResources)
  {
    super(paramResources);
    this.avO = new WeakReference(paramContext);
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    Drawable localDrawable = super.getDrawable(paramInt);
    Context localContext = (Context)this.avO.get();
    if ((localDrawable != null) && (localContext != null))
    {
      g.iD();
      g.a(localContext, paramInt, localDrawable);
    }
    return localDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ay
 * JD-Core Version:    0.7.0.1
 */