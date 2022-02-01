package com.tencent.mm.plugin.brandservice.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.lang.ref.WeakReference;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/model/BizIconQuickAccess;", "", "(Ljava/lang/String;I)V", "sDefaultIcon", "Ljava/lang/ref/WeakReference;", "Landroid/graphics/Bitmap;", "defaultIcon", "Landroid/graphics/drawable/Drawable;", "instance", "plugin-brandservice_release"})
public enum a
{
  public volatile WeakReference<Bitmap> gRP;
  
  static
  {
    AppMethodBeat.i(175451);
    a locala = new a("instance");
    mSy = locala;
    mSz = new a[] { locala };
    AppMethodBeat.o(175451);
  }
  
  private a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.a
 * JD-Core Version:    0.7.0.1
 */