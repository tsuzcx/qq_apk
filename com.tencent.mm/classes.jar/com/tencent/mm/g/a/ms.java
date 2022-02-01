package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.sdk.b.b;
import java.util.ArrayList;

public final class ms
  extends b
{
  public a drL;
  public b drM;
  
  public ms()
  {
    this((byte)0);
  }
  
  private ms(byte paramByte)
  {
    AppMethodBeat.i(127407);
    this.drL = new a();
    this.drM = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(127407);
  }
  
  public static final class a
  {
    public Context context;
    public String drN;
    public int drO = 0;
    public String drP;
    public String drQ;
    public boolean drR = false;
    public Bundle drS;
    public int drT = 0;
    public int drU = 0;
    public boolean drV = true;
    public agq drW;
    public ago field_favProto;
    public long field_localId = 0L;
    public ArrayList iq;
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
 * Qualified Name:     com.tencent.mm.g.a.ms
 * JD-Core Version:    0.7.0.1
 */