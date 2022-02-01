package com.tencent.mm.plugin.flutter.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/voip/data/FlutterVoIPEnums$EventType;", "", "(Ljava/lang/String;I)V", "SelfNetworkWeak", "OtherNetworkWeak", "NetworkResume", "NetworkCostMax", "NetworkUseMobile", "RiskTip", "PhoneInUse", "plugin-flutter-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum a$f
{
  static
  {
    AppMethodBeat.i(263363);
    HmM = new f("SelfNetworkWeak", 0);
    HmN = new f("OtherNetworkWeak", 1);
    HmO = new f("NetworkResume", 2);
    HmP = new f("NetworkCostMax", 3);
    HmQ = new f("NetworkUseMobile", 4);
    HmR = new f("RiskTip", 5);
    HmS = new f("PhoneInUse", 6);
    HmT = new f[] { HmM, HmN, HmO, HmP, HmQ, HmR, HmS };
    AppMethodBeat.o(263363);
  }
  
  private a$f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.voip.b.a.f
 * JD-Core Version:    0.7.0.1
 */