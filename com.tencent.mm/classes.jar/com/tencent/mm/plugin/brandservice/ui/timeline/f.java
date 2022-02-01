package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.af;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.message.p;
import com.tencent.mm.message.u;
import com.tencent.mm.plugin.brandservice.model.l;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.plugin.findersdk.a.br;
import com.tencent.mm.plugin.webcanvas.j;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.enc;
import com.tencent.mm.protocal.protobuf.ene;
import com.tencent.mm.protocal.protobuf.enp;
import com.tencent.mm.protocal.protobuf.ens;
import com.tencent.mm.protocal.protobuf.fle;
import com.tencent.mm.protocal.protobuf.flf;
import com.tencent.mm.protocal.protobuf.flg;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.protocal.protobuf.fxo;
import com.tencent.mm.protocal.protobuf.nk;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.y;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public final class f
{
  public List<ab> dataList;
  public int hBm;
  public int vGW;
  public int vGX;
  public long vGY;
  public long vGZ;
  public long vHa;
  public long vHb;
  public int vHc;
  public int vHd;
  public int vHe;
  public String vHf;
  public com.tencent.mm.plugin.brandservice.ui.timeline.a.b vHg;
  public c<String, f.b> vHh;
  public HashMap<String, Boolean> vHi;
  a vHj;
  
  public f(int paramInt, long paramLong, Intent paramIntent)
  {
    AppMethodBeat.i(301844);
    this.vGZ = 0L;
    this.vHa = 0L;
    this.vHb = 0L;
    this.vHc = 0;
    this.vHd = 0;
    this.vHe = 0;
    this.vHf = "";
    this.dataList = null;
    this.vHh = new c();
    this.vHi = new HashMap();
    this.hBm = paramInt;
    this.vGY = paramLong;
    com.tencent.mm.storage.v localv = com.tencent.mm.storage.v.acEJ;
    this.vGZ = com.tencent.mm.storage.v.iXL();
    localv = com.tencent.mm.storage.v.acEJ;
    this.vHa = com.tencent.mm.storage.v.iXT();
    localv = com.tencent.mm.storage.v.acEJ;
    this.vHb = com.tencent.mm.storage.v.iXM();
    this.vHc = paramIntent.getIntExtra("Main_UnreadCount", 0);
    this.vHd = paramIntent.getIntExtra("Main_BizFinderLiveRedDotType", 0);
    this.vHe = paramIntent.getIntExtra("Main_BizExposeMsgType", 0);
    this.vHf = paramIntent.getStringExtra("Main_FromUserName");
    AppMethodBeat.o(301844);
  }
  
  private static f.b a(ab paramab, int paramInt, f.b paramb)
  {
    AppMethodBeat.i(301864);
    Object localObject1 = "";
    if (paramInt == 0) {}
    Object localObject3;
    Object localObject4;
    for (Object localObject2 = "";; localObject2 = String.valueOf(paramInt))
    {
      localObject3 = Boolean.FALSE;
      if ((!paramab.iYf()) || (paramab.iYp() == null) || (paramab.iYp().abLM == null) || (paramab.iYp().abLM.YSB == null)) {
        break label331;
      }
      localObject4 = paramab.iYp().abLM.YSB;
      paramab = (ab)localObject1;
      if (((LinkedList)localObject4).size() <= paramInt) {
        break label374;
      }
      paramab = (ab)localObject1;
      if (((qo)((LinkedList)localObject4).get(paramInt)).YVI == null) {
        break label374;
      }
      paramab = (ab)localObject1;
      if (((qo)((LinkedList)localObject4).get(paramInt)).YVI.size() <= paramInt) {
        break label374;
      }
      paramab = (ab)localObject1;
      if (((qo)((LinkedList)localObject4).get(paramInt)).YVI.get(paramInt) == null) {
        break label374;
      }
      localObject4 = (qn)((qo)((LinkedList)localObject4).get(paramInt)).YVI.get(paramInt);
      localObject1 = ((qn)localObject4).YVG;
      if (!Util.isNullOrNil((String)localObject1)) {
        break;
      }
      AppMethodBeat.o(301864);
      return paramb;
    }
    if (((qn)localObject4).YVG.startsWith("<finder_feed>"))
    {
      paramab = "";
      localObject2 = localObject3;
      if (((Boolean)localObject2).booleanValue())
      {
        localObject1 = SemiXml.decode((String)localObject1);
        label223:
        if (localObject1 != null)
        {
          paramab = ((br)com.tencent.mm.kernel.h.ax(br.class)).y(paramab, (Map)localObject1);
          if ((paramab != null) && (paramab.objectId != null))
          {
            paramb.YUa = paramab.objectId;
            paramb.YHv = 17;
          }
        }
        AppMethodBeat.o(301864);
        return paramb;
      }
    }
    else
    {
      paramab = (ab)localObject1;
      if (!((qn)localObject4).YVG.startsWith("~SEMI_XML~")) {
        break label374;
      }
      localObject3 = Boolean.TRUE;
      localObject2 = ".sysmsg.BizAccountRecommend.BizAccount" + (String)localObject2 + ".AppMsg";
    }
    for (;;)
    {
      paramab = (ab)localObject2;
      localObject2 = localObject3;
      break;
      label331:
      localObject1 = Boolean.TRUE;
      localObject3 = paramab.field_content;
      paramab = ".msg.appmsg.mmreader.category.item".concat(String.valueOf(localObject2));
      localObject2 = localObject1;
      localObject1 = localObject3;
      break;
      localObject1 = XmlParser.parseXml((String)localObject1, "finder_feed", null);
      break label223;
      label374:
      localObject2 = "";
      localObject1 = paramab;
    }
  }
  
  private static void a(f.b paramb, int paramInt)
  {
    AppMethodBeat.i(301854);
    int i = (int)(System.currentTimeMillis() / 1000L);
    if (i - paramb.YTx > 1) {
      paramb.YTp += 1;
    }
    paramb.pos = paramInt;
    paramb.YTx = i;
    AppMethodBeat.o(301854);
  }
  
  private void a(f.b paramb, int paramInt, ab paramab)
  {
    int i = 0;
    AppMethodBeat.i(301850);
    paramb.YTX = System.currentTimeMillis();
    paramb.YTx = ((int)(paramb.YTX / 1000L));
    paramb.pos = paramInt;
    paramb.kLn = paramab.field_bizClientMsgId;
    paramb.YTp = 1;
    paramb.YTw = 0;
    paramb.YTy = ((int)(paramab.field_createTime / 1000L));
    if (paramab.iYd())
    {
      paramInt = 3;
      paramb.YTA = paramInt;
      if (!this.vHi.containsKey(paramab.getId())) {
        break label169;
      }
    }
    label169:
    for (paramInt = i;; paramInt = 1)
    {
      paramb.YTG = paramInt;
      paramb.YTN = paramab.field_rankSessionId;
      paramb.weight = ((int)paramab.iYb());
      AppMethodBeat.o(301850);
      return;
      if (paramab.iYa() == af.bHl().iYD())
      {
        paramInt = 0;
        break;
      }
      if (System.currentTimeMillis() - paramab.field_createTime <= 86400000L)
      {
        paramInt = 1;
        break;
      }
      paramInt = 2;
      break;
    }
  }
  
  private static void a(f.b paramb, String paramString)
  {
    AppMethodBeat.i(5936);
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramString);
    if ((paramString != null) && (paramString.aSQ()))
    {
      paramb.YTv = 1;
      paramb.YTz = 1;
      AppMethodBeat.o(5936);
      return;
    }
    paramb.YTv = 0;
    paramb.YTz = 0;
    AppMethodBeat.o(5936);
  }
  
  public static void a(flj paramflj)
  {
    AppMethodBeat.i(301902);
    if (paramflj.abLM != null) {
      com.tencent.mm.plugin.report.service.h.OAn.b(21064, new Object[] { Long.valueOf(System.currentTimeMillis()), paramflj.abLM.YSF, Long.valueOf(paramflj.abry), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(paramflj.style), paramflj.abLM.YSJ });
    }
    AppMethodBeat.o(301902);
  }
  
  private void a(ab paramab, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(5939);
    com.tencent.mm.plugin.brandservice.b.au(new f.4(this, paramab, paramInt1, paramInt2, paramInt3));
    AppMethodBeat.o(5939);
  }
  
  private void a(final ab paramab, final f.b paramb)
  {
    AppMethodBeat.i(301908);
    com.tencent.mm.plugin.brandservice.b.au(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(5930);
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(paramb);
        if (!Util.isNullOrNil(paramb.vHw))
        {
          f.b localb = paramb;
          MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.vXs;
          localb.YTU = MPVideoPreviewMgr.ajW(paramb.vHw);
          localb = paramb;
          localMPVideoPreviewMgr = MPVideoPreviewMgr.vXs;
          localb.YTV = MPVideoPreviewMgr.ajX(paramb.vHw);
        }
        Log.i("MicroMsg.BizTimeLineReport", "reportOnClick %s.", new Object[] { paramab.getId() });
        com.tencent.mm.kernel.h.baD().mCm.a(new l(localLinkedList, f.this.vGW, f.this.vGX, f.this.hBm, f.this.vGY, 1, 1, f.this.vGZ), 0);
        AppMethodBeat.o(5930);
      }
    });
    AppMethodBeat.o(301908);
  }
  
  private void b(ab paramab, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(301883);
    Object localObject1 = new y();
    ((y)localObject1).field_msgId = paramab.field_msgId;
    ((y)localObject1).field_exposeType = y.acEY;
    ((y)localObject1).field_exposeTime = System.currentTimeMillis();
    af.bHn().a((y)localObject1);
    flj localflj = paramab.iYp();
    Object localObject3;
    int j;
    int i;
    Object localObject4;
    Object localObject2;
    if ((localflj != null) && ((localflj.style == 101) || (localflj.style == 102) || (localflj.style == 103)))
    {
      localObject3 = localflj.abLM;
      if ((localObject3 == null) || (Util.isNullOrNil(((apx)localObject3).YSB)))
      {
        AppMethodBeat.o(301883);
        return;
      }
      j = 0;
      i = 0;
      if (j < ((apx)localObject3).YSB.size())
      {
        if (((qo)((apx)localObject3).YSB.get(j)).YFu != 0) {
          break label1669;
        }
        localObject4 = (qn)((qo)((apx)localObject3).YSB.get(j)).YVI.get(0);
        localObject1 = (f.b)this.vHh.get(paramab.getId() + "_" + j);
        if (localObject1 == null)
        {
          localObject1 = new f.b();
          this.vHh.put(paramab.getId() + "_" + j, localObject1);
          ((f.b)localObject1).ADE = ((qo)((apx)localObject3).YSB.get(j)).UserName;
          if ((localObject4 != null) && ((((qn)localObject4).YFu & 0x1) == 0))
          {
            localObject2 = ((qn)localObject4).YQK;
            if (Util.isNullOrNil((String)localObject2)) {}
          }
        }
      }
    }
    label1669:
    for (;;)
    {
      try
      {
        localObject2 = Uri.parse((String)localObject2);
        int k = Util.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
        long l1 = Util.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
        ((f.b)localObject1).nSr = ((int)Util.getLong(new String(Base64.decode(((Uri)localObject2).getQueryParameter("__biz"), 2)), 0L));
        ((f.b)localObject1).YTo.add(Integer.valueOf(k));
        ((f.b)localObject1).hCz = l1;
        ((f.b)localObject1).YTC = l1;
        ((f.b)localObject1).YTP = ((qn)localObject4).YVE;
        ((f.b)localObject1).YTQ = ((qn)localObject4).YVF;
        a((f.b)localObject1, paramInt1, paramab);
        k = 3;
        if (localflj.style == 103) {
          k = 7;
        }
        ((f.b)localObject1).tNW = k;
        if (((qn)localObject4).IJA != null) {
          ((f.b)localObject1).YTL = aa.aUC(((qn)localObject4).IJA);
        }
        if (localflj != null) {
          ((f.b)localObject1).YTK = localflj.abry;
        }
        ((f.b)localObject1).YTD = j;
        if (localObject4 != null) {
          ((f.b)localObject1).YHv = ((qn)localObject4).nUA;
        }
        localObject2 = a(paramab, j, (f.b)localObject1);
        if (paramab.acFD != null)
        {
          k = paramab.acFD.style;
          ((f.b)localObject2).style = k;
          if (paramab.acFD == null) {
            continue;
          }
          localObject1 = paramab.acFD.event;
          ((f.b)localObject2).event = ((String)localObject1);
          if ((paramab.acFD != null) && (paramab.acFD.abLM != null))
          {
            ((f.b)localObject2).iaI = paramab.acFD.abLM.YSF;
            ((f.b)localObject2).YTO = paramab.acFD.abLM.YSJ;
          }
          if ((localflj.style == 102) || (localflj.style == 103))
          {
            ((f.b)localObject2).YTT = localflj.abLM.Zxr;
            ((f.b)localObject2).YTS = localflj.abLM.Zxq;
          }
          ((f.b)localObject2).wtD = localflj.abLM.Zxn;
          ((f.b)localObject2).YTZ = ((qn)localObject4).YQV;
          localObject1 = localObject2;
          ((f.b)localObject1).YUb |= paramInt2;
          if ((i == 0) && (localflj.abLM != null)) {
            com.tencent.mm.plugin.report.service.h.OAn.b(21064, new Object[] { Long.valueOf(System.currentTimeMillis()), localflj.abLM.YSF, Long.valueOf(localflj.abry), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(localflj.style), localflj.abLM.YSJ });
          }
          i = 1;
          j += 1;
          break;
        }
        k = 0;
        continue;
        localObject1 = "";
        continue;
        a((f.b)localObject1, paramInt1);
        continue;
        AppMethodBeat.o(301883);
        return;
        if ((localflj != null) && (localflj.style == 1001) && (localflj.abLO != null))
        {
          if (paramab.iYf())
          {
            localObject1 = (f.b)this.vHh.get(paramab.getId() + "_0");
            if (localObject1 == null)
            {
              localObject1 = new f.b();
              this.vHh.put(paramab.getId() + "_0", localObject1);
              ((f.b)localObject1).DVu = localflj.hRR;
              a((f.b)localObject1, paramInt1, paramab);
              ((f.b)localObject1).tNW = 5;
              if (localflj != null) {
                ((f.b)localObject1).YTK = localflj.abry;
              }
              ((f.b)localObject1).style = 1001;
              localObject2 = j.WkY;
              j.xC(74L);
              ((f.b)localObject1).YUb |= paramInt2;
              localObject2 = com.tencent.mm.plugin.report.service.h.OAn;
              l1 = System.currentTimeMillis();
              localObject3 = localflj.abLO.cardId;
              long l2 = localflj.abry;
              paramInt1 = localflj.style;
              if (localflj.abLM == null) {
                continue;
              }
              localObject1 = localflj.abLM.YSJ;
              ((com.tencent.mm.plugin.report.service.h)localObject2).b(21064, new Object[] { Long.valueOf(l1), localObject3, Long.valueOf(l2), Integer.valueOf(5), Integer.valueOf(1), Integer.valueOf(paramInt1), localObject1 });
              Log.i("MicroMsg.BizTimeLineReport", "onExposeRecCanvasMsg %d", new Object[] { Long.valueOf(paramab.field_msgId) });
            }
          }
          else
          {
            AppMethodBeat.o(301883);
            return;
          }
          a((f.b)localObject1, paramInt1);
          continue;
          localObject1 = "";
          continue;
        }
        localObject2 = paramab.iYo();
        if ((localObject2 == null) || (((fle)localObject2).YVI == null) || (((fle)localObject2).YVI.size() <= 0))
        {
          Log.w("MicroMsg.BizTimeLineReport", "recCard is null");
          AppMethodBeat.o(301883);
          return;
        }
        k = ((fle)localObject2).YVI.size();
        i = 0;
        if (i < k)
        {
          localObject3 = (flf)((fle)localObject2).YVI.get(i);
          localObject1 = (f.b)this.vHh.get(paramab.getId() + "_" + i);
          if (localObject1 == null)
          {
            localObject1 = new f.b();
            this.vHh.put(paramab.getId() + "_" + i, localObject1);
            ((f.b)localObject1).ADE = paramab.field_talker;
            if ((localObject3 != null) && ((((flf)localObject3).YFu & 0x1) == 0))
            {
              localObject4 = ((flf)((fle)localObject2).YVI.get(i)).YQK;
              if (Util.isNullOrNil((String)localObject4)) {}
            }
          }
        }
        try
        {
          localObject4 = Uri.parse((String)localObject4);
          j = Util.getInt(((Uri)localObject4).getQueryParameter("idx"), 0);
          l1 = Util.getLong(((Uri)localObject4).getQueryParameter("mid"), 0L);
          ((f.b)localObject1).nSr = ((int)Util.getLong(new String(Base64.decode(((Uri)localObject4).getQueryParameter("__biz"), 2)), 0L));
          ((f.b)localObject1).YTo.add(Integer.valueOf(j));
          ((f.b)localObject1).hCz = l1;
          ((f.b)localObject1).YTC = l1;
          if (localObject3 != null) {
            ((f.b)localObject1).YHv = ((flf)localObject3).nUA;
          }
          a((f.b)localObject1, paramInt1, paramab);
          ((f.b)localObject1).tNW = 1;
          if (((fle)localObject2).abLF != null) {
            ((f.b)localObject1).YTL = aa.aUC(((fle)localObject2).abLF.abLH);
          }
          if (localflj != null) {
            ((f.b)localObject1).YTK = localflj.abry;
          }
          ((f.b)localObject1).YTD = i;
          if (paramab.acFD != null)
          {
            j = paramab.acFD.style;
            ((f.b)localObject1).style = j;
            ((f.b)localObject1).wtD = ((fle)localObject2).Zxn;
            ((f.b)localObject1).YUb |= paramInt2;
            i += 1;
          }
          else
          {
            j = 0;
            continue;
            a((f.b)localObject1, paramInt1);
            continue;
            AppMethodBeat.o(301883);
            return;
          }
        }
        catch (Exception localException2) {}
      }
      catch (Exception localException1) {}
    }
  }
  
  private void c(ab paramab, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(301898);
    if ((!paramab.iYd()) || (paramab.acFJ == null) || (Util.isNullOrNil(paramab.acFJ.abrC)))
    {
      AppMethodBeat.o(301898);
      return;
    }
    ene localene = paramab.acFJ;
    int j = localene.abrC.size();
    int i = 0;
    for (;;)
    {
      enp localenp;
      Object localObject;
      f.b localb;
      if (i < j)
      {
        localenp = (enp)localene.abrC.get(i);
        localObject = (f.b)this.vHh.get(paramab.getId() + "_" + i);
        if (localObject == null)
        {
          localb = new f.b();
          this.vHh.put(paramab.getId() + "_" + i, localb);
          a(localb, paramInt1, paramab);
          if (i == 0) {
            localb.DVu = localene.YVK;
          }
          localb.tNW = ah.K(paramab);
          localb.YTY = paramab.acFz;
          localb.style = localene.bcb;
          localb.YTQ = localenp.YVF;
          localb.YHv = localenp.abse.nUA;
          localb.YTD = i;
          localb.ADE = localenp.absd.UserName;
          localb.iaI = localene.YSF;
          localObject = localenp.abse.YQK;
          if (Util.isNullOrNil((String)localObject)) {}
        }
      }
      try
      {
        localObject = Uri.parse((String)localObject);
        int k = Util.getInt(((Uri)localObject).getQueryParameter("idx"), 0);
        long l = Util.getLong(((Uri)localObject).getQueryParameter("mid"), 0L);
        localb.nSr = ((int)Util.getLong(new String(Base64.decode(((Uri)localObject).getQueryParameter("__biz"), 2)), 0L));
        localb.YTo.add(Integer.valueOf(k));
        localb.hCz = l;
        localb.YTC = l;
        label387:
        if (localene.bcb == 2002)
        {
          localb.YTT = localene.Zxr;
          localb.YTS = localene.Zxq;
          label418:
          if (localene.bcb != 2002) {
            break label574;
          }
          localb.YTL = aa.aUC(localene.abrE);
          label442:
          if (localenp.abse.aaID != null) {
            localb.YTZ = localenp.abse.aaID.YQV;
          }
          localb.YTI = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.c(localenp);
          if (localene.bcb != 2002) {
            break label653;
          }
          localObject = localene.abrF;
          label497:
          if (localObject != null) {
            localb.wtD = aa.aUC(((ens)localObject).wording);
          }
          localObject = j.WkY;
          j.xC(74L);
          localObject = localb;
        }
        for (;;)
        {
          ((f.b)localObject).YUb |= paramInt2;
          i += 1;
          break;
          localb.YTT = localenp.Zxr;
          localb.YTS = localenp.Zxq;
          break label418;
          label574:
          if (localene.bcb != 2001) {
            break label442;
          }
          localb.YTL = aa.aUC(localenp.abrE);
          if ((localenp.abse.nUA != 5) || (i != 0) || (!com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(localene)) || (localenp.abse.aaID == null)) {
            break label442;
          }
          localb.vHw = localenp.abse.aaID.YQV;
          break label442;
          label653:
          localObject = localenp.abrF;
          break label497;
          a((f.b)localObject, paramInt1);
        }
        AppMethodBeat.o(301898);
        return;
      }
      catch (Exception localException)
      {
        break label387;
      }
    }
  }
  
  private static int h(ab paramab)
  {
    AppMethodBeat.i(301915);
    if (paramab.iYl())
    {
      AppMethodBeat.o(301915);
      return 1;
    }
    if (paramab.iYk())
    {
      AppMethodBeat.o(301915);
      return 2;
    }
    if (paramab.iYj())
    {
      AppMethodBeat.o(301915);
      return 3;
    }
    AppMethodBeat.o(301915);
    return -1;
  }
  
  public final void Hm(int paramInt)
  {
    AppMethodBeat.i(5940);
    a("", 0L, 0, paramInt, -1);
    AppMethodBeat.o(5940);
  }
  
  public final void a(ab paramab, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(301946);
    if (paramab == null)
    {
      AppMethodBeat.o(301946);
      return;
    }
    Log.v("MicroMsg.BizTimeLineReport", "onExpose msgId=%s, pos=%d, isValidExposed=%d", new Object[] { paramab.getId(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject1;
    int j;
    f.b localb;
    if (paramab.iYe()) {
      if (paramab.iYe())
      {
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(paramab.field_msgId, paramab.field_content);
        if ((localObject1 == null) || (Util.isNullOrNil(((u)localObject1).nUC)))
        {
          AppMethodBeat.o(301946);
          return;
        }
        try
        {
          i = ((u)localObject1).nUC.size();
          if ((i <= 2) || (paramab.field_isExpand)) {
            break label1453;
          }
          i = 2;
        }
        catch (UnsupportedOperationException paramab)
        {
          for (;;)
          {
            int i;
            com.tencent.mm.message.v localv;
            Object localObject2;
            Log.w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", new Object[] { paramab.getMessage() });
            AppMethodBeat.o(301946);
            return;
            localb.YTq = 0;
          }
        }
        catch (Exception paramab)
        {
          Log.w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", new Object[] { paramab.getMessage() });
        }
        if (j >= i) {
          break label894;
        }
        localv = (com.tencent.mm.message.v)((u)localObject1).nUC.get(j);
        if (localv == null) {
          break label1459;
        }
        localb = (f.b)this.vHh.get(paramab.getId() + "_" + j);
        if (localb != null) {
          break label825;
        }
        localb = new f.b();
        this.vHh.put(paramab.getId() + "_" + j, localb);
        localb.ADE = paramab.field_talker;
        a(localb, paramInt1, paramab);
        localb.YTr = 0;
        localb.YTt = 0;
        localb.YTu = 0;
        localb.YSj = 0;
        localb.msg_type = localv.type;
        if (!Util.isNullOrNil(localv.url))
        {
          localObject2 = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiz(localv.url);
          if (localObject2 != null)
          {
            k = 0;
            if (((p)localObject2).nUx != null) {
              k = ((p)localObject2).nUx.nUr;
            }
            localb.YTB = ("1_" + k + ";");
            localb.YTW = ((p)localObject2).nUy;
          }
        }
        localb.YTD = j;
        if (!paramab.field_isExpand) {
          break label1468;
        }
        k = 1;
        label425:
        localb.YTE = k;
        if ((j != 0) || (!paramab.acFv)) {
          break label1474;
        }
        k = 1;
        label447:
        localb.YTI = k;
        if (!paramab.acFw) {
          break label1480;
        }
      }
    }
    label819:
    label825:
    label1468:
    label1474:
    label1480:
    for (int k = 1;; k = 0)
    {
      localb.YTJ = k;
      localb.YTM = localv.nQp;
      localb.YHv = localv.type;
      localb.YTN = paramab.field_rankSessionId;
      localb = a(paramab, j, localb);
      a(localb, paramab.field_talker);
      if (!Util.isNullOrNil(localv.url))
      {
        localObject2 = Uri.parse(localv.url);
        k = Util.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
        long l = Util.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
        localb.nSr = ((int)Util.getLong(new String(Base64.decode(((Uri)localObject2).getQueryParameter("__biz"), 2)), 0L));
        localb.YTo.add(Integer.valueOf(k));
        localb.hCz = l;
        localb.YTC = l;
      }
      if (paramab.field_isExpand)
      {
        localb.YTq = 2;
        localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramab.field_talker);
        if ((localObject2 == null) || (d.rs(((az)localObject2).field_type))) {
          break label819;
        }
      }
      for (k = 2;; k = 0)
      {
        localb.tNW = k;
        if (localv.type == 5) {
          localb.vHw = localv.vid;
        }
        localb.YTZ = localv.vid;
        localb.YUb |= paramInt2;
        break label1459;
        if (((u)localObject1).nUC.size() > 2)
        {
          localb.YTq = 1;
          break;
        }
        AppMethodBeat.o(301946);
        return;
      }
      if ((j == 0) && (paramab.acFv))
      {
        k = 1;
        label840:
        localb.YTI = k;
        if (!paramab.acFw) {
          break label888;
        }
      }
      label888:
      for (k = 1;; k = 0)
      {
        localb.YTJ = k;
        a(localb, paramInt1);
        a(localb, paramab.field_talker);
        break;
        k = 0;
        break label840;
      }
      label894:
      AppMethodBeat.o(301946);
      return;
      if (paramab.iYf())
      {
        b(paramab, paramInt1, paramInt2);
        AppMethodBeat.o(301946);
        return;
      }
      if (paramab.iYg())
      {
        if (paramab.iYg())
        {
          localb = (f.b)this.vHh.get(paramab.getId());
          if (localb != null) {
            break label1117;
          }
          localb = new f.b();
          this.vHh.put(paramab.getId(), localb);
          localb.ADE = paramab.field_talker;
          a(localb, paramInt1, paramab);
          localb.msg_type = h(paramab);
          a(localb, paramab.field_talker);
          localb.tNW = ah.K(paramab);
          localObject1 = paramab.iYs();
          localb.aid = ((String)localObject1);
          localb.traceid = paramab.getTraceId();
          paramab = com.tencent.mm.storage.r.acDM;
          if (!com.tencent.mm.storage.r.bvm((String)localObject1)) {
            break label1112;
          }
          paramInt1 = 1;
          localb.YTR = paramInt1;
        }
        for (paramab = localb;; paramab = localb)
        {
          paramab.YUb |= paramInt2;
          AppMethodBeat.o(301946);
          return;
          label1112:
          paramInt1 = 0;
          break;
          label1117:
          a(localb, paramInt1);
          a(localb, paramab.field_talker);
        }
      }
      if (paramab.iYd())
      {
        c(paramab, paramInt1, paramInt2);
        AppMethodBeat.o(301946);
        return;
      }
      localb = (f.b)this.vHh.get(paramab.getId());
      if (localb == null)
      {
        localb = new f.b();
        this.vHh.put(paramab.getId(), localb);
        localb.ADE = paramab.field_talker;
        localb.hCz = 0L;
        a(localb, paramInt1, paramab);
        localb.YTr = 0;
        localb.YTt = 0;
        localb.YTu = 0;
        localb.YSj = 0;
        localb.msg_type = h(paramab);
        a(localb, paramab.field_talker);
        if (paramab.acFv)
        {
          paramInt1 = 1;
          localb.YTI = paramInt1;
          if (!paramab.acFw) {
            break label1382;
          }
          paramInt1 = 1;
          localb.YTJ = paramInt1;
          paramab = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramab.field_talker);
          if ((paramab == null) || (d.rs(paramab.field_type))) {
            break label1387;
          }
        }
        label1382:
        label1387:
        for (paramInt1 = 3;; paramInt1 = 0)
        {
          localb.tNW = paramInt1;
          paramab = localb;
          paramab.YUb |= paramInt2;
          AppMethodBeat.o(301946);
          return;
          paramInt1 = 0;
          break;
          paramInt1 = 0;
          break label1305;
        }
      }
      a(localb, paramInt1);
      a(localb, paramab.field_talker);
      if (paramab.acFv)
      {
        paramInt1 = 1;
        localb.YTI = paramInt1;
        if (!paramab.acFw) {
          break label1448;
        }
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        localb.YTJ = paramInt1;
        paramab = localb;
        break;
        paramInt1 = 0;
        break label1416;
      }
      j = 0;
      break;
      j += 1;
      break;
      k = 0;
      break label425;
      k = 0;
      break label447;
    }
  }
  
  public final void a(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(5941);
    a(paramString, paramLong, paramInt1, paramInt2, paramInt3, 0L, false, 0);
    AppMethodBeat.o(5941);
  }
  
  public final void a(String paramString, long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean, int paramInt4)
  {
    AppMethodBeat.i(301996);
    int i = paramInt3;
    if (paramInt3 <= 0) {
      i = (int)(System.currentTimeMillis() / 1000L);
    }
    if (paramBoolean) {}
    for (paramInt3 = 1;; paramInt3 = 0)
    {
      au localau = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramString);
      int j = paramInt3;
      if (!paramBoolean)
      {
        j = paramInt3;
        if (localau != null)
        {
          j = paramInt3;
          if (!d.rs(localau.field_type)) {
            j = 3;
          }
        }
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(15721, new Object[] { paramString, Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(this.hBm), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), "", Integer.valueOf(j), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(301996);
      return;
    }
  }
  
  public final void a(String paramString1, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString2, int paramInt3, String paramString3, String paramString4, String paramString5, int paramInt4, int paramInt5, String paramString6)
  {
    AppMethodBeat.i(302005);
    int j = (int)(System.currentTimeMillis() / 1000L);
    int i = 3;
    if (paramInt5 == 103) {
      i = 7;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(15721, new Object[] { paramString1, Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Integer.valueOf(j), Integer.valueOf(this.hBm), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), paramString2, Integer.valueOf(i), Integer.valueOf(paramInt3), paramString3, paramString4, paramString5, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), paramString6 });
    AppMethodBeat.o(302005);
  }
  
  public final void a(String paramString1, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(302012);
    int j = (int)(System.currentTimeMillis() / 1000L);
    int i = 3;
    if (paramInt3 == 103) {
      i = 7;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(15721, new Object[] { paramString1, Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Integer.valueOf(j), Integer.valueOf(this.hBm), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), paramString2, Integer.valueOf(i), Integer.valueOf(0), paramString3, paramString4, paramString5, Integer.valueOf(0), Integer.valueOf(paramInt3), paramString6, paramString7, paramString8 });
    AppMethodBeat.o(302012);
  }
  
  public final void b(ab paramab, boolean paramBoolean)
  {
    AppMethodBeat.i(5937);
    paramab = (f.b)this.vHh.get(paramab.getId());
    if (paramab == null)
    {
      AppMethodBeat.o(5937);
      return;
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      paramab.YSj = i;
      AppMethodBeat.o(5937);
      return;
    }
  }
  
  public final void c(ab paramab, int paramInt)
  {
    AppMethodBeat.i(301966);
    d(paramab, paramInt, (int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(301966);
  }
  
  public final void d(ab paramab, int paramInt)
  {
    AppMethodBeat.i(5938);
    a(paramab, 0, paramInt, -1);
    AppMethodBeat.o(5938);
  }
  
  public final void d(ab paramab, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(301961);
    if (paramab == null)
    {
      AppMethodBeat.o(301961);
      return;
    }
    f.b localb = (f.b)this.vHh.get(paramab.getId() + "_" + paramInt1);
    Object localObject = localb;
    if (localb == null)
    {
      localObject = localb;
      if (this.vHg != null)
      {
        a(paramab, paramInt1, 1);
        this.vHg.def();
        localObject = (f.b)this.vHh.get(paramab.getId() + "_" + paramInt1);
      }
    }
    if (localObject != null)
    {
      ((f.b)localObject).YTH = 1;
      ((f.b)localObject).YUb = 1;
      Log.d("MicroMsg.BizTimeLineReport", "onClick %d", new Object[] { Integer.valueOf(paramInt1) });
      a(paramab, (f.b)localObject);
      localObject = g.vHx;
      g.a(paramab, this.dataList, this.vHh, paramInt1);
    }
    if ((!paramab.iYf()) && (!paramab.iYd())) {
      a(paramab, paramInt1, 11, paramInt2);
    }
    AppMethodBeat.o(301961);
  }
  
  public final void e(ab paramab, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(301971);
    if ((!paramab.iYd()) && (!paramab.iYf()))
    {
      AppMethodBeat.o(301971);
      return;
    }
    f.b localb = (f.b)this.vHh.get(paramab.getId() + "_" + paramInt1);
    if (localb == null)
    {
      Log.i("MicroMsg.BizTimeLineReport", "onClickTag fail sessionItem is null");
      AppMethodBeat.o(301971);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(localb);
    if (!Util.isNullOrNil(localb.vHw))
    {
      MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.vXs;
      localb.YTU = MPVideoPreviewMgr.ajW(localb.vHw);
      localMPVideoPreviewMgr = MPVideoPreviewMgr.vXs;
      localb.YTV = MPVideoPreviewMgr.ajX(localb.vHw);
    }
    Log.i("MicroMsg.BizTimeLineReport", "reportOnClick %s.", new Object[] { paramab.getId() });
    if (24 == paramInt2) {}
    for (paramInt1 = 2;; paramInt1 = 3)
    {
      com.tencent.mm.kernel.h.baD().mCm.a(new l(localLinkedList, this.vGW, this.vGX, this.hBm, this.vGY, 1, paramInt1, this.vGZ), 0);
      AppMethodBeat.o(301971);
      return;
    }
  }
  
  public final void g(ab paramab)
  {
    AppMethodBeat.i(301953);
    if (paramab.field_isRead == 1)
    {
      AppMethodBeat.o(301953);
      return;
    }
    this.vHi.put(paramab.getId(), Boolean.TRUE);
    if (paramab.iYg())
    {
      com.tencent.mm.storage.r localr = com.tencent.mm.storage.r.acDM;
      if (com.tencent.mm.storage.r.iXr()) {}
    }
    else
    {
      af.bHl().G(paramab);
    }
    AppMethodBeat.o(301953);
  }
  
  public final void n(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(302020);
    if (this.vHj == null) {
      this.vHj = new a((byte)0);
    }
    if (paramInt2 == 0)
    {
      localObject = this.vHj;
      ((a)localObject).vHs += 1;
      this.vHj.vHv = 0;
    }
    if (this.vHj.vHt == 0) {
      this.vHj.vHt = ((int)(System.currentTimeMillis() / 1000L));
    }
    Object localObject = this.vHj;
    int i = paramInt1;
    if (paramInt1 == 0) {
      i = this.vHj.msgType;
    }
    ((a)localObject).msgType = i;
    this.vHj.hBm = this.hBm;
    a locala = this.vHj;
    localObject = paramString;
    if ("".equals(paramString)) {
      localObject = this.vHj.hUQ;
    }
    locala.hUQ = ((String)localObject);
    if (this.vHj.vHu != 1) {
      this.vHj.vHu = paramInt2;
    }
    AppMethodBeat.o(302020);
  }
  
  static final class a
  {
    int hBm;
    String hUQ;
    int msgType;
    int vHs;
    int vHt;
    int vHu;
    int vHv = -1;
  }
  
  public final class c<K, V>
    extends HashMap<K, V>
  {
    public c() {}
    
    public final V put(K paramK, V paramV)
    {
      AppMethodBeat.i(301925);
      com.tencent.mm.plugin.brandservice.ui.timeline.a.b localb = f.this.vHg;
      String str = (String)paramK;
      f.b localb1 = (f.b)paramV;
      kotlin.g.b.s.u(str, "key");
      kotlin.g.b.s.u(localb1, "item");
      try
      {
        localb.vOc.put(str, localb1);
        paramK = super.put(paramK, paramV);
        AppMethodBeat.o(301925);
        return paramK;
      }
      finally
      {
        AppMethodBeat.o(301925);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.f
 * JD-Core Version:    0.7.0.1
 */