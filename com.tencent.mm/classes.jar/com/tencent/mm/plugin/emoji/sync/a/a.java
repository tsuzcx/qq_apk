package com.tencent.mm.plugin.emoji.sync.a;

import android.util.Base64;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.cv;
import com.tencent.mm.plugin.emoji.c;
import com.tencent.mm.plugin.emoji.e.l;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a
  extends com.tencent.mm.plugin.emoji.sync.d
{
  private EmojiInfo hNs;
  private String iZQ;
  private String iZR;
  private String iZs;
  private com.tencent.mm.plugin.emoji.sync.e jaU;
  private String jaV;
  private String jaW;
  private String jaX;
  private String jaY;
  private String jaZ;
  private String jba;
  private String jbb;
  private com.tencent.mm.plugin.emoji.d.a jbc;
  private com.tencent.mm.as.a.b.a jbd;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    if (bk.bl(paramString1)) {
      y.e("MicroMsg.BKGLoader.EmojiDownloadTask", "[cpan] can not create task md5 is null.");
    }
    this.jaV = paramString1;
    this.jaW = paramString2;
    this.jaX = paramString3;
    this.iZQ = paramString4;
    this.jaY = paramString5;
    this.jaZ = paramString6;
    this.jba = paramString8;
    this.jbb = paramString9;
    this.iZs = paramString7;
    this.iZR = paramString10;
    this.hNs = i.getEmojiStorageMgr().uBb.acC(this.jaV);
    if (this.hNs == null)
    {
      this.hNs = new EmojiInfo();
      this.hNs.field_md5 = this.jaV;
      this.hNs.field_cdnUrl = this.jaW;
      this.hNs.field_thumbUrl = this.jaX;
      this.hNs.field_designerID = this.iZQ;
      this.hNs.field_encrypturl = this.jaY;
      this.hNs.field_aeskey = this.jaZ;
      this.hNs.field_groupId = this.iZs;
    }
    if (!bk.bl(this.jaW))
    {
      this.hNs.field_cdnUrl = this.jaW;
      if (bk.bl(this.jaY)) {
        break label392;
      }
      this.hNs.field_encrypturl = this.jaY;
      this.hNs.field_aeskey = this.jaZ;
    }
    for (;;)
    {
      if (!bk.bl(this.iZQ)) {
        this.hNs.field_designerID = this.iZQ;
      }
      if (!bk.bl(this.iZs)) {
        this.hNs.field_groupId = this.iZs;
      }
      if (!bk.bl(this.jaX)) {
        this.hNs.field_thumbUrl = this.jaX;
      }
      if (!bk.bl(this.iZR)) {
        this.hNs.field_activityid = this.iZR;
      }
      this.hNs.field_externUrl = this.jba;
      this.hNs.field_externMd5 = this.jbb;
      this.hNs.field_attachedText = paramString11;
      this.jbc = new com.tencent.mm.plugin.emoji.d.a();
      this.jbd = new com.tencent.mm.as.a.b.a();
      return;
      this.jaW = this.hNs.field_cdnUrl;
      break;
      label392:
      this.jaY = this.hNs.field_encrypturl;
      this.jaZ = this.hNs.field_aeskey;
    }
  }
  
  private void aIt()
  {
    y.i("MicroMsg.BKGLoader.EmojiDownloadTask", "disable to download emoji when cdn download failed.");
    cv localcv = new cv();
    localcv.bIV.bIW = this.jaV;
    localcv.bIV.bHz = 0;
    localcv.bIV.success = false;
    com.tencent.mm.sdk.b.a.udP.m(localcv);
    if (this.hNs != null)
    {
      y.i("MicroMsg.BKGLoader.EmojiDownloadTask", "[cpan] this emoji is broken. md5 is:%s", new Object[] { this.hNs.Wv() });
      this.hNs.field_state = EmojiInfo.uDi;
      this.hNs.field_catalog = EmojiInfo.uCT;
      i.getEmojiStorageMgr().uBb.q(this.hNs);
    }
  }
  
  public final void a(com.tencent.mm.plugin.emoji.sync.e parame)
  {
    this.jaU = parame;
  }
  
  public final void cancel() {}
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof a)))
    {
      paramObject = (a)paramObject;
      if ((!bk.bl(this.jaV)) && (!bk.bl(paramObject.jaV)) && (this.jaV.equals(paramObject.jaV))) {
        return true;
      }
    }
    return false;
  }
  
  public final String getKey()
  {
    return this.jaV;
  }
  
  public final void run()
  {
    Object localObject2;
    int j;
    Object localObject1;
    int i;
    label158:
    long l;
    Object localObject5;
    if (this.jaU != null)
    {
      this.jaU.AV(this.jaV);
      y.i("MicroMsg.BKGLoader.EmojiDownloadTask", "emoji md5:%s cndUrl:%s thumbUrl:%s field_designerID:%s field_encrypturl:%s field_groupId:%s", new Object[] { this.hNs.Wv(), this.hNs.field_cdnUrl, this.hNs.field_thumbUrl, this.hNs.field_designerID, this.hNs.field_encrypturl, this.hNs.field_groupId });
      if ((bk.bl(this.jaW)) && (bk.bl(this.jaY)) && (bk.bl(this.jba))) {
        break label1031;
      }
      localObject2 = this.jaW;
      j = 0;
      if ((bk.bl(this.jba)) || (bk.bl(this.jbb))) {
        break label335;
      }
      localObject1 = this.jba;
      i = 1;
      l = System.currentTimeMillis();
      localObject5 = this.jbc.ms((String)localObject1);
      if ((localObject5 != null) && (!bk.bE(((com.tencent.mm.as.a.d.b)localObject5).data))) {
        break label378;
      }
      y.d("MicroMsg.BKGLoader.EmojiDownloadTask", "get image data suuse time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      aIt();
    }
    for (;;)
    {
      if (!bk.bl(this.hNs.field_thumbUrl))
      {
        localObject4 = this.jbc.ms(this.hNs.field_thumbUrl);
        if (localObject4 != null)
        {
          localObject1 = this.jbd;
          localObject2 = this.hNs.field_thumbUrl;
          localObject4 = ((com.tencent.mm.as.a.d.b)localObject4).data;
          localObject5 = this.hNs.field_thumbUrl;
          ((com.tencent.mm.as.a.b.a)localObject1).a((String)localObject2, (byte[])localObject4, com.tencent.mm.plugin.emoji.e.e.o(this.hNs.cwL() + "_cover", new Object[0]));
        }
      }
      return;
      y.w("MicroMsg.BKGLoader.EmojiDownloadTask", "call back is null.");
      break;
      label335:
      i = j;
      localObject1 = localObject2;
      if (bk.bl(this.jaY)) {
        break label158;
      }
      i = j;
      localObject1 = localObject2;
      if (bk.bl(this.jaZ)) {
        break label158;
      }
      localObject1 = this.jaY;
      i = 1;
      break label158;
      label378:
      y.d("MicroMsg.BKGLoader.EmojiDownloadTask", "get image data use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      Object localObject4 = ((com.tencent.mm.as.a.d.b)localObject5).data;
      localObject2 = localObject4;
      if (i != 0) {}
      try
      {
        localObject2 = ((com.tencent.mm.as.a.d.b)localObject5).data;
        localObject5 = Base64.decode(Base64.encodeToString(bk.ZM(this.jaZ), 0).getBytes(), 0);
        SecretKeySpec localSecretKeySpec = new SecretKeySpec((byte[])localObject5, "AES");
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        localCipher.init(2, localSecretKeySpec, new IvParameterSpec(Arrays.copyOf((byte[])localObject5, localObject5.length)));
        localObject2 = localCipher.doFinal((byte[])localObject2);
        boolean bool = this.jbd.a((String)localObject1, (byte[])localObject2, com.tencent.mm.plugin.emoji.e.e.o(this.hNs.cwL(), new Object[0]));
        localObject4 = new File(this.hNs.cwL());
        if ((!bool) || (!((File)localObject4).exists())) {
          break label967;
        }
        localObject5 = com.tencent.mm.a.g.m((File)localObject4);
        localObject1 = this.hNs.Wv();
        if (!bk.bl(this.jbb)) {
          localObject1 = this.jbb;
        }
        if ((!bk.bl((String)localObject5)) && (((String)localObject5).equalsIgnoreCase((String)localObject1)))
        {
          this.hNs.field_size = localObject2.length;
          this.hNs.field_state = EmojiInfo.uDh;
          this.hNs.field_temp = 0;
          this.hNs.field_catalog = EmojiInfo.uCZ;
          j = EmojiLogic.aj((byte[])localObject2);
          this.hNs.field_type = j;
          j = i.getEmojiStorageMgr().uBb.cwS();
          if (j < l.aHC())
          {
            j = l.aHC();
            this.hNs.field_idx = j;
            i.getEmojiStorageMgr().uBb.q(this.hNs);
            localObject1 = i.getEmojiStorageMgr().uBc;
            if (!com.tencent.mm.storage.emotion.a.cwo()) {
              i.getEmojiStorageMgr().uBc.cwp();
            }
            localObject1 = new cv();
            ((cv)localObject1).bIV.bIW = this.jaV;
            ((cv)localObject1).bIV.bHz = 0;
            ((cv)localObject1).bIV.success = true;
            com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
            if (i == 0) {
              break label855;
            }
            c.dt(7L);
            c.dt(4L);
            c.a(this.jaV, 3, 0, 0, this.iZs, 0, this.iZQ);
            com.tencent.mm.plugin.emoji.e.d.aHc().c(this.hNs, true);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.w("MicroMsg.BKGLoader.EmojiDownloadTask", "encrypt file failed. %s", new Object[] { bk.j(localException) });
          Object localObject3 = localObject4;
          continue;
          j += 1;
          continue;
          label855:
          c.dt(2L);
          c.dt(4L);
          c.a(this.jaV, 2, 0, 0, this.iZs, 1, this.iZQ);
        }
        if (((File)localObject4).exists()) {
          ((File)localObject4).delete();
        }
        aIt();
        if (i != 0)
        {
          c.dt(8L);
          c.a(this.jaV, 3, 0, 1, this.iZs, 1, this.iZQ);
          continue;
        }
        c.dt(5L);
        c.a(this.jaV, 2, 0, 1, this.iZs, 1, this.iZQ);
      }
      continue;
      label967:
      aIt();
      if (i != 0)
      {
        c.dt(8L);
        c.a(this.jaV, 3, 0, 1, this.iZs, 1, this.iZQ);
      }
      else
      {
        c.dt(3L);
        c.a(this.jaV, 2, 1, 1, this.iZs, 1, this.iZQ);
        continue;
        label1031:
        h.nFQ.a(164L, 10L, 1L, false);
        localObject1 = new LinkedList();
        ((LinkedList)localObject1).add(this.jaV);
        com.tencent.mm.kernel.g.DO().dJT.a(new f((LinkedList)localObject1), 0);
        aIt();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.a
 * JD-Core Version:    0.7.0.1
 */