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
import com.tencent.mm.plugin.emoji.i.b;
import com.tencent.mm.plugin.emoji.i.c;
import com.tencent.mm.plugin.emoji.i.d;
import com.tencent.mm.sdk.platformtools.Log;

public class TouchInterceptorListView
  extends ListView
{
  private int lO;
  private int lP;
  private int mHeight;
  private Rect mTempRect;
  private final int mTouchSlop;
  private WindowManager mWindowManager;
  private WindowManager.LayoutParams mWindowParams;
  private GestureDetector pCU;
  private int uAc;
  private ImageView uMa;
  private int uMb;
  private int uMc;
  private int uMd;
  private int uMe;
  private a uMf;
  private b uMg;
  private c uMh;
  private int uMi;
  private int uMj;
  private int uMk;
  private Bitmap uMl;
  private int uMm;
  private int uMn;
  private Drawable uMo;
  private int uMp;
  
  public TouchInterceptorListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109090);
    this.uMk = -1;
    this.mTempRect = new Rect();
    this.uMp = 0;
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    paramContext = getResources();
    this.uAc = (paramContext.getDimensionPixelSize(i.c.emoji_item_list_height) + 1);
    this.uMn = (this.uAc / 2);
    this.uMm = (this.uAc * 2);
    this.uMp = paramContext.getDimensionPixelOffset(i.c.emoji_itme_drag_width);
    AppMethodBeat.o(109090);
  }
  
  private void cWw()
  {
    AppMethodBeat.i(109095);
    if (this.uMa != null)
    {
      this.uMa.setVisibility(8);
      ((WindowManager)getContext().getSystemService("window")).removeView(this.uMa);
      this.uMa.setImageDrawable(null);
      this.uMa = null;
    }
    if (this.uMl != null)
    {
      Log.i("MicroMsg.emoji.TouchInterceptorListView", "bitmap recycle %s", new Object[] { this.uMl });
      this.uMl.recycle();
      this.uMl = null;
    }
    if (this.uMo != null) {
      this.uMo.setLevel(0);
    }
    AppMethodBeat.o(109095);
  }
  
  private int ga(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109092);
    if (paramInt2 < 0)
    {
      i = ga(paramInt1, this.uAc + paramInt2);
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
  
  private void mG(boolean paramBoolean)
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
      ((ViewGroup.LayoutParams)localObject1).height = this.uAc;
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((View)localObject2).setVisibility(0);
      i += 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(109091);
    if ((this.uMh != null) && (this.pCU == null) && (this.uMk == 0)) {
      this.pCU = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
      {
        public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(257086);
          b localb = new b();
          localb.bn(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
          boolean bool = super.onContextClick(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(257086);
          return bool;
        }
        
        public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(257085);
          b localb = new b();
          localb.bn(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
          boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(257085);
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
          AppMethodBeat.i(257084);
          b localb = new b();
          localb.bn(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
          super.onLongPress(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
          AppMethodBeat.o(257084);
        }
        
        public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(257083);
          b localb = new b();
          localb.bn(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
          boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(257083);
          return bool;
        }
      });
    }
    if ((this.uMf != null) || (this.uMg != null)) {
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
        this.uMd = (j - ((ViewGroup)localObject).getLeft());
        this.uMe = (i - ((ViewGroup)localObject).getTop());
        this.lO = ((int)paramMotionEvent.getRawX() - j);
        this.lP = ((int)paramMotionEvent.getRawY() - i);
        if (j < this.uMp)
        {
          ((ViewGroup)localObject).setDrawingCacheEnabled(true);
          paramMotionEvent = Bitmap.createBitmap(((ViewGroup)localObject).getDrawingCache());
          cWw();
          this.mWindowParams = new WindowManager.LayoutParams();
          this.mWindowParams.gravity = 49;
          this.mWindowParams.x = (j - this.uMd + this.lO);
          this.mWindowParams.y = (i - this.uMe + this.lP);
          this.mWindowParams.height = -2;
          this.mWindowParams.width = -2;
          this.mWindowParams.flags = 920;
          this.mWindowParams.format = -3;
          this.mWindowParams.windowAnimations = 0;
          localObject = getContext();
          ImageView localImageView = new ImageView((Context)localObject);
          localImageView.setBackgroundColor(((Context)localObject).getResources().getColor(i.b.white));
          localImageView.setBackgroundResource(i.d.emotionstore_emotionmanaged_cellshadow);
          localImageView.setPadding(0, 0, 0, 0);
          localImageView.setImageBitmap(paramMotionEvent);
          this.uMl = paramMotionEvent;
          this.mWindowManager = ((WindowManager)((Context)localObject).getSystemService("window"));
          this.mWindowManager.addView(localImageView, this.mWindowParams);
          this.uMa = localImageView;
          this.uMb = k;
          this.uMc = this.uMb;
          this.mHeight = getHeight();
          j = this.mTouchSlop;
          this.uMi = Math.min(i - j, this.mHeight / 3);
          this.uMj = Math.max(j + i, this.mHeight * 2 / 3);
          AppMethodBeat.o(109091);
          return false;
        }
        cWw();
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
    if (this.pCU != null)
    {
      localObject1 = this.pCU;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((GestureDetector)localObject1).onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)), "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    if (((this.uMf != null) || (this.uMg != null)) && (this.uMa != null))
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
          this.uMa.getDrawingRect((Rect)localObject1);
          cWw();
          if ((this.uMk == 1) && (paramMotionEvent.getX() > ((Rect)localObject1).right * 3 / 4))
          {
            mG(true);
          }
          else
          {
            if ((this.uMg != null) && (this.uMb >= 0)) {
              getCount();
            }
            mG(false);
          }
        }
      }
      int i = (int)paramMotionEvent.getX();
      int i1 = (int)paramMotionEvent.getY();
      if (this.uMk == 1)
      {
        float f = 1.0F;
        j = this.uMa.getWidth();
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
      if ((this.uMk == 0) || (this.uMk == 2))
      {
        this.mWindowParams.x = (i - this.uMd + this.lO);
        this.mWindowParams.y = (i1 - this.uMe + this.lP);
        this.mWindowManager.updateViewLayout(this.uMa, this.mWindowParams);
        if (this.uMo != null)
        {
          j = this.uMa.getWidth();
          if (i1 <= getHeight() * 3 / 4) {
            break label698;
          }
          this.uMo.setLevel(2);
        }
        i2 = i1 - this.uMe - this.uMn;
        j = ga(0, i2);
        if (j < 0) {
          break label735;
        }
        i = j;
        if (j <= this.uMc) {
          i = j + 1;
        }
        if (i < 0) {
          break label746;
        }
        if ((k != 0) && (i == this.uMb)) {
          break label910;
        }
        this.uMb = i;
        Log.d("MicroMsg.emoji.TouchInterceptorListView", "doExpansion mDragPos:%d mSrcDragPos:%d", new Object[] { Integer.valueOf(this.uMb), Integer.valueOf(this.uMc) });
        Log.d("MicroMsg.emoji.TouchInterceptorListView", "getFirstVisiblePosition:%d", new Object[] { Integer.valueOf(getFirstVisiblePosition()) });
        Log.d("MicroMsg.emoji.TouchInterceptorListView", "getHeaderViewsCount:%d", new Object[] { Integer.valueOf(getHeaderViewsCount()) });
        i2 = this.uMb;
        i3 = getFirstVisiblePosition();
        i4 = getHeaderViewsCount();
        paramMotionEvent = getChildAt(this.uMc - getFirstVisiblePosition());
        k = 0;
        label597:
        localObject1 = getChildAt(k);
        if (localObject1 == null) {
          break label910;
        }
        j = this.uAc;
        if ((this.uMb >= i4) || (k != i4)) {
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
          this.uMo.setLevel(1);
          break label419;
        }
        this.uMo.setLevel(0);
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
        j = this.uMm;
        Log.d("MicroMsg.emoji.TouchInterceptorListView", "1. height = mItemHeightExpanded");
        i = 0;
        continue;
        label767:
        if (localObject1.equals(paramMotionEvent))
        {
          if ((this.uMb == this.uMc) || (getPositionForView((View)localObject1) == getCount()))
          {
            j = this.uAc;
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
          if ((this.uMb >= i4) && (this.uMb < getCount()))
          {
            j = this.uMm;
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
        this.uMi = (this.mHeight / 3);
      }
      if (i1 <= this.mHeight * 2 / 3) {
        this.uMj = (this.mHeight * 2 / 3);
      }
      if (i1 > this.uMj) {
        if (getLastVisiblePosition() < getCount() - 1)
        {
          i = n;
          if (i1 > (this.mHeight + this.uMj) / 2) {
            i = 16;
          }
        }
      }
      for (;;)
      {
        label1000:
        if ((i != 0) && (!d.qW(8)))
        {
          smoothScrollBy(i, 30);
          break;
          i = 1;
          continue;
          i = m;
          if (i1 < this.uMi) {
            if (i1 >= this.uMi / 2) {
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
    this.uMf = parama;
  }
  
  public void setDropListener(b paramb)
  {
    this.uMg = paramb;
  }
  
  public void setRemoveListener(c paramc)
  {
    this.uMh = paramc;
  }
  
  public void setTrashcan(Drawable paramDrawable)
  {
    this.uMo = paramDrawable;
    this.uMk = 2;
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
  
  public static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.TouchInterceptorListView
 * JD-Core Version:    0.7.0.1
 */