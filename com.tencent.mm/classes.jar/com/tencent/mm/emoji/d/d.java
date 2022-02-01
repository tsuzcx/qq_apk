package com.tencent.mm.emoji.d;

import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.u;

public abstract class d
{
  protected EmojiInfo jHh;
  protected long jID;
  protected boolean jIt;
  protected boolean jPh;
  public a jPl;
  
  public d(EmojiInfo paramEmojiInfo, boolean paramBoolean, a parama)
  {
    this.jHh = paramEmojiInfo;
    this.jIt = paramBoolean;
    this.jPl = parama;
    this.jPh = ImgUtil.isWXGF(paramEmojiInfo.ifh());
    this.jID = Util.nowMilliSecond();
    Log.i("MicroMsg.EmojiUpload", "EmojiUpload: %s, %s, %s", new Object[] { paramEmojiInfo.field_md5, Boolean.valueOf(paramBoolean), Boolean.valueOf(this.jPh) });
  }
  
  protected final void D(int paramInt, String paramString)
  {
    if (this.jPl != null) {
      this.jPl.B(paramInt, paramString);
    }
  }
  
  protected final void LP(String paramString)
  {
    Log.i("MicroMsg.EmojiUpload", "save emoji gif md5, wxam %b, md5 %s, %s", new Object[] { Boolean.valueOf(this.jHh.hBw()), paramString, this.jHh.field_wxamMd5 });
    if ((this.jPh) && (!Util.isNullOrNil(paramString)))
    {
      String str2 = this.jHh.ifh();
      String str1 = this.jHh.ifi();
      u.on(str2, EmojiInfo.ifj() + paramString);
      str2 = this.jHh.field_md5;
      this.jHh.field_md5 = paramString;
      this.jHh.field_externMd5 = this.jHh.field_wxamMd5;
      this.jHh.a(EmojiInfo.a.VIi);
      u.on(str1, this.jHh.ifi());
      ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().VFH.K(this.jHh);
      ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().VFH.du(str2, true);
      return;
    }
    this.jHh.a(EmojiInfo.a.VIi);
    ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().VFH.M(this.jHh);
  }
  
  public final void aDA()
  {
    if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
    {
      D(5, null);
      return;
    }
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      D(6, null);
      return;
    }
    D(7, null);
  }
  
  protected final void rP(int paramInt)
  {
    D(paramInt, null);
  }
  
  public static abstract interface a
  {
    public abstract void B(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.d.d
 * JD-Core Version:    0.7.0.1
 */