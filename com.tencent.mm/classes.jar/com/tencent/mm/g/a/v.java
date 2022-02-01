package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.d;

public final class v
{
  public a cZg;
  public b cZh;
  public Runnable callback;
  
  public v()
  {
    this((byte)0);
  }
  
  private v(byte paramByte)
  {
    AppMethodBeat.i(136972);
    this.callback = null;
    this.cZg = new a();
    this.cZh = new b();
    this.callback = null;
    AppMethodBeat.o(136972);
  }
  
  public static final class a
  {
    public int action;
    public String appId;
    public String cQO;
    public int cZi;
    public b cZj;
    public a cZk;
    public String processName;
  }
  
  public static final class b
  {
    public d cZl;
    public int count;
    public boolean result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.v
 * JD-Core Version:    0.7.0.1
 */