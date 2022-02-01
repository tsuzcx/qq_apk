package com.tencent.mm.loader.cache.a;

import com.tencent.mm.loader.e.g;
import com.tencent.mm.loader.k.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "T", "R", "", "()V", "mFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "clear", "", "configure", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "delete", "", "diskGet", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "exists", "get", "makeConfig", "onSaveCompleted", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "save", "source", "Companion", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d<T, R>
{
  private static final String TAG = "MicroMsg.Loader.IDiskCache";
  public static final d.a npc = new d.a((byte)0);
  private g noZ = (g)new com.tencent.mm.loader.d.a();
  
  public abstract boolean a(com.tencent.mm.loader.g.a.a<T> parama, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, R> paramf);
  
  public abstract boolean a(com.tencent.mm.loader.g.a.a<T> parama, com.tencent.mm.loader.g.f<?> paramf, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, R> paramf1);
  
  public abstract boolean a(com.tencent.mm.loader.g.a.a<T> parama, com.tencent.mm.loader.g.f<?> paramf, com.tencent.mm.loader.g.e<R> parame1, com.tencent.mm.loader.g.e<R> parame2, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, R> paramf1);
  
  public abstract com.tencent.mm.loader.g.b.a b(com.tencent.mm.loader.g.a.a<T> parama, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, R> paramf);
  
  public String c(com.tencent.mm.loader.g.a.a<T> parama, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, R> paramf)
  {
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    String str = parame.fullPath;
    if (str != null)
    {
      paramf = str;
      if (str.length() != 0) {}
    }
    else
    {
      paramf = parame.fullPath;
    }
    if (paramf != null)
    {
      parame = paramf;
      if (paramf.length() != 0) {}
    }
    else
    {
      parame = new StringBuilder().append(b.ntc).append('/');
      paramf = this.noZ;
      s.checkNotNull(paramf);
      parame = paramf.e(parama);
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
 * Qualified Name:     com.tencent.mm.loader.cache.a.d
 * JD-Core Version:    0.7.0.1
 */