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
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/view/CoverEmojiStatusView;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "emojiInfo", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "gameUseCover", "", "getGameUseCover", "()Z", "setGameUseCover", "(Z)V", "status", "getStatus", "()I", "setStatus", "(I)V", "statusListener", "Lcom/tencent/mm/emoji/view/CoverEmojiStatusView$StatusListener;", "getStatusListener", "()Lcom/tencent/mm/emoji/view/CoverEmojiStatusView$StatusListener;", "setStatusListener", "(Lcom/tencent/mm/emoji/view/CoverEmojiStatusView$StatusListener;)V", "destroy", "", "onDetachedFromWindow", "onResult", "success", "reload", "setStatusNotify", "Companion", "StatusListener", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class CoverEmojiStatusView
  extends BaseEmojiView
  implements h.a
{
  public static final CoverEmojiStatusView.a mox;
  private EmojiInfo mgK;
  private CoverEmojiStatusView.b moy;
  private boolean moz = true;
  private int status;
  
  static
  {
    AppMethodBeat.i(105793);
    mox = new CoverEmojiStatusView.a((byte)0);
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
  
  private static final void a(CoverEmojiStatusView paramCoverEmojiStatusView)
  {
    AppMethodBeat.i(242518);
    s.u(paramCoverEmojiStatusView, "this$0");
    Object localObject = paramCoverEmojiStatusView.getEmojiInfo();
    if (localObject != null)
    {
      Log.i("MicroMsg.CoverEmojiStatusView", s.X("reload: ", ((EmojiInfo)localObject).getMd5()));
      if ((paramCoverEmojiStatusView.moz) && ((((EmojiInfo)localObject).field_catalog == EmojiGroupInfo.aklE) || (((EmojiInfo)localObject).field_catalog == EmojiInfo.aklL) || (((EmojiInfo)localObject).field_catalog == EmojiInfo.aklK)))
      {
        paramCoverEmojiStatusView.setStatusNotify(1);
        paramCoverEmojiStatusView.setImageBitmap(((EmojiInfo)localObject).F(paramCoverEmojiStatusView.getContext(), 300));
        AppMethodBeat.o(242518);
        return;
      }
      if (paramCoverEmojiStatusView.getDrawable() == null) {
        paramCoverEmojiStatusView.setStatusNotify(0);
      }
      e locale = e.mgl;
      e.a((EmojiInfo)localObject, (BaseEmojiView)paramCoverEmojiStatusView, (h.a)paramCoverEmojiStatusView);
      AppMethodBeat.o(242518);
      return;
    }
    Log.i("MicroMsg.CoverEmojiStatusView", "reload: emojiInfo is null");
    localObject = e.mgl;
    e.cX((View)paramCoverEmojiStatusView);
    AppMethodBeat.o(242518);
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
  
  public final CoverEmojiStatusView.b getStatusListener()
  {
    return this.moy;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(105792);
    Log.i("MicroMsg.CoverEmojiStatusView", s.X("destroy: ", this));
    e locale = e.mgl;
    e.cX((View)this);
    this.moy = null;
    super.onDetachedFromWindow();
    AppMethodBeat.o(105792);
  }
  
  public void onResult(boolean paramBoolean)
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
  
  public void setEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105789);
    this.mgK = paramEmojiInfo;
    h.ahAA.bm(new CoverEmojiStatusView..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(105789);
  }
  
  public final void setGameUseCover(boolean paramBoolean)
  {
    this.moz = paramBoolean;
  }
  
  public final void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public final void setStatusListener(CoverEmojiStatusView.b paramb)
  {
    this.moy = paramb;
  }
  
  public final void setStatusNotify(int paramInt)
  {
    AppMethodBeat.i(105790);
    this.status = paramInt;
    AppMethodBeat.o(105790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.view.CoverEmojiStatusView
 * JD-Core Version:    0.7.0.1
 */