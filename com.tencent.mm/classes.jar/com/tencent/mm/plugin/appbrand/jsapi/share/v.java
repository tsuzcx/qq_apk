package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import com.tencent.luggage.l.e;
import com.tencent.luggage.sdk.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareGifToConversationLogic;", "", "()V", "SHARE_GIF_REQUEST_CODE", "", "doShare", "", "activity", "Landroid/app/Activity;", "gifPath", "", "shareCallBack", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareCallBack;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
{
  private static final int svA;
  public static final v svz;
  
  static
  {
    AppMethodBeat.i(326396);
    v localv = new v();
    svz = localv;
    svA = a.ce(localv);
    AppMethodBeat.o(326396);
  }
  
  public static void a(Activity paramActivity, String paramString, b<? super aa, ah> paramb)
  {
    AppMethodBeat.i(326380);
    s.u(paramActivity, "activity");
    s.u(paramString, "gifPath");
    s.u(paramb, "shareCallBack");
    Object localObject1 = (com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class);
    long l;
    label49:
    int i;
    label61:
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label234;
      }
      l = 0L;
      if (l <= com.tencent.mm.k.c.aRi()) {
        break label247;
      }
      i = 1;
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      if (localObject1 != null) {
        break label252;
      }
      label81:
      if (((BitmapUtil.decodeFile(paramString, (BitmapFactory.Options)localObject2) == null) || (((BitmapFactory.Options)localObject2).outHeight <= com.tencent.mm.k.c.aRh())) && (((BitmapFactory.Options)localObject2).outWidth <= com.tencent.mm.k.c.aRh())) {
        break label261;
      }
    }
    label261:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) && (j == 0)) {
        break label267;
      }
      Log.i("MicroMsg.AppBrand.ShareGifToConversationLogic", "doShare, fail since gif illegal");
      k.a((Context)paramActivity, paramActivity.getString(ba.i.emoji_custom_gif_max_size_limit_cannot_send), "", paramActivity.getString(ba.i.i_know_it), new v..ExternalSyntheticLambda0(paramb));
      AppMethodBeat.o(326380);
      return;
      localObject2 = ((com.tencent.mm.plugin.emoji.c.d)localObject1).getEmojiMgr();
      if (localObject2 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((com.tencent.mm.pluginsdk.b.d)localObject2).aoe(y.bub(paramString));
      if (localObject1 == null)
      {
        MMApplicationContext.getContext();
        localObject1 = ((com.tencent.mm.pluginsdk.b.d)localObject2).aoe(((com.tencent.mm.pluginsdk.b.d)localObject2).aog(paramString));
        break;
      }
      break;
      label234:
      l = y.bEl(((EmojiInfo)localObject1).kMn());
      break label49;
      label247:
      i = 0;
      break label61;
      label252:
      paramString = ((EmojiInfo)localObject1).kMn();
      break label81;
    }
    label267:
    paramString = new v..ExternalSyntheticLambda2(paramb);
    e.bt((Context)paramActivity).b(new v..ExternalSyntheticLambda1(paramString));
    paramString = (Context)paramActivity;
    paramb = new Intent();
    if (localObject1 == null) {}
    for (paramActivity = "";; paramActivity = ((EmojiInfo)localObject1).getMd5())
    {
      paramb.putExtra("Retr_File_Name", paramActivity);
      paramb.putExtra("Retr_Msg_Type", 5);
      paramb.putExtra("Retr_MsgImgScene", 1);
      paramb.putExtra("Retr_show_success_tips", false);
      paramActivity = ah.aiuX;
      com.tencent.mm.br.c.d(paramString, ".ui.transmit.MsgRetransmitUI", paramb, svA);
      AppMethodBeat.o(326380);
      return;
    }
  }
  
  private static final void a(b paramb, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(326386);
    s.u(paramb, "$shareCallBack");
    if (paramInt1 != svA)
    {
      Log.i("MicroMsg.AppBrand.ShareGifToConversationLogic", "doShare, requestCode: " + paramInt1 + " is not match");
      AppMethodBeat.o(326386);
      return;
    }
    if (paramInt2 != -1)
    {
      Log.i("MicroMsg.AppBrand.ShareGifToConversationLogic", s.X("doShare, resultCode is not RESULT_OK: ", Integer.valueOf(paramInt2)));
      paramb.invoke(aa.svO);
      AppMethodBeat.o(326386);
      return;
    }
    paramb.invoke(aa.svN);
    AppMethodBeat.o(326386);
  }
  
  private static final void a(b paramb, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(326384);
    s.u(paramb, "$shareCallBack");
    paramb.invoke(aa.svP);
    AppMethodBeat.o(326384);
  }
  
  private static final boolean a(MMActivity.a parama, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(326391);
    s.u(parama, "$mmOnActivityResult");
    if (svA != paramInt1)
    {
      AppMethodBeat.o(326391);
      return false;
    }
    parama.mmOnActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(326391);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.v
 * JD-Core Version:    0.7.0.1
 */