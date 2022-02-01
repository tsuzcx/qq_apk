package com.tencent.mm.emoji.a;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.cl.e;
import com.tencent.mm.f.b.a.o;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder;", "", "()V", "TAG", "", "animDrawable", "Lcom/tencent/mm/plugin/gif/MMWXGFDrawable;", "animKey", "getAnimKey", "()Ljava/lang/String;", "setAnimKey", "(Ljava/lang/String;)V", "animStartTextColor", "", "animView", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "delayRecycle", "Ljava/lang/Runnable;", "emojiRect", "Landroid/graphics/RectF;", "isPlaying", "", "itemEmojiSpan", "Lcom/tencent/mm/smiley/EmojiSpan;", "itemTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "msgId", "", "getMsgId", "()J", "setMsgId", "(J)V", "msgPatIndex", "getMsgPatIndex", "()I", "setMsgPatIndex", "(I)V", "msgType", "getMsgType", "setMsgType", "playingConfig", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimItem;", "reporter", "Lcom/tencent/mm/autogen/mmdata/rpt/AnimateEmojiReportStruct;", "getReporter", "()Lcom/tencent/mm/autogen/mmdata/rpt/AnimateEmojiReportStruct;", "setReporter", "(Lcom/tencent/mm/autogen/mmdata/rpt/AnimateEmojiReportStruct;)V", "rootView", "Landroid/widget/FrameLayout;", "getRootView", "()Landroid/widget/FrameLayout;", "setRootView", "(Landroid/widget/FrameLayout;)V", "screenEffectTask", "stateCallback", "Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder$AnimCallback;", "getStateCallback", "()Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder$AnimCallback;", "setStateCallback", "(Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder$AnimCallback;)V", "uiRefreshed", "afterAnim", "", "beforeAnim", "bindItemView", "textView", "recordTextView", "restore", "restoreTextView", "setPlayingConfig", "config", "filePath", "stop", "updateView", "centerX", "", "centerY", "size", "rootLocation", "", "AnimCallback", "plugin-emojisdk_release"})
public final class c
{
  final String TAG;
  boolean fGh;
  String jFO;
  int jFP;
  FrameLayout jFQ;
  private MMAnimateView jFR;
  MMNeat7extView jFS;
  private e jFT;
  h jFU;
  final RectF jFV;
  b.a jFW;
  private boolean jFX;
  private int jFY;
  Runnable jFZ;
  private Runnable jGa;
  o jGb;
  a jGc;
  public long msgId;
  int msgType;
  
  public c()
  {
    AppMethodBeat.i(225501);
    this.TAG = "MicroMsg.EmojiAnimViewHolder";
    this.jFO = "";
    this.jFV = new RectF();
    this.jFY = -16777216;
    this.jFZ = ((Runnable)new c(this));
    this.jGa = ((Runnable)new b(this));
    AppMethodBeat.o(225501);
  }
  
