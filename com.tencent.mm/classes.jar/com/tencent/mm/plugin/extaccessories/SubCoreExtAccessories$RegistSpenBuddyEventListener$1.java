package com.tencent.mm.plugin.extaccessories;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy.ImageWritingListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.pv;
import com.tencent.mm.g.a.pv.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.pluginsdk.ui.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;

class SubCoreExtAccessories$RegistSpenBuddyEventListener$1
  implements SlookWritingBuddy.ImageWritingListener
{
  SubCoreExtAccessories$RegistSpenBuddyEventListener$1(b.a parama, pv parampv) {}
  
  public void onImageReceived(Bitmap paramBitmap)
  {
    AppMethodBeat.i(24541);
    ad.i("MicroMsg.extaccessories.SubCoreExtAccessories", "onImageReceived");
    if (paramBitmap == null)
    {
      ad.e("MicroMsg.extaccessories.SubCoreExtAccessories", "img is null");
      this.pME.dvv.dvw.aBI(null);
      AppMethodBeat.o(24541);
      return;
    }
    if (!e.XG())
    {
      ad.e("MicroMsg.extaccessories.SubCoreExtAccessories", "SDCard not available");
      this.pME.dvv.dvw.aBI(null);
      AppMethodBeat.o(24541);
      return;
    }
    az.arP();
    Object localObject2 = (b)bz.ut("plugin.extaccessories");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      ad.w("MicroMsg.extaccessories.SubCoreExtAccessories", "not found in MMCore, new one");
      localObject1 = new b();
      az.arP().a("plugin.extaccessories", (aw)localObject1);
    }
    localObject2 = System.currentTimeMillis();
    if ((az.afw()) && (!bt.isNullOrNil((String)localObject2))) {}
    for (localObject1 = ((b)localObject1).gcW + "image/spen/spen_" + (String)localObject2; bt.isNullOrNil((String)localObject1); localObject1 = "")
    {
      ad.e("MicroMsg.extaccessories.SubCoreExtAccessories", "filePath is null");
      this.pME.dvv.dvw.aBI(null);
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
        ad.d("MicroMsg.extaccessories.SubCoreExtAccessories", "spen image %d, %d, need scale", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
        Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2, true);
        localObject2 = paramBitmap;
        if (paramBitmap != localBitmap)
        {
          localObject2 = paramBitmap;
          if (localBitmap != null)
          {
            ad.i("MicroMsg.extaccessories.SubCoreExtAccessories", "bitmap recycle %s", new Object[] { paramBitmap.toString() });
            paramBitmap.recycle();
            localObject2 = localBitmap;
          }
        }
      }
      f.a((Bitmap)localObject2, 55, Bitmap.CompressFormat.JPEG, (String)localObject1, true);
      ad.d("MicroMsg.extaccessories.SubCoreExtAccessories", "save spen temp image : %s", new Object[] { localObject1 });
      this.pME.dvv.dvw.aBI((String)localObject1);
      AppMethodBeat.o(24541);
      return;
    }
    catch (Exception paramBitmap)
    {
      ad.e("MicroMsg.extaccessories.SubCoreExtAccessories", "Exception %s", new Object[] { paramBitmap.getMessage() });
      ad.printErrStackTrace("MicroMsg.extaccessories.SubCoreExtAccessories", paramBitmap, "", new Object[0]);
      this.pME.dvv.dvw.aBI(null);
      AppMethodBeat.o(24541);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.extaccessories.SubCoreExtAccessories.RegistSpenBuddyEventListener.1
 * JD-Core Version:    0.7.0.1
 */