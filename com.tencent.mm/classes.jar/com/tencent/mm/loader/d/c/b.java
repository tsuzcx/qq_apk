package com.tencent.mm.loader.d.c;

import com.tencent.mm.loader.c.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "RESOURCE", "Lcom/tencent/mm/loader/common/ITranscoderProducer;", "()V", "nextTransCoder", "getNextTransCoder$libimageloader_release", "()Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "setNextTransCoder$libimageloader_release", "(Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;)V", "priority", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$PRIORITY;", "getPriority$libimageloader_release", "()Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$PRIORITY;", "setPriority$libimageloader_release", "(Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$PRIORITY;)V", "whenIf", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;", "getWhenIf$libimageloader_release", "()Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;", "setWhenIf$libimageloader_release", "(Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;)V", "append", "next", "whenDecode", "whenDownload", "whenLoad", "PRIORITY", "WHENIF", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b<RESOURCE>
  implements f<RESOURCE, RESOURCE>
{
  public b<?> nqR;
  public a nqS = a.nqV;
  public b nqT = b.nqY;
  
  public final b<RESOURCE> blN()
  {
    this.nqT = b.nqZ;
    return this;
  }
  
  public final b<RESOURCE> blO()
  {
    this.nqT = b.nra;
    return this;
  }
  
  public final b<?> c(b<?> paramb)
  {
    s.u(paramb, "next");
    if (this.nqR == null)
    {
      this.nqR = paramb;
      return this;
    }
    b localb = this.nqR;
    s.checkNotNull(localb);
    localb.c(paramb);
    return this;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$PRIORITY;", "", "(Ljava/lang/String;I)V", "LOW", "NORMAL", "HIGH", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    private a() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;", "", "(Ljava/lang/String;I)V", "LOADED", "DECODED", "DOWNLOADED", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.d.c.b
 * JD-Core Version:    0.7.0.1
 */