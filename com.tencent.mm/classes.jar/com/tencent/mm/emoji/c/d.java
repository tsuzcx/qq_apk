package com.tencent.mm.emoji.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.i;

public abstract class d
{
  protected EmojiInfo fPB;
  protected boolean fQJ;
  protected long fQT;
  protected boolean fWt;
  public a fWx;
  
  public d(EmojiInfo paramEmojiInfo, boolean paramBoolean, a parama)
  {
    this.fPB = paramEmojiInfo;
    this.fQJ = paramBoolean;
    this.fWx = parama;
    this.fWt = s.aKE(paramEmojiInfo.ghd());
    this.fQT = bs.eWj();
    ac.i("MicroMsg.EmojiUpload", "EmojiUpload: %s, %s, %s", new Object[] { paramEmojiInfo.field_md5, Boolean.valueOf(paramBoolean), Boolean.valueOf(this.fWt) });
  }
  
  protected final void A(int paramInt, String paramString)
  {
    if (this.fWx != null) {
      this.fWx.y(paramInt, paramString);
    }
  }
  
  public final void adI()
  {
    if (!ax.isConnected(ai.getContext()))
    {
      A(5, null);
      return;
    }
    if (ax.isWifi(ai.getContext()))
    {
      A(6, null);
      return;
    }
    A(7, null);
  }
  
  protected final void lG(int paramInt)
  {
    A(paramInt, null);
  }
  
  protected final void tk(String paramString)
  {
    ac.i("MicroMsg.EmojiUpload", "save emoji gif md5, wxam %b, md5 %s, %s", new Object[] { Boolean.valueOf(this.fPB.fxK()), paramString, this.fPB.field_wxamMd5 });
    if ((this.fWt) && (!bs.isNullOrNil(paramString)))
    {
      String str1 = this.fPB.ghd();
      String str2 = this.fPB.ghe();
      i.lZ(str1, EmojiInfo.ghf() + paramString);
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().GXZ.cF(this.fPB.field_md5, true);
      this.fPB.field_md5 = paramString;
      this.fPB.field_externMd5 = this.fPB.field_wxamMd5;
      this.fPB.a(EmojiInfo.a.Hav);
      i.lZ(str2, this.fPB.ghe());
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().GXZ.J(this.fPB);
      return;
    }
    this.fPB.a(EmojiInfo.a.Hav);
    ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().GXZ.L(this.fPB);
  }
  
  public static abstract interface a
  {
    public abstract void y(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.c.d
 * JD-Core Version:    0.7.0.1
 */