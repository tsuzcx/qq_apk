package com.tencent.mm.platformtools;

import android.util.SparseBooleanArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class o
{
  private static ConcurrentHashMap<Integer, a> pAQ;
  
  static
  {
    AppMethodBeat.i(132975);
    pAQ = new ConcurrentHashMap();
    AppMethodBeat.o(132975);
  }
  
  public static final a a(int paramInt, String paramString, HashMap<Integer, h.b> paramHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(132974);
    if ((!Util.isNullOrNil(paramString)) && (paramHashMap != null)) {}
    int i;
    a locala;
    long l;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      i = paramString.hashCode();
      locala = (a)pAQ.get(Integer.valueOf(i));
      if (locala != null) {
        break label198;
      }
      locala = new a(paramString, paramBoolean);
      if (!paramBoolean) {
        break;
      }
      com.tencent.mm.kernel.h.baC();
      l = com.tencent.mm.kernel.b.getUin();
      q.eD(true);
      if (locala.b("", paramString, "", l, paramHashMap, true)) {
        break label147;
      }
      paramString = new com.tencent.mm.model.b((byte)0);
      AppMethodBeat.o(132974);
      throw paramString;
    }
    if (!locala.a(paramString, paramHashMap, false))
    {
      paramString = new com.tencent.mm.model.b((byte)0);
      AppMethodBeat.o(132974);
      throw paramString;
    }
    label147:
    pAQ.put(Integer.valueOf(i), locala);
    for (paramString = locala;; paramString = locala)
    {
      Log.d("MicroMsg.GeneralDBHelper", "addRef %d", new Object[] { Integer.valueOf(paramInt) });
      paramString.pAR.put(paramInt, true);
      AppMethodBeat.o(132974);
      return paramString;
      label198:
      if (paramBoolean == locala.djI) {
        paramBoolean = true;
      }
      for (;;)
      {
        Assert.assertTrue(paramBoolean);
        l = locala.beginTransaction(-1L);
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
              Log.d("MicroMsg.GeneralDBHelper", "init sql:".concat(String.valueOf(localObject)));
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
      locala.endTransaction(l);
    }
  }
  
  public static final class a
    extends com.tencent.mm.storagebase.h
  {
    public final boolean djI;
    SparseBooleanArray pAR;
    private final String path;
    
    public a(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(132970);
      this.pAR = new SparseBooleanArray();
      Log.d("MicroMsg.GeneralDBHelper", "create db %s", new Object[] { paramString });
      this.djI = paramBoolean;
      this.path = paramString;
      AppMethodBeat.o(132970);
    }
    
    @Deprecated
    public final void Cg(String paramString)
    {
      AppMethodBeat.i(132973);
      Log.e("MicroMsg.GeneralDBHelper", "forbid to use this method");
      if (this.pAR.size() <= 1) {
        super.Cg(paramString);
      }
      AppMethodBeat.o(132973);
    }
    
    @Deprecated
    public final void closeDB()
    {
      AppMethodBeat.i(132972);
      Log.e("MicroMsg.GeneralDBHelper", "forbid to use this method %s", new Object[] { Util.getStack() });
      if (this.pAR.size() <= 1) {
        super.closeDB();
      }
      AppMethodBeat.o(132972);
    }
    
    public final void yb(int paramInt)
    {
      AppMethodBeat.i(132971);
      Log.d("MicroMsg.GeneralDBHelper", "try close db %d", new Object[] { Integer.valueOf(paramInt) });
      this.pAR.delete(paramInt);
      if (this.pAR.size() <= 0)
      {
        Log.d("MicroMsg.GeneralDBHelper", "close db %d succ", new Object[] { Integer.valueOf(paramInt) });
        super.closeDB();
        o.bTA().remove(Integer.valueOf(this.path.hashCode()));
      }
      AppMethodBeat.o(132971);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.o
 * JD-Core Version:    0.7.0.1
 */