package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.model.at;

public final class e
{
  private static long jNJ = -1L;
  private static long jNK = -1L;
  private static float jNL = -1.0F;
  
  public static boolean aOi()
  {
    return Boolean.parseBoolean(at.dVC.L("last_login_face_use_debug_mode", "false"));
  }
  
  public static boolean aOj()
  {
    return Boolean.parseBoolean(at.dVC.L("last_login_face_is_force_upload_face", "false"));
  }
  
  public static boolean aOk()
  {
    return Boolean.parseBoolean(at.dVC.L("last_login_face_save_correct_debug_mode", "false"));
  }
  
  public static boolean aOl()
  {
    return Boolean.parseBoolean(at.dVC.L("last_login_face_save_final_debug_mode", "false"));
  }
  
  public static boolean aOm()
  {
    return Boolean.parseBoolean(at.dVC.L("last_login_face_save_lip_reading", "false"));
  }
  
  public static boolean aOn()
  {
    return Boolean.parseBoolean(at.dVC.L("last_login_face_save_final_voice", "false"));
  }
  
  public static void el(long paramLong)
  {
    jNJ = paramLong;
  }
  
  public static void fI(boolean paramBoolean)
  {
    at.dVC.Y("last_login_face_use_debug_mode", String.valueOf(paramBoolean));
  }
  
  public static void fJ(boolean paramBoolean)
  {
    at.dVC.Y("last_login_face_save_correct_debug_mode", String.valueOf(paramBoolean));
  }
  
  public static void fK(boolean paramBoolean)
  {
    at.dVC.Y("last_login_face_save_final_debug_mode", String.valueOf(paramBoolean));
  }
  
  public static void fL(boolean paramBoolean)
  {
    at.dVC.Y("last_login_face_save_lip_reading", String.valueOf(paramBoolean));
  }
  
  public static void fM(boolean paramBoolean)
  {
    at.dVC.Y("last_login_face_save_final_voice", String.valueOf(paramBoolean));
  }
  
  public static void fN(boolean paramBoolean)
  {
    at.dVC.Y("last_login_face_is_force_upload_face", String.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.e
 * JD-Core Version:    0.7.0.1
 */