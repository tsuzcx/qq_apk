package com.tencent.mm.emoji.d;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.s;

public abstract class d
{
  protected EmojiInfo gWm;
  protected long gXF;
  protected boolean gXv;
  protected boolean hdB;
  public a hdF;
  
  public d(EmojiInfo paramEmojiInfo, boolean paramBoolean, a parama)
  {
    this.gWm = paramEmojiInfo;
    this.gXv = paramBoolean;
    this.hdF = parama;
    this.hdB = ImgUtil.isWXGF(paramEmojiInfo.hRM());
    this.gXF = Util.nowMilliSecond();
    Log.i("MicroMsg.EmojiUpload", "EmojiUpload: %s, %s, %s", new Object[] { paramEmojiInfo.field_md5, Boolean.valueOf(paramBoolean), Boolean.valueOf(this.hdB) });
  }
  
  protected final void C(int paramInt, String paramString)
  {
    if (this.hdF != null) {
      this.hdF.A(paramInt, paramString);
    }
  }
  
  protected final void EW(String paramString)
  {
    Log.i("MicroMsg.EmojiUpload", "save emoji gif md5, wxam %b, md5 %s, %s", new Object[] { Boolean.valueOf(this.gWm.hRD()), paramString, this.gWm.field_wxamMd5 });
    if ((this.hdB) && (!Util.isNullOrNil(paramString)))
    {
      String str2 = this.gWm.hRM();
      String str1 = this.gWm.hRN();
      s.nw(str2, EmojiInfo.hRO() + paramString);
      str2 = this.gWm.field_md5;
      this.gWm.field_md5 = paramString;
      this.gWm.field_externMd5 = this.gWm.field_wxamMd5;
      this.gWm.a(EmojiInfo.a.Osj);
      s.nw(str1, this.gWm.hRN());
      ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.J(this.gWm);
      ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.dj(str2, true);
      return;
    }
    this.gWm.a(EmojiInfo.a.Osj);
    ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.L(this.gWm);
  }
  
  public final void aws()
  {
    if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
    {
      C(5, null);
      return;
    }
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      C(6, null);
      return;
    }
    C(7, null);
  }
  
  protected final void pt(int paramInt)
  {
    C(paramInt, null);
  }
  
  public static abstract interface a
  {
    public abstract void A(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.d.d
 * JD-Core Version:    0.7.0.1
 */