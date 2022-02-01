package com.tencent.i.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class f
  extends JceStruct
{
  static ArrayList<c> Ssq;
  static ArrayList<i> Ssr;
  static ArrayList<h> Sss;
  static e Sst;
  public int RND = 0;
  public long Ssm = 0L;
  public ArrayList<i> Ssn = null;
  public ArrayList<h> Sso = null;
  public e Ssp = null;
  public ArrayList<c> kgc = null;
  
  static
  {
    AppMethodBeat.i(214762);
    Ssq = new ArrayList();
    Object localObject = new c();
    Ssq.add(localObject);
    Ssr = new ArrayList();
    localObject = new i();
    Ssr.add(localObject);
    Sss = new ArrayList();
    localObject = new h();
    Sss.add(localObject);
    Sst = new e();
    AppMethodBeat.o(214762);
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(214761);
    this.Ssm = paramJceInputStream.read(this.Ssm, 0, true);
    this.kgc = ((ArrayList)paramJceInputStream.read(Ssq, 1, false));
    this.RND = paramJceInputStream.read(this.RND, 2, false);
    this.Ssn = ((ArrayList)paramJceInputStream.read(Ssr, 3, false));
    this.Sso = ((ArrayList)paramJceInputStream.read(Sss, 4, false));
    this.Ssp = ((e)paramJceInputStream.read(Sst, 5, false));
    AppMethodBeat.o(214761);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(214760);
    paramJceOutputStream.write(this.Ssm, 0);
    if (this.kgc != null) {
      paramJceOutputStream.write(this.kgc, 1);
    }
    paramJceOutputStream.write(this.RND, 2);
    if (this.Ssn != null) {
      paramJceOutputStream.write(this.Ssn, 3);
    }
    if (this.Sso != null) {
      paramJceOutputStream.write(this.Sso, 4);
    }
    if (this.Ssp != null) {
      paramJceOutputStream.write(this.Ssp, 5);
    }
    AppMethodBeat.o(214760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.c.b.f
 * JD-Core Version:    0.7.0.1
 */