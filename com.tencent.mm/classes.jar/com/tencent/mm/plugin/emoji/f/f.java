package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.h.a.av;
import com.tencent.mm.h.a.av.b;
import com.tencent.mm.h.a.ni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.e.l;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.protocal.c.gk;
import com.tencent.mm.protocal.c.gl;
import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  extends m
  implements k
{
  public static int iZw = 0;
  public static int iZx = 1;
  public final b dmK;
  private com.tencent.mm.ah.f dmL;
  private LinkedList<String> iZA = new LinkedList();
  private ArrayList<String> iZv = new ArrayList();
  private HashMap<String, ut> iZy = new HashMap();
  public int iZz = 0;
  private int mIndex = 0;
  
  public f()
  {
    b.a locala = new b.a();
    locala.ecH = new gk();
    locala.ecI = new gl();
    locala.uri = "/cgi-bin/micromsg-bin/mmbatchemojidownload";
    locala.ecG = 697;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.mIndex = 0;
    this.iZz = iZw;
    this.iZA = new LinkedList();
  }
  
  public f(LinkedList<String> paramLinkedList)
  {
    b.a locala = new b.a();
    locala.ecH = new gk();
    locala.ecI = new gl();
    locala.uri = "/cgi-bin/micromsg-bin/mmbatchemojidownload";
    locala.ecG = 697;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.mIndex = 0;
    this.iZz = iZx;
    this.iZA = paramLinkedList;
  }
  
  private void a(gl paramgl)
  {
    if (paramgl == null) {
      y.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList response is null.");
    }
    for (;;)
    {
      return;
      if ((paramgl.sAu == null) || (paramgl.sAu.size() <= 0))
      {
        y.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addemojiInfoList EmojiList is null or size is empty.");
        return;
      }
      paramgl = paramgl.sAu.iterator();
      while (paramgl.hasNext())
      {
        ut localut = (ut)paramgl.next();
        String str = localut.jnU.toLowerCase();
        this.iZv.add(str);
        this.iZy.put(str, localut);
      }
    }
  }
  
  protected final int Ka()
  {
    return 20;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    paramf = (gk)this.dmK.ecE.ecN;
    paramf.sAr = this.mIndex;
    paramf.sAs = this.iZz;
    paramf.sAt = this.iZA;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    ArrayList localArrayList;
    boolean bool;
    Object localObject;
    long l2;
    if (this.iZz == iZw)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        com.tencent.mm.plugin.report.service.h.nFQ.a(164L, 1L, 1L, false);
        g.DP().Dz().c(ac.a.uog, Long.valueOf(System.currentTimeMillis() - 86400000L + 3600000L));
        return;
      }
      paramq = (gl)this.dmK.ecF.ecN;
      paramArrayOfByte = (gk)this.dmK.ecE.ecN;
      if ((paramq.euw == 0) && ((paramq.syU == null) || (paramq.syU.size() <= 0)))
      {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        y.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] donwload list is null");
        com.tencent.mm.plugin.report.service.h.nFQ.a(164L, 0L, 1L, false);
        return;
      }
      if (paramq.euw == 1)
      {
        if (this.iZy == null) {}
        for (paramInt1 = 0;; paramInt1 = this.iZy.size())
        {
          y.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] preparedDownloadCustomEmojiList size:%s", new Object[] { Integer.valueOf(paramInt1) });
          this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
          g.DP().Dz().c(ac.a.uog, Long.valueOf(System.currentTimeMillis()));
          a(paramq);
          localArrayList = this.iZv;
          if ((localArrayList != null) && (localArrayList.size() > 0)) {
            break;
          }
          y.w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] perparedDownloadCustomEmojiList failed. list is null.");
          g.DP().Dz().c(ac.a.unV, Boolean.valueOf(false));
          com.tencent.mm.plugin.report.service.h.nFQ.a(164L, 0L, 1L, false);
          return;
        }
        if (localArrayList.size() < l.aHC()) {
          g.DP().Dz().c(ac.a.unV, Boolean.valueOf(false));
        }
        bool = ((Boolean)g.DP().Dz().get(ac.a.unY, Boolean.valueOf(true))).booleanValue();
        localObject = i.getEmojiStorageMgr().uBb;
        y.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDownloadCustomEmojiList");
        l2 = System.currentTimeMillis();
        if ((localArrayList == null) || (localArrayList.size() <= 0))
        {
          y.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] perparedDownloadCustomEmojiList failed. list is null");
          g.DP().Dz().c(ac.a.unY, Boolean.valueOf(false));
          paramString = i.getEmojiStorageMgr().uBb;
          y.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDeleteCustomEmojiList");
          l1 = System.currentTimeMillis();
          if ((localArrayList == null) || (localArrayList.size() <= 0))
          {
            y.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. list is null");
            label493:
            paramq = (ArrayList)i.getEmojiStorageMgr().uBb.cwP();
            if (paramq.size() <= 0) {
              break label1419;
            }
            y.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "try to sync emoji downloadList:%d", new Object[] { Integer.valueOf(paramq.size()) });
            paramString = new ArrayList();
            paramInt2 = paramq.size();
            paramInt1 = 0;
          }
        }
        else
        {
          for (;;)
          {
            if (paramInt1 < paramInt2)
            {
              paramArrayOfByte = ((String)paramq.get(paramInt1)).toLowerCase();
              if ((this.iZy != null) && (this.iZy.containsKey(paramArrayOfByte)) && (this.iZy.get(paramArrayOfByte) != null))
              {
                localObject = (ut)this.iZy.get(paramArrayOfByte);
                paramString.add(new com.tencent.mm.plugin.emoji.sync.a.a(paramArrayOfByte, ((ut)localObject).kSC, ((ut)localObject).mQp, ((ut)localObject).sRs, ((ut)localObject).sRt, ((ut)localObject).sRu, ((ut)localObject).syc, ((ut)localObject).sRv, ((ut)localObject).sRw, ((ut)localObject).sRx, ((ut)localObject).jnN));
                label684:
                paramInt1 += 1;
                continue;
                paramString = null;
                if (!(((d)localObject).dXw instanceof com.tencent.mm.cf.h)) {
                  break label1657;
                }
                paramString = (com.tencent.mm.cf.h)((d)localObject).dXw;
              }
            }
          }
        }
      }
    }
    label833:
    label991:
    label1657:
    for (long l1 = paramString.eV(Thread.currentThread().getId());; l1 = -1L)
    {
      Iterator localIterator = localArrayList.iterator();
      paramInt1 = 1;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label1064;
        }
        String str = (String)localIterator.next();
        paramArrayOfByte = ((d)localObject).acC(str);
        if ((paramArrayOfByte == null) || (bk.bl(paramArrayOfByte.Wv())) || (!paramArrayOfByte.cwz()))
        {
          paramq = new EmojiInfo();
          paramq.field_md5 = str;
          paramq.field_catalog = 85;
          paramq.field_source = EmojiInfo.uDl;
          paramq.field_lastUseTime = System.currentTimeMillis();
          paramq.field_reserved3 = paramInt1;
          if (bool)
          {
            y.d("MicroMsg.emoji.EmojiInfoStorage", "need repair");
            paramq.field_temp = 2;
          }
          if (paramq.cwz()) {
            break label991;
          }
          y.d("MicroMsg.emoji.EmojiInfoStorage", "file don't exist");
          paramq.field_temp = 2;
        }
        for (;;)
        {
          paramq = paramq.vf();
          if (((d)localObject).dXw.replace("EmojiInfo", "md5", paramq) >= 0L) {
            break label1057;
          }
          if (paramString != null) {
            paramString.hI(l1);
          }
          y.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDownloadCustomEmojiList user time:%d faild ", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
          break;
          paramArrayOfByte.field_source = EmojiInfo.uDl;
          paramq = paramArrayOfByte;
          if (paramArrayOfByte.field_catalog != EmojiInfo.uCT) {
            break label833;
          }
          paramArrayOfByte.field_catalog = EmojiInfo.uCZ;
          paramq = paramArrayOfByte;
          break label833;
          paramArrayOfByte = new av();
          paramArrayOfByte.bHb.type = 0;
          paramArrayOfByte.bHb.bHd = paramq;
          com.tencent.mm.sdk.b.a.udP.m(paramArrayOfByte);
          if (!paramArrayOfByte.bHc.bFQ)
          {
            y.d("MicroMsg.emoji.EmojiInfoStorage", "decode failed re download.");
            paramq.field_temp = 2;
          }
        }
        paramInt1 += 1;
      }
      if (paramString != null) {
        paramString.hI(l1);
      }
      l1 = System.currentTimeMillis();
      if (localArrayList == null) {}
      for (paramInt1 = 0;; paramInt1 = localArrayList.size())
      {
        y.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDownloadCustomEmojiList user time:%d succes. size:%d", new Object[] { Long.valueOf(l1 - l2), Integer.valueOf(paramInt1) });
        break;
      }
      paramArrayOfByte = paramString.cwO();
      if (paramArrayOfByte.size() <= 0)
      {
        y.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. sync list is null");
        break label493;
      }
      paramq = new ArrayList();
      paramArrayOfByte = paramArrayOfByte.iterator();
      while (paramArrayOfByte.hasNext())
      {
        localObject = (String)paramArrayOfByte.next();
        if (!localArrayList.contains(((String)localObject).toLowerCase()))
        {
          paramq.add(localObject);
          y.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] delete:%s", new Object[] { localObject });
        }
      }
      paramString.dI(paramq);
      y.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDeleteCustomEmojiList user time:%d succes. size:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(paramq.size()) });
      break label493;
      y.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "emoji info list no contains md5:%s", new Object[] { paramArrayOfByte });
      break label684;
      paramq = i.aHQ();
      paramInt1 = localArrayList.size();
      paramq.jan.jay = paramInt1;
      i.aHQ().u(paramString);
      i.aHQ().jan.aIn();
      com.tencent.mm.plugin.report.service.h.nFQ.f(11595, new Object[] { Integer.valueOf(2) });
      if (aq.isWifi(ae.getContext())) {
        com.tencent.mm.plugin.report.service.h.nFQ.f(11595, new Object[] { Integer.valueOf(3) });
      }
      for (;;)
      {
        com.tencent.mm.sdk.b.a.udP.m(new ni());
        break;
        g.DP().Dz().c(ac.a.uod, Boolean.valueOf(false));
        y.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "no things need to download.");
      }
      y.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] do next scene. index:%d size:%d", new Object[] { Integer.valueOf(paramArrayOfByte.sAr), Integer.valueOf(paramq.syU.size()) });
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramArrayOfByte.sAr = paramq.sAr;
      this.mIndex = paramArrayOfByte.sAr;
      a(paramq);
      paramInt2 = a(this.edc, this.dmL);
      if (paramInt1 >= 0) {
        break;
      }
      y.e("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] doScene error.nextNetId:%d", new Object[] { Integer.valueOf(paramInt2) });
      return;
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      paramq = (gl)this.dmK.ecF.ecN;
      if ((paramq.sAu == null) || (paramq.sAu.size() <= 0)) {
        y.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "Change MD5 to URL failed.");
      }
      for (;;)
      {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
        i.getEmojiStorageMgr().uBb.dK(paramq.sAu);
      }
    }
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 697;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.f
 * JD-Core Version:    0.7.0.1
 */