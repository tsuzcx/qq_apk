package com.tencent.mm.danmaku.c;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
{
  private static final String TAG;
  private static m jzI;
  private static com.tencent.mm.danmaku.b.c jzJ;
  private static k jzP;
  private boolean cGn;
  public final com.tencent.mm.danmaku.d.d<Drawable> jzH;
  private final SparseArray<i> jzK;
  private boolean jzL;
  private h jzM;
  private f jzN;
  private e jzO;
  private j jzQ;
  public g jzR;
  public d jzS;
  private c jzT;
  private List<com.tencent.mm.danmaku.render.a> jzU;
  private com.tencent.mm.danmaku.render.c jzV;
  public int jzW;
  
  static
  {
    AppMethodBeat.i(283556);
    TAG = a.class.getSimpleName();
    AppMethodBeat.o(283556);
  }
  
  private a(a parama)
  {
    AppMethodBeat.i(283547);
    this.jzK = new SparseArray();
    this.jzL = false;
    this.jzV = new com.tencent.mm.danmaku.render.c();
    this.jzL = parama.jzL;
    this.jzM = parama.jzM;
    this.jzN = parama.jzN;
    this.jzO = parama.jzO;
    jzP = parama.jzX;
    this.jzQ = parama.jzQ;
    this.jzR = parama.jzR;
    this.jzS = parama.jzS;
    this.jzT = parama.jzT;
    this.jzW = parama.jzW;
    this.cGn = parama.cGn;
    this.jzH = new com.tencent.mm.danmaku.d.d();
    this.jzU = new ArrayList();
    this.jzU.addAll(parama.jzU);
    if ((!this.jzL) && (this.jzM == null))
    {
      parama = new IllegalArgumentException("Danmaku module need an IDanmakuPlayTimeSupplier or is live setter for computing timeline");
      AppMethodBeat.o(283547);
      throw parama;
    }
    AppMethodBeat.o(283547);
  }
  
  public static m azC()
  {
    AppMethodBeat.i(283549);
    if (jzI == null) {}
    try
    {
      if ((jzI == null) && (jzP != null)) {
        jzI = jzP.azK();
      }
      if (jzI == null) {
        jzI = new m();
      }
      m localm = jzI;
      AppMethodBeat.o(283549);
      return localm;
    }
    finally
    {
      AppMethodBeat.o(283549);
    }
  }
  
  private static com.tencent.mm.danmaku.b.c azD()
  {
    AppMethodBeat.i(283551);
    if (jzJ == null) {}
    try
    {
      if (jzJ == null) {
        jzJ = new com.tencent.mm.danmaku.b.c();
      }
      com.tencent.mm.danmaku.b.c localc = jzJ;
      AppMethodBeat.o(283551);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(283551);
    }
  }
  
  public static a azF()
  {
    AppMethodBeat.i(283555);
    a locala = new a((byte)0);
    AppMethodBeat.o(283555);
    return locala;
  }
  
  public final long azE()
  {
    AppMethodBeat.i(283554);
    if (this.jzM == null)
    {
      AppMethodBeat.o(283554);
      return -1L;
    }
    long l = this.jzM.azE();
    AppMethodBeat.o(283554);
    return l;
  }
  
  public final com.tencent.mm.danmaku.render.a d(com.tencent.mm.danmaku.b.a parama)
  {
    AppMethodBeat.i(283548);
    Iterator localIterator = this.jzU.iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (com.tencent.mm.danmaku.render.a)localIterator.next();
    } while (!((com.tencent.mm.danmaku.render.a)localObject).e(parama));
    for (parama = (com.tencent.mm.danmaku.b.a)localObject;; parama = null)
    {
      localObject = parama;
      if (parama == null) {
        localObject = this.jzV;
      }
      AppMethodBeat.o(283548);
      return localObject;
    }
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(283553);
    if ((this.jzL) || (azE() < 0L))
    {
      AppMethodBeat.o(283553);
      return true;
    }
    AppMethodBeat.o(283553);
    return false;
  }
  
  public final i ru(int paramInt)
  {
    AppMethodBeat.i(283550);
    Object localObject3 = (i)this.jzK.get(paramInt);
    Object localObject1 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject3 = (i)this.jzK.get(paramInt);
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = localObject3;
        if (this.jzQ != null)
        {
          localObject1 = this.jzQ.azJ();
          this.jzK.put(paramInt, localObject1);
        }
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = azD();
      }
      AppMethodBeat.o(283550);
      return localObject3;
    }
    finally
    {
      AppMethodBeat.o(283550);
    }
  }
  
  public static final class a
  {
    boolean cGn;
    boolean jzL;
    h jzM;
    f jzN;
    e jzO;
    j jzQ;
    public g jzR;
    public d jzS;
    c jzT;
    List<com.tencent.mm.danmaku.render.a> jzU;
    int jzW;
    k jzX;
    
    private a()
    {
      AppMethodBeat.i(231327);
      this.jzU = new ArrayList();
      this.cGn = false;
      AppMethodBeat.o(231327);
    }
    
    public final a a(d paramd)
    {
      this.jzS = paramd;
      return this;
    }
    
    public final a a(h paramh)
    {
      this.jzM = paramh;
      return this;
    }
    
    public final a a(com.tencent.mm.danmaku.render.a parama)
    {
      AppMethodBeat.i(231335);
      this.jzU.add(parama);
      AppMethodBeat.o(231335);
      return this;
    }
    
    public final a azG()
    {
      AppMethodBeat.i(231340);
      a locala = new a(this, (byte)0);
      AppMethodBeat.o(231340);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.c.a
 * JD-Core Version:    0.7.0.1
 */