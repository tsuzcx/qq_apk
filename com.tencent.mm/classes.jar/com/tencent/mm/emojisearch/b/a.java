package com.tencent.mm.emojisearch.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.ah;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.b;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.a.d.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emojisearch/logic/EmojiSearchPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "scene", "", "show", "Lkotlin/Function0;", "", "dismiss", "(ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "EmojiSearchRequestCode", "getEmojiSearchRequestCode", "()I", "getDismiss", "()Lkotlin/jvm/functions/Function0;", "setDismiss", "(Lkotlin/jvm/functions/Function0;)V", "jumpData", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "getJumpData", "()Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "setJumpData", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "getShow", "setShow", "handlePayEmoji", "context", "Landroid/content/Context;", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "onClick", "view", "Landroid/view/View;", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onLongClick", "Companion", "plugin-emojisdk_release"})
public final class a
  extends com.tencent.mm.emoji.panel.a.d
{
  public static final a.a heo;
  public SimilarEmojiQueryModel hek;
  private final int hel;
  kotlin.g.a.a<x> hem;
  private kotlin.g.a.a<x> hen;
  
  static
  {
    AppMethodBeat.i(200025);
    heo = new a.a((byte)0);
    AppMethodBeat.o(200025);
  }
  
  public a(int paramInt, kotlin.g.a.a<x> parama1, kotlin.g.a.a<x> parama2)
  {
    super(paramInt);
    AppMethodBeat.i(200024);
    this.hem = parama1;
    this.hen = parama2;
    AppMethodBeat.o(200024);
  }
  
  public final void a(View paramView, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(200022);
    p.h(paramContext, "context");
    AppMethodBeat.o(200022);
  }
  
  public final void a(View paramView, final Context paramContext, int paramInt, ac paramac)
  {
    AppMethodBeat.i(200023);
    p.h(paramContext, "context");
    if (paramac == null)
    {
      AppMethodBeat.o(200023);
      return;
    }
    if ((paramac instanceof com.tencent.mm.emoji.b.b.h)) {}
    for (paramView = ((com.tencent.mm.emoji.b.b.h)paramac).gWm.field_md5;; paramView = "")
    {
      Log.i("MicroMsg.EmojiSearch", "onClick: " + paramInt + ", md5 :" + paramView);
      if ((!(paramac instanceof ah)) || (((ah)paramac).gYc != 200)) {
        break;
      }
      paramView = new Intent();
      paramView.putExtra("preceding_scence", 13);
      paramView.putExtra("download_entrance_scene", 17);
      paramView.putExtra("check_clickflag", false);
      if (!Util.isNullOrNil(this.haD)) {
        paramView.putExtra("to_talker_name", this.haD);
      }
      paramContext = ((u)paramContext).getBaseContext();
      if ((paramContext instanceof MMFragmentActivity)) {
        ((MMFragmentActivity)paramContext).setMMOnFragmentActivityResult((MMFragmentActivity.b)new c(this));
      }
      c.b(paramContext, "emoji", ".ui.v2.EmojiStoreV2UI", paramView, this.hel);
      paramView = com.tencent.mm.emojisearch.d.a.hew;
      com.tencent.mm.emojisearch.d.a.awz();
      com.tencent.mm.plugin.report.service.h.CyF.a(11594, new Object[] { Integer.valueOf(2) });
      com.tencent.mm.plugin.report.service.h.CyF.a(12065, new Object[] { Integer.valueOf(8) });
      AppMethodBeat.o(200023);
      return;
    }
    if (((paramac instanceof com.tencent.mm.emoji.b.b.h)) && (((com.tencent.mm.emoji.b.b.h)paramac).gYc == 202))
    {
      paramView = com.tencent.mm.emojisearch.d.a.hew;
      paramView = ((com.tencent.mm.emoji.b.b.h)paramac).gWm.getMd5();
      p.g(paramView, "item.emojiInfo.md5");
      com.tencent.mm.emojisearch.d.a.R(paramView, paramInt);
      if (((com.tencent.mm.emoji.b.b.h)paramac).gWm.UuM == 1)
      {
        if (!Util.isNullOrNil(((com.tencent.mm.emoji.b.b.h)paramac).gWm.avy()))
        {
          paramView = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
          p.g(paramView, "MMKernel.plugin(IPluginEmoji::class.java)");
          if (((com.tencent.mm.plugin.emoji.b.d)paramView).getEmojiMgr().amq(((com.tencent.mm.emoji.b.b.h)paramac).gWm.avy())) {
            Log.i("MicroMsg.EmojiSearch", "buy and resend emoji");
          }
        }
      }
      else
      {
        paramView = ((com.tencent.mm.emoji.b.b.h)paramac).gWm;
        paramContext = bj.gCJ();
        p.g(paramContext, "EmojiStorageMgr.getInstance()");
        if (paramContext.cgN().blk(paramView.field_md5) == null)
        {
          paramContext = bj.gCJ();
          p.g(paramContext, "EmojiStorageMgr.getInstance()");
          paramContext.cgN().K(paramView);
        }
        paramContext = this.haC;
        if (paramContext != null) {
          paramContext.B(paramView);
        }
        paramView = this.haC;
        if (paramView != null) {
          paramView.eio();
        }
        this.hen.invoke();
        AppMethodBeat.o(200023);
        return;
      }
      paramView = ((com.tencent.mm.emoji.b.b.h)paramac).gWm;
      paramac = new d.a(paramContext);
      paramac.bon("");
      paramac.boo(paramContext.getString(2131765912));
      paramac.Dk(true);
      paramac.aoV(2131758498).c((DialogInterface.OnClickListener)new b(paramView, paramContext));
      paramac.aoW(2131755761);
      paramView = paramac.hbn();
      p.g(paramView, "alert");
      paramContext = paramView.getWindow();
      if (paramContext != null)
      {
        paramContext.setSoftInputMode(48);
        paramContext.setFlags(131072, 131072);
      }
      paramView.show();
      AppMethodBeat.o(200023);
      return;
    }
    if (((paramac instanceof ah)) && ((((ah)paramac).gYc == 201) || (((ah)paramac).gYc == 203)))
    {
      if (this.hek == null)
      {
        Log.i("MicroMsg.EmojiSearch", "can not jump for null data!");
        AppMethodBeat.o(200023);
        return;
      }
      paramView = com.tencent.mm.emojisearch.d.a.hew;
      com.tencent.mm.emojisearch.d.a.awA();
      paramView = new Intent();
      paramView.putExtra("KEY_NET_PARAM", (Parcelable)this.hek);
      c.b(((u)paramContext).getBaseContext(), "webview", ".emojistore.ui.SosSimilarUI", paramView, 230);
    }
    AppMethodBeat.o(200023);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(EmojiInfo paramEmojiInfo, Context paramContext) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(200020);
      Intent localIntent = new Intent();
      localIntent.putExtra("extra_id", this.haF.field_groupId);
      localIntent.putExtra("preceding_scence", 20);
      Context localContext = paramContext;
      if (localContext == null)
      {
        paramDialogInterface = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMContextThemeWrapper");
        AppMethodBeat.o(200020);
        throw paramDialogInterface;
      }
      c.b(((u)localContext).getBaseContext(), "emoji", ".ui.EmojiStoreDetailUI", localIntent);
      paramDialogInterface.cancel();
      AppMethodBeat.o(200020);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
  static final class c
    implements MMFragmentActivity.b
  {
    c(a parama) {}
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(200021);
      Log.i("MicroMsg.EmojiSearch", "onActivityResult.");
      this.hep.hem.invoke();
      AppMethodBeat.o(200021);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emojisearch.b.a
 * JD-Core Version:    0.7.0.1
 */