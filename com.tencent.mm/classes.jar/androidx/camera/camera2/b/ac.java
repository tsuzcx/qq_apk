package androidx.camera.camera2.b;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

final class ac
{
  final Set<am> CD;
  final Set<am> CE;
  final Set<am> CF;
  final CameraDevice.StateCallback CG;
  final Executor mExecutor;
  final Object mLock;
  
  ac(Executor paramExecutor)
  {
    AppMethodBeat.i(197639);
    this.mLock = new Object();
    this.CD = new LinkedHashSet();
    this.CE = new LinkedHashSet();
    this.CF = new LinkedHashSet();
    this.CG = new CameraDevice.StateCallback()
    {
      private void hn()
      {
        AppMethodBeat.i(197856);
        LinkedHashSet localLinkedHashSet = new LinkedHashSet();
        synchronized (ac.this.mLock)
        {
          localLinkedHashSet.addAll(ac.this.CF);
          localLinkedHashSet.addAll(ac.this.CD);
          ac.this.mExecutor.execute(new ac.1..ExternalSyntheticLambda0(localLinkedHashSet));
          AppMethodBeat.o(197856);
          return;
        }
      }
      
      private void ho()
      {
        AppMethodBeat.i(197861);
        synchronized (ac.this.mLock)
        {
          List localList = ac.this.hm();
          ac.this.CF.clear();
          ac.this.CD.clear();
          ac.this.CE.clear();
          ??? = localList.iterator();
          if (((Iterator)???).hasNext()) {
            ((am)((Iterator)???).next()).gG();
          }
        }
      }
      
      public final void onClosed(CameraDevice paramAnonymousCameraDevice)
      {
        AppMethodBeat.i(197870);
        ho();
        AppMethodBeat.o(197870);
      }
      
      public final void onDisconnected(CameraDevice paramAnonymousCameraDevice)
      {
        AppMethodBeat.i(197873);
        hn();
        ho();
        AppMethodBeat.o(197873);
      }
      
      public final void onError(CameraDevice paramAnonymousCameraDevice, int paramAnonymousInt)
      {
        AppMethodBeat.i(197868);
        hn();
        ho();
        AppMethodBeat.o(197868);
      }
      
      public final void onOpened(CameraDevice paramAnonymousCameraDevice) {}
    };
    this.mExecutor = paramExecutor;
    AppMethodBeat.o(197639);
  }
  
  final void e(am paramam)
  {
    AppMethodBeat.i(197646);
    Iterator localIterator = hm().iterator();
    while (localIterator.hasNext())
    {
      am localam = (am)localIterator.next();
      if (localam == paramam) {
        break;
      }
      localam.gG();
    }
    AppMethodBeat.o(197646);
  }
  
  final void f(am paramam)
  {
    AppMethodBeat.i(197675);
    e(paramam);
    synchronized (this.mLock)
    {
      this.CF.remove(paramam);
      AppMethodBeat.o(197675);
      return;
    }
  }
  
  final List<am> hj()
  {
    AppMethodBeat.i(197652);
    synchronized (this.mLock)
    {
      ArrayList localArrayList = new ArrayList(this.CD);
      AppMethodBeat.o(197652);
      return localArrayList;
    }
  }
  
  final List<am> hk()
  {
    AppMethodBeat.i(197658);
    synchronized (this.mLock)
    {
      ArrayList localArrayList = new ArrayList(this.CE);
      AppMethodBeat.o(197658);
      return localArrayList;
    }
  }
  
  final List<am> hl()
  {
    AppMethodBeat.i(197666);
    synchronized (this.mLock)
    {
      ArrayList localArrayList = new ArrayList(this.CF);
      AppMethodBeat.o(197666);
      return localArrayList;
    }
  }
  
  final List<am> hm()
  {
    AppMethodBeat.i(197670);
    synchronized (this.mLock)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(hj());
      localArrayList.addAll(hl());
      AppMethodBeat.o(197670);
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.ac
 * JD-Core Version:    0.7.0.1
 */