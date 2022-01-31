package com.tencent.mm.plugin.game.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aeu;
import com.tencent.mm.protocal.protobuf.aev;
import java.util.LinkedList;

public final class r$b
{
  public int actionType;
  public String appId;
  public String cnv;
  public long createTime;
  public String fnp;
  public String hKa;
  public String iconUrl;
  public String nCV;
  public aev nCW;
  public String nCX;
  public LinkedList<String> nCY;
  public int nCZ;
  public int nDa;
  public boolean nDb = false;
  public boolean nDc = false;
  public r.c nDd;
  public String name;
  public int type;
  
  public static b a(aeu paramaeu)
  {
    AppMethodBeat.i(112173);
    b localb = new b();
    localb.type = 2;
    localb.name = paramaeu.Title;
    localb.hKa = paramaeu.Desc;
    localb.iconUrl = paramaeu.ThumbUrl;
    localb.nCX = paramaeu.wXs;
    localb.nCZ = paramaeu.wXM;
    localb.nDa = paramaeu.wXN;
    localb.appId = paramaeu.fKw;
    localb.fnp = paramaeu.ntp;
    localb.createTime = paramaeu.wyt;
    localb.nDd = new r.c(paramaeu.wXs, (byte)0);
    AppMethodBeat.o(112173);
    return localb;
  }
  
  public static b aM(int paramInt, String paramString)
  {
    AppMethodBeat.i(112172);
    b localb = new b();
    localb.type = paramInt;
    localb.name = paramString;
    localb.nDd = new r.c();
    AppMethodBeat.o(112172);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.r.b
 * JD-Core Version:    0.7.0.1
 */