package com.tencent.mm.modelvideo;

import android.os.HandlerThread;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.c;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.j.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class m
{
  private static int bEa = 0;
  private boolean bDW = false;
  private boolean bDX = false;
  int bDY = 0;
  private g.a bEc = new g.a();
  private am bEd = new am(g.DS().mnU.getLooper(), new m.4(this), false);
  private LinkedList<Long> eGI = new LinkedList();
  private Map<Long, g.a> eGJ = new HashMap();
  private Map<Long, String> eGK = new HashMap();
  private Object eGL = new Object();
  String eGM;
  
  public static void aa(List<s> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        u.nX(((s)paramList.next()).getFileName());
      }
    }
  }
  
  public static void ab(List<s> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        u.nY(((s)paramList.next()).getFileName());
      }
    }
  }
  
  private String ch(long paramLong)
  {
    Object localObject2 = o.Sr().ci(paramLong);
    if (((List)localObject2).isEmpty())
    {
      y.e("MicroMsg.SightMassSendService", "check use cdn fail: mass send video list empty");
      return null;
    }
    Object localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (s)((Iterator)localObject1).next();
      if (com.tencent.mm.model.s.hV(((s)localObject3).SA()))
      {
        y.w("MicroMsg.SightMassSendService", "cdntra not use cdn user:%s, list %s, massSendId %d", new Object[] { ((s)localObject3).SA(), ((s)localObject3).eHP, Long.valueOf(paramLong) });
        return null;
      }
      com.tencent.mm.ak.f.Nd();
      if ((!b.iq(2)) && (((s)localObject3).eHM != 1))
      {
        com.tencent.mm.ak.f.Nd();
        y.w("MicroMsg.SightMassSendService", "cdntra not use cdn flag:%b getCdnInfo:%d, list %s, massSendId %d", new Object[] { Boolean.valueOf(b.iq(2)), Integer.valueOf(((s)localObject3).eHM), ((s)localObject3).eHP, Long.valueOf(paramLong) });
        return null;
      }
    }
    if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
      localObject1 = null;
    }
    while (localObject1 == null)
    {
      y.w("MicroMsg.SightMassSendService", "check use cdn fail: no valid info");
      return null;
      int i = 0;
      for (;;)
      {
        if (i >= ((List)localObject2).size()) {
          break label389;
        }
        localObject3 = (s)((List)localObject2).get(i);
        localObject1 = u.oe(((s)localObject3).getFileName());
        if (localObject1 != null)
        {
          y.i("MicroMsg.SightMassSendService", "check %s ok, index %d, size %d, massSendId %d, massSendList %s", new Object[] { ((s)localObject3).getFileName(), Integer.valueOf(i), Integer.valueOf(((List)localObject2).size()), Long.valueOf(paramLong), ((s)localObject3).eHP });
          ((List)localObject2).remove(i);
          ((List)localObject2).add(i, localObject1);
          break;
        }
        y.w("MicroMsg.SightMassSendService", "check %s fail, index %d, size %d, massSendId %d, massSendList %s", new Object[] { ((s)localObject3).getFileName(), Integer.valueOf(i), Integer.valueOf(((List)localObject2).size()), Long.valueOf(paramLong), ((s)localObject3).eHP });
        i += 1;
      }
      label389:
      localObject1 = null;
    }
    Object localObject3 = c.a("upvideo", ((s)localObject1).createTime, ((s)localObject1).eHP, ((s)localObject1).getFileName());
    if (bk.bl((String)localObject3))
    {
      y.w("MicroMsg.SightMassSendService", "cdntra genClientId failed not use cdn file:%s, massSendId %d, massSendList %s", new Object[] { ((s)localObject1).getFileName(), Long.valueOf(((s)localObject1).eFV), ((s)localObject1).eHP });
      return null;
    }
    Object localObject4 = ((s)localObject1).getFileName();
    o.Sr();
    String str1 = t.nT((String)localObject4);
    o.Sr();
    String str2 = t.nS((String)localObject4);
    m.a locala = new m.a(this, (byte)0);
    locala.dYN = ((List)localObject2);
    locala.eFV = paramLong;
    locala.eGP = ((String)localObject3);
    locala.startTime = bk.UY();
    locala.eFW = ((s)localObject1);
    localObject4 = new com.tencent.mm.j.f();
    ((com.tencent.mm.j.f)localObject4).dlP = locala;
    ((com.tencent.mm.j.f)localObject4).field_mediaId = ((String)localObject3);
    ((com.tencent.mm.j.f)localObject4).field_fullpath = str2;
    ((com.tencent.mm.j.f)localObject4).field_thumbpath = str1;
    ((com.tencent.mm.j.f)localObject4).field_fileType = a.MediaType_VIDEO;
    ((com.tencent.mm.j.f)localObject4).field_smallVideoFlag = 1;
    ((com.tencent.mm.j.f)localObject4).field_talker = ((s)localObject1).eHP;
    ((com.tencent.mm.j.f)localObject4).field_priority = a.dlk;
    ((com.tencent.mm.j.f)localObject4).field_needStorage = false;
    ((com.tencent.mm.j.f)localObject4).field_isStreamMedia = false;
    localObject1 = bn.s(((s)localObject1).SD(), "msg");
    if (localObject1 != null)
    {
      ((com.tencent.mm.j.f)localObject4).field_fileId = ((String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"));
      ((com.tencent.mm.j.f)localObject4).field_aesKey = ((String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
    }
    while (!com.tencent.mm.ak.f.Nd().c((com.tencent.mm.j.f)localObject4))
    {
      y.e("MicroMsg.SightMassSendService", "cdntra addSendTask failed.");
      return null;
      y.i("MicroMsg.SightMassSendService", "cdntra parse video recv xml failed");
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (s)((Iterator)localObject1).next();
      if (((s)localObject2).eHM != 1)
      {
        ((s)localObject2).eHM = 1;
        ((s)localObject2).bcw = 524288;
        boolean bool = u.f((s)localObject2);
        y.i("MicroMsg.SightMassSendService", "update %s useCDN, result %B", new Object[] { ((s)localObject2).getFileName(), Boolean.valueOf(bool) });
      }
    }
    return localObject3;
  }
  
  private void uB()
  {
    this.eGK.clear();
    this.eGJ.clear();
    this.eGI.clear();
    this.bDW = false;
    this.bDX = false;
    y.d("MicroMsg.SightMassSendService", "Finish service use time(ms):" + this.bEc.zJ());
  }
  
  public final void d(long paramLong, int paramInt1, int paramInt2)
  {
    g.DS().O(new m.2(this, paramLong, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.m
 * JD-Core Version:    0.7.0.1
 */