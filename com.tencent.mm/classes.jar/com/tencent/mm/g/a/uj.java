package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.sdk.b.b;

public final class uj
  extends b
{
  public a dzH;
  public b dzI;
  
  public uj()
  {
    this((byte)0);
  }
  
  private uj(byte paramByte)
  {
    AppMethodBeat.i(153187);
    this.dzH = new a();
    this.dzI = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(153187);
  }
  
  public static final class a
  {
    public int aAS;
    public String appId;
    public Context context;
    public String dbt;
    public Bundle deG;
    public String dzJ;
    public int dzK;
    public String dzL;
    public String dzM;
    public boolean dzN;
    public boolean dzO;
    public LaunchParamsOptional dzP;
    public int dzQ;
    public Runnable dzR;
    public int dzS;
    public String dzT;
    public String dzU;
    public String dzV;
    public String dzW;
    public String dzX;
    public String dzY;
    public int scene;
    public String userName;
    
    public a()
    {
      AppMethodBeat.i(153186);
      this.dzO = true;
      this.dzP = new LaunchParamsOptional();
      AppMethodBeat.o(153186);
    }
  }
  
  public static final class b
  {
    public String dAa;
    public boolean dzZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.uj
 * JD-Core Version:    0.7.0.1
 */