package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.f.g;
import java.io.PrintWriter;

public abstract class d<E>
  extends b
{
  private final int VM;
  final Activity mActivity;
  final Context mContext;
  final FragmentManagerImpl mFragmentManager = new FragmentManagerImpl();
  final Handler mHandler;
  
  private d(Activity paramActivity, Context paramContext, Handler paramHandler)
  {
    this.mActivity = paramActivity;
    this.mContext = ((Context)g.checkNotNull(paramContext, "context == null"));
    this.mHandler = ((Handler)g.checkNotNull(paramHandler, "handler == null"));
    this.VM = 0;
  }
  
  d(FragmentActivity paramFragmentActivity)
  {
    this(paramFragmentActivity, paramFragmentActivity, paramFragmentActivity.mHandler);
  }
  
  public boolean M(String paramString)
  {
    return false;
  }
  
  public void a(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (paramInt != -1) {
      throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }
    paramFragment = this.mContext;
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramFragment, paramIntent.aFh(), "androidx/fragment/app/FragmentHostCallback", "onStartActivityFromFragment", "(Landroidx/fragment/app/Fragment;Landroid/content/Intent;ILandroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramFragment.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramFragment, "androidx/fragment/app/FragmentHostCallback", "onStartActivityFromFragment", "(Landroidx/fragment/app/Fragment;Landroid/content/Intent;ILandroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
  
  public void a(Fragment paramFragment, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    if (paramInt1 != -1) {
      throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
    }
    androidx.core.app.a.a(this.mActivity, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  public void a(Fragment paramFragment, String[] paramArrayOfString, int paramInt) {}
  
  public void a(String paramString, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public View bZ(int paramInt)
  {
    return null;
  }
  
  public int iA()
  {
    return this.VM;
  }
  
  public abstract E iB();
  
  public boolean it()
  {
    return true;
  }
  
  public boolean iw()
  {
    return true;
  }
  
  public LayoutInflater ix()
  {
    return LayoutInflater.from(this.mContext);
  }
  
  public void iy() {}
  
  public boolean iz()
  {
    return true;
  }
  
  void onAttachFragment(Fragment paramFragment) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.fragment.app.d
 * JD-Core Version:    0.7.0.1
 */