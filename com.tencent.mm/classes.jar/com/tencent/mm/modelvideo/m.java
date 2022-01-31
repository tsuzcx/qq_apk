package com.tencent.mm.modelvideo;

import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.c;
import com.tencent.mm.al.f;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.i.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class m
{
  private static int ckO = 0;
  private boolean ckL;
  int ckM;
  private g.a ckQ;
  private ap ckR;
  private Map<Long, String> fWA;
  private Object fWB;
  String fWC;
  private LinkedList<Long> fWy;
  private Map<Long, g.a> fWz;
  private boolean running;
  
  public m()
  {
    AppMethodBeat.i(50744);
    this.fWy = new LinkedList();
    this.fWz = new HashMap();
    this.fWA = new HashMap();
    this.fWB = new Object();
    this.ckL = false;
    this.running = false;
    this.ckM = 0;
    this.ckQ = new g.a();
    this.ckR = new ap(com.tencent.mm.kernel.g.RO().oNc.getLooper(), new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(50739);
        m.h(m.this);
        AppMethodBeat.o(50739);
        return false;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(50740);
        String str = super.toString() + "|scenePusher";
        AppMethodBeat.o(50740);
        return str;
      }
    }, false);
    AppMethodBeat.o(50744);
  }
  
  private void ET()
  {
    AppMethodBeat.i(50749);
    this.fWA.clear();
    this.fWz.clear();
    this.fWy.clear();
    this.ckL = false;
    this.running = false;
    ab.d("MicroMsg.SightMassSendService", "Finish service use time(ms):" + this.ckQ.Mm());
    AppMethodBeat.o(50749);
  }
  
  public static void ah(List<s> paramList)
  {
    AppMethodBeat.i(50745);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(50745);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      u.vk(((s)paramList.next()).getFileName());
    }
    AppMethodBeat.o(50745);
  }
  
  public static void ai(List<s> paramList)
  {
    AppMethodBeat.i(50746);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(50746);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      u.vl(((s)paramList.next()).getFileName());
    }
    AppMethodBeat.o(50746);
  }
  
  private String hd(long paramLong)
  {
    AppMethodBeat.i(50747);
    Object localObject2 = o.alE().he(paramLong);
    if (((List)localObject2).isEmpty())
    {
      ab.e("MicroMsg.SightMassSendService", "check use cdn fail: mass send video list empty");
      AppMethodBeat.o(50747);
      return null;
    }
    Object localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (s)((Iterator)localObject1).next();
      if (com.tencent.mm.model.t.oE(((s)localObject3).getUser()))
      {
        ab.w("MicroMsg.SightMassSendService", "cdntra not use cdn user:%s, list %s, massSendId %d", new Object[] { ((s)localObject3).getUser(), ((s)localObject3).fXF, Long.valueOf(paramLong) });
        AppMethodBeat.o(50747);
        return null;
      }
      f.afO();
      if ((!b.lc(2)) && (((s)localObject3).fXC != 1))
      {
        f.afO();
        ab.w("MicroMsg.SightMassSendService", "cdntra not use cdn flag:%b getCdnInfo:%d, list %s, massSendId %d", new Object[] { Boolean.valueOf(b.lc(2)), Integer.valueOf(((s)localObject3).fXC), ((s)localObject3).fXF, Long.valueOf(paramLong) });
        AppMethodBeat.o(50747);
        return null;
      }
    }
    if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
      localObject1 = null;
    }
    while (localObject1 == null)
    {
      ab.w("MicroMsg.SightMassSendService", "check use cdn fail: no valid info");
      AppMethodBeat.o(50747);
      return null;
      int i = 0;
      for (;;)
      {
        if (i >= ((List)localObject2).size()) {
          break label425;
        }
        localObject3 = (s)((List)localObject2).get(i);
        localObject1 = u.vr(((s)localObject3).getFileName());
        if (localObject1 != null)
        {
          ab.i("MicroMsg.SightMassSendService", "check %s ok, index %d, size %d, massSendId %d, massSendList %s", new Object[] { ((s)localObject3).getFileName(), Integer.valueOf(i), Integer.valueOf(((List)localObject2).size()), Long.valueOf(paramLong), ((s)localObject3).fXF });
          ((List)localObject2).remove(i);
          ((List)localObject2).add(i, localObject1);
          break;
        }
        ab.w("MicroMsg.SightMassSendService", "check %s fail, index %d, size %d, massSendId %d, massSendList %s", new Object[] { ((s)localObject3).getFileName(), Integer.valueOf(i), Integer.valueOf(((List)localObject2).size()), Long.valueOf(paramLong), ((s)localObject3).fXF });
        i += 1;
      }
      label425:
      localObject1 = null;
    }
    Object localObject3 = c.a("upvideo", ((s)localObject1).createTime, ((s)localObject1).fXF, ((s)localObject1).getFileName());
    if (bo.isNullOrNil((String)localObject3))
    {
      ab.w("MicroMsg.SightMassSendService", "cdntra genClientId failed not use cdn file:%s, massSendId %d, massSendList %s", new Object[] { ((s)localObject1).getFileName(), Long.valueOf(((s)localObject1).fVM), ((s)localObject1).fXF });
      AppMethodBeat.o(50747);
      return null;
    }
    Object localObject4 = ((s)localObject1).getFileName();
    o.alE();
    String str1 = t.vg((String)localObject4);
    o.alE();
    String str2 = t.vf((String)localObject4);
    m.a locala = new m.a(this, (byte)0);
    locala.foQ = ((List)localObject2);
    locala.fVM = paramLong;
    locala.fWF = ((String)localObject3);
    locala.startTime = bo.aoy();
    locala.fVN = ((s)localObject1);
    localObject4 = new com.tencent.mm.i.g();
    ((com.tencent.mm.i.g)localObject4).edp = locala;
    ((com.tencent.mm.i.g)localObject4).field_mediaId = ((String)localObject3);
    ((com.tencent.mm.i.g)localObject4).field_fullpath = str2;
    ((com.tencent.mm.i.g)localObject4).field_thumbpath = str1;
    ((com.tencent.mm.i.g)localObject4).field_fileType = a.MediaType_VIDEO;
    ((com.tencent.mm.i.g)localObject4).field_smallVideoFlag = 1;
    ((com.tencent.mm.i.g)localObject4).field_talker = ((s)localObject1).fXF;
    ((com.tencent.mm.i.g)localObject4).field_priority = a.ecF;
    ((com.tencent.mm.i.g)localObject4).field_needStorage = false;
    ((com.tencent.mm.i.g)localObject4).field_isStreamMedia = false;
    localObject1 = br.F(((s)localObject1).alP(), "msg");
    if (localObject1 != null)
    {
      ((com.tencent.mm.i.g)localObject4).field_fileId = ((String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"));
      ((com.tencent.mm.i.g)localObject4).field_aesKey = ((String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
    }
    while (!f.afO().e((com.tencent.mm.i.g)localObject4))
    {
      ab.e("MicroMsg.SightMassSendService", "cdntra addSendTask failed.");
      AppMethodBeat.o(50747);
      return null;
      ab.i("MicroMsg.SightMassSendService", "cdntra parse video recv xml failed");
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (s)((Iterator)localObject1).next();
      if (((s)localObject2).fXC != 1)
      {
        ((s)localObject2).fXC = 1;
        ((s)localObject2).bsY = 524288;
        boolean bool = u.f((s)localObject2);
        ab.i("MicroMsg.SightMassSendService", "update %s useCDN, result %B", new Object[] { ((s)localObject2).getFileName(), Boolean.valueOf(bool) });
      }
    }
    AppMethodBeat.o(50747);
    return localObject3;
  }
  
  public final void d(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50748);
    com.tencent.mm.kernel.g.RO().ac(new m.2(this, paramLong, paramInt1, paramInt2));
    AppMethodBeat.o(50748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.m
 * JD-Core Version:    0.7.0.1
 */