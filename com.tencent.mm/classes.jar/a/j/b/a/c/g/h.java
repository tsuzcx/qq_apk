package a.j.b.a.c.g;

import TFieldDescriptorType;;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map.Entry<TFieldDescriptorType;Ljava.lang.Object;>;

public final class h<FieldDescriptorType extends h.a<FieldDescriptorType>>
{
  private static final h Crt;
  final v<FieldDescriptorType, Object> Crq;
  private boolean Crr;
  boolean Crs;
  
  static
  {
    AppMethodBeat.i(121520);
    Crt = new h((byte)0);
    AppMethodBeat.o(121520);
  }
  
  private h()
  {
    AppMethodBeat.i(121498);
    this.Crs = false;
    this.Crq = v.VM(16);
    AppMethodBeat.o(121498);
  }
  
  private h(byte paramByte)
  {
    AppMethodBeat.i(121499);
    this.Crs = false;
    this.Crq = v.VM(0);
    emF();
    AppMethodBeat.o(121499);
  }
  
  private static int a(z.a parama, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(121516);
    int i = f.eW(paramInt);
    paramInt = i;
    if (parama == z.a.CsO) {
      paramInt = i * 2;
    }
    i = b(parama, paramObject);
    AppMethodBeat.o(121516);
    return paramInt + i;
  }
  
