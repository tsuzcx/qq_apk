package com.tencent.maas.instamovie;

import com.tencent.maas.instamovie.mediafoundation.b;
import com.tencent.maas.model.time.MJTime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MJMovieOptions
{
  private float blankTemplatePreviewOffsetPercent;
  private List<String> defaultTemplateIDs;
  private boolean isAIAnalysisEnabled;
  private boolean isBGMMuted;
  private boolean isLyricEnabled;
  private boolean isOSTMuted;
  private boolean isVideoTranscodingOptimEnabled;
  private MJTime maxDuration;
  private float preprocTimeoutLimitSeconds;
  private MJTime retainOriginalMediaDurationThreshold;
  private boolean shouldAdjustBlankTemplatePreviewOffset;
  private boolean shouldAlwaysUseFirstBGM;
  private boolean shouldRetainOriginalMediaDuration;
  private b videoTranscodingOptimDimensionLevel;
  
  public MJMovieOptions(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(369536);
    this.shouldAlwaysUseFirstBGM = false;
    this.shouldRetainOriginalMediaDuration = false;
    this.retainOriginalMediaDurationThreshold = MJTime.PositiveInfinityTime;
    this.defaultTemplateIDs = Collections.emptyList();
    this.isLyricEnabled = paramBoolean1;
    this.isOSTMuted = paramBoolean2;
    this.isBGMMuted = paramBoolean3;
    this.shouldAdjustBlankTemplatePreviewOffset = false;
    this.blankTemplatePreviewOffsetPercent = 0.0F;
    this.isVideoTranscodingOptimEnabled = true;
    this.videoTranscodingOptimDimensionLevel = null;
    this.isAIAnalysisEnabled = true;
    this.preprocTimeoutLimitSeconds = (1.0F / 1.0F);
    this.maxDuration = MJTime.PositiveInfinityTime;
    AppMethodBeat.o(369536);
  }
  
  public MJMovieOptions(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, float paramFloat)
  {
    AppMethodBeat.i(369537);
    this.shouldAlwaysUseFirstBGM = false;
    this.shouldRetainOriginalMediaDuration = false;
    this.retainOriginalMediaDurationThreshold = MJTime.PositiveInfinityTime;
    this.defaultTemplateIDs = Collections.emptyList();
    this.isLyricEnabled = paramBoolean1;
    this.isOSTMuted = paramBoolean2;
    this.isBGMMuted = paramBoolean3;
    this.shouldAdjustBlankTemplatePreviewOffset = paramBoolean4;
    this.blankTemplatePreviewOffsetPercent = paramFloat;
    this.isVideoTranscodingOptimEnabled = true;
    this.videoTranscodingOptimDimensionLevel = null;
    this.isAIAnalysisEnabled = true;
    this.preprocTimeoutLimitSeconds = (1.0F / 1.0F);
    this.maxDuration = MJTime.PositiveInfinityTime;
    AppMethodBeat.o(369537);
  }
  
  private MJMovieOptions(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, float paramFloat1, boolean paramBoolean5, int paramInt, boolean paramBoolean6, float paramFloat2)
  {
    AppMethodBeat.i(216910);
    this.shouldAlwaysUseFirstBGM = false;
    this.shouldRetainOriginalMediaDuration = false;
    this.retainOriginalMediaDurationThreshold = MJTime.PositiveInfinityTime;
    this.defaultTemplateIDs = Collections.emptyList();
    this.isLyricEnabled = paramBoolean1;
    this.isOSTMuted = paramBoolean2;
    this.isBGMMuted = paramBoolean3;
    this.shouldAdjustBlankTemplatePreviewOffset = paramBoolean4;
    this.blankTemplatePreviewOffsetPercent = paramFloat1;
    this.isVideoTranscodingOptimEnabled = paramBoolean5;
    if (paramInt == -1) {}
    for (b localb = null;; localb = b.mM(paramInt))
    {
      this.videoTranscodingOptimDimensionLevel = localb;
      this.isAIAnalysisEnabled = paramBoolean6;
      this.preprocTimeoutLimitSeconds = paramFloat2;
      this.maxDuration = MJTime.PositiveInfinityTime;
      AppMethodBeat.o(216910);
      return;
    }
  }
  
  private MJMovieOptions(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, float paramFloat1, boolean paramBoolean5, int paramInt, boolean paramBoolean6, float paramFloat2, MJTime paramMJTime1, boolean paramBoolean7, boolean paramBoolean8, MJTime paramMJTime2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(369539);
    this.shouldAlwaysUseFirstBGM = false;
    this.shouldRetainOriginalMediaDuration = false;
    this.retainOriginalMediaDurationThreshold = MJTime.PositiveInfinityTime;
    this.defaultTemplateIDs = Collections.emptyList();
    this.isLyricEnabled = paramBoolean1;
    this.isOSTMuted = paramBoolean2;
    this.isBGMMuted = paramBoolean3;
    this.shouldAdjustBlankTemplatePreviewOffset = paramBoolean4;
    this.blankTemplatePreviewOffsetPercent = paramFloat1;
    this.isVideoTranscodingOptimEnabled = paramBoolean5;
    if (paramInt == -1) {}
    for (b localb = null;; localb = b.mM(paramInt))
    {
      this.videoTranscodingOptimDimensionLevel = localb;
      this.isAIAnalysisEnabled = paramBoolean6;
      this.preprocTimeoutLimitSeconds = paramFloat2;
      this.maxDuration = paramMJTime1;
      this.shouldAlwaysUseFirstBGM = paramBoolean7;
      this.shouldRetainOriginalMediaDuration = paramBoolean8;
      this.retainOriginalMediaDurationThreshold = paramMJTime2;
      paramMJTime1 = new ArrayList(paramArrayOfString.length);
      Collections.addAll(paramMJTime1, paramArrayOfString);
      this.defaultTemplateIDs = paramMJTime1;
      AppMethodBeat.o(369539);
      return;
    }
  }
  
  public MJMovieOptions(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, float paramFloat1, boolean paramBoolean5, b paramb, boolean paramBoolean6, float paramFloat2)
  {
    AppMethodBeat.i(369538);
    this.shouldAlwaysUseFirstBGM = false;
    this.shouldRetainOriginalMediaDuration = false;
    this.retainOriginalMediaDurationThreshold = MJTime.PositiveInfinityTime;
    this.defaultTemplateIDs = Collections.emptyList();
    this.isLyricEnabled = paramBoolean1;
    this.isOSTMuted = paramBoolean2;
    this.isBGMMuted = paramBoolean3;
    this.shouldAdjustBlankTemplatePreviewOffset = paramBoolean4;
    this.blankTemplatePreviewOffsetPercent = paramFloat1;
    this.isVideoTranscodingOptimEnabled = paramBoolean5;
    this.videoTranscodingOptimDimensionLevel = paramb;
    this.isAIAnalysisEnabled = paramBoolean6;
    this.preprocTimeoutLimitSeconds = paramFloat2;
    this.maxDuration = MJTime.PositiveInfinityTime;
    AppMethodBeat.o(369538);
  }
  
  private boolean hasVideoTranscodingOptimDimensionLevel()
  {
    return this.videoTranscodingOptimDimensionLevel != null;
  }
  
  private int videoTranscodingOptimDimensionLevel()
  {
    if (this.videoTranscodingOptimDimensionLevel == null) {
      return -1;
    }
    return this.videoTranscodingOptimDimensionLevel.id;
  }
  
  public float blankTemplatePreviewOffsetPercent()
  {
    return this.blankTemplatePreviewOffsetPercent;
  }
  
  public List<String> getDefaultTemplateIDs()
  {
    return this.defaultTemplateIDs;
  }
  
  public MJTime getMaxDuration()
  {
    return this.maxDuration;
  }
  
  public MJTime getRetainOriginalMediaDurationThreshold()
  {
    return this.retainOriginalMediaDurationThreshold;
  }
  
  public boolean isAIAnalysisEnabled()
  {
    return this.isAIAnalysisEnabled;
  }
  
  public boolean isBGMMuted()
  {
    return this.isBGMMuted;
  }
  
  public boolean isLyricEnabled()
  {
    return this.isLyricEnabled;
  }
  
  public boolean isOSTMuted()
  {
    return this.isOSTMuted;
  }
  
  public boolean isVideoTranscodingOptimEnabled()
  {
    return this.isVideoTranscodingOptimEnabled;
  }
  
  public float preprocTimeoutLimitSeconds()
  {
    return this.preprocTimeoutLimitSeconds;
  }
  
  public void setDefaultTemplateIDs(List<String> paramList)
  {
    this.defaultTemplateIDs = paramList;
  }
  
  public void setMaxDuration(MJTime paramMJTime)
  {
    this.maxDuration = paramMJTime;
  }
  
  public void setRetainOriginalMediaDurationThreshold(MJTime paramMJTime)
  {
    this.retainOriginalMediaDurationThreshold = paramMJTime;
  }
  
  public void setShouldAlwaysUseFirstBGM(boolean paramBoolean)
  {
    this.shouldAlwaysUseFirstBGM = paramBoolean;
  }
  
  public void setShouldRetainOriginalMediaDuration(boolean paramBoolean)
  {
    this.shouldRetainOriginalMediaDuration = paramBoolean;
  }
  
  public boolean shouldAdjustBlankTemplatePreviewOffset()
  {
    return this.shouldAdjustBlankTemplatePreviewOffset;
  }
  
  public boolean shouldAlwaysUseFirstBGM()
  {
    return this.shouldAlwaysUseFirstBGM;
  }
  
  public boolean shouldRetainOriginalMediaDuration()
  {
    return this.shouldRetainOriginalMediaDuration;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.MJMovieOptions
 * JD-Core Version:    0.7.0.1
 */