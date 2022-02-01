package com.tencent.mm.emoji.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/view/CoverEmojiStatusView;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "emojiInfo", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "gameUseCover", "", "getGameUseCover", "()Z", "setGameUseCover", "(Z)V", "status", "getStatus", "()I", "setStatus", "(I)V", "statusListener", "Lcom/tencent/mm/emoji/view/CoverEmojiStatusView$StatusListener;", "getStatusListener", "()Lcom/tencent/mm/emoji/view/CoverEmojiStatusView$StatusListener;", "setStatusListener", "(Lcom/tencent/mm/emoji/view/CoverEmojiStatusView$StatusListener;)V", "destroy", "", "onDetachedFromWindow", "onResult", "success", "reload", "setStatusNotify", "Companion", "StatusListener", "plugin-emojisdk_release"})
public class CoverEmojiStatusView
  extends BaseEmojiView
  implements i.a
{
  public static final CoverEmojiStatusView.a fWQ;
  private EmojiInfo fPB;
  private b fWO;
  boolean fWP = true;
  private int status;
  
  static
  {
    AppMethodBeat.i(105793);
    fWQ = new CoverEmojiStatusView.a((byte)0);
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
  
  public final void de(boolean paramBoolean)
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
    return this.fPB;
  }
  
  public final boolean getGameUseCover()
  {
    return this.fWP;
  }
  
  public final int getStatus()
  {
    return this.status;
  }
  
  public final b getStatusListener()
  {
    return this.fWO;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(105792);
    ac.i("MicroMsg.CoverEmojiStatusView", "destroy: ".concat(String.valueOf(this)));
    e locale = e.fOZ;
    e.cv((View)this);
    this.fWO = null;
    super.onDetachedFromWindow();
    AppMethodBeat.o(105792);
  }
  
  public void setEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105789);
    this.fPB = paramEmojiInfo;
    h.JZN.aS((Runnable)new c(this));
    AppMethodBeat.o(105789);
  }
  
  public final void setGameUseCover(boolean paramBoolean)
  {
    this.fWP = paramBoolean;
  }
  
  public final void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public final void setStatusListener(b paramb)
  {
    this.fWO = paramb;
  }
  
  public final void setStatusNotify(int paramInt)
  {
    AppMethodBeat.i(105790);
    this.status = paramInt;
    b localb = this.fWO;
    if (localb != null)
    {
      localb.lD(paramInt);
      AppMethodBeat.o(105790);
      return;
    }
    AppMethodBeat.o(105790);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/view/CoverEmojiStatusView$StatusListener;", "", "onStatus", "", "status", "", "plugin-emojisdk_release"})
  public static abstract interface b
  {
    public abstract void lD(int paramInt);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(CoverEmojiStatusView paramCoverEmojiStatusView) {}
    
    public final void run()
    {
      AppMethodBeat.i(105788);
      CoverEmojiStatusView localCoverEmojiStatusView = this.fWR;
      Object localObject = localCoverEmojiStatusView.getEmojiInfo();
      if (localObject != null)
      {
        ac.i("MicroMsg.CoverEmojiStatusView", "reload: " + ((EmojiInfo)localObject).JC());
        if ((localCoverEmojiStatusView.fWP) && ((((EmojiInfo)localObject).getGroup() == EmojiGroupInfo.Jsq) || (((EmojiInfo)localObject).getGroup() == EmojiInfo.Jsx) || (((EmojiInfo)localObject).getGroup() == EmojiInfo.Jsw)))
        {
          localCoverEmojiStatusView.setStatusNotify(1);
          localCoverEmojiStatusView.setImageBitmap(((EmojiInfo)localObject).z(localCoverEmojiStatusView.getContext(), 300));
          AppMethodBeat.o(105788);
          return;
        }
        if (localCoverEmojiStatusView.getDrawable() == null) {
          localCoverEmojiStatusView.setStatusNotify(0);
        }
        e locale = e.fOZ;
        e.a((EmojiInfo)localObject, (BaseEmojiView)localCoverEmojiStatusView, (i.a)localCoverEmojiStatusView);
        AppMethodBeat.o(105788);
        return;
      }
      ac.i("MicroMsg.CoverEmojiStatusView", "reload: emojiInfo is null");
      localObject = e.fOZ;
      e.cv((View)localCoverEmojiStatusView);
      AppMethodBeat.o(105788);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.view.CoverEmojiStatusView
 * JD-Core Version:    0.7.0.1
 */