package com.tencent.matrix.report;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.e.c;
import com.tencent.matrix.e.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class f
  extends h
{
  private final long eYw;
  private final SharedPreferences.Editor eYx;
  private final HashMap<String, Long> eYy;
  public final Context mContext;
  
  public f(Context paramContext, long paramLong, String paramString, h.a parama)
  {
    super(parama);
    this.mContext = paramContext;
    this.eYw = paramLong;
    paramString = "Matrix_" + paramString + d.getProcessName(paramContext);
    parama = paramContext.getSharedPreferences(paramString, 0);
    this.eYy = new HashMap();
    paramLong = System.currentTimeMillis();
    this.eYx = parama.edit();
    paramContext = null;
    if (parama.getAll() != null) {
      paramContext = new HashSet(parama.getAll().keySet());
    }
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        String str = (String)paramContext.next();
        long l;
        try
        {
          l = parama.getLong(str, 0L);
          if ((l > 0L) && (paramLong - l <= this.eYw)) {
            break label229;
          }
          this.eYx.remove(str);
        }
        catch (ClassCastException localClassCastException)
        {
          c.printErrStackTrace("Matrix.FilePublisher", localClassCastException, "might be polluted - sp: %s, key: %s, value : %s", new Object[] { paramString, str, parama.getAll().get(str) });
        }
        continue;
        label229:
        this.eYy.put(str, Long.valueOf(l));
      }
    }
    if (this.eYx != null) {
      this.eYx.apply();
    }
  }
  
  public final void gX(String paramString)
  {
    m(paramString, true);
  }
  
  public final boolean gY(String paramString)
  {
    if (!this.eYy.containsKey(paramString)) {
      return false;
    }
    long l = ((Long)this.eYy.get(paramString)).longValue();
    if ((l <= 0L) || (System.currentTimeMillis() - l > this.eYw))
    {
      SharedPreferences.Editor localEditor = this.eYx.remove(paramString);
      if (localEditor != null) {
        localEditor.apply();
      }
      this.eYy.remove(paramString);
      return false;
    }
    return true;
  }
  
  public final void m(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {}
    do
    {
      long l;
      do
      {
        do
        {
          return;
        } while (this.eYy.containsKey(paramString));
        l = System.currentTimeMillis();
        this.eYy.put(paramString, Long.valueOf(l));
      } while (!paramBoolean);
      paramString = this.eYx.putLong(paramString, l);
    } while (paramString == null);
    paramString.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.report.f
 * JD-Core Version:    0.7.0.1
 */