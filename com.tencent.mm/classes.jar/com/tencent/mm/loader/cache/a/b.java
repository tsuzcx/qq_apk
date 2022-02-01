package com.tencent.mm.loader.cache.a;

import android.graphics.Bitmap;
import com.tencent.mm.loader.e.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.x;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/cache/disk/DefaultImageDiskCache;", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "", "Landroid/graphics/Bitmap;", "()V", "mFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "clear", "", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "delete", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "exists", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "save", "source", "Companion", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends d<String, Bitmap>
{
  private static final String TAG = "MicroMsg.Loader.imageloader.DefaultImageDiskCache";
  public static final b.a npa = new b.a((byte)0);
  private g noZ = (g)new com.tencent.mm.loader.d.a();
  
  public final boolean a(com.tencent.mm.loader.g.a.a<String> parama, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    return true;
  }
  
  public final boolean a(com.tencent.mm.loader.g.a.a<String> parama, com.tencent.mm.loader.g.f<?> paramf, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    s.u(parama, "url");
    s.u(paramf, "httpResponse");
    s.u(parame, "opts");
    s.u(paramf1, "reaper");
    return true;
  }
  
  public final boolean a(com.tencent.mm.loader.g.a.a<String> parama, com.tencent.mm.loader.g.f<?> paramf, com.tencent.mm.loader.g.e<Bitmap> parame1, com.tencent.mm.loader.g.e<Bitmap> parame2, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    s.u(parama, "url");
    s.u(paramf, "httpResponse");
    s.u(parame1, "source");
    s.u(parame, "opts");
    s.u(paramf1, "reaper");
    Object localObject;
    int i;
    if (a(parama, paramf, parame, paramf1))
    {
      parame1 = c(parama, parame, paramf1);
      Log.i(TAG, "save " + parama + " filePath " + parame1);
      localObject = c.npb;
      localObject = c.GF(parame1);
      if (localObject != null)
      {
        parame1 = (Closeable)localObject;
        i = 0;
        if (parame2 == null) {}
      }
    }
    try
    {
      c localc = c.npb;
      parame2 = parame2.value;
      s.s(parame2, "it.value()");
      c.a((Bitmap)parame2, (OutputStream)localObject);
      i = 1;
      if (i == 0) {
        paramf.b((OutputStream)localObject);
      }
      a(parama, parame, paramf1);
      parama = ah.aiuX;
      kotlin.f.b.a(parame1, null);
      return true;
    }
    finally
    {
      try
      {
        throw parama;
      }
      finally
      {
        kotlin.f.b.a(parame1, parama);
      }
    }
  }
  
  public final com.tencent.mm.loader.g.b.a b(com.tencent.mm.loader.g.a.a<String> parama, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    try
    {
      if (parama.bmh() == com.tencent.mm.loader.g.a.b.nsr) {
        return com.tencent.mm.loader.g.b.a.GK(parama.bmi());
      }
      if (parama.bmh() == com.tencent.mm.loader.g.a.b.nss)
      {
        com.tencent.mm.loader.g.b.a locala = com.tencent.mm.loader.g.b.a.o(parama.bmi(), com.tencent.mm.vending.j.b.gT(parama.bmi()));
        return locala;
      }
    }
    catch (Exception localException) {}
    label137:
    for (;;)
    {
      try
      {
        parama = c(parama, parame, paramf);
        parame = (CharSequence)parama;
        if (parame == null) {
          break label127;
        }
        if (parame.length() != 0) {
          break label137;
        }
      }
      catch (FileNotFoundException parama)
      {
        return null;
      }
      parama = com.tencent.mm.loader.g.b.a.a((InputStream)new x(parama), (InputStream)new x(parama));
      return parama;
      label127:
      for (int i = 1; i != 0; i = 0) {
        return null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.cache.a.b
 * JD-Core Version:    0.7.0.1
 */