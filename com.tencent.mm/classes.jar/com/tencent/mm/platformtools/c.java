package com.tencent.mm.platformtools;

import android.app.Activity;
import com.tencent.mm.am.h;
import java.util.HashSet;
import java.util.Set;

public abstract class c
  implements h
{
  public Activity activity;
  Set<Integer> pAq = new HashSet();
  
  public c(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public final boolean a(aa paramaa)
  {
    if (paramaa.action == 0) {
      return false;
    }
    switch (paramaa.action)
    {
    case 3: 
    default: 
      return false;
    case 1: 
      return b(paramaa);
    case 2: 
      return c(paramaa);
    case 4: 
      return d(paramaa);
    case 5: 
      return e(paramaa);
    }
    return f(paramaa);
  }
  
  public abstract boolean b(aa paramaa);
  
  public abstract boolean c(aa paramaa);
  
  public abstract boolean d(aa paramaa);
  
  public abstract boolean e(aa paramaa);
  
  public abstract boolean f(aa paramaa);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.c
 * JD-Core Version:    0.7.0.1
 */