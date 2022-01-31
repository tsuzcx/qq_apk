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
import com.tencent.mm.opensdk.modelmsg.WXEmojiSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class l$1
  implements q.a
{
  public l$1(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, MMActivity paramMMActivity) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(52982);
    if (paramBoolean)
    {
      String str1 = this.lgH;
      String str2 = this.lgI;
      Object localObject4 = this.lgJ;
      String str3 = this.lgK;
      Object localObject2 = this.lgL;
      Object localObject3 = this.lgM;
      paramInt = this.lgN;
      ab.d("MicroMsg.emoji.EmojiSharedMgr", "doSharedToFriend");
      Object localObject1 = new WXMediaMessage();
      ((WXMediaMessage)localObject1).title = ((String)localObject4);
      ((WXMediaMessage)localObject1).description = str3;
      localObject4 = new WXEmojiSharedObject();
      ((WXEmojiSharedObject)localObject4).packageflag = paramInt;
      ((WXEmojiSharedObject)localObject4).packageid = str2;
      ((WXEmojiSharedObject)localObject4).thumburl = ((String)localObject2);
      ((WXEmojiSharedObject)localObject4).url = ((String)localObject3);
      ((WXMediaMessage)localObject1).mediaObject = ((WXMediaMessage.IMediaObject)localObject4);
      o.ahB();
      localObject2 = c.lK((String)localObject2);
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
      com.tencent.mm.plugin.report.service.h.qsU.e(10993, new Object[] { Integer.valueOf(0), str2 });
      com.tencent.mm.ui.base.h.bO(this.cae, this.cae.getString(2131297076));
    }
    AppMethodBeat.o(52982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.l.1
 * JD-Core Version:    0.7.0.1
 */