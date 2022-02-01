package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerDragListener;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

public final class bi
  implements bb, pb.a, rd.c
{
  public final bd a;
  jx.a b;
  public TencentMap.OnMarkerDragListener c;
  public final bh d;
  public eu e;
  public List<et> f;
  public ew g;
  public er h;
  public final Map<Class<? extends mo>, mn> i;
  private Marker j;
  private boolean k;
  private Marker l;
  private Marker m;
  private Marker n;
  
  public bi(bh parambh, bd parambd)
  {
    AppMethodBeat.i(224897);
    this.j = null;
    this.k = false;
    this.a = parambd;
    this.d = parambh;
    this.i = new HashMap();
    AppMethodBeat.o(224897);
  }
  
  private <O extends mo, L extends mm<O>> void a(int paramInt, O paramO)
  {
    AppMethodBeat.i(224967);
    mn localmn = (mn)this.i.get(paramO.getClass());
    if (localmn != null)
    {
      mm localmm = localmn.a(paramInt);
      if (localmm != null)
      {
        localmm.a(paramO);
        localmn.a(localmm);
      }
    }
    AppMethodBeat.o(224967);
  }
  
  private void a(er paramer)
  {
    this.h = paramer;
  }
  
  private void a(et paramet)
  {
    AppMethodBeat.i(225065);
    if (paramet == null)
    {
      AppMethodBeat.o(225065);
      return;
    }
    if (this.f == null) {
      this.f = new ArrayList();
    }
    this.f.add(paramet);
    AppMethodBeat.o(225065);
  }
  
  private void a(eu parameu)
  {
    this.e = parameu;
  }
  
  private void a(ew paramew)
  {
    this.g = paramew;
  }
  
  private void a(TencentMap.OnMarkerDragListener paramOnMarkerDragListener)
  {
    this.c = paramOnMarkerDragListener;
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225037);
    if (this.d.h.a(paramFloat1, paramFloat2))
    {
      AppMethodBeat.o(225037);
      return true;
    }
    Object localObject = this.a.f().a(paramFloat1, paramFloat2);
    if (localObject != null)
    {
      if ((((TappedElement)localObject).type == 1) && (this.e != null))
      {
        new fq(((TappedElement)localObject).name, jz.a(((TappedElement)localObject).pixelX, ((TappedElement)localObject).pixelY));
        AppMethodBeat.o(225037);
        return true;
      }
      if ((((TappedElement)localObject).type == 6) && (this.f != null))
      {
        localObject = this.f.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Iterator)localObject).next();
        }
        AppMethodBeat.o(225037);
        return true;
      }
    }
    AppMethodBeat.o(225037);
    return false;
  }
  
  private <O extends mo, L extends mm<O>> boolean a(int paramInt, Class<L> paramClass)
  {
    AppMethodBeat.i(224978);
    boolean bool = false;
    paramClass = a(paramClass, paramInt);
    if (paramClass != null)
    {
      paramClass.remove();
      bool = true;
    }
    AppMethodBeat.o(224978);
    return bool;
  }
  
  private boolean a(bm parambm, Marker paramMarker)
  {
    AppMethodBeat.i(225200);
    if ((paramMarker != null) && (paramMarker == this.l))
    {
      boolean bool = gc.a(parambm);
      AppMethodBeat.o(225200);
      return bool;
    }
    AppMethodBeat.o(225200);
    return false;
  }
  
  @Deprecated
  private boolean a(GL10 paramGL10)
  {
    AppMethodBeat.i(225016);
    this.d.h.a(paramGL10);
    AppMethodBeat.o(225016);
    return true;
  }
  
  private void b(et paramet)
  {
    AppMethodBeat.i(225085);
    if ((paramet == null) || (this.f == null))
    {
      AppMethodBeat.o(225085);
      return;
    }
    this.f.remove(paramet);
    AppMethodBeat.o(225085);
  }
  
  private boolean b(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225130);
    Object localObject = this.a.f().a(paramFloat1, paramFloat2);
    if (localObject == null)
    {
      AppMethodBeat.o(225130);
      return false;
    }
    if ((((TappedElement)localObject).type == 1) && (this.e != null))
    {
      new fq(((TappedElement)localObject).name, jz.a(((TappedElement)localObject).pixelX, ((TappedElement)localObject).pixelY));
      AppMethodBeat.o(225130);
      return true;
    }
    if ((((TappedElement)localObject).type == 6) && (this.f != null))
    {
      localObject = this.f.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
      AppMethodBeat.o(225130);
      return true;
    }
    AppMethodBeat.o(225130);
    return false;
  }
  
  private void c(eq parameq)
  {
    AppMethodBeat.i(224912);
    a(parameq);
    AppMethodBeat.o(224912);
  }
  
  private boolean c(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225145);
    TappedElement localTappedElement = this.a.f().a(paramFloat1, paramFloat2);
    if (localTappedElement == null)
    {
      AppMethodBeat.o(225145);
      return false;
    }
    if (localTappedElement.type == 3)
    {
      if (this.h != null) {
        this.h.R();
      }
      AppMethodBeat.o(225145);
      return true;
    }
    AppMethodBeat.o(225145);
    return false;
  }
  
  private bh d()
  {
    return this.d;
  }
  
  private void d(eq parameq)
  {
    AppMethodBeat.i(224925);
    a(parameq);
    AppMethodBeat.o(224925);
  }
  
  private boolean d(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225168);
    TappedElement localTappedElement = this.a.f().a(paramFloat1, paramFloat2);
    if (localTappedElement == null)
    {
      AppMethodBeat.o(225168);
      return false;
    }
    if (localTappedElement.type == 6)
    {
      AppMethodBeat.o(225168);
      return true;
    }
    AppMethodBeat.o(225168);
    return false;
  }
  
  private void e()
  {
    AppMethodBeat.i(225215);
    if (this.i != null)
    {
      Object localObject = this.i.values();
      if ((localObject != null) && (!((Collection)localObject).isEmpty()))
      {
        localObject = ((Collection)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((mn)((Iterator)localObject).next()).d();
        }
      }
    }
    AppMethodBeat.o(225215);
  }
  
  private void e(eq parameq)
  {
    AppMethodBeat.i(224934);
    a(parameq);
    AppMethodBeat.o(224934);
  }
  
  private void f(eq parameq)
  {
    AppMethodBeat.i(224949);
    a(parameq);
    AppMethodBeat.o(224949);
  }
  
  public final <O extends mo, L extends mm<O>> L a(O paramO)
  {
    AppMethodBeat.i(225317);
    bd localbd = this.a;
    if ((paramO == null) || (localbd == null))
    {
      AppMethodBeat.o(225317);
      return null;
    }
    Object localObject1 = (mn)this.i.get(paramO.getClass());
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      if (paramO.getClass() != nh.class) {
        break label104;
      }
      localObject1 = new ng(localbd.f());
    }
    for (;;)
    {
      this.i.put(paramO.getClass(), localObject1);
      localObject2 = localObject1;
      paramO = localObject2.b(paramO);
      AppMethodBeat.o(225317);
      return paramO;
      label104:
      if (paramO.getClass() == mv.class) {
        localObject1 = new mu(localbd.f());
      } else if (paramO.getClass() == mr.class) {
        localObject1 = new ms(localbd.f());
      } else if (paramO.getClass() == my.class) {
        localObject1 = new mx(localbd.f());
      } else if (paramO.getClass() == nb.class) {
        localObject1 = new na(localbd.f());
      } else if (paramO.getClass() == ne.class) {
        localObject1 = new nc(localbd.f());
      } else if (paramO.getClass() == nk.class) {
        localObject1 = new nj(localbd.f());
      } else if (paramO.getClass() == nn.class) {
        localObject1 = new nm(localbd.f());
      }
    }
  }
  
  public final <O extends mo, L extends mm<O>> L a(Class<L> paramClass, int paramInt)
  {
    AppMethodBeat.i(225338);
    paramClass = ((java.lang.reflect.ParameterizedType)paramClass.getGenericSuperclass()).getActualTypeArguments()[0];
    paramClass = (mn)this.i.get(paramClass);
    if (paramClass != null)
    {
      paramClass = paramClass.a(paramInt);
      if (paramClass != null)
      {
        AppMethodBeat.o(225338);
        return paramClass;
      }
    }
    AppMethodBeat.o(225338);
    return null;
  }
  
  public final void a()
  {
    this.k = false;
    this.j = null;
  }
  
  public final void a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225495);
    if (this.n == null)
    {
      MarkerOptions localMarkerOptions = new MarkerOptions();
      localMarkerOptions.anchor(0.5F, 0.5F);
      localMarkerOptions.tag("AUTH_MARKER");
      localMarkerOptions.icon(BitmapDescriptorFactory.fromBitmap(this.a, paramBitmap));
      this.n = this.d.a(localMarkerOptions);
      this.n.setFixingPoint(paramInt1 / 2, paramInt2 / 2);
      this.n.setClickable(false);
    }
    for (;;)
    {
      kb.a(new Bitmap[] { paramBitmap });
      AppMethodBeat.o(225495);
      return;
      this.n.setIcon(BitmapDescriptorFactory.fromBitmap(this.a, paramBitmap));
      this.n.setFixingPoint(paramInt1 / 2, paramInt2 / 2);
    }
  }
  
  public final void a(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(225359);
    if ((this.a == null) || (!this.k) || (this.j == null))
    {
      AppMethodBeat.o(225359);
      return;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(225359);
      return;
      AppMethodBeat.o(225359);
      return;
      int i1 = (int)paramMotionEvent.getX();
      int i2 = (int)paramMotionEvent.getY();
      paramMotionEvent = new fl(i1, i2);
      paramMotionEvent = jz.a(this.a.d().a(paramMotionEvent));
      this.j.setPosition(paramMotionEvent);
      if (this.c != null)
      {
        this.c.onMarkerDrag(this.j);
        AppMethodBeat.o(225359);
        return;
        this.k = false;
        if (this.c != null) {
          this.c.onMarkerDragEnd(this.j);
        }
        this.j = null;
      }
    }
  }
  
  public final void a(View paramView, Rect paramRect, boolean paramBoolean)
  {
    AppMethodBeat.i(225430);
    if ((paramView == null) || (paramRect == null))
    {
      AppMethodBeat.o(225430);
      return;
    }
    paramView = gv.a(paramView);
    if (paramView == null)
    {
      AppMethodBeat.o(225430);
      return;
    }
    if (this.l == null)
    {
      Object localObject = new MarkerOptions().anchor(0.0F, 0.0F).visible(false);
      ((MarkerOptions)localObject).tag("AUTH_MARKER");
      ((MarkerOptions)localObject).fastLoad(true);
      this.l = this.d.a((MarkerOptions)localObject);
      localObject = (av)this.d.a(this.l.getId(), av.class);
      if (localObject != null) {
        ((av)localObject).a.a(new TencentMap.OnMarkerClickListener()
        {
          public final boolean onMarkerClick(Marker paramAnonymousMarker)
          {
            AppMethodBeat.i(226233);
            if (bi.this.b == null) {
              bi.this.b = jx.a(bi.this.a.getContext(), null, " ", 0);
            }
            kh.a(bi.this.a.getContext(), bi.this.b);
            AppMethodBeat.o(226233);
            return false;
          }
        });
      }
    }
    this.l.setFixingPoint(paramRect.left, paramRect.top);
    this.l.setIcon(BitmapDescriptorFactory.fromBitmap(this.a, paramView));
    this.l.setVisible(paramBoolean);
    kb.a(new Bitmap[] { paramView });
    AppMethodBeat.o(225430);
  }
  
  public final void a(eq parameq)
  {
    AppMethodBeat.i(225275);
    bh localbh = this.d;
    be localbe = localbh.h;
    synchronized (localbe.a)
    {
      if (localbe.a.contains(parameq))
      {
        if ((parameq instanceof em)) {
          localbh.a((em)parameq);
        }
        AppMethodBeat.o(225275);
        return;
      }
      localbe.a.add(parameq);
    }
  }
  
  public final void a(rd paramrd)
  {
    AppMethodBeat.i(225468);
    if (this.m != null) {
      this.m.setVisible(false);
    }
    if ((this.l != null) && (!paramrd.k())) {
      this.l.setVisible(false);
    }
    AppMethodBeat.o(225468);
  }
  
  public final void a(String paramString)
  {
    AppMethodBeat.i(225375);
    if (paramString.trim().length() == 0)
    {
      this.j = null;
      this.k = false;
      AppMethodBeat.o(225375);
      return;
    }
    this.j = ((Marker)this.d.a(paramString, av.class));
    if (this.j != null)
    {
      if ((this.a instanceof bm))
      {
        paramString = (bm)this.a;
        Marker localMarker = this.j;
        if ((localMarker != null) && (localMarker == this.l)) {}
        for (boolean bool = gc.a(paramString); bool; bool = false)
        {
          AppMethodBeat.o(225375);
          return;
        }
      }
      if (!this.j.isDraggable())
      {
        this.j = null;
        this.k = false;
        AppMethodBeat.o(225375);
        return;
      }
      this.k = true;
      if (this.c != null) {
        this.c.onMarkerDragStart(this.j);
      }
    }
    AppMethodBeat.o(225375);
  }
  
  public final void b()
  {
    AppMethodBeat.i(225391);
    if (this.i != null)
    {
      Object localObject = this.i.values();
      if ((localObject != null) && (!((Collection)localObject).isEmpty()))
      {
        localObject = ((Collection)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((mn)((Iterator)localObject).next()).b();
        }
      }
    }
    this.k = false;
    this.j = null;
    AppMethodBeat.o(225391);
  }
  
  public final void b(View paramView, Rect paramRect, boolean paramBoolean)
  {
    AppMethodBeat.i(225453);
    if (paramView == null)
    {
      AppMethodBeat.o(225453);
      return;
    }
    paramView = gv.a(paramView);
    if (paramView == null)
    {
      AppMethodBeat.o(225453);
      return;
    }
    if (this.m == null)
    {
      MarkerOptions localMarkerOptions = new MarkerOptions().anchor(0.0F, 0.0F).visible(false);
      localMarkerOptions.tag("AUTH_MARKER");
      localMarkerOptions.fastLoad(true);
      this.m = this.d.a(localMarkerOptions);
      this.m.setClickable(false);
    }
    this.m.setFixingPoint(paramRect.left, paramRect.top);
    this.m.setIcon(BitmapDescriptorFactory.fromBitmap(this.a, paramView));
    this.m.setVisible(paramBoolean);
    kb.a(new Bitmap[] { paramView });
    AppMethodBeat.o(225453);
  }
  
  public final void b(eq parameq)
  {
    AppMethodBeat.i(225292);
    be localbe = this.d.h;
    if (parameq != null) {
      synchronized (localbe.a)
      {
        localbe.a.remove(parameq);
        localbe.b.add(parameq);
        AppMethodBeat.o(225292);
        return;
      }
    }
    AppMethodBeat.o(225292);
  }
  
  public final void c()
  {
    AppMethodBeat.i(225479);
    if (this.m != null) {
      this.m.setVisible(true);
    }
    if (this.l != null) {
      this.l.setVisible(true);
    }
    AppMethodBeat.o(225479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.bi
 * JD-Core Version:    0.7.0.1
 */