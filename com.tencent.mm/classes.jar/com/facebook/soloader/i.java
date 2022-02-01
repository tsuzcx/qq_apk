package com.facebook.soloader;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class i
  extends q
{
  protected final File cCG;
  protected final String cCH;
  
  public i(Context paramContext, String paramString1, File paramFile, String paramString2)
  {
    super(paramContext, paramString1);
    this.cCG = paramFile;
    this.cCH = paramString2;
  }
  
  protected q.f PO()
  {
    AppMethodBeat.i(208090);
    b localb = new b(this);
    AppMethodBeat.o(208090);
    return localb;
  }
  
  public final File PU()
  {
    return this.cCG;
  }
  
  static final class a
    extends q.a
    implements Comparable
  {
    final ZipEntry cCI;
    final int cCJ;
    
    a(String paramString, ZipEntry paramZipEntry, int paramInt)
    {
      super(String.format("pseudo-zip-hash-1-%s-%s-%s-%s", new Object[] { paramZipEntry.getName(), Long.valueOf(paramZipEntry.getSize()), Long.valueOf(paramZipEntry.getCompressedSize()), Long.valueOf(paramZipEntry.getCrc()) }));
      AppMethodBeat.i(208152);
      this.cCI = paramZipEntry;
      this.cCJ = paramInt;
      AppMethodBeat.o(208152);
    }
    
    public final int compareTo(Object paramObject)
    {
      AppMethodBeat.i(208162);
      int i = this.name.compareTo(((a)paramObject).name);
      AppMethodBeat.o(208162);
      return i;
    }
  }
  
  protected class b
    extends q.f
  {
    final ZipFile cCC;
    i.a[] cCK;
    private final q cCL;
    
    b(q paramq)
    {
      AppMethodBeat.i(208170);
      this.cCC = new ZipFile(i.this.cCG);
      this.cCL = paramq;
      AppMethodBeat.o(208170);
    }
    
    final i.a[] PV()
    {
      AppMethodBeat.i(208182);
      if (this.cCK == null)
      {
        localObject1 = new LinkedHashSet();
        Object localObject2 = new HashMap();
        Pattern localPattern = Pattern.compile(i.this.cCH);
        String[] arrayOfString = SysUtil.getSupportedAbis();
        Enumeration localEnumeration = this.cCC.entries();
        while (localEnumeration.hasMoreElements())
        {
          ZipEntry localZipEntry = (ZipEntry)localEnumeration.nextElement();
          Object localObject4 = localPattern.matcher(localZipEntry.getName());
          if (((Matcher)localObject4).matches())
          {
            Object localObject3 = ((Matcher)localObject4).group(1);
            localObject4 = ((Matcher)localObject4).group(2);
            i = SysUtil.a(arrayOfString, (String)localObject3);
            if (i >= 0)
            {
              ((Set)localObject1).add(localObject3);
              localObject3 = (i.a)((HashMap)localObject2).get(localObject4);
              if ((localObject3 == null) || (i < ((i.a)localObject3).cCJ)) {
                ((HashMap)localObject2).put(localObject4, new i.a((String)localObject4, localZipEntry, i));
              }
            }
          }
        }
        this.cCL.cDr = ((String[])((Set)localObject1).toArray(new String[((Set)localObject1).size()]));
        localObject1 = (i.a[])((HashMap)localObject2).values().toArray(new i.a[((HashMap)localObject2).size()]);
        Arrays.sort((Object[])localObject1);
        int i = 0;
        int j = 0;
        if (i < localObject1.length)
        {
          localObject2 = localObject1[i];
          if (a(((i.a)localObject2).cCI, ((i.a)localObject2).name)) {
            j += 1;
          }
          for (;;)
          {
            i += 1;
            break;
            localObject1[i] = null;
          }
        }
        localObject2 = new i.a[j];
        i = 0;
        int k;
        for (j = 0; i < localObject1.length; j = k)
        {
          localPattern = localObject1[i];
          k = j;
          if (localPattern != null)
          {
            localObject2[j] = localPattern;
            k = j + 1;
          }
          i += 1;
        }
        this.cCK = ((i.a[])localObject2);
      }
      Object localObject1 = this.cCK;
      AppMethodBeat.o(208182);
      return localObject1;
    }
    
    public final q.b PW()
    {
      AppMethodBeat.i(208196);
      q.b localb = new q.b(PV());
      AppMethodBeat.o(208196);
      return localb;
    }
    
    protected final q.d PX()
    {
      AppMethodBeat.i(208200);
      a locala = new a((byte)0);
      AppMethodBeat.o(208200);
      return locala;
    }
    
    protected boolean a(ZipEntry paramZipEntry, String paramString)
    {
      return true;
    }
    
    public void close()
    {
      AppMethodBeat.i(208193);
      this.cCC.close();
      AppMethodBeat.o(208193);
    }
    
    final class a
      extends q.d
    {
      private int cCN;
      
      private a() {}
      
      public final q.c PY()
      {
        AppMethodBeat.i(208158);
        i.b.this.PV();
        Object localObject1 = i.b.this.cCK;
        int i = this.cCN;
        this.cCN = (i + 1);
        Object localObject2 = localObject1[i];
        localObject1 = i.b.this.cCC.getInputStream(((i.a)localObject2).cCI);
        try
        {
          localObject2 = new q.e((q.a)localObject2, (InputStream)localObject1);
          AppMethodBeat.o(208158);
          return localObject2;
        }
        finally
        {
          if (localObject1 != null) {
            ((InputStream)localObject1).close();
          }
          AppMethodBeat.o(208158);
        }
      }
      
      public final boolean hasNext()
      {
        AppMethodBeat.i(208141);
        i.b.this.PV();
        if (this.cCN < i.b.this.cCK.length)
        {
          AppMethodBeat.o(208141);
          return true;
        }
        AppMethodBeat.o(208141);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.soloader.i
 * JD-Core Version:    0.7.0.1
 */