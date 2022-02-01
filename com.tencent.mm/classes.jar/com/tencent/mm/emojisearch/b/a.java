package com.tencent.mm.emojisearch.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.emoji.c.b.ae;
import com.tencent.mm.emoji.c.b.aj;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.z;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emojisearch/logic/EmojiSearchPanelClickListener;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelClickListener;", "scene", "", "show", "Lkotlin/Function0;", "", "dismiss", "(ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "EmojiSearchRequestCode", "getEmojiSearchRequestCode", "()I", "getDismiss", "()Lkotlin/jvm/functions/Function0;", "setDismiss", "(Lkotlin/jvm/functions/Function0;)V", "jumpData", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "getJumpData", "()Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "setJumpData", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "getShow", "setShow", "handleEmojiInfoSend", "toSend", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "handlePayEmoji", "context", "Landroid/content/Context;", "emoji", "onClick", "view", "Landroid/view/View;", "position", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onLongClick", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.emoji.panel.a.d
{
  public static final a.a moU;
  private kotlin.g.a.a<ah> moV;
  private kotlin.g.a.a<ah> moW;
  public SimilarEmojiQueryModel moX;
  private final int moY;
  
  static
  {
    AppMethodBeat.i(231506);
    moU = new a.a((byte)0);
    AppMethodBeat.o(231506);
  }
  
  public a(int paramInt, kotlin.g.a.a<ah> parama1, kotlin.g.a.a<ah> parama2)
  {
    super(paramInt);
    AppMethodBeat.i(231492);
    this.moV = parama1;
    this.moW = parama2;
    AppMethodBeat.o(231492);
  }
  
  private static final void a(a parama, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(231499);
    s.u(parama, "this$0");
    Log.i("MicroMsg.EmojiSearch", "onActivityResult.");
    parama.moV.invoke();
    AppMethodBeat.o(231499);
  }
  
  private static final void a(EmojiInfo paramEmojiInfo, Context paramContext, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(231503);
    s.u(paramEmojiInfo, "$emoji");
    s.u(paramContext, "$context");
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_id", paramEmojiInfo.field_groupId);
    localIntent.putExtra("preceding_scence", 20);
    c.b(((z)paramContext).getBaseContext(), "emoji", ".ui.EmojiStoreDetailUI", localIntent);
    paramDialogInterface.cancel();
    AppMethodBeat.o(231503);
  }
  
  private static final void b(a parama, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(231500);
    s.u(parama, "this$0");
    Log.i("MicroMsg.EmojiSearch", "onActivityResult2.");
    if (paramInt2 == -1)
    {
      paramIntent = (EmojiInfo)paramIntent.getParcelableExtra("KEY_EMOJI_INFO_RESULT");
      if (paramIntent != null) {
        parama.n(paramIntent);
      }
    }
    AppMethodBeat.o(231500);
  }
  
  private void n(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(231496);
    s.u(paramEmojiInfo, "toSend");
    if (((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().aof(paramEmojiInfo.field_md5) == null) {
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().o(paramEmojiInfo.field_md5, paramEmojiInfo.field_catalog, paramEmojiInfo.field_type, paramEmojiInfo.field_size);
    }
    j localj = this.mkP;
    if (localj != null) {
      localj.o(paramEmojiInfo);
    }
    paramEmojiInfo = this.mkP;
    if (paramEmojiInfo != null) {
      paramEmojiInfo.cSh();
    }
    this.moW.invoke();
    AppMethodBeat.o(231496);
  }
  
  public final void a(View paramView, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(231519);
    s.u(paramContext, "context");
    AppMethodBeat.o(231519);
  }
  
  public final void a(View paramView, Context paramContext, int paramInt, ae paramae)
  {
    AppMethodBeat.i(231531);
    s.u(paramContext, "context");
    if (paramae == null)
    {
      AppMethodBeat.o(231531);
      return;
    }
    if ((paramae instanceof com.tencent.mm.emoji.c.b.h))
    {
      paramView = ((com.tencent.mm.emoji.c.b.h)paramae).mgK.field_md5;
      Log.i("MicroMsg.EmojiSearch", "onClick: " + paramInt + ", md5 :" + paramView);
      if ((!(paramae instanceof aj)) || (((aj)paramae).miu != 200)) {
        break label330;
      }
      paramView = new Intent();
      paramView.putExtra("preceding_scence", 13);
      paramView.putExtra("download_entrance_scene", 17);
      paramView.putExtra("check_clickflag", false);
      if (!Util.isNullOrNil(this.mkQ)) {
        paramView.putExtra("to_talker_name", this.mkQ);
      }
      paramae = AndroidContextUtil.castActivityOrNull(paramContext);
      if (paramae == null) {
        break label312;
      }
      String str = paramae.getLocalClassName();
      if ((str == null) || (n.i((CharSequence)str, (CharSequence)"AppBrandUI") != true)) {
        break label312;
      }
      paramInt = 1;
      label196:
      if (paramInt != 0) {
        paramView.putExtra("from_appbrand_ui", true);
      }
      if (!(paramae instanceof MMFragmentActivity)) {
        break label317;
      }
      ((MMFragmentActivity)paramae).setMMOnFragmentActivityResult(new a..ExternalSyntheticLambda1(this));
      c.b((Context)paramae, "emoji", ".ui.v2.EmojiStoreV2UI", paramView, this.moY);
    }
    for (;;)
    {
      paramView = com.tencent.mm.emojisearch.c.a.moZ;
      com.tencent.mm.emojisearch.c.a.aWP();
      com.tencent.mm.plugin.report.service.h.OAn.b(11594, new Object[] { Integer.valueOf(2) });
      com.tencent.mm.plugin.report.service.h.OAn.b(12065, new Object[] { Integer.valueOf(8) });
      AppMethodBeat.o(231531);
      return;
      paramView = "";
      break;
      label312:
      paramInt = 0;
      break label196;
      label317:
      c.b(paramContext, "emoji", ".ui.v2.EmojiStoreV2UI", paramView);
    }
    label330:
    if (((paramae instanceof com.tencent.mm.emoji.c.b.h)) && (((com.tencent.mm.emoji.c.b.h)paramae).miu == 202))
    {
      paramView = com.tencent.mm.emojisearch.c.a.moZ;
      paramView = ((com.tencent.mm.emoji.c.b.h)paramae).mgK.getMd5();
      s.s(paramView, "item.emojiInfo.md5");
      com.tencent.mm.emojisearch.c.a.ar(paramView, paramInt);
      if (((com.tencent.mm.emoji.c.b.h)paramae).mgK.pay == 1)
      {
        if ((!Util.isNullOrNil(((com.tencent.mm.emoji.c.b.h)paramae).mgK.field_groupId)) && (((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoj(((com.tencent.mm.emoji.c.b.h)paramae).mgK.field_groupId))) {
          Log.i("MicroMsg.EmojiSearch", "buy and resend emoji");
        }
      }
      else
      {
        n(((com.tencent.mm.emoji.c.b.h)paramae).mgK);
        AppMethodBeat.o(231531);
        return;
      }
      paramView = ((com.tencent.mm.emoji.c.b.h)paramae).mgK;
      paramae = new e.a(paramContext);
      paramae.bDv("");
      paramae.bDw(paramContext.getString(a.j.similar_emoji_pay_dialog_title));
      paramae.NC(true);
      paramae.aER(a.j.emoji_add_fialed_non_purchase_goto).c(new a..ExternalSyntheticLambda0(paramView, paramContext));
      paramae.aES(a.j.app_cancel);
      paramView = paramae.jHH();
      paramContext = paramView.getWindow();
      if (paramContext != null)
      {
        paramContext.setSoftInputMode(48);
        paramContext.setFlags(131072, 131072);
      }
      paramView.show();
      AppMethodBeat.o(231531);
      return;
    }
    if (((paramae instanceof aj)) && ((((aj)paramae).miu == 201) || (((aj)paramae).miu == 203)))
    {
      if (this.moX == null)
      {
        Log.i("MicroMsg.EmojiSearch", "can not jump for null data!");
        AppMethodBeat.o(231531);
        return;
      }
      paramView = com.tencent.mm.emojisearch.c.a.moZ;
      com.tencent.mm.emojisearch.c.a.aWQ();
      paramView = new Intent();
      paramView.putExtra("KEY_NET_PARAM", (Parcelable)this.moX);
      paramae = this.mkP;
      if (paramae != null) {
        break label755;
      }
    }
    label755:
    for (boolean bool = false;; bool = paramae.cSi())
    {
      paramView.putExtra("KEY_GET_EMOJI_INFO_DIRECTLY", bool);
      paramContext = ((z)paramContext).getBaseContext();
      if ((bool) && ((paramContext instanceof MMFragmentActivity))) {
        ((MMFragmentActivity)paramContext).setMMOnFragmentActivityResult(new a..ExternalSyntheticLambda2(this));
      }
      c.b(paramContext, "webview", ".emojistore.ui.SosSimilarUI", paramView, 230);
      AppMethodBeat.o(231531);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emojisearch.b.a
 * JD-Core Version:    0.7.0.1
 */