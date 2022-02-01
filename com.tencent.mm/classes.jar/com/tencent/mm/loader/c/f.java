package com.tencent.mm.loader.c;

import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.loader.g.e;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/common/ITranscoderProducer;", "INPUT", "RESOURCE", "", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "asResourceName", "", "source", "whenDecode", "whenDownload", "whenLoad", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface f<INPUT, RESOURCE>
{
  public abstract String GH(String paramString);
  
  public abstract e<? extends RESOURCE> a(g<?> paramg, com.tencent.mm.loader.f<?, RESOURCE> paramf, e<INPUT> parame);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.c.f
 * JD-Core Version:    0.7.0.1
 */