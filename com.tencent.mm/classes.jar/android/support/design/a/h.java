package android.support.design.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.e.n;
import java.util.ArrayList;
import java.util.List;

public final class h
{
  private final n<String, i> ec = new n();
  
  public static h a(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    if (paramTypedArray.hasValue(paramInt))
    {
      paramInt = paramTypedArray.getResourceId(paramInt, 0);
      if (paramInt != 0) {
        return k(paramContext, paramInt);
      }
    }
    return null;
  }
  
  private static void a(h paramh, Animator paramAnimator)
  {
    if ((paramAnimator instanceof ObjectAnimator))
    {
      paramAnimator = (ObjectAnimator)paramAnimator;
      paramh.a(paramAnimator.getPropertyName(), i.a(paramAnimator));
      return;
    }
    throw new IllegalArgumentException("Animator must be an ObjectAnimator: ".concat(String.valueOf(paramAnimator)));
  }
  
  private void a(String paramString, i parami)
  {
    this.ec.put(paramString, parami);
  }
  
  private static h d(List<Animator> paramList)
  {
    h localh = new h();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      a(localh, (Animator)paramList.get(i));
      i += 1;
    }
    return localh;
  }
  
  public static h k(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = AnimatorInflater.loadAnimator(paramContext, paramInt);
      if ((paramContext instanceof AnimatorSet)) {
        return d(((AnimatorSet)paramContext).getChildAnimations());
      }
      if (paramContext != null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramContext);
        paramContext = d(localArrayList);
        return paramContext;
      }
      return null;
    }
    catch (Exception paramContext)
    {
      new StringBuilder("Can't load animation resource ID #0x").append(Integer.toHexString(paramInt));
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (h)paramObject;
    return this.ec.equals(paramObject.ec);
  }
  
  public final long getTotalDuration()
  {
    long l = 0L;
    int j = this.ec.size();
    int i = 0;
    while (i < j)
    {
      i locali = (i)this.ec.valueAt(i);
      l = Math.max(l, locali.ed + locali.duration);
      i += 1;
    }
    return l;
  }
  
  public final int hashCode()
  {
    return this.ec.hashCode();
  }
  
  public final i j(String paramString)
  {
    if (this.ec.get(paramString) != null) {}
    for (int i = 1; i == 0; i = 0) {
      throw new IllegalArgumentException();
    }
    return (i)this.ec.get(paramString);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\n');
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append('{');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" timings: ");
    localStringBuilder.append(this.ec);
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.a.h
 * JD-Core Version:    0.7.0.1
 */