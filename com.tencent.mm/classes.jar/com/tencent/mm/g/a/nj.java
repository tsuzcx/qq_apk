package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.sdk.b.b;
import java.util.ArrayList;

public final class nj
  extends b
{
  public a dBj;
  public b dBk;
  
  public nj()
  {
    this((byte)0);
  }
  
  private nj(byte paramByte)
  {
    AppMethodBeat.i(127407);
    this.dBj = new a();
    this.dBk = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(127407);
  }
  
  public static final class a
  {
    public Context context;
    public String dBl;
    public int dBm = 0;
    public String dBn;
    public String dBo;
    public boolean dBp = false;
    public Bundle dBq;
    public int dBr = 0;
    public int dBs = 0;
    public boolean dBt = true;
    public akf dBu;
    public akd field_favProto;
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
 * Qualified Name:     com.tencent.mm.g.a.nj
 * JD-Core Version:    0.7.0.1
 */