package com.tencent.mm.plugin.hld.model;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.floatview.ImeFloatViewClickBg;
import com.tencent.mm.plugin.hld.floatview.a.a;
import com.tencent.mm.plugin.hld.floatview.c;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView.c;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView.d;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/model/ImeFloatViewSwitch;", "", "()V", "TAG", "", "mClickFloatView", "Lcom/tencent/mm/plugin/hld/floatview/ImeClickFloatView;", "mInitializeSuccess", "", "mLongClickFloatView", "Lcom/tencent/mm/plugin/hld/floatview/ImeLongClickFloatView;", "mUpperSlideFloatView", "Lcom/tencent/mm/plugin/hld/floatview/ImeUpperSlideFloatView;", "init", "", "context", "Landroid/content/Context;", "onHide", "type", "", "end", "delayMs", "", "onShow", "textList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "keyboard", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "button", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "lastKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$KeyOperation;", "parent", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "anchorView", "Landroid/view/View;", "Lcom/tencent/mm/plugin/hld/keyboard/KeyOperation;", "reset", "plugin-hld_release"})
public final class f
{
  private static com.tencent.mm.plugin.hld.floatview.b DBI;
  private static com.tencent.mm.plugin.hld.floatview.f DBJ;
  private static c DBK;
  public static final f DBL;
  private static boolean Dva;
  
  static
  {
    AppMethodBeat.i(209203);
    DBL = new f();
    AppMethodBeat.o(209203);
  }
  
  public static void NU(long paramLong)
  {
    AppMethodBeat.i(209198);
    Log.d("WxIme.ImeFloatViewSwitch", "onHide delayMs:".concat(String.valueOf(paramLong)));
    if (!Dva)
    {
      Log.i("WxIme.ImeFloatViewSwitch", "onHide:init wait....");
      AppMethodBeat.o(209198);
      return;
    }
    Object localObject = DBK;
    if (localObject != null) {
      a.a.a((com.tencent.mm.plugin.hld.floatview.a)localObject, false, 0L, 3);
    }
    localObject = DBJ;
    if (localObject != null) {
      a.a.a((com.tencent.mm.plugin.hld.floatview.a)localObject, false, 0L, 3);
    }
    localObject = DBI;
    if (localObject != null)
    {
      a.a.a((com.tencent.mm.plugin.hld.floatview.a)localObject, false, paramLong, 1);
      AppMethodBeat.o(209198);
      return;
    }
    AppMethodBeat.o(209198);
  }
  
