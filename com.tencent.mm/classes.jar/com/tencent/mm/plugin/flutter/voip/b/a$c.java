package com.tencent.mm.plugin.flutter.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/voip/data/FlutterVoIPEnums$CompleteReason;", "", "(Ljava/lang/String;I)V", "InviteTimeout", "Canceled", "Rejected", "SelfHangup", "AnotherHangup", "Ignored", "PhoneComing", "Killed", "plugin-flutter-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum a$c
{
  static
  {
    AppMethodBeat.i(263348);
    Hml = new c("InviteTimeout", 0);
    Hmm = new c("Canceled", 1);
    Hmn = new c("Rejected", 2);
    Hmo = new c("SelfHangup", 3);
    Hmp = new c("AnotherHangup", 4);
    Hmq = new c("Ignored", 5);
    Hmr = new c("PhoneComing", 6);
    Hms = new c("Killed", 7);
    Hmt = new c[] { Hml, Hmm, Hmn, Hmo, Hmp, Hmq, Hmr, Hms };
    AppMethodBeat.o(263348);
  }
  
  private a$c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.voip.b.a.c
 * JD-Core Version:    0.7.0.1
 */