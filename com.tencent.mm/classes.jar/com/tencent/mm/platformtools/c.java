package com.tencent.mm.platformtools;

import android.app.Activity;
import com.tencent.mm.al.f;
import java.util.HashSet;
import java.util.Set;

public abstract class c
  implements f
{
  public Activity activity;
  Set<Integer> iMV = new HashSet();
  
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
    }
    return e(paramae);
  }
  
  public abstract boolean b(ae paramae);
  
  public abstract boolean c(ae paramae);
  
  public abstract boolean d(ae paramae);
  
  public abstract boolean e(ae paramae);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.platformtools.c
 * JD-Core Version:    0.7.0.1
 */