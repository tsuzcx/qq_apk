package com.tencent.matrix.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.g.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class a
  extends c
{
  private final long bOt = 86400000L;
  private final SharedPreferences.Editor bOu;
  private final HashMap<String, Long> bOv;
  private final SharedPreferences sharedPreferences;
  
  public a(Context paramContext, String paramString, c.a parama)
  {
    super(parama);
    this.sharedPreferences = paramContext.getSharedPreferences(paramString + d.aI(paramContext), 0);
    this.bOv = new HashMap();
    long l1 = System.currentTimeMillis();
    this.bOu = this.sharedPreferences.edit();
    paramContext = new HashSet(this.sharedPreferences.getAll().keySet()).iterator();
    while (paramContext.hasNext())
    {
      paramString = (String)paramContext.next();
      long l2 = this.sharedPreferences.getLong(paramString, 0L);
      if ((l2 <= 0L) || (l1 - l2 > this.bOt)) {
        this.bOu.remove(paramString);
      } else {
        this.bOv.put(paramString, Long.valueOf(l2));
      }
    }
    this.bOu.apply();
  }
  
  public final boolean cA(String paramString)
  {
    if (!this.bOv.containsKey(paramString)) {
      return false;
    }
    long l = ((Long)this.bOv.get(paramString)).longValue();
    if ((l <= 0L) || (System.currentTimeMillis() - l > this.bOt))
    {
      this.bOu.remove(paramString).apply();
      this.bOv.remove(paramString);
      return false;
    }
    return true;
  }
  
  public final void cz(String paramString)
  {
    if (paramString == null) {}
    while (this.bOv.containsKey(paramString)) {
      return;
    }
    long l = System.currentTimeMillis();
    this.bOv.put(paramString, Long.valueOf(l));
    this.bOu.putLong(paramString, l).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.e.a
 * JD-Core Version:    0.7.0.1
 */