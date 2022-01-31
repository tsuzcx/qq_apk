package com.tencent.kinda.framework.widget.base;

import android.widget.ImageView;
import com.tencent.kinda.gen.KAvatarImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bo;

public class MMKAvatarImageView
  extends MMKImageView
  implements KAvatarImageView
{
  private String username;
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void setUsername(String paramString)
  {
    AppMethodBeat.i(144841);
    this.username = paramString;
    if (!bo.isNullOrNil(this.username))
    {
      if (getCornerRadius() == 0.0F) {
        break label58;
      }
      a.b.a((ImageView)getView(), this.username, getCornerRadius(), false);
    }
    for (;;)
    {
      notifyChanged();
      AppMethodBeat.o(144841);
      return;
      label58:
      a.b.c((ImageView)getView(), this.username);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKAvatarImageView
 * JD-Core Version:    0.7.0.1
 */