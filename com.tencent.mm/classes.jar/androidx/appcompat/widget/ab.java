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
    AppMethodBeat.i(199674);
    this.mContextRef = new WeakReference(paramContext);
    AppMethodBeat.o(199674);
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    AppMethodBeat.i(199682);
    Drawable localDrawable = super.getDrawable(paramInt);
    Context localContext = (Context)this.mContextRef.get();
    if ((localDrawable != null) && (localContext != null))
    {
      f.ep();
      f.a(localContext, paramInt, localDrawable);
    }
    AppMethodBeat.o(199682);
    return localDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.appcompat.widget.ab
 * JD-Core Version:    0.7.0.1
 */