package com.tencent.mm.platformtools;

import android.util.SparseBooleanArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class r
{
  private static ConcurrentHashMap<Integer, a> hUi;
  
  static
  {
    AppMethodBeat.i(132975);
    hUi = new ConcurrentHashMap();
    AppMethodBeat.o(132975);
  }
  
  public static final a a(int paramInt, String paramString, HashMap<Integer, h.b> paramHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(132974);
    if ((!bt.isNullOrNil(paramString)) && (paramHashMap != null)) {}
    int i;
    a locala;
    long l;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      i = paramString.hashCode();
      locala = (a)hUi.get(Integer.valueOf(i));
      if (locala != null) {
        break label198;
      }
      locala = new a(paramString, paramBoolean);
      if (!paramBoolean) {
        break;
      }
      g.afz();
      l = a.getUin();
      q.cG(true);
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
    hUi.put(Integer.valueOf(i), locala);
    for (paramString = locala;; paramString = locala)
    {
      ad.d("MicroMsg.GeneralDBHelper", "addRef %d", new Object[] { Integer.valueOf(paramInt) });
      paramString.hUj.put(paramInt, true);
      AppMethodBeat.o(132974);
      return paramString;
      label198:
      if (paramBoolean == locala.bym) {
        paramBoolean = true;
      }
      for (;;)
      {
        Assert.assertTrue(paramBoolean);
        l = locala.rb(-1L);
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
              ad.d("MicroMsg.GeneralDBHelper", "init sql:".concat(String.valueOf(localObject)));
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
      locala.mX(l);
    }
  }
  
  public static final class a
    extends h
  {
    public final boolean bym;
    SparseBooleanArray hUj;
    private final String path;
    
    public a(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(132970);
      this.hUj = new SparseBooleanArray();
      ad.d("MicroMsg.GeneralDBHelper", "create db %s", new Object[] { paramString });
      this.bym = paramBoolean;
      this.path = paramString;
      AppMethodBeat.o(132970);
    }
    
    @Deprecated
    public final void closeDB()
    {
      AppMethodBeat.i(132972);
      ad.e("MicroMsg.GeneralDBHelper", "forbid to use this method %s", new Object[] { bt.eGN() });
      if (this.hUj.size() <= 1) {
        super.closeDB();
      }
      AppMethodBeat.o(132972);
    }
    
    @Deprecated
    public final void oi(String paramString)
    {
      AppMethodBeat.i(132973);
      ad.e("MicroMsg.GeneralDBHelper", "forbid to use this method");
      if (this.hUj.size() <= 1) {
        super.oi(paramString);
      }
      AppMethodBeat.o(132973);
    }
    
    public final void pK(int paramInt)
    {
      AppMethodBeat.i(132971);
      ad.d("MicroMsg.GeneralDBHelper", "try close db %d", new Object[] { Integer.valueOf(paramInt) });
      this.hUj.delete(paramInt);
      if (this.hUj.size() <= 0)
      {
        ad.d("MicroMsg.GeneralDBHelper", "close db %d succ", new Object[] { Integer.valueOf(paramInt) });
        super.closeDB();
        r.aGw().remove(Integer.valueOf(this.path.hashCode()));
      }
      AppMethodBeat.o(132971);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.r
 * JD-Core Version:    0.7.0.1
 */