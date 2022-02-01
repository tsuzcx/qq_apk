package com.tencent.mm.plugin.emojicapture.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.api.a.b;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sticker.c.d;
import com.tencent.mm.sticker.c.d.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vending.e.b;
import d.g.b.k;
import d.n.n;
import d.v;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/model/CheckLensInfo;", "", "context", "Landroid/content/Context;", "lensIdWithUrl", "", "onResult", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;)V", "TAG", "getContext", "()Landroid/content/Context;", "getLensIdWithUrl", "()Ljava/lang/String;", "loadHint", "kotlin.jvm.PlatformType", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getOnResult", "()Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "exit", "", "startEmojiCapture", "lensId", "plugin-emojicapture_release"})
public final class a
{
  final String TAG;
  final Context context;
  private final String oJF;
  final p oJG;
  private final String oJH;
  final a.b oJI;
  
  public a(final Context paramContext, String paramString, a.b paramb)
  {
    AppMethodBeat.i(143);
    this.context = paramContext;
    this.oJH = paramString;
    this.oJI = paramb;
    this.TAG = "MicroMsg.CheckLensInfo";
    this.oJF = this.context.getResources().getString(2131760706);
    this.oJG = p.a(this.context, (CharSequence)this.oJF, true, 0, (DialogInterface.OnCancelListener)new a(this));
    paramContext = this.oJH;
    if (paramContext != null) {}
    for (int i = n.a((CharSequence)paramContext, "lensid=", 0, false, 6);; i = 0)
    {
      paramContext = this.oJH;
      if (paramContext == null) {
        break label210;
      }
      if (paramContext != null) {
        break;
      }
      paramContext = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(143);
      throw paramContext;
    }
    paramContext = paramContext.substring(i + 7);
    k.g(paramContext, "(this as java.lang.String).substring(startIndex)");
    paramString = (CharSequence)paramContext;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label221;
      }
      this.oJI.df(false);
      AppMethodBeat.o(143);
      return;
      label210:
      paramContext = null;
      break;
    }
    label221:
    paramString = d.FdM;
    paramb = this.context;
    paramString = paramb;
    if (!(paramb instanceof MMActivity)) {
      paramString = null;
    }
    d.a.a((b)paramString, paramContext, (com.tencent.mm.sticker.c.c)new com.tencent.mm.sticker.c.c()
    {
      public final void a(int paramAnonymousInt, final blp paramAnonymousblp)
      {
        AppMethodBeat.i(141);
        com.tencent.mm.ad.c.g((d.g.a.a)new a(this, paramAnonymousblp));
        AppMethodBeat.o(141);
      }
      
      @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
      static final class a
        extends d.g.b.l
        implements d.g.a.a<y>
      {
        a(a.1 param1, blp paramblp)
        {
          super();
        }
      }
    });
    AppMethodBeat.o(143);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class a
    implements DialogInterface.OnCancelListener
  {
    a(a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(142);
      ad.i(this.oJJ.TAG, "CheckLensInfo: cancel loading");
      a.a(this.oJJ);
      AppMethodBeat.o(142);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a
 * JD-Core Version:    0.7.0.1
 */