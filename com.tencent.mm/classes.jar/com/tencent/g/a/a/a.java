package com.tencent.g.a.a;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.qq.a.a.c;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.matrix.trace.core.AppMethodBeat;
import e.d;
import e.e;
import java.util.ArrayList;

public final class a
{
  private static final byte[] ahVK = new byte[1];
  
  public static String F(Throwable paramThrowable)
  {
    AppMethodBeat.i(212075);
    if (paramThrowable == null)
    {
      AppMethodBeat.o(212075);
      return "";
    }
    paramThrowable = paramThrowable.getStackTrace();
    if ((paramThrowable == null) || (paramThrowable.length <= 0))
    {
      AppMethodBeat.o(212075);
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
    AppMethodBeat.o(212075);
    return paramThrowable;
  }
  
  public static byte[] a(b paramb, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212093);
    if ((TextUtils.isEmpty(paramb.xOk)) || (TextUtils.isEmpty(paramb.ahVP)) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(212093);
      return null;
    }
    c localc = new c();
    localc.en("analytics");
    localc.ako();
    localc.em("uploadServer");
    b.a locala = new b.a();
    locala.aitb = 1;
    locala.productId = paramb.xOk;
    locala.aitd = paramb.ahVP;
    locala.sdkId = paramb.ahVQ;
    locala.aitf = paramb.ahVR;
    locala.bUl = 206;
    paramb = h.a.a.a.a.kFR();
    try
    {
      paramb = paramb.zip(paramArrayOfByte);
      if (paramb != null) {
        locala.aith = 2;
      }
      paramArrayOfByte = new h.a.a.b.a();
      paramArrayOfByte.bKc("*^@K#K@!");
      return paramb;
    }
    finally
    {
      try
      {
        paramb = paramArrayOfByte.dL(paramb);
        if (paramb != null) {
          locala.aisZ = 1;
        }
        locala.sBuffer = paramb;
        locala.aita = (Build.BRAND + "-" + Build.MODEL + ";Android " + Build.VERSION.RELEASE + ",level " + Build.VERSION.SDK_INT);
        locala.qua = "";
        localc.j("detail", locala);
        paramb = localc.akn();
        AppMethodBeat.o(212093);
        return paramb;
      }
      finally
      {
        paramb = ahVK;
        AppMethodBeat.o(212093);
      }
      paramb = finally;
      paramb = ahVK;
      AppMethodBeat.o(212093);
      return paramb;
    }
  }
  
  public static int bGw(String paramString)
  {
    AppMethodBeat.i(212079);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(212079);
      return -1;
    }
    int i = Math.abs(paramString.hashCode());
    AppMethodBeat.o(212079);
    return i;
  }
  
  public static byte[] cm(ArrayList<d> paramArrayList)
  {
    AppMethodBeat.i(212087);
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      AppMethodBeat.o(212087);
      return null;
    }
    e locale = new e();
    locale.hqL = paramArrayList;
    paramArrayList = new JceOutputStream();
    paramArrayList.setServerEncoding("UTF-8");
    locale.writeTo(paramArrayList);
    paramArrayList = paramArrayList.toByteArray();
    AppMethodBeat.o(212087);
    return paramArrayList;
  }
  
  public static final class a
  {
    public String ahVL;
    public String ahVM;
    public long ahVN;
    public String ahVO;
    public String mProcessName;
    public String mThreadName;
  }
  
  public static final class b
  {
    public String ahVP;
    public String ahVQ;
    public String ahVR;
    public String xOk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.g.a.a.a
 * JD-Core Version:    0.7.0.1
 */