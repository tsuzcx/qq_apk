package com.tencent.mm.plugin.gallery.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.Vector;

public final class d
{
  l<d.b, String> frK;
  Vector<d.b> gjA;
  com.tencent.mm.a.f<String, d.a> ncK;
  f ncL;
  private final d.b ncM;
  
  public d()
  {
    AppMethodBeat.i(21243);
    this.frK = new d.1(this);
    this.gjA = new Vector();
    this.ncM = new d.2(this);
    this.ncK = new b(100, new d.3(this), getClass());
    f localf = new f(new File(e.eQz + "/diskcache"));
    localf.nde = ah.getContext().getSharedPreferences(ah.dsP(), 0).getInt("com.tencent.mm.gallery.cache.suffix", 0);
    localf.bDY();
    localf.wH(-1);
    this.ncL = localf;
    this.frK.a(this.ncM, null);
    AppMethodBeat.o(21243);
  }
  
  public final Bitmap getBitmap(String paramString)
  {
    AppMethodBeat.i(21244);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.GalleryCache", "null filepath");
      AppMethodBeat.o(21244);
      return null;
    }
    if (this.ncK == null)
    {
      ab.w("MicroMsg.GalleryCache", "want to get bitmap, but gallery cache is null");
      AppMethodBeat.o(21244);
      return null;
    }
    if (this.ncK.Z(paramString))
    {
      Object localObject = (d.a)this.ncK.Y(paramString);
      if (localObject == null)
      {
        ab.d("MicroMsg.GalleryCache", "weakreference is null! %s", new Object[] { paramString });
        this.ncK.remove(paramString);
        AppMethodBeat.o(21244);
        return null;
      }
      localObject = ((d.a)localObject).bitmap;
      if (localObject != null)
      {
        if (((Bitmap)localObject).isRecycled())
        {
          ab.i("MicroMsg.GalleryCache", "cahce bitmap has recycled: %s", new Object[] { paramString });
          this.ncK.remove(paramString);
          AppMethodBeat.o(21244);
          return null;
        }
        ab.i("MicroMsg.GalleryCache", "get cached bitmap:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(21244);
        return localObject;
      }
      this.ncK.remove(paramString);
      ab.i("MicroMsg.GalleryCache", "get bitmap is null! %s", new Object[] { paramString });
    }
    AppMethodBeat.o(21244);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.d
 * JD-Core Version:    0.7.0.1
 */