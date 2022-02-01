package com.tencent.mm.media.widget.b.a.b;

import android.hardware.camera2.CaptureResult.Key;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera2/effect/result/WCResultKeyCreator;", "", "()V", "TAG", "", "resultConstructor", "Ljava/lang/reflect/Constructor;", "Landroid/hardware/camera2/CaptureResult$Key;", "resultKey", "T", "name", "klass", "Ljava/lang/Class;", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private static final String TAG;
  public static final c nIZ;
  private static Constructor<CaptureResult.Key<?>> nJa;
  
  static
  {
    AppMethodBeat.i(94210);
    nIZ = new c();
    TAG = "CT2.WCRequestKeyCreator";
    AppMethodBeat.o(94210);
  }
  
  public static final <T> CaptureResult.Key<T> i(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(94209);
    s.u(paramString, "name");
    s.u(paramClass, "klass");
    try
    {
      Constructor localConstructor;
      if (nJa == null)
      {
        localConstructor = CaptureResult.Key.class.getConstructor(new Class[] { String.class, paramClass.getClass() });
        nJa = localConstructor;
        s.checkNotNull(localConstructor);
        localConstructor.setAccessible(true);
      }
      try
      {
        localConstructor = nJa;
        s.checkNotNull(localConstructor);
        paramClass = localConstructor.newInstance(new Object[] { paramString, paramClass });
        if (paramClass != null) {
          break label129;
        }
        paramClass = new NullPointerException("null cannot be cast to non-null type android.hardware.camera2.CaptureResult.Key<T of com.tencent.mm.media.widget.camera2.effect.result.WCResultKeyCreator.resultKey>");
        AppMethodBeat.o(94209);
        throw paramClass;
      }
      catch (Exception paramClass)
      {
        s.X("creator result key error ", paramString);
        s.X("cannot call captureResult.Key constructor: ", paramClass.getMessage());
      }
    }
    catch (NoSuchMethodException paramClass)
    {
      for (;;)
      {
        s.X("creator result key method error ", paramString);
        s.X("cannot find captureResult.Key constructor: ", paramClass.getMessage());
      }
    }
    AppMethodBeat.o(94209);
    return null;
    label129:
    paramClass = (CaptureResult.Key)paramClass;
    AppMethodBeat.o(94209);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.b.c
 * JD-Core Version:    0.7.0.1
 */