package com.tencent.mm.plugin.emoji.sync.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.m;
import com.tencent.mm.g.a.df;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.plugin.emoji.sync.c
{
  private EmojiInfo fPB;
  private String pbJ;
  private String pck;
  private String pcl;
  private d pdl;
  private String pdm;
  private String pdn;
  private String pdo;
  private String pdp;
  private String pdq;
  private String pdr;
  private String pds;
  private com.tencent.mm.plugin.emoji.d.a pdt;
  private com.tencent.mm.av.a.b.a pdu;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    AppMethodBeat.i(108769);
    if (bs.isNullOrNil(paramString1)) {
      ac.e("MicroMsg.BKGLoader.EmojiDownloadTask", "[cpan] can not create task md5 is null.");
    }
    this.pdm = paramString1;
    this.pdn = paramString2;
    this.pdo = paramString3;
    this.pck = paramString4;
    this.pdp = paramString5;
    this.pdq = paramString6;
    this.pdr = paramString8;
    this.pds = paramString9;
    this.pbJ = paramString7;
    this.pcl = paramString10;
    this.fPB = k.getEmojiStorageMgr().GXZ.aOT(this.pdm);
    if (this.fPB == null)
    {
      this.fPB = new EmojiInfo();
      this.fPB.field_md5 = this.pdm;
      this.fPB.field_cdnUrl = this.pdn;
      this.fPB.field_thumbUrl = this.pdo;
      this.fPB.field_designerID = this.pck;
      this.fPB.field_encrypturl = this.pdp;
      this.fPB.field_aeskey = this.pdq;
      this.fPB.field_groupId = this.pbJ;
    }
    if (!bs.isNullOrNil(this.pdn))
    {
      this.fPB.field_cdnUrl = this.pdn;
      if (bs.isNullOrNil(this.pdp)) {
        break label401;
      }
      this.fPB.field_encrypturl = this.pdp;
      this.fPB.field_aeskey = this.pdq;
    }
    for (;;)
    {
      if (!bs.isNullOrNil(this.pck)) {
        this.fPB.field_designerID = this.pck;
      }
      if (!bs.isNullOrNil(this.pbJ)) {
        this.fPB.field_groupId = this.pbJ;
      }
      if (!bs.isNullOrNil(this.pdo)) {
        this.fPB.field_thumbUrl = this.pdo;
      }
      if (!bs.isNullOrNil(this.pcl)) {
        this.fPB.field_activityid = this.pcl;
      }
      this.fPB.field_externUrl = this.pdr;
      this.fPB.field_externMd5 = this.pds;
      this.fPB.field_attachedText = null;
      this.pdt = new com.tencent.mm.plugin.emoji.d.a();
      this.pdu = new com.tencent.mm.av.a.b.a();
      AppMethodBeat.o(108769);
      return;
      this.pdn = this.fPB.field_cdnUrl;
      break;
      label401:
      this.pdp = this.fPB.field_encrypturl;
      this.pdq = this.fPB.field_aeskey;
    }
  }
  
  private void ccO()
  {
    AppMethodBeat.i(108771);
    ac.i("MicroMsg.BKGLoader.EmojiDownloadTask", "disable to download emoji when cdn download failed.");
    df localdf = new df();
    localdf.dcH.md5 = this.pdm;
    localdf.dcH.cZu = 0;
    localdf.dcH.success = false;
    com.tencent.mm.sdk.b.a.GpY.l(localdf);
    if (this.fPB != null)
    {
      ac.i("MicroMsg.BKGLoader.EmojiDownloadTask", "[cpan] this emoji is broken. md5 is:%s", new Object[] { this.fPB.JC() });
      this.fPB.field_state = EmojiInfo.Kgg;
      this.fPB.field_catalog = EmojiInfo.Jss;
      k.getEmojiStorageMgr().GXZ.L(this.fPB);
    }
    AppMethodBeat.o(108771);
  }
  
  public final void a(d paramd)
  {
    this.pdl = paramd;
  }
  
  public final void cancel() {}
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108772);
    if ((paramObject != null) && ((paramObject instanceof a)))
    {
      paramObject = (a)paramObject;
      if ((!bs.isNullOrNil(this.pdm)) && (!bs.isNullOrNil(paramObject.pdm)) && (this.pdm.equals(paramObject.pdm)))
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
    return this.pdm;
  }
  
  public final void run()
  {
    AppMethodBeat.i(108770);
    Object localObject1;
    int i;
    if (this.pdl != null)
    {
      this.pdl.Yq(this.pdm);
      ac.i("MicroMsg.BKGLoader.EmojiDownloadTask", "emoji md5:%s cndUrl:%s thumbUrl:%s field_designerID:%s field_encrypturl:%s field_groupId:%s", new Object[] { this.fPB.JC(), this.fPB.field_cdnUrl, this.fPB.field_thumbUrl, this.fPB.field_designerID, this.fPB.field_encrypturl, this.fPB.field_groupId });
      if ((bs.isNullOrNil(this.pdn)) && (bs.isNullOrNil(this.pdp)) && (bs.isNullOrNil(this.pdr))) {
        break label929;
      }
      localObject1 = this.pdn;
      if ((bs.isNullOrNil(this.pdr)) || (bs.isNullOrNil(this.pds))) {
        break label322;
      }
      localObject1 = this.pdr;
      i = 1;
    }
    for (;;)
    {
      label161:
      long l = System.currentTimeMillis();
      Object localObject5 = this.pdt.CD((String)localObject1);
      if ((localObject5 == null) || (bs.cv(((com.tencent.mm.av.a.d.b)localObject5).data)))
      {
        ac.d("MicroMsg.BKGLoader.EmojiDownloadTask", "get image data suuse time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        ccO();
      }
      for (;;)
      {
        if (!bs.isNullOrNil(this.fPB.field_thumbUrl))
        {
          localObject1 = this.pdt.CD(this.fPB.field_thumbUrl);
          if (localObject1 != null) {
            this.pdu.a(this.fPB.field_thumbUrl, ((com.tencent.mm.av.a.d.b)localObject1).data, com.tencent.mm.plugin.emoji.e.e.p(this.fPB.ghd() + "_cover", new Object[0]));
          }
        }
        AppMethodBeat.o(108770);
        return;
        ac.w("MicroMsg.BKGLoader.EmojiDownloadTask", "call back is null.");
        break;
        label322:
        if ((bs.isNullOrNil(this.pdp)) || (bs.isNullOrNil(this.pdq))) {
          break label989;
        }
        localObject1 = this.pdp;
        i = 1;
        break label161;
        ac.d("MicroMsg.BKGLoader.EmojiDownloadTask", "get image data use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        Object localObject4 = ((com.tencent.mm.av.a.d.b)localObject5).data;
        Object localObject2 = localObject4;
        if (i != 0) {}
        try
        {
          localObject2 = com.tencent.mm.b.a.c(((com.tencent.mm.av.a.d.b)localObject5).data, Base64.encodeToString(bs.aLu(this.pdq), 0));
          boolean bool = this.pdu.a((String)localObject1, (byte[])localObject2, com.tencent.mm.plugin.emoji.e.e.p(this.fPB.ghd(), new Object[0]));
          localObject4 = new com.tencent.mm.vfs.e(this.fPB.ghd());
          if ((!bool) || (!((com.tencent.mm.vfs.e)localObject4).exists())) {
            break label865;
          }
          localObject5 = i.aKe(com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject4).mUri));
          localObject1 = this.fPB.JC();
          if (!bs.isNullOrNil(this.pds)) {
            localObject1 = this.pds;
          }
          if ((!bs.isNullOrNil((String)localObject5)) && (((String)localObject5).equalsIgnoreCase((String)localObject1)))
          {
            this.fPB.field_size = localObject2.length;
            this.fPB.field_state = EmojiInfo.Kgf;
            this.fPB.field_temp = 0;
            this.fPB.field_catalog = EmojiInfo.Jsy;
            j = EmojiLogic.aV((byte[])localObject2);
            this.fPB.field_type = j;
            j = k.getEmojiStorageMgr().GXZ.fds();
            if (j < m.acs())
            {
              j = m.acs();
              this.fPB.field_idx = j;
              k.getEmojiStorageMgr().GXZ.L(this.fPB);
              localObject1 = new df();
              ((df)localObject1).dcH.md5 = this.pdm;
              ((df)localObject1).dcH.cZu = 0;
              ((df)localObject1).dcH.success = true;
              com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
              if (i == 0) {
                break label753;
              }
              com.tencent.mm.plugin.emoji.c.sr(7L);
              com.tencent.mm.plugin.emoji.c.sr(4L);
              com.tencent.mm.plugin.emoji.c.a(this.pdm, 3, 0, 0, this.pbJ, 0, this.pck);
              com.tencent.mm.emoji.decode.a.abO().a(this.fPB, true);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int j;
            ac.w("MicroMsg.BKGLoader.EmojiDownloadTask", "encrypt file failed. %s", new Object[] { bs.m(localException) });
            Object localObject3 = localObject4;
            continue;
            j += 1;
            continue;
            label753:
            com.tencent.mm.plugin.emoji.c.sr(2L);
            com.tencent.mm.plugin.emoji.c.sr(4L);
            com.tencent.mm.plugin.emoji.c.a(this.pdm, 2, 0, 0, this.pbJ, 1, this.pck);
          }
          if (((com.tencent.mm.vfs.e)localObject4).exists()) {
            ((com.tencent.mm.vfs.e)localObject4).delete();
          }
          ccO();
          if (i != 0)
          {
            com.tencent.mm.plugin.emoji.c.sr(8L);
            com.tencent.mm.plugin.emoji.c.a(this.pdm, 3, 0, 1, this.pbJ, 1, this.pck);
            continue;
          }
          com.tencent.mm.plugin.emoji.c.sr(5L);
          com.tencent.mm.plugin.emoji.c.a(this.pdm, 2, 0, 1, this.pbJ, 1, this.pck);
        }
        continue;
        label865:
        ccO();
        if (i != 0)
        {
          com.tencent.mm.plugin.emoji.c.sr(8L);
          com.tencent.mm.plugin.emoji.c.a(this.pdm, 3, 0, 1, this.pbJ, 1, this.pck);
        }
        else
        {
          com.tencent.mm.plugin.emoji.c.sr(3L);
          com.tencent.mm.plugin.emoji.c.a(this.pdm, 2, 1, 1, this.pbJ, 1, this.pck);
          continue;
          label929:
          h.wUl.idkeyStat(164L, 10L, 1L, false);
          localObject1 = new LinkedList();
          ((LinkedList)localObject1).add(this.pdm);
          g.agQ().ghe.a(new com.tencent.mm.plugin.emoji.f.e((LinkedList)localObject1), 0);
          ccO();
        }
      }
      label989:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.a
 * JD-Core Version:    0.7.0.1
 */