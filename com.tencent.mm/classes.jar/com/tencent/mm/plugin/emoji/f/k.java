package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.a.pi;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.g.c;
import com.tencent.mm.plugin.emoji.g.c.a;
import com.tencent.mm.protocal.protobuf.aed;
import com.tencent.mm.protocal.protobuf.awo;
import com.tencent.mm.protocal.protobuf.awp;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private g gfX;
  public String pbJ;
  private c.a pcn;
  private boolean pco;
  private pi pcp;
  public final b rr;
  
  public k(String paramString)
  {
    AppMethodBeat.i(108695);
    this.pbJ = "";
    this.pco = false;
    this.pcp = null;
    b.a locala = new b.a();
    locala.hvt = new awo();
    locala.hvu = new awp();
    locala.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
    locala.funcId = 521;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.pbJ = paramString;
    this.pcp = new pi();
    AppMethodBeat.o(108695);
  }
  
  public k(String paramString, c.a parama)
  {
    AppMethodBeat.i(108696);
    this.pbJ = "";
    this.pco = false;
    this.pcp = null;
    b.a locala = new b.a();
    locala.hvt = new awo();
    locala.hvu = new awp();
    locala.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
    locala.funcId = 521;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.pbJ = paramString;
    this.pcn = parama;
    this.pco = true;
    this.pcp = new pi();
    AppMethodBeat.o(108696);
  }
  
  private int ccB()
  {
    return ((awp)this.rr.hvs.hvw).EOA;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(108697);
    ac.d("MicroMsg.emoji.NetSceneGetEmotionDesc", "getEmotionDesc %s ", new Object[] { this.pbJ });
    this.gfX = paramg;
    ((awo)this.rr.hvr.hvw).ProductID = this.pbJ;
    if (TextUtils.isEmpty(this.pbJ))
    {
      ac.w("MicroMsg.emoji.NetSceneGetEmotionDesc", "get emoji desc faild. product id is null.");
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
      if (this.pco) {
        if ((ccB() & 0x1) == 1) {
          c.a(this.pcn);
        }
      }
      for (;;)
      {
        this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(108698);
        return;
        ac.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion is can't download. ignore");
        continue;
        paramArrayOfByte = ((awp)this.rr.hvs.hvw).ncM;
        locale = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GYb;
        localObject1 = this.pbJ;
        paramInt1 = ((awp)this.rr.hvs.hvw).EOy;
        i = ccB();
        if (locale.HaQ != null) {
          locale.HaQ.edit().putLong("274544".concat(String.valueOf(localObject1)), System.currentTimeMillis()).commit();
        }
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0)) {
          break;
        }
        label179:
        if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0)) {
          break label538;
        }
        ac.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, productId: %s ", new Object[] { this.pbJ });
        this.pcp.dsj.dcO = this.pbJ;
        a.GpY.l(this.pcp);
      }
      paramq = null;
      if (!(locale.db instanceof h)) {
        break label591;
      }
      paramq = (h)locale.db;
    }
    label538:
    label591:
    for (long l = paramq.vE(Thread.currentThread().getId());; l = -1L)
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
          localObject2 = (aed)((Iterator)localObject1).next();
          locald.field_md5 = ((aed)localObject2).Md5;
          localObject2 = ((aed)localObject2).ncM.iterator();
        }
        localObject3 = (boo)((Iterator)localObject2).next();
        locald.field_desc = ((boo)localObject3).Desc;
        locald.field_lang = ((boo)localObject3).tju;
        locald.field_md5_lang = (locald.field_md5 + locald.field_lang);
        localObject3 = locald.convertTo();
      } while (locale.db.replace("EmojiInfoDesc", "md5_lang", (ContentValues)localObject3) >= 0L);
      if (paramq == null) {
        break label179;
      }
      paramq.qL(l);
      break label179;
      locale.db.replace("EmojiInfoDesc", "md5_lang", locald.convertTo());
      if (paramq == null) {
        break label179;
      }
      paramq.qL(l);
      break label179;
      break;
      ac.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, & errType:%d, errCode:%d, productId: %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.pbJ });
      if (!this.pco) {
        break;
      }
      ac.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion get des failed. ignore");
      break;
    }
  }
  
  public final int securityLimitCount()
  {
    return 50;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.k
 * JD-Core Version:    0.7.0.1
 */