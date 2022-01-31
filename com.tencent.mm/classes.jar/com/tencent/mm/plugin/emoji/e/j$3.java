package com.tencent.mm.plugin.emoji.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.as.c;
import com.tencent.mm.as.o;
import com.tencent.mm.h.a.pb;
import com.tencent.mm.h.a.pe;
import com.tencent.mm.model.s;
import com.tencent.mm.opensdk.modelmsg.WXEmojiPageSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

final class j$3
  implements q.a
{
  j$3(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3, String paramString6, MMActivity paramMMActivity) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      String str1 = this.iXu;
      paramInt = this.bns;
      int i = this.iXF;
      Object localObject2 = this.dYK;
      Object localObject3 = this.gBn;
      String str2 = this.iXG;
      String str3 = this.iXH;
      int j = this.iXI;
      String str4 = this.iXJ;
      y.d("MicroMsg.emoji.EmojiSharedMgr", "doSharedToFriend");
      Object localObject1 = new WXMediaMessage();
      ((WXMediaMessage)localObject1).title = ((String)localObject2);
      ((WXMediaMessage)localObject1).description = ((String)localObject3);
      WXEmojiPageSharedObject localWXEmojiPageSharedObject = new WXEmojiPageSharedObject();
      localWXEmojiPageSharedObject.type = paramInt;
      localWXEmojiPageSharedObject.tid = i;
      localWXEmojiPageSharedObject.title = ((String)localObject2);
      localWXEmojiPageSharedObject.desc = ((String)localObject3);
      localWXEmojiPageSharedObject.iconUrl = str2;
      localWXEmojiPageSharedObject.secondUrl = str3;
      localWXEmojiPageSharedObject.pageType = j;
      localWXEmojiPageSharedObject.url = str4;
      ((WXMediaMessage)localObject1).mediaObject = localWXEmojiPageSharedObject;
      o.OI();
      localObject2 = c.jK(str2);
      if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
      {
        y.i("MicroMsg.emoji.EmojiSharedMgr", "thumb image is not null");
        localObject3 = new ByteArrayOutputStream();
        ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject3);
        ((WXMediaMessage)localObject1).thumbData = ((ByteArrayOutputStream)localObject3).toByteArray();
      }
      localObject2 = new pb();
      ((pb)localObject2).bYE.bRd = ((WXMediaMessage)localObject1);
      ((pb)localObject2).bYE.toUser = str1;
      ((pb)localObject2).bYE.bYF = 49;
      ((pb)localObject2).bYE.bYG = str1;
      ((pb)localObject2).bYE.bYH = "";
      a.udP.m((b)localObject2);
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = new pe();
        ((pe)localObject1).bYQ.bYR = str1;
        ((pe)localObject1).bYQ.content = paramString;
        ((pe)localObject1).bYQ.type = s.hW(str1);
        ((pe)localObject1).bYQ.flags = 0;
        a.udP.m((b)localObject1);
      }
      h.bC(this.byc, this.byc.getString(f.h.app_shared));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.j.3
 * JD-Core Version:    0.7.0.1
 */