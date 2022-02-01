package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.HashMap;

public final class jr<Key, Value>
{
  private int a;
  private jr<Key, Value>.a b;
  private jr<Key, Value>.a c;
  private HashMap<Key, jr<Key, Value>.a> d;
  
  private jr(int paramInt)
  {
    AppMethodBeat.i(224077);
    this.a = paramInt;
    this.d = new HashMap();
    AppMethodBeat.o(224077);
  }
  
  private Value a(Key paramKey)
  {
    AppMethodBeat.i(224117);
    paramKey = (a)this.d.get(paramKey);
    if (paramKey == null)
    {
      AppMethodBeat.o(224117);
      return null;
    }
    a(paramKey);
    paramKey = paramKey.b;
    AppMethodBeat.o(224117);
    return paramKey;
  }
  
  private void a(jr<Key, Value>.a paramjr)
  {
    if (paramjr == null) {}
    while (this.c == paramjr) {
      return;
    }
    if (this.b == paramjr) {
      this.b = this.b.d;
    }
    for (this.b.c = null;; paramjr.d.c = paramjr.c)
    {
      this.c.d = paramjr;
      paramjr.c = this.c;
      this.c = paramjr;
      this.c.d = null;
      return;
      paramjr.c.d = paramjr.d;
    }
  }
  
  private void a(Key paramKey, Value paramValue)
  {
    AppMethodBeat.i(224093);
    if (this.d.containsKey(paramKey))
    {
      paramValue = this.b;
      if (paramValue != null) {
        if (!paramValue.a.equals(paramKey)) {}
      }
      for (;;)
      {
        if (paramValue != null) {
          a(paramValue);
        }
        AppMethodBeat.o(224093);
        return;
        paramValue = paramValue.d;
        break;
        paramValue = null;
      }
    }
    if (this.d.size() >= this.a) {
      a();
    }
    paramValue = new a(paramKey, paramValue, (byte)0);
    if (this.c == null)
    {
      this.c = paramValue;
      this.b = paramValue;
    }
    for (;;)
    {
      this.d.put(paramKey, paramValue);
      AppMethodBeat.o(224093);
      return;
      this.c.d = paramValue;
      paramValue.c = this.c;
      this.c = paramValue;
    }
  }
  
  private boolean a()
  {
    AppMethodBeat.i(224103);
    Object localObject = this.b;
    this.b = this.b.d;
    this.b.c = null;
    localObject = ((a)localObject).a;
    if (localObject == null)
    {
      AppMethodBeat.o(224103);
      return false;
    }
    if (this.d.remove(localObject) != null)
    {
      AppMethodBeat.o(224103);
      return true;
    }
    AppMethodBeat.o(224103);
    return false;
  }
  
  private boolean b()
  {
    AppMethodBeat.i(224137);
    boolean bool = a();
    AppMethodBeat.o(224137);
    return bool;
  }
  
  private boolean b(Key paramKey)
  {
    AppMethodBeat.i(224128);
    if (this.d.remove(paramKey) != null)
    {
      AppMethodBeat.o(224128);
      return true;
    }
    AppMethodBeat.o(224128);
    return false;
  }
  
  private jr<Key, Value>.a c(Key paramKey)
  {
    AppMethodBeat.i(224180);
    for (a locala = this.b; locala != null; locala = locala.d) {
      if (locala.a.equals(paramKey))
      {
        AppMethodBeat.o(224180);
        return locala;
      }
    }
    AppMethodBeat.o(224180);
    return null;
  }
  
  private boolean c()
  {
    AppMethodBeat.i(224147);
    boolean bool = this.d.isEmpty();
    AppMethodBeat.o(224147);
    return bool;
  }
  
  private int d()
  {
    AppMethodBeat.i(224156);
    int i = this.d.size();
    AppMethodBeat.o(224156);
    return i;
  }
  
  private void e()
  {
    AppMethodBeat.i(224168);
    this.d.clear();
    this.c = null;
    this.b = null;
    AppMethodBeat.o(224168);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(224206);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this.b;
    if (this.b.c != null) {
      System.out.println("header的pre不为NULL!");
    }
    localStringBuilder.append("header: \n");
    while (localObject != null)
    {
      localStringBuilder.append(((a)localObject).a + "->");
      localObject = ((a)localObject).d;
    }
    localStringBuilder.append("\ntail: \n");
    a locala = this.c;
    localObject = locala;
    if (this.c.d != null) {
      System.out.println("tail的next不为NULL!");
    }
    for (localObject = locala; localObject != null; localObject = ((a)localObject).c) {
      localStringBuilder.append(((a)localObject).a + "<-");
    }
    localStringBuilder.append("\n");
    localObject = localStringBuilder.toString();
    AppMethodBeat.o(224206);
    return localObject;
  }
  
  final class a
  {
    Key a;
    Value b;
    jr<Key, Value>.a c;
    jr<Key, Value>.a d;
    
    private a(Value paramValue)
    {
      this.a = paramValue;
      Object localObject;
      this.b = localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.internal.jr
 * JD-Core Version:    0.7.0.1
 */