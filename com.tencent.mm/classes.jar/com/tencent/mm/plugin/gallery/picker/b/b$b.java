package com.tencent.mm.plugin.gallery.picker.b;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.b.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "", "()V", "compressQuality", "", "getCompressQuality", "()I", "setCompressQuality", "(I)V", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "filename", "getFilename", "setFilename", "isCircle", "", "()Z", "setCircle", "(Z)V", "maxFileLength", "getMaxFileLength", "setMaxFileLength", "maxHeight", "getMaxHeight", "setMaxHeight", "maxWidth", "getMaxWidth", "setMaxWidth", "value", "outputDir", "getOutputDir", "setOutputDir", "thumbSize", "getThumbSize", "setThumbSize", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$b
{
  public String HJE;
  public int HJF;
  public int HJG;
  boolean HJH;
  public String filePath;
  public String filename;
  public int maxHeight;
  public int maxWidth;
  int oCa;
  
  public b$b()
  {
    AppMethodBeat.i(164871);
    this.HJE = "";
    this.oCa = 480;
    this.maxHeight = ((int)MMApplicationContext.getResources().getDimension(b.c.gallery_crop_image_limit));
    this.maxWidth = this.maxHeight;
    this.HJF = 80;
    AppMethodBeat.o(164871);
  }
  
  public final void aES(String paramString)
  {
    AppMethodBeat.i(164870);
    s.u(paramString, "value");
    String str = paramString;
    if (n.bz((CharSequence)paramString) != '/') {
      str = s.X(paramString, "/");
    }
    this.HJE = str;
    AppMethodBeat.o(164870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.b.b.b
 * JD-Core Version:    0.7.0.1
 */