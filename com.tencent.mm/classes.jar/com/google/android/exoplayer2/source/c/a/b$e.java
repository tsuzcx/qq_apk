package com.google.android.exoplayer2.source.c.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

final class b$e
  extends b.a
{
  private long bdm;
  private int bjD;
  private boolean bqS;
  private final List<a.b> brA;
  private long brB;
  private int brn;
  private a.a bro;
  private long duration;
  private int minorVersion;
  
  public b$e(String paramString)
  {
    super(null, paramString, "SmoothStreamingMedia");
    AppMethodBeat.i(89993);
    this.brn = -1;
    this.bro = null;
    this.brA = new LinkedList();
    AppMethodBeat.o(89993);
  }
  
  public final void ac(Object paramObject)
  {
    AppMethodBeat.i(89995);
    if ((paramObject instanceof a.b))
    {
      this.brA.add((a.b)paramObject);
      AppMethodBeat.o(89995);
      return;
    }
    if ((paramObject instanceof a.a)) {
      if (this.bro != null) {
        break label66;
      }
    }
    label66:
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.bro = ((a.a)paramObject);
      AppMethodBeat.o(89995);
      return;
    }
  }
  
  public final Object build()
  {
    AppMethodBeat.i(89996);
    Object localObject1 = new a.b[this.brA.size()];
    this.brA.toArray((Object[])localObject1);
    if (this.bro != null)
    {
      DrmInitData localDrmInitData = new DrmInitData(new DrmInitData.SchemeData[] { new DrmInitData.SchemeData(this.bro.uuid, "video/mp4", this.bro.data) });
      int k = localObject1.length;
      int i = 0;
      while (i < k)
      {
        Object localObject2 = localObject1[i];
        int j = 0;
        while (j < localObject2.blC.length)
        {
          Format[] arrayOfFormat = localObject2.blC;
          arrayOfFormat[j] = arrayOfFormat[j].a(localDrmInitData);
          j += 1;
        }
        i += 1;
      }
    }
    localObject1 = new a(this.bjD, this.minorVersion, this.bdm, this.duration, this.brB, this.brn, this.bqS, this.bro, (a.b[])localObject1);
    AppMethodBeat.o(89996);
    return localObject1;
  }
  
  public final void i(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(89994);
    this.bjD = f(paramXmlPullParser, "MajorVersion");
    this.minorVersion = f(paramXmlPullParser, "MinorVersion");
    this.bdm = c(paramXmlPullParser, "TimeScale", 10000000L);
    this.duration = g(paramXmlPullParser, "Duration");
    this.brB = c(paramXmlPullParser, "DVRWindowLength", 0L);
    this.brn = e(paramXmlPullParser, "LookaheadCount");
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, "IsLive");
    if (paramXmlPullParser != null) {}
    for (boolean bool = Boolean.parseBoolean(paramXmlPullParser);; bool = false)
    {
      this.bqS = bool;
      c("TimeScale", Long.valueOf(this.bdm));
      AppMethodBeat.o(89994);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.a.b.e
 * JD-Core Version:    0.7.0.1
 */