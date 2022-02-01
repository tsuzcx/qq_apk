package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.content.a;
import androidx.core.f.f;
import java.io.PrintWriter;

public abstract class g<E>
  extends d
{
  private final int bCJ;
  final Activity mActivity;
  final Context mContext;
  final FragmentManager mFragmentManager = new FragmentManagerImpl();
  final Handler mHandler;
  
  private g(Activity paramActivity, Context paramContext, Handler paramHandler)
  {
    this.mActivity = paramActivity;
    this.mContext = ((Context)f.checkNotNull(paramContext, "context == null"));
    this.mHandler = ((Handler)f.checkNotNull(paramHandler, "handler == null"));
    this.bCJ = 0;
  }
  
  g(FragmentActivity paramFragmentActivity)
  {
    this(paramFragmentActivity, paramFragmentActivity, new Handler());
  }
  
  public boolean Gg()
  {
    return true;
  }
  
  public LayoutInflater Gh()
  {
    return LayoutInflater.from(this.mContext);
  }
  
  public void Gi() {}
  
  public abstract E Gj();
  
  public final void a(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (paramInt != -1) {
      throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }
    a.a(this.mContext, paramIntent, paramBundle);
  }
  
  public void a(String paramString, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public boolean aF(String paramString)
  {
    return false;
  }
  
  public View onFindViewById(int paramInt)
  {
    return null;
  }
  
  public boolean onHasView()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.g
 * JD-Core Version:    0.7.0.1
 */