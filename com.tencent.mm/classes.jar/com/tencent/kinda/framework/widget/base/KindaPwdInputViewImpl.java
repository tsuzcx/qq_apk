package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import com.tencent.kinda.gen.IUIModal;
import com.tencent.kinda.gen.IUIPage;
import com.tencent.kinda.gen.KPwdInputView;
import com.tencent.kinda.gen.KPwdInputViewOnEndEnterPasswordCallback;
import com.tencent.kinda.gen.KPwdInputViewOnPasswordChangeCallback;
import com.tencent.kinda.gen.PwdEncryptMode;
import com.tencent.kinda.gen.PwdViewStyle;
import com.tencent.kinda.gen.Sm2HashType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;
import com.tencent.mm.wallet_core.ui.formview.a;
import com.tencent.mm.wallet_core.ui.i;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.lang.ref.WeakReference;

public class KindaPwdInputViewImpl
  extends MMKView<EditHintPasswdView>
  implements KPwdInputView
{
  private WeakReference<Context> mContext;
  private KPwdInputViewOnPasswordChangeCallback pwdChangeCallback;
  private PwdEncryptMode pwdEncryptMode = PwdEncryptMode.RSA;
  private KPwdInputViewOnEndEnterPasswordCallback pwdEndCallback;
  private String pwdNonce = "";
  private PwdViewStyle pwdStyle = PwdViewStyle.CHECKPWDSTYLE;
  private long pwdTimestamp = 0L;
  private EditHintPasswdView pwdView;
  
  public EditHintPasswdView createView(Context paramContext)
  {
    AppMethodBeat.i(18933);
    this.mContext = new WeakReference(paramContext);
    this.pwdView = new EditHintPasswdView(paramContext);
    if ((this.pwdStyle == PwdViewStyle.CHECKPWDSTYLE) || (this.pwdStyle == PwdViewStyle.HALFPAGECASHIERSTYLE)) {
      this.pwdView.aGC(1);
    }
    for (;;)
    {
      a.a(this.pwdView);
      this.pwdView.setEditTextMaxLength(6);
      if ((paramContext instanceof BaseFrActivity)) {
        ((BaseFrActivity)paramContext).setEditFocusListener(this.pwdView, 0, false, true, null, true);
      }
      this.pwdView.setOnInputValidListener(new EditHintPasswdView.a()
      {
        public void onInputValidChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(18931);
          Object localObject = KindaPwdInputViewImpl.this.pwdView;
          if (((EditHintPasswdView)localObject).mEditText != null)
          {
            if (((EditHintPasswdView)localObject).pwdNonce.length() > 0) {
              TenpaySecureEditText.setSalt(((EditHintPasswdView)localObject).pwdNonce);
            }
          }
          else
          {
            if (!paramAnonymousBoolean) {
              break label236;
            }
            if (KindaPwdInputViewImpl.this.pwdEncryptMode != PwdEncryptMode.SM2WITHMD5) {
              break label209;
            }
            KindaPwdInputViewImpl.this.pwdView.setEncrType(4);
          }
          for (;;)
          {
            KindaPwdInputViewImpl.this.pwdView.setPwdNonce(KindaPwdInputViewImpl.this.pwdNonce);
            KindaPwdInputViewImpl.this.pwdView.setPwdTimestamp(KindaPwdInputViewImpl.this.pwdTimestamp);
            KindaPwdInputViewImpl.this.pwdView.getText();
            if (KindaPwdInputViewImpl.this.pwdEndCallback != null) {
              KindaPwdInputViewImpl.this.pwdEndCallback.onEndEnterPassword(KindaPwdInputViewImpl.this.pwdView.getText(), KindaPwdInputViewImpl.this.pwdView.getMd5Value());
            }
            if (KindaPwdInputViewImpl.this.pwdChangeCallback != null) {
              KindaPwdInputViewImpl.this.pwdChangeCallback.onPasswordChange(6, KindaPwdInputViewImpl.this.pwdView.getText(), KindaPwdInputViewImpl.this.pwdView.getMd5Value());
            }
            AppMethodBeat.o(18931);
            return;
            TenpaySecureEditText.setSalt(i.jPu());
            break;
            label209:
            if (KindaPwdInputViewImpl.this.pwdEncryptMode == PwdEncryptMode.SM2WITHPBKDF2) {
              KindaPwdInputViewImpl.this.pwdView.setEncrType(5);
            }
          }
          label236:
          if (KindaPwdInputViewImpl.this.pwdChangeCallback != null)
          {
            localObject = KindaPwdInputViewImpl.this.pwdView.getEditText().getText().toString();
            KindaPwdInputViewImpl.this.pwdChangeCallback.onPasswordChange(((String)localObject).length(), KindaPwdInputViewImpl.this.pwdView.getText(), KindaPwdInputViewImpl.this.pwdView.getMd5Value());
          }
          AppMethodBeat.o(18931);
        }
      });
      paramContext = this.pwdView;
      AppMethodBeat.o(18933);
      return paramContext;
      this.pwdView.aGC(0);
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
  
  public PwdEncryptMode getPwdEncryptMode()
  {
    return this.pwdEncryptMode;
  }
  
  public String getPwdNonce()
  {
    return this.pwdNonce;
  }
  
  public PwdViewStyle getPwdStyle()
  {
    return this.pwdStyle;
  }
  
  public long getPwdTimestamp()
  {
    return this.pwdTimestamp;
  }
  
  public long getTextLength()
  {
    return 0L;
  }
  
  public void setAccessible(boolean paramBoolean)
  {
    AppMethodBeat.i(226494);
    super.setAccessible(paramBoolean);
    this.pwdView.getEditText().setImportantForAccessibility(2);
    AppMethodBeat.o(226494);
  }
  
  public void setAutoRemarkKeyBoradType(boolean paramBoolean) {}
  
  public void setChearInput(boolean paramBoolean)
  {
    AppMethodBeat.i(18935);
    if (paramBoolean) {
      this.pwdView.gGd();
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
          AppMethodBeat.i(226484);
          KindaPwdInputViewImpl.this.pwdView.clearFocus();
          AppMethodBeat.o(226484);
        }
      });
    }
    AppMethodBeat.o(18934);
  }
  
  public void setFocusModalListener(IUIModal paramIUIModal)
  {
    AppMethodBeat.i(226538);
    if (paramIUIModal == null)
    {
      Log.i("base_MMKView", "modal == null.");
      AppMethodBeat.o(226538);
      return;
    }
    paramIUIModal = paramIUIModal.getFuncDelegate();
    if ((paramIUIModal instanceof UIModalFuncDelegateImpl))
    {
      paramIUIModal = (MMFragment)((UIModalFuncDelegateImpl)paramIUIModal).weakFragment.get();
      if (paramIUIModal == null)
      {
        Log.i("base_MMKView", "delegateImpl.activity == null.");
        AppMethodBeat.o(226538);
        return;
      }
      if (this.mContext == null)
      {
        Log.i("base_MMKView", "mContext == null.");
        AppMethodBeat.o(226538);
        return;
      }
      Context localContext = (Context)this.mContext.get();
      if (localContext == null)
      {
        Log.i("base_MMKView", "tempContext == null.");
        AppMethodBeat.o(226538);
        return;
      }
      if ((localContext instanceof BaseFrActivity)) {
        ((BaseFrActivity)localContext).setEditFocusListener(this.pwdView, 0, false, true, paramIUIModal, true);
      }
    }
    AppMethodBeat.o(226538);
  }
  
  public void setFocusUIPageListener(IUIPage paramIUIPage)
  {
    AppMethodBeat.i(226539);
    if (paramIUIPage == null)
    {
      Log.i("base_MMKView", "page == null.");
      AppMethodBeat.o(226539);
      return;
    }
    paramIUIPage = paramIUIPage.getPlatformFuncDelegate();
    if ((paramIUIPage instanceof UIPagePlatformDelegateImpl))
    {
      paramIUIPage = (MMFragment)((UIModalFuncDelegateImpl)paramIUIPage).weakFragment.get();
      if (paramIUIPage == null)
      {
        Log.i("base_MMKView", "delegateImpl.activity == null.");
        AppMethodBeat.o(226539);
        return;
      }
      if (this.mContext == null)
      {
        Log.i("base_MMKView", "mContext == null.");
        AppMethodBeat.o(226539);
        return;
      }
      Context localContext = (Context)this.mContext.get();
      if (localContext == null)
      {
        Log.i("base_MMKView", "tempContext == null.");
        AppMethodBeat.o(226539);
        return;
      }
      if ((localContext instanceof BaseFrActivity)) {
        ((BaseFrActivity)localContext).setEditFocusListener(this.pwdView, 0, false, true, paramIUIPage, true);
      }
    }
    AppMethodBeat.o(226539);
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
  
  public void setPwdEncryptMode(PwdEncryptMode paramPwdEncryptMode)
  {
    this.pwdEncryptMode = paramPwdEncryptMode;
  }
  
  public void setPwdNonce(String paramString)
  {
    this.pwdNonce = paramString;
  }
  
  public void setPwdStyle(PwdViewStyle paramPwdViewStyle)
  {
    AppMethodBeat.i(226525);
    Log.d("base_MMKView", "set pwd: %s", new Object[] { paramPwdViewStyle });
    this.pwdStyle = paramPwdViewStyle;
    if ((this.pwdStyle == PwdViewStyle.CHECKPWDSTYLE) || (this.pwdStyle == PwdViewStyle.HALFPAGECASHIERSTYLE))
    {
      this.pwdView.aGC(1);
      AppMethodBeat.o(226525);
      return;
    }
    this.pwdView.aGC(0);
    AppMethodBeat.o(226525);
  }
  
  public void setPwdTimestamp(long paramLong)
  {
    this.pwdTimestamp = paramLong;
  }
  
  public void setTextLength(long paramLong) {}
  
  public Sm2HashType sm2HashType()
  {
    AppMethodBeat.i(226509);
    h.baF();
    Object localObject = (Integer)h.baE().ban().get(at.a.acNb, Integer.valueOf(0));
    localObject = Sm2HashType.values()[localObject.intValue()];
    AppMethodBeat.o(226509);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaPwdInputViewImpl
 * JD-Core Version:    0.7.0.1
 */