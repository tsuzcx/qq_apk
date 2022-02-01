package com.tencent.mm.plugin.flutter.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/voip/data/FlutterVoIPEnums$AudioDevice;", "", "(Ljava/lang/String;I)V", "Speaker", "Earpiece", "Headset", "Bluetooth", "Companion", "plugin-flutter-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum a$a
{
  public static final a Hmf;
  
  static
  {
    AppMethodBeat.i(263350);
    Hmg = new a("Speaker", 0);
    Hmh = new a("Earpiece", 1);
    Hmi = new a("Headset", 2);
    Hmj = new a("Bluetooth", 3);
    Hmk = new a[] { Hmg, Hmh, Hmi, Hmj };
    Hmf = new a((byte)0);
    AppMethodBeat.o(263350);
  }
  
  private a$a() {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/voip/data/FlutterVoIPEnums$AudioDevice$Companion;", "", "()V", "from", "Lcom/tencent/mm/plugin/flutter/voip/data/FlutterVoIPEnums$AudioDevice;", "device", "", "plugin-flutter-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static a.a VO(int paramInt)
    {
      switch (paramInt)
      {
      case 2: 
      default: 
        return a.a.Hmh;
      case 1: 
        return a.a.Hmg;
      case 3: 
        return a.a.Hmi;
      }
      return a.a.Hmj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.voip.b.a.a
 * JD-Core Version:    0.7.0.1
 */