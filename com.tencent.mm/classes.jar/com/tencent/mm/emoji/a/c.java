package com.tencent.mm.emoji.a;

import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder;", "", "()V", "TAG", "", "animDrawable", "Lcom/tencent/mm/plugin/gif/MMWXGFDrawable;", "animStartTextColor", "", "animView", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "delayRecycle", "Ljava/lang/Runnable;", "isPlaying", "", "itemTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "msgId", "", "getMsgId", "()J", "setMsgId", "(J)V", "playingConfig", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimItem;", "reporter", "Lcom/tencent/mm/autogen/mmdata/rpt/AnimateEmojiReportStruct;", "getReporter", "()Lcom/tencent/mm/autogen/mmdata/rpt/AnimateEmojiReportStruct;", "setReporter", "(Lcom/tencent/mm/autogen/mmdata/rpt/AnimateEmojiReportStruct;)V", "rootView", "Landroid/widget/FrameLayout;", "getRootView", "()Landroid/widget/FrameLayout;", "setRootView", "(Landroid/widget/FrameLayout;)V", "screenEffectTask", "stateCallback", "Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder$AnimCallback;", "getStateCallback", "()Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder$AnimCallback;", "setStateCallback", "(Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder$AnimCallback;)V", "uiRefreshed", "afterAnim", "", "beforeAnim", "bindItemView", "textView", "recordTextView", "restore", "restoreTextView", "setPlayingConfig", "config", "filePath", "stop", "updateView", "centerX", "", "centerY", "size", "rootLocation", "", "AnimCallback", "plugin-emojisdk_release"})
public final class c
{
  final String TAG;
  FrameLayout gUY;
  MMAnimateView gUZ;
  MMNeat7extView gVa;
  h gVb;
  b.a gVc;
  boolean gVd;
  private boolean gVe;
  private int gVf;
  Runnable gVg;
  Runnable gVh;
  com.tencent.mm.g.b.a.l gVi;
  a gVj;
  public long msgId;
  
  public c()
  {
    AppMethodBeat.i(199883);
    this.TAG = "MicroMsg.EmojiAnimViewHolder";
    this.gVf = -16777216;
    this.gVg = ((Runnable)new c(this));
    this.gVh = ((Runnable)new b(this));
    AppMethodBeat.o(199883);
  }
  
  private final void aut()
  {
    AppMethodBeat.i(199882);
    MMNeat7extView localMMNeat7extView = this.gVa;
    if (localMMNeat7extView != null) {}
    for (int i = localMMNeat7extView.getCurrentTextColor();; i = 0)
    {
      if (i == 0)
      {
        localMMNeat7extView = this.gVa;
        if (localMMNeat7extView != null) {
          localMMNeat7extView.setTextColor(this.gVf);
        }
      }
      Log.i(this.TAG, "restoreTextView: " + this.gVa + ", " + i);
      AppMethodBeat.o(199882);
      return;
    }
  }
  
  public final boolean b(MMNeat7extView paramMMNeat7extView)
  {
    AppMethodBeat.i(199880);
    if ((p.j(this.gVa, paramMMNeat7extView) ^ true))
    {
      aut();
      this.gVa = paramMMNeat7extView;
      paramMMNeat7extView = this.gVa;
      if (paramMMNeat7extView == null) {
        break label132;
      }
    }
    label132:
    for (int i = paramMMNeat7extView.getCurrentTextColor();; i = this.gVf)
    {
      this.gVf = i;
      paramMMNeat7extView = this.gVa;
      if (paramMMNeat7extView != null) {
        paramMMNeat7extView.setTextColor(0);
      }
      Log.i(this.TAG, "recordTextView: " + this.gVa + ", color:" + this.gVf);
      if (this.gVa != null) {
        break label157;
      }
      if (!this.gVd) {
        break;
      }
      Log.i(this.TAG, "bindItemView: null");
      restore();
      AppMethodBeat.o(199880);
      return true;
    }
    if (!this.gVe) {
      d.a(200L, this.gVh);
    }
    label157:
    this.gVe = true;
    AppMethodBeat.o(199880);
    return false;
  }
  
