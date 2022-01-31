package com.tencent.mm.platformtools;

import android.app.Activity;
import com.tencent.mm.ai.f;
import java.util.HashSet;
import java.util.Set;

public abstract class d
  implements f
{
  public Activity activity;
  Set<Integer> gji = new HashSet();
  
  public d(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public final boolean a(ag paramag)
  {
    if (paramag.action == 0) {
      return false;
    }
    switch (paramag.action)
    {
    case 3: 
    default: 
      return false;
    case 1: 
      return b(paramag);
    case 2: 
      return c(paramag);
    case 4: 
      return d(paramag);
    }
    return e(paramag);
  }
  
  public abstract boolean b(ag paramag);
  
  public abstract boolean c(ag paramag);
  
  public abstract boolean d(ag paramag);
  
  public abstract boolean e(ag paramag);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.platformtools.d
 * JD-Core Version:    0.7.0.1
 */