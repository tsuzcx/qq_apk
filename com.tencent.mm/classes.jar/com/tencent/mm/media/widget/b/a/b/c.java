package com.tencent.mm.media.widget.b.a.b;

import android.hardware.camera2.CaptureResult.Key;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.v;
import java.lang.reflect.Constructor;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/widget/camera2/effect/result/WCResultKeyCreator;", "", "()V", "TAG", "", "resultConstructor", "Ljava/lang/reflect/Constructor;", "Landroid/hardware/camera2/CaptureResult$Key;", "resultKey", "T", "name", "klass", "Ljava/lang/Class;", "plugin-mediaeditor_release"})
public final class c
{
  private static final String TAG = "CT2.WCRequestKeyCreator";
  private static Constructor<CaptureResult.Key<?>> gAs;
  public static final c gAt;
  
  static
  {
    AppMethodBeat.i(94210);
    gAt = new c();
    TAG = "CT2.WCRequestKeyCreator";
    AppMethodBeat.o(94210);
  }
  
  public static final <T> CaptureResult.Key<T> e(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(94209);
    k.h(paramString, "name");
    k.h(paramClass, "klass");
    try
    {
      Constructor localConstructor;
      if (gAs == null)
      {
        localConstructor = CaptureResult.Key.class.getConstructor(new Class[] { String.class, paramClass.getClass() });
        gAs = localConstructor;
        if (localConstructor == null) {
          k.fvU();
        }
        localConstructor.setAccessible(true);
      }
      try
      {
        localConstructor = gAs;
        if (localConstructor == null) {
          k.fvU();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.b.c
 * JD-Core Version:    0.7.0.1
 */