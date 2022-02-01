package com.tencent.mm.emoji.e;

import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.y;

public abstract class d
{
  protected EmojiInfo mgK;
  protected boolean mnZ;
  protected boolean mod;
  protected long moe;
  public a mof;
  
  public d(EmojiInfo paramEmojiInfo, boolean paramBoolean, a parama)
  {
    this.mgK = paramEmojiInfo;
    this.mod = paramBoolean;
    this.mof = parama;
    this.mnZ = ImgUtil.isWXGF(paramEmojiInfo.kMn());
    this.moe = Util.nowMilliSecond();
    Log.i("MicroMsg.EmojiUpload", "EmojiUpload: %s, %s, %s", new Object[] { paramEmojiInfo.field_md5, Boolean.valueOf(paramBoolean), Boolean.valueOf(this.mnZ) });
  }
  
  protected final void B(int paramInt, String paramString)
  {
    if (this.mof != null) {
      this.mof.onResult(paramInt, paramString);
    }
  }
  
  protected final void Ev(String paramString)
  {
    Log.i("MicroMsg.EmojiUpload", "save emoji gif md5, wxam %b, md5 %s, %s", new Object[] { Boolean.valueOf(this.mgK.kMg()), paramString, this.mgK.field_wxamMd5 });
    if ((this.mnZ) && (!Util.isNullOrNil(paramString)))
    {
      String str2 = this.mgK.kMn();
      String str1 = this.mgK.kMo();
      y.O(str2, EmojiInfo.kMp() + paramString, false);
      str2 = this.mgK.field_md5;
      this.mgK.field_md5 = paramString;
      this.mgK.field_externMd5 = this.mgK.field_wxamMd5;
      this.mgK.a(EmojiInfo.a.adme);
      y.O(str1, this.mgK.kMo(), false);
      ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiStorageMgr().adju.K(this.mgK);
      ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiStorageMgr().adju.bzb(str2);
      return;
    }
    this.mgK.a(EmojiInfo.a.adme);
    ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiStorageMgr().adju.M(this.mgK);
  }
  
  public final void aWz()
  {
    if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
    {
      B(5, null);
      return;
    }
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      B(6, null);
      return;
    }
    B(7, null);
  }
  
  protected final void rQ(int paramInt)
  {
    B(paramInt, null);
  }
  
  public static abstract interface a
  {
    public abstract void onResult(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.e.d
 * JD-Core Version:    0.7.0.1
 */