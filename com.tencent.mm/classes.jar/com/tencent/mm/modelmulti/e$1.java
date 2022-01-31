package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.ah.m;
import com.tencent.mm.cf.h;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.c.ayy;
import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

final class e$1
  implements am.a
{
  e$1(e parame) {}
  
  public final boolean tC()
  {
    float f1 = 1.0F;
    if ((!com.tencent.mm.kernel.g.DK()) || (a.CW()))
    {
      y.e("MicroMsg.NetSceneInit.dkInit", "acc is not ready stop handle resp");
      return false;
    }
    if (this.esD.esC)
    {
      y.w("MicroMsg.NetSceneInit.dkInit", "Init CANCELED hash:%d", new Object[] { Integer.valueOf(this.esD.hashCode()) });
      return false;
    }
    if (this.esD.emr.isEmpty())
    {
      y.v("MicroMsg.NetSceneInit.dkInit", "queue maybe this time is null , wait doscene!");
      return false;
    }
    y.i("MicroMsg.NetSceneInit.dkInit", "pusher hash:%d time:%d list:%d [%d/%b,%d/%d]", new Object[] { Integer.valueOf(this.esD.hashCode()), Long.valueOf(this.esD.esm.zJ()), Integer.valueOf(this.esD.emr.size()), Integer.valueOf(this.esD.esy), Boolean.valueOf(this.esD.esz), Integer.valueOf(this.esD.esB), Integer.valueOf(this.esD.esA) });
    com.tencent.mm.kernel.g.DQ();
    long l = com.tencent.mm.kernel.g.DP().dKu.eV(Thread.currentThread().getId());
    Object localObject1 = new c();
    ((c)localObject1).bp("NetSceneInit");
    int i;
    int j;
    label248:
    Object localObject2;
    boolean bool;
    label292:
    Object localObject3;
    if (this.esD.esz)
    {
      i = 40;
      j = 0;
      if (j >= i) {
        break label981;
      }
      localObject2 = (e.a)this.esD.emr.peek();
      if (((e.a)localObject2).esH != 2147483647) {
        break label606;
      }
      if (((e.a)localObject2).esG != null) {
        break label600;
      }
      bool = true;
      Assert.assertTrue("in Queue tail , resp should be null", bool);
      com.tencent.mm.kernel.g.DQ();
      localObject3 = (String)com.tencent.mm.kernel.g.DP().Dz().get(8198, null);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().o(8195, localObject3);
      ae.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", (String)localObject3).commit();
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().o(8197, "");
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().o(8198, "");
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().o(15, Integer.valueOf(1));
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().mC(true);
      y.i("MicroMsg.NetSceneInit.dkInit", "INIT DONE: hash:%d time:%d netCnt:%d cmdCnt:%d err:[%d,%d] ", new Object[] { Integer.valueOf(this.esD.hashCode()), Long.valueOf(this.esD.esm.zJ()), Integer.valueOf(this.esD.esy), Integer.valueOf(this.esD.esA), Integer.valueOf(((e.a)localObject2).errType), Integer.valueOf(((e.a)localObject2).errCode) });
      com.tencent.mm.kernel.g.DS().O(new e.1.1(this, (e.a)localObject2));
      bool = false;
    }
    for (;;)
    {
      ((c)localObject1).bq("NetSceneInit");
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().dKu.hI(l);
      localObject1 = this.esD;
      if (((e)localObject1).eoM == null)
      {
        y.w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progress is null");
        return bool;
        i = 10;
        break;
        label600:
        bool = false;
        break label292;
        label606:
        localObject3 = ((e.a)localObject2).esG.tuL;
        if ((localObject3 != null) && (((LinkedList)localObject3).size() > ((e.a)localObject2).emF))
        {
          ((LinkedList)localObject3).size();
          if (((c)localObject1).a((qv)((LinkedList)localObject3).get(((e.a)localObject2).emF), true)) {}
        }
        else
        {
          this.esD.emr.poll();
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DP().Dz().o(8197, bk.bG(aa.a(((e.a)localObject2).esG.tuH)));
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DP().Dz().o(8198, bk.bG(aa.a(((e.a)localObject2).esG.tuI)));
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DP().Dz().o(16, Integer.valueOf(0));
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DP().Dz().o(8196, Long.valueOf(((e.a)localObject2).esG.tuJ));
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DP().Dz().mC(true);
          bool = true;
          continue;
        }
        ((e.a)localObject2).emF += 1;
        localObject2 = this.esD;
        ((e)localObject2).esB += 1;
        j += 1;
        break label248;
      }
      if (((e)localObject1).esy > 50)
      {
        i = 50;
        label854:
        if (((e)localObject1).esz) {
          break label941;
        }
      }
      for (j = i;; j = (int)((100 - i) * f1 + i))
      {
        y.d("MicroMsg.NetSceneInit.dkInit", "doProgressCallBack index:%d sum:%d ratiocmd:%f ratioDoScene:%d", new Object[] { Integer.valueOf(((e)localObject1).esB), Integer.valueOf(((e)localObject1).esA), Float.valueOf(f1), Integer.valueOf(i) });
        ((e)localObject1).eoM.a(j, 100, (m)localObject1);
        break;
        i = ((e)localObject1).esy;
        break label854;
        label941:
        float f2 = ((e)localObject1).esB / ((e)localObject1).esA;
        f1 = f2;
        if (f2 > 1.0F) {
          f1 = 1.0F;
        }
      }
      label981:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelmulti.e.1
 * JD-Core Version:    0.7.0.1
 */