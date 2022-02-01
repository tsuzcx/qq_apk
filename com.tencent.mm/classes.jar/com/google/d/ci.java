package com.google.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class ci
{
  private static String a(String paramString, am.f paramf, int paramInt)
  {
    paramString = new StringBuilder(paramString);
    if (paramf.dOB.adB()) {
      paramString.append('(').append(paramf.fullName).append(')');
    }
    for (;;)
    {
      if (paramInt != -1) {
        paramString.append('[').append(paramInt).append(']');
      }
      paramString.append('.');
      return paramString.toString();
      paramString.append(paramf.dOB.getName());
    }
  }
  
  static List<String> a(ch paramch)
  {
    ArrayList localArrayList = new ArrayList();
    a(paramch, "", localArrayList);
    return localArrayList;
  }
  
  static void a(cb paramcb, Map<am.f, Object> paramMap, k paramk)
  {
    boolean bool = paramcb.getDescriptorForType().dOc.abU().dNf;
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      am.f localf = (am.f)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if ((bool) && (localf.dOB.adB()) && (localf.dOE == am.f.b.dPe) && (!localf.ahl())) {
        paramk.b(localf.dOB.dLq, (cb)localObject);
      } else {
        az.a(localf, localObject, paramk);
      }
    }
    paramcb = paramcb.getUnknownFields();
    if (bool)
    {
      paramcb.b(paramk);
      return;
    }
    paramcb.writeTo(paramk);
  }
  
  private static void a(ch paramch, String paramString, List<String> paramList)
  {
    Iterator localIterator = paramch.getDescriptorForType().getFields().iterator();
    am.f localf;
    while (localIterator.hasNext())
    {
      localf = (am.f)localIterator.next();
      if ((localf.ahj()) && (!paramch.hasField(localf))) {
        paramList.add(paramString + localf.dOB.getName());
      }
    }
    localIterator = paramch.getAllFields().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      localf = (am.f)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if (localf.dOE.dPm == am.f.a.dOR) {
        if (localf.ahl())
        {
          int i = 0;
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            a((ch)((Iterator)localObject).next(), a(paramString, localf, i), paramList);
            i += 1;
          }
        }
        else if (paramch.hasField(localf))
        {
          a((ch)localObject, a(paramString, localf, -1), paramList);
        }
      }
    }
  }
  
  private static void a(i parami, dn.a parama, at paramat, am.a parama1, c paramc)
  {
    int i = 0;
    ar.b localb = null;
    h localh = null;
    int j;
    do
    {
      for (;;)
      {
        j = parami.aac();
        if (j == 0) {
          break label125;
        }
        if (j == du.dWE)
        {
          j = parami.aal();
          i = j;
          if (j != 0)
          {
            i = j;
            if ((paramat instanceof ar))
            {
              localb = paramc.a((ar)paramat, parama1, j);
              i = j;
            }
          }
        }
        else
        {
          if (j != du.dWF) {
            break;
          }
          if ((i != 0) && (localb != null) && (at.ahI())) {
            localh = null;
          } else {
            localh = parami.aak();
          }
        }
      }
    } while (parami.jN(j));
    label125:
    parami.jM(du.dWD);
    if ((localh == null) || (i == 0) || (localb != null)) {}
    while ((localh == null) || (parama == null)) {
      return;
    }
    parama.a(i, dn.b.ajJ().i(localh).ajL());
  }
  
  static boolean a(i parami, dn.a parama, at paramat, am.a parama1, c paramc, int paramInt)
  {
    if ((parama1.dOc.abU().dNf) && (paramInt == du.dWC))
    {
      a(parami, parama, paramat, parama1, paramc);
      return true;
    }
    int i = du.lD(paramInt);
    int k = du.lE(paramInt);
    int j;
    if (parama1.la(k))
    {
      if ((paramat instanceof ar))
      {
        if (paramc.a((ar)paramat, parama1, k) == null) {
          break label146;
        }
        throw null;
      }
      parama1 = null;
      if (parama1 == null) {
        break label180;
      }
      if (i != az.a(parama1.ahg(), false)) {
        break label151;
      }
      i = 0;
      j = 0;
    }
    for (;;)
    {
      if (j != 0)
      {
        if (parama != null)
        {
          return parama.a(paramInt, parami);
          if (paramc.aiV() == ci.c.a.dTW)
          {
            parama1 = parama1.lb(k);
            break;
          }
          label146:
          parama1 = null;
          break;
          label151:
          if ((parama1.ahn()) && (i == az.a(parama1.ahg(), true)))
          {
            i = 1;
            j = 0;
            continue;
          }
          label180:
          i = 0;
          j = 1;
          continue;
        }
        return parami.jN(paramInt);
      }
    }
    if (i != 0)
    {
      paramInt = parami.jO(parami.aar());
      if (parama1.ahg() == du.a.dWT) {
        while (parami.aat() > 0)
        {
          i = parami.aam();
          if (parama1.dOd.ahu())
          {
            paramc.Z(parama1, parama1.ahr().ld(i));
          }
          else
          {
            paramat = parama1.ahr().lc(i);
            if (paramat == null)
            {
              if (parama != null) {
                parama.cR(k, i);
              }
            }
            else {
              paramc.Z(parama1, paramat);
            }
          }
        }
      }
      while (parami.aat() > 0) {
        paramc.Z(parama1, du.a(parami, parama1.ahg(), paramc.G(parama1)));
      }
      parami.jP(paramInt);
    }
    for (;;)
    {
      return true;
      switch (1.dJx[parama1.dOE.ordinal()])
      {
      default: 
        parami = du.a(parami, parama1.ahg(), paramc.G(parama1));
      }
      for (;;)
      {
        if (parama1.ahl())
        {
          paramc.Z(parama1, parami);
          break;
          parami = paramc.a(parami, paramat, parama1);
          continue;
          parami = paramc.b(parami, paramat, parama1);
          continue;
          paramInt = parami.aam();
          if (parama1.dOd.ahu())
          {
            parami = parama1.ahr().ld(paramInt);
          }
          else
          {
            paramat = parama1.ahr().lc(paramInt);
            parami = paramat;
            if (paramat == null)
            {
              if (parama != null) {
                parama.cR(k, paramInt);
              }
              return true;
            }
          }
        }
      }
      paramc.Y(parama1, parami);
    }
  }
  
  static String aJ(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }
  
  static int b(cb paramcb, Map<am.f, Object> paramMap)
  {
    boolean bool = paramcb.getDescriptorForType().dOc.abU().dNf;
    paramMap = paramMap.entrySet().iterator();
    int i = 0;
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      am.f localf = (am.f)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if ((bool) && (localf.dOB.adB()) && (localf.dOE == am.f.b.dPe) && (!localf.ahl())) {
        i = k.d(localf.dOB.dLq, (cb)localObject) + i;
      } else {
        i = az.c(localf, localObject) + i;
      }
    }
    paramcb = paramcb.getUnknownFields();
    if (bool) {
      return paramcb.ajG() + i;
    }
    return paramcb.getSerializedSize() + i;
  }
  
  static final class a
    implements ci.c
  {
    private final cb.a dTV;
    
    public a(cb.a parama)
    {
      this.dTV = parama;
    }
    
    private Object getField(am.f paramf)
    {
      return this.dTV.getField(paramf);
    }
    
    public final du.c G(am.f paramf)
    {
      if (paramf.ahh()) {
        return du.c.dXm;
      }
      if ((!paramf.ahl()) && ((this.dTV instanceof bc.a))) {
        return du.c.dXn;
      }
      return du.c.dXl;
    }
    
    public final ci.c Y(am.f paramf, Object paramObject)
    {
      this.dTV.setField(paramf, paramObject);
      return this;
    }
    
    public final ci.c Z(am.f paramf, Object paramObject)
    {
      this.dTV.addRepeatedField(paramf, paramObject);
      return this;
    }
    
    public final ar.b a(ar paramar, am.a parama, int paramInt)
    {
      return paramar.a(parama, paramInt);
    }
    
    public final Object a(i parami, at paramat, am.f paramf)
    {
      cb.a locala = this.dTV.newBuilderForField(paramf);
      if (!paramf.ahl())
      {
        cb localcb = (cb)getField(paramf);
        if (localcb != null) {
          locala.mergeFrom(localcb);
        }
      }
      parami.a(paramf.dOB.dLq, locala, paramat);
      return locala.buildPartial();
    }
    
    public final ci.c.a aiV()
    {
      return ci.c.a.dTW;
    }
    
    public final Object b(i parami, at paramat, am.f paramf)
    {
      cb.a locala = this.dTV.newBuilderForField(paramf);
      if (!paramf.ahl())
      {
        paramf = (cb)getField(paramf);
        if (paramf != null) {
          locala.mergeFrom(paramf);
        }
      }
      parami.a(locala, paramat);
      return locala.buildPartial();
    }
  }
  
  static final class b
    implements ci.c
  {
    private final az<am.f> dRL;
    
    b(az<am.f> paramaz)
    {
      this.dRL = paramaz;
    }
    
    private Object getField(am.f paramf)
    {
      return this.dRL.b(paramf);
    }
    
    public final du.c G(am.f paramf)
    {
      if (paramf.ahh()) {
        return du.c.dXm;
      }
      return du.c.dXl;
    }
    
    public final ci.c Y(am.f paramf, Object paramObject)
    {
      this.dRL.a(paramf, paramObject);
      return this;
    }
    
    public final ci.c Z(am.f paramf, Object paramObject)
    {
      this.dRL.b(paramf, paramObject);
      return this;
    }
    
    public final ar.b a(ar paramar, am.a parama, int paramInt)
    {
      return paramar.a(parama, paramInt);
    }
    
    public final Object a(i parami, at paramat, am.f paramf)
    {
      throw new NullPointerException();
    }
    
    public final ci.c.a aiV()
    {
      return ci.c.a.dTX;
    }
    
    public final Object b(i parami, at paramat, am.f paramf)
    {
      throw new NullPointerException();
    }
  }
  
  static abstract interface c
  {
    public abstract du.c G(am.f paramf);
    
    public abstract c Y(am.f paramf, Object paramObject);
    
    public abstract c Z(am.f paramf, Object paramObject);
    
    public abstract ar.b a(ar paramar, am.a parama, int paramInt);
    
    public abstract Object a(i parami, at paramat, am.f paramf);
    
    public abstract ci.c.a aiV();
    
    public abstract Object b(i parami, at paramat, am.f paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.ci
 * JD-Core Version:    0.7.0.1
 */