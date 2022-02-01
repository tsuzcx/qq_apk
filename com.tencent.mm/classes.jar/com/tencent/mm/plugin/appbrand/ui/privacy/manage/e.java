package com.tencent.mm.plugin.appbrand.ui.privacy.manage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.gng;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/AuthorizeScopeInfo;", "", "authScope", "Lcom/tencent/mm/protocal/protobuf/WxaUserAuthScopeItem;", "isGranted", "", "(Lcom/tencent/mm/protocal/protobuf/WxaUserAuthScopeItem;Z)V", "getAuthScope", "()Lcom/tencent/mm/protocal/protobuf/WxaUserAuthScopeItem;", "()Z", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  final gng ujh;
  final boolean uji;
  
  public e(gng paramgng, boolean paramBoolean)
  {
    AppMethodBeat.i(322986);
    this.ujh = paramgng;
    this.uji = paramBoolean;
    AppMethodBeat.o(322986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.manage.e
 * JD-Core Version:    0.7.0.1
 */