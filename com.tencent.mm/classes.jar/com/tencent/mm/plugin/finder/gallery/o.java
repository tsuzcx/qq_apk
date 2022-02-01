package com.tencent.mm.plugin.finder.gallery;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryUtils;", "", "()V", "putGalleryToIntent", "", "intent", "Landroid/content/Intent;", "bizScene", "", "extBuff", "", "tabType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  public static final o Bvl;
  
  static
  {
    AppMethodBeat.i(334282);
    Bvl = new o();
    AppMethodBeat.o(334282);
  }
  
  public static void a(Intent paramIntent, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(334272);
    s.u(paramIntent, "intent");
    paramIntent.putExtra("BIZ_SCENE", paramInt1);
    paramIntent.putExtra("EXT_BUFF", paramArrayOfByte);
    paramIntent.putExtra("TAB_TYPE", paramInt2);
    AppMethodBeat.o(334272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.o
 * JD-Core Version:    0.7.0.1
 */