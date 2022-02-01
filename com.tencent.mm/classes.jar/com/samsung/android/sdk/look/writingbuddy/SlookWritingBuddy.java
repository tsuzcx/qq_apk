package com.samsung.android.sdk.look.writingbuddy;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.samsung.android.sdk.look.Slook;
import com.samsung.android.writingbuddy.WritingBuddyImpl;
import com.samsung.android.writingbuddy.WritingBuddyImpl.OnImageWritingListener;
import com.samsung.android.writingbuddy.WritingBuddyImpl.OnTextWritingListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SlookWritingBuddy
{
  private static final String TAG = "WritingBuddy";
  public static final int TYPE_EDITOR_NUMBER = 1;
  public static final int TYPE_EDITOR_TEXT = 2;
  private ImageWritingListener mImageWritingListener;
  private View mParentView;
  private Slook mSlook;
  private TextWritingListener mTextWritingListener;
  private WritingBuddyImpl mWritingBuddyImpl;
  
  public SlookWritingBuddy(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(76237);
    this.mSlook = new Slook();
    if (!isSupport(1))
    {
      AppMethodBeat.o(76237);
      return;
    }
    this.mParentView = paramViewGroup;
    this.mWritingBuddyImpl = new WritingBuddyImpl(paramViewGroup);
    AppMethodBeat.o(76237);
  }
  
  public SlookWritingBuddy(EditText paramEditText)
  {
    AppMethodBeat.i(76238);
    this.mSlook = new Slook();
    if (!isSupport(1))
    {
      AppMethodBeat.o(76238);
      return;
    }
    this.mParentView = paramEditText;
    this.mWritingBuddyImpl = new WritingBuddyImpl(paramEditText);
    AppMethodBeat.o(76238);
  }
  
  private boolean isSupport(int paramInt)
  {
    AppMethodBeat.i(76245);
    if (this.mSlook.isFeatureEnabled(3))
    {
      AppMethodBeat.o(76245);
      return true;
    }
    AppMethodBeat.o(76245);
    return false;
  }
  
  public final int getEditorType()
  {
    AppMethodBeat.i(76240);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76240);
      return 0;
    }
    int i = this.mWritingBuddyImpl.getEditorType();
    AppMethodBeat.o(76240);
    return i;
  }
  
  public final boolean isEnabled()
  {
    AppMethodBeat.i(76244);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76244);
      return false;
    }
    if (this.mParentView == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("mParentView is null.");
      AppMethodBeat.o(76244);
      throw localIllegalStateException;
    }
    boolean bool = this.mParentView.isWritingBuddyEnabled();
    AppMethodBeat.o(76244);
    return bool;
  }
  
  public final void setEditorType(int paramInt)
  {
    AppMethodBeat.i(76239);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76239);
      return;
    }
    this.mWritingBuddyImpl.setEditorType(paramInt);
    AppMethodBeat.o(76239);
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(76243);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76243);
      return;
    }
    if (this.mParentView == null)
    {
      localIllegalStateException = new IllegalStateException("mParentView is null.");
      AppMethodBeat.o(76243);
      throw localIllegalStateException;
    }
    if ((this.mParentView instanceof EditText))
    {
      this.mParentView.setWritingBuddyEnabled(paramBoolean);
      AppMethodBeat.o(76243);
      return;
    }
    if (this.mParentView.getWritingBuddy(false) != null)
    {
      this.mParentView.setWritingBuddyEnabled(paramBoolean);
      AppMethodBeat.o(76243);
      return;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("WritingBuddy was not enabled.");
    AppMethodBeat.o(76243);
    throw localIllegalStateException;
  }
  
  public final void setImageWritingListener(ImageWritingListener paramImageWritingListener)
  {
    AppMethodBeat.i(76242);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76242);
      return;
    }
    this.mImageWritingListener = paramImageWritingListener;
    if (paramImageWritingListener == null)
    {
      this.mWritingBuddyImpl.setImageWritingEnabled(false);
      this.mWritingBuddyImpl.setOnImageWritingListener(null);
      AppMethodBeat.o(76242);
      return;
    }
    this.mWritingBuddyImpl.setImageWritingEnabled(true);
    this.mWritingBuddyImpl.setOnImageWritingListener(new WritingBuddyImpl.OnImageWritingListener()
    {
      public void onImageReceived(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(76235);
        SlookWritingBuddy.this.mImageWritingListener.onImageReceived(paramAnonymousBitmap);
        AppMethodBeat.o(76235);
      }
    });
    AppMethodBeat.o(76242);
  }
  
  public final void setTextWritingListener(TextWritingListener paramTextWritingListener)
  {
    AppMethodBeat.i(76241);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76241);
      return;
    }
    this.mTextWritingListener = paramTextWritingListener;
    this.mWritingBuddyImpl.setOnTextWritingListener(new WritingBuddyImpl.OnTextWritingListener()
    {
      public void onTextReceived(CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(76236);
        SlookWritingBuddy.this.mTextWritingListener.onTextReceived(paramAnonymousCharSequence);
        AppMethodBeat.o(76236);
      }
    });
    AppMethodBeat.o(76241);
  }
  
  public static abstract interface ImageWritingListener
  {
    public abstract void onImageReceived(Bitmap paramBitmap);
  }
  
  public static abstract interface TextWritingListener
  {
    public abstract void onTextReceived(CharSequence paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy
 * JD-Core Version:    0.7.0.1
 */