package android.support.v7.c.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.widget.h;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class b
{
  private static final ThreadLocal<TypedValue> Rp = new ThreadLocal();
  private static final WeakHashMap<Context, SparseArray<a>> Rq = new WeakHashMap(0);
  private static final Object Rr = new Object();
  
  public static Drawable g(Context paramContext, int paramInt)
  {
    return h.gi().a(paramContext, paramInt, false);
  }
  
  public static ColorStateList h(Context paramContext, int paramInt)
  {
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 23) {
      localObject1 = paramContext.getColorStateList(paramInt);
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject2 = l(paramContext, paramInt);
      localObject1 = localObject2;
    } while (localObject2 != null);
    ColorStateList localColorStateList = k(paramContext, paramInt);
    if (localColorStateList != null) {
      synchronized (Rr)
      {
        localObject2 = (SparseArray)Rq.get(paramContext);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new SparseArray();
          Rq.put(paramContext, localObject1);
        }
        ((SparseArray)localObject1).append(paramInt, new a(localColorStateList, paramContext.getResources().getConfiguration()));
        return localColorStateList;
      }
    }
    return android.support.v4.content.b.h(paramContext, paramInt);
  }
  
  private static ColorStateList k(Context paramContext, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    Object localObject2 = (TypedValue)Rp.get();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new TypedValue();
      Rp.set(localObject1);
    }
    localResources.getValue(paramInt, (TypedValue)localObject1, true);
    if ((((TypedValue)localObject1).type >= 28) && (((TypedValue)localObject1).type <= 31)) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    localObject1 = paramContext.getResources();
    localObject2 = ((Resources)localObject1).getXml(paramInt);
    try
    {
      paramContext = a.createFromXml((Resources)localObject1, (XmlPullParser)localObject2, paramContext.getTheme());
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  private static ColorStateList l(Context paramContext, int paramInt)
  {
    synchronized (Rr)
    {
      SparseArray localSparseArray = (SparseArray)Rq.get(paramContext);
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        a locala = (a)localSparseArray.get(paramInt);
        if (locala != null)
        {
          if (locala.Rt.equals(paramContext.getResources().getConfiguration()))
          {
            paramContext = locala.Rs;
            return paramContext;
          }
          localSparseArray.remove(paramInt);
        }
      }
      return null;
    }
  }
  
  private static final class a
  {
    final ColorStateList Rs;
    final Configuration Rt;
    
    a(ColorStateList paramColorStateList, Configuration paramConfiguration)
    {
      this.Rs = paramColorStateList;
      this.Rt = paramConfiguration;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.c.a.b
 * JD-Core Version:    0.7.0.1
 */