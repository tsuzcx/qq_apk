package androidx.g.a;

import android.os.Bundle;
import android.os.Looper;
import androidx.b.h;
import androidx.lifecycle.aa;
import androidx.lifecycle.l;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import androidx.lifecycle.y.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class b
  extends a
{
  static boolean DEBUG = false;
  private final l aaQ;
  private final c aaR;
  
  b(l paraml, aa paramaa)
  {
    AppMethodBeat.i(188280);
    this.aaQ = paraml;
    this.aaR = c.a(paramaa);
    AppMethodBeat.o(188280);
  }
  
  private <D> androidx.g.b.b<D> b(a.a<D> parama)
  {
    AppMethodBeat.i(188283);
    try
    {
      this.aaR.aba = true;
      localObject = parama.onCreateLoader(0, null);
      if (localObject == null)
      {
        parama = new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        AppMethodBeat.o(188283);
        throw parama;
      }
    }
    finally
    {
      this.aaR.aba = false;
      AppMethodBeat.o(188283);
    }
    if ((localObject.getClass().isMemberClass()) && (!Modifier.isStatic(localObject.getClass().getModifiers())))
    {
      parama = new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(188283);
      throw parama;
    }
    Object localObject = new a(0, null, (androidx.g.b.b)localObject);
    if (DEBUG) {
      new StringBuilder("  Created new loader ").append(localObject);
    }
    this.aaR.aaZ.put(0, localObject);
    this.aaR.aba = false;
    parama = ((a)localObject).a(this.aaQ, parama);
    AppMethodBeat.o(188283);
    return parama;
  }
  
  public final <D> androidx.g.b.b<D> a(a.a<D> parama)
  {
    AppMethodBeat.i(188287);
    if (this.aaR.aba)
    {
      parama = new IllegalStateException("Called while creating a loader");
      AppMethodBeat.o(188287);
      throw parama;
    }
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      parama = new IllegalStateException("initLoader must be called on the main thread");
      AppMethodBeat.o(188287);
      throw parama;
    }
    a locala = (a)this.aaR.aaZ.b(0, null);
    if (DEBUG) {
      new StringBuilder("initLoader in ").append(this).append(": args=").append(null);
    }
    if (locala == null)
    {
      parama = b(parama);
      AppMethodBeat.o(188287);
      return parama;
    }
    if (DEBUG) {
      new StringBuilder("  Re-using existing loader ").append(locala);
    }
    parama = locala.a(this.aaQ, parama);
    AppMethodBeat.o(188287);
    return parama;
  }
  
  @Deprecated
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    AppMethodBeat.i(188293);
    c localc = this.aaR;
    if (localc.aaZ.size() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Loaders:");
      String str = paramString + "    ";
      int i = 0;
      while (i < localc.aaZ.size())
      {
        a locala = (a)localc.aaZ.aM(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(localc.aaZ.aP(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(locala.toString());
        paramPrintWriter.print(str);
        paramPrintWriter.print("mId=");
        paramPrintWriter.print(locala.mId);
        paramPrintWriter.print(" mArgs=");
        paramPrintWriter.println(locala.aaS);
        paramPrintWriter.print(str);
        paramPrintWriter.print("mLoader=");
        paramPrintWriter.println(locala.aaT);
        locala.aaT.dump(str + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        if (locala.aaU != null)
        {
          paramPrintWriter.print(str);
          paramPrintWriter.print("mCallbacks=");
          paramPrintWriter.println(locala.aaU);
          b localb = locala.aaU;
          paramPrintWriter.print(str + "  ");
          paramPrintWriter.print("mDeliveredData=");
          paramPrintWriter.println(localb.aaX);
        }
        paramPrintWriter.print(str);
        paramPrintWriter.print("mData=");
        paramPrintWriter.println(locala.aaT.dataToString(locala.getValue()));
        paramPrintWriter.print(str);
        paramPrintWriter.print("mStarted=");
        paramPrintWriter.println(locala.ji());
        i += 1;
      }
    }
    AppMethodBeat.o(188293);
  }
  
  public final void jn()
  {
    AppMethodBeat.i(188289);
    c localc = this.aaR;
    int j = localc.aaZ.size();
    int i = 0;
    while (i < j)
    {
      ((a)localc.aaZ.aM(i)).jn();
      i += 1;
    }
    AppMethodBeat.o(188289);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188291);
    Object localObject = new StringBuilder(128);
    ((StringBuilder)localObject).append("LoaderManager{");
    ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this)));
    ((StringBuilder)localObject).append(" in ");
    androidx.core.f.b.a(this.aaQ, (StringBuilder)localObject);
    ((StringBuilder)localObject).append("}}");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(188291);
    return localObject;
  }
  
  public static final class a<D>
    extends r<D>
    implements androidx.g.b.b.b<D>
  {
    private l aaQ;
    final Bundle aaS;
    final androidx.g.b.b<D> aaT;
    b.b<D> aaU;
    private androidx.g.b.b<D> aaV;
    final int mId;
    
    a(int paramInt, Bundle paramBundle, androidx.g.b.b<D> paramb)
    {
      AppMethodBeat.i(188247);
      this.mId = 0;
      this.aaS = null;
      this.aaT = paramb;
      this.aaV = null;
      this.aaT.registerListener(0, this);
      AppMethodBeat.o(188247);
    }
    
    public final void M(D paramD)
    {
      AppMethodBeat.i(188254);
      if (b.DEBUG) {
        new StringBuilder("onLoadComplete: ").append(this);
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        setValue(paramD);
        AppMethodBeat.o(188254);
        return;
      }
      boolean bool = b.DEBUG;
      L(paramD);
      AppMethodBeat.o(188254);
    }
    
    final androidx.g.b.b<D> a(l paraml, a.a<D> parama)
    {
      AppMethodBeat.i(188250);
      parama = new b.b(this.aaT, parama);
      a(paraml, parama);
      if (this.aaU != null) {
        b(this.aaU);
      }
      this.aaQ = paraml;
      this.aaU = parama;
      paraml = this.aaT;
      AppMethodBeat.o(188250);
      return paraml;
    }
    
    public final void b(s<? super D> params)
    {
      AppMethodBeat.i(188252);
      super.b(params);
      this.aaQ = null;
      this.aaU = null;
      AppMethodBeat.o(188252);
    }
    
    public final void jb()
    {
      AppMethodBeat.i(188248);
      if (b.DEBUG) {
        new StringBuilder("  Starting: ").append(this);
      }
      this.aaT.startLoading();
      AppMethodBeat.o(188248);
    }
    
    public final void jh()
    {
      AppMethodBeat.i(188249);
      if (b.DEBUG) {
        new StringBuilder("  Stopping: ").append(this);
      }
      this.aaT.stopLoading();
      AppMethodBeat.o(188249);
    }
    
    final void jn()
    {
      AppMethodBeat.i(188251);
      l locall = this.aaQ;
      b.b localb = this.aaU;
      if ((locall != null) && (localb != null))
      {
        super.b(localb);
        a(locall, localb);
      }
      AppMethodBeat.o(188251);
    }
    
    final androidx.g.b.b<D> jo()
    {
      AppMethodBeat.i(188253);
      if (b.DEBUG) {
        new StringBuilder("  Destroying: ").append(this);
      }
      this.aaT.cancelLoad();
      this.aaT.abandon();
      Object localObject = this.aaU;
      if (localObject != null)
      {
        b((s)localObject);
        if (((b.b)localObject).aaX)
        {
          if (b.DEBUG) {
            new StringBuilder("  Resetting: ").append(((b.b)localObject).aaT);
          }
          ((b.b)localObject).aaW.onLoaderReset(((b.b)localObject).aaT);
        }
      }
      this.aaT.unregisterListener(this);
      this.aaT.reset();
      localObject = this.aaV;
      AppMethodBeat.o(188253);
      return localObject;
    }
    
    public final void setValue(D paramD)
    {
      AppMethodBeat.i(188255);
      super.setValue(paramD);
      if (this.aaV != null)
      {
        this.aaV.reset();
        this.aaV = null;
      }
      AppMethodBeat.o(188255);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(188257);
      Object localObject = new StringBuilder(64);
      ((StringBuilder)localObject).append("LoaderInfo{");
      ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this)));
      ((StringBuilder)localObject).append(" #");
      ((StringBuilder)localObject).append(this.mId);
      ((StringBuilder)localObject).append(" : ");
      androidx.core.f.b.a(this.aaT, (StringBuilder)localObject);
      ((StringBuilder)localObject).append("}}");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(188257);
      return localObject;
    }
  }
  
  static final class b<D>
    implements s<D>
  {
    final androidx.g.b.b<D> aaT;
    final a.a<D> aaW;
    boolean aaX = false;
    
    b(androidx.g.b.b<D> paramb, a.a<D> parama)
    {
      this.aaT = paramb;
      this.aaW = parama;
    }
    
    public final void onChanged(D paramD)
    {
      AppMethodBeat.i(188259);
      if (b.DEBUG) {
        new StringBuilder("  onLoadFinished in ").append(this.aaT).append(": ").append(this.aaT.dataToString(paramD));
      }
      this.aaW.onLoadFinished(this.aaT, paramD);
      this.aaX = true;
      AppMethodBeat.o(188259);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(188260);
      String str = this.aaW.toString();
      AppMethodBeat.o(188260);
      return str;
    }
  }
  
  static class c
    extends x
  {
    private static final y.b aaY;
    h<b.a> aaZ;
    boolean aba;
    
    static
    {
      AppMethodBeat.i(188274);
      aaY = new y.b()
      {
        public final <T extends x> T create(Class<T> paramAnonymousClass)
        {
          AppMethodBeat.i(188262);
          paramAnonymousClass = new b.c();
          AppMethodBeat.o(188262);
          return paramAnonymousClass;
        }
      };
      AppMethodBeat.o(188274);
    }
    
    c()
    {
      AppMethodBeat.i(188265);
      this.aaZ = new h();
      this.aba = false;
      AppMethodBeat.o(188265);
    }
    
    static c a(aa paramaa)
    {
      AppMethodBeat.i(188268);
      paramaa = (c)new y(paramaa, aaY).i(c.class);
      AppMethodBeat.o(188268);
      return paramaa;
    }
    
    public void onCleared()
    {
      AppMethodBeat.i(188271);
      super.onCleared();
      int j = this.aaZ.size();
      int i = 0;
      while (i < j)
      {
        ((b.a)this.aaZ.aM(i)).jo();
        i += 1;
      }
      this.aaZ.clear();
      AppMethodBeat.o(188271);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.g.a.b
 * JD-Core Version:    0.7.0.1
 */