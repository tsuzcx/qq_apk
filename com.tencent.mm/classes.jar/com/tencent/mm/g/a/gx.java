package com.tencent.mm.g.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.List;

public final class gx
  extends b
{
  public a dub;
  public b duc;
  
  public gx()
  {
    this((byte)0);
  }
  
  private gx(byte paramByte)
  {
    AppMethodBeat.i(127405);
    this.dub = new a();
    this.duc = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(127405);
  }
  
  public static final class a
  {
    public Context context;
    public String desc;
    public long doH;
    public akn doN;
    public n dpw;
    public ajx dud;
    public Intent due;
    public k.a duf;
    public Runnable dug;
    public String duh;
    public int dui = 0;
    public int duj = 0;
    public String duk;
    public String dul;
    public akp dum;
    public aq handler;
    public String path;
    public String title;
    public String toUser;
    public int type = 0;
  }
  
  public static final class b
  {
    public List bzf;
    public akc dun;
    public e duo;
    public List dup;
    public boolean duq = false;
    public boolean dur = false;
    public boolean dus = false;
    public double dut = 0.0D;
    public String duu;
    public String path;
    public int ret = -1;
    public String thumbPath;
    public String thumbUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.gx
 * JD-Core Version:    0.7.0.1
 */