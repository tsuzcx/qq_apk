package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.g.a.ql;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.emoji.g.c;
import com.tencent.mm.plugin.emoji.g.c.a;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.ajf;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.bms;
import com.tencent.mm.protocal.protobuf.cgx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.e;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends q
  implements m
{
  private i heq;
  private c.a rcV;
  private boolean rcW;
  private ql rcX;
  public String rcq;
  public final com.tencent.mm.ak.d rr;
  
  public l(String paramString)
  {
    AppMethodBeat.i(108695);
    this.rcq = "";
    this.rcW = false;
    this.rcX = null;
    d.a locala = new d.a();
    locala.iLN = new bmr();
    locala.iLO = new bms();
    locala.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
    locala.funcId = 521;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.rcq = paramString;
    this.rcX = new ql();
    AppMethodBeat.o(108695);
  }
  
  public l(String paramString, c.a parama)
  {
    AppMethodBeat.i(108696);
    this.rcq = "";
    this.rcW = false;
    this.rcX = null;
    d.a locala = new d.a();
    locala.iLN = new bmr();
    locala.iLO = new bms();
    locala.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
    locala.funcId = 521;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.rcq = paramString;
    this.rcV = parama;
    this.rcW = true;
    this.rcX = new ql();
    AppMethodBeat.o(108696);
  }
  
  private int cGu()
  {
    return ((bms)this.rr.iLL.iLR).LVu;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(108697);
    Log.d("MicroMsg.emoji.NetSceneGetEmotionDesc", "getEmotionDesc %s ", new Object[] { this.rcq });
    this.heq = parami;
    ((bmr)this.rr.iLK.iLR).ProductID = this.rcq;
    if (TextUtils.isEmpty(this.rcq))
    {
      Log.w("MicroMsg.emoji.NetSceneGetEmotionDesc", "get emoji desc faild. product id is null.");
      AppMethodBeat.o(108697);
      return -1;
    }
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(108697);
    return i;
  }
  
  public final int getType()
  {
    return 521;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108698);
    e locale;
    Object localObject1;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (this.rcW) {
        if ((cGu() & 0x1) == 1) {
          c.a(this.rcV);
        }
      }
      for (;;)
      {
        this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(108698);
        return;
        Log.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion is can't download. ignore");
        continue;
        paramArrayOfByte = ((bms)this.rr.iLL.iLR).oTA;
        locale = k.getEmojiStorageMgr().OpP;
        localObject1 = this.rcq;
        paramInt1 = ((bms)this.rr.iLL.iLR).LVs;
        i = cGu();
        if (locale.OsE != null) {
          locale.OsE.edit().putLong("274544".concat(String.valueOf(localObject1)), System.currentTimeMillis()).commit();
        }
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0)) {
          break;
        }
        label179:
        if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0)) {
          break label538;
        }
        Log.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, productId: %s ", new Object[] { this.rcq });
        this.rcX.dWU.productId = this.rcq;
        EventCenter.instance.publish(this.rcX);
      }
      params = null;
      if (!(locale.db instanceof h)) {
        break label591;
      }
      params = (h)locale.db;
    }
    label538:
    label591:
    for (long l = params.beginTransaction(Thread.currentThread().getId());; l = -1L)
    {
      locale.db.delete("EmojiInfoDesc", "groupId=?", new String[] { localObject1 });
      com.tencent.mm.storage.emotion.d locald = new com.tencent.mm.storage.emotion.d();
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
          localObject2 = (ajf)((Iterator)localObject1).next();
          locald.field_md5 = ((ajf)localObject2).Md5;
          localObject2 = ((ajf)localObject2).oTA.iterator();
        }
        localObject3 = (cgx)((Iterator)localObject2).next();
        locald.field_desc = ((cgx)localObject3).Desc;
        locald.field_lang = ((cgx)localObject3).xLl;
        locald.field_md5_lang = (locald.field_md5 + locald.field_lang);
        localObject3 = locald.convertTo();
      } while (locale.db.replace("EmojiInfoDesc", "md5_lang", (ContentValues)localObject3) >= 0L);
      if (params == null) {
        break label179;
      }
      params.endTransaction(l);
      break label179;
      locale.db.replace("EmojiInfoDesc", "md5_lang", locald.convertTo());
      if (params == null) {
        break label179;
      }
      params.endTransaction(l);
      break label179;
      break;
      Log.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, & errType:%d, errCode:%d, productId: %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.rcq });
      if (!this.rcW) {
        break;
      }
      Log.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion get des failed. ignore");
      break;
    }
  }
  
  public final int securityLimitCount()
  {
    return 50;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.l
 * JD-Core Version:    0.7.0.1
 */