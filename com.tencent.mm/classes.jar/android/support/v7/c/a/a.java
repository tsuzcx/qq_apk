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
  private static final ThreadLocal<TypedValue> aaT = new ThreadLocal();
  private static final WeakHashMap<Context, SparseArray<a>> aaU = new WeakHashMap(0);
  private static final Object aaV = new Object();
  
  public static Drawable l(Context paramContext, int paramInt)
  {
    return g.jk().l(paramContext, paramInt);
  }
  
  public static ColorStateList m(Context paramContext, @android.support.annotation.a int paramInt)
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
      synchronized (aaV)
      {
        localObject2 = (SparseArray)aaU.get(paramContext);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new SparseArray();
          aaU.put(paramContext, localObject1);
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
    Object localObject2 = (TypedValue)aaT.get();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new TypedValue();
      aaT.set(localObject1);
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
  
  private static ColorStateList q(Context paramContext, @android.support.annotation.a int paramInt)
  {
    synchronized (aaV)
    {
      SparseArray localSparseArray = (SparseArray)aaU.get(paramContext);
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        a locala = (a)localSparseArray.get(paramInt);
        if (locala != null)
        {
          if (locala.aaX.equals(paramContext.getResources().getConfiguration()))
          {
            paramContext = locala.aaW;
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
    final ColorStateList aaW;
    final Configuration aaX;
    
    a(ColorStateList paramColorStateList, Configuration paramConfiguration)
    {
      this.aaW = paramColorStateList;
      this.aaX = paramConfiguration;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.c.a.a
 * JD-Core Version:    0.7.0.1
 */