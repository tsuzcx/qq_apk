package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.bx;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class c
  extends g
{
  public int appType;
  public String daa;
  public int diX;
  public int dtF;
  public boolean iis;
  public String jwf;
  public long lTP;
  public String name;
  public int position;
  public int scene;
  public int status;
  public String tcK;
  public String tcL;
  public String tcM;
  public String tcN;
  public String tcO;
  public String tcP;
  public String tcQ;
  public String tcR;
  public LinkedList<String> tcS;
  public String tcT;
  public LinkedList<String> tcU;
  public boolean tcV;
  public boolean tcW;
  public String tcX;
  public String tcY;
  public String tcZ;
  public String tda;
  public String tdb;
  public boolean tdc;
  public String tdd;
  public bx tde;
  public int type;
  public int versionCode;
  
  public c()
  {
    AppMethodBeat.i(41356);
    this.status = 0;
    this.type = 0;
    this.tcK = "";
    this.tcL = "";
    this.tcM = "#929292";
    this.tcN = "";
    this.tcO = "";
    this.daa = "";
    this.iis = false;
    this.scene = 0;
    this.dtF = 0;
    this.position = 1;
    this.versionCode = 0;
    this.tcP = "";
    this.tcQ = "";
    this.tcR = "";
    this.tcS = new LinkedList();
    this.tcT = "";
    this.tcU = new LinkedList();
    this.tcV = false;
    this.tcW = false;
    this.tcX = "";
    this.tcY = "#fca28a";
    this.tcZ = "";
    this.jwf = "";
    this.name = "";
    this.tda = "#222222";
    this.tdb = "";
    this.tdc = false;
    this.tdd = "";
    this.lTP = 0L;
    this.diX = 0;
    this.appType = 0;
    AppMethodBeat.o(41356);
  }
  
  public final boolean cPT()
  {
    AppMethodBeat.i(41357);
    if (((this.appType == 1) || (this.appType == 2)) && (this.tde != null) && (!bs.isNullOrNil(this.tde.tkK)))
    {
      AppMethodBeat.o(41357);
      return true;
    }
    AppMethodBeat.o(41357);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.c
 * JD-Core Version:    0.7.0.1
 */