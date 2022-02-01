package com.tencent.mm.platformtools;

import android.app.Activity;
import com.tencent.mm.an.i;
import java.util.HashSet;
import java.util.Set;

public abstract class c
  implements i
{
  public Activity activity;
  Set<Integer> mDK = new HashSet();
  
  public c(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public final boolean a(ad paramad)
  {
    if (paramad.action == 0) {
      return false;
    }
    switch (paramad.action)
    {
    case 3: 
    default: 
      return false;
    case 1: 
      return b(paramad);
    case 2: 
      return c(paramad);
    case 4: 
      return d(paramad);
    case 5: 
      return e(paramad);
    }
    return f(paramad);
  }
  
  public abstract boolean b(ad paramad);
  
  public abstract boolean c(ad paramad);
  
  public abstract boolean d(ad paramad);
  
  public abstract boolean e(ad paramad);
  
  public abstract boolean f(ad paramad);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.platformtools.c
 * JD-Core Version:    0.7.0.1
 */