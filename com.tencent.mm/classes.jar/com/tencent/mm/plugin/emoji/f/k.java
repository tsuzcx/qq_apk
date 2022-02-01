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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.a.pt;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.g.c;
import com.tencent.mm.plugin.emoji.g.c.a;
import com.tencent.mm.protocal.protobuf.agw;
import com.tencent.mm.protocal.protobuf.bbc;
import com.tencent.mm.protocal.protobuf.bbd;
import com.tencent.mm.protocal.protobuf.btv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private f gCo;
  public String pLX;
  private c.a pMB;
  private boolean pMC;
  private pt pMD;
  public final b rr;
  
  public k(String paramString)
  {
    AppMethodBeat.i(108695);
    this.pLX = "";
    this.pMC = false;
    this.pMD = null;
    b.a locala = new b.a();
    locala.hQF = new bbc();
    locala.hQG = new bbd();
    locala.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
    locala.funcId = 521;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.pLX = paramString;
    this.pMD = new pt();
    AppMethodBeat.o(108695);
  }
  
  public k(String paramString, c.a parama)
  {
    AppMethodBeat.i(108696);
    this.pLX = "";
    this.pMC = false;
    this.pMD = null;
    b.a locala = new b.a();
    locala.hQF = new bbc();
    locala.hQG = new bbd();
    locala.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
    locala.funcId = 521;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.pLX = paramString;
    this.pMB = parama;
    this.pMC = true;
    this.pMD = new pt();
    AppMethodBeat.o(108696);
  }
  
  private int civ()
  {
    return ((bbd)this.rr.hQE.hQJ).GRe;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(108697);
    ae.d("MicroMsg.emoji.NetSceneGetEmotionDesc", "getEmotionDesc %s ", new Object[] { this.pLX });
    this.gCo = paramf;
    ((bbc)this.rr.hQD.hQJ).ProductID = this.pLX;
    if (TextUtils.isEmpty(this.pLX))
    {
      ae.w("MicroMsg.emoji.NetSceneGetEmotionDesc", "get emoji desc faild. product id is null.");
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
      if (this.pMC) {
        if ((civ() & 0x1) == 1) {
          c.a(this.pMB);
        }
      }
      for (;;)
      {
        this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(108698);
        return;
        ae.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion is can't download. ignore");
        continue;
        paramArrayOfByte = ((bbd)this.rr.hQE.hQJ).nIE;
        locale = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfW;
        localObject1 = this.pLX;
        paramInt1 = ((bbd)this.rr.hQE.hQJ).GRc;
        i = civ();
        if (locale.JiM != null) {
          locale.JiM.edit().putLong("274544".concat(String.valueOf(localObject1)), System.currentTimeMillis()).commit();
        }
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0)) {
          break;
        }
        label179:
        if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0)) {
          break label538;
        }
        ae.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, productId: %s ", new Object[] { this.pLX });
        this.pMD.dFi.dpp = this.pLX;
        a.IvT.l(this.pMD);
      }
      paramq = null;
      if (!(locale.db instanceof h)) {
        break label591;
      }
      paramq = (h)locale.db;
    }
    label538:
    label591:
    for (long l = paramq.yi(Thread.currentThread().getId());; l = -1L)
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
          localObject2 = (agw)((Iterator)localObject1).next();
          locald.field_md5 = ((agw)localObject2).Md5;
          localObject2 = ((agw)localObject2).nIE.iterator();
        }
        localObject3 = (btv)((Iterator)localObject2).next();
        locald.field_desc = ((btv)localObject3).Desc;
        locald.field_lang = ((btv)localObject3).usS;
        locald.field_md5_lang = (locald.field_md5 + locald.field_lang);
        localObject3 = locald.convertTo();
      } while (locale.db.replace("EmojiInfoDesc", "md5_lang", (ContentValues)localObject3) >= 0L);
      if (paramq == null) {
        break label179;
      }
      paramq.sW(l);
      break label179;
      locale.db.replace("EmojiInfoDesc", "md5_lang", locald.convertTo());
      if (paramq == null) {
        break label179;
      }
      paramq.sW(l);
      break label179;
      break;
      ae.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, & errType:%d, errCode:%d, productId: %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.pLX });
      if (!this.pMC) {
        break;
      }
      ae.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion get des failed. ignore");
      break;
    }
  }
  
  public final int securityLimitCount()
  {
    return 50;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.k
 * JD-Core Version:    0.7.0.1
 */