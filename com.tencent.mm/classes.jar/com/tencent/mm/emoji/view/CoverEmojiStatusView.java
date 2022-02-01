package com.tencent.mm.emoji.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/view/CoverEmojiStatusView;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "emojiInfo", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "gameUseCover", "", "getGameUseCover", "()Z", "setGameUseCover", "(Z)V", "status", "getStatus", "()I", "setStatus", "(I)V", "statusListener", "Lcom/tencent/mm/emoji/view/CoverEmojiStatusView$StatusListener;", "getStatusListener", "()Lcom/tencent/mm/emoji/view/CoverEmojiStatusView$StatusListener;", "setStatusListener", "(Lcom/tencent/mm/emoji/view/CoverEmojiStatusView$StatusListener;)V", "destroy", "", "onDetachedFromWindow", "onResult", "success", "reload", "setStatusNotify", "Companion", "StatusListener", "plugin-emojisdk_release"})
public class CoverEmojiStatusView
  extends BaseEmojiView
  implements i.a
{
  public static final a jPH;
  private EmojiInfo jHh;
  private CoverEmojiStatusView.b jPF;
  boolean jPG = true;
  private int status;
  
  static
  {
    AppMethodBeat.i(105793);
    jPH = new a((byte)0);
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
  
  public final void ep(boolean paramBoolean)
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
    return this.jHh;
  }
  
  public final boolean getGameUseCover()
  {
    return this.jPG;
  }
  
  public final int getStatus()
  {
    return this.status;
  }
  
  public final CoverEmojiStatusView.b getStatusListener()
  {
    return this.jPF;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(105792);
    Log.i("MicroMsg.CoverEmojiStatusView", "destroy: ".concat(String.valueOf(this)));
    e locale = e.jGI;
    e.cD((View)this);
    this.jPF = null;
    super.onDetachedFromWindow();
    AppMethodBeat.o(105792);
  }
  
  public void setEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105789);
    this.jHh = paramEmojiInfo;
    h.ZvG.be((Runnable)new c(this));
    AppMethodBeat.o(105789);
  }
  
  public final void setGameUseCover(boolean paramBoolean)
  {
    this.jPG = paramBoolean;
  }
  
  public final void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public final void setStatusListener(CoverEmojiStatusView.b paramb)
  {
    this.jPF = paramb;
  }
  
  public final void setStatusNotify(int paramInt)
  {
    AppMethodBeat.i(105790);
    this.status = paramInt;
    CoverEmojiStatusView.b localb = this.jPF;
    if (localb != null)
    {
      localb.rH(paramInt);
      AppMethodBeat.o(105790);
      return;
    }
    AppMethodBeat.o(105790);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/view/CoverEmojiStatusView$Companion;", "", "()V", "StatusFail", "", "StatusLoading", "StatusSuccess", "plugin-emojisdk_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(CoverEmojiStatusView paramCoverEmojiStatusView) {}
    
    public final void run()
    {
      AppMethodBeat.i(105788);
      CoverEmojiStatusView localCoverEmojiStatusView = this.jPI;
      Object localObject = localCoverEmojiStatusView.getEmojiInfo();
      if (localObject != null)
      {
        Log.i("MicroMsg.CoverEmojiStatusView", "reload: " + ((EmojiInfo)localObject).getMd5());
        if ((localCoverEmojiStatusView.jPG) && ((((EmojiInfo)localObject).hBy() == EmojiGroupInfo.YCv) || (((EmojiInfo)localObject).hBy() == EmojiInfo.YCC) || (((EmojiInfo)localObject).hBy() == EmojiInfo.YCB)))
        {
          localCoverEmojiStatusView.setStatusNotify(1);
          localCoverEmojiStatusView.setImageBitmap(((EmojiInfo)localObject).C(localCoverEmojiStatusView.getContext(), 300));
          AppMethodBeat.o(105788);
          return;
        }
        if (localCoverEmojiStatusView.getDrawable() == null) {
          localCoverEmojiStatusView.setStatusNotify(0);
        }
        e locale = e.jGI;
        e.a((EmojiInfo)localObject, (BaseEmojiView)localCoverEmojiStatusView, (i.a)localCoverEmojiStatusView);
        AppMethodBeat.o(105788);
        return;
      }
      Log.i("MicroMsg.CoverEmojiStatusView", "reload: emojiInfo is null");
      localObject = e.jGI;
      e.cD((View)localCoverEmojiStatusView);
      AppMethodBeat.o(105788);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.view.CoverEmojiStatusView
 * JD-Core Version:    0.7.0.1
 */