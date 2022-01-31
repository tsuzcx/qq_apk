package com.tencent.mm.emoji.view;

import a.l;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.a;
import com.tencent.mm.emoji.loader.d.h.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/view/EmojiStatusView;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "emojiInfo", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "status", "getStatus", "()I", "setStatus", "(I)V", "statusListener", "Lcom/tencent/mm/emoji/view/EmojiStatusView$StatusListener;", "getStatusListener", "()Lcom/tencent/mm/emoji/view/EmojiStatusView$StatusListener;", "setStatusListener", "(Lcom/tencent/mm/emoji/view/EmojiStatusView$StatusListener;)V", "destroy", "", "onDetachedFromWindow", "onResult", "success", "", "reload", "setStatusNotify", "Companion", "StatusListener", "plugin-emojisdk_release"})
public class EmojiStatusView
  extends BaseEmojiView
  implements h.a
{
  public static final EmojiStatusView.a eyw;
  private EmojiInfo evH;
  private EmojiStatusView.b eyv;
  private int status;
  
  static
  {
    AppMethodBeat.i(63316);
    eyw = new EmojiStatusView.a((byte)0);
    AppMethodBeat.o(63316);
  }
  
  public EmojiStatusView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EmojiStatusView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void cd(boolean paramBoolean)
  {
    AppMethodBeat.i(63314);
    if (paramBoolean) {}
    for (int i = 1;; i = -1)
    {
      setStatusNotify(i);
      AppMethodBeat.o(63314);
      return;
    }
  }
  
  public EmojiInfo getEmojiInfo()
  {
    return this.evH;
  }
  
  public final int getStatus()
  {
    return this.status;
  }
  
  public final EmojiStatusView.b getStatusListener()
  {
    return this.eyv;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(63315);
    ab.i("MicroMsg.EmojiStatusView", "destroy: ".concat(String.valueOf(this)));
    a locala = a.evk;
    a.ck((View)this);
    this.eyv = null;
    super.onDetachedFromWindow();
    AppMethodBeat.o(63315);
  }
  
  public void reload()
  {
    AppMethodBeat.i(63312);
    Object localObject = getEmojiInfo();
    if (localObject != null)
    {
      ab.i("MicroMsg.EmojiStatusView", "reload: " + ((EmojiInfo)localObject).Al());
      setStatusNotify(0);
      a locala = a.evk;
      a.a((EmojiInfo)localObject, (BaseEmojiView)this, (h.a)this);
      AppMethodBeat.o(63312);
      return;
    }
    ab.i("MicroMsg.EmojiStatusView", "reload: emojiInfo is null");
    localObject = a.evk;
    a.ck((View)this);
    AppMethodBeat.o(63312);
  }
  
  public void setEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(63311);
    this.evH = paramEmojiInfo;
    reload();
    AppMethodBeat.o(63311);
  }
  
  public final void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public final void setStatusListener(EmojiStatusView.b paramb)
  {
    this.eyv = paramb;
  }
  
  public final void setStatusNotify(int paramInt)
  {
    AppMethodBeat.i(63313);
    this.status = paramInt;
    EmojiStatusView.b localb = this.eyv;
    if (localb != null)
    {
      localb.jj(paramInt);
      AppMethodBeat.o(63313);
      return;
    }
    AppMethodBeat.o(63313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.view.EmojiStatusView
 * JD-Core Version:    0.7.0.1
 */