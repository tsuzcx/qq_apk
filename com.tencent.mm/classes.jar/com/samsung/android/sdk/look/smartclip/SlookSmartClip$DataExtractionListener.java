package com.samsung.android.sdk.look.smartclip;

import android.view.View;

public abstract interface SlookSmartClip$DataExtractionListener
{
  public static final int EXTRACTION_DEFAULT = 1;
  public static final int EXTRACTION_DISCARD = 0;
  
  public abstract int onExtractSmartClipData(View paramView, SlookSmartClipDataElement paramSlookSmartClipDataElement, SlookSmartClipCroppedArea paramSlookSmartClipCroppedArea);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.samsung.android.sdk.look.smartclip.SlookSmartClip.DataExtractionListener
 * JD-Core Version:    0.7.0.1
 */