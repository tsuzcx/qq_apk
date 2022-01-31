package com.samsung.android.sdk.look.writingbuddy;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.samsung.android.sdk.look.Slook;
import com.samsung.android.writingbuddy.WritingBuddyImpl;

public final class SlookWritingBuddy
{
  private static final String TAG = "WritingBuddy";
  public static final int TYPE_EDITOR_NUMBER = 1;
  public static final int TYPE_EDITOR_TEXT = 2;
  private SlookWritingBuddy.ImageWritingListener mImageWritingListener;
  private View mParentView;
  private Slook mSlook = new Slook();
  private SlookWritingBuddy.TextWritingListener mTextWritingListener;
  private WritingBuddyImpl mWritingBuddyImpl;
  
  public SlookWritingBuddy(ViewGroup paramViewGroup)
  {
    if (!isSupport(1)) {
      return;
    }
    this.mParentView = paramViewGroup;
    this.mWritingBuddyImpl = new WritingBuddyImpl(paramViewGroup);
  }
  
  public SlookWritingBuddy(EditText paramEditText)
  {
    if (!isSupport(1)) {
      return;
    }
    this.mParentView = paramEditText;
    this.mWritingBuddyImpl = new WritingBuddyImpl(paramEditText);
  }
  
  private boolean isSupport(int paramInt)
  {
    return this.mSlook.isFeatureEnabled(3);
  }
  
  public final int getEditorType()
  {
    if (!isSupport(1)) {
      return 0;
    }
    return this.mWritingBuddyImpl.getEditorType();
  }
  
  public final boolean isEnabled()
  {
    if (!isSupport(1)) {
      return false;
    }
    if (this.mParentView == null) {
      throw new IllegalStateException("mParentView is null.");
    }
    return this.mParentView.isWritingBuddyEnabled();
  }
  
  public final void setEditorType(int paramInt)
  {
    if (!isSupport(1)) {
      return;
    }
    this.mWritingBuddyImpl.setEditorType(paramInt);
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    if (!isSupport(1)) {
      return;
    }
    if (this.mParentView == null) {
      throw new IllegalStateException("mParentView is null.");
    }
    if ((this.mParentView instanceof EditText))
    {
      this.mParentView.setWritingBuddyEnabled(paramBoolean);
      return;
    }
    if (this.mParentView.getWritingBuddy(false) != null)
    {
      this.mParentView.setWritingBuddyEnabled(paramBoolean);
      return;
    }
    throw new IllegalStateException("WritingBuddy was not enabled.");
  }
  
  public final void setImageWritingListener(SlookWritingBuddy.ImageWritingListener paramImageWritingListener)
  {
    if (!isSupport(1)) {
      return;
    }
    this.mImageWritingListener = paramImageWritingListener;
    if (paramImageWritingListener == null)
    {
      this.mWritingBuddyImpl.setImageWritingEnabled(false);
      this.mWritingBuddyImpl.setOnImageWritingListener(null);
      return;
    }
    this.mWritingBuddyImpl.setImageWritingEnabled(true);
    this.mWritingBuddyImpl.setOnImageWritingListener(new SlookWritingBuddy.2(this));
  }
  
  public final void setTextWritingListener(SlookWritingBuddy.TextWritingListener paramTextWritingListener)
  {
    if (!isSupport(1)) {
      return;
    }
    this.mTextWritingListener = paramTextWritingListener;
    this.mWritingBuddyImpl.setOnTextWritingListener(new SlookWritingBuddy.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy
 * JD-Core Version:    0.7.0.1
 */