package com.tencent.mm.app;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/app/WxImeProfile$onCreate$1", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "defaultAvatar", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "getDefaultAvatar", "()Landroid/graphics/Bitmap;", "getDefaultBitmap", "loadBitmap", "tag", "", "loadFromCache", "loadHdBitmap", "width", "", "height", "customFillet", "watch", "", "drawable", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WxImeProfile$b
  implements j.a
{
  private final Bitmap hkp;
  
  WxImeProfile$b(WxImeProfile paramWxImeProfile)
  {
    AppMethodBeat.i(239173);
    this.hkp = BitmapFactory.decodeResource(WxImeProfile.a(this.hkq).getResources(), R.g.icon);
    AppMethodBeat.o(239173);
  }
  
  public final void a(j paramj) {}
  
  public final Bitmap aCj()
  {
    AppMethodBeat.i(239182);
    Bitmap localBitmap = this.hkp;
    s.s(localBitmap, "defaultAvatar");
    AppMethodBeat.o(239182);
    return localBitmap;
  }
  
  public final Bitmap b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return this.hkp;
  }
  
  public final Bitmap ik(String paramString)
  {
    return this.hkp;
  }
  
  public final Bitmap loadBitmap(String paramString)
  {
    return this.hkp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.WxImeProfile.b
 * JD-Core Version:    0.7.0.1
 */