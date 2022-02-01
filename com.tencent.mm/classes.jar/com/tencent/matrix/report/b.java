package com.tencent.matrix.report;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class b
  extends d
{
  private final long cEW;
  private final SharedPreferences.Editor cEX;
  private final HashMap<String, Long> cEY;
  public final Context context;
  private final SharedPreferences sharedPreferences;
  
  public b(Context paramContext, String paramString, d.a parama)
  {
    super(parama);
    this.context = paramContext;
    this.cEW = 86400000L;
    this.sharedPreferences = paramContext.getSharedPreferences(paramString + com.tencent.matrix.g.d.getProcessName(paramContext), 0);
    this.cEY = new HashMap();
    long l1 = System.currentTimeMillis();
    this.cEX = this.sharedPreferences.edit();
    paramContext = null;
    if (this.sharedPreferences.getAll() != null) {
      paramContext = new HashSet(this.sharedPreferences.getAll().keySet());
    }
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        paramString = (String)paramContext.next();
        long l2 = this.sharedPreferences.getLong(paramString, 0L);
        if ((l2 <= 0L) || (l1 - l2 > this.cEW)) {
          this.cEX.remove(paramString);
        } else {
          this.cEY.put(paramString, Long.valueOf(l2));
        }
      }
    }
    if (this.cEX != null) {
      this.cEX.apply();
    }
  }
  
  public final void dO(String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return;
      } while (this.cEY.containsKey(paramString));
      long l = System.currentTimeMillis();
      this.cEY.put(paramString, Long.valueOf(l));
      paramString = this.cEX.putLong(paramString, l);
    } while (paramString == null);
    paramString.apply();
  }
  
  public final boolean dP(String paramString)
  {
    if (!this.cEY.containsKey(paramString)) {
      return false;
    }
    long l = ((Long)this.cEY.get(paramString)).longValue();
    if ((l <= 0L) || (System.currentTimeMillis() - l > this.cEW))
    {
      SharedPreferences.Editor localEditor = this.cEX.remove(paramString);
      if (localEditor != null) {
        localEditor.apply();
      }
      this.cEY.remove(paramString);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.b
 * JD-Core Version:    0.7.0.1
 */