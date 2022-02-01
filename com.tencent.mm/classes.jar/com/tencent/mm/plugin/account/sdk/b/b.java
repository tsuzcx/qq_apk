package com.tencent.mm.plugin.account.sdk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/account/sdk/event/AccountPolicyAgreeEventObj;", "", "type", "Lcom/tencent/mm/plugin/account/sdk/event/AccountPolicyAgreeEventObj$ActionType;", "isAgree", "", "customInfo", "", "ticket", "policyList", "(Lcom/tencent/mm/plugin/account/sdk/event/AccountPolicyAgreeEventObj$ActionType;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCustomInfo", "()Ljava/lang/String;", "()I", "getPolicyList", "getTicket", "getType", "()Lcom/tencent/mm/plugin/account/sdk/event/AccountPolicyAgreeEventObj$ActionType;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "ActionType", "account-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public final String hFb;
  public final a pXd;
  public final int pXe;
  public final String pXf;
  public final String pXg;
  
  public b(a parama, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(304659);
    this.pXd = parama;
    this.pXe = paramInt;
    this.pXf = paramString1;
    this.hFb = paramString2;
    this.pXg = paramString3;
    AppMethodBeat.o(304659);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(304675);
    if (this == paramObject)
    {
      AppMethodBeat.o(304675);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(304675);
      return false;
    }
    paramObject = (b)paramObject;
    if (this.pXd != paramObject.pXd)
    {
      AppMethodBeat.o(304675);
      return false;
    }
    if (this.pXe != paramObject.pXe)
    {
      AppMethodBeat.o(304675);
      return false;
    }
    if (!s.p(this.pXf, paramObject.pXf))
    {
      AppMethodBeat.o(304675);
      return false;
    }
    if (!s.p(this.hFb, paramObject.hFb))
    {
      AppMethodBeat.o(304675);
      return false;
    }
    if (!s.p(this.pXg, paramObject.pXg))
    {
      AppMethodBeat.o(304675);
      return false;
    }
    AppMethodBeat.o(304675);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(304671);
    int i = this.pXd.hashCode();
    int j = this.pXe;
    int k = this.pXf.hashCode();
    int m = this.hFb.hashCode();
    int n = this.pXg.hashCode();
    AppMethodBeat.o(304671);
    return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(304665);
    String str = "AccountPolicyAgreeEventObj(type=" + this.pXd + ", isAgree=" + this.pXe + ", customInfo=" + this.pXf + ", ticket=" + this.hFb + ", policyList=" + this.pXg + ')';
    AppMethodBeat.o(304665);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/account/sdk/event/AccountPolicyAgreeEventObj$ActionType;", "", "(Ljava/lang/String;I)V", "JsApiAgree", "CgiEnd", "account-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(304672);
      pXh = new a("JsApiAgree", 0);
      pXi = new a("CgiEnd", 1);
      pXj = new a[] { pXh, pXi };
      AppMethodBeat.o(304672);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.sdk.b.b
 * JD-Core Version:    0.7.0.1
 */