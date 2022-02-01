package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class gq
  extends gr
{
  @Json(name="create")
  public long a;
  @Json(name="destroy")
  public long b;
  @Json(name="mapLoad")
  private gm c;
  @Json(name="oversea")
  private go d;
  @Json(name="indoorLog")
  private gl e;
  @Json(name="darkMode")
  private gh f;
  @Json(name="pointEvent")
  private gp h;
  @Json(name="aoi")
  private gd i;
  @Json(name="vectorHeat")
  private gu j;
  @Json(name="heatMap")
  private gk k;
  @Json(name="arcLine")
  private ge l;
  @Json(name="dotScatter")
  private gi m;
  @Json(name="bitmapScatter")
  private gf n;
  @Json(name="trail")
  private gs o;
  @Json(name="groundOverlay")
  private gj p;
  @Json(name="offline")
  private gn q;
  @Json(name="customStyle")
  private gg r;
  @Json(name="ugc")
  private gt s;
  
  public gq(long paramLong)
  {
    super(paramLong);
    this.a = paramLong;
  }
  
  private gq r()
  {
    AppMethodBeat.i(225323);
    this.b = (System.currentTimeMillis() - this.a);
    AppMethodBeat.o(225323);
    return this;
  }
  
  public final gm a()
  {
    AppMethodBeat.i(225334);
    if (this.c == null) {
      this.c = new gm(this.g);
    }
    gm localgm = this.c;
    AppMethodBeat.o(225334);
    return localgm;
  }
  
  public final go b()
  {
    AppMethodBeat.i(225347);
    if (this.d == null) {
      this.d = new go(System.currentTimeMillis() - this.g);
    }
    go localgo = this.d;
    AppMethodBeat.o(225347);
    return localgo;
  }
  
  public final gt c()
  {
    AppMethodBeat.i(225355);
    if (this.s == null) {
      this.s = new gt(System.currentTimeMillis() - this.g);
    }
    gt localgt = this.s;
    AppMethodBeat.o(225355);
    return localgt;
  }
  
  public final gl d()
  {
    AppMethodBeat.i(225361);
    if (this.e == null) {
      this.e = new gl(System.currentTimeMillis() - this.g);
    }
    gl localgl = this.e;
    AppMethodBeat.o(225361);
    return localgl;
  }
  
  public final gh e()
  {
    AppMethodBeat.i(225370);
    if (this.f == null) {
      this.f = new gh(System.currentTimeMillis() - this.g);
    }
    gh localgh = this.f;
    AppMethodBeat.o(225370);
    return localgh;
  }
  
  public final gp f()
  {
    AppMethodBeat.i(225382);
    if (this.h == null) {
      this.h = new gp(System.currentTimeMillis() - this.g);
    }
    gp localgp = this.h;
    AppMethodBeat.o(225382);
    return localgp;
  }
  
  public final gd g()
  {
    AppMethodBeat.i(225390);
    if (this.i == null) {
      this.i = new gd(System.currentTimeMillis() - this.g);
    }
    gd localgd = this.i;
    AppMethodBeat.o(225390);
    return localgd;
  }
  
  public final gu h()
  {
    AppMethodBeat.i(225401);
    if (this.j == null) {
      this.j = new gu(System.currentTimeMillis() - this.g);
    }
    gu localgu = this.j;
    AppMethodBeat.o(225401);
    return localgu;
  }
  
  public final gk i()
  {
    AppMethodBeat.i(225407);
    if (this.k == null) {
      this.k = new gk(System.currentTimeMillis() - this.g);
    }
    gk localgk = this.k;
    AppMethodBeat.o(225407);
    return localgk;
  }
  
  public final ge j()
  {
    AppMethodBeat.i(225418);
    if (this.l == null) {
      this.l = new ge(System.currentTimeMillis() - this.g);
    }
    ge localge = this.l;
    AppMethodBeat.o(225418);
    return localge;
  }
  
  public final gi k()
  {
    AppMethodBeat.i(225423);
    if (this.m == null) {
      this.m = new gi(System.currentTimeMillis() - this.g);
    }
    gi localgi = this.m;
    AppMethodBeat.o(225423);
    return localgi;
  }
  
  public final gf l()
  {
    AppMethodBeat.i(225433);
    if (this.n == null) {
      this.n = new gf(System.currentTimeMillis() - this.g);
    }
    gf localgf = this.n;
    AppMethodBeat.o(225433);
    return localgf;
  }
  
  public final gs m()
  {
    AppMethodBeat.i(225444);
    if (this.o == null) {
      this.o = new gs(System.currentTimeMillis() - this.g);
    }
    gs localgs = this.o;
    AppMethodBeat.o(225444);
    return localgs;
  }
  
  public final gj n()
  {
    AppMethodBeat.i(225454);
    if (this.p == null) {
      this.p = new gj(System.currentTimeMillis() - this.g);
    }
    gj localgj = this.p;
    AppMethodBeat.o(225454);
    return localgj;
  }
  
  public final gn o()
  {
    AppMethodBeat.i(225463);
    if (this.q == null) {
      this.q = new gn(System.currentTimeMillis() - this.g);
    }
    gn localgn = this.q;
    AppMethodBeat.o(225463);
    return localgn;
  }
  
  public final gg p()
  {
    AppMethodBeat.i(225470);
    if (this.r == null) {
      this.r = new gg(System.currentTimeMillis() - this.g);
    }
    gg localgg = this.r;
    AppMethodBeat.o(225470);
    return localgg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.gq
 * JD-Core Version:    0.7.0.1
 */