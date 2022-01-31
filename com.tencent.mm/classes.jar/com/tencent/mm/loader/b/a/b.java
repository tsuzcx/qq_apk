package com.tencent.mm.loader.b.a;

import a.f.b.j;
import a.l;
import a.l.m;
import a.v;
import android.graphics.Bitmap;
import com.tencent.mm.loader.f<*Landroid.graphics.Bitmap;>;
import com.tencent.mm.loader.h.a.a<Ljava.lang.String;>;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.FileNotFoundException;
import java.io.InputStream;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/cache/disk/DefaultImageDiskCache;", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "", "Landroid/graphics/Bitmap;", "()V", "mFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "buildFilePath", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "clear", "", "delete", "", "exists", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "getGeneralFilePathFromOptions", "onSaveCompleted", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "save", "source", "Companion", "libimageloader_release"})
public final class b
  extends d<String, Bitmap>
{
  private static final String TAG = "MicroMsg.Loader.imageloader.DefaultImageDiskCache";
  public static final a eNm = new a((byte)0);
  private com.tencent.mm.loader.f.f eNk;
  
  public final String a(com.tencent.mm.loader.h.a.a<String> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    j.q(parama, "url");
    j.q(parame, "opts");
    j.q(paramf, "reaper");
    String str1 = parame.Tu();
    if (str1 != null)
    {
      paramf = str1;
      if (str1.length() != 0) {}
    }
    else
    {
      String str2 = parame.Ts();
      paramf = str1;
      if (str2 != null)
      {
        paramf = str1;
        if (str2.length() > 0)
        {
          parame = parame.Tt();
          if ((parame == null) || (parame.length() == 0) || (!m.jw(str2, parame)))
          {
            ab.e(TAG, "[johnw] SFS can't deal with absolute path: %s", new Object[] { str2 });
            throw ((Throwable)new IllegalArgumentException("SFS can't deal with absolute path: ".concat(String.valueOf(str2))));
          }
          parame = str2.substring(parame.length());
          j.p(parame, "(this as java.lang.String).substring(startIndex)");
          paramf = parame;
          if (m.jw(parame, "/"))
          {
            if (parame == null) {
              throw new v("null cannot be cast to non-null type java.lang.String");
            }
            paramf = parame.substring(1);
            j.p(paramf, "(this as java.lang.String).substring(startIndex)");
          }
        }
      }
    }
    if (paramf != null)
    {
      parame = paramf;
      if (paramf.length() != 0) {}
    }
    else
    {
      parame = this.eNk;
      if (parame == null) {
        j.ebi();
      }
      parame = parame.b(parama);
    }
    if (parame != null)
    {
      parama = parame;
      if (parame.length() != 0) {}
    }
    else
    {
      parama = "";
    }
    return parama;
  }
  
  public final boolean a(com.tencent.mm.loader.h.a.a<String> parama, com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    j.q(parama, "url");
    j.q(paramf, "httpResponse");
    j.q(parame, "opts");
    j.q(paramf1, "reaper");
    return true;
  }
  
  public final boolean a(com.tencent.mm.loader.h.a.a<String> parama, com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.h.e<Bitmap> parame1, com.tencent.mm.loader.h.e<Bitmap> parame2, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    j.q(parama, "url");
    j.q(paramf, "httpResponse");
    j.q(parame1, "source");
    j.q(parame, "opts");
    j.q(paramf1, "reaper");
    return true;
  }
  
  public final boolean b(com.tencent.mm.loader.h.a.a<String> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    j.q(parama, "url");
    j.q(parame, "opts");
    j.q(paramf, "reaper");
    return true;
  }
  
  public final com.tencent.mm.loader.h.b.a c(com.tencent.mm.loader.h.a.a<String> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    int i = 0;
    j.q(parama, "url");
    j.q(parame, "opts");
    j.q(paramf, "reaper");
    try
    {
      if (parama.Ud() == com.tencent.mm.loader.h.a.b.eQj) {
        return com.tencent.mm.loader.h.b.a.mN(parama.Uf());
      }
      if (parama.Ud() == com.tencent.mm.loader.h.a.b.eQk)
      {
        com.tencent.mm.loader.h.b.a locala = com.tencent.mm.loader.h.b.a.h(parama.Uf(), com.tencent.mm.vending.j.b.cP(parama.Uf()));
        return locala;
      }
    }
    catch (Exception localException) {}
    label384:
    for (;;)
    {
      try
      {
        Object localObject = parame.TC();
        if (localObject != null)
        {
          parama = a(parama, parame, paramf);
          parame = (CharSequence)parama;
          if (parame == null) {
            break label359;
          }
          if (parame.length() != 0) {
            break label362;
          }
          break label359;
          return com.tencent.mm.loader.h.b.a.a(((SFSContext)localObject).openRead(parama), ((SFSContext)localObject).openRead(parama));
        }
        localObject = parame.Ts();
        if (localObject != null)
        {
          paramf = (com.tencent.mm.loader.f<?, Bitmap>)localObject;
          if (((String)localObject).length() != 0) {}
        }
        else
        {
          localObject = parame.Tt();
          paramf = (com.tencent.mm.loader.f<?, Bitmap>)localObject;
          if (localObject != null)
          {
            paramf = (com.tencent.mm.loader.f<?, Bitmap>)localObject;
            if (((String)localObject).length() != 0)
            {
              paramf = new StringBuilder().append((String)localObject).append("/");
              localObject = this.eNk;
              if (localObject == null) {
                j.ebi();
              }
              paramf = ((com.tencent.mm.loader.f.f)localObject).b(parama);
            }
          }
        }
        localObject = paramf;
        if (parame.Tr())
        {
          localObject = paramf;
          if (bo.isNullOrNil(paramf))
          {
            parame = new StringBuilder().append(com.tencent.mm.loader.l.b.Uq()).append("/");
            paramf = this.eNk;
            if (paramf == null) {
              j.ebi();
            }
            localObject = paramf.b(parama);
          }
        }
        if (localObject == null) {
          break label369;
        }
        parama = (com.tencent.mm.loader.h.a.a<String>)localObject;
        if (((String)localObject).length() == 0) {
          break label369;
        }
        parame = (CharSequence)parama;
        if (parame == null) {
          break label374;
        }
        if (parame.length() != 0) {
          break label384;
        }
      }
      catch (FileNotFoundException parama)
      {
        return null;
      }
      parama = com.tencent.mm.loader.h.b.a.a((InputStream)new com.tencent.mm.vfs.d(parama), (InputStream)new com.tencent.mm.vfs.d(parama));
      return parama;
      label359:
      i = 1;
      label362:
      if (i != 0)
      {
        return null;
        label369:
        parama = null;
        continue;
        label374:
        for (i = 1; i != 0; i = 0) {
          return null;
        }
      }
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/cache/disk/DefaultImageDiskCache$Companion;", "", "()V", "TAG", "", "libimageloader_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.loader.b.a.b
 * JD-Core Version:    0.7.0.1
 */