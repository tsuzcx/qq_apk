package com.tencent.mm.plugin.emojicapture.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.a.i;
import com.tencent.mm.plugin.emojicapture.api.a.b;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.c.c;
import com.tencent.mm.sticker.c.d.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vending.e.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/model/CheckLensInfo;", "", "context", "Landroid/content/Context;", "lensIdWithUrl", "", "onResult", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;)V", "TAG", "getContext", "()Landroid/content/Context;", "getLensIdWithUrl", "()Ljava/lang/String;", "loadHint", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "kotlin.jvm.PlatformType", "getOnResult", "()Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "exit", "", "startEmojiCapture", "lensId", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private final String TAG;
  final Context context;
  final w xEL;
  private final String ygD;
  final a.b ygE;
  private final String ygF;
  
  public a(final Context paramContext, String paramString, a.b paramb)
  {
    AppMethodBeat.i(143);
    this.context = paramContext;
    this.ygD = paramString;
    this.ygE = paramb;
    this.TAG = "MicroMsg.CheckLensInfo";
    paramContext = this.context.getResources().getString(a.i.loading);
    s.s(paramContext, "context.resources.getString(R.string.loading)");
    this.ygF = paramContext;
    this.xEL = w.a(this.context, (CharSequence)this.ygF, true, 0, new a..ExternalSyntheticLambda0(this));
    paramContext = this.ygD;
    if (paramContext == null)
    {
      i = 0;
      paramContext = this.ygD;
      if (paramContext != null) {
        break label180;
      }
      paramContext = null;
      label119:
      paramString = (CharSequence)paramContext;
      if ((paramString != null) && (paramString.length() != 0)) {
        break label199;
      }
    }
    label180:
    label199:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label205;
      }
      this.ygE.onResult(false);
      AppMethodBeat.o(143);
      return;
      i = n.a((CharSequence)paramContext, "lensid=", 0, false, 6);
      break;
      paramContext = paramContext.substring(i + 7);
      s.s(paramContext, "(this as java.lang.String).substring(startIndex)");
      break label119;
    }
    label205:
    paramString = com.tencent.mm.sticker.c.d.acDm;
    paramString = this.context;
    if ((paramString instanceof MMActivity)) {}
    for (paramString = (MMActivity)paramString;; paramString = null)
    {
      d.a.a((b)paramString, paramContext, (c)new c()
      {
        public final void a(int paramAnonymousInt, dhp paramAnonymousdhp)
        {
          AppMethodBeat.i(141);
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(paramAnonymousdhp, this.ygG, paramContext));
          AppMethodBeat.o(141);
        }
        
        @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
        static final class a
          extends u
          implements kotlin.g.a.a<ah>
        {
          a(dhp paramdhp, a parama, String paramString)
          {
            super();
          }
          
          private static final void a(a parama, boolean paramBoolean, String paramString)
          {
            AppMethodBeat.i(269339);
            s.u(parama, "this$0");
            parama.exit();
            AppMethodBeat.o(269339);
          }
        }
      });
      AppMethodBeat.o(143);
      return;
    }
  }
  
  private static final void a(a parama, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(269337);
    s.u(parama, "this$0");
    Log.i(parama.TAG, "CheckLensInfo: cancel loading");
    parama.exit();
    AppMethodBeat.o(269337);
  }
  
  final void exit()
  {
    AppMethodBeat.i(269343);
    this.xEL.dismiss();
    this.ygE.onResult(false);
    AppMethodBeat.o(269343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a
 * JD-Core Version:    0.7.0.1
 */