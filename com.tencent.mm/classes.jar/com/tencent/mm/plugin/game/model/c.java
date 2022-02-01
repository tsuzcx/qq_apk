package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.protobuf.ck;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class c
  extends g
{
  public String CHV;
  public String CHW;
  public String CHX;
  public String CHY;
  public String CHZ;
  public String CIa;
  public String CIb;
  public String CIc;
  public LinkedList<String> CId;
  public String CIe;
  public LinkedList<String> CIf;
  public boolean CIg;
  public boolean CIh;
  public String CIi;
  public String CIj;
  public String CIk;
  public String CIl;
  public String CIm;
  public boolean CIn;
  public String CIo;
  public ck CIp;
  public int appType;
  public int fGH;
  public int fSl;
  public String fwt;
  public boolean moD;
  public String nQm;
  public String name;
  public int position;
  public long qLO;
  public int scene;
  public int status;
  public int type;
  public int versionCode;
  
  public c()
  {
    AppMethodBeat.i(41356);
    this.status = 0;
    this.type = 0;
    this.CHV = "";
    this.CHW = "";
    this.CHX = "#929292";
    this.CHY = "";
    this.CHZ = "";
    this.fwt = "";
    this.moD = false;
    this.scene = 0;
    this.fSl = 0;
    this.position = 1;
    this.versionCode = 0;
    this.CIa = "";
    this.CIb = "";
    this.CIc = "";
    this.CId = new LinkedList();
    this.CIe = "";
    this.CIf = new LinkedList();
    this.CIg = false;
    this.CIh = false;
    this.CIi = "";
    this.CIj = "#fca28a";
    this.CIk = "";
    this.nQm = "";
    this.name = "";
    this.CIl = "#222222";
    this.CIm = "";
    this.CIn = false;
    this.CIo = "";
    this.qLO = 0L;
    this.fGH = 0;
    this.appType = 0;
    AppMethodBeat.o(41356);
  }
  
  public final boolean exW()
  {
    AppMethodBeat.i(41357);
    if (((this.appType == 1) || (this.appType == 2)) && (this.CIp != null) && (!Util.isNullOrNil(this.CIp.CQy)))
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