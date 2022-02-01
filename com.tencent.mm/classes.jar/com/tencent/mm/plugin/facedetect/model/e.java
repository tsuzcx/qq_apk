package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bb;

public final class e
{
  private static long rpl = -1L;
  private static long rpm = -1L;
  private static float rpn = -1.0F;
  
  public static boolean cus()
  {
    AppMethodBeat.i(103713);
    boolean bool = Boolean.parseBoolean(bb.hIK.ay("last_login_face_use_debug_mode", "false"));
    AppMethodBeat.o(103713);
    return bool;
  }
  
  public static boolean cut()
  {
    AppMethodBeat.i(103714);
    boolean bool = Boolean.parseBoolean(bb.hIK.ay("last_login_face_is_force_upload_face", "false"));
    AppMethodBeat.o(103714);
    return bool;
  }
  
  public static boolean cuu()
  {
    AppMethodBeat.i(103715);
    boolean bool = Boolean.parseBoolean(bb.hIK.ay("last_login_face_save_correct_debug_mode", "false"));
    AppMethodBeat.o(103715);
    return bool;
  }
  
  public static boolean cuv()
  {
    AppMethodBeat.i(103716);
    boolean bool = Boolean.parseBoolean(bb.hIK.ay("last_login_face_save_final_debug_mode", "false"));
    AppMethodBeat.o(103716);
    return bool;
  }
  
  public static boolean cuw()
  {
    AppMethodBeat.i(103717);
    boolean bool = Boolean.parseBoolean(bb.hIK.ay("last_login_face_save_lip_reading", "false"));
    AppMethodBeat.o(103717);
    return bool;
  }
  
  public static boolean cux()
  {
    AppMethodBeat.i(103718);
    boolean bool = Boolean.parseBoolean(bb.hIK.ay("last_login_face_save_final_voice", "false"));
    AppMethodBeat.o(103718);
    return bool;
  }
  
  public static void ll(boolean paramBoolean)
  {
    AppMethodBeat.i(103719);
    bb.hIK.aM("last_login_face_use_debug_mode", String.valueOf(paramBoolean));
    AppMethodBeat.o(103719);
  }
  
  public static void lm(boolean paramBoolean)
  {
    AppMethodBeat.i(103720);
    bb.hIK.aM("last_login_face_save_correct_debug_mode", String.valueOf(paramBoolean));
    AppMethodBeat.o(103720);
  }
  
  public static void ln(boolean paramBoolean)
  {
    AppMethodBeat.i(103721);
    bb.hIK.aM("last_login_face_save_final_debug_mode", String.valueOf(paramBoolean));
    AppMethodBeat.o(103721);
  }
  
  public static void lo(boolean paramBoolean)
  {
    AppMethodBeat.i(103722);
    bb.hIK.aM("last_login_face_save_lip_reading", String.valueOf(paramBoolean));
    AppMethodBeat.o(103722);
  }
  
  public static void lp(boolean paramBoolean)
  {
    AppMethodBeat.i(103723);
    bb.hIK.aM("last_login_face_save_final_voice", String.valueOf(paramBoolean));
    AppMethodBeat.o(103723);
  }
  
  public static void lq(boolean paramBoolean)
  {
    AppMethodBeat.i(103724);
    bb.hIK.aM("last_login_face_is_force_upload_face", String.valueOf(paramBoolean));
    AppMethodBeat.o(103724);
  }
  
  public static void vB(long paramLong)
  {
    rpl = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.e
 * JD-Core Version:    0.7.0.1
 */