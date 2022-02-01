package com.tencent.mm.plugin.hld.model;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.floatview.ImeFloatViewClickBg;
import com.tencent.mm.plugin.hld.floatview.a.a;
import com.tencent.mm.plugin.hld.floatview.c;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView.c;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView.d;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/model/ImeFloatViewSwitch;", "", "()V", "TAG", "", "mClickFloatView", "Lcom/tencent/mm/plugin/hld/floatview/ImeClickFloatView;", "mInitializeSuccess", "", "mLongClickFloatView", "Lcom/tencent/mm/plugin/hld/floatview/ImeLongClickFloatView;", "mUpperSlideFloatView", "Lcom/tencent/mm/plugin/hld/floatview/ImeUpperSlideFloatView;", "init", "", "context", "Landroid/content/Context;", "onHide", "type", "", "end", "delayMs", "", "onShow", "textList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "keyboard", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "button", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "lastKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$KeyOperation;", "parent", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "anchorView", "Landroid/view/View;", "Lcom/tencent/mm/plugin/hld/keyboard/KeyOperation;", "reset", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  private static boolean Jox;
  public static final f JuH;
  private static com.tencent.mm.plugin.hld.floatview.b JuI;
  private static com.tencent.mm.plugin.hld.floatview.f JuJ;
  private static c JuK;
  
  static
  {
    AppMethodBeat.i(311974);
    JuH = new f();
    AppMethodBeat.o(311974);
  }
  
  public static void a(int paramInt, ArrayList<String> paramArrayList, KeyboardView paramKeyboardView, com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb, KeyboardView.c paramc)
  {
    AppMethodBeat.i(311926);
    s.u(paramArrayList, "textList");
    s.u(paramKeyboardView, "keyboard");
    s.u(paramb, "button");
    Log.d("WxIme.ImeFloatViewSwitch", "onShow " + paramInt + ' ' + paramArrayList.size());
    if (!Jox)
    {
      Log.i("WxIme.ImeFloatViewSwitch", "onShow:init wait....");
      AppMethodBeat.o(311926);
      return;
    }
    rL(0L);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(311926);
      return;
      paramc = JuI;
      if (paramc != null)
      {
        s.u(paramArrayList, "textList");
        s.u(paramKeyboardView, "keyboard");
        s.u(paramb, "button");
        if (paramArrayList.size() == 0)
        {
          Log.e("WxIme.ImeClickFloatView", "onShowView textList is null");
          AppMethodBeat.o(311926);
          return;
        }
        paramc.Jqa = ((String)paramArrayList.get(0));
        if (Util.isNullOrNil(paramc.Jqa))
        {
          Log.e("WxIme.ImeClickFloatView", "onShowView mCompositionStr is null");
          AppMethodBeat.o(311926);
          return;
        }
        paramArrayList = new int[2];
        paramKeyboardView.getLocationInWindow(paramArrayList);
        paramInt = paramArrayList[0];
        int j = paramb.JsG.left + paramInt;
        paramKeyboardView.getLocationOnScreen(paramArrayList);
        int k = paramArrayList[1] + paramb.JsG.top;
        paramArrayList = paramc.Jqa;
        s.checkNotNull(paramArrayList);
        if (paramArrayList == null)
        {
          paramArrayList = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(311926);
          throw paramArrayList;
        }
        paramArrayList = paramArrayList.toLowerCase();
        s.s(paramArrayList, "(this as java.lang.String).toLowerCase()");
        Object localObject = paramc.context.getString(a.j.Q);
        s.s(localObject, "context.getString(R.string.Q)");
        localObject = ((String)localObject).toLowerCase();
        s.s(localObject, "(this as java.lang.String).toLowerCase()");
        int i;
        if (Util.isEqual(paramArrayList, (String)localObject))
        {
          paramc.fLk().setVisibility(8);
          paramc.fLl().setVisibility(0);
          paramc.fLm().setVisibility(8);
          paramc.fLn().setVisibility(8);
          paramc.fLq().setVisibility(0);
          paramc.fLr().setVisibility(8);
          i = paramc.fLl().getBgWidth();
          paramc.fLo().setText((CharSequence)paramc.Jqa);
          paramInt = j;
        }
        for (;;)
        {
          paramArrayList = paramc.JpU;
          s.checkNotNull(paramArrayList);
          paramArrayList.setHeight(com.tencent.mm.cd.a.bs(paramc.context, a.d.ime_click_float_view_height));
          paramArrayList = paramc.JpU;
          s.checkNotNull(paramArrayList);
          paramArrayList.setWidth(i);
          i = paramb.JsG.height();
          paramArrayList = paramc.JpU;
          s.checkNotNull(paramArrayList);
          int m = paramArrayList.getHeight();
          paramArrayList = l.JyV;
          i = i + k - m - l.getStatusBarHeight(paramc.context);
          paramArrayList = com.tencent.mm.plugin.hld.d.a.JqJ;
          if (com.tencent.mm.plugin.hld.d.a.fLA() != null)
          {
            paramArrayList = com.tencent.mm.plugin.hld.d.a.JqJ;
            paramArrayList = (View)com.tencent.mm.plugin.hld.d.a.fLA();
          }
          try
          {
            for (;;)
            {
              paramKeyboardView = paramc.JpU;
              s.checkNotNull(paramKeyboardView);
              paramKeyboardView.showAtLocation(paramArrayList, 8388659, paramInt, i);
              paramArrayList = new StringBuilder("onShowView ").append(paramc.Jqa).append(' ').append(j).append(' ').append(k).append(" yOffset:").append(i).append(" button.drawRect.height:").append(paramb.JsG.height()).append(" mFloatCompositionWidow.height:");
              paramKeyboardView = paramc.JpU;
              s.checkNotNull(paramKeyboardView);
              Log.d("WxIme.ImeClickFloatView", paramKeyboardView.getHeight());
              AppMethodBeat.o(311926);
              return;
              paramArrayList = paramc.Jqa;
              s.checkNotNull(paramArrayList);
              if (paramArrayList == null)
              {
                paramArrayList = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(311926);
                throw paramArrayList;
              }
              paramArrayList = paramArrayList.toLowerCase();
              s.s(paramArrayList, "(this as java.lang.String).toLowerCase()");
              localObject = paramc.context.getString(a.j.P);
              s.s(localObject, "context.getString(R.string.P)");
              localObject = ((String)localObject).toLowerCase();
              s.s(localObject, "(this as java.lang.String).toLowerCase()");
              if (Util.isEqual(paramArrayList, (String)localObject))
              {
                paramc.fLk().setVisibility(8);
                paramc.fLl().setVisibility(8);
                paramc.fLm().setVisibility(0);
                paramc.fLn().setVisibility(8);
                paramc.fLq().setVisibility(8);
                paramc.fLr().setVisibility(0);
                i = paramc.fLm().getBgWidth();
                paramInt = paramb.JsG.width() + j - i;
                paramc.fLp().setText((CharSequence)paramc.Jqa);
                break;
              }
              paramc.fLk().setVisibility(0);
              paramc.fLl().setVisibility(8);
              paramc.fLm().setVisibility(8);
              paramc.fLn().setVisibility(0);
              paramc.fLq().setVisibility(8);
              paramc.fLr().setVisibility(8);
              i = paramc.fLk().getBgWidth();
              paramInt = j - (i - paramb.JsG.width()) / 2;
              paramc.fLn().setText((CharSequence)paramc.Jqa);
              break;
              paramArrayList = (View)paramKeyboardView;
            }
          }
          catch (Exception paramArrayList)
          {
            for (;;)
            {
              Log.e("WxIme.ImeClickFloatView", s.X("onShowView ", paramArrayList.getMessage()));
            }
          }
        }
        localObject = JuJ;
        if (localObject != null)
        {
          s.u(paramArrayList, "textList");
          s.u(paramKeyboardView, "keyboard");
          s.u(paramb, "button");
          if (paramArrayList.size() == 0)
          {
            Log.e("WxIme.ImeUpperSlideFloatView", "onShowView textList is null");
            AppMethodBeat.o(311926);
            return;
          }
          ((com.tencent.mm.plugin.hld.floatview.f)localObject).Jqr = paramc;
          ((com.tencent.mm.plugin.hld.floatview.f)localObject).JqD = paramKeyboardView;
          ((com.tencent.mm.plugin.hld.floatview.f)localObject).Jqn = paramb;
          paramb.wV(true);
          ((com.tencent.mm.plugin.hld.floatview.f)localObject).JqF = ((String)paramArrayList.get(0));
          ((com.tencent.mm.plugin.hld.floatview.f)localObject).JqE = ((String)paramArrayList.get(1));
          paramArrayList = ((com.tencent.mm.plugin.hld.floatview.f)localObject).JqC;
          s.checkNotNull(paramArrayList);
          paramArrayList.setText((CharSequence)((com.tencent.mm.plugin.hld.floatview.f)localObject).JqE);
          paramArrayList = ((com.tencent.mm.plugin.hld.floatview.f)localObject).JpU;
          s.checkNotNull(paramArrayList);
          paramArrayList.setHeight(com.tencent.mm.cd.a.bs(((com.tencent.mm.plugin.hld.floatview.f)localObject).context, a.d.ime_upper_slide_float_view_height));
          paramArrayList = ((com.tencent.mm.plugin.hld.floatview.f)localObject).JpU;
          s.checkNotNull(paramArrayList);
          paramArrayList.setWidth(com.tencent.mm.cd.a.bs(((com.tencent.mm.plugin.hld.floatview.f)localObject).context, a.d.ime_upper_slide_float_view_width));
          ((com.tencent.mm.plugin.hld.floatview.f)localObject).fLw();
          ((com.tencent.mm.plugin.hld.floatview.f)localObject).Jqp = new WeakReference(paramKeyboardView.getTouchListener());
          paramArrayList = ((com.tencent.mm.plugin.hld.floatview.f)localObject).JqD;
          s.checkNotNull(paramArrayList);
          paramArrayList.setOnTouchListener((KeyboardView.d)localObject);
          AppMethodBeat.o(311926);
          return;
          localObject = JuK;
          if (localObject != null) {
            ((c)localObject).a(paramArrayList, paramKeyboardView, paramb, paramc);
          }
        }
      }
    }
  }
  
  public static void a(int paramInt, ArrayList<String> paramArrayList, ImeKeyRelativeLayout paramImeKeyRelativeLayout, View paramView, com.tencent.mm.plugin.hld.keyboard.b paramb)
  {
    AppMethodBeat.i(311908);
    s.u(paramArrayList, "textList");
    s.u(paramView, "anchorView");
    Log.d("WxIme.ImeFloatViewSwitch", "onShow " + paramInt + ' ' + paramArrayList.size());
    if (!Jox)
    {
      Log.i("WxIme.ImeFloatViewSwitch", "onShow:init wait....");
      AppMethodBeat.o(311908);
      return;
    }
    rL(0L);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(311908);
      return;
      paramImeKeyRelativeLayout = JuI;
      if (paramImeKeyRelativeLayout != null)
      {
        s.u(paramArrayList, "textList");
        s.u(paramView, "anchorView");
        if (paramArrayList.size() == 0)
        {
          Log.e("WxIme.ImeClickFloatView", "onShowView textList is null");
          AppMethodBeat.o(311908);
          return;
        }
        paramImeKeyRelativeLayout.Jqa = ((String)paramArrayList.get(0));
        if (Util.isNullOrNil(paramImeKeyRelativeLayout.Jqa))
        {
          Log.e("WxIme.ImeClickFloatView", "onShowView mCompositionStr is null");
          AppMethodBeat.o(311908);
          return;
        }
        paramImeKeyRelativeLayout.mF = paramView;
        paramArrayList = paramImeKeyRelativeLayout.mF;
        if (paramArrayList != null) {
          paramArrayList.setSelected(true);
        }
        paramArrayList = new int[2];
        paramb = paramImeKeyRelativeLayout.mF;
        s.checkNotNull(paramb);
        paramb.getLocationInWindow(paramArrayList);
        int j = paramArrayList[0];
        paramb = paramImeKeyRelativeLayout.mF;
        s.checkNotNull(paramb);
        paramb.getLocationOnScreen(paramArrayList);
        int k = paramArrayList[1];
        paramArrayList = paramImeKeyRelativeLayout.Jqa;
        s.checkNotNull(paramArrayList);
        if (paramArrayList == null)
        {
          paramArrayList = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(311908);
          throw paramArrayList;
        }
        paramArrayList = paramArrayList.toLowerCase();
        s.s(paramArrayList, "(this as java.lang.String).toLowerCase()");
        paramb = paramImeKeyRelativeLayout.context.getString(a.j.Q);
        s.s(paramb, "context.getString(R.string.Q)");
        paramb = paramb.toLowerCase();
        s.s(paramb, "(this as java.lang.String).toLowerCase()");
        int i;
        if (Util.isEqual(paramArrayList, paramb))
        {
          paramImeKeyRelativeLayout.fLk().setVisibility(8);
          paramImeKeyRelativeLayout.fLl().setVisibility(0);
          paramImeKeyRelativeLayout.fLm().setVisibility(8);
          paramImeKeyRelativeLayout.fLn().setVisibility(8);
          paramImeKeyRelativeLayout.fLq().setVisibility(0);
          paramImeKeyRelativeLayout.fLr().setVisibility(8);
          i = paramImeKeyRelativeLayout.fLl().getBgWidth();
          paramImeKeyRelativeLayout.fLo().setText((CharSequence)paramImeKeyRelativeLayout.Jqa);
          paramInt = j;
        }
        for (;;)
        {
          paramArrayList = paramImeKeyRelativeLayout.JpU;
          s.checkNotNull(paramArrayList);
          paramArrayList.setHeight(com.tencent.mm.cd.a.bs(paramImeKeyRelativeLayout.context, a.d.ime_click_float_view_height));
          paramArrayList = paramImeKeyRelativeLayout.JpU;
          s.checkNotNull(paramArrayList);
          paramArrayList.setWidth(i);
          i = paramView.getMeasuredHeight();
          paramArrayList = paramImeKeyRelativeLayout.JpU;
          s.checkNotNull(paramArrayList);
          int m = paramArrayList.getHeight();
          paramArrayList = l.JyV;
          i = i + k - m - l.getStatusBarHeight(paramImeKeyRelativeLayout.context);
          paramArrayList = com.tencent.mm.plugin.hld.d.a.JqJ;
          if (com.tencent.mm.plugin.hld.d.a.fLA() != null)
          {
            paramArrayList = com.tencent.mm.plugin.hld.d.a.JqJ;
            paramArrayList = (View)com.tencent.mm.plugin.hld.d.a.fLA();
          }
          try
          {
            for (;;)
            {
              paramb = paramImeKeyRelativeLayout.JpU;
              s.checkNotNull(paramb);
              paramb.showAtLocation(paramArrayList, 8388659, paramInt, i);
              paramArrayList = new StringBuilder("onShowView ").append(paramImeKeyRelativeLayout.Jqa).append(' ').append(j).append(' ').append(k).append(" yOffset:").append(i).append(" anchorView.measuredHeight:").append(paramView.getMeasuredHeight()).append(" mFloatCompositionWidow.height:");
              paramImeKeyRelativeLayout = paramImeKeyRelativeLayout.JpU;
              s.checkNotNull(paramImeKeyRelativeLayout);
              Log.d("WxIme.ImeClickFloatView", paramImeKeyRelativeLayout.getHeight());
              AppMethodBeat.o(311908);
              return;
              paramArrayList = paramImeKeyRelativeLayout.Jqa;
              s.checkNotNull(paramArrayList);
              if (paramArrayList == null)
              {
                paramArrayList = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(311908);
                throw paramArrayList;
              }
              paramArrayList = paramArrayList.toLowerCase();
              s.s(paramArrayList, "(this as java.lang.String).toLowerCase()");
              paramb = paramImeKeyRelativeLayout.context.getString(a.j.P);
              s.s(paramb, "context.getString(R.string.P)");
              paramb = paramb.toLowerCase();
              s.s(paramb, "(this as java.lang.String).toLowerCase()");
              if (Util.isEqual(paramArrayList, paramb))
              {
                paramImeKeyRelativeLayout.fLk().setVisibility(8);
                paramImeKeyRelativeLayout.fLl().setVisibility(8);
                paramImeKeyRelativeLayout.fLm().setVisibility(0);
                paramImeKeyRelativeLayout.fLn().setVisibility(8);
                paramImeKeyRelativeLayout.fLq().setVisibility(8);
                paramImeKeyRelativeLayout.fLr().setVisibility(0);
                i = paramImeKeyRelativeLayout.fLm().getBgWidth();
                paramArrayList = paramImeKeyRelativeLayout.mF;
                s.checkNotNull(paramArrayList);
                paramInt = paramArrayList.getMeasuredWidth() + j - i;
                paramImeKeyRelativeLayout.fLp().setText((CharSequence)paramImeKeyRelativeLayout.Jqa);
                break;
              }
              paramImeKeyRelativeLayout.fLk().setVisibility(0);
              paramImeKeyRelativeLayout.fLl().setVisibility(8);
              paramImeKeyRelativeLayout.fLm().setVisibility(8);
              paramImeKeyRelativeLayout.fLn().setVisibility(0);
              paramImeKeyRelativeLayout.fLq().setVisibility(8);
              paramImeKeyRelativeLayout.fLr().setVisibility(8);
              i = paramImeKeyRelativeLayout.fLk().getBgWidth();
              paramArrayList = paramImeKeyRelativeLayout.mF;
              s.checkNotNull(paramArrayList);
              paramInt = j - (i - paramArrayList.getMeasuredWidth()) / 2;
              paramImeKeyRelativeLayout.fLn().setText((CharSequence)paramImeKeyRelativeLayout.Jqa);
              break;
              paramArrayList = paramView;
            }
          }
          catch (Exception paramArrayList)
          {
            for (;;)
            {
              Log.e("WxIme.ImeClickFloatView", s.X("onShowView ", paramArrayList.getMessage()));
            }
          }
        }
        Object localObject = JuJ;
        if (localObject != null)
        {
          s.u(paramArrayList, "textList");
          s.u(paramView, "anchorView");
          if (paramArrayList.size() == 0)
          {
            Log.e("WxIme.ImeUpperSlideFloatView", "onShowView textList is null");
            AppMethodBeat.o(311908);
            return;
          }
          ((com.tencent.mm.plugin.hld.floatview.f)localObject).Jqs = paramb;
          ((com.tencent.mm.plugin.hld.floatview.f)localObject).JqB = paramImeKeyRelativeLayout;
          ((com.tencent.mm.plugin.hld.floatview.f)localObject).mF = paramView;
          paramView = ((com.tencent.mm.plugin.hld.floatview.f)localObject).mF;
          if (paramView != null) {
            paramView.setSelected(true);
          }
          ((com.tencent.mm.plugin.hld.floatview.f)localObject).JqF = ((String)paramArrayList.get(0));
          ((com.tencent.mm.plugin.hld.floatview.f)localObject).JqE = ((String)paramArrayList.get(1));
          paramArrayList = ((com.tencent.mm.plugin.hld.floatview.f)localObject).JqC;
          s.checkNotNull(paramArrayList);
          paramArrayList.setText((CharSequence)((com.tencent.mm.plugin.hld.floatview.f)localObject).JqE);
          paramArrayList = ((com.tencent.mm.plugin.hld.floatview.f)localObject).JpU;
          s.checkNotNull(paramArrayList);
          paramArrayList.setHeight(com.tencent.mm.cd.a.bs(((com.tencent.mm.plugin.hld.floatview.f)localObject).context, a.d.ime_upper_slide_float_view_height));
          paramArrayList = ((com.tencent.mm.plugin.hld.floatview.f)localObject).JpU;
          s.checkNotNull(paramArrayList);
          paramArrayList.setWidth(com.tencent.mm.cd.a.bs(((com.tencent.mm.plugin.hld.floatview.f)localObject).context, a.d.ime_upper_slide_float_view_width));
          ((com.tencent.mm.plugin.hld.floatview.f)localObject).fLv();
          if (paramImeKeyRelativeLayout != null) {
            ((com.tencent.mm.plugin.hld.floatview.f)localObject).Jqq = paramImeKeyRelativeLayout.getOnTouchListener();
          }
          paramArrayList = ((com.tencent.mm.plugin.hld.floatview.f)localObject).JqB;
          s.checkNotNull(paramArrayList);
          paramArrayList.setOnTouchListener((View.OnTouchListener)((com.tencent.mm.plugin.hld.floatview.f)localObject).JqH);
          AppMethodBeat.o(311908);
          return;
          localObject = JuK;
          if (localObject != null) {
            ((c)localObject).a(paramArrayList, paramImeKeyRelativeLayout, paramView, paramb);
          }
        }
      }
    }
  }
  
  public static void fLW()
  {
    AppMethodBeat.i(311955);
    if (!Jox)
    {
      Log.i("WxIme.ImeFloatViewSwitch", "onHide:init wait....");
      AppMethodBeat.o(311955);
      return;
    }
    Log.d("WxIme.ImeFloatViewSwitch", "onHide type:1 end:false");
    com.tencent.mm.plugin.hld.floatview.b localb = JuI;
    if (localb != null) {
      a.a.a((com.tencent.mm.plugin.hld.floatview.a)localb, false, 0L, 2);
    }
    AppMethodBeat.o(311955);
  }
  
  private static final void ig(Context paramContext)
  {
    AppMethodBeat.i(311965);
    s.u(paramContext, "$context");
    long l = System.currentTimeMillis();
    JuI = new com.tencent.mm.plugin.hld.floatview.b(paramContext);
    JuJ = new com.tencent.mm.plugin.hld.floatview.f(paramContext);
    JuK = new c(paramContext);
    Jox = true;
    Log.i("WxIme.ImeFloatViewSwitch", s.X("init ", Long.valueOf(System.currentTimeMillis() - l)));
    AppMethodBeat.o(311965);
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(311877);
    s.u(paramContext, "context");
    h.ahAA.bm(new f..ExternalSyntheticLambda0(paramContext));
    AppMethodBeat.o(311877);
  }
  
  public static void rL(long paramLong)
  {
    AppMethodBeat.i(311935);
    Log.d("WxIme.ImeFloatViewSwitch", s.X("onHide delayMs:", Long.valueOf(paramLong)));
    if (!Jox)
    {
      Log.i("WxIme.ImeFloatViewSwitch", "onHide:init wait....");
      AppMethodBeat.o(311935);
      return;
    }
    Object localObject = JuK;
    if (localObject != null) {
      a.a.a((com.tencent.mm.plugin.hld.floatview.a)localObject, false, 0L, 3);
    }
    localObject = JuJ;
    if (localObject != null) {
      a.a.a((com.tencent.mm.plugin.hld.floatview.a)localObject, false, 0L, 3);
    }
    localObject = JuI;
    if (localObject != null) {
      a.a.a((com.tencent.mm.plugin.hld.floatview.a)localObject, false, paramLong, 1);
    }
    AppMethodBeat.o(311935);
  }
  
  public static void reset(Context paramContext)
  {
    AppMethodBeat.i(311886);
    s.u(paramContext, "context");
    Jox = false;
    init(paramContext);
    AppMethodBeat.o(311886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.f
 * JD-Core Version:    0.7.0.1
 */