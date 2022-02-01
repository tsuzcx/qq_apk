package com.tencent.mm.plugin.emoji.magicemoji.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.magicemoji.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/view/MEHolderView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/emoji/magicemoji/api/IMagicEmojiLifecycleListener;", "Lcom/tencent/mm/plugin/emoji/magicemoji/api/IMagicEmojiConnExptListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/view/SurfaceHolder$Callback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "clickHandler", "Lkotlin/Function0;", "", "getClickHandler", "()Lkotlin/jvm/functions/Function0;", "setClickHandler", "(Lkotlin/jvm/functions/Function0;)V", "rect", "Landroid/graphics/RectF;", "surface", "Landroid/view/Surface;", "surfaceView", "Landroid/view/SurfaceView;", "textureView", "Landroid/view/TextureView;", "onAttachedToWindow", "onBindingDied", "onDetachedFromWindow", "onDisconnected", "onRemoteException", "onServiceDestroy", "reason", "", "onSurfaceTextureAvailable", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "resetBoundingBox", "setBoundingBox", "start", "stop", "surfaceChanged", "holder", "Landroid/view/SurfaceHolder;", "format", "surfaceCreated", "surfaceDestroyed", "Companion", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MEHolderView
  extends FrameLayout
  implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, com.tencent.mm.plugin.emoji.magicemoji.a.a, com.tencent.mm.plugin.emoji.magicemoji.a.d
{
  private static int mode;
  public static final MEHolderView.a xKx;
  public static final RectF xKz;
  private TextureView cHz;
  public RectF ekW;
  private SurfaceView sce;
  private Surface surface;
  private kotlin.g.a.a<ah> xKy;
  
  static
  {
    AppMethodBeat.i(270313);
    xKx = new MEHolderView.a((byte)0);
    xKz = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    AppMethodBeat.o(270313);
  }
  
