package com.tencent.mm.plugin.emojicapture.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.api.a.b;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.c.c;
import com.tencent.mm.sticker.c.d.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vending.e.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/model/CheckLensInfo;", "", "context", "Landroid/content/Context;", "lensIdWithUrl", "", "onResult", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;)V", "TAG", "getContext", "()Landroid/content/Context;", "getLensIdWithUrl", "()Ljava/lang/String;", "loadHint", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "kotlin.jvm.PlatformType", "getOnResult", "()Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "exit", "", "startEmojiCapture", "lensId", "plugin-emojicapture_release"})
public final class a
{
  final String TAG;
  final Context context;
  final com.tencent.mm.ui.base.q qVq;
  private final String roh;
  private final String roi;
  final a.b roj;
  
  public a(final Context paramContext, String paramString, a.b paramb)
  {
    AppMethodBeat.i(143);
    this.context = paramContext;
    this.roi = paramString;
    this.roj = paramb;
    this.TAG = "MicroMsg.CheckLensInfo";
    paramContext = this.context.getResources().getString(2131762443);
    p.g(paramContext, "context.resources.getString(R.string.loading)");
    this.roh = paramContext;
    this.qVq = com.tencent.mm.ui.base.q.a(this.context, (CharSequence)this.roh, true, 0, (DialogInterface.OnCancelListener)new a(this));
    paramContext = this.roi;
    if (paramContext != null) {}
    for (int i = n.a((CharSequence)paramContext, "lensid=", 0, false, 6);; i = 0)
    {
      paramContext = this.roi;
      if (paramContext == null) {
        break label218;
      }
      if (paramContext != null) {
        break;
      }
      paramContext = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(143);
      throw paramContext;
    }
    paramContext = paramContext.substring(i + 7);
    p.g(paramContext, "(this as java.lang.String).substring(startIndex)");
    paramString = (CharSequence)paramContext;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label229;
      }
      this.roj.dQ(false);
      AppMethodBeat.o(143);
      return;
      label218:
      paramContext = null;
      break;
    }
    label229:
    paramString = com.tencent.mm.sticker.c.d.NOm;
    paramb = this.context;
    paramString = paramb;
    if (!(paramb instanceof MMActivity)) {
      paramString = null;
    }
    d.a.a((b)paramString, paramContext, (c)new c()
    {
      public final void a(int paramAnonymousInt, final chz paramAnonymouschz)
      {
        AppMethodBeat.i(141);
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this, paramAnonymouschz));
        AppMethodBeat.o(141);
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
      static final class a
        extends kotlin.g.b.q
        implements kotlin.g.a.a<x>
      {
        a(a.1 param1, chz paramchz)
        {
          super();
        }
      }
    });
    AppMethodBeat.o(143);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class a
    implements DialogInterface.OnCancelListener
  {
    a(a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(142);
      Log.i(this.rok.TAG, "CheckLensInfo: cancel loading");
      a.a(this.rok);
      AppMethodBeat.o(142);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a
 * JD-Core Version:    0.7.0.1
 */