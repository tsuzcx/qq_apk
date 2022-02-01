package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Locale;

class GraphRequest$6
  implements GraphRequest.KeyValueSerializer
{
  GraphRequest$6(GraphRequest paramGraphRequest, ArrayList paramArrayList) {}
  
  public void writeString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(17081);
    this.val$keysAndValues.add(String.format(Locale.US, "%s=%s", new Object[] { paramString1, URLEncoder.encode(paramString2, "UTF-8") }));
    AppMethodBeat.o(17081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.GraphRequest.6
 * JD-Core Version:    0.7.0.1
 */