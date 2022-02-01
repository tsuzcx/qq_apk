package com.tencent.mm.emoji.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/util/EmojiSendCheck;", "", "context", "Landroid/content/Context;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "goToDetail", "", "callback", "Lcom/tencent/mm/emoji/util/EmojiSendCheck$CheckCallback;", "(Landroid/content/Context;Lcom/tencent/mm/storage/emotion/EmojiInfo;ZLcom/tencent/mm/emoji/util/EmojiSendCheck$CheckCallback;)V", "TAG", "", "getCallback", "()Lcom/tencent/mm/emoji/util/EmojiSendCheck$CheckCallback;", "getContext", "()Landroid/content/Context;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getGoToDetail", "()Z", "checkExchange", "", "showErrorDialog", "msg", "showPurchaseDialog", "CheckCallback", "plugin-emojisdk_release"})
public final class c
{
  final String TAG;
  final Context context;
  EmojiInfo glt;
  final boolean gsJ;
  final a gsK;
  
  public c(Context paramContext, EmojiInfo paramEmojiInfo, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(188610);
    this.context = paramContext;
    this.glt = paramEmojiInfo;
    this.gsJ = paramBoolean;
    this.gsK = parama;
    this.TAG = "MicroMsg.EmojiSendCheck";
    if ((this.glt.getGroup() != EmojiInfo.OAa) && (!bu.isNullOrNil(this.glt.field_groupId)))
    {
      paramContext = d.gsN;
      paramContext = this.glt.field_groupId;
      p.g(paramContext, "emojiInfo.field_groupId");
      if (!d.wJ(paramContext)) {}
    }
    else
    {
      ae.i(this.TAG, "no need exchange %s %s", new Object[] { this.glt.field_md5, this.glt.field_groupId });
      this.gsK.dg(true);
      AppMethodBeat.o(188610);
      return;
    }
    paramContext = this.glt.field_groupId;
    p.g(paramContext, "emojiInfo.field_groupId");
    new com.tencent.mm.emoji.a.a.a(paramContext).aET().g((com.tencent.mm.vending.c.a)new b(this));
    ae.i(this.TAG, "do exchange %s %s", new Object[] { this.glt.field_md5, this.glt.field_groupId });
    AppMethodBeat.o(188610);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/util/EmojiSendCheck$CheckCallback;", "", "onResult", "", "canSend", "", "plugin-emojisdk_release"})
  public static abstract interface a
  {
    public abstract void dg(boolean paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/ExchangeEmotionPackResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(c paramc) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    d(c paramc) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(188609);
      paramDialogInterface = new Intent();
      paramDialogInterface.putExtra("extra_id", this.gsL.glt.field_groupId);
      paramDialogInterface.putExtra("preceding_scence", 20);
      com.tencent.mm.br.d.b(this.gsL.context, "emoji", ".ui.EmojiStoreDetailUI", paramDialogInterface);
      AppMethodBeat.o(188609);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.d.c
 * JD-Core Version:    0.7.0.1
 */