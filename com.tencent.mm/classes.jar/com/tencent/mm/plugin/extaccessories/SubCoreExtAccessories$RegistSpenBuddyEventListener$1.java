package com.tencent.mm.plugin.extaccessories;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy.ImageWritingListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.g.a.qp.a;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.ca;
import com.tencent.mm.pluginsdk.ui.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;

class SubCoreExtAccessories$RegistSpenBuddyEventListener$1
  implements SlookWritingBuddy.ImageWritingListener
{
  SubCoreExtAccessories$RegistSpenBuddyEventListener$1(b.a parama, qp paramqp) {}
  
  public void onImageReceived(Bitmap paramBitmap)
  {
    AppMethodBeat.i(24541);
    ad.i("MicroMsg.extaccessories.SubCoreExtAccessories", "onImageReceived");
    if (paramBitmap == null)
    {
      ad.e("MicroMsg.extaccessories.SubCoreExtAccessories", "img is null");
      this.rfc.dFj.dFk.aMD(null);
      AppMethodBeat.o(24541);
      return;
    }
    if (!e.abf())
    {
      ad.e("MicroMsg.extaccessories.SubCoreExtAccessories", "SDCard not available");
      this.rfc.dFj.dFk.aMD(null);
      AppMethodBeat.o(24541);
      return;
    }
    ba.aBK();
    Object localObject2 = (b)ca.By("plugin.extaccessories");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      ad.w("MicroMsg.extaccessories.SubCoreExtAccessories", "not found in MMCore, new one");
      localObject1 = new b();
      ba.aBK().a("plugin.extaccessories", (ax)localObject1);
    }
    localObject2 = System.currentTimeMillis();
    if ((ba.ajx()) && (!bt.isNullOrNil((String)localObject2))) {}
    for (localObject1 = ((b)localObject1).gBm + "image/spen/spen_" + (String)localObject2; bt.isNullOrNil((String)localObject1); localObject1 = "")
    {
      ad.e("MicroMsg.extaccessories.SubCoreExtAccessories", "filePath is null");
      this.rfc.dFj.dFk.aMD(null);
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
      g.a((Bitmap)localObject2, 55, Bitmap.CompressFormat.JPEG, (String)localObject1, true);
      ad.d("MicroMsg.extaccessories.SubCoreExtAccessories", "save spen temp image : %s", new Object[] { localObject1 });
      this.rfc.dFj.dFk.aMD((String)localObject1);
      AppMethodBeat.o(24541);
      return;
    }
    catch (Exception paramBitmap)
    {
      ad.e("MicroMsg.extaccessories.SubCoreExtAccessories", "Exception %s", new Object[] { paramBitmap.getMessage() });
      ad.printErrStackTrace("MicroMsg.extaccessories.SubCoreExtAccessories", paramBitmap, "", new Object[0]);
      this.rfc.dFj.dFk.aMD(null);
      AppMethodBeat.o(24541);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.extaccessories.SubCoreExtAccessories.RegistSpenBuddyEventListener.1
 * JD-Core Version:    0.7.0.1
 */