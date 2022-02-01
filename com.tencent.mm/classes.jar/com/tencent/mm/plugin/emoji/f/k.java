package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.g.c;
import com.tencent.mm.plugin.emoji.g.c.a;
import com.tencent.mm.protocal.protobuf.agm;
import com.tencent.mm.protocal.protobuf.bam;
import com.tencent.mm.protocal.protobuf.ban;
import com.tencent.mm.protocal.protobuf.btb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private f gzH;
  private c.a pFX;
  private boolean pFY;
  private ps pFZ;
  public String pFt;
  public final b rr;
  
  public k(String paramString)
  {
    AppMethodBeat.i(108695);
    this.pFt = "";
    this.pFY = false;
    this.pFZ = null;
    b.a locala = new b.a();
    locala.hNM = new bam();
    locala.hNN = new ban();
    locala.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
    locala.funcId = 521;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.pFt = paramString;
    this.pFZ = new ps();
    AppMethodBeat.o(108695);
  }
  
  public k(String paramString, c.a parama)
  {
    AppMethodBeat.i(108696);
    this.pFt = "";
    this.pFY = false;
    this.pFZ = null;
    b.a locala = new b.a();
    locala.hNM = new bam();
    locala.hNN = new ban();
    locala.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
    locala.funcId = 521;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.pFt = paramString;
    this.pFX = parama;
    this.pFY = true;
    this.pFZ = new ps();
    AppMethodBeat.o(108696);
  }
  
  private int chf()
  {
    return ((ban)this.rr.hNL.hNQ).GxE;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(108697);
    ad.d("MicroMsg.emoji.NetSceneGetEmotionDesc", "getEmotionDesc %s ", new Object[] { this.pFt });
    this.gzH = paramf;
    ((bam)this.rr.hNK.hNQ).ProductID = this.pFt;
    if (TextUtils.isEmpty(this.pFt))
    {
      ad.w("MicroMsg.emoji.NetSceneGetEmotionDesc", "get emoji desc faild. product id is null.");
      AppMethodBeat.o(108697);
      return -1;
    }
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(108697);
    return i;
  }
  
  public final int getType()
  {
    return 521;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108698);
    com.tencent.mm.storage.emotion.e locale;
    Object localObject1;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (this.pFY) {
        if ((chf() & 0x1) == 1) {
          c.a(this.pFX);
        }
      }
      for (;;)
      {
        this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(108698);
        return;
        ad.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion is can't download. ignore");
        continue;
        paramArrayOfByte = ((ban)this.rr.hNL.hNQ).nDj;
        locale = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILp;
        localObject1 = this.pFt;
        paramInt1 = ((ban)this.rr.hNL.hNQ).GxC;
        i = chf();
        if (locale.IOg != null) {
          locale.IOg.edit().putLong("274544".concat(String.valueOf(localObject1)), System.currentTimeMillis()).commit();
        }
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0)) {
          break;
        }
        label179:
        if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0)) {
          break label538;
        }
        ad.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, productId: %s ", new Object[] { this.pFt });
        this.pFZ.dEd.dok = this.pFt;
        a.IbL.l(this.pFZ);
      }
      paramq = null;
      if (!(locale.db instanceof h)) {
        break label591;
      }
      paramq = (h)locale.db;
    }
    label538:
    label591:
    for (long l = paramq.xO(Thread.currentThread().getId());; l = -1L)
    {
      locale.db.delete("EmojiInfoDesc", "groupId=?", new String[] { localObject1 });
      d locald = new d();
      locald.field_groupId = ((String)localObject1);
      locald.field_click_flag = paramInt1;
      locald.field_download_flag = i;
      localObject1 = paramArrayOfByte.iterator();
      Object localObject3;
      do
      {
        Object localObject2;
        while (!((Iterator)localObject2).hasNext())
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (agm)((Iterator)localObject1).next();
          locald.field_md5 = ((agm)localObject2).Md5;
          localObject2 = ((agm)localObject2).nDj.iterator();
        }
        localObject3 = (btb)((Iterator)localObject2).next();
        locald.field_desc = ((btb)localObject3).Desc;
        locald.field_lang = ((btb)localObject3).uhu;
        locald.field_md5_lang = (locald.field_md5 + locald.field_lang);
        localObject3 = locald.convertTo();
      } while (locale.db.replace("EmojiInfoDesc", "md5_lang", (ContentValues)localObject3) >= 0L);
      if (paramq == null) {
        break label179;
      }
      paramq.sJ(l);
      break label179;
      locale.db.replace("EmojiInfoDesc", "md5_lang", locald.convertTo());
      if (paramq == null) {
        break label179;
      }
      paramq.sJ(l);
      break label179;
      break;
      ad.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, & errType:%d, errCode:%d, productId: %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.pFt });
      if (!this.pFY) {
        break;
      }
      ad.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion get des failed. ignore");
      break;
    }
  }
  
  public final int securityLimitCount()
  {
    return 50;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.k
 * JD-Core Version:    0.7.0.1
 */