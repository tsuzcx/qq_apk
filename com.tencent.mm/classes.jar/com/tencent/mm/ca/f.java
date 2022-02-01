package com.tencent.mm.ca;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract interface f
{
  public abstract f bL(String paramString, long paramLong);
  
  public abstract f cu(String paramString, boolean paramBoolean);
  
  public abstract f eCw();
  
  public abstract f eCx();
  
  public abstract f eCy();
  
  public abstract f fC(String paramString, int paramInt);
  
  public abstract boolean getBoolean(String paramString, boolean paramBoolean);
  
  public abstract int getInt(String paramString, int paramInt);
  
  public abstract long getLong(String paramString, long paramLong);
  
  public abstract String getString(String paramString1, String paramString2);
  
  public abstract f kJ(String paramString1, String paramString2);
  
  public static final class a
    implements f
  {
    final File ELp;
    final File ELq;
    private final AtomicBoolean ELr;
    private final Bundle mExtras;
    
    public a(Context paramContext, String paramString)
    {
      this(new File(k.hB(paramContext), paramString));
      AppMethodBeat.i(189831);
      AppMethodBeat.o(189831);
    }
    
    private a(File paramFile)
    {
      AppMethodBeat.i(189832);
      this.mExtras = new Bundle();
      this.ELr = new AtomicBoolean();
      this.ELp = paramFile;
      this.ELq = new File(this.ELp, "fast_persist_data");
      AppMethodBeat.o(189832);
    }
    
    private Pair<String, File> aEF(String paramString)
    {
      AppMethodBeat.i(189837);
      Object localObject1 = new ArrayList();
      File[] arrayOfFile = k.b.J(this.ELq);
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = arrayOfFile[i];
        try
        {
          Object localObject3 = ((File)localObject2).getName();
          if ((((String)localObject3).startsWith(".FP")) && (((String)localObject3).contains("__KEY__")))
          {
            localObject3 = ((String)localObject3).substring(((String)localObject3).indexOf("__KEY__") + 7);
            if (((String)localObject3).contains("__VALUE__"))
            {
              if (((String)localObject3).substring(0, ((String)localObject3).indexOf("__VALUE__")).equals(paramString))
              {
                localObject3 = new Pair(((String)localObject3).substring(((String)localObject3).indexOf("__VALUE__") + 9), localObject2);
                paramString = ((List)localObject1).iterator();
                while (paramString.hasNext()) {
                  k.b.G((File)paramString.next());
                }
                AppMethodBeat.o(189837);
                return localObject3;
              }
              localObject2 = ((List)localObject1).iterator();
              while (((Iterator)localObject2).hasNext()) {
                k.b.G((File)((Iterator)localObject2).next());
              }
            }
            ((List)localObject1).add(localObject2);
          }
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext()) {
            k.b.G((File)((Iterator)localObject2).next());
          }
          i += 1;
        }
        catch (Throwable localThrowable)
        {
          a.w("MicroMsg.recovery.fastPersist", "find persist file fail", localThrowable);
          ((List)localObject1).add(localObject2);
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext()) {
            k.b.G((File)((Iterator)localObject2).next());
          }
        }
        finally
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            k.b.G((File)((Iterator)localObject1).next());
          }
          AppMethodBeat.o(189837);
        }
      }
      AppMethodBeat.o(189837);
      return null;
    }
    
    private a bM(String paramString, long paramLong)
    {
      AppMethodBeat.i(189841);
      this.mExtras.putLong(paramString, paramLong);
      AppMethodBeat.o(189841);
      return this;
    }
    
    private void eCz()
    {
      AppMethodBeat.i(189836);
      if (!this.ELr.get())
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Persis#load() has not yet been called");
        AppMethodBeat.o(189836);
        throw localIllegalStateException;
      }
      AppMethodBeat.o(189836);
    }
    
    public final f eCw()
    {
      AppMethodBeat.i(189833);
      try
      {
        Object localObject = this.ELq;
        if (localObject == null)
        {
          localObject = new IOException("Dir is null.");
          AppMethodBeat.o(189833);
          throw ((Throwable)localObject);
        }
      }
      catch (Throwable localThrowable)
      {
        a.w("MicroMsg.recovery.fastPersist", "create persist dir fail", localThrowable);
      }
      for (;;)
      {
        this.ELr.set(true);
        AppMethodBeat.o(189833);
        return this;
        IOException localIOException;
        if (localThrowable.exists())
        {
          if (!localThrowable.isDirectory())
          {
            if (!k.b.G(localThrowable))
            {
              localIOException = new IOException("Fail to delete existing file, file = " + localThrowable.getAbsolutePath());
              AppMethodBeat.o(189833);
              throw localIOException;
            }
            localIOException.mkdir();
          }
        }
        else {
          while ((!localIOException.exists()) || (!localIOException.isDirectory()))
          {
            localIOException = new IOException("Fail to create dir, dir = " + localIOException.getAbsolutePath());
            AppMethodBeat.o(189833);
            throw localIOException;
            localIOException.mkdirs();
          }
        }
      }
    }
    
    public final f eCx()
    {
      AppMethodBeat.i(189834);
      eCz();
      Iterator localIterator = this.mExtras.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = this.mExtras.get(str);
        if (localObject != null)
        {
          Pair localPair = aEF(str);
          if (localPair != null) {
            k.b.G((File)localPair.second);
          }
          try
          {
            k.b.I(new File(this.ELq, ".FP__KEY__" + str + "__VALUE__" + localObject));
          }
          catch (Throwable localThrowable)
          {
            a.w("MicroMsg.recovery.fastPersist", "create file pair store fail", localThrowable);
          }
        }
      }
      AppMethodBeat.o(189834);
      return this;
    }
    
    public final f eCy()
    {
      AppMethodBeat.i(189835);
      f localf = eCx();
      AppMethodBeat.o(189835);
      return localf;
    }
    
    public final boolean getBoolean(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(189838);
      eCz();
      if (this.mExtras.containsKey(paramString))
      {
        paramBoolean = this.mExtras.getBoolean(paramString);
        AppMethodBeat.o(189838);
        return paramBoolean;
      }
      paramString = aEF(paramString);
      if (paramString != null)
      {
        paramString = (String)paramString.first;
        if ((paramString.equalsIgnoreCase("true")) || (paramString.equalsIgnoreCase("false")))
        {
          paramBoolean = Boolean.parseBoolean(paramString);
          AppMethodBeat.o(189838);
          return paramBoolean;
        }
      }
      AppMethodBeat.o(189838);
      return paramBoolean;
    }
    
    public final int getInt(String paramString, int paramInt)
    {
      AppMethodBeat.i(189839);
      paramInt = k.ab(getLong(paramString, paramInt), paramInt);
      AppMethodBeat.o(189839);
      return paramInt;
    }
    
    public final long getLong(String paramString, long paramLong)
    {
      AppMethodBeat.i(189840);
      eCz();
      if (this.mExtras.containsKey(paramString))
      {
        paramLong = this.mExtras.getLong(paramString);
        AppMethodBeat.o(189840);
        return paramLong;
      }
      paramString = aEF(paramString);
      if (paramString != null)
      {
        paramString = (String)paramString.first;
        if (k.isNumeric(paramString)) {
          try
          {
            long l = Long.parseLong(paramString);
            AppMethodBeat.o(189840);
            return l;
          }
          catch (Throwable paramString) {}
        }
      }
      AppMethodBeat.o(189840);
      return paramLong;
    }
    
    public final String getString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(189842);
      eCz();
      if (this.mExtras.containsKey(paramString1))
      {
        paramString1 = this.mExtras.getString(paramString1);
        AppMethodBeat.o(189842);
        return paramString1;
      }
      paramString1 = aEF(paramString1);
      if (paramString1 != null)
      {
        paramString1 = (String)paramString1.first;
        AppMethodBeat.o(189842);
        return paramString1;
      }
      AppMethodBeat.o(189842);
      return paramString2;
    }
  }
  
  public static final class b
    implements f
  {
    private final String ELs;
    private SharedPreferences ELt;
    private final Context mContext;
    private final Bundle mExtras;
    
    public b(Context paramContext, String paramString)
    {
      AppMethodBeat.i(189847);
      this.mExtras = new Bundle();
      this.mContext = paramContext;
      this.ELs = paramString;
      AppMethodBeat.o(189847);
    }
    
    private static long a(SharedPreferences paramSharedPreferences, String paramString, long paramLong)
    {
      AppMethodBeat.i(189856);
      if (!paramSharedPreferences.contains(paramString))
      {
        AppMethodBeat.o(189856);
        return paramLong;
      }
      try
      {
        long l = paramSharedPreferences.getLong(paramString, paramLong);
        AppMethodBeat.o(189856);
        return l;
      }
      catch (Throwable localThrowable)
      {
        try
        {
          int i = paramSharedPreferences.getInt(paramString, 0);
          paramLong = i;
          AppMethodBeat.o(189856);
          return paramLong;
        }
        catch (Throwable paramSharedPreferences)
        {
          AppMethodBeat.o(189856);
        }
      }
      return paramLong;
    }
    
    private b bN(String paramString, long paramLong)
    {
      AppMethodBeat.i(189854);
      eCB();
      this.mExtras.putLong(paramString, paramLong);
      AppMethodBeat.o(189854);
      return this;
    }
    
    private void eCB()
    {
      AppMethodBeat.i(189849);
      if (this.ELt == null)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Persis#load() has not yet been called");
        AppMethodBeat.o(189849);
        throw localIllegalStateException;
      }
      AppMethodBeat.o(189849);
    }
    
    private SharedPreferences.Editor eCC()
    {
      AppMethodBeat.i(189850);
      SharedPreferences.Editor localEditor = this.ELt.edit();
      Iterator localIterator = this.mExtras.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = this.mExtras.get(str);
        if (localObject != null)
        {
          localObject = localObject.toString();
          if (k.isNumeric((String)localObject)) {
            try
            {
              localEditor.putLong(str, Long.parseLong((String)localObject));
            }
            catch (Throwable localThrowable) {}
          } else if ((((String)localObject).equalsIgnoreCase("true")) || (((String)localObject).equalsIgnoreCase("false"))) {
            localEditor.putBoolean(localThrowable, Boolean.parseBoolean((String)localObject));
          } else {
            localEditor.putString(localThrowable, (String)localObject);
          }
        }
      }
      AppMethodBeat.o(189850);
      return localEditor;
    }
    
    public final b eCA()
    {
      AppMethodBeat.i(189848);
      this.ELt = this.mContext.getSharedPreferences(this.ELs, 0);
      AppMethodBeat.o(189848);
      return this;
    }
    
    public final boolean getBoolean(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(189851);
      eCB();
      if (this.mExtras.containsKey(paramString))
      {
        paramBoolean = this.mExtras.getBoolean(paramString);
        AppMethodBeat.o(189851);
        return paramBoolean;
      }
      paramBoolean = this.ELt.getBoolean(paramString, false);
      AppMethodBeat.o(189851);
      return paramBoolean;
    }
    
    public final int getInt(String paramString, int paramInt)
    {
      AppMethodBeat.i(189852);
      paramInt = k.ab(getLong(paramString, paramInt), paramInt);
      AppMethodBeat.o(189852);
      return paramInt;
    }
    
    public final long getLong(String paramString, long paramLong)
    {
      AppMethodBeat.i(189853);
      eCB();
      if (this.mExtras.containsKey(paramString))
      {
        paramLong = this.mExtras.getLong(paramString);
        AppMethodBeat.o(189853);
        return paramLong;
      }
      paramLong = a(this.ELt, paramString, paramLong);
      AppMethodBeat.o(189853);
      return paramLong;
    }
    
    public final String getString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(189855);
      eCB();
      if (this.mExtras.containsKey(paramString1))
      {
        paramString1 = this.mExtras.getString(paramString1);
        AppMethodBeat.o(189855);
        return paramString1;
      }
      paramString1 = this.ELt.getString(paramString1, paramString2);
      AppMethodBeat.o(189855);
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ca.f
 * JD-Core Version:    0.7.0.1
 */