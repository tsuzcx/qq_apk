package com.tencent.mm.plugin.game.ui;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.openapi.a;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;

final class j$a$1
  implements MStorage.IOnStorageChange
{
  j$a$1(String paramString, float paramFloat, ImageView paramImageView) {}
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(42077);
    if (this.etl.equals(paramString))
    {
      paramString = h.c(this.etl, 1, this.enb);
      if (paramString != null)
      {
        this.ytT.setImageBitmap(paramString);
        a.gxn().remove(this);
      }
    }
    AppMethodBeat.o(42077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.j.a.1
 * JD-Core Version:    0.7.0.1
 */