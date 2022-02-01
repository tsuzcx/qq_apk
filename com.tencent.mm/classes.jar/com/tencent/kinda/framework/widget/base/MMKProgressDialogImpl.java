package com.tencent.kinda.framework.widget.base;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.kinda.framework.R.string;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KProgressDialog;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.i;

public class MMKProgressDialogImpl
  implements KProgressDialog
{
  private static final String TAG = "MMKProgressDialogImpl";
  private Dialog mDialogImpl;
  private Dialog mLoadingImpl;
  private Dialog mPayProcessImpl;
  
  private void runInMainThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(264459);
    if (MMHandlerThread.isMainThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(264459);
      return;
    }
    MMHandlerThread.postToMainThread(paramRunnable);
    AppMethodBeat.o(264459);
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
        AppMethodBeat.i(264059);
        MMKProgressDialogImpl.access$002(MMKProgressDialogImpl.this, i.a(paramString, paramBoolean, new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(264210);
            MMKProgressDialogImpl.1.this.val$cancel.call();
            MMKProgressDialogImpl.access$002(MMKProgressDialogImpl.this, null);
            AppMethodBeat.o(264210);
          }
        }));
        if ((paramString instanceof MMActivity)) {
          ((MMActivity)paramString).addDialog(MMKProgressDialogImpl.this.mDialogImpl);
        }
        AppMethodBeat.o(264059);
      }
    });
    AppMethodBeat.o(19098);
  }
  
  public void showNormalGlobalLoading(boolean paramBoolean)
  {
    AppMethodBeat.i(264457);
    showNormalLoading(paramBoolean);
    AppMethodBeat.o(264457);
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
        AppMethodBeat.i(263756);
        MMKProgressDialogImpl localMMKProgressDialogImpl = MMKProgressDialogImpl.this;
        Context localContext = localContext;
        String str = this.val$text;
        if (!paramBoolean) {}
        for (boolean bool = true;; bool = false)
        {
          MMKProgressDialogImpl.access$202(localMMKProgressDialogImpl, i.c(localContext, str, bool, new DialogInterface.OnCancelListener()
          {
            public void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(264105);
              if (MMKProgressDialogImpl.this.mLoadingImpl != null)
              {
                MMKProgressDialogImpl.this.mLoadingImpl.dismiss();
                MMKProgressDialogImpl.access$202(MMKProgressDialogImpl.this, null);
              }
              AppMethodBeat.o(264105);
            }
          }));
          if ((localContext instanceof MMActivity)) {
            ((MMActivity)localContext).addDialog(MMKProgressDialogImpl.this.mLoadingImpl);
          }
          AppMethodBeat.o(263756);
          return;
        }
      }
    });
    AppMethodBeat.o(170127);
  }
  
  public void showPayGlobalLoading(boolean paramBoolean)
  {
    AppMethodBeat.i(264458);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      showImpl("", paramBoolean, new VoidCallback()
      {
        public void call() {}
      });
      AppMethodBeat.o(264458);
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
        AppMethodBeat.i(263604);
        MMKProgressDialogImpl.access$102(MMKProgressDialogImpl.this, i.a(localContext, paramBoolean, new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(263297);
            MMKProgressDialogImpl.2.this.val$cancel.call();
            MMKProgressDialogImpl.access$102(MMKProgressDialogImpl.this, null);
            AppMethodBeat.o(263297);
          }
        }));
        if ((localContext instanceof MMActivity)) {
          ((MMActivity)localContext).addDialog(MMKProgressDialogImpl.this.mPayProcessImpl);
        }
        AppMethodBeat.o(263604);
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
    h.cO(localContext, paramString);
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
        AppMethodBeat.i(264399);
        MMKProgressDialogImpl localMMKProgressDialogImpl = MMKProgressDialogImpl.this;
        Context localContext = paramString;
        String str = this.val$text;
        if (!paramBoolean) {}
        for (boolean bool = true;; bool = false)
        {
          MMKProgressDialogImpl.access$202(localMMKProgressDialogImpl, i.c(localContext, str, bool, new DialogInterface.OnCancelListener()
          {
            public void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(263624);
              if (MMKProgressDialogImpl.this.mLoadingImpl != null)
              {
                MMKProgressDialogImpl.this.mLoadingImpl.dismiss();
                MMKProgressDialogImpl.access$202(MMKProgressDialogImpl.this, null);
              }
              AppMethodBeat.o(263624);
            }
          }));
          if ((paramString instanceof MMActivity)) {
            ((MMActivity)paramString).addDialog(MMKProgressDialogImpl.this.mLoadingImpl);
          }
          AppMethodBeat.o(264399);
          return;
        }
      }
    });
    AppMethodBeat.o(19102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKProgressDialogImpl
 * JD-Core Version:    0.7.0.1
 */