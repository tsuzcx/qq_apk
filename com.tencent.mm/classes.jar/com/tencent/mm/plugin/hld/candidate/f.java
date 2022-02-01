package com.tencent.mm.plugin.hld.candidate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.plugin.hld.f.k;
import com.tencent.mm.plugin.hld.view.ImeEditText;
import com.tencent.mm.plugin.hld.view.e;
import com.tencent.mm.plugin.hld.view.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ad;
import com.tencent.wxhld.WxhldApi;
import com.tencent.wxhld.info.PendingInput;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/candidate/ImeUnfoldStrikeView;", "Lcom/tencent/mm/plugin/hld/candidate/IPendingInputDataListener;", "Lcom/tencent/mm/plugin/hld/view/ImeEditTextCursorListener;", "Landroid/view/View$OnTouchListener;", "()V", "TAG", "", "loc", "", "mAdjustX", "", "mAdjustY", "mAnchorView", "Landroid/view/View;", "mBottomYOffSet", "mContext", "Landroid/content/Context;", "mCursorHandleView", "mCursorHandleWidow", "Landroid/widget/PopupWindow;", "mInitializeSuccess", "", "mStrikeContainerWidow", "mStrikeEt", "Lcom/tencent/mm/plugin/hld/view/ImeEditText;", "mStrikeMaskView", "mUnfoldStrikeContainerView", "offset", "getOffset", "()Ljava/lang/Integer;", "setOffset", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "calculateOffset", "rawX", "rawY", "(II)Ljava/lang/Integer;", "init", "", "context", "onCursorLocation", "x", "y", "cursorIndex", "onHide", "onShow", "anchorView", "onTouch", "v", "event", "Landroid/view/MotionEvent;", "reset", "showUnfoldStrikeView", "updatePendingInputData", "pendingInputs", "", "Lcom/tencent/wxhld/info/PendingInput;", "lastPendingInputContent", "", "([Lcom/tencent/wxhld/info/PendingInput;Ljava/lang/CharSequence;I)V", "plugin-hld_release"})
@SuppressLint({"StaticFieldLeak"})
public final class f
  implements View.OnTouchListener, b, e
{
  private static PopupWindow DuV;
  private static View DuW;
  static ImeEditText DuX;
  private static View DuY;
  static int DuZ;
  public static boolean Dva;
  private static PopupWindow Dvb;
  private static View Dvc;
  private static int Dvd;
  private static int Dve;
  private static final int[] Dvf;
  private static Integer Dvg;
  public static final f Dvh;
  static View lJ;
  private static Context mContext;
  
  static
  {
    AppMethodBeat.i(211599);
    Dvh = new f();
    Dvf = new int[2];
    AppMethodBeat.o(211599);
  }
  
  static void eCR()
  {
    AppMethodBeat.i(211590);
    PopupWindow localPopupWindow = DuV;
    if (localPopupWindow != null)
    {
      int i = localPopupWindow.getHeight();
      Object localObject1 = k.DHH;
      localObject1 = DuX;
      if (localObject1 == null) {
        p.iCn();
      }
      localObject1 = (TextView)localObject1;
      Object localObject2 = com.tencent.mm.plugin.hld.model.n.DEn;
      localObject2 = com.tencent.mm.plugin.hld.model.n.eEM();
      Object localObject3 = mContext;
      if (localObject3 == null) {
        p.iCn();
      }
      localObject3 = ((Context)localObject3).getResources();
      p.j(localObject3, "mContext!!.resources");
      int j = k.b((TextView)localObject1, (CharSequence)localObject2, ((Resources)localObject3).getDisplayMetrics().widthPixels - com.tencent.mm.ci.a.aZ(mContext, a.d.ime_strike_container_content_margin_left) * 2) + com.tencent.mm.ci.a.aZ(mContext, a.d.ime_strike_container_top_margin) * 2 + com.tencent.mm.ci.a.aZ(mContext, a.d.ime_strike_container_content_margin_bottom) + com.tencent.mm.ci.a.aZ(mContext, a.d.bottomsheet_dividing_line_height);
      if ((i != j) || (!localPopupWindow.isShowing()))
      {
        int k = DuZ;
        localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
        localObject1 = mContext;
        if (localObject1 == null) {
          p.iCn();
        }
        k = k - j - com.tencent.mm.plugin.hld.f.l.getStatusBarHeight((Context)localObject1);
        localObject1 = new StringBuilder().append(localPopupWindow.isShowing()).append(" yOffset:").append(k).append(" mBottomYOffSet:").append(DuZ).append(" newHeight:").append(j).append(" statusBar:");
        localObject2 = com.tencent.mm.plugin.hld.f.l.DHK;
        localObject2 = mContext;
        if (localObject2 == null) {
          p.iCn();
        }
        Log.d("WxIme.ImeUnfoldStrikeView", com.tencent.mm.plugin.hld.f.l.getStatusBarHeight((Context)localObject2) + " oriHeight:" + i + " newHeight:" + j);
        if (lJ != null)
        {
          if (!localPopupWindow.isShowing())
          {
            localPopupWindow.dismiss();
            localPopupWindow.setHeight(j);
            localPopupWindow.showAtLocation(lJ, 8388659, 0, k);
            AppMethodBeat.o(211590);
            return;
          }
          localPopupWindow.update(0, k, localPopupWindow.getWidth(), j);
          AppMethodBeat.o(211590);
          return;
        }
        Log.e("WxIme.ImeUnfoldStrikeView", "mAnchorView is null?");
        AppMethodBeat.o(211590);
        return;
      }
      Log.d("WxIme.ImeUnfoldStrikeView", "oriHeight:" + i + " newHeight:" + j);
      AppMethodBeat.o(211590);
      return;
    }
    AppMethodBeat.o(211590);
  }
  
  private static Integer hJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211597);
    aa.f localf = new aa.f();
    paramInt1 -= Dvf[0];
    int i = Dve;
    Object localObject1 = Dvc;
    if (localObject1 == null) {
      p.iCn();
    }
    int j = ((View)localObject1).getMeasuredHeight();
    localObject1 = DuX;
    if (localObject1 == null) {
      p.iCn();
    }
    int k = ((ImeEditText)localObject1).getMeasuredHeight();
    localObject1 = DuX;
    if (localObject1 == null) {
      p.iCn();
    }
    paramInt2 = i + paramInt2 - j - k / ((ImeEditText)localObject1).getLineCount() - Dvf[1];
    localObject1 = (View)DuX;
    Object localObject2 = DuX;
    if (localObject2 == null) {
      p.iCn();
    }
    i = com.tencent.mm.ui.widget.textview.b.i((View)localObject1, paramInt1, paramInt2, ((ImeEditText)localObject2).getSelectionStart());
    localObject2 = new StringBuilder("onTouch ").append(paramInt1).append(' ').append(paramInt2).append(" offset:").append(i).append(" oriOffset:");
    localObject1 = DuX;
    if (localObject1 != null) {}
    for (localObject1 = Integer.valueOf(((ImeEditText)localObject1).getSelectionStart());; localObject1 = null)
    {
      Log.d("WxIme.ImeUnfoldStrikeView", localObject1);
      localObject1 = DuX;
      if (localObject1 != null) {
        ((ImeEditText)localObject1).setSelection(i);
      }
      localf.aaBC = Integer.valueOf(i);
      localObject1 = (Integer)localf.aaBC;
      AppMethodBeat.o(211597);
      return localObject1;
    }
  }
  
  public final void a(PendingInput[] paramArrayOfPendingInput, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(211593);
    paramArrayOfPendingInput = DuX;
    if (paramArrayOfPendingInput == null) {
      p.iCn();
    }
    int i = paramArrayOfPendingInput.getMCurrentCursorIndex();
    paramArrayOfPendingInput = new StringBuilder("updatePendingInputData length:");
    com.tencent.mm.plugin.hld.model.n localn = com.tencent.mm.plugin.hld.model.n.DEn;
    paramArrayOfPendingInput = paramArrayOfPendingInput.append(com.tencent.mm.plugin.hld.model.n.eEM().length()).append(" lastLength:");
    if (paramCharSequence == null) {
      p.iCn();
    }
    Log.i("WxIme.ImeUnfoldStrikeView", paramCharSequence.length() + " cursorIndex:" + paramInt + " lastPendingInputCursorIndex:" + i);
    paramArrayOfPendingInput = com.tencent.mm.plugin.hld.model.n.DEn;
    if ((Util.isEqual(paramCharSequence, com.tencent.mm.plugin.hld.model.n.eEM())) && (i == paramInt))
    {
      AppMethodBeat.o(211593);
      return;
    }
    paramArrayOfPendingInput = DuX;
    if (paramArrayOfPendingInput == null) {
      p.iCn();
    }
    paramArrayOfPendingInput.eHE();
    paramArrayOfPendingInput = DuX;
    if (paramArrayOfPendingInput == null) {
      p.iCn();
    }
    paramCharSequence = com.tencent.mm.plugin.hld.model.n.DEn;
    paramArrayOfPendingInput.setText(com.tencent.mm.plugin.hld.model.n.eEM());
    paramArrayOfPendingInput = DuX;
    if (paramArrayOfPendingInput != null) {
      paramArrayOfPendingInput.post((Runnable)new b(paramInt));
    }
    paramArrayOfPendingInput = com.tencent.mm.plugin.hld.model.n.DEn;
    if (Util.isNullOrNil(com.tencent.mm.plugin.hld.model.n.eEM()))
    {
      onHide();
      AppMethodBeat.o(211593);
      return;
    }
    eCR();
    AppMethodBeat.o(211593);
  }
  
  public final void hI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211594);
    Object localObject = DuX;
    if (localObject == null) {
      p.iCn();
    }
    int i = ((ImeEditText)localObject).getMeasuredHeight();
    localObject = DuX;
    if (localObject == null) {
      p.iCn();
    }
    i /= ((ImeEditText)localObject).getLineCount();
    localObject = Dvb;
    if (localObject == null) {
      p.iCn();
    }
    paramInt1 -= ((PopupWindow)localObject).getWidth() / 2;
    localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    localObject = mContext;
    if (localObject == null) {
      p.iCn();
    }
    int j = paramInt2 - com.tencent.mm.plugin.hld.f.l.getStatusBarHeight((Context)localObject);
    Log.d("WxIme.ImeUnfoldStrikeView", "onCursorLocation y:" + paramInt2 + " lineHeight:" + i);
    localObject = Dvb;
    if (localObject == null) {
      p.iCn();
    }
    if (!((PopupWindow)localObject).isShowing())
    {
      localObject = Dvb;
      if (localObject == null) {
        p.iCn();
      }
      ((PopupWindow)localObject).dismiss();
      localObject = Dvb;
      if (localObject == null) {
        p.iCn();
      }
      ((PopupWindow)localObject).showAtLocation(lJ, 8388659, paramInt1, j);
      AppMethodBeat.o(211594);
      return;
    }
    localObject = Dvb;
    if (localObject == null) {
      p.iCn();
    }
    PopupWindow localPopupWindow = Dvb;
    if (localPopupWindow == null) {
      p.iCn();
    }
    paramInt2 = localPopupWindow.getWidth();
    localPopupWindow = Dvb;
    if (localPopupWindow == null) {
      p.iCn();
    }
    ((PopupWindow)localObject).update(paramInt1, j, paramInt2, localPopupWindow.getHeight());
    AppMethodBeat.o(211594);
  }
  
  public final void init(Context paramContext)
  {
    AppMethodBeat.i(211587);
    p.k(paramContext, "context");
    long l = System.currentTimeMillis();
    mContext = paramContext;
    Object localObject1 = ad.kS(paramContext).inflate(a.h.ime_unfold_strike_container_view, null, false);
    DuX = (ImeEditText)((View)localObject1).findViewById(a.f.un_fold_strike_et);
    DuY = ((View)localObject1).findViewById(a.f.un_fold_strike_mask);
    Object localObject2 = g.DIP;
    g.a(((View)localObject1).findViewById(a.f.strike_unfold_back_ll), (View.OnClickListener)a.Dvi);
    DuW = (View)localObject1;
    localObject1 = new PopupWindow(DuW);
    ((PopupWindow)localObject1).setClippingEnabled(false);
    ((PopupWindow)localObject1).setInputMethodMode(2);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject2 = com.tencent.mm.plugin.hld.f.l.DHK;
      ((PopupWindow)localObject1).setWindowLayoutType(1003);
    }
    localObject2 = paramContext.getResources();
    p.j(localObject2, "context.resources");
    ((PopupWindow)localObject1).setWidth(((Resources)localObject2).getDisplayMetrics().widthPixels);
    DuV = (PopupWindow)localObject1;
    paramContext = ad.kS(paramContext).inflate(a.h.ime_unfold_strike_container_cursor_handle_view, null, false);
    paramContext.setOnTouchListener((View.OnTouchListener)Dvh);
    Dvc = paramContext;
    paramContext = new PopupWindow(Dvc);
    paramContext.setClippingEnabled(true);
    paramContext.setInputMethodMode(2);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
      paramContext.setWindowLayoutType(1003);
    }
    paramContext.setWidth(com.tencent.mm.ci.a.aZ(mContext, a.d.ime_strike_container_cursor_handle_width));
    paramContext.setHeight(com.tencent.mm.ci.a.aZ(mContext, a.d.ime_strike_container_cursor_handle_height));
    Dvb = paramContext;
    paramContext = DuY;
    if (paramContext != null) {
      paramContext.setOnTouchListener((View.OnTouchListener)this);
    }
    Dva = true;
    Log.i("WxIme.ImeUnfoldStrikeView", "init inter time:" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(211587);
  }
  
  public final void onHide()
  {
    AppMethodBeat.i(211589);
    Log.d("WxIme.ImeUnfoldStrikeView", "onHide");
    if (!Dva)
    {
      Log.i("WxIme.ImeUnfoldStrikeView", "onHide:init wait....");
      AppMethodBeat.o(211589);
      return;
    }
    Object localObject = DuX;
    if (localObject != null) {
      ((ImeEditText)localObject).setImeEditTextCursorListener(null);
    }
    localObject = com.tencent.mm.plugin.hld.model.n.DEn;
    com.tencent.mm.plugin.hld.model.n.b((b)this);
    localObject = com.tencent.mm.plugin.hld.model.n.DEn;
    com.tencent.mm.plugin.hld.model.n.eEJ();
    localObject = DuV;
    if (localObject != null) {
      ((PopupWindow)localObject).dismiss();
    }
    localObject = Dvb;
    if (localObject != null) {
      ((PopupWindow)localObject).dismiss();
    }
    lJ = null;
    AppMethodBeat.o(211589);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(211596);
    Integer localInteger;
    int i;
    int j;
    if (paramMotionEvent != null)
    {
      localInteger = Integer.valueOf(paramMotionEvent.getActionMasked());
      if (paramMotionEvent == null) {
        p.iCn();
      }
      i = (int)paramMotionEvent.getRawX();
      j = (int)paramMotionEvent.getRawY();
      if (localInteger != null) {
        break label125;
      }
      label44:
      if (localInteger != null) {
        break label179;
      }
      label49:
      if (localInteger != null) {
        break label200;
      }
      label54:
      paramMotionEvent = new StringBuilder("onTouch action:").append(localInteger).append(' ');
      if (paramView == null) {
        break label345;
      }
    }
    label179:
    label200:
    label345:
    for (paramView = Integer.valueOf(paramView.getId());; paramView = null)
    {
      Log.d("WxIme.ImeUnfoldStrikeView", paramView + ' ' + Dvg);
      AppMethodBeat.o(211596);
      return true;
      localInteger = null;
      break;
      label125:
      if (localInteger.intValue() != 0) {
        break label44;
      }
      Dvd = (int)paramMotionEvent.getX();
      Dve = (int)paramMotionEvent.getY();
      paramMotionEvent = DuX;
      if (paramMotionEvent == null) {
        p.iCn();
      }
      paramMotionEvent.getLocationOnScreen(Dvf);
      Dvg = hJ(i, j);
      break label54;
      if (localInteger.intValue() != 2) {
        break label49;
      }
      Dvg = hJ(i, j);
      break label54;
      if (localInteger.intValue() != 1) {
        break label54;
      }
      paramMotionEvent = Dvg;
      if (paramMotionEvent == null) {
        break label54;
      }
      i = ((Number)paramMotionEvent).intValue();
      paramMotionEvent = com.tencent.mm.plugin.hld.model.n.DEn;
      Log.i("WxIme.WxEngineMgr", "setCursorIndex " + com.tencent.mm.plugin.hld.model.n.DDY + ' ' + i + ' ' + com.tencent.mm.plugin.hld.model.n.eEM().length());
      if (com.tencent.mm.plugin.hld.model.n.eEX()) {
        break label54;
      }
      i = kotlin.n.n.l(com.tencent.mm.plugin.hld.model.n.eEM().subSequence(i, com.tencent.mm.plugin.hld.model.n.eEM().length()).toString(), " ", "", false).length();
      Log.d("WxIme.WxEngineMgr", "setCursorIndex ".concat(String.valueOf(i)));
      WxhldApi.session_set_internal_cursor(com.tencent.mm.plugin.hld.model.n.DDY, i);
      break label54;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    public static final a Dvi;
    
    static
    {
      AppMethodBeat.i(210720);
      Dvi = new a();
      AppMethodBeat.o(210720);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(210718);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/candidate/ImeUnfoldStrikeView$init$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      f.Dvh.onHide();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/candidate/ImeUnfoldStrikeView$init$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(210718);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(210771);
      Object localObject = f.Dvh;
      localObject = f.eCS();
      if (localObject != null)
      {
        ((ImeEditText)localObject).setSelection(this.Dvj);
        AppMethodBeat.o(210771);
        return;
      }
      AppMethodBeat.o(210771);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.candidate.f
 * JD-Core Version:    0.7.0.1
 */