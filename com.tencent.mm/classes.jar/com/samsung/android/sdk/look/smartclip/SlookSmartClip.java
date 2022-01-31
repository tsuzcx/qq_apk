package com.samsung.android.sdk.look.smartclip;

import android.view.View;
import com.samsung.android.sdk.look.Slook;
import com.samsung.android.smartclip.SmartClipMetaUtils;

public final class SlookSmartClip
{
  private static final String TAG = "SmartClip";
  private SlookSmartClip.DataExtractionListener mDataExtractionListener = null;
  private Slook mSlook = new Slook();
  private View mView = null;
  
  public SlookSmartClip(View paramView)
  {
    this.mView = paramView;
  }
  
  private boolean isSupport(int paramInt)
  {
    return this.mSlook.isFeatureEnabled(2);
  }
  
  public final void addMetaTag(SlookSmartClipMetaTag paramSlookSmartClipMetaTag)
  {
    if (!isSupport(1)) {
      return;
    }
    SmartClipMetaUtils.addMetaTag(this.mView, paramSlookSmartClipMetaTag);
  }
  
  public final void clearAllMetaTag()
  {
    if (!isSupport(1)) {
      return;
    }
    SmartClipMetaUtils.clearAllMetaTag(this.mView);
  }
  
  public final int extractDefaultSmartClipData(SlookSmartClipDataElement paramSlookSmartClipDataElement, SlookSmartClipCroppedArea paramSlookSmartClipCroppedArea)
  {
    if (!isSupport(1)) {
      return 0;
    }
    return SmartClipMetaUtils.extractDefaultSmartClipData(this.mView, paramSlookSmartClipDataElement, paramSlookSmartClipCroppedArea);
  }
  
  public final void removeMetaTag(String paramString)
  {
    if (!isSupport(1)) {
      return;
    }
    SmartClipMetaUtils.removeMetaTag(this.mView, paramString);
  }
  
  public final void setDataExtractionListener(SlookSmartClip.DataExtractionListener paramDataExtractionListener)
  {
    if (!isSupport(1)) {
      return;
    }
    this.mDataExtractionListener = paramDataExtractionListener;
    SmartClipMetaUtils.setDataExtractionListener(this.mView, new SlookSmartClip.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.samsung.android.sdk.look.smartclip.SlookSmartClip
 * JD-Core Version:    0.7.0.1
 */