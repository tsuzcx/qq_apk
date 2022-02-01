package com.tencent.mm.plugin.hld.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ad;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/ImeSeekBar;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "_current_pos", "", "_mBarLen", "_mBarPointWidth", "iImeSeekCallback", "Lcom/tencent/mm/plugin/hld/view/IImeSeekCallback;", "mBackBar", "Landroid/widget/ImageView;", "getMBackBar", "()Landroid/widget/ImageView;", "mBackBar$delegate", "Lkotlin/Lazy;", "mBarPoint", "getMBarPoint", "mBarPoint$delegate", "mFrontBar", "getMFrontBar", "mFrontBar$delegate", "mLen", "mMinSize", "mPlaytimeTv", "Landroid/widget/TextView;", "getMPlaytimeTv", "()Landroid/widget/TextView;", "mPlaytimeTv$delegate", "mPosition", "checkEdge", "left", "getBarLen", "getBarPointWidth", "getCurrentSeekSize", "getCurrentTimeByBarPoint", "seek", "", "position", "seekForPoint", "setIImeSeekCallback", "_seekCallback", "setInitSeekSize", "setMinSize", "_minSize", "setSeekText", "seekSize", "setTotalSize", "_len", "Companion", "plugin-hld_release"})
public final class ImeSeekBar
  extends RelativeLayout
{
  public static final a DJa;
  private final f DIU;
  private final f DIV;
  private final f DIW;
  private final f DIX;
  private int DIY;
  private c DIZ;
  private int mPosition;
  private int pCf;
  private int pCg;
  private int pCh;
  private float pCi;
  
  static
  {
    AppMethodBeat.i(210661);
    DJa = new a((byte)0);
    AppMethodBeat.o(210661);
  }
  
  public ImeSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImeSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private ImeSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(210660);
    this.DIU = g.ar((a)new c(this));
    this.DIV = g.ar((a)new e(this));
    this.DIW = g.ar((a)new b(this));
    this.DIX = g.ar((a)new d(this));
    ad.kS(paramContext).inflate(a.h.ime_seek_bar, (ViewGroup)this, true);
    getMBarPoint().setOnTouchListener((View.OnTouchListener)new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(211039);
        p.j(paramAnonymousMotionEvent, "event");
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          Log.i("WxIme.ImeSeekBar", "ontouch down");
          ImeSeekBar.a(this.DJb, paramAnonymousMotionEvent.getX());
          AppMethodBeat.o(211039);
          return true;
        }
        int i;
        if (paramAnonymousMotionEvent.getAction() == 2)
        {
          float f1 = paramAnonymousMotionEvent.getX();
          paramAnonymousView = ImeSeekBar.b(this.DJb).getLayoutParams();
          if (paramAnonymousView == null)
          {
            paramAnonymousView = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            AppMethodBeat.o(211039);
            throw paramAnonymousView;
          }
          paramAnonymousView = (FrameLayout.LayoutParams)paramAnonymousView;
          float f2 = paramAnonymousView.leftMargin;
          i = (int)(f1 - ImeSeekBar.a(this.DJb) + f2);
          paramAnonymousView.leftMargin = ImeSeekBar.a(this.DJb, i);
          ImeSeekBar.b(this.DJb).setLayoutParams((ViewGroup.LayoutParams)paramAnonymousView);
          i = this.DJb.getCurrentTimeByBarPoint();
          if (ImeSeekBar.c(this.DJb) > 0)
          {
            paramAnonymousView = ImeSeekBar.d(this.DJb).getLayoutParams();
            if (paramAnonymousView == null)
            {
              paramAnonymousView = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
              AppMethodBeat.o(211039);
              throw paramAnonymousView;
            }
            paramAnonymousView = (FrameLayout.LayoutParams)paramAnonymousView;
            paramAnonymousView.width = ((int)(i * 1.0D / ImeSeekBar.c(this.DJb) * this.DJb.getBarLen()));
            ImeSeekBar.d(this.DJb).setLayoutParams((ViewGroup.LayoutParams)paramAnonymousView);
          }
          this.DJb.setSeekText(ImeSeekBar.e(this.DJb));
        }
        for (;;)
        {
          this.DJb.seek(i);
          break;
          int j = this.DJb.getCurrentTimeByBarPoint();
          i = j;
          if (ImeSeekBar.f(this.DJb) != null)
          {
            Log.i("WxIme.ImeSeekBar", "current time : ".concat(String.valueOf(j)));
            i = j;
          }
        }
      }
    });
    AppMethodBeat.o(210660);
  }
  
  private final ImageView getMBackBar()
  {
    AppMethodBeat.i(210643);
    ImageView localImageView = (ImageView)this.DIW.getValue();
    AppMethodBeat.o(210643);
    return localImageView;
  }
  
  private final ImageView getMBarPoint()
  {
    AppMethodBeat.i(210640);
    ImageView localImageView = (ImageView)this.DIU.getValue();
    AppMethodBeat.o(210640);
    return localImageView;
  }
  
  private final ImageView getMFrontBar()
  {
    AppMethodBeat.i(210645);
    ImageView localImageView = (ImageView)this.DIX.getValue();
    AppMethodBeat.o(210645);
    return localImageView;
  }
  
  private final TextView getMPlaytimeTv()
  {
    AppMethodBeat.i(210642);
    TextView localTextView = (TextView)this.DIV.getValue();
    AppMethodBeat.o(210642);
    return localTextView;
  }
  
  public final void bWO()
  {
    AppMethodBeat.i(210653);
    if (this.pCf == 0)
    {
      Log.d("WxIme.ImeSeekBar", "mLen == 0");
      AppMethodBeat.o(210653);
      return;
    }
    if (getMBarPoint() == null)
    {
      Log.d("WxIme.ImeSeekBar", "mBarPoint == null");
      AppMethodBeat.o(210653);
      return;
    }
    if (getBarLen() == 0)
    {
      Log.d("WxIme.ImeSeekBar", "_mBarLen == 0");
      AppMethodBeat.o(210653);
      return;
    }
    int i = (getBarPointWidth() - getMBarPoint().getPaddingLeft() - getMBarPoint().getPaddingRight()) / 2;
    setSeekText(this.mPosition);
    Object localObject = getMBackBar().getLayoutParams();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(210653);
      throw ((Throwable)localObject);
    }
    int j = ((FrameLayout.LayoutParams)localObject).leftMargin;
    int k = getMBarPoint().getPaddingLeft();
    localObject = getMBarPoint().getLayoutParams();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(210653);
      throw ((Throwable)localObject);
    }
    localObject = (FrameLayout.LayoutParams)localObject;
    ((FrameLayout.LayoutParams)localObject).leftMargin = (j - k + (int)(this.mPosition * 1.0D / this.pCf * getBarLen()) - i);
    getMBarPoint().setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = getMFrontBar().getLayoutParams();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(210653);
      throw ((Throwable)localObject);
    }
    localObject = (FrameLayout.LayoutParams)localObject;
    ((FrameLayout.LayoutParams)localObject).width = ((int)(this.mPosition * 1.0D / this.pCf * getBarLen()));
    getMFrontBar().setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(210653);
  }
  
  protected final int getBarLen()
  {
    AppMethodBeat.i(210648);
    if (this.pCg <= 0) {
      this.pCg = getMBackBar().getWidth();
    }
    int i = this.pCg;
    AppMethodBeat.o(210648);
    return i;
  }
  
  protected final int getBarPointWidth()
  {
    AppMethodBeat.i(210647);
    if (this.pCh <= 0) {
      this.pCh = getMBarPoint().getWidth();
    }
    int i = this.pCh;
    AppMethodBeat.o(210647);
    return i;
  }
  
  public final int getCurrentSeekSize()
  {
    AppMethodBeat.i(210651);
    int i = getCurrentTimeByBarPoint();
    int j = this.DIY;
    AppMethodBeat.o(210651);
    return i + j;
  }
  
  protected final int getCurrentTimeByBarPoint()
  {
    AppMethodBeat.i(210649);
    Object localObject = getMBackBar().getLayoutParams();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(210649);
      throw ((Throwable)localObject);
    }
    int i = ((FrameLayout.LayoutParams)localObject).leftMargin;
    int j = getMBarPoint().getPaddingLeft();
    localObject = getMBarPoint().getLayoutParams();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(210649);
      throw ((Throwable)localObject);
    }
    i = Math.max(0, (int)((((FrameLayout.LayoutParams)localObject).leftMargin - (i - j) + (getBarPointWidth() - getMBarPoint().getPaddingLeft() - getMBarPoint().getPaddingRight()) / 2) * 1.0D / getBarLen() * this.pCf));
    AppMethodBeat.o(210649);
    return i;
  }
  
  protected final void seek(int paramInt)
  {
    AppMethodBeat.i(210657);
    this.mPosition = paramInt;
    bWO();
    AppMethodBeat.o(210657);
  }
  
  public final void setIImeSeekCallback(c paramc)
  {
    AppMethodBeat.i(210646);
    p.k(paramc, "_seekCallback");
    this.DIZ = paramc;
    AppMethodBeat.o(210646);
  }
  
  public final void setInitSeekSize(int paramInt)
  {
    AppMethodBeat.i(210655);
    this.mPosition = (paramInt - this.DIY);
    bWO();
    AppMethodBeat.o(210655);
  }
  
  public final void setMinSize(int paramInt)
  {
    this.DIY = paramInt;
  }
  
  protected final void setSeekText(int paramInt)
  {
    AppMethodBeat.i(210650);
    getMPlaytimeTv().setText((CharSequence)String.valueOf(this.DIY + paramInt));
    AppMethodBeat.o(210650);
  }
  
  public final void setTotalSize(int paramInt)
  {
    AppMethodBeat.i(210652);
    this.pCf = paramInt;
    if ((p.h(Looper.myLooper(), Looper.getMainLooper()) ^ true))
    {
      post((Runnable)new f(this));
      AppMethodBeat.o(210652);
      return;
    }
    bWO();
    AppMethodBeat.o(210652);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/ImeSeekBar$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements a<ImageView>
  {
    b(ImeSeekBar paramImeSeekBar)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements a<ImageView>
  {
    c(ImeSeekBar paramImeSeekBar)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements a<ImageView>
  {
    d(ImeSeekBar paramImeSeekBar)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements a<TextView>
  {
    e(ImeSeekBar paramImeSeekBar)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(ImeSeekBar paramImeSeekBar) {}
    
    public final void run()
    {
      AppMethodBeat.i(217304);
      this.DJb.bWO();
      AppMethodBeat.o(217304);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.ImeSeekBar
 * JD-Core Version:    0.7.0.1
 */