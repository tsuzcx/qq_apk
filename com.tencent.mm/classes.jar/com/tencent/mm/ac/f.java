package com.tencent.mm.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;
import org.json.JSONArray;

public final class f
  extends JSONArray
  implements a
{
  private final a gbN;
  
  public f()
  {
    AppMethodBeat.i(158497);
    this.gbN = h.aem();
    AppMethodBeat.o(158497);
  }
  
  f(a parama)
  {
    AppMethodBeat.i(158499);
    Assert.assertNotNull(parama);
    this.gbN = parama;
    AppMethodBeat.o(158499);
  }
  
  public f(String paramString)
  {
    AppMethodBeat.i(158498);
    this.gbN = h.qG(paramString);
    AppMethodBeat.o(158498);
  }
  
  private f bn(Object paramObject)
  {
    AppMethodBeat.i(158505);
    this.gbN.bm(paramObject);
    AppMethodBeat.o(158505);
    return this;
  }
  
  private f cN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(158508);
    this.gbN.cM(paramInt1, paramInt2);
    AppMethodBeat.o(158508);
    return this;
  }
  
  private f d(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(158507);
    this.gbN.c(paramInt, paramDouble);
    AppMethodBeat.o(158507);
    return this;
  }
  
  private f dx(boolean paramBoolean)
  {
    AppMethodBeat.i(158501);
    this.gbN.dw(paramBoolean);
    AppMethodBeat.o(158501);
    return this;
  }
  
  private f g(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(158510);
    this.gbN.f(paramInt, paramObject);
    AppMethodBeat.o(158510);
    return this;
  }
  
  private f k(double paramDouble)
  {
    AppMethodBeat.i(158502);
    this.gbN.j(paramDouble);
    AppMethodBeat.o(158502);
    return this;
  }
  
  private f lw(long paramLong)
  {
    AppMethodBeat.i(158504);
    this.gbN.lv(paramLong);
    AppMethodBeat.o(158504);
    return this;
  }
  
  private f mh(int paramInt)
  {
    AppMethodBeat.i(158503);
    this.gbN.mc(paramInt);
    AppMethodBeat.o(158503);
    return this;
  }
  
  private f mj(int paramInt)
  {
    AppMethodBeat.i(158531);
    f localf = new f(this.gbN.me(paramInt));
    AppMethodBeat.o(158531);
    return localf;
  }
  
  private i mk(int paramInt)
  {
    AppMethodBeat.i(158532);
    i locali = new i(this.gbN.mf(paramInt));
    AppMethodBeat.o(158532);
    return locali;
  }
  
  private f v(int paramInt, long paramLong)
  {
    AppMethodBeat.i(158509);
    this.gbN.u(paramInt, paramLong);
    AppMethodBeat.o(158509);
    return this;
  }
  
  private f z(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(158506);
    this.gbN.y(paramInt, paramBoolean);
    AppMethodBeat.o(158506);
    return this;
  }
  
  public final Object get(int paramInt)
  {
    AppMethodBeat.i(158512);
    Object localObject = this.gbN.get(paramInt);
    AppMethodBeat.o(158512);
    return localObject;
  }
  
  public final boolean getBoolean(int paramInt)
  {
    AppMethodBeat.i(158515);
    boolean bool = this.gbN.getBoolean(paramInt);
    AppMethodBeat.o(158515);
    return bool;
  }
  
  public final double getDouble(int paramInt)
  {
    AppMethodBeat.i(158518);
    double d = this.gbN.getDouble(paramInt);
    AppMethodBeat.o(158518);
    return d;
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(158521);
    paramInt = this.gbN.getInt(paramInt);
    AppMethodBeat.o(158521);
    return paramInt;
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(158524);
    long l = this.gbN.getLong(paramInt);
    AppMethodBeat.o(158524);
    return l;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(158527);
    String str = this.gbN.getString(paramInt);
    AppMethodBeat.o(158527);
    return str;
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(158511);
    boolean bool = this.gbN.isNull(paramInt);
    AppMethodBeat.o(158511);
    return bool;
  }
  
  public final int length()
  {
    AppMethodBeat.i(158500);
    int i = this.gbN.length();
    AppMethodBeat.o(158500);
    return i;
  }
  
  public final f mi(int paramInt)
  {
    AppMethodBeat.i(158530);
    f localf = new f(this.gbN.md(paramInt));
    AppMethodBeat.o(158530);
    return localf;
  }
  
  public final i ml(int paramInt)
  {
    AppMethodBeat.i(158533);
    i locali = new i(this.gbN.mg(paramInt));
    AppMethodBeat.o(158533);
    return locali;
  }
  
  public final Object opt(int paramInt)
  {
    AppMethodBeat.i(158513);
    Object localObject = this.gbN.opt(paramInt);
    AppMethodBeat.o(158513);
    return localObject;
  }
  
  public final boolean optBoolean(int paramInt)
  {
    AppMethodBeat.i(158516);
    boolean bool = this.gbN.optBoolean(paramInt);
    AppMethodBeat.o(158516);
    return bool;
  }
  
  public final boolean optBoolean(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(158517);
    paramBoolean = this.gbN.optBoolean(paramInt, paramBoolean);
    AppMethodBeat.o(158517);
    return paramBoolean;
  }
  
  public final double optDouble(int paramInt)
  {
    AppMethodBeat.i(158519);
    double d = this.gbN.optDouble(paramInt);
    AppMethodBeat.o(158519);
    return d;
  }
  
  public final double optDouble(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(158520);
    paramDouble = this.gbN.optDouble(paramInt, paramDouble);
    AppMethodBeat.o(158520);
    return paramDouble;
  }
  
  public final int optInt(int paramInt)
  {
    AppMethodBeat.i(158522);
    paramInt = this.gbN.optInt(paramInt);
    AppMethodBeat.o(158522);
    return paramInt;
  }
  
  public final int optInt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(158523);
    paramInt1 = this.gbN.optInt(paramInt1, paramInt2);
    AppMethodBeat.o(158523);
    return paramInt1;
  }
  
  public final long optLong(int paramInt)
  {
    AppMethodBeat.i(158525);
    long l = this.gbN.optLong(paramInt);
    AppMethodBeat.o(158525);
    return l;
  }
  
  public final long optLong(int paramInt, long paramLong)
  {
    AppMethodBeat.i(158526);
    paramLong = this.gbN.optLong(paramInt, paramLong);
    AppMethodBeat.o(158526);
    return paramLong;
  }
  
  public final String optString(int paramInt)
  {
    AppMethodBeat.i(158528);
    String str = this.gbN.optString(paramInt);
    AppMethodBeat.o(158528);
    return str;
  }
  
  public final String optString(int paramInt, String paramString)
  {
    AppMethodBeat.i(158529);
    paramString = this.gbN.optString(paramInt, paramString);
    AppMethodBeat.o(158529);
    return paramString;
  }
  
  public final Object remove(int paramInt)
  {
    AppMethodBeat.i(158514);
    Object localObject = this.gbN.remove(paramInt);
    AppMethodBeat.o(158514);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(158534);
    String str = this.gbN.toString();
    AppMethodBeat.o(158534);
    return str;
  }
  
  public final String toString(int paramInt)
  {
    AppMethodBeat.i(158535);
    String str = this.gbN.toString(paramInt);
    AppMethodBeat.o(158535);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ac.f
 * JD-Core Version:    0.7.0.1
 */