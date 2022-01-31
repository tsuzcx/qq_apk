package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.cg.h;
import com.tencent.mm.g.a.nm;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.g.c.a;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.protocal.protobuf.azi;
import com.tencent.mm.protocal.protobuf.zq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.at;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends m
  implements com.tencent.mm.network.k
{
  private f eGj;
  private c.a liK;
  private boolean liL;
  private nm liM;
  public String lig;
  public final com.tencent.mm.ai.b rr;
  
  public k(String paramString)
  {
    AppMethodBeat.i(53123);
    this.lig = "";
    this.liL = false;
    this.liM = null;
    b.a locala = new b.a();
    locala.fsX = new ajy();
    locala.fsY = new ajz();
    locala.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
    locala.funcId = 521;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.lig = paramString;
    this.liM = new nm();
    AppMethodBeat.o(53123);
  }
  
  public k(String paramString, c.a parama)
  {
    AppMethodBeat.i(53124);
    this.lig = "";
    this.liL = false;
    this.liM = null;
    b.a locala = new b.a();
    locala.fsX = new ajy();
    locala.fsY = new ajz();
    locala.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
    locala.funcId = 521;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.lig = paramString;
    this.liK = parama;
    this.liL = true;
    this.liM = new nm();
    AppMethodBeat.o(53124);
  }
  
  private int blE()
  {
    return ((ajz)this.rr.fsW.fta).xbm;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(53125);
    ab.d("MicroMsg.emoji.NetSceneGetEmotionDesc", "getEmotionDesc %s ", new Object[] { this.lig });
    this.eGj = paramf;
    ((ajy)this.rr.fsV.fta).ProductID = this.lig;
    if (TextUtils.isEmpty(this.lig))
    {
      ab.w("MicroMsg.emoji.NetSceneGetEmotionDesc", "get emoji desc faild. product id is null.");
      AppMethodBeat.o(53125);
      return -1;
    }
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(53125);
    return i;
  }
  
  public final int getType()
  {
    return 521;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53126);
    com.tencent.mm.storage.emotion.c localc;
    Object localObject1;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (this.liL) {
        if ((blE() & 0x1) == 1) {
          com.tencent.mm.plugin.emoji.g.c.a(this.liK);
        }
      }
      for (;;)
      {
        this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(53126);
        return;
        ab.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion is can't download. ignore");
        continue;
        paramArrayOfByte = ((ajz)this.rr.fsW.fta).jJv;
        localc = i.getEmojiStorageMgr().yNp;
        localObject1 = this.lig;
        paramInt1 = ((ajz)this.rr.fsW.fta).xbk;
        i = blE();
        if (localc.yPW != null) {
          localc.yPW.edit().putLong("274544".concat(String.valueOf(localObject1)), System.currentTimeMillis()).commit();
        }
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0)) {
          break;
        }
        label179:
        if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0)) {
          break label538;
        }
        ab.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, productId: %s ", new Object[] { this.lig });
        this.liM.cDW.cqx = this.lig;
        a.ymk.l(this.liM);
      }
      paramq = null;
      if (!(localc.db instanceof h)) {
        break label591;
      }
      paramq = (h)localc.db;
    }
    label538:
    label591:
    for (long l = paramq.kr(Thread.currentThread().getId());; l = -1L)
    {
      localc.db.delete("EmojiInfoDesc", "groupId=?", new String[] { localObject1 });
      com.tencent.mm.storage.emotion.b localb = new com.tencent.mm.storage.emotion.b();
      localb.field_groupId = ((String)localObject1);
      localb.field_click_flag = paramInt1;
      localb.field_download_flag = i;
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
          localObject2 = (zq)((Iterator)localObject1).next();
          localb.field_md5 = ((zq)localObject2).Md5;
          localObject2 = ((zq)localObject2).jJv.iterator();
        }
        localObject3 = (azi)((Iterator)localObject2).next();
        localb.field_desc = ((azi)localObject3).Desc;
        localb.field_lang = ((azi)localObject3).nsa;
        localb.field_md5_lang = (localb.field_md5 + localb.field_lang);
        localObject3 = localb.convertTo();
      } while (localc.db.replace("EmojiInfoDesc", "md5_lang", (ContentValues)localObject3) >= 0L);
      if (paramq == null) {
        break label179;
      }
      paramq.nY(l);
      break label179;
      localc.db.replace("EmojiInfoDesc", "md5_lang", localb.convertTo());
      if (paramq == null) {
        break label179;
      }
      paramq.nY(l);
      break label179;
      break;
      ab.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, & errType:%d, errCode:%d, productId: %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.lig });
      if (!this.liL) {
        break;
      }
      ab.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion get des failed. ignore");
      break;
    }
  }
  
  public final int securityLimitCount()
  {
    return 50;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.k
 * JD-Core Version:    0.7.0.1
 */