package com.tencent.mm.media.widget.b.a.b;

import android.hardware.camera2.CaptureResult.Key;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.v;
import java.lang.reflect.Constructor;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/widget/camera2/effect/result/WCResultKeyCreator;", "", "()V", "TAG", "", "resultConstructor", "Ljava/lang/reflect/Constructor;", "Landroid/hardware/camera2/CaptureResult$Key;", "resultKey", "T", "name", "klass", "Ljava/lang/Class;", "plugin-mediaeditor_release"})
public final class c
{
  private static final String TAG = "CT2.WCRequestKeyCreator";
  private static Constructor<CaptureResult.Key<?>> hsV;
  public static final c hsW;
  
  static
  {
    AppMethodBeat.i(94210);
    hsW = new c();
    TAG = "CT2.WCRequestKeyCreator";
    AppMethodBeat.o(94210);
  }
  
  public static final <T> CaptureResult.Key<T> e(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(94209);
    p.h(paramString, "name");
    p.h(paramClass, "klass");
    try
    {
      Constructor localConstructor;
      if (hsV == null)
      {
        localConstructor = CaptureResult.Key.class.getConstructor(new Class[] { String.class, paramClass.getClass() });
        hsV = localConstructor;
        if (localConstructor == null) {
          p.gfZ();
        }
        localConstructor.setAccessible(true);
      }
      try
      {
        localConstructor = hsV;
        if (localConstructor == null) {
          p.gfZ();
        }
        paramString = localConstructor.newInstance(new Object[] { paramString, paramClass });
        if (paramString != null) {
          break label135;
        }
        paramString = new v("null cannot be cast to non-null type android.hardware.camera2.CaptureResult.Key<T>");
        AppMethodBeat.o(94209);
        throw paramString;
      }
      catch (Exception paramString)
      {
        new StringBuilder("cannot call captureResult.Key constructor: ").append(paramString.getMessage());
      }
    }
    catch (NoSuchMethodException paramString)
    {
      for (;;)
      {
        new StringBuilder("cannot find captureResult.Key constructor: ").append(paramString.getMessage());
      }
    }
    AppMethodBeat.o(94209);
    return null;
    label135:
    paramString = (CaptureResult.Key)paramString;
    AppMethodBeat.o(94209);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.b.c
 * JD-Core Version:    0.7.0.1
 */