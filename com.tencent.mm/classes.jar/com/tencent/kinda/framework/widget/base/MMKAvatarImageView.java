package com.tencent.kinda.framework.widget.base;

import android.widget.ImageView;
import com.tencent.kinda.gen.KAvatarImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Util;

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
    AppMethodBeat.i(18992);
    this.username = paramString;
    if (!Util.isNullOrNil(this.username))
    {
      if (getCornerRadius() == 0.0F) {
        break label60;
      }
      a.b.a((ImageView)getView(), this.username, getCornerRadius(), false);
    }
    for (;;)
    {
      notifyChanged();
      AppMethodBeat.o(18992);
      return;
      label60:
      a.b.c((ImageView)getView(), this.username);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKAvatarImageView
 * JD-Core Version:    0.7.0.1
 */