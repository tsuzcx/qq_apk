package com.tencent.kinda.framework.widget.base;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KProgressDialog;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.g;

public class MMKProgressDialogImpl
  implements KProgressDialog
{
  private static final String TAG = "MMKProgressDialogImpl";
  private Dialog mDialogImpl;
  private Dialog mLoadingImpl;
  private Dialog mPayProcessImpl;
  
  public void dismiss()
  {
    AppMethodBeat.i(19101);
    if (this.mDialogImpl != null) {
      this.mDialogImpl.dismiss();
    }
    if (this.mPayProcessImpl != null) {
      this.mPayProcessImpl.dismiss();
    }
    if (this.mLoadingImpl != null) {
      this.mLoadingImpl.dismiss();
    }
    AppMethodBeat.o(19101);
  }
  
  public void showImpl(String paramString, boolean paramBoolean, final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(19098);
    paramString = KindaContext.get();
    if (paramString == null)
    {
      ad.e("MMKProgressDialogImpl", "MMKProgressDialogImpl showImpl() KindaContext.get() return null! case 1");
      AppMethodBeat.o(19098);
      return;
    }
    this.mDialogImpl = g.a(paramString, paramBoolean, new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(19095);
        paramVoidCallback.call();
        MMKProgressDialogImpl.access$002(MMKProgressDialogImpl.this, null);
        AppMethodBeat.o(19095);
      }
    });
    AppMethodBeat.o(19098);
  }
  
  public void showNormalLoading(boolean paramBoolean)
  {
    AppMethodBeat.i(170127);
    Context localContext = KindaContext.get();
    if (localContext == null)
    {
      ad.e("MMKProgressDialogImpl", "MMKProgressDialogImpl showImpl() KindaContext.get() return null! case 1");
      AppMethodBeat.o(170127);
      return;
    }
    String str = localContext.getString(2131765694);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.mLoadingImpl = g.b(localContext, str, paramBoolean, new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(170126);
          if (MMKProgressDialogImpl.this.mLoadingImpl != null)
          {
            MMKProgressDialogImpl.this.mLoadingImpl.dismiss();
            MMKProgressDialogImpl.access$202(MMKProgressDialogImpl.this, null);
          }
          AppMethodBeat.o(170126);
        }
      });
      AppMethodBeat.o(170127);
      return;
    }
  }
  
  public void showPayProcessImpl(boolean paramBoolean, final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(19099);
    Context localContext = KindaContext.get();
    if (localContext == null)
    {
      ad.e("MMKProgressDialogImpl", "MMKProgressDialogImpl showPayProcessImpl() KindaContext.get() return null! case 2");
      AppMethodBeat.o(19099);
      return;
    }
    this.mPayProcessImpl = g.a(localContext, paramBoolean, new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(19096);
        paramVoidCallback.call();
        MMKProgressDialogImpl.access$102(MMKProgressDialogImpl.this, null);
        AppMethodBeat.o(19096);
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
      ad.e("MMKProgressDialogImpl", "MMKProgressDialogImpl showToast() KindaContext.get() return null! case 3");
      AppMethodBeat.o(19100);
      return;
    }
    h.cf(localContext, paramString);
    AppMethodBeat.o(19100);
  }
  
  public void showTopLoading(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(19102);
    paramString = KindaContext.get();
    if (paramString == null)
    {
      ad.e("MMKProgressDialogImpl", "MMKProgressDialogImpl can't startLoading because the context is null!");
      AppMethodBeat.o(19102);
      return;
    }
    String str = paramString.getString(2131765693);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.mLoadingImpl = g.b(paramString, str, paramBoolean, new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(19097);
          if (MMKProgressDialogImpl.this.mLoadingImpl != null)
          {
            MMKProgressDialogImpl.this.mLoadingImpl.dismiss();
            MMKProgressDialogImpl.access$202(MMKProgressDialogImpl.this, null);
          }
          AppMethodBeat.o(19097);
        }
      });
      AppMethodBeat.o(19102);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKProgressDialogImpl
 * JD-Core Version:    0.7.0.1
 */