package com.tencent.mm.plugin.hld.view;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/view/ImeSeekBar;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "_current_pos", "", "_mBarLen", "_mBarPointWidth", "iImeSeekCallback", "Lcom/tencent/mm/plugin/hld/view/IImeSeekCallback;", "mBackBar", "Landroid/widget/ImageView;", "getMBackBar", "()Landroid/widget/ImageView;", "mBackBar$delegate", "Lkotlin/Lazy;", "mBarPoint", "getMBarPoint", "mBarPoint$delegate", "mFrontBar", "getMFrontBar", "mFrontBar$delegate", "mLen", "mMinSize", "mPlaytimeTv", "Landroid/widget/TextView;", "getMPlaytimeTv", "()Landroid/widget/TextView;", "mPlaytimeTv$delegate", "mPosition", "checkEdge", "left", "getBarLen", "getBarPointWidth", "getCurrentSeekSize", "getCurrentTimeByBarPoint", "seek", "", "position", "seekForPoint", "setIImeSeekCallback", "_seekCallback", "setInitSeekSize", "setMinSize", "_minSize", "setSeekText", "seekSize", "setTotalSize", "_len", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ImeSeekBar
  extends RelativeLayout
{
  public static final ImeSeekBar.a JzW;
  private final j JAa;
  private int JAb;
  private c JAc;
  private final j JzX;
  private final j JzY;
  private final j JzZ;
  private int cqW;
  private int mPosition;
  private int sHs;
  private int sHt;
  private float sHu;
  
  static
  {
    AppMethodBeat.i(312545);
    JzW = new ImeSeekBar.a((byte)0);
    AppMethodBeat.o(312545);
  }
  
  public ImeSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImeSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private ImeSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(312499);
    this.JzX = k.cm((a)new c(this));
    this.JzY = k.cm((a)new e(this));
    this.JzZ = k.cm((a)new b(this));
    this.JAa = k.cm((a)new d(this));
    af.mU(paramContext).inflate(a.h.ime_seek_bar, (ViewGroup)this, true);
    getMBarPoint().setOnTouchListener(new ImeSeekBar..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(312499);
  }
  
  private static final boolean a(ImeSeekBar paramImeSeekBar, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(312528);
    s.u(paramImeSeekBar, "this$0");
    if (paramMotionEvent.getAction() == 0)
    {
      Log.i("WxIme.ImeSeekBar", "ontouch down");
      paramImeSeekBar.sHu = paramMotionEvent.getX();
      AppMethodBeat.o(312528);
      return true;
    }
    int i;
    int j;
    if (paramMotionEvent.getAction() == 2)
    {
      float f1 = paramMotionEvent.getX();
      paramView = paramImeSeekBar.getMBarPoint().getLayoutParams();
      if (paramView == null)
      {
        paramImeSeekBar = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(312528);
        throw paramImeSeekBar;
      }
      paramView = (FrameLayout.LayoutParams)paramView;
      float f2 = paramView.leftMargin;
      i = (int)(f1 - paramImeSeekBar.sHu + f2);
      j = (paramImeSeekBar.getBarPointWidth() - paramImeSeekBar.getMBarPoint().getPaddingLeft() - paramImeSeekBar.getMBarPoint().getPaddingRight()) / 2;
      paramMotionEvent = paramImeSeekBar.getMBackBar().getLayoutParams();
      if (paramMotionEvent == null)
      {
        paramImeSeekBar = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(312528);
        throw paramImeSeekBar;
      }
      paramMotionEvent = (FrameLayout.LayoutParams)paramMotionEvent;
      if (i < paramMotionEvent.leftMargin - paramImeSeekBar.getMBarPoint().getPaddingLeft() - j) {
        i = paramMotionEvent.leftMargin - paramImeSeekBar.getMBarPoint().getPaddingLeft() - j;
      }
      for (;;)
      {
        paramView.leftMargin = i;
        paramImeSeekBar.getMBarPoint().setLayoutParams((ViewGroup.LayoutParams)paramView);
        i = paramImeSeekBar.getCurrentTimeByBarPoint();
        if (paramImeSeekBar.cqW <= 0) {
          break label355;
        }
        paramView = paramImeSeekBar.getMFrontBar().getLayoutParams();
        if (paramView != null) {
          break;
        }
        paramImeSeekBar = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(312528);
        throw paramImeSeekBar;
        if (i > paramImeSeekBar.getBarLen() + paramMotionEvent.leftMargin - j - paramImeSeekBar.getMBarPoint().getPaddingLeft())
        {
          i = paramImeSeekBar.getBarLen();
          i = paramMotionEvent.leftMargin + i - j - paramImeSeekBar.getMBarPoint().getPaddingLeft();
        }
      }
      paramView = (FrameLayout.LayoutParams)paramView;
      paramView.width = ((int)(i * 1.0D / paramImeSeekBar.cqW * paramImeSeekBar.getBarLen()));
      paramImeSeekBar.getMFrontBar().setLayoutParams((ViewGroup.LayoutParams)paramView);
      label355:
      paramImeSeekBar.setSeekText(paramImeSeekBar.mPosition);
    }
    for (;;)
    {
      paramImeSeekBar.mPosition = i;
      paramImeSeekBar.cxb();
      break;
      j = paramImeSeekBar.getCurrentTimeByBarPoint();
      i = j;
      if (paramImeSeekBar.JAc != null)
      {
        Log.i("WxIme.ImeSeekBar", s.X("current time : ", Integer.valueOf(j)));
        i = j;
      }
    }
  }
  
  private void cxb()
  {
    AppMethodBeat.i(312512);
    if (this.cqW == 0)
    {
      Log.d("WxIme.ImeSeekBar", "mLen == 0");
      AppMethodBeat.o(312512);
      return;
    }
    if (getMBarPoint() == null)
    {
      Log.d("WxIme.ImeSeekBar", "mBarPoint == null");
      AppMethodBeat.o(312512);
      return;
    }
    if (getBarLen() == 0)
    {
      Log.d("WxIme.ImeSeekBar", "_mBarLen == 0");
      AppMethodBeat.o(312512);
      return;
    }
    int i = (getBarPointWidth() - getMBarPoint().getPaddingLeft() - getMBarPoint().getPaddingRight()) / 2;
    setSeekText(this.mPosition);
    Object localObject = getMBackBar().getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(312512);
      throw ((Throwable)localObject);
    }
    int j = ((FrameLayout.LayoutParams)localObject).leftMargin;
    int k = getMBarPoint().getPaddingLeft();
    localObject = getMBarPoint().getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(312512);
      throw ((Throwable)localObject);
    }
    localObject = (FrameLayout.LayoutParams)localObject;
    ((FrameLayout.LayoutParams)localObject).leftMargin = (j - k + (int)(this.mPosition * 1.0D / this.cqW * getBarLen()) - i);
    getMBarPoint().setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = getMFrontBar().getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(312512);
      throw ((Throwable)localObject);
    }
    localObject = (FrameLayout.LayoutParams)localObject;
    ((FrameLayout.LayoutParams)localObject).width = ((int)(this.mPosition * 1.0D / this.cqW * getBarLen()));
    getMFrontBar().setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(312512);
  }
  
  private final ImageView getMBackBar()
  {
    AppMethodBeat.i(312468);
    Object localObject = this.JzZ.getValue();
    s.s(localObject, "<get-mBackBar>(...)");
    localObject = (ImageView)localObject;
    AppMethodBeat.o(312468);
    return localObject;
  }
  
  private final ImageView getMBarPoint()
  {
    AppMethodBeat.i(312453);
    Object localObject = this.JzX.getValue();
    s.s(localObject, "<get-mBarPoint>(...)");
    localObject = (ImageView)localObject;
    AppMethodBeat.o(312453);
    return localObject;
  }
  
  private final ImageView getMFrontBar()
  {
    AppMethodBeat.i(312478);
    Object localObject = this.JAa.getValue();
    s.s(localObject, "<get-mFrontBar>(...)");
    localObject = (ImageView)localObject;
    AppMethodBeat.o(312478);
    return localObject;
  }
  
  private final TextView getMPlaytimeTv()
  {
    AppMethodBeat.i(312459);
    Object localObject = this.JzY.getValue();
    s.s(localObject, "<get-mPlaytimeTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(312459);
    return localObject;
  }
  
  private static final void setTotalSize$lambda-2(ImeSeekBar paramImeSeekBar)
  {
    AppMethodBeat.i(312535);
    s.u(paramImeSeekBar, "this$0");
    paramImeSeekBar.cxb();
    AppMethodBeat.o(312535);
  }
  
  protected final int getBarLen()
  {
    AppMethodBeat.i(312577);
    if (this.sHs <= 0) {
      this.sHs = getMBackBar().getWidth();
    }
    int i = this.sHs;
    AppMethodBeat.o(312577);
    return i;
  }
  
  protected final int getBarPointWidth()
  {
    AppMethodBeat.i(312572);
    if (this.sHt <= 0) {
      this.sHt = getMBarPoint().getWidth();
    }
    int i = this.sHt;
    AppMethodBeat.o(312572);
    return i;
  }
  
  public final int getCurrentSeekSize()
  {
    AppMethodBeat.i(312598);
    int i = getCurrentTimeByBarPoint();
    int j = this.JAb;
    AppMethodBeat.o(312598);
    return i + j;
  }
  
  protected final int getCurrentTimeByBarPoint()
  {
    AppMethodBeat.i(312583);
    Object localObject = getMBackBar().getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(312583);
      throw ((Throwable)localObject);
    }
    int i = ((FrameLayout.LayoutParams)localObject).leftMargin;
    int j = getMBarPoint().getPaddingLeft();
    localObject = getMBarPoint().getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(312583);
      throw ((Throwable)localObject);
    }
    i = Math.max(0, (int)((((FrameLayout.LayoutParams)localObject).leftMargin - (i - j) + (getBarPointWidth() - getMBarPoint().getPaddingLeft() - getMBarPoint().getPaddingRight()) / 2) * 1.0D / getBarLen() * this.cqW));
    AppMethodBeat.o(312583);
    return i;
  }
  
  public final void setIImeSeekCallback(c paramc)
  {
    AppMethodBeat.i(312565);
    s.u(paramc, "_seekCallback");
    this.JAc = paramc;
    AppMethodBeat.o(312565);
  }
  
  public final void setInitSeekSize(int paramInt)
  {
    AppMethodBeat.i(312615);
    this.mPosition = (paramInt - this.JAb);
    cxb();
    AppMethodBeat.o(312615);
  }
  
  public final void setMinSize(int paramInt)
  {
    this.JAb = paramInt;
  }
  
  protected final void setSeekText(int paramInt)
  {
    AppMethodBeat.i(312591);
    getMPlaytimeTv().setText((CharSequence)String.valueOf(this.JAb + paramInt));
    AppMethodBeat.o(312591);
  }
  
  public final void setTotalSize(int paramInt)
  {
    AppMethodBeat.i(312608);
    this.cqW = paramInt;
    if (!s.p(Looper.myLooper(), Looper.getMainLooper()))
    {
      post(new ImeSeekBar..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(312608);
      return;
    }
    cxb();
    AppMethodBeat.o(312608);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ImageView>
  {
    b(ImeSeekBar paramImeSeekBar)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ImageView>
  {
    c(ImeSeekBar paramImeSeekBar)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ImageView>
  {
    d(ImeSeekBar paramImeSeekBar)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<TextView>
  {
    e(ImeSeekBar paramImeSeekBar)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.ImeSeekBar
 * JD-Core Version:    0.7.0.1
 */