package com.tencent.mm.ipcinvoker.extension;

import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.e.a;
import com.tencent.mm.ipcinvoker.e.b;

final class XIPCInvoker$b
  implements c, a
{
  c<XIPCInvoker.WrapperParcelable> dHg;
  a dHh;
  
  XIPCInvoker$b(c<XIPCInvoker.WrapperParcelable> paramc)
  {
    this.dHg = paramc;
    if ((paramc instanceof a)) {
      this.dHh = ((a)paramc);
    }
  }
  
  public final void U(Object paramObject)
  {
    if (this.dHg != null) {
      this.dHg.U(new XIPCInvoker.WrapperParcelable(null, paramObject));
    }
  }
  
  public final void a(b paramb)
  {
    if (this.dHh == null) {
      return;
    }
    this.dHh.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.XIPCInvoker.b
 * JD-Core Version:    0.7.0.1
 */