  static int a(z.a parama, boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2;
    }
    return parama.CsY;
  }
  
  public static Object a(e parame, z.a parama)
  {
    AppMethodBeat.i(121511);
    long l;
    int i;
    switch (1.Crv[parama.ordinal()])
    {
    default: 
      parame = new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
      AppMethodBeat.o(121511);
      throw parame;
    case 1: 
      double d = Double.longBitsToDouble(parame.emy());
      AppMethodBeat.o(121511);
      return Double.valueOf(d);
    case 2: 
      float f = Float.intBitsToFloat(parame.emx());
      AppMethodBeat.o(121511);
      return Float.valueOf(f);
    case 3: 
      l = parame.sm();
      AppMethodBeat.o(121511);
      return Long.valueOf(l);
    case 4: 
      l = parame.sm();
      AppMethodBeat.o(121511);
      return Long.valueOf(l);
    case 5: 
      i = parame.sl();
      AppMethodBeat.o(121511);
      return Integer.valueOf(i);
    case 6: 
      l = parame.emy();
      AppMethodBeat.o(121511);
      return Long.valueOf(l);
    case 7: 
      i = parame.emx();
      AppMethodBeat.o(121511);
      return Integer.valueOf(i);
    case 8: 
      boolean bool = parame.emu();
      AppMethodBeat.o(121511);
      return Boolean.valueOf(bool);
    case 9: 
      i = parame.sl();
      if ((i <= parame.bufferSize - parame.bgR) && (i > 0))
      {
        parama = new String(parame.buffer, parame.bgR, i, "UTF-8");
        parame.bgR = (i + parame.bgR);
        AppMethodBeat.o(121511);
        return parama;
      }
      if (i == 0)
      {
        AppMethodBeat.o(121511);
        return "";
      }
      parame = new String(parame.VE(i), "UTF-8");
      AppMethodBeat.o(121511);
      return parame;
    case 10: 
      parame = parame.emv();
      AppMethodBeat.o(121511);
      return parame;
    case 11: 
      i = parame.sl();
      AppMethodBeat.o(121511);
      return Integer.valueOf(i);
    case 12: 
      i = parame.emx();
      AppMethodBeat.o(121511);
      return Integer.valueOf(i);
    case 13: 
      l = parame.emy();
      AppMethodBeat.o(121511);
      return Long.valueOf(l);
    case 14: 
      i = parame.sl();
      int j = -(i & 0x1);
      AppMethodBeat.o(121511);
      return Integer.valueOf(j ^ i >>> 1);
    case 15: 
      l = e.pp(parame.sm());
      AppMethodBeat.o(121511);
      return Long.valueOf(l);
    case 16: 
      parame = new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
      AppMethodBeat.o(121511);
      throw parame;
    case 17: 
      parame = new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
      AppMethodBeat.o(121511);
      throw parame;
    }
    parame = new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
    AppMethodBeat.o(121511);
    throw parame;
  }
  
  private static void a(f paramf, z.a parama, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(121512);
    if (parama == z.a.CsO)
    {
      parama = (q)paramObject;
      paramf.bn(paramInt, 3);
      parama.a(paramf);
      paramf.bn(paramInt, 4);
      AppMethodBeat.o(121512);
      return;
    }
    paramf.bn(paramInt, a(parama, false));
    a(paramf, parama, paramObject);
    AppMethodBeat.o(121512);
  }
  
  private static void a(f paramf, z.a parama, Object paramObject)
  {
    AppMethodBeat.i(121513);
    switch (1.Crv[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(121513);
      return;
      paramf.J(((Double)paramObject).doubleValue());
      AppMethodBeat.o(121513);
      return;
      paramf.bH(((Float)paramObject).floatValue());
      AppMethodBeat.o(121513);
      return;
      paramf.ao(((Long)paramObject).longValue());
      AppMethodBeat.o(121513);
      return;
      paramf.ao(((Long)paramObject).longValue());
      AppMethodBeat.o(121513);
      return;
      paramf.VG(((Integer)paramObject).intValue());
      AppMethodBeat.o(121513);
      return;
      paramf.ps(((Long)paramObject).longValue());
      AppMethodBeat.o(121513);
      return;
      paramf.VI(((Integer)paramObject).intValue());
      AppMethodBeat.o(121513);
      return;
      paramf.sx(((Boolean)paramObject).booleanValue());
      AppMethodBeat.o(121513);
      return;
      paramf.ayZ((String)paramObject);
      AppMethodBeat.o(121513);
      return;
      ((q)paramObject).a(paramf);
      AppMethodBeat.o(121513);
      return;
      paramf.b((q)paramObject);
      AppMethodBeat.o(121513);
      return;
      if ((paramObject instanceof d))
      {
        paramf.b((d)paramObject);
        AppMethodBeat.o(121513);
        return;
      }
      paramf.cC((byte[])paramObject);
      AppMethodBeat.o(121513);
      return;
      paramf.eX(((Integer)paramObject).intValue());
      AppMethodBeat.o(121513);
      return;
      paramf.VI(((Integer)paramObject).intValue());
      AppMethodBeat.o(121513);
      return;
      paramf.ps(((Long)paramObject).longValue());
      AppMethodBeat.o(121513);
      return;
      paramf.VH(((Integer)paramObject).intValue());
      AppMethodBeat.o(121513);
      return;
      paramf.pq(((Long)paramObject).longValue());
      AppMethodBeat.o(121513);
      return;
      if ((paramObject instanceof j.a))
      {
        paramf.VG(((j.a)paramObject).ehC());
        AppMethodBeat.o(121513);
        return;
      }
      paramf.VG(((Integer)paramObject).intValue());
    }
  }
  
  public static void a(h.a<?> parama, Object paramObject, f paramf)
  {
    AppMethodBeat.i(121514);
    z.a locala = parama.emH();
    int i = parama.ehC();
    if (parama.emJ())
    {
      paramObject = (List)paramObject;
      if (parama.emK())
      {
        paramf.bn(i, 2);
        i = 0;
        parama = paramObject.iterator();
        while (parama.hasNext()) {
          i += b(locala, parama.next());
        }
        paramf.eX(i);
        parama = paramObject.iterator();
        while (parama.hasNext()) {
          a(paramf, locala, parama.next());
        }
        AppMethodBeat.o(121514);
        return;
      }
      parama = paramObject.iterator();
      while (parama.hasNext()) {
        a(paramf, locala, i, parama.next());
      }
      AppMethodBeat.o(121514);
      return;
    }
    if ((paramObject instanceof l))
    {
      a(paramf, locala, i, ((l)paramObject).emV());
      AppMethodBeat.o(121514);
      return;
    }
    a(paramf, locala, i, paramObject);
    AppMethodBeat.o(121514);
  }
  
  private static void a(z.a parama, Object paramObject)
  {
    boolean bool = false;
    AppMethodBeat.i(121506);
    if (paramObject == null)
    {
      parama = new NullPointerException();
      AppMethodBeat.o(121506);
      throw parama;
    }
    switch (1.Cru[parama.CsX.ordinal()])
    {
    }
    while (!bool)
    {
      parama = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      AppMethodBeat.o(121506);
      throw parama;
      bool = paramObject instanceof Integer;
      continue;
      bool = paramObject instanceof Long;
      continue;
      bool = paramObject instanceof Float;
      continue;
      bool = paramObject instanceof Double;
      continue;
      bool = paramObject instanceof Boolean;
      continue;
      bool = paramObject instanceof String;
      continue;
      if (((paramObject instanceof d)) || ((paramObject instanceof byte[])))
      {
        bool = true;
        continue;
        if (((paramObject instanceof Integer)) || ((paramObject instanceof j.a)))
        {
          bool = true;
          continue;
          if (((paramObject instanceof q)) || ((paramObject instanceof l))) {
            bool = true;
          }
        }
      }
    }
    AppMethodBeat.o(121506);
  }
  
  private static boolean a(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    AppMethodBeat.i(121508);
    h.a locala = (h.a)paramEntry.getKey();
    if (locala.emI() == z.b.Cti)
    {
      if (locala.emJ())
      {
        paramEntry = ((List)paramEntry.getValue()).iterator();
        do
        {
          if (!paramEntry.hasNext()) {
            break;
          }
        } while (((q)paramEntry.next()).isInitialized());
        AppMethodBeat.o(121508);
        return false;
      }
      paramEntry = paramEntry.getValue();
      if ((paramEntry instanceof q))
      {
        if (!((q)paramEntry).isInitialized())
        {
          AppMethodBeat.o(121508);
          return false;
        }
      }
      else
      {
        if ((paramEntry instanceof l))
        {
          AppMethodBeat.o(121508);
          return true;
        }
        paramEntry = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        AppMethodBeat.o(121508);
        throw paramEntry;
      }
    }
    AppMethodBeat.o(121508);
    return true;
  }
  
  private static int b(z.a parama, Object paramObject)
  {
    AppMethodBeat.i(121517);
    switch (1.Crv[parama.ordinal()])
    {
    default: 
      parama = new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
      AppMethodBeat.o(121517);
      throw parama;
    case 1: 
      ((Double)paramObject).doubleValue();
      AppMethodBeat.o(121517);
      return 8;
    case 2: 
      ((Float)paramObject).floatValue();
      AppMethodBeat.o(121517);
      return 4;
    case 3: 
      i = f.ap(((Long)paramObject).longValue());
      AppMethodBeat.o(121517);
      return i;
    case 4: 
      i = f.ap(((Long)paramObject).longValue());
      AppMethodBeat.o(121517);
      return i;
    case 5: 
      i = f.eU(((Integer)paramObject).intValue());
      AppMethodBeat.o(121517);
      return i;
    case 6: 
      ((Long)paramObject).longValue();
      AppMethodBeat.o(121517);
      return 8;
    case 7: 
      ((Integer)paramObject).intValue();
      AppMethodBeat.o(121517);
      return 4;
    case 8: 
      ((Boolean)paramObject).booleanValue();
      AppMethodBeat.o(121517);
      return 1;
    case 9: 
      i = f.bf((String)paramObject);
      AppMethodBeat.o(121517);
      return i;
    case 16: 
      i = ((q)paramObject).sy();
      AppMethodBeat.o(121517);
      return i;
    case 10: 
      if ((paramObject instanceof d))
      {
        i = f.c((d)paramObject);
        AppMethodBeat.o(121517);
        return i;
      }
      i = f.cD((byte[])paramObject);
      AppMethodBeat.o(121517);
      return i;
    case 11: 
      i = f.eY(((Integer)paramObject).intValue());
      AppMethodBeat.o(121517);
      return i;
    case 12: 
      ((Integer)paramObject).intValue();
      AppMethodBeat.o(121517);
      return 4;
    case 13: 
      ((Long)paramObject).longValue();
      AppMethodBeat.o(121517);
      return 8;
    case 14: 
      i = f.eY(f.VJ(((Integer)paramObject).intValue()));
      AppMethodBeat.o(121517);
      return i;
    case 15: 
      i = f.ap(f.pt(((Long)paramObject).longValue()));
      AppMethodBeat.o(121517);
      return i;
    case 17: 
      if ((paramObject instanceof l))
      {
        i = f.a((l)paramObject);
        AppMethodBeat.o(121517);
        return i;
      }
      i = f.c((q)paramObject);
      AppMethodBeat.o(121517);
      return i;
    }
    if ((paramObject instanceof j.a))
    {
      i = f.eU(((j.a)paramObject).ehC());
      AppMethodBeat.o(121517);
      return i;
    }
    int i = f.eU(((Integer)paramObject).intValue());
    AppMethodBeat.o(121517);
    return i;
  }
  
  private static int c(h.a<?> parama, Object paramObject)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(121518);
    z.a locala = parama.emH();
    int k = parama.ehC();
    if (parama.emJ())
    {
      if (parama.emK())
      {
        parama = ((List)paramObject).iterator();
        while (parama.hasNext()) {
          i += b(locala, parama.next());
        }
        j = f.eW(k);
        k = f.eY(i);
        AppMethodBeat.o(121518);
        return k + (j + i);
      }
      parama = ((List)paramObject).iterator();
      i = j;
      while (parama.hasNext()) {
        i += a(locala, k, parama.next());
      }
      AppMethodBeat.o(121518);
      return i;
    }
    i = a(locala, k, paramObject);
    AppMethodBeat.o(121518);
    return i;
  }
  
  private static Object dG(Object paramObject)
  {
    AppMethodBeat.i(121509);
    if ((paramObject instanceof byte[]))
    {
      paramObject = (byte[])paramObject;
      byte[] arrayOfByte = new byte[paramObject.length];
      System.arraycopy(paramObject, 0, arrayOfByte, 0, paramObject.length);
      AppMethodBeat.o(121509);
      return arrayOfByte;
    }
    AppMethodBeat.o(121509);
    return paramObject;
  }
  
  public static <T extends h.a<T>> h<T> emD()
  {
    AppMethodBeat.i(121500);
    h localh = new h();
    AppMethodBeat.o(121500);
    return localh;
  }
  
  public static <T extends h.a<T>> h<T> emE()
  {
    return Crt;
  }
  
  public final Object a(FieldDescriptorType paramFieldDescriptorType)
  {
    AppMethodBeat.i(121503);
    paramFieldDescriptorType = this.Crq.get(paramFieldDescriptorType);
    if ((paramFieldDescriptorType instanceof l))
    {
      paramFieldDescriptorType = ((l)paramFieldDescriptorType).emV();
      AppMethodBeat.o(121503);
      return paramFieldDescriptorType;
    }
    AppMethodBeat.o(121503);
    return paramFieldDescriptorType;
  }
  
  public final void a(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    AppMethodBeat.i(121504);
    if (paramFieldDescriptorType.emJ())
    {
      if (!(paramObject instanceof List))
      {
        paramFieldDescriptorType = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        AppMethodBeat.o(121504);
        throw paramFieldDescriptorType;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll((List)paramObject);
      paramObject = localArrayList.iterator();
      while (paramObject.hasNext())
      {
        Object localObject = paramObject.next();
        a(paramFieldDescriptorType.emH(), localObject);
      }
      paramObject = localArrayList;
    }
    for (;;)
    {
      if ((paramObject instanceof l)) {
        this.Crs = true;
      }
      this.Crq.c(paramFieldDescriptorType, paramObject);
      AppMethodBeat.o(121504);
      return;
      a(paramFieldDescriptorType.emH(), paramObject);
    }
  }
  
  public final void b(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    AppMethodBeat.i(121505);
    if (!paramFieldDescriptorType.emJ())
    {
      paramFieldDescriptorType = new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
      AppMethodBeat.o(121505);
      throw paramFieldDescriptorType;
    }
    a(paramFieldDescriptorType.emH(), paramObject);
    Object localObject = a(paramFieldDescriptorType);
    if (localObject == null)
    {
      localObject = new ArrayList();
      this.Crq.c(paramFieldDescriptorType, localObject);
    }
    for (paramFieldDescriptorType = (TFieldDescriptorType)localObject;; paramFieldDescriptorType = (List)localObject)
    {
      paramFieldDescriptorType.add(paramObject);
      AppMethodBeat.o(121505);
      return;
    }
  }
  
  final void b(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    AppMethodBeat.i(121510);
    h.a locala = (h.a)paramEntry.getKey();
    Object localObject1 = paramEntry.getValue();
    paramEntry = (Map.Entry<FieldDescriptorType, Object>)localObject1;
    if ((localObject1 instanceof l)) {
      paramEntry = ((l)localObject1).emV();
    }
    if (locala.emJ())
    {
      Object localObject2 = a(locala);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      paramEntry = ((List)paramEntry).iterator();
      while (paramEntry.hasNext())
      {
        localObject2 = paramEntry.next();
        ((List)localObject1).add(dG(localObject2));
      }
      this.Crq.c(locala, localObject1);
      AppMethodBeat.o(121510);
      return;
    }
    if (locala.emI() == z.b.Cti)
    {
      localObject1 = a(locala);
      if (localObject1 == null)
      {
        this.Crq.c(locala, dG(paramEntry));
        AppMethodBeat.o(121510);
        return;
      }
      paramEntry = locala.a(((q)localObject1).ehb(), (q)paramEntry).ehl();
      this.Crq.c(locala, paramEntry);
      AppMethodBeat.o(121510);
      return;
    }
    this.Crq.c(locala, dG(paramEntry));
    AppMethodBeat.o(121510);
  }
  
  public final void emF()
  {
    AppMethodBeat.i(121501);
    if (this.Crr)
    {
      AppMethodBeat.o(121501);
      return;
    }
    this.Crq.emF();
    this.Crr = true;
    AppMethodBeat.o(121501);
  }
  
  public final h<FieldDescriptorType> emG()
  {
    AppMethodBeat.i(121502);
    h localh = new h();
    int i = 0;
    while (i < this.Crq.enc())
    {
      localObject = this.Crq.VN(i);
      localh.a((h.a)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      i += 1;
    }
    Object localObject = this.Crq.ene().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localh.a((h.a)localEntry.getKey(), localEntry.getValue());
    }
    localh.Crs = this.Crs;
    AppMethodBeat.o(121502);
    return localh;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(121507);
    int i = 0;
    while (i < this.Crq.enc())
    {
      if (!a(this.Crq.VN(i)))
      {
        AppMethodBeat.o(121507);
        return false;
      }
      i += 1;
    }
    Iterator localIterator = this.Crq.ene().iterator();
    while (localIterator.hasNext()) {
      if (!a((Map.Entry)localIterator.next()))
      {
        AppMethodBeat.o(121507);
        return false;
      }
    }
    AppMethodBeat.o(121507);
    return true;
  }
  
  public final int sy()
  {
    AppMethodBeat.i(121515);
    int j = 0;
    int i = 0;
    while (j < this.Crq.enc())
    {
      localObject = this.Crq.VN(j);
      i += c((h.a)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      j += 1;
    }
    Object localObject = this.Crq.ene().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      i += c((h.a)localEntry.getKey(), localEntry.getValue());
    }
    AppMethodBeat.o(121515);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.g.h
 * JD-Core Version:    0.7.0.1
 */