package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class ab
  extends u
{
  private final WeakReference<Context> mContextRef;
  
  public ab(Context paramContext, Resources paramResources)
  {
    super(paramResources);
    AppMethodBeat.i(242034);
    this.mContextRef = new WeakReference(paramContext);
    AppMethodBeat.o(242034);
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    AppMethodBeat.i(242036);
    Drawable localDrawable = super.getDrawable(paramInt);
    Context localContext = (Context)this.mContextRef.get();
    if ((localDrawable != null) && (localContext != null))
    {
      f.dq();
      f.a(localContext, paramInt, localDrawable);
    }
    AppMethodBeat.o(242036);
    return localDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.appcompat.widget.ab
 * JD-Core Version:    0.7.0.1
 */