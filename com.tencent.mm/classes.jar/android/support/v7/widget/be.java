package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;

public final class be
  extends Resources
{
  private static boolean axd = false;
  private final WeakReference<Context> avO;
  
  public be(Context paramContext, Resources paramResources)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    this.avO = new WeakReference(paramContext);
  }
  
  public static boolean mG()
  {
    return (axd) && (Build.VERSION.SDK_INT <= 20);
  }
  
  final Drawable df(int paramInt)
  {
    return super.getDrawable(paramInt);
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    Context localContext = (Context)this.avO.get();
    if (localContext != null) {
      return g.iD().a(localContext, this, paramInt);
    }
    return super.getDrawable(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.be
 * JD-Core Version:    0.7.0.1
 */