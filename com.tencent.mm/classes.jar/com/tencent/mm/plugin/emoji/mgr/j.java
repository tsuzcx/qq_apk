package com.tencent.mm.plugin.emoji.mgr;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.wm;
import com.tencent.mm.autogen.a.wp;
import com.tencent.mm.br.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.modelimage.e;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.opensdk.modelmsg.WXDesignerSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiPageSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.emoji.h.a;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
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
    paramString1 = ad.Jo("emoje_stroe");
    ad.bCb().M(paramString1, true).q("prePublishId", "emoje_stroe");
    localIntent.putExtra("reportSessionId", paramString1);
    c.c(paramContext, "sns", ".ui.SnsUploadUI", localIntent);
    AppMethodBeat.o(108530);
  }
  
  public static void a(final MMActivity paramMMActivity, String paramString1, final int paramInt1, final int paramInt2, final String paramString2, final String paramString3, final String paramString4, final String paramString5, final int paramInt3, final String paramString6)
  {
    AppMethodBeat.i(108533);
    ((com.tencent.mm.pluginsdk.j)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.j.class)).b(paramMMActivity.getController(), paramString2, paramString4, paramString3, "", paramMMActivity.getString(h.h.app_send), new y.a()
    {
      public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(108529);
        if (paramAnonymousBoolean)
        {
          String str1 = j.this;
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
          r.bJZ();
          localObject2 = e.Eo(str2);
          if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
          {
            Log.i("MicroMsg.emoji.EmojiSharedMgr", "thumb image is not null");
            localObject3 = new ByteArrayOutputStream();
            ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject3);
            ((WXMediaMessage)localObject1).thumbData = ((ByteArrayOutputStream)localObject3).toByteArray();
          }
          localObject2 = new wm();
          ((wm)localObject2).hZZ.hzF = ((WXMediaMessage)localObject1);
          ((wm)localObject2).hZZ.toUser = str1;
          ((wm)localObject2).hZZ.hKZ = 49;
          ((wm)localObject2).hZZ.iaa = str1;
          ((wm)localObject2).hZZ.iab = "";
          ((wm)localObject2).publish();
          if (!TextUtils.isEmpty(paramAnonymousString))
          {
            localObject1 = new wp();
            ((wp)localObject1).iak.hgl = str1;
            ((wp)localObject1).iak.content = paramAnonymousString;
            ((wp)localObject1).iak.type = ab.IX(str1);
            ((wp)localObject1).iak.flags = 0;
            ((wp)localObject1).publish();
          }
          k.cZ(paramMMActivity, paramMMActivity.getString(h.h.app_shared));
          AppMethodBeat.o(108529);
          return;
        }
        AppMethodBeat.o(108529);
      }
    });
    AppMethodBeat.o(108533);
  }
  
  public static void ai(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(269918);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", h.a.fast_faded_in);
    localIntent.putExtra("MMActivity.OverrideExitAnimation", h.a.push_down_out);
    localIntent.putExtra("scene_from", 14);
    c.d(paramContext, ".ui.transmit.SelectConversationUI", localIntent, paramInt);
    AppMethodBeat.o(269918);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.mgr.j
 * JD-Core Version:    0.7.0.1
 */