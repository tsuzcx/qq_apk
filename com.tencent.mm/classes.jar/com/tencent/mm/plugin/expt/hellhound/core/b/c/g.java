package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.protocal.protobuf.fbo;
import com.tencent.mm.protocal.protobuf.fbp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewUtil;", "", "()V", "Companion", "plugin-expt_release"})
public final class g
{
  public static final a wgZ;
  
  static
  {
    AppMethodBeat.i(255888);
    wgZ = new a((byte)0);
    AppMethodBeat.o(255888);
  }
  
  public static final boolean a(fbo paramfbo, fbp paramfbp)
  {
    AppMethodBeat.i(255890);
    boolean bool = a.a(paramfbo, paramfbp);
    AppMethodBeat.o(255890);
    return bool;
  }
  
  public static final boolean gD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(255892);
    boolean bool = a.gD(paramString1, paramString2);
    AppMethodBeat.o(255892);
    return bool;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewUtil$Companion;", "", "()V", "TAG", "", "VIEW_TYPE_LIST", "", "VIEW_TYPE_SINGLE", "covertResName", "resName", "doGetResNameAgain", "viewId", "getResName", "view", "Landroid/view/View;", "getViewPath", "isViewCallerOk", "", "caller", "clazzProguard", "report", "", "page", "layout", "opEvent", "viewEqual", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "viewOp", "Lcom/tencent/mm/protocal/protobuf/ViewOp;", "plugin-expt_release"})
  public static final class a
  {
    private static String KG(int paramInt)
    {
      AppMethodBeat.i(256275);
      String str1 = String.valueOf(paramInt);
      if (b.isNumeric(str1))
      {
        str1 = b.Kx(paramInt);
        p.j(str1, "HellhoundUtil.toHexString(viewId)");
        AppMethodBeat.o(256275);
        return str1;
      }
      try
      {
        String str2 = b.Kx(paramInt);
        p.j(str2, "HellhoundUtil.toHexString(viewId)");
        AppMethodBeat.o(256275);
        return str2;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(256275);
      }
      return str1;
    }
    
    public static boolean a(fbo paramfbo, fbp paramfbp)
    {
      AppMethodBeat.i(256277);
      p.k(paramfbo, "viewNode");
      p.k(paramfbp, "viewOp");
      Log.i("HABBYGE-MALI.ViewUtil", "viewEqual: " + paramfbo.id + ", " + paramfbp.viewId + ", " + paramfbo.UBI + ", " + paramfbp.UBI);
      if ((p.h(paramfbo.id, paramfbp.viewId)) || (p.h(paramfbo.UBI, paramfbp.UBI)))
      {
        boolean bool = gD(paramfbo.UBJ, paramfbp.UBN);
        AppMethodBeat.o(256277);
        return bool;
      }
      AppMethodBeat.o(256277);
      return false;
    }
    
    public static String ej(View paramView)
    {
      AppMethodBeat.i(256274);
      if (paramView == null)
      {
        AppMethodBeat.o(256274);
        return null;
      }
      if (-1 == paramView.getId())
      {
        AppMethodBeat.o(256274);
        return "-1";
      }
      try
      {
        String str = paramView.getResources().getResourceName(paramView.getId());
        if (str == null)
        {
          str = KG(paramView.getId());
          AppMethodBeat.o(256274);
          return str;
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        paramView = KG(paramView.getId());
        AppMethodBeat.o(256274);
        return paramView;
      }
      paramView = n.a((CharSequence)n.l(localNotFoundException, "/", ":", false), new String[] { ":" });
      paramView = "R:" + (String)paramView.get(1) + ":" + (String)paramView.get(2);
      AppMethodBeat.o(256274);
      return paramView;
    }
    
    public static String ek(View paramView)
    {
      AppMethodBeat.i(256276);
      p.k(paramView, "view");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b.awD(paramView.getClass().getName()));
      for (paramView = paramView.getParent(); (paramView != null) && ((paramView instanceof View)); paramView = ((View)paramView).getParent()) {
        localStringBuilder.append("|").append(b.awD(((View)paramView).getClass().getName()));
      }
      paramView = localStringBuilder.toString();
      p.j(paramView, "viewPath.toString()");
      AppMethodBeat.o(256276);
      return paramView;
    }
    
    public static boolean gD(String paramString1, String paramString2)
    {
      AppMethodBeat.i(256279);
      if ((!TextUtils.isEmpty((CharSequence)paramString2)) && (!TextUtils.isEmpty((CharSequence)paramString1)))
      {
        paramString2 = b.awD(paramString2);
        if (paramString2 == null)
        {
          AppMethodBeat.o(256279);
          return true;
        }
        p.j(paramString2, "HellhoundUtil.getShortNa…zProguard) ?: return true");
        paramString1 = b.awD(paramString1);
        if (paramString1 == null)
        {
          AppMethodBeat.o(256279);
          return true;
        }
        p.j(paramString1, "HellhoundUtil.getShortNa…ge(caller) ?: return true");
        Log.i("HABBYGE-MALI.ViewUtil", "isViewCallerOk: " + paramString2 + ", " + paramString1);
        if (n.pu(paramString2, "$"))
        {
          if (!n.M(paramString1, paramString2, false))
          {
            AppMethodBeat.o(256279);
            return false;
          }
        }
        else if ((p.h(paramString2, paramString1) ^ true))
        {
          AppMethodBeat.o(256279);
          return false;
        }
      }
      AppMethodBeat.o(256279);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.c.g
 * JD-Core Version:    0.7.0.1
 */