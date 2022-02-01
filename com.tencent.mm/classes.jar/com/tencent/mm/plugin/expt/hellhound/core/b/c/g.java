package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.protocal.protobuf.dwc;
import com.tencent.mm.protocal.protobuf.dwd;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewUtil;", "", "()V", "Companion", "plugin-expt_release"})
public final class g
{
  public static final a qSQ;
  
  static
  {
    AppMethodBeat.i(210673);
    qSQ = new a((byte)0);
    AppMethodBeat.o(210673);
  }
  
  public static final boolean a(dwc paramdwc, dwd paramdwd)
  {
    AppMethodBeat.i(210674);
    boolean bool = a.a(paramdwc, paramdwd);
    AppMethodBeat.o(210674);
    return bool;
  }
  
  public static final boolean fR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(210675);
    boolean bool = a.fR(paramString1, paramString2);
    AppMethodBeat.o(210675);
    return bool;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewUtil$Companion;", "", "()V", "TAG", "", "VIEW_TYPE_LIST", "", "VIEW_TYPE_SINGLE", "covertResName", "resName", "doGetResNameAgain", "viewId", "getResName", "view", "Landroid/view/View;", "getViewPath", "isViewCallerOk", "", "caller", "clazzProguard", "report", "", "page", "layout", "opEvent", "viewEqual", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "viewOp", "Lcom/tencent/mm/protocal/protobuf/ViewOp;", "plugin-expt_release"})
  public static final class a
  {
    private static String CY(int paramInt)
    {
      AppMethodBeat.i(210669);
      String str1 = String.valueOf(paramInt);
      if (b.isNumeric(str1))
      {
        str1 = b.toHexString(paramInt);
        p.g(str1, "HellhoundUtil.toHexString(viewId)");
        AppMethodBeat.o(210669);
        return str1;
      }
      try
      {
        String str2 = b.toHexString(paramInt);
        p.g(str2, "HellhoundUtil.toHexString(viewId)");
        AppMethodBeat.o(210669);
        return str2;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(210669);
      }
      return str1;
    }
    
    public static boolean a(dwc paramdwc, dwd paramdwd)
    {
      AppMethodBeat.i(210671);
      p.h(paramdwc, "viewNode");
      p.h(paramdwd, "viewOp");
      ad.i("HABBYGE-MALI.ViewUtil", "viewEqual: " + paramdwc.id + ", " + paramdwd.aQj + ", " + paramdwc.HIB + ", " + paramdwd.HIB);
      if ((p.i(paramdwc.id, paramdwd.aQj)) || (p.i(paramdwc.HIB, paramdwd.HIB)))
      {
        boolean bool = fR(paramdwc.HIC, paramdwd.HIH);
        AppMethodBeat.o(210671);
        return bool;
      }
      AppMethodBeat.o(210671);
      return false;
    }
    
    public static String dT(View paramView)
    {
      AppMethodBeat.i(210668);
      if (paramView == null)
      {
        AppMethodBeat.o(210668);
        return null;
      }
      if (-1 == paramView.getId())
      {
        AppMethodBeat.o(210668);
        return "-1";
      }
      try
      {
        String str = paramView.getResources().getResourceName(paramView.getId());
        if (str == null)
        {
          str = CY(paramView.getId());
          AppMethodBeat.o(210668);
          return str;
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        paramView = CY(paramView.getId());
        AppMethodBeat.o(210668);
        return paramView;
      }
      paramView = n.a((CharSequence)n.h(localNotFoundException, "/", ":", false), new String[] { ":" });
      paramView = "R:" + (String)paramView.get(1) + ":" + (String)paramView.get(2);
      AppMethodBeat.o(210668);
      return paramView;
    }
    
    public static String dU(View paramView)
    {
      AppMethodBeat.i(210670);
      p.h(paramView, "view");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b.adx(paramView.getClass().getName()));
      for (paramView = paramView.getParent(); (paramView != null) && ((paramView instanceof View)); paramView = ((View)paramView).getParent()) {
        localStringBuilder.append("|").append(b.adx(((View)paramView).getClass().getName()));
      }
      paramView = localStringBuilder.toString();
      p.g(paramView, "viewPath.toString()");
      AppMethodBeat.o(210670);
      return paramView;
    }
    
    public static boolean fR(String paramString1, String paramString2)
    {
      AppMethodBeat.i(210672);
      if ((!TextUtils.isEmpty((CharSequence)paramString2)) && (!TextUtils.isEmpty((CharSequence)paramString1)))
      {
        paramString2 = b.adx(paramString2);
        if (paramString2 == null)
        {
          AppMethodBeat.o(210672);
          return true;
        }
        p.g(paramString2, "HellhoundUtil.getShortNa…zProguard) ?: return true");
        paramString1 = b.adx(paramString1);
        if (paramString1 == null)
        {
          AppMethodBeat.o(210672);
          return true;
        }
        p.g(paramString1, "HellhoundUtil.getShortNa…ge(caller) ?: return true");
        ad.i("HABBYGE-MALI.ViewUtil", "isViewCallerOk: " + paramString2 + ", " + paramString1);
        if (n.nA(paramString2, "$"))
        {
          if (!n.nz(paramString1, paramString2))
          {
            AppMethodBeat.o(210672);
            return false;
          }
        }
        else if ((p.i(paramString2, paramString1) ^ true))
        {
          AppMethodBeat.o(210672);
          return false;
        }
      }
      AppMethodBeat.o(210672);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.c.g
 * JD-Core Version:    0.7.0.1
 */