package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.protocal.protobuf.erd;
import com.tencent.mm.protocal.protobuf.ere;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewUtil;", "", "()V", "Companion", "plugin-expt_release"})
public final class g
{
  public static final a sBf;
  
  static
  {
    AppMethodBeat.i(220788);
    sBf = new a((byte)0);
    AppMethodBeat.o(220788);
  }
  
  public static final boolean a(erd paramerd, ere paramere)
  {
    AppMethodBeat.i(220789);
    boolean bool = a.a(paramerd, paramere);
    AppMethodBeat.o(220789);
    return bool;
  }
  
  public static final boolean gp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220790);
    boolean bool = a.gp(paramString1, paramString2);
    AppMethodBeat.o(220790);
    return bool;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewUtil$Companion;", "", "()V", "TAG", "", "VIEW_TYPE_LIST", "", "VIEW_TYPE_SINGLE", "covertResName", "resName", "doGetResNameAgain", "viewId", "getResName", "view", "Landroid/view/View;", "getViewPath", "isViewCallerOk", "", "caller", "clazzProguard", "report", "", "page", "layout", "opEvent", "viewEqual", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "viewOp", "Lcom/tencent/mm/protocal/protobuf/ViewOp;", "plugin-expt_release"})
  public static final class a
  {
    private static String GW(int paramInt)
    {
      AppMethodBeat.i(220784);
      String str1 = String.valueOf(paramInt);
      if (b.isNumeric(str1))
      {
        str1 = b.toHexString(paramInt);
        p.g(str1, "HellhoundUtil.toHexString(viewId)");
        AppMethodBeat.o(220784);
        return str1;
      }
      try
      {
        String str2 = b.toHexString(paramInt);
        p.g(str2, "HellhoundUtil.toHexString(viewId)");
        AppMethodBeat.o(220784);
        return str2;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(220784);
      }
      return str1;
    }
    
    public static boolean a(erd paramerd, ere paramere)
    {
      AppMethodBeat.i(220786);
      p.h(paramerd, "viewNode");
      p.h(paramere, "viewOp");
      Log.i("HABBYGE-MALI.ViewUtil", "viewEqual: " + paramerd.id + ", " + paramere.viewId + ", " + paramerd.NoL + ", " + paramere.NoL);
      if ((p.j(paramerd.id, paramere.viewId)) || (p.j(paramerd.NoL, paramere.NoL)))
      {
        boolean bool = gp(paramerd.NoM, paramere.NoR);
        AppMethodBeat.o(220786);
        return bool;
      }
      AppMethodBeat.o(220786);
      return false;
    }
    
    public static String dL(View paramView)
    {
      AppMethodBeat.i(220783);
      if (paramView == null)
      {
        AppMethodBeat.o(220783);
        return null;
      }
      if (-1 == paramView.getId())
      {
        AppMethodBeat.o(220783);
        return "-1";
      }
      try
      {
        String str = paramView.getResources().getResourceName(paramView.getId());
        if (str == null)
        {
          str = GW(paramView.getId());
          AppMethodBeat.o(220783);
          return str;
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        paramView = GW(paramView.getId());
        AppMethodBeat.o(220783);
        return paramView;
      }
      paramView = n.a((CharSequence)n.j(localNotFoundException, "/", ":", false), new String[] { ":" });
      paramView = "R:" + (String)paramView.get(1) + ":" + (String)paramView.get(2);
      AppMethodBeat.o(220783);
      return paramView;
    }
    
    public static String dM(View paramView)
    {
      AppMethodBeat.i(220785);
      p.h(paramView, "view");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b.aoE(paramView.getClass().getName()));
      for (paramView = paramView.getParent(); (paramView != null) && ((paramView instanceof View)); paramView = ((View)paramView).getParent()) {
        localStringBuilder.append("|").append(b.aoE(((View)paramView).getClass().getName()));
      }
      paramView = localStringBuilder.toString();
      p.g(paramView, "viewPath.toString()");
      AppMethodBeat.o(220785);
      return paramView;
    }
    
    public static boolean gp(String paramString1, String paramString2)
    {
      AppMethodBeat.i(220787);
      if ((!TextUtils.isEmpty((CharSequence)paramString2)) && (!TextUtils.isEmpty((CharSequence)paramString1)))
      {
        paramString2 = b.aoE(paramString2);
        if (paramString2 == null)
        {
          AppMethodBeat.o(220787);
          return true;
        }
        p.g(paramString2, "HellhoundUtil.getShortNa…zProguard) ?: return true");
        paramString1 = b.aoE(paramString1);
        if (paramString1 == null)
        {
          AppMethodBeat.o(220787);
          return true;
        }
        p.g(paramString1, "HellhoundUtil.getShortNa…ge(caller) ?: return true");
        Log.i("HABBYGE-MALI.ViewUtil", "isViewCallerOk: " + paramString2 + ", " + paramString1);
        if (n.K(paramString2, "$", false))
        {
          if (!n.J(paramString1, paramString2, false))
          {
            AppMethodBeat.o(220787);
            return false;
          }
        }
        else if ((p.j(paramString2, paramString1) ^ true))
        {
          AppMethodBeat.o(220787);
          return false;
        }
      }
      AppMethodBeat.o(220787);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.c.g
 * JD-Core Version:    0.7.0.1
 */