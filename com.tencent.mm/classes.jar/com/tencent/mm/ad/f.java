package com.tencent.mm.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import junit.framework.Assert;
import org.json.JSONArray;

public final class f
  extends JSONArray
  implements a
{
  private final a mBu;
  
  public f()
  {
    AppMethodBeat.i(158497);
    this.mBu = h.aZo();
    AppMethodBeat.o(158497);
  }
  
  f(a parama)
  {
    AppMethodBeat.i(158499);
    Assert.assertNotNull(parama);
    this.mBu = parama;
    AppMethodBeat.o(158499);
  }
  
  public f(String paramString)
  {
    AppMethodBeat.i(158498);
    this.mBu = h.Fp(paramString);
    AppMethodBeat.o(158498);
  }
  
  public f(Collection paramCollection)
  {
    AppMethodBeat.i(230942);
    this.mBu = h.s(paramCollection);
    AppMethodBeat.o(230942);
  }
  
  private f A(int paramInt, long paramLong)
  {
    AppMethodBeat.i(158509);
    this.mBu.z(paramInt, paramLong);
    AppMethodBeat.o(158509);
    return this;
  }
  
  private f B(double paramDouble)
  {
    AppMethodBeat.i(158502);
    this.mBu.A(paramDouble);
    AppMethodBeat.o(158502);
    return this;
  }
  
  private f D(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(158510);
    this.mBu.C(paramInt, paramObject);
    AppMethodBeat.o(158510);
    return this;
  }
  
  private f T(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(158506);
    this.mBu.S(paramInt, paramBoolean);
    AppMethodBeat.o(158506);
    return this;
  }
  
  private f eb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(158508);
    this.mBu.dZ(paramInt1, paramInt2);
    AppMethodBeat.o(158508);
    return this;
  }
  
  private f fy(boolean paramBoolean)
  {
    AppMethodBeat.i(158501);
    this.mBu.fx(paramBoolean);
    AppMethodBeat.o(158501);
    return this;
  }
  
  private f g(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(158507);
    this.mBu.f(paramInt, paramDouble);
    AppMethodBeat.o(158507);
    return this;
  }
  
  private f hD(long paramLong)
  {
    AppMethodBeat.i(158504);
    this.mBu.hC(paramLong);
    AppMethodBeat.o(158504);
    return this;
  }
  
  private f sq(int paramInt)
  {
    AppMethodBeat.i(158503);
    this.mBu.sl(paramInt);
    AppMethodBeat.o(158503);
    return this;
  }
  
  private f ss(int paramInt)
  {
    AppMethodBeat.i(158531);
    f localf = new f(this.mBu.sn(paramInt));
    AppMethodBeat.o(158531);
    return localf;
  }
  
  public final f cP(Object paramObject)
  {
    AppMethodBeat.i(158505);
    this.mBu.cO(paramObject);
    AppMethodBeat.o(158505);
    return this;
  }
  
  public final Object get(int paramInt)
  {
    AppMethodBeat.i(158512);
    Object localObject = this.mBu.get(paramInt);
    AppMethodBeat.o(158512);
    return localObject;
  }
  
  public final boolean getBoolean(int paramInt)
  {
    AppMethodBeat.i(158515);
    boolean bool = this.mBu.getBoolean(paramInt);
    AppMethodBeat.o(158515);
    return bool;
  }
  
  public final double getDouble(int paramInt)
  {
    AppMethodBeat.i(158518);
    double d = this.mBu.getDouble(paramInt);
    AppMethodBeat.o(158518);
    return d;
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(158521);
    paramInt = this.mBu.getInt(paramInt);
    AppMethodBeat.o(158521);
    return paramInt;
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(158524);
    long l = this.mBu.getLong(paramInt);
    AppMethodBeat.o(158524);
    return l;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(158527);
    String str = this.mBu.getString(paramInt);
    AppMethodBeat.o(158527);
    return str;
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(158511);
    boolean bool = this.mBu.isNull(paramInt);
    AppMethodBeat.o(158511);
    return bool;
  }
  
  public final int length()
  {
    AppMethodBeat.i(158500);
    int i = this.mBu.length();
    AppMethodBeat.o(158500);
    return i;
  }
  
  public final Object opt(int paramInt)
  {
    AppMethodBeat.i(158513);
    Object localObject = this.mBu.opt(paramInt);
    AppMethodBeat.o(158513);
    return localObject;
  }
  
  public final boolean optBoolean(int paramInt)
  {
    AppMethodBeat.i(158516);
    boolean bool = this.mBu.optBoolean(paramInt);
    AppMethodBeat.o(158516);
    return bool;
  }
  
  public final boolean optBoolean(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(158517);
    paramBoolean = this.mBu.optBoolean(paramInt, paramBoolean);
    AppMethodBeat.o(158517);
    return paramBoolean;
  }
  
  public final double optDouble(int paramInt)
  {
    AppMethodBeat.i(158519);
    double d = this.mBu.optDouble(paramInt);
    AppMethodBeat.o(158519);
    return d;
  }
  
  public final double optDouble(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(158520);
    paramDouble = this.mBu.optDouble(paramInt, paramDouble);
    AppMethodBeat.o(158520);
    return paramDouble;
  }
  
  public final int optInt(int paramInt)
  {
    AppMethodBeat.i(158522);
    paramInt = this.mBu.optInt(paramInt);
    AppMethodBeat.o(158522);
    return paramInt;
  }
  
  public final int optInt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(158523);
    paramInt1 = this.mBu.optInt(paramInt1, paramInt2);
    AppMethodBeat.o(158523);
    return paramInt1;
  }
  
  public final long optLong(int paramInt)
  {
    AppMethodBeat.i(158525);
    long l = this.mBu.optLong(paramInt);
    AppMethodBeat.o(158525);
    return l;
  }
  
  public final long optLong(int paramInt, long paramLong)
  {
    AppMethodBeat.i(158526);
    paramLong = this.mBu.optLong(paramInt, paramLong);
    AppMethodBeat.o(158526);
    return paramLong;
  }
  
  public final String optString(int paramInt)
  {
    AppMethodBeat.i(158528);
    String str = this.mBu.optString(paramInt);
    AppMethodBeat.o(158528);
    return str;
  }
  
  public final String optString(int paramInt, String paramString)
  {
    AppMethodBeat.i(158529);
    paramString = this.mBu.optString(paramInt, paramString);
    AppMethodBeat.o(158529);
    return paramString;
  }
  
  public final Object remove(int paramInt)
  {
    AppMethodBeat.i(158514);
    Object localObject = this.mBu.remove(paramInt);
    AppMethodBeat.o(158514);
    return localObject;
  }
  
  public final f sr(int paramInt)
  {
    AppMethodBeat.i(158530);
    f localf = new f(this.mBu.sm(paramInt));
    AppMethodBeat.o(158530);
    return localf;
  }
  
  public final i st(int paramInt)
  {
    AppMethodBeat.i(158532);
    i locali = new i(this.mBu.so(paramInt));
    AppMethodBeat.o(158532);
    return locali;
  }
  
  public final i su(int paramInt)
  {
    AppMethodBeat.i(158533);
    i locali = new i(this.mBu.sp(paramInt));
    AppMethodBeat.o(158533);
    return locali;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(158534);
    String str = this.mBu.toString();
    AppMethodBeat.o(158534);
    return str;
  }
  
  public final String toString(int paramInt)
  {
    AppMethodBeat.i(158535);
    String str = this.mBu.toString(paramInt);
    AppMethodBeat.o(158535);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.ad.f
 * JD-Core Version:    0.7.0.1
 */