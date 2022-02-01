package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.emoji.i.a;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.ui.MMActivity;

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
    paramString1 = ad.Rp("emoje_stroe");
    ad.beh().I(paramString1, true).k("prePublishId", "emoje_stroe");
    localIntent.putExtra("reportSessionId", paramString1);
    c.c(paramContext, "sns", ".ui.SnsUploadUI", localIntent);
    AppMethodBeat.o(108530);
  }
  
  public static void a(MMActivity paramMMActivity, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3, String paramString6)
  {
    AppMethodBeat.i(108533);
    ((com.tencent.mm.pluginsdk.j)h.ae(com.tencent.mm.pluginsdk.j.class)).b(paramMMActivity.getController(), paramString2, paramString4, paramString3, "", paramMMActivity.getString(i.h.app_send), new j.3(paramString1, paramInt1, paramInt2, paramString2, paramString3, paramString4, paramString5, paramInt3, paramString6, paramMMActivity));
    AppMethodBeat.o(108533);
  }
  
  public static void fc(Context paramContext)
  {
    AppMethodBeat.i(108531);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", i.a.fast_faded_in);
    localIntent.putExtra("MMActivity.OverrideExitAnimation", i.a.push_down_out);
    localIntent.putExtra("scene_from", 14);
    c.d(paramContext, ".ui.transmit.SelectConversationUI", localIntent, 2002);
    AppMethodBeat.o(108531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.j
 * JD-Core Version:    0.7.0.1
 */