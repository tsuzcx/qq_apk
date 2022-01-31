package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Environment;
import com.tencent.luggage.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class s
  implements o
{
  public final LinkedList<o> had;
  private final o hae;
  
  public s(String paramString)
  {
    AppMethodBeat.i(105390);
    this.hae = new g();
    this.had = new LinkedList();
    Object localObject1 = new File(Environment.getExternalStorageDirectory(), "luggage/".concat(String.valueOf(paramString)));
    paramString = this.had;
    Object localObject2 = ((File)localObject1).getAbsolutePath();
    localObject1 = new l(new File((String)localObject2, "objects/").getAbsolutePath(), "default_obfuscation_key", "wxfile://");
    localObject2 = new w(new File((String)localObject2, "files/").getAbsolutePath());
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(localObject1);
    localLinkedList.add(localObject2);
    paramString.addAll(localLinkedList);
    AppMethodBeat.o(105390);
  }
  
  public final j Y(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(105396);
    paramString = zn(paramString).Y(paramString, paramBoolean);
    AppMethodBeat.o(105396);
    return paramString;
  }
  
  public final <T extends o> T Y(Class<T> paramClass)
  {
    AppMethodBeat.i(105392);
    Iterator localIterator = this.had.iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (paramClass.isInstance(localo))
      {
        AppMethodBeat.o(105392);
        return localo;
      }
    }
    AppMethodBeat.o(105392);
    return null;
  }
  
  public final j Z(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(105397);
    paramString = zn(paramString).Z(paramString, paramBoolean);
    AppMethodBeat.o(105397);
    return paramString;
  }
  
  public final j a(com.tencent.mm.plugin.appbrand.s.j<String> paramj)
  {
    AppMethodBeat.i(105412);
    Iterator localIterator = this.had.iterator();
    while (localIterator.hasNext())
    {
      j localj = ((o)localIterator.next()).a(paramj);
      if (localj != j.gZO)
      {
        AppMethodBeat.o(105412);
        return localj;
      }
    }
    paramj = j.gZO;
    AppMethodBeat.o(105412);
    return paramj;
  }
  
  public final j a(File paramFile, String paramString, com.tencent.mm.plugin.appbrand.s.j<String> paramj)
  {
    AppMethodBeat.i(105414);
    Iterator localIterator = this.had.iterator();
    while (localIterator.hasNext())
    {
      j localj = ((o)localIterator.next()).a(paramFile, paramString, paramj);
      if (localj != j.gZO)
      {
        AppMethodBeat.o(105414);
        return localj;
      }
    }
    paramFile = j.gZO;
    AppMethodBeat.o(105414);
    return paramFile;
  }
  
  public j a(File paramFile, String paramString, boolean paramBoolean, com.tencent.mm.plugin.appbrand.s.j<String> paramj)
  {
    AppMethodBeat.i(105413);
    Iterator localIterator = this.had.iterator();
    while (localIterator.hasNext())
    {
      j localj = ((o)localIterator.next()).a(paramFile, paramString, paramBoolean, paramj);
      if (localj != j.gZO)
      {
        AppMethodBeat.o(105413);
        return localj;
      }
    }
    paramFile = j.gZO;
    AppMethodBeat.o(105413);
    return paramFile;
  }
  
  public final j a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(105402);
    paramString = zn(paramString).a(paramString, paramFileStructStat);
    AppMethodBeat.o(105402);
    return paramString;
  }
  
  public j a(String paramString, com.tencent.mm.plugin.appbrand.s.j<List<h>> paramj)
  {
    AppMethodBeat.i(105398);
    paramString = zn(paramString).a(paramString, paramj);
    AppMethodBeat.o(105398);
    return paramString;
  }
  
  public final j a(String paramString, File paramFile, boolean paramBoolean)
  {
    AppMethodBeat.i(105404);
    paramString = zn(paramString).a(paramString, paramFile, paramBoolean);
    AppMethodBeat.o(105404);
    return paramString;
  }
  
  public final j a(String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    AppMethodBeat.i(105400);
    paramString = zn(paramString).a(paramString, paramInputStream, paramBoolean);
    AppMethodBeat.o(105400);
    return paramString;
  }
  
  public final File aa(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(105406);
    paramString = zn(paramString).aa(paramString, paramBoolean);
    AppMethodBeat.o(105406);
    return paramString;
  }
  
  public List<? extends o.a> awJ()
  {
    AppMethodBeat.i(105415);
    List localList = ((l)Y(l.class)).gZT.awK();
    AppMethodBeat.o(105415);
    return localList;
  }
  
  public final j b(String paramString, com.tencent.mm.plugin.appbrand.s.j<ByteBuffer> paramj)
  {
    AppMethodBeat.i(105399);
    paramString = zn(paramString).b(paramString, paramj);
    AppMethodBeat.o(105399);
    return paramString;
  }
  
  public final j b(String paramString, File paramFile)
  {
    AppMethodBeat.i(105407);
    paramString = zn(paramString).b(paramString, paramFile);
    AppMethodBeat.o(105407);
    return paramString;
  }
  
  public final boolean bL(String paramString)
  {
    AppMethodBeat.i(105408);
    int i = 0;
    while (i < 3)
    {
      if (com.tencent.luggage.g.h.x(paramString, new String[] { "file://", "http://", "https://" }[i]))
      {
        AppMethodBeat.o(105408);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(105408);
    return true;
  }
  
  public final j h(String paramString, List<u> paramList)
  {
    AppMethodBeat.i(105403);
    paramString = zn(paramString).h(paramString, paramList);
    AppMethodBeat.o(105403);
    return paramString;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(105409);
    Iterator localIterator = this.had.iterator();
    while (localIterator.hasNext()) {
      ((o)localIterator.next()).initialize();
    }
    this.hae.initialize();
    AppMethodBeat.o(105409);
  }
  
  public final void release()
  {
    AppMethodBeat.i(105410);
    Iterator localIterator = this.had.iterator();
    while (localIterator.hasNext()) {
      ((o)localIterator.next()).release();
    }
    this.had.clear();
    this.hae.release();
    AppMethodBeat.o(105410);
  }
  
  public final j zd(String paramString)
  {
    AppMethodBeat.i(105394);
    paramString = zn(paramString).zd(paramString);
    AppMethodBeat.o(105394);
    return paramString;
  }
  
  public final j ze(String paramString)
  {
    AppMethodBeat.i(105395);
    paramString = zn(paramString).ze(paramString);
    AppMethodBeat.o(105395);
    return paramString;
  }
  
  public final j zf(String paramString)
  {
    AppMethodBeat.i(105401);
    paramString = zn(paramString).zf(paramString);
    AppMethodBeat.o(105401);
    return paramString;
  }
  
  public final File zg(String paramString)
  {
    AppMethodBeat.i(105405);
    paramString = aa(paramString, false);
    AppMethodBeat.o(105405);
    return paramString;
  }
  
  public b zh(String paramString)
  {
    AppMethodBeat.i(105411);
    paramString = ((l)Y(l.class)).zh(paramString);
    AppMethodBeat.o(105411);
    return paramString;
  }
  
  public final boolean zi(String paramString)
  {
    AppMethodBeat.i(105416);
    boolean bool = ((l)Y(l.class)).zi(paramString);
    AppMethodBeat.o(105416);
    return bool;
  }
  
  public final InputStream zj(String paramString)
  {
    AppMethodBeat.i(105391);
    com.tencent.mm.plugin.appbrand.s.j localj = new com.tencent.mm.plugin.appbrand.s.j();
    if (b(paramString, localj) == j.gZA)
    {
      paramString = new a((ByteBuffer)localj.value);
      AppMethodBeat.o(105391);
      return paramString;
    }
    AppMethodBeat.o(105391);
    return null;
  }
  
  public final o zn(String paramString)
  {
    AppMethodBeat.i(105393);
    if (bo.isNullOrNil(paramString))
    {
      paramString = this.hae;
      AppMethodBeat.o(105393);
      return paramString;
    }
    Iterator localIterator = this.had.iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (localo.bL(paramString))
      {
        AppMethodBeat.o(105393);
        return localo;
      }
    }
    paramString = this.hae;
    AppMethodBeat.o(105393);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.s
 * JD-Core Version:    0.7.0.1
 */