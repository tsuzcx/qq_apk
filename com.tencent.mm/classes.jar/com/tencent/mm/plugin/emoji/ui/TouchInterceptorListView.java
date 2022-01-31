package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
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
import com.tencent.mm.sdk.platformtools.ab;

public class TouchInterceptorListView
  extends ListView
{
  private int VB;
  private int VC;
  private GestureDetector idY;
  private int led;
  private ImageView lnT;
  private WindowManager lnU;
  private WindowManager.LayoutParams lnV;
  private int lnW;
  private int lnX;
  private int lnY;
  private int lnZ;
  private TouchInterceptorListView.a loa;
  private TouchInterceptorListView.b lob;
  private TouchInterceptorListView.c lod;
  private int loe;
  private int lof;
  private int loh;
  private Bitmap loi;
  private int loj;
  private int lok;
  private Drawable lol;
  private int lom;
  private int mHeight;
  private Rect mTempRect;
  private final int mTouchSlop;
  
  public TouchInterceptorListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(53527);
    this.loh = -1;
    this.mTempRect = new Rect();
    this.lom = 0;
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    paramContext = getResources();
    this.led = (paramContext.getDimensionPixelSize(2131428372) + 1);
    this.lok = (this.led / 2);
    this.loj = (this.led * 2);
    this.lom = paramContext.getDimensionPixelOffset(2131428379);
    AppMethodBeat.o(53527);
  }
  
  private void bmY()
  {
    AppMethodBeat.i(53532);
    if (this.lnT != null)
    {
      this.lnT.setVisibility(8);
      ((WindowManager)getContext().getSystemService("window")).removeView(this.lnT);
      this.lnT.setImageDrawable(null);
      this.lnT = null;
    }
    if (this.loi != null)
    {
      ab.i("MicroMsg.emoji.TouchInterceptorListView", "bitmap recycle %s", new Object[] { this.loi });
      this.loi.recycle();
      this.loi = null;
    }
    if (this.lol != null) {
      this.lol.setLevel(0);
    }
    AppMethodBeat.o(53532);
  }
  
  private int ec(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(53529);
    if (paramInt2 < 0)
    {
      i = ec(paramInt1, this.led + paramInt2);
      if (i > 0)
      {
        AppMethodBeat.o(53529);
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
        AppMethodBeat.o(53529);
        return i + paramInt1;
      }
      i -= 1;
    }
    AppMethodBeat.o(53529);
    return -1;
  }
  
  private void gI(boolean paramBoolean)
  {
    AppMethodBeat.i(53530);
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
        AppMethodBeat.o(53530);
        return;
      }
      localObject1 = ((View)localObject2).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = this.led;
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((View)localObject2).setVisibility(0);
      i += 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(53528);
    if ((this.lod != null) && (this.idY == null) && (this.loh == 0)) {
      this.idY = new GestureDetector(getContext(), new TouchInterceptorListView.1(this));
    }
    if ((this.loa != null) || (this.lob != null)) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(53528);
      return bool;
      int j = (int)paramMotionEvent.getX();
      int i = (int)paramMotionEvent.getY();
      int k = pointToPosition(j, i);
      if (k != -1)
      {
        Object localObject = (ViewGroup)getChildAt(k - getFirstVisiblePosition());
        this.lnY = (j - ((ViewGroup)localObject).getLeft());
        this.lnZ = (i - ((ViewGroup)localObject).getTop());
        this.VB = ((int)paramMotionEvent.getRawX() - j);
        this.VC = ((int)paramMotionEvent.getRawY() - i);
        if (j < this.lom)
        {
          ((ViewGroup)localObject).setDrawingCacheEnabled(true);
          paramMotionEvent = Bitmap.createBitmap(((ViewGroup)localObject).getDrawingCache());
          bmY();
          this.lnV = new WindowManager.LayoutParams();
          this.lnV.gravity = 49;
          this.lnV.x = (j - this.lnY + this.VB);
          this.lnV.y = (i - this.lnZ + this.VC);
          this.lnV.height = -2;
          this.lnV.width = -2;
          this.lnV.flags = 920;
          this.lnV.format = -3;
          this.lnV.windowAnimations = 0;
          localObject = getContext();
          ImageView localImageView = new ImageView((Context)localObject);
          localImageView.setBackgroundColor(((Context)localObject).getResources().getColor(2131690709));
          localImageView.setBackgroundResource(2130838654);
          localImageView.setPadding(0, 0, 0, 0);
          localImageView.setImageBitmap(paramMotionEvent);
          this.loi = paramMotionEvent;
          this.lnU = ((WindowManager)((Context)localObject).getSystemService("window"));
          this.lnU.addView(localImageView, this.lnV);
          this.lnT = localImageView;
          this.lnW = k;
          this.lnX = this.lnW;
          this.mHeight = getHeight();
          j = this.mTouchSlop;
          this.loe = Math.min(i - j, this.mHeight / 3);
          this.lof = Math.max(j + i, this.mHeight * 2 / 3);
          AppMethodBeat.o(53528);
          return false;
        }
        bmY();
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = 4;
    int m = 0;
    AppMethodBeat.i(53531);
    if (this.idY != null) {
      this.idY.onTouchEvent(paramMotionEvent);
    }
    if (((this.loa != null) || (this.lob != null)) && (this.lnT != null))
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
          AppMethodBeat.o(53531);
          return true;
          localObject = this.mTempRect;
          this.lnT.getDrawingRect((Rect)localObject);
          bmY();
          if ((this.loh == 1) && (paramMotionEvent.getX() > ((Rect)localObject).right * 3 / 4))
          {
            gI(true);
          }
          else
          {
            if ((this.lob != null) && (this.lnW >= 0)) {
              getCount();
            }
            gI(false);
          }
        }
      }
      int i = (int)paramMotionEvent.getX();
      int i1 = (int)paramMotionEvent.getY();
      if (this.loh == 1)
      {
        float f = 1.0F;
        j = this.lnT.getWidth();
        if (i > j / 2) {
          f = (j - i) / (j / 2);
        }
        this.lnV.alpha = f;
      }
      label269:
      label343:
      int i2;
      label388:
      int i3;
      int i4;
      if ((this.loh == 0) || (this.loh == 2))
      {
        this.lnV.x = (i - this.lnY + this.VB);
        this.lnV.y = (i1 - this.lnZ + this.VC);
        this.lnU.updateViewLayout(this.lnT, this.lnV);
        if (this.lol != null)
        {
          j = this.lnT.getWidth();
          if (i1 <= getHeight() * 3 / 4) {
            break label622;
          }
          this.lol.setLevel(2);
        }
        i2 = i1 - this.lnZ - this.lok;
        j = ec(0, i2);
        if (j < 0) {
          break label659;
        }
        i = j;
        if (j <= this.lnX) {
          i = j + 1;
        }
        if (i < 0) {
          break label670;
        }
        if ((k != 0) && (i == this.lnW)) {
          break label834;
        }
        this.lnW = i;
        ab.d("MicroMsg.emoji.TouchInterceptorListView", "doExpansion mDragPos:%d mSrcDragPos:%d", new Object[] { Integer.valueOf(this.lnW), Integer.valueOf(this.lnX) });
        ab.d("MicroMsg.emoji.TouchInterceptorListView", "getFirstVisiblePosition:%d", new Object[] { Integer.valueOf(getFirstVisiblePosition()) });
        ab.d("MicroMsg.emoji.TouchInterceptorListView", "getHeaderViewsCount:%d", new Object[] { Integer.valueOf(getHeaderViewsCount()) });
        i2 = this.lnW;
        i3 = getFirstVisiblePosition();
        i4 = getHeaderViewsCount();
        paramMotionEvent = getChildAt(this.lnX - getFirstVisiblePosition());
        k = 0;
        label521:
        localObject = getChildAt(k);
        if (localObject == null) {
          break label834;
        }
        j = this.led;
        if ((this.lnW >= i4) || (k != i4)) {
          break label691;
        }
        if (!localObject.equals(paramMotionEvent)) {
          break label672;
        }
        ab.d("MicroMsg.emoji.TouchInterceptorListView", "1. visibility = View.INVISIBLE");
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
        this.lnV.x = 0;
        break label269;
        label622:
        if ((j > 0) && (i > j / 4))
        {
          this.lol.setLevel(1);
          break label343;
        }
        this.lol.setLevel(0);
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
        j = this.loj;
        ab.d("MicroMsg.emoji.TouchInterceptorListView", "1. height = mItemHeightExpanded");
        i = 0;
        continue;
        label691:
        if (localObject.equals(paramMotionEvent))
        {
          if ((this.lnW == this.lnX) || (getPositionForView((View)localObject) == getCount()))
          {
            j = this.led;
            ab.d("MicroMsg.emoji.TouchInterceptorListView", "2. visibility = View.INVISIBLE");
            i = 4;
          }
          else
          {
            ab.d("MicroMsg.emoji.TouchInterceptorListView", "2. height = 1");
            i = 0;
            j = 1;
          }
        }
        else if (k == i2 - i3)
        {
          if ((this.lnW >= i4) && (this.lnW < getCount()))
          {
            j = this.loj;
            ab.d("MicroMsg.emoji.TouchInterceptorListView", "3. height = mItemHeightExpanded;");
            i = 0;
          }
          else
          {
            ab.d("MicroMsg.emoji.TouchInterceptorListView", "3. ");
            i = 0;
          }
        }
        else
        {
          ab.d("MicroMsg.emoji.TouchInterceptorListView", "4");
          i = 0;
        }
      }
      label834:
      if (i1 >= this.mHeight / 3) {
        this.loe = (this.mHeight / 3);
      }
      if (i1 <= this.mHeight * 2 / 3) {
        this.lof = (this.mHeight * 2 / 3);
      }
      if (i1 > this.lof) {
        if (getLastVisiblePosition() < getCount() - 1)
        {
          i = n;
          if (i1 > (this.mHeight + this.lof) / 2) {
            i = 16;
          }
        }
      }
      for (;;)
      {
        label924:
        if ((i != 0) && (!d.fw(8)))
        {
          smoothScrollBy(i, 30);
          break;
          i = 1;
          continue;
          i = m;
          if (i1 < this.loe) {
            if (i1 >= this.loe / 2) {
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
    AppMethodBeat.o(53531);
    return bool;
  }
  
  public void setDragListener(TouchInterceptorListView.a parama)
  {
    this.loa = parama;
  }
  
  public void setDropListener(TouchInterceptorListView.b paramb)
  {
    this.lob = paramb;
  }
  
  public void setRemoveListener(TouchInterceptorListView.c paramc)
  {
    this.lod = paramc;
  }
  
  public void setTrashcan(Drawable paramDrawable)
  {
    this.lol = paramDrawable;
    this.loh = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.TouchInterceptorListView
 * JD-Core Version:    0.7.0.1
 */