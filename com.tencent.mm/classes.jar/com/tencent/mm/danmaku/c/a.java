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
  private static m gPp;
  private static com.tencent.mm.danmaku.b.c gPq;
  private static k gPw;
  private boolean cFH;
  private c gPA;
  private List<com.tencent.mm.danmaku.render.a> gPB;
  private com.tencent.mm.danmaku.render.c gPC;
  private int gPD;
  public final com.tencent.mm.danmaku.d.d<Drawable> gPo;
  private final SparseArray<i> gPr;
  private boolean gPs;
  private h gPt;
  private f gPu;
  private e gPv;
  private j gPx;
  public g gPy;
  public d gPz;
  
  static
  {
    AppMethodBeat.i(241692);
    TAG = a.class.getSimpleName();
    AppMethodBeat.o(241692);
  }
  
  private a(a parama)
  {
    AppMethodBeat.i(241684);
    this.gPr = new SparseArray();
    this.gPs = false;
    this.gPC = new com.tencent.mm.danmaku.render.c();
    this.gPs = parama.gPs;
    this.gPt = parama.gPt;
    this.gPu = parama.gPu;
    this.gPv = parama.gPv;
    gPw = parama.gPE;
    this.gPx = parama.gPx;
    this.gPy = parama.gPy;
    this.gPz = parama.gPz;
    this.gPA = parama.gPA;
    this.gPD = parama.gPD;
    this.cFH = parama.cFH;
    this.gPo = new com.tencent.mm.danmaku.d.d();
    this.gPB = new ArrayList();
    this.gPB.addAll(parama.gPB);
    if ((!this.gPs) && (this.gPt == null))
    {
      parama = new IllegalArgumentException("Danmaku module need an IDanmakuPlayTimeSupplier or is live setter for computing timeline");
      AppMethodBeat.o(241684);
      throw parama;
    }
    AppMethodBeat.o(241684);
  }
  
  public static m asO()
  {
    AppMethodBeat.i(241686);
    if (gPp == null) {}
    try
    {
      if ((gPp == null) && (gPw != null)) {
        gPp = gPw.asW();
      }
      if (gPp == null) {
        gPp = new m();
      }
      m localm = gPp;
      AppMethodBeat.o(241686);
      return localm;
    }
    finally
    {
      AppMethodBeat.o(241686);
    }
  }
  
  private static com.tencent.mm.danmaku.b.c asP()
  {
    AppMethodBeat.i(241688);
    if (gPq == null) {}
    try
    {
      if (gPq == null) {
        gPq = new com.tencent.mm.danmaku.b.c();
      }
      com.tencent.mm.danmaku.b.c localc = gPq;
      AppMethodBeat.o(241688);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(241688);
    }
  }
  
  public static a asR()
  {
    AppMethodBeat.i(241691);
    a locala = new a((byte)0);
    AppMethodBeat.o(241691);
    return locala;
  }
  
  public final long asQ()
  {
    AppMethodBeat.i(241690);
    if (this.gPt == null)
    {
      AppMethodBeat.o(241690);
      return -1L;
    }
    long l = this.gPt.asQ();
    AppMethodBeat.o(241690);
    return l;
  }
  
  public final com.tencent.mm.danmaku.render.a e(com.tencent.mm.danmaku.b.a parama)
  {
    AppMethodBeat.i(241685);
    Iterator localIterator = this.gPB.iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (com.tencent.mm.danmaku.render.a)localIterator.next();
    } while (!((com.tencent.mm.danmaku.render.a)localObject).f(parama));
    for (parama = (com.tencent.mm.danmaku.b.a)localObject;; parama = null)
    {
      localObject = parama;
      if (parama == null) {
        localObject = this.gPC;
      }
      AppMethodBeat.o(241685);
      return localObject;
    }
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(241689);
    if ((this.gPs) || (asQ() < 0L))
    {
      AppMethodBeat.o(241689);
      return true;
    }
    AppMethodBeat.o(241689);
    return false;
  }
  
  public final i oZ(int paramInt)
  {
    AppMethodBeat.i(241687);
    Object localObject3 = (i)this.gPr.get(paramInt);
    Object localObject1 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject3 = (i)this.gPr.get(paramInt);
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = localObject3;
        if (this.gPx != null)
        {
          localObject1 = this.gPx.asV();
          this.gPr.put(paramInt, localObject1);
        }
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = asP();
      }
      AppMethodBeat.o(241687);
      return localObject3;
    }
    finally
    {
      AppMethodBeat.o(241687);
    }
  }
  
  public static final class a
  {
    boolean cFH;
    c gPA;
    List<com.tencent.mm.danmaku.render.a> gPB;
    int gPD;
    k gPE;
    boolean gPs;
    h gPt;
    f gPu;
    e gPv;
    j gPx;
    public g gPy;
    public d gPz;
    
    private a()
    {
      AppMethodBeat.i(241681);
      this.gPB = new ArrayList();
      this.cFH = false;
      AppMethodBeat.o(241681);
    }
    
    public final a a(d paramd)
    {
      this.gPz = paramd;
      return this;
    }
    
    public final a a(h paramh)
    {
      this.gPt = paramh;
      return this;
    }
    
    public final a a(com.tencent.mm.danmaku.render.a parama)
    {
      AppMethodBeat.i(241682);
      this.gPB.add(parama);
      AppMethodBeat.o(241682);
      return this;
    }
    
    public final a asS()
    {
      AppMethodBeat.i(241683);
      a locala = new a(this, (byte)0);
      AppMethodBeat.o(241683);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.c.a
 * JD-Core Version:    0.7.0.1
 */