package com.tencent.g.a.a;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.qq.a.a.c;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d;
import d.e;
import java.util.ArrayList;

public final class a
{
  private static final byte[] ZRp = new byte[1];
  
  public static byte[] a(b paramb, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(208411);
    if ((TextUtils.isEmpty(paramb.uFI)) || (TextUtils.isEmpty(paramb.ZRu)) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(208411);
      return null;
    }
    c localc = new c();
    localc.cT("analytics");
    localc.Kn();
    localc.cS("uploadServer");
    b.a locala = new b.a();
    locala.aamM = 1;
    locala.productId = paramb.uFI;
    locala.aamO = paramb.ZRu;
    locala.sdkId = paramb.ZRv;
    locala.aamQ = paramb.mSdkVersion;
    locala.Vh = 206;
    paramb = f.a.a.a.a.iUq();
    try
    {
      paramb = paramb.zip(paramArrayOfByte);
      if (paramb != null) {
        locala.aamS = 2;
      }
      paramArrayOfByte = new f.a.a.b.a();
      paramArrayOfByte.bHY("*^@K#K@!");
      return paramb;
    }
    catch (Throwable paramb)
    {
      try
      {
        paramb = paramArrayOfByte.dI(paramb);
        if (paramb != null) {
          locala.aamK = 1;
        }
        locala.sBuffer = paramb;
        locala.aamL = (Build.BRAND + "-" + Build.MODEL + ";Android " + Build.VERSION.RELEASE + ",level " + Build.VERSION.SDK_INT);
        locala.qua = "";
        localc.c("detail", locala);
        paramb = localc.Km();
        AppMethodBeat.o(208411);
        return paramb;
      }
      catch (Throwable paramb)
      {
        paramb = ZRp;
        AppMethodBeat.o(208411);
      }
      paramb = paramb;
      paramb = ZRp;
      AppMethodBeat.o(208411);
      return paramb;
    }
  }
  
  public static int bDX(String paramString)
  {
    AppMethodBeat.i(208408);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(208408);
      return -1;
    }
    int i = Math.abs(paramString.hashCode());
    AppMethodBeat.o(208408);
    return i;
  }
  
  public static byte[] bM(ArrayList<d> paramArrayList)
  {
    AppMethodBeat.i(208409);
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      AppMethodBeat.o(208409);
      return null;
    }
    e locale = new e();
    locale.fmA = paramArrayList;
    paramArrayList = new JceOutputStream();
    paramArrayList.setServerEncoding("UTF-8");
    locale.writeTo(paramArrayList);
    paramArrayList = paramArrayList.toByteArray();
    AppMethodBeat.o(208409);
    return paramArrayList;
  }
  
  public static String p(Throwable paramThrowable)
  {
    AppMethodBeat.i(208406);
    if (paramThrowable == null)
    {
      AppMethodBeat.o(208406);
      return "";
    }
    paramThrowable = paramThrowable.getStackTrace();
    if ((paramThrowable == null) || (paramThrowable.length <= 0))
    {
      AppMethodBeat.o(208406);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramThrowable.length)
    {
      Object localObject = paramThrowable[i];
      if (localObject != null)
      {
        localStringBuilder.append(localObject.getClassName());
        localStringBuilder.append("(");
        localStringBuilder.append(localObject.getMethodName());
        localStringBuilder.append(":");
        localStringBuilder.append(localObject.getLineNumber());
        localStringBuilder.append(")");
        localStringBuilder.append("\n");
      }
      i += 1;
    }
    paramThrowable = localStringBuilder.toString();
    AppMethodBeat.o(208406);
    return paramThrowable;
  }
  
  public static final class a
  {
    public String ZRq;
    public String ZRr;
    public long ZRs;
    public String ZRt;
    public String mProcessName;
    public String mThreadName;
  }
  
  public static final class b
  {
    public String ZRu;
    public String ZRv;
    public String mSdkVersion;
    public String uFI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.g.a.a.a
 * JD-Core Version:    0.7.0.1
 */