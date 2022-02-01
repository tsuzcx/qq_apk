package com.tencent.mm.platformtools;

import android.app.Activity;
import com.tencent.mm.ak.i;
import java.util.HashSet;
import java.util.Set;

public abstract class c
  implements i
{
  public Activity activity;
  Set<Integer> jMC = new HashSet();
  
  public c(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public final boolean a(ae paramae)
  {
    if (paramae.action == 0) {
      return false;
    }
    switch (paramae.action)
    {
    case 3: 
    default: 
      return false;
    case 1: 
      return b(paramae);
    case 2: 
      return c(paramae);
    case 4: 
      return d(paramae);
    case 5: 
      return e(paramae);
    }
    return f(paramae);
  }
  
  public abstract boolean b(ae paramae);
  
  public abstract boolean c(ae paramae);
  
  public abstract boolean d(ae paramae);
  
  public abstract boolean e(ae paramae);
  
  public abstract boolean f(ae paramae);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.platformtools.c
 * JD-Core Version:    0.7.0.1
 */