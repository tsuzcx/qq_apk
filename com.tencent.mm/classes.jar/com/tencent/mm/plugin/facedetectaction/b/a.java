package com.tencent.mm.plugin.facedetectaction.b;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame;

public final class a
{
  public int kKx;
  public Camera mCamera;
  public Context mContext;
  public int mDesiredPreviewHeight;
  public int mDesiredPreviewWidth;
  public int rxn;
  public String rxo;
  public FaceActionUI rxp;
  public TextView rxq;
  public a rxr;
  public Rect rxs;
  public Rect rxt;
  public YTPoseDetectInterface.PoseDetectOnFrame rxu;
  public boolean rxv = false;
  
  public static abstract interface a {}
  
  public static final class b
  {
    private static a rxx;
    
    static
    {
      AppMethodBeat.i(104203);
      rxx = new a((byte)0);
      AppMethodBeat.o(104203);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.a
 * JD-Core Version:    0.7.0.1
 */