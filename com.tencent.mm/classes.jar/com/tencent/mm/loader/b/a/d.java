package com.tencent.mm.loader.b.a;

import a.f.b.j;
import a.l;
import a.l.m;
import a.v;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "T", "R", "", "()V", "mFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "clear", "", "configure", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "delete", "", "diskGet", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "exists", "get", "makeConfig", "onSaveCompleted", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "save", "source", "Companion", "libimageloader_release"})
public abstract class d<T, R>
{
  private static final String TAG = "MicroMsg.Loader.IDiskCache";
  public static final d.a eNo = new d.a((byte)0);
  private com.tencent.mm.loader.f.f eNk;
  
  public String a(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, R> paramf)
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
  
  public abstract boolean a(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, R> paramf1);
  
  public abstract boolean a(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.h.e<R> parame1, com.tencent.mm.loader.h.e<R> parame2, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, R> paramf1);
  
  public abstract boolean b(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, R> paramf);
  
  public abstract com.tencent.mm.loader.h.b.a c(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, R> paramf);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.loader.b.a.d
 * JD-Core Version:    0.7.0.1
 */