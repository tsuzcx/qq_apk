package com.bumptech.glide.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a
  implements Closeable
{
  private final File aBJ;
  private final File aBK;
  private final File aBL;
  private final int aBM;
  private final int aBN;
  private Writer aBO;
  private final LinkedHashMap<String, c> aBP;
  private int aBQ;
  private long aBR;
  final ThreadPoolExecutor aBS;
  private final Callable<Void> aBT;
  private final File directory;
  private long maxSize;
  private long size;
  
  private a(File paramFile, long paramLong)
  {
    AppMethodBeat.i(100610);
    this.size = 0L;
    this.aBP = new LinkedHashMap(0, 0.75F, true);
    this.aBR = 0L;
    this.aBS = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a.a((byte)0));
    this.aBT = new Callable()
    {
      private Void call()
      {
        AppMethodBeat.i(100638);
        synchronized (a.this)
        {
          if (a.a(a.this) == null)
          {
            AppMethodBeat.o(100638);
            return null;
          }
          a.b(a.this);
          if (a.c(a.this))
          {
            a.d(a.this);
            a.e(a.this);
          }
          AppMethodBeat.o(100638);
          return null;
        }
      }
    };
    this.directory = paramFile;
    this.aBM = 1;
    this.aBJ = new File(paramFile, "journal");
    this.aBK = new File(paramFile, "journal.tmp");
    this.aBL = new File(paramFile, "journal.bkp");
    this.aBN = 1;
    this.maxSize = paramLong;
    AppMethodBeat.o(100610);
  }
  
  private void a(b paramb, boolean paramBoolean)
  {
    int k = 0;
    c localc;
    try
    {
      AppMethodBeat.i(100619);
      localc = paramb.aBV;
      if (localc.aCb != paramb)
      {
        paramb = new IllegalStateException();
        AppMethodBeat.o(100619);
        throw paramb;
      }
    }
    finally {}
    int j = k;
    if (paramBoolean)
    {
      j = k;
      if (!localc.readable)
      {
        int i = 0;
        for (;;)
        {
          j = k;
          if (i >= this.aBN) {
            break;
          }
          if (paramb.aBW[i] == 0)
          {
            paramb.abort();
            paramb = new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
            AppMethodBeat.o(100619);
            throw paramb;
          }
          if (!localc.aCa[i].exists())
          {
            paramb.abort();
            AppMethodBeat.o(100619);
            return;
          }
          i += 1;
        }
      }
    }
    for (;;)
    {
      long l1;
      if (j < this.aBN)
      {
        paramb = localc.aCa[j];
        if (paramBoolean)
        {
          if (paramb.exists())
          {
            File localFile = localc.aBZ[j];
            paramb.renameTo(localFile);
            l1 = localc.aBY[j];
            long l2 = localFile.length();
            localc.aBY[j] = l2;
            this.size = (this.size - l1 + l2);
          }
        }
        else {
          q(paramb);
        }
      }
      else
      {
        this.aBQ += 1;
        localc.aCb = null;
        if ((localc.readable | paramBoolean))
        {
          localc.readable = true;
          this.aBO.append("CLEAN");
          this.aBO.append(' ');
          this.aBO.append(localc.key);
          this.aBO.append(localc.nF());
          this.aBO.append('\n');
          if (paramBoolean)
          {
            l1 = this.aBR;
            this.aBR = (1L + l1);
            localc.aCc = l1;
          }
        }
        for (;;)
        {
          this.aBO.flush();
          if ((this.size > this.maxSize) || (nB())) {
            this.aBS.submit(this.aBT);
          }
          AppMethodBeat.o(100619);
          break;
          this.aBP.remove(localc.key);
          this.aBO.append("REMOVE");
          this.aBO.append(' ');
          this.aBO.append(localc.key);
          this.aBO.append('\n');
        }
      }
      j += 1;
    }
  }
  
  private static void a(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    AppMethodBeat.i(100616);
    if (paramBoolean) {
      q(paramFile2);
    }
    if (!paramFile1.renameTo(paramFile2))
    {
      paramFile1 = new IOException();
      AppMethodBeat.o(100616);
      throw paramFile1;
    }
    AppMethodBeat.o(100616);
  }
  
  public static a b(File paramFile, long paramLong)
  {
    AppMethodBeat.i(100611);
    if (paramLong <= 0L)
    {
      paramFile = new IllegalArgumentException("maxSize <= 0");
      AppMethodBeat.o(100611);
      throw paramFile;
    }
    Object localObject = new File(paramFile, "journal.bkp");
    File localFile;
    if (((File)localObject).exists())
    {
      localFile = new File(paramFile, "journal");
      if (!localFile.exists()) {
        break label106;
      }
      ((File)localObject).delete();
    }
    for (;;)
    {
      localObject = new a(paramFile, paramLong);
      if (!((a)localObject).aBJ.exists()) {
        break label172;
      }
      try
      {
        ((a)localObject).ny();
        ((a)localObject).nz();
        AppMethodBeat.o(100611);
        return localObject;
      }
      catch (IOException localIOException)
      {
        label106:
        System.out.println("DiskLruCache " + paramFile + " is corrupt: " + localIOException.getMessage() + ", removing");
        ((a)localObject).close();
        c.r(((a)localObject).directory);
      }
      a((File)localObject, localFile, false);
    }
    label172:
    paramFile.mkdirs();
    paramFile = new a(paramFile, paramLong);
    paramFile.nA();
    AppMethodBeat.o(100611);
    return paramFile;
  }
  
  private void nA()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(100614);
        if (this.aBO != null) {
          this.aBO.close();
        }
        BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aBK), c.US_ASCII));
        c localc;
        try
        {
          localBufferedWriter.write("libcore.io.DiskLruCache");
          localBufferedWriter.write("\n");
          localBufferedWriter.write("1");
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.aBM));
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.aBN));
          localBufferedWriter.write("\n");
          localBufferedWriter.write("\n");
          Iterator localIterator = this.aBP.values().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localc = (c)localIterator.next();
          if (localc.aCb != null)
          {
            localBufferedWriter.write("DIRTY " + localc.key + '\n');
            continue;
            localObject1 = finally;
          }
        }
        finally
        {
          localBufferedWriter.close();
          AppMethodBeat.o(100614);
        }
        localObject1.write("CLEAN " + localc.key + localc.nF() + '\n');
      }
      finally {}
    }
    localObject1.close();
    if (this.aBJ.exists()) {
      a(this.aBJ, this.aBL, true);
    }
    a(this.aBK, this.aBJ, false);
    this.aBL.delete();
    this.aBO = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aBJ, true), c.US_ASCII));
    AppMethodBeat.o(100614);
  }
  
  private boolean nB()
  {
    AppMethodBeat.i(100620);
    if ((this.aBQ >= 2000) && (this.aBQ >= this.aBP.size()))
    {
      AppMethodBeat.o(100620);
      return true;
    }
    AppMethodBeat.o(100620);
    return false;
  }
  
  private void nC()
  {
    AppMethodBeat.i(100622);
    if (this.aBO == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("cache is closed");
      AppMethodBeat.o(100622);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(100622);
  }
  
  private void ny()
  {
    AppMethodBeat.i(100612);
    b localb = new b(new FileInputStream(this.aBJ), c.US_ASCII);
    Object localObject4;
    Object localObject5;
    String str1;
    try
    {
      Object localObject1 = localb.readLine();
      localObject4 = localb.readLine();
      localObject5 = localb.readLine();
      str1 = localb.readLine();
      String str2 = localb.readLine();
      if ((!"libcore.io.DiskLruCache".equals(localObject1)) || (!"1".equals(localObject4)) || (!Integer.toString(this.aBM).equals(localObject5)) || (!Integer.toString(this.aBN).equals(str1)) || (!"".equals(str2)))
      {
        localObject1 = new IOException("unexpected journal header: [" + (String)localObject1 + ", " + (String)localObject4 + ", " + str1 + ", " + str2 + "]");
        AppMethodBeat.o(100612);
        throw ((Throwable)localObject1);
      }
    }
    finally
    {
      c.closeQuietly(localb);
      AppMethodBeat.o(100612);
    }
    int i = 0;
    for (;;)
    {
      try
      {
        str1 = localb.readLine();
        j = str1.indexOf(' ');
        if (j == -1)
        {
          IOException localIOException = new IOException("unexpected journal line: ".concat(String.valueOf(str1)));
          AppMethodBeat.o(100612);
          throw localIOException;
        }
      }
      catch (EOFException localEOFException)
      {
        int j;
        this.aBQ = (i - this.aBP.size());
        if (localb.end == -1)
        {
          i = 1;
          if (i != 0)
          {
            nA();
            c.closeQuietly(localb);
            AppMethodBeat.o(100612);
            return;
            int k = j + 1;
            int m = str1.indexOf(' ', k);
            if (m == -1)
            {
              localObject3 = str1.substring(k);
              if ((j != 6) || (!str1.startsWith("REMOVE"))) {
                continue;
              }
              this.aBP.remove(localObject3);
              continue;
            }
            Object localObject3 = str1.substring(k, m);
            localObject5 = (c)this.aBP.get(localObject3);
            localObject4 = localObject5;
            if (localObject5 == null)
            {
              localObject4 = new c((String)localObject3, (byte)0);
              this.aBP.put(localObject3, localObject4);
            }
            if ((m != -1) && (j == 5) && (str1.startsWith("CLEAN")))
            {
              localObject3 = str1.substring(m + 1).split(" ");
              ((c)localObject4).readable = true;
              ((c)localObject4).aCb = null;
              ((c)localObject4).c((String[])localObject3);
              continue;
            }
            if ((m == -1) && (j == 5) && (str1.startsWith("DIRTY")))
            {
              ((c)localObject4).aCb = new b((c)localObject4, (byte)0);
              continue;
            }
            if ((m == -1) && (j == 4) && (str1.startsWith("READ"))) {
              continue;
            }
            localObject3 = new IOException("unexpected journal line: ".concat(String.valueOf(str1)));
            AppMethodBeat.o(100612);
            throw ((Throwable)localObject3);
          }
        }
        else
        {
          i = 0;
          continue;
        }
        this.aBO = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aBJ, true), c.US_ASCII));
        continue;
        continue;
        i += 1;
      }
    }
  }
  
  private void nz()
  {
    AppMethodBeat.i(100613);
    q(this.aBK);
    Iterator localIterator = this.aBP.values().iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      int i;
      if (localc.aCb == null)
      {
        i = 0;
        while (i < this.aBN)
        {
          this.size += localc.aBY[i];
          i += 1;
        }
      }
      else
      {
        localc.aCb = null;
        i = 0;
        while (i < this.aBN)
        {
          q(localc.aBZ[i]);
          q(localc.aCa[i]);
          i += 1;
        }
        localIterator.remove();
      }
    }
    AppMethodBeat.o(100613);
  }
  
  private static void q(File paramFile)
  {
    AppMethodBeat.i(100615);
    if ((paramFile.exists()) && (!paramFile.delete()))
    {
      paramFile = new IOException();
      AppMethodBeat.o(100615);
      throw paramFile;
    }
    AppMethodBeat.o(100615);
  }
  
  private boolean remove(String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(100621);
        nC();
        c localc = (c)this.aBP.get(paramString);
        if ((localc == null) || (localc.aCb != null))
        {
          AppMethodBeat.o(100621);
          bool = false;
          return bool;
          this.size -= localc.aBY[i];
          localc.aBY[i] = 0L;
          i += 1;
        }
        if (i < this.aBN)
        {
          File localFile = localc.aBZ[i];
          if ((!localFile.exists()) || (localFile.delete())) {
            continue;
          }
          paramString = new IOException("failed to delete ".concat(String.valueOf(localFile)));
          AppMethodBeat.o(100621);
          throw paramString;
        }
      }
      finally {}
      this.aBQ += 1;
      this.aBO.append("REMOVE");
      this.aBO.append(' ');
      this.aBO.append(paramString);
      this.aBO.append('\n');
      this.aBP.remove(paramString);
      if (nB()) {
        this.aBS.submit(this.aBT);
      }
      boolean bool = true;
      AppMethodBeat.o(100621);
    }
  }
  
  private void trimToSize()
  {
    AppMethodBeat.i(100624);
    while (this.size > this.maxSize) {
      remove((String)((Map.Entry)this.aBP.entrySet().iterator().next()).getKey());
    }
    AppMethodBeat.o(100624);
  }
  
  public final d O(String paramString)
  {
    int i = 0;
    Object localObject = null;
    c localc;
    try
    {
      AppMethodBeat.i(100617);
      nC();
      localc = (c)this.aBP.get(paramString);
      if (localc == null) {
        AppMethodBeat.o(100617);
      }
      for (paramString = localObject;; paramString = localObject)
      {
        return paramString;
        if (localc.readable) {
          break;
        }
        AppMethodBeat.o(100617);
      }
      arrayOfFile = localc.aBZ;
    }
    finally {}
    File[] arrayOfFile;
    int j = arrayOfFile.length;
    for (;;)
    {
      if (i < j)
      {
        if (arrayOfFile[i].exists()) {
          break label215;
        }
        AppMethodBeat.o(100617);
        paramString = localObject;
        break;
      }
      this.aBQ += 1;
      this.aBO.append("READ");
      this.aBO.append(' ');
      this.aBO.append(paramString);
      this.aBO.append('\n');
      if (nB()) {
        this.aBS.submit(this.aBT);
      }
      paramString = new d(paramString, localc.aCc, localc.aBZ, localc.aBY, (byte)0);
      AppMethodBeat.o(100617);
      break;
      label215:
      i += 1;
    }
  }
  
  public final b P(String paramString)
  {
    label183:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(100618);
        nC();
        c localc = (c)this.aBP.get(paramString);
        if ((-1L != -1L) && ((localc == null) || (localc.aCc != -1L)))
        {
          AppMethodBeat.o(100618);
          paramString = null;
          return paramString;
        }
        if (localc == null)
        {
          localc = new c(paramString, (byte)0);
          this.aBP.put(paramString, localc);
          b localb = new b(localc, (byte)0);
          localc.aCb = localb;
          this.aBO.append("DIRTY");
          this.aBO.append(' ');
          this.aBO.append(paramString);
          this.aBO.append('\n');
          this.aBO.flush();
          AppMethodBeat.o(100618);
          paramString = localb;
          continue;
        }
        if (localc.aCb == null) {
          break label183;
        }
      }
      finally {}
      AppMethodBeat.o(100618);
      paramString = null;
    }
  }
  
  public final void close()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(100623);
        if (this.aBO == null)
        {
          AppMethodBeat.o(100623);
          return;
        }
        Iterator localIterator = new ArrayList(this.aBP.values()).iterator();
        if (localIterator.hasNext())
        {
          c localc = (c)localIterator.next();
          if (localc.aCb == null) {
            continue;
          }
          localc.aCb.abort();
          continue;
        }
        trimToSize();
      }
      finally {}
      this.aBO.close();
      this.aBO = null;
      AppMethodBeat.o(100623);
    }
  }
  
  public final class b
  {
    final a.c aBV;
    final boolean[] aBW;
    public boolean aBX;
    
    private b(a.c paramc)
    {
      AppMethodBeat.i(100629);
      this.aBV = paramc;
      if (paramc.readable) {}
      for (this$1 = null;; this$1 = new boolean[a.f(a.this)])
      {
        this.aBW = a.this;
        AppMethodBeat.o(100629);
        return;
      }
    }
    
    public final void abort()
    {
      AppMethodBeat.i(100631);
      a.a(a.this, this, false);
      AppMethodBeat.o(100631);
    }
    
    public final File nD()
    {
      AppMethodBeat.i(100630);
      synchronized (a.this)
      {
        if (this.aBV.aCb != this)
        {
          IllegalStateException localIllegalStateException = new IllegalStateException();
          AppMethodBeat.o(100630);
          throw localIllegalStateException;
        }
      }
      if (!this.aBV.readable) {
        this.aBW[0] = true;
      }
      File localFile = this.aBV.aCa[0];
      if (!a.g(a.this).exists()) {
        a.g(a.this).mkdirs();
      }
      AppMethodBeat.o(100630);
      return localFile;
    }
    
    public final void nE()
    {
      AppMethodBeat.i(100632);
      if (!this.aBX) {
        try
        {
          abort();
          AppMethodBeat.o(100632);
          return;
        }
        catch (IOException localIOException) {}
      }
      AppMethodBeat.o(100632);
    }
  }
  
  final class c
  {
    final long[] aBY;
    File[] aBZ;
    File[] aCa;
    a.b aCb;
    long aCc;
    final String key;
    boolean readable;
    
    private c(String paramString)
    {
      AppMethodBeat.i(100633);
      this.key = paramString;
      this.aBY = new long[a.f(a.this)];
      this.aBZ = new File[a.f(a.this)];
      this.aCa = new File[a.f(a.this)];
      paramString = new StringBuilder(paramString).append('.');
      int j = paramString.length();
      int i = 0;
      while (i < a.f(a.this))
      {
        paramString.append(i);
        this.aBZ[i] = new File(a.g(a.this), paramString.toString());
        paramString.append(".tmp");
        this.aCa[i] = new File(a.g(a.this), paramString.toString());
        paramString.setLength(j);
        i += 1;
      }
      AppMethodBeat.o(100633);
    }
    
    private static IOException d(String[] paramArrayOfString)
    {
      AppMethodBeat.i(100636);
      paramArrayOfString = new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
      AppMethodBeat.o(100636);
      throw paramArrayOfString;
    }
    
    final void c(String[] paramArrayOfString)
    {
      AppMethodBeat.i(100635);
      if (paramArrayOfString.length != a.f(a.this))
      {
        paramArrayOfString = d(paramArrayOfString);
        AppMethodBeat.o(100635);
        throw paramArrayOfString;
      }
      int i = 0;
      try
      {
        while (i < paramArrayOfString.length)
        {
          this.aBY[i] = Long.parseLong(paramArrayOfString[i]);
          i += 1;
        }
        AppMethodBeat.o(100635);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        paramArrayOfString = d(paramArrayOfString);
        AppMethodBeat.o(100635);
        throw paramArrayOfString;
      }
    }
    
    public final String nF()
    {
      AppMethodBeat.i(100634);
      Object localObject = new StringBuilder();
      long[] arrayOfLong = this.aBY;
      int j = arrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        long l = arrayOfLong[i];
        ((StringBuilder)localObject).append(' ').append(l);
        i += 1;
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(100634);
      return localObject;
    }
  }
  
  public final class d
  {
    private final long[] aBY;
    private final long aCc;
    public final File[] aCd;
    private final String key;
    
    private d(String paramString, long paramLong, File[] paramArrayOfFile, long[] paramArrayOfLong)
    {
      this.key = paramString;
      this.aCc = paramLong;
      this.aCd = paramArrayOfFile;
      this.aBY = paramArrayOfLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.a.a
 * JD-Core Version:    0.7.0.1
 */