package com.tencent.mm.emoji.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.o;

public abstract class d
{
  protected EmojiInfo glt;
  protected boolean gmD;
  protected long gmN;
  protected boolean gsr;
  public a gsv;
  
  public d(EmojiInfo paramEmojiInfo, boolean paramBoolean, a parama)
  {
    this.glt = paramEmojiInfo;
    this.gmD = paramBoolean;
    this.gsv = parama;
    this.gsr = u.aRH(paramEmojiInfo.fSQ());
    this.gmN = bu.fpO();
    ae.i("MicroMsg.EmojiUpload", "EmojiUpload: %s, %s, %s", new Object[] { paramEmojiInfo.field_md5, Boolean.valueOf(paramBoolean), Boolean.valueOf(this.gsr) });
  }
  
  protected final void A(int paramInt, String paramString)
  {
    if (this.gsv != null) {
      this.gsv.y(paramInt, paramString);
    }
  }
  
  public final void agC()
  {
    if (!az.isConnected(ak.getContext()))
    {
      A(5, null);
      return;
    }
    if (az.isWifi(ak.getContext()))
    {
      A(6, null);
      return;
    }
    A(7, null);
  }
  
  protected final void mj(int paramInt)
  {
    A(paramInt, null);
  }
  
  protected final void wH(String paramString)
  {
    ae.i("MicroMsg.EmojiUpload", "save emoji gif md5, wxam %b, md5 %s, %s", new Object[] { Boolean.valueOf(this.glt.fxt()), paramString, this.glt.field_wxamMd5 });
    if ((this.gsr) && (!bu.isNullOrNil(paramString)))
    {
      String str2 = this.glt.fSQ();
      String str1 = this.glt.fSR();
      o.mF(str2, EmojiInfo.fSS() + paramString);
      str2 = this.glt.field_md5;
      this.glt.field_md5 = paramString;
      this.glt.field_externMd5 = this.glt.field_wxamMd5;
      this.glt.a(EmojiInfo.a.Jir);
      o.mF(str1, this.glt.fSR());
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().JfU.I(this.glt);
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().JfU.cO(str2, true);
      return;
    }
    this.glt.a(EmojiInfo.a.Jir);
    ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().JfU.K(this.glt);
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