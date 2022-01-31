package com.tencent.mm.plugin.ext.provider;

import android.database.MatrixCursor;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.sdk.platformtools.y;

final class ExtControlProviderMsg$2$1
  implements f
{
  ExtControlProviderMsg$2$1(ExtControlProviderMsg.2 param2, String paramString) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.ExtControlProviderMsg", "onSceneEnd errType=%s, errCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramm == null)
    {
      y.e("MicroMsg.ExtControlProviderMsg", "scene == null");
      au.Dk().b(522, this);
      this.jKy.jKv.qF(4);
      this.jKy.hSx.countDown();
      return;
    }
    switch (paramm.getType())
    {
    default: 
      this.jKy.jKv.qF(0);
    }
    for (;;)
    {
      this.jKy.hSx.countDown();
      au.Dk().b(522, this);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        y.d("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd ok, ");
        ExtControlProviderMsg.a(this.jKy.jKv).addRow(new Object[] { this.jKx, Integer.valueOf(1) });
        break;
      }
      y.e("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd err, errType = " + paramInt1 + ", errCode = " + paramInt2);
      ExtControlProviderMsg.a(this.jKy.jKv).addRow(new Object[] { this.jKx, Integer.valueOf(2) });
      this.jKy.jKv.qF(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.2.1
 * JD-Core Version:    0.7.0.1
 */