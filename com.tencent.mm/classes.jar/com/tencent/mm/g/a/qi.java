package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.bv;
import java.util.List;

public final class qi
  extends b
{
  public a dFS;
  public b dFT;
  
  public qi()
  {
    this((byte)0);
  }
  
  private qi(byte paramByte)
  {
    AppMethodBeat.i(94798);
    this.dFS = new a();
    this.dFT = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(94798);
  }
  
  public static final class a
  {
    public Context context;
    public bv dCi;
    public String dFU;
    public akn dFV;
    public int dFW = 0;
    public List<bv> dFX;
    public String dFY;
    public String dFZ;
    public cw dFl;
    public d dGa;
    public boolean dGb = false;
    public String dGc;
    public String desc;
    public ajx dtI;
    public String duh;
    public long msgId = 0L;
    public String thumbPath;
    public String title;
    public String toUser;
    public int type = 0;
  }
  
  public static final class b
  {
    public cw dFl;
    public d dGa;
    public c dGd;
    public String dGe;
    public boolean dGf = false;
    public boolean dGg = false;
    public boolean dGh = false;
    public long msgId = 0L;
    public String thumbPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.qi
 * JD-Core Version:    0.7.0.1
 */