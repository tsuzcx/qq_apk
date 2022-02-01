package com.tencent.mm.plugin.emoji.sync.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.l;
import com.tencent.mm.g.a.de;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.plugin.emoji.sync.c
{
  private EmojiInfo fLP;
  private String oyK;
  private String oyL;
  private String oyj;
  private d ozL;
  private String ozM;
  private String ozN;
  private String ozO;
  private String ozP;
  private String ozQ;
  private String ozR;
  private String ozS;
  private com.tencent.mm.plugin.emoji.d.a ozT;
  private com.tencent.mm.aw.a.b.a ozU;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    AppMethodBeat.i(108769);
    if (bt.isNullOrNil(paramString1)) {
      ad.e("MicroMsg.BKGLoader.EmojiDownloadTask", "[cpan] can not create task md5 is null.");
    }
    this.ozM = paramString1;
    this.ozN = paramString2;
    this.ozO = paramString3;
    this.oyK = paramString4;
    this.ozP = paramString5;
    this.ozQ = paramString6;
    this.ozR = paramString8;
    this.ozS = paramString9;
    this.oyj = paramString7;
    this.oyL = paramString10;
    this.fLP = k.getEmojiStorageMgr().FyY.aJx(this.ozM);
    if (this.fLP == null)
    {
      this.fLP = new EmojiInfo();
      this.fLP.field_md5 = this.ozM;
      this.fLP.field_cdnUrl = this.ozN;
      this.fLP.field_thumbUrl = this.ozO;
      this.fLP.field_designerID = this.oyK;
      this.fLP.field_encrypturl = this.ozP;
      this.fLP.field_aeskey = this.ozQ;
      this.fLP.field_groupId = this.oyj;
    }
    if (!bt.isNullOrNil(this.ozN))
    {
      this.fLP.field_cdnUrl = this.ozN;
      if (bt.isNullOrNil(this.ozP)) {
        break label401;
      }
      this.fLP.field_encrypturl = this.ozP;
      this.fLP.field_aeskey = this.ozQ;
    }
    for (;;)
    {
      if (!bt.isNullOrNil(this.oyK)) {
        this.fLP.field_designerID = this.oyK;
      }
      if (!bt.isNullOrNil(this.oyj)) {
        this.fLP.field_groupId = this.oyj;
      }
      if (!bt.isNullOrNil(this.ozO)) {
        this.fLP.field_thumbUrl = this.ozO;
      }
      if (!bt.isNullOrNil(this.oyL)) {
        this.fLP.field_activityid = this.oyL;
      }
      this.fLP.field_externUrl = this.ozR;
      this.fLP.field_externMd5 = this.ozS;
      this.fLP.field_attachedText = null;
      this.ozT = new com.tencent.mm.plugin.emoji.d.a();
      this.ozU = new com.tencent.mm.aw.a.b.a();
      AppMethodBeat.o(108769);
      return;
      this.ozN = this.fLP.field_cdnUrl;
      break;
      label401:
      this.ozP = this.fLP.field_encrypturl;
      this.ozQ = this.fLP.field_aeskey;
    }
  }
  
  private void bVB()
  {
    AppMethodBeat.i(108771);
    ad.i("MicroMsg.BKGLoader.EmojiDownloadTask", "disable to download emoji when cdn download failed.");
    de localde = new de();
    localde.dfm.md5 = this.ozM;
    localde.dfm.dbV = 0;
    localde.dfm.success = false;
    com.tencent.mm.sdk.b.a.ESL.l(localde);
    if (this.fLP != null)
    {
      ad.i("MicroMsg.BKGLoader.EmojiDownloadTask", "[cpan] this emoji is broken. md5 is:%s", new Object[] { this.fLP.JS() });
      this.fLP.field_state = EmojiInfo.LCf;
      this.fLP.field_catalog = EmojiInfo.LBQ;
      k.getEmojiStorageMgr().FyY.L(this.fLP);
    }
    AppMethodBeat.o(108771);
  }
  
  public final void a(d paramd)
  {
    this.ozL = paramd;
  }
  
  public final void cancel() {}
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108772);
    if ((paramObject != null) && ((paramObject instanceof a)))
    {
      paramObject = (a)paramObject;
      if ((!bt.isNullOrNil(this.ozM)) && (!bt.isNullOrNil(paramObject.ozM)) && (this.ozM.equals(paramObject.ozM)))
      {
        AppMethodBeat.o(108772);
        return true;
      }
    }
    AppMethodBeat.o(108772);
    return false;
  }
  
  public final String getKey()
  {
    return this.ozM;
  }
  
  public final void run()
  {
    AppMethodBeat.i(108770);
    Object localObject1;
    int i;
    if (this.ozL != null)
    {
      this.ozL.Ue(this.ozM);
      ad.i("MicroMsg.BKGLoader.EmojiDownloadTask", "emoji md5:%s cndUrl:%s thumbUrl:%s field_designerID:%s field_encrypturl:%s field_groupId:%s", new Object[] { this.fLP.JS(), this.fLP.field_cdnUrl, this.fLP.field_thumbUrl, this.fLP.field_designerID, this.fLP.field_encrypturl, this.fLP.field_groupId });
      if ((bt.isNullOrNil(this.ozN)) && (bt.isNullOrNil(this.ozP)) && (bt.isNullOrNil(this.ozR))) {
        break label929;
      }
      localObject1 = this.ozN;
      if ((bt.isNullOrNil(this.ozR)) || (bt.isNullOrNil(this.ozS))) {
        break label322;
      }
      localObject1 = this.ozR;
      i = 1;
    }
    for (;;)
    {
      label161:
      long l = System.currentTimeMillis();
      Object localObject5 = this.ozT.yy((String)localObject1);
      if ((localObject5 == null) || (bt.cw(((com.tencent.mm.aw.a.d.b)localObject5).data)))
      {
        ad.d("MicroMsg.BKGLoader.EmojiDownloadTask", "get image data suuse time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        bVB();
      }
      for (;;)
      {
        if (!bt.isNullOrNil(this.fLP.field_thumbUrl))
        {
          localObject1 = this.ozT.yy(this.fLP.field_thumbUrl);
          if (localObject1 != null) {
            this.ozU.a(this.fLP.field_thumbUrl, ((com.tencent.mm.aw.a.d.b)localObject1).data, com.tencent.mm.plugin.emoji.e.e.p(this.fLP.gaa() + "_cover", new Object[0]));
          }
        }
        AppMethodBeat.o(108770);
        return;
        ad.w("MicroMsg.BKGLoader.EmojiDownloadTask", "call back is null.");
        break;
        label322:
        if ((bt.isNullOrNil(this.ozP)) || (bt.isNullOrNil(this.ozQ))) {
          break label989;
        }
        localObject1 = this.ozP;
        i = 1;
        break label161;
        ad.d("MicroMsg.BKGLoader.EmojiDownloadTask", "get image data use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        Object localObject4 = ((com.tencent.mm.aw.a.d.b)localObject5).data;
        Object localObject2 = localObject4;
        if (i != 0) {}
        try
        {
          localObject2 = com.tencent.mm.b.a.c(((com.tencent.mm.aw.a.d.b)localObject5).data, Base64.encodeToString(bt.aGd(this.ozQ), 0));
          boolean bool = this.ozU.a((String)localObject1, (byte[])localObject2, com.tencent.mm.plugin.emoji.e.e.p(this.fLP.gaa(), new Object[0]));
          localObject4 = new com.tencent.mm.vfs.e(this.fLP.gaa());
          if ((!bool) || (!((com.tencent.mm.vfs.e)localObject4).exists())) {
            break label865;
          }
          localObject5 = i.aEN(com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject4).mUri));
          localObject1 = this.fLP.JS();
          if (!bt.isNullOrNil(this.ozS)) {
            localObject1 = this.ozS;
          }
          if ((!bt.isNullOrNil((String)localObject5)) && (((String)localObject5).equalsIgnoreCase((String)localObject1)))
          {
            this.fLP.field_size = localObject2.length;
            this.fLP.field_state = EmojiInfo.LCe;
            this.fLP.field_temp = 0;
            this.fLP.field_catalog = EmojiInfo.LBW;
            j = EmojiLogic.aW((byte[])localObject2);
            this.fLP.field_type = j;
            j = k.getEmojiStorageMgr().FyY.eNO();
            if (j < l.abt())
            {
              j = l.abt();
              this.fLP.field_idx = j;
              k.getEmojiStorageMgr().FyY.L(this.fLP);
              localObject1 = new de();
              ((de)localObject1).dfm.md5 = this.ozM;
              ((de)localObject1).dfm.dbV = 0;
              ((de)localObject1).dfm.success = true;
              com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
              if (i == 0) {
                break label753;
              }
              com.tencent.mm.plugin.emoji.c.oF(7L);
              com.tencent.mm.plugin.emoji.c.oF(4L);
              com.tencent.mm.plugin.emoji.c.a(this.ozM, 3, 0, 0, this.oyj, 0, this.oyK);
              com.tencent.mm.emoji.decode.a.aaP().a(this.fLP, true);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int j;
            ad.w("MicroMsg.BKGLoader.EmojiDownloadTask", "encrypt file failed. %s", new Object[] { bt.m(localException) });
            Object localObject3 = localObject4;
            continue;
            j += 1;
            continue;
            label753:
            com.tencent.mm.plugin.emoji.c.oF(2L);
            com.tencent.mm.plugin.emoji.c.oF(4L);
            com.tencent.mm.plugin.emoji.c.a(this.ozM, 2, 0, 0, this.oyj, 1, this.oyK);
          }
          if (((com.tencent.mm.vfs.e)localObject4).exists()) {
            ((com.tencent.mm.vfs.e)localObject4).delete();
          }
          bVB();
          if (i != 0)
          {
            com.tencent.mm.plugin.emoji.c.oF(8L);
            com.tencent.mm.plugin.emoji.c.a(this.ozM, 3, 0, 1, this.oyj, 1, this.oyK);
            continue;
          }
          com.tencent.mm.plugin.emoji.c.oF(5L);
          com.tencent.mm.plugin.emoji.c.a(this.ozM, 2, 0, 1, this.oyj, 1, this.oyK);
        }
        continue;
        label865:
        bVB();
        if (i != 0)
        {
          com.tencent.mm.plugin.emoji.c.oF(8L);
          com.tencent.mm.plugin.emoji.c.a(this.ozM, 3, 0, 1, this.oyj, 1, this.oyK);
        }
        else
        {
          com.tencent.mm.plugin.emoji.c.oF(3L);
          com.tencent.mm.plugin.emoji.c.a(this.ozM, 2, 1, 1, this.oyj, 1, this.oyK);
          continue;
          label929:
          h.vKh.idkeyStat(164L, 10L, 1L, false);
          localObject1 = new LinkedList();
          ((LinkedList)localObject1).add(this.ozM);
          g.afA().gcy.a(new com.tencent.mm.plugin.emoji.f.e((LinkedList)localObject1), 0);
          bVB();
        }
      }
      label989:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.a
 * JD-Core Version:    0.7.0.1
 */