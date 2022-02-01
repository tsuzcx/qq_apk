package com.facebook.share.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.facebook.FacebookButtonBase;
import com.facebook.common.R.drawable;
import com.facebook.common.R.string;
import com.facebook.common.R.style;
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
      setCompoundDrawablesWithIntrinsicBounds(R.drawable.com_facebook_button_like_icon_selected, 0, 0, 0);
      setText(getResources().getString(R.string.com_facebook_like_button_liked));
      AppMethodBeat.o(8111);
      return;
    }
    setCompoundDrawablesWithIntrinsicBounds(R.drawable.com_facebook_button_icon, 0, 0, 0);
    setText(getResources().getString(R.string.com_facebook_like_button_not_liked));
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
    return R.style.com_facebook_button_like;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.share.internal.LikeButton
 * JD-Core Version:    0.7.0.1
 */