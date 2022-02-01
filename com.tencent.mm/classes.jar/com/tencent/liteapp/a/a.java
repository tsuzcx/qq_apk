package com.tencent.liteapp.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ext.ui.e;
import io.flutter.plugin.a.j;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/liteapp/channel/WxaLiteAppConsumer;", "Lcom/tencent/wxa/MethodCallConsumer;", "()V", "consume", "Lcom/tencent/wxa/MethodCallConsumer$Result;", "call", "Lio/flutter/plugin/common/MethodCall;", "enterFullScreen", "args", "", "exitFullScreen", "getCutOutHeight", "hasCutOut", "hideKeyboard", "inputLocationChange", "navigateBack", "Companion", "wxa_lite_app_release"})
public final class a
  extends com.tencent.wxa.a
{
  private static final String TAG = "WxaLiteApp.WxaLiteAppConsumer";
  public static final a.a cqS;
  
  static
  {
    AppMethodBeat.i(197924);
    cqS = new a.a((byte)0);
    TAG = "WxaLiteApp.WxaLiteAppConsumer";
    AppMethodBeat.o(197924);
  }
  
  public final com.tencent.wxa.a.a a(j paramj)
  {
    AppMethodBeat.i(197923);
    if (paramj == null) {
      p.hyc();
    }
    Object localObject = paramj.method;
    paramj = paramj.SxX;
    com.tencent.liteapp.b.b.d(TAG, "consume method: ".concat(String.valueOf(localObject)), new Object[0]);
    if (localObject == null) {}
    label238:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                for (;;)
                {
                  paramj = hrG();
                  p.g(paramj, "consumeSkip()");
                  AppMethodBeat.o(197923);
                  return paramj;
                  switch (((String)localObject).hashCode())
                  {
                  }
                }
              } while (!((String)localObject).equals("inputLocationChange"));
              p.g(paramj, "args");
              localObject = com.tencent.wxa.c.hrH();
              p.g(localObject, "WxaRouter.getInstance()");
              localObject = ((com.tencent.wxa.c)localObject).hrJ();
              p.g(localObject, "WxaRouter.getInstance().currentActivity");
              localObject = ((com.tencent.wxa.b.b)localObject).getActivity();
              if (localObject != null) {
                break;
              }
              paramj = eI(Boolean.TRUE);
              p.g(paramj, "consumed(true)");
              AppMethodBeat.o(197923);
              return paramj;
            } while (!((String)localObject).equals("hideKeyboard"));
            paramj = com.tencent.wxa.c.hrH();
            p.g(paramj, "WxaRouter.getInstance()");
            paramj = paramj.hrJ();
            p.g(paramj, "WxaRouter.getInstance().currentActivity");
            paramj = paramj.getActivity();
            if (paramj != null) {
              break label899;
            }
            paramj = eI(Boolean.TRUE);
            p.g(paramj, "consumed(true)");
            AppMethodBeat.o(197923);
            return paramj;
          } while (!((String)localObject).equals("hasCutOut"));
          paramj = com.tencent.wxa.c.hrH();
          p.g(paramj, "WxaRouter.getInstance()");
          paramj = paramj.hrJ();
          p.g(paramj, "WxaRouter.getInstance().currentActivity");
          paramj = eI(Boolean.valueOf(e.cI((Context)paramj.getActivity())));
          p.g(paramj, "consumed(result)");
          AppMethodBeat.o(197923);
          return paramj;
        } while (!((String)localObject).equals("enterFullScreen"));
        p.g(paramj, "args");
        paramj = com.tencent.wxa.c.hrH();
        p.g(paramj, "WxaRouter.getInstance()");
        paramj = paramj.hrJ();
        p.g(paramj, "WxaRouter.getInstance().currentActivity");
        paramj = paramj.getActivity();
        if (paramj != null) {
          break label937;
        }
        paramj = eI(Boolean.TRUE);
        p.g(paramj, "consumed(true)");
        AppMethodBeat.o(197923);
        return paramj;
      } while (!((String)localObject).equals("getCutOutHeight"));
      paramj = com.tencent.liteapp.a.cqJ;
      paramj = com.tencent.liteapp.a.a.getAppContext();
      localObject = com.tencent.liteapp.a.cqJ;
      paramj = eI(Double.valueOf(com.tencent.mm.ext.ui.c.E(paramj, e.aP(com.tencent.liteapp.a.a.getAppContext()))));
      p.g(paramj, "consumed(result)");
      AppMethodBeat.o(197923);
      return paramj;
    } while (!((String)localObject).equals("navigateBack"));
    label299:
    label428:
    paramj = com.tencent.wxa.c.hrH();
    p.g(paramj, "WxaRouter.getInstance()");
    paramj = paramj.hrJ();
    p.g(paramj, "WxaRouter.getInstance().currentActivity");
    paramj = paramj.getActivity();
    if (paramj == null) {}
    for (;;)
    {
      paramj = eI(Boolean.TRUE);
      p.g(paramj, "consumed(true)");
      AppMethodBeat.o(197923);
      return paramj;
      if (!((String)localObject).equals("showPicker")) {
        break;
      }
      paramj = eI(Boolean.TRUE);
      p.g(paramj, "consumed(true)");
      AppMethodBeat.o(197923);
      return paramj;
      if (!((String)localObject).equals("inputOnKeyboardValueChange")) {
        break;
      }
      paramj = eI(Boolean.TRUE);
      p.g(paramj, "consumed(true)");
      AppMethodBeat.o(197923);
      return paramj;
      if (!((String)localObject).equals("onRenderCallback")) {
        break;
      }
      paramj = eI(Boolean.TRUE);
      p.g(paramj, "consumed(true)");
      AppMethodBeat.o(197923);
      return paramj;
      if (!((String)localObject).equals("generateInputEventData")) {
        break;
      }
      paramj = eI(Boolean.TRUE);
      p.g(paramj, "consumed(true)");
      AppMethodBeat.o(197923);
      return paramj;
      if (!((String)localObject).equals("publishEvent")) {
        break;
      }
      paramj = eI(Boolean.TRUE);
      p.g(paramj, "consumed(true)");
      AppMethodBeat.o(197923);
      return paramj;
      if (!((String)localObject).equals("exitFullScreen")) {
        break;
      }
      p.g(paramj, "args");
      paramj = com.tencent.wxa.c.hrH();
      p.g(paramj, "WxaRouter.getInstance()");
      paramj = paramj.hrJ();
      p.g(paramj, "WxaRouter.getInstance().currentActivity");
      paramj = paramj.getActivity();
      if (paramj == null) {}
      for (;;)
      {
        paramj = eI(Boolean.TRUE);
        p.g(paramj, "consumed(true)");
        AppMethodBeat.o(197923);
        return paramj;
        if (!((String)localObject).equals("getLocalFileData")) {
          break;
        }
        paramj = eI(Boolean.TRUE);
        p.g(paramj, "consumed(true)");
        AppMethodBeat.o(197923);
        return paramj;
        if (!((String)localObject).equals("setCanOverScroll")) {
          break;
        }
        paramj = eI(Boolean.TRUE);
        p.g(paramj, "consumed(true)");
        AppMethodBeat.o(197923);
        return paramj;
        if ((!(localObject instanceof com.tencent.liteapp.ui.a)) || (!(paramj instanceof Map))) {
          break label238;
        }
        localObject = (com.tencent.liteapp.ui.a)localObject;
        paramj = ((Map)paramj).get("offset");
        if (paramj == null)
        {
          paramj = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(197923);
          throw paramj;
        }
        ((com.tencent.liteapp.ui.a)localObject).hD(((Integer)paramj).intValue());
        break label238;
        label899:
        if (!(paramj instanceof com.tencent.liteapp.ui.a)) {
          break label299;
        }
        ((com.tencent.liteapp.ui.a)paramj).hideKeyboard();
        break label299;
        if ((paramj instanceof com.tencent.liteapp.ui.a)) {
          ((com.tencent.liteapp.ui.a)paramj).KC();
        }
      }
      label937:
      if (!(paramj instanceof com.tencent.liteapp.ui.a)) {
        break label428;
      }
      ((com.tencent.liteapp.ui.a)paramj).KD();
      break label428;
      if ((paramj instanceof com.tencent.liteapp.ui.a)) {
        ((com.tencent.liteapp.ui.a)paramj).navigateBack();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteapp.a.a
 * JD-Core Version:    0.7.0.1
 */