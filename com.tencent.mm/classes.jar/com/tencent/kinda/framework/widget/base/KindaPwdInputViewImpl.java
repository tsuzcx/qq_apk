package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import com.tencent.kinda.gen.IUIModal;
import com.tencent.kinda.gen.IUIPage;
import com.tencent.kinda.gen.KPwdInputView;
import com.tencent.kinda.gen.KPwdInputViewOnEndEnterPasswordCallback;
import com.tencent.kinda.gen.KPwdInputViewOnPasswordChangeCallback;
import com.tencent.kinda.gen.PwdViewStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;
import com.tencent.mm.wallet_core.ui.formview.a;
import com.tencent.mm.wallet_core.ui.g;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.lang.ref.WeakReference;

public class KindaPwdInputViewImpl
  extends MMKView<EditHintPasswdView>
  implements KPwdInputView
{
  private WeakReference<Context> mContext;
  private KPwdInputViewOnPasswordChangeCallback pwdChangeCallback;
  private KPwdInputViewOnEndEnterPasswordCallback pwdEndCallback;
  private PwdViewStyle pwdStyle = PwdViewStyle.CHECKPWDSTYLE;
  private EditHintPasswdView pwdView;
  
  public EditHintPasswdView createView(Context paramContext)
  {
    AppMethodBeat.i(18933);
    this.mContext = new WeakReference(paramContext);
    this.pwdView = new EditHintPasswdView(paramContext);
    if ((this.pwdStyle == PwdViewStyle.CHECKPWDSTYLE) || (this.pwdStyle == PwdViewStyle.HALFPAGECASHIERSTYLE)) {
      this.pwdView.azM(1);
    }
    for (;;)
    {
      a.a(this.pwdView);
      if ((paramContext instanceof BaseFrActivity)) {
        ((BaseFrActivity)paramContext).setEditFocusListener(this.pwdView, 0, false, true, null, true);
      }
      this.pwdView.setOnInputValidListener(new EditHintPasswdView.a()
      {
        public void onInputValidChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(18931);
          if (KindaPwdInputViewImpl.this.pwdView.mEditText != null) {
            TenpaySecureEditText.setSalt(g.ijw());
          }
          if (paramAnonymousBoolean)
          {
            KindaPwdInputViewImpl.this.pwdView.getText();
            if (KindaPwdInputViewImpl.this.pwdEndCallback != null) {
              KindaPwdInputViewImpl.this.pwdEndCallback.onEndEnterPassword(KindaPwdInputViewImpl.this.pwdView.getText(), KindaPwdInputViewImpl.this.pwdView.getMd5Value());
            }
            if (KindaPwdInputViewImpl.this.pwdChangeCallback != null) {
              KindaPwdInputViewImpl.this.pwdChangeCallback.onPasswordChange(6, KindaPwdInputViewImpl.this.pwdView.getText(), KindaPwdInputViewImpl.this.pwdView.getMd5Value());
            }
            AppMethodBeat.o(18931);
            return;
          }
          if (KindaPwdInputViewImpl.this.pwdChangeCallback != null) {
            KindaPwdInputViewImpl.this.pwdChangeCallback.onPasswordChange(0, KindaPwdInputViewImpl.this.pwdView.getText(), KindaPwdInputViewImpl.this.pwdView.getMd5Value());
          }
          AppMethodBeat.o(18931);
        }
      });
      paramContext = this.pwdView;
      AppMethodBeat.o(18933);
      return paramContext;
      this.pwdView.azM(0);
    }
  }
  
  public boolean getAutoRemarkKeyBoradType()
  {
    return false;
  }
  
  public boolean getChearInput()
  {
    return false;
  }
  
  public boolean getFocus()
  {
    return false;
  }
  
  public String getHashData()
  {
    return null;
  }
  
  public PwdViewStyle getPwdStyle()
  {
    return this.pwdStyle;
  }
  
  public long getTextLength()
  {
    return 0L;
  }
  
  public void setAutoRemarkKeyBoradType(boolean paramBoolean) {}
  
  public void setChearInput(boolean paramBoolean)
  {
    AppMethodBeat.i(18935);
    if (paramBoolean) {
      this.pwdView.fuo();
    }
    AppMethodBeat.o(18935);
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(18934);
    if ((paramBoolean) && (this.pwdView.getVisibility() == 0) && (!this.pwdView.hasFocus()))
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(18932);
          KindaPwdInputViewImpl.this.pwdView.requestFocus();
          AppMethodBeat.o(18932);
        }
      });
      AppMethodBeat.o(18934);
      return;
    }
    if (!paramBoolean) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(263107);
          KindaPwdInputViewImpl.this.pwdView.clearFocus();
          AppMethodBeat.o(263107);
        }
      });
    }
    AppMethodBeat.o(18934);
  }
  
  public void setFocusModalListener(IUIModal paramIUIModal)
  {
    AppMethodBeat.i(263948);
    if (paramIUIModal == null)
    {
      Log.i("base_MMKView", "modal == null.");
      AppMethodBeat.o(263948);
      return;
    }
    paramIUIModal = paramIUIModal.getFuncDelegate();
    if ((paramIUIModal instanceof UIModalFuncDelegateImpl))
    {
      paramIUIModal = (MMFragment)((UIModalFuncDelegateImpl)paramIUIModal).weakFragment.get();
      if (paramIUIModal == null)
      {
        Log.i("base_MMKView", "delegateImpl.activity == null.");
        AppMethodBeat.o(263948);
        return;
      }
      if (this.mContext == null)
      {
        Log.i("base_MMKView", "mContext == null.");
        AppMethodBeat.o(263948);
        return;
      }
      Context localContext = (Context)this.mContext.get();
      if (localContext == null)
      {
        Log.i("base_MMKView", "tempContext == null.");
        AppMethodBeat.o(263948);
        return;
      }
      if ((localContext instanceof BaseFrActivity)) {
        ((BaseFrActivity)localContext).setEditFocusListener(this.pwdView, 0, false, true, paramIUIModal, true);
      }
    }
    AppMethodBeat.o(263948);
  }
  
  public void setFocusUIPageListener(IUIPage paramIUIPage)
  {
    AppMethodBeat.i(263949);
    if (paramIUIPage == null)
    {
      Log.i("base_MMKView", "page == null.");
      AppMethodBeat.o(263949);
      return;
    }
    paramIUIPage = paramIUIPage.getPlatformFuncDelegate();
    if ((paramIUIPage instanceof UIPagePlatformDelegateImpl))
    {
      paramIUIPage = (MMFragment)((UIModalFuncDelegateImpl)paramIUIPage).weakFragment.get();
      if (paramIUIPage == null)
      {
        Log.i("base_MMKView", "delegateImpl.activity == null.");
        AppMethodBeat.o(263949);
        return;
      }
      if (this.mContext == null)
      {
        Log.i("base_MMKView", "mContext == null.");
        AppMethodBeat.o(263949);
        return;
      }
      Context localContext = (Context)this.mContext.get();
      if (localContext == null)
      {
        Log.i("base_MMKView", "tempContext == null.");
        AppMethodBeat.o(263949);
        return;
      }
      if ((localContext instanceof BaseFrActivity)) {
        ((BaseFrActivity)localContext).setEditFocusListener(this.pwdView, 0, false, true, paramIUIPage, true);
      }
    }
    AppMethodBeat.o(263949);
  }
  
  public void setHashData(String paramString) {}
  
  public void setOnEndEnterPasswordCallback(KPwdInputViewOnEndEnterPasswordCallback paramKPwdInputViewOnEndEnterPasswordCallback)
  {
    if (paramKPwdInputViewOnEndEnterPasswordCallback != null) {
      this.pwdEndCallback = paramKPwdInputViewOnEndEnterPasswordCallback;
    }
  }
  
  public void setOnPasswordChangeCallback(KPwdInputViewOnPasswordChangeCallback paramKPwdInputViewOnPasswordChangeCallback)
  {
    if (paramKPwdInputViewOnPasswordChangeCallback != null) {
      this.pwdChangeCallback = paramKPwdInputViewOnPasswordChangeCallback;
    }
  }
  
  public void setPwdStyle(PwdViewStyle paramPwdViewStyle)
  {
    AppMethodBeat.i(263945);
    Log.d("base_MMKView", "set pwd: %s", new Object[] { paramPwdViewStyle });
    this.pwdStyle = paramPwdViewStyle;
    if ((this.pwdStyle == PwdViewStyle.CHECKPWDSTYLE) || (this.pwdStyle == PwdViewStyle.HALFPAGECASHIERSTYLE))
    {
      this.pwdView.azM(1);
      AppMethodBeat.o(263945);
      return;
    }
    this.pwdView.azM(0);
    AppMethodBeat.o(263945);
  }
  
  public void setTextLength(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaPwdInputViewImpl
 * JD-Core Version:    0.7.0.1
 */