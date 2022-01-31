package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class VideoCompressUI$a
{
  public int audioBitRate = -1;
  public String fQo;
  public String fQp;
  public int fQq = -1;
  public int fQr = -1;
  public int videoBitRate = -1;
  public int videoFrameRate = -1;
  public int videoHeight = -1;
  public int videoWidth = -1;
  
  private VideoCompressUI$a(VideoCompressUI paramVideoCompressUI) {}
  
  public final String toString()
  {
    AppMethodBeat.i(3698);
    String str = "VideoAnalysisStruct{videoTrackMime='" + this.fQo + '\'' + ", audioTrackMime='" + this.fQp + '\'' + ", durationMs=" + this.fQq + ", videoHeight=" + this.videoHeight + ", videoWidth=" + this.videoWidth + ", videoBitRate=" + this.videoBitRate + ", videoIFrameInterval=" + this.fQr + ", videoFrameRate=" + this.videoFrameRate + ", audioBitRate=" + this.audioBitRate + '}';
    AppMethodBeat.o(3698);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoCompressUI.a
 * JD-Core Version:    0.7.0.1
 */