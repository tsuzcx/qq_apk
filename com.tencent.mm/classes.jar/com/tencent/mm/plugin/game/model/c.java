package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.cj;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class c
  extends g
{
  public int appType;
  public int dGL;
  public String dmu;
  public int dvO;
  public boolean iEF;
  public String jTr;
  public long myB;
  public String name;
  public int position;
  public int scene;
  public int status;
  public int type;
  public String ulC;
  public String ulD;
  public String ulE;
  public String ulF;
  public String ulG;
  public String ulH;
  public String ulI;
  public String ulJ;
  public LinkedList<String> ulK;
  public String ulL;
  public LinkedList<String> ulM;
  public boolean ulN;
  public boolean ulO;
  public String ulP;
  public String ulQ;
  public String ulR;
  public String ulS;
  public String ulT;
  public boolean ulU;
  public String ulV;
  public cj ulW;
  public int versionCode;
  
  public c()
  {
    AppMethodBeat.i(41356);
    this.status = 0;
    this.type = 0;
    this.ulC = "";
    this.ulD = "";
    this.ulE = "#929292";
    this.ulF = "";
    this.ulG = "";
    this.dmu = "";
    this.iEF = false;
    this.scene = 0;
    this.dGL = 0;
    this.position = 1;
    this.versionCode = 0;
    this.ulH = "";
    this.ulI = "";
    this.ulJ = "";
    this.ulK = new LinkedList();
    this.ulL = "";
    this.ulM = new LinkedList();
    this.ulN = false;
    this.ulO = false;
    this.ulP = "";
    this.ulQ = "#fca28a";
    this.ulR = "";
    this.jTr = "";
    this.name = "";
    this.ulS = "#222222";
    this.ulT = "";
    this.ulU = false;
    this.ulV = "";
    this.myB = 0L;
    this.dvO = 0;
    this.appType = 0;
    AppMethodBeat.o(41356);
  }
  
  public final boolean dbi()
  {
    AppMethodBeat.i(41357);
    if (((this.appType == 1) || (this.appType == 2)) && (this.ulW != null) && (!bu.isNullOrNil(this.ulW.uun)))
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