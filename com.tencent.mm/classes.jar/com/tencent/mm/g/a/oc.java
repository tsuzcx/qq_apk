package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.event.IEvent;
import java.util.ArrayList;

public final class oc
  extends IEvent
{
  public a dUe;
  public b dUf;
  
  public oc()
  {
    this((byte)0);
  }
  
  private oc(byte paramByte)
  {
    AppMethodBeat.i(127407);
    this.dUe = new a();
    this.dUf = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127407);
  }
  
  public static final class a
  {
    public Context context;
    public String dUg;
    public int dUh = 0;
    public String dUi;
    public String dUj;
    public boolean dUk = false;
    public Bundle dUl;
    public int dUm = 0;
    public int dUn = 0;
    public boolean dUo = true;
    public and dUp;
    public anb field_favProto;
    public long field_localId = 0L;
    public ArrayList lj;
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
 * Qualified Name:     com.tencent.mm.g.a.oc
 * JD-Core Version:    0.7.0.1
 */