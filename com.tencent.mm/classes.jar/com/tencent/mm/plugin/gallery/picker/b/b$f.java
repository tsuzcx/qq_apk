package com.tencent.mm.plugin.gallery.picker.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "", "ret", "", "(I)V", "outPath", "", "getOutPath", "()Ljava/lang/String;", "setOutPath", "(Ljava/lang/String;)V", "quality", "getQuality", "()I", "setQuality", "getRet", "setRet", "thumbPath", "getThumbPath", "setThumbPath", "token", "getToken", "setToken", "plugin-gallery_release"})
public class b$f
{
  int quality;
  public int ret;
  public String thumbPath;
  public int token;
  public String xli;
  
  public b$f(int paramInt)
  {
    this.ret = paramInt;
    this.xli = "";
    this.thumbPath = "";
  }
  
  public final void HA(String paramString)
  {
    AppMethodBeat.i(164885);
    p.h(paramString, "<set-?>");
    this.thumbPath = paramString;
    AppMethodBeat.o(164885);
  }
  
  public final void ayV(String paramString)
  {
    AppMethodBeat.i(164884);
    p.h(paramString, "<set-?>");
    this.xli = paramString;
    AppMethodBeat.o(164884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.b.b.f
 * JD-Core Version:    0.7.0.1
 */