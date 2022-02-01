package com.tencent.mm.emoji.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.i;

public abstract class d
{
  protected EmojiInfo gjb;
  protected boolean gkj;
  protected long gkt;
  protected boolean gpW;
  public a gqa;
  
  public d(EmojiInfo paramEmojiInfo, boolean paramBoolean, a parama)
  {
    this.gjb = paramEmojiInfo;
    this.gkj = paramBoolean;
    this.gqa = parama;
    this.gpW = t.aQk(paramEmojiInfo.gzQ());
    this.gkt = bt.flT();
    ad.i("MicroMsg.EmojiUpload", "EmojiUpload: %s, %s, %s", new Object[] { paramEmojiInfo.field_md5, Boolean.valueOf(paramBoolean), Boolean.valueOf(this.gpW) });
  }
  
  protected final void A(int paramInt, String paramString)
  {
    if (this.gqa != null) {
      this.gqa.y(paramInt, paramString);
    }
  }
  
  public final void ago()
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
  
  protected final void mg(int paramInt)
  {
    A(paramInt, null);
  }
  
  protected final void wa(String paramString)
  {
    ad.i("MicroMsg.EmojiUpload", "save emoji gif md5, wxam %b, md5 %s, %s", new Object[] { Boolean.valueOf(this.gjb.gzH()), paramString, this.gjb.field_wxamMd5 });
    if ((this.gpW) && (!bt.isNullOrNil(paramString)))
    {
      String str2 = this.gjb.gzQ();
      String str1 = this.gjb.gzR();
      i.mz(str2, EmojiInfo.gzS() + paramString);
      str2 = this.gjb.field_md5;
      this.gjb.field_md5 = paramString;
      this.gjb.field_externMd5 = this.gjb.field_wxamMd5;
      this.gjb.a(EmojiInfo.a.INK);
      i.mz(str1, this.gjb.gzR());
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().ILn.I(this.gjb);
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().ILn.cK(str2, true);
      return;
    }
    this.gjb.a(EmojiInfo.a.INK);
    ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().ILn.K(this.gjb);
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