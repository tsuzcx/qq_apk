package com.tencent.mm.plugin.appbrand.ui.privacy.revoke;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/UserInfoRevokeState;", "", "(Ljava/lang/String;I)V", "DOING", "SUCCESS", "FAILURE", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum k
{
  static
  {
    AppMethodBeat.i(322879);
    uku = new k("DOING", 0);
    ukv = new k("SUCCESS", 1);
    ukw = new k("FAILURE", 2);
    ukx = new k[] { uku, ukv, ukw };
    AppMethodBeat.o(322879);
  }
  
  private k() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.revoke.k
 * JD-Core Version:    0.7.0.1
 */