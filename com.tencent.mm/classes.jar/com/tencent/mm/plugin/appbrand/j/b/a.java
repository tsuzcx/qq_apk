package com.tencent.mm.plugin.appbrand.j.b;

import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell.a;
import com.tencent.mm.plugin.appbrand.debugger.b;
import com.tencent.mm.plugin.appbrand.debugger.c;
import com.tencent.mm.plugin.appbrand.debugger.d;
import com.tencent.mm.plugin.appbrand.debugger.f;
import com.tencent.mm.plugin.appbrand.debugger.g;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements d
{
  private static final List<DebuggerShell.a> gMQ;
  
  static
  {
    LinkedList localLinkedList = new LinkedList();
    gMQ = localLinkedList;
    localLinkedList.add(new b());
    gMQ.add(new c());
    gMQ.add(new f());
    gMQ.add(new g());
  }
  
  public final List<DebuggerShell.a> aey()
  {
    return gMQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.b.a
 * JD-Core Version:    0.7.0.1
 */