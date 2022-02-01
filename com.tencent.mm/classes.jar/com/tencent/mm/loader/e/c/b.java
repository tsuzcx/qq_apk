package com.tencent.mm.loader.e.c;

import com.tencent.mm.loader.d.f;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "RESOURCE", "Lcom/tencent/mm/loader/common/ITranscoderProducer;", "()V", "nextTransCoder", "getNextTransCoder$libimageloader_release", "()Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "setNextTransCoder$libimageloader_release", "(Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;)V", "priority", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$PRIORITY;", "getPriority$libimageloader_release", "()Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$PRIORITY;", "setPriority$libimageloader_release", "(Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$PRIORITY;)V", "whenIf", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;", "getWhenIf$libimageloader_release", "()Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;", "setWhenIf$libimageloader_release", "(Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;)V", "append", "next", "whenDecode", "whenDownload", "whenLoad", "PRIORITY", "WHENIF", "libimageloader_release"})
public abstract class b<RESOURCE>
  implements f<RESOURCE, RESOURCE>
{
  public b<?> heX;
  public b.a heY = b.a.hfb;
  public b heZ = b.hfe;
  
  public final b<RESOURCE> ark()
  {
    this.heZ = b.hff;
    return this;
  }
  
  public final b<?> c(b<?> paramb)
  {
    p.h(paramb, "next");
    if (this.heX == null)
    {
      this.heX = paramb;
      return this;
    }
    b localb = this.heX;
    if (localb == null) {
      p.gfZ();
    }
    localb.c(paramb);
    return this;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;", "", "(Ljava/lang/String;I)V", "LOADED", "DECODED", "DOWNLOADED", "libimageloader_release"})
  public static enum b
  {
    static
    {
      b localb1 = new b("LOADED", 0);
      hfe = localb1;
      b localb2 = new b("DECODED", 1);
      hff = localb2;
      b localb3 = new b("DOWNLOADED", 2);
      hfg = localb3;
      hfh = new b[] { localb1, localb2, localb3 };
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.e.c.b
 * JD-Core Version:    0.7.0.1
 */