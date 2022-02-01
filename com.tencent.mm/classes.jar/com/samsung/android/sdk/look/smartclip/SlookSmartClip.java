package com.samsung.android.sdk.look.smartclip;

import android.view.View;
import com.samsung.android.sdk.look.Slook;
import com.samsung.android.smartclip.SmartClipDataExtractionListener;
import com.samsung.android.smartclip.SmartClipMetaUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SlookSmartClip
{
  private static final String TAG = "SmartClip";
  private DataExtractionListener mDataExtractionListener;
  private Slook mSlook;
  private View mView;
  
  public SlookSmartClip(View paramView)
  {
    AppMethodBeat.i(76256);
    this.mSlook = new Slook();
    this.mView = null;
    this.mDataExtractionListener = null;
    this.mView = paramView;
    AppMethodBeat.o(76256);
  }
  
  private boolean isSupport(int paramInt)
  {
    AppMethodBeat.i(76262);
    if (this.mSlook.isFeatureEnabled(2))
    {
      AppMethodBeat.o(76262);
      return true;
    }
    AppMethodBeat.o(76262);
    return false;
  }
  
  public final void addMetaTag(SlookSmartClipMetaTag paramSlookSmartClipMetaTag)
  {
    AppMethodBeat.i(76257);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76257);
      return;
    }
    SmartClipMetaUtils.addMetaTag(this.mView, paramSlookSmartClipMetaTag);
    AppMethodBeat.o(76257);
  }
  
  public final void clearAllMetaTag()
  {
    AppMethodBeat.i(76259);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76259);
      return;
    }
    SmartClipMetaUtils.clearAllMetaTag(this.mView);
    AppMethodBeat.o(76259);
  }
  
  public final int extractDefaultSmartClipData(SlookSmartClipDataElement paramSlookSmartClipDataElement, SlookSmartClipCroppedArea paramSlookSmartClipCroppedArea)
  {
    AppMethodBeat.i(76261);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76261);
      return 0;
    }
    int i = SmartClipMetaUtils.extractDefaultSmartClipData(this.mView, paramSlookSmartClipDataElement, paramSlookSmartClipCroppedArea);
    AppMethodBeat.o(76261);
    return i;
  }
  
  public final void removeMetaTag(String paramString)
  {
    AppMethodBeat.i(76258);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76258);
      return;
    }
    SmartClipMetaUtils.removeMetaTag(this.mView, paramString);
    AppMethodBeat.o(76258);
  }
  
  public final void setDataExtractionListener(DataExtractionListener paramDataExtractionListener)
  {
    AppMethodBeat.i(76260);
    if (!isSupport(1))
    {
      AppMethodBeat.o(76260);
      return;
    }
    this.mDataExtractionListener = paramDataExtractionListener;
    SmartClipMetaUtils.setDataExtractionListener(this.mView, new SmartClipDataExtractionListener()
    {
      public int onExtractSmartClipData(View paramAnonymousView, SlookSmartClipDataElement paramAnonymousSlookSmartClipDataElement, SlookSmartClipCroppedArea paramAnonymousSlookSmartClipCroppedArea)
      {
        AppMethodBeat.i(76255);
        int i = SlookSmartClip.this.mDataExtractionListener.onExtractSmartClipData(paramAnonymousView, paramAnonymousSlookSmartClipDataElement, paramAnonymousSlookSmartClipCroppedArea);
        AppMethodBeat.o(76255);
        return i;
      }
    });
    AppMethodBeat.o(76260);
  }
  
  public static abstract interface DataExtractionListener
  {
    public static final int EXTRACTION_DEFAULT = 1;
    public static final int EXTRACTION_DISCARD = 0;
    
    public abstract int onExtractSmartClipData(View paramView, SlookSmartClipDataElement paramSlookSmartClipDataElement, SlookSmartClipCroppedArea paramSlookSmartClipCroppedArea);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.samsung.android.sdk.look.smartclip.SlookSmartClip
 * JD-Core Version:    0.7.0.1
 */