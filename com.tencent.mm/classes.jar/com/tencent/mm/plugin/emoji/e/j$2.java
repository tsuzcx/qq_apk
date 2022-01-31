package com.tencent.mm.plugin.emoji.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.as.c;
import com.tencent.mm.as.o;
import com.tencent.mm.h.a.pb;
import com.tencent.mm.h.a.pe;
import com.tencent.mm.model.s;
import com.tencent.mm.opensdk.modelmsg.WXDesignerSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class j$2
  implements q.a
{
  public j$2(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, MMActivity paramMMActivity) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      String str1 = this.iXB;
      Object localObject4 = this.iXC;
      String str3 = this.gBn;
      paramInt = this.iXD;
      Object localObject2 = this.iXz;
      Object localObject3 = this.bjS;
      String str2 = this.iXE;
      y.d("MicroMsg.emoji.EmojiSharedMgr", "shareToFriend");
      Object localObject1 = new WXMediaMessage();
      ((WXMediaMessage)localObject1).title = ((String)localObject4);
      ((WXMediaMessage)localObject1).description = str3;
      localObject4 = new WXDesignerSharedObject();
      ((WXDesignerSharedObject)localObject4).designerUIN = paramInt;
      ((WXDesignerSharedObject)localObject4).thumburl = str2;
      ((WXDesignerSharedObject)localObject4).url = ((String)localObject2);
      ((WXDesignerSharedObject)localObject4).designerName = ((String)localObject3);
      ((WXDesignerSharedObject)localObject4).designerRediretctUrl = str2;
      ((WXMediaMessage)localObject1).mediaObject = ((WXMediaMessage.IMediaObject)localObject4);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.j.2
 * JD-Core Version:    0.7.0.1
 */