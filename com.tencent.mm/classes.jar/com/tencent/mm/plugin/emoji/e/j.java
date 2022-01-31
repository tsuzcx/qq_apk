package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.as.c;
import com.tencent.mm.as.o;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.pb;
import com.tencent.mm.h.a.pe;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.opensdk.modelmsg.WXEmojiSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.emoji.f.a;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class j
{
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("Ksnsupload_title", paramString1);
    localIntent.putExtra("KContentObjDesc", paramString2);
    localIntent.putExtra("Ksnsupload_imgurl", paramString3);
    localIntent.putExtra("Ksnsupload_link", paramString4);
    localIntent.putExtra("KUploadProduct_UserData", paramString5);
    localIntent.putExtra("Ksnsupload_type", paramInt);
    paramString1 = u.ij("emoje_stroe");
    u.Hc().v(paramString1, true).h("prePublishId", "emoje_stroe");
    localIntent.putExtra("reportSessionId", paramString1);
    d.c(paramContext, "sns", ".ui.SnsUploadUI", localIntent);
  }
  
  public static void a(MMActivity paramMMActivity, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3, String paramString6)
  {
    ((com.tencent.mm.pluginsdk.h)g.r(com.tencent.mm.pluginsdk.h.class)).b(paramMMActivity.mController, paramString2, paramString4, paramString3, "", paramMMActivity.getString(f.h.app_send), new j.3(paramString1, paramInt1, paramInt2, paramString2, paramString3, paramString4, paramString5, paramInt3, paramString6, paramMMActivity));
  }
  
  public static void cW(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", f.a.fast_faded_in);
    localIntent.putExtra("MMActivity.OverrideExitAnimation", f.a.push_down_out);
    d.c(paramContext, ".ui.transmit.SelectConversationUI", localIntent, 2002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.j
 * JD-Core Version:    0.7.0.1
 */