  public static void a(int paramInt, ArrayList<String> paramArrayList, KeyboardView paramKeyboardView, com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb, KeyboardView.c paramc)
  {
    AppMethodBeat.i(209197);
    p.k(paramArrayList, "textList");
    p.k(paramKeyboardView, "keyboard");
    p.k(paramb, "button");
    Log.d("WxIme.ImeFloatViewSwitch", "onShow " + paramInt + ' ' + paramArrayList.size());
    if (!Dva)
    {
      Log.i("WxIme.ImeFloatViewSwitch", "onShow:init wait....");
      AppMethodBeat.o(209197);
      return;
    }
    NU(0L);
    switch (paramInt)
    {
    }
    Object localObject;
    label1003:
    do
    {
      AppMethodBeat.o(209197);
      return;
      paramc = DBI;
      if (paramc != null)
      {
        p.k(paramArrayList, "textList");
        p.k(paramKeyboardView, "keyboard");
        p.k(paramb, "button");
        if (paramArrayList.size() == 0)
        {
          Log.e("WxIme.ImeClickFloatView", "onShowView textList is null");
          AppMethodBeat.o(209197);
          return;
        }
        paramc.DwT = ((String)paramArrayList.get(0));
        if (Util.isNullOrNil(paramc.DwT))
        {
          Log.e("WxIme.ImeClickFloatView", "onShowView mCompositionStr is null");
          AppMethodBeat.o(209197);
          return;
        }
        paramArrayList = new int[2];
        paramKeyboardView.getLocationInWindow(paramArrayList);
        paramInt = paramArrayList[0];
        int j = paramb.DzD.left + paramInt;
        paramKeyboardView.getLocationOnScreen(paramArrayList);
        int k = paramArrayList[1] + paramb.DzD.top;
        paramArrayList = paramc.DwT;
        if (paramArrayList == null) {
          p.iCn();
        }
        if (paramArrayList == null)
        {
          paramArrayList = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(209197);
          throw paramArrayList;
        }
        paramArrayList = paramArrayList.toLowerCase();
        p.j(paramArrayList, "(this as java.lang.String).toLowerCase()");
        localObject = paramc.context.getString(a.j.Q);
        p.j(localObject, "context.getString(R.string.Q)");
        if (localObject == null)
        {
          paramArrayList = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(209197);
          throw paramArrayList;
        }
        localObject = ((String)localObject).toLowerCase();
        p.j(localObject, "(this as java.lang.String).toLowerCase()");
        int i;
        if (Util.isEqual(paramArrayList, (String)localObject))
        {
          paramc.eDk().setVisibility(8);
          paramc.eDl().setVisibility(0);
          paramc.eDm().setVisibility(8);
          paramc.eDn().setVisibility(8);
          paramc.eDq().setVisibility(0);
          paramc.eDr().setVisibility(8);
          i = paramc.eDl().getBgWidth();
          paramc.eDo().setText((CharSequence)paramc.DwT);
          paramInt = j;
          paramArrayList = paramc.DwN;
          if (paramArrayList == null) {
            p.iCn();
          }
          paramArrayList.setHeight(com.tencent.mm.ci.a.aZ(paramc.context, a.d.ime_click_float_view_height));
          paramArrayList = paramc.DwN;
          if (paramArrayList == null) {
            p.iCn();
          }
          paramArrayList.setWidth(i);
          i = paramb.DzD.height();
          paramArrayList = paramc.DwN;
          if (paramArrayList == null) {
            p.iCn();
          }
          int m = paramArrayList.getHeight();
          paramArrayList = com.tencent.mm.plugin.hld.f.l.DHK;
          i = i + k - m - com.tencent.mm.plugin.hld.f.l.getStatusBarHeight(paramc.context);
          paramArrayList = com.tencent.mm.plugin.hld.d.a.DxH;
          if (com.tencent.mm.plugin.hld.d.a.eDz() == null) {
            break label1003;
          }
          paramArrayList = com.tencent.mm.plugin.hld.d.a.DxH;
        }
        for (paramArrayList = (View)com.tencent.mm.plugin.hld.d.a.eDz();; paramArrayList = (View)paramKeyboardView)
        {
          try
          {
            paramKeyboardView = paramc.DwN;
            if (paramKeyboardView == null) {
              p.iCn();
            }
            paramKeyboardView.showAtLocation(paramArrayList, 8388659, paramInt, i);
          }
          catch (Exception paramArrayList)
          {
            for (;;)
            {
              Log.e("WxIme.ImeClickFloatView", "onShowView " + paramArrayList.getMessage());
            }
          }
          paramArrayList = new StringBuilder("onShowView ").append(paramc.DwT).append(' ').append(j).append(' ').append(k).append(" yOffset:").append(i).append(" button.drawRect.height:").append(paramb.DzD.height()).append(" mFloatCompositionWidow.height:");
          paramKeyboardView = paramc.DwN;
          if (paramKeyboardView == null) {
            p.iCn();
          }
          Log.d("WxIme.ImeClickFloatView", paramKeyboardView.getHeight());
          AppMethodBeat.o(209197);
          return;
          paramArrayList = paramc.DwT;
          if (paramArrayList == null) {
            p.iCn();
          }
          if (paramArrayList == null)
          {
            paramArrayList = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(209197);
            throw paramArrayList;
          }
          paramArrayList = paramArrayList.toLowerCase();
          p.j(paramArrayList, "(this as java.lang.String).toLowerCase()");
          localObject = paramc.context.getString(a.j.P);
          p.j(localObject, "context.getString(R.string.P)");
          if (localObject == null)
          {
            paramArrayList = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(209197);
            throw paramArrayList;
          }
          localObject = ((String)localObject).toLowerCase();
          p.j(localObject, "(this as java.lang.String).toLowerCase()");
          if (Util.isEqual(paramArrayList, (String)localObject))
          {
            paramc.eDk().setVisibility(8);
            paramc.eDl().setVisibility(8);
            paramc.eDm().setVisibility(0);
            paramc.eDn().setVisibility(8);
            paramc.eDq().setVisibility(8);
            paramc.eDr().setVisibility(0);
            i = paramc.eDm().getBgWidth();
            paramInt = paramb.DzD.width() + j - i;
            paramc.eDp().setText((CharSequence)paramc.DwT);
            break;
          }
          paramc.eDk().setVisibility(0);
          paramc.eDl().setVisibility(8);
          paramc.eDm().setVisibility(8);
          paramc.eDn().setVisibility(0);
          paramc.eDq().setVisibility(8);
          paramc.eDr().setVisibility(8);
          i = paramc.eDk().getBgWidth();
          paramInt = j - (i - paramb.DzD.width()) / 2;
          paramc.eDn().setText((CharSequence)paramc.DwT);
          break;
        }
      }
      AppMethodBeat.o(209197);
      return;
      localObject = DBJ;
      if (localObject != null)
      {
        p.k(paramArrayList, "textList");
        p.k(paramKeyboardView, "keyboard");
        p.k(paramb, "button");
        if (paramArrayList.size() == 0)
        {
          Log.e("WxIme.ImeUpperSlideFloatView", "onShowView textList is null");
          AppMethodBeat.o(209197);
          return;
        }
        ((com.tencent.mm.plugin.hld.floatview.f)localObject).Dxl = paramc;
        ((com.tencent.mm.plugin.hld.floatview.f)localObject).Dxx = paramKeyboardView;
        ((com.tencent.mm.plugin.hld.floatview.f)localObject).Dxh = paramb;
        paramb.sP(true);
        ((com.tencent.mm.plugin.hld.floatview.f)localObject).Dxz = ((String)paramArrayList.get(0));
        ((com.tencent.mm.plugin.hld.floatview.f)localObject).Dxy = ((String)paramArrayList.get(1));
        paramArrayList = ((com.tencent.mm.plugin.hld.floatview.f)localObject).Dxw;
        if (paramArrayList == null) {
          p.iCn();
        }
        paramArrayList.setText((CharSequence)((com.tencent.mm.plugin.hld.floatview.f)localObject).Dxy);
        paramArrayList = ((com.tencent.mm.plugin.hld.floatview.f)localObject).DwN;
        if (paramArrayList == null) {
          p.iCn();
        }
        paramArrayList.setHeight(com.tencent.mm.ci.a.aZ(((com.tencent.mm.plugin.hld.floatview.f)localObject).context, a.d.ime_upper_slide_float_view_height));
        paramArrayList = ((com.tencent.mm.plugin.hld.floatview.f)localObject).DwN;
        if (paramArrayList == null) {
          p.iCn();
        }
        paramArrayList.setWidth(com.tencent.mm.ci.a.aZ(((com.tencent.mm.plugin.hld.floatview.f)localObject).context, a.d.ime_upper_slide_float_view_width));
        ((com.tencent.mm.plugin.hld.floatview.f)localObject).eDw();
        ((com.tencent.mm.plugin.hld.floatview.f)localObject).Dxj = new WeakReference(paramKeyboardView.getTouchListener());
        paramArrayList = ((com.tencent.mm.plugin.hld.floatview.f)localObject).Dxx;
        if (paramArrayList == null) {
          p.iCn();
        }
        paramArrayList.setOnTouchListener((KeyboardView.d)localObject);
        AppMethodBeat.o(209197);
        return;
      }
      AppMethodBeat.o(209197);
      return;
      localObject = DBK;
    } while (localObject == null);
    ((c)localObject).a(paramArrayList, paramKeyboardView, paramb, paramc);
    AppMethodBeat.o(209197);
  }
  
