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
  private final Runnable GC = new Runnable()
  {
    public final void run()
    {
      ListFragment.this.GF.focusableViewAvailable(ListFragment.this.GF);
    }
  };
  private final AdapterView.OnItemClickListener GD = new AdapterView.OnItemClickListener()
  {
    public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {}
  };
  ListAdapter GE;
  ListView GF;
  View GG;
  TextView GH;
  View GI;
  View GJ;
  boolean GK;
  CharSequence mEmptyText;
  private final Handler mHandler = new Handler();
  
  private void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    el();
    if (this.GI == null) {
      throw new IllegalStateException("Can't be used with a custom content view");
    }
    if (this.GK == paramBoolean1) {
      return;
    }
    this.GK = paramBoolean1;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        this.GI.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
        this.GJ.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
      }
      for (;;)
      {
        this.GI.setVisibility(8);
        this.GJ.setVisibility(0);
        return;
        this.GI.clearAnimation();
        this.GJ.clearAnimation();
      }
    }
    if (paramBoolean2)
    {
      this.GI.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
      this.GJ.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
    }
    for (;;)
    {
      this.GI.setVisibility(0);
      this.GJ.setVisibility(8);
      return;
      this.GI.clearAnimation();
      this.GJ.clearAnimation();
    }
  }
  
  private void el()
  {
    if (this.GF != null) {
      return;
    }
    Object localObject = getView();
    if (localObject == null) {
      throw new IllegalStateException("Content view not yet created");
    }
    if ((localObject instanceof ListView))
    {
      this.GF = ((ListView)localObject);
      this.GK = true;
      this.GF.setOnItemClickListener(this.GD);
      if (this.GE == null) {
        break label254;
      }
      localObject = this.GE;
      this.GE = null;
      setListAdapter((ListAdapter)localObject);
    }
    for (;;)
    {
      this.mHandler.post(this.GC);
      return;
      this.GH = ((TextView)((View)localObject).findViewById(16711681));
      if (this.GH == null) {
        this.GG = ((View)localObject).findViewById(16908292);
      }
      for (;;)
      {
        this.GI = ((View)localObject).findViewById(16711682);
        this.GJ = ((View)localObject).findViewById(16711683);
        localObject = ((View)localObject).findViewById(16908298);
        if ((localObject instanceof ListView)) {
          break label193;
        }
        if (localObject != null) {
          break;
        }
        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
        this.GH.setVisibility(8);
      }
      throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
      label193:
      this.GF = ((ListView)localObject);
      if (this.GG != null)
      {
        this.GF.setEmptyView(this.GG);
        break;
      }
      if (this.mEmptyText == null) {
        break;
      }
      this.GH.setText(this.mEmptyText);
      this.GF.setEmptyView(this.GH);
      break;
      label254:
      if (this.GI != null) {
        e(false, false);
      }
    }
  }
  
  private void setListAdapter(ListAdapter paramListAdapter)
  {
    boolean bool = false;
    if (this.GE != null) {}
    for (int i = 1;; i = 0)
    {
      this.GE = paramListAdapter;
      if (this.GF != null)
      {
        this.GF.setAdapter(paramListAdapter);
        if ((!this.GK) && (i == 0))
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
    this.mHandler.removeCallbacks(this.GC);
    this.GF = null;
    this.GK = false;
    this.GJ = null;
    this.GI = null;
    this.GG = null;
    this.GH = null;
    super.onDestroyView();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    el();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.app.ListFragment
 * JD-Core Version:    0.7.0.1
 */