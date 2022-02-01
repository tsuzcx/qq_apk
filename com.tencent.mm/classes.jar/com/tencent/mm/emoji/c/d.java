package com.tencent.mm.emoji.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.i;

public abstract class d
{
  protected EmojiInfo fLP;
  protected boolean fMY;
  protected long fNi;
  public a fSC;
  protected boolean fSy;
  
  public d(EmojiInfo paramEmojiInfo, boolean paramBoolean, a parama)
  {
    this.fLP = paramEmojiInfo;
    this.fMY = paramBoolean;
    this.fSC = parama;
    this.fSy = t.aFn(paramEmojiInfo.gaa());
    this.fNi = bt.eGO();
    ad.i("MicroMsg.EmojiUpload", "EmojiUpload: %s, %s, %s", new Object[] { paramEmojiInfo.field_md5, Boolean.valueOf(paramBoolean), Boolean.valueOf(this.fSy) });
  }
  
  protected final void A(int paramInt, String paramString)
  {
    if (this.fSC != null) {
      this.fSC.y(paramInt, paramString);
    }
  }
  
  public final void acC()
  {
    if (!ay.isConnected(aj.getContext()))
    {
      A(5, null);
      return;
    }
    if (ay.isWifi(aj.getContext()))
    {
      A(6, null);
      return;
    }
    A(7, null);
  }
  
  protected final void lK(int paramInt)
  {
    A(paramInt, null);
  }
  
  protected final void pX(String paramString)
  {
    ad.i("MicroMsg.EmojiUpload", "save emoji gif md5, wxam %b, md5 %s, %s", new Object[] { Boolean.valueOf(this.fLP.fZS()), paramString, this.fLP.field_wxamMd5 });
    if ((this.fSy) && (!bt.isNullOrNil(paramString)))
    {
      String str1 = this.fLP.gaa();
      String str2 = this.fLP.gab();
      i.lC(str1, EmojiInfo.gac() + paramString);
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().FyY.cz(this.fLP.field_md5, true);
      this.fLP.field_md5 = paramString;
      this.fLP.field_externMd5 = this.fLP.field_wxamMd5;
      this.fLP.a(EmojiInfo.a.FBv);
      i.lC(str2, this.fLP.gab());
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().FyY.J(this.fLP);
      return;
    }
    this.fLP.a(EmojiInfo.a.FBv);
    ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().FyY.L(this.fLP);
  }
  
  public static abstract interface a
  {
    public abstract void y(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.c.d
 * JD-Core Version:    0.7.0.1
 */