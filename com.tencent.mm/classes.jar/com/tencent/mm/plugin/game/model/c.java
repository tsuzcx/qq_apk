package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.protobuf.cl;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class c
  extends g
{
  public String ICf;
  public String ICg;
  public String ICh;
  public String ICi;
  public String ICj;
  public String ICk;
  public String ICl;
  public String ICm;
  public LinkedList<String> ICn;
  public String ICo;
  public LinkedList<String> ICp;
  public boolean ICq;
  public boolean ICr;
  public String ICs;
  public String ICt;
  public String ICu;
  public String ICv;
  public String ICw;
  public boolean ICx;
  public String ICy;
  public cl ICz;
  public int appType;
  public String hAR;
  public int hMd;
  public int hYi;
  public String name;
  public boolean piu;
  public int position;
  public String qQb;
  public int scene;
  public int status;
  public long tQv;
  public int type;
  public int versionCode;
  
  public c()
  {
    AppMethodBeat.i(41356);
    this.status = 0;
    this.type = 0;
    this.ICf = "";
    this.ICg = "";
    this.ICh = "#929292";
    this.ICi = "";
    this.ICj = "";
    this.hAR = "";
    this.piu = false;
    this.scene = 0;
    this.hYi = 0;
    this.position = 1;
    this.versionCode = 0;
    this.ICk = "";
    this.ICl = "";
    this.ICm = "";
    this.ICn = new LinkedList();
    this.ICo = "";
    this.ICp = new LinkedList();
    this.ICq = false;
    this.ICr = false;
    this.ICs = "";
    this.ICt = "#fca28a";
    this.ICu = "";
    this.qQb = "";
    this.name = "";
    this.ICv = "#222222";
    this.ICw = "";
    this.ICx = false;
    this.ICy = "";
    this.tQv = 0L;
    this.hMd = 0;
    this.appType = 0;
    AppMethodBeat.o(41356);
  }
  
  public final boolean fFS()
  {
    AppMethodBeat.i(41357);
    if (((this.appType == 1) || (this.appType == 2)) && (this.ICz != null) && (!Util.isNullOrNil(this.ICz.IKI)))
    {
      AppMethodBeat.o(41357);
      return true;
    }
    AppMethodBeat.o(41357);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.c
 * JD-Core Version:    0.7.0.1
 */