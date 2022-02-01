package com.tencent.mm.emoji.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/view/CoverEmojiStatusView;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "emojiInfo", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "gameUseCover", "", "getGameUseCover", "()Z", "setGameUseCover", "(Z)V", "status", "getStatus", "()I", "setStatus", "(I)V", "statusListener", "Lcom/tencent/mm/emoji/view/CoverEmojiStatusView$StatusListener;", "getStatusListener", "()Lcom/tencent/mm/emoji/view/CoverEmojiStatusView$StatusListener;", "setStatusListener", "(Lcom/tencent/mm/emoji/view/CoverEmojiStatusView$StatusListener;)V", "destroy", "", "onDetachedFromWindow", "onResult", "success", "reload", "setStatusNotify", "Companion", "StatusListener", "plugin-emojisdk_release"})
public class CoverEmojiStatusView
  extends BaseEmojiView
  implements i.a
{
  public static final CoverEmojiStatusView.a heb;
  private EmojiInfo gWm;
  private b hdZ;
  boolean hea = true;
  private int status;
  
  static
  {
    AppMethodBeat.i(105793);
    heb = new CoverEmojiStatusView.a((byte)0);
    AppMethodBeat.o(105793);
  }
  
  public CoverEmojiStatusView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CoverEmojiStatusView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void dQ(boolean paramBoolean)
  {
    AppMethodBeat.i(105791);
    if (paramBoolean) {}
    for (int i = 1;; i = -1)
    {
      setStatusNotify(i);
      AppMethodBeat.o(105791);
      return;
    }
  }
  
  public EmojiInfo getEmojiInfo()
  {
    return this.gWm;
  }
  
  public final boolean getGameUseCover()
  {
    return this.hea;
  }
  
  public final int getStatus()
  {
    return this.status;
  }
  
  public final b getStatusListener()
  {
    return this.hdZ;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(105792);
    Log.i("MicroMsg.CoverEmojiStatusView", "destroy: ".concat(String.valueOf(this)));
    e locale = e.gVM;
    e.cl((View)this);
    this.hdZ = null;
    super.onDetachedFromWindow();
    AppMethodBeat.o(105792);
  }
  
  public void setEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105789);
    this.gWm = paramEmojiInfo;
    h.RTc.aX((Runnable)new c(this));
    AppMethodBeat.o(105789);
  }
  
  public final void setGameUseCover(boolean paramBoolean)
  {
    this.hea = paramBoolean;
  }
  
  public final void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public final void setStatusListener(b paramb)
  {
    this.hdZ = paramb;
  }
  
  public final void setStatusNotify(int paramInt)
  {
    AppMethodBeat.i(105790);
    this.status = paramInt;
    b localb = this.hdZ;
    if (localb != null)
    {
      localb.po(paramInt);
      AppMethodBeat.o(105790);
      return;
    }
    AppMethodBeat.o(105790);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/view/CoverEmojiStatusView$StatusListener;", "", "onStatus", "", "status", "", "plugin-emojisdk_release"})
  public static abstract interface b
  {
    public abstract void po(int paramInt);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(CoverEmojiStatusView paramCoverEmojiStatusView) {}
    
    public final void run()
    {
      AppMethodBeat.i(105788);
      CoverEmojiStatusView localCoverEmojiStatusView = this.hec;
      Object localObject = localCoverEmojiStatusView.getEmojiInfo();
      if (localObject != null)
      {
        Log.i("MicroMsg.CoverEmojiStatusView", "reload: " + ((EmojiInfo)localObject).getMd5());
        if ((localCoverEmojiStatusView.hea) && ((((EmojiInfo)localObject).getGroup() == EmojiGroupInfo.Uun) || (((EmojiInfo)localObject).getGroup() == EmojiInfo.Uuu) || (((EmojiInfo)localObject).getGroup() == EmojiInfo.Uut)))
        {
          localCoverEmojiStatusView.setStatusNotify(1);
          localCoverEmojiStatusView.setImageBitmap(((EmojiInfo)localObject).A(localCoverEmojiStatusView.getContext(), 300));
          AppMethodBeat.o(105788);
          return;
        }
        if (localCoverEmojiStatusView.getDrawable() == null) {
          localCoverEmojiStatusView.setStatusNotify(0);
        }
        e locale = e.gVM;
        e.a((EmojiInfo)localObject, (BaseEmojiView)localCoverEmojiStatusView, (i.a)localCoverEmojiStatusView);
        AppMethodBeat.o(105788);
        return;
      }
      Log.i("MicroMsg.CoverEmojiStatusView", "reload: emojiInfo is null");
      localObject = e.gVM;
      e.cl((View)localCoverEmojiStatusView);
      AppMethodBeat.o(105788);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.view.CoverEmojiStatusView
 * JD-Core Version:    0.7.0.1
 */