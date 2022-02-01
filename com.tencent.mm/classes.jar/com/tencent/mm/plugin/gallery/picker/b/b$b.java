package com.tencent.mm.plugin.gallery.picker.b;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "", "()V", "compressQuality", "", "getCompressQuality", "()I", "setCompressQuality", "(I)V", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "filename", "getFilename", "setFilename", "isCircle", "", "()Z", "setCircle", "(Z)V", "maxFileLength", "getMaxFileLength", "setMaxFileLength", "maxHeight", "getMaxHeight", "setMaxHeight", "maxWidth", "getMaxWidth", "setMaxWidth", "value", "outputDir", "getOutputDir", "setOutputDir", "thumbSize", "getThumbSize", "setThumbSize", "plugin-gallery_release"})
public final class b$b
{
  public String filePath;
  public String filename;
  int iTf;
  public int maxHeight;
  public int maxWidth;
  public String xkX;
  public int xkY;
  public int xkZ;
  boolean xla;
  
  public b$b()
  {
    AppMethodBeat.i(164871);
    this.xkX = "";
    this.iTf = 480;
    this.maxHeight = ((int)MMApplicationContext.getResources().getDimension(2131166487));
    this.maxWidth = this.maxHeight;
    this.xkY = 80;
    AppMethodBeat.o(164871);
  }
  
  public final void ayU(String paramString)
  {
    AppMethodBeat.i(164870);
    p.h(paramString, "value");
    String str = paramString;
    if (n.aS((CharSequence)paramString) != '/') {
      str = paramString + '/';
    }
    this.xkX = str;
    AppMethodBeat.o(164870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.b.b.b
 * JD-Core Version:    0.7.0.1
 */