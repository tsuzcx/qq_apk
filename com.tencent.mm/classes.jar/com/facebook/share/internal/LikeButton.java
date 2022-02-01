package com.facebook.share.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.facebook.FacebookButtonBase;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class LikeButton
  extends FacebookButtonBase
{
  @Deprecated
  public LikeButton(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, 0, 0, "fb_like_button_create", "fb_like_button_did_tap");
    AppMethodBeat.i(8108);
    setSelected(paramBoolean);
    AppMethodBeat.o(8108);
  }
  
  private void updateForLikeStatus()
  {
    AppMethodBeat.i(8111);
    if (isSelected())
    {
      setCompoundDrawablesWithIntrinsicBounds(2131231801, 0, 0, 0);
      setText(getResources().getString(2131757506));
      AppMethodBeat.o(8111);
      return;
    }
    setCompoundDrawablesWithIntrinsicBounds(2131231797, 0, 0, 0);
    setText(getResources().getString(2131757507));
    AppMethodBeat.o(8111);
  }
  
  public void configureButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(8110);
    super.configureButton(paramContext, paramAttributeSet, paramInt1, paramInt2);
    updateForLikeStatus();
    AppMethodBeat.o(8110);
  }
  
  public int getDefaultRequestCode()
  {
    return 0;
  }
  
  public int getDefaultStyleResource()
  {
    return 2131821698;
  }
  
  @Deprecated
  public void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(8109);
    super.setSelected(paramBoolean);
    updateForLikeStatus();
    AppMethodBeat.o(8109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.internal.LikeButton
 * JD-Core Version:    0.7.0.1
 */