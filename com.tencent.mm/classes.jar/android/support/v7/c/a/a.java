package android.support.v7.c.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.b;
import android.support.v7.widget.g;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class a
{
  private static final ThreadLocal<TypedValue> XW = new ThreadLocal();
  private static final WeakHashMap<Context, SparseArray<a>> XX = new WeakHashMap(0);
  private static final Object XY = new Object();
  
  public static Drawable l(Context paramContext, int paramInt)
  {
    return g.iD().l(paramContext, paramInt);
  }
  
  public static ColorStateList m(Context paramContext, int paramInt)
  {
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 23) {
      localObject1 = paramContext.getColorStateList(paramInt);
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject2 = q(paramContext, paramInt);
      localObject1 = localObject2;
    } while (localObject2 != null);
    ColorStateList localColorStateList = p(paramContext, paramInt);
    if (localColorStateList != null) {
      synchronized (XY)
      {
        localObject2 = (SparseArray)XX.get(paramContext);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new SparseArray();
          XX.put(paramContext, localObject1);
        }
        ((SparseArray)localObject1).append(paramInt, new a(localColorStateList, paramContext.getResources().getConfiguration()));
        return localColorStateList;
      }
    }
    return b.m(paramContext, paramInt);
  }
  
  private static ColorStateList p(Context paramContext, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    Object localObject2 = (TypedValue)XW.get();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new TypedValue();
      XW.set(localObject1);
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
      paramContext = android.support.v4.content.a.a.createFromXml((Resources)localObject1, (XmlPullParser)localObject2, paramContext.getTheme());
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  private static ColorStateList q(Context paramContext, int paramInt)
  {
    synchronized (XY)
    {
      SparseArray localSparseArray = (SparseArray)XX.get(paramContext);
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        a locala = (a)localSparseArray.get(paramInt);
        if (locala != null)
        {
          if (locala.Ya.equals(paramContext.getResources().getConfiguration()))
          {
            paramContext = locala.XZ;
            return paramContext;
          }
          localSparseArray.remove(paramInt);
        }
      }
      return null;
    }
  }
  
  static final class a
  {
    final ColorStateList XZ;
    final Configuration Ya;
    
    a(ColorStateList paramColorStateList, Configuration paramConfiguration)
    {
      this.XZ = paramColorStateList;
      this.Ya = paramConfiguration;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.c.a.a
 * JD-Core Version:    0.7.0.1
 */