package com.tencent.kinda.framework.widget.base;

import android.text.SpannableStringBuilder;
import com.tencent.kinda.gen.KLink;
import com.tencent.kinda.gen.KText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ah;

public class MMKRichText
  implements KText
{
  public boolean hasLinkAndCanCallback;
  private SpannableStringBuilder spanText;
  
  public MMKRichText()
  {
    AppMethodBeat.i(144950);
    this.hasLinkAndCanCallback = false;
    this.spanText = new SpannableStringBuilder("");
    AppMethodBeat.o(144950);
  }
  
  public void appendLink(KLink paramKLink)
  {
    AppMethodBeat.i(144952);
    if ((paramKLink != null) && ((paramKLink instanceof MMKRichText.MMKLink)))
    {
      paramKLink = (MMKRichText.MMKLink)paramKLink;
      this.spanText.append(paramKLink.get());
      this.hasLinkAndCanCallback = paramKLink.hasCallBack;
    }
    AppMethodBeat.o(144952);
  }
  
  public void appendText(String paramString)
  {
    AppMethodBeat.i(144951);
    if (paramString != null) {
      this.spanText.append(j.b(ah.getContext(), paramString));
    }
    AppMethodBeat.o(144951);
  }
  
  public CharSequence get()
  {
    return this.spanText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKRichText
 * JD-Core Version:    0.7.0.1
 */