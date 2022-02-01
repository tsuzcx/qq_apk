package midas.x;

import com.tencent.midas.comm.APLog;

public class hr
{
  public static hv a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createWebPage name = ");
    localStringBuilder.append(paramString);
    APLog.d("APPageFactory", localStringBuilder.toString());
    if (hj.v.equals(paramString)) {
      return new ib();
    }
    if (hj.w.equals(paramString)) {
      return new if();
    }
    if (hj.y.equals(paramString)) {
      return new ia();
    }
    if (hj.A.equals(paramString)) {
      return new hw();
    }
    if (hj.z.equals(paramString)) {
      return new hy();
    }
    if (hj.B.equals(paramString)) {
      return new ie();
    }
    if (hj.C.equals(paramString)) {
      return new hz();
    }
    if (hj.D.equals(paramString)) {}
    for (paramString = new hx(paramString);; paramString = new hx(paramString))
    {
      return paramString;
      if (!hj.E.equals(paramString)) {
        break;
      }
    }
    if (hj.F.equals(paramString)) {
      return new id();
    }
    return null;
  }
  
  public static ig b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createX5WebPage name = ");
    localStringBuilder.append(paramString);
    APLog.d("APPageFactory", localStringBuilder.toString());
    if (hj.v.equals(paramString)) {
      return new im();
    }
    if (hj.w.equals(paramString)) {
      return new ip();
    }
    if (hj.y.equals(paramString)) {
      return new il();
    }
    if (hj.A.equals(paramString)) {
      return new ih();
    }
    if (hj.z.equals(paramString)) {
      return new ij();
    }
    if (hj.B.equals(paramString)) {
      return new io();
    }
    if (hj.C.equals(paramString)) {
      return new ik();
    }
    if (hj.D.equals(paramString)) {}
    for (paramString = new ii(paramString);; paramString = new ii(paramString))
    {
      return paramString;
      if (!hj.E.equals(paramString)) {
        break;
      }
    }
    if (hj.F.equals(paramString)) {
      return new in();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.hr
 * JD-Core Version:    0.7.0.1
 */