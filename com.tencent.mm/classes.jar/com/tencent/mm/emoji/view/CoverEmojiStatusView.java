package com.tencent.mm.emoji.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/view/CoverEmojiStatusView;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "emojiInfo", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "gameUseCover", "", "getGameUseCover", "()Z", "setGameUseCover", "(Z)V", "status", "getStatus", "()I", "setStatus", "(I)V", "statusListener", "Lcom/tencent/mm/emoji/view/CoverEmojiStatusView$StatusListener;", "getStatusListener", "()Lcom/tencent/mm/emoji/view/CoverEmojiStatusView$StatusListener;", "setStatusListener", "(Lcom/tencent/mm/emoji/view/CoverEmojiStatusView$StatusListener;)V", "destroy", "", "onDetachedFromWindow", "onResult", "success", "reload", "setStatusNotify", "Companion", "StatusListener", "plugin-emojisdk_release"})
public class CoverEmojiStatusView
  extends BaseEmojiView
  implements i.a
{
  public static final a fSV;
  private EmojiInfo fLP;
  private b fST;
  boolean fSU = true;
  private int status;
  
  static
  {
    AppMethodBeat.i(105793);
    fSV = new a((byte)0);
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
  
  public final void df(boolean paramBoolean)
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
    return this.fST;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(105792);
    ad.i("MicroMsg.CoverEmojiStatusView", "destroy: ".concat(String.valueOf(this)));
    e locale = e.fLn;
    e.cv((View)this);
    this.fST = null;
    super.onDetachedFromWindow();
    AppMethodBeat.o(105792);
  }
  
  public void setEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105789);
    this.fLP = paramEmojiInfo;
    h.Iye.aP((Runnable)new c(this));
    AppMethodBeat.o(105789);
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
    this.fST = paramb;
  }
  
  public final void setStatusNotify(int paramInt)
  {
    AppMethodBeat.i(105790);
    this.status = paramInt;
    b localb = this.fST;
    if (localb != null)
    {
      localb.lG(paramInt);
      AppMethodBeat.o(105790);
      return;
    }
    AppMethodBeat.o(105790);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/view/CoverEmojiStatusView$Companion;", "", "()V", "StatusFail", "", "StatusLoading", "StatusSuccess", "plugin-emojisdk_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/view/CoverEmojiStatusView$StatusListener;", "", "onStatus", "", "status", "", "plugin-emojisdk_release"})
  public static abstract interface b
  {
    public abstract void lG(int paramInt);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(CoverEmojiStatusView paramCoverEmojiStatusView) {}
    
    public final void run()
    {
      AppMethodBeat.i(105788);
      CoverEmojiStatusView localCoverEmojiStatusView = this.fSW;
      Object localObject = localCoverEmojiStatusView.getEmojiInfo();
      if (localObject != null)
      {
        ad.i("MicroMsg.CoverEmojiStatusView", "reload: " + ((EmojiInfo)localObject).JS());
        if ((localCoverEmojiStatusView.fSU) && ((((EmojiInfo)localObject).getGroup() == EmojiGroupInfo.LBO) || (((EmojiInfo)localObject).getGroup() == EmojiInfo.LBV) || (((EmojiInfo)localObject).getGroup() == EmojiInfo.LBU)))
        {
          localCoverEmojiStatusView.setStatusNotify(1);
          localCoverEmojiStatusView.setImageBitmap(((EmojiInfo)localObject).z(localCoverEmojiStatusView.getContext(), 300));
          AppMethodBeat.o(105788);
          return;
        }
        if (localCoverEmojiStatusView.getDrawable() == null) {
          localCoverEmojiStatusView.setStatusNotify(0);
        }
        e locale = e.fLn;
        e.a((EmojiInfo)localObject, (BaseEmojiView)localCoverEmojiStatusView, (i.a)localCoverEmojiStatusView);
        AppMethodBeat.o(105788);
        return;
      }
      ad.i("MicroMsg.CoverEmojiStatusView", "reload: emojiInfo is null");
      localObject = e.fLn;
      e.cv((View)localCoverEmojiStatusView);
      AppMethodBeat.o(105788);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.view.CoverEmojiStatusView
 * JD-Core Version:    0.7.0.1
 */