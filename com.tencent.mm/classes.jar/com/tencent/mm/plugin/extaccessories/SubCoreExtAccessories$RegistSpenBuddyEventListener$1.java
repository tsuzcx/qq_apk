package com.tencent.mm.plugin.extaccessories;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy.ImageWritingListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.rk;
import com.tencent.mm.g.a.rk.a;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cg;
import com.tencent.mm.pluginsdk.ui.a.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

class SubCoreExtAccessories$RegistSpenBuddyEventListener$1
  implements SlookWritingBuddy.ImageWritingListener
{
  SubCoreExtAccessories$RegistSpenBuddyEventListener$1(b.a parama, rk paramrk) {}
  
  public void onImageReceived(Bitmap paramBitmap)
  {
    AppMethodBeat.i(24541);
    Log.i("MicroMsg.extaccessories.SubCoreExtAccessories", "onImageReceived");
    if (paramBitmap == null)
    {
      Log.e("MicroMsg.extaccessories.SubCoreExtAccessories", "img is null");
      this.sOK.dXZ.dYa.beB(null);
      AppMethodBeat.o(24541);
      return;
    }
    if (!e.apn())
    {
      Log.e("MicroMsg.extaccessories.SubCoreExtAccessories", "SDCard not available");
      this.sOK.dXZ.dYa.beB(null);
      AppMethodBeat.o(24541);
      return;
    }
    bg.aVz();
    Object localObject2 = (b)cg.KG("plugin.extaccessories");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      Log.w("MicroMsg.extaccessories.SubCoreExtAccessories", "not found in MMCore, new one");
      localObject1 = new b();
      bg.aVz().a("plugin.extaccessories", (bd)localObject1);
    }
    localObject2 = System.currentTimeMillis();
    if ((bg.aAc()) && (!Util.isNullOrNil((String)localObject2))) {}
    for (localObject1 = ((b)localObject1).hqG + "image/spen/spen_" + (String)localObject2; Util.isNullOrNil((String)localObject1); localObject1 = "")
    {
      Log.e("MicroMsg.extaccessories.SubCoreExtAccessories", "filePath is null");
      this.sOK.dXZ.dYa.beB(null);
      AppMethodBeat.o(24541);
      return;
    }
    try
    {
      if (paramBitmap.getWidth() <= 1000)
      {
        localObject2 = paramBitmap;
        if (paramBitmap.getHeight() <= 1000) {}
      }
      else
      {
        Log.d("MicroMsg.extaccessories.SubCoreExtAccessories", "spen image %d, %d, need scale", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
        Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2, true);
        localObject2 = paramBitmap;
        if (paramBitmap != localBitmap)
        {
          localObject2 = paramBitmap;
          if (localBitmap != null)
          {
            Log.i("MicroMsg.extaccessories.SubCoreExtAccessories", "bitmap recycle %s", new Object[] { paramBitmap.toString() });
            paramBitmap.recycle();
            localObject2 = localBitmap;
          }
        }
      }
      BitmapUtil.saveBitmapToImage((Bitmap)localObject2, 55, Bitmap.CompressFormat.JPEG, (String)localObject1, true);
      Log.d("MicroMsg.extaccessories.SubCoreExtAccessories", "save spen temp image : %s", new Object[] { localObject1 });
      this.sOK.dXZ.dYa.beB((String)localObject1);
      AppMethodBeat.o(24541);
      return;
    }
    catch (Exception paramBitmap)
    {
      Log.e("MicroMsg.extaccessories.SubCoreExtAccessories", "Exception %s", new Object[] { paramBitmap.getMessage() });
      Log.printErrStackTrace("MicroMsg.extaccessories.SubCoreExtAccessories", paramBitmap, "", new Object[0]);
      this.sOK.dXZ.dYa.beB(null);
      AppMethodBeat.o(24541);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.extaccessories.SubCoreExtAccessories.RegistSpenBuddyEventListener.1
 * JD-Core Version:    0.7.0.1
 */