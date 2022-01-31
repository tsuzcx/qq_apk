package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;

public final class be
  extends Resources
{
  private static boolean apB = false;
  private final WeakReference<Context> aon;
  
  public be(Context paramContext, Resources paramResources)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    this.aon = new WeakReference(paramContext);
  }
  
  public static boolean kZ()
  {
    return (apB) && (Build.VERSION.SDK_INT <= 20);
  }
  
  final Drawable cK(int paramInt)
  {
    return super.getDrawable(paramInt);
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    Context localContext = (Context)this.aon.get();
    if (localContext != null) {
      return g.hg().a(localContext, this, paramInt);
    }
    return super.getDrawable(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.be
 * JD-Core Version:    0.7.0.1
 */