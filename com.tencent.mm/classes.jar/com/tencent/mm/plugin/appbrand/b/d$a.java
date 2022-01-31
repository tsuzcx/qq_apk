package com.tencent.mm.plugin.appbrand.b;

import android.os.Message;

final class d$a
  extends g
{
  d$a(d paramd, i parami, com.tencent.mm.plugin.appbrand.i parami1)
  {
    super(parami, parami1);
  }
  
  final void acB()
  {
    if (this.fGa.csl() == this)
    {
      d.a(this.fGa, this.fGa.fFT);
      this.fGa.ku(1000);
    }
  }
  
  public final void enter()
  {
    super.enter();
  }
  
  public final void exit()
  {
    super.exit();
  }
  
  public final boolean g(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return super.g(paramMessage);
    case 3: 
      d.a(this.fGa, this.fGa.fFQ);
      return true;
    }
    super.kv(16);
    return true;
  }
  
  public final String getName()
  {
    return this.fGa.mName + "|Background";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.d.a
 * JD-Core Version:    0.7.0.1
 */