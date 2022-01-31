package com.tencent.mm.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;
import org.json.JSONArray;

public final class f
  extends JSONArray
  implements a
{
  private final a eGF;
  
  public f()
  {
    AppMethodBeat.i(117557);
    this.eGF = h.QA();
    AppMethodBeat.o(117557);
  }
  
  f(a parama)
  {
    AppMethodBeat.i(117559);
    Assert.assertNotNull(parama);
    this.eGF = parama;
    AppMethodBeat.o(117559);
  }
  
  public f(String paramString)
  {
    AppMethodBeat.i(117558);
    this.eGF = h.mq(paramString);
    AppMethodBeat.o(117558);
  }
  
  private f A(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(117566);
    this.eGF.z(paramInt, paramBoolean);
    AppMethodBeat.o(117566);
    return this;
  }
  
  private f al(Object paramObject)
  {
    AppMethodBeat.i(117565);
    this.eGF.ak(paramObject);
    AppMethodBeat.o(117565);
    return this;
  }
  
  private f ch(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117568);
    this.eGF.cg(paramInt1, paramInt2);
    AppMethodBeat.o(117568);
    return this;
  }
  
  private f ct(boolean paramBoolean)
  {
    AppMethodBeat.i(117561);
    this.eGF.cs(paramBoolean);
    AppMethodBeat.o(117561);
    return this;
  }
  
  private f e(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(117567);
    this.eGF.d(paramInt, paramDouble);
    AppMethodBeat.o(117567);
    return this;
  }
  
  private f f(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(117570);
    this.eGF.e(paramInt, paramObject);
    AppMethodBeat.o(117570);
    return this;
  }
  
  private f gh(long paramLong)
  {
    AppMethodBeat.i(117564);
    this.eGF.gg(paramLong);
    AppMethodBeat.o(117564);
    return this;
  }
  
  private f jE(int paramInt)
  {
    AppMethodBeat.i(117563);
    this.eGF.jz(paramInt);
    AppMethodBeat.o(117563);
    return this;
  }
  
  private f jF(int paramInt)
  {
    AppMethodBeat.i(117590);
    f localf = new f(this.eGF.jA(paramInt));
    AppMethodBeat.o(117590);
    return localf;
  }
  
  private f jG(int paramInt)
  {
    AppMethodBeat.i(117591);
    f localf = new f(this.eGF.jB(paramInt));
    AppMethodBeat.o(117591);
    return localf;
  }
  
  private i jH(int paramInt)
  {
    AppMethodBeat.i(117592);
    i locali = new i(this.eGF.jC(paramInt));
    AppMethodBeat.o(117592);
    return locali;
  }
  
  private i jI(int paramInt)
  {
    AppMethodBeat.i(117593);
    i locali = new i(this.eGF.jD(paramInt));
    AppMethodBeat.o(117593);
    return locali;
  }
  
  private f o(double paramDouble)
  {
    AppMethodBeat.i(117562);
    this.eGF.n(paramDouble);
    AppMethodBeat.o(117562);
    return this;
  }
  
  private f t(int paramInt, long paramLong)
  {
    AppMethodBeat.i(117569);
    this.eGF.s(paramInt, paramLong);
    AppMethodBeat.o(117569);
    return this;
  }
  
  public final Object get(int paramInt)
  {
    AppMethodBeat.i(117572);
    Object localObject = this.eGF.get(paramInt);
    AppMethodBeat.o(117572);
    return localObject;
  }
  
  public final boolean getBoolean(int paramInt)
  {
    AppMethodBeat.i(117575);
    boolean bool = this.eGF.getBoolean(paramInt);
    AppMethodBeat.o(117575);
    return bool;
  }
  
  public final double getDouble(int paramInt)
  {
    AppMethodBeat.i(117578);
    double d = this.eGF.getDouble(paramInt);
    AppMethodBeat.o(117578);
    return d;
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(117581);
    paramInt = this.eGF.getInt(paramInt);
    AppMethodBeat.o(117581);
    return paramInt;
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(117584);
    long l = this.eGF.getLong(paramInt);
    AppMethodBeat.o(117584);
    return l;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(117587);
    String str = this.eGF.getString(paramInt);
    AppMethodBeat.o(117587);
    return str;
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(117571);
    boolean bool = this.eGF.isNull(paramInt);
    AppMethodBeat.o(117571);
    return bool;
  }
  
  public final int length()
  {
    AppMethodBeat.i(117560);
    int i = this.eGF.length();
    AppMethodBeat.o(117560);
    return i;
  }
  
  public final Object opt(int paramInt)
  {
    AppMethodBeat.i(117573);
    Object localObject = this.eGF.opt(paramInt);
    AppMethodBeat.o(117573);
    return localObject;
  }
  
  public final boolean optBoolean(int paramInt)
  {
    AppMethodBeat.i(117576);
    boolean bool = this.eGF.optBoolean(paramInt);
    AppMethodBeat.o(117576);
    return bool;
  }
  
  public final boolean optBoolean(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(117577);
    paramBoolean = this.eGF.optBoolean(paramInt, paramBoolean);
    AppMethodBeat.o(117577);
    return paramBoolean;
  }
  
  public final double optDouble(int paramInt)
  {
    AppMethodBeat.i(117579);
    double d = this.eGF.optDouble(paramInt);
    AppMethodBeat.o(117579);
    return d;
  }
  
  public final double optDouble(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(117580);
    paramDouble = this.eGF.optDouble(paramInt, paramDouble);
    AppMethodBeat.o(117580);
    return paramDouble;
  }
  
  public final int optInt(int paramInt)
  {
    AppMethodBeat.i(117582);
    paramInt = this.eGF.optInt(paramInt);
    AppMethodBeat.o(117582);
    return paramInt;
  }
  
  public final int optInt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117583);
    paramInt1 = this.eGF.optInt(paramInt1, paramInt2);
    AppMethodBeat.o(117583);
    return paramInt1;
  }
  
  public final long optLong(int paramInt)
  {
    AppMethodBeat.i(117585);
    long l = this.eGF.optLong(paramInt);
    AppMethodBeat.o(117585);
    return l;
  }
  
  public final long optLong(int paramInt, long paramLong)
  {
    AppMethodBeat.i(117586);
    paramLong = this.eGF.optLong(paramInt, paramLong);
    AppMethodBeat.o(117586);
    return paramLong;
  }
  
  public final String optString(int paramInt)
  {
    AppMethodBeat.i(117588);
    String str = this.eGF.optString(paramInt);
    AppMethodBeat.o(117588);
    return str;
  }
  
  public final String optString(int paramInt, String paramString)
  {
    AppMethodBeat.i(117589);
    paramString = this.eGF.optString(paramInt, paramString);
    AppMethodBeat.o(117589);
    return paramString;
  }
  
  public final Object remove(int paramInt)
  {
    AppMethodBeat.i(117574);
    Object localObject = this.eGF.remove(paramInt);
    AppMethodBeat.o(117574);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(117594);
    String str = this.eGF.toString();
    AppMethodBeat.o(117594);
    return str;
  }
  
  public final String toString(int paramInt)
  {
    AppMethodBeat.i(117595);
    String str = this.eGF.toString(paramInt);
    AppMethodBeat.o(117595);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aa.f
 * JD-Core Version:    0.7.0.1
 */