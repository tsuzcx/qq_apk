package midas.x;

import com.tencent.midas.comm.APLog;

public class ic
{
  public static ig a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createWebPage name = ");
    localStringBuilder.append(paramString);
    APLog.d("APPageFactory", localStringBuilder.toString());
    if (hu.v.equals(paramString)) {
      return new im();
    }
    if (hu.w.equals(paramString)) {
      return new iq();
    }
    if (hu.y.equals(paramString)) {
      return new il();
    }
    if (hu.A.equals(paramString)) {
      return new ih();
    }
    if (hu.z.equals(paramString)) {
      return new ij();
    }
    if (hu.B.equals(paramString)) {
      return new ip();
    }
    if (hu.C.equals(paramString)) {
      return new ik();
    }
    if (hu.D.equals(paramString)) {
      return new ii();
    }
    if (hu.E.equals(paramString)) {
      return new io();
    }
    return null;
  }
  
  public static ir b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createX5WebPage name = ");
    localStringBuilder.append(paramString);
    APLog.d("APPageFactory", localStringBuilder.toString());
    if (hu.v.equals(paramString)) {
      return new ix();
    }
    if (hu.w.equals(paramString)) {
      return new ja();
    }
    if (hu.y.equals(paramString)) {
      return new iw();
    }
    if (hu.A.equals(paramString)) {
      return new is();
    }
    if (hu.z.equals(paramString)) {
      return new iu();
    }
    if (hu.B.equals(paramString)) {
      return new iz();
    }
    if (hu.C.equals(paramString)) {
      return new iv();
    }
    if (hu.D.equals(paramString)) {
      return new it();
    }
    if (hu.E.equals(paramString)) {
      return new iy();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ic
 * JD-Core Version:    0.7.0.1
 */