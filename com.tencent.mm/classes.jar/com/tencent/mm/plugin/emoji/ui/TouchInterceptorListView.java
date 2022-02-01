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
import com.tencent.mm.sdk.platformtools.ad;

public class TouchInterceptorListView
  extends ListView
{
  private int afr;
  private int afs;
  private WindowManager gKC;
  private GestureDetector lsn;
  private int mHeight;
  private Rect mTempRect;
  private final int mTouchSlop;
  private WindowManager.LayoutParams mWindowParams;
  private int pAY;
  private Drawable pLA;
  private int pLB;
  private ImageView pLm;
  private int pLn;
  private int pLo;
  private int pLp;
  private int pLq;
  private a pLr;
  private b pLs;
  private c pLt;
  private int pLu;
  private int pLv;
  private int pLw;
  private Bitmap pLx;
  private int pLy;
  private int pLz;
  
  public TouchInterceptorListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109090);
    this.pLw = -1;
    this.mTempRect = new Rect();
    this.pLB = 0;
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    paramContext = getResources();
    this.pAY = (paramContext.getDimensionPixelSize(2131166229) + 1);
    this.pLz = (this.pAY / 2);
    this.pLy = (this.pAY * 2);
    this.pLB = paramContext.getDimensionPixelOffset(2131166236);
    AppMethodBeat.o(109090);
  }
  
  private void ciy()
  {
    AppMethodBeat.i(109095);
    if (this.pLm != null)
    {
      this.pLm.setVisibility(8);
      ((WindowManager)getContext().getSystemService("window")).removeView(this.pLm);
      this.pLm.setImageDrawable(null);
      this.pLm = null;
    }
    if (this.pLx != null)
    {
      ad.i("MicroMsg.emoji.TouchInterceptorListView", "bitmap recycle %s", new Object[] { this.pLx });
      this.pLx.recycle();
      this.pLx = null;
    }
    if (this.pLA != null) {
      this.pLA.setLevel(0);
    }
    AppMethodBeat.o(109095);
  }
  
  private int fm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109092);
    if (paramInt2 < 0)
    {
      i = fm(paramInt1, this.pAY + paramInt2);
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
  
  private void ku(boolean paramBoolean)
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
      ((ViewGroup.LayoutParams)localObject1).height = this.pAY;
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((View)localObject2).setVisibility(0);
      i += 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(109091);
    if ((this.pLt != null) && (this.lsn == null) && (this.pLw == 0)) {
      this.lsn = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
      {
        public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(198769);
          b localb = new b();
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
          boolean bool = super.onContextClick(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(198769);
          return bool;
        }
        
        public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(198768);
          b localb = new b();
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
          boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(198768);
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
          AppMethodBeat.i(198767);
          b localb = new b();
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
          super.onLongPress(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
          AppMethodBeat.o(198767);
        }
        
        public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(198766);
          b localb = new b();
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
          boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(198766);
          return bool;
        }
      });
    }
    if ((this.pLr != null) || (this.pLs != null)) {
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
        this.pLp = (j - ((ViewGroup)localObject).getLeft());
        this.pLq = (i - ((ViewGroup)localObject).getTop());
        this.afr = ((int)paramMotionEvent.getRawX() - j);
        this.afs = ((int)paramMotionEvent.getRawY() - i);
        if (j < this.pLB)
        {
          ((ViewGroup)localObject).setDrawingCacheEnabled(true);
          paramMotionEvent = Bitmap.createBitmap(((ViewGroup)localObject).getDrawingCache());
          ciy();
          this.mWindowParams = new WindowManager.LayoutParams();
          this.mWindowParams.gravity = 49;
          this.mWindowParams.x = (j - this.pLp + this.afr);
          this.mWindowParams.y = (i - this.pLq + this.afs);
          this.mWindowParams.height = -2;
          this.mWindowParams.width = -2;
          this.mWindowParams.flags = 920;
          this.mWindowParams.format = -3;
          this.mWindowParams.windowAnimations = 0;
          localObject = getContext();
          ImageView localImageView = new ImageView((Context)localObject);
          localImageView.setBackgroundColor(((Context)localObject).getResources().getColor(2131101179));
          localImageView.setBackgroundResource(2131232093);
          localImageView.setPadding(0, 0, 0, 0);
          localImageView.setImageBitmap(paramMotionEvent);
          this.pLx = paramMotionEvent;
          this.gKC = ((WindowManager)((Context)localObject).getSystemService("window"));
          this.gKC.addView(localImageView, this.mWindowParams);
          this.pLm = localImageView;
          this.pLn = k;
          this.pLo = this.pLn;
          this.mHeight = getHeight();
          j = this.mTouchSlop;
          this.pLu = Math.min(i - j, this.mHeight / 3);
          this.pLv = Math.max(j + i, this.mHeight * 2 / 3);
          AppMethodBeat.o(109091);
          return false;
        }
        ciy();
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
    if (this.lsn != null)
    {
      localObject1 = this.lsn;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((GestureDetector)localObject1).onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0)), "com/tencent/mm/plugin/emoji/ui/TouchInterceptorListView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    if (((this.pLr != null) || (this.pLs != null)) && (this.pLm != null))
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
          this.pLm.getDrawingRect((Rect)localObject1);
          ciy();
          if ((this.pLw == 1) && (paramMotionEvent.getX() > ((Rect)localObject1).right * 3 / 4))
          {
            ku(true);
          }
          else
          {
            if ((this.pLs != null) && (this.pLn >= 0)) {
              getCount();
            }
            ku(false);
          }
        }
      }
      int i = (int)paramMotionEvent.getX();
      int i1 = (int)paramMotionEvent.getY();
      if (this.pLw == 1)
      {
        float f = 1.0F;
        j = this.pLm.getWidth();
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
      if ((this.pLw == 0) || (this.pLw == 2))
      {
        this.mWindowParams.x = (i - this.pLp + this.afr);
        this.mWindowParams.y = (i1 - this.pLq + this.afs);
        this.gKC.updateViewLayout(this.pLm, this.mWindowParams);
        if (this.pLA != null)
        {
          j = this.pLm.getWidth();
          if (i1 <= getHeight() * 3 / 4) {
            break label698;
          }
          this.pLA.setLevel(2);
        }
        i2 = i1 - this.pLq - this.pLz;
        j = fm(0, i2);
        if (j < 0) {
          break label735;
        }
        i = j;
        if (j <= this.pLo) {
          i = j + 1;
        }
        if (i < 0) {
          break label746;
        }
        if ((k != 0) && (i == this.pLn)) {
          break label910;
        }
        this.pLn = i;
        ad.d("MicroMsg.emoji.TouchInterceptorListView", "doExpansion mDragPos:%d mSrcDragPos:%d", new Object[] { Integer.valueOf(this.pLn), Integer.valueOf(this.pLo) });
        ad.d("MicroMsg.emoji.TouchInterceptorListView", "getFirstVisiblePosition:%d", new Object[] { Integer.valueOf(getFirstVisiblePosition()) });
        ad.d("MicroMsg.emoji.TouchInterceptorListView", "getHeaderViewsCount:%d", new Object[] { Integer.valueOf(getHeaderViewsCount()) });
        i2 = this.pLn;
        i3 = getFirstVisiblePosition();
        i4 = getHeaderViewsCount();
        paramMotionEvent = getChildAt(this.pLo - getFirstVisiblePosition());
        k = 0;
        label597:
        localObject1 = getChildAt(k);
        if (localObject1 == null) {
          break label910;
        }
        j = this.pAY;
        if ((this.pLn >= i4) || (k != i4)) {
          break label767;
        }
        if (!localObject1.equals(paramMotionEvent)) {
          break label748;
        }
        ad.d("MicroMsg.emoji.TouchInterceptorListView", "1. visibility = View.INVISIBLE");
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
          this.pLA.setLevel(1);
          break label419;
        }
        this.pLA.setLevel(0);
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
        j = this.pLy;
        ad.d("MicroMsg.emoji.TouchInterceptorListView", "1. height = mItemHeightExpanded");
        i = 0;
        continue;
        label767:
        if (localObject1.equals(paramMotionEvent))
        {
          if ((this.pLn == this.pLo) || (getPositionForView((View)localObject1) == getCount()))
          {
            j = this.pAY;
            ad.d("MicroMsg.emoji.TouchInterceptorListView", "2. visibility = View.INVISIBLE");
            i = 4;
          }
          else
          {
            ad.d("MicroMsg.emoji.TouchInterceptorListView", "2. height = 1");
            i = 0;
            j = 1;
          }
        }
        else if (k == i2 - i3)
        {
          if ((this.pLn >= i4) && (this.pLn < getCount()))
          {
            j = this.pLy;
            ad.d("MicroMsg.emoji.TouchInterceptorListView", "3. height = mItemHeightExpanded;");
            i = 0;
          }
          else
          {
            ad.d("MicroMsg.emoji.TouchInterceptorListView", "3. ");
            i = 0;
          }
        }
        else
        {
          ad.d("MicroMsg.emoji.TouchInterceptorListView", "4");
          i = 0;
        }
      }
      label910:
      if (i1 >= this.mHeight / 3) {
        this.pLu = (this.mHeight / 3);
      }
      if (i1 <= this.mHeight * 2 / 3) {
        this.pLv = (this.mHeight * 2 / 3);
      }
      if (i1 > this.pLv) {
        if (getLastVisiblePosition() < getCount() - 1)
        {
          i = n;
          if (i1 > (this.mHeight + this.pLv) / 2) {
            i = 16;
          }
        }
      }
      for (;;)
      {
        label1000:
        if ((i != 0) && (!d.lz(8)))
        {
          smoothScrollBy(i, 30);
          break;
          i = 1;
          continue;
          i = m;
          if (i1 < this.pLu) {
            if (i1 >= this.pLu / 2) {
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
    this.pLr = parama;
  }
  
  public void setDropListener(b paramb)
  {
    this.pLs = paramb;
  }
  
  public void setRemoveListener(c paramc)
  {
    this.pLt = paramc;
  }
  
  public void setTrashcan(Drawable paramDrawable)
  {
    this.pLA = paramDrawable;
    this.pLw = 2;
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
  
  public static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.TouchInterceptorListView
 * JD-Core Version:    0.7.0.1
 */