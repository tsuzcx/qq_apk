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
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.plugin.emoji.h.d;
import com.tencent.mm.sdk.platformtools.Log;

public class TouchInterceptorListView
  extends ListView
{
  private int mHeight;
  private int mL;
  private int mM;
  private GestureDetector mQj;
  private Rect mTempRect;
  private final int mTouchSlop;
  private WindowManager mWindowManager;
  private int xGF;
  private ImageView xUB;
  private WindowManager.LayoutParams xUC;
  private int xUD;
  private int xUE;
  private int xUF;
  private int xUG;
  private a xUH;
  private b xUI;
  private c xUJ;
  private int xUK;
  private int xUL;
  private int xUM;
  private Bitmap xUN;
  private int xUO;
  private int xUP;
  private Drawable xUQ;
  private int xUR;
  
  public TouchInterceptorListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109090);
    this.xUM = -1;
    this.mTempRect = new Rect();
    this.xUR = 0;
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    paramContext = getResources();
    this.xGF = (paramContext.getDimensionPixelSize(h.c.emoji_item_list_height) + 1);
    this.xUP = (this.xGF / 2);
    this.xUO = (this.xGF * 2);
    this.xUR = paramContext.getDimensionPixelOffset(h.c.emoji_itme_drag_width);
    AppMethodBeat.o(109090);
  }
  
  private void dCa()
  {
    AppMethodBeat.i(109095);
    if (this.xUB != null)
    {
      this.xUB.setVisibility(8);
      ((WindowManager)getContext().getSystemService("window")).removeView(this.xUB);
      this.xUB.setImageDrawable(null);
      this.xUB = null;
    }
    if (this.xUN != null)
    {
      Log.i("MicroMsg.emoji.TouchInterceptorListView", "bitmap recycle %s", new Object[] { this.xUN });
      this.xUN.recycle();
      this.xUN = null;
    }
    if (this.xUQ != null) {
      this.xUQ.setLevel(0);
    }
    AppMethodBeat.o(109095);
  }
  
  private int gT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109092);
    if (paramInt2 < 0)
    {
      i = gT(paramInt1, this.xGF + paramInt2);
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
  
  private void od(boolean paramBoolean)
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
      ((ViewGroup.LayoutParams)localObject1).height = this.xGF;
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((View)localObject2).setVisibility(0);
      i += 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(109091);
    if ((this.xUJ != null) && (this.mQj == null) && (this.xUM == 0)) {
      this.mQj = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
      {
        public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(270419);
          b localb = new b();
          localb.cH(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
          boolean bool = super.onContextClick(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(270419);
          return bool;
        }
        
        public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(270416);
          b localb = new b();
          localb.cH(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
          boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(270416);
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
          AppMethodBeat.i(270413);
          b localb = new b();
          localb.cH(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
          super.onLongPress(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
          AppMethodBeat.o(270413);
        }
        
        public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(270410);
          b localb = new b();
          localb.cH(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
          boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(270410);
          return bool;
        }
      });
    }
    if ((this.xUH != null) || (this.xUI != null)) {
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
        this.xUF = (j - ((ViewGroup)localObject).getLeft());
        this.xUG = (i - ((ViewGroup)localObject).getTop());
        this.mL = ((int)paramMotionEvent.getRawX() - j);
        this.mM = ((int)paramMotionEvent.getRawY() - i);
        if (j < this.xUR)
        {
          ((ViewGroup)localObject).setDrawingCacheEnabled(true);
          paramMotionEvent = Bitmap.createBitmap(((ViewGroup)localObject).getDrawingCache());
          dCa();
          this.xUC = new WindowManager.LayoutParams();
          this.xUC.gravity = 49;
          this.xUC.x = (j - this.xUF + this.mL);
          this.xUC.y = (i - this.xUG + this.mM);
          this.xUC.height = -2;
          this.xUC.width = -2;
          this.xUC.flags = 920;
          this.xUC.format = -3;
          this.xUC.windowAnimations = 0;
          localObject = getContext();
          ImageView localImageView = new ImageView((Context)localObject);
          localImageView.setBackgroundColor(((Context)localObject).getResources().getColor(h.b.white));
          localImageView.setBackgroundResource(h.d.emotionstore_emotionmanaged_cellshadow);
          localImageView.setPadding(0, 0, 0, 0);
          localImageView.setImageBitmap(paramMotionEvent);
          this.xUN = paramMotionEvent;
          this.mWindowManager = ((WindowManager)((Context)localObject).getSystemService("window"));
          this.mWindowManager.addView(localImageView, this.xUC);
          this.xUB = localImageView;
          this.xUD = k;
          this.xUE = this.xUD;
          this.mHeight = getHeight();
          j = this.mTouchSlop;
          this.xUK = Math.min(i - j, this.mHeight / 3);
          this.xUL = Math.max(j + i, this.mHeight * 2 / 3);
          AppMethodBeat.o(109091);
          return false;
        }
        dCa();
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
    if (this.mQj != null)
    {
      localObject1 = this.mQj;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((GestureDetector)localObject1).onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)), "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    if (((this.xUH != null) || (this.xUI != null)) && (this.xUB != null))
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
          this.xUB.getDrawingRect((Rect)localObject1);
          dCa();
          if ((this.xUM == 1) && (paramMotionEvent.getX() > ((Rect)localObject1).right * 3 / 4))
          {
            od(true);
          }
          else
          {
            if ((this.xUI != null) && (this.xUD >= 0)) {
              getCount();
            }
            od(false);
          }
        }
      }
      int i = (int)paramMotionEvent.getX();
      int i1 = (int)paramMotionEvent.getY();
      if (this.xUM == 1)
      {
        float f = 1.0F;
        j = this.xUB.getWidth();
        if (i > j / 2) {
          f = (j - i) / (j / 2);
        }
        this.xUC.alpha = f;
      }
      label345:
      int i2;
      label419:
      label464:
      int i3;
      int i4;
      if ((this.xUM == 0) || (this.xUM == 2))
      {
        this.xUC.x = (i - this.xUF + this.mL);
        this.xUC.y = (i1 - this.xUG + this.mM);
        this.mWindowManager.updateViewLayout(this.xUB, this.xUC);
        if (this.xUQ != null)
        {
          j = this.xUB.getWidth();
          if (i1 <= getHeight() * 3 / 4) {
            break label698;
          }
          this.xUQ.setLevel(2);
        }
        i2 = i1 - this.xUG - this.xUP;
        j = gT(0, i2);
        if (j < 0) {
          break label735;
        }
        i = j;
        if (j <= this.xUE) {
          i = j + 1;
        }
        if (i < 0) {
          break label746;
        }
        if ((k != 0) && (i == this.xUD)) {
          break label910;
        }
        this.xUD = i;
        Log.d("MicroMsg.emoji.TouchInterceptorListView", "doExpansion mDragPos:%d mSrcDragPos:%d", new Object[] { Integer.valueOf(this.xUD), Integer.valueOf(this.xUE) });
        Log.d("MicroMsg.emoji.TouchInterceptorListView", "getFirstVisiblePosition:%d", new Object[] { Integer.valueOf(getFirstVisiblePosition()) });
        Log.d("MicroMsg.emoji.TouchInterceptorListView", "getHeaderViewsCount:%d", new Object[] { Integer.valueOf(getHeaderViewsCount()) });
        i2 = this.xUD;
        i3 = getFirstVisiblePosition();
        i4 = getHeaderViewsCount();
        paramMotionEvent = getChildAt(this.xUE - getFirstVisiblePosition());
        k = 0;
        label597:
        localObject1 = getChildAt(k);
        if (localObject1 == null) {
          break label910;
        }
        j = this.xGF;
        if ((this.xUD >= i4) || (k != i4)) {
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
        this.xUC.x = 0;
        break label345;
        label698:
        if ((j > 0) && (i > j / 4))
        {
          this.xUQ.setLevel(1);
          break label419;
        }
        this.xUQ.setLevel(0);
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
        j = this.xUO;
        Log.d("MicroMsg.emoji.TouchInterceptorListView", "1. height = mItemHeightExpanded");
        i = 0;
        continue;
        label767:
        if (localObject1.equals(paramMotionEvent))
        {
          if ((this.xUD == this.xUE) || (getPositionForView((View)localObject1) == getCount()))
          {
            j = this.xGF;
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
          if ((this.xUD >= i4) && (this.xUD < getCount()))
          {
            j = this.xUO;
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
        this.xUK = (this.mHeight / 3);
      }
      if (i1 <= this.mHeight * 2 / 3) {
        this.xUL = (this.mHeight * 2 / 3);
      }
      if (i1 > this.xUL) {
        if (getLastVisiblePosition() < getCount() - 1)
        {
          i = n;
          if (i1 > (this.mHeight + this.xUL) / 2) {
            i = 16;
          }
        }
      }
      for (;;)
      {
        label1000:
        if ((i != 0) && (!d.rc(8)))
        {
          smoothScrollBy(i, 30);
          break;
          i = 1;
          continue;
          i = m;
          if (i1 < this.xUK) {
            if (i1 >= this.xUK / 2) {
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
    this.xUH = parama;
  }
  
  public void setDropListener(b paramb)
  {
    this.xUI = paramb;
  }
  
  public void setRemoveListener(c paramc)
  {
    this.xUJ = paramc;
  }
  
  public void setTrashcan(Drawable paramDrawable)
  {
    this.xUQ = paramDrawable;
    this.xUM = 2;
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
  
  public static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.TouchInterceptorListView
 * JD-Core Version:    0.7.0.1
 */