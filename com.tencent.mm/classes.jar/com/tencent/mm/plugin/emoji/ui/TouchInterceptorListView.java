package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public class TouchInterceptorListView
  extends ListView
{
  private int afE;
  private int afF;
  private GestureDetector mDJ;
  private int mHeight;
  private Rect mTempRect;
  private final int mTouchSlop;
  private WindowManager mWindowManager;
  private WindowManager.LayoutParams mWindowParams;
  private int qXo;
  private ImageView riR;
  private int riS;
  private int riT;
  private int riU;
  private int riV;
  private a riW;
  private b riX;
  private c riY;
  private int riZ;
  private int rja;
  private int rjb;
  private Bitmap rjc;
  private int rjd;
  private int rje;
  private Drawable rjf;
  private int rjg;
  
  public TouchInterceptorListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109090);
    this.rjb = -1;
    this.mTempRect = new Rect();
    this.rjg = 0;
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    paramContext = getResources();
    this.qXo = (paramContext.getDimensionPixelSize(2131166272) + 1);
    this.rje = (this.qXo / 2);
    this.rjd = (this.qXo * 2);
    this.rjg = paramContext.getDimensionPixelOffset(2131166279);
    AppMethodBeat.o(109090);
  }
  
  private void cHP()
  {
    AppMethodBeat.i(109095);
    if (this.riR != null)
    {
      this.riR.setVisibility(8);
      ((WindowManager)getContext().getSystemService("window")).removeView(this.riR);
      this.riR.setImageDrawable(null);
      this.riR = null;
    }
    if (this.rjc != null)
    {
      Log.i("MicroMsg.emoji.TouchInterceptorListView", "bitmap recycle %s", new Object[] { this.rjc });
      this.rjc.recycle();
      this.rjc = null;
    }
    if (this.rjf != null) {
      this.rjf.setLevel(0);
    }
    AppMethodBeat.o(109095);
  }
  
  private int fD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109092);
    if (paramInt2 < 0)
    {
      i = fD(paramInt1, this.qXo + paramInt2);
      if (i > 0)
      {
        AppMethodBeat.o(109092);
        return i - 1;
      }
    }
    Rect localRect = this.mTempRect;
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      getChildAt(i).getHitRect(localRect);
      if (localRect.contains(paramInt1, paramInt2))
      {
        paramInt1 = getFirstVisiblePosition();
        AppMethodBeat.o(109092);
        return i + paramInt1;
      }
      i -= 1;
    }
    AppMethodBeat.o(109092);
    return -1;
  }
  
  private void lv(boolean paramBoolean)
  {
    AppMethodBeat.i(109093);
    int i = 0;
    for (;;)
    {
      Object localObject1 = getChildAt(i);
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        if (paramBoolean)
        {
          int j = getFirstVisiblePosition();
          int k = getChildAt(0).getTop();
          setAdapter(getAdapter());
          setSelectionFromTop(j, k);
        }
      }
      try
      {
        layoutChildren();
        localObject2 = getChildAt(i);
        localObject1 = localObject2;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        label72:
        break label72;
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        AppMethodBeat.o(109093);
        return;
      }
      localObject1 = ((View)localObject2).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = this.qXo;
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((View)localObject2).setVisibility(0);
      i += 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(109091);
    if ((this.riY != null) && (this.mDJ == null) && (this.rjb == 0)) {
      this.mDJ = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
      {
        public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(240179);
          b localb = new b();
          localb.bm(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
          boolean bool = super.onContextClick(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(240179);
          return bool;
        }
        
        public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(240178);
          b localb = new b();
          localb.bm(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
          boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(240178);
          return bool;
        }
        
        public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          AppMethodBeat.i(109089);
          if (TouchInterceptorListView.a(TouchInterceptorListView.this) != null)
          {
            if (paramAnonymousFloat1 > 1000.0F)
            {
              paramAnonymousMotionEvent1 = TouchInterceptorListView.b(TouchInterceptorListView.this);
              TouchInterceptorListView.a(TouchInterceptorListView.this).getDrawingRect(paramAnonymousMotionEvent1);
              if (paramAnonymousMotionEvent2.getX() > paramAnonymousMotionEvent1.right * 2 / 3)
              {
                TouchInterceptorListView.c(TouchInterceptorListView.this);
                TouchInterceptorListView.e(TouchInterceptorListView.this);
                TouchInterceptorListView.d(TouchInterceptorListView.this);
                TouchInterceptorListView.f(TouchInterceptorListView.this);
              }
            }
            AppMethodBeat.o(109089);
            return true;
          }
          AppMethodBeat.o(109089);
          return false;
        }
        
        public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(240177);
          b localb = new b();
          localb.bm(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
          super.onLongPress(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
          AppMethodBeat.o(240177);
        }
        
        public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(240176);
          b localb = new b();
          localb.bm(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
          boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(240176);
          return bool;
        }
      });
    }
    if ((this.riW != null) || (this.riX != null)) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(109091);
      return bool;
      int j = (int)paramMotionEvent.getX();
      int i = (int)paramMotionEvent.getY();
      int k = pointToPosition(j, i);
      if (k != -1)
      {
        Object localObject = (ViewGroup)getChildAt(k - getFirstVisiblePosition());
        this.riU = (j - ((ViewGroup)localObject).getLeft());
        this.riV = (i - ((ViewGroup)localObject).getTop());
        this.afE = ((int)paramMotionEvent.getRawX() - j);
        this.afF = ((int)paramMotionEvent.getRawY() - i);
        if (j < this.rjg)
        {
          ((ViewGroup)localObject).setDrawingCacheEnabled(true);
          paramMotionEvent = Bitmap.createBitmap(((ViewGroup)localObject).getDrawingCache());
          cHP();
          this.mWindowParams = new WindowManager.LayoutParams();
          this.mWindowParams.gravity = 49;
          this.mWindowParams.x = (j - this.riU + this.afE);
          this.mWindowParams.y = (i - this.riV + this.afF);
          this.mWindowParams.height = -2;
          this.mWindowParams.width = -2;
          this.mWindowParams.flags = 920;
          this.mWindowParams.format = -3;
          this.mWindowParams.windowAnimations = 0;
          localObject = getContext();
          ImageView localImageView = new ImageView((Context)localObject);
          localImageView.setBackgroundColor(((Context)localObject).getResources().getColor(2131101424));
          localImageView.setBackgroundResource(2131232185);
          localImageView.setPadding(0, 0, 0, 0);
          localImageView.setImageBitmap(paramMotionEvent);
          this.rjc = paramMotionEvent;
          this.mWindowManager = ((WindowManager)((Context)localObject).getSystemService("window"));
          this.mWindowManager.addView(localImageView, this.mWindowParams);
          this.riR = localImageView;
          this.riS = k;
          this.riT = this.riS;
          this.mHeight = getHeight();
          j = this.mTouchSlop;
          this.riZ = Math.min(i - j, this.mHeight / 3);
          this.rja = Math.max(j + i, this.mHeight * 2 / 3);
          AppMethodBeat.o(109091);
          return false;
        }
        cHP();
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = 4;
    int m = 0;
    AppMethodBeat.i(109094);
    Object localObject1;
    Object localObject2;
    if (this.mDJ != null)
    {
      localObject1 = this.mDJ;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((GestureDetector)localObject1).onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0)), "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    if (((this.riW != null) || (this.riX != null)) && (this.riR != null))
    {
      int k = paramMotionEvent.getAction();
      switch (k)
      {
      default: 
      case 1: 
      case 3: 
        for (;;)
        {
          AppMethodBeat.o(109094);
          return true;
          localObject1 = this.mTempRect;
          this.riR.getDrawingRect((Rect)localObject1);
          cHP();
          if ((this.rjb == 1) && (paramMotionEvent.getX() > ((Rect)localObject1).right * 3 / 4))
          {
            lv(true);
          }
          else
          {
            if ((this.riX != null) && (this.riS >= 0)) {
              getCount();
            }
            lv(false);
          }
        }
      }
      int i = (int)paramMotionEvent.getX();
      int i1 = (int)paramMotionEvent.getY();
      if (this.rjb == 1)
      {
        float f = 1.0F;
        j = this.riR.getWidth();
        if (i > j / 2) {
          f = (j - i) / (j / 2);
        }
        this.mWindowParams.alpha = f;
      }
      label345:
      int i2;
      label419:
      label464:
      int i3;
      int i4;
      if ((this.rjb == 0) || (this.rjb == 2))
      {
        this.mWindowParams.x = (i - this.riU + this.afE);
        this.mWindowParams.y = (i1 - this.riV + this.afF);
        this.mWindowManager.updateViewLayout(this.riR, this.mWindowParams);
        if (this.rjf != null)
        {
          j = this.riR.getWidth();
          if (i1 <= getHeight() * 3 / 4) {
            break label698;
          }
          this.rjf.setLevel(2);
        }
        i2 = i1 - this.riV - this.rje;
        j = fD(0, i2);
        if (j < 0) {
          break label735;
        }
        i = j;
        if (j <= this.riT) {
          i = j + 1;
        }
        if (i < 0) {
          break label746;
        }
        if ((k != 0) && (i == this.riS)) {
          break label910;
        }
        this.riS = i;
        Log.d("MicroMsg.emoji.TouchInterceptorListView", "doExpansion mDragPos:%d mSrcDragPos:%d", new Object[] { Integer.valueOf(this.riS), Integer.valueOf(this.riT) });
        Log.d("MicroMsg.emoji.TouchInterceptorListView", "getFirstVisiblePosition:%d", new Object[] { Integer.valueOf(getFirstVisiblePosition()) });
        Log.d("MicroMsg.emoji.TouchInterceptorListView", "getHeaderViewsCount:%d", new Object[] { Integer.valueOf(getHeaderViewsCount()) });
        i2 = this.riS;
        i3 = getFirstVisiblePosition();
        i4 = getHeaderViewsCount();
        paramMotionEvent = getChildAt(this.riT - getFirstVisiblePosition());
        k = 0;
        label597:
        localObject1 = getChildAt(k);
        if (localObject1 == null) {
          break label910;
        }
        j = this.qXo;
        if ((this.riS >= i4) || (k != i4)) {
          break label767;
        }
        if (!localObject1.equals(paramMotionEvent)) {
          break label748;
        }
        Log.d("MicroMsg.emoji.TouchInterceptorListView", "1. visibility = View.INVISIBLE");
        i = 4;
      }
      for (;;)
      {
        localObject2 = ((View)localObject1).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = j;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((View)localObject1).setVisibility(i);
        k += 1;
        break label597;
        this.mWindowParams.x = 0;
        break label345;
        label698:
        if ((j > 0) && (i > j / 4))
        {
          this.rjf.setLevel(1);
          break label419;
        }
        this.rjf.setLevel(0);
        break label419;
        label735:
        i = j;
        if (i2 >= 0) {
          break label464;
        }
        i = 0;
        break label464;
        label746:
        break;
        label748:
        j = this.rjd;
        Log.d("MicroMsg.emoji.TouchInterceptorListView", "1. height = mItemHeightExpanded");
        i = 0;
        continue;
        label767:
        if (localObject1.equals(paramMotionEvent))
        {
          if ((this.riS == this.riT) || (getPositionForView((View)localObject1) == getCount()))
          {
            j = this.qXo;
            Log.d("MicroMsg.emoji.TouchInterceptorListView", "2. visibility = View.INVISIBLE");
            i = 4;
          }
          else
          {
            Log.d("MicroMsg.emoji.TouchInterceptorListView", "2. height = 1");
            i = 0;
            j = 1;
          }
        }
        else if (k == i2 - i3)
        {
          if ((this.riS >= i4) && (this.riS < getCount()))
          {
            j = this.rjd;
            Log.d("MicroMsg.emoji.TouchInterceptorListView", "3. height = mItemHeightExpanded;");
            i = 0;
          }
          else
          {
            Log.d("MicroMsg.emoji.TouchInterceptorListView", "3. ");
            i = 0;
          }
        }
        else
        {
          Log.d("MicroMsg.emoji.TouchInterceptorListView", "4");
          i = 0;
        }
      }
      label910:
      if (i1 >= this.mHeight / 3) {
        this.riZ = (this.mHeight / 3);
      }
      if (i1 <= this.mHeight * 2 / 3) {
        this.rja = (this.mHeight * 2 / 3);
      }
      if (i1 > this.rja) {
        if (getLastVisiblePosition() < getCount() - 1)
        {
          i = n;
          if (i1 > (this.mHeight + this.rja) / 2) {
            i = 16;
          }
        }
      }
      for (;;)
      {
        label1000:
        if ((i != 0) && (!d.oE(8)))
        {
          smoothScrollBy(i, 30);
          break;
          i = 1;
          continue;
          i = m;
          if (i1 < this.riZ) {
            if (i1 >= this.riZ / 2) {
              break label1085;
            }
          }
        }
      }
      label1085:
      for (int j = -16;; j = -4)
      {
        if (getFirstVisiblePosition() == 0)
        {
          i = m;
          if (getChildAt(0).getTop() >= getPaddingTop()) {
            break label1000;
          }
        }
        i = j;
        break label1000;
        break;
      }
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(109094);
    return bool;
  }
  
  public void setDragListener(a parama)
  {
    this.riW = parama;
  }
  
  public void setDropListener(b paramb)
  {
    this.riX = paramb;
  }
  
  public void setRemoveListener(c paramc)
  {
    this.riY = paramc;
  }
  
  public void setTrashcan(Drawable paramDrawable)
  {
    this.rjf = paramDrawable;
    this.rjb = 2;
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
  
  public static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.TouchInterceptorListView
 * JD-Core Version:    0.7.0.1
 */