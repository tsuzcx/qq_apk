package com.google.android.exoplayer2.source.c.a;

import android.net.Uri;
import com.google.android.exoplayer2.h.v.a;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class b
  implements v.a<a>
{
  private final XmlPullParserFactory boa;
  
  public b()
  {
    AppMethodBeat.i(90002);
    try
    {
      this.boa = XmlPullParserFactory.newInstance();
      AppMethodBeat.o(90002);
      return;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      RuntimeException localRuntimeException = new RuntimeException("Couldn't create XmlPullParserFactory instance", localXmlPullParserException);
      AppMethodBeat.o(90002);
      throw localRuntimeException;
    }
  }
  
  private a d(Uri paramUri, InputStream paramInputStream)
  {
    AppMethodBeat.i(90003);
    try
    {
      XmlPullParser localXmlPullParser = this.boa.newPullParser();
      localXmlPullParser.setInput(paramInputStream, null);
      paramUri = (a)new b.e(paramUri.toString()).h(localXmlPullParser);
      AppMethodBeat.o(90003);
      return paramUri;
    }
    catch (XmlPullParserException paramUri)
    {
      paramUri = new o(paramUri);
      AppMethodBeat.o(90003);
      throw paramUri;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.a.b
 * JD-Core Version:    0.7.0.1
 */