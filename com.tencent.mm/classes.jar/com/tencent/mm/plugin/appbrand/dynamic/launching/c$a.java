package com.tencent.mm.plugin.appbrand.dynamic.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c$a
{
  static
  {
    AppMethodBeat.i(10926);
    hqj = new a("Ok", 0);
    hqk = new a("Fail", 1);
    hql = new a("Timeout", 2);
    hqm = new a("CgiFail", 3);
    hqn = new a("ResponseInvalid", 4);
    hqo = new a("AwaitFail", 5);
    hqp = new a[] { hqj, hqk, hql, hqm, hqn, hqo };
    AppMethodBeat.o(10926);
  }
  
  private c$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.c.a
 * JD-Core Version:    0.7.0.1
 */