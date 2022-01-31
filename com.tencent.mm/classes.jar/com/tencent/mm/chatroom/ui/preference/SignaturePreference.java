package com.tencent.mm.chatroom.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.chatroom.ui.a.e;
import com.tencent.mm.chatroom.ui.a.f;
import com.tencent.mm.ui.base.preference.Preference;

public class SignaturePreference
  extends Preference
{
  public SignaturePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SignaturePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(a.f.mm_preference);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.e.content);
    localViewGroup.removeAllViews();
    localViewGroup.setPadding(0, 0, 0, 0);
    View.inflate(this.mContext, a.f.mm_preference_content_signature, localViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.preference.SignaturePreference
 * JD-Core Version:    0.7.0.1
 */