package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class m
{
  protected String a;
  private ByteBuffer b;
  
  public m()
  {
    this.a = "GBK";
  }
  
  private m(ByteBuffer paramByteBuffer)
  {
    this.a = "GBK";
    this.b = paramByteBuffer;
  }
  
  public m(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(224987);
    this.a = "GBK";
    this.b = ByteBuffer.wrap(paramArrayOfByte);
    AppMethodBeat.o(224987);
  }
  
  public m(byte[] paramArrayOfByte, byte paramByte)
  {
    AppMethodBeat.i(224999);
    this.a = "GBK";
    this.b = ByteBuffer.wrap(paramArrayOfByte);
    this.b.position(4);
    AppMethodBeat.o(224999);
  }
  
  private static int a(a parama, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(225023);
    int i = paramByteBuffer.get();
    parama.a = ((byte)(i & 0xF));
    parama.b = ((i & 0xF0) >> 4);
    if (parama.b == 15)
    {
      parama.b = (paramByteBuffer.get() & 0xFF);
      AppMethodBeat.o(225023);
      return 2;
    }
    AppMethodBeat.o(225023);
    return 1;
  }
  
  private String a(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225114);
    if (b(paramInt))
    {
      paramString = new a();
      a(paramString);
      switch (paramString.a)
      {
      default: 
        paramString = new j("type mismatch.");
        AppMethodBeat.o(225114);
        throw paramString;
      case 6: 
        i = this.b.get();
        paramInt = i;
        if (i < 0) {
          paramInt = i + 256;
        }
        paramString = new byte[paramInt];
        this.b.get(paramString);
        paramString = i.a(paramString);
      }
    }
    while (!paramBoolean) {
      for (;;)
      {
        int i;
        AppMethodBeat.o(225114);
        return paramString;
        paramInt = this.b.getInt();
        if ((paramInt > 104857600) || (paramInt < 0) || (paramInt > this.b.capacity()))
        {
          paramString = new j("String too long: ".concat(String.valueOf(paramInt)));
          AppMethodBeat.o(225114);
          throw paramString;
        }
        paramString = new byte[paramInt];
        this.b.get(paramString);
        paramString = i.a(paramString);
      }
    }
    paramString = new j("require field not exist.");
    AppMethodBeat.o(225114);
    throw paramString;
  }
  
  private <T> List<T> a(List<T> paramList, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(225267);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramList = new ArrayList();
      AppMethodBeat.o(225267);
      return paramList;
    }
    paramList = b(paramList.get(0), paramInt, paramBoolean);
    if (paramList == null)
    {
      AppMethodBeat.o(225267);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramInt = i;
    while (paramInt < paramList.length)
    {
      localArrayList.add(paramList[paramInt]);
      paramInt += 1;
    }
    AppMethodBeat.o(225267);
    return localArrayList;
  }
  
  private <K, V> Map<K, V> a(Map<K, V> paramMap1, Map<K, V> paramMap2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225169);
    if ((paramMap2 == null) || (paramMap2.isEmpty()))
    {
      paramMap1 = new HashMap();
      AppMethodBeat.o(225169);
      return paramMap1;
    }
    Object localObject = (Map.Entry)paramMap2.entrySet().iterator().next();
    paramMap2 = ((Map.Entry)localObject).getKey();
    localObject = ((Map.Entry)localObject).getValue();
    if (b(paramInt))
    {
      a locala = new a();
      a(locala);
      switch (locala.a)
      {
      default: 
        paramMap1 = new j("type mismatch.");
        AppMethodBeat.o(225169);
        throw paramMap1;
      }
      int i = a(0, 0, true);
      if (i < 0)
      {
        paramMap1 = new j("size invalid: ".concat(String.valueOf(i)));
        AppMethodBeat.o(225169);
        throw paramMap1;
      }
      paramInt = 0;
      while (paramInt < i)
      {
        paramMap1.put(a(paramMap2, 0, true), a(localObject, 1, true));
        paramInt += 1;
      }
    }
    if (paramBoolean)
    {
      paramMap1 = new j("require field not exist.");
      AppMethodBeat.o(225169);
      throw paramMap1;
    }
    AppMethodBeat.o(225169);
    return paramMap1;
  }
  
  private void a()
  {
    AppMethodBeat.i(225075);
    a locala = new a();
    do
    {
      a(locala);
      a(locala.a);
    } while (locala.a != 11);
    AppMethodBeat.o(225075);
  }
  
  private void a(byte paramByte)
  {
    byte b2 = 0;
    byte b1 = 0;
    AppMethodBeat.i(225099);
    Object localObject;
    switch (paramByte)
    {
    default: 
      localObject = new j("invalid type.");
      AppMethodBeat.o(225099);
      throw ((Throwable)localObject);
    case 0: 
      a(1);
      AppMethodBeat.o(225099);
      return;
    case 1: 
      a(2);
      AppMethodBeat.o(225099);
      return;
    case 2: 
      a(4);
      AppMethodBeat.o(225099);
      return;
    case 3: 
      a(8);
      AppMethodBeat.o(225099);
      return;
    case 4: 
      a(4);
      AppMethodBeat.o(225099);
      return;
    case 5: 
      a(8);
      AppMethodBeat.o(225099);
      return;
    case 6: 
      b1 = this.b.get();
      paramByte = b1;
      if (b1 < 0) {
        paramByte = b1 + 256;
      }
      a(paramByte);
      AppMethodBeat.o(225099);
      return;
    case 7: 
      a(this.b.getInt());
      AppMethodBeat.o(225099);
      return;
    case 8: 
      b2 = a(0, 0, true);
      paramByte = b1;
      while (paramByte < b2 * 2)
      {
        b();
        paramByte += 1;
      }
      AppMethodBeat.o(225099);
      return;
    case 9: 
      b1 = a(0, 0, true);
      paramByte = b2;
      while (paramByte < b1)
      {
        b();
        paramByte += 1;
      }
      AppMethodBeat.o(225099);
      return;
    case 13: 
      localObject = new a();
      a((a)localObject);
      if (((a)localObject).a != 0)
      {
        localObject = new j("skipField with invalid type, type value: " + paramByte + ", " + ((a)localObject).a);
        AppMethodBeat.o(225099);
        throw ((Throwable)localObject);
      }
      a(a(0, 0, true));
      AppMethodBeat.o(225099);
      return;
    case 10: 
      a();
      AppMethodBeat.o(225099);
      return;
    }
    AppMethodBeat.o(225099);
  }
  
  private void a(int paramInt)
  {
    AppMethodBeat.i(225052);
    this.b.position(this.b.position() + paramInt);
    AppMethodBeat.o(225052);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(225030);
    a(parama, this.b);
    AppMethodBeat.o(225030);
  }
  
  private p[] a(p[] paramArrayOfp, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225291);
    paramArrayOfp = (p[])a(paramArrayOfp, paramInt, paramBoolean);
    AppMethodBeat.o(225291);
    return paramArrayOfp;
  }
  
  private <T> T[] a(T[] paramArrayOfT, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225256);
    if ((paramArrayOfT == null) || (paramArrayOfT.length == 0))
    {
      paramArrayOfT = new j("unable to get type of key and value.");
      AppMethodBeat.o(225256);
      throw paramArrayOfT;
    }
    paramArrayOfT = b(paramArrayOfT[0], paramInt, paramBoolean);
    AppMethodBeat.o(225256);
    return paramArrayOfT;
  }
  
  private String[] a(String[] paramArrayOfString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225138);
    paramArrayOfString = (String[])a(paramArrayOfString, paramInt, paramBoolean);
    AppMethodBeat.o(225138);
    return paramArrayOfString;
  }
  
  private int b(a parama)
  {
    AppMethodBeat.i(225042);
    int i = a(parama, this.b.duplicate());
    AppMethodBeat.o(225042);
    return i;
  }
  
  private String b(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225128);
    if (b(paramInt))
    {
      paramString = new a();
      a(paramString);
      switch (paramString.a)
      {
      default: 
        paramString = new j("type mismatch.");
        AppMethodBeat.o(225128);
        throw paramString;
      case 6: 
        i = this.b.get();
        paramInt = i;
        if (i < 0) {
          paramInt = i + 256;
        }
        arrayOfByte = new byte[paramInt];
        this.b.get(arrayOfByte);
      }
    }
    while (!paramBoolean) {
      for (;;)
      {
        try
        {
          int i;
          paramString = new String(arrayOfByte, this.a);
          AppMethodBeat.o(225128);
          return paramString;
        }
        catch (UnsupportedEncodingException paramString)
        {
          paramString = new String(arrayOfByte);
          continue;
        }
        paramInt = this.b.getInt();
        if ((paramInt > 104857600) || (paramInt < 0) || (paramInt > this.b.capacity()))
        {
          paramString = new j("String too long: ".concat(String.valueOf(paramInt)));
          AppMethodBeat.o(225128);
          throw paramString;
        }
        byte[] arrayOfByte = new byte[paramInt];
        this.b.get(arrayOfByte);
        try
        {
          paramString = new String(arrayOfByte, this.a);
        }
        catch (UnsupportedEncodingException paramString)
        {
          paramString = new String(arrayOfByte);
        }
      }
    }
    paramString = new j("require field not exist.");
    AppMethodBeat.o(225128);
    throw paramString;
  }
  
  private void b()
  {
    AppMethodBeat.i(225084);
    a locala = new a();
    a(locala);
    a(locala.a);
    AppMethodBeat.o(225084);
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(225011);
    a(paramArrayOfByte);
    AppMethodBeat.o(225011);
  }
  
  /* Error */
  private boolean b(int paramInt)
  {
    // Byte code:
    //   0: ldc 243
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 6	com/tencent/mapsdk/internal/m$a
    //   8: dup
    //   9: invokespecial 63	com/tencent/mapsdk/internal/m$a:<init>	()V
    //   12: astore_3
    //   13: aload_3
    //   14: aload_0
    //   15: getfield 22	com/tencent/mapsdk/internal/m:b	Ljava/nio/ByteBuffer;
    //   18: invokevirtual 228	java/nio/ByteBuffer:duplicate	()Ljava/nio/ByteBuffer;
    //   21: invokestatic 207	com/tencent/mapsdk/internal/m:a	(Lcom/tencent/mapsdk/internal/m$a;Ljava/nio/ByteBuffer;)I
    //   24: istore_2
    //   25: iload_1
    //   26: aload_3
    //   27: getfield 57	com/tencent/mapsdk/internal/m$a:b	I
    //   30: if_icmple +12 -> 42
    //   33: aload_3
    //   34: getfield 54	com/tencent/mapsdk/internal/m$a:a	B
    //   37: bipush 11
    //   39: if_icmpne +41 -> 80
    //   42: aload_3
    //   43: getfield 54	com/tencent/mapsdk/internal/m$a:a	B
    //   46: bipush 11
    //   48: if_icmpne +10 -> 58
    //   51: ldc 243
    //   53: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: iconst_0
    //   57: ireturn
    //   58: iload_1
    //   59: aload_3
    //   60: getfield 57	com/tencent/mapsdk/internal/m$a:b	I
    //   63: if_icmpne +10 -> 73
    //   66: ldc 243
    //   68: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: iconst_1
    //   72: ireturn
    //   73: ldc 243
    //   75: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: iconst_0
    //   79: ireturn
    //   80: aload_0
    //   81: iload_2
    //   82: invokespecial 179	com/tencent/mapsdk/internal/m:a	(I)V
    //   85: aload_0
    //   86: aload_3
    //   87: getfield 54	com/tencent/mapsdk/internal/m$a:a	B
    //   90: invokespecial 174	com/tencent/mapsdk/internal/m:a	(B)V
    //   93: goto -80 -> 13
    //   96: astore_3
    //   97: ldc 243
    //   99: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: iconst_0
    //   103: ireturn
    //   104: astore_3
    //   105: goto -8 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	m
    //   0	108	1	paramInt	int
    //   24	58	2	i	int
    //   12	75	3	locala	a
    //   96	1	3	localj	j
    //   104	1	3	localBufferUnderflowException	java.nio.BufferUnderflowException
    // Exception table:
    //   from	to	target	type
    //   5	13	96	com/tencent/mapsdk/internal/j
    //   13	42	96	com/tencent/mapsdk/internal/j
    //   42	56	96	com/tencent/mapsdk/internal/j
    //   58	71	96	com/tencent/mapsdk/internal/j
    //   80	93	96	com/tencent/mapsdk/internal/j
    //   5	13	104	java/nio/BufferUnderflowException
    //   13	42	104	java/nio/BufferUnderflowException
    //   42	56	104	java/nio/BufferUnderflowException
    //   58	71	104	java/nio/BufferUnderflowException
    //   80	93	104	java/nio/BufferUnderflowException
  }
  
  private <T> T[] b(T paramT, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225281);
    if (b(paramInt))
    {
      Object localObject = new a();
      a((a)localObject);
      switch (((a)localObject).a)
      {
      default: 
        paramT = new j("type mismatch.");
        AppMethodBeat.o(225281);
        throw paramT;
      }
      int i = a(0, 0, true);
      if (i < 0)
      {
        paramT = new j("size invalid: ".concat(String.valueOf(i)));
        AppMethodBeat.o(225281);
        throw paramT;
      }
      localObject = (Object[])Array.newInstance(paramT.getClass(), i);
      paramInt = 0;
      while (paramInt < i)
      {
        localObject[paramInt] = a(paramT, 0, true);
        paramInt += 1;
      }
      AppMethodBeat.o(225281);
      return localObject;
    }
    if (paramBoolean)
    {
      paramT = new j("require field not exist.");
      AppMethodBeat.o(225281);
      throw paramT;
    }
    AppMethodBeat.o(225281);
    return null;
  }
  
  private ByteBuffer c()
  {
    return this.b;
  }
  
  private Map<String, String> d(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225153);
    Object localObject = new HashMap();
    if (b(paramInt))
    {
      a locala = new a();
      a(locala);
      switch (locala.a)
      {
      default: 
        localObject = new j("type mismatch.");
        AppMethodBeat.o(225153);
        throw ((Throwable)localObject);
      }
      int i = a(0, 0, true);
      if (i < 0)
      {
        localObject = new j("size invalid: ".concat(String.valueOf(i)));
        AppMethodBeat.o(225153);
        throw ((Throwable)localObject);
      }
      paramInt = 0;
      while (paramInt < i)
      {
        ((HashMap)localObject).put(b(0, true), b(1, true));
        paramInt += 1;
      }
    }
    if (paramBoolean)
    {
      localObject = new j("require field not exist.");
      AppMethodBeat.o(225153);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(225153);
    return localObject;
  }
  
  private List e(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225187);
    Object localObject1 = new ArrayList();
    j localj;
    if (b(paramInt))
    {
      Object localObject2 = new a();
      a((a)localObject2);
      switch (((a)localObject2).a)
      {
      default: 
        localObject1 = new j("type mismatch.");
        AppMethodBeat.o(225187);
        throw ((Throwable)localObject1);
      }
      int k = a(0, 0, true);
      if (k < 0)
      {
        localObject1 = new j("size invalid: ".concat(String.valueOf(k)));
        AppMethodBeat.o(225187);
        throw ((Throwable)localObject1);
      }
      paramInt = 0;
      if (paramInt < k)
      {
        localObject2 = new a();
        a((a)localObject2);
        switch (((a)localObject2).a)
        {
        case 11: 
        default: 
          localObject1 = new j("type mismatch.");
          AppMethodBeat.o(225187);
          throw ((Throwable)localObject1);
        case 0: 
          a(1);
        }
        for (;;)
        {
          paramInt += 1;
          break;
          a(2);
          continue;
          a(4);
          continue;
          a(8);
          continue;
          a(4);
          continue;
          a(8);
          continue;
          int j = this.b.get();
          int i = j;
          if (j < 0) {
            i = j + 256;
          }
          a(i);
          continue;
          a(this.b.getInt());
          continue;
          try
          {
            localObject2 = (p)Class.forName(p.class.getName()).getConstructor(new Class[0]).newInstance(new Object[0]);
            ((p)localObject2).readFrom(this);
            a();
            ((List)localObject1).add(localObject2);
          }
          catch (Exception localException)
          {
            localj = new j("type mismatch.".concat(String.valueOf(localException)));
            AppMethodBeat.o(225187);
            throw localj;
          }
          localj.add(Integer.valueOf(0));
        }
      }
    }
    else if (paramBoolean)
    {
      localj = new j("require field not exist.");
      AppMethodBeat.o(225187);
      throw localj;
    }
    AppMethodBeat.o(225187);
    return localj;
  }
  
  private boolean[] f(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225199);
    Object localObject = null;
    if (b(paramInt))
    {
      localObject = new a();
      a((a)localObject);
      switch (((a)localObject).a)
      {
      default: 
        localObject = new j("type mismatch.");
        AppMethodBeat.o(225199);
        throw ((Throwable)localObject);
      }
      int i = a(0, 0, true);
      if (i < 0)
      {
        localObject = new j("size invalid: ".concat(String.valueOf(i)));
        AppMethodBeat.o(225199);
        throw ((Throwable)localObject);
      }
      boolean[] arrayOfBoolean = new boolean[i];
      paramInt = 0;
      for (;;)
      {
        localObject = arrayOfBoolean;
        if (paramInt >= i) {
          break;
        }
        arrayOfBoolean[paramInt] = a(0, true);
        paramInt += 1;
      }
    }
    if (paramBoolean)
    {
      localObject = new j("require field not exist.");
      AppMethodBeat.o(225199);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(225199);
    return localObject;
  }
  
  private short[] g(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225212);
    Object localObject = null;
    if (b(paramInt))
    {
      localObject = new a();
      a((a)localObject);
      switch (((a)localObject).a)
      {
      default: 
        localObject = new j("type mismatch.");
        AppMethodBeat.o(225212);
        throw ((Throwable)localObject);
      }
      int i = a(0, 0, true);
      if (i < 0)
      {
        localObject = new j("size invalid: ".concat(String.valueOf(i)));
        AppMethodBeat.o(225212);
        throw ((Throwable)localObject);
      }
      short[] arrayOfShort = new short[i];
      paramInt = 0;
      for (;;)
      {
        localObject = arrayOfShort;
        if (paramInt >= i) {
          break;
        }
        arrayOfShort[paramInt] = a(arrayOfShort[0], 0, true);
        paramInt += 1;
      }
    }
    if (paramBoolean)
    {
      localObject = new j("require field not exist.");
      AppMethodBeat.o(225212);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(225212);
    return localObject;
  }
  
  private int[] h(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225220);
    Object localObject = null;
    if (b(paramInt))
    {
      localObject = new a();
      a((a)localObject);
      switch (((a)localObject).a)
      {
      default: 
        localObject = new j("type mismatch.");
        AppMethodBeat.o(225220);
        throw ((Throwable)localObject);
      }
      int i = a(0, 0, true);
      if (i < 0)
      {
        localObject = new j("size invalid: ".concat(String.valueOf(i)));
        AppMethodBeat.o(225220);
        throw ((Throwable)localObject);
      }
      int[] arrayOfInt = new int[i];
      paramInt = 0;
      for (;;)
      {
        localObject = arrayOfInt;
        if (paramInt >= i) {
          break;
        }
        arrayOfInt[paramInt] = a(arrayOfInt[0], 0, true);
        paramInt += 1;
      }
    }
    if (paramBoolean)
    {
      localObject = new j("require field not exist.");
      AppMethodBeat.o(225220);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(225220);
    return localObject;
  }
  
  private long[] i(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225228);
    Object localObject = null;
    if (b(paramInt))
    {
      localObject = new a();
      a((a)localObject);
      switch (((a)localObject).a)
      {
      default: 
        localObject = new j("type mismatch.");
        AppMethodBeat.o(225228);
        throw ((Throwable)localObject);
      }
      int i = a(0, 0, true);
      if (i < 0)
      {
        localObject = new j("size invalid: ".concat(String.valueOf(i)));
        AppMethodBeat.o(225228);
        throw ((Throwable)localObject);
      }
      long[] arrayOfLong = new long[i];
      paramInt = 0;
      for (;;)
      {
        localObject = arrayOfLong;
        if (paramInt >= i) {
          break;
        }
        arrayOfLong[paramInt] = a(arrayOfLong[0], 0, true);
        paramInt += 1;
      }
    }
    if (paramBoolean)
    {
      localObject = new j("require field not exist.");
      AppMethodBeat.o(225228);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(225228);
    return localObject;
  }
  
  private float[] j(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225235);
    Object localObject = null;
    if (b(paramInt))
    {
      localObject = new a();
      a((a)localObject);
      switch (((a)localObject).a)
      {
      default: 
        localObject = new j("type mismatch.");
        AppMethodBeat.o(225235);
        throw ((Throwable)localObject);
      }
      int i = a(0, 0, true);
      if (i < 0)
      {
        localObject = new j("size invalid: ".concat(String.valueOf(i)));
        AppMethodBeat.o(225235);
        throw ((Throwable)localObject);
      }
      float[] arrayOfFloat = new float[i];
      paramInt = 0;
      for (;;)
      {
        localObject = arrayOfFloat;
        if (paramInt >= i) {
          break;
        }
        arrayOfFloat[paramInt] = a(arrayOfFloat[0], 0, true);
        paramInt += 1;
      }
    }
    if (paramBoolean)
    {
      localObject = new j("require field not exist.");
      AppMethodBeat.o(225235);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(225235);
    return localObject;
  }
  
  private double[] k(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225247);
    Object localObject = null;
    if (b(paramInt))
    {
      localObject = new a();
      a((a)localObject);
      switch (((a)localObject).a)
      {
      default: 
        localObject = new j("type mismatch.");
        AppMethodBeat.o(225247);
        throw ((Throwable)localObject);
      }
      int i = a(0, 0, true);
      if (i < 0)
      {
        localObject = new j("size invalid: ".concat(String.valueOf(i)));
        AppMethodBeat.o(225247);
        throw ((Throwable)localObject);
      }
      double[] arrayOfDouble = new double[i];
      paramInt = 0;
      for (;;)
      {
        localObject = arrayOfDouble;
        if (paramInt >= i) {
          break;
        }
        arrayOfDouble[paramInt] = a(arrayOfDouble[0], 0, true);
        paramInt += 1;
      }
    }
    if (paramBoolean)
    {
      localObject = new j("require field not exist.");
      AppMethodBeat.o(225247);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(225247);
    return localObject;
  }
  
  public final byte a(byte paramByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225335);
    if (b(paramInt))
    {
      localObject = new a();
      a((a)localObject);
      switch (((a)localObject).a)
      {
      default: 
        localObject = new j("type mismatch.");
        AppMethodBeat.o(225335);
        throw ((Throwable)localObject);
      case 12: 
        paramByte = 0;
      }
    }
    while (!paramBoolean) {
      for (;;)
      {
        AppMethodBeat.o(225335);
        return paramByte;
        paramByte = this.b.get();
      }
    }
    Object localObject = new j("require field not exist.");
    AppMethodBeat.o(225335);
    throw ((Throwable)localObject);
  }
  
  public final double a(double paramDouble, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225398);
    if (b(paramInt))
    {
      localObject = new a();
      a((a)localObject);
      switch (((a)localObject).a)
      {
      default: 
        localObject = new j("type mismatch.");
        AppMethodBeat.o(225398);
        throw ((Throwable)localObject);
      case 12: 
        paramDouble = 0.0D;
      }
    }
    while (!paramBoolean) {
      for (;;)
      {
        AppMethodBeat.o(225398);
        return paramDouble;
        paramDouble = this.b.getFloat();
        continue;
        paramDouble = this.b.getDouble();
      }
    }
    Object localObject = new j("require field not exist.");
    AppMethodBeat.o(225398);
    throw ((Throwable)localObject);
  }
  
  public final float a(float paramFloat, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225388);
    if (b(paramInt))
    {
      localObject = new a();
      a((a)localObject);
      switch (((a)localObject).a)
      {
      default: 
        localObject = new j("type mismatch.");
        AppMethodBeat.o(225388);
        throw ((Throwable)localObject);
      case 12: 
        paramFloat = 0.0F;
      }
    }
    while (!paramBoolean) {
      for (;;)
      {
        AppMethodBeat.o(225388);
        return paramFloat;
        paramFloat = this.b.getFloat();
      }
    }
    Object localObject = new j("require field not exist.");
    AppMethodBeat.o(225388);
    throw ((Throwable)localObject);
  }
  
  public final int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(225365);
    if (b(paramInt2))
    {
      localObject = new a();
      a((a)localObject);
      switch (((a)localObject).a)
      {
      default: 
        localObject = new j("type mismatch.");
        AppMethodBeat.o(225365);
        throw ((Throwable)localObject);
      case 12: 
        paramInt1 = 0;
      }
    }
    while (!paramBoolean) {
      for (;;)
      {
        AppMethodBeat.o(225365);
        return paramInt1;
        paramInt1 = this.b.get();
        continue;
        paramInt1 = this.b.getShort();
        continue;
        paramInt1 = this.b.getInt();
      }
    }
    Object localObject = new j("require field not exist.");
    AppMethodBeat.o(225365);
    throw ((Throwable)localObject);
  }
  
  public final int a(String paramString)
  {
    this.a = paramString;
    return 0;
  }
  
  public final long a(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225378);
    if (b(paramInt))
    {
      localObject = new a();
      a((a)localObject);
      switch (((a)localObject).a)
      {
      default: 
        localObject = new j("type mismatch.");
        AppMethodBeat.o(225378);
        throw ((Throwable)localObject);
      case 12: 
        paramLong = 0L;
      }
    }
    while (!paramBoolean) {
      for (;;)
      {
        AppMethodBeat.o(225378);
        return paramLong;
        paramLong = this.b.get();
        continue;
        paramLong = this.b.getShort();
        continue;
        paramLong = this.b.getInt();
        continue;
        paramLong = this.b.getLong();
      }
    }
    Object localObject = new j("require field not exist.");
    AppMethodBeat.o(225378);
    throw ((Throwable)localObject);
  }
  
  public final p a(p paramp)
  {
    AppMethodBeat.i(225449);
    if (b(0))
    {
      try
      {
        paramp = paramp.newInit();
        a locala = new a();
        a(locala);
        if (locala.a != 10)
        {
          paramp = new j("type mismatch.");
          AppMethodBeat.o(225449);
          throw paramp;
        }
      }
      catch (Exception paramp)
      {
        paramp = new j(paramp.getMessage());
        AppMethodBeat.o(225449);
        throw paramp;
      }
      paramp.readFrom(this);
      a();
      AppMethodBeat.o(225449);
      return paramp;
    }
    paramp = new j("require field not exist.");
    AppMethodBeat.o(225449);
    throw paramp;
  }
  
  public final p a(p paramp, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225459);
    a locala = null;
    if (b(paramInt))
    {
      try
      {
        paramp = (p)paramp.getClass().newInstance();
        locala = new a();
        a(locala);
        if (locala.a != 10)
        {
          paramp = new j("type mismatch.");
          AppMethodBeat.o(225459);
          throw paramp;
        }
      }
      catch (Exception paramp)
      {
        paramp = new j(paramp.getMessage());
        AppMethodBeat.o(225459);
        throw paramp;
      }
      paramp.readFrom(this);
      a();
    }
    do
    {
      AppMethodBeat.o(225459);
      return paramp;
      paramp = locala;
    } while (!paramBoolean);
    paramp = new j("require field not exist.");
    AppMethodBeat.o(225459);
    throw paramp;
  }
  
  public final <T> Object a(T paramT, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225475);
    if ((paramT instanceof Byte))
    {
      byte b1 = a((byte)0, paramInt, paramBoolean);
      AppMethodBeat.o(225475);
      return Byte.valueOf(b1);
    }
    if ((paramT instanceof Boolean))
    {
      paramBoolean = a(paramInt, paramBoolean);
      AppMethodBeat.o(225475);
      return Boolean.valueOf(paramBoolean);
    }
    if ((paramT instanceof Short))
    {
      short s = a((short)0, paramInt, paramBoolean);
      AppMethodBeat.o(225475);
      return Short.valueOf(s);
    }
    if ((paramT instanceof Integer))
    {
      paramInt = a(0, paramInt, paramBoolean);
      AppMethodBeat.o(225475);
      return Integer.valueOf(paramInt);
    }
    if ((paramT instanceof Long))
    {
      long l = a(0L, paramInt, paramBoolean);
      AppMethodBeat.o(225475);
      return Long.valueOf(l);
    }
    if ((paramT instanceof Float))
    {
      float f = a(0.0F, paramInt, paramBoolean);
      AppMethodBeat.o(225475);
      return Float.valueOf(f);
    }
    if ((paramT instanceof Double))
    {
      double d = a(0.0D, paramInt, paramBoolean);
      AppMethodBeat.o(225475);
      return Double.valueOf(d);
    }
    if ((paramT instanceof String))
    {
      paramT = b(paramInt, paramBoolean);
      AppMethodBeat.o(225475);
      return paramT;
    }
    if ((paramT instanceof Map))
    {
      paramT = a((Map)paramT, paramInt, paramBoolean);
      AppMethodBeat.o(225475);
      return paramT;
    }
    if ((paramT instanceof List))
    {
      paramT = a((List)paramT, paramInt, paramBoolean);
      AppMethodBeat.o(225475);
      return paramT;
    }
    if ((paramT instanceof p))
    {
      paramT = a((p)paramT, paramInt, paramBoolean);
      AppMethodBeat.o(225475);
      return paramT;
    }
    if (paramT.getClass().isArray())
    {
      if (((paramT instanceof byte[])) || ((paramT instanceof Byte[])))
      {
        paramT = c(paramInt, paramBoolean);
        AppMethodBeat.o(225475);
        return paramT;
      }
      if ((paramT instanceof boolean[]))
      {
        paramT = f(paramInt, paramBoolean);
        AppMethodBeat.o(225475);
        return paramT;
      }
      if ((paramT instanceof short[]))
      {
        paramT = g(paramInt, paramBoolean);
        AppMethodBeat.o(225475);
        return paramT;
      }
      if ((paramT instanceof int[]))
      {
        paramT = h(paramInt, paramBoolean);
        AppMethodBeat.o(225475);
        return paramT;
      }
      if ((paramT instanceof long[]))
      {
        paramT = i(paramInt, paramBoolean);
        AppMethodBeat.o(225475);
        return paramT;
      }
      if ((paramT instanceof float[]))
      {
        paramT = j(paramInt, paramBoolean);
        AppMethodBeat.o(225475);
        return paramT;
      }
      if ((paramT instanceof double[]))
      {
        paramT = k(paramInt, paramBoolean);
        AppMethodBeat.o(225475);
        return paramT;
      }
      paramT = a((Object[])paramT, paramInt, paramBoolean);
      AppMethodBeat.o(225475);
      return paramT;
    }
    paramT = new j("read object error: unsupport type.");
    AppMethodBeat.o(225475);
    throw paramT;
  }
  
  public final <K, V> HashMap<K, V> a(Map<K, V> paramMap, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225420);
    paramMap = (HashMap)a(new HashMap(), paramMap, paramInt, paramBoolean);
    AppMethodBeat.o(225420);
    return paramMap;
  }
  
  public final short a(short paramShort, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225354);
    if (b(paramInt))
    {
      localObject = new a();
      a((a)localObject);
      switch (((a)localObject).a)
      {
      default: 
        localObject = new j("type mismatch.");
        AppMethodBeat.o(225354);
        throw ((Throwable)localObject);
      case 12: 
        paramShort = 0;
      }
    }
    while (!paramBoolean) {
      for (;;)
      {
        AppMethodBeat.o(225354);
        return paramShort;
        paramShort = (short)this.b.get();
        continue;
        paramShort = this.b.getShort();
      }
    }
    Object localObject = new j("require field not exist.");
    AppMethodBeat.o(225354);
    throw ((Throwable)localObject);
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(225310);
    this.b = ByteBuffer.wrap(paramArrayOfByte);
    AppMethodBeat.o(225310);
  }
  
  public final boolean a(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225322);
    if (a((byte)0, paramInt, paramBoolean) != 0)
    {
      AppMethodBeat.o(225322);
      return true;
    }
    AppMethodBeat.o(225322);
    return false;
  }
  
  public final String b(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225409);
    Object localObject1 = null;
    if (b(paramInt))
    {
      localObject1 = new a();
      a((a)localObject1);
      switch (((a)localObject1).a)
      {
      default: 
        localObject1 = new j("type mismatch.");
        AppMethodBeat.o(225409);
        throw ((Throwable)localObject1);
      case 6: 
        i = this.b.get();
        paramInt = i;
        if (i < 0) {
          paramInt = i + 256;
        }
        arrayOfByte = new byte[paramInt];
        this.b.get(arrayOfByte);
      }
    }
    while (!paramBoolean) {
      for (;;)
      {
        Object localObject2;
        try
        {
          int i;
          localObject1 = new String(arrayOfByte, this.a);
          AppMethodBeat.o(225409);
          return localObject1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException1)
        {
          localObject2 = new String(arrayOfByte);
          continue;
        }
        paramInt = this.b.getInt();
        if ((paramInt > 104857600) || (paramInt < 0) || (paramInt > this.b.capacity()))
        {
          localObject2 = new j("String too long: ".concat(String.valueOf(paramInt)));
          AppMethodBeat.o(225409);
          throw ((Throwable)localObject2);
        }
        byte[] arrayOfByte = new byte[paramInt];
        this.b.get(arrayOfByte);
        try
        {
          localObject2 = new String(arrayOfByte, this.a);
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2)
        {
          localObject3 = new String(arrayOfByte);
        }
      }
    }
    Object localObject3 = new j("require field not exist.");
    AppMethodBeat.o(225409);
    throw ((Throwable)localObject3);
  }
  
  public final byte[] c(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225437);
    Object localObject1 = null;
    if (b(paramInt))
    {
      localObject1 = new a();
      a((a)localObject1);
      switch (((a)localObject1).a)
      {
      default: 
        localObject1 = new j("type mismatch.");
        AppMethodBeat.o(225437);
        throw ((Throwable)localObject1);
      case 13: 
        localObject2 = new a();
        a((a)localObject2);
        if (((a)localObject2).a != 0)
        {
          localObject1 = new j("type mismatch, tag: " + paramInt + ", type: " + ((a)localObject1).a + ", " + ((a)localObject2).a);
          AppMethodBeat.o(225437);
          throw ((Throwable)localObject1);
        }
        i = a(0, 0, true);
        if ((i < 0) || (i > this.b.capacity()))
        {
          localObject1 = new j("invalid size, tag: " + paramInt + ", type: " + ((a)localObject1).a + ", " + ((a)localObject2).a + ", size: " + i);
          AppMethodBeat.o(225437);
          throw ((Throwable)localObject1);
        }
        localObject1 = new byte[i];
        this.b.get((byte[])localObject1);
      }
    }
    while (!paramBoolean)
    {
      AppMethodBeat.o(225437);
      return localObject1;
      int i = a(0, 0, true);
      if ((i < 0) || (i > this.b.capacity()))
      {
        localObject1 = new j("size invalid: ".concat(String.valueOf(i)));
        AppMethodBeat.o(225437);
        throw ((Throwable)localObject1);
      }
      Object localObject2 = new byte[i];
      paramInt = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (paramInt >= i) {
          break;
        }
        localObject2[paramInt] = a(localObject2[0], 0, true);
        paramInt += 1;
      }
    }
    localObject1 = new j("require field not exist.");
    AppMethodBeat.o(225437);
    throw ((Throwable)localObject1);
  }
  
  public static final class a
  {
    public byte a;
    public int b;
    
    private void a()
    {
      this.a = 0;
      this.b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.m
 * JD-Core Version:    0.7.0.1
 */