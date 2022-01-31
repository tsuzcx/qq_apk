package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.c;
import com.tencent.mm.at.o;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.opensdk.modelmsg.WXEmojiPageSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class l
{
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    AppMethodBeat.i(52985);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ksnsupload_title", paramString1);
    localIntent.putExtra("KContentObjDesc", paramString2);
    localIntent.putExtra("Ksnsupload_imgurl", paramString3);
    localIntent.putExtra("Ksnsupload_link", paramString4);
    localIntent.putExtra("KUploadProduct_UserData", paramString5);
    localIntent.putExtra("Ksnsupload_type", paramInt);
    paramString1 = v.oQ("emoje_stroe");
    v.aae().z(paramString1, true).i("prePublishId", "emoje_stroe");
    localIntent.putExtra("reportSessionId", paramString1);
    d.c(paramContext, "sns", ".ui.SnsUploadUI", localIntent);
    AppMethodBeat.o(52985);
  }
  
  public static void a(final MMActivity paramMMActivity, String paramString1, final int paramInt1, final int paramInt2, final String paramString2, final String paramString3, final String paramString4, final String paramString5, final int paramInt3, final String paramString6)
  {
    AppMethodBeat.i(52987);
    ((i)g.E(i.class)).b(paramMMActivity.getController(), paramString2, paramString4, paramString3, "", paramMMActivity.getString(2131297067), new q.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(52984);
        if (paramAnonymousBoolean)
        {
          String str1 = this.lgH;
          paramAnonymousInt = paramInt1;
          int i = paramInt2;
          Object localObject2 = paramString2;
          Object localObject3 = paramString3;
          String str2 = paramString4;
          String str3 = paramString5;
          int j = paramInt3;
          String str4 = paramString6;
          ab.d("MicroMsg.emoji.EmojiSharedMgr", "doSharedToFriend");
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
          if (!TextUtils.isEmpty(paramAnonymousString))
          {
            localObject1 = new qj();
            ((qj)localObject1).cGX.cGY = str1;
            ((qj)localObject1).cGX.content = paramAnonymousString;
            ((qj)localObject1).cGX.type = t.oF(str1);
            ((qj)localObject1).cGX.flags = 0;
            a.ymk.l((b)localObject1);
          }
          h.bO(paramMMActivity, paramMMActivity.getString(2131297076));
          AppMethodBeat.o(52984);
          return;
        }
        AppMethodBeat.o(52984);
      }
    });
    AppMethodBeat.o(52987);
  }
  
  public static void dJ(Context paramContext)
  {
    AppMethodBeat.i(52986);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", 2131034181);
    localIntent.putExtra("MMActivity.OverrideExitAnimation", 2131034228);
    d.b(paramContext, ".ui.transmit.SelectConversationUI", localIntent, 2002);
    AppMethodBeat.o(52986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.l
 * JD-Core Version:    0.7.0.1
 */