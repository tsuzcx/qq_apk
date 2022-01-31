package com.tencent.mm.plugin.fav.b.e;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.aj;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.bdy;
import com.tencent.mm.protocal.protobuf.beb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class d
  implements f, z
{
  private static Map<Integer, g.a> ckJ;
  private static Map<Integer, Integer> mvk;
  private Queue<com.tencent.mm.plugin.fav.a.g> ckH;
  private boolean ckL;
  public int ckM;
  private long ckN;
  public ap ckR;
  private boolean running;
  
  static
  {
    AppMethodBeat.i(5387);
    ckJ = new HashMap();
    mvk = new HashMap();
    AppMethodBeat.o(5387);
  }
  
  public d()
  {
    AppMethodBeat.i(5378);
    this.running = false;
    this.ckM = 0;
    this.ckN = 0L;
    this.ckL = false;
    this.ckH = new LinkedList();
    this.ckR = new ap(com.tencent.mm.kernel.g.RO().oNc.getLooper(), new d.3(this), false);
    com.tencent.mm.kernel.g.Rc().a(426, this);
    AppMethodBeat.o(5378);
  }
  
  private static void a(long paramLong, LinkedList<bdy> paramLinkedList, LinkedList<beb> paramLinkedList1)
  {
    AppMethodBeat.i(5383);
    Object localObject1 = new bdy();
    ((bdy)localObject1).xtK = 4;
    ((bdy)localObject1).xtL = 0;
    paramLinkedList.add(localObject1);
    paramLinkedList = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().jX(paramLong);
    ab.i("MicroMsg.Fav.FavModService", "setModAfterClientUpload %d modcdnlistsize %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramLinkedList.size()) });
    paramLinkedList = paramLinkedList.iterator();
    label478:
    while (paramLinkedList.hasNext())
    {
      localObject1 = (c)paramLinkedList.next();
      boolean bool = b.Nz(((c)localObject1).field_dataId);
      if ((bo.isNullOrNil(((c)localObject1).field_cdnUrl)) || (bool))
      {
        ab.e("MicroMsg.Fav.FavModService", "setModAfterClientUpload cdnUrl:%s, isThumb:%b,  favLocalId:%d", new Object[] { ((c)localObject1).field_cdnUrl, Boolean.valueOf(bool), Long.valueOf(paramLong) });
      }
      else
      {
        Object localObject2 = new beb();
        ((beb)localObject2).ntn = ("dataitem." + ((c)localObject1).field_dataId + ".cdn_dataurl");
        ((beb)localObject2).qsu = ((c)localObject1).field_cdnUrl;
        paramLinkedList1.add(localObject2);
        localObject2 = new beb();
        ((beb)localObject2).ntn = ("dataitem." + ((c)localObject1).field_dataId + ".cdn_datakey");
        ((beb)localObject2).qsu = ((c)localObject1).field_cdnKey;
        paramLinkedList1.add(localObject2);
        localObject2 = new beb();
        ((beb)localObject2).ntn = ("dataitem." + ((c)localObject1).field_dataId);
        ((beb)localObject2).xtQ = "datastatus";
        ((beb)localObject2).qsu = "0";
        paramLinkedList1.add(localObject2);
        localObject2 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(((c)localObject1).field_favLocalId);
        if (localObject2 != null)
        {
          if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_type == 4) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label478;
            }
            localObject2 = b.a((com.tencent.mm.plugin.fav.a.g)localObject2, ((c)localObject1).field_dataId);
            if (localObject2 == null) {
              break;
            }
            beb localbeb = new beb();
            localbeb.ntn = ("dataitem." + ((c)localObject1).field_dataId + ".stream_videoid");
            localbeb.qsu = ((aca)localObject2).wTm;
            paramLinkedList1.add(localbeb);
            break;
          }
        }
      }
    }
    AppMethodBeat.o(5383);
  }
  
  public static void startSync()
  {
    AppMethodBeat.i(5382);
    aj localaj = new aj();
    com.tencent.mm.kernel.g.Rc().a(localaj, 0);
    AppMethodBeat.o(5382);
  }
  
  public final void ET()
  {
    AppMethodBeat.i(5381);
    this.ckH.clear();
    ckJ.clear();
    this.running = false;
    this.ckL = false;
    mvk.clear();
    AppMethodBeat.o(5381);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(5379);
    if (paramm.getType() != 426)
    {
      AppMethodBeat.o(5379);
      return;
    }
    if (!(paramm instanceof com.tencent.mm.plugin.fav.a.al))
    {
      AppMethodBeat.o(5379);
      return;
    }
    com.tencent.mm.kernel.g.RO().ac(new d.1(this, paramm, paramInt2, paramInt1));
    AppMethodBeat.o(5379);
  }
  
  public final void run()
  {
    AppMethodBeat.i(5380);
    com.tencent.mm.kernel.g.RO().ac(new d.2(this));
    AppMethodBeat.o(5380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.d
 * JD-Core Version:    0.7.0.1
 */