  public static void a(int paramInt, ArrayList<String> paramArrayList, ImeKeyRelativeLayout paramImeKeyRelativeLayout, View paramView, com.tencent.mm.plugin.hld.keyboard.b paramb)
  {
    AppMethodBeat.i(209193);
    p.k(paramArrayList, "textList");
    p.k(paramView, "anchorView");
    Log.d("WxIme.ImeFloatViewSwitch", "onShow " + paramInt + ' ' + paramArrayList.size());
    if (!Dva)
    {
      Log.i("WxIme.ImeFloatViewSwitch", "onShow:init wait....");
      AppMethodBeat.o(209193);
      return;
    }
    NU(0L);
    switch (paramInt)
    {
    }
    label1005:
    Object localObject;
    do
    {
      AppMethodBeat.o(209193);
      return;
      paramImeKeyRelativeLayout = DBI;
      if (paramImeKeyRelativeLayout != null)
      {
        p.k(paramArrayList, "textList");
        p.k(paramView, "anchorView");
        if (paramArrayList.size() == 0)
        {
          Log.e("WxIme.ImeClickFloatView", "onShowView textList is null");
          AppMethodBeat.o(209193);
          return;
        }
        paramImeKeyRelativeLayout.DwT = ((String)paramArrayList.get(0));
        if (Util.isNullOrNil(paramImeKeyRelativeLayout.DwT))
        {
          Log.e("WxIme.ImeClickFloatView", "onShowView mCompositionStr is null");
          AppMethodBeat.o(209193);
          return;
        }
        paramImeKeyRelativeLayout.lJ = paramView;
        paramArrayList = paramImeKeyRelativeLayout.lJ;
        if (paramArrayList != null) {
          paramArrayList.setSelected(true);
        }
        paramArrayList = new int[2];
        paramb = paramImeKeyRelativeLayout.lJ;
        if (paramb == null) {
          p.iCn();
        }
        paramb.getLocationInWindow(paramArrayList);
        int j = paramArrayList[0];
        paramb = paramImeKeyRelativeLayout.lJ;
        if (paramb == null) {
          p.iCn();
        }
        paramb.getLocationOnScreen(paramArrayList);
        int k = paramArrayList[1];
        paramArrayList = paramImeKeyRelativeLayout.DwT;
        if (paramArrayList == null) {
          p.iCn();
        }
        if (paramArrayList == null)
        {
          paramArrayList = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(209193);
          throw paramArrayList;
        }
        paramArrayList = paramArrayList.toLowerCase();
        p.j(paramArrayList, "(this as java.lang.String).toLowerCase()");
        paramb = paramImeKeyRelativeLayout.context.getString(a.j.Q);
        p.j(paramb, "context.getString(R.string.Q)");
        if (paramb == null)
        {
          paramArrayList = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(209193);
          throw paramArrayList;
        }
        paramb = paramb.toLowerCase();
        p.j(paramb, "(this as java.lang.String).toLowerCase()");
        int i;
        if (Util.isEqual(paramArrayList, paramb))
        {
          paramImeKeyRelativeLayout.eDk().setVisibility(8);
          paramImeKeyRelativeLayout.eDl().setVisibility(0);
          paramImeKeyRelativeLayout.eDm().setVisibility(8);
          paramImeKeyRelativeLayout.eDn().setVisibility(8);
          paramImeKeyRelativeLayout.eDq().setVisibility(0);
          paramImeKeyRelativeLayout.eDr().setVisibility(8);
          i = paramImeKeyRelativeLayout.eDl().getBgWidth();
          paramImeKeyRelativeLayout.eDo().setText((CharSequence)paramImeKeyRelativeLayout.DwT);
          paramInt = j;
          paramArrayList = paramImeKeyRelativeLayout.DwN;
          if (paramArrayList == null) {
            p.iCn();
          }
          paramArrayList.setHeight(com.tencent.mm.ci.a.aZ(paramImeKeyRelativeLayout.context, a.d.ime_click_float_view_height));
          paramArrayList = paramImeKeyRelativeLayout.DwN;
          if (paramArrayList == null) {
            p.iCn();
          }
          paramArrayList.setWidth(i);
          i = paramView.getMeasuredHeight();
          paramArrayList = paramImeKeyRelativeLayout.DwN;
          if (paramArrayList == null) {
            p.iCn();
          }
          int m = paramArrayList.getHeight();
          paramArrayList = com.tencent.mm.plugin.hld.f.l.DHK;
          i = i + k - m - com.tencent.mm.plugin.hld.f.l.getStatusBarHeight(paramImeKeyRelativeLayout.context);
          paramArrayList = com.tencent.mm.plugin.hld.d.a.DxH;
          if (com.tencent.mm.plugin.hld.d.a.eDz() == null) {
            break label1005;
          }
          paramArrayList = com.tencent.mm.plugin.hld.d.a.DxH;
        }
        for (paramArrayList = (View)com.tencent.mm.plugin.hld.d.a.eDz();; paramArrayList = paramView)
        {
          try
          {
            paramb = paramImeKeyRelativeLayout.DwN;
            if (paramb == null) {
              p.iCn();
            }
            paramb.showAtLocation(paramArrayList, 8388659, paramInt, i);
          }
          catch (Exception paramArrayList)
          {
            for (;;)
            {
              Log.e("WxIme.ImeClickFloatView", "onShowView " + paramArrayList.getMessage());
            }
          }
          paramArrayList = new StringBuilder("onShowView ").append(paramImeKeyRelativeLayout.DwT).append(' ').append(j).append(' ').append(k).append(" yOffset:").append(i).append(" anchorView.measuredHeight:").append(paramView.getMeasuredHeight()).append(" mFloatCompositionWidow.height:");
          paramImeKeyRelativeLayout = paramImeKeyRelativeLayout.DwN;
          if (paramImeKeyRelativeLayout == null) {
            p.iCn();
          }
          Log.d("WxIme.ImeClickFloatView", paramImeKeyRelativeLayout.getHeight());
          AppMethodBeat.o(209193);
          return;
          paramArrayList = paramImeKeyRelativeLayout.DwT;
          if (paramArrayList == null) {
            p.iCn();
          }
          if (paramArrayList == null)
          {
            paramArrayList = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(209193);
            throw paramArrayList;
          }
          paramArrayList = paramArrayList.toLowerCase();
          p.j(paramArrayList, "(this as java.lang.String).toLowerCase()");
          paramb = paramImeKeyRelativeLayout.context.getString(a.j.P);
          p.j(paramb, "context.getString(R.string.P)");
          if (paramb == null)
          {
            paramArrayList = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(209193);
            throw paramArrayList;
          }
          paramb = paramb.toLowerCase();
          p.j(paramb, "(this as java.lang.String).toLowerCase()");
          if (Util.isEqual(paramArrayList, paramb))
          {
            paramImeKeyRelativeLayout.eDk().setVisibility(8);
            paramImeKeyRelativeLayout.eDl().setVisibility(8);
            paramImeKeyRelativeLayout.eDm().setVisibility(0);
            paramImeKeyRelativeLayout.eDn().setVisibility(8);
            paramImeKeyRelativeLayout.eDq().setVisibility(8);
            paramImeKeyRelativeLayout.eDr().setVisibility(0);
            i = paramImeKeyRelativeLayout.eDm().getBgWidth();
            paramArrayList = paramImeKeyRelativeLayout.lJ;
            if (paramArrayList == null) {
              p.iCn();
            }
            paramInt = paramArrayList.getMeasuredWidth() + j - i;
            paramImeKeyRelativeLayout.eDp().setText((CharSequence)paramImeKeyRelativeLayout.DwT);
            break;
          }
          paramImeKeyRelativeLayout.eDk().setVisibility(0);
          paramImeKeyRelativeLayout.eDl().setVisibility(8);
          paramImeKeyRelativeLayout.eDm().setVisibility(8);
          paramImeKeyRelativeLayout.eDn().setVisibility(0);
          paramImeKeyRelativeLayout.eDq().setVisibility(8);
          paramImeKeyRelativeLayout.eDr().setVisibility(8);
          i = paramImeKeyRelativeLayout.eDk().getBgWidth();
          paramArrayList = paramImeKeyRelativeLayout.lJ;
          if (paramArrayList == null) {
            p.iCn();
          }
          paramInt = j - (i - paramArrayList.getMeasuredWidth()) / 2;
          paramImeKeyRelativeLayout.eDn().setText((CharSequence)paramImeKeyRelativeLayout.DwT);
          break;
        }
      }
      AppMethodBeat.o(209193);
      return;
      localObject = DBJ;
      if (localObject != null)
      {
        p.k(paramArrayList, "textList");
        p.k(paramView, "anchorView");
        if (paramArrayList.size() == 0)
        {
          Log.e("WxIme.ImeUpperSlideFloatView", "onShowView textList is null");
          AppMethodBeat.o(209193);
          return;
        }
        ((com.tencent.mm.plugin.hld.floatview.f)localObject).Dxm = paramb;
        ((com.tencent.mm.plugin.hld.floatview.f)localObject).Dxv = paramImeKeyRelativeLayout;
        ((com.tencent.mm.plugin.hld.floatview.f)localObject).lJ = paramView;
        paramView = ((com.tencent.mm.plugin.hld.floatview.f)localObject).lJ;
        if (paramView != null) {
          paramView.setSelected(true);
        }
        ((com.tencent.mm.plugin.hld.floatview.f)localObject).Dxz = ((String)paramArrayList.get(0));
        ((com.tencent.mm.plugin.hld.floatview.f)localObject).Dxy = ((String)paramArrayList.get(1));
        paramArrayList = ((com.tencent.mm.plugin.hld.floatview.f)localObject).Dxw;
        if (paramArrayList == null) {
          p.iCn();
        }
        paramArrayList.setText((CharSequence)((com.tencent.mm.plugin.hld.floatview.f)localObject).Dxy);
        paramArrayList = ((com.tencent.mm.plugin.hld.floatview.f)localObject).DwN;
        if (paramArrayList == null) {
          p.iCn();
        }
        paramArrayList.setHeight(com.tencent.mm.ci.a.aZ(((com.tencent.mm.plugin.hld.floatview.f)localObject).context, a.d.ime_upper_slide_float_view_height));
        paramArrayList = ((com.tencent.mm.plugin.hld.floatview.f)localObject).DwN;
        if (paramArrayList == null) {
          p.iCn();
        }
        paramArrayList.setWidth(com.tencent.mm.ci.a.aZ(((com.tencent.mm.plugin.hld.floatview.f)localObject).context, a.d.ime_upper_slide_float_view_width));
        ((com.tencent.mm.plugin.hld.floatview.f)localObject).eDv();
        if ((paramImeKeyRelativeLayout instanceof ImeKeyRelativeLayout)) {
          ((com.tencent.mm.plugin.hld.floatview.f)localObject).Dxk = paramImeKeyRelativeLayout.getOnTouchListener();
        }
        paramArrayList = ((com.tencent.mm.plugin.hld.floatview.f)localObject).Dxv;
        if (paramArrayList == null) {
          p.iCn();
        }
        paramArrayList.setOnTouchListener((View.OnTouchListener)((com.tencent.mm.plugin.hld.floatview.f)localObject).DxB);
        AppMethodBeat.o(209193);
        return;
      }
      AppMethodBeat.o(209193);
      return;
      localObject = DBK;
    } while (localObject == null);
    ((c)localObject).a(paramArrayList, paramImeKeyRelativeLayout, paramView, paramb);
    AppMethodBeat.o(209193);
  }
  
