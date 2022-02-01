package com.tencent.mapsdk.core.components.protocol.jce.user;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class user_login_t
  extends MapJceStruct
{
  public String channel = "";
  public String fr = "";
  public String imei = "";
  public boolean is_login = true;
  public String nettp = "";
  public String pf = "";
  public String session_id = "";
  public long uin = 0L;
  public int uip = 0;
  public long user_id = 0L;
  public String version = "";
  public double x = 0.0D;
  public double y = 0.0D;
  
  public user_login_t() {}
  
  public user_login_t(long paramLong1, String paramString1, long paramLong2, int paramInt, String paramString2, double paramDouble1, double paramDouble2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, String paramString6, String paramString7)
  {
    this.user_id = paramLong1;
    this.session_id = paramString1;
    this.uin = paramLong2;
    this.uip = paramInt;
    this.imei = paramString2;
    this.x = paramDouble1;
    this.y = paramDouble2;
    this.pf = paramString3;
    this.version = paramString4;
    this.is_login = paramBoolean;
    this.fr = paramString5;
    this.nettp = paramString6;
    this.channel = paramString7;
  }
  
  public final String className()
  {
    return "navsns.user_login_t";
  }
  
  public final void readFrom(m paramm)
  {
    AppMethodBeat.i(221219);
    this.user_id = paramm.a(this.user_id, 0, true);
    this.session_id = paramm.b(1, true);
    this.uin = paramm.a(this.uin, 2, true);
    this.uip = paramm.a(this.uip, 3, true);
    this.imei = paramm.b(4, false);
    this.x = paramm.a(this.x, 5, false);
    this.y = paramm.a(this.y, 6, false);
    this.pf = paramm.b(7, false);
    this.version = paramm.b(8, false);
    this.is_login = paramm.a(9, false);
    this.fr = paramm.b(10, false);
    this.nettp = paramm.b(11, false);
    this.channel = paramm.b(12, false);
    AppMethodBeat.o(221219);
  }
  
  public final void writeTo(n paramn)
  {
    AppMethodBeat.i(221210);
    paramn.a(this.user_id, 0);
    paramn.a(this.session_id, 1);
    paramn.a(this.uin, 2);
    paramn.a(this.uip, 3);
    if (this.imei != null) {
      paramn.a(this.imei, 4);
    }
    paramn.a(this.x, 5);
    paramn.a(this.y, 6);
    if (this.pf != null) {
      paramn.a(this.pf, 7);
    }
    if (this.version != null) {
      paramn.a(this.version, 8);
    }
    paramn.a(this.is_login, 9);
    if (this.fr != null) {
      paramn.a(this.fr, 10);
    }
    if (this.nettp != null) {
      paramn.a(this.nettp, 11);
    }
    if (this.channel != null) {
      paramn.a(this.channel, 12);
    }
    AppMethodBeat.o(221210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.core.components.protocol.jce.user.user_login_t
 * JD-Core Version:    0.7.0.1
 */