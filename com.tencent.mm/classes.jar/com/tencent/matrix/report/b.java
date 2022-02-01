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
  private final long cub;
  private final SharedPreferences.Editor cuc;
  private final HashMap<String, Long> cud;
  private final SharedPreferences sharedPreferences;
  
  public b(Context paramContext, String paramString, d.a parama)
  {
    super(parama);
    this.context = paramContext;
    this.cub = 86400000L;
    this.sharedPreferences = paramContext.getSharedPreferences(paramString + com.tencent.matrix.g.d.getProcessName(paramContext), 0);
    this.cud = new HashMap();
    long l1 = System.currentTimeMillis();
    this.cuc = this.sharedPreferences.edit();
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
        if ((l2 <= 0L) || (l1 - l2 > this.cub)) {
          this.cuc.remove(paramString);
        } else {
          this.cud.put(paramString, Long.valueOf(l2));
        }
      }
    }
    if (this.cuc != null) {
      this.cuc.apply();
    }
  }
  
  public final void cL(String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return;
      } while (this.cud.containsKey(paramString));
      long l = System.currentTimeMillis();
      this.cud.put(paramString, Long.valueOf(l));
      paramString = this.cuc.putLong(paramString, l);
    } while (paramString == null);
    paramString.apply();
  }
  
  public final boolean cM(String paramString)
  {
    if (!this.cud.containsKey(paramString)) {
      return false;
    }
    long l = ((Long)this.cud.get(paramString)).longValue();
    if ((l <= 0L) || (System.currentTimeMillis() - l > this.cub))
    {
      SharedPreferences.Editor localEditor = this.cuc.remove(paramString);
      if (localEditor != null) {
        localEditor.apply();
      }
      this.cud.remove(paramString);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.b
 * JD-Core Version:    0.7.0.1
 */