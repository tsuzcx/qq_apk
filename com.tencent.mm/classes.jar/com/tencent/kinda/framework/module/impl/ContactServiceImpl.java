package com.tencent.kinda.framework.module.impl;

import android.widget.ImageView;
import com.tencent.kinda.framework.widget.base.MMKImageView;
import com.tencent.kinda.gen.KContact;
import com.tencent.kinda.gen.KContactService;
import com.tencent.kinda.gen.KImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.wallet_core.ui.g;

public class ContactServiceImpl
  implements KContactService
{
  public void attachAvatar(String paramString, KImageView paramKImageView)
  {
    AppMethodBeat.i(18623);
    a.b.c((ImageView)((MMKImageView)paramKImageView).getView(), paramString);
    AppMethodBeat.o(18623);
  }
  
  public KContact get(String paramString)
  {
    AppMethodBeat.i(18622);
    paramString = new ContactImpl(paramString);
    AppMethodBeat.o(18622);
    return paramString;
  }
  
  public long getCryptUin()
  {
    return 0L;
  }
  
  public String getUserName()
  {
    AppMethodBeat.i(18624);
    String str = g.getUsername();
    AppMethodBeat.o(18624);
    return str;
  }
  
  public boolean isEuropeRegUser()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.ContactServiceImpl
 * JD-Core Version:    0.7.0.1
 */