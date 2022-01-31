package com.tencent.mm.plugin.facedetect.service;

import android.os.Bundle;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.plugin.facedetect.model.o;

final class FaceDetectProcessService$1$1
  implements Runnable
{
  FaceDetectProcessService$1$1(FaceDetectProcessService.1 param1, FaceProNative.FaceResult paramFaceResult) {}
  
  public final void run()
  {
    String str = o.a(this.jPT);
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_face_result_code", 0);
    localBundle.putString("key_face_result_file_path", str);
    FaceDetectProcessService.a(this.jPU.jPS, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService.1.1
 * JD-Core Version:    0.7.0.1
 */