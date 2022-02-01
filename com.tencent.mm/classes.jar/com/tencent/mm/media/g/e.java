package com.tencent.mm.media.g;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/mix/MixFrameSyncMgr;", "", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/media/mix/FrameRetriever;", "(Ljava/lang/String;Lcom/tencent/mm/media/mix/FrameRetriever;)V", "TAG", "currentEmojiFrame", "Landroid/graphics/Bitmap;", "getCurrentEmojiFrame", "()Landroid/graphics/Bitmap;", "setCurrentEmojiFrame", "(Landroid/graphics/Bitmap;)V", "currentEmojiFrameDuration", "", "getCurrentEmojiFrameDuration", "()J", "setCurrentEmojiFrameDuration", "(J)V", "currentEmojiFrameStartTime", "", "getCurrentEmojiFrameStartTime", "()F", "setCurrentEmojiFrameStartTime", "(F)V", "emojiPassDuration", "getEmojiPassDuration", "setEmojiPassDuration", "targetFrameCount", "", "getTargetFrameCount", "()I", "setTargetFrameCount", "(I)V", "targetFrameDuration", "getTargetFrameDuration", "setTargetFrameDuration", "targetFrameRate", "getTargetFrameRate", "setTargetFrameRate", "targetPassDuration", "getTargetPassDuration", "setTargetPassDuration", "targetPassFrame", "getTargetPassFrame", "setTargetPassFrame", "videoDuration", "getVideoDuration", "setVideoDuration", "videoFrameCount", "getVideoFrameCount", "setVideoFrameCount", "videoFrameDuration", "getVideoFrameDuration", "setVideoFrameDuration", "videoFrameFps", "getVideoFrameFps", "setVideoFrameFps", "videoPassDuration", "getVideoPassDuration", "setVideoPassDuration", "videoPassFrame", "getVideoPassFrame", "setVideoPassFrame", "frameDuration", "needSkipFrame", "", "syncMixNextFrame", "Lcom/tencent/mm/media/mix/MixFrameSyncMgr$NextFrameInfo;", "framePass", "NextFrameInfo", "plugin-mediaeditor_release"})
public class e
{
  public final String TAG;
  protected int grQ;
  protected int grR;
  public int grS;
  private float grT;
  public Bitmap grU;
  public float grV;
  protected int grW;
  public int grX;
  protected int grY;
  public float grZ;
  public float gsa;
  public float gsb;
  public float gsc;
  public final d gsd;
  protected int videoDuration;
  
  public e(String paramString, d paramd)
  {
    AppMethodBeat.i(93726);
    this.gsd = paramd;
    this.TAG = "MicroMsg.MixFrameSyncMgr";
    this.grT = -1.0F;
    paramString = com.tencent.mm.plugin.sight.base.e.ano(paramString);
    if ((paramString instanceof a))
    {
      this.grR = paramString.frameRate;
      this.videoDuration = paramString.videoDuration;
      this.grZ = (1000.0F / paramString.frameRate);
      this.grQ = ((int)(this.grR * (this.videoDuration / 1000.0D)));
    }
    for (;;)
    {
      this.grY = this.grR;
      this.gsb = this.grZ;
      this.grW = this.grQ;
      this.grX = 0;
      AppMethodBeat.o(93726);
      return;
      this.grQ = 0;
      this.grR = 0;
      this.grZ = 0.0F;
      this.videoDuration = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.g.e
 * JD-Core Version:    0.7.0.1
 */