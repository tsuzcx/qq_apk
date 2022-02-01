package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.cc;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class c
  extends g
{
  public int appType;
  public int dFG;
  public String dls;
  public int duJ;
  public boolean iBM;
  public String jPZ;
  public long mtE;
  public String name;
  public int position;
  public int scene;
  public int status;
  public int type;
  public String uaA;
  public String uaB;
  public String uaC;
  public String uaD;
  public String uaE;
  public String uaF;
  public String uaG;
  public String uaH;
  public LinkedList<String> uaI;
  public String uaJ;
  public LinkedList<String> uaK;
  public boolean uaL;
  public boolean uaM;
  public String uaN;
  public String uaO;
  public String uaP;
  public String uaQ;
  public String uaR;
  public boolean uaS;
  public String uaT;
  public cc uaU;
  public int versionCode;
  
  public c()
  {
    AppMethodBeat.i(41356);
    this.status = 0;
    this.type = 0;
    this.uaA = "";
    this.uaB = "";
    this.uaC = "#929292";
    this.uaD = "";
    this.uaE = "";
    this.dls = "";
    this.iBM = false;
    this.scene = 0;
    this.dFG = 0;
    this.position = 1;
    this.versionCode = 0;
    this.uaF = "";
    this.uaG = "";
    this.uaH = "";
    this.uaI = new LinkedList();
    this.uaJ = "";
    this.uaK = new LinkedList();
    this.uaL = false;
    this.uaM = false;
    this.uaN = "";
    this.uaO = "#fca28a";
    this.uaP = "";
    this.jPZ = "";
    this.name = "";
    this.uaQ = "#222222";
    this.uaR = "";
    this.uaS = false;
    this.uaT = "";
    this.mtE = 0L;
    this.duJ = 0;
    this.appType = 0;
    AppMethodBeat.o(41356);
  }
  
  public final boolean cYy()
  {
    AppMethodBeat.i(41357);
    if (((this.appType == 1) || (this.appType == 2)) && (this.uaU != null) && (!bt.isNullOrNil(this.uaU.uiQ)))
    {
      AppMethodBeat.o(41357);
      return true;
    }
    AppMethodBeat.o(41357);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.c
 * JD-Core Version:    0.7.0.1
 */