  private final void aBm()
  {
    Object localObject3 = null;
    AppMethodBeat.i(225496);
    if ((this.msgType == 889192497) || (this.msgType == 922746929))
    {
      Log.i(this.TAG, "recordTextView: skip pat msg");
      localObject1 = this.jFS;
      Object localObject2;
      int j;
      if (localObject1 != null)
      {
        localObject1 = ((MMNeat7extView)localObject1).ikC();
        localObject2 = localObject1;
        if (!(localObject1 instanceof Spannable)) {
          localObject2 = null;
        }
        localObject1 = (Spannable)localObject2;
        if (localObject1 != null)
        {
          localObject2 = (e[])((Spannable)localObject1).getSpans(0, ((Spannable)localObject1).length(), e.class);
          p.j(localObject2, "emojiList");
          j = localObject2.length;
          i = 0;
        }
      }
      else
      {
        for (;;)
        {
          localObject1 = localObject3;
          if (i < j)
          {
            localObject1 = localObject2[i];
            if (!((e)localObject1).UYu) {}
          }
          else
          {
            if (localObject1 == null) {
              break label185;
            }
            this.jFT = ((e)localObject1);
            localObject1 = this.jFT;
            if (localObject1 != null) {
              ((e)localObject1).setAlpha(0.0F);
            }
            localObject1 = this.jFS;
            if (localObject1 == null) {
              break label179;
            }
            ((MMNeat7extView)localObject1).invalidate();
            AppMethodBeat.o(225496);
            return;
            localObject1 = null;
            break;
          }
          i += 1;
        }
        label179:
        AppMethodBeat.o(225496);
        return;
      }
      label185:
      AppMethodBeat.o(225496);
      return;
    }
    Object localObject1 = this.jFS;
    if (localObject1 != null) {}
    for (int i = ((MMNeat7extView)localObject1).getCurrentTextColor();; i = this.jFY)
    {
      this.jFY = i;
      localObject1 = this.jFS;
      if (localObject1 != null) {
        ((MMNeat7extView)localObject1).setTextColor(0);
      }
      Log.i(this.TAG, "recordTextView: " + this.jFS + ", color:" + this.jFY);
      AppMethodBeat.o(225496);
      return;
    }
  }
  
  private final void aBn()
  {
    AppMethodBeat.i(225499);
    if ((this.msgType == 889192497) || (this.msgType == 922746929))
    {
      Log.i(this.TAG, "recordTextView: skip pat msg");
      localObject = this.jFT;
      if (localObject != null) {
        ((e)localObject).setAlpha(1.0F);
      }
      localObject = this.jFS;
      if (localObject != null)
      {
        ((MMNeat7extView)localObject).invalidate();
        AppMethodBeat.o(225499);
        return;
      }
      AppMethodBeat.o(225499);
      return;
    }
    Object localObject = this.jFS;
    if (localObject != null) {}
    for (int i = ((MMNeat7extView)localObject).getCurrentTextColor();; i = 0)
    {
      if (i == 0)
      {
        localObject = this.jFS;
        if (localObject != null) {
          ((MMNeat7extView)localObject).setTextColor(this.jFY);
        }
      }
      Log.i(this.TAG, "restoreTextView: " + this.jFS + ", " + i);
      AppMethodBeat.o(225499);
      return;
    }
  }
  
  public final void LD(String paramString)
  {
    AppMethodBeat.i(225460);
    p.k(paramString, "<set-?>");
    this.jFO = paramString;
    AppMethodBeat.o(225460);
  }
  
  public final boolean b(MMNeat7extView paramMMNeat7extView)
  {
    AppMethodBeat.i(225466);
    Log.d(this.TAG, "bindItemView: " + this.msgId + ", " + paramMMNeat7extView);
    if ((p.h(this.jFS, paramMMNeat7extView) ^ true))
    {
      aBn();
      this.jFS = paramMMNeat7extView;
      aBm();
    }
    if (this.jFS == null)
    {
      if (this.fGh)
      {
        Log.i(this.TAG, "bindItemView: null");
        restore();
        AppMethodBeat.o(225466);
        return true;
      }
      if (!this.jFX) {
        d.a(200L, this.jGa);
      }
    }
    this.jFX = true;
    AppMethodBeat.o(225466);
    return false;
  }
  
