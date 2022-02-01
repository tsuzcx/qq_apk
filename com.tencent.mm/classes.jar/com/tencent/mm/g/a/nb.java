package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.sdk.b.b;
import java.util.ArrayList;

public final class nb
  extends b
{
  public a dpw;
  public b dpx;
  
  public nb()
  {
    this((byte)0);
  }
  
  private nb(byte paramByte)
  {
    AppMethodBeat.i(127407);
    this.dpw = new a();
    this.dpx = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(127407);
  }
  
  public static final class a
  {
    public Context context;
    public String dpA;
    public String dpB;
    public boolean dpC = false;
    public Bundle dpD;
    public int dpE = 0;
    public int dpF = 0;
    public boolean dpG = true;
    public ahp dpH;
    public String dpy;
    public int dpz = 0;
    public ahn field_favProto;
    public long field_localId = 0L;
    public ArrayList jq;
    public String path;
    public int type = 0;
  }
  
  public static final class b
  {
    public String path;
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.nb
 * JD-Core Version:    0.7.0.1
 */