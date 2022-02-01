package com.tencent.mapsdk.core.components.protocol.jce.sso;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.k;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.mapsdk.internal.q;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CmdResult
  extends MapJceStruct
  implements Cloneable
{
  public int iErrCode = 0;
  public int iSubErrCode = 0;
  public String strErrDesc = "";
  
  static
  {
    AppMethodBeat.i(221277);
    if (!CmdResult.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      AppMethodBeat.o(221277);
      return;
    }
  }
  
  public CmdResult() {}
  
  public CmdResult(int paramInt1, String paramString, int paramInt2)
  {
    this.iErrCode = paramInt1;
    this.strErrDesc = paramString;
    this.iSubErrCode = paramInt2;
  }
  
  public final String className()
  {
    return "sosomap.CmdResult";
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(221297);
    localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (a) {}
      localObject1 = new AssertionError();
      AppMethodBeat.o(221297);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(221297);
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(221316);
    paramStringBuilder = new k(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.iErrCode, "iErrCode");
    paramStringBuilder.a(this.strErrDesc, "strErrDesc");
    paramStringBuilder.a(this.iSubErrCode, "iSubErrCode");
    AppMethodBeat.o(221316);
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(221322);
    paramStringBuilder = new k(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.iErrCode, true);
    paramStringBuilder.a(this.strErrDesc, true);
    paramStringBuilder.a(this.iSubErrCode, false);
    AppMethodBeat.o(221322);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(221286);
    if (paramObject == null)
    {
      AppMethodBeat.o(221286);
      return false;
    }
    paramObject = (CmdResult)paramObject;
    if ((q.a(this.iErrCode, paramObject.iErrCode)) && (q.a(this.strErrDesc, paramObject.strErrDesc)) && (q.a(this.iSubErrCode, paramObject.iSubErrCode)))
    {
      AppMethodBeat.o(221286);
      return true;
    }
    AppMethodBeat.o(221286);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(221291);
    try
    {
      Exception localException1 = new Exception("Need define key first!");
      AppMethodBeat.o(221291);
      throw localException1;
    }
    catch (Exception localException2)
    {
      AppMethodBeat.o(221291);
    }
    return 0;
  }
  
  public final void readFrom(m paramm)
  {
    AppMethodBeat.i(221310);
    this.iErrCode = paramm.a(this.iErrCode, 0, true);
    this.strErrDesc = paramm.b(1, true);
    this.iSubErrCode = paramm.a(this.iSubErrCode, 2, false);
    AppMethodBeat.o(221310);
  }
  
  public final void writeTo(n paramn)
  {
    AppMethodBeat.i(221303);
    paramn.a(this.iErrCode, 0);
    paramn.a(this.strErrDesc, 1);
    paramn.a(this.iSubErrCode, 2);
    AppMethodBeat.o(221303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.core.components.protocol.jce.sso.CmdResult
 * JD-Core Version:    0.7.0.1
 */