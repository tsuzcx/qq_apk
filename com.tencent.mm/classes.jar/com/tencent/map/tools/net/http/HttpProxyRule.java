package com.tencent.map.tools.net.http;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class HttpProxyRule
  extends JsonComposer
{
  @Json(name="domain")
  public String domain;
  @Json(name="proxy_domain")
  public String proxyDomain;
  
  public boolean match(String paramString)
  {
    AppMethodBeat.i(211008);
    if (paramString == null)
    {
      AppMethodBeat.o(211008);
      return false;
    }
    paramString = Uri.parse(paramString);
    String str = paramString.getScheme();
    if ((str == null) || (!str.startsWith("http")))
    {
      AppMethodBeat.o(211008);
      return false;
    }
    paramString = paramString.getHost();
    if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
    {
      boolean bool = paramString.matches(this.domain);
      AppMethodBeat.o(211008);
      return bool;
    }
    AppMethodBeat.o(211008);
    return false;
  }
  
  public String replaceHost(String paramString)
  {
    AppMethodBeat.i(211004);
    if (paramString == null)
    {
      AppMethodBeat.o(211004);
      return null;
    }
    Uri localUri = Uri.parse(paramString);
    String str = localUri.getScheme();
    if ((str == null) || (!str.startsWith("http")))
    {
      AppMethodBeat.o(211004);
      return paramString;
    }
    str = localUri.getHost();
    if ((str != null) && (!TextUtils.isEmpty(str)) && (str.matches(this.domain)))
    {
      paramString = localUri.buildUpon().encodedAuthority(this.proxyDomain).build().toString();
      AppMethodBeat.o(211004);
      return paramString;
    }
    AppMethodBeat.o(211004);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.tools.net.http.HttpProxyRule
 * JD-Core Version:    0.7.0.1
 */