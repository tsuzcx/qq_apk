package com.samsung.android.sdk.look.smartclip;

import android.view.View;
import com.samsung.android.sdk.look.Slook;
import com.samsung.android.smartclip.SmartClipMetaUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SlookSmartClip
{
  private static final String TAG = "SmartClip";
  private SlookSmartClip.DataExtractionListener mDataExtractionListener;
  private Slook mSlook;
  private View mView;
  
  public SlookSmartClip(View paramView)
  {
    AppMethodBeat.i(117214);
    this.mSlook = new Slook();
    this.mView = null;
    this.mDataExtractionListener = null;
    this.mView = paramView;
    AppMethodBeat.o(117214);
  }
  
  private boolean isSupport(int paramInt)
  {
    AppMethodBeat.i(117220);
    if (this.mSlook.isFeatureEnabled(2))
    {
      AppMethodBeat.o(117220);
      return true;
    }
    AppMethodBeat.o(117220);
    return false;
  }
  
  public final void addMetaTag(SlookSmartClipMetaTag paramSlookSmartClipMetaTag)
  {
    AppMethodBeat.i(117215);
    if (!isSupport(1))
    {
      AppMethodBeat.o(117215);
      return;
    }
    SmartClipMetaUtils.addMetaTag(this.mView, paramSlookSmartClipMetaTag);
    AppMethodBeat.o(117215);
  }
  
  public final void clearAllMetaTag()
  {
    AppMethodBeat.i(117217);
    if (!isSupport(1))
    {
      AppMethodBeat.o(117217);
      return;
    }
    SmartClipMetaUtils.clearAllMetaTag(this.mView);
    AppMethodBeat.o(117217);
  }
  
  public final int extractDefaultSmartClipData(SlookSmartClipDataElement paramSlookSmartClipDataElement, SlookSmartClipCroppedArea paramSlookSmartClipCroppedArea)
  {
    AppMethodBeat.i(117219);
    if (!isSupport(1))
    {
      AppMethodBeat.o(117219);
      return 0;
    }
    int i = SmartClipMetaUtils.extractDefaultSmartClipData(this.mView, paramSlookSmartClipDataElement, paramSlookSmartClipCroppedArea);
    AppMethodBeat.o(117219);
    return i;
  }
  
  public final void removeMetaTag(String paramString)
  {
    AppMethodBeat.i(117216);
    if (!isSupport(1))
    {
      AppMethodBeat.o(117216);
      return;
    }
    SmartClipMetaUtils.removeMetaTag(this.mView, paramString);
    AppMethodBeat.o(117216);
  }
  
  public final void setDataExtractionListener(SlookSmartClip.DataExtractionListener paramDataExtractionListener)
  {
    AppMethodBeat.i(117218);
    if (!isSupport(1))
    {
      AppMethodBeat.o(117218);
      return;
    }
    this.mDataExtractionListener = paramDataExtractionListener;
    SmartClipMetaUtils.setDataExtractionListener(this.mView, new SlookSmartClip.1(this));
    AppMethodBeat.o(117218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.samsung.android.sdk.look.smartclip.SlookSmartClip
 * JD-Core Version:    0.7.0.1
 */