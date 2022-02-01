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
  public final Context context;
  private final long cwS;
  private final SharedPreferences.Editor cwT;
  private final HashMap<String, Long> cwU;
  private final SharedPreferences sharedPreferences;
  
  public b(Context paramContext, String paramString, d.a parama)
  {
    super(parama);
    this.context = paramContext;
    this.cwS = 86400000L;
    this.sharedPreferences = paramContext.getSharedPreferences(paramString + com.tencent.matrix.g.d.getProcessName(paramContext), 0);
    this.cwU = new HashMap();
    long l1 = System.currentTimeMillis();
    this.cwT = this.sharedPreferences.edit();
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
        if ((l2 <= 0L) || (l1 - l2 > this.cwS)) {
          this.cwT.remove(paramString);
        } else {
          this.cwU.put(paramString, Long.valueOf(l2));
        }
      }
    }
    if (this.cwT != null) {
      this.cwT.apply();
    }
  }
  
  public final void cW(String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return;
      } while (this.cwU.containsKey(paramString));
      long l = System.currentTimeMillis();
      this.cwU.put(paramString, Long.valueOf(l));
      paramString = this.cwT.putLong(paramString, l);
    } while (paramString == null);
    paramString.apply();
  }
  
  public final boolean cX(String paramString)
  {
    if (!this.cwU.containsKey(paramString)) {
      return false;
    }
    long l = ((Long)this.cwU.get(paramString)).longValue();
    if ((l <= 0L) || (System.currentTimeMillis() - l > this.cwS))
    {
      SharedPreferences.Editor localEditor = this.cwT.remove(paramString);
      if (localEditor != null) {
        localEditor.apply();
      }
      this.cwU.remove(paramString);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.b
 * JD-Core Version:    0.7.0.1
 */