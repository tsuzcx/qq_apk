package androidx.fragment.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DialogFragment
  extends Fragment
  implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener
{
  private static final String SAVED_BACK_STACK_ID = "android:backStackId";
  private static final String SAVED_CANCELABLE = "android:cancelable";
  private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
  private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
  private static final String SAVED_STYLE = "android:style";
  private static final String SAVED_THEME = "android:theme";
  public static final int STYLE_NORMAL = 0;
  public static final int STYLE_NO_FRAME = 2;
  public static final int STYLE_NO_INPUT = 3;
  public static final int STYLE_NO_TITLE = 1;
  int mBackStackId = -1;
  boolean mCancelable = true;
  Dialog mDialog;
  boolean mDismissed;
  boolean mShownByMe;
  boolean mShowsDialog = true;
  int mStyle = 0;
  int mTheme = 0;
  boolean mViewDestroyed;
  
  public void dismiss()
  {
    AppMethodBeat.i(211911);
    dismissInternal(false);
    AppMethodBeat.o(211911);
  }
  
  public void dismissAllowingStateLoss()
  {
    AppMethodBeat.i(211913);
    dismissInternal(true);
    AppMethodBeat.o(211913);
  }
  
  void dismissInternal(boolean paramBoolean)
  {
    AppMethodBeat.i(211915);
    if (this.mDismissed)
    {
      AppMethodBeat.o(211915);
      return;
    }
    this.mDismissed = true;
    this.mShownByMe = false;
    if (this.mDialog != null) {
      this.mDialog.dismiss();
    }
    this.mViewDestroyed = true;
    if (this.mBackStackId >= 0)
    {
      getFragmentManager().popBackStack(this.mBackStackId, 1);
      this.mBackStackId = -1;
      AppMethodBeat.o(211915);
      return;
    }
    i locali = getFragmentManager().beginTransaction();
    locali.a(this);
    if (paramBoolean)
    {
      locali.ip();
      AppMethodBeat.o(211915);
      return;
    }
    locali.in();
    AppMethodBeat.o(211915);
  }
  
  public Dialog getDialog()
  {
    return this.mDialog;
  }
  
  public boolean getShowsDialog()
  {
    return this.mShowsDialog;
  }
  
  public int getTheme()
  {
    return this.mTheme;
  }
  
