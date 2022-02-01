package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.bx;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class c
  extends g
{
  public int appType;
  public String dcC;
  public int dlp;
  public int dvS;
  public boolean hHQ;
  public String iVP;
  public long lrU;
  public String name;
  public int position;
  public String rUS;
  public String rUT;
  public String rUU;
  public String rUV;
  public String rUW;
  public String rUX;
  public String rUY;
  public String rUZ;
  public LinkedList<String> rVa;
  public String rVb;
  public LinkedList<String> rVc;
  public boolean rVd;
  public boolean rVe;
  public String rVf;
  public String rVg;
  public String rVh;
  public String rVi;
  public String rVj;
  public boolean rVk;
  public String rVl;
  public bx rVm;
  public int scene;
  public int status;
  public int type;
  public int versionCode;
  
  public c()
  {
    AppMethodBeat.i(41356);
    this.status = 0;
    this.type = 0;
    this.rUS = "";
    this.rUT = "";
    this.rUU = "#929292";
    this.rUV = "";
    this.rUW = "";
    this.dcC = "";
    this.hHQ = false;
    this.scene = 0;
    this.dvS = 0;
    this.position = 1;
    this.versionCode = 0;
    this.rUX = "";
    this.rUY = "";
    this.rUZ = "";
    this.rVa = new LinkedList();
    this.rVb = "";
    this.rVc = new LinkedList();
    this.rVd = false;
    this.rVe = false;
    this.rVf = "";
    this.rVg = "#fca28a";
    this.rVh = "";
    this.iVP = "";
    this.name = "";
    this.rVi = "#222222";
    this.rVj = "";
    this.rVk = false;
    this.rVl = "";
    this.lrU = 0L;
    this.dlp = 0;
    this.appType = 0;
    AppMethodBeat.o(41356);
  }
  
  public final boolean cCJ()
  {
    AppMethodBeat.i(41357);
    if (((this.appType == 1) || (this.appType == 2)) && (this.rVm != null) && (!bt.isNullOrNil(this.rVm.scQ)))
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