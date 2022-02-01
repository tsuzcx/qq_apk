package com.tencent.mm.plugin.flutter.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/voip/data/FlutterVoIPEnums$ErrorReason;", "", "(Ljava/lang/String;I)V", "Unknown", "VideoNotSupported", "VoIPNotEnabled", "InBlacklist", "UserBusy", "NotInContact", "ServerOverload", "NetworkError", "Companion", "plugin-flutter-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum a$e
{
  public static final a HmC;
  
  static
  {
    AppMethodBeat.i(263372);
    HmD = new e("Unknown", 0);
    HmE = new e("VideoNotSupported", 1);
    HmF = new e("VoIPNotEnabled", 2);
    HmG = new e("InBlacklist", 3);
    HmH = new e("UserBusy", 4);
    HmI = new e("NotInContact", 5);
    HmJ = new e("ServerOverload", 6);
    HmK = new e("NetworkError", 7);
    HmL = new e[] { HmD, HmE, HmF, HmG, HmH, HmI, HmJ, HmK };
    HmC = new a((byte)0);
    AppMethodBeat.o(263372);
  }
  
  private a$e() {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/voip/data/FlutterVoIPEnums$ErrorReason$Companion;", "", "()V", "from", "Lcom/tencent/mm/plugin/flutter/voip/data/FlutterVoIPEnums$ErrorReason;", "code", "", "plugin-flutter-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.voip.b.a.e
 * JD-Core Version:    0.7.0.1
 */