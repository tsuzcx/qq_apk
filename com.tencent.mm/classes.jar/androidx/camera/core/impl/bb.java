package androidx.camera.core.impl;

import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CameraDevice.StateCallback;
import androidx.camera.core.a.a.b.b;
import androidx.camera.core.al;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class bb
{
  public final List<ad> Fs;
  public final List<CameraDevice.StateCallback> Na;
  public final List<CameraCaptureSession.StateCallback> Nb;
  final List<h> Nc;
  public final List<c> Nd;
  public final z Ne;
  
  bb(List<ad> paramList, List<CameraDevice.StateCallback> paramList1, List<CameraCaptureSession.StateCallback> paramList2, List<h> paramList3, List<c> paramList4, z paramz)
  {
    AppMethodBeat.i(198840);
    this.Fs = paramList;
    this.Na = Collections.unmodifiableList(paramList1);
    this.Nb = Collections.unmodifiableList(paramList2);
    this.Nc = Collections.unmodifiableList(paramList3);
    this.Nd = Collections.unmodifiableList(paramList4);
    this.Ne = paramz;
    AppMethodBeat.o(198840);
  }
  
  public static bb kx()
  {
    AppMethodBeat.i(198846);
    bb localbb = new bb(new ArrayList(), new ArrayList(0), new ArrayList(0), new ArrayList(0), new ArrayList(0), new z.a().kc());
    AppMethodBeat.o(198846);
    return localbb;
  }
  
  public static class a
  {
    public final Set<ad> LY;
    final List<CameraDevice.StateCallback> Na;
    final List<CameraCaptureSession.StateCallback> Nb;
    public final List<h> Nc;
    final List<bb.c> Nd;
    public final z.a Nf;
    
    a()
    {
      AppMethodBeat.i(198775);
      this.LY = new LinkedHashSet();
      this.Nf = new z.a();
      this.Na = new ArrayList();
      this.Nb = new ArrayList();
      this.Nd = new ArrayList();
      this.Nc = new ArrayList();
      AppMethodBeat.o(198775);
    }
  }
  
  public static final class b
    extends bb.a
  {
    public static b b(bk<?> parambk)
    {
      AppMethodBeat.i(198781);
      bb.d locald = parambk.kH();
      if (locald == null)
      {
        parambk = new IllegalStateException("Implementation is missing option unpacker for " + parambk.ag(parambk.toString()));
        AppMethodBeat.o(198781);
        throw parambk;
      }
      b localb = new b();
      locald.a(parambk, localb);
      AppMethodBeat.o(198781);
      return localb;
    }
    
    public final void a(CameraCaptureSession.StateCallback paramStateCallback)
    {
      AppMethodBeat.i(198804);
      if (this.Nb.contains(paramStateCallback))
      {
        AppMethodBeat.o(198804);
        return;
      }
      this.Nb.add(paramStateCallback);
      AppMethodBeat.o(198804);
    }
    
    public final void a(CameraDevice.StateCallback paramStateCallback)
    {
      AppMethodBeat.i(198798);
      if (this.Na.contains(paramStateCallback))
      {
        AppMethodBeat.o(198798);
        return;
      }
      this.Na.add(paramStateCallback);
      AppMethodBeat.o(198798);
    }
    
    public final void a(bb.c paramc)
    {
      AppMethodBeat.i(198826);
      this.Nd.add(paramc);
      AppMethodBeat.o(198826);
    }
    
    public final void aW(int paramInt)
    {
      this.Nf.LW = paramInt;
    }
    
    public final void b(ad paramad)
    {
      AppMethodBeat.i(198830);
      this.LY.add(paramad);
      this.Nf.b(paramad);
      AppMethodBeat.o(198830);
    }
    
    public final void b(h paramh)
    {
      AppMethodBeat.i(198819);
      this.Nf.b(paramh);
      if (!this.Nc.contains(paramh)) {
        this.Nc.add(paramh);
      }
      AppMethodBeat.o(198819);
    }
    
    public final void c(ad paramad)
    {
      AppMethodBeat.i(198835);
      this.LY.add(paramad);
      AppMethodBeat.o(198835);
    }
    
    public final void c(h paramh)
    {
      AppMethodBeat.i(198809);
      this.Nf.b(paramh);
      AppMethodBeat.o(198809);
    }
    
    public final void g(String paramString, Object paramObject)
    {
      AppMethodBeat.i(198793);
      this.Nf.g(paramString, paramObject);
      AppMethodBeat.o(198793);
    }
    
    public final void i(ac paramac)
    {
      AppMethodBeat.i(198844);
      this.Nf.i(paramac);
      AppMethodBeat.o(198844);
    }
    
    public final void j(ac paramac)
    {
      AppMethodBeat.i(198849);
      this.Nf.j(paramac);
      AppMethodBeat.o(198849);
    }
    
    public final bb ky()
    {
      AppMethodBeat.i(198858);
      bb localbb = new bb(new ArrayList(this.LY), this.Na, this.Nb, this.Nc, this.Nd, this.Nf.kc());
      AppMethodBeat.o(198858);
      return localbb;
    }
  }
  
  public static abstract interface c
  {
    public abstract void onError(bb parambb, bb.e parame);
  }
  
  public static abstract interface d
  {
    public abstract void a(bk<?> parambk, bb.b paramb);
  }
  
  public static final class f
    extends bb.a
  {
    private static final List<Integer> Nj;
    private final b Nk;
    private boolean Nl;
    private boolean Nm;
    
    static
    {
      AppMethodBeat.i(198790);
      Nj = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(3) });
      AppMethodBeat.o(198790);
    }
    
    public f()
    {
      AppMethodBeat.i(198778);
      this.Nk = new b();
      this.Nl = true;
      this.Nm = false;
      AppMethodBeat.o(198778);
    }
    
    private static int z(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(198784);
      if (Nj.indexOf(Integer.valueOf(paramInt1)) >= Nj.indexOf(Integer.valueOf(paramInt2)))
      {
        AppMethodBeat.o(198784);
        return paramInt1;
      }
      AppMethodBeat.o(198784);
      return paramInt2;
    }
    
    public final void e(bb parambb)
    {
      AppMethodBeat.i(198799);
      z localz = parambb.Ne;
      if (localz.LW != -1)
      {
        this.Nm = true;
        this.Nf.LW = z(localz.LW, this.Nf.LW);
      }
      bi localbi = parambb.Ne.zU;
      this.Nf.a(localbi);
      this.Na.addAll(parambb.Na);
      this.Nb.addAll(parambb.Nb);
      this.Nf.h(parambb.Ne.Bs);
      this.Nc.addAll(parambb.Nc);
      this.Nd.addAll(parambb.Nd);
      this.LY.addAll(Collections.unmodifiableList(parambb.Fs));
      this.Nf.LY.addAll(Collections.unmodifiableList(localz.Fs));
      if (!this.LY.containsAll(this.Nf.LY))
      {
        al.O("ValidatingBuilder");
        this.Nl = false;
      }
      this.Nf.j(localz.LV);
      AppMethodBeat.o(198799);
    }
    
    public final boolean isValid()
    {
      return (this.Nm) && (this.Nl);
    }
    
    public final bb ky()
    {
      AppMethodBeat.i(198813);
      if (!this.Nl)
      {
        localObject = new IllegalArgumentException("Unsupported session configuration combination");
        AppMethodBeat.o(198813);
        throw ((Throwable)localObject);
      }
      Object localObject = new ArrayList(this.LY);
      this.Nk.N((List)localObject);
      localObject = new bb((List)localObject, this.Na, this.Nb, this.Nc, this.Nd, this.Nf.kc());
      AppMethodBeat.o(198813);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.bb
 * JD-Core Version:    0.7.0.1
 */