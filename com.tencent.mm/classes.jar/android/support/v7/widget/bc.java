package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.d;
import java.lang.ref.WeakReference;

public final class bc
  extends Resources
{
  private final WeakReference<Context> alY;
  
  public bc(Context paramContext, Resources paramResources)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    this.alY = new WeakReference(paramContext);
  }
  
  public static boolean je()
  {
    return (d.ei()) && (Build.VERSION.SDK_INT <= 20);
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    Context localContext = (Context)this.alY.get();
    if (localContext != null)
    {
      h localh = h.gi();
      Drawable localDrawable2 = localh.m(localContext, paramInt);
      Drawable localDrawable1 = localDrawable2;
      if (localDrawable2 == null) {
        localDrawable1 = super.getDrawable(paramInt);
      }
      if (localDrawable1 != null) {
        return localh.a(localContext, paramInt, false, localDrawable1);
      }
      return null;
    }
    return super.getDrawable(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.bc
 * JD-Core Version:    0.7.0.1
 */