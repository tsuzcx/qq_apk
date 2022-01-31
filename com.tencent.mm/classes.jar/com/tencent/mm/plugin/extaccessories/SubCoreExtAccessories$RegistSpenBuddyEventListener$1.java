package com.tencent.mm.plugin.extaccessories;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy.ImageWritingListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.og;
import com.tencent.mm.g.a.og.a;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.pluginsdk.ui.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;

class SubCoreExtAccessories$RegistSpenBuddyEventListener$1
  implements SlookWritingBuddy.ImageWritingListener
{
  SubCoreExtAccessories$RegistSpenBuddyEventListener$1(b.a parama, og paramog) {}
  
  public void onImageReceived(Bitmap paramBitmap)
  {
    AppMethodBeat.i(20464);
    ab.i("MicroMsg.extaccessories.SubCoreExtAccessories", "onImageReceived");
    if (paramBitmap == null)
    {
      ab.e("MicroMsg.extaccessories.SubCoreExtAccessories", "img is null");
      this.mfS.cEQ.cER.amf(null);
      AppMethodBeat.o(20464);
      return;
    }
    if (!f.Mi())
    {
      ab.e("MicroMsg.extaccessories.SubCoreExtAccessories", "SDCard not available");
      this.mfS.cEQ.cER.amf(null);
      AppMethodBeat.o(20464);
      return;
    }
    aw.aat();
    Object localObject2 = (b)bw.pF("plugin.extaccessories");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      ab.w("MicroMsg.extaccessories.SubCoreExtAccessories", "not found in MMCore, new one");
      localObject1 = new b();
      aw.aat().a("plugin.extaccessories", (at)localObject1);
    }
    localObject2 = System.currentTimeMillis();
    if ((aw.RG()) && (!bo.isNullOrNil((String)localObject2))) {}
    for (localObject1 = ((b)localObject1).eHR + "image/spen/spen_" + (String)localObject2; bo.isNullOrNil((String)localObject1); localObject1 = "")
    {
      ab.e("MicroMsg.extaccessories.SubCoreExtAccessories", "filePath is null");
      this.mfS.cEQ.cER.amf(null);
      AppMethodBeat.o(20464);
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
        ab.d("MicroMsg.extaccessories.SubCoreExtAccessories", "spen image %d, %d, need scale", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
        Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2, true);
        localObject2 = paramBitmap;
        if (paramBitmap != localBitmap)
        {
          localObject2 = paramBitmap;
          if (localBitmap != null)
          {
            ab.i("MicroMsg.extaccessories.SubCoreExtAccessories", "bitmap recycle %s", new Object[] { paramBitmap.toString() });
            paramBitmap.recycle();
            localObject2 = localBitmap;
          }
        }
      }
      d.a((Bitmap)localObject2, 55, Bitmap.CompressFormat.JPEG, (String)localObject1, true);
      ab.d("MicroMsg.extaccessories.SubCoreExtAccessories", "save spen temp image : %s", new Object[] { localObject1 });
      this.mfS.cEQ.cER.amf((String)localObject1);
      AppMethodBeat.o(20464);
      return;
    }
    catch (Exception paramBitmap)
    {
      ab.e("MicroMsg.extaccessories.SubCoreExtAccessories", "Exception %s", new Object[] { paramBitmap.getMessage() });
      ab.printErrStackTrace("MicroMsg.extaccessories.SubCoreExtAccessories", paramBitmap, "", new Object[0]);
      this.mfS.cEQ.cER.amf(null);
      AppMethodBeat.o(20464);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.extaccessories.SubCoreExtAccessories.RegistSpenBuddyEventListener.1
 * JD-Core Version:    0.7.0.1
 */