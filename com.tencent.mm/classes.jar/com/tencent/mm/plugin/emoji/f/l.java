package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.a.mq;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.g.c.a;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.afb;
import com.tencent.mm.protocal.c.afc;
import com.tencent.mm.protocal.c.atf;
import com.tencent.mm.protocal.c.vh;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends m
  implements k
{
  private f dIJ;
  public final com.tencent.mm.ah.b dmK;
  private c.a iZT;
  private boolean iZU = false;
  private mq iZV = null;
  public String iZs = "";
  
  public l(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new afb();
    locala.ecI = new afc();
    locala.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
    locala.ecG = 521;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.iZs = paramString;
    this.iZV = new mq();
  }
  
  public l(String paramString, c.a parama)
  {
    b.a locala = new b.a();
    locala.ecH = new afb();
    locala.ecI = new afc();
    locala.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
    locala.ecG = 521;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.iZs = paramString;
    this.iZT = parama;
    this.iZU = true;
    this.iZV = new mq();
  }
  
  private int aIf()
  {
    return ((afc)this.dmK.ecF.ecN).tcU;
  }
  
  protected final int Ka()
  {
    return 50;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    y.d("MicroMsg.emoji.NetSceneGetEmotionDesc", "getEmotionDesc %s ", new Object[] { this.iZs });
    this.dIJ = paramf;
    ((afb)this.dmK.ecE.ecN).syc = this.iZs;
    if (TextUtils.isEmpty(this.iZs))
    {
      y.w("MicroMsg.emoji.NetSceneGetEmotionDesc", "get emoji desc faild. product id is null.");
      return -1;
    }
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    com.tencent.mm.storage.emotion.c localc;
    Object localObject1;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (this.iZU) {
        if ((aIf() & 0x1) == 1) {
          com.tencent.mm.plugin.emoji.g.c.a(this.iZT);
        }
      }
      for (;;)
      {
        this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
        y.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion is can't download. ignore");
        continue;
        paramArrayOfByte = ((afc)this.dmK.ecF.ecN).hPT;
        localc = i.getEmojiStorageMgr().uBd;
        localObject1 = this.iZs;
        paramInt1 = ((afc)this.dmK.ecF.ecN).tcS;
        i = aIf();
        if (localc.uDp != null) {
          localc.uDp.edit().putLong("274544" + (String)localObject1, System.currentTimeMillis()).commit();
        }
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0)) {
          break;
        }
        label176:
        if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0)) {
          break label535;
        }
        y.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, productId: %s ", new Object[] { this.iZs });
        this.iZV.bWj.bJd = this.iZs;
        a.udP.m(this.iZV);
      }
      paramq = null;
      if (!(localc.dXw instanceof h)) {
        break label588;
      }
      paramq = (h)localc.dXw;
    }
    label535:
    label588:
    for (long l = paramq.eV(Thread.currentThread().getId());; l = -1L)
    {
      localc.dXw.delete("EmojiInfoDesc", "groupId=?", new String[] { localObject1 });
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
          localObject2 = (vh)((Iterator)localObject1).next();
          localb.field_md5 = ((vh)localObject2).jnU;
          localObject2 = ((vh)localObject2).hPT.iterator();
        }
        localObject3 = (atf)((Iterator)localObject2).next();
        localb.field_desc = ((atf)localObject3).kRN;
        localb.field_lang = ((atf)localObject3).kUa;
        localb.field_md5_lang = (localb.field_md5 + localb.field_lang);
        localObject3 = localb.vf();
      } while (localc.dXw.replace("EmojiInfoDesc", "md5_lang", (ContentValues)localObject3) >= 0L);
      if (paramq == null) {
        break label176;
      }
      paramq.hI(l);
      break label176;
      localc.dXw.replace("EmojiInfoDesc", "md5_lang", localb.vf());
      if (paramq == null) {
        break label176;
      }
      paramq.hI(l);
      break label176;
      break;
      y.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, & errType:%d, errCode:%d, productId: %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.iZs });
      if (!this.iZU) {
        break;
      }
      y.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion get des failed. ignore");
      break;
    }
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 521;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.l
 * JD-Core Version:    0.7.0.1
 */