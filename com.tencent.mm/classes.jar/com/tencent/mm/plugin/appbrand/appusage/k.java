package com.tencent.mm.plugin.appbrand.appusage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bt;

public final class k
  extends j<b>
{
  public static final String[] hEf;
  public final e jHa;
  
  static
  {
    AppMethodBeat.i(44488);
    hEf = new String[] { j.getCreateSQLs(b.hEe, "AppBrandAppLaunchUsernameDuplicateRecord2") };
    AppMethodBeat.o(44488);
  }
  
  public k(e parame)
  {
    super(parame, b.hEe, "AppBrandAppLaunchUsernameDuplicateRecord2", b.INDEX_CREATE);
    this.jHa = parame;
  }
  
  public final b MD(String paramString)
  {
    AppMethodBeat.i(188029);
    b localb = new b();
    localb.field_usernameHash = paramString.hashCode();
    if ((!get(localb, new String[] { "usernameHash" })) || (localb.field_username == null) || (!localb.field_username.equals(paramString)))
    {
      AppMethodBeat.o(188029);
      return null;
    }
    AppMethodBeat.o(188029);
    return localb;
  }
  
  public final boolean ME(String paramString)
  {
    AppMethodBeat.i(188030);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(188030);
      return false;
    }
    paramString = MD(paramString);
    if ((paramString != null) && (paramString.field_updateTime > 0L))
    {
      AppMethodBeat.o(188030);
      return true;
    }
    AppMethodBeat.o(188030);
    return false;
  }
  
  public final boolean MF(String paramString)
  {
    AppMethodBeat.i(188031);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(188031);
      return false;
    }
    b localb = new b();
    localb.field_username = paramString;
    localb.field_usernameHash = paramString.hashCode();
    boolean bool = super.delete(localb, new String[] { "usernameHash" });
    AppMethodBeat.o(188031);
    return bool;
  }
  
  public final boolean P(String paramString, long paramLong)
  {
    AppMethodBeat.i(44487);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44487);
      return false;
    }
    b localb = new b();
    localb.field_usernameHash = paramString.hashCode();
    localb.field_username = paramString;
    boolean bool = get(localb, new String[0]);
    localb.field_updateTime = paramLong;
    if (bool)
    {
      bool = update(localb, new String[0]);
      AppMethodBeat.o(44487);
      return bool;
    }
    bool = insert(localb);
    AppMethodBeat.o(44487);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.k
 * JD-Core Version:    0.7.0.1
 */