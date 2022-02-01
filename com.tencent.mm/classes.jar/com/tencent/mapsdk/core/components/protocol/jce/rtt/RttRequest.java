package com.tencent.mapsdk.core.components.protocol.jce.rtt;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.k;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.mapsdk.internal.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class RttRequest
  extends MapJceStruct
  implements Cloneable
{
  static ArrayList<Integer> a;
  public ArrayList<Integer> bounds = null;
  public short zip = 0;
  public short zoom = 0;
  
  static
  {
    AppMethodBeat.i(221214);
    if (!RttRequest.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      a = new ArrayList();
      a.add(Integer.valueOf(0));
      AppMethodBeat.o(221214);
      return;
    }
  }
  
  public RttRequest() {}
  
  public RttRequest(ArrayList<Integer> paramArrayList, short paramShort1, short paramShort2)
  {
    this.bounds = paramArrayList;
    this.zoom = paramShort1;
    this.zip = paramShort2;
  }
  
  public final String className()
  {
    return "navsns.RttRequest";
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(221279);
    localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (b) {}
      localObject1 = new AssertionError();
      AppMethodBeat.o(221279);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(221279);
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(221295);
    paramStringBuilder = new k(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.bounds, "bounds");
    paramStringBuilder.a(this.zoom, "zoom");
    paramStringBuilder.a(this.zip, "zip");
    AppMethodBeat.o(221295);
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(221302);
    paramStringBuilder = new k(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.bounds, true);
    paramStringBuilder.a(this.zoom, true);
    paramStringBuilder.a(this.zip, false);
    AppMethodBeat.o(221302);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(221270);
    if (paramObject == null)
    {
      AppMethodBeat.o(221270);
      return false;
    }
    paramObject = (RttRequest)paramObject;
    if ((q.a(this.bounds, paramObject.bounds)) && (q.a(this.zoom, paramObject.zoom)) && (q.a(this.zip, paramObject.zip)))
    {
      AppMethodBeat.o(221270);
      return true;
    }
    AppMethodBeat.o(221270);
    return false;
  }
  
  public final ArrayList<Integer> getBounds()
  {
    return this.bounds;
  }
  
  public final short getZip()
  {
    return this.zip;
  }
  
  public final short getZoom()
  {
    return this.zoom;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(221273);
    try
    {
      Exception localException1 = new Exception("Need define key first!");
      AppMethodBeat.o(221273);
      throw localException1;
    }
    catch (Exception localException2)
    {
      AppMethodBeat.o(221273);
    }
    return 0;
  }
  
  public final void readFrom(m paramm)
  {
    AppMethodBeat.i(221289);
    this.bounds = ((ArrayList)paramm.a(a, 0, true));
    this.zoom = paramm.a(this.zoom, 1, true);
    this.zip = paramm.a(this.zip, 2, true);
    AppMethodBeat.o(221289);
  }
  
  public final void setBounds(ArrayList<Integer> paramArrayList)
  {
    this.bounds = paramArrayList;
  }
  
  public final void setZip(short paramShort)
  {
    this.zip = paramShort;
  }
  
  public final void setZoom(short paramShort)
  {
    this.zoom = paramShort;
  }
  
  public final void writeTo(n paramn)
  {
    AppMethodBeat.i(221284);
    paramn.a(this.bounds, 0);
    paramn.a(this.zoom, 1);
    paramn.a(this.zip, 2);
    AppMethodBeat.o(221284);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.core.components.protocol.jce.rtt.RttRequest
 * JD-Core Version:    0.7.0.1
 */