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
  private static final ThreadLocal<TypedValue> jr;
  private static final WeakHashMap<Context, SparseArray<a>> js;
  private static final Object jt;
  
  static
  {
    AppMethodBeat.i(199269);
    jr = new ThreadLocal();
    js = new WeakHashMap(0);
    jt = new Object();
    AppMethodBeat.o(199269);
  }
  
  public static ColorStateList l(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(199250);
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramContext = paramContext.getColorStateList(paramInt);
      AppMethodBeat.o(199250);
      return paramContext;
    }
    Object localObject1 = o(paramContext, paramInt);
    if (localObject1 != null)
    {
      AppMethodBeat.o(199250);
      return localObject1;
    }
    ColorStateList localColorStateList = n(paramContext, paramInt);
    if (localColorStateList != null) {
      synchronized (jt)
      {
        SparseArray localSparseArray = (SparseArray)js.get(paramContext);
        localObject1 = localSparseArray;
        if (localSparseArray == null)
        {
          localObject1 = new SparseArray();
          js.put(paramContext, localObject1);
        }
        ((SparseArray)localObject1).append(paramInt, new a(localColorStateList, paramContext.getResources().getConfiguration()));
        AppMethodBeat.o(199250);
        return localColorStateList;
      }
    }
    paramContext = androidx.core.content.a.l(paramContext, paramInt);
    AppMethodBeat.o(199250);
    return paramContext;
  }
  
  public static Drawable m(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(199259);
    paramContext = f.ep().m(paramContext, paramInt);
    AppMethodBeat.o(199259);
    return paramContext;
  }
  
  private static ColorStateList n(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(199264);
    Resources localResources = paramContext.getResources();
    Object localObject2 = (TypedValue)jr.get();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new TypedValue();
      jr.set(localObject1);
    }
    localResources.getValue(paramInt, (TypedValue)localObject1, true);
    if ((((TypedValue)localObject1).type >= 28) && (((TypedValue)localObject1).type <= 31)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(199264);
      return null;
    }
    localObject1 = paramContext.getResources();
    localObject2 = ((Resources)localObject1).getXml(paramInt);
    try
    {
      paramContext = androidx.core.content.a.a.a((Resources)localObject1, (XmlPullParser)localObject2, paramContext.getTheme());
      AppMethodBeat.o(199264);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(199264);
    }
    return null;
  }
  
  private static ColorStateList o(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(199266);
    synchronized (jt)
    {
      SparseArray localSparseArray = (SparseArray)js.get(paramContext);
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        a locala = (a)localSparseArray.get(paramInt);
        if (locala != null)
        {
          if (locala.jv.equals(paramContext.getResources().getConfiguration()))
          {
            paramContext = locala.ju;
            AppMethodBeat.o(199266);
            return paramContext;
          }
          localSparseArray.remove(paramInt);
        }
      }
      AppMethodBeat.o(199266);
      return null;
    }
  }
  
  static final class a
  {
    final ColorStateList ju;
    final Configuration jv;
    
    a(ColorStateList paramColorStateList, Configuration paramConfiguration)
    {
      this.ju = paramColorStateList;
      this.jv = paramConfiguration;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.appcompat.a.a.a
 * JD-Core Version:    0.7.0.1
 */