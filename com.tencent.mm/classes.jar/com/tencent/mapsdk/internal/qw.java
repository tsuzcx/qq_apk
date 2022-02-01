package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.SparseArray;
import com.tencent.map.tools.EncryptAesUtils;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetRequest.NetRequestBuilder;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Basic;
import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Detail;
import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Response;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds.Builder;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent;
import java.io.File;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.crypto.spec.IvParameterSpec;

public final class qw
  implements oc
{
  public static final String a = "d8ab2f7b7a7536a71894084e1c812fd0";
  public static final IvParameterSpec b;
  public static int c;
  public static int d;
  public static int e;
  public volatile boolean f;
  public volatile boolean g;
  public volatile boolean h;
  qv i;
  public final a j;
  private mk k;
  private final SparseArray<qt> l;
  private String m;
  private dp n;
  
  static
  {
    AppMethodBeat.i(226267);
    b = new IvParameterSpec("c0ab1f54he78k36d".getBytes());
    c = 0;
    d = 1;
    e = 2;
    AppMethodBeat.o(226267);
  }
  
  public qw(mk parammk)
  {
    AppMethodBeat.i(226167);
    this.l = new SparseArray(32);
    this.j = new a();
    this.k = parammk;
    this.k.a(this);
    this.i = new qv(this.k.k);
    parammk = mf.a(parammk.getContext(), null);
    kb.a(parammk.d);
    this.m = parammk.d;
    this.n = ((dp)cj.a(dp.class));
    AppMethodBeat.o(226167);
  }
  
  private qt a(int paramInt, LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3)
  {
    AppMethodBeat.i(226212);
    paramLatLng3 = URLEncoder.encode(EncryptAesUtils.encryptAes256Base64("lblat=" + paramLatLng1.latitude + "&lblon=" + paramLatLng1.longitude + "&rtlat=" + paramLatLng2.latitude + "&rtlon=" + paramLatLng2.longitude + "&zoom=" + paramInt + "&suid=" + gw.d() + "&version=" + gw.l() + "&nt=" + gw.f() + "&location=" + paramLatLng3.latitude + "," + paramLatLng3.longitude, "d8ab2f7b7a7536a71894084e1c812fd0", b));
    paramLatLng3 = ((db)this.n.h()).mapTrafficEvent(paramLatLng3);
    if ((paramLatLng3 == null) || (paramLatLng3.data == null))
    {
      paramLatLng2 = new StringBuilder("rsp = ");
      if (paramLatLng3 != null) {}
      for (paramLatLng1 = Integer.valueOf(paramLatLng3.statusCode);; paramLatLng1 = "null")
      {
        kh.c("net", paramLatLng1);
        AppMethodBeat.o(226212);
        return null;
      }
    }
    paramLatLng3 = new m(paramLatLng3.data);
    paramLatLng3.a("UTF-8");
    Response localResponse = new Response();
    localResponse.readFrom(paramLatLng3);
    if ((localResponse.error == 0) && (localResponse.detail != null)) {}
    for (paramLatLng1 = new qt(new LatLngBounds.Builder().include(paramLatLng1).include(paramLatLng2).build(), localResponse.detail);; paramLatLng1 = null)
    {
      AppMethodBeat.o(226212);
      return paramLatLng1;
    }
  }
  
  private void a()
  {
    AppMethodBeat.i(226181);
    this.g = false;
    synchronized (this.j)
    {
      this.j.notifyAll();
      AppMethodBeat.o(226181);
      return;
    }
  }
  
  private void a(qt paramqt1, qt paramqt2)
  {
    AppMethodBeat.i(226220);
    if ((paramqt2 == null) || (paramqt2.c == null))
    {
      AppMethodBeat.o(226220);
      return;
    }
    if (paramqt2.c.isEmpty())
    {
      this.i.a();
      AppMethodBeat.o(226220);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject;
    if ((paramqt1 != null) && (paramqt1.c != null) && (!paramqt1.c.isEmpty()))
    {
      localObject = paramqt1.c;
      paramqt1 = paramqt2.c;
      paramqt2 = ((List)localObject).iterator();
    }
    label207:
    for (;;)
    {
      if (paramqt2.hasNext())
      {
        localObject = (Detail)paramqt2.next();
        Iterator localIterator = paramqt1.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((Detail)localIterator.next()).basic.eventid.equals(((Detail)localObject).basic.eventid));
      }
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 != 0) {
          break label207;
        }
        localLinkedList.add(localObject);
        break;
        this.i.b(localLinkedList);
        AppMethodBeat.o(226220);
        return;
      }
    }
  }
  
  private void a(List<Detail> paramList)
  {
    AppMethodBeat.i(226232);
    Iterator localIterator = paramList.iterator();
    label186:
    while (localIterator.hasNext())
    {
      Object localObject = ((Detail)localIterator.next()).basic.icon_normal;
      int i1 = ((String)localObject).lastIndexOf("/");
      if ((i1 != -1) && (i1 + 1 <= ((String)localObject).length()))
      {
        String str = ((String)localObject).substring(i1 + 1);
        if (gv.b.a(str) == null)
        {
          paramList = new File(this.m, str);
          if (!paramList.exists())
          {
            localObject = NetManager.getInstance().builder().url((String)localObject).doGet();
            if ((localObject != null) && (((NetResponse)localObject).data != null)) {
              ka.a(paramList, ((NetResponse)localObject).data);
            }
          }
          else
          {
            for (paramList = ((NetResponse)localObject).data;; paramList = ka.c(paramList))
            {
              if ((paramList == null) || (paramList.length <= 0)) {
                break label186;
              }
              paramList = BitmapFactory.decodeByteArray(paramList, 0, paramList.length);
              gv.b.a(str, paramList);
              break;
            }
          }
        }
      }
    }
    AppMethodBeat.o(226232);
  }
  
  private void a(boolean paramBoolean)
  {
    AppMethodBeat.i(226175);
    this.f = paramBoolean;
    if (paramBoolean) {
      try
      {
        synchronized (this.j)
        {
          this.j.start();
          AppMethodBeat.o(226175);
          return;
        }
        this.f = false;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(226175);
        return;
      }
    }
    synchronized (this.j)
    {
      this.j.notifyAll();
      AppMethodBeat.o(226175);
      return;
    }
  }
  
  private qt b(int paramInt)
  {
    AppMethodBeat.i(226203);
    if ((this.k == null) || ((this.k.C() != null) && (this.k.C().e)))
    {
      AppMethodBeat.o(226203);
      return null;
    }
    kh.c("TTE", "traffic event tobe fetch data from net!");
    Object localObject2 = this.k.o;
    Object localObject1 = this.k.n.a(new PointF(((Rect)localObject2).width() * -2, ((Rect)localObject2).height() * 3));
    localObject2 = this.k.n.a(new PointF(((Rect)localObject2).width() * 3, ((Rect)localObject2).height() * -2));
    Object localObject3 = jz.a(this.k.t.m);
    localObject3 = URLEncoder.encode(EncryptAesUtils.encryptAes256Base64("lblat=" + ((LatLng)localObject1).latitude + "&lblon=" + ((LatLng)localObject1).longitude + "&rtlat=" + ((LatLng)localObject2).latitude + "&rtlon=" + ((LatLng)localObject2).longitude + "&zoom=" + paramInt + "&suid=" + gw.d() + "&version=" + gw.l() + "&nt=" + gw.f() + "&location=" + ((LatLng)localObject3).latitude + "," + ((LatLng)localObject3).longitude, "d8ab2f7b7a7536a71894084e1c812fd0", b));
    localObject3 = ((db)this.n.h()).mapTrafficEvent((String)localObject3);
    if ((localObject3 == null) || (((NetResponse)localObject3).data == null))
    {
      localObject2 = new StringBuilder("rsp = ");
      if (localObject3 != null) {}
      for (localObject1 = Integer.valueOf(((NetResponse)localObject3).statusCode);; localObject1 = "null")
      {
        kh.c("net", localObject1);
        AppMethodBeat.o(226203);
        return null;
      }
    }
    localObject3 = new m(((NetResponse)localObject3).data);
    ((m)localObject3).a("UTF-8");
    Response localResponse = new Response();
    localResponse.readFrom((m)localObject3);
    if ((localResponse.error == 0) && (localResponse.detail != null)) {}
    for (localObject1 = new qt(new LatLngBounds.Builder().include((LatLng)localObject1).include((LatLng)localObject2).build(), localResponse.detail);; localObject1 = null)
    {
      AppMethodBeat.o(226203);
      return localObject1;
    }
  }
  
  private void b()
  {
    this.g = true;
  }
  
  private void c()
  {
    AppMethodBeat.i(226188);
    this.h = true;
    this.f = false;
    synchronized (this.j)
    {
      this.j.notifyAll();
      AppMethodBeat.o(226188);
      return;
    }
  }
  
  public final TrafficEvent a(int paramInt)
  {
    AppMethodBeat.i(226276);
    if (this.i == null)
    {
      AppMethodBeat.o(226276);
      return null;
    }
    Object localObject1 = this.i.a.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (qv.a)this.i.a.get(localObject2);
      if ((localObject2 != null) && (((qv.a)localObject2).a.e_() == paramInt))
      {
        localObject1 = new qu(((qv.a)localObject2).b);
        AppMethodBeat.o(226276);
        return localObject1;
      }
    }
    AppMethodBeat.o(226276);
    return null;
  }
  
  final void a(qt paramqt)
  {
    AppMethodBeat.i(226269);
    if ((paramqt == null) || (paramqt.c == null) || (paramqt.c.isEmpty()))
    {
      AppMethodBeat.o(226269);
      return;
    }
    Object localObject1;
    if (this.k != null)
    {
      localObject1 = this.k.d;
      if (localObject1 != null)
      {
        localObject1 = ((gq)localObject1).f();
        ((gp)localObject1).a += 1;
      }
    }
    Iterator localIterator = paramqt.c.iterator();
    label256:
    while (localIterator.hasNext())
    {
      Object localObject2 = ((Detail)localIterator.next()).basic.icon_normal;
      int i1 = ((String)localObject2).lastIndexOf("/");
      if ((i1 != -1) && (i1 + 1 <= ((String)localObject2).length()))
      {
        String str = ((String)localObject2).substring(i1 + 1);
        if (gv.b.a(str) == null)
        {
          localObject1 = new File(this.m, str);
          if (!((File)localObject1).exists())
          {
            localObject2 = NetManager.getInstance().builder().url((String)localObject2).doGet();
            if ((localObject2 != null) && (((NetResponse)localObject2).data != null)) {
              ka.a((File)localObject1, ((NetResponse)localObject2).data);
            }
          }
          else
          {
            for (localObject1 = ((NetResponse)localObject2).data;; localObject1 = ka.c((File)localObject1))
            {
              if ((localObject1 == null) || (localObject1.length <= 0)) {
                break label256;
              }
              localObject1 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
              gv.b.a(str, (Bitmap)localObject1);
              break;
            }
          }
        }
      }
    }
    this.i.a(paramqt.c);
    AppMethodBeat.o(226269);
  }
  
  public final void h() {}
  
  public final void i()
  {
    AppMethodBeat.i(226274);
    synchronized (this.j)
    {
      this.j.notifyAll();
      AppMethodBeat.o(226274);
      return;
    }
  }
  
  public final class a
    extends Thread
  {
    private static final int b = 60000;
    
    a()
    {
      AppMethodBeat.i(221546);
      setName("tms-traffic");
      qw.a(qw.this);
      qw.a(qw.this, false);
      AppMethodBeat.o(221546);
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 45
      //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 15	com/tencent/mapsdk/internal/qw$a:a	Lcom/tencent/mapsdk/internal/qw;
      //   9: invokestatic 47	com/tencent/mapsdk/internal/qw:b	(Lcom/tencent/mapsdk/internal/qw;)Z
      //   12: ifne +464 -> 476
      //   15: aload_0
      //   16: getfield 15	com/tencent/mapsdk/internal/qw$a:a	Lcom/tencent/mapsdk/internal/qw;
      //   19: invokestatic 50	com/tencent/mapsdk/internal/qw:c	(Lcom/tencent/mapsdk/internal/qw;)Z
      //   22: ifeq +454 -> 476
      //   25: aload_0
      //   26: getfield 15	com/tencent/mapsdk/internal/qw$a:a	Lcom/tencent/mapsdk/internal/qw;
      //   29: invokestatic 53	com/tencent/mapsdk/internal/qw:d	(Lcom/tencent/mapsdk/internal/qw;)Z
      //   32: ifne +416 -> 448
      //   35: aload_0
      //   36: getfield 15	com/tencent/mapsdk/internal/qw$a:a	Lcom/tencent/mapsdk/internal/qw;
      //   39: invokestatic 57	com/tencent/mapsdk/internal/qw:e	(Lcom/tencent/mapsdk/internal/qw;)Lcom/tencent/mapsdk/internal/mk;
      //   42: ifnonnull +15 -> 57
      //   45: aload_0
      //   46: getfield 15	com/tencent/mapsdk/internal/qw$a:a	Lcom/tencent/mapsdk/internal/qw;
      //   49: iconst_1
      //   50: invokestatic 37	com/tencent/mapsdk/internal/qw:a	(Lcom/tencent/mapsdk/internal/qw;Z)Z
      //   53: pop
      //   54: goto -49 -> 5
      //   57: aload_0
      //   58: getfield 15	com/tencent/mapsdk/internal/qw$a:a	Lcom/tencent/mapsdk/internal/qw;
      //   61: invokestatic 57	com/tencent/mapsdk/internal/qw:e	(Lcom/tencent/mapsdk/internal/qw;)Lcom/tencent/mapsdk/internal/mk;
      //   64: getfield 63	com/tencent/mapsdk/internal/mk:t	Lcom/tencent/mapsdk/internal/v;
      //   67: invokevirtual 68	com/tencent/mapsdk/internal/v:a	()F
      //   70: f2i
      //   71: istore_1
      //   72: aload_0
      //   73: getfield 15	com/tencent/mapsdk/internal/qw$a:a	Lcom/tencent/mapsdk/internal/qw;
      //   76: invokestatic 57	com/tencent/mapsdk/internal/qw:e	(Lcom/tencent/mapsdk/internal/qw;)Lcom/tencent/mapsdk/internal/mk;
      //   79: getfield 72	com/tencent/mapsdk/internal/mk:n	Lcom/tencent/mapsdk/internal/ep;
      //   82: invokeinterface 77 1 0
      //   87: astore 4
      //   89: aload_0
      //   90: getfield 15	com/tencent/mapsdk/internal/qw$a:a	Lcom/tencent/mapsdk/internal/qw;
      //   93: invokestatic 81	com/tencent/mapsdk/internal/qw:f	(Lcom/tencent/mapsdk/internal/qw;)Landroid/util/SparseArray;
      //   96: iload_1
      //   97: invokevirtual 87	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   100: checkcast 89	com/tencent/mapsdk/internal/qt
      //   103: astore_3
      //   104: aconst_null
      //   105: astore_2
      //   106: aload_3
      //   107: ifnull +81 -> 188
      //   110: aload_3
      //   111: getfield 92	com/tencent/mapsdk/internal/qt:c	Ljava/util/List;
      //   114: ifnull +74 -> 188
      //   117: invokestatic 98	java/lang/System:currentTimeMillis	()J
      //   120: aload_3
      //   121: getfield 101	com/tencent/mapsdk/internal/qt:a	J
      //   124: lsub
      //   125: ldc2_w 102
      //   128: lcmp
      //   129: ifgt +59 -> 188
      //   132: aload_3
      //   133: getfield 106	com/tencent/mapsdk/internal/qt:b	Lcom/tencent/tencentmap/mapsdk/maps/model/LatLngBounds;
      //   136: aload 4
      //   138: iconst_0
      //   139: aaload
      //   140: invokevirtual 112	com/tencent/tencentmap/mapsdk/maps/model/LatLngBounds:contains	(Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;)Z
      //   143: ifeq +45 -> 188
      //   146: aload_3
      //   147: getfield 106	com/tencent/mapsdk/internal/qt:b	Lcom/tencent/tencentmap/mapsdk/maps/model/LatLngBounds;
      //   150: aload 4
      //   152: iconst_1
      //   153: aaload
      //   154: invokevirtual 112	com/tencent/tencentmap/mapsdk/maps/model/LatLngBounds:contains	(Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;)Z
      //   157: ifeq +31 -> 188
      //   160: aload_3
      //   161: getfield 106	com/tencent/mapsdk/internal/qt:b	Lcom/tencent/tencentmap/mapsdk/maps/model/LatLngBounds;
      //   164: aload 4
      //   166: iconst_2
      //   167: aaload
      //   168: invokevirtual 112	com/tencent/tencentmap/mapsdk/maps/model/LatLngBounds:contains	(Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;)Z
      //   171: ifeq +17 -> 188
      //   174: aload_3
      //   175: getfield 106	com/tencent/mapsdk/internal/qt:b	Lcom/tencent/tencentmap/mapsdk/maps/model/LatLngBounds;
      //   178: aload 4
      //   180: iconst_3
      //   181: aaload
      //   182: invokevirtual 112	com/tencent/tencentmap/mapsdk/maps/model/LatLngBounds:contains	(Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;)Z
      //   185: ifne +12 -> 197
      //   188: aload_0
      //   189: getfield 15	com/tencent/mapsdk/internal/qw$a:a	Lcom/tencent/mapsdk/internal/qw;
      //   192: iload_1
      //   193: invokestatic 115	com/tencent/mapsdk/internal/qw:a	(Lcom/tencent/mapsdk/internal/qw;I)Lcom/tencent/mapsdk/internal/qt;
      //   196: astore_2
      //   197: aload_2
      //   198: ifnull +10 -> 208
      //   201: aload_2
      //   202: getfield 92	com/tencent/mapsdk/internal/qt:c	Ljava/util/List;
      //   205: ifnonnull +327 -> 532
      //   208: aload_3
      //   209: astore_2
      //   210: aload_0
      //   211: getfield 15	com/tencent/mapsdk/internal/qw$a:a	Lcom/tencent/mapsdk/internal/qw;
      //   214: invokestatic 81	com/tencent/mapsdk/internal/qw:f	(Lcom/tencent/mapsdk/internal/qw;)Landroid/util/SparseArray;
      //   217: iload_1
      //   218: aload_2
      //   219: invokevirtual 119	android/util/SparseArray:put	(ILjava/lang/Object;)V
      //   222: aload_0
      //   223: getfield 15	com/tencent/mapsdk/internal/qw$a:a	Lcom/tencent/mapsdk/internal/qw;
      //   226: astore 4
      //   228: aload_2
      //   229: ifnull +10 -> 239
      //   232: aload_2
      //   233: getfield 92	com/tencent/mapsdk/internal/qt:c	Ljava/util/List;
      //   236: ifnonnull +35 -> 271
      //   239: aload_0
      //   240: getfield 15	com/tencent/mapsdk/internal/qw$a:a	Lcom/tencent/mapsdk/internal/qw;
      //   243: aload_2
      //   244: invokevirtual 122	com/tencent/mapsdk/internal/qw:a	(Lcom/tencent/mapsdk/internal/qt;)V
      //   247: aload_0
      //   248: monitorenter
      //   249: aload_0
      //   250: ldc2_w 102
      //   253: invokevirtual 128	java/lang/Object:wait	(J)V
      //   256: aload_0
      //   257: monitorexit
      //   258: goto -253 -> 5
      //   261: astore_2
      //   262: aload_0
      //   263: monitorexit
      //   264: ldc 45
      //   266: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   269: aload_2
      //   270: athrow
      //   271: aload_2
      //   272: getfield 92	com/tencent/mapsdk/internal/qt:c	Ljava/util/List;
      //   275: invokeinterface 134 1 0
      //   280: ifeq +14 -> 294
      //   283: aload 4
      //   285: getfield 137	com/tencent/mapsdk/internal/qw:i	Lcom/tencent/mapsdk/internal/qv;
      //   288: invokevirtual 141	com/tencent/mapsdk/internal/qv:a	()V
      //   291: goto -52 -> 239
      //   294: new 143	java/util/LinkedList
      //   297: dup
      //   298: invokespecial 144	java/util/LinkedList:<init>	()V
      //   301: astore 5
      //   303: aload_3
      //   304: ifnull -65 -> 239
      //   307: aload_3
      //   308: getfield 92	com/tencent/mapsdk/internal/qt:c	Ljava/util/List;
      //   311: ifnull -72 -> 239
      //   314: aload_3
      //   315: getfield 92	com/tencent/mapsdk/internal/qt:c	Ljava/util/List;
      //   318: invokeinterface 134 1 0
      //   323: ifne -84 -> 239
      //   326: aload_3
      //   327: getfield 92	com/tencent/mapsdk/internal/qt:c	Ljava/util/List;
      //   330: astore 6
      //   332: aload_2
      //   333: getfield 92	com/tencent/mapsdk/internal/qt:c	Ljava/util/List;
      //   336: astore_3
      //   337: aload 6
      //   339: invokeinterface 148 1 0
      //   344: astore 6
      //   346: aload 6
      //   348: invokeinterface 153 1 0
      //   353: ifeq +82 -> 435
      //   356: aload 6
      //   358: invokeinterface 157 1 0
      //   363: checkcast 159	com/tencent/mapsdk/core/components/protocol/jce/trafficevent/Detail
      //   366: astore 7
      //   368: aload_3
      //   369: invokeinterface 148 1 0
      //   374: astore 8
      //   376: aload 8
      //   378: invokeinterface 153 1 0
      //   383: ifeq +144 -> 527
      //   386: aload 8
      //   388: invokeinterface 157 1 0
      //   393: checkcast 159	com/tencent/mapsdk/core/components/protocol/jce/trafficevent/Detail
      //   396: getfield 163	com/tencent/mapsdk/core/components/protocol/jce/trafficevent/Detail:basic	Lcom/tencent/mapsdk/core/components/protocol/jce/trafficevent/Basic;
      //   399: getfield 169	com/tencent/mapsdk/core/components/protocol/jce/trafficevent/Basic:eventid	Ljava/lang/String;
      //   402: aload 7
      //   404: getfield 163	com/tencent/mapsdk/core/components/protocol/jce/trafficevent/Detail:basic	Lcom/tencent/mapsdk/core/components/protocol/jce/trafficevent/Basic;
      //   407: getfield 169	com/tencent/mapsdk/core/components/protocol/jce/trafficevent/Basic:eventid	Ljava/lang/String;
      //   410: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   413: ifeq -37 -> 376
      //   416: iconst_1
      //   417: istore_1
      //   418: iload_1
      //   419: ifne -73 -> 346
      //   422: aload 5
      //   424: aload 7
      //   426: invokeinterface 178 2 0
      //   431: pop
      //   432: goto -86 -> 346
      //   435: aload 4
      //   437: getfield 137	com/tencent/mapsdk/internal/qw:i	Lcom/tencent/mapsdk/internal/qv;
      //   440: aload 5
      //   442: invokevirtual 181	com/tencent/mapsdk/internal/qv:b	(Ljava/util/List;)V
      //   445: goto -206 -> 239
      //   448: ldc 183
      //   450: ldc 185
      //   452: invokestatic 190	com/tencent/mapsdk/internal/kh:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   455: aload_0
      //   456: monitorenter
      //   457: aload_0
      //   458: invokevirtual 192	java/lang/Object:wait	()V
      //   461: aload_0
      //   462: monitorexit
      //   463: goto -458 -> 5
      //   466: astore_2
      //   467: aload_0
      //   468: monitorexit
      //   469: ldc 45
      //   471: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   474: aload_2
      //   475: athrow
      //   476: ldc 183
      //   478: ldc 194
      //   480: invokestatic 190	com/tencent/mapsdk/internal/kh:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   483: aload_0
      //   484: getfield 15	com/tencent/mapsdk/internal/qw$a:a	Lcom/tencent/mapsdk/internal/qw;
      //   487: invokestatic 198	com/tencent/mapsdk/internal/qw:g	(Lcom/tencent/mapsdk/internal/qw;)Lcom/tencent/mapsdk/internal/qv;
      //   490: ifnull +23 -> 513
      //   493: aload_0
      //   494: getfield 15	com/tencent/mapsdk/internal/qw$a:a	Lcom/tencent/mapsdk/internal/qw;
      //   497: invokestatic 198	com/tencent/mapsdk/internal/qw:g	(Lcom/tencent/mapsdk/internal/qw;)Lcom/tencent/mapsdk/internal/qv;
      //   500: invokevirtual 200	com/tencent/mapsdk/internal/qv:b	()V
      //   503: aload_0
      //   504: getfield 15	com/tencent/mapsdk/internal/qw$a:a	Lcom/tencent/mapsdk/internal/qw;
      //   507: invokestatic 81	com/tencent/mapsdk/internal/qw:f	(Lcom/tencent/mapsdk/internal/qw;)Landroid/util/SparseArray;
      //   510: invokevirtual 203	android/util/SparseArray:clear	()V
      //   513: ldc 45
      //   515: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   518: return
      //   519: astore_2
      //   520: goto -264 -> 256
      //   523: astore_2
      //   524: goto -63 -> 461
      //   527: iconst_0
      //   528: istore_1
      //   529: goto -111 -> 418
      //   532: goto -322 -> 210
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	535	0	this	a
      //   71	458	1	i	int
      //   105	139	2	localObject1	Object
      //   261	72	2	localObject2	Object
      //   466	9	2	localObject3	Object
      //   519	1	2	localInterruptedException1	java.lang.InterruptedException
      //   523	1	2	localInterruptedException2	java.lang.InterruptedException
      //   103	266	3	localObject4	Object
      //   87	349	4	localObject5	Object
      //   301	140	5	localLinkedList	LinkedList
      //   330	27	6	localObject6	Object
      //   366	59	7	localDetail	Detail
      //   374	13	8	localIterator	Iterator
      // Exception table:
      //   from	to	target	type
      //   249	256	261	finally
      //   256	258	261	finally
      //   457	461	466	finally
      //   461	463	466	finally
      //   249	256	519	java/lang/InterruptedException
      //   457	461	523	java/lang/InterruptedException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.qw
 * JD-Core Version:    0.7.0.1
 */