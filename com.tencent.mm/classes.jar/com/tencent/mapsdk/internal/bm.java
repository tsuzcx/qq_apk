package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.map.sdk.comps.offlinemap.OfflineMapComponent;
import com.tencent.mapsdk.core.MapDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMapComponent;
import com.tencent.tencentmap.mapsdk.maps.TencentMapComponent.Component;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.TencentMapProtocol;
import com.tencent.tencentmap.mapsdk.maps.TencentMapResource;
import com.tencent.tencentmap.mapsdk.maps.TencentMapServiceProtocol;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.MapViewType;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaSource;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class bm
  implements TencentMapContext
{
  private static final Map<Class<? extends TencentMapComponent.Component>, TencentMapComponent.Component> g = new ConcurrentHashMap();
  private static final Set<bm.a> h;
  private static final String i = "map-context.cache";
  private static final String j = "navi_marker_location.png";
  private static final String k = "color_texture_flat_style.png";
  public final TencentMapOptions a;
  public final bn b;
  gb c;
  public gq d;
  public boolean e = false;
  public volatile boolean f = true;
  private final Context l;
  private mf m;
  
  static
  {
    HashSet localHashSet = new HashSet();
    h = localHashSet;
    localHashSet.add(new bm.a(TencentMapProtocol.class, cj.class));
    h.add(new bm.a(OfflineMapComponent.class, bz.class));
  }
  
  public bm(Context paramContext, TencentMapOptions paramTencentMapOptions, bn parambn)
  {
    this.l = paramContext.getApplicationContext();
    this.a = paramTencentMapOptions;
    this.b = parambn;
    BitmapDescriptorFactory.attachMapContext(this);
    mc.a(paramTencentMapOptions);
  }
  
  private <T extends TencentMapComponent.Component> T a(Class<T> paramClass)
  {
    paramClass = (TencentMapComponent.Component)g.get(paramClass);
    if ((paramClass instanceof bl)) {
      ((bl)paramClass).a(this, null);
    }
    return paramClass;
  }
  
  private void a()
  {
    this.c = new gb(this);
    gb localgb = this.c;
    if (localgb.a == 0) {
      localgb.a(new gb.1(localgb, new gb.2(localgb)));
    }
    localgb.a += 1;
    this.d = gb.a(System.currentTimeMillis());
  }
  
  private static void a(Bundle paramBundle)
  {
    if (paramBundle.size() > 0)
    {
      Parcel localParcel = Parcel.obtain();
      paramBundle.writeToParcel(localParcel, 0);
      ka.a(ka.b(ka.d, "map-context.cache"), localParcel.marshall());
      localParcel.recycle();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  private void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  private gq c()
  {
    return this.d;
  }
  
  private cl d()
  {
    TencentMapProtocol localTencentMapProtocol = (TencentMapProtocol)getMapComponent(TencentMapProtocol.class);
    if ((localTencentMapProtocol instanceof cj)) {
      return ((cj)localTencentMapProtocol).d().b;
    }
    return cj.e();
  }
  
  private boolean e()
  {
    return this.e;
  }
  
  private boolean f()
  {
    return this.f;
  }
  
  private void g()
  {
    Object localObject1 = this.c;
    Object localObject2 = this.d;
    ((gq)localObject2).b = (System.currentTimeMillis() - ((gq)localObject2).a);
    ((gb)localObject1).a -= 1;
    if (localObject2 != null) {}
    try
    {
      ((gb)localObject1).b.add(localObject2);
      if ((((gb)localObject1).a == 0) && (!((gb)localObject1).b.isEmpty())) {
        ((gb)localObject1).a(gb.a(((gb)localObject1).b, null), new gb.4((gb)localObject1));
      }
      localObject1 = new Bundle();
      if (((Bundle)localObject1).size() > 0)
      {
        localObject2 = Parcel.obtain();
        ((Bundle)localObject1).writeToParcel((Parcel)localObject2, 0);
        ka.a(ka.b(ka.d, "map-context.cache"), ((Parcel)localObject2).marshall());
        ((Parcel)localObject2).recycle();
      }
      s();
      BitmapDescriptorFactory.detachMapContext(this);
      return;
    }
    finally {}
  }
  
  private void h()
  {
    Object localObject1 = q();
    if (localObject1 != null)
    {
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        h.add(new bm.a((Class)((Map.Entry)localObject2).getKey(), (Class)((Map.Entry)localObject2).getValue()));
      }
    }
    Object localObject2 = h.iterator();
    label211:
    label212:
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (bm.a)((Iterator)localObject2).next();
        Class localClass = ((bm.a)localObject3).a;
        localObject1 = (TencentMapComponent.Component)g.get(localClass);
        localObject3 = ((bm.a)localObject3).b;
        if ((localObject1 != null) || (localObject3 == null) || (!localClass.isAssignableFrom((Class)localObject3))) {
          break label211;
        }
        localObject1 = (TencentMapComponent.Component)gy.a((Class)localObject3, new Object[0]);
        if ((localObject1 instanceof bl)) {
          ((bl)localObject1).a(getContext());
        }
        g.put(localClass, localObject1);
      }
      for (;;)
      {
        if (!(localObject1 instanceof bl)) {
          break label212;
        }
        ((bl)localObject1).a(this);
        break;
        return;
      }
    }
  }
  
  private TencentMapProtocol i()
  {
    return (TencentMapProtocol)getMapComponent(TencentMapProtocol.class);
  }
  
  private TencentMapOptions j()
  {
    return this.a;
  }
  
  private File k()
  {
    return t().c();
  }
  
  private OverSeaSource m()
  {
    return this.a.getOverSeaSource();
  }
  
  private MapViewType n()
  {
    return this.a.getMapViewType();
  }
  
  static Bundle r()
  {
    File localFile = new File(ka.d, "map-context.cache");
    if (localFile.exists())
    {
      Object localObject = ka.c(localFile);
      if ((localObject != null) && (localObject.length > 0))
      {
        Parcel localParcel = Parcel.obtain();
        localParcel.unmarshall((byte[])localObject, 0, localObject.length);
        localObject = new Bundle();
        ((Bundle)localObject).readFromParcel(localParcel);
        ka.b(localFile);
        localParcel.recycle();
        return localObject;
      }
    }
    return null;
  }
  
  public final MapDelegate b()
  {
    return this.b;
  }
  
  public BitmapDescriptor createBitmapDescriptor(float paramFloat, int paramInt)
  {
    fj localfj = new fj(getContext(), paramInt);
    localfj.e = paramFloat;
    return new BitmapDescriptor(localfj);
  }
  
  public BitmapDescriptor createBitmapDescriptor(int paramInt)
  {
    fj localfj = new fj(getContext(), paramInt);
    if (paramInt == 5) {
      return new BitmapDescriptor(localfj);
    }
    return null;
  }
  
  public BitmapDescriptor createBitmapDescriptor(int paramInt1, int paramInt2)
  {
    fj localfj = new fj(getContext(), paramInt2);
    localfj.a = paramInt1;
    return new BitmapDescriptor(localfj);
  }
  
  public BitmapDescriptor createBitmapDescriptor(Bitmap paramBitmap, int paramInt)
  {
    return new BitmapDescriptor(new fj(getContext(), paramInt).a(paramBitmap));
  }
  
  public BitmapDescriptor createBitmapDescriptor(Parcelable paramParcelable, int paramInt)
  {
    fj localfj = new fj(getContext(), paramInt);
    if (paramInt == 9)
    {
      if ((paramParcelable instanceof fj.a))
      {
        localfj.g = ((fj.a)paramParcelable);
        return new BitmapDescriptor(localfj);
      }
    }
    else if ((paramInt == 7) && ((paramParcelable instanceof Bitmap))) {
      return new BitmapDescriptor(localfj.a((Bitmap)paramParcelable));
    }
    return null;
  }
  
  public BitmapDescriptor createBitmapDescriptor(String paramString, int paramInt)
  {
    fj localfj = new fj(getContext(), paramInt);
    if (paramInt == 2)
    {
      localfj.b = paramString;
      return new BitmapDescriptor(localfj);
    }
    if (paramInt == 3)
    {
      localfj.c = paramString;
      return new BitmapDescriptor(localfj);
    }
    if (paramInt == 4)
    {
      localfj.d = paramString;
      return new BitmapDescriptor(localfj);
    }
    if (paramInt == 8)
    {
      localfj.f = paramString;
      return new BitmapDescriptor(localfj);
    }
    return null;
  }
  
  public BitmapDescriptor createBitmapDescriptor(Bitmap[] paramArrayOfBitmap, int paramInt)
  {
    fj localfj = new fj(getContext(), paramInt);
    localfj.h = paramArrayOfBitmap;
    localfj.getBitmap(localfj.i);
    return new BitmapDescriptor(localfj);
  }
  
  public Context getContext()
  {
    return this.l;
  }
  
  public MyLocationStyle getDefaultMyLocationStyle()
  {
    MyLocationStyle localMyLocationStyle = new MyLocationStyle();
    localMyLocationStyle.icon(createBitmapDescriptor("navi_marker_location.png", 2));
    return localMyLocationStyle;
  }
  
  public <T extends TencentMapComponent.Component> T getMapComponent(Class<T> paramClass)
  {
    paramClass = (TencentMapComponent.Component)g.get(paramClass);
    if ((paramClass instanceof bl)) {
      ((bl)paramClass).a(this, null);
    }
    return paramClass;
  }
  
  public TencentMapComponent getMapComponent()
  {
    return this;
  }
  
  public TencentMapResource getMapResource()
  {
    return this;
  }
  
  public TencentMapServiceProtocol getMapServiceProtocol()
  {
    return (TencentMapServiceProtocol)getMapComponent(TencentMapProtocol.class);
  }
  
  public int getScreenPixels()
  {
    return gw.e();
  }
  
  public Typeface getTypeface()
  {
    return this.a.getTypeface();
  }
  
  public abstract boolean l();
  
  final void o()
  {
    Object localObject1 = u();
    gw.a(this.l, ((b)localObject1).a, ((b)localObject1).b, ((b)localObject1).f);
    this.c = new gb(this);
    localObject1 = this.c;
    if (((gb)localObject1).a == 0) {
      ((gb)localObject1).a(new gb.1((gb)localObject1, new gb.2((gb)localObject1)));
    }
    ((gb)localObject1).a += 1;
    long l1 = System.currentTimeMillis();
    gb.e.a(gb.c.a).e = Long.valueOf(l1);
    this.d = new gq(l1);
    localObject1 = q();
    if (localObject1 != null)
    {
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        h.add(new bm.a((Class)((Map.Entry)localObject2).getKey(), (Class)((Map.Entry)localObject2).getValue()));
      }
    }
    Object localObject2 = h.iterator();
    label328:
    label329:
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (bm.a)((Iterator)localObject2).next();
        Class localClass = ((bm.a)localObject3).a;
        localObject1 = (TencentMapComponent.Component)g.get(localClass);
        localObject3 = ((bm.a)localObject3).b;
        if ((localObject1 != null) || (localObject3 == null) || (!localClass.isAssignableFrom((Class)localObject3))) {
          break label328;
        }
        localObject1 = (TencentMapComponent.Component)gy.a((Class)localObject3, new Object[0]);
        if ((localObject1 instanceof bl)) {
          ((bl)localObject1).a(getContext());
        }
        g.put(localClass, localObject1);
      }
      for (;;)
      {
        if (!(localObject1 instanceof bl)) {
          break label329;
        }
        ((bl)localObject1).a(this);
        break;
        return;
      }
    }
  }
  
  protected abstract void p();
  
  protected Map<Class<? extends TencentMapComponent.Component>, Class<? extends TencentMapComponent.Component>> q()
  {
    return null;
  }
  
  final void s()
  {
    Iterator localIterator = g.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      TencentMapComponent.Component localComponent = (TencentMapComponent.Component)localEntry.getValue();
      if ((localComponent instanceof bl))
      {
        ((bl)localComponent).b(this);
        if (((bl)localComponent).c_() == null) {
          g.remove(localEntry.getKey());
        }
      }
    }
    gw.o();
  }
  
  public final mf t()
  {
    if (this.m == null) {
      this.m = mf.a(this.l, this.a);
    }
    return this.m;
  }
  
  public final b u()
  {
    return new b(this.a);
  }
  
  public abstract String v();
  
  public abstract String w();
  
  public abstract String x();
  
  public abstract br y();
  
  public static final class b
  {
    public String a;
    public String b;
    public String c;
    public String d;
    String e;
    String f;
    
    b(TencentMapOptions paramTencentMapOptions)
    {
      AppMethodBeat.i(222196);
      this.f = "undefined";
      this.a = gw.a();
      this.b = gw.k();
      this.e = gw.l();
      if (paramTencentMapOptions != null)
      {
        if (!TextUtils.isEmpty(paramTencentMapOptions.getMapKey())) {
          this.a = paramTencentMapOptions.getMapKey();
        }
        if (!TextUtils.isEmpty(paramTencentMapOptions.getSubKey())) {
          this.c = paramTencentMapOptions.getSubKey();
        }
        if (!TextUtils.isEmpty(paramTencentMapOptions.getSubId())) {
          this.d = paramTencentMapOptions.getSubId();
        }
        this.f = paramTencentMapOptions.getCustomUserId();
      }
      AppMethodBeat.o(222196);
    }
    
    private String d()
    {
      return this.a;
    }
    
    private String e()
    {
      return this.b;
    }
    
    private String f()
    {
      return this.c;
    }
    
    private String g()
    {
      return this.d;
    }
    
    private String h()
    {
      return this.e;
    }
    
    private String i()
    {
      return this.f;
    }
    
    private String j()
    {
      AppMethodBeat.i(222244);
      String str = this.a + "-" + this.b + "-" + this.c + "-" + this.d;
      AppMethodBeat.o(222244);
      return str;
    }
    
    private String k()
    {
      AppMethodBeat.i(222252);
      String str = kr.a(a());
      AppMethodBeat.o(222252);
      return str;
    }
    
    public final String a()
    {
      AppMethodBeat.i(222265);
      String str = this.e + "-" + this.a + "-" + this.b + "-" + this.c + "-" + this.d;
      AppMethodBeat.o(222265);
      return str;
    }
    
    public final String b()
    {
      AppMethodBeat.i(222273);
      if (TextUtils.isEmpty(this.c))
      {
        str = this.a;
        AppMethodBeat.o(222273);
        return str;
      }
      String str = this.c;
      AppMethodBeat.o(222273);
      return str;
    }
    
    public final String c()
    {
      AppMethodBeat.i(222283);
      String str = kr.a(this.a + "-" + this.b + "-" + this.c + "-" + this.d);
      AppMethodBeat.o(222283);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.bm
 * JD-Core Version:    0.7.0.1
 */