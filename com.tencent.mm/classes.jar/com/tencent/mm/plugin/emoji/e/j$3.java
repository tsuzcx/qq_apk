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
import com.tencent.mm.opensdk.modelmsg.WXEmojiPageSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

final class j$3
  implements y.a
{
  j$3(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3, String paramString6, MMActivity paramMMActivity) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(108529);
    if (paramBoolean)
    {
      String str1 = this.uDE;
      paramInt = this.val$type;
      int i = this.uDQ;
      Object localObject2 = this.cWz;
      Object localObject3 = this.uDN;
      String str2 = this.uDR;
      String str3 = this.uDS;
      int j = this.uDT;
      String str4 = this.uDU;
      Log.d("MicroMsg.emoji.EmojiSharedMgr", "doSharedToFriend");
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
      q.bmg();
      localObject2 = d.LI(str2);
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
      h.cO(this.nfc, this.nfc.getString(i.h.app_shared));
      AppMethodBeat.o(108529);
      return;
    }
    AppMethodBeat.o(108529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.j.3
 * JD-Core Version:    0.7.0.1
 */