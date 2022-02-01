package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.c;
import com.tencent.mm.av.o;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.sh;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.opensdk.modelmsg.WXDesignerSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiPageSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
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
    paramString1 = y.xJ("emoje_stroe");
    y.ayq().F(paramString1, true).l("prePublishId", "emoje_stroe");
    localIntent.putExtra("reportSessionId", paramString1);
    d.c(paramContext, "sns", ".ui.SnsUploadUI", localIntent);
    AppMethodBeat.o(108530);
  }
  
  public static void a(final MMActivity paramMMActivity, String paramString1, final int paramInt1, final int paramInt2, final String paramString2, final String paramString3, final String paramString4, final String paramString5, final int paramInt3, final String paramString6)
  {
    AppMethodBeat.i(108533);
    ((i)g.ab(i.class)).b(paramMMActivity.getController(), paramString2, paramString4, paramString3, "", paramMMActivity.getString(2131755884), new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(108529);
        if (paramAnonymousBoolean)
        {
          String str1 = this.oZN;
          paramAnonymousInt = paramInt1;
          int i = paramInt2;
          Object localObject2 = paramString2;
          Object localObject3 = paramString3;
          String str2 = paramString4;
          String str3 = paramString5;
          int j = paramInt3;
          String str4 = paramString6;
          ac.d("MicroMsg.emoji.EmojiSharedMgr", "doSharedToFriend");
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
          o.aFw();
          localObject2 = c.te(str2);
          if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
          {
            ac.i("MicroMsg.emoji.EmojiSharedMgr", "thumb image is not null");
            localObject3 = new ByteArrayOutputStream();
            ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject3);
            ((WXMediaMessage)localObject1).thumbData = ((ByteArrayOutputStream)localObject3).toByteArray();
          }
          localObject2 = new sh();
          ((sh)localObject2).dvk.dis = ((WXMediaMessage)localObject1);
          ((sh)localObject2).dvk.toUser = str1;
          ((sh)localObject2).dvk.dit = 49;
          ((sh)localObject2).dvk.dvl = str1;
          ((sh)localObject2).dvk.dvm = "";
          a.GpY.l((b)localObject2);
          if (!TextUtils.isEmpty(paramAnonymousString))
          {
            localObject1 = new sk();
            ((sk)localObject1).dvv.dvw = str1;
            ((sk)localObject1).dvv.content = paramAnonymousString;
            ((sk)localObject1).dvv.type = w.xt(str1);
            ((sk)localObject1).dvv.flags = 0;
            a.GpY.l((b)localObject1);
          }
          com.tencent.mm.ui.base.h.cg(paramMMActivity, paramMMActivity.getString(2131755894));
          AppMethodBeat.o(108529);
          return;
        }
        AppMethodBeat.o(108529);
      }
    });
    AppMethodBeat.o(108533);
  }
  
  public static void a(final MMActivity paramMMActivity, String paramString1, final String paramString2, final String paramString3, final String paramString4, final String paramString5, final String paramString6, final int paramInt)
  {
    AppMethodBeat.i(108532);
    String str1 = paramMMActivity.getResources().getString(2131755724);
    str1 = str1 + paramString3;
    String str2 = paramMMActivity.getString(2131755884);
    String str3 = paramMMActivity.getString(2131757559);
    ((i)g.ab(i.class)).a(paramMMActivity, paramString1, str1, str2, str3, paramString5, new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(108527);
        if (paramAnonymousBoolean)
        {
          String str1 = this.oZN;
          String str2 = paramString2;
          Object localObject4 = paramString3;
          String str3 = paramString4;
          Object localObject2 = paramString5;
          Object localObject3 = paramString6;
          paramAnonymousInt = paramInt;
          ac.d("MicroMsg.emoji.EmojiSharedMgr", "doSharedToFriend");
          Object localObject1 = new WXMediaMessage();
          ((WXMediaMessage)localObject1).title = ((String)localObject4);
          ((WXMediaMessage)localObject1).description = str3;
          localObject4 = new WXEmojiSharedObject();
          ((WXEmojiSharedObject)localObject4).packageflag = paramAnonymousInt;
          ((WXEmojiSharedObject)localObject4).packageid = str2;
          ((WXEmojiSharedObject)localObject4).thumburl = ((String)localObject2);
          ((WXEmojiSharedObject)localObject4).url = ((String)localObject3);
          ((WXMediaMessage)localObject1).mediaObject = ((WXMediaMessage.IMediaObject)localObject4);
          o.aFw();
          localObject2 = c.te((String)localObject2);
          if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
          {
            ac.i("MicroMsg.emoji.EmojiSharedMgr", "thumb image is not null");
            localObject3 = new ByteArrayOutputStream();
            ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject3);
            ((WXMediaMessage)localObject1).thumbData = ((ByteArrayOutputStream)localObject3).toByteArray();
          }
          localObject2 = new sh();
          ((sh)localObject2).dvk.dis = ((WXMediaMessage)localObject1);
          ((sh)localObject2).dvk.toUser = str1;
          ((sh)localObject2).dvk.dit = 49;
          ((sh)localObject2).dvk.dvl = str1;
          ((sh)localObject2).dvk.dvm = "";
          a.GpY.l((b)localObject2);
          if (!TextUtils.isEmpty(paramAnonymousString))
          {
            localObject1 = new sk();
            ((sk)localObject1).dvv.dvw = str1;
            ((sk)localObject1).dvv.content = paramAnonymousString;
            ((sk)localObject1).dvv.type = w.xt(str1);
            ((sk)localObject1).dvv.flags = 0;
            a.GpY.l((b)localObject1);
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(10993, new Object[] { Integer.valueOf(0), str2 });
          com.tencent.mm.ui.base.h.cg(paramMMActivity, paramMMActivity.getString(2131755894));
        }
        AppMethodBeat.o(108527);
      }
    });
    AppMethodBeat.o(108532);
  }
  
  public static void ez(Context paramContext)
  {
    AppMethodBeat.i(108531);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
    localIntent.putExtra("MMActivity.OverrideExitAnimation", 2130772106);
    d.c(paramContext, ".ui.transmit.SelectConversationUI", localIntent, 2002);
    AppMethodBeat.o(108531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.j
 * JD-Core Version:    0.7.0.1
 */