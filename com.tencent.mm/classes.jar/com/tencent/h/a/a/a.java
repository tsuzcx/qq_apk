package com.tencent.h.a.a;

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
  private static final byte[] SpK = new byte[1];
  
  public static byte[] a(b paramb, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(214606);
    if ((TextUtils.isEmpty(paramb.rcD)) || (TextUtils.isEmpty(paramb.SpP)) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(214606);
      return null;
    }
    c localc = new c();
    localc.cz("analytics");
    localc.IK();
    localc.cy("uploadServer");
    b.a locala = new b.a();
    locala.SKS = 1;
    locala.productId = paramb.rcD;
    locala.SKU = paramb.SpP;
    locala.sdkId = paramb.SpQ;
    locala.dfy = paramb.mSdkVersion;
    locala.EX = 206;
    paramb = f.a.a.a.a.hPj();
    try
    {
      paramb = paramb.zip(paramArrayOfByte);
      if (paramb != null) {
        locala.SKX = 2;
      }
      paramArrayOfByte = new f.a.a.b.a();
      paramArrayOfByte.buV("*^@K#K@!");
      return paramb;
    }
    catch (Throwable paramb)
    {
      try
      {
        paramb = paramArrayOfByte.encode(paramb);
        if (paramb != null) {
          locala.SKQ = 1;
        }
        locala.sBuffer = paramb;
        locala.SKR = (Build.BRAND + "-" + Build.MODEL + ";Android " + Build.VERSION.RELEASE + ",level " + Build.VERSION.SDK_INT);
        locala.qua = "";
        localc.put("detail", locala);
        paramb = localc.IJ();
        AppMethodBeat.o(214606);
        return paramb;
      }
      catch (Throwable paramb)
      {
        paramb = SpK;
        AppMethodBeat.o(214606);
      }
      paramb = paramb;
      paramb = SpK;
      AppMethodBeat.o(214606);
      return paramb;
    }
  }
  
  public static byte[] bB(ArrayList<d> paramArrayList)
  {
    AppMethodBeat.i(214605);
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      AppMethodBeat.o(214605);
      return null;
    }
    e locale = new e();
    locale.dtS = paramArrayList;
    paramArrayList = new JceOutputStream();
    paramArrayList.setServerEncoding("UTF-8");
    locale.writeTo(paramArrayList);
    paramArrayList = paramArrayList.toByteArray();
    AppMethodBeat.o(214605);
    return paramArrayList;
  }
  
  public static int bqY(String paramString)
  {
    AppMethodBeat.i(214604);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(214604);
      return -1;
    }
    int i = Math.abs(paramString.hashCode());
    AppMethodBeat.o(214604);
    return i;
  }
  
  public static String p(Throwable paramThrowable)
  {
    AppMethodBeat.i(214603);
    if (paramThrowable == null)
    {
      AppMethodBeat.o(214603);
      return "";
    }
    paramThrowable = paramThrowable.getStackTrace();
    if ((paramThrowable == null) || (paramThrowable.length <= 0))
    {
      AppMethodBeat.o(214603);
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
    AppMethodBeat.o(214603);
    return paramThrowable;
  }
  
  public static final class a
  {
    public String SpL;
    public String SpM;
    public long SpN;
    public String SpO;
    public String mProcessName;
    public String mThreadName;
  }
  
  public static final class b
  {
    public String SpP;
    public String SpQ;
    public String mSdkVersion;
    public String rcD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.h.a.a.a
 * JD-Core Version:    0.7.0.1
 */