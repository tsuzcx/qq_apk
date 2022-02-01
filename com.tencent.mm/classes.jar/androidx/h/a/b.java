package androidx.h.a;

import android.os.Bundle;
import android.os.Looper;
import androidx.b.h;
import androidx.lifecycle.af;
import androidx.lifecycle.ah;
import androidx.lifecycle.ah.b;
import androidx.lifecycle.aj;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class b
  extends a
{
  static boolean DEBUG = false;
  private final q QG;
  private final c bIA;
  
  b(q paramq, aj paramaj)
  {
    AppMethodBeat.i(193177);
    this.QG = paramq;
    this.bIA = c.b(paramaj);
    AppMethodBeat.o(193177);
  }
  
  private <D> androidx.h.b.b<D> b(a.a<D> parama)
  {
    AppMethodBeat.i(193187);
    try
    {
      this.bIA.bII = true;
      localObject = parama.onCreateLoader(0, null);
      if (localObject == null)
      {
        parama = new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        AppMethodBeat.o(193187);
        throw parama;
      }
    }
    finally
    {
      this.bIA.bII = false;
      AppMethodBeat.o(193187);
    }
    if ((localObject.getClass().isMemberClass()) && (!Modifier.isStatic(localObject.getClass().getModifiers())))
    {
      parama = new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(193187);
      throw parama;
    }
    Object localObject = new a(0, null, (androidx.h.b.b)localObject);
    if (DEBUG) {
      new StringBuilder("  Created new loader ").append(localObject);
    }
    this.bIA.bIH.put(0, localObject);
    this.bIA.bII = false;
    parama = ((a)localObject).a(this.QG, parama);
    AppMethodBeat.o(193187);
    return parama;
  }
  
  public final void Hr()
  {
    AppMethodBeat.i(193205);
    c localc = this.bIA;
    int j = localc.bIH.size();
    int i = 0;
    while (i < j)
    {
      ((a)localc.bIH.bl(i)).Hr();
      i += 1;
    }
    AppMethodBeat.o(193205);
  }
  
  public final <D> androidx.h.b.b<D> a(a.a<D> parama)
  {
    AppMethodBeat.i(193199);
    if (this.bIA.bII)
    {
      parama = new IllegalStateException("Called while creating a loader");
      AppMethodBeat.o(193199);
      throw parama;
    }
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      parama = new IllegalStateException("initLoader must be called on the main thread");
      AppMethodBeat.o(193199);
      throw parama;
    }
    a locala = (a)this.bIA.bIH.d(0, null);
    if (DEBUG) {
      new StringBuilder("initLoader in ").append(this).append(": args=").append(null);
    }
    if (locala == null)
    {
      parama = b(parama);
      AppMethodBeat.o(193199);
      return parama;
    }
    if (DEBUG) {
      new StringBuilder("  Re-using existing loader ").append(locala);
    }
    parama = locala.a(this.QG, parama);
    AppMethodBeat.o(193199);
    return parama;
  }
  
  @Deprecated
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    AppMethodBeat.i(193228);
    c localc = this.bIA;
    if (localc.bIH.size() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Loaders:");
      String str = paramString + "    ";
      int i = 0;
      while (i < localc.bIH.size())
      {
        a locala = (a)localc.bIH.bl(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(localc.bIH.bo(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(locala.toString());
        paramPrintWriter.print(str);
        paramPrintWriter.print("mId=");
        paramPrintWriter.print(locala.mId);
        paramPrintWriter.print(" mArgs=");
        paramPrintWriter.println(locala.bIB);
        paramPrintWriter.print(str);
        paramPrintWriter.print("mLoader=");
        paramPrintWriter.println(locala.bIC);
        locala.bIC.dump(str + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        if (locala.bID != null)
        {
          paramPrintWriter.print(str);
          paramPrintWriter.print("mCallbacks=");
          paramPrintWriter.println(locala.bID);
          b localb = locala.bID;
          paramPrintWriter.print(str + "  ");
          paramPrintWriter.print("mDeliveredData=");
          paramPrintWriter.println(localb.bIG);
        }
        paramPrintWriter.print(str);
        paramPrintWriter.print("mData=");
        paramPrintWriter.println(locala.bIC.dataToString(locala.getValue()));
        paramPrintWriter.print(str);
        paramPrintWriter.print("mStarted=");
        paramPrintWriter.println(locala.Hl());
        i += 1;
      }
    }
    AppMethodBeat.o(193228);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(193215);
    Object localObject = new StringBuilder(128);
    ((StringBuilder)localObject).append("LoaderManager{");
    ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this)));
    ((StringBuilder)localObject).append(" in ");
    androidx.core.f.b.a(this.QG, (StringBuilder)localObject);
    ((StringBuilder)localObject).append("}}");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(193215);
    return localObject;
  }
  
  public static final class a<D>
    extends x<D>
    implements androidx.h.b.b.b<D>
  {
    private q QG;
    final Bundle bIB;
    final androidx.h.b.b<D> bIC;
    b.b<D> bID;
    private androidx.h.b.b<D> bIE;
    final int mId;
    
    a(int paramInt, Bundle paramBundle, androidx.h.b.b<D> paramb)
    {
      AppMethodBeat.i(193176);
      this.mId = 0;
      this.bIB = null;
      this.bIC = paramb;
      this.bIE = null;
      this.bIC.registerListener(0, this);
      AppMethodBeat.o(193176);
    }
    
    public final void Hf()
    {
      AppMethodBeat.i(193183);
      if (b.DEBUG) {
        new StringBuilder("  Starting: ").append(this);
      }
      this.bIC.startLoading();
      AppMethodBeat.o(193183);
    }
    
    public final void Hk()
    {
      AppMethodBeat.i(193190);
      if (b.DEBUG) {
        new StringBuilder("  Stopping: ").append(this);
      }
      this.bIC.stopLoading();
      AppMethodBeat.o(193190);
    }
    
    final void Hr()
    {
      AppMethodBeat.i(193200);
      q localq = this.QG;
      b.b localb = this.bID;
      if ((localq != null) && (localb != null))
      {
        super.b(localb);
        a(localq, localb);
      }
      AppMethodBeat.o(193200);
    }
    
    final androidx.h.b.b<D> Hs()
    {
      AppMethodBeat.i(193212);
      if (b.DEBUG) {
        new StringBuilder("  Destroying: ").append(this);
      }
      this.bIC.cancelLoad();
      this.bIC.abandon();
      Object localObject = this.bID;
      if (localObject != null)
      {
        b((y)localObject);
        if (((b.b)localObject).bIG)
        {
          if (b.DEBUG) {
            new StringBuilder("  Resetting: ").append(((b.b)localObject).bIC);
          }
          ((b.b)localObject).bIF.onLoaderReset(((b.b)localObject).bIC);
        }
      }
      this.bIC.unregisterListener(this);
      this.bIC.reset();
      localObject = this.bIE;
      AppMethodBeat.o(193212);
      return localObject;
    }
    
    final androidx.h.b.b<D> a(q paramq, a.a<D> parama)
    {
      AppMethodBeat.i(193196);
      parama = new b.b(this.bIC, parama);
      a(paramq, parama);
      if (this.bID != null) {
        b(this.bID);
      }
      this.QG = paramq;
      this.bID = parama;
      paramq = this.bIC;
      AppMethodBeat.o(193196);
      return paramq;
    }
    
    public final void aL(D paramD)
    {
      AppMethodBeat.i(193221);
      if (b.DEBUG) {
        new StringBuilder("onLoadComplete: ").append(this);
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        setValue(paramD);
        AppMethodBeat.o(193221);
        return;
      }
      boolean bool = b.DEBUG;
      t(paramD);
      AppMethodBeat.o(193221);
    }
    
    public final void b(y<? super D> paramy)
    {
      AppMethodBeat.i(193204);
      super.b(paramy);
      this.QG = null;
      this.bID = null;
      AppMethodBeat.o(193204);
    }
    
    public final void setValue(D paramD)
    {
      AppMethodBeat.i(193226);
      super.setValue(paramD);
      if (this.bIE != null)
      {
        this.bIE.reset();
        this.bIE = null;
      }
      AppMethodBeat.o(193226);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(193234);
      Object localObject = new StringBuilder(64);
      ((StringBuilder)localObject).append("LoaderInfo{");
      ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this)));
      ((StringBuilder)localObject).append(" #");
      ((StringBuilder)localObject).append(this.mId);
      ((StringBuilder)localObject).append(" : ");
      androidx.core.f.b.a(this.bIC, (StringBuilder)localObject);
      ((StringBuilder)localObject).append("}}");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(193234);
      return localObject;
    }
  }
  
  static final class b<D>
    implements y<D>
  {
    final androidx.h.b.b<D> bIC;
    final a.a<D> bIF;
    boolean bIG = false;
    
    b(androidx.h.b.b<D> paramb, a.a<D> parama)
    {
      this.bIC = paramb;
      this.bIF = parama;
    }
    
    public final void onChanged(D paramD)
    {
      AppMethodBeat.i(193181);
      if (b.DEBUG) {
        new StringBuilder("  onLoadFinished in ").append(this.bIC).append(": ").append(this.bIC.dataToString(paramD));
      }
      this.bIF.onLoadFinished(this.bIC, paramD);
      this.bIG = true;
      AppMethodBeat.o(193181);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(193189);
      String str = this.bIF.toString();
      AppMethodBeat.o(193189);
      return str;
    }
  }
  
  static class c
    extends af
  {
    private static final ah.b bDl;
    h<b.a> bIH;
    boolean bII;
    
    static
    {
      AppMethodBeat.i(193184);
      bDl = new ah.b()
      {
        public final <T extends af> T create(Class<T> paramAnonymousClass)
        {
          AppMethodBeat.i(193191);
          paramAnonymousClass = new b.c();
          AppMethodBeat.o(193191);
          return paramAnonymousClass;
        }
      };
      AppMethodBeat.o(193184);
    }
    
    c()
    {
      AppMethodBeat.i(193173);
      this.bIH = new h();
      this.bII = false;
      AppMethodBeat.o(193173);
    }
    
    static c b(aj paramaj)
    {
      AppMethodBeat.i(193178);
      paramaj = (c)new ah(paramaj, bDl).q(c.class);
      AppMethodBeat.o(193178);
      return paramaj;
    }
    
    public void onCleared()
    {
      AppMethodBeat.i(193192);
      super.onCleared();
      int j = this.bIH.size();
      int i = 0;
      while (i < j)
      {
        ((b.a)this.bIH.bl(i)).Hs();
        i += 1;
      }
      this.bIH.clear();
      AppMethodBeat.o(193192);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.h.a.b
 * JD-Core Version:    0.7.0.1
 */