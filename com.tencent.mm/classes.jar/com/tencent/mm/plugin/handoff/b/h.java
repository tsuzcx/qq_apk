package com.tencent.mm.plugin.handoff.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.xmlpull.v1.XmlPullParser;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/parser/HandOffURLParser;", "Lcom/tencent/mm/plugin/handoff/parser/HandOffParser;", "Lcom/tencent/mm/plugin/handoff/model/HandOffURL;", "()V", "newHandOff", "parseTag", "", "tag", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "api-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends f<HandOffURL>
{
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(266252);
    s.u(paramString, "tag");
    s.u(paramXmlPullParser, "parser");
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(266252);
      return;
      if (!paramString.equals("handofftype"))
      {
        AppMethodBeat.o(266252);
        return;
        if (paramString.equals("icon")) {
          break label196;
        }
        AppMethodBeat.o(266252);
        return;
        if (!paramString.equals("title"))
        {
          AppMethodBeat.o(266252);
          return;
          if (paramString.equals("url")) {
            break label174;
          }
          AppMethodBeat.o(266252);
        }
      }
      else
      {
        int i = g(paramXmlPullParser);
        ((HandOffURL)fJO()).setHandOffType(i);
        AppMethodBeat.o(266252);
        return;
      }
      paramString = f(paramXmlPullParser);
      ((HandOffURL)fJO()).setTitle(paramString);
      AppMethodBeat.o(266252);
      return;
      label174:
      paramString = f(paramXmlPullParser);
      ((HandOffURL)fJO()).setUrl(paramString);
      AppMethodBeat.o(266252);
      return;
      label196:
      paramString = f(paramXmlPullParser);
      ((HandOffURL)fJO()).setIcon(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.h
 * JD-Core Version:    0.7.0.1
 */