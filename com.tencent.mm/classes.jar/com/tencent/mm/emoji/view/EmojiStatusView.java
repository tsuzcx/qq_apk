package com.tencent.mm.emoji.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/view/EmojiStatusView;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "emojiInfo", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "gameUseCover", "", "getGameUseCover", "()Z", "setGameUseCover", "(Z)V", "status", "getStatus", "()I", "setStatus", "(I)V", "statusListener", "Lcom/tencent/mm/emoji/view/EmojiStatusView$StatusListener;", "getStatusListener", "()Lcom/tencent/mm/emoji/view/EmojiStatusView$StatusListener;", "setStatusListener", "(Lcom/tencent/mm/emoji/view/EmojiStatusView$StatusListener;)V", "destroy", "", "onDetachedFromWindow", "onResult", "success", "reload", "setStatusNotify", "Companion", "StatusListener", "plugin-emojisdk_release"})
public class EmojiStatusView
  extends BaseEmojiView
  implements i.a
{
  public static final a fTc;
  private EmojiInfo fLP;
  private boolean fSU = true;
  private b fTb;
  private int status;
  
  static
  {
    AppMethodBeat.i(105804);
    fTc = new a((byte)0);
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
  
  public final void df(boolean paramBoolean)
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
  
  public EmojiInfo getEmojiInfo()
  {
    return this.fLP;
  }
  
  public final boolean getGameUseCover()
  {
    return this.fSU;
  }
  
  public final int getStatus()
  {
    return this.status;
  }
  
  public final b getStatusListener()
  {
    return this.fTb;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(105803);
    ad.i("MicroMsg.EmojiStatusView", "destroy: ".concat(String.valueOf(this)));
    e locale = e.fLn;
    e.cv((View)this);
    this.fTb = null;
    super.onDetachedFromWindow();
    AppMethodBeat.o(105803);
  }
  
  public void reload()
  {
    AppMethodBeat.i(105800);
    Object localObject = getEmojiInfo();
    if (localObject != null)
    {
      ad.i("MicroMsg.EmojiStatusView", "reload: " + ((EmojiInfo)localObject).JS());
      if ((this.fSU) && ((((EmojiInfo)localObject).getGroup() == EmojiGroupInfo.LBO) || (((EmojiInfo)localObject).getGroup() == EmojiInfo.LBV) || (((EmojiInfo)localObject).getGroup() == EmojiInfo.LBU)))
      {
        setStatusNotify(1);
        setImageBitmap(((EmojiInfo)localObject).z(getContext(), 300));
        AppMethodBeat.o(105800);
        return;
      }
      setStatusNotify(0);
      e locale = e.fLn;
      e.a((EmojiInfo)localObject, (BaseEmojiView)this, (i.a)this);
      AppMethodBeat.o(105800);
      return;
    }
    ad.i("MicroMsg.EmojiStatusView", "reload: emojiInfo is null");
    localObject = e.fLn;
    e.cv((View)this);
    AppMethodBeat.o(105800);
  }
  
  public void setEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105799);
    this.fLP = paramEmojiInfo;
    reload();
    AppMethodBeat.o(105799);
  }
  
  public final void setGameUseCover(boolean paramBoolean)
  {
    this.fSU = paramBoolean;
  }
  
  public final void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public final void setStatusListener(b paramb)
  {
    this.fTb = paramb;
  }
  
  public final void setStatusNotify(int paramInt)
  {
    AppMethodBeat.i(105801);
    this.status = paramInt;
    b localb = this.fTb;
    if (localb != null)
    {
      localb.lG(paramInt);
      AppMethodBeat.o(105801);
      return;
    }
    AppMethodBeat.o(105801);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/view/EmojiStatusView$Companion;", "", "()V", "StatusFail", "", "StatusLoading", "StatusSuccess", "plugin-emojisdk_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/view/EmojiStatusView$StatusListener;", "", "onStatus", "", "status", "", "plugin-emojisdk_release"})
  public static abstract interface b
  {
    public abstract void lG(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.view.EmojiStatusView
 * JD-Core Version:    0.7.0.1
 */