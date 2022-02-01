package com.google.a;

import com.google.a.b.a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g
{
  private final List<t> bCL;
  private com.google.a.b.d bCM;
  private final Map<Type, h<?>> bCO;
  private boolean bCP;
  private boolean bCQ;
  private boolean bCR;
  private boolean bCT;
  private boolean bCU;
  private boolean bCV;
  private String bCW;
  private int bCX;
  private int bCY;
  private r bCZ;
  private e bDf;
  private final List<t> bDg;
  private boolean bDh;
  
  public g()
  {
    AppMethodBeat.i(108127);
    this.bCM = com.google.a.b.d.bDE;
    this.bCZ = r.bDl;
    this.bDf = d.bCz;
    this.bCO = new HashMap();
    this.bCL = new ArrayList();
    this.bDg = new ArrayList();
    this.bCP = false;
    this.bCX = 2;
    this.bCY = 2;
    this.bCQ = false;
    this.bCV = false;
    this.bDh = true;
    this.bCT = false;
    this.bCR = false;
    this.bCU = false;
    AppMethodBeat.o(108127);
  }
  
  public final f wY()
  {
    AppMethodBeat.i(108128);
    ArrayList localArrayList = new ArrayList(this.bCL.size() + this.bDg.size() + 3);
    localArrayList.addAll(this.bCL);
    Collections.reverse(localArrayList);
    Object localObject1 = new ArrayList(this.bDg);
    Collections.reverse((List)localObject1);
    localArrayList.addAll((Collection)localObject1);
    Object localObject2 = this.bCW;
    int i = this.bCX;
    int j = this.bCY;
    a locala;
    if ((localObject2 != null) && (!"".equals(((String)localObject2).trim())))
    {
      locala = new a(java.util.Date.class, (String)localObject2);
      localObject1 = new a(Timestamp.class, (String)localObject2);
    }
    for (localObject2 = new a(java.sql.Date.class, (String)localObject2);; localObject2 = new a(java.sql.Date.class, i, j))
    {
      localArrayList.add(m.a(java.util.Date.class, locala));
      localArrayList.add(m.a(Timestamp.class, (s)localObject1));
      localArrayList.add(m.a(java.sql.Date.class, (s)localObject2));
      do
      {
        localObject1 = new f(this.bCM, this.bDf, this.bCO, this.bCP, this.bCQ, this.bCR, this.bDh, this.bCT, this.bCU, this.bCV, this.bCZ, this.bCW, this.bCX, this.bCY, this.bCL, this.bDg, localArrayList);
        AppMethodBeat.o(108128);
        return localObject1;
      } while ((i == 2) || (j == 2));
      locala = new a(java.util.Date.class, i, j);
      localObject1 = new a(Timestamp.class, i, j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.a.g
 * JD-Core Version:    0.7.0.1
 */