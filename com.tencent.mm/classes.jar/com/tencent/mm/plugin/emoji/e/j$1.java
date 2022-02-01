package com.tencent.mm.plugin.emoji.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.d;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.a.uw;
import com.tencent.mm.f.a.uz;
import com.tencent.mm.model.ab;
import com.tencent.mm.opensdk.modelmsg.WXEmojiSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class j$1
  implements y.a
{
  public j$1(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, MMActivity paramMMActivity) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(108527);
    if (paramBoolean)
    {
      String str1 = this.uDE;
      String str2 = this.uDF;
      Object localObject4 = this.uDG;
      String str3 = this.uDH;
      Object localObject2 = this.uDI;
      Object localObject3 = this.uDJ;
      paramInt = this.uDK;
      Log.d("MicroMsg.emoji.EmojiSharedMgr", "doSharedToFriend");
      Object localObject1 = new WXMediaMessage();
      ((WXMediaMessage)localObject1).title = ((String)localObject4);
      ((WXMediaMessage)localObject1).description = str3;
      localObject4 = new WXEmojiSharedObject();
      ((WXEmojiSharedObject)localObject4).packageflag = paramInt;
      ((WXEmojiSharedObject)localObject4).packageid = str2;
      ((WXEmojiSharedObject)localObject4).thumburl = ((String)localObject2);
      ((WXEmojiSharedObject)localObject4).url = ((String)localObject3);
      ((WXMediaMessage)localObject1).mediaObject = ((WXMediaMessage.IMediaObject)localObject4);
      q.bmg();
      localObject2 = d.LI((String)localObject2);
      if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
      {
        Log.i("MicroMsg.emoji.EmojiSharedMgr", "thumb image is not null");
        localObject3 = new ByteArrayOutputStream();
        ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject3);
        ((WXMediaMessage)localObject1).thumbData = ((ByteArrayOutputStream)localObject3).toByteArray();
      }
      localObject2 = new uw();
      ((uw)localObject2).fUc.fvl = ((WXMediaMessage)localObject1);
      ((uw)localObject2).fUc.toUser = str1;
      ((uw)localObject2).fUc.fFO = 49;
      ((uw)localObject2).fUc.fUd = str1;
      ((uw)localObject2).fUc.fUe = "";
      EventCenter.instance.publish((IEvent)localObject2);
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = new uz();
        ((uz)localObject1).fUn.fcD = str1;
        ((uz)localObject1).fUn.content = paramString;
        ((uz)localObject1).fUn.type = ab.QZ(str1);
        ((uz)localObject1).fUn.flags = 0;
        EventCenter.instance.publish((IEvent)localObject1);
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(10993, new Object[] { Integer.valueOf(0), str2 });
      com.tencent.mm.ui.base.h.cO(this.nfc, this.nfc.getString(i.h.app_shared));
    }
    AppMethodBeat.o(108527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.j.1
 * JD-Core Version:    0.7.0.1
 */