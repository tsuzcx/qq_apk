package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.plugin.exdevice.model.c;

public final class u
{
  private static u jzg = null;
  private c jzh;
  private f jzi;
  
  public static void a(m paramm)
  {
    aMn().jtr = paramm;
  }
  
  private static u aMl()
  {
    if (jzg == null) {
      jzg = new u();
    }
    return jzg;
  }
  
  public static f aMm()
  {
    if (aMl().jzi == null) {
      aMl().jzi = new f();
    }
    return aMl().jzi;
  }
  
  public static c aMn()
  {
    if (aMl().jzh == null)
    {
      u localu = aMl();
      if (c.jtq == null) {
        c.jtq = new c();
      }
      localu.jzh = c.jtq;
    }
    return aMl().jzh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.u
 * JD-Core Version:    0.7.0.1
 */