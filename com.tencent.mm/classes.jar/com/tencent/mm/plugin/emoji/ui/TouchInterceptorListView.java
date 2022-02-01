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
import com.tencent.mm.sdk.platformtools.ad;

public class TouchInterceptorListView
  extends ListView
{
  private int acG;
  private int acH;
  private GestureDetector ktZ;
  private int mHeight;
  private Rect mTempRect;
  private final int mTouchSlop;
  private WindowManager.LayoutParams mWindowParams;
  private int oEA;
  private ImageView oEk;
  private WindowManager oEl;
  private int oEm;
  private int oEn;
  private int oEo;
  private int oEp;
  private a oEq;
  private b oEr;
  private c oEs;
  private int oEt;
  private int oEu;
  private int oEv;
  private Bitmap oEw;
  private int oEx;
  private int oEy;
  private Drawable oEz;
  private int otN;
  
  public TouchInterceptorListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109090);
    this.oEv = -1;
    this.mTempRect = new Rect();
    this.oEA = 0;
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    paramContext = getResources();
    this.otN = (paramContext.getDimensionPixelSize(2131166229) + 1);
    this.oEy = (this.otN / 2);
    this.oEx = (this.otN * 2);
    this.oEA = paramContext.getDimensionPixelOffset(2131166236);
    AppMethodBeat.o(109090);
  }
  
  private void bWI()
  {
    AppMethodBeat.i(109095);
    if (this.oEk != null)
    {
      this.oEk.setVisibility(8);
      ((WindowManager)getContext().getSystemService("window")).removeView(this.oEk);
      this.oEk.setImageDrawable(null);
      this.oEk = null;
    }
    if (this.oEw != null)
    {
      ad.i("MicroMsg.emoji.TouchInterceptorListView", "bitmap recycle %s", new Object[] { this.oEw });
      this.oEw.recycle();
      this.oEw = null;
    }
    if (this.oEz != null) {
      this.oEz.setLevel(0);
    }
    AppMethodBeat.o(109095);
  }
  
  private int ff(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109092);
    if (paramInt2 < 0)
    {
      i = ff(paramInt1, this.otN + paramInt2);
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
  
  private void jG(boolean paramBoolean)
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
      ((ViewGroup.LayoutParams)localObject1).height = this.otN;
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((View)localObject2).setVisibility(0);
      i += 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(109091);
    if ((this.oEs != null) && (this.ktZ == null) && (this.oEv == 0)) {
      this.ktZ = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
      {
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
      });
    }
    if ((this.oEq != null) || (this.oEr != null)) {
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
        this.oEo = (j - ((ViewGroup)localObject).getLeft());
        this.oEp = (i - ((ViewGroup)localObject).getTop());
        this.acG = ((int)paramMotionEvent.getRawX() - j);
        this.acH = ((int)paramMotionEvent.getRawY() - i);
        if (j < this.oEA)
        {
          ((ViewGroup)localObject).setDrawingCacheEnabled(true);
          paramMotionEvent = Bitmap.createBitmap(((ViewGroup)localObject).getDrawingCache());
          bWI();
          this.mWindowParams = new WindowManager.LayoutParams();
          this.mWindowParams.gravity = 49;
          this.mWindowParams.x = (j - this.oEo + this.acG);
          this.mWindowParams.y = (i - this.oEp + this.acH);
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
          this.oEw = paramMotionEvent;
          this.oEl = ((WindowManager)((Context)localObject).getSystemService("window"));
          this.oEl.addView(localImageView, this.mWindowParams);
          this.oEk = localImageView;
          this.oEm = k;
          this.oEn = this.oEm;
          this.mHeight = getHeight();
          j = this.mTouchSlop;
          this.oEt = Math.min(i - j, this.mHeight / 3);
          this.oEu = Math.max(j + i, this.mHeight * 2 / 3);
          AppMethodBeat.o(109091);
          return false;
        }
        bWI();
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = 4;
    int m = 0;
    AppMethodBeat.i(109094);
    if (this.ktZ != null) {
      this.ktZ.onTouchEvent(paramMotionEvent);
    }
    if (((this.oEq != null) || (this.oEr != null)) && (this.oEk != null))
    {
      int k = paramMotionEvent.getAction();
      Object localObject;
      switch (k)
      {
      default: 
      case 1: 
      case 3: 
        for (;;)
        {
          AppMethodBeat.o(109094);
          return true;
          localObject = this.mTempRect;
          this.oEk.getDrawingRect((Rect)localObject);
          bWI();
          if ((this.oEv == 1) && (paramMotionEvent.getX() > ((Rect)localObject).right * 3 / 4))
          {
            jG(true);
          }
          else
          {
            if ((this.oEr != null) && (this.oEm >= 0)) {
              getCount();
            }
            jG(false);
          }
        }
      }
      int i = (int)paramMotionEvent.getX();
      int i1 = (int)paramMotionEvent.getY();
      if (this.oEv == 1)
      {
        float f = 1.0F;
        j = this.oEk.getWidth();
        if (i > j / 2) {
          f = (j - i) / (j / 2);
        }
        this.mWindowParams.alpha = f;
      }
      label269:
      label343:
      int i2;
      label388:
      int i3;
      int i4;
      if ((this.oEv == 0) || (this.oEv == 2))
      {
        this.mWindowParams.x = (i - this.oEo + this.acG);
        this.mWindowParams.y = (i1 - this.oEp + this.acH);
        this.oEl.updateViewLayout(this.oEk, this.mWindowParams);
        if (this.oEz != null)
        {
          j = this.oEk.getWidth();
          if (i1 <= getHeight() * 3 / 4) {
            break label622;
          }
          this.oEz.setLevel(2);
        }
        i2 = i1 - this.oEp - this.oEy;
        j = ff(0, i2);
        if (j < 0) {
          break label659;
        }
        i = j;
        if (j <= this.oEn) {
          i = j + 1;
        }
        if (i < 0) {
          break label670;
        }
        if ((k != 0) && (i == this.oEm)) {
          break label834;
        }
        this.oEm = i;
        ad.d("MicroMsg.emoji.TouchInterceptorListView", "doExpansion mDragPos:%d mSrcDragPos:%d", new Object[] { Integer.valueOf(this.oEm), Integer.valueOf(this.oEn) });
        ad.d("MicroMsg.emoji.TouchInterceptorListView", "getFirstVisiblePosition:%d", new Object[] { Integer.valueOf(getFirstVisiblePosition()) });
        ad.d("MicroMsg.emoji.TouchInterceptorListView", "getHeaderViewsCount:%d", new Object[] { Integer.valueOf(getHeaderViewsCount()) });
        i2 = this.oEm;
        i3 = getFirstVisiblePosition();
        i4 = getHeaderViewsCount();
        paramMotionEvent = getChildAt(this.oEn - getFirstVisiblePosition());
        k = 0;
        label521:
        localObject = getChildAt(k);
        if (localObject == null) {
          break label834;
        }
        j = this.otN;
        if ((this.oEm >= i4) || (k != i4)) {
          break label691;
        }
        if (!localObject.equals(paramMotionEvent)) {
          break label672;
        }
        ad.d("MicroMsg.emoji.TouchInterceptorListView", "1. visibility = View.INVISIBLE");
        i = 4;
      }
      for (;;)
      {
        ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
        localLayoutParams.height = j;
        ((View)localObject).setLayoutParams(localLayoutParams);
        ((View)localObject).setVisibility(i);
        k += 1;
        break label521;
        this.mWindowParams.x = 0;
        break label269;
        label622:
        if ((j > 0) && (i > j / 4))
        {
          this.oEz.setLevel(1);
          break label343;
        }
        this.oEz.setLevel(0);
        break label343;
        label659:
        i = j;
        if (i2 >= 0) {
          break label388;
        }
        i = 0;
        break label388;
        label670:
        break;
        label672:
        j = this.oEx;
        ad.d("MicroMsg.emoji.TouchInterceptorListView", "1. height = mItemHeightExpanded");
        i = 0;
        continue;
        label691:
        if (localObject.equals(paramMotionEvent))
        {
          if ((this.oEm == this.oEn) || (getPositionForView((View)localObject) == getCount()))
          {
            j = this.otN;
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
          if ((this.oEm >= i4) && (this.oEm < getCount()))
          {
            j = this.oEx;
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
      label834:
      if (i1 >= this.mHeight / 3) {
        this.oEt = (this.mHeight / 3);
      }
      if (i1 <= this.mHeight * 2 / 3) {
        this.oEu = (this.mHeight * 2 / 3);
      }
      if (i1 > this.oEu) {
        if (getLastVisiblePosition() < getCount() - 1)
        {
          i = n;
          if (i1 > (this.mHeight + this.oEu) / 2) {
            i = 16;
          }
        }
      }
      for (;;)
      {
        label924:
        if ((i != 0) && (!d.lg(8)))
        {
          smoothScrollBy(i, 30);
          break;
          i = 1;
          continue;
          i = m;
          if (i1 < this.oEt) {
            if (i1 >= this.oEt / 2) {
              break label1009;
            }
          }
        }
      }
      label1009:
      for (int j = -16;; j = -4)
      {
        if (getFirstVisiblePosition() == 0)
        {
          i = m;
          if (getChildAt(0).getTop() >= getPaddingTop()) {
            break label924;
          }
        }
        i = j;
        break label924;
        break;
      }
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(109094);
    return bool;
  }
  
  public void setDragListener(a parama)
  {
    this.oEq = parama;
  }
  
  public void setDropListener(b paramb)
  {
    this.oEr = paramb;
  }
  
  public void setRemoveListener(c paramc)
  {
    this.oEs = paramc;
  }
  
  public void setTrashcan(Drawable paramDrawable)
  {
    this.oEz = paramDrawable;
    this.oEv = 2;
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
  
  public static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.TouchInterceptorListView
 * JD-Core Version:    0.7.0.1
 */