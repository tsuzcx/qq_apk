package androidx.appcompat.a.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class a
{
  private static final ThreadLocal<TypedValue> iw;
  private static final WeakHashMap<Context, SparseArray<a>> ix;
  private static final Object iy;
  
  static
  {
    AppMethodBeat.i(238627);
    iw = new ThreadLocal();
    ix = new WeakHashMap(0);
    iy = new Object();
    AppMethodBeat.o(238627);
  }
  
  public static ColorStateList l(Context paramContext, @androidx.annotation.a int paramInt)
  {
    AppMethodBeat.i(238619);
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramContext = paramContext.getColorStateList(paramInt);
      AppMethodBeat.o(238619);
      return paramContext;
    }
    Object localObject1 = o(paramContext, paramInt);
    if (localObject1 != null)
    {
      AppMethodBeat.o(238619);
      return localObject1;
    }
    ColorStateList localColorStateList = n(paramContext, paramInt);
    if (localColorStateList != null) {
      synchronized (iy)
      {
        SparseArray localSparseArray = (SparseArray)ix.get(paramContext);
        localObject1 = localSparseArray;
        if (localSparseArray == null)
        {
          localObject1 = new SparseArray();
          ix.put(paramContext, localObject1);
        }
        ((SparseArray)localObject1).append(paramInt, new a(localColorStateList, paramContext.getResources().getConfiguration()));
        AppMethodBeat.o(238619);
        return localColorStateList;
      }
    }
    paramContext = androidx.core.content.a.l(paramContext, paramInt);
    AppMethodBeat.o(238619);
    return paramContext;
  }
  
  public static Drawable m(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(238622);
    paramContext = f.dq().m(paramContext, paramInt);
    AppMethodBeat.o(238622);
    return paramContext;
  }
  
  private static ColorStateList n(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(238624);
    Resources localResources = paramContext.getResources();
    Object localObject2 = (TypedValue)iw.get();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new TypedValue();
      iw.set(localObject1);
    }
    localResources.getValue(paramInt, (TypedValue)localObject1, true);
    if ((((TypedValue)localObject1).type >= 28) && (((TypedValue)localObject1).type <= 31)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(238624);
      return null;
    }
    localObject1 = paramContext.getResources();
    localObject2 = ((Resources)localObject1).getXml(paramInt);
    try
    {
      paramContext = androidx.core.content.a.a.a((Resources)localObject1, (XmlPullParser)localObject2, paramContext.getTheme());
      AppMethodBeat.o(238624);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(238624);
    }
    return null;
  }
  
  private static ColorStateList o(Context paramContext, @androidx.annotation.a int paramInt)
  {
    AppMethodBeat.i(238626);
    synchronized (iy)
    {
      SparseArray localSparseArray = (SparseArray)ix.get(paramContext);
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        a locala = (a)localSparseArray.get(paramInt);
        if (locala != null)
        {
          if (locala.iA.equals(paramContext.getResources().getConfiguration()))
          {
            paramContext = locala.iz;
            AppMethodBeat.o(238626);
            return paramContext;
          }
          localSparseArray.remove(paramInt);
        }
      }
      AppMethodBeat.o(238626);
      return null;
    }
  }
  
  static final class a
  {
    final Configuration iA;
    final ColorStateList iz;
    
    a(ColorStateList paramColorStateList, Configuration paramConfiguration)
    {
      this.iz = paramColorStateList;
      this.iA = paramConfiguration;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.appcompat.a.a.a
 * JD-Core Version:    0.7.0.1
 */