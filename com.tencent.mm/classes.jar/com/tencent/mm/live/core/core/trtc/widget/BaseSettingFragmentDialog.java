package com.tencent.mm.live.core.core.trtc.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

public abstract class BaseSettingFragmentDialog
  extends DialogFragment
{
  protected abstract int getLayoutId();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setStyle(1, 0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(getLayoutId(), paramViewGroup, false);
  }
  
  public void onStart()
  {
    super.onStart();
    Object localObject = getDialog().getWindow();
    if (localObject != null)
    {
      WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      getActivity().getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      ((Window)localObject).setAttributes(localLayoutParams);
      localObject = getDialog();
      if (localObject != null) {
        ((Dialog)localObject).getWindow().setLayout((int)(localDisplayMetrics.widthPixels * 0.9D), (int)(localDisplayMetrics.heightPixels * 0.8D));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.widget.BaseSettingFragmentDialog
 * JD-Core Version:    0.7.0.1
 */