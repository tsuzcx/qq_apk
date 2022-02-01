package androidx.fragment.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import androidx.savedstate.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DialogFragment
  extends Fragment
  implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener
{
  private static final String SAVED_BACK_STACK_ID = "android:backStackId";
  private static final String SAVED_CANCELABLE = "android:cancelable";
  private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
  private static final String SAVED_INTERNAL_DIALOG_SHOWING = "android:dialogShowing";
  private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
  private static final String SAVED_STYLE = "android:style";
  private static final String SAVED_THEME = "android:theme";
  public static final int STYLE_NORMAL = 0;
  public static final int STYLE_NO_FRAME = 2;
  public static final int STYLE_NO_INPUT = 3;
  public static final int STYLE_NO_TITLE = 1;
  private int mBackStackId;
  private boolean mCancelable;
  private boolean mCreatingDialog;
  private Dialog mDialog;
  private boolean mDialogCreated;
  private Runnable mDismissRunnable;
  private boolean mDismissed;
  private Handler mHandler;
  private y<q> mObserver;
  private DialogInterface.OnCancelListener mOnCancelListener;
  private DialogInterface.OnDismissListener mOnDismissListener;
  private boolean mShownByMe;
  private boolean mShowsDialog;
  private int mStyle;
  private int mTheme;
  private boolean mViewDestroyed;
  
