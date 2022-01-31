package com.tencent.mm.plugin.fav.b.e;

import android.os.HandlerThread;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.aj;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.protocal.c.axi;
import com.tencent.mm.protocal.c.axl;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class d
  implements f, z
{
  private static Map<Integer, g.a> bDU = new HashMap();
  private static Map<Integer, Integer> kaO = new HashMap();
  private Queue<com.tencent.mm.plugin.fav.a.g> bDS = new LinkedList();
  private boolean bDW = false;
  private boolean bDX = false;
  public int bDY = 0;
  private long bDZ = 0L;
  public am bEd = new am(com.tencent.mm.kernel.g.DS().mnU.getLooper(), new d.3(this), false);
  
  public d()
  {
    com.tencent.mm.kernel.g.Dk().a(426, this);
  }
  
  private static void a(long paramLong, LinkedList<axi> paramLinkedList, LinkedList<axl> paramLinkedList1)
  {
    Object localObject1 = new axi();
    ((axi)localObject1).ttL = 4;
    ((axi)localObject1).ttM = 0;
    paramLinkedList.add(localObject1);
    paramLinkedList = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().eA(paramLong);
    y.i("MicroMsg.Fav.FavModService", "setModAfterClientUpload %d modcdnlistsize %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramLinkedList.size()) });
    paramLinkedList = paramLinkedList.iterator();
    label472:
    while (paramLinkedList.hasNext())
    {
      localObject1 = (c)paramLinkedList.next();
      boolean bool = b.Cx(((c)localObject1).field_dataId);
      if ((bk.bl(((c)localObject1).field_cdnUrl)) || (bool))
      {
        y.e("MicroMsg.Fav.FavModService", "setModAfterClientUpload cdnUrl:%s, isThumb:%b,  favLocalId:%d", new Object[] { ((c)localObject1).field_cdnUrl, Boolean.valueOf(bool), Long.valueOf(paramLong) });
      }
      else
      {
        Object localObject2 = new axl();
        ((axl)localObject2).kVl = ("dataitem." + ((c)localObject1).field_dataId + ".cdn_dataurl");
        ((axl)localObject2).nFs = ((c)localObject1).field_cdnUrl;
        paramLinkedList1.add(localObject2);
        localObject2 = new axl();
        ((axl)localObject2).kVl = ("dataitem." + ((c)localObject1).field_dataId + ".cdn_datakey");
        ((axl)localObject2).nFs = ((c)localObject1).field_cdnKey;
        paramLinkedList1.add(localObject2);
        localObject2 = new axl();
        ((axl)localObject2).kVl = ("dataitem." + ((c)localObject1).field_dataId);
        ((axl)localObject2).ttR = "datastatus";
        ((axl)localObject2).nFs = "0";
        paramLinkedList1.add(localObject2);
        localObject2 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(((c)localObject1).field_favLocalId);
        if (localObject2 != null)
        {
          if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_type == 4) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label472;
            }
            localObject2 = b.a((com.tencent.mm.plugin.fav.a.g)localObject2, ((c)localObject1).field_dataId);
            if (localObject2 == null) {
              break;
            }
            axl localaxl = new axl();
            localaxl.kVl = ("dataitem." + ((c)localObject1).field_dataId + ".stream_videoid");
            localaxl.nFs = ((xv)localObject2).sVq;
            paramLinkedList1.add(localaxl);
            break;
          }
        }
      }
    }
  }
  
  public static void startSync()
  {
    aj localaj = new aj();
    com.tencent.mm.kernel.g.Dk().a(localaj, 0);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.getType() != 426) {}
    while (!(paramm instanceof al)) {
      return;
    }
    com.tencent.mm.kernel.g.DS().O(new d.1(this, paramm, paramInt2, paramInt1));
  }
  
  public final void run()
  {
    com.tencent.mm.kernel.g.DS().O(new d.2(this));
  }
  
  public final void uB()
  {
    this.bDS.clear();
    bDU.clear();
    this.bDX = false;
    this.bDW = false;
    kaO.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.d
 * JD-Core Version:    0.7.0.1
 */