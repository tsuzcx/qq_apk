package com.tencent.mapsdk.core.components.protocol.jce.sso;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.k;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.mapsdk.internal.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class Package
  extends MapJceStruct
  implements Cloneable
{
  static int a;
  static byte[] b;
  static byte[] c;
  static ArrayList<Tag> d;
  public byte[] busiBuff = null;
  public byte cEncodeType = 0;
  public int eCmd = 0;
  public byte[] head = null;
  public int iSeqNo = 0;
  public String sAppId = "";
  public short shVer = 0;
  public String strSubCmd = "";
  public String uin = "";
  public ArrayList<Tag> vTag = null;
  
  static
  {
    AppMethodBeat.i(221281);
    if (!Package.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      e = bool;
      AppMethodBeat.o(221281);
      return;
    }
  }
  
  public Package() {}
  
  public Package(short paramShort, int paramInt1, String paramString1, int paramInt2, byte paramByte, String paramString2, String paramString3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, ArrayList<Tag> paramArrayList)
  {
    this.shVer = paramShort;
    this.eCmd = paramInt1;
    this.strSubCmd = paramString1;
    this.iSeqNo = paramInt2;
    this.cEncodeType = paramByte;
    this.sAppId = paramString2;
    this.uin = paramString3;
    this.head = paramArrayOfByte1;
    this.busiBuff = paramArrayOfByte2;
    this.vTag = paramArrayList;
  }
  
  public final String className()
  {
    return "sosomap.Package";
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(221311);
    localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (e) {}
      localObject1 = new AssertionError();
      AppMethodBeat.o(221311);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(221311);
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(221329);
    paramStringBuilder = new k(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.shVer, "shVer");
    paramStringBuilder.a(this.eCmd, "eCmd");
    paramStringBuilder.a(this.strSubCmd, "strSubCmd");
    paramStringBuilder.a(this.iSeqNo, "iSeqNo");
    paramStringBuilder.a(this.cEncodeType, "cEncodeType");
    paramStringBuilder.a(this.sAppId, "sAppId");
    paramStringBuilder.a(this.uin, "uin");
    paramStringBuilder.a(this.head, "head");
    paramStringBuilder.a(this.busiBuff, "busiBuff");
    paramStringBuilder.a(this.vTag, "vTag");
    AppMethodBeat.o(221329);
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(221333);
    paramStringBuilder = new k(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.shVer, true);
    paramStringBuilder.a(this.eCmd, true);
    paramStringBuilder.a(this.strSubCmd, true);
    paramStringBuilder.a(this.iSeqNo, true);
    paramStringBuilder.a(this.cEncodeType, true);
    paramStringBuilder.a(this.sAppId, true);
    paramStringBuilder.a(this.uin, true);
    paramStringBuilder.a(this.head, true);
    paramStringBuilder.a(this.busiBuff, true);
    paramStringBuilder.a(this.vTag, false);
    AppMethodBeat.o(221333);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(221299);
    if (paramObject == null)
    {
      AppMethodBeat.o(221299);
      return false;
    }
    paramObject = (Package)paramObject;
    if ((q.a(this.shVer, paramObject.shVer)) && (q.a(this.eCmd, paramObject.eCmd)) && (q.a(this.strSubCmd, paramObject.strSubCmd)) && (q.a(this.iSeqNo, paramObject.iSeqNo)) && (q.a(this.cEncodeType, paramObject.cEncodeType)) && (q.a(this.sAppId, paramObject.sAppId)) && (q.a(this.uin, paramObject.uin)) && (q.a(this.head, paramObject.head)) && (q.a(this.busiBuff, paramObject.busiBuff)) && (q.a(this.vTag, paramObject.vTag)))
    {
      AppMethodBeat.o(221299);
      return true;
    }
    AppMethodBeat.o(221299);
    return false;
  }
  
  public final byte[] getBusiBuff()
  {
    return this.busiBuff;
  }
  
  public final byte[] getHead()
  {
    return this.head;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(221305);
    try
    {
      Exception localException1 = new Exception("Need define key first!");
      AppMethodBeat.o(221305);
      throw localException1;
    }
    catch (Exception localException2)
    {
      AppMethodBeat.o(221305);
    }
    return 0;
  }
  
  public final void readFrom(m paramm)
  {
    AppMethodBeat.i(221324);
    this.shVer = paramm.a(this.shVer, 0, true);
    this.eCmd = paramm.a(this.eCmd, 1, true);
    this.strSubCmd = paramm.b(2, true);
    this.iSeqNo = paramm.a(this.iSeqNo, 3, false);
    this.cEncodeType = paramm.a(this.cEncodeType, 4, false);
    this.sAppId = paramm.b(5, false);
    this.uin = paramm.b(6, false);
    Object localObject;
    if (b == null)
    {
      localObject = new byte[1];
      b = (byte[])localObject;
      localObject[0] = 0;
    }
    this.head = paramm.c(7, false);
    if (c == null)
    {
      localObject = new byte[1];
      c = (byte[])localObject;
      localObject[0] = 0;
    }
    this.busiBuff = paramm.c(8, false);
    if (d == null)
    {
      d = new ArrayList();
      localObject = new Tag();
      d.add(localObject);
    }
    this.vTag = ((ArrayList)paramm.a(d, 9, false));
    AppMethodBeat.o(221324);
  }
  
  public final void writeTo(n paramn)
  {
    AppMethodBeat.i(221318);
    paramn.a(this.shVer, 0);
    paramn.a(this.eCmd, 1);
    paramn.a(this.strSubCmd, 2);
    paramn.a(this.iSeqNo, 3);
    paramn.a(this.cEncodeType, 4);
    if (this.sAppId != null) {
      paramn.a(this.sAppId, 5);
    }
    if (this.uin != null) {
      paramn.a(this.uin, 6);
    }
    if (this.head != null) {
      paramn.a(this.head, 7);
    }
    if (this.busiBuff != null) {
      paramn.a(this.busiBuff, 8);
    }
    if (this.vTag != null) {
      paramn.a(this.vTag, 9);
    }
    AppMethodBeat.o(221318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.core.components.protocol.jce.sso.Package
 * JD-Core Version:    0.7.0.1
 */