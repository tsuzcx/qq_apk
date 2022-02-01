package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.protobuf.cj;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class c
  extends g
{
  public int appType;
  public String dDJ;
  public int dNv;
  public int dYu;
  public boolean jyX;
  public String kVZ;
  public long nJC;
  public String name;
  public int position;
  public int scene;
  public int status;
  public int type;
  public int versionCode;
  public String xDU;
  public String xDV;
  public String xDW;
  public String xDX;
  public String xDY;
  public String xDZ;
  public String xEa;
  public String xEb;
  public LinkedList<String> xEc;
  public String xEd;
  public LinkedList<String> xEe;
  public boolean xEf;
  public boolean xEg;
  public String xEh;
  public String xEi;
  public String xEj;
  public String xEk;
  public String xEl;
  public boolean xEm;
  public String xEn;
  public cj xEo;
  
  public c()
  {
    AppMethodBeat.i(41356);
    this.status = 0;
    this.type = 0;
    this.xDU = "";
    this.xDV = "";
    this.xDW = "#929292";
    this.xDX = "";
    this.xDY = "";
    this.dDJ = "";
    this.jyX = false;
    this.scene = 0;
    this.dYu = 0;
    this.position = 1;
    this.versionCode = 0;
    this.xDZ = "";
    this.xEa = "";
    this.xEb = "";
    this.xEc = new LinkedList();
    this.xEd = "";
    this.xEe = new LinkedList();
    this.xEf = false;
    this.xEg = false;
    this.xEh = "";
    this.xEi = "#fca28a";
    this.xEj = "";
    this.kVZ = "";
    this.name = "";
    this.xEk = "#222222";
    this.xEl = "";
    this.xEm = false;
    this.xEn = "";
    this.nJC = 0L;
    this.dNv = 0;
    this.appType = 0;
    AppMethodBeat.o(41356);
  }
  
  public final boolean dUP()
  {
    AppMethodBeat.i(41357);
    if (((this.appType == 1) || (this.appType == 2)) && (this.xEo != null) && (!Util.isNullOrNil(this.xEo.xMp)))
    {
      AppMethodBeat.o(41357);
      return true;
    }
    AppMethodBeat.o(41357);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.c
 * JD-Core Version:    0.7.0.1
 */