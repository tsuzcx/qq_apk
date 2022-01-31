package com.tencent.mm.media.f;

import a.l;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/mix/MixFrameSyncMgr;", "", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/media/mix/FrameRetriever;", "(Ljava/lang/String;Lcom/tencent/mm/media/mix/FrameRetriever;)V", "TAG", "currentEmojiFrame", "Landroid/graphics/Bitmap;", "getCurrentEmojiFrame", "()Landroid/graphics/Bitmap;", "setCurrentEmojiFrame", "(Landroid/graphics/Bitmap;)V", "currentEmojiFrameDuration", "", "getCurrentEmojiFrameDuration", "()J", "setCurrentEmojiFrameDuration", "(J)V", "currentEmojiFrameStartTime", "", "getCurrentEmojiFrameStartTime", "()F", "setCurrentEmojiFrameStartTime", "(F)V", "emojiPassDuration", "getEmojiPassDuration", "setEmojiPassDuration", "targetFrameCount", "", "getTargetFrameCount", "()I", "setTargetFrameCount", "(I)V", "targetFrameDuration", "getTargetFrameDuration", "setTargetFrameDuration", "targetFrameRate", "getTargetFrameRate", "setTargetFrameRate", "targetPassDuration", "getTargetPassDuration", "setTargetPassDuration", "targetPassFrame", "getTargetPassFrame", "setTargetPassFrame", "videoDuration", "getVideoDuration", "setVideoDuration", "videoFrameCount", "getVideoFrameCount", "setVideoFrameCount", "videoFrameDuration", "getVideoFrameDuration", "setVideoFrameDuration", "videoFrameFps", "getVideoFrameFps", "setVideoFrameFps", "videoPassDuration", "getVideoPassDuration", "setVideoPassDuration", "videoPassFrame", "getVideoPassFrame", "setVideoPassFrame", "frameDuration", "needSkipFrame", "", "syncMixNextFrame", "Lcom/tencent/mm/media/mix/MixFrameSyncMgr$NextFrameInfo;", "framePass", "NextFrameInfo", "plugin-mediaeditor_release"})
public class e
{
  public final String TAG;
  protected int eVA;
  public int eVB;
  private float eVC;
  public Bitmap eVD;
  public float eVE;
  protected int eVF;
  public int eVG;
  protected int eVH;
  public float eVI;
  public float eVJ;
  public float eVK;
  public float eVL;
  public final d eVM;
  protected int eVy;
  protected int eVz;
  
  public e(String paramString, d paramd)
  {
    AppMethodBeat.i(12999);
    this.eVM = paramd;
    this.TAG = "MicroMsg.MixFrameSyncMgr";
    this.eVC = -1.0F;
    paramString = com.tencent.mm.plugin.sight.base.d.Zo(paramString);
    if ((paramString instanceof a))
    {
      this.eVz = paramString.eRw;
      this.eVA = paramString.eVA;
      this.eVI = (1000.0F / paramString.eRw);
      this.eVy = ((int)(this.eVz * (this.eVA / 1000.0D)));
    }
    for (;;)
    {
      this.eVH = this.eVz;
      this.eVK = this.eVI;
      this.eVF = this.eVy;
      this.eVG = 0;
      AppMethodBeat.o(12999);
      return;
      this.eVy = 0;
      this.eVz = 0;
      this.eVI = 0.0F;
      this.eVA = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.f.e
 * JD-Core Version:    0.7.0.1
 */