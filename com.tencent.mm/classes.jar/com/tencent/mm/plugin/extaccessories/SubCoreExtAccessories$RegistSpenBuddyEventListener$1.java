package com.tencent.mm.plugin.extaccessories;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy.ImageWritingListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.qq;
import com.tencent.mm.g.a.qq.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cc;
import com.tencent.mm.pluginsdk.ui.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;

class SubCoreExtAccessories$RegistSpenBuddyEventListener$1
  implements SlookWritingBuddy.ImageWritingListener
{
  SubCoreExtAccessories$RegistSpenBuddyEventListener$1(b.a parama, qq paramqq) {}
  
  public void onImageReceived(Bitmap paramBitmap)
  {
    AppMethodBeat.i(24541);
    ae.i("MicroMsg.extaccessories.SubCoreExtAccessories", "onImageReceived");
    if (paramBitmap == null)
    {
      ae.e("MicroMsg.extaccessories.SubCoreExtAccessories", "img is null");
      this.rnf.dGo.dGp.aNZ(null);
      AppMethodBeat.o(24541);
      return;
    }
    if (!e.abo())
    {
      ae.e("MicroMsg.extaccessories.SubCoreExtAccessories", "SDCard not available");
      this.rnf.dGo.dGp.aNZ(null);
      AppMethodBeat.o(24541);
      return;
    }
    bc.aCa();
    Object localObject2 = (b)cc.Ca("plugin.extaccessories");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      ae.w("MicroMsg.extaccessories.SubCoreExtAccessories", "not found in MMCore, new one");
      localObject1 = new b();
      bc.aCa().a("plugin.extaccessories", (az)localObject1);
    }
    localObject2 = System.currentTimeMillis();
    if ((bc.ajM()) && (!bu.isNullOrNil((String)localObject2))) {}
    for (localObject1 = ((b)localObject1).gDT + "image/spen/spen_" + (String)localObject2; bu.isNullOrNil((String)localObject1); localObject1 = "")
    {
      ae.e("MicroMsg.extaccessories.SubCoreExtAccessories", "filePath is null");
      this.rnf.dGo.dGp.aNZ(null);
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
        ae.d("MicroMsg.extaccessories.SubCoreExtAccessories", "spen image %d, %d, need scale", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
        Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2, true);
        localObject2 = paramBitmap;
        if (paramBitmap != localBitmap)
        {
          localObject2 = paramBitmap;
          if (localBitmap != null)
          {
            ae.i("MicroMsg.extaccessories.SubCoreExtAccessories", "bitmap recycle %s", new Object[] { paramBitmap.toString() });
            paramBitmap.recycle();
            localObject2 = localBitmap;
          }
        }
      }
      h.a((Bitmap)localObject2, 55, Bitmap.CompressFormat.JPEG, (String)localObject1, true);
      ae.d("MicroMsg.extaccessories.SubCoreExtAccessories", "save spen temp image : %s", new Object[] { localObject1 });
      this.rnf.dGo.dGp.aNZ((String)localObject1);
      AppMethodBeat.o(24541);
      return;
    }
    catch (Exception paramBitmap)
    {
      ae.e("MicroMsg.extaccessories.SubCoreExtAccessories", "Exception %s", new Object[] { paramBitmap.getMessage() });
      ae.printErrStackTrace("MicroMsg.extaccessories.SubCoreExtAccessories", paramBitmap, "", new Object[0]);
      this.rnf.dGo.dGp.aNZ(null);
      AppMethodBeat.o(24541);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.extaccessories.SubCoreExtAccessories.RegistSpenBuddyEventListener.1
 * JD-Core Version:    0.7.0.1
 */