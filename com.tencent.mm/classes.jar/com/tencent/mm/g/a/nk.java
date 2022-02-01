package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.sdk.b.b;
import java.util.ArrayList;

public final class nk
  extends b
{
  public a dCo;
  public b dCp;
  
  public nk()
  {
    this((byte)0);
  }
  
  private nk(byte paramByte)
  {
    AppMethodBeat.i(127407);
    this.dCo = new a();
    this.dCp = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(127407);
  }
  
  public static final class a
  {
    public Context context;
    public String dCq;
    public int dCr = 0;
    public String dCs;
    public String dCt;
    public boolean dCu = false;
    public Bundle dCv;
    public int dCw = 0;
    public int dCx = 0;
    public boolean dCy = true;
    public akp dCz;
    public akn field_favProto;
    public long field_localId = 0L;
    public ArrayList lh;
    public String path;
    public int type = 0;
  }
  
  public static final class b
  {
    public String path;
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.nk
 * JD-Core Version:    0.7.0.1
 */