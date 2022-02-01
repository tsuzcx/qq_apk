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
  private final List<t> bMZ;
  private com.google.a.b.d bNa;
  private final Map<Type, h<?>> bNc;
  private boolean bNd;
  private boolean bNe;
  private boolean bNf;
  private boolean bNh;
  private boolean bNi;
  private boolean bNj;
  private String bNk;
  private int bNl;
  private int bNm;
  private r bNn;
  private e bNt;
  private final List<t> bNu;
  private boolean bNv;
  
  public g()
  {
    AppMethodBeat.i(108127);
    this.bNa = com.google.a.b.d.bNS;
    this.bNn = r.bNz;
    this.bNt = d.bMN;
    this.bNc = new HashMap();
    this.bMZ = new ArrayList();
    this.bNu = new ArrayList();
    this.bNd = false;
    this.bNl = 2;
    this.bNm = 2;
    this.bNe = false;
    this.bNj = false;
    this.bNv = true;
    this.bNh = false;
    this.bNf = false;
    this.bNi = false;
    AppMethodBeat.o(108127);
  }
  
  public final f yv()
  {
    AppMethodBeat.i(108128);
    ArrayList localArrayList = new ArrayList(this.bMZ.size() + this.bNu.size() + 3);
    localArrayList.addAll(this.bMZ);
    Collections.reverse(localArrayList);
    Object localObject1 = new ArrayList(this.bNu);
    Collections.reverse((List)localObject1);
    localArrayList.addAll((Collection)localObject1);
    Object localObject2 = this.bNk;
    int i = this.bNl;
    int j = this.bNm;
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
        localObject1 = new f(this.bNa, this.bNt, this.bNc, this.bNd, this.bNe, this.bNf, this.bNv, this.bNh, this.bNi, this.bNj, this.bNn, this.bNk, this.bNl, this.bNm, this.bMZ, this.bNu, localArrayList);
        AppMethodBeat.o(108128);
        return localObject1;
      } while ((i == 2) || (j == 2));
      locala = new a(java.util.Date.class, i, j);
      localObject1 = new a(Timestamp.class, i, j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.a.g
 * JD-Core Version:    0.7.0.1
 */