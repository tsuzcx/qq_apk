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
  private final Runnable GM = new Runnable()
  {
    public final void run()
    {
      ListFragment.this.GP.focusableViewAvailable(ListFragment.this.GP);
    }
  };
  private final AdapterView.OnItemClickListener GN = new AdapterView.OnItemClickListener()
  {
    public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {}
  };
  ListAdapter GO;
  ListView GP;
  View GQ;
  TextView GR;
  View GS;
  View GT;
  boolean GU;
  CharSequence mEmptyText;
  private final Handler mHandler = new Handler();
  
  private void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    ep();
    if (this.GS == null) {
      throw new IllegalStateException("Can't be used with a custom content view");
    }
    if (this.GU == paramBoolean1) {
      return;
    }
    this.GU = paramBoolean1;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        this.GS.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
        this.GT.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
      }
      for (;;)
      {
        this.GS.setVisibility(8);
        this.GT.setVisibility(0);
        return;
        this.GS.clearAnimation();
        this.GT.clearAnimation();
      }
    }
    if (paramBoolean2)
    {
      this.GS.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
      this.GT.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
    }
    for (;;)
    {
      this.GS.setVisibility(0);
      this.GT.setVisibility(8);
      return;
      this.GS.clearAnimation();
      this.GT.clearAnimation();
    }
  }
  
  private void ep()
  {
    if (this.GP != null) {
      return;
    }
    Object localObject = getView();
    if (localObject == null) {
      throw new IllegalStateException("Content view not yet created");
    }
    if ((localObject instanceof ListView))
    {
      this.GP = ((ListView)localObject);
      this.GU = true;
      this.GP.setOnItemClickListener(this.GN);
      if (this.GO == null) {
        break label254;
      }
      localObject = this.GO;
      this.GO = null;
      setListAdapter((ListAdapter)localObject);
    }
    for (;;)
    {
      this.mHandler.post(this.GM);
      return;
      this.GR = ((TextView)((View)localObject).findViewById(16711681));
      if (this.GR == null) {
        this.GQ = ((View)localObject).findViewById(16908292);
      }
      for (;;)
      {
        this.GS = ((View)localObject).findViewById(16711682);
        this.GT = ((View)localObject).findViewById(16711683);
        localObject = ((View)localObject).findViewById(16908298);
        if ((localObject instanceof ListView)) {
          break label193;
        }
        if (localObject != null) {
          break;
        }
        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
        this.GR.setVisibility(8);
      }
      throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
      label193:
      this.GP = ((ListView)localObject);
      if (this.GQ != null)
      {
        this.GP.setEmptyView(this.GQ);
        break;
      }
      if (this.mEmptyText == null) {
        break;
      }
      this.GR.setText(this.mEmptyText);
      this.GP.setEmptyView(this.GR);
      break;
      label254:
      if (this.GS != null) {
        e(false, false);
      }
    }
  }
  
  private void setListAdapter(ListAdapter paramListAdapter)
  {
    boolean bool = false;
    if (this.GO != null) {}
    for (int i = 1;; i = 0)
    {
      this.GO = paramListAdapter;
      if (this.GP != null)
      {
        this.GP.setAdapter(paramListAdapter);
        if ((!this.GU) && (i == 0))
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
    this.mHandler.removeCallbacks(this.GM);
    this.GP = null;
    this.GU = false;
    this.GT = null;
    this.GS = null;
    this.GQ = null;
    this.GR = null;
    super.onDestroyView();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.app.ListFragment
 * JD-Core Version:    0.7.0.1
 */