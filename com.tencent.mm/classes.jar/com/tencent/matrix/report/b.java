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
  private final long cFD;
  private final SharedPreferences.Editor cFE;
  private final HashMap<String, Long> cFF;
  public final Context context;
  private final SharedPreferences sharedPreferences;
  
  public b(Context paramContext, String paramString, d.a parama)
  {
    super(parama);
    this.context = paramContext;
    this.cFD = 86400000L;
    this.sharedPreferences = paramContext.getSharedPreferences(paramString + com.tencent.matrix.g.d.getProcessName(paramContext), 0);
    this.cFF = new HashMap();
    long l1 = System.currentTimeMillis();
    this.cFE = this.sharedPreferences.edit();
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
        if ((l2 <= 0L) || (l1 - l2 > this.cFD)) {
          this.cFE.remove(paramString);
        } else {
          this.cFF.put(paramString, Long.valueOf(l2));
        }
      }
    }
    if (this.cFE != null) {
      this.cFE.apply();
    }
  }
  
  public final void dR(String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return;
      } while (this.cFF.containsKey(paramString));
      long l = System.currentTimeMillis();
      this.cFF.put(paramString, Long.valueOf(l));
      paramString = this.cFE.putLong(paramString, l);
    } while (paramString == null);
    paramString.apply();
  }
  
  public final boolean dS(String paramString)
  {
    if (!this.cFF.containsKey(paramString)) {
      return false;
    }
    long l = ((Long)this.cFF.get(paramString)).longValue();
    if ((l <= 0L) || (System.currentTimeMillis() - l > this.cFD))
    {
      SharedPreferences.Editor localEditor = this.cFE.remove(paramString);
      if (localEditor != null) {
        localEditor.apply();
      }
      this.cFF.remove(paramString);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.b
 * JD-Core Version:    0.7.0.1
 */