  public static void eDT()
  {
    AppMethodBeat.i(209201);
    if (!Dva)
    {
      Log.i("WxIme.ImeFloatViewSwitch", "onHide:init wait....");
      AppMethodBeat.o(209201);
      return;
    }
    Log.d("WxIme.ImeFloatViewSwitch", "onHide type:1 end:false");
    com.tencent.mm.plugin.hld.floatview.b localb = DBI;
    if (localb != null)
    {
      a.a.a(localb, false, 0L, 2);
      AppMethodBeat.o(209201);
      return;
    }
    AppMethodBeat.o(209201);
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(209190);
    p.k(paramContext, "context");
    h.ZvG.be((Runnable)new a(paramContext));
    AppMethodBeat.o(209190);
  }
  
  public static void reset(Context paramContext)
  {
    AppMethodBeat.i(209191);
    p.k(paramContext, "context");
    Dva = false;
    init(paramContext);
    AppMethodBeat.o(209191);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(Context paramContext) {}
    
    public final void run()
    {
      AppMethodBeat.i(212012);
      long l = System.currentTimeMillis();
      f localf = f.DBL;
      f.c(new com.tencent.mm.plugin.hld.floatview.b(this.$context));
      localf = f.DBL;
      f.j(new com.tencent.mm.plugin.hld.floatview.f(this.$context));
      localf = f.DBL;
      f.g(new c(this.$context));
      localf = f.DBL;
      f.eDU();
      Log.i("WxIme.ImeFloatViewSwitch", "init " + (System.currentTimeMillis() - l));
      AppMethodBeat.o(212012);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.f
 * JD-Core Version:    0.7.0.1
 */