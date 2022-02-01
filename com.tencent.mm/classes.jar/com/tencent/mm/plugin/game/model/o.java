package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.dr;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class o
  extends dr
{
  protected static IAutoDBItem.MAutoDBInfo info;
  public boolean ICD;
  public String IDA;
  public String IDB;
  public String IDC;
  public int IDD;
  public int IDE;
  public long IDF;
  public long IDG;
  public int IDH;
  public b IDI;
  public String IDJ;
  public String IDK;
  public String IDL;
  public String IDM;
  public String IDN;
  public String IDO;
  public String IDP;
  public String IDQ;
  public String IDR;
  public String IDS;
  public String IDT;
  public String IDU;
  public j IDV;
  public i IDW;
  public k IDX;
  public m IDY;
  public e IDZ;
  public long IDg;
  private boolean IDh;
  public String IDi;
  public String IDj;
  public String IDk;
  public String IDl;
  public String IDm;
  public int IDn;
  public String IDo;
  public String IDp;
  public LinkedList<l> IDq;
  public boolean IDr;
  public g IDs;
  public boolean IDt;
  public f IDu;
  public HashMap<String, h> IDv;
  public String IDw;
  public int IDx;
  public int IDy;
  public int IDz;
  public q IEa;
  public p IEb;
  public o IEc;
  public d IEd;
  public n IEe;
  public c IEf;
  public int IEg;
  public int IEh;
  public String IEi;
  public String IEj;
  public int IEk;
  public String IEl;
  public boolean IEm;
  public String mAppName;
  public String mNoticeId;
  public String xQX;
  
  static
  {
    AppMethodBeat.i(41454);
    info = dr.aJm();
    AppMethodBeat.o(41454);
  }
  
  public o()
  {
    AppMethodBeat.i(41452);
    this.IDg = 0L;
    this.IDh = false;
    this.xQX = "";
    this.IDi = "";
    this.IDj = "";
    this.mAppName = "";
    this.IDk = "";
    this.IDl = "";
    this.IDm = "";
    this.IDn = 0;
    this.IDo = "";
    this.IDp = "";
    this.IDq = new LinkedList();
    this.IDs = new g();
    this.IDu = new f();
    this.IDv = new HashMap();
    this.IDw = "";
    this.IDx = 0;
    this.IDy = 0;
    this.IDz = 0;
    this.IDA = "";
    this.IDB = "";
    this.IDC = "";
    this.IDD = 0;
    this.IDE = 0;
    this.IDF = 0L;
    this.IDG = 0L;
    this.IDH = 0;
    this.IDI = new b();
    this.IDJ = "";
    this.IDK = "";
    this.IDL = "";
    this.IDM = "";
    this.IDN = "";
    this.IDO = "";
    this.IDP = "";
    this.IDW = new i();
    this.IDX = new k();
    this.IDY = new m();
    this.IDZ = new e();
    this.IEa = new q();
    this.IEb = new p();
    this.IEc = new o();
    this.IEd = new d();
    this.IEe = new n();
    this.IEf = new c();
    this.ICD = false;
    this.IEk = 0;
    this.IEl = "";
    this.IEm = false;
    AppMethodBeat.o(41452);
  }
  
  public final void fGp()
  {
    AppMethodBeat.i(41453);
    if (this.IDh)
    {
      AppMethodBeat.o(41453);
      return;
    }
    if (this.field_msgType == 100)
    {
      u.fGG();
      u.a(this);
    }
    for (;;)
    {
      q.b(this);
      this.IDh = true;
      AppMethodBeat.o(41453);
      return;
      q.a(this);
    }
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public static final class a
  {
    public String IEn;
    public String IEo;
  }
  
  public static final class b
  {
    public List<String> IEp;
    public boolean ItB;
    public boolean egT;
    public int orientation;
    public String url;
    
    public b()
    {
      AppMethodBeat.i(41450);
      this.IEp = new ArrayList();
      AppMethodBeat.o(41450);
    }
  }
  
  public static final class c
  {
    public String IEq;
  }
  
  public static final class d
  {
    public boolean IEr;
    public o.a IEs;
    public boolean hWa;
    
    public d()
    {
      AppMethodBeat.i(275394);
      this.IEr = false;
      this.hWa = false;
      this.IEs = new o.a();
      AppMethodBeat.o(275394);
    }
  }
  
  public static final class e
  {
    public List<String> IEp;
    public String IEt;
    
    public e()
    {
      AppMethodBeat.i(41451);
      this.IEp = new ArrayList();
      AppMethodBeat.o(41451);
    }
  }
  
  public static final class f
  {
    public String IEu;
    public String IEv;
    public String mDesc;
  }
  
  public static final class g
  {
    public String IEu;
    public int IEw;
    public boolean IEx;
    public int IEy;
    public boolean IEz;
    public int mIconHeight;
    public int mIconWidth;
    public String mText;
  }
  
  public static final class h
  {
    public int mJumpType;
    public String mJumpUrl;
  }
  
  public static final class i
  {
    public String IEu;
    public String IEv;
    public String mContent;
  }
  
  public static final class j
  {
    public String IEA;
    public String IEB;
    public String IEC;
    public String IEv;
  }
  
  public static final class k
  {
    public String IEv;
    public boolean mClickable;
    public String mName;
  }
  
  public static final class l
  {
    public String DUN;
    public String IED;
    public String IEE;
    public String IEF;
    public String nickName;
    public String userName;
  }
  
  public static final class m
  {
    public String IEG;
    public long IEH = 0L;
    public int wxJ = 0;
  }
  
  public static final class n
  {
    public String IEI;
    public String IEJ;
    public long IEK;
  }
  
  public static final class o
  {
    public int IEL;
    public String IEM;
    public String IEN;
    public String IEO;
    public String IEP;
    public String IEQ;
    public String IER;
    public String IES;
    public int IET;
    public String IEU;
    public String IEV;
    public String IEW;
    public String IEX;
    public String IEY;
    public String jump_id;
    public int show_type;
  }
  
  public static final class p
  {
    public int IEZ = 0;
    public int IFa;
    public Boolean ias = null;
    public String ooc;
  }
  
  public static final class q
  {
    public int IFb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.o
 * JD-Core Version:    0.7.0.1
 */