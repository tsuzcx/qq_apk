package com.tencent.mm.plugin.datareport.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  public List<com.tencent.mm.plugin.datareport.a.a> cQ;
  private long xgL;
  private double xgM;
  private long xgN;
  private double xgO;
  private long xgP;
  private int xgQ;
  private int xgR;
  public com.tencent.mm.plugin.datareport.a.c.b xgS;
  public com.tencent.mm.plugin.datareport.e.b xgT;
  
  private a()
  {
    AppMethodBeat.i(262868);
    this.xgQ = 2;
    this.xgR = 1;
    this.cQ = new ArrayList();
    this.xgT = new com.tencent.mm.plugin.datareport.e.a();
    AppMethodBeat.o(262868);
  }
  
  private a(a parama)
  {
    AppMethodBeat.i(262876);
    this.xgQ = 2;
    this.xgR = 1;
    this.cQ = new ArrayList();
    this.xgT = new com.tencent.mm.plugin.datareport.e.a();
    if (parama != null)
    {
      if ((parama.cQ != null) && (parama.cQ.size() > 0)) {
        this.cQ.addAll(parama.cQ);
      }
      if (parama.xgT != null) {
        this.xgT = parama.xgT;
      }
      this.xgS = parama.xgS;
      this.xgL = parama.xgL;
      this.xgM = parama.xgM;
      this.xgN = parama.xgN;
      this.xgO = parama.xgO;
      this.xgP = parama.xgP;
      this.xgQ = parama.xgQ;
      this.xgR = parama.xgR;
    }
    AppMethodBeat.o(262876);
  }
  
  public static final class a
  {
    public List<com.tencent.mm.plugin.datareport.a.a> cQ;
    long xgL;
    double xgM;
    long xgN;
    double xgO;
    long xgP;
    int xgQ;
    int xgR;
    public com.tencent.mm.plugin.datareport.a.c.b xgS;
    public com.tencent.mm.plugin.datareport.e.b xgT;
    
    private a()
    {
      AppMethodBeat.i(262863);
      this.xgQ = 2;
      this.xgR = 1;
      this.cQ = new ArrayList();
      this.xgT = new com.tencent.mm.plugin.datareport.e.a();
      AppMethodBeat.o(262863);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.c.a
 * JD-Core Version:    0.7.0.1
 */