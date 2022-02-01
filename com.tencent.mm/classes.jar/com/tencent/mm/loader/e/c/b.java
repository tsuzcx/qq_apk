package com.tencent.mm.loader.e.c;

import com.tencent.mm.loader.d.f;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "RESOURCE", "Lcom/tencent/mm/loader/common/ITranscoderProducer;", "()V", "nextTransCoder", "getNextTransCoder$libimageloader_release", "()Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "setNextTransCoder$libimageloader_release", "(Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;)V", "priority", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$PRIORITY;", "getPriority$libimageloader_release", "()Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$PRIORITY;", "setPriority$libimageloader_release", "(Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$PRIORITY;)V", "whenIf", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;", "getWhenIf$libimageloader_release", "()Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;", "setWhenIf$libimageloader_release", "(Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;)V", "append", "next", "whenDecode", "whenDownload", "whenLoad", "PRIORITY", "WHENIF", "libimageloader_release"})
public abstract class b<RESOURCE>
  implements f<RESOURCE, RESOURCE>
{
  public b<?> gkv;
  public a gkw = a.gkz;
  public b gkx = b.gkC;
  
  public final b<RESOURCE> ahw()
  {
    this.gkx = b.gkD;
    return this;
  }
  
  public final b<?> c(b<?> paramb)
  {
    k.h(paramb, "next");
    if (this.gkv == null)
    {
      this.gkv = paramb;
      return this;
    }
    b localb = this.gkv;
    if (localb == null) {
      k.fvU();
    }
    localb.c(paramb);
    return this;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$PRIORITY;", "", "(Ljava/lang/String;I)V", "LOW", "NORMAL", "HIGH", "libimageloader_release"})
  public static enum a
  {
    static
    {
      a locala1 = new a("LOW", 0);
      gky = locala1;
      a locala2 = new a("NORMAL", 1);
      gkz = locala2;
      a locala3 = new a("HIGH", 2);
      gkA = locala3;
      gkB = new a[] { locala1, locala2, locala3 };
    }
    
    private a() {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;", "", "(Ljava/lang/String;I)V", "LOADED", "DECODED", "DOWNLOADED", "libimageloader_release"})
  public static enum b
  {
    static
    {
      b localb1 = new b("LOADED", 0);
      gkC = localb1;
      b localb2 = new b("DECODED", 1);
      gkD = localb2;
      b localb3 = new b("DOWNLOADED", 2);
      gkE = localb3;
      gkF = new b[] { localb1, localb2, localb3 };
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.e.c.b
 * JD-Core Version:    0.7.0.1
 */