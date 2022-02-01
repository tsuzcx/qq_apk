package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.protocal.protobuf.fxz;
import com.tencent.mm.protocal.protobuf.fya;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewUtil;", "", "()V", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final a zDb;
  
  static
  {
    AppMethodBeat.i(300073);
    zDb = new a((byte)0);
    AppMethodBeat.o(300073);
  }
  
  public static final boolean a(fxz paramfxz, fya paramfya)
  {
    AppMethodBeat.i(300062);
    boolean bool = a.a(paramfxz, paramfya);
    AppMethodBeat.o(300062);
    return bool;
  }
  
  public static final boolean hk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(300069);
    boolean bool = a.hk(paramString1, paramString2);
    AppMethodBeat.o(300069);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewUtil$Companion;", "", "()V", "TAG", "", "VIEW_TYPE_LIST", "", "VIEW_TYPE_SINGLE", "covertResName", "resName", "doGetResNameAgain", "viewId", "getResName", "view", "Landroid/view/View;", "getViewPath", "isViewCallerOk", "", "caller", "clazzProguard", "report", "", "page", "layout", "opEvent", "viewEqual", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "viewOp", "Lcom/tencent/mm/protocal/protobuf/ViewOp;", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static String LF(int paramInt)
    {
      AppMethodBeat.i(300048);
      String str1 = String.valueOf(paramInt);
      if (b.isNumeric(str1))
      {
        str1 = b.Lx(paramInt);
        s.s(str1, "toHexString(viewId)");
        AppMethodBeat.o(300048);
        return str1;
      }
      try
      {
        String str2 = b.Lx(paramInt);
        s.s(str2, "toHexString(viewId)");
        AppMethodBeat.o(300048);
        return str2;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(300048);
      }
      return str1;
    }
    
    public static boolean a(fxz paramfxz, fya paramfya)
    {
      AppMethodBeat.i(300057);
      s.u(paramfxz, "viewNode");
      s.u(paramfya, "viewOp");
      Log.i("HABBYGE-MALI.ViewUtil", "viewEqual: " + paramfxz.id + ", " + paramfya.viewId + ", " + paramfxz.abVR + ", " + paramfya.abVR);
      if ((s.p(paramfxz.id, paramfya.viewId)) || (s.p(paramfxz.abVR, paramfya.abVR)))
      {
        boolean bool = hk(paramfxz.abVS, paramfya.abVW);
        AppMethodBeat.o(300057);
        return bool;
      }
      AppMethodBeat.o(300057);
      return false;
    }
    
    public static String fd(View paramView)
    {
      AppMethodBeat.i(300044);
      if (paramView == null)
      {
        AppMethodBeat.o(300044);
        return null;
      }
      if (-1 == paramView.getId())
      {
        AppMethodBeat.o(300044);
        return "-1";
      }
      try
      {
        String str = paramView.getResources().getResourceName(paramView.getId());
        if (str == null)
        {
          str = LF(paramView.getId());
          AppMethodBeat.o(300044);
          return str;
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        paramView = LF(paramView.getId());
        AppMethodBeat.o(300044);
        return paramView;
      }
      paramView = n.a((CharSequence)n.m(localNotFoundException, "/", ":", false), new String[] { ":" });
      paramView = "R:" + (String)paramView.get(1) + ':' + (String)paramView.get(2);
      AppMethodBeat.o(300044);
      return paramView;
    }
    
    public static String fe(View paramView)
    {
      AppMethodBeat.i(300053);
      s.u(paramView, "view");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b.aqH(paramView.getClass().getName()));
      for (paramView = paramView.getParent(); (paramView != null) && ((paramView instanceof View)); paramView = ((View)paramView).getParent()) {
        localStringBuilder.append("|").append(b.aqH(paramView.getClass().getName()));
      }
      paramView = localStringBuilder.toString();
      s.s(paramView, "viewPath.toString()");
      AppMethodBeat.o(300053);
      return paramView;
    }
    
    public static boolean hk(String paramString1, String paramString2)
    {
      AppMethodBeat.i(300063);
      if ((!TextUtils.isEmpty((CharSequence)paramString2)) && (!TextUtils.isEmpty((CharSequence)paramString1)))
      {
        paramString2 = b.aqH(paramString2);
        if (paramString2 == null)
        {
          AppMethodBeat.o(300063);
          return true;
        }
        paramString1 = b.aqH(paramString1);
        if (paramString1 == null)
        {
          AppMethodBeat.o(300063);
          return true;
        }
        Log.i("HABBYGE-MALI.ViewUtil", "isViewCallerOk: " + paramString2 + ", " + paramString1);
        if (n.rs(paramString2, "$"))
        {
          if (!n.U(paramString1, paramString2, false))
          {
            AppMethodBeat.o(300063);
            return false;
          }
        }
        else if (!s.p(paramString2, paramString1))
        {
          AppMethodBeat.o(300063);
          return false;
        }
      }
      AppMethodBeat.o(300063);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.c.g
 * JD-Core Version:    0.7.0.1
 */