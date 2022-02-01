package androidx.camera.core.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class z
{
  public static final ac.a<Integer> LT;
  public static final ac.a<Integer> LU;
  public final List<h> Bs;
  public final List<ad> Fs;
  public final ac LV;
  public final int LW;
  public final boolean LX;
  public final bi zU;
  
  static
  {
    AppMethodBeat.i(198679);
    LT = ac.a.a("camerax.core.captureConfig.rotation", Integer.TYPE, null);
    LU = ac.a.a("camerax.core.captureConfig.jpegQuality", Integer.class, null);
    AppMethodBeat.o(198679);
  }
  
  z(List<ad> paramList, ac paramac, int paramInt, List<h> paramList1, boolean paramBoolean, bi parambi)
  {
    AppMethodBeat.i(198658);
    this.Fs = paramList;
    this.LV = paramac;
    this.LW = paramInt;
    this.Bs = Collections.unmodifiableList(paramList1);
    this.LX = paramBoolean;
    this.zU = parambi;
    AppMethodBeat.o(198658);
  }
  
  public static z ka()
  {
    AppMethodBeat.i(198665);
    z localz = new a().kc();
    AppMethodBeat.o(198665);
    return localz;
  }
  
  public static final class a
  {
    private List<h> Bs;
    public int LW;
    public boolean LX;
    public final Set<ad> LY;
    private as LZ;
    private au Ma;
    
    public a()
    {
      AppMethodBeat.i(198772);
      this.LY = new HashSet();
      this.LZ = at.ku();
      this.LW = -1;
      this.Bs = new ArrayList();
      this.LX = false;
      this.Ma = au.kv();
      AppMethodBeat.o(198772);
    }
    
    private a(z paramz)
    {
      AppMethodBeat.i(198782);
      this.LY = new HashSet();
      this.LZ = at.ku();
      this.LW = -1;
      this.Bs = new ArrayList();
      this.LX = false;
      this.Ma = au.kv();
      this.LY.addAll(paramz.Fs);
      this.LZ = at.k(paramz.LV);
      this.LW = paramz.LW;
      this.Bs.addAll(paramz.Bs);
      this.LX = paramz.LX;
      this.Ma = au.b(paramz.zU);
      AppMethodBeat.o(198782);
    }
    
    public static a a(z paramz)
    {
      AppMethodBeat.i(198791);
      paramz = new a(paramz);
      AppMethodBeat.o(198791);
      return paramz;
    }
    
    public final <T> void a(ac.a<T> parama, T paramT)
    {
      AppMethodBeat.i(198862);
      this.LZ.c(parama, paramT);
      AppMethodBeat.o(198862);
    }
    
    public final void a(bi parambi)
    {
      AppMethodBeat.i(198883);
      this.Ma.c(parambi);
      AppMethodBeat.o(198883);
    }
    
    public final void b(ad paramad)
    {
      AppMethodBeat.i(198823);
      this.LY.add(paramad);
      AppMethodBeat.o(198823);
    }
    
    public final void b(h paramh)
    {
      AppMethodBeat.i(198800);
      if (this.Bs.contains(paramh))
      {
        AppMethodBeat.o(198800);
        return;
      }
      this.Bs.add(paramh);
      AppMethodBeat.o(198800);
    }
    
    public final void g(String paramString, Object paramObject)
    {
      AppMethodBeat.i(198870);
      this.Ma.h(paramString, paramObject);
      AppMethodBeat.o(198870);
    }
    
    public final void h(Collection<h> paramCollection)
    {
      AppMethodBeat.i(198811);
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        b((h)paramCollection.next());
      }
      AppMethodBeat.o(198811);
    }
    
    public final void i(ac paramac)
    {
      AppMethodBeat.i(198841);
      this.LZ = at.k(paramac);
      AppMethodBeat.o(198841);
    }
    
    public final void j(ac paramac)
    {
      AppMethodBeat.i(198851);
      Iterator localIterator = paramac.ke().iterator();
      while (localIterator.hasNext())
      {
        ac.a locala = (ac.a)localIterator.next();
        Object localObject1 = this.LZ.b(locala, null);
        Object localObject2 = paramac.b(locala);
        if ((localObject1 instanceof ar))
        {
          ((ar)localObject1).addAll(((ar)localObject2).kt());
        }
        else
        {
          localObject1 = localObject2;
          if ((localObject2 instanceof ar)) {
            localObject1 = ((ar)localObject2).fY();
          }
          this.LZ.a(locala, paramac.c(locala), localObject1);
        }
      }
      AppMethodBeat.o(198851);
    }
    
    public final void kb()
    {
      AppMethodBeat.i(198829);
      this.LY.clear();
      AppMethodBeat.o(198829);
    }
    
    public final z kc()
    {
      AppMethodBeat.i(198893);
      z localz = new z(new ArrayList(this.LY), av.l(this.LZ), this.LW, this.Bs, this.LX, bi.d(this.Ma));
      AppMethodBeat.o(198893);
      return localz;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(bk<?> parambk, z.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.z
 * JD-Core Version:    0.7.0.1
 */