package com.tencent.mm.plugin.emojicapture.c;

import com.tencent.mm.plugin.emojicapture.ui.capture.CaptureDecoration;
import com.tencent.mm.sticker.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;", "", "changeSticker", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "getDecoration", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureDecoration;", "onDestroy", "onPause", "onResume", "startRecord", "stopRecord", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "Lkotlin/ParameterName;", "name", "capture", "switchCamera", "toggleFlipCamera", "show", "toggleVoiceDetect", "useBackGroundCamera", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a$b
{
  public abstract void a(f paramf);
  
  public abstract CaptureDecoration getDecoration();
  
  public abstract void on(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.c.a.b
 * JD-Core Version:    0.7.0.1
 */