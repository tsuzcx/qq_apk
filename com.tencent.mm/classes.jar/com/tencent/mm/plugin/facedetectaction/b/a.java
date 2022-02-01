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
  public int kHi;
  public Camera mCamera;
  public Context mContext;
  public int mDesiredPreviewHeight;
  public int mDesiredPreviewWidth;
  public int rpj;
  public String rpk;
  public FaceActionUI rpl;
  public TextView rpm;
  public a rpn;
  public Rect rpo;
  public Rect rpp;
  public YTPoseDetectInterface.PoseDetectOnFrame rpq;
  public boolean rpr = false;
  
  public static abstract interface a {}
  
  public static final class b
  {
    private static a rpt;
    
    static
    {
      AppMethodBeat.i(104203);
      rpt = new a((byte)0);
      AppMethodBeat.o(104203);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.a
 * JD-Core Version:    0.7.0.1
 */