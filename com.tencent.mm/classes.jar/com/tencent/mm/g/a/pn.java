package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.bl;
import java.util.List;

public final class pn
  extends b
{
  public a dvb;
  public b dvc;
  
  public pn()
  {
    this((byte)0);
  }
  
  private pn(byte paramByte)
  {
    AppMethodBeat.i(94798);
    this.dvb = new a();
    this.dvc = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(94798);
  }
  
  public static final class a
  {
    public Context context;
    public String desc;
    public afy djJ;
    public String dki;
    public bl drF;
    public cs duB;
    public String dvd;
    public ago dve;
    public int dvf = 0;
    public List<bl> dvg;
    public String dvh;
    public String dvi;
    public d dvj;
    public boolean dvk = false;
    public long msgId = 0L;
    public String thumbPath;
    public String title;
    public String toUser;
    public int type = 0;
  }
  
  public static final class b
  {
    public cs duB;
    public d dvj;
    public c dvl;
    public String dvm;
    public boolean dvn = false;
    public boolean dvo = false;
    public String thumbPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.pn
 * JD-Core Version:    0.7.0.1
 */