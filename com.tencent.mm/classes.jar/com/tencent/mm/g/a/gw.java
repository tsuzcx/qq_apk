package com.tencent.mm.g.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajs;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.List;

public final class gw
  extends b
{
  public a dsV;
  public b dsW;
  
  public gw()
  {
    this((byte)0);
  }
  
  private gw(byte paramByte)
  {
    AppMethodBeat.i(127405);
    this.dsV = new a();
    this.dsW = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(127405);
  }
  
  public static final class a
  {
    public Context context;
    public String desc;
    public long dnC;
    public akd dnI;
    public n dor;
    public ajn dsX;
    public Intent dsY;
    public k.a dsZ;
    public Runnable dta;
    public String dtb;
    public int dtc = 0;
    public int dtd = 0;
    public String dte;
    public String dtf;
    public akf dtg;
    public ap handler;
    public String path;
    public String title;
    public String toUser;
    public int type = 0;
  }
  
  public static final class b
  {
    public List bzf;
    public ajs dth;
    public e dti;
    public List dtj;
    public boolean dtk = false;
    public boolean dtl = false;
    public boolean dtm = false;
    public double dtn = 0.0D;
    public String dto;
    public String path;
    public int ret = -1;
    public String thumbPath;
    public String thumbUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.gw
 * JD-Core Version:    0.7.0.1
 */