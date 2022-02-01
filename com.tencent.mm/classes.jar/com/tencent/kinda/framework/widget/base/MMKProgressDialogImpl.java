package com.tencent.kinda.framework.widget.base;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KProgressDialog;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
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
    AppMethodBeat.i(193242);
    if (ar.isMainThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(193242);
      return;
    }
    ar.f(paramRunnable);
    AppMethodBeat.o(193242);
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
      ae.e("MMKProgressDialogImpl", "MMKProgressDialogImpl showImpl() KindaContext.get() return null! case 1");
      AppMethodBeat.o(19098);
      return;
    }
    runInMainThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(193235);
        MMKProgressDialogImpl.access$002(MMKProgressDialogImpl.this, com.tencent.mm.wallet_core.ui.h.a(paramString, paramBoolean, new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(193234);
            MMKProgressDialogImpl.1.this.val$cancel.call();
            MMKProgressDialogImpl.access$002(MMKProgressDialogImpl.this, null);
            AppMethodBeat.o(193234);
          }
        }));
        if ((paramString instanceof MMActivity)) {
          ((MMActivity)paramString).addDialog(MMKProgressDialogImpl.this.mDialogImpl);
        }
        AppMethodBeat.o(193235);
      }
    });
    AppMethodBeat.o(19098);
  }
  
  public void showNormalLoading(final boolean paramBoolean)
  {
    AppMethodBeat.i(170127);
    final Context localContext = KindaContext.get();
    if (localContext == null)
    {
      ae.e("MMKProgressDialogImpl", "MMKProgressDialogImpl showImpl() KindaContext.get() return null! case 1");
      AppMethodBeat.o(170127);
      return;
    }
    runInMainThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(193241);
        MMKProgressDialogImpl localMMKProgressDialogImpl = MMKProgressDialogImpl.this;
        Context localContext = localContext;
        String str = this.val$text;
        if (!paramBoolean) {}
        for (boolean bool = true;; bool = false)
        {
          MMKProgressDialogImpl.access$202(localMMKProgressDialogImpl, com.tencent.mm.wallet_core.ui.h.b(localContext, str, bool, new DialogInterface.OnCancelListener()
          {
            public void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(193240);
              if (MMKProgressDialogImpl.this.mLoadingImpl != null)
              {
                MMKProgressDialogImpl.this.mLoadingImpl.dismiss();
                MMKProgressDialogImpl.access$202(MMKProgressDialogImpl.this, null);
              }
              AppMethodBeat.o(193240);
            }
          }));
          if ((localContext instanceof MMActivity)) {
            ((MMActivity)localContext).addDialog(MMKProgressDialogImpl.this.mLoadingImpl);
          }
          AppMethodBeat.o(193241);
          return;
        }
      }
    });
    AppMethodBeat.o(170127);
  }
  
  public void showPayProcessImpl(final boolean paramBoolean, final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(19099);
    final Context localContext = KindaContext.get();
    if (localContext == null)
    {
      ae.e("MMKProgressDialogImpl", "MMKProgressDialogImpl showPayProcessImpl() KindaContext.get() return null! case 2");
      AppMethodBeat.o(19099);
      return;
    }
    runInMainThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(193237);
        MMKProgressDialogImpl.access$102(MMKProgressDialogImpl.this, com.tencent.mm.wallet_core.ui.h.a(localContext, paramBoolean, new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(193236);
            MMKProgressDialogImpl.2.this.val$cancel.call();
            MMKProgressDialogImpl.access$102(MMKProgressDialogImpl.this, null);
            AppMethodBeat.o(193236);
          }
        }));
        if ((localContext instanceof MMActivity)) {
          ((MMActivity)localContext).addDialog(MMKProgressDialogImpl.this.mPayProcessImpl);
        }
        AppMethodBeat.o(193237);
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
      ae.e("MMKProgressDialogImpl", "MMKProgressDialogImpl showToast() KindaContext.get() return null! case 3");
      AppMethodBeat.o(19100);
      return;
    }
    com.tencent.mm.ui.base.h.cm(localContext, paramString);
    AppMethodBeat.o(19100);
  }
  
  public void showTopLoading(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(19102);
    paramString = KindaContext.get();
    if (paramString == null)
    {
      ae.e("MMKProgressDialogImpl", "MMKProgressDialogImpl can't startLoading because the context is null!");
      AppMethodBeat.o(19102);
      return;
    }
    runInMainThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(193239);
        MMKProgressDialogImpl localMMKProgressDialogImpl = MMKProgressDialogImpl.this;
        Context localContext = paramString;
        String str = this.val$text;
        if (!paramBoolean) {}
        for (boolean bool = true;; bool = false)
        {
          MMKProgressDialogImpl.access$202(localMMKProgressDialogImpl, com.tencent.mm.wallet_core.ui.h.b(localContext, str, bool, new DialogInterface.OnCancelListener()
          {
            public void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(193238);
              if (MMKProgressDialogImpl.this.mLoadingImpl != null)
              {
                MMKProgressDialogImpl.this.mLoadingImpl.dismiss();
                MMKProgressDialogImpl.access$202(MMKProgressDialogImpl.this, null);
              }
              AppMethodBeat.o(193238);
            }
          }));
          if ((paramString instanceof MMActivity)) {
            ((MMActivity)paramString).addDialog(MMKProgressDialogImpl.this.mLoadingImpl);
          }
          AppMethodBeat.o(193239);
          return;
        }
      }
    });
    AppMethodBeat.o(19102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKProgressDialogImpl
 * JD-Core Version:    0.7.0.1
 */