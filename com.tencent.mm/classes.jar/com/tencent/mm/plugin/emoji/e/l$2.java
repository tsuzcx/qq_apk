package com.tencent.mm.plugin.emoji.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.c;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXDesignerSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class l$2
  implements q.a
{
  public l$2(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, MMActivity paramMMActivity) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(52983);
    if (paramBoolean)
    {
      String str1 = this.lgO;
      Object localObject4 = this.lgP;
      String str3 = this.hZi;
      paramInt = this.lgQ;
      Object localObject2 = this.lgM;
      Object localObject3 = this.val$name;
      String str2 = this.lgR;
      ab.d("MicroMsg.emoji.EmojiSharedMgr", "shareToFriend");
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
      o.ahB();
      localObject2 = c.lK(str2);
      if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
      {
        ab.i("MicroMsg.emoji.EmojiSharedMgr", "thumb image is not null");
        localObject3 = new ByteArrayOutputStream();
        ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject3);
        ((WXMediaMessage)localObject1).thumbData = ((ByteArrayOutputStream)localObject3).toByteArray();
      }
      localObject2 = new qg();
      ((qg)localObject2).cGL.cyF = ((WXMediaMessage)localObject1);
      ((qg)localObject2).cGL.toUser = str1;
      ((qg)localObject2).cGL.cGM = 49;
      ((qg)localObject2).cGL.cGN = str1;
      ((qg)localObject2).cGL.cGO = "";
      a.ymk.l((b)localObject2);
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = new qj();
        ((qj)localObject1).cGX.cGY = str1;
        ((qj)localObject1).cGX.content = paramString;
        ((qj)localObject1).cGX.type = t.oF(str1);
        ((qj)localObject1).cGX.flags = 0;
        a.ymk.l((b)localObject1);
      }
      h.bO(this.cae, this.cae.getString(2131297076));
    }
    AppMethodBeat.o(52983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.l.2
 * JD-Core Version:    0.7.0.1
 */