package com.tencent.mm.plugin.extaccessories;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy.ImageWritingListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.g.a.qe.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.pluginsdk.ui.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;

class SubCoreExtAccessories$RegistSpenBuddyEventListener$1
  implements SlookWritingBuddy.ImageWritingListener
{
  SubCoreExtAccessories$RegistSpenBuddyEventListener$1(b.a parama, qe paramqe) {}
  
  public void onImageReceived(Bitmap paramBitmap)
  {
    AppMethodBeat.i(24541);
    ac.i("MicroMsg.extaccessories.SubCoreExtAccessories", "onImageReceived");
    if (paramBitmap == null)
    {
      ac.e("MicroMsg.extaccessories.SubCoreExtAccessories", "img is null");
      this.qvm.dth.dti.aHa(null);
      AppMethodBeat.o(24541);
      return;
    }
    if (!e.YD())
    {
      ac.e("MicroMsg.extaccessories.SubCoreExtAccessories", "SDCard not available");
      this.qvm.dth.dti.aHa(null);
      AppMethodBeat.o(24541);
      return;
    }
    az.ayG();
    Object localObject2 = (b)bz.yz("plugin.extaccessories");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      ac.w("MicroMsg.extaccessories.SubCoreExtAccessories", "not found in MMCore, new one");
      localObject1 = new b();
      az.ayG().a("plugin.extaccessories", (aw)localObject1);
    }
    localObject2 = System.currentTimeMillis();
    if ((az.agM()) && (!bs.isNullOrNil((String)localObject2))) {}
    for (localObject1 = ((b)localObject1).ghC + "image/spen/spen_" + (String)localObject2; bs.isNullOrNil((String)localObject1); localObject1 = "")
    {
      ac.e("MicroMsg.extaccessories.SubCoreExtAccessories", "filePath is null");
      this.qvm.dth.dti.aHa(null);
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
        ac.d("MicroMsg.extaccessories.SubCoreExtAccessories", "spen image %d, %d, need scale", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
        Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2, true);
        localObject2 = paramBitmap;
        if (paramBitmap != localBitmap)
        {
          localObject2 = paramBitmap;
          if (localBitmap != null)
          {
            ac.i("MicroMsg.extaccessories.SubCoreExtAccessories", "bitmap recycle %s", new Object[] { paramBitmap.toString() });
            paramBitmap.recycle();
            localObject2 = localBitmap;
          }
        }
      }
      f.a((Bitmap)localObject2, 55, Bitmap.CompressFormat.JPEG, (String)localObject1, true);
      ac.d("MicroMsg.extaccessories.SubCoreExtAccessories", "save spen temp image : %s", new Object[] { localObject1 });
      this.qvm.dth.dti.aHa((String)localObject1);
      AppMethodBeat.o(24541);
      return;
    }
    catch (Exception paramBitmap)
    {
      ac.e("MicroMsg.extaccessories.SubCoreExtAccessories", "Exception %s", new Object[] { paramBitmap.getMessage() });
      ac.printErrStackTrace("MicroMsg.extaccessories.SubCoreExtAccessories", paramBitmap, "", new Object[0]);
      this.qvm.dth.dti.aHa(null);
      AppMethodBeat.o(24541);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.extaccessories.SubCoreExtAccessories.RegistSpenBuddyEventListener.1
 * JD-Core Version:    0.7.0.1
 */