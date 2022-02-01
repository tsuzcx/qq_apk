package com.tencent.mm.emoji.f;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mm.plugin.emoji.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/util/EmojiExchangeCheck;", "", "context", "Landroid/content/Context;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "token", "", "callback", "Lcom/tencent/mm/emoji/util/EmojiExchangeCheck$CheckCallback;", "(Landroid/content/Context;Lcom/tencent/mm/storage/emotion/EmojiInfo;Ljava/lang/String;Lcom/tencent/mm/emoji/util/EmojiExchangeCheck$CheckCallback;)V", "TAG", "getCallback", "()Lcom/tencent/mm/emoji/util/EmojiExchangeCheck$CheckCallback;", "getContext", "()Landroid/content/Context;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getToken", "()Ljava/lang/String;", "checkExchange", "", "handleErrCode", "errCode", "", "errMsg", "showErrorDialog", "msg", "dismissCallback", "Lkotlin/Function0;", "showPurchaseDialog", "goToDetail", "", "CheckCallback", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
{
  private final String TAG;
  private final Context context;
  private EmojiInfo mgK;
  final a mop;
  private final String token;
  
  public b(Context paramContext, EmojiInfo paramEmojiInfo, String paramString, a parama)
  {
    this.context = paramContext;
    this.mgK = paramEmojiInfo;
    this.token = paramString;
    this.mop = parama;
    this.TAG = "MicroMsg.EmojiExchangeCheck";
    if ((!d.y(this.mgK)) && (!d.z(this.mgK)) && (!Util.isNullOrNil(this.mgK.field_groupId)))
    {
      paramContext = this.mgK.field_groupId;
      s.s(paramContext, "emojiInfo.field_groupId");
      if (!f.Ey(paramContext)) {}
    }
    else
    {
      Log.i(this.TAG, "no need exchange %s %s", new Object[] { this.mgK.field_md5, this.mgK.field_groupId });
      this.mop.onResult(true);
      return;
    }
    paramContext = this.mgK.field_groupId;
    s.s(paramContext, "emojiInfo.field_groupId");
    new com.tencent.mm.emoji.c.a.b(paramContext, this.token).bFJ().g(new b..ExternalSyntheticLambda1(this));
    Log.i(this.TAG, "do exchange " + this.mgK.field_md5 + ' ' + this.mgK.field_groupId + ", " + this.token);
  }
  
  private static final ah a(b paramb, com.tencent.mm.am.b.a parama)
  {
    s.u(paramb, "this$0");
    int i = parama.errType;
    int j = parama.errCode;
    Log.i(paramb.TAG, "checkExchange: cgi result: " + i + ", " + j);
    if ((i == 0) && (j == 0))
    {
      parama = paramb.mgK.field_groupId;
      s.s(parama, "emojiInfo.field_groupId");
      f.Ez(parama);
      paramb.mop.onResult(true);
    }
    for (;;)
    {
      return ah.aiuX;
      paramb.C(j, parama.errMsg);
    }
  }
  
  private static final void a(a parama, DialogInterface paramDialogInterface)
  {
    s.u(parama, "$dismissCallback");
    parama.invoke();
  }
  
  public abstract void C(int paramInt, String paramString);
  
  protected final void c(String paramString, a<ah> parama)
  {
    s.u(paramString, "msg");
    s.u(parama, "dismissCallback");
    paramString = k.c(this.context, paramString, "", true);
    s.s(paramString, "showAlert(context, msg, \"\")");
    paramString.setOnDismissListener(new b..ExternalSyntheticLambda0(parama));
  }
  
  public final Context getContext()
  {
    return this.context;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/util/EmojiExchangeCheck$CheckCallback;", "", "onResult", "", "canSend", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void onResult(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.f.b
 * JD-Core Version:    0.7.0.1
 */