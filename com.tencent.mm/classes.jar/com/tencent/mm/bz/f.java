package com.tencent.mm.bz;

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
  public abstract f bN(String paramString, long paramLong);
  
  public abstract f cA(String paramString, boolean paramBoolean);
  
  public abstract f eRR();
  
  public abstract f eRS();
  
  public abstract f eRT();
  
  public abstract f fH(String paramString, int paramInt);
  
  public abstract boolean getBoolean(String paramString, boolean paramBoolean);
  
  public abstract int getInt(String paramString, int paramInt);
  
  public abstract long getLong(String paramString, long paramLong);
  
  public abstract String getString(String paramString1, String paramString2);
  
  public abstract f lg(String paramString1, String paramString2);
  
  public static final class a
    implements f
  {
    final File GiB;
    final File GiC;
    private final AtomicBoolean GiD;
    private final Bundle mExtras;
    
    public a(Context paramContext, String paramString)
    {
      this(new File(k.hM(paramContext), paramString));
      AppMethodBeat.i(194772);
      AppMethodBeat.o(194772);
    }
    
    private a(File paramFile)
    {
      AppMethodBeat.i(194773);
      this.mExtras = new Bundle();
      this.GiD = new AtomicBoolean();
      this.GiB = paramFile;
      this.GiC = new File(this.GiB, "fast_persist_data");
      AppMethodBeat.o(194773);
    }
    
    private Pair<String, File> aJW(String paramString)
    {
      AppMethodBeat.i(194778);
      Object localObject1 = new ArrayList();
      File[] arrayOfFile = k.b.M(this.GiC);
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
                  k.b.J((File)paramString.next());
                }
                AppMethodBeat.o(194778);
                return localObject3;
              }
              localObject2 = ((List)localObject1).iterator();
              while (((Iterator)localObject2).hasNext()) {
                k.b.J((File)((Iterator)localObject2).next());
              }
            }
            ((List)localObject1).add(localObject2);
          }
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext()) {
            k.b.J((File)((Iterator)localObject2).next());
          }
          i += 1;
        }
        catch (Throwable localThrowable)
        {
          a.w("MicroMsg.recovery.fastPersist", "find persist file fail", localThrowable);
          ((List)localObject1).add(localObject2);
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext()) {
            k.b.J((File)((Iterator)localObject2).next());
          }
        }
        finally
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            k.b.J((File)((Iterator)localObject1).next());
          }
          AppMethodBeat.o(194778);
        }
      }
      AppMethodBeat.o(194778);
      return null;
    }
    
    private a bO(String paramString, long paramLong)
    {
      AppMethodBeat.i(194782);
      this.mExtras.putLong(paramString, paramLong);
      AppMethodBeat.o(194782);
      return this;
    }
    
    private void egq()
    {
      AppMethodBeat.i(194777);
      if (!this.GiD.get())
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Persis#load() has not yet been called");
        AppMethodBeat.o(194777);
        throw localIllegalStateException;
      }
      AppMethodBeat.o(194777);
    }
    
    public final f eRR()
    {
      AppMethodBeat.i(194774);
      try
      {
        Object localObject = this.GiC;
        if (localObject == null)
        {
          localObject = new IOException("Dir is null.");
          AppMethodBeat.o(194774);
          throw ((Throwable)localObject);
        }
      }
      catch (Throwable localThrowable)
      {
        a.w("MicroMsg.recovery.fastPersist", "create persist dir fail", localThrowable);
      }
      for (;;)
      {
        this.GiD.set(true);
        AppMethodBeat.o(194774);
        return this;
        IOException localIOException;
        if (localThrowable.exists())
        {
          if (!localThrowable.isDirectory())
          {
            if (!k.b.J(localThrowable))
            {
              localIOException = new IOException("Fail to delete existing file, file = " + localThrowable.getAbsolutePath());
              AppMethodBeat.o(194774);
              throw localIOException;
            }
            localIOException.mkdir();
          }
        }
        else {
          while ((!localIOException.exists()) || (!localIOException.isDirectory()))
          {
            localIOException = new IOException("Fail to create dir, dir = " + localIOException.getAbsolutePath());
            AppMethodBeat.o(194774);
            throw localIOException;
            localIOException.mkdirs();
          }
        }
      }
    }
    
    public final f eRS()
    {
      AppMethodBeat.i(194775);
      egq();
      Iterator localIterator = this.mExtras.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = this.mExtras.get(str);
        if (localObject != null)
        {
          Pair localPair = aJW(str);
          if (localPair != null) {
            k.b.J((File)localPair.second);
          }
          try
          {
            k.b.L(new File(this.GiC, ".FP__KEY__" + str + "__VALUE__" + localObject));
          }
          catch (Throwable localThrowable)
          {
            a.w("MicroMsg.recovery.fastPersist", "create file pair store fail", localThrowable);
          }
        }
      }
      AppMethodBeat.o(194775);
      return this;
    }
    
    public final f eRT()
    {
      AppMethodBeat.i(194776);
      f localf = eRS();
      AppMethodBeat.o(194776);
      return localf;
    }
    
    public final boolean getBoolean(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(194779);
      egq();
      if (this.mExtras.containsKey(paramString))
      {
        paramBoolean = this.mExtras.getBoolean(paramString);
        AppMethodBeat.o(194779);
        return paramBoolean;
      }
      paramString = aJW(paramString);
      if (paramString != null)
      {
        paramString = (String)paramString.first;
        if ((paramString.equalsIgnoreCase("true")) || (paramString.equalsIgnoreCase("false")))
        {
          paramBoolean = Boolean.parseBoolean(paramString);
          AppMethodBeat.o(194779);
          return paramBoolean;
        }
      }
      AppMethodBeat.o(194779);
      return paramBoolean;
    }
    
    public final int getInt(String paramString, int paramInt)
    {
      AppMethodBeat.i(194780);
      paramInt = k.ae(getLong(paramString, paramInt), paramInt);
      AppMethodBeat.o(194780);
      return paramInt;
    }
    
    public final long getLong(String paramString, long paramLong)
    {
      AppMethodBeat.i(194781);
      egq();
      if (this.mExtras.containsKey(paramString))
      {
        paramLong = this.mExtras.getLong(paramString);
        AppMethodBeat.o(194781);
        return paramLong;
      }
      paramString = aJW(paramString);
      if (paramString != null)
      {
        paramString = (String)paramString.first;
        if (k.isNumeric(paramString)) {
          try
          {
            long l = Long.parseLong(paramString);
            AppMethodBeat.o(194781);
            return l;
          }
          catch (Throwable paramString) {}
        }
      }
      AppMethodBeat.o(194781);
      return paramLong;
    }
    
    public final String getString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(194783);
      egq();
      if (this.mExtras.containsKey(paramString1))
      {
        paramString1 = this.mExtras.getString(paramString1);
        AppMethodBeat.o(194783);
        return paramString1;
      }
      paramString1 = aJW(paramString1);
      if (paramString1 != null)
      {
        paramString1 = (String)paramString1.first;
        AppMethodBeat.o(194783);
        return paramString1;
      }
      AppMethodBeat.o(194783);
      return paramString2;
    }
  }
  
  public static final class b
    implements f
  {
    private final String GiE;
    private SharedPreferences GiF;
    private final Context mContext;
    private final Bundle mExtras;
    
    public b(Context paramContext, String paramString)
    {
      AppMethodBeat.i(194788);
      this.mExtras = new Bundle();
      this.mContext = paramContext;
      this.GiE = paramString;
      AppMethodBeat.o(194788);
    }
    
    private static long a(SharedPreferences paramSharedPreferences, String paramString, long paramLong)
    {
      AppMethodBeat.i(194797);
      if (!paramSharedPreferences.contains(paramString))
      {
        AppMethodBeat.o(194797);
        return paramLong;
      }
      try
      {
        long l = paramSharedPreferences.getLong(paramString, paramLong);
        AppMethodBeat.o(194797);
        return l;
      }
      catch (Throwable localThrowable)
      {
        try
        {
          int i = paramSharedPreferences.getInt(paramString, 0);
          paramLong = i;
          AppMethodBeat.o(194797);
          return paramLong;
        }
        catch (Throwable paramSharedPreferences)
        {
          AppMethodBeat.o(194797);
        }
      }
      return paramLong;
    }
    
    private b bP(String paramString, long paramLong)
    {
      AppMethodBeat.i(194795);
      eRV();
      this.mExtras.putLong(paramString, paramLong);
      AppMethodBeat.o(194795);
      return this;
    }
    
    private void eRV()
    {
      AppMethodBeat.i(194790);
      if (this.GiF == null)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Persis#load() has not yet been called");
        AppMethodBeat.o(194790);
        throw localIllegalStateException;
      }
      AppMethodBeat.o(194790);
    }
    
    private SharedPreferences.Editor eRW()
    {
      AppMethodBeat.i(194791);
      SharedPreferences.Editor localEditor = this.GiF.edit();
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
      AppMethodBeat.o(194791);
      return localEditor;
    }
    
    public final b eRU()
    {
      AppMethodBeat.i(194789);
      this.GiF = this.mContext.getSharedPreferences(this.GiE, 0);
      AppMethodBeat.o(194789);
      return this;
    }
    
    public final boolean getBoolean(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(194792);
      eRV();
      if (this.mExtras.containsKey(paramString))
      {
        paramBoolean = this.mExtras.getBoolean(paramString);
        AppMethodBeat.o(194792);
        return paramBoolean;
      }
      paramBoolean = this.GiF.getBoolean(paramString, false);
      AppMethodBeat.o(194792);
      return paramBoolean;
    }
    
    public final int getInt(String paramString, int paramInt)
    {
      AppMethodBeat.i(194793);
      paramInt = k.ae(getLong(paramString, paramInt), paramInt);
      AppMethodBeat.o(194793);
      return paramInt;
    }
    
    public final long getLong(String paramString, long paramLong)
    {
      AppMethodBeat.i(194794);
      eRV();
      if (this.mExtras.containsKey(paramString))
      {
        paramLong = this.mExtras.getLong(paramString);
        AppMethodBeat.o(194794);
        return paramLong;
      }
      paramLong = a(this.GiF, paramString, paramLong);
      AppMethodBeat.o(194794);
      return paramLong;
    }
    
    public final String getString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(194796);
      eRV();
      if (this.mExtras.containsKey(paramString1))
      {
        paramString1 = this.mExtras.getString(paramString1);
        AppMethodBeat.o(194796);
        return paramString1;
      }
      paramString1 = this.GiF.getString(paramString1, paramString2);
      AppMethodBeat.o(194796);
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bz.f
 * JD-Core Version:    0.7.0.1
 */