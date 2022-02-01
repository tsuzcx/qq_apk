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
  private static boolean yK = false;
  private final WeakReference<Context> mContextRef;
  
  public ah(Context paramContext, Resources paramResources)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    AppMethodBeat.i(199486);
    this.mContextRef = new WeakReference(paramContext);
    AppMethodBeat.o(199486);
  }
  
  public static boolean fE()
  {
    return (yK) && (Build.VERSION.SDK_INT <= 20);
  }
  
  final Drawable aC(int paramInt)
  {
    AppMethodBeat.i(199518);
    Drawable localDrawable = super.getDrawable(paramInt);
    AppMethodBeat.o(199518);
    return localDrawable;
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    AppMethodBeat.i(199506);
    Object localObject = (Context)this.mContextRef.get();
    if (localObject != null)
    {
      localObject = f.ep().a((Context)localObject, this, paramInt);
      AppMethodBeat.o(199506);
      return localObject;
    }
    localObject = super.getDrawable(paramInt);
    AppMethodBeat.o(199506);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.appcompat.widget.ah
 * JD-Core Version:    0.7.0.1
 */