package com.tencent.mm.plugin.appbrand.jsapi.address;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/address/AddressSelectorContract$Mode;", "", "size", "", "(Ljava/lang/String;II)V", "getSize", "()I", "PROVINCE", "CITY", "REGION", "DISTRICT", "Companion", "PARCELER", "plugin-select-address-contract_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum AddressSelectorContract$a
{
  public static final a rBO;
  final int size;
  
  static
  {
    AppMethodBeat.i(326503);
    rBP = new a("PROVINCE", 0, 1);
    rBQ = new a("CITY", 1, 2);
    rBR = new a("REGION", 2, 3);
    rBS = new a("DISTRICT", 3, 4);
    rBT = new a[] { rBP, rBQ, rBR, rBS };
    rBO = new a((byte)0);
    AppMethodBeat.o(326503);
  }
  
  private AddressSelectorContract$a(int paramInt)
  {
    this.size = paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/address/AddressSelectorContract$Mode$Companion;", "", "()V", "optFromJson", "Lcom/tencent/mm/plugin/appbrand/jsapi/address/AddressSelectorContract$Mode;", "data", "Lorg/json/JSONObject;", "plugin-select-address-contract_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.address.AddressSelectorContract.a
 * JD-Core Version:    0.7.0.1
 */