  public final void c(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(225480);
    if (this.jFU == null)
    {
      Log.i(this.TAG, "updateView: no drawable");
      AppMethodBeat.o(225480);
      return;
    }
    if (this.jFQ == null)
    {
      Log.i(this.TAG, "updateView: no rootView");
      AppMethodBeat.o(225480);
      return;
    }
    Log.d(this.TAG, "updateView: " + paramFloat1 + ", " + paramFloat2 + ", " + paramInt + ", " + this.fGh);
    if (this.jFR == null)
    {
      localObject = this.jFQ;
      if (localObject == null) {
        break label547;
      }
      localObject = ((FrameLayout)localObject).getContext();
      this.jFR = new MMAnimateView((Context)localObject);
      localObject = this.jFQ;
      if (localObject != null) {
        ((FrameLayout)localObject).addView((View)this.jFR, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(paramInt, paramInt));
      }
      localObject = this.jFR;
      if (localObject != null) {
        ((MMAnimateView)localObject).setVisibility(8);
      }
    }
    Object localObject = this.jFR;
    label217:
    MMAnimateView localMMAnimateView;
    if (localObject != null)
    {
      localObject = ((MMAnimateView)localObject).getLayoutParams();
      localObject = (FrameLayout.LayoutParams)localObject;
      if (localObject != null) {
        break label559;
      }
      localObject = new FrameLayout.LayoutParams(paramInt, paramInt);
      localMMAnimateView = this.jFR;
      if (localMMAnimateView != null) {
        localMMAnimateView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    for (;;)
    {
      localObject = this.jFR;
      if (localObject != null) {
        ((MMAnimateView)localObject).setTranslationX(paramFloat1 - paramInt / 2);
      }
      localObject = this.jFR;
      if (localObject != null) {
        ((MMAnimateView)localObject).setTranslationY(paramFloat2 - paramInt / 2);
      }
      if (this.fGh) {
        break label613;
      }
      localObject = this.jGb;
      if (localObject != null) {
        ((o)localObject).bpa();
      }
      localObject = this.jFQ;
      if ((localObject != null) && (((FrameLayout)localObject).getVisibility() == 8))
      {
        localObject = this.jFQ;
        if (localObject != null) {
          ((FrameLayout)localObject).setVisibility(0);
        }
      }
      localObject = this.jFR;
      if ((localObject != null) && (((MMAnimateView)localObject).getVisibility() == 8))
      {
        localObject = this.jFR;
        if (localObject != null) {
          ((MMAnimateView)localObject).setVisibility(0);
        }
      }
      localObject = this.jFR;
      if (localObject != null) {
        ((MMAnimateView)localObject).setImageDrawable((Drawable)this.jFU);
      }
      d.C(this.jFZ);
      localObject = this.jFW;
      if (localObject != null)
      {
        localObject = ((b.a)localObject).jFN;
        if ((localObject != null) && (((b.b)localObject).fJe >= 0)) {
          d.a(((b.b)localObject).fJe, this.jFZ);
        }
      }
      this.fGh = true;
      d.C(this.jGa);
      localObject = this.jFR;
      if (localObject == null) {
        break label613;
      }
      ((MMAnimateView)localObject).animate().scaleX(1.5F).scaleY(1.5F).setDuration(0L).withEndAction((Runnable)new d((MMAnimateView)localObject, this));
      AppMethodBeat.o(225480);
      return;
      label547:
      localObject = null;
      break;
      localObject = null;
      break label217;
      label559:
      if ((((FrameLayout.LayoutParams)localObject).width != paramInt) || (((FrameLayout.LayoutParams)localObject).height != paramInt))
      {
        ((FrameLayout.LayoutParams)localObject).width = paramInt;
        ((FrameLayout.LayoutParams)localObject).height = paramInt;
        localMMAnimateView = this.jFR;
        if (localMMAnimateView != null) {
          localMMAnimateView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
    label613:
    AppMethodBeat.o(225480);
  }
  
  final void restore()
  {
    AppMethodBeat.i(225488);
    d.C(this.jFZ);
    d.C(this.jGa);
    Object localObject = this.jFU;
    if (localObject != null) {
      ((h)localObject).recycle();
    }
    this.jFU = null;
    localObject = this.jFR;
    if (localObject != null) {
      ((MMAnimateView)localObject).setVisibility(8);
    }
    localObject = this.jFR;
    if (localObject != null)
    {
      localObject = ((MMAnimateView)localObject).animate();
      if (localObject != null) {
        ((ViewPropertyAnimator)localObject).cancel();
      }
    }
    localObject = this.jFR;
    if (localObject != null) {
      ((MMAnimateView)localObject).setScaleX(1.0F);
    }
    localObject = this.jFR;
    if (localObject != null) {
      ((MMAnimateView)localObject).setScaleY(1.0F);
    }
    aBn();
    this.fGh = false;
    AppMethodBeat.o(225488);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(225481);
    Log.i(this.TAG, "stop: ");
    restore();
    AppMethodBeat.o(225481);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder$AnimCallback;", "", "onEnd", "", "onPlayScreenEffect", "msgId", "", "animKey", "", "config", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimItem;", "onRecycle", "holder", "Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder;", "played", "", "onScreenEffect", "onStart", "plugin-emojisdk_release"})
  public static abstract interface a
  {
    public abstract void a(long paramLong, String paramString, b.a parama);
    
    public abstract void a(c paramc);
    
    public abstract void a(String paramString, b.a parama);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(231455);
      if (!this.jGd.fGh)
      {
        Log.i(this.jGd.TAG, "delay: recycle");
        this.jGd.restore();
        c.a locala = this.jGd.jGc;
        if (locala != null)
        {
          locala.a(this.jGd);
          AppMethodBeat.o(231455);
          return;
        }
      }
      AppMethodBeat.o(231455);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(227487);
      b.a locala = this.jGd.jFW;
      if (locala != null)
      {
        if (locala.jFN != null)
        {
          c.a locala1 = this.jGd.jGc;
          if (locala1 != null)
          {
            locala1.a(this.jGd.msgId, this.jGd.jFO, locala);
            AppMethodBeat.o(227487);
            return;
          }
        }
        AppMethodBeat.o(227487);
        return;
      }
      AppMethodBeat.o(227487);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/emoji/egg/EmojiAnimViewHolder$updateView$2$1"})
  static final class d
    implements Runnable
  {
    d(MMAnimateView paramMMAnimateView, c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(226518);
      h localh = jdField_this.jFU;
      if (localh != null) {
        localh.resume();
      }
      localh = jdField_this.jFU;
      if (localh != null)
      {
        localh.az((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(229367);
            h localh = this.jGf.jGd.jFU;
            if (localh != null) {
              localh.pause();
            }
            this.jGf.jGe.animate().scaleX(1.0F).scaleY(1.0F).setDuration(200L).withEndAction((Runnable)new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(230637);
                c localc = this.jGg.jGf.jGd;
                if (localc.fGh)
                {
                  Object localObject = localc.jFW;
                  if (localObject != null)
                  {
                    localObject = ((b.a)localObject).jFN;
                    if ((localObject != null) && (((b.b)localObject).fJe == -1)) {
                      localc.jFZ.run();
                    }
                  }
                  d.C(localc.jFZ);
                  localc.restore();
                  localc.msgId = 0L;
                  localc.jFS = null;
                  localObject = localc.jGc;
                  if (localObject != null)
                  {
                    ((c.a)localObject).a(localc);
                    AppMethodBeat.o(230637);
                    return;
                  }
                }
                AppMethodBeat.o(230637);
              }
            });
            AppMethodBeat.o(229367);
          }
        });
        AppMethodBeat.o(226518);
        return;
      }
      AppMethodBeat.o(226518);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(c paramc, MMNeat7extView paramMMNeat7extView, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(228634);
      Object localObject = a.jFJ;
      localObject = a.a.a(this.jGh);
      this.jGd.jFV.set((RectF)localObject);
      this.jGd.c(((RectF)localObject).centerX() + this.jGi + this.jGh.getPaddingLeft(), ((RectF)localObject).centerY() + this.jGj + this.jGh.getPaddingTop(), (int)((RectF)localObject).width());
      AppMethodBeat.o(228634);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.c
 * JD-Core Version:    0.7.0.1
 */