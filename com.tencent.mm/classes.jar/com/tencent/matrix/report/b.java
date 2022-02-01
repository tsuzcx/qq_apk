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
  private final long cWb;
  private final SharedPreferences.Editor cWc;
  private final HashMap<String, Long> cWd;
  public final Context context;
  private final SharedPreferences sharedPreferences;
  
  public b(Context paramContext, String paramString, d.a parama)
  {
    super(parama);
    this.context = paramContext;
    this.cWb = 86400000L;
    this.sharedPreferences = paramContext.getSharedPreferences(paramString + com.tencent.matrix.g.d.getProcessName(paramContext), 0);
    this.cWd = new HashMap();
    long l1 = System.currentTimeMillis();
    this.cWc = this.sharedPreferences.edit();
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
        if ((l2 <= 0L) || (l1 - l2 > this.cWb)) {
          this.cWc.remove(paramString);
        } else {
          this.cWd.put(paramString, Long.valueOf(l2));
        }
      }
    }
    if (this.cWc != null) {
      this.cWc.apply();
    }
  }
  
  public final void eB(String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return;
      } while (this.cWd.containsKey(paramString));
      long l = System.currentTimeMillis();
      this.cWd.put(paramString, Long.valueOf(l));
      paramString = this.cWc.putLong(paramString, l);
    } while (paramString == null);
    paramString.apply();
  }
  
  public final boolean eC(String paramString)
  {
    if (!this.cWd.containsKey(paramString)) {
      return false;
    }
    long l = ((Long)this.cWd.get(paramString)).longValue();
    if ((l <= 0L) || (System.currentTimeMillis() - l > this.cWb))
    {
      SharedPreferences.Editor localEditor = this.cWc.remove(paramString);
      if (localEditor != null) {
        localEditor.apply();
      }
      this.cWd.remove(paramString);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.report.b
 * JD-Core Version:    0.7.0.1
 */