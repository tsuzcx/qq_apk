package com.tencent.mm.emoji.e;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vending.c.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/util/EmojiSendCheck;", "", "context", "Landroid/content/Context;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "goToDetail", "", "callback", "Lcom/tencent/mm/emoji/util/EmojiSendCheck$CheckCallback;", "(Landroid/content/Context;Lcom/tencent/mm/storage/emotion/EmojiInfo;ZLcom/tencent/mm/emoji/util/EmojiSendCheck$CheckCallback;)V", "TAG", "", "getCallback", "()Lcom/tencent/mm/emoji/util/EmojiSendCheck$CheckCallback;", "getContext", "()Landroid/content/Context;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getGoToDetail", "()Z", "checkExchange", "", "showErrorDialog", "msg", "showPurchaseDialog", "CheckCallback", "plugin-emojisdk_release"})
public final class c
{
  final String TAG;
  final Context context;
  EmojiInfo jHh;
  final boolean jPA;
  final c.a jPB;
  
  public c(Context paramContext, EmojiInfo paramEmojiInfo, boolean paramBoolean, c.a parama)
  {
    AppMethodBeat.i(225671);
    this.context = paramContext;
    this.jHh = paramEmojiInfo;
    this.jPA = paramBoolean;
    this.jPB = parama;
    this.TAG = "MicroMsg.EmojiSendCheck";
    if ((!com.tencent.mm.plugin.emoji.i.b.y(this.jHh)) && (!com.tencent.mm.plugin.emoji.i.b.z(this.jHh)) && (!Util.isNullOrNil(this.jHh.field_groupId)))
    {
      paramContext = d.jPE;
      paramContext = this.jHh.field_groupId;
      p.j(paramContext, "emojiInfo.field_groupId");
      if (!d.LS(paramContext)) {}
    }
    else
    {
      Log.i(this.TAG, "no need exchange %s %s", new Object[] { this.jHh.field_md5, this.jHh.field_groupId });
      this.jPB.ep(true);
      AppMethodBeat.o(225671);
      return;
    }
    paramContext = this.jHh.field_groupId;
    p.j(paramContext, "emojiInfo.field_groupId");
    new com.tencent.mm.emoji.b.a.b(paramContext).bhW().g((a)new b(this));
    Log.i(this.TAG, "do exchange %s %s", new Object[] { this.jHh.field_md5, this.jHh.field_groupId });
    AppMethodBeat.o(225671);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/ExchangeEmotionPackResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    b(c paramc) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    d(c paramc) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(240705);
      paramDialogInterface = new Intent();
      paramDialogInterface.putExtra("extra_id", this.jPC.jHh.field_groupId);
      paramDialogInterface.putExtra("preceding_scence", 20);
      com.tencent.mm.by.c.b(this.jPC.context, "emoji", ".ui.EmojiStoreDetailUI", paramDialogInterface);
      AppMethodBeat.o(240705);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.e.c
 * JD-Core Version:    0.7.0.1
 */