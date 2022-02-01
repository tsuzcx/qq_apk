package com.tencent.mm.media.widget.b.a.a;

import android.hardware.camera2.CaptureRequest.Key;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.lang.reflect.Constructor;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/widget/camera2/effect/request/WCRequestKeyCreator;", "", "()V", "TAG", "", "requestConstructor", "Ljava/lang/reflect/Constructor;", "Landroid/hardware/camera2/CaptureRequest$Key;", "resultConstructor", "Landroid/hardware/camera2/CaptureResult$Key;", "requestKey", "T", "name", "klass", "Ljava/lang/Class;", "resultKey", "plugin-mediaeditor_release"})
public final class c
{
  private static final String TAG = "MicroMsg.WCRequestKeyCreator";
  private static Constructor<CaptureRequest.Key<?>> hvA;
  public static final c hvB;
  
  static
  {
    AppMethodBeat.i(94202);
    hvB = new c();
    TAG = "MicroMsg.WCRequestKeyCreator";
    AppMethodBeat.o(94202);
  }
  
  public static final <T> CaptureRequest.Key<T> d(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(94201);
    p.h(paramString, "name");
    p.h(paramClass, "klass");
    try
    {
      Constructor localConstructor;
      if (hvA == null)
      {
        localConstructor = CaptureRequest.Key.class.getConstructor(new Class[] { String.class, paramClass.getClass() });
        hvA = localConstructor;
        if (localConstructor == null) {
          p.gkB();
        }
        localConstructor.setAccessible(true);
      }
      try
      {
        localConstructor = hvA;
        if (localConstructor == null) {
          p.gkB();
        }
        paramString = (CaptureRequest.Key)localConstructor.newInstance(new Object[] { paramString, paramClass });
        AppMethodBeat.o(94201);
        return paramString;
      }
      catch (Exception paramString)
      {
        new StringBuilder("cannot call captureRequest.Key constructor: ").append(paramString.getMessage());
      }
    }
    catch (NoSuchMethodException paramString)
    {
      for (;;)
      {
        new StringBuilder("cannot find captureRequest.Key constructor: ").append(paramString.getMessage());
      }
    }
    AppMethodBeat.o(94201);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */