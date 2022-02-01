package com.tencent.kinda.framework.widget.base;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KProgressDialog;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;

public class MMKProgressDialogImpl
  implements KProgressDialog
{
  private static final String TAG = "MMKProgressDialogImpl";
  private Dialog mDialogImpl;
  private Dialog mLoadingImpl;
  private Dialog mPayProcessImpl;
  
  private void runInMainThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(214557);
    if (MMHandlerThread.isMainThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(214557);
      return;
    }
    MMHandlerThread.postToMainThread(paramRunnable);
    AppMethodBeat.o(214557);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(19101);
    if ((this.mDialogImpl != null) && (this.mDialogImpl.isShowing())) {
      this.mDialogImpl.dismiss();
    }
    if ((this.mPayProcessImpl != null) && (this.mPayProcessImpl.isShowing())) {
      this.mPayProcessImpl.dismiss();
    }
    if ((this.mLoadingImpl != null) && (this.mLoadingImpl.isShowing())) {
      this.mLoadingImpl.dismiss();
    }
    AppMethodBeat.o(19101);
  }
  
  public void showImpl(final String paramString, final boolean paramBoolean, final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(19098);
    paramString = KindaContext.get();
    if (paramString == null)
    {
      Log.e("MMKProgressDialogImpl", "MMKProgressDialogImpl showImpl() KindaContext.get() return null! case 1");
      AppMethodBeat.o(19098);
      return;
    }
    runInMainThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(214548);
        MMKProgressDialogImpl.access$002(MMKProgressDialogImpl.this, com.tencent.mm.wallet_core.ui.h.a(paramString, paramBoolean, new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(214547);
            MMKProgressDialogImpl.1.this.val$cancel.call();
            MMKProgressDialogImpl.access$002(MMKProgressDialogImpl.this, null);
            AppMethodBeat.o(214547);
          }
        }));
        if ((paramString instanceof MMActivity)) {
          ((MMActivity)paramString).addDialog(MMKProgressDialogImpl.this.mDialogImpl);
        }
        AppMethodBeat.o(214548);
      }
    });
    AppMethodBeat.o(19098);
  }
  
  public void showNormalGlobalLoading(boolean paramBoolean)
  {
    AppMethodBeat.i(214555);
    showNormalLoading(paramBoolean);
    AppMethodBeat.o(214555);
  }
  
  public void showNormalLoading(final boolean paramBoolean)
  {
    AppMethodBeat.i(170127);
    final Context localContext = KindaContext.get();
    if (localContext == null)
    {
      Log.e("MMKProgressDialogImpl", "MMKProgressDialogImpl showImpl() KindaContext.get() return null! case 1");
      AppMethodBeat.o(170127);
      return;
    }
    runInMainThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(214554);
        MMKProgressDialogImpl localMMKProgressDialogImpl = MMKProgressDialogImpl.this;
        Context localContext = localContext;
        String str = this.val$text;
        if (!paramBoolean) {}
        for (boolean bool = true;; bool = false)
        {
          MMKProgressDialogImpl.access$202(localMMKProgressDialogImpl, com.tencent.mm.wallet_core.ui.h.c(localContext, str, bool, new DialogInterface.OnCancelListener()
          {
            public void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(214553);
              if (MMKProgressDialogImpl.this.mLoadingImpl != null)
              {
                MMKProgressDialogImpl.this.mLoadingImpl.dismiss();
                MMKProgressDialogImpl.access$202(MMKProgressDialogImpl.this, null);
              }
              AppMethodBeat.o(214553);
            }
          }));
          if ((localContext instanceof MMActivity)) {
            ((MMActivity)localContext).addDialog(MMKProgressDialogImpl.this.mLoadingImpl);
          }
          AppMethodBeat.o(214554);
          return;
        }
      }
    });
    AppMethodBeat.o(170127);
  }
  
  public void showPayGlobalLoading(boolean paramBoolean)
  {
    AppMethodBeat.i(214556);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      showImpl("", paramBoolean, new VoidCallback()
      {
        public void call() {}
      });
      AppMethodBeat.o(214556);
      return;
    }
  }
  
  public void showPayProcessImpl(final boolean paramBoolean, final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(19099);
    final Context localContext = KindaContext.get();
    if (localContext == null)
    {
      Log.e("MMKProgressDialogImpl", "MMKProgressDialogImpl showPayProcessImpl() KindaContext.get() return null! case 2");
      AppMethodBeat.o(19099);
      return;
    }
    runInMainThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(214550);
        MMKProgressDialogImpl.access$102(MMKProgressDialogImpl.this, com.tencent.mm.wallet_core.ui.h.a(localContext, paramBoolean, new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(214549);
            MMKProgressDialogImpl.2.this.val$cancel.call();
            MMKProgressDialogImpl.access$102(MMKProgressDialogImpl.this, null);
            AppMethodBeat.o(214549);
          }
        }));
        if ((localContext instanceof MMActivity)) {
          ((MMActivity)localContext).addDialog(MMKProgressDialogImpl.this.mPayProcessImpl);
        }
        AppMethodBeat.o(214550);
      }
    });
    AppMethodBeat.o(19099);
  }
  
  public void showToast(String paramString)
  {
    AppMethodBeat.i(19100);
    Context localContext = KindaContext.get();
    if (localContext == null)
    {
      Log.e("MMKProgressDialogImpl", "MMKProgressDialogImpl showToast() KindaContext.get() return null! case 3");
      AppMethodBeat.o(19100);
      return;
    }
    com.tencent.mm.ui.base.h.cD(localContext, paramString);
    AppMethodBeat.o(19100);
  }
  
  public void showTopLoading(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(19102);
    paramString = KindaContext.get();
    if (paramString == null)
    {
      Log.e("MMKProgressDialogImpl", "MMKProgressDialogImpl can't startLoading because the context is null!");
      AppMethodBeat.o(19102);
      return;
    }
    runInMainThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(214552);
        MMKProgressDialogImpl localMMKProgressDialogImpl = MMKProgressDialogImpl.this;
        Context localContext = paramString;
        String str = this.val$text;
        if (!paramBoolean) {}
        for (boolean bool = true;; bool = false)
        {
          MMKProgressDialogImpl.access$202(localMMKProgressDialogImpl, com.tencent.mm.wallet_core.ui.h.c(localContext, str, bool, new DialogInterface.OnCancelListener()
          {
            public void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(214551);
              if (MMKProgressDialogImpl.this.mLoadingImpl != null)
              {
                MMKProgressDialogImpl.this.mLoadingImpl.dismiss();
                MMKProgressDialogImpl.access$202(MMKProgressDialogImpl.this, null);
              }
              AppMethodBeat.o(214551);
            }
          }));
          if ((paramString instanceof MMActivity)) {
            ((MMActivity)paramString).addDialog(MMKProgressDialogImpl.this.mLoadingImpl);
          }
          AppMethodBeat.o(214552);
          return;
        }
      }
    });
    AppMethodBeat.o(19102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKProgressDialogImpl
 * JD-Core Version:    0.7.0.1
 */