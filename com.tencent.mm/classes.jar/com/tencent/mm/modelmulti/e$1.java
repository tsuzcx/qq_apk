package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

final class e$1
  implements ap.a
{
  e$1(e parame) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(58360);
    if ((!com.tencent.mm.kernel.g.RG()) || (a.QP()))
    {
      ab.e("MicroMsg.NetSceneInit.dkInit", "acc is not ready stop handle resp");
      AppMethodBeat.o(58360);
      return false;
    }
    if (this.fIq.fIp)
    {
      ab.w("MicroMsg.NetSceneInit.dkInit", "Init CANCELED hash:%d", new Object[] { Integer.valueOf(this.fIq.hashCode()) });
      AppMethodBeat.o(58360);
      return false;
    }
    if (this.fIq.fCO.isEmpty())
    {
      ab.v("MicroMsg.NetSceneInit.dkInit", "queue maybe this time is null , wait doscene!");
      AppMethodBeat.o(58360);
      return false;
    }
    ab.i("MicroMsg.NetSceneInit.dkInit", "pusher hash:%d time:%d list:%d [%d/%b,%d/%d]", new Object[] { Integer.valueOf(this.fIq.hashCode()), Long.valueOf(this.fIq.eMo.Mm()), Integer.valueOf(this.fIq.fCO.size()), Integer.valueOf(this.fIq.fIl), Boolean.valueOf(this.fIq.fIm), Integer.valueOf(this.fIq.fIo), Integer.valueOf(this.fIq.fIn) });
    com.tencent.mm.kernel.g.RM();
    long l = com.tencent.mm.kernel.g.RL().eHS.kr(Thread.currentThread().getId());
    Object localObject1 = new c();
    ((c)localObject1).bT("NetSceneInit");
    int i;
    int j;
    label266:
    Object localObject2;
    boolean bool;
    label310:
    Object localObject3;
    if (this.fIq.fIm)
    {
      i = 40;
      j = 0;
      if (j >= i) {
        break label1093;
      }
      localObject2 = (e.a)this.fIq.fCO.peek();
      if (((e.a)localObject2).fIu != 2147483647) {
        break label630;
      }
      if (((e.a)localObject2).fIt != null) {
        break label624;
      }
      bool = true;
      Assert.assertTrue("in Queue tail , resp should be null", bool);
      com.tencent.mm.kernel.g.RM();
      localObject3 = (String)com.tencent.mm.kernel.g.RL().Ru().get(8198, null);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(8195, localObject3);
      ah.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.h.Mp()).edit().putString("notify_sync_key_keybuf", (String)localObject3).commit();
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(8197, "");
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(8198, "");
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(15, Integer.valueOf(1));
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().dww();
      ab.i("MicroMsg.NetSceneInit.dkInit", "INIT DONE: hash:%d time:%d netCnt:%d cmdCnt:%d err:[%d,%d] ", new Object[] { Integer.valueOf(this.fIq.hashCode()), Long.valueOf(this.fIq.eMo.Mm()), Integer.valueOf(this.fIq.fIl), Integer.valueOf(this.fIq.fIn), Integer.valueOf(((e.a)localObject2).errType), Integer.valueOf(((e.a)localObject2).errCode) });
      com.tencent.mm.kernel.g.RO().ac(new e.1.1(this, (e.a)localObject2));
      bool = false;
    }
    for (;;)
    {
      label565:
      ((c)localObject1).bU("NetSceneInit");
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().eHS.nY(l);
      localObject1 = this.fIq;
      if (((e)localObject1).fIj == null) {
        ab.w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progressRef is null");
      }
      for (;;)
      {
        AppMethodBeat.o(58360);
        return bool;
        i = 10;
        break;
        label624:
        bool = false;
        break label310;
        label630:
        localObject3 = ((e.a)localObject2).fIt.xuU;
        if ((localObject3 != null) && (((LinkedList)localObject3).size() > ((e.a)localObject2).fDc))
        {
          ((LinkedList)localObject3).size();
          if (((c)localObject1).a((ud)((LinkedList)localObject3).get(((e.a)localObject2).fDc), true)) {}
        }
        else
        {
          this.fIq.fCO.poll();
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RL().Ru().set(8197, bo.cg(aa.a(((e.a)localObject2).fIt.xuQ)));
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RL().Ru().set(8198, bo.cg(aa.a(((e.a)localObject2).fIt.xuR)));
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RL().Ru().set(16, Integer.valueOf(0));
          ab.i("MicroMsg.NetSceneInit.dkInit", "ContinueFlag:%s, cur[%s], max[%s]", new Object[] { Long.valueOf(((e.a)localObject2).fIt.wBX), bo.cg(aa.a(((e.a)localObject2).fIt.xuQ)), bo.cg(aa.a(((e.a)localObject2).fIt.xuR)) });
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RL().Ru().set(8196, Long.valueOf(((e.a)localObject2).fIt.wBX));
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RL().Ru().dww();
          bool = true;
          break label565;
        }
        ((e.a)localObject2).fDc += 1;
        localObject2 = this.fIq;
        ((e)localObject2).fIo += 1;
        j += 1;
        break label266;
        localObject2 = (com.tencent.mm.ai.g)((e)localObject1).fIj.get();
        if (localObject2 != null) {
          break label954;
        }
        ab.w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progress is null");
      }
      label954:
      label967:
      float f1;
      if (((e)localObject1).fIl > 50)
      {
        i = 50;
        f1 = 1.0F;
        if (((e)localObject1).fIm) {
          break label1053;
        }
      }
      for (j = i;; j = (int)((100 - i) * f1 + i))
      {
        ab.d("MicroMsg.NetSceneInit.dkInit", "doProgressCallBack index:%d sum:%d ratiocmd:%f ratioDoScene:%d", new Object[] { Integer.valueOf(((e)localObject1).fIo), Integer.valueOf(((e)localObject1).fIn), Float.valueOf(f1), Integer.valueOf(i) });
        ((com.tencent.mm.ai.g)localObject2).a(j, 100, (m)localObject1);
        break;
        i = ((e)localObject1).fIl;
        break label967;
        label1053:
        float f2 = ((e)localObject1).fIo / ((e)localObject1).fIn;
        f1 = f2;
        if (f2 > 1.0F) {
          f1 = 1.0F;
        }
      }
      label1093:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelmulti.e.1
 * JD-Core Version:    0.7.0.1
 */