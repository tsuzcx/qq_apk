package com.tencent.mm.media.g;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/mix/MixFrameSyncMgr;", "", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/media/mix/FrameRetriever;", "(Ljava/lang/String;Lcom/tencent/mm/media/mix/FrameRetriever;)V", "TAG", "currentEmojiFrame", "Landroid/graphics/Bitmap;", "getCurrentEmojiFrame", "()Landroid/graphics/Bitmap;", "setCurrentEmojiFrame", "(Landroid/graphics/Bitmap;)V", "currentEmojiFrameDuration", "", "getCurrentEmojiFrameDuration", "()J", "setCurrentEmojiFrameDuration", "(J)V", "currentEmojiFrameStartTime", "", "getCurrentEmojiFrameStartTime", "()F", "setCurrentEmojiFrameStartTime", "(F)V", "emojiPassDuration", "getEmojiPassDuration", "setEmojiPassDuration", "targetFrameCount", "", "getTargetFrameCount", "()I", "setTargetFrameCount", "(I)V", "targetFrameDuration", "getTargetFrameDuration", "setTargetFrameDuration", "targetFrameRate", "getTargetFrameRate", "setTargetFrameRate", "targetPassDuration", "getTargetPassDuration", "setTargetPassDuration", "targetPassFrame", "getTargetPassFrame", "setTargetPassFrame", "videoDuration", "getVideoDuration", "setVideoDuration", "videoFrameCount", "getVideoFrameCount", "setVideoFrameCount", "videoFrameDuration", "getVideoFrameDuration", "setVideoFrameDuration", "videoFrameFps", "getVideoFrameFps", "setVideoFrameFps", "videoPassDuration", "getVideoPassDuration", "setVideoPassDuration", "videoPassFrame", "getVideoPassFrame", "setVideoPassFrame", "frameDuration", "needSkipFrame", "", "syncMixNextFrame", "Lcom/tencent/mm/media/mix/MixFrameSyncMgr$NextFrameInfo;", "framePass", "NextFrameInfo", "plugin-mediaeditor_release"})
public class f
{
  public final String TAG;
  public int gSA;
  private float gSB;
  public Bitmap gSC;
  public float gSD;
  protected int gSE;
  public int gSF;
  protected int gSG;
  public float gSH;
  public float gSI;
  public float gSJ;
  public float gSK;
  public final d gSL;
  protected int gSy;
  protected int gSz;
  protected int videoDuration;
  
  public f(String paramString, d paramd)
  {
    AppMethodBeat.i(93726);
    this.gSL = paramd;
    this.TAG = "MicroMsg.MixFrameSyncMgr";
    this.gSB = -1.0F;
    paramString = e.asx(paramString);
    if ((paramString instanceof a))
    {
      this.gSz = paramString.frameRate;
      this.videoDuration = paramString.videoDuration;
      this.gSH = (1000.0F / paramString.frameRate);
      this.gSy = ((int)(this.gSz * (this.videoDuration / 1000.0D)));
    }
    for (;;)
    {
      this.gSG = this.gSz;
      this.gSJ = this.gSH;
      this.gSE = this.gSy;
      this.gSF = 0;
      AppMethodBeat.o(93726);
      return;
      this.gSy = 0;
      this.gSz = 0;
      this.gSH = 0.0F;
      this.videoDuration = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.g.f
 * JD-Core Version:    0.7.0.1
 */