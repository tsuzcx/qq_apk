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
import com.tencent.mm.autogen.mmdata.rpt.q;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.smiley.k;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder;", "", "()V", "TAG", "", "animDrawable", "Lcom/tencent/mm/plugin/gif/MMWXGFDrawable;", "animKey", "getAnimKey", "()Ljava/lang/String;", "setAnimKey", "(Ljava/lang/String;)V", "animStartTextColor", "", "animView", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "delayRecycle", "Ljava/lang/Runnable;", "emojiRect", "Landroid/graphics/RectF;", "isPlaying", "", "itemEmojiSpan", "Lcom/tencent/mm/smiley/EmojiSpan;", "itemTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "msgId", "", "getMsgId", "()J", "setMsgId", "(J)V", "msgPatIndex", "getMsgPatIndex", "()I", "setMsgPatIndex", "(I)V", "msgType", "getMsgType", "setMsgType", "playingConfig", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimItem;", "reporter", "Lcom/tencent/mm/autogen/mmdata/rpt/AnimateEmojiReportStruct;", "getReporter", "()Lcom/tencent/mm/autogen/mmdata/rpt/AnimateEmojiReportStruct;", "setReporter", "(Lcom/tencent/mm/autogen/mmdata/rpt/AnimateEmojiReportStruct;)V", "rootView", "Landroid/widget/FrameLayout;", "getRootView", "()Landroid/widget/FrameLayout;", "setRootView", "(Landroid/widget/FrameLayout;)V", "screenEffectTask", "stateCallback", "Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder$AnimCallback;", "getStateCallback", "()Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder$AnimCallback;", "setStateCallback", "(Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder$AnimCallback;)V", "uiRefreshed", "afterAnim", "", "beforeAnim", "bindItemView", "textView", "recordTextView", "restore", "restoreTextView", "setPlayingConfig", "config", "filePath", "stop", "updateView", "centerX", "", "centerY", "size", "rootLocation", "", "AnimCallback", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  final String TAG;
  private boolean hLy;
  String mfC;
  int mfD;
  FrameLayout mfE;
  private MMAnimateView mfF;
  private MMNeat7extView mfG;
  private k mfH;
  h mfI;
  private final RectF mfJ;
  b.a mfK;
  private boolean mfL;
  private int mfM;
  private Runnable mfN;
  private Runnable mfO;
  q mfP;
  a mfQ;
  public long msgId;
  int msgType;
  
  public c()
  {
    AppMethodBeat.i(242310);
    this.TAG = "MicroMsg.EmojiAnimViewHolder";
    this.mfC = "";
    this.mfJ = new RectF();
    this.mfM = -16777216;
    this.mfN = new c..ExternalSyntheticLambda0(this);
    this.mfO = new c..ExternalSyntheticLambda1(this);
    AppMethodBeat.o(242310);
  }
  
  private static final void a(c paramc)
  {
    AppMethodBeat.i(242346);
    s.u(paramc, "this$0");
    b.a locala = paramc.mfK;
    if ((locala != null) && (locala.mfA != null))
    {
      a locala1 = paramc.mfQ;
      if (locala1 != null) {
        locala1.a(paramc.msgId, paramc.mfC, locala);
      }
    }
    AppMethodBeat.o(242346);
  }
  
  private static final void a(c paramc, MMAnimateView paramMMAnimateView)
  {
    AppMethodBeat.i(242368);
    s.u(paramc, "this$0");
    s.u(paramMMAnimateView, "$it");
    h localh = paramc.mfI;
    if (localh != null) {
      localh.mIsRunning = false;
    }
    paramMMAnimateView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(200L).withEndAction(new c..ExternalSyntheticLambda2(paramc));
    AppMethodBeat.o(242368);
  }
  
  private static final void a(MMNeat7extView paramMMNeat7extView, c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242360);
    s.u(paramc, "this$0");
    Object localObject = a.mfw;
    localObject = a.a.a(paramMMNeat7extView);
    paramc.mfJ.set((RectF)localObject);
    paramc.c(((RectF)localObject).centerX() + paramInt1 + paramMMNeat7extView.getPaddingLeft(), ((RectF)localObject).centerY() + paramInt2 + paramMMNeat7extView.getPaddingTop(), (int)((RectF)localObject).width());
    AppMethodBeat.o(242360);
  }
  
  private final void aUj()
  {
    int j = 1;
    AppMethodBeat.i(242324);
    Object localObject = this.mfP;
    if (localObject != null) {
      ((q)localObject).bMH();
    }
    localObject = this.mfE;
    if ((localObject != null) && (((FrameLayout)localObject).getVisibility() == 8))
    {
      i = 1;
      if (i != 0)
      {
        localObject = this.mfE;
        if (localObject != null) {
          ((FrameLayout)localObject).setVisibility(0);
        }
      }
      localObject = this.mfF;
      if ((localObject == null) || (((MMAnimateView)localObject).getVisibility() != 8)) {
        break label174;
      }
    }
    label174:
    for (int i = j;; i = 0)
    {
      if (i != 0)
      {
        localObject = this.mfF;
        if (localObject != null) {
          ((MMAnimateView)localObject).setVisibility(0);
        }
      }
      localObject = this.mfF;
      if (localObject != null) {
        ((MMAnimateView)localObject).setImageDrawable((Drawable)this.mfI);
      }
      d.H(this.mfN);
      localObject = this.mfK;
      if (localObject != null)
      {
        localObject = ((b.a)localObject).mfA;
        if ((localObject != null) && (((b.b)localObject).UZ >= 0)) {
          d.a(((b.b)localObject).UZ, this.mfN);
        }
      }
      AppMethodBeat.o(242324);
      return;
      i = 0;
      break;
    }
  }
  
  private final void aUk()
  {
    Object localObject = null;
    MMNeat7extView localMMNeat7extView = null;
    AppMethodBeat.i(242337);
    if ((this.msgType == 889192497) || (this.msgType == 922746929))
    {
      Log.i(this.TAG, "recordTextView: skip pat msg");
      localObject = this.mfG;
      label64:
      k[] arrayOfk;
      int j;
      if (localObject == null)
      {
        localObject = null;
        if (!(localObject instanceof Spannable)) {
          break label174;
        }
        localObject = (Spannable)localObject;
        if (localObject != null)
        {
          arrayOfk = (k[])((Spannable)localObject).getSpans(0, ((Spannable)localObject).length(), k.class);
          s.s(arrayOfk, "emojiList");
          j = arrayOfk.length;
          i = 0;
        }
      }
      for (;;)
      {
        localObject = localMMNeat7extView;
        if (i < j)
        {
          localObject = arrayOfk[i];
          if (!((k)localObject).acyj) {}
        }
        else
        {
          if (localObject != null)
          {
            this.mfH = ((k)localObject);
            localObject = this.mfH;
            if (localObject != null) {
              ((k)localObject).setAlpha(0.0F);
            }
            localObject = this.mfG;
            if (localObject != null) {
              ((MMNeat7extView)localObject).invalidate();
            }
          }
          AppMethodBeat.o(242337);
          return;
          localObject = ((MMNeat7extView)localObject).jPy();
          break;
          label174:
          localObject = null;
          break label64;
        }
        i += 1;
      }
    }
    localMMNeat7extView = this.mfG;
    if (localMMNeat7extView == null) {
      if (localObject != null) {
        break label284;
      }
    }
    label284:
    for (int i = this.mfM;; i = ((Integer)localObject).intValue())
    {
      this.mfM = i;
      localObject = this.mfG;
      if (localObject != null) {
        ((MMNeat7extView)localObject).setTextColor(0);
      }
      Log.i(this.TAG, "recordTextView: " + this.mfG + ", color:" + this.mfM);
      AppMethodBeat.o(242337);
      return;
      localObject = Integer.valueOf(localMMNeat7extView.getCurrentTextColor());
      break;
    }
  }
  
  private final void aUl()
  {
    AppMethodBeat.i(242342);
    if ((this.msgType == 889192497) || (this.msgType == 922746929))
    {
      Log.i(this.TAG, "recordTextView: skip pat msg");
      localObject = this.mfH;
      if (localObject != null) {
        ((k)localObject).setAlpha(1.0F);
      }
      localObject = this.mfG;
      if (localObject != null) {
        ((MMNeat7extView)localObject).invalidate();
      }
      AppMethodBeat.o(242342);
      return;
    }
    Object localObject = this.mfG;
    if (localObject == null) {}
    for (int i = 0;; i = ((MMNeat7extView)localObject).getCurrentTextColor())
    {
      if (i == 0)
      {
        localObject = this.mfG;
        if (localObject != null) {
          ((MMNeat7extView)localObject).setTextColor(this.mfM);
        }
      }
      Log.i(this.TAG, "restoreTextView: " + this.mfG + ", " + i);
      AppMethodBeat.o(242342);
      return;
    }
  }
  
  private static final void b(c paramc)
  {
    AppMethodBeat.i(242353);
    s.u(paramc, "this$0");
    if (!paramc.hLy)
    {
      Log.i(paramc.TAG, "delay: recycle");
      paramc.restore();
      a locala = paramc.mfQ;
      if (locala != null) {
        locala.d(paramc);
      }
    }
    AppMethodBeat.o(242353);
  }
  
  private static final void b(c paramc, MMAnimateView paramMMAnimateView)
  {
    AppMethodBeat.i(242371);
    s.u(paramc, "this$0");
    s.u(paramMMAnimateView, "$it");
    h localh = paramc.mfI;
    if (localh != null) {
      localh.resume();
    }
    localh = paramc.mfI;
    if (localh != null) {
      localh.JhG = new c..ExternalSyntheticLambda4(paramc, paramMMAnimateView);
    }
    AppMethodBeat.o(242371);
  }
  
  private void c(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(242319);
    if (this.mfI == null)
    {
      Log.i(this.TAG, "updateView: no drawable");
      AppMethodBeat.o(242319);
      return;
    }
    if (this.mfE == null)
    {
      Log.i(this.TAG, "updateView: no rootView");
      AppMethodBeat.o(242319);
      return;
    }
    Log.d(this.TAG, "updateView: " + paramFloat1 + ", " + paramFloat2 + ", " + paramInt + ", " + this.hLy);
    if (this.mfF == null)
    {
      localObject = this.mfE;
      if (localObject != null) {
        break label376;
      }
      localObject = null;
      this.mfF = new MMAnimateView((Context)localObject);
      localObject = this.mfE;
      if (localObject != null) {
        ((FrameLayout)localObject).addView((View)this.mfF, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(paramInt, paramInt));
      }
      localObject = this.mfF;
      if (localObject != null) {
        ((MMAnimateView)localObject).setVisibility(8);
      }
    }
    Object localObject = this.mfF;
    label212:
    MMAnimateView localMMAnimateView;
    if (localObject == null)
    {
      localObject = null;
      localObject = (FrameLayout.LayoutParams)localObject;
      if (localObject != null) {
        break label396;
      }
      localObject = new FrameLayout.LayoutParams(paramInt, paramInt);
      localMMAnimateView = this.mfF;
      if (localMMAnimateView != null) {
        localMMAnimateView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    for (;;)
    {
      localObject = this.mfF;
      if (localObject != null) {
        ((MMAnimateView)localObject).setTranslationX(paramFloat1 - paramInt / 2);
      }
      localObject = this.mfF;
      if (localObject != null) {
        ((MMAnimateView)localObject).setTranslationY(paramFloat2 - paramInt / 2);
      }
      if (!this.hLy)
      {
        aUj();
        this.hLy = true;
        d.H(this.mfO);
        localObject = this.mfF;
        if (localObject != null) {
          ((MMAnimateView)localObject).animate().scaleX(1.5F).scaleY(1.5F).setDuration(0L).withEndAction(new c..ExternalSyntheticLambda3(this, (MMAnimateView)localObject));
        }
      }
      AppMethodBeat.o(242319);
      return;
      label376:
      localObject = ((FrameLayout)localObject).getContext();
      break;
      localObject = ((MMAnimateView)localObject).getLayoutParams();
      break label212;
      label396:
      if ((((FrameLayout.LayoutParams)localObject).width != paramInt) || (((FrameLayout.LayoutParams)localObject).height != paramInt))
      {
        ((FrameLayout.LayoutParams)localObject).width = paramInt;
        ((FrameLayout.LayoutParams)localObject).height = paramInt;
        localMMAnimateView = this.mfF;
        if (localMMAnimateView != null) {
          localMMAnimateView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
  }
  
  private static final void c(c paramc)
  {
    AppMethodBeat.i(242365);
    s.u(paramc, "this$0");
    if (paramc.hLy)
    {
      Object localObject = paramc.mfK;
      if (localObject != null)
      {
        localObject = ((b.a)localObject).mfA;
        if ((localObject != null) && (((b.b)localObject).UZ == -1)) {
          paramc.mfN.run();
        }
      }
      d.H(paramc.mfN);
      paramc.restore();
      paramc.msgId = 0L;
      paramc.mfG = null;
      localObject = paramc.mfQ;
      if (localObject != null) {
        ((a)localObject).d(paramc);
      }
    }
    AppMethodBeat.o(242365);
  }
  
  private final void restore()
  {
    AppMethodBeat.i(242331);
    d.H(this.mfN);
    d.H(this.mfO);
    Object localObject = this.mfI;
    if (localObject != null) {
      ((h)localObject).recycle();
    }
    this.mfI = null;
    localObject = this.mfF;
    if (localObject != null) {
      ((MMAnimateView)localObject).setVisibility(8);
    }
    localObject = this.mfF;
    if (localObject != null)
    {
      localObject = ((MMAnimateView)localObject).animate();
      if (localObject != null) {
        ((ViewPropertyAnimator)localObject).cancel();
      }
    }
    localObject = this.mfF;
    if (localObject != null) {
      ((MMAnimateView)localObject).setScaleX(1.0F);
    }
    localObject = this.mfF;
    if (localObject != null) {
      ((MMAnimateView)localObject).setScaleY(1.0F);
    }
    aUl();
    this.hLy = false;
    AppMethodBeat.o(242331);
  }
  
  public final void Ej(String paramString)
  {
    AppMethodBeat.i(242405);
    s.u(paramString, "<set-?>");
    this.mfC = paramString;
    AppMethodBeat.o(242405);
  }
  
  public final boolean b(MMNeat7extView paramMMNeat7extView)
  {
    AppMethodBeat.i(242409);
    Log.d(this.TAG, "bindItemView: " + this.msgId + ", " + paramMMNeat7extView);
    if (!s.p(this.mfG, paramMMNeat7extView))
    {
      aUl();
      this.mfG = paramMMNeat7extView;
      aUk();
    }
    if (this.mfG == null)
    {
      if (this.hLy)
      {
        Log.i(this.TAG, "bindItemView: null");
        restore();
        AppMethodBeat.o(242409);
        return true;
      }
      if (!this.mfL) {
        d.a(200L, this.mfO);
      }
    }
    this.mfL = true;
    AppMethodBeat.o(242409);
    return false;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(242418);
    Log.i(this.TAG, "stop: ");
    restore();
    AppMethodBeat.o(242418);
  }
  
  public final void u(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(242413);
    s.u(paramArrayOfInt, "rootLocation");
    MMNeat7extView localMMNeat7extView = this.mfG;
    Object localObject;
    int i;
    int j;
    if (localMMNeat7extView == null)
    {
      localObject = null;
      if (localObject == null) {
        break label200;
      }
      localObject = a.mfw;
      localObject = a.a.a(localMMNeat7extView);
      int[] arrayOfInt = new int[2];
      localMMNeat7extView.getLocationInWindow(arrayOfInt);
      i = arrayOfInt[0] - paramArrayOfInt[0];
      j = arrayOfInt[1] - paramArrayOfInt[1];
      if (!((RectF)localObject).isEmpty()) {
        break label188;
      }
      localMMNeat7extView.post(new c..ExternalSyntheticLambda5(localMMNeat7extView, this, i, j));
      ((RectF)localObject).set(this.mfJ);
    }
    for (;;)
    {
      float f1 = ((RectF)localObject).centerX();
      float f2 = i;
      float f3 = localMMNeat7extView.getPaddingLeft();
      float f4 = ((RectF)localObject).centerY();
      float f5 = j;
      c(f2 + f1 + f3, localMMNeat7extView.getPaddingTop() + (f5 + f4), (int)((RectF)localObject).width());
      AppMethodBeat.o(242413);
      return;
      localObject = localMMNeat7extView.getLayout();
      break;
      label188:
      this.mfJ.set((RectF)localObject);
    }
    label200:
    Log.i(this.TAG, "updateView: no layout");
    AppMethodBeat.o(242413);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder$AnimCallback;", "", "onEnd", "", "onPlayScreenEffect", "msgId", "", "animKey", "", "config", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimItem;", "onRecycle", "holder", "Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder;", "played", "", "onScreenEffect", "onStart", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(long paramLong, String paramString, b.a parama);
    
    public abstract void a(String paramString, b.a parama);
    
    public abstract void d(c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.c
 * JD-Core Version:    0.7.0.1
 */