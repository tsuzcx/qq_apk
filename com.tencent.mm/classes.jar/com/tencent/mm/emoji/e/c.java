package com.tencent.mm.emoji.e;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/util/EmojiSendCheck;", "", "context", "Landroid/content/Context;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "goToDetail", "", "callback", "Lcom/tencent/mm/emoji/util/EmojiSendCheck$CheckCallback;", "(Landroid/content/Context;Lcom/tencent/mm/storage/emotion/EmojiInfo;ZLcom/tencent/mm/emoji/util/EmojiSendCheck$CheckCallback;)V", "TAG", "", "getCallback", "()Lcom/tencent/mm/emoji/util/EmojiSendCheck$CheckCallback;", "getContext", "()Landroid/content/Context;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getGoToDetail", "()Z", "checkExchange", "", "showErrorDialog", "msg", "showPurchaseDialog", "CheckCallback", "plugin-emojisdk_release"})
public final class c
{
  final String TAG;
  final Context context;
  EmojiInfo gWm;
  final boolean hdU;
  final a hdV;
  
  public c(Context paramContext, EmojiInfo paramEmojiInfo, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(200010);
    this.context = paramContext;
    this.gWm = paramEmojiInfo;
    this.hdU = paramBoolean;
    this.hdV = parama;
    this.TAG = "MicroMsg.EmojiSendCheck";
    if ((!b.x(this.gWm)) && (!b.y(this.gWm)) && (!Util.isNullOrNil(this.gWm.field_groupId)))
    {
      paramContext = d.hdY;
      paramContext = this.gWm.field_groupId;
      p.g(paramContext, "emojiInfo.field_groupId");
      if (!d.EZ(paramContext)) {}
    }
    else
    {
      Log.i(this.TAG, "no need exchange %s %s", new Object[] { this.gWm.field_md5, this.gWm.field_groupId });
      this.hdV.dQ(true);
      AppMethodBeat.o(200010);
      return;
    }
    paramContext = this.gWm.field_groupId;
    p.g(paramContext, "emojiInfo.field_groupId");
    new com.tencent.mm.emoji.b.a.a(paramContext).aYI().g((com.tencent.mm.vending.c.a)new b(this));
    Log.i(this.TAG, "do exchange %s %s", new Object[] { this.gWm.field_md5, this.gWm.field_groupId });
    AppMethodBeat.o(200010);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/util/EmojiSendCheck$CheckCallback;", "", "onResult", "", "canSend", "", "plugin-emojisdk_release"})
  public static abstract interface a
  {
    public abstract void dQ(boolean paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/ExchangeEmotionPackResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(c paramc) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    d(c paramc) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(200009);
      paramDialogInterface = new Intent();
      paramDialogInterface.putExtra("extra_id", this.hdW.gWm.field_groupId);
      paramDialogInterface.putExtra("preceding_scence", 20);
      com.tencent.mm.br.c.b(this.hdW.context, "emoji", ".ui.EmojiStoreDetailUI", paramDialogInterface);
      AppMethodBeat.o(200009);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.e.c
 * JD-Core Version:    0.7.0.1
 */