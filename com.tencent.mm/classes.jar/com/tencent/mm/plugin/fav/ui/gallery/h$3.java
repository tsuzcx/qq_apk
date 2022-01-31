package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

final class h$3
  implements f.b
{
  h$3(h paramh) {}
  
  public final void a(boolean paramBoolean, f.c paramc, int paramInt)
  {
    AppMethodBeat.i(74592);
    ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[onCheck] isChecked :%s pos:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if ((paramBoolean) && (e.a.bym().mCl.size() >= 9))
    {
      Toast.makeText(this.mCP.mContext, this.mCP.mContext.getResources().getString(2131299670, new Object[] { Integer.valueOf(9) }), 1).show();
      this.mCP.mCL.bR(paramInt);
      AppMethodBeat.o(74592);
      return;
    }
    e locale;
    if (paramBoolean)
    {
      locale = e.a.bym();
      paramc = paramc.mCt;
      if (paramc != null)
      {
        ab.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", new Object[] { paramc });
        locale.mCl.remove(paramc);
        locale.mCl.remove(locale.Oe(paramc.cuZ.mBq));
        locale.mCl.add(paramc);
        locale.byl();
      }
    }
    for (;;)
    {
      this.mCP.mCK.wa(e.a.bym().mCl.size());
      AppMethodBeat.o(74592);
      return;
      locale = e.a.bym();
      paramc = paramc.mCt;
      if (paramc != null)
      {
        ab.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", new Object[] { paramc.cuZ.mBq });
        locale.mCl.remove(paramc);
        locale.mCl.remove(locale.Oe(paramc.cuZ.mBq));
        locale.byl();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.h.3
 * JD-Core Version:    0.7.0.1
 */