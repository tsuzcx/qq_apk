package com.tencent.mm.platformtools;

import android.util.SparseBooleanArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class t
{
  private static ConcurrentHashMap<Integer, a> gjv;
  
  static
  {
    AppMethodBeat.i(58725);
    gjv = new ConcurrentHashMap();
    AppMethodBeat.o(58725);
  }
  
  public static final a a(int paramInt, String paramString, HashMap<Integer, h.d> paramHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(58724);
    if ((!bo.isNullOrNil(paramString)) && (paramHashMap != null)) {}
    int i;
    a locala;
    long l;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      i = paramString.hashCode();
      locala = (a)gjv.get(Integer.valueOf(i));
      if (locala != null) {
        break label198;
      }
      locala = new a(paramString, paramBoolean);
      if (!paramBoolean) {
        break;
      }
      g.RJ();
      l = a.getUin();
      q.bP(true);
      if (locala.b("", paramString, "", l, paramHashMap, true)) {
        break label147;
      }
      paramString = new b((byte)0);
      AppMethodBeat.o(58724);
      throw paramString;
    }
    if (!locala.b(paramString, paramHashMap, false))
    {
      paramString = new b((byte)0);
      AppMethodBeat.o(58724);
      throw paramString;
    }
    label147:
    gjv.put(Integer.valueOf(i), locala);
    for (paramString = locala;; paramString = locala)
    {
      ab.d("MicroMsg.GeneralDBHelper", "addRef %d", new Object[] { Integer.valueOf(paramInt) });
      paramString.gjw.put(paramInt, true);
      AppMethodBeat.o(58724);
      return paramString;
      label198:
      if (paramBoolean == locala.bak) {
        paramBoolean = true;
      }
      for (;;)
      {
        Assert.assertTrue(paramBoolean);
        l = locala.kr(-1L);
        paramString = paramHashMap.values().iterator();
        for (;;)
        {
          if (paramString.hasNext())
          {
            paramHashMap = ((h.d)paramString.next()).getSQLs();
            int j = paramHashMap.length;
            i = 0;
            label264:
            if (i < j)
            {
              Object localObject = paramHashMap[i];
              ab.d("MicroMsg.GeneralDBHelper", "init sql:".concat(String.valueOf(localObject)));
              try
              {
                locala.execSQL(null, localObject);
                i += 1;
                break label264;
                paramBoolean = false;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  Assert.assertTrue("CreateTable failed:[" + localObject + "][" + localException.getMessage() + "]", false);
                }
              }
            }
          }
        }
      }
      locala.nY(l);
    }
  }
  
  public static final class a
    extends h
  {
    public final boolean bak;
    SparseBooleanArray gjw;
    private final String path;
    
    public a(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(58720);
      this.gjw = new SparseBooleanArray();
      ab.d("MicroMsg.GeneralDBHelper", "create db %s", new Object[] { paramString });
      this.bak = paramBoolean;
      this.path = paramString;
      AppMethodBeat.o(58720);
    }
    
    @Deprecated
    public final void closeDB()
    {
      AppMethodBeat.i(58722);
      ab.e("MicroMsg.GeneralDBHelper", "forbid to use this method %s", new Object[] { bo.dtY() });
      if (this.gjw.size() <= 1) {
        super.closeDB();
      }
      AppMethodBeat.o(58722);
    }
    
    @Deprecated
    public final void kr(String paramString)
    {
      AppMethodBeat.i(58723);
      ab.e("MicroMsg.GeneralDBHelper", "forbid to use this method");
      if (this.gjw.size() <= 1) {
        super.kr(paramString);
      }
      AppMethodBeat.o(58723);
    }
    
    public final void mG(int paramInt)
    {
      AppMethodBeat.i(58721);
      ab.d("MicroMsg.GeneralDBHelper", "try close db %d", new Object[] { Integer.valueOf(paramInt) });
      this.gjw.delete(paramInt);
      if (this.gjw.size() <= 0)
      {
        ab.d("MicroMsg.GeneralDBHelper", "close db %d succ", new Object[] { Integer.valueOf(paramInt) });
        super.closeDB();
        t.aol().remove(Integer.valueOf(this.path.hashCode()));
      }
      AppMethodBeat.o(58721);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.t
 * JD-Core Version:    0.7.0.1
 */