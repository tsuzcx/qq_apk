package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ay;

public final class e
{
  private static long qxr = -1L;
  private static long qxs = -1L;
  private static float qxt = -1.0F;
  
  public static boolean cnm()
  {
    AppMethodBeat.i(103713);
    boolean bool = Boolean.parseBoolean(ay.hnA.aw("last_login_face_use_debug_mode", "false"));
    AppMethodBeat.o(103713);
    return bool;
  }
  
  public static boolean cnn()
  {
    AppMethodBeat.i(103714);
    boolean bool = Boolean.parseBoolean(ay.hnA.aw("last_login_face_is_force_upload_face", "false"));
    AppMethodBeat.o(103714);
    return bool;
  }
  
  public static boolean cno()
  {
    AppMethodBeat.i(103715);
    boolean bool = Boolean.parseBoolean(ay.hnA.aw("last_login_face_save_correct_debug_mode", "false"));
    AppMethodBeat.o(103715);
    return bool;
  }
  
  public static boolean cnp()
  {
    AppMethodBeat.i(103716);
    boolean bool = Boolean.parseBoolean(ay.hnA.aw("last_login_face_save_final_debug_mode", "false"));
    AppMethodBeat.o(103716);
    return bool;
  }
  
  public static boolean cnq()
  {
    AppMethodBeat.i(103717);
    boolean bool = Boolean.parseBoolean(ay.hnA.aw("last_login_face_save_lip_reading", "false"));
    AppMethodBeat.o(103717);
    return bool;
  }
  
  public static boolean cnr()
  {
    AppMethodBeat.i(103718);
    boolean bool = Boolean.parseBoolean(ay.hnA.aw("last_login_face_save_final_voice", "false"));
    AppMethodBeat.o(103718);
    return bool;
  }
  
  public static void kS(boolean paramBoolean)
  {
    AppMethodBeat.i(103719);
    ay.hnA.aL("last_login_face_use_debug_mode", String.valueOf(paramBoolean));
    AppMethodBeat.o(103719);
  }
  
  public static void kT(boolean paramBoolean)
  {
    AppMethodBeat.i(103720);
    ay.hnA.aL("last_login_face_save_correct_debug_mode", String.valueOf(paramBoolean));
    AppMethodBeat.o(103720);
  }
  
  public static void kU(boolean paramBoolean)
  {
    AppMethodBeat.i(103721);
    ay.hnA.aL("last_login_face_save_final_debug_mode", String.valueOf(paramBoolean));
    AppMethodBeat.o(103721);
  }
  
  public static void kV(boolean paramBoolean)
  {
    AppMethodBeat.i(103722);
    ay.hnA.aL("last_login_face_save_lip_reading", String.valueOf(paramBoolean));
    AppMethodBeat.o(103722);
  }
  
  public static void kW(boolean paramBoolean)
  {
    AppMethodBeat.i(103723);
    ay.hnA.aL("last_login_face_save_final_voice", String.valueOf(paramBoolean));
    AppMethodBeat.o(103723);
  }
  
  public static void kX(boolean paramBoolean)
  {
    AppMethodBeat.i(103724);
    ay.hnA.aL("last_login_face_is_force_upload_face", String.valueOf(paramBoolean));
    AppMethodBeat.o(103724);
  }
  
  public static void to(long paramLong)
  {
    qxr = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.e
 * JD-Core Version:    0.7.0.1
 */