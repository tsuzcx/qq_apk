package com.tencent.mm.f.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.event.IEvent;
import java.util.ArrayList;

public final class oz
  extends IEvent
{
  public a fNG;
  public b fNH;
  
  public oz()
  {
    this((byte)0);
  }
  
  private oz(byte paramByte)
  {
    AppMethodBeat.i(127407);
    this.fNG = new a();
    this.fNH = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127407);
  }
  
  public static final class a
  {
    public ArrayList bCM;
    public Context context;
    public String fNI;
    public int fNJ = 0;
    public String fNK;
    public String fNL;
    public boolean fNM = false;
    public Bundle fNN;
    public int fNO = 0;
    public int fNP = 0;
    public boolean fNQ = true;
    public aoe fNR;
    public aoc field_favProto;
    public long field_localId = 0L;
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
 * Qualified Name:     com.tencent.mm.f.a.oz
 * JD-Core Version:    0.7.0.1
 */