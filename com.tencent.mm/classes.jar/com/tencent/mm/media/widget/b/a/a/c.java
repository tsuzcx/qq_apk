package com.tencent.mm.media.widget.b.a.a;

import android.hardware.camera2.CaptureRequest.Key;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera2/effect/request/WCRequestKeyCreator;", "", "()V", "TAG", "", "requestConstructor", "Ljava/lang/reflect/Constructor;", "Landroid/hardware/camera2/CaptureRequest$Key;", "resultConstructor", "Landroid/hardware/camera2/CaptureResult$Key;", "requestKey", "T", "name", "klass", "Ljava/lang/Class;", "resultKey", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private static final String TAG;
  public static final c nIQ;
  private static Constructor<CaptureRequest.Key<?>> nIR;
  
  static
  {
    AppMethodBeat.i(94202);
    nIQ = new c();
    TAG = "MicroMsg.WCRequestKeyCreator";
    AppMethodBeat.o(94202);
  }
  
  public static final <T> CaptureRequest.Key<T> h(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(94201);
    s.u(paramString, "name");
    s.u(paramClass, "klass");
    try
    {
      Constructor localConstructor;
      if (nIR == null)
      {
        localConstructor = CaptureRequest.Key.class.getConstructor(new Class[] { String.class, paramClass.getClass() });
        nIR = localConstructor;
        s.checkNotNull(localConstructor);
        localConstructor.setAccessible(true);
      }
      try
      {
        localConstructor = nIR;
        s.checkNotNull(localConstructor);
        paramClass = (CaptureRequest.Key)localConstructor.newInstance(new Object[] { paramString, paramClass });
        AppMethodBeat.o(94201);
        return paramClass;
      }
      catch (Exception paramClass)
      {
        s.X("create request key error ", paramString);
        s.X("cannot call captureRequest.Key constructor: ", paramClass.getMessage());
      }
    }
    catch (NoSuchMethodException paramClass)
    {
      for (;;)
      {
        s.X("create request key method error ", paramString);
        s.X("cannot find captureRequest.Key constructor: ", paramClass.getMessage());
      }
    }
    AppMethodBeat.o(94201);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */