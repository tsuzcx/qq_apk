package com.tencent.mm.media.widget.b.a.a;

import android.hardware.camera2.CaptureRequest.Key;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.lang.reflect.Constructor;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/widget/camera2/effect/request/WCRequestKeyCreator;", "", "()V", "TAG", "", "requestConstructor", "Ljava/lang/reflect/Constructor;", "Landroid/hardware/camera2/CaptureRequest$Key;", "resultConstructor", "Landroid/hardware/camera2/CaptureResult$Key;", "requestKey", "T", "name", "klass", "Ljava/lang/Class;", "resultKey", "plugin-mediaeditor_release"})
public final class c
{
  private static final String TAG = "MicroMsg.WCRequestKeyCreator";
  private static Constructor<CaptureRequest.Key<?>> hsM;
  public static final c hsN;
  
  static
  {
    AppMethodBeat.i(94202);
    hsN = new c();
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
      if (hsM == null)
      {
        localConstructor = CaptureRequest.Key.class.getConstructor(new Class[] { String.class, paramClass.getClass() });
        hsM = localConstructor;
        if (localConstructor == null) {
          p.gfZ();
        }
        localConstructor.setAccessible(true);
      }
      try
      {
        localConstructor = hsM;
        if (localConstructor == null) {
          p.gfZ();
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