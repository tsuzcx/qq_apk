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
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.emoji.f.b;
import com.tencent.mm.plugin.emoji.f.c;
import com.tencent.mm.plugin.emoji.f.d;
import com.tencent.mm.sdk.platformtools.y;

public class TouchInterceptorListView
  extends ListView
{
  private int UO;
  private int UP;
  private Rect ec = new Rect();
  private GestureDetector gEU;
  private int iUZ;
  private final int jb;
  private ImageView jfd;
  private WindowManager jfe;
  private WindowManager.LayoutParams jff;
  private int jfg;
  private int jfh;
  private int jfi;
  private int jfj;
  private TouchInterceptorListView.a jfk;
  private TouchInterceptorListView.b jfl;
  private TouchInterceptorListView.c jfm;
  private int jfn;
  private int jfo;
  private int jfp = -1;
  private Bitmap jfq;
  private int jfr;
  private int jfs;
  private Drawable jft;
  private int jfu = 0;
  private int mHeight;
  
  public TouchInterceptorListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jb = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    paramContext = getResources();
    this.iUZ = (paramContext.getDimensionPixelSize(f.c.emoji_item_list_height) + 1);
    this.jfs = (this.iUZ / 2);
    this.jfr = (this.iUZ * 2);
    this.jfu = paramContext.getDimensionPixelOffset(f.c.emoji_itme_drag_width);
  }
  
  private void aJt()
  {
    if (this.jfd != null)
    {
      this.jfd.setVisibility(8);
      ((WindowManager)getContext().getSystemService("window")).removeView(this.jfd);
      this.jfd.setImageDrawable(null);
      this.jfd = null;
    }
    if (this.jfq != null)
    {
      y.i("MicroMsg.emoji.TouchInterceptorListView", "bitmap recycle %s", new Object[] { this.jfq });
      this.jfq.recycle();
      this.jfq = null;
    }
    if (this.jft != null) {
      this.jft.setLevel(0);
    }
  }
  
  private int cE(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0)
    {
      i = cE(paramInt1, this.iUZ + paramInt2);
      if (i > 0) {
        return i - 1;
      }
    }
    Rect localRect = this.ec;
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      getChildAt(i).getHitRect(localRect);
      if (localRect.contains(paramInt1, paramInt2)) {
        return i + getFirstVisiblePosition();
      }
      i -= 1;
    }
    return -1;
  }
  
  private void fh(boolean paramBoolean)
  {
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
        label67:
        break label67;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        return;
      }
      localObject1 = ((View)localObject2).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = this.iUZ;
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((View)localObject2).setVisibility(0);
      i += 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jfm != null) && (this.gEU == null) && (this.jfp == 0)) {
      this.gEU = new GestureDetector(getContext(), new TouchInterceptorListView.1(this));
    }
    if ((this.jfk != null) || (this.jfl != null)) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      int j = (int)paramMotionEvent.getX();
      int i = (int)paramMotionEvent.getY();
      int k = pointToPosition(j, i);
      if (k != -1)
      {
        Object localObject = (ViewGroup)getChildAt(k - getFirstVisiblePosition());
        this.jfi = (j - ((ViewGroup)localObject).getLeft());
        this.jfj = (i - ((ViewGroup)localObject).getTop());
        this.UO = ((int)paramMotionEvent.getRawX() - j);
        this.UP = ((int)paramMotionEvent.getRawY() - i);
        if (j < this.jfu)
        {
          ((ViewGroup)localObject).setDrawingCacheEnabled(true);
          paramMotionEvent = Bitmap.createBitmap(((ViewGroup)localObject).getDrawingCache());
          aJt();
          this.jff = new WindowManager.LayoutParams();
          this.jff.gravity = 49;
          this.jff.x = (j - this.jfi + this.UO);
          this.jff.y = (i - this.jfj + this.UP);
          this.jff.height = -2;
          this.jff.width = -2;
          this.jff.flags = 920;
          this.jff.format = -3;
          this.jff.windowAnimations = 0;
          localObject = getContext();
          ImageView localImageView = new ImageView((Context)localObject);
          localImageView.setBackgroundColor(((Context)localObject).getResources().getColor(f.b.white));
          localImageView.setBackgroundResource(f.d.emotionstore_emotionmanaged_cellshadow);
          localImageView.setPadding(0, 0, 0, 0);
          localImageView.setImageBitmap(paramMotionEvent);
          this.jfq = paramMotionEvent;
          this.jfe = ((WindowManager)((Context)localObject).getSystemService("window"));
          this.jfe.addView(localImageView, this.jff);
          this.jfd = localImageView;
          this.jfg = k;
          this.jfh = this.jfg;
          this.mHeight = getHeight();
          j = this.jb;
          this.jfn = Math.min(i - j, this.mHeight / 3);
          this.jfo = Math.max(j + i, this.mHeight * 2 / 3);
          return false;
        }
        aJt();
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = 4;
    int m = 0;
    if (this.gEU != null) {
      this.gEU.onTouchEvent(paramMotionEvent);
    }
    if (((this.jfk != null) || (this.jfl != null)) && (this.jfd != null))
    {
      int k = paramMotionEvent.getAction();
      Object localObject;
      switch (k)
      {
      default: 
        return true;
      case 1: 
      case 3: 
        localObject = this.ec;
        this.jfd.getDrawingRect((Rect)localObject);
        aJt();
        if ((this.jfp == 1) && (paramMotionEvent.getX() > ((Rect)localObject).right * 3 / 4))
        {
          fh(true);
          return true;
        }
        if ((this.jfl != null) && (this.jfg >= 0)) {
          getCount();
        }
        fh(false);
        return true;
      }
      int i = (int)paramMotionEvent.getX();
      int i1 = (int)paramMotionEvent.getY();
      if (this.jfp == 1)
      {
        float f = 1.0F;
        j = this.jfd.getWidth();
        if (i > j / 2) {
          f = (j - i) / (j / 2);
        }
        this.jff.alpha = f;
      }
      label253:
      int i2;
      label327:
      label372:
      int i3;
      int i4;
      if ((this.jfp == 0) || (this.jfp == 2))
      {
        this.jff.x = (i - this.jfi + this.UO);
        this.jff.y = (i1 - this.jfj + this.UP);
        this.jfe.updateViewLayout(this.jfd, this.jff);
        if (this.jft != null)
        {
          j = this.jfd.getWidth();
          if (i1 <= getHeight() * 3 / 4) {
            break label606;
          }
          this.jft.setLevel(2);
        }
        i2 = i1 - this.jfj - this.jfs;
        j = cE(0, i2);
        if (j < 0) {
          break label643;
        }
        i = j;
        if (j <= this.jfh) {
          i = j + 1;
        }
        if (i < 0) {
          break label654;
        }
        if ((k != 0) && (i == this.jfg)) {
          break label818;
        }
        this.jfg = i;
        y.d("MicroMsg.emoji.TouchInterceptorListView", "doExpansion mDragPos:%d mSrcDragPos:%d", new Object[] { Integer.valueOf(this.jfg), Integer.valueOf(this.jfh) });
        y.d("MicroMsg.emoji.TouchInterceptorListView", "getFirstVisiblePosition:%d", new Object[] { Integer.valueOf(getFirstVisiblePosition()) });
        y.d("MicroMsg.emoji.TouchInterceptorListView", "getHeaderViewsCount:%d", new Object[] { Integer.valueOf(getHeaderViewsCount()) });
        i2 = this.jfg;
        i3 = getFirstVisiblePosition();
        i4 = getHeaderViewsCount();
        paramMotionEvent = getChildAt(this.jfh - getFirstVisiblePosition());
        k = 0;
        label505:
        localObject = getChildAt(k);
        if (localObject == null) {
          break label818;
        }
        j = this.iUZ;
        if ((this.jfg >= i4) || (k != i4)) {
          break label675;
        }
        if (!localObject.equals(paramMotionEvent)) {
          break label656;
        }
        y.d("MicroMsg.emoji.TouchInterceptorListView", "1. visibility = View.INVISIBLE");
        i = 4;
      }
      for (;;)
      {
        ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
        localLayoutParams.height = j;
        ((View)localObject).setLayoutParams(localLayoutParams);
        ((View)localObject).setVisibility(i);
        k += 1;
        break label505;
        this.jff.x = 0;
        break label253;
        label606:
        if ((j > 0) && (i > j / 4))
        {
          this.jft.setLevel(1);
          break label327;
        }
        this.jft.setLevel(0);
        break label327;
        label643:
        i = j;
        if (i2 >= 0) {
          break label372;
        }
        i = 0;
        break label372;
        label654:
        break;
        label656:
        j = this.jfr;
        y.d("MicroMsg.emoji.TouchInterceptorListView", "1. height = mItemHeightExpanded");
        i = 0;
        continue;
        label675:
        if (localObject.equals(paramMotionEvent))
        {
          if ((this.jfg == this.jfh) || (getPositionForView((View)localObject) == getCount()))
          {
            j = this.iUZ;
            y.d("MicroMsg.emoji.TouchInterceptorListView", "2. visibility = View.INVISIBLE");
            i = 4;
          }
          else
          {
            y.d("MicroMsg.emoji.TouchInterceptorListView", "2. height = 1");
            i = 0;
            j = 1;
          }
        }
        else if (k == i2 - i3)
        {
          if ((this.jfg >= i4) && (this.jfg < getCount()))
          {
            j = this.jfr;
            y.d("MicroMsg.emoji.TouchInterceptorListView", "3. height = mItemHeightExpanded;");
            i = 0;
          }
          else
          {
            y.d("MicroMsg.emoji.TouchInterceptorListView", "3. ");
            i = 0;
          }
        }
        else
        {
          y.d("MicroMsg.emoji.TouchInterceptorListView", "4");
          i = 0;
        }
      }
      label818:
      if (i1 >= this.mHeight / 3) {
        this.jfn = (this.mHeight / 3);
      }
      if (i1 <= this.mHeight * 2 / 3) {
        this.jfo = (this.mHeight * 2 / 3);
      }
      if (i1 > this.jfo) {
        if (getLastVisiblePosition() < getCount() - 1)
        {
          i = n;
          if (i1 > (this.mHeight + this.jfo) / 2) {
            i = 16;
          }
        }
      }
      label908:
      while ((i != 0) && (!d.gG(8)))
      {
        smoothScrollBy(i, 30);
        return true;
        i = 1;
        continue;
        i = m;
        if (i1 < this.jfn) {
          if (i1 >= this.jfn / 2) {
            break label992;
          }
        }
      }
      label992:
      for (int j = -16;; j = -4)
      {
        if (getFirstVisiblePosition() == 0)
        {
          i = m;
          if (getChildAt(0).getTop() >= getPaddingTop()) {
            break label908;
          }
        }
        i = j;
        break label908;
        break;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setDragListener(TouchInterceptorListView.a parama)
  {
    this.jfk = parama;
  }
  
  public void setDropListener(TouchInterceptorListView.b paramb)
  {
    this.jfl = paramb;
  }
  
  public void setRemoveListener(TouchInterceptorListView.c paramc)
  {
    this.jfm = paramc;
  }
  
  public void setTrashcan(Drawable paramDrawable)
  {
    this.jft = paramDrawable;
    this.jfp = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.TouchInterceptorListView
 * JD-Core Version:    0.7.0.1
 */