package com.tencent.mm.plugin.hld.candidate;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.plugin.hld.f.k;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.view.ImeEditText;
import com.tencent.mm.plugin.hld.view.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.af;
import com.tencent.wxhld.WxhldApi;
import com.tencent.wxhld.info.PendingInput;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/candidate/ImeUnfoldStrikeView;", "Lcom/tencent/mm/plugin/hld/candidate/IPendingInputDataListener;", "Lcom/tencent/mm/plugin/hld/view/ImeEditTextCursorListener;", "Landroid/view/View$OnTouchListener;", "()V", "TAG", "", "loc", "", "mAdjustX", "", "mAdjustY", "mAnchorView", "Landroid/view/View;", "mBottomYOffSet", "mContext", "Landroid/content/Context;", "mCursorHandleView", "mCursorHandleWidow", "Landroid/widget/PopupWindow;", "mInitializeSuccess", "", "mStrikeContainerWidow", "mStrikeEt", "Lcom/tencent/mm/plugin/hld/view/ImeEditText;", "mStrikeMaskView", "mUnfoldStrikeContainerView", "offset", "getOffset", "()Ljava/lang/Integer;", "setOffset", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "calculateOffset", "rawX", "rawY", "(II)Ljava/lang/Integer;", "init", "", "context", "onCursorLocation", "x", "y", "cursorIndex", "onHide", "onShow", "anchorView", "onTouch", "v", "event", "Landroid/view/MotionEvent;", "reset", "showUnfoldStrikeView", "updatePendingInputData", "pendingInputs", "", "Lcom/tencent/wxhld/info/PendingInput;", "lastPendingInputContent", "", "([Lcom/tencent/wxhld/info/PendingInput;Ljava/lang/CharSequence;I)V", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements View.OnTouchListener, b, d
{
  private static int JoA;
  private static int JoB;
  private static final int[] JoC;
  private static Integer JoD;
  public static final f Jor;
  private static PopupWindow Jos;
  private static View Jot;
  static ImeEditText Jou;
  private static View Jov;
  static int Jow;
  private static boolean Jox;
  private static PopupWindow Joy;
  private static View Joz;
  private static Context mContext;
  static View mF;
  
  static
  {
    AppMethodBeat.i(312878);
    Jor = new f();
    JoC = new int[2];
    AppMethodBeat.o(312878);
  }
  
  private static final void Yo(int paramInt)
  {
    AppMethodBeat.i(312873);
    ImeEditText localImeEditText = Jou;
    if (localImeEditText != null) {
      localImeEditText.setSelection(paramInt);
    }
    AppMethodBeat.o(312873);
  }
  
  static void fKT()
  {
    AppMethodBeat.i(312854);
    PopupWindow localPopupWindow = Jos;
    if (localPopupWindow != null)
    {
      int i = localPopupWindow.getHeight();
      Object localObject1 = k.JyF;
      localObject1 = Jou;
      s.checkNotNull(localObject1);
      localObject1 = (TextView)localObject1;
      Object localObject2 = com.tencent.mm.plugin.hld.model.n.JvW;
      localObject2 = com.tencent.mm.plugin.hld.model.n.fMP();
      Context localContext = mContext;
      s.checkNotNull(localContext);
      int j = k.b((TextView)localObject1, (CharSequence)localObject2, localContext.getResources().getDisplayMetrics().widthPixels - com.tencent.mm.cd.a.bs(mContext, a.d.ime_strike_container_content_margin_left) * 2) + com.tencent.mm.cd.a.bs(mContext, a.d.ime_strike_container_top_margin) * 2 + com.tencent.mm.cd.a.bs(mContext, a.d.ime_strike_container_content_margin_bottom) + com.tencent.mm.cd.a.bs(mContext, a.d.bottomsheet_dividing_line_height);
      if ((i != j) || (!localPopupWindow.isShowing()))
      {
        int k = Jow;
        localObject1 = l.JyV;
        localObject1 = mContext;
        s.checkNotNull(localObject1);
        k = k - j - l.getStatusBarHeight((Context)localObject1);
        localObject1 = new StringBuilder().append(localPopupWindow.isShowing()).append(" yOffset:").append(k).append(" mBottomYOffSet:").append(Jow).append(" newHeight:").append(j).append(" statusBar:");
        localObject2 = l.JyV;
        localObject2 = mContext;
        s.checkNotNull(localObject2);
        Log.d("WxIme.ImeUnfoldStrikeView", l.getStatusBarHeight((Context)localObject2) + " oriHeight:" + i + " newHeight:" + j);
        if (mF != null)
        {
          if (!localPopupWindow.isShowing())
          {
            localPopupWindow.dismiss();
            localPopupWindow.setHeight(j);
            localPopupWindow.showAtLocation(mF, 8388659, 0, k);
            AppMethodBeat.o(312854);
            return;
          }
          localPopupWindow.update(0, k, localPopupWindow.getWidth(), j);
          AppMethodBeat.o(312854);
          return;
        }
        Log.e("WxIme.ImeUnfoldStrikeView", "mAnchorView is null?");
        AppMethodBeat.o(312854);
        return;
      }
      Log.d("WxIme.ImeUnfoldStrikeView", "oriHeight:" + i + " newHeight:" + j);
    }
    AppMethodBeat.o(312854);
  }
  
  private static final void hK(View paramView)
  {
    AppMethodBeat.i(312867);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/candidate/ImeUnfoldStrikeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    Jor.onHide();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/hld/candidate/ImeUnfoldStrikeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(312867);
  }
  
  private static Integer jn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(312863);
    paramInt1 -= JoC[0];
    int i = JoB;
    Object localObject1 = Joz;
    s.checkNotNull(localObject1);
    int j = ((View)localObject1).getMeasuredHeight();
    localObject1 = Jou;
    s.checkNotNull(localObject1);
    int k = ((ImeEditText)localObject1).getMeasuredHeight();
    localObject1 = Jou;
    s.checkNotNull(localObject1);
    paramInt2 = i + paramInt2 - j - k / ((ImeEditText)localObject1).getLineCount() - JoC[1];
    localObject1 = (View)Jou;
    Object localObject2 = Jou;
    s.checkNotNull(localObject2);
    i = com.tencent.mm.ui.widget.textview.b.h((View)localObject1, paramInt1, paramInt2, ((ImeEditText)localObject2).getSelectionStart());
    localObject2 = new StringBuilder("onTouch ").append(paramInt1).append(' ').append(paramInt2).append(" offset:").append(i).append(" oriOffset:");
    localObject1 = Jou;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = Integer.valueOf(((ImeEditText)localObject1).getSelectionStart()))
    {
      Log.d("WxIme.ImeUnfoldStrikeView", localObject1);
      localObject1 = Jou;
      if (localObject1 != null) {
        ((ImeEditText)localObject1).setSelection(i);
      }
      AppMethodBeat.o(312863);
      return Integer.valueOf(i);
    }
  }
  
  public final void a(PendingInput[] paramArrayOfPendingInput, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(312920);
    paramArrayOfPendingInput = Jou;
    s.checkNotNull(paramArrayOfPendingInput);
    int i = paramArrayOfPendingInput.getMCurrentCursorIndex();
    paramArrayOfPendingInput = new StringBuilder("updatePendingInputData length:");
    com.tencent.mm.plugin.hld.model.n localn = com.tencent.mm.plugin.hld.model.n.JvW;
    paramArrayOfPendingInput = paramArrayOfPendingInput.append(com.tencent.mm.plugin.hld.model.n.fMP().length()).append(" lastLength:");
    s.checkNotNull(paramCharSequence);
    Log.i("WxIme.ImeUnfoldStrikeView", paramCharSequence.length() + " cursorIndex:" + paramInt + " lastPendingInputCursorIndex:" + i);
    paramArrayOfPendingInput = com.tencent.mm.plugin.hld.model.n.JvW;
    if ((Util.isEqual(paramCharSequence, com.tencent.mm.plugin.hld.model.n.fMP())) && (i == paramInt))
    {
      AppMethodBeat.o(312920);
      return;
    }
    paramArrayOfPendingInput = Jou;
    s.checkNotNull(paramArrayOfPendingInput);
    paramArrayOfPendingInput.fPq();
    paramArrayOfPendingInput = Jou;
    s.checkNotNull(paramArrayOfPendingInput);
    paramCharSequence = com.tencent.mm.plugin.hld.model.n.JvW;
    paramArrayOfPendingInput.setText(com.tencent.mm.plugin.hld.model.n.fMP());
    paramArrayOfPendingInput = Jou;
    if (paramArrayOfPendingInput != null) {
      paramArrayOfPendingInput.post(new f..ExternalSyntheticLambda1(paramInt));
    }
    paramArrayOfPendingInput = com.tencent.mm.plugin.hld.model.n.JvW;
    if (Util.isNullOrNil(com.tencent.mm.plugin.hld.model.n.fMP()))
    {
      onHide();
      AppMethodBeat.o(312920);
      return;
    }
    fKT();
    AppMethodBeat.o(312920);
  }
  
  public final void init(Context paramContext)
  {
    AppMethodBeat.i(312901);
    s.u(paramContext, "context");
    long l = System.currentTimeMillis();
    mContext = paramContext;
    Object localObject = af.mU(paramContext).inflate(a.h.ime_unfold_strike_container_view, null, false);
    Jou = (ImeEditText)((View)localObject).findViewById(a.f.un_fold_strike_et);
    Jov = ((View)localObject).findViewById(a.f.un_fold_strike_mask);
    com.tencent.mm.plugin.hld.view.f.JzR.a(((View)localObject).findViewById(a.f.strike_unfold_back_ll), f..ExternalSyntheticLambda0.INSTANCE);
    Jot = (View)localObject;
    localObject = new PopupWindow(Jot);
    ((PopupWindow)localObject).setClippingEnabled(false);
    ((PopupWindow)localObject).setInputMethodMode(2);
    if (Build.VERSION.SDK_INT >= 23)
    {
      l locall = l.JyV;
      ((PopupWindow)localObject).setWindowLayoutType(l.fOG());
    }
    ((PopupWindow)localObject).setWidth(paramContext.getResources().getDisplayMetrics().widthPixels);
    Jos = (PopupWindow)localObject;
    paramContext = af.mU(paramContext).inflate(a.h.ime_unfold_strike_container_cursor_handle_view, null, false);
    paramContext.setOnTouchListener((View.OnTouchListener)Jor);
    Joz = paramContext;
    paramContext = new PopupWindow(Joz);
    paramContext.setClippingEnabled(true);
    paramContext.setInputMethodMode(2);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = l.JyV;
      paramContext.setWindowLayoutType(l.fOG());
    }
    paramContext.setWidth(com.tencent.mm.cd.a.bs(mContext, a.d.ime_strike_container_cursor_handle_width));
    paramContext.setHeight(com.tencent.mm.cd.a.bs(mContext, a.d.ime_strike_container_cursor_handle_height));
    Joy = paramContext;
    paramContext = Jov;
    if (paramContext != null) {
      paramContext.setOnTouchListener((View.OnTouchListener)this);
    }
    Jox = true;
    Log.i("WxIme.ImeUnfoldStrikeView", s.X("init inter time:", Long.valueOf(System.currentTimeMillis() - l)));
    AppMethodBeat.o(312901);
  }
  
  public final void jm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(312927);
    Object localObject = Jou;
    s.checkNotNull(localObject);
    int i = ((ImeEditText)localObject).getMeasuredHeight();
    localObject = Jou;
    s.checkNotNull(localObject);
    i /= ((ImeEditText)localObject).getLineCount();
    localObject = Joy;
    s.checkNotNull(localObject);
    paramInt1 -= ((PopupWindow)localObject).getWidth() / 2;
    localObject = l.JyV;
    localObject = mContext;
    s.checkNotNull(localObject);
    int j = paramInt2 - l.getStatusBarHeight((Context)localObject);
    Log.d("WxIme.ImeUnfoldStrikeView", "onCursorLocation y:" + paramInt2 + " lineHeight:" + i);
    localObject = Joy;
    s.checkNotNull(localObject);
    if (!((PopupWindow)localObject).isShowing())
    {
      localObject = Joy;
      s.checkNotNull(localObject);
      ((PopupWindow)localObject).dismiss();
      localObject = Joy;
      s.checkNotNull(localObject);
      ((PopupWindow)localObject).showAtLocation(mF, 8388659, paramInt1, j);
      AppMethodBeat.o(312927);
      return;
    }
    localObject = Joy;
    s.checkNotNull(localObject);
    PopupWindow localPopupWindow = Joy;
    s.checkNotNull(localPopupWindow);
    paramInt2 = localPopupWindow.getWidth();
    localPopupWindow = Joy;
    s.checkNotNull(localPopupWindow);
    ((PopupWindow)localObject).update(paramInt1, j, paramInt2, localPopupWindow.getHeight());
    AppMethodBeat.o(312927);
  }
  
  public final void onHide()
  {
    AppMethodBeat.i(312913);
    Log.d("WxIme.ImeUnfoldStrikeView", "onHide");
    if (!Jox)
    {
      Log.i("WxIme.ImeUnfoldStrikeView", "onHide:init wait....");
      AppMethodBeat.o(312913);
      return;
    }
    Object localObject = Jou;
    if (localObject != null) {
      ((ImeEditText)localObject).setImeEditTextCursorListener(null);
    }
    localObject = com.tencent.mm.plugin.hld.model.n.JvW;
    com.tencent.mm.plugin.hld.model.n.b((b)this);
    localObject = com.tencent.mm.plugin.hld.model.n.JvW;
    com.tencent.mm.plugin.hld.model.n.fMM();
    localObject = Jos;
    if (localObject != null) {
      ((PopupWindow)localObject).dismiss();
    }
    localObject = Joy;
    if (localObject != null) {
      ((PopupWindow)localObject).dismiss();
    }
    mF = null;
    AppMethodBeat.o(312913);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(312938);
    Object localObject1;
    int i;
    int j;
    if (paramMotionEvent == null)
    {
      localObject1 = null;
      s.checkNotNull(paramMotionEvent);
      i = (int)paramMotionEvent.getRawX();
      j = (int)paramMotionEvent.getRawY();
      if (localObject1 != null) {
        break label120;
      }
      label38:
      if (localObject1 != null) {
        break label171;
      }
      label43:
      if (localObject1 != null) {
        break label192;
      }
      label48:
      paramMotionEvent = new StringBuilder("onTouch action:").append(localObject1).append(' ');
      if (paramView != null) {
        break label336;
      }
    }
    label171:
    label192:
    label336:
    for (paramView = localObject2;; paramView = Integer.valueOf(paramView.getId()))
    {
      Log.d("WxIme.ImeUnfoldStrikeView", paramView + ' ' + JoD);
      AppMethodBeat.o(312938);
      return true;
      localObject1 = Integer.valueOf(paramMotionEvent.getActionMasked());
      break;
      label120:
      if (((Integer)localObject1).intValue() != 0) {
        break label38;
      }
      JoA = (int)paramMotionEvent.getX();
      JoB = (int)paramMotionEvent.getY();
      paramMotionEvent = Jou;
      s.checkNotNull(paramMotionEvent);
      paramMotionEvent.getLocationOnScreen(JoC);
      JoD = jn(i, j);
      break label48;
      if (((Integer)localObject1).intValue() != 2) {
        break label43;
      }
      JoD = jn(i, j);
      break label48;
      if (((Integer)localObject1).intValue() != 1) {
        break label48;
      }
      paramMotionEvent = JoD;
      if (paramMotionEvent == null) {
        break label48;
      }
      i = ((Number)paramMotionEvent).intValue();
      paramMotionEvent = com.tencent.mm.plugin.hld.model.n.JvW;
      Log.i("WxIme.WxEngineMgr", "setCursorIndex " + com.tencent.mm.plugin.hld.model.n.JvX + ' ' + i + ' ' + com.tencent.mm.plugin.hld.model.n.fMP().length());
      if (com.tencent.mm.plugin.hld.model.n.fNa()) {
        break label48;
      }
      i = kotlin.n.n.bV(com.tencent.mm.plugin.hld.model.n.fMP().subSequence(i, com.tencent.mm.plugin.hld.model.n.fMP().length()).toString(), " ", "").length();
      Log.d("WxIme.WxEngineMgr", s.X("setCursorIndex ", Integer.valueOf(i)));
      WxhldApi.session_set_internal_cursor(com.tencent.mm.plugin.hld.model.n.JvX, i);
      break label48;
    }
  }
  
  public final void reset(Context paramContext)
  {
    AppMethodBeat.i(312906);
    s.u(paramContext, "context");
    onHide();
    Jox = false;
    init(paramContext);
    AppMethodBeat.o(312906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.candidate.f
 * JD-Core Version:    0.7.0.1
 */