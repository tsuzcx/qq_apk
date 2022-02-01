package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import com.tencent.luggage.k.f;
import com.tencent.luggage.k.f.c;
import com.tencent.luggage.sdk.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.vfs.u;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareGifToConversationLogic;", "", "()V", "SHARE_GIF_REQUEST_CODE", "", "doShare", "", "activity", "Landroid/app/Activity;", "gifPath", "", "shareCallBack", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareCallBack;", "plugin-appbrand-integration_release"})
public final class x
{
  private static final int pqO;
  public static final x pqP;
  
  static
  {
    AppMethodBeat.i(258293);
    x localx = new x();
    pqP = localx;
    pqO = a.aI(localx);
    AppMethodBeat.o(258293);
  }
  
  public static void a(Activity paramActivity, String paramString, b<? super ac, kotlin.x> paramb)
  {
    AppMethodBeat.i(258292);
    p.k(paramActivity, "activity");
    p.k(paramString, "gifPath");
    p.k(paramb, "shareCallBack");
    Object localObject1 = (com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class);
    long l;
    label103:
    int i;
    if (localObject1 != null)
    {
      com.tencent.mm.pluginsdk.b.d locald = ((com.tencent.mm.plugin.emoji.b.d)localObject1).getEmojiMgr();
      if (locald != null)
      {
        Object localObject2 = locald.aud(u.buc(paramString));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          MMApplicationContext.getContext();
          localObject1 = locald.aud(locald.auf(paramString));
        }
        if (localObject1 != null) {
          break label232;
        }
        l = 0L;
        if (l <= com.tencent.mm.n.c.awI()) {
          break label245;
        }
        i = 1;
        label115:
        localObject2 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        if (localObject1 != null) {
          break label250;
        }
        label135:
        if (((BitmapUtil.decodeFile(paramString, (BitmapFactory.Options)localObject2) == null) || (((BitmapFactory.Options)localObject2).outHeight <= com.tencent.mm.n.c.awH())) && (((BitmapFactory.Options)localObject2).outWidth <= com.tencent.mm.n.c.awH())) {
          break label259;
        }
      }
    }
    label259:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) && (j == 0)) {
        break label265;
      }
      Log.i("MicroMsg.AppBrand.ShareGifToConversationLogic", "doShare, fail since gif illegal");
      com.tencent.mm.ui.base.h.a((Context)paramActivity, paramActivity.getString(au.i.emoji_custom_gif_max_size_limit_cannot_send), "", paramActivity.getString(au.i.i_know_it), (DialogInterface.OnClickListener)new a(paramb));
      AppMethodBeat.o(258292);
      return;
      localObject1 = null;
      break;
      label232:
      l = u.bBQ(((EmojiInfo)localObject1).ifh());
      break label103;
      label245:
      i = 0;
      break label115;
      label250:
      paramString = ((EmojiInfo)localObject1).ifh();
      break label135;
    }
    label265:
    paramString = (MMActivity.a)new c(paramb);
    f.aI((Context)paramActivity).b((f.c)new b(paramString));
    paramString = (Context)paramActivity;
    paramb = new Intent();
    if (localObject1 == null) {}
    for (paramActivity = "";; paramActivity = ((EmojiInfo)localObject1).getMd5())
    {
      paramb.putExtra("Retr_File_Name", paramActivity);
      paramb.putExtra("Retr_Msg_Type", 5);
      paramb.putExtra("Retr_MsgImgScene", 1);
      paramb.putExtra("Retr_show_success_tips", false);
      com.tencent.mm.by.c.d(paramString, ".ui.transmit.MsgRetransmitUI", paramb, pqO);
      AppMethodBeat.o(258292);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class a
    implements DialogInterface.OnClickListener
  {
    a(b paramb) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(269103);
      this.pqI.invoke(ac.pre);
      AppMethodBeat.o(269103);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onResult"})
  static final class b
    implements f.c
  {
    b(MMActivity.a parama) {}
    
    public final boolean c(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(269110);
      x localx = x.pqP;
      if (x.bUt() != paramInt1)
      {
        AppMethodBeat.o(269110);
        return false;
      }
      this.pqQ.d(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(269110);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "requestCode", "", "resultCode", "<anonymous parameter 2>", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
  static final class c
    implements MMActivity.a
  {
    c(b paramb) {}
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(276519);
      paramIntent = x.pqP;
      if (paramInt1 != x.bUt())
      {
        Log.i("MicroMsg.AppBrand.ShareGifToConversationLogic", "doShare, requestCode: " + paramInt1 + " is not match");
        AppMethodBeat.o(276519);
        return;
      }
      if (paramInt2 != -1)
      {
        Log.i("MicroMsg.AppBrand.ShareGifToConversationLogic", "doShare, resultCode is not RESULT_OK: ".concat(String.valueOf(paramInt2)));
        this.pqI.invoke(ac.prd);
        AppMethodBeat.o(276519);
        return;
      }
      this.pqI.invoke(ac.prc);
      AppMethodBeat.o(276519);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.x
 * JD-Core Version:    0.7.0.1
 */