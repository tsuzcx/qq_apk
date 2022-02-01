package androidx.fragment.app;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ListFragment
  extends Fragment
{
  private final Runnable Xa;
  private final AdapterView.OnItemClickListener Xb;
  ListView Xc;
  View Xd;
  TextView Xe;
  View Xf;
  View Xg;
  boolean Xh;
  ListAdapter eP;
  CharSequence mEmptyText;
  private final Handler mHandler;
  
  public ListFragment()
  {
    AppMethodBeat.i(213109);
    this.mHandler = new Handler();
    this.Xa = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213099);
        ListFragment.this.Xc.focusableViewAvailable(ListFragment.this.Xc);
        AppMethodBeat.o(213099);
      }
    };
    this.Xb = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {}
    };
    AppMethodBeat.o(213109);
  }
  
  private void b(ListAdapter paramListAdapter)
  {
    boolean bool = false;
    AppMethodBeat.i(213119);
    if (this.eP != null) {}
    for (int i = 1;; i = 0)
    {
      this.eP = paramListAdapter;
      if (this.Xc != null)
      {
        this.Xc.setAdapter(paramListAdapter);
        if ((!this.Xh) && (i == 0))
        {
          if (getView().getWindowToken() != null) {
            bool = true;
          }
          e(true, bool);
        }
      }
      AppMethodBeat.o(213119);
      return;
    }
  }
  
  private void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(213123);
    iG();
    if (this.Xf == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Can't be used with a custom content view");
      AppMethodBeat.o(213123);
      throw localIllegalStateException;
    }
    if (this.Xh == paramBoolean1)
    {
      AppMethodBeat.o(213123);
      return;
    }
    this.Xh = paramBoolean1;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        this.Xf.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
        this.Xg.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
      }
      for (;;)
      {
        this.Xf.setVisibility(8);
        this.Xg.setVisibility(0);
        AppMethodBeat.o(213123);
        return;
        this.Xf.clearAnimation();
        this.Xg.clearAnimation();
      }
    }
    if (paramBoolean2)
    {
      this.Xf.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
      this.Xg.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
    }
    for (;;)
    {
      this.Xf.setVisibility(0);
      this.Xg.setVisibility(8);
      AppMethodBeat.o(213123);
      return;
      this.Xf.clearAnimation();
      this.Xg.clearAnimation();
    }
  }
  
  private void iG()
  {
    AppMethodBeat.i(213125);
    if (this.Xc != null)
    {
      AppMethodBeat.o(213125);
      return;
    }
    Object localObject = getView();
    if (localObject == null)
    {
      localObject = new IllegalStateException("Content view not yet created");
      AppMethodBeat.o(213125);
      throw ((Throwable)localObject);
    }
    if ((localObject instanceof ListView))
    {
      this.Xc = ((ListView)localObject);
      this.Xh = true;
      this.Xc.setOnItemClickListener(this.Xb);
      if (this.eP == null) {
        break label290;
      }
      localObject = this.eP;
      this.eP = null;
      b((ListAdapter)localObject);
    }
    for (;;)
    {
      this.mHandler.post(this.Xa);
      AppMethodBeat.o(213125);
      return;
      this.Xe = ((TextView)((View)localObject).findViewById(16711681));
      if (this.Xe == null) {
        this.Xd = ((View)localObject).findViewById(16908292);
      }
      for (;;)
      {
        this.Xf = ((View)localObject).findViewById(16711682);
        this.Xg = ((View)localObject).findViewById(16711683);
        localObject = ((View)localObject).findViewById(16908298);
        if ((localObject instanceof ListView)) {
          break label229;
        }
        if (localObject != null) {
          break;
        }
        localObject = new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
        AppMethodBeat.o(213125);
        throw ((Throwable)localObject);
        this.Xe.setVisibility(8);
      }
      localObject = new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
      AppMethodBeat.o(213125);
      throw ((Throwable)localObject);
      label229:
      this.Xc = ((ListView)localObject);
      if (this.Xd != null)
      {
        this.Xc.setEmptyView(this.Xd);
        break;
      }
      if (this.mEmptyText == null) {
        break;
      }
      this.Xe.setText(this.mEmptyText);
      this.Xc.setEmptyView(this.Xe);
      break;
      label290:
      if (this.Xf != null) {
        e(false, false);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(213113);
    paramViewGroup = getContext();
    paramLayoutInflater = new FrameLayout(paramViewGroup);
    paramBundle = new LinearLayout(paramViewGroup);
    paramBundle.setId(16711682);
    paramBundle.setOrientation(1);
    paramBundle.setVisibility(8);
    paramBundle.setGravity(17);
    paramBundle.addView(new ProgressBar(paramViewGroup, null, 16842874), new FrameLayout.LayoutParams(-2, -2));
    paramLayoutInflater.addView(paramBundle, new FrameLayout.LayoutParams(-1, -1));
    paramBundle = new FrameLayout(paramViewGroup);
    paramBundle.setId(16711683);
    TextView localTextView = new TextView(paramViewGroup);
    localTextView.setId(16711681);
    localTextView.setGravity(17);
    paramBundle.addView(localTextView, new FrameLayout.LayoutParams(-1, -1));
    paramViewGroup = new ListView(paramViewGroup);
    paramViewGroup.setId(16908298);
    paramViewGroup.setDrawSelectorOnTop(false);
    paramBundle.addView(paramViewGroup, new FrameLayout.LayoutParams(-1, -1));
    paramLayoutInflater.addView(paramBundle, new FrameLayout.LayoutParams(-1, -1));
    paramLayoutInflater.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(213113);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(213117);
    this.mHandler.removeCallbacks(this.Xa);
    this.Xc = null;
    this.Xh = false;
    this.Xg = null;
    this.Xf = null;
    this.Xd = null;
    this.Xe = null;
    super.onDestroyView();
    AppMethodBeat.o(213117);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(213115);
    super.onViewCreated(paramView, paramBundle);
    iG();
    AppMethodBeat.o(213115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.fragment.app.ListFragment
 * JD-Core Version:    0.7.0.1
 */