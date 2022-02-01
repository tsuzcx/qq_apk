package com.tencent.mobileqq.msf.core.net;

import java.util.ArrayList;
import java.util.Iterator;

class j
  extends Thread
{
  j(h paramh) {}
  
  public void run()
  {
    Iterator localIterator = this.a.t.iterator();
    while (localIterator.hasNext()) {
      ((h.a)localIterator.next()).a();
    }
    this.a.u.addAll(this.a.t);
    this.a.t.clear();
    this.a.v = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.j
 * JD-Core Version:    0.7.0.1
 */