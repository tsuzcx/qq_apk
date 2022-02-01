package com.tencent.mm.loader.b.a;

import com.tencent.mm.loader.f.g;
import com.tencent.mm.loader.l.b;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "T", "R", "", "()V", "mFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "clear", "", "configure", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "delete", "", "diskGet", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "exists", "get", "makeConfig", "onSaveCompleted", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "save", "source", "Companion", "libimageloader_release"})
public abstract class d<T, R>
{
  private static final String TAG = "MicroMsg.Loader.IDiskCache";
  public static final d.a hfP = new d.a((byte)0);
  private g hfL;
  
  public abstract boolean a(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, R> paramf);
  
  public abstract boolean a(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, R> paramf1);
  
  public abstract boolean a(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.h.e<R> parame1, com.tencent.mm.loader.h.e<R> parame2, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, R> paramf1);
  
  public abstract com.tencent.mm.loader.h.b.a b(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, R> paramf);
  
  public String c(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, R> paramf)
  {
    p.h(parama, "url");
    p.h(parame, "opts");
    p.h(paramf, "reaper");
    String str = parame.hgD;
    if (str != null)
    {
      paramf = str;
      if (str.length() != 0) {}
    }
    else
    {
      paramf = parame.hgD;
    }
    if (paramf != null)
    {
      parame = paramf;
      if (paramf.length() != 0) {}
    }
    else
    {
      parame = new StringBuilder().append(b.hjX).append("/");
      paramf = this.hfL;
      if (paramf == null) {
        p.gkB();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.b.a.d
 * JD-Core Version:    0.7.0.1
 */