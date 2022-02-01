package com.tencent.luggage.l;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.o;
import com.tencent.mm.sdk.vendor.Huawei;
import com.tencent.mm.sdk.vendor.Oppo;
import com.tencent.mm.sdk.vendor.Vivo;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/util/UIUtilsCompat;", "Lcom/tencent/luggage/util/UIUtilsInterface;", "()V", "interfaceImpl", "getInterfaceImpl", "()Lcom/tencent/luggage/util/UIUtilsInterface;", "setInterfaceImpl", "(Lcom/tencent/luggage/util/UIUtilsInterface;)V", "getCutOutHeight", "", "context", "Landroid/content/Context;", "getDarkModeColor", "originalColor", "getStableStatusBarHeight", "hasCutOut", "", "huaweiSpecial", "isDarkMode", "isDarkModeForWeApp", "appId", "", "isFoldableDevice", "isHuaweiFold", "luggage-commons_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  implements l
{
  public static final k exm;
  private static l exn;
  
  static
  {
    AppMethodBeat.i(174639);
    exm = new k();
    AppMethodBeat.o(174639);
  }
  
  public static void a(l paraml)
  {
    exn = paraml;
  }
  
  public final boolean atm()
  {
    AppMethodBeat.i(219985);
    l locall = exn;
    if (locall == null)
    {
      AppMethodBeat.o(219985);
      return false;
    }
    boolean bool = locall.atm();
    AppMethodBeat.o(219985);
    return bool;
  }
  
  public final boolean atn()
  {
    AppMethodBeat.i(219991);
    l locall = exn;
    if (locall == null)
    {
      AppMethodBeat.o(219991);
      return false;
    }
    boolean bool = locall.atn();
    AppMethodBeat.o(219991);
    return bool;
  }
  
  public final boolean ato()
  {
    AppMethodBeat.i(219996);
    l locall = exn;
    if (locall == null)
    {
      AppMethodBeat.o(219996);
      return false;
    }
    boolean bool = locall.ato();
    AppMethodBeat.o(219996);
    return bool;
  }
  
  public final int bw(Context paramContext)
  {
    AppMethodBeat.i(174637);
    if (paramContext == null)
    {
      AppMethodBeat.o(174637);
      return 0;
    }
    l locall = exn;
    if (locall == null)
    {
      i = o.I(paramContext, 25);
      AppMethodBeat.o(174637);
      return i;
    }
    int i = locall.bw(paramContext);
    AppMethodBeat.o(174637);
    return i;
  }
  
  public final boolean bx(Context paramContext)
  {
    AppMethodBeat.i(174638);
    if (paramContext == null)
    {
      AppMethodBeat.o(174638);
      return false;
    }
    l locall = exn;
    if (locall == null)
    {
      if (Build.VERSION.SDK_INT >= 28)
      {
        int i;
        if ((paramContext instanceof Activity))
        {
          paramContext = (Activity)paramContext;
          if (paramContext != null) {
            break label68;
          }
          i = 0;
        }
        for (;;)
        {
          if (i <= 0) {
            break label148;
          }
          AppMethodBeat.o(174638);
          return true;
          paramContext = null;
          break;
          label68:
          paramContext = paramContext.getWindow();
          if (paramContext == null)
          {
            i = 0;
          }
          else
          {
            paramContext = paramContext.getDecorView();
            if (paramContext == null)
            {
              i = 0;
            }
            else
            {
              paramContext = paramContext.getRootWindowInsets();
              if (paramContext == null)
              {
                i = 0;
              }
              else
              {
                paramContext = paramContext.getDisplayCutout();
                if (paramContext == null)
                {
                  i = 0;
                }
                else
                {
                  paramContext = paramContext.getBoundingRects();
                  if (paramContext == null) {
                    i = 0;
                  } else {
                    i = paramContext.size();
                  }
                }
              }
            }
          }
        }
        label148:
        AppMethodBeat.o(174638);
        return false;
      }
      if ((Vivo.vivohasCutOut(paramContext)) || (Oppo.oppohasCutOut(paramContext)) || (Huawei.huaweihasCutOut(paramContext)))
      {
        AppMethodBeat.o(174638);
        return true;
      }
      AppMethodBeat.o(174638);
      return false;
    }
    boolean bool = locall.bx(paramContext);
    AppMethodBeat.o(174638);
    return bool;
  }
  
  public final int by(Context paramContext)
  {
    AppMethodBeat.i(182836);
    s.u(paramContext, "context");
    l locall = exn;
    if (locall == null)
    {
      i = o.I(paramContext, 0);
      AppMethodBeat.o(182836);
      return i;
    }
    int i = locall.by(paramContext);
    AppMethodBeat.o(182836);
    return i;
  }
  
  public final boolean fJ(String paramString)
  {
    AppMethodBeat.i(219968);
    l locall = exn;
    if (locall == null)
    {
      AppMethodBeat.o(219968);
      return false;
    }
    boolean bool = locall.fJ(paramString);
    AppMethodBeat.o(219968);
    return bool;
  }
  
  public final boolean isDarkMode()
  {
    AppMethodBeat.i(174636);
    l locall = exn;
    if (locall == null)
    {
      AppMethodBeat.o(174636);
      return false;
    }
    boolean bool = locall.isDarkMode();
    AppMethodBeat.o(174636);
    return bool;
  }
  
  public final int mx(int paramInt)
  {
    AppMethodBeat.i(174635);
    l locall = exn;
    if (locall == null)
    {
      AppMethodBeat.o(174635);
      return paramInt;
    }
    paramInt = locall.mx(paramInt);
    AppMethodBeat.o(174635);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.l.k
 * JD-Core Version:    0.7.0.1
 */