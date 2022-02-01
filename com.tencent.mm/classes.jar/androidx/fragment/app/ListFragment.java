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
  View bEA;
  CharSequence bEB;
  boolean bEC;
  private final Runnable bEu;
  private final AdapterView.OnItemClickListener bEv;
  ListView bEw;
  View bEx;
  TextView bEy;
  View bEz;
  ListAdapter fR;
  private final Handler mHandler;
  
  public ListFragment()
  {
    AppMethodBeat.i(193483);
    this.mHandler = new Handler();
    this.bEu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193673);
        ListFragment.this.bEw.focusableViewAvailable(ListFragment.this.bEw);
        AppMethodBeat.o(193673);
      }
    };
    this.bEv = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {}
    };
    AppMethodBeat.o(193483);
  }
  
  private void GE()
  {
    AppMethodBeat.i(193528);
    if (this.bEw != null)
    {
      AppMethodBeat.o(193528);
      return;
    }
    Object localObject = getView();
    if (localObject == null)
    {
      localObject = new IllegalStateException("Content view not yet created");
      AppMethodBeat.o(193528);
      throw ((Throwable)localObject);
    }
    if ((localObject instanceof ListView))
    {
      this.bEw = ((ListView)localObject);
      this.bEC = true;
      this.bEw.setOnItemClickListener(this.bEv);
      if (this.fR == null) {
        break label290;
      }
      localObject = this.fR;
      this.fR = null;
      b((ListAdapter)localObject);
    }
    for (;;)
    {
      this.mHandler.post(this.bEu);
      AppMethodBeat.o(193528);
      return;
      this.bEy = ((TextView)((View)localObject).findViewById(16711681));
      if (this.bEy == null) {
        this.bEx = ((View)localObject).findViewById(16908292);
      }
      for (;;)
      {
        this.bEz = ((View)localObject).findViewById(16711682);
        this.bEA = ((View)localObject).findViewById(16711683);
        localObject = ((View)localObject).findViewById(16908298);
        if ((localObject instanceof ListView)) {
          break label229;
        }
        if (localObject != null) {
          break;
        }
        localObject = new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
        AppMethodBeat.o(193528);
        throw ((Throwable)localObject);
        this.bEy.setVisibility(8);
      }
      localObject = new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
      AppMethodBeat.o(193528);
      throw ((Throwable)localObject);
      label229:
      this.bEw = ((ListView)localObject);
      if (this.bEx != null)
      {
        this.bEw.setEmptyView(this.bEx);
        break;
      }
      if (this.bEB == null) {
        break;
      }
      this.bEy.setText(this.bEB);
      this.bEw.setEmptyView(this.bEy);
      break;
      label290:
      if (this.bEz != null) {
        h(false, false);
      }
    }
  }
  
  private void b(ListAdapter paramListAdapter)
  {
    boolean bool = false;
    AppMethodBeat.i(193494);
    if (this.fR != null) {}
    for (int i = 1;; i = 0)
    {
      this.fR = paramListAdapter;
      if (this.bEw != null)
      {
        this.bEw.setAdapter(paramListAdapter);
        if ((!this.bEC) && (i == 0))
        {
          if (requireView().getWindowToken() != null) {
            bool = true;
          }
          h(true, bool);
        }
      }
      AppMethodBeat.o(193494);
      return;
    }
  }
  
  private void h(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(193512);
    GE();
    if (this.bEz == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Can't be used with a custom content view");
      AppMethodBeat.o(193512);
      throw localIllegalStateException;
    }
    if (this.bEC == paramBoolean1)
    {
      AppMethodBeat.o(193512);
      return;
    }
    this.bEC = paramBoolean1;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        this.bEz.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
        this.bEA.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
      }
      for (;;)
      {
        this.bEz.setVisibility(8);
        this.bEA.setVisibility(0);
        AppMethodBeat.o(193512);
        return;
        this.bEz.clearAnimation();
        this.bEA.clearAnimation();
      }
    }
    if (paramBoolean2)
    {
      this.bEz.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
      this.bEA.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
    }
    for (;;)
    {
      this.bEz.setVisibility(0);
      this.bEA.setVisibility(8);
      AppMethodBeat.o(193512);
      return;
      this.bEz.clearAnimation();
      this.bEA.clearAnimation();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(193538);
    paramViewGroup = requireContext();
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
    AppMethodBeat.o(193538);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(193570);
    this.mHandler.removeCallbacks(this.bEu);
    this.bEw = null;
    this.bEC = false;
    this.bEA = null;
    this.bEz = null;
    this.bEx = null;
    this.bEy = null;
    super.onDestroyView();
    AppMethodBeat.o(193570);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(193551);
    super.onViewCreated(paramView, paramBundle);
    GE();
    AppMethodBeat.o(193551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.fragment.app.ListFragment
 * JD-Core Version:    0.7.0.1
 */