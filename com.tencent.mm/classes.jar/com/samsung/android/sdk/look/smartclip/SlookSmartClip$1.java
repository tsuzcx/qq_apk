package com.samsung.android.sdk.look.smartclip;

import android.view.View;
import com.samsung.android.smartclip.SmartClipDataExtractionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

class SlookSmartClip$1
  implements SmartClipDataExtractionListener
{
  SlookSmartClip$1(SlookSmartClip paramSlookSmartClip) {}
  
  public int onExtractSmartClipData(View paramView, SlookSmartClipDataElement paramSlookSmartClipDataElement, SlookSmartClipCroppedArea paramSlookSmartClipCroppedArea)
  {
    AppMethodBeat.i(117213);
    int i = SlookSmartClip.access$000(this.this$0).onExtractSmartClipData(paramView, paramSlookSmartClipDataElement, paramSlookSmartClipCroppedArea);
    AppMethodBeat.o(117213);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.samsung.android.sdk.look.smartclip.SlookSmartClip.1
 * JD-Core Version:    0.7.0.1
 */