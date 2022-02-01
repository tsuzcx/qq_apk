package com.tencent.mobileqq.msf.core.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.msf.core.c;
import com.tencent.mobileqq.msf.sdk.CommandCallbackerInfo;
import com.tencent.mobileqq.msf.sdk.NotifyRegisterInfo;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.qphone.base.util.BaseApplication;

public final class a
  extends JceStruct
{
  static PushRegisterInfo o;
  static NotifyRegisterInfo p;
  static CommandCallbackerInfo q;
  public int a = 0;
  public String b = "";
  public long c = 0L;
  public long d = 0L;
  public long e = 0L;
  public long f = 0L;
  public long g = 0L;
  public long h = 0L;
  public String i = "";
  public String j = "";
  public PushRegisterInfo k = null;
  public NotifyRegisterInfo l = null;
  public CommandCallbackerInfo m = null;
  public String n = "";
  
  public a() {}
  
  public a(int paramInt, String paramString1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, String paramString2, String paramString3, PushRegisterInfo paramPushRegisterInfo, NotifyRegisterInfo paramNotifyRegisterInfo, CommandCallbackerInfo paramCommandCallbackerInfo, String paramString4)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = paramLong3;
    this.f = paramLong4;
    this.g = paramLong5;
    this.h = paramLong6;
    this.i = paramString2;
    this.j = paramString3;
    this.k = paramPushRegisterInfo;
    this.l = paramNotifyRegisterInfo;
    this.m = paramCommandCallbackerInfo;
    this.n = paramString4;
  }
  
  public a(String paramString)
  {
    this.b = paramString;
    this.n = ("" + c.e(BaseApplication.getContext()));
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 1, true);
    this.b = paramJceInputStream.readString(2, true);
    this.c = paramJceInputStream.read(this.c, 3, true);
    this.d = paramJceInputStream.read(this.d, 4, true);
    this.e = paramJceInputStream.read(this.e, 5, false);
    this.f = paramJceInputStream.read(this.f, 6, false);
    this.g = paramJceInputStream.read(this.g, 7, false);
    this.h = paramJceInputStream.read(this.h, 8, false);
    this.i = paramJceInputStream.readString(9, false);
    this.j = paramJceInputStream.readString(10, false);
    if (o == null) {
      o = new PushRegisterInfo();
    }
    this.k = ((PushRegisterInfo)paramJceInputStream.read(o, 11, false));
    if (p == null) {
      p = new NotifyRegisterInfo();
    }
    this.l = ((NotifyRegisterInfo)paramJceInputStream.read(p, 12, false));
    if (q == null) {
      q = new CommandCallbackerInfo();
    }
    this.m = ((CommandCallbackerInfo)paramJceInputStream.read(q, 13, false));
    this.n = paramJceInputStream.readString(14, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
    paramJceOutputStream.write(this.c, 3);
    paramJceOutputStream.write(this.d, 4);
    paramJceOutputStream.write(this.e, 5);
    paramJceOutputStream.write(this.f, 6);
    paramJceOutputStream.write(this.g, 7);
    paramJceOutputStream.write(this.h, 8);
    if (this.i != null) {
      paramJceOutputStream.write(this.i, 9);
    }
    if (this.j != null) {
      paramJceOutputStream.write(this.j, 10);
    }
    if (this.k != null) {
      paramJceOutputStream.write(this.k, 11);
    }
    if (this.l != null) {
      paramJceOutputStream.write(this.l, 12);
    }
    if (this.m != null) {
      paramJceOutputStream.write(this.m, 13);
    }
    if (this.n != null) {
      paramJceOutputStream.write(this.n, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.push.a
 * JD-Core Version:    0.7.0.1
 */