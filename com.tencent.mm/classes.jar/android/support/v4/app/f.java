package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.e.l;
import android.view.LayoutInflater;
import android.view.View;
import java.io.PrintWriter;

public abstract class f<E>
  extends d
{
  final Activity mActivity;
  final Context mContext;
  final FragmentManagerImpl mFragmentManager = new FragmentManagerImpl();
  final Handler mHandler;
  private final int wj;
  
  private f(Activity paramActivity, Context paramContext, Handler paramHandler)
  {
    this.mActivity = paramActivity;
    this.mContext = ((Context)l.checkNotNull(paramContext, "context == null"));
    this.mHandler = ((Handler)l.checkNotNull(paramHandler, "handler == null"));
    this.wj = 0;
  }
  
  f(FragmentActivity paramFragmentActivity)
  {
    this(paramFragmentActivity, paramFragmentActivity, paramFragmentActivity.mHandler);
  }
  
  public boolean G(String paramString)
  {
    return false;
  }
  
  public void a(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (paramInt != -1) {
      throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }
    this.mContext.startActivity(paramIntent);
  }
  
  public void a(Fragment paramFragment, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    if (paramInt1 != -1) {
      throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
    }
    a.a(this.mActivity, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  public void a(Fragment paramFragment, String[] paramArrayOfString, int paramInt) {}
  
  public void a(String paramString, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public boolean cB()
  {
    return true;
  }
  
  public void cC() {}
  
  void onAttachFragment(Fragment paramFragment) {}
  
  public View onFindViewById(int paramInt)
  {
    return null;
  }
  
  public abstract E onGetHost();
  
  public LayoutInflater onGetLayoutInflater()
  {
    return LayoutInflater.from(this.mContext);
  }
  
  public int onGetWindowAnimations()
  {
    return this.wj;
  }
  
  public boolean onHasView()
  {
    return true;
  }
  
  public boolean onHasWindowAnimations()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.f
 * JD-Core Version:    0.7.0.1
 */