  final void restore()
  {
    AppMethodBeat.i(199881);
    d.C(this.gVg);
    d.C(this.gVh);
    Object localObject = this.gVb;
    if (localObject != null) {
      ((h)localObject).recycle();
    }
    this.gVb = null;
    localObject = this.gUZ;
    if (localObject != null) {
      ((MMAnimateView)localObject).setVisibility(8);
    }
    localObject = this.gUZ;
    if (localObject != null)
    {
      localObject = ((MMAnimateView)localObject).animate();
      if (localObject != null) {
        ((ViewPropertyAnimator)localObject).cancel();
      }
    }
    localObject = this.gUZ;
    if (localObject != null) {
      ((MMAnimateView)localObject).setScaleX(1.0F);
    }
    localObject = this.gUZ;
    if (localObject != null) {
      ((MMAnimateView)localObject).setScaleY(1.0F);
    }
    aut();
    this.gVd = false;
    AppMethodBeat.o(199881);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(258532);
    Log.i(this.TAG, "stop: ");
    restore();
    AppMethodBeat.o(258532);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder$AnimCallback;", "", "onEnd", "", "onPlayScreenEffect", "msgId", "", "effect", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimScreenEffect;", "onRecycle", "holder", "Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder;", "played", "", "onScreenEffect", "onStart", "plugin-emojisdk_release"})
  public static abstract interface a
  {
    public abstract void a(long paramLong, b.b paramb);
    
    public abstract void a(b.b paramb);
    
    public abstract void a(c paramc);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(199875);
      if (!this.gVk.gVd)
      {
        Log.i(this.gVk.TAG, "delay: recycle");
        this.gVk.restore();
        c.a locala = this.gVk.gVj;
        if (locala != null)
        {
          locala.a(this.gVk);
          AppMethodBeat.o(199875);
          return;
        }
      }
      AppMethodBeat.o(199875);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(199876);
      Object localObject = this.gVk.gVc;
      if (localObject != null)
      {
        localObject = ((b.a)localObject).gUX;
        if (localObject != null)
        {
          c.a locala = this.gVk.gVj;
          if (locala != null)
          {
            locala.a(this.gVk.msgId, (b.b)localObject);
            AppMethodBeat.o(199876);
            return;
          }
          AppMethodBeat.o(199876);
          return;
        }
      }
      AppMethodBeat.o(199876);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/emoji/egg/EmojiAnimViewHolder$updateView$1$1"})
  static final class d
    implements Runnable
  {
    d(MMAnimateView paramMMAnimateView, c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(199879);
      h localh = this.gVk.gVb;
      if (localh != null) {
        localh.resume();
      }
      localh = this.gVk.gVb;
      if (localh != null)
      {
        localh.au((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(199878);
            h localh = this.gVm.gVk.gVb;
            if (localh != null) {
              localh.pause();
            }
            this.gVm.gVl.animate().scaleX(1.0F).scaleY(1.0F).setDuration(200L).withEndAction((Runnable)new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(199877);
                c localc = this.gVn.gVm.gVk;
                if (localc.gVd)
                {
                  Object localObject = localc.gVc;
                  if (localObject != null)
                  {
                    localObject = ((b.a)localObject).gUX;
                    if ((localObject != null) && (((b.b)localObject).delay == -1)) {
                      localc.gVg.run();
                    }
                  }
                  d.C(localc.gVg);
                  localc.restore();
                  localc.msgId = 0L;
                  localc.gVa = null;
                  localObject = localc.gVj;
                  if (localObject != null)
                  {
                    ((c.a)localObject).a(localc);
                    AppMethodBeat.o(199877);
                    return;
                  }
                }
                AppMethodBeat.o(199877);
              }
            });
            AppMethodBeat.o(199878);
          }
        });
        AppMethodBeat.o(199879);
        return;
      }
      AppMethodBeat.o(199879);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.a.c
 * JD-Core Version:    0.7.0.1
 */