package com.tencent.mm.plugin.gallery.ui;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class h$c
  implements d.b
{
  final ImageView nhp;
  
  h$c(ImageView paramImageView)
  {
    this.nhp = paramImageView;
  }
  
  private Drawable bEH()
  {
    AppMethodBeat.i(138613);
    Object localObject = this.nhp;
    if (localObject == null)
    {
      AppMethodBeat.o(138613);
      return null;
    }
    localObject = ((ImageView)localObject).getDrawable();
    AppMethodBeat.o(138613);
    return localObject;
  }
  
  public final void PA(String paramString)
  {
    AppMethodBeat.i(21608);
    ImageView localImageView = this.nhp;
    if (localImageView == null)
    {
      ab.w("MicroMsg.ThumbDrawable", "[tomys] ownerView is recycled, ignore this event.");
      AppMethodBeat.o(21608);
      return;
    }
    if (bo.isNullOrNil(paramString))
    {
      ab.d("MicroMsg.ThumbDrawable", "filepath is null or nill");
      AppMethodBeat.o(21608);
      return;
    }
    Object localObject = localImageView.getDrawable();
    if (localObject == null)
    {
      ab.w("MicroMsg.ThumbDrawable", "drawable in ownerView [%s] is null, ignore.", new Object[] { localImageView });
      AppMethodBeat.o(21608);
      return;
    }
    if ((localObject instanceof h))
    {
      localObject = (h)localObject;
      if (!((h)localObject).mFilePath.equals(paramString))
      {
        ab.d("MicroMsg.ThumbDrawable", "not current filepath, drawableFilePath: [%s], cbFilePath: [%s]", new Object[] { ((h)localObject).mFilePath, paramString });
        AppMethodBeat.o(21608);
        return;
      }
      ab.d("MicroMsg.ThumbDrawable", "notify thumb get ".concat(String.valueOf(paramString)));
      localImageView.post(new h.b(localImageView));
      AppMethodBeat.o(21608);
      return;
    }
    ab.w("MicroMsg.ThumbDrawable", "drawable [%s] in ownerView [%s] is not a ThumbDrawable, ignore.", new Object[] { localObject, localImageView });
    AppMethodBeat.o(21608);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(138169);
    if (paramObject == null)
    {
      AppMethodBeat.o(138169);
      return false;
    }
    Drawable localDrawable = bEH();
    if ((paramObject instanceof c)) {
      paramObject = ((c)paramObject).bEH();
    }
    while ((localDrawable == null) && (paramObject == null))
    {
      AppMethodBeat.o(138169);
      return true;
      if ((paramObject instanceof h))
      {
        paramObject = (Drawable)paramObject;
      }
      else
      {
        AppMethodBeat.o(138169);
        return false;
      }
    }
    if ((localDrawable != null) && (paramObject != null))
    {
      boolean bool = localDrawable.equals(paramObject);
      AppMethodBeat.o(138169);
      return bool;
    }
    AppMethodBeat.o(138169);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(21609);
    Drawable localDrawable = bEH();
    if (localDrawable != null)
    {
      i = localDrawable.hashCode();
      AppMethodBeat.o(21609);
      return i;
    }
    int i = super.hashCode();
    AppMethodBeat.o(21609);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.h.c
 * JD-Core Version:    0.7.0.1
 */