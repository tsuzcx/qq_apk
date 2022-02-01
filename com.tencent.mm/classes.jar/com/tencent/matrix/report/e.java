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

public class e
  extends g
{
  private final long cZW;
  private final SharedPreferences.Editor cZX;
  private final HashMap<String, Long> cZY;
  public final Context mContext;
  
  public e(Context paramContext, long paramLong, String paramString, g.a parama)
  {
    super(parama);
    this.mContext = paramContext;
    this.cZW = paramLong;
    paramString = "Matrix_" + paramString + d.getProcessName(paramContext);
    parama = paramContext.getSharedPreferences(paramString, 0);
    this.cZY = new HashMap();
    paramLong = System.currentTimeMillis();
    this.cZX = parama.edit();
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
          if ((l > 0L) && (paramLong - l <= this.cZW)) {
            break label229;
          }
          this.cZX.remove(str);
        }
        catch (ClassCastException localClassCastException)
        {
          c.printErrStackTrace("Matrix.FilePublisher", localClassCastException, "might be polluted - sp: %s, key: %s, value : %s", new Object[] { paramString, str, parama.getAll().get(str) });
        }
        continue;
        label229:
        this.cZY.put(str, Long.valueOf(l));
      }
    }
    if (this.cZX != null) {
      this.cZX.apply();
    }
  }
  
  public final void fw(String paramString)
  {
    m(paramString, true);
  }
  
  public final boolean fx(String paramString)
  {
    if (!this.cZY.containsKey(paramString)) {
      return false;
    }
    long l = ((Long)this.cZY.get(paramString)).longValue();
    if ((l <= 0L) || (System.currentTimeMillis() - l > this.cZW))
    {
      SharedPreferences.Editor localEditor = this.cZX.remove(paramString);
      if (localEditor != null) {
        localEditor.apply();
      }
      this.cZY.remove(paramString);
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
        } while (this.cZY.containsKey(paramString));
        l = System.currentTimeMillis();
        this.cZY.put(paramString, Long.valueOf(l));
      } while (!paramBoolean);
      paramString = this.cZX.putLong(paramString, l);
    } while (paramString == null);
    paramString.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.e
 * JD-Core Version:    0.7.0.1
 */