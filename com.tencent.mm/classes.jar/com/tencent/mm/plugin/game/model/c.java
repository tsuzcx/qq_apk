package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.bx;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class c
  extends f
{
  public int cFj;
  public String cnG;
  public int cvQ;
  public int edl;
  public String hcN;
  public String name;
  public String nlT;
  public String nlU;
  public String nlV;
  public String nlW;
  public String nlX;
  public boolean nlY;
  public String nlZ;
  public String nma;
  public String nmb;
  public LinkedList<String> nmc;
  public String nmd;
  public LinkedList<String> nme;
  public boolean nmf;
  public boolean nmg;
  public String nmh;
  public String nmi;
  public String nmj;
  public String nmk;
  public String nml;
  public boolean nmm;
  public String nmn;
  public long nmo;
  public bx nmp;
  public int position;
  public int scene;
  public int status;
  public int type;
  public int versionCode;
  
  public c()
  {
    AppMethodBeat.i(111194);
    this.status = 0;
    this.type = 0;
    this.nlT = "";
    this.nlU = "";
    this.nlV = "#929292";
    this.nlW = "";
    this.nlX = "";
    this.cnG = "";
    this.nlY = false;
    this.scene = 0;
    this.cFj = 0;
    this.position = 1;
    this.versionCode = 0;
    this.nlZ = "";
    this.nma = "";
    this.nmb = "";
    this.nmc = new LinkedList();
    this.nmd = "";
    this.nme = new LinkedList();
    this.nmf = false;
    this.nmg = false;
    this.nmh = "";
    this.nmi = "#fca28a";
    this.nmj = "";
    this.hcN = "";
    this.name = "";
    this.nmk = "#222222";
    this.nml = "";
    this.nmm = false;
    this.nmn = "";
    this.nmo = 0L;
    this.cvQ = 0;
    this.edl = 0;
    AppMethodBeat.o(111194);
  }
  
  public final boolean bFQ()
  {
    AppMethodBeat.i(111195);
    if (((this.edl == 1) || (this.edl == 2)) && (this.nmp != null) && (!bo.isNullOrNil(this.nmp.nto)))
    {
      AppMethodBeat.o(111195);
      return true;
    }
    AppMethodBeat.o(111195);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.c
 * JD-Core Version:    0.7.0.1
 */