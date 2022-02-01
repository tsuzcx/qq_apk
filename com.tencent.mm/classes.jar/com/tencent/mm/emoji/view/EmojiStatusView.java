package com.tencent.mm.emoji.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.d.h.a;
import com.tencent.mm.emoji.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/view/EmojiStatusView;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "emojiInfo", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "gameUseCover", "", "getGameUseCover", "()Z", "setGameUseCover", "(Z)V", "status", "getStatus", "()I", "setStatus", "(I)V", "statusListener", "Lcom/tencent/mm/emoji/view/EmojiStatusView$StatusListener;", "getStatusListener", "()Lcom/tencent/mm/emoji/view/EmojiStatusView$StatusListener;", "setStatusListener", "(Lcom/tencent/mm/emoji/view/EmojiStatusView$StatusListener;)V", "destroy", "", "onDetachedFromWindow", "onResult", "success", "reload", "setStatusNotify", "Companion", "StatusListener", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class EmojiStatusView
  extends BaseEmojiView
  implements h.a
{
  public static final EmojiStatusView.a moM;
  private EmojiInfo mgK;
  private b moN;
  private boolean moz = true;
  private int status;
  
  static
  {
    AppMethodBeat.i(105804);
    moM = new EmojiStatusView.a((byte)0);
    AppMethodBeat.o(105804);
  }
  
  public EmojiStatusView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EmojiStatusView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EmojiStatusView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public EmojiInfo getEmojiInfo()
  {
    return this.mgK;
  }
  
  public final boolean getGameUseCover()
  {
    return this.moz;
  }
  
  public final int getStatus()
  {
    return this.status;
  }
  
  public final b getStatusListener()
  {
    return this.moN;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(105803);
    Log.i("MicroMsg.EmojiStatusView", s.X("destroy: ", this));
    e locale = e.mgl;
    e.cX((View)this);
    this.moN = null;
    super.onDetachedFromWindow();
    AppMethodBeat.o(105803);
  }
  
  public void onResult(boolean paramBoolean)
  {
    AppMethodBeat.i(105802);
    if (paramBoolean) {}
    for (int i = 1;; i = -1)
    {
      setStatusNotify(i);
      AppMethodBeat.o(105802);
      return;
    }
  }
  
  public void reload()
  {
    AppMethodBeat.i(105800);
    Object localObject = getEmojiInfo();
    if (localObject != null)
    {
      Log.i("MicroMsg.EmojiStatusView", s.X("reload: ", ((EmojiInfo)localObject).getMd5()));
      if ((this.moz) && ((((EmojiInfo)localObject).field_catalog == EmojiGroupInfo.aklE) || (((EmojiInfo)localObject).field_catalog == EmojiInfo.aklL) || (((EmojiInfo)localObject).field_catalog == EmojiInfo.aklK)))
      {
        setStatusNotify(1);
        setImageBitmap(((EmojiInfo)localObject).F(getContext(), 300));
        AppMethodBeat.o(105800);
        return;
      }
      setStatusNotify(0);
      e locale = e.mgl;
      e.a((EmojiInfo)localObject, (BaseEmojiView)this, (h.a)this);
      AppMethodBeat.o(105800);
      return;
    }
    Log.i("MicroMsg.EmojiStatusView", "reload: emojiInfo is null");
    localObject = e.mgl;
    e.cX((View)this);
    AppMethodBeat.o(105800);
  }
  
  public void setEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105799);
    this.mgK = paramEmojiInfo;
    reload();
    AppMethodBeat.o(105799);
  }
  
  public final void setGameUseCover(boolean paramBoolean)
  {
    this.moz = paramBoolean;
  }
  
  public final void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public final void setStatusListener(b paramb)
  {
    this.moN = paramb;
  }
  
  public final void setStatusNotify(int paramInt)
  {
    AppMethodBeat.i(105801);
    this.status = paramInt;
    b localb = this.moN;
    if (localb != null) {
      localb.rJ(paramInt);
    }
    AppMethodBeat.o(105801);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/view/EmojiStatusView$StatusListener;", "", "onStatus", "", "status", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void rJ(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.view.EmojiStatusView
 * JD-Core Version:    0.7.0.1
 */