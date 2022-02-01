package com.tencent.mm.autogen.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.sdk.event.IEvent;
import java.util.ArrayList;

public final class ql
  extends IEvent
{
  public a hTy;
  public b hTz;
  
  public ql()
  {
    this((byte)0);
  }
  
  private ql(byte paramByte)
  {
    AppMethodBeat.i(127407);
    this.hTy = new a();
    this.hTz = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127407);
  }
  
  public static final class a
  {
    public Context context;
    public ArrayList dvO;
    public arv field_favProto;
    public long field_localId = 0L;
    public String hTA;
    public int hTB = 0;
    public String hTC;
    public String hTD;
    public boolean hTE = false;
    public Bundle hTF;
    public int hTG = 0;
    public boolean hTH = true;
    public arx hTI;
    public int itemType = 0;
    public String path;
    public int type = 0;
  }
  
  public static final class b
  {
    public String path;
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ql
 * JD-Core Version:    0.7.0.1
 */