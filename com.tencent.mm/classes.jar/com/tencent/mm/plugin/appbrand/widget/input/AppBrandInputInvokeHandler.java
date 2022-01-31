package com.tencent.mm.plugin.appbrand.widget.input;

import android.os.Looper;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.plugin.appbrand.ui.l;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.d;
import com.tencent.mm.plugin.appbrand.widget.input.c.a;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.a;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.a.c.a;
import com.tencent.mm.ui.tools.f.a;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

public abstract class AppBrandInputInvokeHandler
  implements z<x>
{
  private static final String TAG = "MicroMsg.AppBrandInputInvokeHandler";
  private final ah H = new ah(Looper.getMainLooper());
  private final c.a inputExceedMaxLengthCallback = new AppBrandInputInvokeHandler.8(this);
  private final Runnable mAutoScrollForMultiLineRunnerAfterSmileyPanelSettle = new AppBrandInputInvokeHandler.9(this);
  private x mInput;
  final View.OnFocusChangeListener mInputFocusChangeListenerImpl = new AppBrandInputInvokeHandler.1(this);
  private int mInputId;
  private int mLastContentHeight = -1;
  private int mLastLineCount = -1;
  private u mNumberKeyboard;
  private volatile AppBrandInputInvokeHandler.a mOnInputFocusChangeListener;
  private volatile b mOnLineHeightChangeListener;
  protected WeakReference<com.tencent.mm.plugin.appbrand.page.q> mPageRef;
  private e mParams;
  private boolean mPerformingDelete = false;
  private final Runnable mResetPerformingDelete = new AppBrandInputInvokeHandler.10(this);
  private final v.d mSmileyChosenListener = new AppBrandInputInvokeHandler.2(this);
  private final v.c mSmileyOnDoneListener = new AppBrandInputInvokeHandler.3(this);
  private v mSmileyPanel;
  private final v.e mSmileyVisibilityListener = new AppBrandInputInvokeHandler.4(this);
  private AppBrandInputInvokeHandler.c mTextDoneReason = null;
  private final a mValueChangeNotify = new a();
  
  private void dispatchKeyboardComplete(boolean paramBoolean)
  {
    if (this.mInput == null) {
      return;
    }
    String str = this.mInput.getText().toString();
    int i = this.mInput.getSelectionEnd();
    if (this.mTextDoneReason == AppBrandInputInvokeHandler.c.htu) {}
    for (boolean bool = true;; bool = false)
    {
      onInputDone(str, i, bool, paramBoolean);
      return;
    }
  }
  
  @Deprecated
  private void doHideKeyboard()
  {
    if (!isFocused()) {
      y.d("MicroMsg.AppBrandInputInvokeHandler", "doHideKeyboard, not focused, return");
    }
    v localv;
    do
    {
      return;
      localv = findSmileyPanel();
    } while (localv == null);
    localv.setVisibility(8);
  }
  
  @Deprecated
  private void doShowKeyboard()
  {
    if ((this.mInput == null) || (this.mPageRef == null) || (this.mPageRef.get() == null)) {
      return;
    }
    this.mInput.performClick();
  }
  
  private void doneTextInput()
  {
    if ((this.mTextDoneReason == AppBrandInputInvokeHandler.c.htu) && (ai.f(this.mParams.hyU))) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        hideSmileyPanel();
      }
      if (this.mInput != null)
      {
        if (this.mInput.hasFocus()) {
          dispatchKeyboardComplete(bool);
        }
        if (!bool)
        {
          if (this.mSmileyPanel != null) {
            this.mSmileyPanel.b(this.mInput);
          }
          if (!this.mParams.hyu) {
            break;
          }
          removeInputImpl(this.mInput);
          onDestroy();
        }
      }
      return;
    }
    this.mInput.setFocusable(false);
    this.mInput.setFocusableInTouchMode(false);
  }
  
  private u findNumberKeyboard()
  {
    if (this.mNumberKeyboard != null) {
      return this.mNumberKeyboard;
    }
    if (this.mPageRef != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.page.q)this.mPageRef.get();
      if (localObject != null) {}
    }
    else
    {
      return null;
    }
    Object localObject = u.cl(((com.tencent.mm.plugin.appbrand.page.q)localObject).getContentView());
    this.mNumberKeyboard = ((u)localObject);
    return localObject;
  }
  
  private v findSmileyPanel()
  {
    if (this.mSmileyPanel != null) {
      return this.mSmileyPanel;
    }
    if (this.mPageRef != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.page.q)this.mPageRef.get();
      if (localObject != null) {}
    }
    else
    {
      return null;
    }
    Object localObject = v.cn(((com.tencent.mm.plugin.appbrand.page.q)localObject).getContentView());
    this.mSmileyPanel = ((v)localObject);
    return localObject;
  }
  
  private void hideNumberKeyboard()
  {
    if (findNumberKeyboard() != null) {
      this.mNumberKeyboard.setVisibility(8);
    }
  }
  
  private void hideSmileyPanel()
  {
    if (findSmileyPanel() != null) {
      this.mSmileyPanel.hide();
    }
    for (;;)
    {
      j.a(this.mPageRef).mN(getInputId());
      return;
      if (this.mPageRef != null)
      {
        Object localObject = (com.tencent.mm.plugin.appbrand.page.q)this.mPageRef.get();
        if (localObject == null) {
          break;
        }
        localObject = ((com.tencent.mm.plugin.appbrand.page.q)localObject).anc();
        if (localObject != null) {
          ((ac)localObject).XM();
        }
      }
    }
  }
  
  private void initSmileyPanelAndShow()
  {
    Object localObject = (com.tencent.mm.plugin.appbrand.page.q)this.mPageRef.get();
    if (!android.support.v4.view.q.ao(((com.tencent.mm.plugin.appbrand.page.q)localObject).getContentView())) {
      return;
    }
    this.mSmileyPanel = v.co(((com.tencent.mm.plugin.appbrand.page.q)localObject).getContentView());
    setupSmileyPanelListeners();
    hideNumberKeyboard();
    this.mInput.a(this.mInputFocusChangeListenerImpl);
    this.mInput.setOnKeyListener(new AppBrandInputInvokeHandler.5(this));
    n.a((com.tencent.mm.plugin.appbrand.page.q)this.mPageRef.get(), this.mInput);
    localObject = this.mSmileyPanel;
    boolean bool;
    if ((!this.mParams.hyt) && ("emoji".equals(this.mParams.hys)))
    {
      bool = true;
      ((v)localObject).setCanSmileyInput(bool);
      if (this.mParams.hyO.booleanValue()) {
        break label299;
      }
      if (this.mParams.hyT != null) {
        break label288;
      }
      localObject = com.tencent.mm.plugin.appbrand.widget.input.d.b.asK();
      label149:
      int i = ((com.tencent.mm.plugin.appbrand.widget.input.d.b)localObject).hym;
      this.mInput.setImeOptions(i);
      this.mInput.setOnEditorActionListener(new AppBrandInputInvokeHandler.6(this, i));
      label178:
      this.mSmileyPanel.setShowDoneButton(this.mParams.hyP.booleanValue());
      this.mSmileyPanel.hvc = this.mInput;
      if (this.mParams.hyO.booleanValue()) {
        break label318;
      }
      this.mInput.requestFocus();
      this.mSmileyPanel.show();
    }
    for (;;)
    {
      if (!this.mParams.hyO.booleanValue()) {
        j.a(this.mPageRef).mM(getInputId());
      }
      ((com.tencent.mm.plugin.appbrand.page.q)this.mPageRef.get()).a(new AppBrandInputInvokeHandler.7(this));
      return;
      bool = false;
      break;
      label288:
      localObject = this.mParams.hyT;
      break label149;
      label299:
      this.mInput.setOnEditorActionListener(null);
      this.mInput.setImeOptions(0);
      break label178;
      label318:
      this.mInput.setFocusable(false);
      this.mInput.setFocusableInTouchMode(false);
      this.mSmileyPanel.hide();
    }
  }
  
  private void insertInputImpl(int paramInt1, int paramInt2)
  {
    this.mPageRef = this.mParams.hsZ;
    if (this.mPageRef == null) {}
    for (com.tencent.mm.plugin.appbrand.page.q localq = null; (localq == null) || (localq.gTF == null); localq = (com.tencent.mm.plugin.appbrand.page.q)this.mPageRef.get())
    {
      y.e("MicroMsg.AppBrandInputInvokeHandler", "insertInputImpl, view not ready, return fail");
      onRuntimeFail();
      return;
    }
    if (ai.f(this.mParams.hyO)) {}
    for (Object localObject = new p(localq.mContext);; localObject = new s(localq.mContext))
    {
      this.mInput = ((x)localObject);
      this.mInputId = this.mParams.hsX;
      this.mInput.setInputId(this.mInputId);
      n.b(localq, this);
      resetInputAttributes();
      this.mInput.setText(bk.pm(this.mParams.hyx));
      if (ai.f(this.mParams.hyQ)) {
        lineHeightMaybeChanged();
      }
      this.mInput.addTextChangedListener(new AppBrandInputInvokeHandler.11(this));
      this.mInput.setOnComposingDismissedListener(new AppBrandInputInvokeHandler.12(this));
      this.mInput.setOnKeyUpPostImeListener(new AppBrandInputInvokeHandler.13(this));
      if (addInputImpl(this.mInput, this.mParams)) {
        break;
      }
      y.e("MicroMsg.AppBrandInputInvokeHandler", "add custom view into webView failed");
      onRuntimeFail();
      return;
    }
    if ((this.mParams.hyw != null) && (!bk.dk(this.mParams.hyw.hyg))) {
      d.a(localq, this.mInput, this.mParams.hyw);
    }
    if (!ai.f(this.mParams.hyO)) {
      b.a(this.mInput, paramInt1, paramInt2);
    }
    if (ai.f(this.mParams.hyO)) {
      this.mInput.post(new AppBrandInputInvokeHandler.14(this));
    }
    if (("text".equalsIgnoreCase(this.mParams.hys)) || ("emoji".equalsIgnoreCase(this.mParams.hys))) {
      initSmileyPanelAndShow();
    }
    for (;;)
    {
      this.mInput.setOnClickListener(new AppBrandInputInvokeHandler.15(this));
      onInputInitialized();
      return;
      Assert.assertTrue("Number type implementation removed from here", false);
    }
  }
  
  private void lineHeightMaybeChanged()
  {
    if (this.mInput == null) {
      break label7;
    }
    label7:
    while ((this.mInput.getLineCount() == this.mLastLineCount) && (this.mInput.ask() == this.mLastContentHeight)) {
      return;
    }
    if (this.mLastLineCount == -1) {}
    for (int i = 1;; i = 0)
    {
      this.mLastLineCount = this.mInput.getLineCount();
      this.mLastContentHeight = this.mInput.ask();
      if (this.mOnLineHeightChangeListener != null) {
        this.mOnLineHeightChangeListener.bW(this.mLastLineCount, this.mLastContentHeight);
      }
      if ((!this.mParams.hyO.booleanValue()) || (i != 0)) {
        break;
      }
      mayAutoResizeInputHeight();
      mayAutoScrollIfMultiLine();
      return;
    }
  }
  
  private void mayAutoResizeInputHeight()
  {
    int k;
    int i;
    if ((this.mInput != null) && (ai.f(this.mParams.hyQ)) && (ai.f(this.mParams.hyO)))
    {
      ((p)this.mInput).setAutoHeight(true);
      j = this.mInput.getLineHeight();
      k = this.mInput.ask();
      if ((this.mParams.hyC != null) && (this.mParams.hyC.intValue() > 0)) {
        break label161;
      }
      i = j;
      if ((this.mParams.hyD != null) && (this.mParams.hyD.intValue() > 0)) {
        break label175;
      }
    }
    label161:
    label175:
    for (int j = 2147483647;; j = Math.max(this.mParams.hyD.intValue(), j))
    {
      this.mInput.setMinHeight(i);
      this.mInput.setMaxHeight(j);
      this.mParams.hyz = Integer.valueOf(Math.max(i, Math.min(k, j)));
      updateInputPosition(this.mInput, this.mParams);
      return;
      i = this.mParams.hyC.intValue();
      break;
    }
  }
  
  private void mayAutoScrollIfMultiLine()
  {
    if ((this.mParams.hyO.booleanValue()) && (this.mSmileyPanel != null) && (this.mSmileyPanel.isShown()) && (this.mInput != null) && (this.mInput == this.mSmileyPanel.getAttachedEditText())) {
      j.a(this.mPageRef).mM(getInputId());
    }
  }
  
  private void notifyInputFocusChange(boolean paramBoolean)
  {
    if (paramBoolean) {
      setupSmileyFocus();
    }
    if (this.mSmileyPanel == null) {
      this.mSmileyPanel = findSmileyPanel();
    }
    if (this.mOnInputFocusChangeListener != null) {
      this.mOnInputFocusChangeListener.dc(paramBoolean);
    }
    if ((this.mInput != null) && (paramBoolean) && (this.mParams.hyO.booleanValue())) {
      com.tencent.mm.sdk.platformtools.ai.l(this.mAutoScrollForMultiLineRunnerAfterSmileyPanelSettle, 100L);
    }
    if ((this.mInput != null) && (!paramBoolean) && (!this.mParams.hyu))
    {
      if (this.mTextDoneReason == null) {
        dispatchKeyboardComplete(false);
      }
      this.mInput.setFocusable(false);
      this.mInput.setFocusableInTouchMode(false);
      if (this.mSmileyPanel.getAttachedEditText() == this.mInput)
      {
        this.mSmileyPanel.hide();
        this.mSmileyPanel.b(this.mInput);
      }
    }
    if ((this.mSmileyPanel != null) && (this.mInput != null) && (!paramBoolean) && (this.mParams.hyu)) {
      removeInputWhenFocusLoss();
    }
  }
  
  private void onDestroy()
  {
    this.mInput = null;
    com.tencent.mm.plugin.appbrand.v.c.aa(this);
  }
  
  @Deprecated
  private boolean removeInput()
  {
    if ((this.mInput == null) || (this.mPageRef == null) || (this.mPageRef.get() == null)) {
      return false;
    }
    this.mInput.destroy();
    g localg = (g)((com.tencent.mm.plugin.appbrand.page.q)this.mPageRef.get()).agO();
    if (localg == null) {
      return false;
    }
    if (this.mInput.hasFocus())
    {
      if (this.mNumberKeyboard != null) {
        this.mNumberKeyboard.setVisibility(8);
      }
      findSmileyPanel();
      if (this.mSmileyPanel != null) {
        this.mSmileyPanel.setVisibility(8);
      }
    }
    localg.cg(this.mInput);
    return true;
  }
  
  private void removeInputWhenFocusLoss()
  {
    dispatchKeyboardComplete(false);
    if (!this.mParams.hyu) {
      return;
    }
    removeInputImpl(this.mInput);
    onDestroy();
  }
  
  private void resetInputAttributes()
  {
    b.a(this.mInput, this.mParams);
    if (this.mParams.hyH == null)
    {
      this.mParams.hyH = Integer.valueOf(140);
      com.tencent.mm.ui.tools.a.c localc = o.a(this.mInput).Ig(this.mParams.hyH.intValue());
      localc.wfM = false;
      localc.huj = f.a.wcS;
      localc.a(this.inputExceedMaxLengthCallback);
      this.mInput.setPasswordMode(this.mParams.hyt);
      if (!ai.f(this.mParams.hyM)) {
        break label236;
      }
      this.mInput.setEnabled(false);
      this.mInput.setFocusable(false);
      this.mInput.setFocusableInTouchMode(false);
      this.mInput.setClickable(false);
    }
    for (;;)
    {
      if ((this.mInput instanceof p))
      {
        if (this.mParams.hyW != null) {
          ((p)this.mInput).setLineSpace(this.mParams.hyW.intValue());
        }
        if (this.mParams.hyX != null) {
          ((p)this.mInput).setLineHeight(this.mParams.hyX.intValue());
        }
      }
      return;
      if (this.mParams.hyH.intValue() > 0) {
        break;
      }
      this.mParams.hyH = Integer.valueOf(2147483647);
      break;
      label236:
      this.mInput.setEnabled(true);
      this.mInput.setClickable(true);
    }
  }
  
  private void setInputSelection(int paramInt1, int paramInt2)
  {
    b.a(this.mInput, paramInt1, paramInt2);
    mayAutoScrollIfMultiLine();
  }
  
  private void setupSmileyFocus()
  {
    if (this.mParams.hyO.booleanValue()) {
      findSmileyPanel();
    }
    if ((this.mSmileyPanel != null) && (this.mInput != null))
    {
      this.mSmileyPanel.hvc = this.mInput;
      this.mSmileyPanel.setShowDoneButton(ai.f(this.mParams.hyP));
      setupSmileyPanelListeners();
      if ((l.bW(this.mInput)) && (this.mInput.hasFocus())) {
        this.mSmileyPanel.show();
      }
    }
  }
  
  private void setupSmileyPanelListeners()
  {
    if (this.mSmileyPanel == null) {
      return;
    }
    this.mSmileyPanel.setOnSmileyChosenListener(this.mSmileyChosenListener);
    this.mSmileyPanel.setOnDoneListener(this.mSmileyOnDoneListener);
    this.mSmileyPanel.setOnVisibilityChangedListener(this.mSmileyVisibilityListener);
  }
  
  boolean addInputImpl(x paramx, e parame)
  {
    if ((paramx == null) || (this.mPageRef == null) || (this.mPageRef.get() == null)) {
      return false;
    }
    g localg = (g)((com.tencent.mm.plugin.appbrand.page.q)this.mPageRef.get()).agO();
    return (localg != null) && (localg.a(((com.tencent.mm.plugin.appbrand.page.q)this.mPageRef.get()).gTF, paramx, parame.hyy.intValue(), parame.hyz.intValue(), parame.hyB.intValue(), parame.hyA.intValue()));
  }
  
  public boolean adjustPositionOnFocused()
  {
    return (this.mParams != null) && (ai.f(this.mParams.hyV));
  }
  
  public final int getInputId()
  {
    return this.mInputId;
  }
  
  public <P extends View,  extends ab> P getInputPanel()
  {
    return this.mSmileyPanel;
  }
  
  public int getInputPanelMarginBottom()
  {
    if ((this.mParams != null) && (this.mParams.hyS != null)) {
      return this.mParams.hyS.intValue();
    }
    if ((this.mInput != null) && (this.mInput.arT())) {
      return 5;
    }
    return 0;
  }
  
  public x getWidget()
  {
    return this.mInput;
  }
  
  public boolean hideKeyboard()
  {
    doHideKeyboard();
    return true;
  }
  
  public final void insertInput(e parame, int paramInt1, int paramInt2)
  {
    com.tencent.mm.plugin.appbrand.v.c.aU(this);
    this.mParams = parame;
    insertInputImpl(paramInt1, paramInt2);
  }
  
  public boolean isAttachedTo(com.tencent.mm.plugin.appbrand.page.q paramq)
  {
    return (paramq != null) && (this.mPageRef != null) && (paramq == this.mPageRef.get());
  }
  
  public boolean isFocused()
  {
    return (this.mInput != null) && ((this.mInput.isFocused()) || ((findSmileyPanel() != null) && (findSmileyPanel().getAttachedEditText() == this.mInput)));
  }
  
  public abstract void onBackspacePressedWhileValueNoChange(String paramString);
  
  public abstract void onInputDone(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void onInputInitialized();
  
  public abstract void onRuntimeFail();
  
  void removeInputImpl(x paramx)
  {
    if (paramx == null) {}
    label58:
    for (;;)
    {
      return;
      paramx.b(this.mInputFocusChangeListenerImpl);
      if (this.mPageRef == null) {}
      for (Object localObject = null;; localObject = (com.tencent.mm.plugin.appbrand.page.q)this.mPageRef.get())
      {
        if (localObject == null) {
          break label58;
        }
        localObject = (g)((com.tencent.mm.plugin.appbrand.page.q)localObject).agO();
        if (localObject == null) {
          break;
        }
        ((g)localObject).cg(paramx);
        return;
      }
    }
  }
  
  public boolean removeSelf()
  {
    if (removeInput())
    {
      onDestroy();
      return true;
    }
    return false;
  }
  
  public void setOnInputFocusChangeListener(AppBrandInputInvokeHandler.a parama)
  {
    this.mOnInputFocusChangeListener = parama;
  }
  
  public void setOnLineHeightChangeListener(b paramb)
  {
    this.mOnLineHeightChangeListener = paramb;
  }
  
  public void setOnValueChangeListener(com.tencent.mm.plugin.appbrand.widget.input.c.c paramc)
  {
    this.mValueChangeNotify.hxw = paramc;
  }
  
  public boolean showKeyboard(int paramInt1, int paramInt2)
  {
    doShowKeyboard();
    setInputSelection(paramInt1, paramInt2);
    return true;
  }
  
  public final boolean updateInput(h paramh)
  {
    if ((this.mParams == null) || (this.mInput == null)) {}
    do
    {
      return false;
      this.mParams.a(paramh);
    } while ((!this.mParams.hyv) && ((this.mParams.hyz == null) || (this.mParams.hyz.intValue() <= 0)));
    this.mInput.setWillNotDraw(true);
    resetInputAttributes();
    if (this.mParams.hyx != null) {
      this.mInput.q(bk.pm(this.mParams.hyx));
    }
    if (!ai.f(this.mParams.hyQ)) {
      updateInputPosition(this.mInput, this.mParams);
    }
    for (;;)
    {
      this.mInput.setWillNotDraw(false);
      this.mInput.invalidate();
      return true;
      mayAutoResizeInputHeight();
      lineHeightMaybeChanged();
    }
  }
  
  boolean updateInputPosition(x paramx, e parame)
  {
    if ((paramx == null) || (this.mPageRef == null) || (this.mPageRef.get() == null)) {
      return false;
    }
    g localg = (g)((com.tencent.mm.plugin.appbrand.page.q)this.mPageRef.get()).agO();
    return (localg != null) && (localg.b(((com.tencent.mm.plugin.appbrand.page.q)this.mPageRef.get()).gTF, paramx, parame.hyy.intValue(), parame.hyz.intValue(), parame.hyB.intValue(), parame.hyA.intValue()));
  }
  
  public void updateValue(String paramString, Integer paramInteger)
  {
    if (this.mInput == null) {
      return;
    }
    this.mInput.q(paramString);
    if (paramInteger == null) {}
    for (int i = -1;; i = paramInteger.intValue())
    {
      paramString = Integer.valueOf(i);
      setInputSelection(paramString.intValue(), paramString.intValue());
      lineHeightMaybeChanged();
      return;
    }
  }
  
  public static abstract interface b
  {
    public abstract void bW(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler
 * JD-Core Version:    0.7.0.1
 */