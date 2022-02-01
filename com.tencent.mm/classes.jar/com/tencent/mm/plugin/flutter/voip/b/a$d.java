package com.tencent.mm.plugin.flutter.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/voip/data/FlutterVoIPEnums$DialingStatus;", "", "(Ljava/lang/String;I)V", "Unknown", "Inviting", "Waiting", "Connecting", "Connected", "Finished", "Companion", "plugin-flutter-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum a$d
{
  public static final a Hmu;
  
  static
  {
    AppMethodBeat.i(263343);
    Hmv = new d("Unknown", 0);
    Hmw = new d("Inviting", 1);
    Hmx = new d("Waiting", 2);
    Hmy = new d("Connecting", 3);
    Hmz = new d("Connected", 4);
    HmA = new d("Finished", 5);
    HmB = new d[] { Hmv, Hmw, Hmx, Hmy, Hmz, HmA };
    Hmu = new a((byte)0);
    AppMethodBeat.o(263343);
  }
  
  private a$d() {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/voip/data/FlutterVoIPEnums$DialingStatus$Companion;", "", "()V", "from", "Lcom/tencent/mm/plugin/flutter/voip/data/FlutterVoIPEnums$DialingStatus;", "state", "", "plugin-flutter-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static a.d VP(int paramInt)
    {
      AppMethodBeat.i(263355);
      switch (paramInt)
      {
      default: 
        Log.e("MicroMsg.FlutterVoIPEnums", s.X("Not supported state: ", Integer.valueOf(paramInt)));
        locald = a.d.Hmv;
        AppMethodBeat.o(263355);
        return locald;
      case 0: 
      case 1: 
        locald = a.d.Hmw;
        AppMethodBeat.o(263355);
        return locald;
      case 2: 
      case 3: 
      case 256: 
      case 257: 
        locald = a.d.Hmx;
        AppMethodBeat.o(263355);
        return locald;
      case 4: 
      case 5: 
      case 258: 
      case 259: 
        locald = a.d.Hmy;
        AppMethodBeat.o(263355);
        return locald;
      case 6: 
      case 7: 
      case 260: 
      case 261: 
        locald = a.d.Hmz;
        AppMethodBeat.o(263355);
        return locald;
      }
      a.d locald = a.d.HmA;
      AppMethodBeat.o(263355);
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.voip.b.a.d
 * JD-Core Version:    0.7.0.1
 */