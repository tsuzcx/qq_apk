package com.tencent.mm.plugin.appbrand.jsapi.address;

import android.content.Context;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/address/AddressSelectorContract;", "Lcom/tencent/mm/kernel/service/IService;", "startSelector", "", "context", "Landroid/content/Context;", "request", "Lcom/tencent/mm/plugin/appbrand/jsapi/address/AddressSelectorContract$SelectRequest;", "onSelect", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsapi/address/AddressSelectorContract$SelectResponse;", "onCancel", "Lkotlin/Function0;", "AddressNode", "Mode", "SelectRequest", "SelectResponse", "plugin-select-address-contract_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface AddressSelectorContract
  extends com.tencent.mm.kernel.c.a
{
  public abstract void a(Context paramContext, AddressSelectorContract.SelectRequest paramSelectRequest, b<? super AddressSelectorContract.SelectResponse, ah> paramb, kotlin.g.a.a<ah> parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.address.AddressSelectorContract
 * JD-Core Version:    0.7.0.1
 */