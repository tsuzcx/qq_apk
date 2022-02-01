package com.tencent.luggage.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.l.o;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/util/LuggageMMKVProperty;", "T", "", "defaultValue", "(Ljava/lang/Object;)V", "mmkvName", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "Ljava/lang/Object;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "propertyType", "Ljava/lang/Class;", "thisRef", "getValue", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "Companion", "luggage-commons_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g<T>
{
  private static final g.a exf;
  private T dOI;
  private String exg;
  private Class<?> exh;
  private Object exi;
  private final j exj;
  
  static
  {
    AppMethodBeat.i(219977);
    exf = new g.a((byte)0);
    AppMethodBeat.o(219977);
  }
  
  public g(T paramT)
  {
    AppMethodBeat.i(219959);
    this.exj = k.cm((kotlin.g.a.a)new b(this));
    this.dOI = paramT;
    this.exh = paramT.getClass();
    AppMethodBeat.o(219959);
  }
  
  public g(T paramT, String paramString)
  {
    this(paramT);
    AppMethodBeat.i(219962);
    this.exg = paramString;
    this.dOI = paramT;
    this.exh = paramT.getClass();
    AppMethodBeat.o(219962);
  }
  
  private final MultiProcessMMKV atj()
  {
    AppMethodBeat.i(219965);
    Object localObject = this.exj.getValue();
    s.s(localObject, "<get-mmkv>(...)");
    localObject = (MultiProcessMMKV)localObject;
    AppMethodBeat.o(219965);
    return localObject;
  }
  
  public final T a(Object paramObject, o<?> paramo)
  {
    boolean bool2 = true;
    AppMethodBeat.i(219984);
    s.u(paramObject, "thisRef");
    s.u(paramo, "property");
    this.exi = paramObject;
    paramObject = this.exh;
    if (s.p(paramObject, Float.TYPE)) {}
    for (boolean bool1 = true; bool1; bool1 = s.p(paramObject, Float.class))
    {
      paramObject = (Object)Float.valueOf(atj().getFloat(paramo.getName(), ((Float)this.dOI).floatValue()));
      AppMethodBeat.o(219984);
      return paramObject;
    }
    if (s.p(paramObject, Integer.TYPE)) {}
    for (bool1 = true; bool1; bool1 = s.p(paramObject, Integer.class))
    {
      paramObject = (Object)Integer.valueOf(atj().getInt(paramo.getName(), ((Integer)this.dOI).intValue()));
      AppMethodBeat.o(219984);
      return paramObject;
    }
    if (s.p(paramObject, String.class))
    {
      paramObject = atj().getString(paramo.getName(), (String)this.dOI);
      if (paramObject == null)
      {
        paramObject = new NullPointerException("null cannot be cast to non-null type T of com.tencent.luggage.util.LuggageMMKVProperty");
        AppMethodBeat.o(219984);
        throw paramObject;
      }
      AppMethodBeat.o(219984);
      return paramObject;
    }
    if (s.p(paramObject, Long.TYPE)) {}
    for (bool1 = true; bool1; bool1 = s.p(paramObject, Long.class))
    {
      paramObject = (Object)Long.valueOf(atj().getLong(paramo.getName(), ((Long)this.dOI).longValue()));
      AppMethodBeat.o(219984);
      return paramObject;
    }
    if (s.p(paramObject, Boolean.TYPE)) {}
    for (bool1 = bool2; bool1; bool1 = s.p(paramObject, Boolean.class))
    {
      paramObject = (Object)Boolean.valueOf(atj().getBoolean(paramo.getName(), ((Boolean)this.dOI).booleanValue()));
      AppMethodBeat.o(219984);
      return paramObject;
    }
    if (s.p(paramObject, [B.class))
    {
      paramObject = atj().decodeBytes(paramo.getName());
      if (paramObject == null)
      {
        paramObject = this.dOI;
        AppMethodBeat.o(219984);
        return paramObject;
      }
      AppMethodBeat.o(219984);
      return paramObject;
    }
    if (g.a.af(this.exh).contains(com.tencent.mm.bx.a.class))
    {
      paramo = atj().decodeBytes(paramo.getName());
      if (paramo == null)
      {
        paramObject = this.dOI;
        AppMethodBeat.o(219984);
        return paramObject;
      }
      try
      {
        paramObject = this.exh.newInstance();
        if (paramObject == null)
        {
          paramObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protobuf.BaseProtoBuf");
          AppMethodBeat.o(219984);
          throw paramObject;
        }
      }
      catch (Exception paramObject)
      {
        Log.e("AppBrand.utils.AppBrandMMKVProperty", s.X("parse pb failed, class:", this.exh.getCanonicalName()));
        paramObject = this.dOI;
      }
      for (;;)
      {
        AppMethodBeat.o(219984);
        return paramObject;
        paramObject = (com.tencent.mm.bx.a)paramObject;
        paramObject.parseFrom(paramo);
      }
    }
    paramObject = new IllegalAccessError(s.X("unsupported type:", this.exh));
    AppMethodBeat.o(219984);
    throw paramObject;
  }
  
  public final void a(Object paramObject, o<?> paramo, T paramT)
  {
    boolean bool2 = true;
    AppMethodBeat.i(219994);
    s.u(paramObject, "thisRef");
    s.u(paramo, "property");
    this.exi = paramObject;
    if (paramT == null)
    {
      atj().removeValueForKey(paramo.getName());
      AppMethodBeat.o(219994);
      return;
    }
    paramObject = this.exh;
    if (s.p(paramObject, Float.TYPE)) {}
    for (boolean bool1 = true; bool1; bool1 = s.p(paramObject, Float.class))
    {
      atj().putFloat(paramo.getName(), ((Float)paramT).floatValue());
      AppMethodBeat.o(219994);
      return;
    }
    if (s.p(paramObject, Integer.TYPE)) {}
    for (bool1 = true; bool1; bool1 = s.p(paramObject, Integer.class))
    {
      atj().putInt(paramo.getName(), ((Integer)paramT).intValue());
      AppMethodBeat.o(219994);
      return;
    }
    if (s.p(paramObject, String.class))
    {
      atj().putString(paramo.getName(), (String)paramT);
      AppMethodBeat.o(219994);
      return;
    }
    if (s.p(paramObject, Long.TYPE)) {}
    for (bool1 = true; bool1; bool1 = s.p(paramObject, Long.class))
    {
      atj().putLong(paramo.getName(), ((Long)paramT).longValue());
      AppMethodBeat.o(219994);
      return;
    }
    if (s.p(paramObject, Boolean.TYPE)) {}
    for (bool1 = bool2; bool1; bool1 = s.p(paramObject, Boolean.class))
    {
      atj().putBoolean(paramo.getName(), ((Boolean)paramT).booleanValue());
      AppMethodBeat.o(219994);
      return;
    }
    if (s.p(paramObject, [B.class))
    {
      atj().encode(paramo.getName(), (byte[])paramT);
      AppMethodBeat.o(219994);
      return;
    }
    if (g.a.af(this.exh).contains(com.tencent.mm.bx.a.class))
    {
      paramObject = ((com.tencent.mm.bx.a)paramT).toByteArray();
      atj().encode(paramo.getName(), paramObject);
      AppMethodBeat.o(219994);
      return;
    }
    paramObject = new IllegalAccessError(s.X("unsupported type:", this.exh));
    AppMethodBeat.o(219994);
    throw paramObject;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "T", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<MultiProcessMMKV>
  {
    b(g<T> paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.l.g
 * JD-Core Version:    0.7.0.1
 */