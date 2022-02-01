package com.tencent.mm.emoji.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/view/EmojiStatusView;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "emojiInfo", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "gameUseCover", "", "getGameUseCover", "()Z", "setGameUseCover", "(Z)V", "status", "getStatus", "()I", "setStatus", "(I)V", "statusListener", "Lcom/tencent/mm/emoji/view/EmojiStatusView$StatusListener;", "getStatusListener", "()Lcom/tencent/mm/emoji/view/EmojiStatusView$StatusListener;", "setStatusListener", "(Lcom/tencent/mm/emoji/view/EmojiStatusView$StatusListener;)V", "destroy", "", "onDetachedFromWindow", "onResult", "success", "reload", "setStatusNotify", "Companion", "StatusListener", "plugin-emojisdk_release"})
public class EmojiStatusView
  extends BaseEmojiView
  implements i.a
{
  public static final EmojiStatusView.a gsY;
  private EmojiInfo glt;
  private boolean gsQ = true;
  private b gsX;
  private int status;
  
  static
  {
    AppMethodBeat.i(105804);
    gsY = new EmojiStatusView.a((byte)0);
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
  
  public final void dg(boolean paramBoolean)
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
    return this.glt;
  }
  
  public final boolean getGameUseCover()
  {
    return this.gsQ;
  }
  
  public final int getStatus()
  {
    return this.status;
  }
  
  public final b getStatusListener()
  {
    return this.gsX;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(105803);
    ae.i("MicroMsg.EmojiStatusView", "destroy: ".concat(String.valueOf(this)));
    e locale = e.gkR;
    e.cv((View)this);
    this.gsX = null;
    super.onDetachedFromWindow();
    AppMethodBeat.o(105803);
  }
  
  public void reload()
  {
    AppMethodBeat.i(105800);
    Object localObject = getEmojiInfo();
    if (localObject != null)
    {
      ae.i("MicroMsg.EmojiStatusView", "reload: " + ((EmojiInfo)localObject).Lj());
      if ((this.gsQ) && ((((EmojiInfo)localObject).getGroup() == EmojiGroupInfo.OzS) || (((EmojiInfo)localObject).getGroup() == EmojiInfo.OzZ) || (((EmojiInfo)localObject).getGroup() == EmojiInfo.OzY)))
      {
        setStatusNotify(1);
        setImageBitmap(((EmojiInfo)localObject).z(getContext(), 300));
        AppMethodBeat.o(105800);
        return;
      }
      setStatusNotify(0);
      e locale = e.gkR;
      e.a((EmojiInfo)localObject, (BaseEmojiView)this, (i.a)this);
      AppMethodBeat.o(105800);
      return;
    }
    ae.i("MicroMsg.EmojiStatusView", "reload: emojiInfo is null");
    localObject = e.gkR;
    e.cv((View)this);
    AppMethodBeat.o(105800);
  }
  
  public void setEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105799);
    this.glt = paramEmojiInfo;
    reload();
    AppMethodBeat.o(105799);
  }
  
  public final void setGameUseCover(boolean paramBoolean)
  {
    this.gsQ = paramBoolean;
  }
  
  public final void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public final void setStatusListener(b paramb)
  {
    this.gsX = paramb;
  }
  
  public final void setStatusNotify(int paramInt)
  {
    AppMethodBeat.i(105801);
    this.status = paramInt;
    b localb = this.gsX;
    if (localb != null)
    {
      localb.mg(paramInt);
      AppMethodBeat.o(105801);
      return;
    }
    AppMethodBeat.o(105801);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/view/EmojiStatusView$StatusListener;", "", "onStatus", "", "status", "", "plugin-emojisdk_release"})
  public static abstract interface b
  {
    public abstract void mg(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.view.EmojiStatusView
 * JD-Core Version:    0.7.0.1
 */