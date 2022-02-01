package com.tencent.mm.plugin.facedetectaction.b;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame;

public final class a
{
  public int lPd;
  public Camera mCamera;
  public Context mContext;
  public int mDesiredPreviewHeight;
  public int mDesiredPreviewWidth;
  public int sXk;
  public String sXl;
  public TextView sXm;
  public a sXn;
  public Rect sXo;
  public Rect sXp;
  public int sXq;
  public int sXr;
  public YTPoseDetectInterface.PoseDetectOnFrame sXs;
  public boolean sXt = false;
  
  public static abstract interface a {}
  
  public static final class b
  {
    private static a sXv;
    
    static
    {
      AppMethodBeat.i(104203);
      sXv = new a((byte)0);
      AppMethodBeat.o(104203);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.a
 * JD-Core Version:    0.7.0.1
 */