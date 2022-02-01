package com.tencent.mm.g.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.agd;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.List;

public final class gs
  extends b
{
  public a dkc;
  public b dkd;
  
  public gs()
  {
    this((byte)0);
  }
  
  private gs(byte paramByte)
  {
    AppMethodBeat.i(127405);
    this.dkc = new a();
    this.dkd = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(127405);
  }
  
  public static final class a
  {
    public Context context;
    public long deL;
    public ago deS;
    public String desc;
    public n dfA;
    public afy dke;
    public Intent dkf;
    public k.a dkg;
    public Runnable dkh;
    public String dki;
    public int dkj = 0;
    public int dkk = 0;
    public String dkl;
    public String dkm;
    public agq dkn;
    public ap handler;
    public String path;
    public String title;
    public String toUser;
    public int type = 0;
  }
  
  public static final class b
  {
    public List bqk;
    public agd dko;
    public e dkp;
    public List dkq;
    public boolean dkr = false;
    public boolean dks = false;
    public boolean dkt = false;
    public double dku = 0.0D;
    public String dkv;
    public String path;
    public int ret = -1;
    public String thumbPath;
    public String thumbUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.gs
 * JD-Core Version:    0.7.0.1
 */