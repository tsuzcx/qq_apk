package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.protocal.protobuf.dwx;
import com.tencent.mm.protocal.protobuf.dwy;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewUtil;", "", "()V", "Companion", "plugin-expt_release"})
public final class g
{
  public static final a raO;
  
  static
  {
    AppMethodBeat.i(196340);
    raO = new a((byte)0);
    AppMethodBeat.o(196340);
  }
  
  public static final boolean a(dwx paramdwx, dwy paramdwy)
  {
    AppMethodBeat.i(196341);
    boolean bool = a.a(paramdwx, paramdwy);
    AppMethodBeat.o(196341);
    return bool;
  }
  
  public static final boolean fW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(196342);
    boolean bool = a.fW(paramString1, paramString2);
    AppMethodBeat.o(196342);
    return bool;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewUtil$Companion;", "", "()V", "TAG", "", "VIEW_TYPE_LIST", "", "VIEW_TYPE_SINGLE", "covertResName", "resName", "doGetResNameAgain", "viewId", "getResName", "view", "Landroid/view/View;", "getViewPath", "isViewCallerOk", "", "caller", "clazzProguard", "report", "", "page", "layout", "opEvent", "viewEqual", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "viewOp", "Lcom/tencent/mm/protocal/protobuf/ViewOp;", "plugin-expt_release"})
  public static final class a
  {
    private static String Dl(int paramInt)
    {
      AppMethodBeat.i(196336);
      String str1 = String.valueOf(paramInt);
      if (b.isNumeric(str1))
      {
        str1 = b.toHexString(paramInt);
        p.g(str1, "HellhoundUtil.toHexString(viewId)");
        AppMethodBeat.o(196336);
        return str1;
      }
      try
      {
        String str2 = b.toHexString(paramInt);
        p.g(str2, "HellhoundUtil.toHexString(viewId)");
        AppMethodBeat.o(196336);
        return str2;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(196336);
      }
      return str1;
    }
    
    public static boolean a(dwx paramdwx, dwy paramdwy)
    {
      AppMethodBeat.i(196338);
      p.h(paramdwx, "viewNode");
      p.h(paramdwy, "viewOp");
      ae.i("HABBYGE-MALI.ViewUtil", "viewEqual: " + paramdwx.id + ", " + paramdwy.aQj + ", " + paramdwx.Icn + ", " + paramdwy.Icn);
      if ((p.i(paramdwx.id, paramdwy.aQj)) || (p.i(paramdwx.Icn, paramdwy.Icn)))
      {
        boolean bool = fW(paramdwx.Ico, paramdwy.Ict);
        AppMethodBeat.o(196338);
        return bool;
      }
      AppMethodBeat.o(196338);
      return false;
    }
    
    public static String dT(View paramView)
    {
      AppMethodBeat.i(196335);
      if (paramView == null)
      {
        AppMethodBeat.o(196335);
        return null;
      }
      if (-1 == paramView.getId())
      {
        AppMethodBeat.o(196335);
        return "-1";
      }
      try
      {
        String str = paramView.getResources().getResourceName(paramView.getId());
        if (str == null)
        {
          str = Dl(paramView.getId());
          AppMethodBeat.o(196335);
          return str;
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        paramView = Dl(paramView.getId());
        AppMethodBeat.o(196335);
        return paramView;
      }
      paramView = n.a((CharSequence)n.h(localNotFoundException, "/", ":", false), new String[] { ":" });
      paramView = "R:" + (String)paramView.get(1) + ":" + (String)paramView.get(2);
      AppMethodBeat.o(196335);
      return paramView;
    }
    
    public static String dU(View paramView)
    {
      AppMethodBeat.i(196337);
      p.h(paramView, "view");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b.aer(paramView.getClass().getName()));
      for (paramView = paramView.getParent(); (paramView != null) && ((paramView instanceof View)); paramView = ((View)paramView).getParent()) {
        localStringBuilder.append("|").append(b.aer(((View)paramView).getClass().getName()));
      }
      paramView = localStringBuilder.toString();
      p.g(paramView, "viewPath.toString()");
      AppMethodBeat.o(196337);
      return paramView;
    }
    
    public static boolean fW(String paramString1, String paramString2)
    {
      AppMethodBeat.i(196339);
      if ((!TextUtils.isEmpty((CharSequence)paramString2)) && (!TextUtils.isEmpty((CharSequence)paramString1)))
      {
        paramString2 = b.aer(paramString2);
        if (paramString2 == null)
        {
          AppMethodBeat.o(196339);
          return true;
        }
        p.g(paramString2, "HellhoundUtil.getShortNa…zProguard) ?: return true");
        paramString1 = b.aer(paramString1);
        if (paramString1 == null)
        {
          AppMethodBeat.o(196339);
          return true;
        }
        p.g(paramString1, "HellhoundUtil.getShortNa…ge(caller) ?: return true");
        ae.i("HABBYGE-MALI.ViewUtil", "isViewCallerOk: " + paramString2 + ", " + paramString1);
        if (n.nG(paramString2, "$"))
        {
          if (!n.nF(paramString1, paramString2))
          {
            AppMethodBeat.o(196339);
            return false;
          }
        }
        else if ((p.i(paramString2, paramString1) ^ true))
        {
          AppMethodBeat.o(196339);
          return false;
        }
      }
      AppMethodBeat.o(196339);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.c.g
 * JD-Core Version:    0.7.0.1
 */