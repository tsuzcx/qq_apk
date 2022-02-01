package com.tencent.mm.loader.e.c;

import com.tencent.mm.loader.d.f;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "RESOURCE", "Lcom/tencent/mm/loader/common/ITranscoderProducer;", "()V", "nextTransCoder", "getNextTransCoder$libimageloader_release", "()Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "setNextTransCoder$libimageloader_release", "(Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;)V", "priority", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$PRIORITY;", "getPriority$libimageloader_release", "()Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$PRIORITY;", "setPriority$libimageloader_release", "(Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$PRIORITY;)V", "whenIf", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;", "getWhenIf$libimageloader_release", "()Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;", "setWhenIf$libimageloader_release", "(Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;)V", "append", "next", "whenDecode", "whenDownload", "whenLoad", "PRIORITY", "WHENIF", "libimageloader_release"})
public abstract class b<RESOURCE>
  implements f<RESOURCE, RESOURCE>
{
  public b<?> hhL;
  public a hhM = a.hhP;
  public b hhN = b.hhS;
  
  public final b<RESOURCE> arz()
  {
    this.hhN = b.hhT;
    return this;
  }
  
  public final b<?> c(b<?> paramb)
  {
    p.h(paramb, "next");
    if (this.hhL == null)
    {
      this.hhL = paramb;
      return this;
    }
    b localb = this.hhL;
    if (localb == null) {
      p.gkB();
    }
    localb.c(paramb);
    return this;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$PRIORITY;", "", "(Ljava/lang/String;I)V", "LOW", "NORMAL", "HIGH", "libimageloader_release"})
  public static enum a
  {
    static
    {
      a locala1 = new a("LOW", 0);
      hhO = locala1;
      a locala2 = new a("NORMAL", 1);
      hhP = locala2;
      a locala3 = new a("HIGH", 2);
      hhQ = locala3;
      hhR = new a[] { locala1, locala2, locala3 };
    }
    
    private a() {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;", "", "(Ljava/lang/String;I)V", "LOADED", "DECODED", "DOWNLOADED", "libimageloader_release"})
  public static enum b
  {
    static
    {
      b localb1 = new b("LOADED", 0);
      hhS = localb1;
      b localb2 = new b("DECODED", 1);
      hhT = localb2;
      b localb3 = new b("DOWNLOADED", 2);
      hhU = localb3;
      hhV = new b[] { localb1, localb2, localb3 };
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.e.c.b
 * JD-Core Version:    0.7.0.1
 */