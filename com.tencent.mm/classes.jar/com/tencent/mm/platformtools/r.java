package com.tencent.mm.platformtools;

import android.util.SparseBooleanArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class r
{
  private static ConcurrentHashMap<Integer, a> iQj;
  
  static
  {
    AppMethodBeat.i(132975);
    iQj = new ConcurrentHashMap();
    AppMethodBeat.o(132975);
  }
  
  public static final a a(int paramInt, String paramString, HashMap<Integer, h.b> paramHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(132974);
    if ((!bu.isNullOrNil(paramString)) && (paramHashMap != null)) {}
    int i;
    a locala;
    long l;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      i = paramString.hashCode();
      locala = (a)iQj.get(Integer.valueOf(i));
      if (locala != null) {
        break label198;
      }
      locala = new a(paramString, paramBoolean);
      if (!paramBoolean) {
        break;
      }
      g.ajP();
      l = a.getUin();
      q.cH(true);
      if (locala.b("", paramString, "", l, paramHashMap, true)) {
        break label147;
      }
      paramString = new b((byte)0);
      AppMethodBeat.o(132974);
      throw paramString;
    }
    if (!locala.b(paramString, paramHashMap, false))
    {
      paramString = new b((byte)0);
      AppMethodBeat.o(132974);
      throw paramString;
    }
    label147:
    iQj.put(Integer.valueOf(i), locala);
    for (paramString = locala;; paramString = locala)
    {
      ae.d("MicroMsg.GeneralDBHelper", "addRef %d", new Object[] { Integer.valueOf(paramInt) });
      paramString.iQk.put(paramInt, true);
      AppMethodBeat.o(132974);
      return paramString;
      label198:
      if (paramBoolean == locala.bGj) {
        paramBoolean = true;
      }
      for (;;)
      {
        Assert.assertTrue(paramBoolean);
        l = locala.yi(-1L);
        paramString = paramHashMap.values().iterator();
        for (;;)
        {
          if (paramString.hasNext())
          {
            paramHashMap = ((h.b)paramString.next()).getSQLs();
            int j = paramHashMap.length;
            i = 0;
            label264:
            if (i < j)
            {
              Object localObject = paramHashMap[i];
              ae.d("MicroMsg.GeneralDBHelper", "init sql:".concat(String.valueOf(localObject)));
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
      locala.sW(l);
    }
  }
  
  public static final class a
    extends h
  {
    public final boolean bGj;
    SparseBooleanArray iQk;
    private final String path;
    
    public a(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(132970);
      this.iQk = new SparseBooleanArray();
      ae.d("MicroMsg.GeneralDBHelper", "create db %s", new Object[] { paramString });
      this.bGj = paramBoolean;
      this.path = paramString;
      AppMethodBeat.o(132970);
    }
    
    @Deprecated
    public final void closeDB()
    {
      AppMethodBeat.i(132972);
      ae.e("MicroMsg.GeneralDBHelper", "forbid to use this method %s", new Object[] { bu.fpN() });
      if (this.iQk.size() <= 1) {
        super.closeDB();
      }
      AppMethodBeat.o(132972);
    }
    
    public final void ra(int paramInt)
    {
      AppMethodBeat.i(132971);
      ae.d("MicroMsg.GeneralDBHelper", "try close db %d", new Object[] { Integer.valueOf(paramInt) });
      this.iQk.delete(paramInt);
      if (this.iQk.size() <= 0)
      {
        ae.d("MicroMsg.GeneralDBHelper", "close db %d succ", new Object[] { Integer.valueOf(paramInt) });
        super.closeDB();
        r.aQT().remove(Integer.valueOf(this.path.hashCode()));
      }
      AppMethodBeat.o(132971);
    }
    
    @Deprecated
    public final void uv(String paramString)
    {
      AppMethodBeat.i(132973);
      ae.e("MicroMsg.GeneralDBHelper", "forbid to use this method");
      if (this.iQk.size() <= 1) {
        super.uv(paramString);
      }
      AppMethodBeat.o(132973);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.r
 * JD-Core Version:    0.7.0.1
 */