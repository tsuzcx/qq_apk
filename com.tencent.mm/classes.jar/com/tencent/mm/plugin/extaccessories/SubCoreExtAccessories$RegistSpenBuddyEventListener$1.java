package com.tencent.mm.plugin.extaccessories;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy.ImageWritingListener;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.h.a.nj;
import com.tencent.mm.h.a.nj.a;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bu;
import com.tencent.mm.pluginsdk.ui.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;

class SubCoreExtAccessories$RegistSpenBuddyEventListener$1
  implements SlookWritingBuddy.ImageWritingListener
{
  SubCoreExtAccessories$RegistSpenBuddyEventListener$1(b.a parama, nj paramnj) {}
  
  public void onImageReceived(Bitmap paramBitmap)
  {
    y.i("MicroMsg.extaccessories.SubCoreExtAccessories", "onImageReceived");
    if (paramBitmap == null)
    {
      y.e("MicroMsg.extaccessories.SubCoreExtAccessories", "img is null");
      this.jLO.bWZ.bXa.Wz(null);
      return;
    }
    if (!f.zF())
    {
      y.e("MicroMsg.extaccessories.SubCoreExtAccessories", "SDCard not available");
      this.jLO.bWZ.bXa.Wz(null);
      return;
    }
    au.Hq();
    Object localObject2 = (b)bu.iR("plugin.extaccessories");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      y.w("MicroMsg.extaccessories.SubCoreExtAccessories", "not found in MMCore, new one");
      localObject1 = new b();
      au.Hq().a("plugin.extaccessories", (ar)localObject1);
    }
    localObject2 = System.currentTimeMillis();
    if ((au.DK()) && (!bk.bl((String)localObject2))) {}
    for (localObject1 = ((b)localObject1).dKt + "image/spen/spen_" + (String)localObject2; bk.bl((String)localObject1); localObject1 = "")
    {
      y.e("MicroMsg.extaccessories.SubCoreExtAccessories", "filePath is null");
      this.jLO.bWZ.bXa.Wz(null);
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
        y.d("MicroMsg.extaccessories.SubCoreExtAccessories", "spen image %d, %d, need scale", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
        Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2, true);
        localObject2 = paramBitmap;
        if (paramBitmap != localBitmap)
        {
          localObject2 = paramBitmap;
          if (localBitmap != null)
          {
            paramBitmap.recycle();
            localObject2 = localBitmap;
          }
        }
      }
      c.a((Bitmap)localObject2, 55, Bitmap.CompressFormat.JPEG, (String)localObject1, true);
      y.d("MicroMsg.extaccessories.SubCoreExtAccessories", "save spen temp image : %s", new Object[] { localObject1 });
      this.jLO.bWZ.bXa.Wz((String)localObject1);
      return;
    }
    catch (Exception paramBitmap)
    {
      y.e("MicroMsg.extaccessories.SubCoreExtAccessories", "Exception %s", new Object[] { paramBitmap.getMessage() });
      y.printErrStackTrace("MicroMsg.extaccessories.SubCoreExtAccessories", paramBitmap, "", new Object[0]);
      this.jLO.bWZ.bXa.Wz(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.extaccessories.SubCoreExtAccessories.RegistSpenBuddyEventListener.1
 * JD-Core Version:    0.7.0.1
 */