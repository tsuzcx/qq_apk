package com.tencent.mm.loader.b.a;

import com.tencent.mm.loader.l.b;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "T", "R", "", "()V", "mFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "clear", "", "configure", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "delete", "", "diskGet", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "exists", "get", "makeConfig", "onSaveCompleted", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "save", "source", "Companion", "libimageloader_release"})
public abstract class d<T, R>
{
  private static final String TAG = "MicroMsg.Loader.IDiskCache";
  public static final d.a gJq = new d.a((byte)0);
  private com.tencent.mm.loader.f.f gJm;
  
  public abstract boolean a(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, R> paramf);
  
  public abstract boolean a(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, R> paramf1);
  
  public abstract boolean a(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.h.e<R> parame1, com.tencent.mm.loader.h.e<R> parame2, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, R> paramf1);
  
  public abstract com.tencent.mm.loader.h.b.a b(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, R> paramf);
  
  public String c(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, R> paramf)
  {
    k.h(parama, "url");
    k.h(parame, "opts");
    k.h(paramf, "reaper");
    String str = parame.gKe;
    if (str != null)
    {
      paramf = str;
      if (str.length() != 0) {}
    }
    else
    {
      paramf = parame.gKe;
    }
    if (paramf != null)
    {
      parame = paramf;
      if (paramf.length() != 0) {}
    }
    else
    {
      parame = new StringBuilder().append(b.gNm).append("/");
      paramf = this.gJm;
      if (paramf == null) {
        k.fOy();
      }
      parame = paramf.b(parama);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.b.a.d
 * JD-Core Version:    0.7.0.1
 */