  public boolean isCancelable()
  {
    return this.mCancelable;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(211932);
    super.onActivityCreated(paramBundle);
    if (!this.mShowsDialog)
    {
      AppMethodBeat.o(211932);
      return;
    }
    Object localObject = getView();
    if (localObject != null)
    {
      if (((View)localObject).getParent() != null)
      {
        paramBundle = new IllegalStateException("DialogFragment can not be attached to a container view");
        AppMethodBeat.o(211932);
        throw paramBundle;
      }
      this.mDialog.setContentView((View)localObject);
    }
    localObject = getActivity();
    if (localObject != null) {
      this.mDialog.setOwnerActivity((Activity)localObject);
    }
    this.mDialog.setCancelable(this.mCancelable);
    this.mDialog.setOnCancelListener(this);
    this.mDialog.setOnDismissListener(this);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getBundle("android:savedDialogState");
      if (paramBundle != null) {
        this.mDialog.onRestoreInstanceState(paramBundle);
      }
    }
    AppMethodBeat.o(211932);
  }
  
  public void onAttach(Context paramContext)
  {
    AppMethodBeat.i(211918);
    super.onAttach(paramContext);
    if (!this.mShownByMe) {
      this.mDismissed = false;
    }
    AppMethodBeat.o(211918);
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(211922);
    super.onCreate(paramBundle);
    if (this.mContainerId == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mShowsDialog = bool;
      if (paramBundle != null)
      {
        this.mStyle = paramBundle.getInt("android:style", 0);
        this.mTheme = paramBundle.getInt("android:theme", 0);
        this.mCancelable = paramBundle.getBoolean("android:cancelable", true);
        this.mShowsDialog = paramBundle.getBoolean("android:showsDialog", this.mShowsDialog);
        this.mBackStackId = paramBundle.getInt("android:backStackId", -1);
      }
      AppMethodBeat.o(211922);
      return;
    }
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    AppMethodBeat.i(211929);
    paramBundle = new Dialog(getActivity(), getTheme());
    AppMethodBeat.o(211929);
    return paramBundle;
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(211939);
    super.onDestroyView();
    if (this.mDialog != null)
    {
      this.mViewDestroyed = true;
      this.mDialog.dismiss();
      this.mDialog = null;
    }
    AppMethodBeat.o(211939);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(211920);
    super.onDetach();
    if ((!this.mShownByMe) && (!this.mDismissed)) {
      this.mDismissed = true;
    }
    AppMethodBeat.o(211920);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(211930);
    if (!this.mViewDestroyed) {
      dismissInternal(true);
    }
    AppMethodBeat.o(211930);
  }
  
  public LayoutInflater onGetLayoutInflater(Bundle paramBundle)
  {
    AppMethodBeat.i(211925);
    if (!this.mShowsDialog)
    {
      paramBundle = super.onGetLayoutInflater(paramBundle);
      AppMethodBeat.o(211925);
      return paramBundle;
    }
    this.mDialog = onCreateDialog(paramBundle);
    if (this.mDialog != null)
    {
      setupDialog(this.mDialog, this.mStyle);
      paramBundle = (LayoutInflater)this.mDialog.getContext().getSystemService("layout_inflater");
      AppMethodBeat.o(211925);
      return paramBundle;
    }
    paramBundle = (LayoutInflater)this.mHost.mContext.getSystemService("layout_inflater");
    AppMethodBeat.o(211925);
    return paramBundle;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(211936);
    super.onSaveInstanceState(paramBundle);
    if (this.mDialog != null)
    {
      Bundle localBundle = this.mDialog.onSaveInstanceState();
      if (localBundle != null) {
        paramBundle.putBundle("android:savedDialogState", localBundle);
      }
    }
    if (this.mStyle != 0) {
      paramBundle.putInt("android:style", this.mStyle);
    }
    if (this.mTheme != 0) {
      paramBundle.putInt("android:theme", this.mTheme);
    }
    if (!this.mCancelable) {
      paramBundle.putBoolean("android:cancelable", this.mCancelable);
    }
    if (!this.mShowsDialog) {
      paramBundle.putBoolean("android:showsDialog", this.mShowsDialog);
    }
    if (this.mBackStackId != -1) {
      paramBundle.putInt("android:backStackId", this.mBackStackId);
    }
    AppMethodBeat.o(211936);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(211934);
    super.onStart();
    if (this.mDialog != null)
    {
      this.mViewDestroyed = false;
      this.mDialog.show();
    }
    AppMethodBeat.o(211934);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(211938);
    super.onStop();
    if (this.mDialog != null) {
      this.mDialog.hide();
    }
    AppMethodBeat.o(211938);
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(211916);
    this.mCancelable = paramBoolean;
    if (this.mDialog != null) {
      this.mDialog.setCancelable(paramBoolean);
    }
    AppMethodBeat.o(211916);
  }
  
  public void setShowsDialog(boolean paramBoolean)
  {
    this.mShowsDialog = paramBoolean;
  }
  
  public void setStyle(int paramInt1, int paramInt2)
  {
    this.mStyle = paramInt1;
    if ((this.mStyle == 2) || (this.mStyle == 3)) {
      this.mTheme = 16973913;
    }
    if (paramInt2 != 0) {
      this.mTheme = paramInt2;
    }
  }
  
  public void setupDialog(Dialog paramDialog, int paramInt)
  {
    AppMethodBeat.i(211927);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(211927);
      return;
      paramDialog.getWindow().addFlags(24);
      paramDialog.requestWindowFeature(1);
    }
  }
  
  public int show(i parami, String paramString)
  {
    AppMethodBeat.i(211908);
    this.mDismissed = false;
    this.mShownByMe = true;
    parami.a(this, paramString);
    this.mViewDestroyed = false;
    this.mBackStackId = parami.in();
    int i = this.mBackStackId;
    AppMethodBeat.o(211908);
    return i;
  }
  
  public void show(e parame, String paramString)
  {
    AppMethodBeat.i(211907);
    this.mDismissed = false;
    this.mShownByMe = true;
    parame = parame.beginTransaction();
    parame.a(this, paramString);
    parame.in();
    AppMethodBeat.o(211907);
  }
  
  public void showNow(e parame, String paramString)
  {
    AppMethodBeat.i(211910);
    this.mDismissed = false;
    this.mShownByMe = true;
    parame = parame.beginTransaction();
    parame.a(this, paramString);
    parame.iq();
    AppMethodBeat.o(211910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.fragment.app.DialogFragment
 * JD-Core Version:    0.7.0.1
 */