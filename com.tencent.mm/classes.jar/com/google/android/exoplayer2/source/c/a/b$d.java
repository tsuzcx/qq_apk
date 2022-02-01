package com.google.android.exoplayer2.source.c.a;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.d;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

final class b$d
  extends b.a
{
  private Format aSv;
  
  public b$d(b.a parama, String paramString)
  {
    super(parama, paramString, "QualityLevel");
  }
  
  private static List<byte[]> av(String paramString)
  {
    AppMethodBeat.i(89992);
    ArrayList localArrayList = new ArrayList();
    byte[][] arrayOfByte;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = x.aZ(paramString);
      arrayOfByte = d.w(paramString);
      if (arrayOfByte != null) {
        break label47;
      }
      localArrayList.add(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(89992);
      return localArrayList;
      label47:
      Collections.addAll(localArrayList, arrayOfByte);
    }
  }
  
  public final Object build()
  {
    return this.aSv;
  }
  
  public final void i(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(89991);
    int j = ((Integer)at("Type")).intValue();
    String str = paramXmlPullParser.getAttributeValue(null, "Index");
    int i = f(paramXmlPullParser, "Bitrate");
    Object localObject1 = d(paramXmlPullParser, "FourCC");
    if ((((String)localObject1).equalsIgnoreCase("H264")) || (((String)localObject1).equalsIgnoreCase("X264")) || (((String)localObject1).equalsIgnoreCase("AVC1")) || (((String)localObject1).equalsIgnoreCase("DAVC"))) {
      localObject1 = "video/avc";
    }
    while (j == 2)
    {
      this.aSv = Format.a(str, "video/mp4", (String)localObject1, null, i, f(paramXmlPullParser, "MaxWidth"), f(paramXmlPullParser, "MaxHeight"), -1.0F, av(paramXmlPullParser.getAttributeValue(null, "CodecPrivateData")), 0);
      AppMethodBeat.o(89991);
      return;
      if ((((String)localObject1).equalsIgnoreCase("AAC")) || (((String)localObject1).equalsIgnoreCase("AACL")) || (((String)localObject1).equalsIgnoreCase("AACH")) || (((String)localObject1).equalsIgnoreCase("AACP"))) {
        localObject1 = "audio/mp4a-latm";
      } else if (((String)localObject1).equalsIgnoreCase("TTML")) {
        localObject1 = "application/ttml+xml";
      } else if ((((String)localObject1).equalsIgnoreCase("ac-3")) || (((String)localObject1).equalsIgnoreCase("dac3"))) {
        localObject1 = "audio/ac3";
      } else if ((((String)localObject1).equalsIgnoreCase("ec-3")) || (((String)localObject1).equalsIgnoreCase("dec3"))) {
        localObject1 = "audio/eac3";
      } else if (((String)localObject1).equalsIgnoreCase("dtsc")) {
        localObject1 = "audio/vnd.dts";
      } else if ((((String)localObject1).equalsIgnoreCase("dtsh")) || (((String)localObject1).equalsIgnoreCase("dtsl"))) {
        localObject1 = "audio/vnd.dts.hd";
      } else if (((String)localObject1).equalsIgnoreCase("dtse")) {
        localObject1 = "audio/vnd.dts.hd;profile=lbr";
      } else if (((String)localObject1).equalsIgnoreCase("opus")) {
        localObject1 = "audio/opus";
      } else {
        localObject1 = null;
      }
    }
    if (j == 1)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "audio/mp4a-latm";
      }
      j = f(paramXmlPullParser, "Channels");
      int k = f(paramXmlPullParser, "SamplingRate");
      localObject1 = av(paramXmlPullParser.getAttributeValue(null, "CodecPrivateData"));
      paramXmlPullParser = (XmlPullParser)localObject1;
      if (((List)localObject1).isEmpty())
      {
        paramXmlPullParser = (XmlPullParser)localObject1;
        if ("audio/mp4a-latm".equals(localObject2)) {
          paramXmlPullParser = Collections.singletonList(d.bo(k, j));
        }
      }
      this.aSv = Format.a(str, "audio/mp4", (String)localObject2, null, i, j, k, paramXmlPullParser, 0, (String)at("Language"));
      AppMethodBeat.o(89991);
      return;
    }
    if (j == 3)
    {
      this.aSv = Format.a(str, "application/mp4", (String)localObject1, i, 0, (String)at("Language"));
      AppMethodBeat.o(89991);
      return;
    }
    this.aSv = Format.a(str, "application/mp4", (String)localObject1, null, i, 0, null);
    AppMethodBeat.o(89991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.a.b.d
 * JD-Core Version:    0.7.0.1
 */