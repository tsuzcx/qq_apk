package com.tencent.mm.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import junit.framework.Assert;
import org.json.JSONArray;

public final class f
  extends JSONArray
  implements a
{
  private final a kbp;
  
  public f()
  {
    AppMethodBeat.i(158497);
    this.kbp = h.aGn();
    AppMethodBeat.o(158497);
  }
  
  f(a parama)
  {
    AppMethodBeat.i(158499);
    Assert.assertNotNull(parama);
    this.kbp = parama;
    AppMethodBeat.o(158499);
  }
  
  public f(String paramString)
  {
    AppMethodBeat.i(158498);
    this.kbp = h.MG(paramString);
    AppMethodBeat.o(158498);
  }
  
  public f(Collection paramCollection)
  {
    AppMethodBeat.i(202179);
    this.kbp = h.d(paramCollection);
    AppMethodBeat.o(202179);
  }
  
  private f F(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(158506);
    this.kbp.E(paramInt, paramBoolean);
    AppMethodBeat.o(158506);
    return this;
  }
  
  private f Fu(long paramLong)
  {
    AppMethodBeat.i(158504);
    this.kbp.Ft(paramLong);
    AppMethodBeat.o(158504);
    return this;
  }
  
  private f d(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(158507);
    this.kbp.c(paramInt, paramDouble);
    AppMethodBeat.o(158507);
    return this;
  }
  
  private f jdMethod_do(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(158508);
    this.kbp.dn(paramInt1, paramInt2);
    AppMethodBeat.o(158508);
    return this;
  }
  
  private f eO(boolean paramBoolean)
  {
    AppMethodBeat.i(158501);
    this.kbp.eN(paramBoolean);
    AppMethodBeat.o(158501);
    return this;
  }
  
  private f k(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(158510);
    this.kbp.j(paramInt, paramObject);
    AppMethodBeat.o(158510);
    return this;
  }
  
  private f l(double paramDouble)
  {
    AppMethodBeat.i(158502);
    this.kbp.k(paramDouble);
    AppMethodBeat.o(158502);
    return this;
  }
  
  private f su(int paramInt)
  {
    AppMethodBeat.i(158503);
    this.kbp.sp(paramInt);
    AppMethodBeat.o(158503);
    return this;
  }
  
  private f sw(int paramInt)
  {
    AppMethodBeat.i(158531);
    f localf = new f(this.kbp.sr(paramInt));
    AppMethodBeat.o(158531);
    return localf;
  }
  
  private f w(int paramInt, long paramLong)
  {
    AppMethodBeat.i(158509);
    this.kbp.v(paramInt, paramLong);
    AppMethodBeat.o(158509);
    return this;
  }
  
  public final f bv(Object paramObject)
  {
    AppMethodBeat.i(158505);
    this.kbp.bu(paramObject);
    AppMethodBeat.o(158505);
    return this;
  }
  
  public final Object get(int paramInt)
  {
    AppMethodBeat.i(158512);
    Object localObject = this.kbp.get(paramInt);
    AppMethodBeat.o(158512);
    return localObject;
  }
  
  public final boolean getBoolean(int paramInt)
  {
    AppMethodBeat.i(158515);
    boolean bool = this.kbp.getBoolean(paramInt);
    AppMethodBeat.o(158515);
    return bool;
  }
  
  public final double getDouble(int paramInt)
  {
    AppMethodBeat.i(158518);
    double d = this.kbp.getDouble(paramInt);
    AppMethodBeat.o(158518);
    return d;
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(158521);
    paramInt = this.kbp.getInt(paramInt);
    AppMethodBeat.o(158521);
    return paramInt;
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(158524);
    long l = this.kbp.getLong(paramInt);
    AppMethodBeat.o(158524);
    return l;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(158527);
    String str = this.kbp.getString(paramInt);
    AppMethodBeat.o(158527);
    return str;
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(158511);
    boolean bool = this.kbp.isNull(paramInt);
    AppMethodBeat.o(158511);
    return bool;
  }
  
  public final int length()
  {
    AppMethodBeat.i(158500);
    int i = this.kbp.length();
    AppMethodBeat.o(158500);
    return i;
  }
  
  public final Object opt(int paramInt)
  {
    AppMethodBeat.i(158513);
    Object localObject = this.kbp.opt(paramInt);
    AppMethodBeat.o(158513);
    return localObject;
  }
  
  public final boolean optBoolean(int paramInt)
  {
    AppMethodBeat.i(158516);
    boolean bool = this.kbp.optBoolean(paramInt);
    AppMethodBeat.o(158516);
    return bool;
  }
  
  public final boolean optBoolean(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(158517);
    paramBoolean = this.kbp.optBoolean(paramInt, paramBoolean);
    AppMethodBeat.o(158517);
    return paramBoolean;
  }
  
  public final double optDouble(int paramInt)
  {
    AppMethodBeat.i(158519);
    double d = this.kbp.optDouble(paramInt);
    AppMethodBeat.o(158519);
    return d;
  }
  
  public final double optDouble(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(158520);
    paramDouble = this.kbp.optDouble(paramInt, paramDouble);
    AppMethodBeat.o(158520);
    return paramDouble;
  }
  
  public final int optInt(int paramInt)
  {
    AppMethodBeat.i(158522);
    paramInt = this.kbp.optInt(paramInt);
    AppMethodBeat.o(158522);
    return paramInt;
  }
  
  public final int optInt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(158523);
    paramInt1 = this.kbp.optInt(paramInt1, paramInt2);
    AppMethodBeat.o(158523);
    return paramInt1;
  }
  
  public final long optLong(int paramInt)
  {
    AppMethodBeat.i(158525);
    long l = this.kbp.optLong(paramInt);
    AppMethodBeat.o(158525);
    return l;
  }
  
  public final long optLong(int paramInt, long paramLong)
  {
    AppMethodBeat.i(158526);
    paramLong = this.kbp.optLong(paramInt, paramLong);
    AppMethodBeat.o(158526);
    return paramLong;
  }
  
  public final String optString(int paramInt)
  {
    AppMethodBeat.i(158528);
    String str = this.kbp.optString(paramInt);
    AppMethodBeat.o(158528);
    return str;
  }
  
  public final String optString(int paramInt, String paramString)
  {
    AppMethodBeat.i(158529);
    paramString = this.kbp.optString(paramInt, paramString);
    AppMethodBeat.o(158529);
    return paramString;
  }
  
  public final Object remove(int paramInt)
  {
    AppMethodBeat.i(158514);
    Object localObject = this.kbp.remove(paramInt);
    AppMethodBeat.o(158514);
    return localObject;
  }
  
  public final f sv(int paramInt)
  {
    AppMethodBeat.i(158530);
    f localf = new f(this.kbp.sq(paramInt));
    AppMethodBeat.o(158530);
    return localf;
  }
  
  public final i sx(int paramInt)
  {
    AppMethodBeat.i(158532);
    i locali = new i(this.kbp.ss(paramInt));
    AppMethodBeat.o(158532);
    return locali;
  }
  
  public final i sy(int paramInt)
  {
    AppMethodBeat.i(158533);
    i locali = new i(this.kbp.st(paramInt));
    AppMethodBeat.o(158533);
    return locali;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(158534);
    String str = this.kbp.toString();
    AppMethodBeat.o(158534);
    return str;
  }
  
  public final String toString(int paramInt)
  {
    AppMethodBeat.i(158535);
    String str = this.kbp.toString(paramInt);
    AppMethodBeat.o(158535);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ad.f
 * JD-Core Version:    0.7.0.1
 */