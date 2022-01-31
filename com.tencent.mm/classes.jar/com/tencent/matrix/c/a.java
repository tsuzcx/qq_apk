package com.tencent.matrix.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class a
  extends c
{
  private final long boF = 86400000L;
  private final SharedPreferences boG;
  private final SharedPreferences.Editor boH;
  private final HashMap<String, Long> boI;
  
  public a(Context paramContext, String paramString, c.a parama)
  {
    super(parama);
    this.boG = paramContext.getSharedPreferences(paramString + com.tencent.matrix.d.c.ak(paramContext), 0);
    this.boI = new HashMap();
    long l1 = System.currentTimeMillis();
    this.boH = this.boG.edit();
    paramContext = new HashSet(this.boG.getAll().keySet()).iterator();
    while (paramContext.hasNext())
    {
      paramString = (String)paramContext.next();
      long l2 = this.boG.getLong(paramString, 0L);
      if ((l2 <= 0L) || (l1 - l2 > this.boF)) {
        this.boH.remove(paramString);
      } else {
        this.boI.put(paramString, Long.valueOf(l2));
      }
    }
    this.boH.apply();
  }
  
  public final void bx(String paramString)
  {
    if (paramString == null) {}
    while (this.boI.containsKey(paramString)) {
      return;
    }
    long l = System.currentTimeMillis();
    this.boI.put(paramString, Long.valueOf(l));
    this.boH.putLong(paramString, l).apply();
  }
  
  public final boolean by(String paramString)
  {
    if (!this.boI.containsKey(paramString)) {
      return false;
    }
    long l = ((Long)this.boI.get(paramString)).longValue();
    if ((l <= 0L) || (System.currentTimeMillis() - l > this.boF))
    {
      this.boH.remove(paramString).apply();
      this.boI.remove(paramString);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.c.a
 * JD-Core Version:    0.7.0.1
 */