package com.google.android.material.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import androidx.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class h
{
  private final g<String, i> dnC;
  
  public h()
  {
    AppMethodBeat.i(209244);
    this.dnC = new g();
    AppMethodBeat.o(209244);
  }
  
  public static h B(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(209266);
    try
    {
      paramContext = AnimatorInflater.loadAnimator(paramContext, paramInt);
      if ((paramContext instanceof AnimatorSet))
      {
        paramContext = an(((AnimatorSet)paramContext).getChildAnimations());
        AppMethodBeat.o(209266);
        return paramContext;
      }
      if (paramContext != null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramContext);
        paramContext = an(localArrayList);
        AppMethodBeat.o(209266);
        return paramContext;
      }
      AppMethodBeat.o(209266);
      return null;
    }
    catch (Exception paramContext)
    {
      new StringBuilder("Can't load animation resource ID #0x").append(Integer.toHexString(paramInt));
      AppMethodBeat.o(209266);
    }
    return null;
  }
  
  public static h a(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    AppMethodBeat.i(209258);
    if (paramTypedArray.hasValue(paramInt))
    {
      paramInt = paramTypedArray.getResourceId(paramInt, 0);
      if (paramInt != 0)
      {
        paramContext = B(paramContext, paramInt);
        AppMethodBeat.o(209258);
        return paramContext;
      }
    }
    AppMethodBeat.o(209258);
    return null;
  }
  
  private static void a(h paramh, Animator paramAnimator)
  {
    AppMethodBeat.i(209283);
    if ((paramAnimator instanceof ObjectAnimator))
    {
      paramAnimator = (ObjectAnimator)paramAnimator;
      paramh.a(paramAnimator.getPropertyName(), i.a(paramAnimator));
      AppMethodBeat.o(209283);
      return;
    }
    paramh = new IllegalArgumentException("Animator must be an ObjectAnimator: ".concat(String.valueOf(paramAnimator)));
    AppMethodBeat.o(209283);
    throw paramh;
  }
  
  private void a(String paramString, i parami)
  {
    AppMethodBeat.i(209252);
    this.dnC.put(paramString, parami);
    AppMethodBeat.o(209252);
  }
  
  private static h an(List<Animator> paramList)
  {
    AppMethodBeat.i(209278);
    h localh = new h();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      a(localh, (Animator)paramList.get(i));
      i += 1;
    }
    AppMethodBeat.o(209278);
    return localh;
  }
  
  public final i dx(String paramString)
  {
    AppMethodBeat.i(209292);
    if (this.dnC.get(paramString) != null) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString = new IllegalArgumentException();
      AppMethodBeat.o(209292);
      throw paramString;
    }
    paramString = (i)this.dnC.get(paramString);
    AppMethodBeat.o(209292);
    return paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(209305);
    if (this == paramObject)
    {
      AppMethodBeat.o(209305);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(209305);
      return false;
    }
    paramObject = (h)paramObject;
    boolean bool = this.dnC.equals(paramObject.dnC);
    AppMethodBeat.o(209305);
    return bool;
  }
  
  public final long getTotalDuration()
  {
    AppMethodBeat.i(209300);
    long l = 0L;
    int j = this.dnC.size();
    int i = 0;
    while (i < j)
    {
      i locali = (i)this.dnC.bl(i);
      l = Math.max(l, locali.delay + locali.duration);
      i += 1;
    }
    AppMethodBeat.o(209300);
    return l;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(209311);
    int i = this.dnC.hashCode();
    AppMethodBeat.o(209311);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(209317);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append('\n');
    ((StringBuilder)localObject).append(getClass().getName());
    ((StringBuilder)localObject).append('{');
    ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this)));
    ((StringBuilder)localObject).append(" timings: ");
    ((StringBuilder)localObject).append(this.dnC);
    ((StringBuilder)localObject).append("}\n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(209317);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.a.h
 * JD-Core Version:    0.7.0.1
 */