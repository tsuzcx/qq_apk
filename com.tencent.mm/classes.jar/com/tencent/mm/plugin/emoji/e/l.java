package com.tencent.mm.plugin.emoji.e;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.a.ta;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.ang;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.protocal.protobuf.ciw;
import com.tencent.mm.protocal.protobuf.dgn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.storage.emotion.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends p
  implements m
{
  private com.tencent.mm.am.h mAY;
  public final com.tencent.mm.am.c rr;
  public String xNX;
  private com.tencent.mm.plugin.emoji.f.c.a xOE;
  private boolean xOF;
  private ta xOG;
  
  public l(String paramString)
  {
    AppMethodBeat.i(108695);
    this.xNX = "";
    this.xOF = false;
    this.xOG = null;
    com.tencent.mm.am.c.a locala = new com.tencent.mm.am.c.a();
    locala.otE = new civ();
    locala.otF = new ciw();
    locala.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
    locala.funcId = 521;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.xNX = paramString;
    this.xOG = new ta();
    AppMethodBeat.o(108695);
  }
  
  public l(String paramString, com.tencent.mm.plugin.emoji.f.c.a parama)
  {
    AppMethodBeat.i(108696);
    this.xNX = "";
    this.xOF = false;
    this.xOG = null;
    com.tencent.mm.am.c.a locala = new com.tencent.mm.am.c.a();
    locala.otE = new civ();
    locala.otF = new ciw();
    locala.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
    locala.funcId = 521;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.xNX = paramString;
    this.xOE = parama;
    this.xOF = true;
    this.xOG = new ta();
    AppMethodBeat.o(108696);
  }
  
  private int dAC()
  {
    AppMethodBeat.i(269814);
    int i = ((ciw)c.c.b(this.rr.otC)).aart;
    AppMethodBeat.o(269814);
    return i;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(108697);
    Log.d("MicroMsg.emoji.NetSceneGetEmotionDesc", "getEmotionDesc %s ", new Object[] { this.xNX });
    this.mAY = paramh;
    ((civ)c.b.b(this.rr.otB)).ProductID = this.xNX;
    if (TextUtils.isEmpty(this.xNX))
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108698);
    e locale;
    Object localObject1;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (this.xOF) {
        if ((dAC() & 0x1) == 1) {
          com.tencent.mm.plugin.emoji.f.c.a(this.xOE);
        }
      }
      for (;;)
      {
        this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(108698);
        return;
        Log.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion is can't download. ignore");
        continue;
        paramArrayOfByte = ((ciw)c.c.b(this.rr.otC)).vgO;
        locale = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjw;
        localObject1 = this.xNX;
        paramInt1 = ((ciw)c.c.b(this.rr.otC)).aarr;
        i = dAC();
        if (locale.admz != null) {
          locale.admz.edit().putLong("274544".concat(String.valueOf(localObject1)), System.currentTimeMillis()).commit();
        }
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0)) {
          break;
        }
        label179:
        if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0)) {
          break label535;
        }
        Log.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, productId: %s ", new Object[] { this.xNX });
        this.xOG.hWD.productId = this.xNX;
        this.xOG.publish();
      }
      params = null;
      if (!(locale.db instanceof com.tencent.mm.storagebase.h)) {
        break label588;
      }
      params = (com.tencent.mm.storagebase.h)locale.db;
    }
    label535:
    label588:
    for (long l = params.beginTransaction(Thread.currentThread().getId());; l = -1L)
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
          localObject2 = (ang)((Iterator)localObject1).next();
          locald.field_md5 = ((ang)localObject2).Md5;
          localObject2 = ((ang)localObject2).vgO.iterator();
        }
        localObject3 = (dgn)((Iterator)localObject2).next();
        locald.field_desc = ((dgn)localObject3).IGG;
        locald.field_lang = ((dgn)localObject3).IJD;
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
      Log.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, & errType:%d, errCode:%d, productId: %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.xNX });
      if (!this.xOF) {
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
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.l
 * JD-Core Version:    0.7.0.1
 */