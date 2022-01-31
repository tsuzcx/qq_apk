package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.PrintWriter;

public abstract class i<E>
  extends g
{
  final Activity mActivity;
  final Context mContext;
  final k mFragmentManager = new k();
  final Handler mHandler;
  final int vm;
  
  private i(Activity paramActivity, Context paramContext, Handler paramHandler)
  {
    this.mActivity = paramActivity;
    this.mContext = paramContext;
    this.mHandler = paramHandler;
    this.vm = 0;
  }
  
  i(FragmentActivity paramFragmentActivity)
  {
    this(paramFragmentActivity, paramFragmentActivity, paramFragmentActivity.mHandler);
  }
  
  public boolean F(String paramString)
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
  
  public boolean bN()
  {
    return true;
  }
  
  public void bO() {}
  
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
    return this.vm;
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
 * Qualified Name:     android.support.v4.app.i
 * JD-Core Version:    0.7.0.1
 */