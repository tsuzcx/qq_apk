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
  private final Runnable EL = new Runnable()
  {
    public final void run()
    {
      ListFragment.this.EO.focusableViewAvailable(ListFragment.this.EO);
    }
  };
  private final AdapterView.OnItemClickListener EM = new AdapterView.OnItemClickListener()
  {
    public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {}
  };
  ListAdapter EN;
  ListView EO;
  View EP;
  TextView EQ;
  View ER;
  View ES;
  boolean ET;
  CharSequence mEmptyText;
  private final Handler mHandler = new Handler();
  
  private void dQ()
  {
    if (this.EO != null) {
      return;
    }
    Object localObject = getView();
    if (localObject == null) {
      throw new IllegalStateException("Content view not yet created");
    }
    if ((localObject instanceof ListView))
    {
      this.EO = ((ListView)localObject);
      this.ET = true;
      this.EO.setOnItemClickListener(this.EM);
      if (this.EN == null) {
        break label254;
      }
      localObject = this.EN;
      this.EN = null;
      setListAdapter((ListAdapter)localObject);
    }
    for (;;)
    {
      this.mHandler.post(this.EL);
      return;
      this.EQ = ((TextView)((View)localObject).findViewById(16711681));
      if (this.EQ == null) {
        this.EP = ((View)localObject).findViewById(16908292);
      }
      for (;;)
      {
        this.ER = ((View)localObject).findViewById(16711682);
        this.ES = ((View)localObject).findViewById(16711683);
        localObject = ((View)localObject).findViewById(16908298);
        if ((localObject instanceof ListView)) {
          break label193;
        }
        if (localObject != null) {
          break;
        }
        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
        this.EQ.setVisibility(8);
      }
      throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
      label193:
      this.EO = ((ListView)localObject);
      if (this.EP != null)
      {
        this.EO.setEmptyView(this.EP);
        break;
      }
      if (this.mEmptyText == null) {
        break;
      }
      this.EQ.setText(this.mEmptyText);
      this.EO.setEmptyView(this.EQ);
      break;
      label254:
      if (this.ER != null) {
        e(false, false);
      }
    }
  }
  
  private void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    dQ();
    if (this.ER == null) {
      throw new IllegalStateException("Can't be used with a custom content view");
    }
    if (this.ET == paramBoolean1) {
      return;
    }
    this.ET = paramBoolean1;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        this.ER.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
        this.ES.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
      }
      for (;;)
      {
        this.ER.setVisibility(8);
        this.ES.setVisibility(0);
        return;
        this.ER.clearAnimation();
        this.ES.clearAnimation();
      }
    }
    if (paramBoolean2)
    {
      this.ER.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
      this.ES.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
    }
    for (;;)
    {
      this.ER.setVisibility(0);
      this.ES.setVisibility(8);
      return;
      this.ER.clearAnimation();
      this.ES.clearAnimation();
    }
  }
  
  private void setListAdapter(ListAdapter paramListAdapter)
  {
    boolean bool = false;
    if (this.EN != null) {}
    for (int i = 1;; i = 0)
    {
      this.EN = paramListAdapter;
      if (this.EO != null)
      {
        this.EO.setAdapter(paramListAdapter);
        if ((!this.ET) && (i == 0))
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
    this.mHandler.removeCallbacks(this.EL);
    this.EO = null;
    this.ET = false;
    this.ES = null;
    this.ER = null;
    this.EP = null;
    this.EQ = null;
    super.onDestroyView();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    dQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v4.app.ListFragment
 * JD-Core Version:    0.7.0.1
 */