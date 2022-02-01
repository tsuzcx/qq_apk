package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class gm
  extends gr
{
  @Json(name="loadSuccess")
  private boolean a = false;
  @Json(name="loadSuccessTime")
  private long b = 0L;
  @Json(name="firstLoadTime")
  private long c = 0L;
  @Json(name="configUpdate")
  private b d;
  @Json(name="tileErrors")
  private Set<e> e;
  @Json(name="configError")
  private a f;
  
  gm(long paramLong)
  {
    super(paramLong);
  }
  
  public final void a(long paramLong, String paramString)
  {
    AppMethodBeat.i(225521);
    if (this.f == null) {
      this.f = new a(q());
    }
    if (this.f.b == null) {
      this.f.b = new CopyOnWriteArraySet();
    }
    if (this.f.b.size() > 9)
    {
      AppMethodBeat.o(225521);
      return;
    }
    d locald = new d(this.g);
    locald.b = (paramLong - this.g);
    locald.a = paramString;
    this.f.b.add(locald);
    paramString = new HashMap();
    paramString.put("startTime", this.g);
    paramString.put("endTime", String.valueOf(paramLong));
    u.a();
    new rw("mapload-missfile", paramString);
    AppMethodBeat.o(225521);
  }
  
  public final void a(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(225504);
    if (this.e == null) {
      this.e = new CopyOnWriteArraySet();
    }
    if (this.e.size() > 9)
    {
      AppMethodBeat.o(225504);
      return;
    }
    Object localObject = new e(paramLong);
    ((e)localObject).a = (paramLong - this.g);
    ((e)localObject).b = paramString;
    ((e)localObject).c = paramInt;
    this.e.add(localObject);
    localObject = new HashMap();
    ((Map)localObject).put("tid", paramString);
    ((Map)localObject).put("netError", String.valueOf(paramInt));
    ((Map)localObject).put("startTime", this.g);
    ((Map)localObject).put("endTime", String.valueOf(paramLong));
    u.a();
    new rw("mapload-tile", (Map)localObject);
    AppMethodBeat.o(225504);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(225514);
    if (this.f == null) {
      this.f = new a(q());
    }
    if (this.f.a == null) {
      this.f.a = new CopyOnWriteArraySet();
    }
    if (this.f.a.size() > 9)
    {
      AppMethodBeat.o(225514);
      return;
    }
    this.f.a.add(paramc);
    HashMap localHashMap = new HashMap();
    localHashMap.put("name", paramc.a);
    localHashMap.put("localVer", paramc.e);
    localHashMap.put("netError", paramc.f);
    localHashMap.put("expectMd5", paramc.c);
    localHashMap.put("actualMd5", paramc.d);
    localHashMap.put("startTime", this.g);
    localHashMap.put("endTime", this.g + paramc.b);
    u.a();
    new rw("mapload-configfile", localHashMap);
    AppMethodBeat.o(225514);
  }
  
  public final void a(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(225484);
    this.a = paramBoolean;
    if (this.c > 0L) {
      this.b = (paramLong - this.g);
    }
    for (;;)
    {
      this.b = paramLong;
      HashMap localHashMap = new HashMap();
      localHashMap.put("success", String.valueOf(paramBoolean));
      localHashMap.put("startTime", this.g);
      localHashMap.put("endTime", String.valueOf(paramLong));
      localHashMap.put("duration", this.b);
      localHashMap.put("firstDuration", this.c);
      u.a();
      new rw("mapload", localHashMap);
      AppMethodBeat.o(225484);
      return;
      this.c = (paramLong - this.g);
    }
  }
  
  public final void b(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(225494);
    this.d = new b(q());
    this.d.a = paramBoolean;
    if (paramLong - this.g > 0L) {
      this.d.b = (paramLong - this.g);
    }
    AppMethodBeat.o(225494);
  }
  
  public static final class a
    extends gr
  {
    @Json(name="failUpdates")
    Set<gm.c> a;
    @Json(name="missFiles")
    Set<gm.d> b;
    
    a(long paramLong)
    {
      super();
    }
  }
  
  public static final class b
    extends gr
  {
    @Json(name="success")
    boolean a = false;
    @Json(name="loadBeginTime")
    long b = 0L;
    
    b(long paramLong)
    {
      super();
    }
  }
  
  public static final class c
    extends gr
  {
    @Json(name="name")
    public String a;
    @Json(name="time")
    public long b;
    @Json(name="expectMd5")
    public String c;
    @Json(name="actualMd5")
    public String d;
    @Json(name="localVer")
    public int e;
    @Json(name="netError")
    public int f;
    
    public c()
    {
      this(0L);
    }
    
    c(long paramLong)
    {
      super();
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(222810);
      if (paramObject == this)
      {
        AppMethodBeat.o(222810);
        return true;
      }
      if (!(paramObject instanceof c))
      {
        AppMethodBeat.o(222810);
        return false;
      }
      paramObject = (c)paramObject;
      boolean bool = gz.a(this.a, paramObject.a);
      AppMethodBeat.o(222810);
      return bool;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(222800);
      if (this.a == null)
      {
        i = super.hashCode();
        AppMethodBeat.o(222800);
        return i;
      }
      int i = this.a.hashCode();
      AppMethodBeat.o(222800);
      return i;
    }
  }
  
  public static final class d
    extends gr
  {
    @Json(name="name")
    String a;
    @Json(name="time")
    long b;
    
    d(long paramLong)
    {
      super();
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(222803);
      if (paramObject == this)
      {
        AppMethodBeat.o(222803);
        return true;
      }
      if (!(paramObject instanceof d))
      {
        AppMethodBeat.o(222803);
        return false;
      }
      paramObject = (d)paramObject;
      boolean bool = gz.a(this.a, paramObject.a);
      AppMethodBeat.o(222803);
      return bool;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(222794);
      if (this.a == null)
      {
        i = super.hashCode();
        AppMethodBeat.o(222794);
        return i;
      }
      int i = this.a.hashCode();
      AppMethodBeat.o(222794);
      return i;
    }
  }
  
  public static final class e
    extends gr
  {
    @Json(name="time")
    long a;
    @Json(name="tid")
    String b;
    @Json(name="netError")
    int c;
    
    e(long paramLong)
    {
      super();
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(222837);
      if (paramObject == this)
      {
        AppMethodBeat.o(222837);
        return true;
      }
      if (!(paramObject instanceof e))
      {
        AppMethodBeat.o(222837);
        return false;
      }
      paramObject = (e)paramObject;
      boolean bool = gz.a(this.b, paramObject.b);
      AppMethodBeat.o(222837);
      return bool;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(222821);
      if (this.b == null)
      {
        i = super.hashCode();
        AppMethodBeat.o(222821);
        return i;
      }
      int i = this.b.hashCode();
      AppMethodBeat.o(222821);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.gm
 * JD-Core Version:    0.7.0.1
 */