package com.tencent.magicbrush;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Keep;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.FrameLayout;
import com.tencent.magicbrush.c.g;
import com.tencent.magicbrush.handler.JsTouchEventHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.concurrent.ConcurrentLinkedDeque;

@Keep
public class MagicBrushView
  extends FrameLayout
{
  private boolean mDisableTouchEvent;
  private JsTouchEventHandler mJsTouchEventHandler;
  private g mTextureView;
  private MBRuntime mbRuntime;
  
  public MagicBrushView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(115839);
    this.mDisableTouchEvent = false;
    init(null);
    AppMethodBeat.o(115839);
  }
  
  public MagicBrushView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MagicBrushView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(151475);
    this.mDisableTouchEvent = false;
    init(null);
    AppMethodBeat.o(151475);
  }
  
  public MagicBrushView(Context paramContext, g paramg)
  {
    super(paramContext);
    AppMethodBeat.i(151476);
    this.mDisableTouchEvent = false;
    init(paramg);
    AppMethodBeat.o(151476);
  }
  
  private void init(g paramg)
  {
    AppMethodBeat.i(151477);
    setBackgroundColor(-16777216);
    if (paramg == null) {}
    for (this.mTextureView = new g(getContext());; this.mTextureView = paramg)
    {
      addView(this.mTextureView);
      AppMethodBeat.o(151477);
      return;
    }
  }
  
  public void addSurfaceTextureListener(TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    AppMethodBeat.i(151478);
    this.mTextureView.bLD.add(paramSurfaceTextureListener);
    AppMethodBeat.o(151478);
  }
  
  public void disableTouchEvent()
  {
    this.mDisableTouchEvent = true;
  }
  
  public a.a getCurrentFps()
  {
    AppMethodBeat.i(115845);
    a.a locala = this.mbRuntime.getCurrentFps();
    AppMethodBeat.o(115845);
    return locala;
  }
  
  public MBRuntime getMBRuntime()
  {
    return this.mbRuntime;
  }
  
  public g getTextureView()
  {
    return this.mTextureView;
  }
  
  public void notifyBackground()
  {
    AppMethodBeat.i(115847);
    this.mbRuntime.pause();
    AppMethodBeat.o(115847);
  }
  
  public void notifyDestroy()
  {
    AppMethodBeat.i(151481);
    this.mbRuntime.destroy();
    this.mTextureView.yA();
    AppMethodBeat.o(151481);
  }
  
  public void notifyForeground()
  {
    AppMethodBeat.i(115846);
    this.mbRuntime.resume();
    AppMethodBeat.o(115846);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = -1;
    AppMethodBeat.i(115848);
    if (this.mDisableTouchEvent)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(115848);
      return bool;
    }
    JsTouchEventHandler localJsTouchEventHandler;
    int k;
    int n;
    if (this.mJsTouchEventHandler != null)
    {
      localJsTouchEventHandler = this.mJsTouchEventHandler;
      localJsTouchEventHandler.fJ(paramMotionEvent.getPointerCount());
      int m = JsTouchEventHandler.n(paramMotionEvent);
      if (m != -1)
      {
        k = paramMotionEvent.getPointerCount();
        i = 0;
        while (i < k)
        {
          localJsTouchEventHandler.bJw.put(paramMotionEvent.getPointerId(i));
          localJsTouchEventHandler.bJx.put(paramMotionEvent.getX(i) / localJsTouchEventHandler.mDensity);
          localJsTouchEventHandler.bJx.put(paramMotionEvent.getY(i) / localJsTouchEventHandler.mDensity);
          i += 1;
        }
        n = JsTouchEventHandler.n(paramMotionEvent);
        if (m != 1) {
          break label200;
        }
      }
    }
    label200:
    for (int i = j;; i = paramMotionEvent.getActionIndex())
    {
      long l = localJsTouchEventHandler.nativeCreateTouchEvent(n, i, k, localJsTouchEventHandler.bJw, localJsTouchEventHandler.bJx, paramMotionEvent.getEventTime());
      localJsTouchEventHandler.mbRuntime.notifyTouchEvent(l, localJsTouchEventHandler.bJy);
      AppMethodBeat.o(115848);
      return true;
    }
  }
  
  public void registerEventListener(MBRuntime.IMBEventListener paramIMBEventListener)
  {
    AppMethodBeat.i(115843);
    this.mbRuntime.registerEventListener(paramIMBEventListener);
    AppMethodBeat.o(115843);
  }
  
  public void removeSurfaceTextureListener(TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    AppMethodBeat.i(151479);
    this.mTextureView.bLD.remove(paramSurfaceTextureListener);
    AppMethodBeat.o(151479);
  }
  
  public void setMBRuntime(MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(115840);
    this.mbRuntime = paramMBRuntime;
    this.mJsTouchEventHandler = new JsTouchEventHandler(paramMBRuntime);
    this.mTextureView.setMBRuntime(paramMBRuntime);
    AppMethodBeat.o(115840);
  }
  
  public void setTransparentBackground(boolean paramBoolean)
  {
    AppMethodBeat.i(115842);
    if (paramBoolean)
    {
      setBackground(null);
      AppMethodBeat.o(115842);
      return;
    }
    setBackgroundColor(-16777216);
    AppMethodBeat.o(115842);
  }
  
  public void setUserPreferedFps(double paramDouble)
  {
    AppMethodBeat.i(115844);
    this.mbRuntime.setUserPreferredFps(paramDouble);
    AppMethodBeat.o(115844);
  }
  
  public void unregisterEventListener(MBRuntime.IMBEventListener paramIMBEventListener)
  {
    AppMethodBeat.i(151480);
    this.mbRuntime.unregisterEventListener(paramIMBEventListener);
    AppMethodBeat.o(151480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.magicbrush.MagicBrushView
 * JD-Core Version:    0.7.0.1
 */