package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.av;

public final class e
{
  private static long mhV = -1L;
  private static long mhW = -1L;
  private static float mhX = -1.0F;
  
  public static boolean bul()
  {
    AppMethodBeat.i(188);
    boolean bool = Boolean.parseBoolean(av.flM.Y("last_login_face_use_debug_mode", "false"));
    AppMethodBeat.o(188);
    return bool;
  }
  
  public static boolean bum()
  {
    AppMethodBeat.i(189);
    boolean bool = Boolean.parseBoolean(av.flM.Y("last_login_face_is_force_upload_face", "false"));
    AppMethodBeat.o(189);
    return bool;
  }
  
  public static boolean bun()
  {
    AppMethodBeat.i(190);
    boolean bool = Boolean.parseBoolean(av.flM.Y("last_login_face_save_correct_debug_mode", "false"));
    AppMethodBeat.o(190);
    return bool;
  }
  
  public static boolean buo()
  {
    AppMethodBeat.i(191);
    boolean bool = Boolean.parseBoolean(av.flM.Y("last_login_face_save_final_debug_mode", "false"));
    AppMethodBeat.o(191);
    return bool;
  }
  
  public static boolean bup()
  {
    AppMethodBeat.i(192);
    boolean bool = Boolean.parseBoolean(av.flM.Y("last_login_face_save_lip_reading", "false"));
    AppMethodBeat.o(192);
    return bool;
  }
  
  public static boolean buq()
  {
    AppMethodBeat.i(193);
    boolean bool = Boolean.parseBoolean(av.flM.Y("last_login_face_save_final_voice", "false"));
    AppMethodBeat.o(193);
    return bool;
  }
  
  public static void hl(boolean paramBoolean)
  {
    AppMethodBeat.i(194);
    av.flM.ao("last_login_face_use_debug_mode", String.valueOf(paramBoolean));
    AppMethodBeat.o(194);
  }
  
  public static void hm(boolean paramBoolean)
  {
    AppMethodBeat.i(195);
    av.flM.ao("last_login_face_save_correct_debug_mode", String.valueOf(paramBoolean));
    AppMethodBeat.o(195);
  }
  
  public static void hn(boolean paramBoolean)
  {
    AppMethodBeat.i(196);
    av.flM.ao("last_login_face_save_final_debug_mode", String.valueOf(paramBoolean));
    AppMethodBeat.o(196);
  }
  
  public static void ho(boolean paramBoolean)
  {
    AppMethodBeat.i(197);
    av.flM.ao("last_login_face_save_lip_reading", String.valueOf(paramBoolean));
    AppMethodBeat.o(197);
  }
  
  public static void hp(boolean paramBoolean)
  {
    AppMethodBeat.i(198);
    av.flM.ao("last_login_face_save_final_voice", String.valueOf(paramBoolean));
    AppMethodBeat.o(198);
  }
  
  public static void hq(boolean paramBoolean)
  {
    AppMethodBeat.i(199);
    av.flM.ao("last_login_face_is_force_upload_face", String.valueOf(paramBoolean));
    AppMethodBeat.o(199);
  }
  
  public static void jI(long paramLong)
  {
    mhV = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.e
 * JD-Core Version:    0.7.0.1
 */