package com.tencent.mm.plugin.gallery.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/mjtemplate/AlbumTemplateUI$TemplateSelectType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "NO_SELECT", "SELECTED", "SELECTED_NO_ENABLE_CHANGE", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum a$b
{
  final int value;
  
  static
  {
    AppMethodBeat.i(289271);
    HFT = new b("NO_SELECT", 0, 0);
    HFU = new b("SELECTED", 1, 1);
    HFV = new b("SELECTED_NO_ENABLE_CHANGE", 2, 2);
    HFW = new b[] { HFT, HFU, HFV };
    AppMethodBeat.o(289271);
  }
  
  private a$b(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.a.a.b
 * JD-Core Version:    0.7.0.1
 */