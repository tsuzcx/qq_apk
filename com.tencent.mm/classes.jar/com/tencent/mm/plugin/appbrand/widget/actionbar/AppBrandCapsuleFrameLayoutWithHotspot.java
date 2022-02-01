package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.a;
import com.tencent.luggage.l.g;
import com.tencent.luggage.wxa.a.a;
import com.tencent.luggage.wxa.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.aa;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.z;
import kotlin.l.o;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandCapsuleFrameLayoutWithHotspot;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "debugUse", "", "Landroid/graphics/Rect;", "isTouchDelegatesInvalidated", "", "touchDelegates", "Landroid/view/TouchDelegate;", "init", "", "initCapsuleTouchDelegate", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "left", "top", "right", "bottom", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandCapsuleFrameLayoutWithHotspot
  extends FrameLayout
{
  public static final a uyZ;
  private static final g<Boolean> uzd;
  private List<TouchDelegate> uza;
  private List<Rect> uzb;
  private boolean uzc;
  
  static
  {
    AppMethodBeat.i(324177);
    uyZ = new a((byte)0);
    uzd = new g(Boolean.FALSE);
    AppMethodBeat.o(324177);
  }
  
  public AppBrandCapsuleFrameLayoutWithHotspot(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(324156);
    this.uzc = true;
    init();
    AppMethodBeat.o(324156);
  }
  
  public AppBrandCapsuleFrameLayoutWithHotspot(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(324158);
    this.uzc = true;
    init();
    AppMethodBeat.o(324158);
  }
  
  private static final void a(AppBrandCapsuleFrameLayoutWithHotspot paramAppBrandCapsuleFrameLayoutWithHotspot)
  {
    AppMethodBeat.i(324171);
    s.u(paramAppBrandCapsuleFrameLayoutWithHotspot, "this$0");
    paramAppBrandCapsuleFrameLayoutWithHotspot.cPc();
    AppMethodBeat.o(324171);
  }
  
  private static final void b(AppBrandCapsuleFrameLayoutWithHotspot paramAppBrandCapsuleFrameLayoutWithHotspot)
  {
    AppMethodBeat.i(324173);
    s.u(paramAppBrandCapsuleFrameLayoutWithHotspot, "this$0");
    paramAppBrandCapsuleFrameLayoutWithHotspot.cPc();
    AppMethodBeat.o(324173);
  }
  
  private final void cPc()
  {
    AppMethodBeat.i(324168);
    if (!this.uzc)
    {
      AppMethodBeat.o(324168);
      return;
    }
    this.uzc = false;
    Object localObject1 = findViewById(a.d.actionbar_capsule_option_btn);
    View localView = findViewById(a.d.actionbar_capsule_home_btn);
    Object localObject2 = findViewById(a.d.actionbar_capsule_area);
    if ((localObject1 == null) || (localView == null) || (localObject2 == null))
    {
      AppMethodBeat.o(324168);
      return;
    }
    Object localObject3 = new Rect();
    getHitRect((Rect)localObject3);
    Rect localRect2 = new Rect();
    ((View)localObject2).getHitRect(localRect2);
    Rect localRect1 = new Rect();
    ((View)localObject1).getHitRect(localRect1);
    localObject2 = new Rect();
    localView.getHitRect((Rect)localObject2);
    ((Rect)localObject2).offset(localRect2.left, localRect2.top);
    localRect1.offset(localRect2.left, localRect2.top);
    int i = ((Rect)localObject3).right - localRect2.right;
    int j = localRect2.top - ((Rect)localObject3).top;
    int k = ((Rect)localObject3).bottom - localRect2.bottom;
    if (i > 0)
    {
      localRect2.left -= i;
      localRect2.right += i;
      localRect1.left -= i;
      ((Rect)localObject2).right = (i + ((Rect)localObject2).right);
    }
    if (k > 0)
    {
      localRect2.bottom += k;
      localRect1.bottom += k;
      ((Rect)localObject2).bottom += k;
    }
    if (j > 0)
    {
      localRect2.top -= j;
      localRect1.top -= j;
      ((Rect)localObject2).top -= j;
    }
    if (this.uza == null)
    {
      this.uza = ((List)new ArrayList());
      if (uyZ.cPe()) {
        this.uzb = ((List)new ArrayList());
      }
    }
    if (uyZ.cPe())
    {
      localObject3 = this.uzb;
      s.checkNotNull(localObject3);
      ((List)localObject3).add(new Rect(localRect1));
      localObject3 = this.uzb;
      s.checkNotNull(localObject3);
      ((List)localObject3).add(new Rect((Rect)localObject2));
      invalidate();
    }
    localObject3 = this.uza;
    s.checkNotNull(localObject3);
    ((List)localObject3).add(new TouchDelegate(localRect1, (View)localObject1));
    localObject1 = this.uza;
    s.checkNotNull(localObject1);
    ((List)localObject1).add(new TouchDelegate((Rect)localObject2, localView));
    AppMethodBeat.o(324168);
  }
  
  private final void init()
  {
    AppMethodBeat.i(324161);
    if (uyZ.cPe())
    {
      setWillNotDraw(false);
      post(new AppBrandCapsuleFrameLayoutWithHotspot..ExternalSyntheticLambda1(this));
    }
    AppMethodBeat.o(324161);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(324197);
    s.u(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    if (uyZ.cPe())
    {
      Object localObject = this.uzb;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Rect localRect = (Rect)((Iterator)localObject).next();
          paramCanvas.save();
          paramCanvas.clipRect(localRect);
          paramCanvas.drawColor(a.w(getContext(), a.a.wechat_green_quarter_alpha));
          paramCanvas.restore();
        }
      }
    }
    AppMethodBeat.o(324197);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(324191);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.uzc = true;
      Object localObject = this.uza;
      if (localObject != null) {
        ((List)localObject).clear();
      }
      if (uyZ.cPe())
      {
        localObject = this.uzb;
        if (localObject != null)
        {
          ((List)localObject).clear();
          localObject = ah.aiuX;
          invalidate();
        }
        post(new AppBrandCapsuleFrameLayoutWithHotspot..ExternalSyntheticLambda0(this));
      }
    }
    AppMethodBeat.o(324191);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(324185);
    s.u(paramMotionEvent, "event");
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if (!bool)
    {
      cPc();
      Object localObject = this.uza;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((TouchDelegate)((Iterator)localObject).next()).onTouchEvent(paramMotionEvent)) {
            bool = true;
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(324185);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandCapsuleFrameLayoutWithHotspot$Companion;", "", "()V", "TAG", "", "<set-?>", "", "isDebugEnable", "()Z", "setDebugEnable", "(Z)V", "isDebugEnable$delegate", "Lcom/tencent/luggage/util/LuggageMMKVProperty;", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static
    {
      AppMethodBeat.i(324180);
      aYe = new o[] { (o)ai.a((z)new aa(a.class, "isDebugEnable", "isDebugEnable()Z", 0)) };
      AppMethodBeat.o(324180);
    }
    
    public final boolean cPe()
    {
      AppMethodBeat.i(324188);
      boolean bool = ((Boolean)AppBrandCapsuleFrameLayoutWithHotspot.cPd().a(this, aYe[0])).booleanValue();
      AppMethodBeat.o(324188);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandCapsuleFrameLayoutWithHotspot
 * JD-Core Version:    0.7.0.1
 */