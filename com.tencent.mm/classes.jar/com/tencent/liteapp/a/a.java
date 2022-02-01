package com.tencent.liteapp.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ext.ui.e;
import io.flutter.plugin.common.MethodCall;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.w;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/liteapp/channel/WxaLiteAppConsumer;", "Lcom/tencent/wxa/MethodCallConsumer;", "()V", "consume", "Lcom/tencent/wxa/MethodCallConsumer$Result;", "call", "Lio/flutter/plugin/common/MethodCall;", "enterFullScreen", "args", "", "exitFullScreen", "getCutOutHeight", "hasCutOut", "hideKeyboard", "navigateBack", "openWebView", "tryReleaseDefaultEngine", "Companion", "wxa_lite_app_release"}, k=1, mv={1, 1, 16})
public final class a
  extends com.tencent.wxa.b
{
  private static final String TAG = "WxaLiteApp.WxaLiteAppConsumer";
  public static final a efR;
  
  static
  {
    AppMethodBeat.i(219014);
    efR = new a((byte)0);
    TAG = "WxaLiteApp.WxaLiteAppConsumer";
    AppMethodBeat.o(219014);
  }
  
  public final com.tencent.wxa.b.a a(MethodCall paramMethodCall)
  {
    AppMethodBeat.i(219031);
    if (paramMethodCall == null) {
      s.klw();
    }
    Object localObject = paramMethodCall.method;
    paramMethodCall = paramMethodCall.arguments;
    com.tencent.liteapp.b.b.d(TAG, "consume method: ".concat(String.valueOf(localObject)), new Object[0]);
    if (localObject == null) {}
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
                                  paramMethodCall = keP();
                                  s.r(paramMethodCall, "consumeSkip()");
                                  AppMethodBeat.o(219031);
                                  return paramMethodCall;
                                  switch (((String)localObject).hashCode())
                                  {
                                  }
                                }
                              } while (!((String)localObject).equals("publishEvent"));
                              paramMethodCall = hl(Boolean.TRUE);
                              s.r(paramMethodCall, "consumed(true)");
                              AppMethodBeat.o(219031);
                              return paramMethodCall;
                            } while (!((String)localObject).equals("hideKeyboard"));
                            s.r(paramMethodCall, "args");
                            if (paramMethodCall != null) {
                              break;
                            }
                            paramMethodCall = new w("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, *> /* = java.util.HashMap<kotlin.String, *> */");
                            AppMethodBeat.o(219031);
                            throw paramMethodCall;
                          } while (!((String)localObject).equals("hasCutOut"));
                          s.r(paramMethodCall, "args");
                          if (paramMethodCall != null) {
                            break label975;
                          }
                          paramMethodCall = new w("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, *> /* = java.util.HashMap<kotlin.String, *> */");
                          AppMethodBeat.o(219031);
                          throw paramMethodCall;
                        } while (!((String)localObject).equals("enterFullScreen"));
                        s.r(paramMethodCall, "args");
                        if (paramMethodCall != null) {
                          break label875;
                        }
                        paramMethodCall = new w("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, *> /* = java.util.HashMap<kotlin.String, *> */");
                        AppMethodBeat.o(219031);
                        throw paramMethodCall;
                      } while (!((String)localObject).equals("getCutOutHeight"));
                      s.r(paramMethodCall, "args");
                      paramMethodCall = com.tencent.liteapp.b.efD;
                      paramMethodCall = com.tencent.liteapp.b.a.getAppContext();
                      localObject = com.tencent.liteapp.b.efD;
                      paramMethodCall = hl(Double.valueOf(com.tencent.mm.ext.ui.c.K(paramMethodCall, e.bw(com.tencent.liteapp.b.a.getAppContext()))));
                      s.r(paramMethodCall, "consumed(result)");
                      AppMethodBeat.o(219031);
                      return paramMethodCall;
                    } while (!((String)localObject).equals("onStageEmpty"));
                    s.r(paramMethodCall, "args");
                    if (paramMethodCall != null) {
                      break label1337;
                    }
                    paramMethodCall = new w("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, *> /* = java.util.HashMap<kotlin.String, *> */");
                    AppMethodBeat.o(219031);
                    throw paramMethodCall;
                  } while (!((String)localObject).equals("navigateBack"));
                  s.r(paramMethodCall, "args");
                  if (paramMethodCall != null) {
                    break label1083;
                  }
                  paramMethodCall = new w("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, *> /* = java.util.HashMap<kotlin.String, *> */");
                  AppMethodBeat.o(219031);
                  throw paramMethodCall;
                } while (!((String)localObject).equals("inputOnKeyboardValueChange"));
                paramMethodCall = hl(Boolean.TRUE);
                s.r(paramMethodCall, "consumed(true)");
                AppMethodBeat.o(219031);
                return paramMethodCall;
              } while (!((String)localObject).equals("onRenderCallback"));
              paramMethodCall = hl(Boolean.TRUE);
              s.r(paramMethodCall, "consumed(true)");
              AppMethodBeat.o(219031);
              return paramMethodCall;
            } while (!((String)localObject).equals("generateInputEventData"));
            paramMethodCall = hl(Boolean.TRUE);
            s.r(paramMethodCall, "consumed(true)");
            AppMethodBeat.o(219031);
            return paramMethodCall;
          } while (!((String)localObject).equals("exitFullScreen"));
          s.r(paramMethodCall, "args");
          if (paramMethodCall != null) {
            break label775;
          }
          paramMethodCall = new w("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, *> /* = java.util.HashMap<kotlin.String, *> */");
          AppMethodBeat.o(219031);
          throw paramMethodCall;
        } while (!((String)localObject).equals("getLocalFileData"));
        paramMethodCall = hl(Boolean.TRUE);
        s.r(paramMethodCall, "consumed(true)");
        AppMethodBeat.o(219031);
        return paramMethodCall;
      } while (!((String)localObject).equals("setCanOverScroll"));
      paramMethodCall = hl(Boolean.TRUE);
      s.r(paramMethodCall, "consumed(true)");
      AppMethodBeat.o(219031);
      return paramMethodCall;
    } while (!((String)localObject).equals("openWebView"));
    s.r(paramMethodCall, "args");
    if (paramMethodCall == null)
    {
      paramMethodCall = new w("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, *> /* = java.util.HashMap<kotlin.String, *> */");
      AppMethodBeat.o(219031);
      throw paramMethodCall;
      paramMethodCall = ((HashMap)paramMethodCall).get("activityId");
      if (paramMethodCall == null)
      {
        paramMethodCall = new w("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(219031);
        throw paramMethodCall;
      }
      paramMethodCall = (String)paramMethodCall;
      paramMethodCall = com.tencent.wxa.c.keQ().bGZ(paramMethodCall);
      s.r(paramMethodCall, "WxaRouter.getInstance().…utterActivity(activityId)");
      paramMethodCall = paramMethodCall.getActivity();
      if (paramMethodCall == null) {}
      for (;;)
      {
        paramMethodCall = hl(Boolean.TRUE);
        s.r(paramMethodCall, "consumed(true)");
        AppMethodBeat.o(219031);
        return paramMethodCall;
        if ((paramMethodCall instanceof com.tencent.liteapp.ui.a)) {
          ((com.tencent.liteapp.ui.a)paramMethodCall).hideKeyboard();
        }
      }
      label775:
      paramMethodCall = ((HashMap)paramMethodCall).get("activityId");
      if (paramMethodCall == null)
      {
        paramMethodCall = new w("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(219031);
        throw paramMethodCall;
      }
      paramMethodCall = (String)paramMethodCall;
      paramMethodCall = com.tencent.wxa.c.keQ().bGZ(paramMethodCall);
      s.r(paramMethodCall, "WxaRouter.getInstance().…utterActivity(activityId)");
      paramMethodCall = paramMethodCall.getActivity();
      if (paramMethodCall == null) {}
      for (;;)
      {
        paramMethodCall = hl(Boolean.TRUE);
        s.r(paramMethodCall, "consumed(true)");
        AppMethodBeat.o(219031);
        return paramMethodCall;
        if ((paramMethodCall instanceof com.tencent.liteapp.ui.a)) {
          ((com.tencent.liteapp.ui.a)paramMethodCall).anI();
        }
      }
      label875:
      paramMethodCall = ((HashMap)paramMethodCall).get("activityId");
      if (paramMethodCall == null)
      {
        paramMethodCall = new w("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(219031);
        throw paramMethodCall;
      }
      paramMethodCall = (String)paramMethodCall;
      paramMethodCall = com.tencent.wxa.c.keQ().bGZ(paramMethodCall);
      s.r(paramMethodCall, "WxaRouter.getInstance().…utterActivity(activityId)");
      paramMethodCall = paramMethodCall.getActivity();
      if (paramMethodCall == null) {}
      for (;;)
      {
        paramMethodCall = hl(Boolean.TRUE);
        s.r(paramMethodCall, "consumed(true)");
        AppMethodBeat.o(219031);
        return paramMethodCall;
        if ((paramMethodCall instanceof com.tencent.liteapp.ui.a)) {
          ((com.tencent.liteapp.ui.a)paramMethodCall).anJ();
        }
      }
      label975:
      paramMethodCall = ((HashMap)paramMethodCall).get("activityId");
      if (paramMethodCall == null)
      {
        paramMethodCall = new w("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(219031);
        throw paramMethodCall;
      }
      paramMethodCall = (String)paramMethodCall;
      paramMethodCall = com.tencent.wxa.c.keQ().bGZ(paramMethodCall);
      s.r(paramMethodCall, "WxaRouter.getInstance().…utterActivity(activityId)");
      paramMethodCall = paramMethodCall.getActivity();
      if (paramMethodCall == null)
      {
        paramMethodCall = hl(Boolean.TRUE);
        s.r(paramMethodCall, "consumed(true)");
        AppMethodBeat.o(219031);
        return paramMethodCall;
      }
      paramMethodCall = hl(Boolean.valueOf(e.ds((Context)paramMethodCall)));
      s.r(paramMethodCall, "consumed(result)");
      AppMethodBeat.o(219031);
      return paramMethodCall;
      label1083:
      localObject = ((HashMap)paramMethodCall).get("activityId");
      if (localObject == null)
      {
        paramMethodCall = new w("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(219031);
        throw paramMethodCall;
      }
      localObject = (String)localObject;
      localObject = com.tencent.wxa.c.keQ().bGZ((String)localObject);
      s.r(localObject, "WxaRouter.getInstance().…utterActivity(activityId)");
      localObject = ((com.tencent.wxa.b.b)localObject).getActivity();
      if (localObject == null) {}
      for (;;)
      {
        paramMethodCall = hl(Boolean.TRUE);
        s.r(paramMethodCall, "consumed(true)");
        AppMethodBeat.o(219031);
        return paramMethodCall;
        if (((localObject instanceof com.tencent.liteapp.ui.a)) && ((paramMethodCall instanceof Map)))
        {
          localObject = (com.tencent.liteapp.ui.a)localObject;
          paramMethodCall = ((HashMap)paramMethodCall).get("animation");
          if (paramMethodCall == null)
          {
            paramMethodCall = new w("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(219031);
            throw paramMethodCall;
          }
          ((com.tencent.liteapp.ui.a)localObject).navigateBack(((Boolean)paramMethodCall).booleanValue());
        }
      }
    }
    localObject = ((HashMap)paramMethodCall).get("activityId");
    if (localObject == null)
    {
      paramMethodCall = new w("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(219031);
      throw paramMethodCall;
    }
    localObject = (String)localObject;
    localObject = com.tencent.wxa.c.keQ().bGZ((String)localObject);
    s.r(localObject, "WxaRouter.getInstance().…utterActivity(activityId)");
    localObject = ((com.tencent.wxa.b.b)localObject).getActivity();
    if (localObject == null) {}
    for (;;)
    {
      paramMethodCall = hl(Boolean.TRUE);
      s.r(paramMethodCall, "consumed(true)");
      AppMethodBeat.o(219031);
      return paramMethodCall;
      if (((localObject instanceof com.tencent.liteapp.ui.a)) && ((paramMethodCall instanceof Map))) {
        ((com.tencent.liteapp.ui.a)localObject).anK();
      }
    }
    label1337:
    if (((HashMap)paramMethodCall).get("activityId") == null)
    {
      paramMethodCall = new w("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(219031);
      throw paramMethodCall;
    }
    paramMethodCall = keP();
    s.r(paramMethodCall, "consumeSkip()");
    AppMethodBeat.o(219031);
    return paramMethodCall;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/liteapp/channel/WxaLiteAppConsumer$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "wxa_lite_app_release"}, k=1, mv={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.a.a
 * JD-Core Version:    0.7.0.1
 */