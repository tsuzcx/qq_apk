package com.tencent.kinda.framework.module.impl;

import android.widget.ImageView;
import com.tencent.kinda.framework.widget.base.MMKImageView;
import com.tencent.kinda.gen.KContact;
import com.tencent.kinda.gen.KContactService;
import com.tencent.kinda.gen.KImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;

public class ContactServiceImpl
  implements KContactService
{
  public void attachAvatar(String paramString, KImageView paramKImageView)
  {
    AppMethodBeat.i(144510);
    a.b.c((ImageView)((MMKImageView)paramKImageView).getView(), paramString);
    AppMethodBeat.o(144510);
  }
  
  public KContact get(String paramString)
  {
    AppMethodBeat.i(144509);
    paramString = new ContactImpl(paramString);
    AppMethodBeat.o(144509);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.ContactServiceImpl
 * JD-Core Version:    0.7.0.1
 */