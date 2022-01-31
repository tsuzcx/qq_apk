package android.support.v4.app;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
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
  CharSequence mEmptyText;
  private final Handler mHandler = new Handler();
  View xA;
  View xB;
  boolean xC;
  private final Runnable xu = new ListFragment.1(this);
  private final AdapterView.OnItemClickListener xv = new ListFragment.2(this);
  ListAdapter xw;
  ListView xx;
  View xy;
  TextView xz;
  
  private void cG()
  {
    if (this.xx != null) {
      return;
    }
    Object localObject = getView();
    if (localObject == null) {
      throw new IllegalStateException("Content view not yet created");
    }
    if ((localObject instanceof ListView))
    {
      this.xx = ((ListView)localObject);
      this.xC = true;
      this.xx.setOnItemClickListener(this.xv);
      if (this.xw == null) {
        break label254;
      }
      localObject = this.xw;
      this.xw = null;
      setListAdapter((ListAdapter)localObject);
    }
    for (;;)
    {
      this.mHandler.post(this.xu);
      return;
      this.xz = ((TextView)((View)localObject).findViewById(16711681));
      if (this.xz == null) {
        this.xy = ((View)localObject).findViewById(16908292);
      }
      for (;;)
      {
        this.xA = ((View)localObject).findViewById(16711682);
        this.xB = ((View)localObject).findViewById(16711683);
        localObject = ((View)localObject).findViewById(16908298);
        if ((localObject instanceof ListView)) {
          break label193;
        }
        if (localObject != null) {
          break;
        }
        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
        this.xz.setVisibility(8);
      }
      throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
      label193:
      this.xx = ((ListView)localObject);
      if (this.xy != null)
      {
        this.xx.setEmptyView(this.xy);
        break;
      }
      if (this.mEmptyText == null) {
        break;
      }
      this.xz.setText(this.mEmptyText);
      this.xx.setEmptyView(this.xz);
      break;
      label254:
      if (this.xA != null) {
        e(false, false);
      }
    }
  }
  
  private void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    cG();
    if (this.xA == null) {
      throw new IllegalStateException("Can't be used with a custom content view");
    }
    if (this.xC == paramBoolean1) {
      return;
    }
    this.xC = paramBoolean1;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        this.xA.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
        this.xB.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
      }
      for (;;)
      {
        this.xA.setVisibility(8);
        this.xB.setVisibility(0);
        return;
        this.xA.clearAnimation();
        this.xB.clearAnimation();
      }
    }
    if (paramBoolean2)
    {
      this.xA.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
      this.xB.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
    }
    for (;;)
    {
      this.xA.setVisibility(0);
      this.xB.setVisibility(8);
      return;
      this.xA.clearAnimation();
      this.xB.clearAnimation();
    }
  }
  
  private void setListAdapter(ListAdapter paramListAdapter)
  {
    boolean bool = false;
    if (this.xw != null) {}
    for (int i = 1;; i = 0)
    {
      this.xw = paramListAdapter;
      if (this.xx != null)
      {
        this.xx.setAdapter(paramListAdapter);
        if ((!this.xC) && (i == 0))
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
    this.mHandler.removeCallbacks(this.xu);
    this.xx = null;
    this.xC = false;
    this.xB = null;
    this.xA = null;
    this.xy = null;
    this.xz = null;
    super.onDestroyView();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    cG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.app.ListFragment
 * JD-Core Version:    0.7.0.1
 */