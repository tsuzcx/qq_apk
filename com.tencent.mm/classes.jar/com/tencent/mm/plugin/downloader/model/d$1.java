package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.plugin.downloader.f.a;

final class d$1
  implements Runnable
{
  d$1(d paramd, a parama, int paramInt, Context paramContext, long paramLong, boolean paramBoolean) {}
  
  public final void run()
  {
    new ad(this.iOZ.field_packageName, this.iPq).a(g.DO().dJT.edx, new d.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.d.1
 * JD-Core Version:    0.7.0.1
 */