  public MEHolderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(270305);
    this.ekW = xKz;
    this.xKy = ((kotlin.g.a.a)MEHolderView.b.xKA);
    AppMethodBeat.o(270305);
  }
  
  public final void Kk(int paramInt)
  {
    AppMethodBeat.i(270380);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(270380);
  }
  
  public final void dyA()
  {
    AppMethodBeat.i(270370);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(270370);
  }
  
  public final void dyB()
  {
    AppMethodBeat.i(270376);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(270376);
  }
  
  public final void dyt()
  {
    AppMethodBeat.i(270383);
    s.u(this, "this");
    AppMethodBeat.o(270383);
  }
  
  public final void dyu()
  {
    AppMethodBeat.i(270395);
    s.u(this, "this");
    AppMethodBeat.o(270395);
  }
  
  public final void dyv()
  {
    AppMethodBeat.i(270392);
    s.u(this, "this");
    AppMethodBeat.o(270392);
  }
  
  public final void dyw()
  {
    AppMethodBeat.i(270389);
    s.u(this, "this");
    AppMethodBeat.o(270389);
  }
  
  public final void dyx()
  {
    AppMethodBeat.i(270386);
    s.u(this, "this");
    AppMethodBeat.o(270386);
  }
  
  public final void dyz()
  {
    AppMethodBeat.i(270368);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(270368);
  }
  
  public final kotlin.g.a.a<ah> getClickHandler()
  {
    return this.xKy;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(270323);
    super.onAttachedToWindow();
    Log.i("MicroMsg.MEHolderView", "stevecai: onAttachedToWindow: MEHolderView");
    ((b)h.ax(b.class)).a((com.tencent.mm.plugin.emoji.magicemoji.a.d)this);
    ((b)h.ax(b.class)).a((com.tencent.mm.plugin.emoji.magicemoji.a.a)this);
    AppMethodBeat.o(270323);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(270325);
    super.onDetachedFromWindow();
    Log.i("MicroMsg.MEHolderView", "stevecai: onDetachedFromWindow: MEHolderView");
    ((b)h.ax(b.class)).b((com.tencent.mm.plugin.emoji.magicemoji.a.d)this);
    ((b)h.ax(b.class)).b((com.tencent.mm.plugin.emoji.magicemoji.a.a)this);
    AppMethodBeat.o(270325);
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(270339);
    s.u(paramSurfaceTexture, "surfaceTexture");
    Log.i("MicroMsg.MEHolderView", "stevecai: onSurfaceTextureAvailable: " + paramInt1 + ' ' + paramInt2);
    paramSurfaceTexture = new Surface(paramSurfaceTexture);
    ((b)h.ax(b.class)).e(paramSurfaceTexture, paramInt1, paramInt2);
    this.surface = paramSurfaceTexture;
    AppMethodBeat.o(270339);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(270347);
    s.u(paramSurfaceTexture, "surfaceTexture");
    Log.i("MicroMsg.MEHolderView", "stevecai: onSurfaceTextureDestroyed: ");
    paramSurfaceTexture = this.surface;
    if (paramSurfaceTexture != null)
    {
      ((b)h.ax(b.class)).p(paramSurfaceTexture);
      paramSurfaceTexture.release();
    }
    this.surface = null;
    AppMethodBeat.o(270347);
    return true;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(270343);
    s.u(paramSurfaceTexture, "surfaceTexture");
    Log.i("MicroMsg.MEHolderView", "stevecai: onSurfaceTextureSizeChanged: " + paramInt1 + ' ' + paramInt2);
    paramSurfaceTexture = this.surface;
    if (paramSurfaceTexture != null) {
      ((b)h.ax(b.class)).e(paramSurfaceTexture, paramInt1, paramInt2);
    }
    AppMethodBeat.o(270343);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(270349);
    s.u(paramSurfaceTexture, "surface");
    AppMethodBeat.o(270349);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(270336);
    s.u(paramMotionEvent, "event");
    if ((s.p(this.ekW, xKz)) || (this.surface == null))
    {
      AppMethodBeat.o(270336);
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default: 
      AppMethodBeat.o(270336);
      return false;
    case 0: 
    case 2: 
      boolean bool = this.ekW.contains(f1, f2);
      AppMethodBeat.o(270336);
      return bool;
    }
    if (this.ekW.contains(f1, f2))
    {
      this.xKy.invoke();
      AppMethodBeat.o(270336);
      return true;
    }
    AppMethodBeat.o(270336);
    return false;
  }
  
  public final void setBoundingBox(RectF paramRectF)
  {
    AppMethodBeat.i(270320);
    s.u(paramRectF, "rect");
    this.ekW = paramRectF;
    AppMethodBeat.o(270320);
  }
  
  public final void setClickHandler(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(270318);
    s.u(parama, "<set-?>");
    this.xKy = parama;
    AppMethodBeat.o(270318);
  }
  
  public final void start()
  {
    AppMethodBeat.i(270328);
    if ((this.cHz != null) || (this.sce != null))
    {
      AppMethodBeat.o(270328);
      return;
    }
    if (mode == 0)
    {
      localObject = new TextureView(getContext());
      ((TextureView)localObject).setOpaque(false);
      ((TextureView)localObject).setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
      localah = ah.aiuX;
      this.cHz = ((TextureView)localObject);
      addView((View)this.cHz);
      AppMethodBeat.o(270328);
      return;
    }
    Object localObject = new SurfaceView(getContext());
    ((SurfaceView)localObject).setZOrderOnTop(true);
    ((SurfaceView)localObject).getHolder().setFormat(-2);
    ((SurfaceView)localObject).getHolder().addCallback((SurfaceHolder.Callback)this);
    ah localah = ah.aiuX;
    this.sce = ((SurfaceView)localObject);
    addView((View)this.sce);
    AppMethodBeat.o(270328);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(270331);
    Object localObject = this.cHz;
    if (localObject != null) {
      removeView((View)localObject);
    }
    this.cHz = null;
    localObject = this.sce;
    if (localObject != null) {
      removeView((View)localObject);
    }
    this.sce = null;
    AppMethodBeat.o(270331);
  }
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(270361);
    s.u(paramSurfaceHolder, "holder");
    Log.i("MicroMsg.MEHolderView", "stevecai: surfaceChanged: " + paramInt2 + ' ' + paramInt3);
    paramSurfaceHolder = this.surface;
    if (paramSurfaceHolder != null) {
      ((b)h.ax(b.class)).e(paramSurfaceHolder, paramInt2, paramInt3);
    }
    AppMethodBeat.o(270361);
  }
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(270358);
    s.u(paramSurfaceHolder, "holder");
    Surface localSurface = paramSurfaceHolder.getSurface();
    paramSurfaceHolder = paramSurfaceHolder.getSurfaceFrame();
    Log.i("MicroMsg.MEHolderView", "stevecai: surfaceCreated: " + paramSurfaceHolder.width() + ' ' + paramSurfaceHolder.height());
    b localb = (b)h.ax(b.class);
    s.s(localSurface, "surface");
    localb.e(localSurface, paramSurfaceHolder.width(), paramSurfaceHolder.height());
    this.surface = localSurface;
    AppMethodBeat.o(270358);
  }
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(270364);
    s.u(paramSurfaceHolder, "holder");
    Log.i("MicroMsg.MEHolderView", "stevecai: surfaceDestroyed: ");
    paramSurfaceHolder = this.surface;
    if (paramSurfaceHolder != null) {
      ((b)h.ax(b.class)).p(paramSurfaceHolder);
    }
    this.surface = null;
    AppMethodBeat.o(270364);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(MEHolderView paramMEHolderView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(MEHolderView paramMEHolderView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(MEHolderView paramMEHolderView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(MEHolderView paramMEHolderView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.view.MEHolderView
 * JD-Core Version:    0.7.0.1
 */