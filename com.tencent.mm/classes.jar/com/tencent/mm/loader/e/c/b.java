package com.tencent.mm.loader.e.c;

import com.tencent.mm.loader.d.f;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "RESOURCE", "Lcom/tencent/mm/loader/common/ITranscoderProducer;", "()V", "nextTransCoder", "getNextTransCoder$libimageloader_release", "()Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "setNextTransCoder$libimageloader_release", "(Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;)V", "priority", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$PRIORITY;", "getPriority$libimageloader_release", "()Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$PRIORITY;", "setPriority$libimageloader_release", "(Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$PRIORITY;)V", "whenIf", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;", "getWhenIf$libimageloader_release", "()Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;", "setWhenIf$libimageloader_release", "(Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;)V", "append", "next", "whenDecode", "whenDownload", "whenLoad", "PRIORITY", "WHENIF", "libimageloader_release"})
public abstract class b<RESOURCE>
  implements f<RESOURCE, RESOURCE>
{
  public b<?> gLi;
  public a gLj = a.gLm;
  public b gLk = b.gLp;
  
  public final b<RESOURCE> aoy()
  {
    this.gLk = b.gLq;
    return this;
  }
  
  public final b<?> b(b<?> paramb)
  {
    k.h(paramb, "next");
    if (this.gLi == null)
    {
      this.gLi = paramb;
      return this;
    }
    b localb = this.gLi;
    if (localb == null) {
      k.fOy();
    }
    localb.b(paramb);
    return this;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$PRIORITY;", "", "(Ljava/lang/String;I)V", "LOW", "NORMAL", "HIGH", "libimageloader_release"})
  public static enum a
  {
    static
    {
      a locala1 = new a("LOW", 0);
      gLl = locala1;
      a locala2 = new a("NORMAL", 1);
      gLm = locala2;
      a locala3 = new a("HIGH", 2);
      gLn = locala3;
      gLo = new a[] { locala1, locala2, locala3 };
    }
    
    private a() {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;", "", "(Ljava/lang/String;I)V", "LOADED", "DECODED", "DOWNLOADED", "libimageloader_release"})
  public static enum b
  {
    static
    {
      b localb1 = new b("LOADED", 0);
      gLp = localb1;
      b localb2 = new b("DECODED", 1);
      gLq = localb2;
      b localb3 = new b("DOWNLOADED", 2);
      gLr = localb3;
      gLs = new b[] { localb1, localb2, localb3 };
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.e.c.b
 * JD-Core Version:    0.7.0.1
 */