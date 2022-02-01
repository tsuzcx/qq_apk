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
  private final List<t> bFd;
  private com.google.a.b.d bFe;
  private final Map<Type, h<?>> bFg;
  private boolean bFh;
  private boolean bFi;
  private boolean bFj;
  private boolean bFl;
  private boolean bFm;
  private boolean bFn;
  private String bFo;
  private int bFp;
  private int bFq;
  private r bFr;
  private e bFx;
  private final List<t> bFy;
  private boolean bFz;
  
  public g()
  {
    AppMethodBeat.i(108127);
    this.bFe = com.google.a.b.d.bFW;
    this.bFr = r.bFD;
    this.bFx = d.bER;
    this.bFg = new HashMap();
    this.bFd = new ArrayList();
    this.bFy = new ArrayList();
    this.bFh = false;
    this.bFp = 2;
    this.bFq = 2;
    this.bFi = false;
    this.bFn = false;
    this.bFz = true;
    this.bFl = false;
    this.bFj = false;
    this.bFm = false;
    AppMethodBeat.o(108127);
  }
  
  public final f xl()
  {
    AppMethodBeat.i(108128);
    ArrayList localArrayList = new ArrayList(this.bFd.size() + this.bFy.size() + 3);
    localArrayList.addAll(this.bFd);
    Collections.reverse(localArrayList);
    Object localObject1 = new ArrayList(this.bFy);
    Collections.reverse((List)localObject1);
    localArrayList.addAll((Collection)localObject1);
    Object localObject2 = this.bFo;
    int i = this.bFp;
    int j = this.bFq;
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
        localObject1 = new f(this.bFe, this.bFx, this.bFg, this.bFh, this.bFi, this.bFj, this.bFz, this.bFl, this.bFm, this.bFn, this.bFr, this.bFo, this.bFp, this.bFq, this.bFd, this.bFy, localArrayList);
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