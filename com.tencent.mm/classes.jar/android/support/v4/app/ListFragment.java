package android.support.v4.app;

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

public class ListFragment
  extends Fragment
{
  private final Runnable DN = new Runnable()
  {
    public final void run()
    {
      ListFragment.this.DQ.focusableViewAvailable(ListFragment.this.DQ);
    }
  };
  private final AdapterView.OnItemClickListener DO = new AdapterView.OnItemClickListener()
  {
    public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {}
  };
  ListAdapter DP;
  ListView DQ;
  View DR;
  TextView DS;
  View DT;
  View DU;
  boolean DV;
  CharSequence mEmptyText;
  private final Handler mHandler = new Handler();
  
  private void dJ()
  {
    if (this.DQ != null) {
      return;
    }
    Object localObject = getView();
    if (localObject == null) {
      throw new IllegalStateException("Content view not yet created");
    }
    if ((localObject instanceof ListView))
    {
      this.DQ = ((ListView)localObject);
      this.DV = true;
      this.DQ.setOnItemClickListener(this.DO);
      if (this.DP == null) {
        break label254;
      }
      localObject = this.DP;
      this.DP = null;
      setListAdapter((ListAdapter)localObject);
    }
    for (;;)
    {
      this.mHandler.post(this.DN);
      return;
      this.DS = ((TextView)((View)localObject).findViewById(16711681));
      if (this.DS == null) {
        this.DR = ((View)localObject).findViewById(16908292);
      }
      for (;;)
      {
        this.DT = ((View)localObject).findViewById(16711682);
        this.DU = ((View)localObject).findViewById(16711683);
        localObject = ((View)localObject).findViewById(16908298);
        if ((localObject instanceof ListView)) {
          break label193;
        }
        if (localObject != null) {
          break;
        }
        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
        this.DS.setVisibility(8);
      }
      throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
      label193:
      this.DQ = ((ListView)localObject);
      if (this.DR != null)
      {
        this.DQ.setEmptyView(this.DR);
        break;
      }
      if (this.mEmptyText == null) {
        break;
      }
      this.DS.setText(this.mEmptyText);
      this.DQ.setEmptyView(this.DS);
      break;
      label254:
      if (this.DT != null) {
        e(false, false);
      }
    }
  }
  
  private void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    dJ();
    if (this.DT == null) {
      throw new IllegalStateException("Can't be used with a custom content view");
    }
    if (this.DV == paramBoolean1) {
      return;
    }
    this.DV = paramBoolean1;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        this.DT.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
        this.DU.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
      }
      for (;;)
      {
        this.DT.setVisibility(8);
        this.DU.setVisibility(0);
        return;
        this.DT.clearAnimation();
        this.DU.clearAnimation();
      }
    }
    if (paramBoolean2)
    {
      this.DT.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
      this.DU.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
    }
    for (;;)
    {
      this.DT.setVisibility(0);
      this.DU.setVisibility(8);
      return;
      this.DT.clearAnimation();
      this.DU.clearAnimation();
    }
  }
  
  private void setListAdapter(ListAdapter paramListAdapter)
  {
    boolean bool = false;
    if (this.DP != null) {}
    for (int i = 1;; i = 0)
    {
      this.DP = paramListAdapter;
      if (this.DQ != null)
      {
        this.DQ.setAdapter(paramListAdapter);
        if ((!this.DV) && (i == 0))
        {
          if (getView().getWindowToken() != null) {
            bool = true;
          }
          e(true, bool);
        }
      }
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
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
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    this.mHandler.removeCallbacks(this.DN);
    this.DQ = null;
    this.DV = false;
    this.DU = null;
    this.DT = null;
    this.DR = null;
    this.DS = null;
    super.onDestroyView();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    dJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.app.ListFragment
 * JD-Core Version:    0.7.0.1
 */