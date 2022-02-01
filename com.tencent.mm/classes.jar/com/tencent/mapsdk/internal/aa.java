package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorLevel;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public final class aa
  implements fd, oa
{
  public mb a;
  public fo b;
  public int c;
  public VectorMap d;
  public mk e;
  public boolean f;
  public IndoorBuilding g;
  private boolean h;
  private sj i;
  private TencentMap.OnIndoorStateChangeListener j;
  
  public aa(sj paramsj, String paramString)
  {
    AppMethodBeat.i(223682);
    this.c = a.a;
    this.j = null;
    this.d = null;
    this.f = false;
    this.g = null;
    this.i = paramsj;
    if (this.i != null)
    {
      if (paramString != null) {
        break label258;
      }
      this.a = me.a(this.i.G());
    }
    for (;;)
    {
      this.d = ((VectorMap)this.i.e_);
      this.e = this.i.aB;
      int k = this.a.b("AIEnabled");
      int m = this.a.b("AIType");
      paramsj = this.a.a("AIBuildingList");
      try
      {
        if (!TextUtils.isEmpty(paramsj))
        {
          paramsj = new JSONArray(paramsj);
          if ((k != -1) && (m != -1) && (paramsj != null)) {
            this.b = new fo(k, m, paramsj);
          }
          if (this.d != null)
          {
            this.d.a(a());
            if (m == 1) {
              this.d.a(b());
            }
          }
          a(false);
          if (this.d != null)
          {
            this.d.a(this);
            this.d.o.a(this);
            this.j = new sg(this.i);
          }
          AppMethodBeat.o(223682);
          return;
          label258:
          this.a = md.a(this.i.G(), paramString);
        }
      }
      catch (Exception paramsj)
      {
        for (;;)
        {
          if (kh.a != null)
          {
            kh.a.b("TI", "indoor auth init failed", paramsj);
            paramsj = localObject;
          }
          else
          {
            kh.b("TI", "indoor auth init failed", paramsj);
            paramsj = localObject;
            continue;
            paramsj = null;
          }
        }
      }
    }
  }
  
  private int a(String paramString)
  {
    AppMethodBeat.i(223842);
    if (this.d == null)
    {
      AppMethodBeat.o(223842);
      return -1;
    }
    Object localObject = this.d;
    if (((VectorMap)localObject).o == null)
    {
      AppMethodBeat.o(223842);
      return -1;
    }
    localObject = ((VectorMap)localObject).o;
    if (((mk)localObject).g == null)
    {
      AppMethodBeat.o(223842);
      return -1;
    }
    localObject = ((mk)localObject).g;
    int k = ((Integer)((sc)localObject).a(new sc.40((sc)localObject, paramString), Integer.valueOf(-1))).intValue();
    AppMethodBeat.o(223842);
    return k;
  }
  
  private void a(fo paramfo)
  {
    AppMethodBeat.i(223702);
    if (paramfo != null)
    {
      this.b = paramfo;
      kh.b("TDZ", "IndoorAuth:".concat(String.valueOf(paramfo)));
      this.a.a("AIEnabled", paramfo.c);
      this.a.a("AIType", paramfo.d);
      if (paramfo.e != null) {
        this.a.a("AIBuildingList", paramfo.e.toString());
      }
      if (this.d != null)
      {
        this.d.a(a());
        if (a() == 1) {
          this.d.a(b());
        }
      }
    }
    for (;;)
    {
      if (this.b == null) {
        this.b = new fo();
      }
      jw.a(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(221598);
          if (aa.this.c == aa.a.a)
          {
            aa.this.a(aa.this.b.a());
            AppMethodBeat.o(221598);
            return;
          }
          aa.this.a(aa.this.c);
          AppMethodBeat.o(221598);
        }
      });
      AppMethodBeat.o(223702);
      return;
      this.a.a(new String[] { "AIEnabled", "AIType", "AIBuildingList" });
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223827);
    if (this.e == null)
    {
      AppMethodBeat.o(223827);
      return;
    }
    this.e.a(paramString1, paramString2);
    AppMethodBeat.o(223827);
  }
  
  private void b(boolean paramBoolean)
  {
    AppMethodBeat.i(223705);
    if (paramBoolean) {}
    for (int k = a.b;; k = a.c)
    {
      this.c = k;
      a(this.c);
      AppMethodBeat.o(223705);
      return;
    }
  }
  
  private void c(int paramInt)
  {
    AppMethodBeat.i(223760);
    if (this.e == null)
    {
      AppMethodBeat.o(223760);
      return;
    }
    Object localObject = this.e;
    if (((mk)localObject).g != null)
    {
      localObject = ((mk)localObject).g;
      ((sc)localObject).a(new sc.133((sc)localObject, paramInt));
    }
    c();
    AppMethodBeat.o(223760);
  }
  
  private void c(boolean paramBoolean)
  {
    AppMethodBeat.i(223815);
    if (this.d == null)
    {
      AppMethodBeat.o(223815);
      return;
    }
    Object localObject = this.d.o;
    if (((mk)localObject).g != null)
    {
      localObject = ((mk)localObject).g;
      if (((sc)localObject).e != 0L) {
        ((sc)localObject).a(new sc.143((sc)localObject, paramBoolean));
      }
    }
    AppMethodBeat.o(223815);
  }
  
  private void d()
  {
    AppMethodBeat.i(223691);
    int k = this.a.b("AIEnabled");
    int m = this.a.b("AIType");
    Object localObject2 = this.a.a("AIBuildingList");
    localObject1 = null;
    try
    {
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label167;
      }
      localObject2 = new JSONArray((String)localObject2);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (kh.a != null)
        {
          kh.a.b("TI", "indoor auth init failed", localException);
        }
        else
        {
          kh.b("TI", "indoor auth init failed", localException);
          continue;
          localObject1 = null;
        }
      }
    }
    if ((k != -1) && (m != -1) && (localObject1 != null)) {
      this.b = new fo(k, m, localObject1);
    }
    if (this.d != null)
    {
      this.d.a(a());
      if (m == 1) {
        this.d.a(b());
      }
    }
    AppMethodBeat.o(223691);
  }
  
  private boolean e()
  {
    AppMethodBeat.i(223715);
    if ((this.b != null) && (this.b.a()))
    {
      AppMethodBeat.o(223715);
      return true;
    }
    AppMethodBeat.o(223715);
    return false;
  }
  
  private boolean f()
  {
    return this.f;
  }
  
  private void g()
  {
    AppMethodBeat.i(223729);
    if ((this.i == null) || (this.i.e_ == null) || (this.f))
    {
      AppMethodBeat.o(223729);
      return;
    }
    VectorMap localVectorMap = (VectorMap)this.i.e_;
    int k = Math.min(20, this.i.j);
    if (localVectorMap.o.t.a() < k) {
      localVectorMap.b(k);
    }
    AppMethodBeat.o(223729);
  }
  
  private void h()
  {
    AppMethodBeat.i(223742);
    if (this.g != null)
    {
      String str = this.g.getBuidlingId();
      int k = this.g.getActiveLevelIndex();
      Object localObject = this.g.getLevels();
      if ((localObject == null) || (k >= ((List)localObject).size()))
      {
        AppMethodBeat.o(223742);
        return;
      }
      localObject = ((IndoorLevel)((List)localObject).get(k)).getName();
      if ((!gz.a(str)) && (!gz.a((String)localObject))) {
        this.e.a(str, (String)localObject);
      }
    }
    AppMethodBeat.o(223742);
  }
  
  private IndoorBuilding i()
  {
    return this.g;
  }
  
  private String j()
  {
    AppMethodBeat.i(223769);
    if (this.g == null)
    {
      AppMethodBeat.o(223769);
      return null;
    }
    String str = this.g.getBuidlingId();
    AppMethodBeat.o(223769);
    return str;
  }
  
  private int k()
  {
    AppMethodBeat.i(223775);
    if (this.g == null)
    {
      AppMethodBeat.o(223775);
      return -1;
    }
    int k = this.g.getActiveLevelIndex();
    AppMethodBeat.o(223775);
    return k;
  }
  
  private String[] l()
  {
    AppMethodBeat.i(223786);
    if ((this.g == null) || (this.g.getLevels() == null) || (this.g.getLevels().isEmpty()))
    {
      AppMethodBeat.o(223786);
      return null;
    }
    List localList = this.g.getLevels();
    String[] arrayOfString = new String[localList.size()];
    int k = 0;
    while (k < localList.size())
    {
      arrayOfString[k] = ((IndoorLevel)localList.get(k)).getName();
      k += 1;
    }
    AppMethodBeat.o(223786);
    return arrayOfString;
  }
  
  private String m()
  {
    AppMethodBeat.i(223797);
    if (this.g == null)
    {
      AppMethodBeat.o(223797);
      return "";
    }
    String str = this.g.getBuildingName();
    AppMethodBeat.o(223797);
    return str;
  }
  
  private IndoorBuilding n()
  {
    return this.g;
  }
  
  public final int a()
  {
    AppMethodBeat.i(223908);
    if ((this.b != null) && (this.b.b()))
    {
      AppMethodBeat.o(223908);
      return 1;
    }
    AppMethodBeat.o(223908);
    return 0;
  }
  
  public final void a(int paramInt)
  {
    AppMethodBeat.i(223884);
    switch (3.a[(paramInt - 1)])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(223884);
      return;
      a(true);
      AppMethodBeat.o(223884);
      return;
      a(false);
    }
  }
  
  final void a(String paramString1, String paramString2, LatLng paramLatLng, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(223944);
    if ((this.i == null) || (this.i.e_ == null))
    {
      AppMethodBeat.o(223944);
      return;
    }
    Object localObject = (VectorMap)this.i.e_;
    int k = ((VectorMap)localObject).p();
    if ((paramString1 != null) && (paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramInt >= 0) && (k >= 16))
    {
      if ((this.j != null) && (!this.f))
      {
        this.f = true;
        this.j.onIndoorBuildingFocused();
      }
      ((VectorMap)localObject).b(Math.min(this.i.j, 22));
      if (this.j != null)
      {
        localObject = new ArrayList();
        int m = paramArrayOfString.length;
        k = 0;
        while (k < m)
        {
          ((List)localObject).add(new IndoorLevel(paramArrayOfString[k]));
          k += 1;
        }
        try
        {
          if ((this.g != null) && (this.g.getBuidlingId().equals(paramString1)))
          {
            k = this.g.getActiveLevelIndex();
            if (k == paramInt)
            {
              AppMethodBeat.o(223944);
              return;
            }
          }
        }
        catch (Exception paramArrayOfString)
        {
          if ((this.g == null) || (!paramString1.equals(this.g.getBuidlingId())))
          {
            paramArrayOfString = this.e.d;
            if (paramArrayOfString != null) {
              paramArrayOfString.d().a.a();
            }
          }
          this.g = new IndoorBuilding(paramString1, paramString2, paramLatLng, (List)localObject, paramInt);
          if ((this.i != null) && (this.i.n != null) && (this.i.n.c)) {
            this.i.n.a(this.g);
          }
          this.j.onIndoorLevelActivated(this.g);
        }
      }
      AppMethodBeat.o(223944);
      return;
    }
    g();
    if (this.f)
    {
      this.f = false;
      this.g = null;
      if ((this.i != null) && (this.i.n != null)) {
        this.i.n.a(this.g);
      }
      if (this.j != null) {
        this.j.onIndoorBuildingDeactivated();
      }
    }
    AppMethodBeat.o(223944);
  }
  
  final void a(boolean paramBoolean)
  {
    AppMethodBeat.i(223895);
    this.h = paramBoolean;
    if (this.e == null)
    {
      AppMethodBeat.o(223895);
      return;
    }
    if (!e())
    {
      this.e.d(false);
      AppMethodBeat.o(223895);
      return;
    }
    this.e.d(paramBoolean);
    if ((!paramBoolean) && (this.f)) {
      a(null, null, null, null, -1);
    }
    AppMethodBeat.o(223895);
  }
  
  public final void b(int paramInt)
  {
    AppMethodBeat.i(223952);
    if ((!this.h) || (this.i == null) || (this.i.e_ == null) || (this.i.n == null))
    {
      AppMethodBeat.o(223952);
      return;
    }
    if (!this.f) {
      g();
    }
    AppMethodBeat.o(223952);
  }
  
  public final String[] b()
  {
    if (this.b != null) {
      return this.b.f;
    }
    return null;
  }
  
  public final void c()
  {
    AppMethodBeat.i(223927);
    if ((!this.h) || (this.i == null) || (this.i.e_ == null))
    {
      AppMethodBeat.o(223927);
      return;
    }
    Object localObject2 = (VectorMap)this.i.e_;
    Object localObject1 = new GeoPoint();
    localObject2 = ((VectorMap)localObject2).o.g;
    localObject2 = (ps)((sc)localObject2).a(new sc.136((sc)localObject2, (GeoPoint)localObject1), null);
    if (localObject2 == null)
    {
      AppMethodBeat.o(223927);
      return;
    }
    localObject1 = new LatLng(((GeoPoint)localObject1).getLatitudeE6() * 1.0D / 1000000.0D, ((GeoPoint)localObject1).getLongitudeE6() * 1.0D / 1000000.0D);
    jw.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(221607);
        aa.this.a(this.a, this.b, this.c, this.d, this.e);
        AppMethodBeat.o(221607);
      }
    });
    AppMethodBeat.o(223927);
  }
  
  public static enum a
  {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    
    private a() {}
    
    public static int[] a()
    {
      AppMethodBeat.i(225440);
      int[] arrayOfInt = (int[])d.clone();
      AppMethodBeat.o(225440);
      return arrayOfInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.aa
 * JD-Core Version:    0.7.0.1
 */