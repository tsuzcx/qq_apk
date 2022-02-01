package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class ah
  extends Resources
{
  private static boolean xP = false;
  private final WeakReference<Context> mContextRef;
  
  public ah(Context paramContext, Resources paramResources)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    AppMethodBeat.i(242485);
    this.mContextRef = new WeakReference(paramContext);
    AppMethodBeat.o(242485);
  }
  
  public static boolean eH()
  {
    return (xP) && (Build.VERSION.SDK_INT <= 20);
  }
  
  final Drawable aF(int paramInt)
  {
    AppMethodBeat.i(242490);
    Drawable localDrawable = super.getDrawable(paramInt);
    AppMethodBeat.o(242490);
    return localDrawable;
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    AppMethodBeat.i(242488);
    Object localObject = (Context)this.mContextRef.get();
    if (localObject != null)
    {
      localObject = f.dq().a((Context)localObject, this, paramInt);
      AppMethodBeat.o(242488);
      return localObject;
    }
    localObject = super.getDrawable(paramInt);
    AppMethodBeat.o(242488);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.appcompat.widget.ah
 * JD-Core Version:    0.7.0.1
 */