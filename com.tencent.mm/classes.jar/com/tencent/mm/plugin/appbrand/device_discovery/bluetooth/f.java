package com.tencent.mm.plugin.appbrand.device_discovery.bluetooth;

import com.tencent.luggage.l.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eul;
import com.tencent.mm.protocal.protobuf.hu;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.aa;
import kotlin.g.b.ai;
import kotlin.g.b.u;
import kotlin.g.b.z;
import kotlin.j;
import kotlin.k;
import kotlin.l.o;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/BluetoothScopeTestLogic;", "", "()V", "<set-?>", "", "ENABLE", "getENABLE", "()Z", "setENABLE", "(Z)V", "ENABLE$delegate", "Lcom/tencent/luggage/util/LuggageMMKVProperty;", "applyWording", "", "bluetoothAuthItem", "Lcom/tencent/mm/protocal/protobuf/AuthItem;", "getBluetoothAuthItem", "()Lcom/tencent/mm/protocal/protobuf/AuthItem;", "bluetoothAuthItem$delegate", "Lkotlin/Lazy;", "bluetoothScopeInfo", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "getBluetoothScopeInfo", "()Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "bluetoothScopeInfo$delegate", "provideBluetoothFgScopeForAuthorize", "", "response", "Lcom/tencent/mm/protocal/protobuf/JSAuthorizeResponse;", "provideBluetoothFgScopeForAuthorizeUI", "authItemList", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f rgV;
  public static final g rgW;
  public static final String rgX;
  private static final j rgY;
  private static final j rgZ;
  
  static
  {
    AppMethodBeat.i(321608);
    aYe = new o[] { (o)ai.a((z)new aa(f.class, "ENABLE", "getENABLE()Z", 0)) };
    rgV = new f();
    rgW = new g(Boolean.FALSE);
    rgX = "申请";
    rgY = k.cm((a)b.rhb);
    rgZ = k.cm((a)a.rha);
    AppMethodBeat.o(321608);
  }
  
  public static eul cmN()
  {
    AppMethodBeat.i(321595);
    eul localeul = (eul)rgY.getValue();
    AppMethodBeat.o(321595);
    return localeul;
  }
  
  public static hu cmO()
  {
    AppMethodBeat.i(321600);
    hu localhu = (hu)rgZ.getValue();
    AppMethodBeat.o(321600);
    return localhu;
  }
  
  public final boolean cmM()
  {
    AppMethodBeat.i(321613);
    boolean bool = ((Boolean)rgW.a(this, aYe[0])).booleanValue();
    AppMethodBeat.o(321613);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/AuthItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<hu>
  {
    public static final a rha;
    
    static
    {
      AppMethodBeat.i(321771);
      rha = new a();
      AppMethodBeat.o(321771);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<eul>
  {
    public static final b rhb;
    
    static
    {
      AppMethodBeat.i(321754);
      rhb = new b();
      AppMethodBeat.o(321754);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.f
 * JD-Core Version:    0.7.0.1
 */