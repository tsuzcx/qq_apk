package com.tencent.mm.plugin.emoji.sync.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.cy;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a
  extends com.tencent.mm.plugin.emoji.sync.c
{
  private EmojiInfo evH;
  private String liH;
  private String liI;
  private String lig;
  private com.tencent.mm.plugin.emoji.sync.d ljD;
  private String ljE;
  private String ljF;
  private String ljG;
  private String ljH;
  private String ljI;
  private String ljJ;
  private String ljK;
  private com.tencent.mm.plugin.emoji.d.a ljL;
  private com.tencent.mm.at.a.b.a ljM;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    AppMethodBeat.i(53198);
    if (bo.isNullOrNil(paramString1)) {
      ab.e("MicroMsg.BKGLoader.EmojiDownloadTask", "[cpan] can not create task md5 is null.");
    }
    this.ljE = paramString1;
    this.ljF = paramString2;
    this.ljG = paramString3;
    this.liH = paramString4;
    this.ljH = paramString5;
    this.ljI = paramString6;
    this.ljJ = paramString8;
    this.ljK = paramString9;
    this.lig = paramString7;
    this.liI = paramString10;
    this.evH = i.getEmojiStorageMgr().yNn.asP(this.ljE);
    if (this.evH == null)
    {
      this.evH = new EmojiInfo();
      this.evH.field_md5 = this.ljE;
      this.evH.field_cdnUrl = this.ljF;
      this.evH.field_thumbUrl = this.ljG;
      this.evH.field_designerID = this.liH;
      this.evH.field_encrypturl = this.ljH;
      this.evH.field_aeskey = this.ljI;
      this.evH.field_groupId = this.lig;
    }
    if (!bo.isNullOrNil(this.ljF))
    {
      this.evH.field_cdnUrl = this.ljF;
      if (bo.isNullOrNil(this.ljH)) {
        break label401;
      }
      this.evH.field_encrypturl = this.ljH;
      this.evH.field_aeskey = this.ljI;
    }
    for (;;)
    {
      if (!bo.isNullOrNil(this.liH)) {
        this.evH.field_designerID = this.liH;
      }
      if (!bo.isNullOrNil(this.lig)) {
        this.evH.field_groupId = this.lig;
      }
      if (!bo.isNullOrNil(this.ljG)) {
        this.evH.field_thumbUrl = this.ljG;
      }
      if (!bo.isNullOrNil(this.liI)) {
        this.evH.field_activityid = this.liI;
      }
      this.evH.field_externUrl = this.ljJ;
      this.evH.field_externMd5 = this.ljK;
      this.evH.field_attachedText = null;
      this.ljL = new com.tencent.mm.plugin.emoji.d.a();
      this.ljM = new com.tencent.mm.at.a.b.a();
      AppMethodBeat.o(53198);
      return;
      this.ljF = this.evH.field_cdnUrl;
      break;
      label401:
      this.ljH = this.evH.field_encrypturl;
      this.ljI = this.evH.field_aeskey;
    }
  }
  
  private void blQ()
  {
    AppMethodBeat.i(53200);
    ab.i("MicroMsg.BKGLoader.EmojiDownloadTask", "disable to download emoji when cdn download failed.");
    cy localcy = new cy();
    localcy.cqp.cqq = this.ljE;
    localcy.cqp.coO = 0;
    localcy.cqp.success = false;
    com.tencent.mm.sdk.b.a.ymk.l(localcy);
    if (this.evH != null)
    {
      ab.i("MicroMsg.BKGLoader.EmojiDownloadTask", "[cpan] this emoji is broken. md5 is:%s", new Object[] { this.evH.Al() });
      this.evH.field_state = EmojiInfo.yPv;
      this.evH.field_catalog = EmojiInfo.yPg;
      i.getEmojiStorageMgr().yNn.J(this.evH);
    }
    AppMethodBeat.o(53200);
  }
  
  public final void a(com.tencent.mm.plugin.emoji.sync.d paramd)
  {
    this.ljD = paramd;
  }
  
  public final void cancel() {}
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(53201);
    if ((paramObject != null) && ((paramObject instanceof a)))
    {
      paramObject = (a)paramObject;
      if ((!bo.isNullOrNil(this.ljE)) && (!bo.isNullOrNil(paramObject.ljE)) && (this.ljE.equals(paramObject.ljE)))
      {
        AppMethodBeat.o(53201);
        return true;
      }
    }
    AppMethodBeat.o(53201);
    return false;
  }
  
  public final String getKey()
  {
    return this.ljE;
  }
  
  public final void run()
  {
    AppMethodBeat.i(53199);
    Object localObject1;
    int i;
    if (this.ljD != null)
    {
      this.ljD.KX(this.ljE);
      ab.i("MicroMsg.BKGLoader.EmojiDownloadTask", "emoji md5:%s cndUrl:%s thumbUrl:%s field_designerID:%s field_encrypturl:%s field_groupId:%s", new Object[] { this.evH.Al(), this.evH.field_cdnUrl, this.evH.field_thumbUrl, this.evH.field_designerID, this.evH.field_encrypturl, this.evH.field_groupId });
      if ((bo.isNullOrNil(this.ljF)) && (bo.isNullOrNil(this.ljH)) && (bo.isNullOrNil(this.ljJ))) {
        break label983;
      }
      localObject1 = this.ljF;
      if ((bo.isNullOrNil(this.ljJ)) || (bo.isNullOrNil(this.ljK))) {
        break label322;
      }
      localObject1 = this.ljJ;
      i = 1;
    }
    for (;;)
    {
      label161:
      long l = System.currentTimeMillis();
      Object localObject5 = this.ljL.tB((String)localObject1);
      if ((localObject5 == null) || (bo.ce(((com.tencent.mm.at.a.d.b)localObject5).data)))
      {
        ab.d("MicroMsg.BKGLoader.EmojiDownloadTask", "get image data suuse time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        blQ();
      }
      for (;;)
      {
        if (!bo.isNullOrNil(this.evH.field_thumbUrl))
        {
          localObject1 = this.ljL.tB(this.evH.field_thumbUrl);
          if (localObject1 != null) {
            this.ljM.a(this.evH.field_thumbUrl, ((com.tencent.mm.at.a.d.b)localObject1).data, com.tencent.mm.plugin.emoji.e.g.n(this.evH.dQB() + "_cover", new Object[0]));
          }
        }
        AppMethodBeat.o(53199);
        return;
        ab.w("MicroMsg.BKGLoader.EmojiDownloadTask", "call back is null.");
        break;
        label322:
        if ((bo.isNullOrNil(this.ljH)) || (bo.isNullOrNil(this.ljI))) {
          break label1043;
        }
        localObject1 = this.ljH;
        i = 1;
        break label161;
        ab.d("MicroMsg.BKGLoader.EmojiDownloadTask", "get image data use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        Object localObject4 = ((com.tencent.mm.at.a.d.b)localObject5).data;
        Object localObject2 = localObject4;
        if (i != 0) {}
        try
        {
          localObject2 = ((com.tencent.mm.at.a.d.b)localObject5).data;
          localObject5 = Base64.decode(Base64.encodeToString(bo.apQ(this.ljI), 0).getBytes(), 0);
          SecretKeySpec localSecretKeySpec = new SecretKeySpec((byte[])localObject5, "AES");
          Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
          localCipher.init(2, localSecretKeySpec, new IvParameterSpec(Arrays.copyOf((byte[])localObject5, localObject5.length)));
          localObject2 = localCipher.doFinal((byte[])localObject2);
          boolean bool = this.ljM.a((String)localObject1, (byte[])localObject2, com.tencent.mm.plugin.emoji.e.g.n(this.evH.dQB(), new Object[0]));
          localObject4 = new File(this.evH.dQB());
          if ((!bool) || (!((File)localObject4).exists())) {
            break label919;
          }
          localObject5 = com.tencent.mm.a.g.r((File)localObject4);
          localObject1 = this.evH.Al();
          if (!bo.isNullOrNil(this.ljK)) {
            localObject1 = this.ljK;
          }
          if ((!bo.isNullOrNil((String)localObject5)) && (((String)localObject5).equalsIgnoreCase((String)localObject1)))
          {
            this.evH.field_size = localObject2.length;
            this.evH.field_state = EmojiInfo.yPu;
            this.evH.field_temp = 0;
            this.evH.field_catalog = EmojiInfo.yPm;
            j = EmojiLogic.aG((byte[])localObject2);
            this.evH.field_type = j;
            j = i.getEmojiStorageMgr().yNn.dzD();
            if (j < com.tencent.mm.emoji.a.h.OK())
            {
              j = com.tencent.mm.emoji.a.h.OK();
              this.evH.field_idx = j;
              i.getEmojiStorageMgr().yNn.J(this.evH);
              localObject1 = new cy();
              ((cy)localObject1).cqp.cqq = this.ljE;
              ((cy)localObject1).cqp.coO = 0;
              ((cy)localObject1).cqp.success = true;
              com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
              if (i == 0) {
                break label807;
              }
              com.tencent.mm.plugin.emoji.c.iX(7L);
              com.tencent.mm.plugin.emoji.c.iX(4L);
              com.tencent.mm.plugin.emoji.c.a(this.ljE, 3, 0, 0, this.lig, 0, this.liH);
              f.bkQ().c(this.evH, true);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int j;
            ab.w("MicroMsg.BKGLoader.EmojiDownloadTask", "encrypt file failed. %s", new Object[] { bo.l(localException) });
            Object localObject3 = localObject4;
            continue;
            j += 1;
            continue;
            label807:
            com.tencent.mm.plugin.emoji.c.iX(2L);
            com.tencent.mm.plugin.emoji.c.iX(4L);
            com.tencent.mm.plugin.emoji.c.a(this.ljE, 2, 0, 0, this.lig, 1, this.liH);
          }
          if (((File)localObject4).exists()) {
            ((File)localObject4).delete();
          }
          blQ();
          if (i != 0)
          {
            com.tencent.mm.plugin.emoji.c.iX(8L);
            com.tencent.mm.plugin.emoji.c.a(this.ljE, 3, 0, 1, this.lig, 1, this.liH);
            continue;
          }
          com.tencent.mm.plugin.emoji.c.iX(5L);
          com.tencent.mm.plugin.emoji.c.a(this.ljE, 2, 0, 1, this.lig, 1, this.liH);
        }
        continue;
        label919:
        blQ();
        if (i != 0)
        {
          com.tencent.mm.plugin.emoji.c.iX(8L);
          com.tencent.mm.plugin.emoji.c.a(this.ljE, 3, 0, 1, this.lig, 1, this.liH);
        }
        else
        {
          com.tencent.mm.plugin.emoji.c.iX(3L);
          com.tencent.mm.plugin.emoji.c.a(this.ljE, 2, 1, 1, this.lig, 1, this.liH);
          continue;
          label983:
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(164L, 10L, 1L, false);
          localObject1 = new LinkedList();
          ((LinkedList)localObject1).add(this.ljE);
          com.tencent.mm.kernel.g.RK().eHt.a(new e((LinkedList)localObject1), 0);
          blQ();
        }
      }
      label1043:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.a
 * JD-Core Version:    0.7.0.1
 */