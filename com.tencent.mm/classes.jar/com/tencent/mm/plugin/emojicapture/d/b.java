package com.tencent.mm.plugin.emojicapture.d;

import com.tencent.luggage.j.c;
import com.tencent.mm.compatible.util.k;

public class b
{
  public static boolean jkg = false;
  
  static
  {
    aJY();
  }
  
  public static void aJY()
  {
    System.currentTimeMillis();
    if (!jkg) {}
    try
    {
      k.b("image_filter_common", b.class.getClassLoader());
      k.b("image_filter_gpu", b.class.getClassLoader());
      k.b("algo_rithm_jni", b.class.getClassLoader());
      k.b("format_convert", b.class.getClassLoader());
      k.b("ParticleSystem", b.class.getClassLoader());
      k.b("YTCommon", b.class.getClassLoader());
      k.b("YTIllumination", b.class.getClassLoader());
      k.b("YTFaceTrackPro", b.class.getClassLoader());
      k.b("algo_youtu_jni", b.class.getClassLoader());
      jkg = true;
      return;
    }
    catch (Exception localException)
    {
      jkg = false;
      c.printErrStackTrace("MicroMsg.Emoji.FilterUtils", localException, "", new Object[0]);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label106:
      break label106;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.d.b
 * JD-Core Version:    0.7.0.1
 */