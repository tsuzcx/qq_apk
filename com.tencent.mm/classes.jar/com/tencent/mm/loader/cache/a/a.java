package com.tencent.mm.loader.cache.a;

import android.graphics.Bitmap;
import com.tencent.mm.loader.e.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.Closeable;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.f.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "T", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "Landroid/graphics/Bitmap;", "()V", "mFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "delete", "", "exists", "save", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "source", "Lcom/tencent/mm/loader/model/Resource;", "resource", "Companion", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a<T>
  extends d<T, Bitmap>
{
  private static final String TAG = "MicroMsg.Loader.IDiskCache";
  public static final a.a noY = new a.a((byte)0);
  private g noZ = (g)new com.tencent.mm.loader.d.a();
  
  public boolean a(com.tencent.mm.loader.g.a.a<T> parama, com.tencent.mm.loader.g.f<?> paramf, com.tencent.mm.loader.g.e<Bitmap> parame1, com.tencent.mm.loader.g.e<Bitmap> parame2, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    s.u(parama, "url");
    s.u(paramf, "httpResponse");
    s.u(parame1, "source");
    s.u(parame, "opts");
    s.u(paramf1, "reaper");
    Object localObject;
    OutputStream localOutputStream;
    if (a(parama, paramf, parame, paramf1))
    {
      parame1 = c(parama, parame, paramf1);
      Log.i(TAG, "save " + parama + " filePath " + parame1);
      localObject = c.npb;
      localOutputStream = c.GF(parame1);
      if (localOutputStream != null)
      {
        localObject = (Closeable)localOutputStream;
        if (parame2 != null) {
          break label173;
        }
        parame1 = null;
        if ((parame2 == null) || (parame1 == null)) {
          break label197;
        }
      }
    }
    for (;;)
    {
      try
      {
        parame2 = c.npb;
        c.a(parame1, localOutputStream);
        i = 1;
        if (i == 0) {
          paramf.b(localOutputStream);
        }
        a(parama, parame, paramf1);
        parama = ah.aiuX;
        b.a((Closeable)localObject, null);
        return true;
      }
      finally
      {
        try
        {
          label173:
          throw parama;
        }
        finally
        {
          b.a((Closeable)localObject, parama);
        }
      }
      parame1 = (Bitmap)parame2.value;
      break;
      label197:
      int i = 0;
    }
  }
  
  public String c(com.tencent.mm.loader.g.a.a<T> parama, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    return super.c(parama, parame, paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.cache.a.a
 * JD-Core Version:    0.7.0.1
 */