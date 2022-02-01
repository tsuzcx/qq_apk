package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.lib.models.PolygonInfo;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayer;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayer.OnAoiLayerLoadListener;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor.BitmapFormator;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds.Builder;
import com.tencent.tencentmap.mapsdk.maps.model.SubPoi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ox
  implements AoiLayer
{
  private static final String c;
  public oz a;
  public oy b;
  private String d;
  private int e;
  private int f;
  private boolean g;
  private boolean h;
  private int[] i;
  private int[] j;
  private AoiLayer.OnAoiLayerLoadListener k;
  
  static
  {
    AppMethodBeat.i(222346);
    c = AoiLayer.class.getSimpleName();
    AppMethodBeat.o(222346);
  }
  
  public ox(oz paramoz, String paramString, AoiLayerOptions paramAoiLayerOptions, AoiLayer.OnAoiLayerLoadListener paramOnAoiLayerLoadListener)
  {
    AppMethodBeat.i(221872);
    this.e = 20;
    this.f = -1;
    this.a = paramoz;
    this.d = paramString;
    this.k = paramOnAoiLayerLoadListener;
    a(paramAoiLayerOptions);
    AppMethodBeat.o(221872);
  }
  
  private int a(oy paramoy)
  {
    int n = 0;
    AppMethodBeat.i(221903);
    if (this.a == null)
    {
      AppMethodBeat.o(221903);
      return 0;
    }
    mk localmk = this.a.b;
    if (localmk == null)
    {
      AppMethodBeat.o(221903);
      return 0;
    }
    int m = n;
    if (paramoy != null)
    {
      paramoy = a(paramoy.a);
      m = n;
      if (paramoy != null) {
        m = (int)localmk.n.a(paramoy.getSouthWest(), paramoy.getNorthEast(), 0, 0, 0, 0, null) - 2;
      }
    }
    AppMethodBeat.o(221903);
    return m;
  }
  
  private fn a(oy.e parame, oy.d paramd)
  {
    AppMethodBeat.i(222050);
    fn localfn = new fn();
    if (this.a == null)
    {
      AppMethodBeat.o(222050);
      return localfn;
    }
    Object localObject1 = this.a.b;
    if (localObject1 == null)
    {
      AppMethodBeat.o(222050);
      return localfn;
    }
    localObject1 = ((bm)localObject1).getContext();
    if (localObject1 == null)
    {
      AppMethodBeat.o(222050);
      return localfn;
    }
    if (parame == null)
    {
      AppMethodBeat.o(222050);
      return localfn;
    }
    if (parame.e == 0) {
      localfn.k = "";
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = parame.a;
      if (localObject2 != null) {
        break;
      }
      AppMethodBeat.o(222050);
      return localfn;
      if (parame.e == 1)
      {
        localfn.k = paramd.a();
        localObject2 = parame.b;
        if (localObject2 != null)
        {
          localfn.h = ((BitmapDescriptor)localObject2).getFormater().getBitmapId();
          localObject2 = ((BitmapDescriptor)localObject2).getBitmap((Context)localObject1);
          if (localObject2 != null)
          {
            localfn.i = ((Bitmap)localObject2).getWidth();
            localfn.j = ((Bitmap)localObject2).getHeight();
          }
        }
      }
    }
    localfn.b = ((BitmapDescriptor)localObject2).getFormater().getBitmapId();
    localObject1 = ((BitmapDescriptor)localObject2).getBitmap((Context)localObject1);
    if (localObject1 != null)
    {
      localfn.c = ((Bitmap)localObject1).getWidth();
      localfn.d = ((Bitmap)localObject1).getHeight();
    }
    localfn.p = 2;
    localfn.q = parame.k;
    localfn.r = ((parame.j + 1) * 10000 + parame.k);
    localfn.u = paramd.h;
    localfn.s = this.f;
    localfn.t = this.e;
    localfn.g = 1.0F;
    AppMethodBeat.o(222050);
    return localfn;
  }
  
  private oy.d a(long paramLong)
  {
    AppMethodBeat.i(222139);
    if ((this.b != null) && (this.b.a != null) && (this.b.a.j != null))
    {
      Iterator localIterator = this.b.a.j.iterator();
      while (localIterator.hasNext())
      {
        oy.d locald = (oy.d)localIterator.next();
        nf localnf = (nf)this.a.b.k.a(nf.class, locald.a);
        if ((localnf != null) && (localnf.e_() == paramLong))
        {
          AppMethodBeat.o(222139);
          return locald;
        }
      }
    }
    AppMethodBeat.o(222139);
    return null;
  }
  
  private static LatLngBounds a(oy.d paramd)
  {
    AppMethodBeat.i(221987);
    if ((paramd != null) && (paramd.i != null) && (paramd.i.c != null) && (paramd.i.c.b != null))
    {
      Object localObject = paramd.i.c.b;
      paramd = new LatLngBounds.Builder();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramd.include((List)((Iterator)localObject).next());
      }
    }
    for (;;)
    {
      try
      {
        paramd = paramd.build();
        AppMethodBeat.o(221987);
        return paramd;
      }
      catch (Exception paramd)
      {
        kh.a(Log.getStackTraceString(paramd));
      }
      paramd = null;
    }
  }
  
  public static SubPoi a(String paramString, oy.d paramd)
  {
    AppMethodBeat.i(222154);
    SubPoi localSubPoi = new SubPoi();
    localSubPoi.setParentId(paramString);
    localSubPoi.setId(paramd.b);
    localSubPoi.setName(paramd.a());
    localSubPoi.setPosition(paramd.h);
    AppMethodBeat.o(222154);
    return localSubPoi;
  }
  
  private String a(String paramString)
  {
    AppMethodBeat.i(222030);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(222030);
      return paramString;
    }
    new fn();
    if (this.a == null)
    {
      AppMethodBeat.o(222030);
      return paramString;
    }
    Object localObject = this.a.b;
    if (localObject == null)
    {
      AppMethodBeat.o(222030);
      return paramString;
    }
    localObject = ((bm)localObject).getContext();
    if (localObject == null)
    {
      AppMethodBeat.o(222030);
      return paramString;
    }
    int m = (int)ha.a((Context)localObject);
    if (m <= 1) {
      paramString = paramString.replace("{density}", "");
    }
    for (;;)
    {
      AppMethodBeat.o(222030);
      return paramString;
      if (m <= 2) {
        paramString = paramString.replace("{density}", "@2x");
      } else {
        paramString = paramString.replace("{density}", "@3x");
      }
    }
  }
  
  private void a(oy.c paramc, List<List<LatLng>> paramList)
  {
    AppMethodBeat.i(221941);
    if (this.a == null)
    {
      AppMethodBeat.o(221941);
      return;
    }
    mk localmk = this.a.b;
    if (localmk == null)
    {
      AppMethodBeat.o(221941);
      return;
    }
    int m;
    PolygonInfo localPolygonInfo;
    if (this.i == null)
    {
      this.i = new int[paramList.size()];
      paramList = paramList.iterator();
      m = 0;
      if (paramList.hasNext())
      {
        localPolygonInfo = b(paramc, (List)paramList.next());
        if (this.h) {
          break label260;
        }
        int[] arrayOfInt = this.i;
        int n = m + 1;
        arrayOfInt[m] = localmk.a(localPolygonInfo);
        kh.c(c, "添加PoiLayer成功,ID=" + this.i[(n - 1)] + "|model:" + localPolygonInfo);
        m = n;
      }
    }
    label260:
    for (;;)
    {
      break;
      AppMethodBeat.o(221941);
      return;
      paramList = paramList.iterator();
      m = 0;
      while (paramList.hasNext())
      {
        localPolygonInfo = b(paramc, (List)paramList.next());
        localPolygonInfo.polygonId = this.i[m];
        if (!this.h)
        {
          localmk.b(localPolygonInfo);
          kh.c(c, "更新PoiLayer成功");
        }
        m += 1;
      }
      AppMethodBeat.o(221941);
      return;
    }
  }
  
  private void a(List<oy.d> paramList)
  {
    AppMethodBeat.i(221969);
    if (this.a == null)
    {
      AppMethodBeat.o(221969);
      return;
    }
    mk localmk = this.a.b;
    if (localmk == null)
    {
      AppMethodBeat.o(221969);
      return;
    }
    int i1 = paramList.size();
    int[] arrayOfInt = new int[i1];
    Iterator localIterator = paramList.iterator();
    int m = 0;
    while (localIterator.hasNext())
    {
      oy.d locald = (oy.d)localIterator.next();
      Object localObject1 = c(locald.f);
      paramList = new fn();
      if (this.a == null)
      {
        label113:
        if (locald.a >= 0) {
          break label499;
        }
        if ((localmk.k == null) || (paramList.u == null)) {
          break label494;
        }
        localObject1 = mk.a(paramList);
        localObject1 = (nf)localmk.k.a((mo)localObject1);
        if (localObject1 == null) {
          break label494;
        }
      }
      Object localObject2;
      label494:
      for (int n = ((nf)localObject1).c();; n = -1)
      {
        locald.a = n;
        arrayOfInt[m] = locald.a;
        kh.c(c, "添加子点成功！" + locald.a() + "|id:" + paramList.h);
        m += 1;
        break;
        localObject2 = this.a.b;
        if (localObject2 == null) {
          break label113;
        }
        localObject2 = ((bm)localObject2).getContext();
        if ((localObject2 == null) || (localObject1 == null)) {
          break label113;
        }
        if (((oy.e)localObject1).e == 0) {
          paramList.k = "";
        }
        Object localObject3;
        for (;;)
        {
          localObject3 = ((oy.e)localObject1).a;
          if (localObject3 != null) {
            break label378;
          }
          break;
          if (((oy.e)localObject1).e == 1)
          {
            paramList.k = locald.a();
            localObject3 = ((oy.e)localObject1).b;
            if (localObject3 != null)
            {
              paramList.h = ((BitmapDescriptor)localObject3).getFormater().getBitmapId();
              localObject3 = ((BitmapDescriptor)localObject3).getBitmap((Context)localObject2);
              if (localObject3 != null)
              {
                paramList.i = ((Bitmap)localObject3).getWidth();
                paramList.j = ((Bitmap)localObject3).getHeight();
              }
            }
          }
        }
        label378:
        paramList.b = ((BitmapDescriptor)localObject3).getFormater().getBitmapId();
        localObject2 = ((BitmapDescriptor)localObject3).getBitmap((Context)localObject2);
        if (localObject2 != null)
        {
          paramList.c = ((Bitmap)localObject2).getWidth();
          paramList.d = ((Bitmap)localObject2).getHeight();
        }
        paramList.p = 2;
        paramList.q = ((oy.e)localObject1).k;
        n = ((oy.e)localObject1).j;
        paramList.r = (((oy.e)localObject1).k + (n + 1) * 10000);
        paramList.u = locald.h;
        paramList.s = this.f;
        paramList.t = this.e;
        paramList.g = 1.0F;
        break label113;
      }
      label499:
      paramList.a = locald.a;
      if (localmk.k != null)
      {
        localObject1 = mk.a(paramList);
        localObject2 = localmk.k;
        n = paramList.a;
        paramList = (mn)((bi)localObject2).i.get(localObject1.getClass());
        if (paramList != null)
        {
          localObject2 = paramList.a(n);
          if (localObject2 != null)
          {
            ((mm)localObject2).a((mo)localObject1);
            paramList.a((mm)localObject2);
          }
        }
      }
      kh.c(c, "更新子点成功！" + locald.a());
    }
    this.j = new int[i1];
    System.arraycopy(arrayOfInt, 0, this.j, 0, i1);
    AppMethodBeat.o(221969);
  }
  
  private void a(List<oy.d> paramList, Callback<oy.d> paramCallback)
  {
    AppMethodBeat.i(222014);
    if (this.a == null)
    {
      AppMethodBeat.o(222014);
      return;
    }
    mk localmk = this.a.b;
    if (localmk == null)
    {
      AppMethodBeat.o(222014);
      return;
    }
    Context localContext = localmk.getContext();
    if (localContext == null)
    {
      AppMethodBeat.o(222014);
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int m = 0;
      if ((m < paramList.size()) && (!this.h))
      {
        oy.d locald = (oy.d)paramList.get(m);
        oy.e locale = c(locald.f);
        String str = locale.d;
        Object localObject1;
        if (TextUtils.isEmpty(str))
        {
          localObject1 = str;
          label134:
          kh.c(c, "请求子点[" + locald.a() + "]icon url:" + (String)localObject1);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            locale.a = localmk.createBitmapDescriptor((String)localObject1, 8);
            locale.a.getFormater().setScale(2);
            if (locale.a.getBitmap(localContext) == null) {
              break label571;
            }
            kh.c(c, "子点[" + locald.a() + "]icon下载成功");
            if (locale.e == 1)
            {
              localObject1 = new fj.a(locald.a(), locale.g, Color.parseColor(locale.f));
              ((fj.a)localObject1).f = localmk.getTypeface();
              ((fj.a)localObject1).e = Color.parseColor(locale.h);
              ((fj.a)localObject1).d = locale.i;
              ((fj.a)localObject1).g = (ha.a(localContext) / 2.0F);
              locale.b = localmk.createBitmapDescriptor((Parcelable)localObject1, 9);
              if (locale.b.getBitmap(localContext) == null) {
                break label535;
              }
              kh.c(c, "子点[" + locald.a() + "]文本图片创建成功");
            }
            label396:
            if (paramCallback != null) {
              paramCallback.callback(locald);
            }
          }
        }
        for (;;)
        {
          m += 1;
          break;
          new fn();
          localObject1 = str;
          if (this.a == null) {
            break label134;
          }
          Object localObject2 = this.a.b;
          localObject1 = str;
          if (localObject2 == null) {
            break label134;
          }
          localObject2 = ((bm)localObject2).getContext();
          localObject1 = str;
          if (localObject2 == null) {
            break label134;
          }
          int n = (int)ha.a((Context)localObject2);
          if (n <= 1)
          {
            localObject1 = str.replace("{density}", "");
            break label134;
          }
          if (n <= 2)
          {
            localObject1 = str.replace("{density}", "@2x");
            break label134;
          }
          localObject1 = str.replace("{density}", "@3x");
          break label134;
          label535:
          kh.d(c, "子点[" + locald.a() + "]文本图片创建失败！");
          break label396;
          label571:
          kh.d(c, "子点[" + locald.a() + "]icon下载失败！");
        }
      }
    }
    AppMethodBeat.o(222014);
  }
  
  private PolygonInfo b(oy.c paramc, List<LatLng> paramList)
  {
    AppMethodBeat.i(222068);
    PolygonInfo localPolygonInfo = new PolygonInfo();
    if (this.a == null)
    {
      AppMethodBeat.o(222068);
      return localPolygonInfo;
    }
    Object localObject = this.a.b;
    if (localObject == null)
    {
      AppMethodBeat.o(222068);
      return localPolygonInfo;
    }
    localObject = ((bm)localObject).getContext();
    if (localObject == null)
    {
      AppMethodBeat.o(222068);
      return localPolygonInfo;
    }
    ha.a((Context)localObject);
    localPolygonInfo.points = ((LatLng[])paramList.toArray(new LatLng[0]));
    if (paramc != null)
    {
      localPolygonInfo.borderWidth = paramc.c;
      localPolygonInfo.borderColor = Color.parseColor(paramc.b);
      localPolygonInfo.color = Color.parseColor(paramc.a);
      localPolygonInfo.level = 1;
      localPolygonInfo.minScaleLevel = this.f;
      localPolygonInfo.maxScaleLevel = this.e;
    }
    AppMethodBeat.o(222068);
    return localPolygonInfo;
  }
  
  private LatLngBounds b()
  {
    AppMethodBeat.i(221884);
    if (this.b != null)
    {
      LatLngBounds localLatLngBounds = a(this.b.a);
      AppMethodBeat.o(221884);
      return localLatLngBounds;
    }
    AppMethodBeat.o(221884);
    return null;
  }
  
  private void b(final oy paramoy)
  {
    AppMethodBeat.i(221921);
    if ((paramoy == null) || (paramoy.a == null))
    {
      AppMethodBeat.o(221921);
      return;
    }
    boolean bool = false;
    Object localObject = c(paramoy.a.f).l;
    oy.a locala = paramoy.a.i;
    kh.c(c, "绘制PoiLayer的面，aoiStyle:" + localObject + "|poiArea:" + locala);
    if ((locala != null) && (locala.c != null) && ("Polygon".equalsIgnoreCase(locala.c.a)) && (locala.c.b != null))
    {
      a((oy.c)localObject, locala.c.b);
      bool = true;
    }
    for (;;)
    {
      this.b = paramoy;
      if (this.k != null) {
        this.k.onAoiLayerLoaded(bool, this);
      }
      if (bool) {
        break;
      }
      AppMethodBeat.o(221921);
      return;
      kh.d(c, "PoiLayer的面渲染失败！");
    }
    paramoy = paramoy.a.j;
    localObject = new ArrayList();
    kh.c(c, "绘制PoiLayer的子点，remotePois:".concat(String.valueOf(paramoy)));
    jw.a(new jw.g()
    {
      public final Object call()
      {
        AppMethodBeat.i(221673);
        if (ox.b(ox.this))
        {
          AppMethodBeat.o(221673);
          return null;
        }
        ox.a(ox.this, paramoy, new Callback()
        {
          private void a(oy.d paramAnonymous2d)
          {
            AppMethodBeat.i(221479);
            if (paramAnonymous2d != null) {
              ox.4.this.b.add(paramAnonymous2d);
            }
            AppMethodBeat.o(221479);
          }
        });
        AppMethodBeat.o(221673);
        return null;
      }
    }).a(null, new jw.a()
    {
      public final void callback(Object paramAnonymousObject)
      {
        AppMethodBeat.i(221705);
        if (ox.b(ox.this))
        {
          AppMethodBeat.o(221705);
          return;
        }
        int i = paramoy.size();
        int j = this.b.size();
        if (i != j) {
          kh.d(ox.a(), "PoiLayer的子点渲染缺失！！count:" + j + "/" + i);
        }
        ox.a(ox.this, this.b);
        AppMethodBeat.o(221705);
      }
    });
    AppMethodBeat.o(221921);
  }
  
  private static Point[] b(List<LatLng> paramList)
  {
    AppMethodBeat.i(222084);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Point[] arrayOfPoint = new Point[paramList.size()];
      int m = 0;
      while (m < arrayOfPoint.length)
      {
        arrayOfPoint[m] = GeoPoint.from((LatLng)paramList.get(m)).toPoint();
        m += 1;
      }
      AppMethodBeat.o(222084);
      return arrayOfPoint;
    }
    AppMethodBeat.o(222084);
    return new Point[0];
  }
  
  private oy.e c(List<oy.e> paramList)
  {
    AppMethodBeat.i(222100);
    oy.e locale = new oy.e();
    if ((paramList == null) || (this.a == null) || (this.a.b == null))
    {
      AppMethodBeat.o(222100);
      return locale;
    }
    boolean bool = this.a.b.l();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (oy.e)localIterator.next();
      if ((!bool) || (paramList.c != 1)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(222100);
      return paramList;
      if ((bool) || (paramList.c != 0)) {
        break;
      }
      continue;
      paramList = locale;
    }
  }
  
  private oy c()
  {
    AppMethodBeat.i(222126);
    kh.c(c, "请求poiDetail[" + this.d + "]");
    if (this.a == null)
    {
      AppMethodBeat.o(222126);
      return null;
    }
    Object localObject = this.a.b;
    if (localObject == null)
    {
      AppMethodBeat.o(222126);
      return null;
    }
    localObject = ((ct)((dh)cj.a(dh.class)).h()).poiDetail(this.d, ((bm)localObject).u().a);
    ((NetResponse)localObject).charset = "UTF-8";
    localObject = new dt.a((NetResponse)localObject, oy.class);
    kh.c(c, "poiDetail[" + this.d + "] resp:" + ((dt.a)localObject).available());
    if (((dt.a)localObject).available())
    {
      localObject = (oy)((dt.a)localObject).b;
      AppMethodBeat.o(222126);
      return localObject;
    }
    AppMethodBeat.o(222126);
    return null;
  }
  
  private oy.c d(List<oy.e> paramList)
  {
    AppMethodBeat.i(222111);
    paramList = c(paramList).l;
    AppMethodBeat.o(222111);
    return paramList;
  }
  
  public final void a(AoiLayerOptions paramAoiLayerOptions)
  {
    AppMethodBeat.i(222401);
    if (paramAoiLayerOptions != null)
    {
      if (paramAoiLayerOptions.getMaxLevel() != -1) {
        this.e = paramAoiLayerOptions.getMaxLevel();
      }
      if (paramAoiLayerOptions.getMinLevel() != -1) {
        this.f = paramAoiLayerOptions.getMinLevel();
      }
    }
    if (this.g)
    {
      AppMethodBeat.o(222401);
      return;
    }
    kh.c(c, "开始更新POI[" + this.d + "]的详情数据");
    this.g = true;
    jw.a(new jw.g()
    {
      private oy a()
      {
        AppMethodBeat.i(221720);
        if (ox.b(ox.this))
        {
          AppMethodBeat.o(221720);
          return null;
        }
        oy localoy = ox.f(ox.this);
        AppMethodBeat.o(221720);
        return localoy;
      }
    }).a(null, new jw.a()
    {
      private void a(oy paramAnonymousoy)
      {
        AppMethodBeat.i(221784);
        kh.c(ox.a(), "POI[" + ox.a(ox.this) + "]的详情数据：" + paramAnonymousoy);
        if ((paramAnonymousoy != null) && (!ox.b(ox.this)))
        {
          if (ox.c(ox.this) < 0) {
            ox.a(ox.this, ox.a(ox.this, paramAnonymousoy));
          }
          ox.b(ox.this, paramAnonymousoy);
        }
        for (;;)
        {
          ox.e(ox.this);
          kh.c(ox.a(), "结束POI[" + ox.a(ox.this) + "]详情数据的更新");
          AppMethodBeat.o(221784);
          return;
          if (ox.d(ox.this) != null) {
            ox.d(ox.this).onAoiLayerLoaded(false, ox.this);
          }
        }
      }
    });
    AppMethodBeat.o(222401);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(222427);
    if (this == paramObject)
    {
      AppMethodBeat.o(222427);
      return true;
    }
    if (!(paramObject instanceof ox))
    {
      AppMethodBeat.o(222427);
      return false;
    }
    paramObject = (ox)paramObject;
    if (this.d != null)
    {
      boolean bool = this.d.equals(paramObject.d);
      AppMethodBeat.o(222427);
      return bool;
    }
    if (paramObject.d == null)
    {
      AppMethodBeat.o(222427);
      return true;
    }
    AppMethodBeat.o(222427);
    return false;
  }
  
  public final String getId()
  {
    return this.d;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(222437);
    if (this.d != null)
    {
      int m = this.d.hashCode();
      AppMethodBeat.o(222437);
      return m;
    }
    AppMethodBeat.o(222437);
    return 0;
  }
  
  public final LatLng location()
  {
    if ((this.b != null) && (this.b.a != null)) {
      return this.b.a.h;
    }
    return null;
  }
  
  public final String name()
  {
    if ((this.b != null) && (this.b.a != null)) {
      return this.b.a.c;
    }
    return null;
  }
  
  public final boolean remove()
  {
    int n = 0;
    AppMethodBeat.i(222419);
    if ((this.a == null) || (this.h))
    {
      AppMethodBeat.o(222419);
      return false;
    }
    mk localmk = this.a.b;
    if (localmk == null)
    {
      AppMethodBeat.o(222419);
      return false;
    }
    int[] arrayOfInt;
    int i1;
    int m;
    if (this.j != null)
    {
      arrayOfInt = this.j;
      i1 = arrayOfInt.length;
      m = 0;
      while (m < i1)
      {
        int i2 = arrayOfInt[m];
        if (localmk.k != null)
        {
          mm localmm = localmk.k.a(nf.class, i2);
          if (localmm != null) {
            localmm.remove();
          }
        }
        m += 1;
      }
      this.j = null;
    }
    for (boolean bool = true;; bool = false)
    {
      if (this.i != null)
      {
        arrayOfInt = this.i;
        i1 = arrayOfInt.length;
        m = n;
        while (m < i1)
        {
          localmk.a(arrayOfInt[m]);
          m += 1;
        }
        this.i = null;
        bool = true;
      }
      this.b = null;
      this.a.a.remove(this);
      this.h = true;
      kh.c(c, "移除poiLayer[" + this.d + "]");
      AppMethodBeat.o(222419);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ox
 * JD-Core Version:    0.7.0.1
 */