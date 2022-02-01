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
  private final File aAP;
  private final File aAQ;
  private final File aAR;
  private final int aAS;
  private final int aAT;
  private Writer aAU;
  private final LinkedHashMap<String, c> aAV;
  private int aAW;
  private long aAX;
  final ThreadPoolExecutor aAY;
  private final Callable<Void> aAZ;
  private final File directory;
  private long maxSize;
  private long size;
  
  private a(File paramFile, long paramLong)
  {
    AppMethodBeat.i(100610);
    this.size = 0L;
    this.aAV = new LinkedHashMap(0, 0.75F, true);
    this.aAX = 0L;
    this.aAY = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a.a((byte)0));
    this.aAZ = new Callable()
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
    this.aAS = 1;
    this.aAP = new File(paramFile, "journal");
    this.aAQ = new File(paramFile, "journal.tmp");
    this.aAR = new File(paramFile, "journal.bkp");
    this.aAT = 1;
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
      localc = paramb.aBb;
      if (localc.aBi != paramb)
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
          if (i >= this.aAT) {
            break;
          }
          if (paramb.aBc[i] == 0)
          {
            paramb.abort();
            paramb = new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
            AppMethodBeat.o(100619);
            throw paramb;
          }
          if (!localc.aBg[i].exists())
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
      if (j < this.aAT)
      {
        paramb = localc.aBg[j];
        if (paramBoolean)
        {
          if (paramb.exists())
          {
            File localFile = localc.aBf[j];
            paramb.renameTo(localFile);
            l1 = localc.aBe[j];
            long l2 = localFile.length();
            localc.aBe[j] = l2;
            this.size = (this.size - l1 + l2);
          }
        }
        else {
          q(paramb);
        }
      }
      else
      {
        this.aAW += 1;
        localc.aBi = null;
        if ((localc.readable | paramBoolean))
        {
          localc.readable = true;
          this.aAU.append("CLEAN");
          this.aAU.append(' ');
          this.aAU.append(localc.key);
          this.aAU.append(localc.nv());
          this.aAU.append('\n');
          if (paramBoolean)
          {
            l1 = this.aAX;
            this.aAX = (1L + l1);
            localc.aBj = l1;
          }
        }
        for (;;)
        {
          this.aAU.flush();
          if ((this.size > this.maxSize) || (nr())) {
            this.aAY.submit(this.aAZ);
          }
          AppMethodBeat.o(100619);
          break;
          this.aAV.remove(localc.key);
          this.aAU.append("REMOVE");
          this.aAU.append(' ');
          this.aAU.append(localc.key);
          this.aAU.append('\n');
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
      if (!((a)localObject).aAP.exists()) {
        break label172;
      }
      try
      {
        ((a)localObject).no();
        ((a)localObject).np();
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
    paramFile.nq();
    AppMethodBeat.o(100611);
    return paramFile;
  }
  
  private void no()
  {
    AppMethodBeat.i(100612);
    b localb = new b(new FileInputStream(this.aAP), c.US_ASCII);
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
      if ((!"libcore.io.DiskLruCache".equals(localObject1)) || (!"1".equals(localObject4)) || (!Integer.toString(this.aAS).equals(localObject5)) || (!Integer.toString(this.aAT).equals(str1)) || (!"".equals(str2)))
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
        this.aAW = (i - this.aAV.size());
        if (localb.end == -1)
        {
          i = 1;
          if (i != 0)
          {
            nq();
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
              this.aAV.remove(localObject3);
              continue;
            }
            Object localObject3 = str1.substring(k, m);
            localObject5 = (c)this.aAV.get(localObject3);
            localObject4 = localObject5;
            if (localObject5 == null)
            {
              localObject4 = new c((String)localObject3, (byte)0);
              this.aAV.put(localObject3, localObject4);
            }
            if ((m != -1) && (j == 5) && (str1.startsWith("CLEAN")))
            {
              localObject3 = str1.substring(m + 1).split(" ");
              ((c)localObject4).readable = true;
              ((c)localObject4).aBi = null;
              ((c)localObject4).c((String[])localObject3);
              continue;
            }
            if ((m == -1) && (j == 5) && (str1.startsWith("DIRTY")))
            {
              ((c)localObject4).aBi = new b((c)localObject4, (byte)0);
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
        this.aAU = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aAP, true), c.US_ASCII));
        continue;
        continue;
        i += 1;
      }
    }
  }
  
  private void np()
  {
    AppMethodBeat.i(100613);
    q(this.aAQ);
    Iterator localIterator = this.aAV.values().iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      int i;
      if (localc.aBi == null)
      {
        i = 0;
        while (i < this.aAT)
        {
          this.size += localc.aBe[i];
          i += 1;
        }
      }
      else
      {
        localc.aBi = null;
        i = 0;
        while (i < this.aAT)
        {
          q(localc.aBf[i]);
          q(localc.aBg[i]);
          i += 1;
        }
        localIterator.remove();
      }
    }
    AppMethodBeat.o(100613);
  }
  
  private void nq()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(100614);
        if (this.aAU != null) {
          this.aAU.close();
        }
        BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aAQ), c.US_ASCII));
        c localc;
        try
        {
          localBufferedWriter.write("libcore.io.DiskLruCache");
          localBufferedWriter.write("\n");
          localBufferedWriter.write("1");
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.aAS));
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.aAT));
          localBufferedWriter.write("\n");
          localBufferedWriter.write("\n");
          Iterator localIterator = this.aAV.values().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localc = (c)localIterator.next();
          if (localc.aBi != null)
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
        localObject1.write("CLEAN " + localc.key + localc.nv() + '\n');
      }
      finally {}
    }
    localObject1.close();
    if (this.aAP.exists()) {
      a(this.aAP, this.aAR, true);
    }
    a(this.aAQ, this.aAP, false);
    this.aAR.delete();
    this.aAU = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aAP, true), c.US_ASCII));
    AppMethodBeat.o(100614);
  }
  
  private boolean nr()
  {
    AppMethodBeat.i(100620);
    if ((this.aAW >= 2000) && (this.aAW >= this.aAV.size()))
    {
      AppMethodBeat.o(100620);
      return true;
    }
    AppMethodBeat.o(100620);
    return false;
  }
  
  private void ns()
  {
    AppMethodBeat.i(100622);
    if (this.aAU == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("cache is closed");
      AppMethodBeat.o(100622);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(100622);
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
        ns();
        c localc = (c)this.aAV.get(paramString);
        if ((localc == null) || (localc.aBi != null))
        {
          AppMethodBeat.o(100621);
          bool = false;
          return bool;
          this.size -= localc.aBe[i];
          localc.aBe[i] = 0L;
          i += 1;
        }
        if (i < this.aAT)
        {
          File localFile = localc.aBf[i];
          if ((!localFile.exists()) || (localFile.delete())) {
            continue;
          }
          paramString = new IOException("failed to delete ".concat(String.valueOf(localFile)));
          AppMethodBeat.o(100621);
          throw paramString;
        }
      }
      finally {}
      this.aAW += 1;
      this.aAU.append("REMOVE");
      this.aAU.append(' ');
      this.aAU.append(paramString);
      this.aAU.append('\n');
      this.aAV.remove(paramString);
      if (nr()) {
        this.aAY.submit(this.aAZ);
      }
      boolean bool = true;
      AppMethodBeat.o(100621);
    }
  }
  
  private void trimToSize()
  {
    AppMethodBeat.i(100624);
    while (this.size > this.maxSize) {
      remove((String)((Map.Entry)this.aAV.entrySet().iterator().next()).getKey());
    }
    AppMethodBeat.o(100624);
  }
  
  public final d M(String paramString)
  {
    int i = 0;
    Object localObject = null;
    c localc;
    try
    {
      AppMethodBeat.i(100617);
      ns();
      localc = (c)this.aAV.get(paramString);
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
      arrayOfFile = localc.aBf;
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
      this.aAW += 1;
      this.aAU.append("READ");
      this.aAU.append(' ');
      this.aAU.append(paramString);
      this.aAU.append('\n');
      if (nr()) {
        this.aAY.submit(this.aAZ);
      }
      paramString = new d(paramString, localc.aBj, localc.aBf, localc.aBe, (byte)0);
      AppMethodBeat.o(100617);
      break;
      label215:
      i += 1;
    }
  }
  
  public final b N(String paramString)
  {
    label183:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(100618);
        ns();
        c localc = (c)this.aAV.get(paramString);
        if ((-1L != -1L) && ((localc == null) || (localc.aBj != -1L)))
        {
          AppMethodBeat.o(100618);
          paramString = null;
          return paramString;
        }
        if (localc == null)
        {
          localc = new c(paramString, (byte)0);
          this.aAV.put(paramString, localc);
          b localb = new b(localc, (byte)0);
          localc.aBi = localb;
          this.aAU.append("DIRTY");
          this.aAU.append(' ');
          this.aAU.append(paramString);
          this.aAU.append('\n');
          this.aAU.flush();
          AppMethodBeat.o(100618);
          paramString = localb;
          continue;
        }
        if (localc.aBi == null) {
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
        if (this.aAU == null)
        {
          AppMethodBeat.o(100623);
          return;
        }
        Iterator localIterator = new ArrayList(this.aAV.values()).iterator();
        if (localIterator.hasNext())
        {
          c localc = (c)localIterator.next();
          if (localc.aBi == null) {
            continue;
          }
          localc.aBi.abort();
          continue;
        }
        trimToSize();
      }
      finally {}
      this.aAU.close();
      this.aAU = null;
      AppMethodBeat.o(100623);
    }
  }
  
  public final class b
  {
    final a.c aBb;
    final boolean[] aBc;
    public boolean aBd;
    
    private b(a.c paramc)
    {
      AppMethodBeat.i(100629);
      this.aBb = paramc;
      if (paramc.readable) {}
      for (this$1 = null;; this$1 = new boolean[a.f(a.this)])
      {
        this.aBc = a.this;
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
    
    public final File nt()
    {
      AppMethodBeat.i(100630);
      synchronized (a.this)
      {
        if (this.aBb.aBi != this)
        {
          IllegalStateException localIllegalStateException = new IllegalStateException();
          AppMethodBeat.o(100630);
          throw localIllegalStateException;
        }
      }
      if (!this.aBb.readable) {
        this.aBc[0] = true;
      }
      File localFile = this.aBb.aBg[0];
      if (!a.g(a.this).exists()) {
        a.g(a.this).mkdirs();
      }
      AppMethodBeat.o(100630);
      return localFile;
    }
    
    public final void nu()
    {
      AppMethodBeat.i(100632);
      if (!this.aBd) {
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
    final long[] aBe;
    File[] aBf;
    File[] aBg;
    a.b aBi;
    long aBj;
    final String key;
    boolean readable;
    
    private c(String paramString)
    {
      AppMethodBeat.i(100633);
      this.key = paramString;
      this.aBe = new long[a.f(a.this)];
      this.aBf = new File[a.f(a.this)];
      this.aBg = new File[a.f(a.this)];
      paramString = new StringBuilder(paramString).append('.');
      int j = paramString.length();
      int i = 0;
      while (i < a.f(a.this))
      {
        paramString.append(i);
        this.aBf[i] = new File(a.g(a.this), paramString.toString());
        paramString.append(".tmp");
        this.aBg[i] = new File(a.g(a.this), paramString.toString());
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
          this.aBe[i] = Long.parseLong(paramArrayOfString[i]);
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
    
    public final String nv()
    {
      AppMethodBeat.i(100634);
      Object localObject = new StringBuilder();
      long[] arrayOfLong = this.aBe;
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
    private final long[] aBe;
    private final long aBj;
    public final File[] aBk;
    private final String key;
    
    private d(String paramString, long paramLong, File[] paramArrayOfFile, long[] paramArrayOfLong)
    {
      this.key = paramString;
      this.aBj = paramLong;
      this.aBk = paramArrayOfFile;
      this.aBe = paramArrayOfLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.bumptech.glide.a.a
 * JD-Core Version:    0.7.0.1
 */