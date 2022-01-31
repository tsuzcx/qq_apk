package com.tencent.mm.plugin.facedetect.model;

import android.content.Context;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class h$a
{
  public String fuj;
  public long jNU;
  public long jNV;
  public boolean jNW;
  public long jNX;
  public String jNY;
  public boolean jNZ;
  public boolean jOa;
  public int type;
  
  public h$a(int paramInt, String paramString)
  {
    this.type = paramInt;
    this.jNY = paramString;
    switch (this.type)
    {
    default: 
      y.e("MicroMsg.FaceDetectProcessModel", "hy: unknown type");
      this.type = 100;
      return;
    case 0: 
      this.jNU = 30L;
      this.jNV = 7000L;
      this.fuj = ae.getContext().getString(a.i.soter_face_err_msg_ok);
      this.jNW = true;
      this.jNX = 2500L;
      this.jNZ = false;
      this.jOa = false;
      return;
    case 1: 
      this.jNU = 30L;
      this.jNV = 7000L;
      this.fuj = ae.getContext().getString(a.i.face_detect_hint_pose_left);
      this.jNW = false;
      this.jNX = -1L;
      this.jNZ = true;
      this.jOa = true;
      return;
    case 2: 
      this.jNU = 30L;
      this.jNV = 7000L;
      this.fuj = ae.getContext().getString(a.i.face_detect_hint_pose_right);
      this.jNW = false;
      this.jNX = -1L;
      this.jNZ = true;
      this.jOa = true;
      return;
    case 3: 
      this.jNU = 30L;
      this.jNV = 7000L;
      this.fuj = ae.getContext().getString(a.i.face_detect_hint_eye);
      this.jNW = true;
      this.jNX = -1L;
      this.jNZ = true;
      this.jOa = true;
      return;
    }
    this.jNU = 30L;
    this.jNV = 7000L;
    this.fuj = ae.getContext().getString(a.i.face_detect_hint_read_number);
    this.jNW = true;
    this.jNX = 1000L;
    this.jNZ = true;
    this.jOa = true;
  }
  
  public final String toString()
  {
    return "FaceProcessItem{type=" + this.type + ", frameTween=" + this.jNU + ", hintTween=" + this.jNV + ", hintStr='" + this.fuj + '\'' + ", isCheckFace=" + this.jNW + ", minSuccTime=" + this.jNX + ", actionData='" + this.jNY + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.h.a
 * JD-Core Version:    0.7.0.1
 */