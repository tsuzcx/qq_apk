package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public abstract class ItemizedOverlay<Item extends OverlayItem>
  extends Overlay
{
  private boolean a = true;
  private Drawable b;
  private ItemizedOverlay<Item>.b c = null;
  private OnFocusChangeListener d = null;
  private int e = -1;
  private int f = -1;
  private Item g;
  private boolean h = false;
  private boolean i = true;
  
  public ItemizedOverlay(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Contex can not be null!");
    }
    String str = "marker_small.png";
    if (q.a()) {
      str = "marker_big.png";
    }
    Bitmap localBitmap = q.a(paramContext, str);
    if (localBitmap == null) {
      throw new IllegalArgumentException(str + " is missing in tencent mapsdk!");
    }
    this.b = new BitmapDrawable(paramContext.getResources(), localBitmap);
    if (this.b == null) {
      throw new IllegalArgumentException("the drawable can not be null!");
    }
    boundCenterBottom(this.b);
  }
  
  public ItemizedOverlay(Drawable paramDrawable)
  {
    this.b = paramDrawable;
    if (this.b == null) {
      throw new IllegalArgumentException("the drawable can not be null!");
    }
    paramDrawable = this.b.getBounds();
    if (paramDrawable == null) {
      boundCenterBottom(this.b);
    }
    while ((paramDrawable.left != 0) || (paramDrawable.right != 0) || (paramDrawable.top != 0) || (paramDrawable.bottom != 0)) {
      return;
    }
    boundCenterBottom(this.b);
  }
  
  private static Drawable a(Drawable paramDrawable, a parama)
  {
    if ((paramDrawable == null) || (a.a == parama)) {
      return null;
    }
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    Rect localRect = paramDrawable.getBounds();
    int n = localRect.width() / 2;
    int m = -localRect.height();
    int k = 0;
    int j = m;
    if (parama == a.b)
    {
      j = m / 2;
      k = -j;
    }
    paramDrawable.setBounds(-n, j, n, k);
    return paramDrawable;
  }
  
  private Item a(int paramInt)
  {
    if (this.c == null) {}
    while (paramInt == 0) {
      return null;
    }
    return this.c.a(paramInt - 1);
  }
  
  private void a(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean, Item paramItem, Point paramPoint)
  {
    paramItem = paramItem.getMarker();
    paramMapView = paramItem;
    if (paramItem == null) {
      paramMapView = this.b;
    }
    if (paramBoolean)
    {
      paramCanvas.save();
      paramCanvas.translate(paramPoint.x, paramPoint.y);
      a(paramMapView, paramCanvas);
      paramCanvas.restore();
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(paramPoint.x, paramPoint.y);
    paramMapView.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  static void a(Drawable paramDrawable, Canvas paramCanvas)
  {
    paramDrawable.setColorFilter(2130706432, PorterDuff.Mode.SRC_IN);
    paramCanvas.skew(-0.89F, 0.0F);
    paramCanvas.scale(1.0F, 0.5F);
    paramDrawable.draw(paramCanvas);
    paramDrawable.clearColorFilter();
  }
  
  private Item b(int paramInt)
  {
    if (this.c == null) {}
    while (paramInt == this.c.a() - 1) {
      return null;
    }
    return this.c.a(paramInt + 1);
  }
  
  public static Drawable boundCenter(Drawable paramDrawable)
  {
    return a(paramDrawable, a.b);
  }
  
  public static Drawable boundCenterBottom(Drawable paramDrawable)
  {
    return a(paramDrawable, a.c);
  }
  
  protected abstract Item createItem(int paramInt);
  
  public void draw(Canvas paramCanvas, MapView paramMapView)
  {
    int k = size();
    if (k <= 0) {}
    label107:
    OverlayItem localOverlayItem2;
    do
    {
      return;
      localObject = paramMapView.getProjection();
      int j = 0;
      for (;;)
      {
        if (j >= k) {
          break label107;
        }
        try
        {
          OverlayItem localOverlayItem1 = getItem(getIndexToDraw(j));
          if (localOverlayItem1 != null) {
            break;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            continue;
            Point localPoint = ((Projection)localObject).toPixels(localException.getPoint(), null);
            if (localPoint != null)
            {
              if (this.i == true) {
                a(paramCanvas, paramMapView, true, localException, localPoint);
              }
              a(paramCanvas, paramMapView, false, localException, localPoint);
            }
          }
        }
        j += 1;
      }
      localOverlayItem2 = getFocus();
    } while ((!this.a) || (localOverlayItem2 == null));
    Object localObject = ((Projection)localObject).toPixels(localOverlayItem2.getPoint(), null);
    if (this.i == true) {
      a(paramCanvas, paramMapView, true, localOverlayItem2, (Point)localObject);
    }
    a(paramCanvas, paramMapView, false, localOverlayItem2, (Point)localObject);
  }
  
  public GeoPoint getCenter()
  {
    if (this.c == null) {
      return null;
    }
    return new GeoPoint(this.c.a, this.c.b);
  }
  
  public Item getFocus()
  {
    if (this.c == null) {}
    while (this.f == -1) {
      return null;
    }
    return this.c.a(this.f);
  }
  
  protected int getIndexToDraw(int paramInt)
  {
    if (this.c == null) {
      return -1;
    }
    return this.c.b(paramInt);
  }
  
  public final Item getItem(int paramInt)
  {
    if (this.c == null) {
      return null;
    }
    return this.c.a(paramInt);
  }
  
  public final int getLastFocusedIndex()
  {
    return this.e;
  }
  
  public int getLatSpanE6()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.a(true);
  }
  
  public int getLonSpanE6()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.a(false);
  }
  
  public boolean isShadowEnable()
  {
    return this.i;
  }
  
  public Item nextFocus(boolean paramBoolean)
  {
    if ((this.c == null) || (this.c.a() == 0)) {}
    do
    {
      return null;
      if (this.e != -1) {
        break;
      }
    } while (this.f == -1);
    return this.c.a(0);
    if (this.f == -1) {}
    for (int j = this.e; paramBoolean; j = this.f) {
      return b(j);
    }
    return a(j);
  }
  
  public void onEmptyTap(GeoPoint paramGeoPoint)
  {
    super.onEmptyTap(paramGeoPoint);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent, MapView paramMapView)
  {
    return false;
  }
  
  public boolean onLongPress(GeoPoint paramGeoPoint, MotionEvent paramMotionEvent, MapView paramMapView)
  {
    if (this.c == null) {}
    do
    {
      return false;
      this.c.a(paramGeoPoint, paramMapView);
      this.h = true;
    } while (this.g == null);
    return false;
  }
  
  protected boolean onTap(int paramInt)
  {
    if (this.c == null) {}
    while (paramInt == this.f) {
      return false;
    }
    setFocus(getItem(paramInt));
    return false;
  }
  
  public boolean onTap(GeoPoint paramGeoPoint, MapView paramMapView)
  {
    if (this.c == null) {
      return false;
    }
    return this.c.b(paramGeoPoint, paramMapView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    if ((!this.h) || (this.g == null)) {
      return false;
    }
    if (!this.g.isDragable()) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    case 0: 
    default: 
      return false;
    case 1: 
    case 3: 
    case 4: 
      this.h = false;
      this.g = null;
      return true;
    }
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    paramMotionEvent = paramMapView.getProjection().fromPixels(j, k);
    this.g.setPoint(paramMotionEvent);
    paramMapView.invalidate();
    return true;
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    return false;
  }
  
  protected final void populate()
  {
    if (this.c != null) {
      this.c.b();
    }
    this.c = new b();
    this.e = -1;
    this.f = -1;
  }
  
  public void setDrawFocusedItem(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setFocus(Item paramItem)
  {
    if (this.c == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramItem != null) && (this.f == this.c.a(paramItem)));
        if ((paramItem == null) && (this.f != -1))
        {
          if (this.d != null) {
            this.d.onFocusChanged(this, paramItem);
          }
          this.f = -1;
          return;
        }
        this.f = this.c.a(paramItem);
      } while (this.f == -1);
      setLastFocusedIndex(this.f);
    } while (this.d == null);
    this.d.onFocusChanged(this, paramItem);
  }
  
  protected void setLastFocusedIndex(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setOnFocusChangeListener(OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.d = paramOnFocusChangeListener;
  }
  
  public void setShadowEnable(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public abstract int size();
  
  public static abstract interface OnFocusChangeListener
  {
    public abstract void onFocusChanged(ItemizedOverlay<?> paramItemizedOverlay, OverlayItem paramOverlayItem);
  }
  
  static enum a
  {
    private a() {}
  }
  
  class b
    implements Comparator<Integer>
  {
    int a = 0;
    int b = 0;
    private ArrayList<Item> d = new ArrayList();
    private ArrayList<Integer> e = new ArrayList();
    
    public b()
    {
      if (this.d != null) {
        this.d.clear();
      }
      if (this.e != null) {
        this.e.clear();
      }
      int k = 0;
      int i = 0;
      int m = ItemizedOverlay.this.size();
      int j = 0;
      while (j < m)
      {
        this.e.add(Integer.valueOf(j));
        OverlayItem localOverlayItem = ItemizedOverlay.this.createItem(j);
        k += localOverlayItem.getPoint().getLatitudeE6();
        i += localOverlayItem.getPoint().getLongitudeE6();
        this.d.add(localOverlayItem);
        j += 1;
      }
      if (m > 0) {
        this.a = (k / m);
      }
      for (this.b = (i / m);; this.b = 0)
      {
        Collections.sort(this.e, this);
        return;
        this.a = 0;
      }
    }
    
    private double a(Item paramItem, Projection paramProjection, Point paramPoint, int paramInt)
    {
      double d1 = -1.0D;
      Point localPoint = paramProjection.toPixels(paramItem.getPoint(), null);
      if (a(paramItem.getMarker(), localPoint, paramProjection, paramPoint, paramInt))
      {
        paramItem = new Point(paramPoint.x - localPoint.x, paramPoint.y - localPoint.y);
        d1 = paramItem.x * paramItem.x + paramItem.y * paramItem.y;
      }
      return d1;
    }
    
    private boolean a(Drawable paramDrawable, Point paramPoint1, Projection paramProjection, Point paramPoint2, int paramInt)
    {
      paramProjection = new Point(paramPoint2.x - paramPoint1.x, paramPoint2.y - paramPoint1.y);
      paramPoint1 = paramDrawable;
      if (paramDrawable == null) {
        paramPoint1 = ItemizedOverlay.a(ItemizedOverlay.this);
      }
      return paramPoint1.getBounds().contains(paramProjection.x, paramProjection.y);
    }
    
    private int c(GeoPoint paramGeoPoint, MapView paramMapView)
    {
      paramMapView = paramMapView.getProjection();
      paramGeoPoint = paramMapView.toPixels(paramGeoPoint, null);
      int m = -1;
      double d1 = 1.7976931348623157E+308D;
      int k = 2147483647;
      int i1 = a();
      int i = 0;
      if (i < i1)
      {
        OverlayItem localOverlayItem = (OverlayItem)this.d.get(i);
        int n;
        double d2;
        int j;
        if (localOverlayItem == null)
        {
          n = k;
          d2 = d1;
          j = m;
        }
        for (;;)
        {
          i += 1;
          m = j;
          d1 = d2;
          k = n;
          break;
          double d3 = a(localOverlayItem, paramMapView, paramGeoPoint, i);
          if ((d3 >= 0.0D) && (d3 < d1))
          {
            d2 = d3;
            n = b(i);
            j = i;
          }
          else
          {
            j = m;
            d2 = d1;
            n = k;
            if (d3 == d1)
            {
              j = m;
              d2 = d1;
              n = k;
              if (b(i) > k)
              {
                j = i;
                d2 = d1;
                n = k;
              }
            }
          }
        }
      }
      return m;
    }
    
    public int a()
    {
      return this.d.size();
    }
    
    public int a(Item paramItem)
    {
      int k = -1;
      int m = a();
      int j = k;
      int i;
      if (paramItem != null) {
        i = 0;
      }
      for (;;)
      {
        j = k;
        if (i < m)
        {
          if (paramItem.equals(this.d.get(i))) {
            j = i;
          }
        }
        else {
          return j;
        }
        i += 1;
      }
    }
    
    public int a(Integer paramInteger1, Integer paramInteger2)
    {
      paramInteger1 = ((OverlayItem)this.d.get(paramInteger1.intValue())).getPoint();
      paramInteger2 = ((OverlayItem)this.d.get(paramInteger2.intValue())).getPoint();
      if ((paramInteger1 == null) || (paramInteger2 == null)) {
        return 0;
      }
      if (paramInteger1.getLatitudeE6() > paramInteger2.getLatitudeE6()) {
        return -1;
      }
      if (paramInteger1.getLatitudeE6() < paramInteger2.getLatitudeE6()) {
        return 1;
      }
      if (paramInteger1.getLongitudeE6() < paramInteger2.getLongitudeE6()) {
        return -1;
      }
      if (paramInteger1.getLongitudeE6() > paramInteger2.getLongitudeE6()) {
        return 1;
      }
      return 0;
    }
    
    public int a(boolean paramBoolean)
    {
      if (this.d.size() == 0) {
        return 0;
      }
      int k = -2147483648;
      int j = 2147483647;
      Iterator localIterator = this.d.iterator();
      if (localIterator.hasNext())
      {
        GeoPoint localGeoPoint = ((OverlayItem)localIterator.next()).getPoint();
        if (paramBoolean) {}
        for (int i = localGeoPoint.getLatitudeE6();; i = localGeoPoint.getLongitudeE6())
        {
          int m = k;
          if (i > k) {
            m = i;
          }
          k = m;
          if (i >= j) {
            break;
          }
          k = m;
          j = i;
          break;
        }
      }
      return k - j;
    }
    
    public Item a(int paramInt)
    {
      if (this.d == null) {}
      while ((this.d.size() <= paramInt) || (paramInt < 0)) {
        return null;
      }
      return (OverlayItem)this.d.get(paramInt);
    }
    
    public boolean a(GeoPoint paramGeoPoint, MapView paramMapView)
    {
      int i = c(paramGeoPoint, paramMapView);
      if (i != -1) {
        ItemizedOverlay.a(ItemizedOverlay.this, (OverlayItem)this.d.get(i));
      }
      return false;
    }
    
    public int b(int paramInt)
    {
      if (this.e.size() <= paramInt) {
        return -1;
      }
      return ((Integer)this.e.get(paramInt)).intValue();
    }
    
    public void b()
    {
      if (this.d != null) {
        this.d.clear();
      }
      if (this.e != null) {
        this.e.clear();
      }
    }
    
    public boolean b(GeoPoint paramGeoPoint, MapView paramMapView)
    {
      boolean bool = false;
      int i = c(paramGeoPoint, paramMapView);
      if (i >= 0) {
        bool = ItemizedOverlay.this.onTap(i);
      }
      for (;;)
      {
        paramMapView.postInvalidate();
        return bool;
        ItemizedOverlay.this.setFocus(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.ItemizedOverlay
 * JD-Core Version:    0.7.0.1
 */