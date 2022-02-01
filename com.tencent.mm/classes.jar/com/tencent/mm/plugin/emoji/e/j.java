package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.d;
import com.tencent.mm.av.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.opensdk.modelmsg.WXDesignerSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiPageSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class j
{
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    AppMethodBeat.i(108530);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ksnsupload_title", paramString1);
    localIntent.putExtra("KContentObjDesc", paramString2);
    localIntent.putExtra("Ksnsupload_imgurl", paramString3);
    localIntent.putExtra("Ksnsupload_link", paramString4);
    localIntent.putExtra("KUploadProduct_UserData", paramString5);
    localIntent.putExtra("Ksnsupload_type", paramInt);
    paramString1 = ad.JX("emoje_stroe");
    ad.aVe().G(paramString1, true).l("prePublishId", "emoje_stroe");
    localIntent.putExtra("reportSessionId", paramString1);
    c.c(paramContext, "sns", ".ui.SnsUploadUI", localIntent);
    AppMethodBeat.o(108530);
  }
  
  public static void a(final MMActivity paramMMActivity, String paramString1, final int paramInt1, final int paramInt2, final String paramString2, final String paramString3, final String paramString4, final String paramString5, final int paramInt3, final String paramString6)
  {
    AppMethodBeat.i(108533);
    ((com.tencent.mm.pluginsdk.j)g.af(com.tencent.mm.pluginsdk.j.class)).b(paramMMActivity.getController(), paramString2, paramString4, paramString3, "", paramMMActivity.getString(2131755976), new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(108529);
        if (paramAnonymousBoolean)
        {
          String str1 = this.raE;
          paramAnonymousInt = paramInt1;
          int i = paramInt2;
          Object localObject2 = paramString2;
          Object localObject3 = paramString3;
          String str2 = paramString4;
          String str3 = paramString5;
          int j = paramInt3;
          String str4 = paramString6;
          Log.d("MicroMsg.emoji.EmojiSharedMgr", "doSharedToFriend");
          Object localObject1 = new WXMediaMessage();
          ((WXMediaMessage)localObject1).title = ((String)localObject2);
          ((WXMediaMessage)localObject1).description = ((String)localObject3);
          WXEmojiPageSharedObject localWXEmojiPageSharedObject = new WXEmojiPageSharedObject();
          localWXEmojiPageSharedObject.type = paramAnonymousInt;
          localWXEmojiPageSharedObject.tid = i;
          localWXEmojiPageSharedObject.title = ((String)localObject2);
          localWXEmojiPageSharedObject.desc = ((String)localObject3);
          localWXEmojiPageSharedObject.iconUrl = str2;
          localWXEmojiPageSharedObject.secondUrl = str3;
          localWXEmojiPageSharedObject.pageType = j;
          localWXEmojiPageSharedObject.url = str4;
          ((WXMediaMessage)localObject1).mediaObject = localWXEmojiPageSharedObject;
          q.bcQ();
          localObject2 = d.EP(str2);
          if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
          {
            Log.i("MicroMsg.emoji.EmojiSharedMgr", "thumb image is not null");
            localObject3 = new ByteArrayOutputStream();
            ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject3);
            ((WXMediaMessage)localObject1).thumbData = ((ByteArrayOutputStream)localObject3).toByteArray();
          }
          localObject2 = new tt();
          ((tt)localObject2).eaf.dCE = ((WXMediaMessage)localObject1);
          ((tt)localObject2).eaf.toUser = str1;
          ((tt)localObject2).eaf.dMG = 49;
          ((tt)localObject2).eaf.eag = str1;
          ((tt)localObject2).eaf.eah = "";
          EventCenter.instance.publish((IEvent)localObject2);
          if (!TextUtils.isEmpty(paramAnonymousString))
          {
            localObject1 = new tw();
            ((tw)localObject1).eaq.dkV = str1;
            ((tw)localObject1).eaq.content = paramAnonymousString;
            ((tw)localObject1).eaq.type = ab.JG(str1);
            ((tw)localObject1).eaq.flags = 0;
            EventCenter.instance.publish((IEvent)localObject1);
          }
          com.tencent.mm.ui.base.h.cD(paramMMActivity, paramMMActivity.getString(2131755986));
          AppMethodBeat.o(108529);
          return;
        }
        AppMethodBeat.o(108529);
      }
    });
    AppMethodBeat.o(108533);
  }
  
  public static void eY(Context paramContext)
  {
    AppMethodBeat.i(108531);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", 2130772059);
    localIntent.putExtra("MMActivity.OverrideExitAnimation", 2130772130);
    c.c(paramContext, ".ui.transmit.SelectConversationUI", localIntent, 2002);
    AppMethodBeat.o(108531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.j
 * JD-Core Version:    0.7.0.1
 */