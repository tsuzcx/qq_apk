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
  private final g<String, i> buy;
  
  public h()
  {
    AppMethodBeat.i(234229);
    this.buy = new g();
    AppMethodBeat.o(234229);
  }
  
  public static h a(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    AppMethodBeat.i(234237);
    if (paramTypedArray.hasValue(paramInt))
    {
      paramInt = paramTypedArray.getResourceId(paramInt, 0);
      if (paramInt != 0)
      {
        paramContext = y(paramContext, paramInt);
        AppMethodBeat.o(234237);
        return paramContext;
      }
    }
    AppMethodBeat.o(234237);
    return null;
  }
  
  private static void a(h paramh, Animator paramAnimator)
  {
    AppMethodBeat.i(234242);
    if ((paramAnimator instanceof ObjectAnimator))
    {
      paramAnimator = (ObjectAnimator)paramAnimator;
      paramh.a(paramAnimator.getPropertyName(), i.a(paramAnimator));
      AppMethodBeat.o(234242);
      return;
    }
    paramh = new IllegalArgumentException("Animator must be an ObjectAnimator: ".concat(String.valueOf(paramAnimator)));
    AppMethodBeat.o(234242);
    throw paramh;
  }
  
  private void a(String paramString, i parami)
  {
    AppMethodBeat.i(234233);
    this.buy.put(paramString, parami);
    AppMethodBeat.o(234233);
  }
  
  private static h u(List<Animator> paramList)
  {
    AppMethodBeat.i(234240);
    h localh = new h();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      a(localh, (Animator)paramList.get(i));
      i += 1;
    }
    AppMethodBeat.o(234240);
    return localh;
  }
  
  public static h y(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(234238);
    try
    {
      paramContext = AnimatorInflater.loadAnimator(paramContext, paramInt);
      if ((paramContext instanceof AnimatorSet))
      {
        paramContext = u(((AnimatorSet)paramContext).getChildAnimations());
        AppMethodBeat.o(234238);
        return paramContext;
      }
      if (paramContext != null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramContext);
        paramContext = u(localArrayList);
        AppMethodBeat.o(234238);
        return paramContext;
      }
      AppMethodBeat.o(234238);
      return null;
    }
    catch (Exception paramContext)
    {
      new StringBuilder("Can't load animation resource ID #0x").append(Integer.toHexString(paramInt));
      AppMethodBeat.o(234238);
    }
    return null;
  }
  
  public final i bX(String paramString)
  {
    AppMethodBeat.i(234231);
    if (this.buy.get(paramString) != null) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString = new IllegalArgumentException();
      AppMethodBeat.o(234231);
      throw paramString;
    }
    paramString = (i)this.buy.get(paramString);
    AppMethodBeat.o(234231);
    return paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(234245);
    if (this == paramObject)
    {
      AppMethodBeat.o(234245);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(234245);
      return false;
    }
    paramObject = (h)paramObject;
    boolean bool = this.buy.equals(paramObject.buy);
    AppMethodBeat.o(234245);
    return bool;
  }
  
  public final long getTotalDuration()
  {
    AppMethodBeat.i(234235);
    long l = 0L;
    int j = this.buy.size();
    int i = 0;
    while (i < j)
    {
      i locali = (i)this.buy.aM(i);
      l = Math.max(l, locali.delay + locali.duration);
      i += 1;
    }
    AppMethodBeat.o(234235);
    return l;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(234246);
    int i = this.buy.hashCode();
    AppMethodBeat.o(234246);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(234248);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append('\n');
    ((StringBuilder)localObject).append(getClass().getName());
    ((StringBuilder)localObject).append('{');
    ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this)));
    ((StringBuilder)localObject).append(" timings: ");
    ((StringBuilder)localObject).append(this.buy);
    ((StringBuilder)localObject).append("}\n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(234248);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.a.h
 * JD-Core Version:    0.7.0.1
 */