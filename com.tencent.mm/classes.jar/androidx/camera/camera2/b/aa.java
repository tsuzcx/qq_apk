package androidx.camera.camera2.b;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.c.a.b.a;
import androidx.camera.camera2.a.a;
import androidx.camera.camera2.a.c.a;
import androidx.camera.camera2.b.a.a.g;
import androidx.camera.camera2.b.a.a.g.c;
import androidx.camera.core.al;
import androidx.camera.core.impl.a.b.d;
import androidx.camera.core.impl.a.b.e;
import androidx.camera.core.impl.ac;
import androidx.camera.core.impl.ac.a;
import androidx.camera.core.impl.ad;
import androidx.camera.core.impl.at;
import androidx.camera.core.impl.av;
import androidx.camera.core.impl.bb;
import androidx.camera.core.impl.h;
import androidx.camera.core.impl.z.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;

final class aa
  implements ab
{
  private final CameraCaptureSession.CaptureCallback Cd;
  final Object Ce;
  private final List<androidx.camera.core.impl.z> Cf;
  private final b Cg;
  ap Ch;
  am Ci;
  bb Cj;
  ac Ck;
  androidx.camera.camera2.a.c Cl;
  private final Map<ad, Surface> Cm;
  List<ad> Cn;
  a Co;
  com.google.b.b.a.f<Void> Cp;
  b.a<Void> Cq;
  final androidx.camera.camera2.b.a.c.j Cr;
  
  aa()
  {
    AppMethodBeat.i(197661);
    this.Ce = new Object();
    this.Cf = new ArrayList();
    this.Cd = new CameraCaptureSession.CaptureCallback()
    {
      public final void onCaptureCompleted(CameraCaptureSession paramAnonymousCameraCaptureSession, CaptureRequest paramAnonymousCaptureRequest, TotalCaptureResult paramAnonymousTotalCaptureResult) {}
    };
    this.Ck = av.kw();
    this.Cl = androidx.camera.camera2.a.c.fX();
    this.Cm = new HashMap();
    this.Cn = Collections.emptyList();
    this.Co = a.Cu;
    this.Cr = new androidx.camera.camera2.b.a.c.j();
    this.Co = a.Cv;
    this.Cg = new b();
    AppMethodBeat.o(197661);
  }
  
  private static CameraCaptureSession.CaptureCallback a(List<h> paramList, CameraCaptureSession.CaptureCallback... paramVarArgs)
  {
    AppMethodBeat.i(197683);
    ArrayList localArrayList1 = new ArrayList(paramList.size() + 1);
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (h)localIterator.next();
      if (paramList == null) {
        paramList = null;
      }
      for (;;)
      {
        localArrayList1.add(paramList);
        break;
        ArrayList localArrayList2 = new ArrayList();
        z.a(paramList, localArrayList2);
        if (localArrayList2.size() == 1) {
          paramList = (CameraCaptureSession.CaptureCallback)localArrayList2.get(0);
        } else {
          paramList = j.p(localArrayList2);
        }
      }
    }
    Collections.addAll(localArrayList1, paramVarArgs);
    paramList = j.p(localArrayList1);
    AppMethodBeat.o(197683);
    return paramList;
  }
  
  private com.google.b.b.a.f<Void> a(List<Surface> paramList, bb parambb, CameraDevice paramCameraDevice)
  {
    AppMethodBeat.i(197677);
    for (;;)
    {
      synchronized (this.Ce)
      {
        switch (3.Ct[this.Co.ordinal()])
        {
        case 4: 
          paramList = e.i(new CancellationException("openCaptureSession() not execute in state: " + this.Co));
          AppMethodBeat.o(197677);
          return paramList;
        case 1: 
        case 2: 
        case 5: 
          paramList = e.i(new IllegalStateException("openCaptureSession() should not be possible in state: " + this.Co));
          AppMethodBeat.o(197677);
          return paramList;
        case 3: 
          this.Cm.clear();
          int i = 0;
          if (i < paramList.size())
          {
            this.Cm.put((ad)this.Cn.get(i), (Surface)paramList.get(i));
            i += 1;
            continue;
          }
          localObject2 = new ArrayList(new LinkedHashSet(paramList));
          this.Co = a.Cx;
          al.O("CaptureSession");
          paramList = new aq(Arrays.asList(new am.a[] { this.Cg, new aq.a(parambb.Nb) }));
          this.Cl = new a(parambb.Ne.LV).a(androidx.camera.camera2.a.c.fX());
          localObject3 = this.Cl.fW().fZ();
          parambb = z.a.a(parambb.Ne);
          localObject3 = ((List)localObject3).iterator();
          if (((Iterator)localObject3).hasNext()) {
            parambb.j(((androidx.camera.core.impl.z)((Iterator)localObject3).next()).LV);
          }
          break;
        }
      }
      Object localObject3 = new ArrayList();
      Object localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject3).add(new androidx.camera.camera2.b.a.a.b((Surface)((Iterator)localObject2).next()));
      }
      paramList = this.Ch.EB.a((List)localObject3, paramList);
      try
      {
        parambb = m.a(parambb.kc(), paramCameraDevice);
        if (parambb != null) {
          paramList.Fw.b(parambb);
        }
        parambb = this.Ch;
        localObject2 = this.Cn;
        paramList = parambb.EB.a(paramCameraDevice, paramList, (List)localObject2);
        AppMethodBeat.o(197677);
        return paramList;
      }
      catch (CameraAccessException paramList)
      {
        paramList = e.i(paramList);
        AppMethodBeat.o(197677);
        return paramList;
      }
    }
  }
  
  private static ac u(List<androidx.camera.core.impl.z> paramList)
  {
    AppMethodBeat.i(197693);
    at localat = at.ku();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ac localac = ((androidx.camera.core.impl.z)paramList.next()).LV;
      Iterator localIterator = localac.ke().iterator();
      while (localIterator.hasNext())
      {
        ac.a locala = (ac.a)localIterator.next();
        Object localObject1 = localac.b(locala, null);
        if (localat.a(locala))
        {
          Object localObject2 = localat.b(locala, null);
          if (!Objects.equals(localObject2, localObject1))
          {
            new StringBuilder("Detect conflicting option ").append(locala.getId()).append(" : ").append(localObject1).append(" != ").append(localObject2);
            al.O("CaptureSession");
          }
        }
        else
        {
          localat.c(locala, localObject1);
        }
      }
    }
    AppMethodBeat.o(197693);
    return localat;
  }
  
  public final com.google.b.b.a.f<Void> a(bb parambb, CameraDevice paramCameraDevice, ap paramap)
  {
    AppMethodBeat.i(197762);
    for (;;)
    {
      synchronized (this.Ce)
      {
        switch (3.Ct[this.Co.ordinal()])
        {
        case 2: 
          new StringBuilder("Open not allowed in state: ").append(this.Co);
          al.T("CaptureSession");
          parambb = e.i(new IllegalStateException("open() should not allow the state: " + this.Co));
          AppMethodBeat.o(197762);
          return parambb;
          this.Co = a.Cw;
          this.Cn = new ArrayList(Collections.unmodifiableList(parambb.Fs));
          this.Ch = paramap;
          paramap = this.Ch;
          List localList = this.Cn;
          parambb = d.c(paramap.EB.a(localList, 5000L)).a(new aa..ExternalSyntheticLambda2(this, parambb, paramCameraDevice), this.Ch.hI());
          e.a(parambb, new androidx.camera.core.impl.a.b.c()
          {
            public final void onFailure(Throwable paramAnonymousThrowable)
            {
              AppMethodBeat.i(197845);
              for (;;)
              {
                synchronized (aa.this.Ce)
                {
                  aa.this.Ch.stop();
                  switch (aa.3.Ct[aa.this.Co.ordinal()])
                  {
                  case 5: 
                    AppMethodBeat.o(197845);
                    return;
                  case 4: 
                  case 6: 
                  case 7: 
                    if (!(paramAnonymousThrowable instanceof CancellationException))
                    {
                      new StringBuilder("Opening session with fail ").append(aa.this.Co);
                      al.S("CaptureSession");
                      aa.this.gG();
                    }
                    break;
                  }
                }
              }
            }
          }, this.Ch.hI());
          parambb = e.d(parambb);
          AppMethodBeat.o(197762);
          return parambb;
        }
      }
    }
  }
  
  public final com.google.b.b.a.f<Void> ab(boolean paramBoolean)
  {
    AppMethodBeat.i(197791);
    for (;;)
    {
      synchronized (this.Ce)
      {
        switch (3.Ct[this.Co.ordinal()])
        {
        case 1: 
          ??? = e.v(null);
          AppMethodBeat.o(197791);
          return ???;
          IllegalStateException localIllegalStateException = new IllegalStateException("release() should not be possible in state: " + this.Co);
          AppMethodBeat.o(197791);
          throw localIllegalStateException;
        }
      }
      am localam = this.Ci;
      if ((localam == null) || (paramBoolean)) {}
      try
      {
        this.Ci.hG();
        this.Ci.close();
        this.Co = a.CA;
        androidx.core.f.f.checkNotNull(this.Ch, "The Opener shouldn't null in state:" + this.Co);
        if (this.Ch.stop()) {
          gG();
        }
      }
      catch (CameraAccessException localCameraAccessException)
      {
        for (;;)
        {
          al.U("CaptureSession");
        }
        if (this.Cp == null) {
          this.Cp = androidx.c.a.b.a(new aa..ExternalSyntheticLambda0(this));
        }
        com.google.b.b.a.f localf = this.Cp;
        AppMethodBeat.o(197791);
        return localf;
      }
      androidx.core.f.f.checkNotNull(this.Ch, "The Opener shouldn't null in state:" + this.Co);
      this.Ch.stop();
      this.Co = a.CB;
    }
  }
  
  public final void b(bb parambb)
  {
    AppMethodBeat.i(197750);
    for (;;)
    {
      synchronized (this.Ce)
      {
        switch (3.Ct[this.Co.ordinal()])
        {
        case 1: 
          AppMethodBeat.o(197750);
          return;
          parambb = new IllegalStateException("setSessionConfig() should not be possible in state: " + this.Co);
          AppMethodBeat.o(197750);
          throw parambb;
        }
      }
      this.Cj = parambb;
      continue;
      this.Cj = parambb;
      if (parambb == null)
      {
        AppMethodBeat.o(197750);
        return;
      }
      if (!this.Cm.keySet().containsAll(Collections.unmodifiableList(parambb.Fs)))
      {
        al.T("CaptureSession");
        AppMethodBeat.o(197750);
        return;
      }
      al.O("CaptureSession");
      c(this.Cj);
      continue;
      parambb = new IllegalStateException("Session configuration cannot be set on a closed/released session.");
      AppMethodBeat.o(197750);
      throw parambb;
    }
  }
  
  final int c(bb parambb)
  {
    AppMethodBeat.i(197829);
    Object localObject1 = this.Ce;
    if (parambb == null) {}
    try
    {
      al.O("CaptureSession");
      return -1;
    }
    finally
    {
      AppMethodBeat.o(197829);
    }
    parambb = parambb.Ne;
    if (Collections.unmodifiableList(parambb.Fs).isEmpty())
    {
      al.O("CaptureSession");
      try
      {
        this.Ci.hF();
        AppMethodBeat.o(197829);
        return -1;
      }
      catch (CameraAccessException parambb)
      {
        for (;;)
        {
          new StringBuilder("Unable to access camera: ").append(parambb.getMessage());
          al.T("CaptureSession");
          Thread.dumpStack();
        }
      }
    }
    try
    {
      al.O("CaptureSession");
      Object localObject2 = z.a.a(parambb);
      this.Ck = u(this.Cl.fW().gb());
      ((z.a)localObject2).j(this.Ck);
      localObject2 = m.a(((z.a)localObject2).kc(), this.Ci.hC(), this.Cm);
      if (localObject2 == null)
      {
        al.O("CaptureSession");
        AppMethodBeat.o(197829);
        return -1;
      }
      parambb = a(parambb.Bs, new CameraCaptureSession.CaptureCallback[] { this.Cd });
      int i = this.Ci.a((CaptureRequest)localObject2, parambb);
      AppMethodBeat.o(197829);
      return i;
    }
    catch (CameraAccessException parambb)
    {
      new StringBuilder("Unable to access camera: ").append(parambb.getMessage());
      al.T("CaptureSession");
      Thread.dumpStack();
      AppMethodBeat.o(197829);
    }
    return -1;
  }
  
  public final void close()
  {
    AppMethodBeat.i(197775);
    for (;;)
    {
      synchronized (this.Ce)
      {
        switch (3.Ct[this.Co.ordinal()])
        {
        case 1: 
          AppMethodBeat.o(197775);
          return;
          IllegalStateException localIllegalStateException1 = new IllegalStateException("close() should not be possible in state: " + this.Co);
          AppMethodBeat.o(197775);
          throw localIllegalStateException1;
        }
      }
      androidx.core.f.f.checkNotNull(this.Ch, "The Opener shouldn't null in state:" + this.Co);
      this.Ch.stop();
      this.Co = a.CB;
      continue;
      List localList;
      if (this.Cj != null)
      {
        localList = this.Cl.fW().gc();
        boolean bool = localList.isEmpty();
        if (bool) {}
      }
      try
      {
        s(v(localList));
        androidx.core.f.f.checkNotNull(this.Ch, "The Opener shouldn't null in state:" + this.Co);
        this.Ch.stop();
        this.Co = a.Cz;
        this.Cj = null;
      }
      catch (IllegalStateException localIllegalStateException2)
      {
        for (;;)
        {
          al.U("CaptureSession");
        }
      }
    }
  }
  
  final void gG()
  {
    AppMethodBeat.i(197817);
    if (this.Co == a.CB)
    {
      al.O("CaptureSession");
      AppMethodBeat.o(197817);
      return;
    }
    this.Co = a.CB;
    this.Ci = null;
    if (this.Cq != null)
    {
      this.Cq.ap(null);
      this.Cq = null;
    }
    AppMethodBeat.o(197817);
  }
  
  public final bb gh()
  {
    synchronized (this.Ce)
    {
      bb localbb = this.Cj;
      return localbb;
    }
  }
  
  public final List<androidx.camera.core.impl.z> hg()
  {
    AppMethodBeat.i(197810);
    synchronized (this.Ce)
    {
      List localList = Collections.unmodifiableList(this.Cf);
      AppMethodBeat.o(197810);
      return localList;
    }
  }
  
  final void hh()
  {
    AppMethodBeat.i(197839);
    if (this.Cf.isEmpty())
    {
      AppMethodBeat.o(197839);
      return;
    }
    try
    {
      t(this.Cf);
      return;
    }
    finally
    {
      this.Cf.clear();
      AppMethodBeat.o(197839);
    }
  }
  
  public final void hi()
  {
    AppMethodBeat.i(197855);
    Object localObject1 = null;
    synchronized (this.Ce)
    {
      if (!this.Cf.isEmpty())
      {
        localObject1 = new ArrayList(this.Cf);
        this.Cf.clear();
      }
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ??? = ((androidx.camera.core.impl.z)((Iterator)localObject1).next()).Bs.iterator();
          if (((Iterator)???).hasNext()) {
            ((h)((Iterator)???).next()).gB();
          }
        }
      }
    }
    AppMethodBeat.o(197855);
  }
  
  public final void s(List<androidx.camera.core.impl.z> paramList)
  {
    AppMethodBeat.i(197804);
    for (;;)
    {
      synchronized (this.Ce)
      {
        switch (3.Ct[this.Co.ordinal()])
        {
        case 1: 
          AppMethodBeat.o(197804);
          return;
          paramList = new IllegalStateException("issueCaptureRequests() should not be possible in state: " + this.Co);
          AppMethodBeat.o(197804);
          throw paramList;
        }
      }
      this.Cf.addAll(paramList);
      continue;
      this.Cf.addAll(paramList);
      hh();
      continue;
      paramList = new IllegalStateException("Cannot issue capture request on a closed/released session.");
      AppMethodBeat.o(197804);
      throw paramList;
    }
  }
  
  final int t(List<androidx.camera.core.impl.z> paramList)
  {
    AppMethodBeat.i(197850);
    for (;;)
    {
      r localr;
      ArrayList localArrayList1;
      boolean bool;
      Object localObject3;
      Object localObject4;
      synchronized (this.Ce)
      {
        if (paramList.isEmpty())
        {
          AppMethodBeat.o(197850);
          return -1;
        }
        try
        {
          localr = new r();
          localArrayList1 = new ArrayList();
          bool = false;
          al.O("CaptureSession");
          paramList = paramList.iterator();
          if (!paramList.hasNext()) {
            break label504;
          }
          localObject2 = (androidx.camera.core.impl.z)paramList.next();
          if (!Collections.unmodifiableList(((androidx.camera.core.impl.z)localObject2).Fs).isEmpty()) {
            continue;
          }
          al.O("CaptureSession");
          continue;
        }
        catch (CameraAccessException paramList)
        {
          new StringBuilder("Unable to access camera: ").append(paramList.getMessage());
          al.T("CaptureSession");
          Thread.dumpStack();
        }
        AppMethodBeat.o(197850);
        return -1;
        localObject3 = Collections.unmodifiableList(((androidx.camera.core.impl.z)localObject2).Fs).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label586;
        }
        localObject4 = (ad)((Iterator)localObject3).next();
        if (this.Cm.containsKey(localObject4)) {
          continue;
        }
        "Skipping capture request with invalid surface: ".concat(String.valueOf(localObject4));
        al.O("CaptureSession");
        i = 0;
        if (i == 0) {
          continue;
        }
        if (((androidx.camera.core.impl.z)localObject2).LW != 2) {
          break label583;
        }
        bool = true;
        localObject3 = z.a.a((androidx.camera.core.impl.z)localObject2);
        if (this.Cj != null) {
          ((z.a)localObject3).j(this.Cj.Ne.LV);
        }
        ((z.a)localObject3).j(this.Ck);
        ((z.a)localObject3).j(((androidx.camera.core.impl.z)localObject2).LV);
        localObject3 = m.a(((z.a)localObject3).kc(), this.Ci.hC(), this.Cm);
        if (localObject3 == null)
        {
          al.O("CaptureSession");
          AppMethodBeat.o(197850);
          return -1;
        }
        localObject4 = new ArrayList();
        localObject2 = ((androidx.camera.core.impl.z)localObject2).Bs.iterator();
        if (((Iterator)localObject2).hasNext()) {
          z.a((h)((Iterator)localObject2).next(), (List)localObject4);
        }
      }
      Object localObject2 = (List)localr.BY.get(localObject3);
      if (localObject2 != null)
      {
        ArrayList localArrayList2 = new ArrayList(((List)localObject4).size() + ((List)localObject2).size());
        localArrayList2.addAll((Collection)localObject4);
        localArrayList2.addAll((Collection)localObject2);
        localr.BY.put(localObject3, localArrayList2);
      }
      for (;;)
      {
        localArrayList1.add(localObject3);
        break;
        localr.BY.put(localObject3, localObject4);
      }
      label504:
      if (!localArrayList1.isEmpty())
      {
        if (this.Cr.a(localArrayList1, bool))
        {
          this.Ci.hF();
          localr.BZ = new aa..ExternalSyntheticLambda1(this);
        }
        i = this.Ci.a(localArrayList1, localr);
        AppMethodBeat.o(197850);
        return i;
      }
      al.O("CaptureSession");
      continue;
      label583:
      continue;
      label586:
      int i = 1;
    }
  }
  
  final List<androidx.camera.core.impl.z> v(List<androidx.camera.core.impl.z> paramList)
  {
    AppMethodBeat.i(197860);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      z.a locala = z.a.a((androidx.camera.core.impl.z)paramList.next());
      locala.LW = 1;
      Iterator localIterator = Collections.unmodifiableList(this.Cj.Ne.Fs).iterator();
      while (localIterator.hasNext()) {
        locala.b((ad)localIterator.next());
      }
      localArrayList.add(locala.kc());
    }
    AppMethodBeat.o(197860);
    return localArrayList;
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(197808);
      Cu = new a("UNINITIALIZED", 0);
      Cv = new a("INITIALIZED", 1);
      Cw = new a("GET_SURFACE", 2);
      Cx = new a("OPENING", 3);
      Cy = new a("OPENED", 4);
      Cz = new a("CLOSED", 5);
      CA = new a("RELEASING", 6);
      CB = new a("RELEASED", 7);
      CC = new a[] { Cu, Cv, Cw, Cx, Cy, Cz, CA, CB };
      AppMethodBeat.o(197808);
    }
    
    private a() {}
  }
  
  final class b
    extends am.a
  {
    b() {}
    
    public final void a(am paramam)
    {
      AppMethodBeat.i(197813);
      for (;;)
      {
        synchronized (aa.this.Ce)
        {
          switch (aa.3.Ct[aa.this.Co.ordinal()])
          {
          case 1: 
            new StringBuilder("CameraCaptureSession.onConfigured() mState=").append(aa.this.Co);
            al.O("CaptureSession");
            AppMethodBeat.o(197813);
            return;
          case 2: 
          case 3: 
          case 5: 
          case 8: 
            paramam = new IllegalStateException("onConfigured() should not be possible in state: " + aa.this.Co);
            AppMethodBeat.o(197813);
            throw paramam;
          }
        }
        aa.this.Co = aa.a.Cy;
        aa.this.Ci = paramam;
        if (aa.this.Cj != null)
        {
          paramam = aa.this.Cl.fW().ga();
          if (!paramam.isEmpty()) {
            aa.this.t(aa.this.v(paramam));
          }
        }
        al.O("CaptureSession");
        aa.this.c(aa.this.Cj);
        aa.this.hh();
        continue;
        aa.this.Ci = paramam;
        continue;
        paramam.close();
      }
    }
    
    public final void b(am arg1)
    {
      AppMethodBeat.i(197820);
      for (;;)
      {
        synchronized (aa.this.Ce)
        {
          switch (aa.3.Ct[aa.this.Co.ordinal()])
          {
          case 1: 
            new StringBuilder("CameraCaptureSession.onReady() ").append(aa.this.Co);
            al.O("CaptureSession");
            AppMethodBeat.o(197820);
            return;
            IllegalStateException localIllegalStateException = new IllegalStateException("onReady() should not be possible in state: " + aa.this.Co);
            AppMethodBeat.o(197820);
            throw localIllegalStateException;
          }
        }
      }
    }
    
    public final void c(am arg1)
    {
      AppMethodBeat.i(197828);
      synchronized (aa.this.Ce)
      {
        if (aa.this.Co == aa.a.Cu)
        {
          IllegalStateException localIllegalStateException = new IllegalStateException("onSessionFinished() should not be possible in state: " + aa.this.Co);
          AppMethodBeat.o(197828);
          throw localIllegalStateException;
        }
      }
      al.O("CaptureSession");
      aa.this.gG();
      AppMethodBeat.o(197828);
    }
    
    public final void d(am arg1)
    {
      AppMethodBeat.i(197837);
      for (;;)
      {
        synchronized (aa.this.Ce)
        {
          switch (aa.3.Ct[aa.this.Co.ordinal()])
          {
          case 1: 
            new StringBuilder("CameraCaptureSession.onConfigureFailed() ").append(aa.this.Co);
            al.T("CaptureSession");
            AppMethodBeat.o(197837);
            return;
          case 2: 
          case 3: 
          case 5: 
            IllegalStateException localIllegalStateException = new IllegalStateException("onConfigureFailed() should not be possible in state: " + aa.this.Co);
            AppMethodBeat.o(197837);
            throw localIllegalStateException;
          }
        }
        aa.this.gG();
        continue;
        al.O("CaptureSession");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.aa
 * JD-Core Version:    0.7.0.1
 */