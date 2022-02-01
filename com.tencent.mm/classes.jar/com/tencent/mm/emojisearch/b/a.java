package com.tencent.mm.emojisearch.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.emoji.b.b.ae;
import com.tencent.mm.emoji.b.b.aj;
import com.tencent.mm.emoji.panel.a.e;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.b;
import com.tencent.mm.ui.widget.a.d.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emojisearch/logic/EmojiSearchPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "scene", "", "show", "Lkotlin/Function0;", "", "dismiss", "(ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "EmojiSearchRequestCode", "getEmojiSearchRequestCode", "()I", "getDismiss", "()Lkotlin/jvm/functions/Function0;", "setDismiss", "(Lkotlin/jvm/functions/Function0;)V", "jumpData", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "getJumpData", "()Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "setJumpData", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "getShow", "setShow", "handlePayEmoji", "context", "Landroid/content/Context;", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "onClick", "view", "Landroid/view/View;", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onLongClick", "Companion", "plugin-emojisdk_release"})
public final class a
  extends e
{
  public static final a jQe;
  public SimilarEmojiQueryModel jQa;
  private final int jQb;
  kotlin.g.a.a<kotlin.x> jQc;
  private kotlin.g.a.a<kotlin.x> jQd;
  
  static
  {
    AppMethodBeat.i(241167);
    jQe = new a((byte)0);
    AppMethodBeat.o(241167);
  }
  
  public a(int paramInt, kotlin.g.a.a<kotlin.x> parama1, kotlin.g.a.a<kotlin.x> parama2)
  {
    super(paramInt);
    AppMethodBeat.i(241162);
    this.jQc = parama1;
    this.jQd = parama2;
    AppMethodBeat.o(241162);
  }
  
  public final void a(View paramView, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(241153);
    p.k(paramContext, "context");
    AppMethodBeat.o(241153);
  }
  
  public final void a(View paramView, final Context paramContext, int paramInt, ae paramae)
  {
    AppMethodBeat.i(241160);
    p.k(paramContext, "context");
    if (paramae == null)
    {
      AppMethodBeat.o(241160);
      return;
    }
    if ((paramae instanceof com.tencent.mm.emoji.b.b.h)) {}
    for (paramView = ((com.tencent.mm.emoji.b.b.h)paramae).jHh.field_md5;; paramView = "")
    {
      Log.i("MicroMsg.EmojiSearch", "onClick: " + paramInt + ", md5 :" + paramView);
      if ((!(paramae instanceof aj)) || (((aj)paramae).jJc != 200)) {
        break;
      }
      paramView = new Intent();
      paramView.putExtra("preceding_scence", 13);
      paramView.putExtra("download_entrance_scene", 17);
      paramView.putExtra("check_clickflag", false);
      if (!Util.isNullOrNil(this.jLI)) {
        paramView.putExtra("to_talker_name", this.jLI);
      }
      paramContext = ((com.tencent.mm.ui.x)paramContext).getBaseContext();
      if ((paramContext instanceof MMFragmentActivity)) {
        ((MMFragmentActivity)paramContext).setMMOnFragmentActivityResult((MMFragmentActivity.b)new c(this));
      }
      c.b(paramContext, "emoji", ".ui.v2.EmojiStoreV2UI", paramView, this.jQb);
      paramView = com.tencent.mm.emojisearch.d.a.jQm;
      com.tencent.mm.emojisearch.d.a.aDQ();
      com.tencent.mm.plugin.report.service.h.IzE.a(11594, new Object[] { Integer.valueOf(2) });
      com.tencent.mm.plugin.report.service.h.IzE.a(12065, new Object[] { Integer.valueOf(8) });
      AppMethodBeat.o(241160);
      return;
    }
    if (((paramae instanceof com.tencent.mm.emoji.b.b.h)) && (((com.tencent.mm.emoji.b.b.h)paramae).jJc == 202))
    {
      paramView = com.tencent.mm.emojisearch.d.a.jQm;
      paramView = ((com.tencent.mm.emoji.b.b.h)paramae).jHh.getMd5();
      p.j(paramView, "item.emojiInfo.md5");
      com.tencent.mm.emojisearch.d.a.ai(paramView, paramInt);
      if (((com.tencent.mm.emoji.b.b.h)paramae).jHh.ZuO == 1)
      {
        if (!Util.isNullOrNil(((com.tencent.mm.emoji.b.b.h)paramae).jHh.aCt()))
        {
          paramView = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class);
          p.j(paramView, "MMKernel.plugin(IPluginEmoji::class.java)");
          if (((com.tencent.mm.plugin.emoji.b.d)paramView).getEmojiMgr().aui(((com.tencent.mm.emoji.b.b.h)paramae).jHh.aCt())) {
            Log.i("MicroMsg.EmojiSearch", "buy and resend emoji");
          }
        }
      }
      else
      {
        paramView = ((com.tencent.mm.emoji.b.b.h)paramae).jHh;
        paramContext = bj.hyV();
        p.j(paramContext, "EmojiStorageMgr.getInstance()");
        if (paramContext.ctY().bxK(paramView.field_md5) == null)
        {
          paramContext = bj.hyV();
          p.j(paramContext, "EmojiStorageMgr.getInstance()");
          paramContext.ctY().L(paramView);
        }
        paramContext = this.jLH;
        if (paramContext != null) {
          paramContext.o(paramView);
        }
        paramView = this.jLH;
        if (paramView != null) {
          paramView.cpF();
        }
        this.jQd.invoke();
        AppMethodBeat.o(241160);
        return;
      }
      paramView = ((com.tencent.mm.emoji.b.b.h)paramae).jHh;
      paramae = new d.a(paramContext);
      paramae.bBc("");
      paramae.bBd(paramContext.getString(a.j.similar_emoji_pay_dialog_title));
      paramae.HG(true);
      paramae.ayj(a.j.emoji_add_fialed_non_purchase_goto).c((DialogInterface.OnClickListener)new b(paramView, paramContext));
      paramae.ayk(a.j.app_cancel);
      paramView = paramae.icu();
      p.j(paramView, "alert");
      paramContext = paramView.getWindow();
      if (paramContext != null)
      {
        paramContext.setSoftInputMode(48);
        paramContext.setFlags(131072, 131072);
      }
      paramView.show();
      AppMethodBeat.o(241160);
      return;
    }
    if (((paramae instanceof aj)) && ((((aj)paramae).jJc == 201) || (((aj)paramae).jJc == 203)))
    {
      if (this.jQa == null)
      {
        Log.i("MicroMsg.EmojiSearch", "can not jump for null data!");
        AppMethodBeat.o(241160);
        return;
      }
      paramView = com.tencent.mm.emojisearch.d.a.jQm;
      com.tencent.mm.emojisearch.d.a.aDR();
      paramView = new Intent();
      paramView.putExtra("KEY_NET_PARAM", (Parcelable)this.jQa);
      c.b(((com.tencent.mm.ui.x)paramContext).getBaseContext(), "webview", ".emojistore.ui.SosSimilarUI", paramView, 230);
    }
    AppMethodBeat.o(241160);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emojisearch/logic/EmojiSearchPanelClickListener$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(EmojiInfo paramEmojiInfo, Context paramContext) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(228542);
      Intent localIntent = new Intent();
      localIntent.putExtra("extra_id", this.jLK.field_groupId);
      localIntent.putExtra("preceding_scence", 20);
      Context localContext = paramContext;
      if (localContext == null)
      {
        paramDialogInterface = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMContextThemeWrapper");
        AppMethodBeat.o(228542);
        throw paramDialogInterface;
      }
      c.b(((com.tencent.mm.ui.x)localContext).getBaseContext(), "emoji", ".ui.EmojiStoreDetailUI", localIntent);
      paramDialogInterface.cancel();
      AppMethodBeat.o(228542);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
  static final class c
    implements MMFragmentActivity.b
  {
    c(a parama) {}
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(232268);
      Log.i("MicroMsg.EmojiSearch", "onActivityResult.");
      this.jQf.jQc.invoke();
      AppMethodBeat.o(232268);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emojisearch.b.a
 * JD-Core Version:    0.7.0.1
 */