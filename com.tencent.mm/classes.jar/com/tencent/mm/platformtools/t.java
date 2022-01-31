package com.tencent.mm.platformtools;

import android.util.SparseBooleanArray;
import com.tencent.mm.cf.h;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class t
{
  private static ConcurrentHashMap<Integer, a> eRA = new ConcurrentHashMap();
  
  public static final a a(int paramInt, String paramString, HashMap<Integer, h.d> paramHashMap, boolean paramBoolean)
  {
    if ((!bk.bl(paramString)) && (paramHashMap != null)) {}
    int i;
    a locala;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      i = paramString.hashCode();
      locala = (a)eRA.get(Integer.valueOf(i));
      if (locala != null) {
        break label168;
      }
      locala = new a(paramString, paramBoolean);
      if (!paramBoolean) {
        break;
      }
      g.DN();
      if (locala.a("", paramString, "", a.CK(), q.zf(), paramHashMap, true)) {
        break label122;
      }
      throw new b((byte)0);
    }
    if (!locala.b(paramString, paramHashMap, false)) {
      throw new b((byte)0);
    }
    label122:
    eRA.put(Integer.valueOf(i), locala);
    for (paramString = locala;; paramString = locala)
    {
      y.d("MicroMsg.GeneralDBHelper", "addRef %d", new Object[] { Integer.valueOf(paramInt) });
      paramString.eRC.put(paramInt, true);
      return paramString;
      label168:
      if (paramBoolean == locala.eRB) {
        paramBoolean = true;
      }
      long l;
      for (;;)
      {
        Assert.assertTrue(paramBoolean);
        l = locala.eV(-1L);
        paramString = paramHashMap.values().iterator();
        for (;;)
        {
          if (paramString.hasNext())
          {
            paramHashMap = ((h.d)paramString.next()).rK();
            int j = paramHashMap.length;
            i = 0;
            label234:
            if (i < j)
            {
              String str = paramHashMap[i];
              y.d("MicroMsg.GeneralDBHelper", "init sql:" + str);
              try
              {
                locala.gk(null, str);
                i += 1;
                break label234;
                paramBoolean = false;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  Assert.assertTrue("CreateTable failed:[" + str + "][" + localException.getMessage() + "]", false);
                }
              }
            }
          }
        }
      }
      locala.hI(l);
    }
  }
  
  public static final class a
    extends h
  {
    public final boolean eRB;
    SparseBooleanArray eRC = new SparseBooleanArray();
    private final String path;
    
    public a(String paramString, boolean paramBoolean)
    {
      y.d("MicroMsg.GeneralDBHelper", "create db %s", new Object[] { paramString });
      this.eRB = paramBoolean;
      this.path = paramString;
    }
    
    @Deprecated
    public final void closeDB()
    {
      y.e("MicroMsg.GeneralDBHelper", "forbid to use this method %s", new Object[] { bk.csb() });
      if (this.eRC.size() <= 1) {
        super.closeDB();
      }
    }
    
    @Deprecated
    public final void ek(String paramString)
    {
      y.e("MicroMsg.GeneralDBHelper", "forbid to use this method");
      if (this.eRC.size() <= 1) {
        super.ek(paramString);
      }
    }
    
    public final void jK(int paramInt)
    {
      y.d("MicroMsg.GeneralDBHelper", "try close db %d", new Object[] { Integer.valueOf(paramInt) });
      this.eRC.delete(paramInt);
      if (this.eRC.size() <= 0)
      {
        y.d("MicroMsg.GeneralDBHelper", "close db %d succ", new Object[] { Integer.valueOf(paramInt) });
        super.closeDB();
        t.UM().remove(Integer.valueOf(this.path.hashCode()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.t
 * JD-Core Version:    0.7.0.1
 */