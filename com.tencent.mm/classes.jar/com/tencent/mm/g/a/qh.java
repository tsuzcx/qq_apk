package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.bu;
import java.util.List;

public final class qh
  extends b
{
  public a dEN;
  public b dEO;
  
  public qh()
  {
    this((byte)0);
  }
  
  private qh(byte paramByte)
  {
    AppMethodBeat.i(94798);
    this.dEN = new a();
    this.dEO = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(94798);
  }
  
  public static final class a
  {
    public Context context;
    public bu dBd;
    public String dEP;
    public akd dEQ;
    public int dER = 0;
    public List<bu> dES;
    public String dET;
    public String dEU;
    public d dEV;
    public boolean dEW = false;
    public String dEX;
    public cv dEg;
    public String desc;
    public ajn dsC;
    public String dtb;
    public long msgId = 0L;
    public String thumbPath;
    public String title;
    public String toUser;
    public int type = 0;
  }
  
  public static final class b
  {
    public d dEV;
    public c dEY;
    public String dEZ;
    public cv dEg;
    public boolean dFa = false;
    public boolean dFb = false;
    public boolean dFc = false;
    public long msgId = 0L;
    public String thumbPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.qh
 * JD-Core Version:    0.7.0.1
 */