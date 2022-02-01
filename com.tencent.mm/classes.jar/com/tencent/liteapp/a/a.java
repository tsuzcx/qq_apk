package com.tencent.liteapp.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ext.ui.e;
import io.flutter.plugin.a.j;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/liteapp/channel/WxaLiteAppConsumer;", "Lcom/tencent/wxa/MethodCallConsumer;", "()V", "consume", "Lcom/tencent/wxa/MethodCallConsumer$Result;", "call", "Lio/flutter/plugin/common/MethodCall;", "enterFullScreen", "args", "", "exitFullScreen", "getCutOutHeight", "hasCutOut", "hideKeyboard", "inputLocationChange", "navigateBack", "openWebView", "Companion", "wxa_lite_app_release"})
public final class a
  extends com.tencent.wxa.b
{
  private static final String TAG = "WxaLiteApp.WxaLiteAppConsumer";
  public static final a coG;
  
  static
  {
    AppMethodBeat.i(259176);
    coG = new a((byte)0);
    TAG = "WxaLiteApp.WxaLiteAppConsumer";
    AppMethodBeat.o(259176);
  }
  
  public final com.tencent.wxa.b.a a(j paramj)
  {
    AppMethodBeat.i(259173);
    if (paramj == null) {
      p.iCn();
    }
    Object localObject = paramj.method;
    paramj = paramj.ZZe;
    com.tencent.liteapp.b.b.d(TAG, "consume method: ".concat(String.valueOf(localObject)), new Object[0]);
    if (localObject == null) {}
    label307:
    label436:
    label767:
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
                            do
                            {
                              do
                              {
                                do
                                {
                                  for (;;)
                                  {
                                    paramj = ivs();
                                    p.j(paramj, "consumeSkip()");
                                    AppMethodBeat.o(259173);
                                    return paramj;
                                    switch (((String)localObject).hashCode())
                                    {
                                    }
                                  }
                                } while (!((String)localObject).equals("inputLocationChange"));
                                p.j(paramj, "args");
                                localObject = com.tencent.wxa.c.ivt();
                                p.j(localObject, "WxaRouter.getInstance()");
                                localObject = ((com.tencent.wxa.c)localObject).ivv();
                                p.j(localObject, "WxaRouter.getInstance().currentActivity");
                                localObject = ((com.tencent.wxa.b.b)localObject).getActivity();
                                if (localObject != null) {
                                  break;
                                }
                                paramj = eO(Boolean.TRUE);
                                p.j(paramj, "consumed(true)");
                                AppMethodBeat.o(259173);
                                return paramj;
                              } while (!((String)localObject).equals("hideKeyboard"));
                              paramj = com.tencent.wxa.c.ivt();
                              p.j(paramj, "WxaRouter.getInstance()");
                              paramj = paramj.ivv();
                              p.j(paramj, "WxaRouter.getInstance().currentActivity");
                              paramj = paramj.getActivity();
                              if (paramj != null) {
                                break label980;
                              }
                              paramj = eO(Boolean.TRUE);
                              p.j(paramj, "consumed(true)");
                              AppMethodBeat.o(259173);
                              return paramj;
                            } while (!((String)localObject).equals("hasCutOut"));
                            paramj = com.tencent.wxa.c.ivt();
                            p.j(paramj, "WxaRouter.getInstance()");
                            paramj = paramj.ivv();
                            p.j(paramj, "WxaRouter.getInstance().currentActivity");
                            paramj = eO(Boolean.valueOf(e.cE((Context)paramj.getActivity())));
                            p.j(paramj, "consumed(result)");
                            AppMethodBeat.o(259173);
                            return paramj;
                          } while (!((String)localObject).equals("enterFullScreen"));
                          p.j(paramj, "args");
                          paramj = com.tencent.wxa.c.ivt();
                          p.j(paramj, "WxaRouter.getInstance()");
                          paramj = paramj.ivv();
                          p.j(paramj, "WxaRouter.getInstance().currentActivity");
                          paramj = paramj.getActivity();
                          if (paramj != null) {
                            break label1018;
                          }
                          paramj = eO(Boolean.TRUE);
                          p.j(paramj, "consumed(true)");
                          AppMethodBeat.o(259173);
                          return paramj;
                        } while (!((String)localObject).equals("getCutOutHeight"));
                        paramj = com.tencent.liteapp.b.cox;
                        paramj = com.tencent.liteapp.b.a.getAppContext();
                        localObject = com.tencent.liteapp.b.cox;
                        paramj = eO(Double.valueOf(com.tencent.mm.ext.ui.c.H(paramj, e.aM(com.tencent.liteapp.b.a.getAppContext()))));
                        p.j(paramj, "consumed(result)");
                        AppMethodBeat.o(259173);
                        return paramj;
                      } while (!((String)localObject).equals("navigateBack"));
                      p.j(paramj, "args");
                      localObject = com.tencent.wxa.c.ivt();
                      p.j(localObject, "WxaRouter.getInstance()");
                      localObject = ((com.tencent.wxa.c)localObject).ivv();
                      p.j(localObject, "WxaRouter.getInstance().currentActivity");
                      localObject = ((com.tencent.wxa.b.b)localObject).getActivity();
                      if (localObject != null) {
                        break label1037;
                      }
                      paramj = eO(Boolean.TRUE);
                      p.j(paramj, "consumed(true)");
                      AppMethodBeat.o(259173);
                      return paramj;
                    } while (!((String)localObject).equals("showPicker"));
                    paramj = eO(Boolean.TRUE);
                    p.j(paramj, "consumed(true)");
                    AppMethodBeat.o(259173);
                    return paramj;
                  } while (!((String)localObject).equals("inputOnKeyboardValueChange"));
                  paramj = eO(Boolean.TRUE);
                  p.j(paramj, "consumed(true)");
                  AppMethodBeat.o(259173);
                  return paramj;
                } while (!((String)localObject).equals("onRenderCallback"));
                paramj = eO(Boolean.TRUE);
                p.j(paramj, "consumed(true)");
                AppMethodBeat.o(259173);
                return paramj;
              } while (!((String)localObject).equals("generateInputEventData"));
              paramj = eO(Boolean.TRUE);
              p.j(paramj, "consumed(true)");
              AppMethodBeat.o(259173);
              return paramj;
            } while (!((String)localObject).equals("publishEvent"));
            paramj = eO(Boolean.TRUE);
            p.j(paramj, "consumed(true)");
            AppMethodBeat.o(259173);
            return paramj;
          } while (!((String)localObject).equals("exitFullScreen"));
          p.j(paramj, "args");
          paramj = com.tencent.wxa.c.ivt();
          p.j(paramj, "WxaRouter.getInstance()");
          paramj = paramj.ivv();
          p.j(paramj, "WxaRouter.getInstance().currentActivity");
          paramj = paramj.getActivity();
          if (paramj != null) {
            break label999;
          }
          paramj = eO(Boolean.TRUE);
          p.j(paramj, "consumed(true)");
          AppMethodBeat.o(259173);
          return paramj;
        } while (!((String)localObject).equals("getLocalFileData"));
        paramj = eO(Boolean.TRUE);
        p.j(paramj, "consumed(true)");
        AppMethodBeat.o(259173);
        return paramj;
      } while (!((String)localObject).equals("setCanOverScroll"));
      paramj = eO(Boolean.TRUE);
      p.j(paramj, "consumed(true)");
      AppMethodBeat.o(259173);
      return paramj;
    } while (!((String)localObject).equals("openWebView"));
    label555:
    p.j(paramj, "args");
    localObject = com.tencent.wxa.c.ivt();
    p.j(localObject, "WxaRouter.getInstance()");
    localObject = ((com.tencent.wxa.c)localObject).ivv();
    p.j(localObject, "WxaRouter.getInstance().currentActivity");
    localObject = ((com.tencent.wxa.b.b)localObject).getActivity();
    if (localObject == null) {}
    for (;;)
    {
      paramj = eO(Boolean.TRUE);
      p.j(paramj, "consumed(true)");
      AppMethodBeat.o(259173);
      return paramj;
      if ((!(localObject instanceof com.tencent.liteapp.ui.a)) || (!(paramj instanceof Map))) {
        break;
      }
      localObject = (com.tencent.liteapp.ui.a)localObject;
      paramj = ((Map)paramj).get("offset");
      if (paramj == null)
      {
        paramj = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(259173);
        throw paramj;
      }
      ((com.tencent.liteapp.ui.a)localObject).iD(((Integer)paramj).intValue());
      break;
      label980:
      if (!(paramj instanceof com.tencent.liteapp.ui.a)) {
        break label307;
      }
      ((com.tencent.liteapp.ui.a)paramj).hideKeyboard();
      break label307;
      label999:
      if (!(paramj instanceof com.tencent.liteapp.ui.a)) {
        break label767;
      }
      ((com.tencent.liteapp.ui.a)paramj).Np();
      break label767;
      label1018:
      if (!(paramj instanceof com.tencent.liteapp.ui.a)) {
        break label436;
      }
      ((com.tencent.liteapp.ui.a)paramj).Nq();
      break label436;
      label1037:
      if ((!(localObject instanceof com.tencent.liteapp.ui.a)) || (!(paramj instanceof Map))) {
        break label555;
      }
      localObject = (com.tencent.liteapp.ui.a)localObject;
      paramj = ((Map)paramj).get("animation");
      if (paramj == null)
      {
        paramj = new t("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(259173);
        throw paramj;
      }
      ((com.tencent.liteapp.ui.a)localObject).navigateBack(((Boolean)paramj).booleanValue());
      break label555;
      if (((localObject instanceof com.tencent.liteapp.ui.a)) && ((paramj instanceof Map))) {
        ((com.tencent.liteapp.ui.a)localObject).Nr();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/liteapp/channel/WxaLiteAppConsumer$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "wxa_lite_app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.a.a
 * JD-Core Version:    0.7.0.1
 */