  public DialogFragment()
  {
    AppMethodBeat.i(193907);
    this.mDismissRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193430);
        DialogFragment.this.mOnDismissListener.onDismiss(DialogFragment.this.mDialog);
        AppMethodBeat.o(193430);
      }
    };
    this.mOnCancelListener = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(193428);
        if (DialogFragment.this.mDialog != null) {
          DialogFragment.this.onCancel(DialogFragment.this.mDialog);
        }
        AppMethodBeat.o(193428);
      }
    };
    this.mOnDismissListener = new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(193429);
        if (DialogFragment.this.mDialog != null) {
          DialogFragment.this.onDismiss(DialogFragment.this.mDialog);
        }
        AppMethodBeat.o(193429);
      }
    };
    this.mStyle = 0;
    this.mTheme = 0;
    this.mCancelable = true;
    this.mShowsDialog = true;
    this.mBackStackId = -1;
    this.mObserver = new y() {};
    this.mDialogCreated = false;
    AppMethodBeat.o(193907);
  }
  
  public DialogFragment(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(193913);
    this.mDismissRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193430);
        DialogFragment.this.mOnDismissListener.onDismiss(DialogFragment.this.mDialog);
        AppMethodBeat.o(193430);
      }
    };
    this.mOnCancelListener = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(193428);
        if (DialogFragment.this.mDialog != null) {
          DialogFragment.this.onCancel(DialogFragment.this.mDialog);
        }
        AppMethodBeat.o(193428);
      }
    };
    this.mOnDismissListener = new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(193429);
        if (DialogFragment.this.mDialog != null) {
          DialogFragment.this.onDismiss(DialogFragment.this.mDialog);
        }
        AppMethodBeat.o(193429);
      }
    };
    this.mStyle = 0;
    this.mTheme = 0;
    this.mCancelable = true;
    this.mShowsDialog = true;
    this.mBackStackId = -1;
    this.mObserver = new y() {};
    this.mDialogCreated = false;
    AppMethodBeat.o(193913);
  }
  
  private void dismissInternal(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(193926);
    if (this.mDismissed)
    {
      AppMethodBeat.o(193926);
      return;
    }
    this.mDismissed = true;
    this.mShownByMe = false;
    if (this.mDialog != null)
    {
      this.mDialog.setOnDismissListener(null);
      this.mDialog.dismiss();
      if (!paramBoolean2)
      {
        if (Looper.myLooper() != this.mHandler.getLooper()) {
          break label110;
        }
        onDismiss(this.mDialog);
      }
    }
    for (;;)
    {
      this.mViewDestroyed = true;
      if (this.mBackStackId < 0) {
        break;
      }
      getParentFragmentManager().popBackStack(this.mBackStackId, 1);
      this.mBackStackId = -1;
      AppMethodBeat.o(193926);
      return;
      label110:
      this.mHandler.post(this.mDismissRunnable);
    }
    r localr = getParentFragmentManager().beginTransaction();
    localr.a(this);
    if (paramBoolean1)
    {
      localr.FX();
      AppMethodBeat.o(193926);
      return;
    }
    localr.FW();
    AppMethodBeat.o(193926);
  }
  
  private void prepareDialog(Bundle paramBundle)
  {
    AppMethodBeat.i(193934);
    if (!this.mShowsDialog)
    {
      AppMethodBeat.o(193934);
      return;
    }
    if (!this.mDialogCreated) {
      try
      {
        this.mCreatingDialog = true;
        this.mDialog = onCreateDialog(paramBundle);
        if (this.mShowsDialog)
        {
          setupDialog(this.mDialog, this.mStyle);
          paramBundle = getContext();
          if ((paramBundle instanceof Activity)) {
            this.mDialog.setOwnerActivity((Activity)paramBundle);
          }
          this.mDialog.setCancelable(this.mCancelable);
          this.mDialog.setOnCancelListener(this.mOnCancelListener);
          this.mDialog.setOnDismissListener(this.mOnDismissListener);
          this.mDialogCreated = true;
        }
        for (;;)
        {
          return;
          this.mDialog = null;
        }
        AppMethodBeat.o(193934);
      }
      finally
      {
        this.mCreatingDialog = false;
        AppMethodBeat.o(193934);
      }
    }
  }
  
  d createFragmentContainer()
  {
    AppMethodBeat.i(194086);
    d local5 = new d()
    {
      public final View onFindViewById(int paramAnonymousInt)
      {
        AppMethodBeat.i(193445);
        View localView = DialogFragment.this.onFindViewById(paramAnonymousInt);
        if (localView != null)
        {
          AppMethodBeat.o(193445);
          return localView;
        }
        if (this.bBS.onHasView())
        {
          localView = this.bBS.onFindViewById(paramAnonymousInt);
          AppMethodBeat.o(193445);
          return localView;
        }
        AppMethodBeat.o(193445);
        return null;
      }
      
      public final boolean onHasView()
      {
        AppMethodBeat.i(193456);
        if ((DialogFragment.this.onHasView()) || (this.bBS.onHasView()))
        {
          AppMethodBeat.o(193456);
          return true;
        }
        AppMethodBeat.o(193456);
        return false;
      }
    };
    AppMethodBeat.o(194086);
    return local5;
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(193997);
    dismissInternal(false, false);
    AppMethodBeat.o(193997);
  }
  
  public void dismissAllowingStateLoss()
  {
    AppMethodBeat.i(194005);
    dismissInternal(true, false);
    AppMethodBeat.o(194005);
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
  
  public void onAttach(Context paramContext)
  {
    AppMethodBeat.i(194060);
    super.onAttach(paramContext);
    getViewLifecycleOwnerLiveData().a(this.mObserver);
    if (!this.mShownByMe) {
      this.mDismissed = false;
    }
    AppMethodBeat.o(194060);
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(194072);
    super.onCreate(paramBundle);
    this.mHandler = new Handler();
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
      AppMethodBeat.o(194072);
      return;
    }
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    AppMethodBeat.i(194128);
    if (FragmentManager.isLoggingEnabled(3)) {
      new StringBuilder("onCreateDialog called for DialogFragment ").append(this);
    }
    paramBundle = new Dialog(requireContext(), getTheme());
    AppMethodBeat.o(194128);
    return paramBundle;
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(194171);
    super.onDestroyView();
    if (this.mDialog != null)
    {
      this.mViewDestroyed = true;
      this.mDialog.setOnDismissListener(null);
      this.mDialog.dismiss();
      if (!this.mDismissed) {
        onDismiss(this.mDialog);
      }
      this.mDialog = null;
      this.mDialogCreated = false;
    }
    AppMethodBeat.o(194171);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(194066);
    super.onDetach();
    if ((!this.mShownByMe) && (!this.mDismissed)) {
      this.mDismissed = true;
    }
    getViewLifecycleOwnerLiveData().b(this.mObserver);
    AppMethodBeat.o(194066);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(194137);
    if (!this.mViewDestroyed)
    {
      if (FragmentManager.isLoggingEnabled(3)) {
        new StringBuilder("onDismiss called for DialogFragment ").append(this);
      }
      dismissInternal(true, true);
    }
    AppMethodBeat.o(194137);
  }
  
  View onFindViewById(int paramInt)
  {
    AppMethodBeat.i(194094);
    if (this.mDialog != null)
    {
      View localView = this.mDialog.findViewById(paramInt);
      AppMethodBeat.o(194094);
      return localView;
    }
    AppMethodBeat.o(194094);
    return null;
  }
  
  public LayoutInflater onGetLayoutInflater(Bundle paramBundle)
  {
    AppMethodBeat.i(194111);
    LayoutInflater localLayoutInflater = super.onGetLayoutInflater(paramBundle);
    if ((!this.mShowsDialog) || (this.mCreatingDialog))
    {
      if (FragmentManager.isLoggingEnabled(2)) {
        "getting layout inflater for DialogFragment ".concat(String.valueOf(this));
      }
      AppMethodBeat.o(194111);
      return localLayoutInflater;
    }
    prepareDialog(paramBundle);
    if (FragmentManager.isLoggingEnabled(2)) {
      new StringBuilder("get layout inflater for DialogFragment ").append(this).append(" from dialog context");
    }
    paramBundle = localLayoutInflater;
    if (this.mDialog != null) {
      paramBundle = localLayoutInflater.cloneInContext(this.mDialog.getContext());
    }
    AppMethodBeat.o(194111);
    return paramBundle;
  }
  
  boolean onHasView()
  {
    return this.mDialogCreated;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(194158);
    super.onSaveInstanceState(paramBundle);
    if (this.mDialog != null)
    {
      Bundle localBundle = this.mDialog.onSaveInstanceState();
      localBundle.putBoolean("android:dialogShowing", false);
      paramBundle.putBundle("android:savedDialogState", localBundle);
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
    AppMethodBeat.o(194158);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(194151);
    super.onStart();
    if (this.mDialog != null)
    {
      this.mViewDestroyed = false;
      this.mDialog.show();
      View localView = this.mDialog.getWindow().getDecorView();
      al.a(localView, this);
      am.a(localView, this);
      e.b(localView, this);
    }
    AppMethodBeat.o(194151);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(194164);
    super.onStop();
    if (this.mDialog != null) {
      this.mDialog.hide();
    }
    AppMethodBeat.o(194164);
  }
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    AppMethodBeat.i(194144);
    super.onViewStateRestored(paramBundle);
    if ((this.mDialog != null) && (paramBundle != null))
    {
      paramBundle = paramBundle.getBundle("android:savedDialogState");
      if (paramBundle != null) {
        this.mDialog.onRestoreInstanceState(paramBundle);
      }
    }
    AppMethodBeat.o(194144);
  }
  
  void performCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(194080);
    super.performCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((this.mView == null) && (this.mDialog != null) && (paramBundle != null))
    {
      paramLayoutInflater = paramBundle.getBundle("android:savedDialogState");
      if (paramLayoutInflater != null) {
        this.mDialog.onRestoreInstanceState(paramLayoutInflater);
      }
    }
    AppMethodBeat.o(194080);
  }
  
  public final Dialog requireDialog()
  {
    AppMethodBeat.i(194017);
    Object localObject = getDialog();
    if (localObject == null)
    {
      localObject = new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
      AppMethodBeat.o(194017);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(194017);
    return localObject;
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(194032);
    this.mCancelable = paramBoolean;
    if (this.mDialog != null) {
      this.mDialog.setCancelable(paramBoolean);
    }
    AppMethodBeat.o(194032);
  }
  
  public void setShowsDialog(boolean paramBoolean)
  {
    this.mShowsDialog = paramBoolean;
  }
  
  public void setStyle(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193964);
    if (FragmentManager.isLoggingEnabled(2)) {
      new StringBuilder("Setting style and theme for DialogFragment ").append(this).append(" to ").append(paramInt1).append(", ").append(paramInt2);
    }
    this.mStyle = paramInt1;
    if ((this.mStyle == 2) || (this.mStyle == 3)) {
      this.mTheme = 16973913;
    }
    if (paramInt2 != 0) {
      this.mTheme = paramInt2;
    }
    AppMethodBeat.o(193964);
  }
  
  public void setupDialog(Dialog paramDialog, int paramInt)
  {
    AppMethodBeat.i(194122);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(194122);
      return;
      Window localWindow = paramDialog.getWindow();
      if (localWindow != null) {
        localWindow.addFlags(24);
      }
      paramDialog.requestWindowFeature(1);
    }
  }
  
  public int show(r paramr, String paramString)
  {
    AppMethodBeat.i(193980);
    this.mDismissed = false;
    this.mShownByMe = true;
    paramr.a(this, paramString);
    this.mViewDestroyed = false;
    this.mBackStackId = paramr.FW();
    int i = this.mBackStackId;
    AppMethodBeat.o(193980);
    return i;
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString)
  {
    AppMethodBeat.i(193972);
    this.mDismissed = false;
    this.mShownByMe = true;
    paramFragmentManager = paramFragmentManager.beginTransaction();
    paramFragmentManager.a(this, paramString);
    paramFragmentManager.FW();
    AppMethodBeat.o(193972);
  }
  
  public void showNow(FragmentManager paramFragmentManager, String paramString)
  {
    AppMethodBeat.i(193989);
    this.mDismissed = false;
    this.mShownByMe = true;
    paramFragmentManager = paramFragmentManager.beginTransaction();
    paramFragmentManager.a(this, paramString);
    paramFragmentManager.FY();
    AppMethodBeat.o(193989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.DialogFragment
 * JD-Core Version:    0.7.0.1
 */