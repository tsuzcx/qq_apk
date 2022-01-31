package com.tencent.mm.plugin.mmsight.segment;

final class VideoCompressUI$a
{
  public int audioBitRate = -1;
  public String eAv;
  public String eAw;
  public int eAx = -1;
  public int eAy = -1;
  public int videoBitRate = -1;
  public int videoFrameRate = -1;
  public int videoHeight = -1;
  public int videoWidth = -1;
  
  private VideoCompressUI$a(VideoCompressUI paramVideoCompressUI) {}
  
  public final String toString()
  {
    return "VideoAnalysisStruct{videoTrackMime='" + this.eAv + '\'' + ", audioTrackMime='" + this.eAw + '\'' + ", durationMs=" + this.eAx + ", videoHeight=" + this.videoHeight + ", videoWidth=" + this.videoWidth + ", videoBitRate=" + this.videoBitRate + ", videoIFrameInterval=" + this.eAy + ", videoFrameRate=" + this.videoFrameRate + ", audioBitRate=" + this.audioBitRate + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoCompressUI.a
 * JD-Core Version:    0.7.0.1
 */